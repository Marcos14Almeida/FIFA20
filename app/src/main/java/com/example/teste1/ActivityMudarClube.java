package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ActivityMudarClube extends AppCompatActivity {
    int campeonato, max, max2,posicao;
    int item;
    ArrayList<String> timeProposta = new ArrayList<>();
    ArrayList<Integer> PosicaoProposta = new ArrayList<>();
    ArrayList<Integer> CampeonatoProposta = new ArrayList<>();
    ArrayList<Integer> ClassificacaoProposta = new ArrayList<>();
    ArrayList<String> times = new ArrayList<>();
    ArrayList<String> timesOrdem = new ArrayList<>();
    ArrayList<Integer> PtsEquipe = new ArrayList<>();
    ArrayList<Integer> pontosOrdem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_clube);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        times = globalVariable.SaberTimes();
        posicao = globalVariable.SaberPosicao();
        campeonato = globalVariable.SaberCampeonato();
        PtsEquipe = globalVariable.SaberPtsEquipe();
        timesOrdem = globalVariable.SabertimesOrdem();
        max = globalVariable.SaberMax();
        max2 = globalVariable.SaberMax2();

        //PROCURAR TIMES COM PONTUAÇÃO SIMILAR
        timeProposta.add("");
        CampeonatoProposta.add(0);
        PosicaoProposta.add(0);
        //2times da mesma liga
        while(timeProposta.size()<2) {
            for (int k = campeonato; k <= campeonato; k++) {
                for (int i = 1; i <= max; i++) {
                    int j = new Random().nextInt(10);
                    if (j > 4 && (k!=campeonato || i!=posicao)) {
                        //Se tiver na margem de força do time
                        if (PtsEquipe.get((max * (k - 1)) + i) - PtsEquipe.get((max * (campeonato - 1)) + posicao) >= -4 && (PtsEquipe.get((max * (k - 1)) + i) - PtsEquipe.get((max * (campeonato - 1)) + posicao)) <= 2) {
                            timeProposta.add(times.get((max * (k - 1)) + i));
                            CampeonatoProposta.add(k);
                            PosicaoProposta.add(i);
                            if(timeProposta.size()>2)break;
                        }
                    }
                }
            }
        }
        //4 times de outras ligas
        while(timeProposta.size()<=6) {
            for (int k = 1; k <= max2; k++) {
                for (int i = 1; i <= max; i++) {
                    int j = new Random().nextInt(10);
                    if (j > 8 && (k!=campeonato && i!=posicao)) {
                        //Se tiver na margem de força do time
                        if (PtsEquipe.get((max * (k - 1)) + i) - PtsEquipe.get((max * (campeonato - 1)) + posicao) >= -3 && (PtsEquipe.get((max * (k - 1)) + i) - PtsEquipe.get((max * (campeonato - 1)) + posicao)) <= 2) {
                            if( timeProposta.equals(times.get((max * (k - 1)) + i))==false ) {//para não ter times repetidos
                                timeProposta.add(times.get((max * (k - 1)) + i));
                                CampeonatoProposta.add(k);
                                PosicaoProposta.add(i);
                                if (timeProposta.size() > 6) break;
                            }
                        }
                    }
                }
            }
        }

        //MINHA PONTUAÇÃO E CLASSIFICAÇÃO
        ClassificacaoProposta.add(0);
        for(int y=1;y<=6;y++){
            int classificao =  timesOrdem.indexOf(timeProposta.get(y))%max;
            if(classificao==0){classificao=max;}
        ClassificacaoProposta.add(classificao);}

        ImageView imageLogo = findViewById(R.id.imagemProposta1);
        globalVariable.imageLogo(timeProposta.get(1), imageLogo);
        imageLogo = findViewById(R.id.imagemProposta2);
        globalVariable.imageLogo(timeProposta.get(2), imageLogo);
        imageLogo = findViewById(R.id.imagemProposta3);
        globalVariable.imageLogo(timeProposta.get(3), imageLogo);
        imageLogo = findViewById(R.id.imagemProposta4);
        globalVariable.imageLogo(timeProposta.get(4), imageLogo);
        imageLogo = findViewById(R.id.imagemProposta5);
        globalVariable.imageLogo(timeProposta.get(5), imageLogo);
        imageLogo = findViewById(R.id.imagemProposta6);
        globalVariable.imageLogo(timeProposta.get(6), imageLogo);


        TextView texto = findViewById(R.id.textoProposta1);
        texto.setText(timeProposta.get(1)+"\nPosição: "+ClassificacaoProposta.get(1)+"º");
        texto = findViewById(R.id.textoProposta2);
        texto.setText(timeProposta.get(2)+"\nPosição: "+ClassificacaoProposta.get(2)+"º");
        texto = findViewById(R.id.textoProposta3);
        texto.setText(timeProposta.get(3)+"\nPosição: "+ClassificacaoProposta.get(3)+"º");
        texto = findViewById(R.id.textoProposta4);
        texto.setText(timeProposta.get(4)+"\nPosição: "+ClassificacaoProposta.get(4)+"º");
        texto = findViewById(R.id.textoProposta5);
        texto.setText(timeProposta.get(5)+"\nPosição: "+ClassificacaoProposta.get(5)+"º");
        texto = findViewById(R.id.textoProposta6);
        texto.setText(timeProposta.get(6)+"\nPosição: "+ClassificacaoProposta.get(6)+"º");
    }

    public void abrirActivityMenu(View view){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

    public void SalvarVariaveis(Integer id){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.Definirmeutime(timeProposta.get(id));
        globalVariable.DefinirPosicao(PosicaoProposta.get(id));
        Integer Pts = PtsEquipe.get((max * (CampeonatoProposta.get(id) - 1)) + PosicaoProposta.get(id));
        float dinheiro = (Pts-68)*(Pts-68)/2;
        globalVariable.DefinirParametros(CampeonatoProposta.get(id),dinheiro);
        globalVariable.DefinirTransferenciaTecnico(1);
    }

    public void imagem1(View view){
        SalvarVariaveis(1);
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void imagem2(View view){
        SalvarVariaveis(2);
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void imagem3(View view){
        SalvarVariaveis(3);
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void imagem4(View view){
        SalvarVariaveis(4);
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void imagem5(View view){
        SalvarVariaveis(5);
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void imagem6(View view){
        SalvarVariaveis(6);
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
}
