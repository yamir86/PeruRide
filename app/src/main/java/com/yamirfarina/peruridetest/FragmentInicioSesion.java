package com.yamirfarina.peruridetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yamir on 21/02/18.
 */

public class FragmentInicioSesion extends Fragment implements View.OnClickListener{

    String TAG=FragmentInicioSesion.class.getSimpleName();
    View rootView;
    TextInputEditText emailEditText;
    EditText passwordEditText;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_inicio_sesion, null);
        emailEditText=rootView.findViewById(R.id.emailEditText);
        passwordEditText=rootView.findViewById(R.id.passwordEditText);
        rootView.findViewById(R.id.btnIngresar).setOnClickListener(this);
        rootView.findViewById(R.id.btnRegistrarse).setOnClickListener(this);

        return rootView;
    }

    private boolean validarFormulario(){
        if (emailEditText.getText().toString().isEmpty()){
            emailEditText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_person_black_24px,0,R.drawable.error_login, 0);
            Toast.makeText(getActivity(), "Debe ingresar su email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (passwordEditText.getText().toString().isEmpty()){
            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_lock_idle_lock,0,R.drawable.error_login, 0);
            Toast.makeText(getActivity(), "Debe ingresar su password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIngresar:
                if (validarFormulario()){
                    startActivity(new Intent(getActivity().getApplicationContext(), MapsActivity.class));
                    getActivity().finish();
                }

                break;
            case R.id.btnRegistrarse:
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragments_container, new FragmentRegistro(), FragmentRegistro.class.getSimpleName())
                        .commit();
                break;
        }
    }
}
