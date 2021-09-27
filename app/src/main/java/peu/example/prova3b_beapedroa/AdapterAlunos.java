package peu.example.prova3b_beapedroa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAlunos extends ArrayAdapter<Aluno> {

    // contexto
    private Context context;

    private ArrayList<Aluno> alunos;

    public AdapterAlunos(Context context, ArrayList<Aluno> alunos) {

        super(context, R.layout.item_lista, alunos);
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.item_lista, parent, false);

        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblNota1 = itemView.findViewById(R.id.lblNota1);
        TextView lblNota2 = itemView.findViewById(R.id.lblNota2);
        TextView lblMedia = itemView.findViewById(R.id.lblMedia);

        lblNome.setText(alunos.get(position).getNome());
        lblNota1.setText(alunos.get(position).getNota1());
        lblNota2.setText(alunos.get(position).getNota2());
        lblMedia.setText(alunos.get(position).getMedia());

        return itemView;
    }
}
