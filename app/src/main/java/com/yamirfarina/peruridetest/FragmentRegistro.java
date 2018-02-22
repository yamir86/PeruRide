package com.yamirfarina.peruridetest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by yamir on 21/02/18.
 */

public class FragmentRegistro extends Fragment {

    String TAG=FragmentInicioSesion.class.getSimpleName();
    View rootView;
    Spinner districtsSpinner;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_registro, null);
        districtsSpinner=rootView.findViewById(R.id.districts_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.districts, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        districtsSpinner.setAdapter(adapter);

        return rootView;
    }

}
