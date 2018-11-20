package com.inovaufrpe.makeparty.cliente.gui.dialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.inovaufrpe.makeparty.usuario.dominio.Usuario;

public class ItemAtualizandoPerfilDialog extends DialogFragment {
    //private Callback callback;
    //private Usuario usuario;
    //private TextView nome;

    //Interface para retornar o resultado
    public interface Callback{
        //void onPerfilModificado()
    }
    //Método utilitário para criar o dialog
    public static void show(FragmentManager fm, Callback callback){
        FragmentTransaction ft = fm.beginTransaction();
        Fragment prev = fm.findFragmentByTag("editar_usuario");
        if (prev !=null){
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        ItemAtualizandoPerfilDialog frag = new ItemAtualizandoPerfilDialog();
        //frag.callback = callback;
        Bundle args = new Bundle();
        //..............
    }

}
