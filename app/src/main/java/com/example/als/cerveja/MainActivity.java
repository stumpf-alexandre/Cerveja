package com.example.als.cerveja;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etPreco1;
    EditText etQtd1;
    EditText etPreco2;
    EditText etQtd2;
    Button btnCalculo;
    Calculo cerveja = new Calculo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPreco1 = findViewById(R.id.editTextPreco1);
        etQtd1 = findViewById(R.id.editTextQtd1);
        etPreco2 = findViewById(R.id.editTextPreco2);
        etQtd2 = findViewById(R.id.editTextQtd2);
        btnCalculo = findViewById(R.id.buttonCalculo);

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etPreco1.getText().length() != 0 && etQtd1.getText().length() != 0 && etPreco2.getText().length() != 0 && etQtd2.getText().length() != 0 ){
                    double val1 = Double.parseDouble(etPreco1.getText().toString());
                    int qtd1 = Integer.parseInt(etQtd1.getText().toString());
                    double val2 = Double.parseDouble(etPreco2.getText().toString());

                    int qtd2 = Integer.parseInt(etQtd2.getText().toString());

                    val1 = cerveja.valor(val1,qtd1);
                    val2 = cerveja.valor(val2,qtd2);
                    if (val1 < val2){
                        AlertDialog.Builder janela =new AlertDialog.Builder(MainActivity.this);

                        janela.setTitle(getString(R.string.alert_title));
                        janela.setMessage(getString(R.string.alert_primeiro) + qtd1 + "ml");
                        janela.setNeutralButton("OK",null);
                        janela.show();
                        etPreco2.setText(" ");
                        etQtd2.setText(" ");
                    }
                    else if (val2 < val1){
                        AlertDialog.Builder janela =new AlertDialog.Builder(MainActivity.this);

                        janela.setTitle(getString(R.string.alert_title));
                        janela.setMessage(getString(R.string.alert_primeiro) + qtd2 + "ml");
                        janela.setNeutralButton("OK",null);
                        janela.show();
                        etPreco1.setText(" ");
                        etQtd1.setText(" ");
                    }
                    else {
                        AlertDialog.Builder janela =new AlertDialog.Builder(MainActivity.this);

                        janela.setTitle(getString(R.string.alert_title));
                        janela.setMessage(getString(R.string.alert_igual));
                        janela.setNeutralButton("OK",null);
                        janela.show();
                        etPreco2.setText(" ");
                        etQtd2.setText(" ");
                    }

                }else {
                    Toast.makeText(getApplicationContext(), R.string.alert, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
