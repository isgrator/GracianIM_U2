package org.imgt.gracianim_u2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;


public class Tab4 extends Fragment{

    private EditText entrada;
    private TextView salida,salida2;
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
        salida2= (TextView)v.findViewById(R.id.salida2);

        bep= (Button) v.findViewById(R.id.beuropesetas);
        bep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convEuroPeseta(view);
            }
        });

        bpe= (Button) v.findViewById(R.id.bpesetaseuro);
        bpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convPesetaEuro(view);
            }
        });

        /*Calculadora*/
        View.OnClickListener onClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pulsado(view);
            }
        };
        v.findViewById(R.id.b0).setOnClickListener(onClickListener);
        v.findViewById(R.id.b1).setOnClickListener(onClickListener);
        v.findViewById(R.id.b2).setOnClickListener(onClickListener);
        v.findViewById(R.id.b3).setOnClickListener(onClickListener);
        v.findViewById(R.id.b4).setOnClickListener(onClickListener);
        v.findViewById(R.id.b5).setOnClickListener(onClickListener);
        v.findViewById(R.id.b6).setOnClickListener(onClickListener);
        v.findViewById(R.id.b7).setOnClickListener(onClickListener);
        v.findViewById(R.id.b8).setOnClickListener(onClickListener);
        v.findViewById(R.id.b9).setOnClickListener(onClickListener);
        v.findViewById(R.id.bc).setOnClickListener(onClickListener);
        v.findViewById(R.id.bequal).setOnClickListener(onClickListener);
        v.findViewById(R.id.bplus).setOnClickListener(onClickListener);
        /*************/

        return v;
    }

    public void convEuroPeseta(View view){
        try {
            Float res=(float)Math.round( (suma(view)* 166.386) * 100f) / 100f;
            salida2.setText(entrada.getText() +" = "+ String.valueOf(suma(view))+" Euros");
            salida.setText(String.valueOf(suma(view))+" Euros "+ getString(R.string.son) + " " + String.valueOf(res) +" Ptas.");
        }catch (NumberFormatException e) {
            salida.setText("0.0");
        }

    }

    public void convPesetaEuro(View view){
        try{
            Float res=(float)Math.round( (suma(view)/ 166.386) * 100f) / 100f;
            salida2.setText(entrada.getText() +" = "+ String.valueOf(suma(view))+" Ptas.");
            salida.setText(String.valueOf(suma(view))+" Ptas. "+ getString(R.string.son)+ " " + String.valueOf(res) +" Euros");
        }catch (NumberFormatException e) {
            salida.setText("0.0");
        }

    }

    public Float suma(View view){
        String strDatos=entrada.getText().toString();

        StringTokenizer tokens=new StringTokenizer(strDatos, "+");
        Float resultado=new Float(0);
        int i=0;
        while(tokens.hasMoreTokens()){
            String str=tokens.nextToken();
            resultado= resultado + Float.valueOf(str).floatValue();
            i++;
        }
        return(resultado);

    }

    public void pulsado(View view)
    {
        switch(view.getId())
        {
            case R.id.b0:
                entrada.setText(entrada.getText()+"0");
                break;
            case R.id.b1:
                entrada.setText(entrada.getText()+"1");
                break;
            case R.id.b2:
                entrada.setText(entrada.getText()+"2");
                break;
            case R.id.b3:
                entrada.setText(entrada.getText()+"3");
                break;
            case R.id.b4:
                entrada.setText(entrada.getText()+"4");
                break;
            case R.id.b5:
                entrada.setText(entrada.getText()+"5");
                break;
            case R.id.b6:
                entrada.setText(entrada.getText()+"6");
                break;
            case R.id.b7:
                entrada.setText(entrada.getText()+"7");
                break;
            case R.id.b8:
                entrada.setText(entrada.getText()+"8");
                break;
            case R.id.b9:
                entrada.setText(entrada.getText()+"9");
                break;
            case R.id.bc:
                try{
                entrada.setText("");
                salida.setText("");
                salida2.setText("");
                }catch(Exception e){}
                break;
            case R.id.bplus:
                entrada.setText(entrada.getText()+"+");
                break;
            case R.id.bequal:
                salida.setText(String.valueOf(suma(view)));
                break;

        }

    }


}