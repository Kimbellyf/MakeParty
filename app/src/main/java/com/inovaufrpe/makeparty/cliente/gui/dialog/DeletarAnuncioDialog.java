package com.inovaufrpe.makeparty.cliente.gui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * Created by Ricardo Lecheta on 25/01/2015.
 */
public class DeletarAnuncioDialog extends DialogFragment {

    private Callback callback;

    public static void show(FragmentManager fm, Callback callback) {
        FragmentTransaction ft = fm.beginTransaction();
        Fragment prev = fm.findFragmentByTag("deletar_anuncio");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        DeletarAnuncioDialog frag = new DeletarAnuncioDialog();
        frag.callback = callback;
        frag.show(ft, "deletar_anuncio");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        if (callback != null) {
                            callback.deleteAnuncio();
                        }
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Deletar esse anuncio da sua lista de desejos?");
        builder.setPositiveButton("Sim", dialogClickListener);
        builder.setNegativeButton("Não", dialogClickListener);
        return builder.create();
    }

    public static interface Callback {
        public void deleteAnuncio();
    }
}