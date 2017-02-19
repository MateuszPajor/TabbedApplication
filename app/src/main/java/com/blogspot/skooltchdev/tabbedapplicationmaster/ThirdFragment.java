package com.blogspot.skooltchdev.tabbedapplicationmaster;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.third_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText ed_uah = (EditText) view.findViewById(R.id.ed_uah);

        Double num1 = 0.0;
        final String myStr = ed_uah.getText().toString();
        if (!myStr.isEmpty())
        {
            num1 = Double.parseDouble(myStr);
        }


        final EditText ed_pln = (EditText) view.findViewById(R.id.ed_pln);
        ed_pln.setFocusable(false);

        final Button bt_convert = (Button) view.findViewById(R.id.bt_convert);
        bt_convert.setVisibility(View.INVISIBLE);

        final Button btnClear = (Button) view.findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_uah.setText("");
                ed_pln.setText("");
            }
        });

        bt_convert.setVisibility(View.VISIBLE);

        bt_convert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                double uah;

                try {
                    uah = Double.valueOf(ed_uah.getText().toString().trim());
                } catch (NumberFormatException e) {
                    uah = 0; // your default value
                }
                //double uah = Double.valueOf( ed_uah.getText().toString().trim());

                double pln = uah * 0.15;

                ed_pln.setText(String.valueOf(pln));

            }
        });
    }


}
