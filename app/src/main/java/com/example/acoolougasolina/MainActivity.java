package com.example.acoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool;
    private TextInputEditText editPrecoGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void calcularPreco(View v){

        //recuperando valores
        String precoAcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar campos digitados
        Boolean camposValidados = validarCampos(precoAcool, precoGasolina);
        if(camposValidados){

            //convertendo string para numeros
            Double valorAlcool = Double.parseDouble(precoAcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //calculo de menor preco
            Double resultado = valorAlcool / valorGasolina;
            if(resultado >= 0.7){
                txtResultado.setText("Melhor usar Gasolina");
            }else {
                txtResultado.setText("Melhor usar Alcool");
            }

        }else{
            txtResultado.setText("Preencha os valores primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;
        String campo = "preenchido";

        if(pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
            campo = "alcool nao foi preenchido";
        }
        else if(pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
            campo = "gasolina nao foi preenchido";
        }

        return camposValidados;
    }

}