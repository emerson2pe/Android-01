package br.senac.es.conversotamanho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int alturaEmCentimentros = 0;

    @Override
    //Protected
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //metodo que liga a MainActivity.JAVA no activity_main.xml (TELA)
        setContentView(R.layout.activity_main);

        //Instacia de um elemento texto do android
        final textView txtMetros = (TextView) findViewById(R.id.textMetros);
        //Exemplo Semelhante de instacia objeto no java
        //final textview textMetros = new TextView();
        final textView txtPes = (TextView) findViewById(R.id.textPes);




     }
}
