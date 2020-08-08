package com.example.teste1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentTab4 extends Fragment {
    Button botaoMenu;
    ImageView fundochampions,imagemLogo;
    TextView textoTitulo;
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
    ArrayList<Integer> PtsEquipeLibertadores = new ArrayList<>();

    ArrayList<String> timesLibertadores = new ArrayList<>();
    ArrayList<String> timesLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> pontosTotalLibertadoresOrdem = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = (View) inflater.inflate(R.layout.activity_champions_tabela, container, false);

        //Recebe dados globais
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        meutime  = globalVariable.Sabermeutime();
        campeonato = globalVariable.SaberCampeonato();
        posicao = globalVariable.SaberPosicao();
        PtsEquipeLibertadores = globalVariable.SaberPtsEquipeLibertadores();

        //PRINT TABELA
        //globalVariable.DefinirOrdemLibertadores();
        timesLibertadoresOrdem=globalVariable.SabertimesLibertadoresOrdem();
        PtsEquipeLibertadoresOrdem=globalVariable.SaberPtsEquipeLibertadoresOrdem();
        pontosTotalLibertadoresOrdem=globalVariable.SaberPontosLibertadoresOrdem();
        golsMarcadosTotalLibertadoresOrdem=globalVariable.SaberGolsMarcadosTotalLibertadoresOrdem();
        golsSofridosTotalLibertadoresOrdem=globalVariable.SaberGolsSofridosTotalLibertadoresOrdem();



        tabela(rootView);


        //BOTÃO MENU
        botaoMenu = rootView.findViewById(R.id.botaoMenu);
        botaoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity4.class);
                startActivity(intent);
            }
        });
        fundochampions = rootView.findViewById(R.id.fundoChampions);
        fundochampions.setImageResource(R.drawable.fundolibertadores);
        imagemLogo = rootView.findViewById(R.id.imagemLogo);
        imagemLogo.setImageResource(R.drawable.libertadores);
        textoTitulo=rootView.findViewById(R.id.textoTitulo);
        textoTitulo.setText("Libertadores");
        return rootView;
    }
    public void PrintarTime(Integer id){
        time_da_linha = timesLibertadoresOrdem.get(id);
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        globalVariable.imageLogo(time_da_linha,imagemTime);
        textoNomeTime.setText(time_da_linha+" ");
        if(id%4==1 || id%4 ==2)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));
        if(time_da_linha.equals(meutime)){textoNomeTime.setBackgroundColor(Color.rgb(150,255,150));}
        textoPontos.setText(" "+String.valueOf(pontosTotalLibertadoresOrdem.get(id)));
        textoGolsMarcados.setText(" "+golsMarcadosTotalLibertadoresOrdem.get(id));
        textoGolsSofridos.setText(" "+golsSofridosTotalLibertadoresOrdem.get(id));
        SaldoGols=golsMarcadosTotalLibertadoresOrdem.get(id)-golsSofridosTotalLibertadoresOrdem.get(id);
        textoSaldoGols.setText(" "+String.valueOf(SaldoGols));
        textovalorEquipe.setText(" "+PtsEquipeLibertadoresOrdem.get(id));
    }

    public void tabela(View rootView){
         /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TABELA //
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1);
        imagemTime = rootView.findViewById(R.id.logo1);
        PrintarTime(1);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2);
        imagemTime = rootView.findViewById(R.id.logo2);
        PrintarTime(2);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3);
        imagemTime = rootView.findViewById(R.id.logo3);
        PrintarTime(3);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4);
        imagemTime = rootView.findViewById(R.id.logo4);
        PrintarTime(4);

        ///GRUPO B
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1B);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1B);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1B);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1B);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1B);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1B);
        imagemTime = rootView.findViewById(R.id.logo1B);
        PrintarTime(5);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2B);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2B);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2B);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2B);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2B);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2B);
        imagemTime = rootView.findViewById(R.id.logo2B);
        PrintarTime(6);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3B);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3B);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3B);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3B);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3B);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3B);
        imagemTime = rootView.findViewById(R.id.logo3B);
        PrintarTime(7);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4B);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4B);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4B);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4B);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4B);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4B);
        imagemTime = rootView.findViewById(R.id.logo4B);
        PrintarTime(8);

        ///GRUPO C
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1C);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1C);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1C);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1C);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1C);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1C);
        imagemTime = rootView.findViewById(R.id.logo1C);
        PrintarTime(9);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2C);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2C);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2C);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2C);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2C);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2C);
        imagemTime = rootView.findViewById(R.id.logo2C);
        PrintarTime(10);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3C);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3C);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3C);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3C);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3C);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3C);
        imagemTime = rootView.findViewById(R.id.logo3C);
        PrintarTime(11);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4C);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4C);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4C);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4C);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4C);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4C);
        imagemTime = rootView.findViewById(R.id.logo4C);
        PrintarTime(12);

        ///GRUPO D
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1D);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1D);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1D);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1D);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1D);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1D);
        imagemTime = rootView.findViewById(R.id.logo1D);
        PrintarTime(13);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2D);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2D);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2D);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2D);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2D);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2D);
        imagemTime = rootView.findViewById(R.id.logo2D);
        PrintarTime(14);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3D);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3D);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3D);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3D);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3D);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3D);
        imagemTime = rootView.findViewById(R.id.logo3D);
        PrintarTime(15);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4D);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4D);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4D);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4D);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4D);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4D);
        imagemTime = rootView.findViewById(R.id.logo4D);
        PrintarTime(16);

        ///GRUPO E
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1E);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1E);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1E);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1E);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1E);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1E);
        imagemTime = rootView.findViewById(R.id.logo1E);
        PrintarTime(17);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2E);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2E);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2E);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2E);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2E);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2E);
        imagemTime = rootView.findViewById(R.id.logo2E);
        PrintarTime(18);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3E);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3E);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3E);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3E);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3E);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3E);
        imagemTime = rootView.findViewById(R.id.logo3E);
        PrintarTime(19);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4E);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4E);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4E);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4E);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4E);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4E);
        imagemTime = rootView.findViewById(R.id.logo4E);
        PrintarTime(20);
        ///GRUPO F
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1f);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1f);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1f);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1f);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1f);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1f);
        imagemTime = rootView.findViewById(R.id.logo1f);
        PrintarTime(21);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2f);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2f);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2f);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2f);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2f);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2f);
        imagemTime = rootView.findViewById(R.id.logo2f);
        PrintarTime(22);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3f);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3f);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3f);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3f);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3f);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3f);
        imagemTime = rootView.findViewById(R.id.logo3f);
        PrintarTime(23);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4f);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4f);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4f);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4f);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4f);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4f);
        imagemTime = rootView.findViewById(R.id.logo4f);
        PrintarTime(24);
        ///GRUPO G
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1g);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1g);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1g);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1g);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1g);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1g);
        imagemTime = rootView.findViewById(R.id.logo1g);
        PrintarTime(25);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2g);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2g);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2g);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2g);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2g);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2g);
        imagemTime = rootView.findViewById(R.id.logo2g);
        PrintarTime(26);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3g);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3g);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3g);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3g);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3g);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3g);
        imagemTime = rootView.findViewById(R.id.logo3g);
        PrintarTime(27);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4g);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4g);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4g);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4g);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4g);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4g);
        imagemTime = rootView.findViewById(R.id.logo4g);
        PrintarTime(28);

        ///GRUPO H
        //Coluna1
        textoNomeTime =  rootView.findViewById(R.id.nomeTime1h);
        textoPontos = rootView.findViewById(R.id.pontosGanhos1h);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados1h);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos1h);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols1h);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe1h);
        imagemTime = rootView.findViewById(R.id.logo1h);
        PrintarTime(29);

        //Coluna2
        textoNomeTime =  rootView.findViewById(R.id.nomeTime2h);
        textoPontos = rootView.findViewById(R.id.pontosGanhos2h);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados2h);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos2h);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols2h);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe2h);
        imagemTime = rootView.findViewById(R.id.logo2h);
        PrintarTime(30);

        //Coluna3
        textoNomeTime =  rootView.findViewById(R.id.nomeTime3h);
        textoPontos = rootView.findViewById(R.id.pontosGanhos3h);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados3h);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos3h);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols3h);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe3h);
        imagemTime = rootView.findViewById(R.id.logo3h);
        PrintarTime(31);

        //Coluna4
        textoNomeTime =  rootView.findViewById(R.id.nomeTime4h);
        textoPontos = rootView.findViewById(R.id.pontosGanhos4h);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados4h);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos4h);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols4h);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe4h);
        imagemTime = rootView.findViewById(R.id.logo4h);
        PrintarTime(32);
        /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //TABELA
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

}

