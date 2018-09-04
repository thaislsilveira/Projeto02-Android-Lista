package projeto02.com.br.projeto02;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtNumero;
    Button btnCalcular, btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtNumero = (EditText) findViewById(R.id.edtNumero);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        //ação do método do botão Calcular

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNumero.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtNumero.requestFocus();
                } else{
                    Double numero = Double.parseDouble(edtNumero.getText().toString());

                    Double quadrado = (numero)*(numero);

                    Double cubo = (numero)*(numero)*(numero);

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("QUADRADO E O CUBO");
                    alerta.setMessage("O número : "
                            + edtNumero.getText().toString()
                            + "\ntem o valor do quadrado de : "
                            + new DecimalFormat("0.00").format(quadrado)
                            + "\ne o valor do cubo de : "
                            + new DecimalFormat("0.00").format(cubo));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNumero.setText("");
                edtNumero.requestFocus();
            }
        });

    }
}
