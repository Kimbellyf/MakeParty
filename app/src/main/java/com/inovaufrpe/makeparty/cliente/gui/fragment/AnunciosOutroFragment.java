package com.inovaufrpe.makeparty.cliente.gui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.inovaufrpe.makeparty.R;
import com.inovaufrpe.makeparty.cliente.gui.DetalhesAnuncioActivity;
import com.inovaufrpe.makeparty.cliente.gui.adapter.AnuncioAdapter;
import com.inovaufrpe.makeparty.fornecedor.dominio.Anuncio;
import com.inovaufrpe.makeparty.infra.MakePartyApplication;
import com.inovaufrpe.makeparty.usuario.servico.AnuncioService;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.fragment.BaseFragment;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.task.TaskListener;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.AndroidUtils;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.IOUtils;
import com.inovaufrpe.makeparty.utils.bibliotecalivroandroid.utils.SDCardUtils;
import com.squareup.otto.Subscribe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AnunciosOutroFragment extends BaseFragment {
    protected RecyclerView recyclerView;
    private int tipo;
    private List<Anuncio> anuncios;
    private SwipeRefreshLayout swipeLayout;
    private ActionMode actionMode;
    private Intent shareIntent;

    // Método para instanciar esse fragment pelo tipo.
    public static AnunciosOutroFragment newInstance(int tipo) {
        Bundle args = new Bundle();
        args.putInt("tipo", tipo);
        AnunciosOutroFragment f = new AnunciosOutroFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Lê o tipo dos argumentos.
            this.tipo = getArguments().getInt("tipo");
        }

        // Registra a classe para receber eventos.
        MakePartyApplication.getInstance().getBus().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Cancela o recebimento de eventos.
        MakePartyApplication.getInstance().getBus().unregister(this);
    }

    @Subscribe
    public void onBusAtualizarListaAnuncios(String refresh) {
        // Recebeu o evento, atualiza a lista.
        taskAnuncios(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anuncios_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
// Swipe to Refresh
        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        swipeLayout.setOnRefreshListener(OnRefreshListener());
        swipeLayout.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3);

        return view;
    }

    private SwipeRefreshLayout.OnRefreshListener OnRefreshListener() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Valida se existe conexão ao fazer o gesto Pull to Refresh
                if (AndroidUtils.isNetworkAvailable(getContext())) {
                    // Atualiza ao fazer o gesto Pull to Refresh
                    taskAnuncios(true);
                } else {
                    swipeLayout.setRefreshing(false);
                    snack(recyclerView, R.string.msg_error_conexao_indisponivel);
                }
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskAnuncios(false);
    }

    private void taskAnuncios(boolean pullToRefresh) {
        // Busca os carros: Dispara a Task
        startTask("anuncios", new GetAnunciosTask(pullToRefresh), pullToRefresh ? R.id.swipeToRefresh : R.id.progress);
    }

    private AnuncioAdapter.AnuncioOnClickListener onClickAnuncio() {
        return new AnuncioAdapter.AnuncioOnClickListener() {
            @Override
            public void onClickAnuncio(AnuncioAdapter.AnunciosViewHolder holder, int indexAnuncio) {
                Anuncio c = anuncios.get(indexAnuncio);
                if (actionMode == null) {
                    Intent intent = new Intent(getContext(), DetalhesAnuncioActivity.class);
                    //intent.putExtra("anuncio", c);
                    startActivity(intent);
                } else { // Se a CAB está ativada
                    // Seleciona o carro
                    c.selected = !c.selected;
                    // Atualiza o título com a quantidade de carros selecionados
                    updateActionModeTitle();
                    // Redesenha a lista
                    recyclerView.getAdapter().notifyDataSetChanged();
                }

            }

            @Override
            public void onLongClickAnuncio(AnuncioAdapter.AnunciosViewHolder holder, int indexAnuncio) {
                if (actionMode != null) {
                    return;
                }
                // Liga a action bar de contexto (CAB)
                actionMode = getAppCompatActivity().
                        startSupportActionMode(getActionModeCallback());
                Anuncio c = anuncios.get(indexAnuncio);
                c.selected = true; // Seleciona o carro
                // Solicita ao Android para desenhar a lista novamente
                recyclerView.getAdapter().notifyDataSetChanged();
                // Atualiza o título para mostrar a quantidade de carros selecionados
                updateActionModeTitle();
            }
        };
    }

    // Atualiza o título da action bar (CAB)
    private void updateActionModeTitle() {
        if (actionMode != null) {
            actionMode.setTitle("Selecione os carros.");
            actionMode.setSubtitle(null);
            List<Anuncio> selectedAnuncios = getSelectedAnuncios();
            if (selectedAnuncios.size() == 1) {
                actionMode.setSubtitle("1 carro selecionado");
            } else if (selectedAnuncios.size() > 1) {
                actionMode.setSubtitle(selectedAnuncios.size() + " carros selecionados");
            }
            updateShareIntent(selectedAnuncios);
        }
    }

    // Atualiza a share intent com os carros selecionados
    private void updateShareIntent(List<Anuncio> selectedAnuncios) {
        if (shareIntent != null) {
            // Texto com os carros
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Carros: " + selectedAnuncios);
        }
    }

    // Retorna a lista de carros selecionados
    private List<Anuncio> getSelectedAnuncios() {
        List<Anuncio> list = new ArrayList<Anuncio>();
        for (Anuncio c : anuncios) {
            if (c.selected) {
                list.add(c);
            }
        }
        return list;
    }

    private ActionMode.Callback getActionModeCallback() {
        return new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Infla o menu específico da action bar de contexto (CAB)
                MenuInflater inflater = getActivity().getMenuInflater();
                inflater.inflate(R.menu.menu_main, menu);
               // MenuItem shareItem = menu.findItem(R.id.action_share);
//                ShareActionProvider share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
//                shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.app_name));
//                shareIntent.setType("text/plain");
//                share.setShareIntent(shareIntent);

                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                List<Anuncio> selectedAnuncios = getSelectedAnuncios();
                /*if (item.getItemId() == R.id.action_remove) {
                    CarroDB db = new CarroDB(getContext());
                    try {
                        for (Anuncio c : selectedAnuncios) {
                            db.delete(c); // Deleta o carro do banco
                            carros.remove(c); // Remove da lista
                        }
                    } finally {
                        db.close();
                    }
                    snack(recyclerView, "Carros excluídos com sucesso.");

                } else if (item.getItemId() == R.id.action_share) {
                    // Dispara a tarefa para fazer download das fotos
                    startTask("compartilhar", new CompartilharTask(selectedAnuncios));

                }*/
                // Encerra o action mode
                mode.finish();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Limpa o estado
                actionMode = null;
                // Configura todos os carros para não selecionados
                for (Anuncio c : anuncios) {
                    c.selected = false;
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        };
    }

    // Task para buscar os carros
    private class GetAnunciosTask implements TaskListener<List<Anuncio>> {
        private boolean refresh;

        public GetAnunciosTask(boolean refresh) {
            this.refresh = refresh;
        }

        @Override
        public List<Anuncio> execute() throws Exception {
            // Busca os carros em background (Thread)
            return AnuncioService.getAnunciosByTipo("Festa");
            //return AnuncioService.getCarros(getContext(), tipo, refresh);
        }

        @Override
        public void updateView(List<Anuncio> anuncios) {
            if (anuncios != null) {
                // Salva a lista de carros no atributo da classe
                AnunciosOutroFragment.this.anuncios = anuncios;
                // Atualiza a view na UI Thread
                recyclerView.setAdapter(new AnuncioAdapter(getContext(), anuncios,  onClickAnuncio()));
            }
        }

        @Override
        public void onError(Exception e) {
            // Qualquer exceção lançada no método execute vai cair aqui.
            alert("Ocorreu algum erro ao buscar os dados.");
        }

        @Override
        public void onCancelled(String s) {
        }
    }

    // Task para fazer o download
    // Faça import da classe android.net.Uri;
    private class CompartilharTask implements TaskListener {
        private final List<Anuncio> selectedAnuncios;
        // Lista de arquivos para compartilhar
        ArrayList<Uri> imageUris = new ArrayList<Uri>();

        public CompartilharTask(List<Anuncio> selectedAnuncios) {
            this.selectedAnuncios = selectedAnuncios;
        }

        @Override
        public Object execute() throws Exception {
            if (selectedAnuncios != null) {
                for (Anuncio c : selectedAnuncios) {
                    // Faz o download da foto do carro para arquivo
                    //String url = c.urlFoto;
                    //String fileName = url.substring(url.lastIndexOf("/"));
                    // Cria o arquivo no SD card
                    //File file = SDCardUtils.getPrivateFile(getContext(), "carros", fileName);
                    //IOUtils.downloadToFile(c.urlFoto, file);
                    // Salva a Uri para compartilhar a foto
                    //imageUris.add(Uri.fromFile(file));
                }
            }
            return null;
        }

        @Override
        public void updateView(Object o) {
            // Cria a intent com a foto dos carros
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
            shareIntent.setType("image/*");
            // Cria o Intent Chooser com as opções
            startActivity(Intent.createChooser(shareIntent, "Enviar Carros"));
        }

        @Override
        public void onError(Exception e) {
            alert("Ocorreu algum erro ao compartilhar.");
        }

        @Override
        public void onCancelled(String s) {
        }
    }

}
