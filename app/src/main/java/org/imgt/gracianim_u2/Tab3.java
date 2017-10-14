package org.imgt.gracianim_u2;

import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Tab3 extends Fragment{

    private EditText entrada;
    private TextView salida;
    private Button botonRojo;
    private Button boton0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v =  inflater.inflate(R.layout.tab3, container, false);
        //Trabaja aquí...... entre el View v y el return
        entrada = (EditText) v.findViewById(R.id.entrada);
        salida= (TextView)v.findViewById(R.id.salida);
        /***** VER ANEXO A DEL LIBRO, PÁG.528, PUNTO 5 ********/
        botonRojo= (Button) v.findViewById(R.id.botonRojo);
        botonRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sePulsa(view);
            }
        });

        boton0= (Button) v.findViewById(R.id.boton0);
        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sePulsa0(view);
            }
        });
        /******************************************************/
        return v;
        //return inflater.inflate(R.layout.tab3, container, false);
    }

    public void sePulsa(View view){
        salida.setText(String.valueOf(Float.parseFloat(entrada.getText().toString())*2.0));
    }

    public void sePulsa0(View view){
        entrada.setText(entrada.getText()+(String)view.getTag());
    }
}
