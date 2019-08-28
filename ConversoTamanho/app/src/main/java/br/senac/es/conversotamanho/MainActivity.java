package br.senac.es.conversotamanho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int alturaEmCentimentros = 0;


    @Override
    //Protected
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //metodo que liga a MainActivity.JAVA no activity_main.xml (TELA)
        setContentView(R.layout.activity_main);

        //Instacia de um elemento texto do android
        final TextView txtMetros = (TextView) findViewById(R.id.txtMetros);
        //Exemplo Semelhante de instacia objeto no java
        //final textview textMetros = new TextView();

        //txtMetros.setText(" "+ alturaEmCentimentros);
        //Cria um string vazia concatenada.

        final TextView txtPes = (TextView) findViewById(R.id.txtPes);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.skbMetros);

        final Button button = (Button) findViewById(R.id.btnConverter);
        //são amarrados ao id que exibem os valores e comando.

        seekBar.setMax(230);
        //ate o limite final no caso o valor maximo 230.

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // monitora e atualiza as 3 funções.

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                //quando usuario move no SeekBar e para ele pega o valor e guarda.
                alturaEmCentimentros = progress;
                //txtMetros.setText(progress + "centimetro")
                String texto = formataValorComDoisDigitos(progress / 100.0);
                //chama formataValorComDoisDigitos para calcular o progress / 100.0 e guarda no texto.
                texto += "m.";
                txtMetros.setText(texto);
                //informa o valor do texto.

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //quando usuario para de mover o SeekBar ele da a menssagem que precisa converter.
                txtPes.setText("Toque em Converter");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //quando usuario para de mover no SeekBar.
            }

        });
        final Button btnConverter = (Button) findViewById(R.id.btnConverter);
        btnConverter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double alturaEmPes = alturaEmCentimentros / 30.48;
                //alturaEmPes recebe o valor alturaEmCentimentros / 30.48.
                String texto = formataValorComDoisDigitos(alturaEmPes);
                //converte para String e deixa o valor com 2 casas.
                texto += "pé(s)";
                txtPes.setText(texto);
            }
        });

    }

    private String formataValorComDoisDigitos(double valor) {
        return String.format(Locale.FRANCE, "%.2f", valor);
        //retorna um local, pega valor e formata.


    }


}





