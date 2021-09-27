package peu.example.prova3b_beapedroa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InserirAluno extends AppCompatActivity {

    EditText txtNome;
    EditText txtNota1;
    EditText txtNota2;
    TextView lblMedia;
    Button btnOk;
    Button btnCancela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_aluno);

        txtNome = findViewById(R.id.txtNome);
        txtNota1 = findViewById(R.id.txtNota1);
        txtNota2 = findViewById(R.id.txtNota2);

        lblMedia = findViewById(R.id.lblMedia);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancela = (Button) findViewById(R.id.btnCancela);

        btnOk.setOnClickListener( new AddAluno() );
        btnCancela.setOnClickListener( new Cancela() );


    }
    private class AddAluno implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String nome, nota1, nota2, mediaM;
            Double n1, n2, media;

            nome = txtNome.getText().toString();
            nota1 = txtNota1.getText().toString();
            nota2 = txtNota2.getText().toString();

            n1 = Double.parseDouble( txtNota1.getText().toString() );
            n2 = Double.parseDouble( txtNota2.getText().toString() );

            media = (n1+n2)/2;
            mediaM = String.valueOf(media);

            Intent i = new Intent();

            i.putExtra("nome", nome);
            i.putExtra("nota1", nota1);
            i.putExtra("nota2", nota2);
            i.putExtra("media", mediaM);

            setResult(RESULT_OK,i);

            txtNome.setText("");
            txtNota1.setText("");
            txtNota2.setText("");

            finish();
        }
    }

    private class Cancela implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    }
}