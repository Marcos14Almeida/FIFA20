package com.example.teste1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class activity_3 extends AppCompatActivity {

    String fileName = "exemplo";

    private EditText textoNome;
    private EditText textoIdade;
    private TextView displayName;
    Button botaoActivity;
    Button botaoSalvar;
    Button botaoLoad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        textoNome = (EditText) findViewById(R.id.textoNome);
        textoIdade = (EditText) findViewById(R.id.textoIdade);
        botaoActivity = (Button) findViewById(R.id.botaoActivity);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvar);
        botaoLoad = (Button) findViewById(R.id.botaoLoad);
        displayName = findViewById(R.id.displayName);
    }

    public void save(View view) {
        String name = textoNome.getText().toString();
        String idade = textoIdade.getText().toString();
        if(name.equals(String.valueOf(""))){
            textoNome.setError("Escreva seu nome!!!");
        }
        else{

            double peso = Double.parseDouble(textoIdade.getText().toString());
            int peso1 = Integer.parseInt(textoIdade.getText().toString());
            double resultado = Math.pow(peso1,2);
            displayName.setText("Idade ao quadrado:"+resultado);
            try{
                FileOutputStream fileout = openFileOutput(fileName,MODE_PRIVATE);
                OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                outputWriter.write(name);
                outputWriter.write(idade);
                outputWriter.close();
                textoNome.setText("");
                textoIdade.setText("");

                Toast.makeText(getBaseContext(),"Sucesso",Toast.LENGTH_SHORT).show();
            }catch(Exception e){e.printStackTrace();}

        }

    }



    public void load(View view){
            try{
                FileInputStream fileIn = openFileInput(fileName);
                InputStreamReader inputRead = new InputStreamReader(fileIn);
                BufferedReader bufferedReader = new BufferedReader(inputRead);
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                while((line = bufferedReader.readLine()) !=null){
                    stringBuilder.append(line);
                }
                fileIn.close();
                inputRead.close();

                Toast.makeText(getBaseContext(),"Sucesso",Toast.LENGTH_SHORT).show();
                displayName.setText("Nome:"+ stringBuilder.toString());
            }catch(java.io.IOException e){e.printStackTrace();}

        }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastro, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.action_ok:
                validaDados();
                break;
            case R.id.action_cancel:
                Toast.makeText(this,"Cancelar", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void validaDados(){
        boolean res = false;
        String nome = textoNome.getText().toString();
        String idade = textoIdade.getText().toString();

        if (res=isCampoVazio(nome)){
            textoNome.requestFocus();
        }
        else if (res=isCampoVazio(idade)){
            textoIdade.requestFocus();
        }
        if(res==true){
            AlertDialog.Builder dlg= new AlertDialog.Builder(this);
            dlg.setTitle(R.string.title_aviso);
            dlg.setMessage(R.string.texto_de_aviso);
            dlg.setNeutralButton("Ok",null);
            dlg.show();
        }else{Toast.makeText(this,"Confirmado", Toast.LENGTH_SHORT).show();}


    }

    private boolean isCampoVazio(String valor){
        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
        return resultado;
    }

    public void abrirActivity1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
