package com.example.teste1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Random;

public class FragmentTab3 extends Fragment {
    Button botaoMenu;
    int rodada,campeonato,PtsEquipeAdversario,posicao;
    int vitoria,empate,resultado,Venceu;
    int golsMarcados,golsSofridos;
    int max=16,max2=8,ano=2020;
    int timea=0, timeb=0;
    int pontosA=0,pontosB=0;
    float dinheiro;
    String meutime,adversario;
    String timeFoto;
    ArrayList<String> times = new ArrayList<>();
    ArrayList<Integer> chave = new ArrayList<>();
    ArrayList<Integer> PtsEquipe = new ArrayList<>();

    TextView textoNomeTime,textoGolsMarcados;
    ImageView imagemTime;

    int minhaposicaoChampions,meuGrupoChampions,qualcampeonato, grupoSIMULACAO;
    ArrayList<String> timesChampionsOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsOitavas = new ArrayList<>();
    ArrayList<String> timesChampionsQuartas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsQuartas = new ArrayList<>();
    ArrayList<String> timesChampionsSemifinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsSemifinal = new ArrayList<>();
    ArrayList<String> timesChampionsFinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsFinal = new ArrayList<>();
    ArrayList<Integer> golsMarcadosMataMataChampions = new ArrayList<>();
    int rodadaOitavas=22,rodadaQuartas=23,rodadaSemi=24,rodadaFinal=25;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = (View) inflater.inflate(R.layout.activity_mata_mata_champions, container, false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        meutime  = globalVariable.Sabermeutime();
        dinheiro  = globalVariable.SaberDinheiro();
        rodada= globalVariable.SaberRodada();
        campeonato = globalVariable.SaberCampeonato();
        PtsEquipe =globalVariable.SaberPtsEquipe();
        ano = globalVariable.SaberAno();
        max= globalVariable.SaberMax();
        max2=globalVariable.SaberMax2();

        qualcampeonato=globalVariable.SaberQualCampeonato();

        golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
        timesChampionsOitavas=globalVariable.SaberTimesChampionsOitavas();
        PtsEquipeChampionsOitavas=globalVariable.SaberPtsEquipeChampionsOitavas();
        if(rodada!=rodadaOitavas){//se não atualiza o vetor errado
            timesChampionsQuartas=globalVariable.SaberTimesChampionsQuartas();
            PtsEquipeChampionsQuartas=globalVariable.SaberPtsEquipeChampionsQuartas();}
        if(rodada!=rodadaQuartas){//se não atualiza o vetor errado
            timesChampionsSemifinal=globalVariable.SaberTimesChampionsSemifinal();
            PtsEquipeChampionsSemifinal=globalVariable.SaberPtsEquipeChampionsSemifinal();}
        if(rodada!=rodadaSemi){//se não atualiza o vetor errado
            timesChampionsFinal=globalVariable.SaberTimesChampionsFinal();
            PtsEquipeChampionsFinal=globalVariable.SaberPtsEquipeChampionsFinal();}

        //MOSTRA TODAS AS RODADAS
        if(ano>2020 && rodada<rodadaOitavas ){
            //PRINTA OITAVAS
            for(int i=1;i<=16;i++) {
                timea=i;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,8,rootView);}
            //PRINTA QUARTAS
            for(int i=17;i<=24;i++) {
                timea=i-16;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,4,rootView);}
            //PRINTA SEMIFINAL
            for(int i=25;i<=28;i++) {
                timea=i-24;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,2,rootView);}
            //PRINTA FINAL
            for(int i=29;i<=30;i++) {
                timea=i-28;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,1,rootView);}
        }

        //PRINTA OITAVAS
        if(ano>2020 || rodada>=rodadaOitavas ){//garante que não printa até a 1ªchampions
            if(rodada>=rodadaQuartas || rodada<rodadaOitavas){
                for(int i=1;i<=16;i++) {
                    timea=i;
                    golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                    golsMarcados=golsMarcadosMataMataChampions.get(i);
                    tabela(i,1,8,rootView);}}
            //PRINTA QUARTAS
            if(rodada>=rodadaSemi || rodada<rodadaOitavas){
                for(int i=17;i<=24;i++) {
                    timea=i-16;
                    golsMarcados=golsMarcadosMataMataChampions.get(i);
                    tabela(i,1,4,rootView);}}
            //PRINTA SEMIFINAL
            if(rodada>=rodadaFinal || rodada<rodadaOitavas){
                for(int i=25;i<=28;i++) {
                    timea=i-24;
                    timesChampionsSemifinal=globalVariable.SaberTimesChampionsSemifinal();
                    golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                    golsMarcados=golsMarcadosMataMataChampions.get(i);
                    tabela(i,1,2,rootView);}}
        }

        /////////////////////////////////////////////////////////////////////////////////////
        //APAGA O TEXTO DESNECESSARIO do título de quartas, semi e final dependendo da fase
/////////////////////////////////////////////////////////////////////////////////////
        if(rodada==rodadaOitavas){
            textoNomeTime =  rootView.findViewById(R.id.textoQuartas);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x9);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x10);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x11);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x12);
            textoNomeTime.setText("");}
        if(rodada==rodadaQuartas || rodada==rodadaOitavas){
            textoNomeTime =  rootView.findViewById(R.id.textoSemifinal);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x14);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x13);
            textoNomeTime.setText("");}
        if(rodada==rodadaQuartas || rodada==rodadaSemi || rodada ==rodadaOitavas){
            textoNomeTime =  rootView.findViewById(R.id.textoFinal);
            textoNomeTime.setText("");
            textoNomeTime =  rootView.findViewById(R.id.x15);
            textoNomeTime.setText("");}

        botaoMenu = rootView.findViewById(R.id.botaoMenu);
        botaoMenu.setVisibility(View.GONE);
        return rootView;
    }




    public void PrintarTime(Integer id,Integer GMouGS, Integer Fase){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        if(Fase==8){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsOitavas.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsOitavas.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsOitavas.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsOitavas.get(timeb));
                textoGolsMarcados.setText(" "+String.valueOf(golsSofridos)+" ");}}

        if(Fase==4){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsQuartas.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsQuartas.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsQuartas.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsQuartas.get(timeb));
                textoGolsMarcados.setText(" "+String.valueOf(golsSofridos)+" ");}}

        if(Fase==2){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsSemifinal.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsSemifinal.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsSemifinal.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsSemifinal.get(timeb));
                textoGolsMarcados.setText(" "+String.valueOf(golsSofridos)+" ");}}

        if(Fase==1){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsFinal.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsFinal.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsFinal.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsFinal.get(timeb));
                textoGolsMarcados.setText(" "+String.valueOf(golsSofridos)+" ");}}

    }
    public void tabela(Integer id,Integer GMouGS, Integer Fase, View rootView){
         /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TABELA //
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //GRUPO A
        if(id==1){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1);
            imagemTime = rootView.findViewById(R.id.logo1);PrintarTime(id,GMouGS, Fase);
        }
        if(id==2){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1B);
            imagemTime = rootView.findViewById(R.id.logo1B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==3){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2);
            imagemTime = rootView.findViewById(R.id.logo2);PrintarTime(id,GMouGS, Fase);
        }
        if(id==4){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2B);
            imagemTime = rootView.findViewById(R.id.logo2B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==5){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3);
            imagemTime = rootView.findViewById(R.id.logo3);PrintarTime(id,GMouGS, Fase);
        }
        if(id==6){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3B);
            imagemTime = rootView.findViewById(R.id.logo3B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==7){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4);
            imagemTime = rootView.findViewById(R.id.logo4);PrintarTime(id,GMouGS, Fase);
        }
        if(id==8){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4B);
            imagemTime = rootView.findViewById(R.id.logo4B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==9){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime5);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols5);
            imagemTime = rootView.findViewById(R.id.logo5);PrintarTime(id,GMouGS, Fase);
        }
        if(id==10){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime5B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols5B);
            imagemTime = rootView.findViewById(R.id.logo5B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==11){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime6);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols6);
            imagemTime = rootView.findViewById(R.id.logo6);PrintarTime(id,GMouGS, Fase);
        }
        if(id==12){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime6B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols6B);
            imagemTime = rootView.findViewById(R.id.logo6B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==13){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime7);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols7);
            imagemTime = rootView.findViewById(R.id.logo7);PrintarTime(id,GMouGS, Fase);
        }
        if(id==14){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime7B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols7B);
            imagemTime = rootView.findViewById(R.id.logo7B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==15){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime8);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols8);
            imagemTime = rootView.findViewById(R.id.logo8);PrintarTime(id,GMouGS, Fase);
        }
        if(id==16){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime8B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols8B);
            imagemTime = rootView.findViewById(R.id.logo8B);PrintarTime(id,GMouGS, Fase);
        }
//QUARTAS
        if(id==17){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime9);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols9);
            imagemTime = rootView.findViewById(R.id.logo9);PrintarTime(id,GMouGS, Fase);        }
        if(id==18){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime9B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols9B);
            imagemTime = rootView.findViewById(R.id.logo9B);PrintarTime(id,GMouGS, Fase);        }
        if(id==19){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime10);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols10);
            imagemTime = rootView.findViewById(R.id.logo10);PrintarTime(id,GMouGS, Fase);        }
        if(id==20){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime10B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols10B);
            imagemTime = rootView.findViewById(R.id.logo10B);PrintarTime(id,GMouGS, Fase);        }
        if(id==21){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime11);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols11);
            imagemTime = rootView.findViewById(R.id.logo11);PrintarTime(id,GMouGS, Fase);        }
        if(id==22){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime11B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols11B);
            imagemTime = rootView.findViewById(R.id.logo11B);PrintarTime(id,GMouGS, Fase);        }
        if(id==23){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime12);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols12);
            imagemTime = rootView.findViewById(R.id.logo12);PrintarTime(id,GMouGS, Fase);        }
        if(id==24){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime12B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols12B);
            imagemTime = rootView.findViewById(R.id.logo12B);PrintarTime(id,GMouGS, Fase);        }
//SEMIFINAL
        if(id==25){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime13);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols13);
            imagemTime = rootView.findViewById(R.id.logo13);PrintarTime(id,GMouGS, Fase);        }
        if(id==26){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime13B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols13B);
            imagemTime = rootView.findViewById(R.id.logo13B);PrintarTime(id,GMouGS, Fase);        }
        if(id==27){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime14);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols14);
            imagemTime = rootView.findViewById(R.id.logo14);PrintarTime(id,GMouGS, Fase);        }
        if(id==28){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime14B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols14B);
            imagemTime = rootView.findViewById(R.id.logo14B);PrintarTime(id,GMouGS, Fase);        }
//FINAL
        if(id==29){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime15);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols15);
            imagemTime = rootView.findViewById(R.id.logo15);PrintarTime(id,GMouGS, Fase);        }
        if(id==30){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime15B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols15B);
            imagemTime = rootView.findViewById(R.id.logo15B);PrintarTime(id,GMouGS, Fase);        }
        /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //TABELA
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public Integer SimulaResultado(Integer PtsEquipe, Integer PtsEquipeAdversario){
        //SIMULAÇÃO RESULTADO
        if(PtsEquipe-PtsEquipeAdversario>=6)                                    {vitoria=125;}
        if(PtsEquipe-PtsEquipeAdversario<6 && PtsEquipe-PtsEquipeAdversario>=4){vitoria=85;}
        if(PtsEquipe-PtsEquipeAdversario<4 && PtsEquipe-PtsEquipeAdversario>=2){vitoria=70;}
        if(PtsEquipe-PtsEquipeAdversario<=1 && PtsEquipe-PtsEquipeAdversario>=-1) {vitoria=50;}
        if(PtsEquipe-PtsEquipeAdversario<=-2 && PtsEquipe-PtsEquipeAdversario>-4){vitoria=30;}
        if(PtsEquipe-PtsEquipeAdversario<=-4 && PtsEquipe-PtsEquipeAdversario>-6){vitoria=15;}
        if(PtsEquipe-PtsEquipeAdversario<=-6)                                     {vitoria=5;}

        resultado = new Random().nextInt(100)+1;
        if(resultado<=vitoria){Venceu=1;}
        if(resultado>vitoria){Venceu=-1;}
        return Venceu;
    }
    public void SimulaGols(Integer Venceu){
        golsMarcados = new Random().nextInt(3);
        golsSofridos = new Random().nextInt(3);
        if(Venceu==1){while(golsMarcados<=golsSofridos){golsMarcados = new Random().nextInt(5);}}
        if(Venceu==-1){while(golsMarcados>=golsSofridos){golsSofridos = new Random().nextInt(4)+1; golsMarcados = new Random().nextInt(3);}}
    }
}
