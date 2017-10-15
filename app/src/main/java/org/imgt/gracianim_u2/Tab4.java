package org.imgt.gracianim_u2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Tab4 extends Fragment{

    private EditText entrada;
    private TextView salida;
    private TextView moneda;
    private Button bep;
    private Button bpe;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v =  inflater.inflate(R.layout.tab4, container, false);

        entrada = (EditText) v.findViewById(R.id.entrada);
        salida= (TextView)v.findViewById(R.id.salida);
        moneda= (TextView)v.findViewById(R.id.moneda);
        bep= (Button) v.findViewById(R.id.beuropesetas);



        bep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    convEuroPeseta(view);
                moneda.setText(R.string.ptas);
            }
        });

        bpe= (Button) v.findViewById(R.id.bpesetaseuro);
        bpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convPesetaEuro(view);
                moneda.setText(R.string.euros);
            }
        });
        return v;
        //return inflater.inflate(R.layout.tab4, container, false);
    }

    public void convEuroPeseta(View view){
        try {
            salida.setText(String.valueOf(Float.parseFloat(entrada.getText().toString()) * 166.386));
        }catch (NumberFormatException e) {
            salida.setText("0.0");
        }

    }

    public void convPesetaEuro(View view){
        try{
            salida.setText(String.valueOf(Float.parseFloat(entrada.getText().toString())/166.386));
        }catch (NumberFormatException e) {
            salida.setText("0.0");
        }

    }


}