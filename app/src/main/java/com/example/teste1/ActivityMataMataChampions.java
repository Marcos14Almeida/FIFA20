package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teste1.fragments.PageFragment1;
import com.example.teste1.fragments.PageFragment2;

import java.util.ArrayList;
import java.util.Random;

public class ActivityMataMataChampions extends AppCompatActivity {
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

    int qualcampeonato;
    ArrayList<String> timesChampionsOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsOitavas = new ArrayList<>();
    ArrayList<String> timesChampionsQuartas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsQuartas = new ArrayList<>();
    ArrayList<String> timesChampionsSemifinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsSemifinal = new ArrayList<>();
    ArrayList<String> timesChampionsFinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsFinal = new ArrayList<>();
    ArrayList<Integer> golsMarcadosMataMataChampions = new ArrayList<>();

    ArrayList<String> timesLibertadoresOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresOitavas = new ArrayList<>();
    ArrayList<String> timesLibertadoresQuartas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresQuartas = new ArrayList<>();
    ArrayList<String> timesLibertadoresSemifinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresSemifinal = new ArrayList<>();
    ArrayList<String> timesLibertadoresFinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresFinal = new ArrayList<>();
    ArrayList<Integer> golsMarcadosMataMataLibertadores = new ArrayList<>();
    int rodadaOitavas=22,rodadaQuartas=23,rodadaSemi=24,rodadaFinal=25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mata_mata_champions);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
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

        golsMarcadosMataMataLibertadores=globalVariable.SaberGolsMarcadosMataMataLibertadores();
        timesLibertadoresOitavas=globalVariable.SaberTimesLibertadoresOitavas();
        PtsEquipeLibertadoresOitavas=globalVariable.SaberPtsEquipeLibertadoresOitavas();
        if(rodada!=rodadaOitavas){//se não atualiza o vetor errado
            timesLibertadoresQuartas=globalVariable.SaberTimesLibertadoresQuartas();
            PtsEquipeLibertadoresQuartas=globalVariable.SaberPtsEquipeLibertadoresQuartas();}
        if(rodada!=rodadaQuartas){//se não atualiza o vetor errado
            timesLibertadoresSemifinal=globalVariable.SaberTimesLibertadoresSemifinal();
            PtsEquipeLibertadoresSemifinal=globalVariable.SaberPtsEquipeLibertadoresSemifinal();}
        if(rodada!=rodadaSemi){//se não atualiza o vetor errado
            timesLibertadoresFinal=globalVariable.SaberTimesLibertadoresFinal();
            PtsEquipeLibertadoresFinal=globalVariable.SaberPtsEquipeLibertadoresFinal();}


            /////////////////////////////////////////////////////////////////////////////////////
                    // SIMULA RESULTADOS  //
            /////////////////////////////////////////////////////////////////////////////////////
        //MOSTRA TODAS AS RODADAS
        if(ano>2020 && rodada<rodadaOitavas ){
            //PRINTA OITAVAS
            for(int i=1;i<=16;i++) {
                timea=i;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,8);}
            //PRINTA QUARTAS
            for(int i=17;i<=24;i++) {
                timea=i-16;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,4);}
            //PRINTA SEMIFINAL
            for(int i=25;i<=28;i++) {
                timea=i-24;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,2);}
            //PRINTA FINAL
            for(int i=29;i<=30;i++) {
                timea=i-28;
                golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
                golsMarcados=golsMarcadosMataMataChampions.get(i);
                tabela(i,1,1);}
        }


        //PRINTA OITAVAS
        if(ano>2020 || rodada>=rodadaOitavas ){//garante que não printa até a 1ªchampions
        if(rodada>=rodadaQuartas || rodada<rodadaOitavas){
        for(int i=1;i<=16;i++) {
            timea=i;
            golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
            golsMarcados=golsMarcadosMataMataChampions.get(i);
            tabela(i,1,8);}}
        //PRINTA QUARTAS
        if(rodada>=rodadaSemi || rodada<rodadaOitavas){
        for(int i=17;i<=24;i++) {
            timea=i-16;
            golsMarcados=golsMarcadosMataMataChampions.get(i);
            tabela(i,1,4);}}
        //PRINTA SEMIFINAL
        if(rodada>=rodadaFinal || rodada<rodadaOitavas){
        for(int i=25;i<=28;i++) {
            timea=i-24;
            timesChampionsSemifinal=globalVariable.SaberTimesChampionsSemifinal();
            golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();
            golsMarcados=golsMarcadosMataMataChampions.get(i);
            tabela(i,1,2);}}
        }

//////CHAMPIONS LEAGUE////////////////////
        //SIMULA OITAVAS
        if(rodada==rodadaOitavas && globalVariable.SaberMinhaPosicaoMataMata()<0){
            timesChampionsQuartas.add(""); //cria times das quartas
            PtsEquipeChampionsQuartas.add(0);
            for(int i=1;i<=16;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesChampionsOitavas.get(timeb);
                PtsEquipeAdversario=PtsEquipeChampionsOitavas.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultado(PtsEquipeChampionsOitavas.get(timea),PtsEquipeAdversario);
                pontosA=0;pontosB=0;
                if (Venceu==1){
                    timesChampionsQuartas.add(timesChampionsOitavas.get(timea));PtsEquipeChampionsQuartas.add(PtsEquipeChampionsOitavas.get(timea));}
                if (Venceu==-1){
                    timesChampionsQuartas.add(timesChampionsOitavas.get(timeb));PtsEquipeChampionsQuartas.add(PtsEquipeChampionsOitavas.get(timeb));}
                globalVariable.DefinirTimesChampionsQuartas(timesChampionsQuartas);
                globalVariable.DefinirPtsEquipeChampionsQuartas(PtsEquipeChampionsQuartas);
                SimulaGols(Venceu);
                globalVariable.DefinirGolsMataMataChampions(golsMarcados, timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataChampions(golsSofridos, timeb); //define os gols marcados por b
                tabela(timea,1,8);
                tabela(timeb,2,8);
            }
        }
        //SIMULA QUARTAS
        if(rodada==rodadaQuartas && globalVariable.SaberMinhaPosicaoMataMata()<0){

                timesChampionsSemifinal.add(""); //cria times das quartas
                PtsEquipeChampionsSemifinal.add(0);
                for(int i=1;i<=8;i=i+2){
                    timea=i;timeb=i+1;
                    adversario=timesChampionsQuartas.get(timeb);
                    PtsEquipeAdversario=PtsEquipeChampionsQuartas.get(timeb);
                    //PontuaçãoA x Pontuação adversarioB
                    Venceu = SimulaResultado(PtsEquipeChampionsQuartas.get(timea),PtsEquipeAdversario);
                    pontosA=0;pontosB=0;
                    if (Venceu==1){
                        timesChampionsSemifinal.add(timesChampionsQuartas.get(timea));PtsEquipeChampionsSemifinal.add(PtsEquipeChampionsQuartas.get(timea));}
                    if (Venceu==-1){
                        timesChampionsSemifinal.add(timesChampionsQuartas.get(timeb));PtsEquipeChampionsSemifinal.add(PtsEquipeChampionsQuartas.get(timeb));}
                    globalVariable.DefinirTimesChampionsSemi(timesChampionsSemifinal);
                    globalVariable.DefinirPtsEquipeChampionsSemifinal(PtsEquipeChampionsSemifinal);
                    SimulaGols(Venceu);
                    globalVariable.DefinirGolsMataMataChampions(golsMarcados, 16+timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataChampions(golsSofridos, 16+timeb); //define os gols marcados por b
                    tabela(16+timea,1,4);
                    tabela(16+timeb,2,4);
                }
            }

        ////SIMULA SEMI
        if(rodada==rodadaSemi && globalVariable.SaberMinhaPosicaoMataMata()<0){
            golsMarcadosMataMataChampions=globalVariable.SaberGolsMarcadosMataMataChampions();

            timesChampionsFinal.add(""); //cria times da FINAL
            PtsEquipeChampionsFinal.add(0);
            for(int i=1;i<=4;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesChampionsSemifinal.get(timeb);
                PtsEquipeAdversario=PtsEquipeChampionsSemifinal.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultado(PtsEquipeChampionsSemifinal.get(timea),PtsEquipeAdversario);
                pontosA=0;pontosB=0;
                if (Venceu==1){
                    timesChampionsFinal.add(timesChampionsSemifinal.get(timea));PtsEquipeChampionsFinal.add(PtsEquipeChampionsSemifinal.get(timea));}
                if (Venceu==-1){
                    timesChampionsFinal.add(timesChampionsSemifinal.get(timeb));PtsEquipeChampionsFinal.add(PtsEquipeChampionsSemifinal.get(timeb));}
                globalVariable.DefinirTimesChampionsFinal(timesChampionsFinal);
                globalVariable.DefinirPtsEquipeChampionsFinal(PtsEquipeChampionsFinal);
                SimulaGols(Venceu);
                globalVariable.DefinirGolsMataMataChampions(golsMarcados, 24+timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataChampions(golsSofridos, 24+timeb); //define os gols marcados por b
                tabela(24+timea,1,2);
                tabela(24+timeb,2,2);
            }
        }

        ////SIMULA FINAL
        if(rodada==rodadaFinal && globalVariable.SaberMinhaPosicaoMataMata()<0){

                timea=1;timeb=2;
                adversario=timesChampionsFinal.get(timeb);
                PtsEquipeAdversario=PtsEquipeChampionsFinal.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultado(PtsEquipeChampionsFinal.get(timea),PtsEquipeAdversario);
                timesChampionsFinal.add(""); //cria times da FINAL
                PtsEquipeChampionsFinal.add(0);
                if (Venceu==1){
                    timesChampionsFinal.add(timesChampionsFinal.get(timea));PtsEquipeChampionsFinal.add(PtsEquipeChampionsFinal.get(timea));}
                if (Venceu==-1){ //Se o time b for campeão
                    timesChampionsFinal.add(timesChampionsFinal.get(timeb));PtsEquipeChampionsFinal.add(PtsEquipeChampionsFinal.get(timeb));}
                globalVariable.DefinirTimesChampionsFinal(timesChampionsFinal);
                globalVariable.DefinirPtsEquipeChampionsFinal(PtsEquipeChampionsFinal);
                SimulaGols(Venceu);
                if(Venceu==1){
                globalVariable.DefinirGolsMataMataChampions(golsMarcados, 28+timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataChampions(golsSofridos, 28+timeb); //define os gols marcados por b
                tabela(28+timea,1,1);
                tabela(28+timeb,2,1);}
                else{
                    globalVariable.DefinirGolsMataMataChampions(golsSofridos, 28+timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataChampions(golsMarcados, 28+timeb); //define os gols marcados por b
                    tabela(28+timea,2,1);
                    tabela(28+timeb,1,1);
                    String stringAuxiliar=timesChampionsFinal.get(1);timesChampionsFinal.set(1,timesChampionsFinal.get(2));timesChampionsFinal.set(2,stringAuxiliar);}
            }
//////LIBERTADORES////////////////////
        //SIMULA OITAVAS
        if(rodada==rodadaOitavas && globalVariable.SaberMinhaPosicaoMataMata()<0){
            timesLibertadoresQuartas.add(""); //cria times das quartas
            PtsEquipeLibertadoresQuartas.add(0);
            for(int i=1;i<=16;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesLibertadoresOitavas.get(timeb);
                PtsEquipeAdversario=PtsEquipeLibertadoresOitavas.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultado(PtsEquipeLibertadoresOitavas.get(timea),PtsEquipeAdversario);
                pontosA=0;pontosB=0;
                if (Venceu==1){
                    timesLibertadoresQuartas.add(timesLibertadoresOitavas.get(timea));PtsEquipeLibertadoresQuartas.add(PtsEquipeLibertadoresOitavas.get(timea));}
                if (Venceu==-1){
                    timesLibertadoresQuartas.add(timesLibertadoresOitavas.get(timeb));PtsEquipeLibertadoresQuartas.add(PtsEquipeLibertadoresOitavas.get(timeb));}
                globalVariable.DefinirTimesLibertadoresQuartas(timesLibertadoresQuartas);
                globalVariable.DefinirPtsEquipeLibertadoresQuartas(PtsEquipeLibertadoresQuartas);
                SimulaGols(Venceu);
                globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, timeb); //define os gols marcados por b
                //tabela(timea,1,8);
                //tabela(timeb,2,8);
            }
        }
        //SIMULA QUARTAS
        if(rodada==rodadaQuartas && globalVariable.SaberMinhaPosicaoMataMata()<0){

            timesLibertadoresSemifinal.add(""); //cria times das quartas
            PtsEquipeLibertadoresSemifinal.add(0);
            for(int i=1;i<=8;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesLibertadoresQuartas.get(timeb);
                PtsEquipeAdversario=PtsEquipeLibertadoresQuartas.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultado(PtsEquipeLibertadoresQuartas.get(timea),PtsEquipeAdversario);
                pontosA=0;pontosB=0;
                if (Venceu==1){
                    timesLibertadoresSemifinal.add(timesLibertadoresQuartas.get(timea));PtsEquipeLibertadoresSemifinal.add(PtsEquipeLibertadoresQuartas.get(timea));}
                if (Venceu==-1){
                    timesLibertadoresSemifinal.add(timesLibertadoresQuartas.get(timeb));PtsEquipeLibertadoresSemifinal.add(PtsEquipeLibertadoresQuartas.get(timeb));}
                globalVariable.DefinirTimesLibertadoresSemi(timesLibertadoresSemifinal);
                globalVariable.DefinirPtsEquipeLibertadoresSemifinal(PtsEquipeLibertadoresSemifinal);
                SimulaGols(Venceu);
                globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, 16+timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, 16+timeb); //define os gols marcados por b
                //tabela(16+timea,1,4);
                //tabela(16+timeb,2,4);
            }
        }

        ////SIMULA SEMI
        if(rodada==rodadaSemi && globalVariable.SaberMinhaPosicaoMataMata()<0){
            golsMarcadosMataMataLibertadores=globalVariable.SaberGolsMarcadosMataMataLibertadores();

            timesLibertadoresFinal.add(""); //cria times da FINAL
            PtsEquipeLibertadoresFinal.add(0);
            for(int i=1;i<=4;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesLibertadoresSemifinal.get(timeb);
                PtsEquipeAdversario=PtsEquipeLibertadoresSemifinal.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultado(PtsEquipeLibertadoresSemifinal.get(timea),PtsEquipeAdversario);
                pontosA=0;pontosB=0;
                if (Venceu==1){
                    timesLibertadoresFinal.add(timesLibertadoresSemifinal.get(timea));PtsEquipeLibertadoresFinal.add(PtsEquipeLibertadoresSemifinal.get(timea));}
                if (Venceu==-1){
                    timesLibertadoresFinal.add(timesLibertadoresSemifinal.get(timeb));PtsEquipeLibertadoresFinal.add(PtsEquipeLibertadoresSemifinal.get(timeb));}
                globalVariable.DefinirTimesLibertadoresFinal(timesLibertadoresFinal);
                globalVariable.DefinirPtsEquipeLibertadoresFinal(PtsEquipeLibertadoresFinal);
                SimulaGols(Venceu);
                globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, 24+timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, 24+timeb); //define os gols marcados por b
                //tabela(24+timea,1,2);
                //tabela(24+timeb,2,2);
            }
        }

        ////SIMULA FINAL
        if(rodada==rodadaFinal && globalVariable.SaberMinhaPosicaoMataMata()<0){

            timea=1;timeb=2;
            adversario=timesLibertadoresFinal.get(timeb);
            PtsEquipeAdversario=PtsEquipeLibertadoresFinal.get(timeb);
            //PontuaçãoA x Pontuação adversarioB
            Venceu = SimulaResultado(PtsEquipeLibertadoresFinal.get(timea),PtsEquipeAdversario);
            timesLibertadoresFinal.add(""); //cria times da FINAL
            PtsEquipeLibertadoresFinal.add(0);
            if (Venceu==1){
                timesLibertadoresFinal.add(timesLibertadoresFinal.get(timea));PtsEquipeLibertadoresFinal.add(PtsEquipeLibertadoresFinal.get(timea));}
            if (Venceu==-1){ //Se o time b for campeão
                timesLibertadoresFinal.add(timesLibertadoresFinal.get(timeb));PtsEquipeLibertadoresFinal.add(PtsEquipeLibertadoresFinal.get(timeb));}
            globalVariable.DefinirTimesLibertadoresFinal(timesLibertadoresFinal);
            globalVariable.DefinirPtsEquipeLibertadoresFinal(PtsEquipeLibertadoresFinal);
            SimulaGols(Venceu);
            if(Venceu==1){
                globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, 28+timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, 28+timeb); //define os gols marcados por b
                //tabela(28+timea,1,1);
                //tabela(28+timeb,2,1);
                }
            else{
                globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, 28+timea); //define os gols marcados por a
                globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, 28+timeb); //define os gols marcados por b
                //tabela(28+timea,2,1);
                //tabela(28+timeb,1,1);
                String stringAuxiliar=timesLibertadoresFinal.get(1);timesLibertadoresFinal.set(1,timesLibertadoresFinal.get(2));timesLibertadoresFinal.set(2,stringAuxiliar);}
        }

/////////////////////////////////////////////////////////////////////////////////////
        //APAGA O TEXTO DESNECESSARIO do título de quartas, semi e final dependendo da fase
/////////////////////////////////////////////////////////////////////////////////////
        if(rodada==rodadaOitavas){
        textoNomeTime =  findViewById(R.id.textoQuartas);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x9);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x10);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x11);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x12);
        textoNomeTime.setText("");}
        if(rodada==rodadaQuartas || rodada==rodadaOitavas){
        textoNomeTime =  findViewById(R.id.textoSemifinal);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x14);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x13);
        textoNomeTime.setText("");}
        if(rodada==rodadaQuartas || rodada==rodadaSemi || rodada ==rodadaOitavas){
        textoNomeTime =  findViewById(R.id.textoFinal);
        textoNomeTime.setText("");
        textoNomeTime =  findViewById(R.id.x15);
        textoNomeTime.setText("");}




///////////////////////////////////////////////////////////////////////////////////
        //FINAL
///////////////////////////////////////////////////////////////////////////////////
        if(rodada>=rodadaOitavas && globalVariable.SaberMinhaPosicaoMataMata()<0){
        rodada++;
        globalVariable.DefinirRodada(rodada);
        }
    }









    public void abrirActivity_Menu(View view){
            Intent intent = new Intent(getApplicationContext(), Activity4.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
    }
    public void PrintarTime(Integer id,Integer GMouGS, Integer Fase){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if(Fase==8){
        if(GMouGS==1){
            globalVariable.imageLogo(timesChampionsOitavas.get(timea),imagemTime);
            textoNomeTime.setText(timesChampionsOitavas.get(timea));
            textoGolsMarcados.setText(String.valueOf(golsMarcados));}
        if(GMouGS==2){
            globalVariable.imageLogo(timesChampionsOitavas.get(timeb),imagemTime);
            textoNomeTime.setText(timesChampionsOitavas.get(timeb));
            textoGolsMarcados.setText(String.valueOf(golsSofridos));}}

        if(Fase==4){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsQuartas.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsQuartas.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsQuartas.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsQuartas.get(timeb));
                textoGolsMarcados.setText(String.valueOf(golsSofridos));}}

        if(Fase==2){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsSemifinal.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsSemifinal.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsSemifinal.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsSemifinal.get(timeb));
                textoGolsMarcados.setText(String.valueOf(golsSofridos));}}

        if(Fase==1){
            if(GMouGS==1){
                globalVariable.imageLogo(timesChampionsFinal.get(timea),imagemTime);
                textoNomeTime.setText(timesChampionsFinal.get(timea));
                textoGolsMarcados.setText(String.valueOf(golsMarcados));}
            if(GMouGS==2){
                globalVariable.imageLogo(timesChampionsFinal.get(timeb),imagemTime);
                textoNomeTime.setText(timesChampionsFinal.get(timeb));
                textoGolsMarcados.setText(String.valueOf(golsSofridos));}}

    }
    public void tabela(Integer id,Integer GMouGS, Integer Fase){
         /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TABELA //
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //GRUPO A
        if(id==1){
            textoNomeTime =  findViewById(R.id.nomeTime1);
            textoGolsMarcados = findViewById(R.id.textoGols1);
            imagemTime = findViewById(R.id.logo1);PrintarTime(id,GMouGS, Fase);
        }
        if(id==2){
            textoNomeTime =  findViewById(R.id.nomeTime1B);
            textoGolsMarcados = findViewById(R.id.textoGols1B);
            imagemTime = findViewById(R.id.logo1B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==3){
            textoNomeTime =  findViewById(R.id.nomeTime2);
            textoGolsMarcados = findViewById(R.id.textoGols2);
            imagemTime = findViewById(R.id.logo2);PrintarTime(id,GMouGS, Fase);
        }
        if(id==4){
            textoNomeTime =  findViewById(R.id.nomeTime2B);
            textoGolsMarcados = findViewById(R.id.textoGols2B);
            imagemTime = findViewById(R.id.logo2B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==5){
            textoNomeTime =  findViewById(R.id.nomeTime3);
            textoGolsMarcados = findViewById(R.id.textoGols3);
            imagemTime = findViewById(R.id.logo3);PrintarTime(id,GMouGS, Fase);
        }
        if(id==6){
            textoNomeTime =  findViewById(R.id.nomeTime3B);
            textoGolsMarcados = findViewById(R.id.textoGols3B);
            imagemTime = findViewById(R.id.logo3B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==7){
            textoNomeTime =  findViewById(R.id.nomeTime4);
            textoGolsMarcados = findViewById(R.id.textoGols4);
            imagemTime = findViewById(R.id.logo4);PrintarTime(id,GMouGS, Fase);
        }
        if(id==8){
            textoNomeTime =  findViewById(R.id.nomeTime4B);
            textoGolsMarcados = findViewById(R.id.textoGols4B);
            imagemTime = findViewById(R.id.logo4B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==9){
            textoNomeTime =  findViewById(R.id.nomeTime5);
            textoGolsMarcados = findViewById(R.id.textoGols5);
            imagemTime = findViewById(R.id.logo5);PrintarTime(id,GMouGS, Fase);
        }
        if(id==10){
            textoNomeTime =  findViewById(R.id.nomeTime5B);
            textoGolsMarcados = findViewById(R.id.textoGols5B);
            imagemTime = findViewById(R.id.logo5B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==11){
            textoNomeTime =  findViewById(R.id.nomeTime6);
            textoGolsMarcados = findViewById(R.id.textoGols6);
            imagemTime = findViewById(R.id.logo6);PrintarTime(id,GMouGS, Fase);
        }
        if(id==12){
            textoNomeTime =  findViewById(R.id.nomeTime6B);
            textoGolsMarcados = findViewById(R.id.textoGols6B);
            imagemTime = findViewById(R.id.logo6B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==13){
            textoNomeTime =  findViewById(R.id.nomeTime7);
            textoGolsMarcados = findViewById(R.id.textoGols7);
            imagemTime = findViewById(R.id.logo7);PrintarTime(id,GMouGS, Fase);
        }
        if(id==14){
            textoNomeTime =  findViewById(R.id.nomeTime7B);
            textoGolsMarcados = findViewById(R.id.textoGols7B);
            imagemTime = findViewById(R.id.logo7B);PrintarTime(id,GMouGS, Fase);
        }
        if(id==15){
            textoNomeTime =  findViewById(R.id.nomeTime8);
            textoGolsMarcados = findViewById(R.id.textoGols8);
            imagemTime = findViewById(R.id.logo8);PrintarTime(id,GMouGS, Fase);
        }
        if(id==16){
            textoNomeTime =  findViewById(R.id.nomeTime8B);
            textoGolsMarcados = findViewById(R.id.textoGols8B);
            imagemTime = findViewById(R.id.logo8B);PrintarTime(id,GMouGS, Fase);
        }
//QUARTAS
        if(id==17){
            textoNomeTime =  findViewById(R.id.nomeTime9);
            textoGolsMarcados = findViewById(R.id.textoGols9);
            imagemTime = findViewById(R.id.logo9);PrintarTime(id,GMouGS, Fase);        }
        if(id==18){
            textoNomeTime =  findViewById(R.id.nomeTime9B);
            textoGolsMarcados = findViewById(R.id.textoGols9B);
            imagemTime = findViewById(R.id.logo9B);PrintarTime(id,GMouGS, Fase);        }
        if(id==19){
            textoNomeTime =  findViewById(R.id.nomeTime10);
            textoGolsMarcados = findViewById(R.id.textoGols10);
            imagemTime = findViewById(R.id.logo10);PrintarTime(id,GMouGS, Fase);        }
        if(id==20){
            textoNomeTime =  findViewById(R.id.nomeTime10B);
            textoGolsMarcados = findViewById(R.id.textoGols10B);
            imagemTime = findViewById(R.id.logo10B);PrintarTime(id,GMouGS, Fase);        }
        if(id==21){
            textoNomeTime =  findViewById(R.id.nomeTime11);
            textoGolsMarcados = findViewById(R.id.textoGols11);
            imagemTime = findViewById(R.id.logo11);PrintarTime(id,GMouGS, Fase);        }
        if(id==22){
            textoNomeTime =  findViewById(R.id.nomeTime11B);
            textoGolsMarcados = findViewById(R.id.textoGols11B);
            imagemTime = findViewById(R.id.logo11B);PrintarTime(id,GMouGS, Fase);        }
        if(id==23){
            textoNomeTime =  findViewById(R.id.nomeTime12);
            textoGolsMarcados = findViewById(R.id.textoGols12);
            imagemTime = findViewById(R.id.logo12);PrintarTime(id,GMouGS, Fase);        }
        if(id==24){
            textoNomeTime =  findViewById(R.id.nomeTime12B);
            textoGolsMarcados = findViewById(R.id.textoGols12B);
            imagemTime = findViewById(R.id.logo12B);PrintarTime(id,GMouGS, Fase);        }
//SEMIFINAL
        if(id==25){
            textoNomeTime =  findViewById(R.id.nomeTime13);
            textoGolsMarcados = findViewById(R.id.textoGols13);
            imagemTime = findViewById(R.id.logo13);PrintarTime(id,GMouGS, Fase);        }
        if(id==26){
            textoNomeTime =  findViewById(R.id.nomeTime13B);
            textoGolsMarcados = findViewById(R.id.textoGols13B);
            imagemTime = findViewById(R.id.logo13B);PrintarTime(id,GMouGS, Fase);        }
        if(id==27){
            textoNomeTime =  findViewById(R.id.nomeTime14);
            textoGolsMarcados = findViewById(R.id.textoGols14);
            imagemTime = findViewById(R.id.logo14);PrintarTime(id,GMouGS, Fase);        }
        if(id==28){
            textoNomeTime =  findViewById(R.id.nomeTime14B);
            textoGolsMarcados = findViewById(R.id.textoGols14B);
            imagemTime = findViewById(R.id.logo14B);PrintarTime(id,GMouGS, Fase);        }
//FINAL
        if(id==29){
            textoNomeTime =  findViewById(R.id.nomeTime15);
            textoGolsMarcados = findViewById(R.id.textoGols15);
            imagemTime = findViewById(R.id.logo15);PrintarTime(id,GMouGS, Fase);        }
        if(id==30){
            textoNomeTime =  findViewById(R.id.nomeTime15B);
            textoGolsMarcados = findViewById(R.id.textoGols15B);
            imagemTime = findViewById(R.id.logo15B);PrintarTime(id,GMouGS, Fase);        }
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
