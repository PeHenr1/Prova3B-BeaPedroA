package peu.example.prova3b_beapedroa;
// DESENVOLVIDO POR BEATRIZ CALDEIRA E PEDRO HENRIQUE AISSA
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnInserir;
    private ListView listaAlunos;

    private ArrayList <Aluno> alunos = new ArrayList<>();
    private AdapterAlunos adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInserir = findViewById(R.id.btnInserir);
        btnInserir.setOnClickListener( new AbrirAluno() );
        listaAlunos = findViewById( R.id.listaAlunos );

        // criando adaptador
        adaptador = new AdapterAlunos( this, alunos );

        // associando o adaptador a lista
        listaAlunos.setAdapter( adaptador );

        // configurar a lista com o escutador de cliques comuns
        listaAlunos.setOnItemClickListener( new EscutadorLista() );

        // configurar a lista com o escutador de cliques longos
        listaAlunos.setOnItemLongClickListener( new EscutadorLista() );

    }

    private class AbrirAluno implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent i = new Intent( getApplicationContext(), InserirAluno.class );
            startActivityForResult(i,1);
        }
    }


    private class EscutadorLista implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Toast.makeText(MainActivity.this, "Dados do aluno: " + "\nNome: "+alunos.get(i).getNome()+
                            "\nNota 1: "+alunos.get(i).getNota1() + "\nNota 2: "+alunos.get(i).getNota2() +
                            "\nMédia: "+alunos.get(i).getMedia(),
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            alunos.remove(i);
            adaptador.notifyDataSetChanged();
            Toast.makeText(MainActivity.this, "Aluno deletado!", Toast.LENGTH_LONG).show();
            return true;
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent i) {

        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                String nome = i.getStringExtra("nome");
                String nota1 = i.getStringExtra("nota1");
                String nota2 = i.getStringExtra("nota2");
                String media = i.getStringExtra("media");

                Aluno a = new Aluno( nome, nota1, nota2, media );

                // inserindo no ArrayList
                alunos.add( a );

                // avisando o adapter que os dados foram atualizados
                adaptador.notifyDataSetChanged();

            }
        }
    }
}