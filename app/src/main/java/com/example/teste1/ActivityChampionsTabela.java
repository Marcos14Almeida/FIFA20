package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityChampionsTabela extends AppCompatActivity {
    String meutime;
    String time_da_linha;
    int campeonato, max=16, max2=7;
    int posicao;
    int rodada;
    int SaldoGols;
    TextView textoNomeTime,textoPontos,textoGolsMarcados,textoGolsSofridos,textoSaldoGols,textovalorEquipe;
    ImageView imagemTime;
    ArrayList<String> times = new ArrayList<>();
    ArrayList<Integer> chave = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotal = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotal = new ArrayList<>();
    ArrayList<Integer> pontos = new ArrayList<>();
    ArrayList<Integer> PtsEquipe = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampions = new ArrayList<>();

    ArrayList<String> timesChampions = new ArrayList<>();
    ArrayList<String> timesChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> pontosTotalChampionsOrdem = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_champions_tabela);

        //Recebe dados globais
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        meutime  = globalVariable.Sabermeutime();
        campeonato = globalVariable.SaberCampeonato();
        posicao = globalVariable.SaberPosicao();
        PtsEquipeChampions = globalVariable.SaberPtsEquipeChampions();

        //PRINT TABELA
        globalVariable.DefinirOrdemChampions();
        timesChampionsOrdem=globalVariable.SabertimesChampionsOrdem();
        PtsEquipeChampionsOrdem=globalVariable.SaberPtsEquipeChampionsOrdem();
        pontosTotalChampionsOrdem=globalVariable.SaberPontosChampionsOrdem();
        golsMarcadosTotalChampionsOrdem=globalVariable.SaberGolsMarcadosTotalChampionsOrdem();
        golsSofridosTotalChampionsOrdem=globalVariable.SaberGolsSofridosTotalChampionsOrdem();

        tabela();
    }
    public void PrintarTime(Integer id){
        time_da_linha = timesChampionsOrdem.get(id);
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.imageLogo(time_da_linha,imagemTime);
        textoNomeTime.setText(time_da_linha+" ");
        if(id%4==1 || id%4 ==2)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));
        if(time_da_linha.equals(meutime)){textoNomeTime.setBackgroundColor(Color.rgb(150,255,150));}
        textoPontos.setText(" "+String.valueOf(pontosTotalChampionsOrdem.get(id)));
        textoGolsMarcados.setText(" "+golsMarcadosTotalChampionsOrdem.get(id));
        textoGolsSofridos.setText(" "+golsSofridosTotalChampionsOrdem.get(id));
        SaldoGols=golsMarcadosTotalChampionsOrdem.get(id)-golsSofridosTotalChampionsOrdem.get(id);
        textoSaldoGols.setText(" "+String.valueOf(SaldoGols));
        textovalorEquipe.setText(" "+PtsEquipeChampionsOrdem.get(id));
    }

    public void tabela(){
         /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TABELA //
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1);
        textoPontos = findViewById(R.id.pontosGanhos1);
        textoGolsMarcados = findViewById(R.id.golsMarcados1);
        textoGolsSofridos = findViewById(R.id.golsSofridos1);
        textoSaldoGols = findViewById(R.id.saldoGols1);
        textovalorEquipe = findViewById(R.id.valorEquipe1);
        imagemTime = findViewById(R.id.logo1);
        PrintarTime(1);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2);
        textoPontos = findViewById(R.id.pontosGanhos2);
        textoGolsMarcados = findViewById(R.id.golsMarcados2);
        textoGolsSofridos = findViewById(R.id.golsSofridos2);
        textoSaldoGols = findViewById(R.id.saldoGols2);
        textovalorEquipe = findViewById(R.id.valorEquipe2);
        imagemTime = findViewById(R.id.logo2);
        PrintarTime(2);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3);
        textoPontos = findViewById(R.id.pontosGanhos3);
        textoGolsMarcados = findViewById(R.id.golsMarcados3);
        textoGolsSofridos = findViewById(R.id.golsSofridos3);
        textoSaldoGols = findViewById(R.id.saldoGols3);
        textovalorEquipe = findViewById(R.id.valorEquipe3);
        imagemTime = findViewById(R.id.logo3);
        PrintarTime(3);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4);
        textoPontos = findViewById(R.id.pontosGanhos4);
        textoGolsMarcados = findViewById(R.id.golsMarcados4);
        textoGolsSofridos = findViewById(R.id.golsSofridos4);
        textoSaldoGols = findViewById(R.id.saldoGols4);
        textovalorEquipe = findViewById(R.id.valorEquipe4);
        imagemTime = findViewById(R.id.logo4);
        PrintarTime(4);

        ///GRUPO B
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1B);
        textoPontos = findViewById(R.id.pontosGanhos1B);
        textoGolsMarcados = findViewById(R.id.golsMarcados1B);
        textoGolsSofridos = findViewById(R.id.golsSofridos1B);
        textoSaldoGols = findViewById(R.id.saldoGols1B);
        textovalorEquipe = findViewById(R.id.valorEquipe1B);
        imagemTime = findViewById(R.id.logo1B);
        PrintarTime(5);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2B);
        textoPontos = findViewById(R.id.pontosGanhos2B);
        textoGolsMarcados = findViewById(R.id.golsMarcados2B);
        textoGolsSofridos = findViewById(R.id.golsSofridos2B);
        textoSaldoGols = findViewById(R.id.saldoGols2B);
        textovalorEquipe = findViewById(R.id.valorEquipe2B);
        imagemTime = findViewById(R.id.logo2B);
        PrintarTime(6);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3B);
        textoPontos = findViewById(R.id.pontosGanhos3B);
        textoGolsMarcados = findViewById(R.id.golsMarcados3B);
        textoGolsSofridos = findViewById(R.id.golsSofridos3B);
        textoSaldoGols = findViewById(R.id.saldoGols3B);
        textovalorEquipe = findViewById(R.id.valorEquipe3B);
        imagemTime = findViewById(R.id.logo3B);
        PrintarTime(7);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4B);
        textoPontos = findViewById(R.id.pontosGanhos4B);
        textoGolsMarcados = findViewById(R.id.golsMarcados4B);
        textoGolsSofridos = findViewById(R.id.golsSofridos4B);
        textoSaldoGols = findViewById(R.id.saldoGols4B);
        textovalorEquipe = findViewById(R.id.valorEquipe4B);
        imagemTime = findViewById(R.id.logo4B);
        PrintarTime(8);

        ///GRUPO C
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1C);
        textoPontos = findViewById(R.id.pontosGanhos1C);
        textoGolsMarcados = findViewById(R.id.golsMarcados1C);
        textoGolsSofridos = findViewById(R.id.golsSofridos1C);
        textoSaldoGols = findViewById(R.id.saldoGols1C);
        textovalorEquipe = findViewById(R.id.valorEquipe1C);
        imagemTime = findViewById(R.id.logo1C);
        PrintarTime(9);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2C);
        textoPontos = findViewById(R.id.pontosGanhos2C);
        textoGolsMarcados = findViewById(R.id.golsMarcados2C);
        textoGolsSofridos = findViewById(R.id.golsSofridos2C);
        textoSaldoGols = findViewById(R.id.saldoGols2C);
        textovalorEquipe = findViewById(R.id.valorEquipe2C);
        imagemTime = findViewById(R.id.logo2C);
        PrintarTime(10);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3C);
        textoPontos = findViewById(R.id.pontosGanhos3C);
        textoGolsMarcados = findViewById(R.id.golsMarcados3C);
        textoGolsSofridos = findViewById(R.id.golsSofridos3C);
        textoSaldoGols = findViewById(R.id.saldoGols3C);
        textovalorEquipe = findViewById(R.id.valorEquipe3C);
        imagemTime = findViewById(R.id.logo3C);
        PrintarTime(11);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4C);
        textoPontos = findViewById(R.id.pontosGanhos4C);
        textoGolsMarcados = findViewById(R.id.golsMarcados4C);
        textoGolsSofridos = findViewById(R.id.golsSofridos4C);
        textoSaldoGols = findViewById(R.id.saldoGols4C);
        textovalorEquipe = findViewById(R.id.valorEquipe4C);
        imagemTime = findViewById(R.id.logo4C);
        PrintarTime(12);

        ///GRUPO D
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1D);
        textoPontos = findViewById(R.id.pontosGanhos1D);
        textoGolsMarcados = findViewById(R.id.golsMarcados1D);
        textoGolsSofridos = findViewById(R.id.golsSofridos1D);
        textoSaldoGols = findViewById(R.id.saldoGols1D);
        textovalorEquipe = findViewById(R.id.valorEquipe1D);
        imagemTime = findViewById(R.id.logo1D);
        PrintarTime(13);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2D);
        textoPontos = findViewById(R.id.pontosGanhos2D);
        textoGolsMarcados = findViewById(R.id.golsMarcados2D);
        textoGolsSofridos = findViewById(R.id.golsSofridos2D);
        textoSaldoGols = findViewById(R.id.saldoGols2D);
        textovalorEquipe = findViewById(R.id.valorEquipe2D);
        imagemTime = findViewById(R.id.logo2D);
        PrintarTime(14);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3D);
        textoPontos = findViewById(R.id.pontosGanhos3D);
        textoGolsMarcados = findViewById(R.id.golsMarcados3D);
        textoGolsSofridos = findViewById(R.id.golsSofridos3D);
        textoSaldoGols = findViewById(R.id.saldoGols3D);
        textovalorEquipe = findViewById(R.id.valorEquipe3D);
        imagemTime = findViewById(R.id.logo3D);
        PrintarTime(15);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4D);
        textoPontos = findViewById(R.id.pontosGanhos4D);
        textoGolsMarcados = findViewById(R.id.golsMarcados4D);
        textoGolsSofridos = findViewById(R.id.golsSofridos4D);
        textoSaldoGols = findViewById(R.id.saldoGols4D);
        textovalorEquipe = findViewById(R.id.valorEquipe4D);
        imagemTime = findViewById(R.id.logo4D);
        PrintarTime(16);

        ///GRUPO E
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1E);
        textoPontos = findViewById(R.id.pontosGanhos1E);
        textoGolsMarcados = findViewById(R.id.golsMarcados1E);
        textoGolsSofridos = findViewById(R.id.golsSofridos1E);
        textoSaldoGols = findViewById(R.id.saldoGols1E);
        textovalorEquipe = findViewById(R.id.valorEquipe1E);
        imagemTime = findViewById(R.id.logo1E);
        PrintarTime(17);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2E);
        textoPontos = findViewById(R.id.pontosGanhos2E);
        textoGolsMarcados = findViewById(R.id.golsMarcados2E);
        textoGolsSofridos = findViewById(R.id.golsSofridos2E);
        textoSaldoGols = findViewById(R.id.saldoGols2E);
        textovalorEquipe = findViewById(R.id.valorEquipe2E);
        imagemTime = findViewById(R.id.logo2E);
        PrintarTime(18);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3E);
        textoPontos = findViewById(R.id.pontosGanhos3E);
        textoGolsMarcados = findViewById(R.id.golsMarcados3E);
        textoGolsSofridos = findViewById(R.id.golsSofridos3E);
        textoSaldoGols = findViewById(R.id.saldoGols3E);
        textovalorEquipe = findViewById(R.id.valorEquipe3E);
        imagemTime = findViewById(R.id.logo3E);
        PrintarTime(19);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4E);
        textoPontos = findViewById(R.id.pontosGanhos4E);
        textoGolsMarcados = findViewById(R.id.golsMarcados4E);
        textoGolsSofridos = findViewById(R.id.golsSofridos4E);
        textoSaldoGols = findViewById(R.id.saldoGols4E);
        textovalorEquipe = findViewById(R.id.valorEquipe4E);
        imagemTime = findViewById(R.id.logo4E);
        PrintarTime(20);
        ///GRUPO F
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1f);
        textoPontos = findViewById(R.id.pontosGanhos1f);
        textoGolsMarcados = findViewById(R.id.golsMarcados1f);
        textoGolsSofridos = findViewById(R.id.golsSofridos1f);
        textoSaldoGols = findViewById(R.id.saldoGols1f);
        textovalorEquipe = findViewById(R.id.valorEquipe1f);
        imagemTime = findViewById(R.id.logo1f);
        PrintarTime(21);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2f);
        textoPontos = findViewById(R.id.pontosGanhos2f);
        textoGolsMarcados = findViewById(R.id.golsMarcados2f);
        textoGolsSofridos = findViewById(R.id.golsSofridos2f);
        textoSaldoGols = findViewById(R.id.saldoGols2f);
        textovalorEquipe = findViewById(R.id.valorEquipe2f);
        imagemTime = findViewById(R.id.logo2f);
        PrintarTime(22);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3f);
        textoPontos = findViewById(R.id.pontosGanhos3f);
        textoGolsMarcados = findViewById(R.id.golsMarcados3f);
        textoGolsSofridos = findViewById(R.id.golsSofridos3f);
        textoSaldoGols = findViewById(R.id.saldoGols3f);
        textovalorEquipe = findViewById(R.id.valorEquipe3f);
        imagemTime = findViewById(R.id.logo3f);
        PrintarTime(23);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4f);
        textoPontos = findViewById(R.id.pontosGanhos4f);
        textoGolsMarcados = findViewById(R.id.golsMarcados4f);
        textoGolsSofridos = findViewById(R.id.golsSofridos4f);
        textoSaldoGols = findViewById(R.id.saldoGols4f);
        textovalorEquipe = findViewById(R.id.valorEquipe4f);
        imagemTime = findViewById(R.id.logo4f);
        PrintarTime(24);
        ///GRUPO G
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1g);
        textoPontos = findViewById(R.id.pontosGanhos1g);
        textoGolsMarcados = findViewById(R.id.golsMarcados1g);
        textoGolsSofridos = findViewById(R.id.golsSofridos1g);
        textoSaldoGols = findViewById(R.id.saldoGols1g);
        textovalorEquipe = findViewById(R.id.valorEquipe1g);
        imagemTime = findViewById(R.id.logo1g);
        PrintarTime(25);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2g);
        textoPontos = findViewById(R.id.pontosGanhos2g);
        textoGolsMarcados = findViewById(R.id.golsMarcados2g);
        textoGolsSofridos = findViewById(R.id.golsSofridos2g);
        textoSaldoGols = findViewById(R.id.saldoGols2g);
        textovalorEquipe = findViewById(R.id.valorEquipe2g);
        imagemTime = findViewById(R.id.logo2g);
        PrintarTime(26);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3g);
        textoPontos = findViewById(R.id.pontosGanhos3g);
        textoGolsMarcados = findViewById(R.id.golsMarcados3g);
        textoGolsSofridos = findViewById(R.id.golsSofridos3g);
        textoSaldoGols = findViewById(R.id.saldoGols3g);
        textovalorEquipe = findViewById(R.id.valorEquipe3g);
        imagemTime = findViewById(R.id.logo3g);
        PrintarTime(27);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4g);
        textoPontos = findViewById(R.id.pontosGanhos4g);
        textoGolsMarcados = findViewById(R.id.golsMarcados4g);
        textoGolsSofridos = findViewById(R.id.golsSofridos4g);
        textoSaldoGols = findViewById(R.id.saldoGols4g);
        textovalorEquipe = findViewById(R.id.valorEquipe4g);
        imagemTime = findViewById(R.id.logo4g);
        PrintarTime(28);

        ///GRUPO H
        //Coluna1
        textoNomeTime =  findViewById(R.id.nomeTime1h);
        textoPontos = findViewById(R.id.pontosGanhos1h);
        textoGolsMarcados = findViewById(R.id.golsMarcados1h);
        textoGolsSofridos = findViewById(R.id.golsSofridos1h);
        textoSaldoGols = findViewById(R.id.saldoGols1h);
        textovalorEquipe = findViewById(R.id.valorEquipe1h);
        imagemTime = findViewById(R.id.logo1h);
        PrintarTime(29);

        //Coluna2
        textoNomeTime =  findViewById(R.id.nomeTime2h);
        textoPontos = findViewById(R.id.pontosGanhos2h);
        textoGolsMarcados = findViewById(R.id.golsMarcados2h);
        textoGolsSofridos = findViewById(R.id.golsSofridos2h);
        textoSaldoGols = findViewById(R.id.saldoGols2h);
        textovalorEquipe = findViewById(R.id.valorEquipe2h);
        imagemTime = findViewById(R.id.logo2h);
        PrintarTime(30);

        //Coluna3
        textoNomeTime =  findViewById(R.id.nomeTime3h);
        textoPontos = findViewById(R.id.pontosGanhos3h);
        textoGolsMarcados = findViewById(R.id.golsMarcados3h);
        textoGolsSofridos = findViewById(R.id.golsSofridos3h);
        textoSaldoGols = findViewById(R.id.saldoGols3h);
        textovalorEquipe = findViewById(R.id.valorEquipe3h);
        imagemTime = findViewById(R.id.logo3h);
        PrintarTime(31);

        //Coluna4
        textoNomeTime =  findViewById(R.id.nomeTime4h);
        textoPontos = findViewById(R.id.pontosGanhos4h);
        textoGolsMarcados = findViewById(R.id.golsMarcados4h);
        textoGolsSofridos = findViewById(R.id.golsSofridos4h);
        textoSaldoGols = findViewById(R.id.saldoGols4h);
        textovalorEquipe = findViewById(R.id.valorEquipe4h);
        imagemTime = findViewById(R.id.logo4h);
        PrintarTime(32);
        /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //TABELA
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void abrirActivityMenu(View view) {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
}
