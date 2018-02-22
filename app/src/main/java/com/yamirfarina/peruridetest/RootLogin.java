package com.yamirfarina.peruridetest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yamir on 21/02/18.
 */

public class RootLogin extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.authentication_activity);


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragments_container, new FragmentInicioSesion(), FragmentInicioSesion.class.getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragments_container);
        if (!(f instanceof FragmentRegistro)) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragments_container, new FragmentInicioSesion(), FragmentInicioSesion.class.getSimpleName())
                    .commit();
        }else{
            super.onBackPressed();
        }
    }
}
