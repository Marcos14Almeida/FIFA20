package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//Como usar database SQLite
//https://www.youtube.com/watch?v=-wor0Po7SEc
public class ActivityJogadores extends Activity {
    Conexao db;

    String id;
    ListView listView;
    String dados;
    ArrayList<String> lista_nomes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogadores);

        db =new Conexao(this);

        //PARA SALVAR
        //Boolean returno= db.inserir("Messi", "25", "80", "asd");
        //if(returno==true && returno!=null){Toast.makeText(this, "Database Atualizado", Toast.LENGTH_SHORT).show();}
        //if(returno==false&& returno!=null){Toast.makeText(this, "Erro ao salvar no Database", Toast.LENGTH_SHORT).show();}



        listView = findViewById(R.id.lista);
        Cursor data = db.getListContent();
        while(data.moveToNext()){
            lista_nomes.add(data.getString(1));//PEGA OS NOMES... 2 PEGA IDADE... 3 PEGA OVERALL
            ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lista_nomes);
            listView.setAdapter(listAdapter);
        }

        //PARA RECEBER
        dados=db.obterTodos();
        TextView texto = findViewById(R.id.text_data);
        texto.setText(dados);
        texto.setMovementMethod(new ScrollingMovementMethod());

    }

    public void Botao1(View view) {
        //Deletar
        id="1";
        db.excluir(id);
        id="2";
        db.excluir(id);
        id="3";
        db.excluir(id);

        //PARA RECEBER
        dados=db.obterTodos();
        TextView texto = findViewById(R.id.text_data);
        texto.setText(dados);
        texto.setMovementMethod(new ScrollingMovementMethod());

    }

    public void abrirActivity4(View view) {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

}


