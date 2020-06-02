package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool, precoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.precoAlcool     = findViewById(R.id.editTextPrecoAlcool);
        this.precoGasolina   = findViewById(R.id.editTextPrecoGasolina);
        this.resultado       = findViewById(R.id.textViewResultado);
    }

    public void calcular(View view){
        String precoAlcoolString    = precoAlcool.getText().toString();
        String precoGasolinaString  = precoGasolina.getText().toString();

        Boolean validaCampos = this.validarCampos(precoAlcoolString, precoGasolinaString);

        if(validaCampos){
            Float precoAlcoolFloat      = Float.parseFloat(precoAlcoolString);
            Float precoGasolinaFloat    = Float.parseFloat(precoGasolinaString);

            if((precoAlcoolFloat/precoGasolinaFloat) > 0.7){
                this.resultado.setText("Use gasolina");
            }else{
                this.resultado.setText("Use alcool");
            }
        }else{
            this.resultado.setText("Preencha os preços!");
        }
    }

    public boolean validarCampos(String precoAlcool, String precoGasolina){

        if(precoAlcool == null || precoAlcool.equals("")){
            return false;
        }else if(precoGasolina == null || precoGasolina.equals("")){
            return false;
        }
        return true;
    }
}
