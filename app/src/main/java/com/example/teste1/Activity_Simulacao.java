package com.example.teste1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Activity_Simulacao extends Activity{
    Button botaoMenu,botaoProximo;
    MediaPlayer mp;
    SeekBar seekBar;
    int pausa;
    int MeuGolMarcado=0, MeuGolSofrido=0;
    int rodada,campeonato,PtsEquipeAdversario,posicao;
    int vitoria,empate,resultado,Venceu;
    int golsMarcados,golsSofridos;
    int max=16,max2=8,ano;
    int rodadaOitavas=22,rodadaQuartas=23,rodadaSemi=24,rodadaFinal=25;
    int timea=0, timeb=0;
    int pontosA=0,pontosB=0;
    float dinheiro;
    int indexAdversarioMataMata;
    String meutime,adversario;
    String timeFoto;
    ArrayList<String> times = new ArrayList<>();
    ArrayList<Integer> chave = new ArrayList<>();
    ArrayList<Integer> PtsEquipe = new ArrayList<>();
    ArrayList<String> timesOrdem;

    int minhaposicaoChampions,meuGrupoChampions,qualcampeonato;
    int minhaposicaoLibertadores,meuGrupoLibertadores;
    ArrayList<String> timesChampions = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampions = new ArrayList<>();
    ArrayList<Integer> pontosTotalChampions = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalChampions = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalChampions = new ArrayList<>();

    ArrayList<String> timesLibertadores = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadores = new ArrayList<>();
    ArrayList<Integer> pontosTotalLibertadores = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalLibertadores = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalLibertadores = new ArrayList<>();

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

    int posturaDoTime=1;
    int mili=0;Integer PtsEquipeAuxiliar;
    TextView textoCronometro;
    TextView textoPlacar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__simulacao);

        mp=MediaPlayer.create(this,R.raw.championsleagueaudio);
        mp.start();
        mp.pause();

        //GLOBAL
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

        minhaposicaoChampions=globalVariable.SaberPosicaoChampions();
        meuGrupoChampions = globalVariable.SaberMeuGrupoChampions();
        timesChampions=globalVariable.SaberTimesChampions();
        PtsEquipeChampions=globalVariable.SaberPtsEquipeChampions();
        pontosTotalChampions=globalVariable.SaberPontosTotalChampions();
        golsMarcadosTotalChampions=globalVariable.SaberGolsMarcadosTotalChampions();
        golsSofridosTotalChampions=globalVariable.SaberGolsSofridosTotalChampions();

        minhaposicaoLibertadores=globalVariable.SaberPosicaoLibertadores();
        meuGrupoLibertadores = globalVariable.SaberMeuGrupoLibertadores();
        timesLibertadores=globalVariable.SaberTimesLibertadores();
        PtsEquipeLibertadores=globalVariable.SaberPtsEquipeLibertadores();
        pontosTotalLibertadores=globalVariable.SaberPontosTotalLibertadores();
        golsMarcadosTotalLibertadores=globalVariable.SaberGolsMarcadosTotalLibertadores();
        golsSofridosTotalLibertadores=globalVariable.SaberGolsSofridosTotalLibertadores();

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

        //////////////////////////////////////////////////////////////////////////////
        //SIMULA CHAMPIONS
        //////////////////////////////////////////////////////////////////////////////
        //SIMULA  OUTROS JOGOS OITAVAS
        if(rodada==rodadaOitavas ){
            timesChampionsQuartas.add(""); //cria times das quartas
            PtsEquipeChampionsQuartas.add(0);
            for(int i=1;i<=16;i=i+2){
                    timea=i;timeb=i+1;
                    adversario=timesChampionsOitavas.get(timeb);
                    PtsEquipeAdversario=PtsEquipeChampionsOitavas.get(timeb);
                    //PontuaçãoA x Pontuação adversarioB
                    Venceu = SimulaResultadoMataMata(PtsEquipeChampionsOitavas.get(timea),PtsEquipeAdversario);
                    if (Venceu==1){
                        timesChampionsQuartas.add(timesChampionsOitavas.get(timea));PtsEquipeChampionsQuartas.add(PtsEquipeChampionsOitavas.get(timea));}
                    if (Venceu==-1){
                        timesChampionsQuartas.add(timesChampionsOitavas.get(timeb));PtsEquipeChampionsQuartas.add(PtsEquipeChampionsOitavas.get(timeb));}
                    globalVariable.DefinirTimesChampionsQuartas(timesChampionsQuartas);
                    globalVariable.DefinirPtsEquipeChampionsQuartas(PtsEquipeChampionsQuartas);
                    SimulaGols(Venceu);
                    if(timea!=globalVariable.SaberMinhaPosicaoMataMata() && timeb!=globalVariable.SaberMinhaPosicaoMataMata()){
                    globalVariable.DefinirGolsMataMataChampions(golsMarcados, timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataChampions(golsSofridos, timeb); //define os gols marcados por b
                         }
                }
        }

        //SIMULA  OUTROS JOGOS QUARTAS
        if(rodada==rodadaQuartas){
            timesChampionsQuartas=globalVariable.SaberTimesChampionsQuartas();
            PtsEquipeChampionsQuartas=globalVariable.SaberPtsEquipeChampionsQuartas();
            timesChampionsSemifinal.add(""); //cria times das quartas
            PtsEquipeChampionsSemifinal.add(0);
            for(int i=1;i<=8;i=i+2){
                    timea=i;timeb=i+1;
                    adversario=timesChampionsQuartas.get(timeb);
                    PtsEquipeAdversario=PtsEquipeChampionsQuartas.get(timeb);
                    //PontuaçãoA x Pontuação adversarioB
                    Venceu = SimulaResultadoMataMata(PtsEquipeChampionsQuartas.get(timea),PtsEquipeAdversario);
                    if (Venceu==1){
                        timesChampionsSemifinal.add(timesChampionsQuartas.get(timea));PtsEquipeChampionsSemifinal.add(PtsEquipeChampionsQuartas.get(timea));}
                    if (Venceu==-1){
                        timesChampionsSemifinal.add(timesChampionsQuartas.get(timeb));PtsEquipeChampionsSemifinal.add(PtsEquipeChampionsQuartas.get(timeb));}
                    globalVariable.DefinirTimesChampionsSemi(timesChampionsSemifinal);
                    globalVariable.DefinirPtsEquipeChampionsSemifinal(PtsEquipeChampionsSemifinal);
                    SimulaGols(Venceu);
                if(timea!=globalVariable.SaberMinhaPosicaoMataMata() && timeb!=globalVariable.SaberMinhaPosicaoMataMata()){
                    globalVariable.DefinirGolsMataMataChampions(golsMarcados, 16+timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataChampions(golsSofridos, 16+timeb); //define os gols marcados por b
                }
                }

        }

        ////SIMULA OUTROS JOGOS SEMI
        if(rodada==rodadaSemi){
            timesChampionsSemifinal=globalVariable.SaberTimesChampionsSemifinal();
            PtsEquipeChampionsSemifinal=globalVariable.SaberPtsEquipeChampionsSemifinal();
            timesChampionsFinal.add(""); //cria times da FINAL
            PtsEquipeChampionsFinal.add(0);
            for(int i=1;i<=4;i=i+2){
                    timea=i;timeb=i+1;
                    adversario=timesChampionsSemifinal.get(timeb);
                    PtsEquipeAdversario=PtsEquipeChampionsSemifinal.get(timeb);
                    //PontuaçãoA x Pontuação adversarioB
                    Venceu = SimulaResultadoMataMata(PtsEquipeChampionsSemifinal.get(timea),PtsEquipeAdversario);
                    if (Venceu==1){
                        timesChampionsFinal.add(timesChampionsSemifinal.get(timea));PtsEquipeChampionsFinal.add(PtsEquipeChampionsSemifinal.get(timea));}
                    if (Venceu==-1){
                        timesChampionsFinal.add(timesChampionsSemifinal.get(timeb));PtsEquipeChampionsFinal.add(PtsEquipeChampionsSemifinal.get(timeb));}
                    globalVariable.DefinirTimesChampionsFinal(timesChampionsFinal);
                    globalVariable.DefinirPtsEquipeChampionsFinal(PtsEquipeChampionsFinal);
                    SimulaGols(Venceu);
                if(timea!=globalVariable.SaberMinhaPosicaoMataMata() && timeb!=globalVariable.SaberMinhaPosicaoMataMata()){
                    globalVariable.DefinirGolsMataMataChampions(golsMarcados, 24+timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataChampions(golsSofridos, 24+timeb); //define os gols marcados por b
                }
                }
        }
        //////////////////////////////////////////////////////////////////////////////
        //SIMULA LIBERTADORES
        //////////////////////////////////////////////////////////////////////////////
        //SIMULA  OUTROS JOGOS OITAVAS
        if(rodada==rodadaOitavas ){
            timesLibertadoresQuartas.add(""); //cria times das quartas
            PtsEquipeLibertadoresQuartas.add(0);
            for(int i=1;i<=16;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesLibertadoresOitavas.get(timeb);
                PtsEquipeAdversario=PtsEquipeLibertadoresOitavas.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultadoMataMata(PtsEquipeLibertadoresOitavas.get(timea),PtsEquipeAdversario);
                if (Venceu==1){
                    timesLibertadoresQuartas.add(timesLibertadoresOitavas.get(timea));PtsEquipeLibertadoresQuartas.add(PtsEquipeLibertadoresOitavas.get(timea));}
                if (Venceu==-1){
                    timesLibertadoresQuartas.add(timesLibertadoresOitavas.get(timeb));PtsEquipeLibertadoresQuartas.add(PtsEquipeLibertadoresOitavas.get(timeb));}
                globalVariable.DefinirTimesLibertadoresQuartas(timesLibertadoresQuartas);
                globalVariable.DefinirPtsEquipeLibertadoresQuartas(PtsEquipeLibertadoresQuartas);
                SimulaGols(Venceu);
                if(timea!=globalVariable.SaberMinhaPosicaoMataMata() && timeb!=globalVariable.SaberMinhaPosicaoMataMata()){
                    globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, timeb); //define os gols marcados por b
                }
            }
        }

        //SIMULA  OUTROS JOGOS QUARTAS
        if(rodada==rodadaQuartas){
            timesLibertadoresQuartas=globalVariable.SaberTimesLibertadoresQuartas();
            PtsEquipeLibertadoresQuartas=globalVariable.SaberPtsEquipeLibertadoresQuartas();
            timesLibertadoresSemifinal.add(""); //cria times das quartas
            PtsEquipeLibertadoresSemifinal.add(0);
            for(int i=1;i<=8;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesLibertadoresQuartas.get(timeb);
                PtsEquipeAdversario=PtsEquipeLibertadoresQuartas.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultadoMataMata(PtsEquipeLibertadoresQuartas.get(timea),PtsEquipeAdversario);
                if (Venceu==1){
                    timesLibertadoresSemifinal.add(timesLibertadoresQuartas.get(timea));PtsEquipeLibertadoresSemifinal.add(PtsEquipeLibertadoresQuartas.get(timea));}
                if (Venceu==-1){
                    timesLibertadoresSemifinal.add(timesLibertadoresQuartas.get(timeb));PtsEquipeLibertadoresSemifinal.add(PtsEquipeLibertadoresQuartas.get(timeb));}
                globalVariable.DefinirTimesLibertadoresSemi(timesLibertadoresSemifinal);
                globalVariable.DefinirPtsEquipeLibertadoresSemifinal(PtsEquipeLibertadoresSemifinal);
                SimulaGols(Venceu);
                if(timea!=globalVariable.SaberMinhaPosicaoMataMata() && timeb!=globalVariable.SaberMinhaPosicaoMataMata()){
                    globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, 16+timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, 16+timeb); //define os gols marcados por b
                }
            }

        }

        ////SIMULA OUTROS JOGOS SEMI
        if(rodada==rodadaSemi){
            timesLibertadoresSemifinal=globalVariable.SaberTimesLibertadoresSemifinal();
            PtsEquipeLibertadoresSemifinal=globalVariable.SaberPtsEquipeLibertadoresSemifinal();
            timesLibertadoresFinal.add(""); //cria times da FINAL
            PtsEquipeLibertadoresFinal.add(0);
            for(int i=1;i<=4;i=i+2){
                timea=i;timeb=i+1;
                adversario=timesLibertadoresSemifinal.get(timeb);
                PtsEquipeAdversario=PtsEquipeLibertadoresSemifinal.get(timeb);
                //PontuaçãoA x Pontuação adversarioB
                Venceu = SimulaResultadoMataMata(PtsEquipeLibertadoresSemifinal.get(timea),PtsEquipeAdversario);
                if (Venceu==1){
                    timesLibertadoresFinal.add(timesLibertadoresSemifinal.get(timea));PtsEquipeLibertadoresFinal.add(PtsEquipeLibertadoresSemifinal.get(timea));}
                if (Venceu==-1){
                    timesLibertadoresFinal.add(timesLibertadoresSemifinal.get(timeb));PtsEquipeLibertadoresFinal.add(PtsEquipeLibertadoresSemifinal.get(timeb));}
                globalVariable.DefinirTimesLibertadoresFinal(timesLibertadoresFinal);
                globalVariable.DefinirPtsEquipeLibertadoresFinal(PtsEquipeLibertadoresFinal);
                SimulaGols(Venceu);
                if(timea!=globalVariable.SaberMinhaPosicaoMataMata() && timeb!=globalVariable.SaberMinhaPosicaoMataMata()){
                    globalVariable.DefinirGolsMataMataLibertadores(golsMarcados, 24+timea); //define os gols marcados por a
                    globalVariable.DefinirGolsMataMataLibertadores(golsSofridos, 24+timeb); //define os gols marcados por b
                }
            }
        }

        //////////////////////////////////////////////////////////////////////////////
        //         A D V E R S A R I O S    CAMP. NACIONAL E FASE GRUPO            //
        //////////////////////////////////////////////////////////////////////////////
        times = globalVariable.SaberTimes();
        chave=ObterChave(rodada);
        posicao=globalVariable.SaberPosicao();

        //Se o valor do meu time é o valor dentro da chave 1 então pega o nome do adversario da chave 2
        if(qualcampeonato==0 && rodada<rodadaOitavas){
        if(chave.get(1)==posicao) {timea=1;timeb=2;}
        if(chave.get(2)==posicao) {timea=2;timeb=1;}
        if(chave.get(3)==posicao) {timea=3;timeb=4;}
        if(chave.get(4)==posicao) {timea=4;timeb=3;}
        if(chave.get(5)==posicao) {timea=5;timeb=6;}
        if(chave.get(6)==posicao) {timea=6;timeb=5;}
        if(chave.get(7)==posicao) {timea=7;timeb=8;}
        if(chave.get(8)==posicao) {timea=8;timeb=7;}
        if(chave.get(9)==posicao) {timea=9;timeb=10;}
        if(chave.get(10)==posicao) {timea=10;timeb=9;}
        if(chave.get(11)==posicao) {timea=11;timeb=12;}
        if(chave.get(12)==posicao) {timea=12;timeb=11;}
        if(chave.get(13)==posicao) {timea=13;timeb=14;}
        if(chave.get(14)==posicao) {timea=14;timeb=13;}
        if(chave.get(15)==posicao) {timea=15;timeb=16;}
        if(chave.get(16)==posicao) {timea=16;timeb=15;}
        adversario=times.get((max * (campeonato - 1)) + chave.get(timeb));
        PtsEquipeAdversario=PtsEquipe.get((max * (campeonato - 1)) + chave.get(timeb));}
        //Se meu time estiver na Champions League
        if(qualcampeonato==1 && rodada<rodadaOitavas ){
            if(chave.get(1)==minhaposicaoChampions) {timea=1;timeb=2;}
            if(chave.get(2)==minhaposicaoChampions) {timea=2;timeb=1;}
            if(chave.get(3)==minhaposicaoChampions) {timea=3;timeb=4;}
            if(chave.get(4)==minhaposicaoChampions) {timea=4;timeb=3;}
            adversario=timesChampions.get((4 * (globalVariable.SaberMeuGrupoChampions() - 1)) + chave.get(timeb));
            PtsEquipeAdversario=PtsEquipeChampions.get((4 * (globalVariable.SaberMeuGrupoChampions() - 1)) + chave.get(timeb));
        }
        //Se meu time estiver na Libertadores
        if(qualcampeonato==2 && rodada<rodadaOitavas ){
            if(chave.get(1)==minhaposicaoLibertadores) {timea=1;timeb=2;}
            if(chave.get(2)==minhaposicaoLibertadores) {timea=2;timeb=1;}
            if(chave.get(3)==minhaposicaoLibertadores) {timea=3;timeb=4;}
            if(chave.get(4)==minhaposicaoLibertadores) {timea=4;timeb=3;}
            adversario=timesLibertadores.get((4 * (globalVariable.SaberMeuGrupoLibertadores() - 1)) + chave.get(timeb));
            PtsEquipeAdversario=PtsEquipeLibertadores.get((4 * (globalVariable.SaberMeuGrupoLibertadores() - 1)) + chave.get(timeb));
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////
        //         D E F I N I R   A D V E R S A R I O   LIBERTADORES E CHAMPIONS                    //
        ////////////////////////////////////////////////////////////////////////////////////////////////
        //Se meu time estiver no Mata-Mata CHAMPIONS
        if(globalVariable.SaberQualCampeonato()==1 && globalVariable.SaberMinhaPosicaoMataMata()>0 && rodada>=rodadaOitavas ) {
            //ADVERSARIO OITAVAS
            if (rodada == rodadaOitavas) {
                timesChampionsOitavas = globalVariable.SaberTimesChampionsOitavas();
                for (int i = 1; i <= 16; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata = i + 1;
                        adversario = timesChampionsOitavas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeChampionsOitavas.get(indexAdversarioMataMata);
                    }
                }
                for (int i = 2; i <= 16; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata = i - 1;
                        adversario = timesChampionsOitavas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeChampionsOitavas.get(indexAdversarioMataMata);
                    }
                }
            }
            //ADVERSARIO QUARTAS
            if (rodada == rodadaQuartas) {
                timesChampionsQuartas = globalVariable.SaberTimesChampionsQuartas();
                for (int i = 1; i <= 8; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i+1;
                        adversario = timesChampionsQuartas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeChampionsQuartas.get(indexAdversarioMataMata);
                    }
                }
                for (int i = 2; i <= 8; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i-1;
                        adversario = timesChampionsQuartas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeChampionsQuartas.get(indexAdversarioMataMata);
                    }
                }
            }

            //ADVERSARIO SEMIFINAL
            if (rodada == rodadaSemi) {
                timesChampionsSemifinal = globalVariable.SaberTimesChampionsSemifinal();
                for (int i = 1; i < 4; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i+1;
                        adversario = timesChampionsSemifinal.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeChampionsSemifinal.get(indexAdversarioMataMata);
                    }
                }
                for (int i = 2; i <= 4; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i-1;
                        adversario = timesChampionsSemifinal.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeChampionsSemifinal.get(indexAdversarioMataMata);
                    }
                }
            }
            //ADVERSARIO FINAL
            if (rodada == rodadaFinal) {
                timesChampionsFinal = globalVariable.SaberTimesChampionsFinal();
                if (globalVariable.SaberMinhaPosicaoMataMata() == 1) {
                    indexAdversarioMataMata=2;
                    adversario = timesChampionsFinal.get(indexAdversarioMataMata);
                    PtsEquipeAdversario= PtsEquipeChampionsFinal.get(indexAdversarioMataMata);
                }
                if (globalVariable.SaberMinhaPosicaoMataMata() == 2) {
                    indexAdversarioMataMata=1;
                    adversario = timesChampionsFinal.get(indexAdversarioMataMata);
                    PtsEquipeAdversario= PtsEquipeChampionsFinal.get(indexAdversarioMataMata);
                }
            }
        }

        //Se meu time estiver no Mata-Mata LIBERTADORES
        if(globalVariable.SaberQualCampeonato()==2 && globalVariable.SaberMinhaPosicaoMataMata()>0 && rodada>=rodadaOitavas ) {
            //ADVERSARIO OITAVAS
            if (rodada == rodadaOitavas) {
                timesLibertadoresOitavas = globalVariable.SaberTimesLibertadoresOitavas();
                for (int i = 1; i <= 16; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata = i + 1;
                        adversario = timesLibertadoresOitavas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeLibertadoresOitavas.get(indexAdversarioMataMata);
                    }
                }
                for (int i = 2; i <= 16; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata = i - 1;
                        adversario = timesLibertadoresOitavas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeLibertadoresOitavas.get(indexAdversarioMataMata);
                    }
                }
            }
            //ADVERSARIO QUARTAS
            if (rodada == rodadaQuartas) {
                timesLibertadoresQuartas = globalVariable.SaberTimesLibertadoresQuartas();
                for (int i = 1; i <= 8; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i+1;
                        adversario = timesLibertadoresQuartas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeLibertadoresQuartas.get(indexAdversarioMataMata);
                    }
                }
                for (int i = 2; i <= 8; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i-1;
                        adversario = timesLibertadoresQuartas.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeLibertadoresQuartas.get(indexAdversarioMataMata);
                    }
                }
            }

            //ADVERSARIO SEMIFINAL
            if (rodada == rodadaSemi) {
                timesLibertadoresSemifinal = globalVariable.SaberTimesLibertadoresSemifinal();
                for (int i = 1; i < 4; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i+1;
                        adversario = timesLibertadoresSemifinal.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeLibertadoresSemifinal.get(indexAdversarioMataMata);
                    }
                }
                for (int i = 2; i <= 4; i = i + 2) {
                    if (i == globalVariable.SaberMinhaPosicaoMataMata()) {
                        indexAdversarioMataMata=i-1;
                        adversario = timesLibertadoresSemifinal.get(indexAdversarioMataMata);
                        PtsEquipeAdversario = PtsEquipeLibertadoresSemifinal.get(indexAdversarioMataMata);
                    }
                }
            }
            //ADVERSARIO FINAL
            if (rodada == rodadaFinal) {
                timesLibertadoresFinal = globalVariable.SaberTimesLibertadoresFinal();
                if (globalVariable.SaberMinhaPosicaoMataMata() == 1) {
                    indexAdversarioMataMata=2;
                    adversario = timesLibertadoresFinal.get(indexAdversarioMataMata);
                    PtsEquipeAdversario= PtsEquipeLibertadoresFinal.get(indexAdversarioMataMata);
                }
                if (globalVariable.SaberMinhaPosicaoMataMata() == 2) {
                    indexAdversarioMataMata=1;
                    adversario = timesLibertadoresFinal.get(indexAdversarioMataMata);
                    PtsEquipeAdversario= PtsEquipeLibertadoresFinal.get(indexAdversarioMataMata);
                }
            }
        }

        //////////////////////////////////////////////////////////////////////////////////////////
        //IMAGENS
        //////////////////////////////////////////////////////////////////////////////////////////
        //FUNDO LIBERTADORES E CHAMPIONS
        ImageView fundocampeonato = findViewById(R.id.fundoChampions);
        if(qualcampeonato==1){fundocampeonato.setVisibility(View.VISIBLE);}
        fundocampeonato = findViewById(R.id.fundolibertadores);
        if(qualcampeonato==2){fundocampeonato.setVisibility(View.VISIBLE);}

        TextView textoRodada = findViewById(R.id.textoRodada);
        if(qualcampeonato>=1){ //fundo branco textpo
            TextView placar = findViewById(R.id.textoPlacar);
            placar.setTextColor(Color.WHITE);
            textoRodada.setTextColor(Color.WHITE);}

        if(qualcampeonato==0){
            textoRodada.setText("Rodada "+rodada+"/15");}
        if((qualcampeonato>=1)&& rodada<rodadaOitavas){
            textoRodada.setText("Rodada "+String.valueOf(rodada-15));
        }
        if(rodada==rodadaOitavas){ textoRodada.setText("Oitavas");}
        if(rodada==rodadaQuartas){ textoRodada.setText("Quartas");}
        if(rodada==rodadaSemi){ textoRodada.setText("Semifinal");}
        if(rodada==rodadaFinal){ textoRodada.setText("Final");}
        ImageView imageLogo = findViewById(R.id.logoCampeonato);
        if(qualcampeonato==0){
            if(campeonato==1){imageLogo.setImageResource(R.drawable.brasileirao);}
            if(campeonato==2){imageLogo.setImageResource(R.drawable.premierleague);}
            if(campeonato==3){imageLogo.setImageResource(R.drawable.seriea);}
            if(campeonato==4){imageLogo.setImageResource(R.drawable.laliga);}
            if(campeonato==5){imageLogo.setImageResource(R.drawable.bundesliga);}
            if(campeonato==6){imageLogo.setImageResource(R.drawable.ligue1);}
            if(campeonato==7){imageLogo.setImageResource(R.drawable.liga1);}
            if(campeonato==8){imageLogo.setImageResource(R.drawable.leste);}
            if(campeonato==9){imageLogo.setImageResource(R.drawable.championship);}
            if(campeonato==10){imageLogo.setImageResource(R.drawable.brasilserieb);}
            if(campeonato==11){imageLogo.setImageResource(R.drawable.logoargentina);}
            if(campeonato==12){imageLogo.setImageResource(R.drawable.logosulamericana);}
            if(campeonato==13){imageLogo.setImageResource(R.drawable.logocolombia);}}
        if(qualcampeonato==1 && (campeonato>=2 && campeonato<=9)){imageLogo.setImageResource(R.drawable.championsleague);}
        if(qualcampeonato==2 && (campeonato==1 || campeonato>=10)){imageLogo.setImageResource(R.drawable.libertadores);}
        imageLogo = findViewById(R.id.imageLogo);
//COLOCA AS IMAGENS DOS TIMES
        for(int i=1;i<=2;i++){
            if(i==1){timeFoto = meutime;}
            if (i==2){ //TIME ADVERSARIO
                //imagem Estádio
                imageLogo = findViewById(R.id.Estadio);
                if(rodada%2==1){globalVariable.imageEstadio(adversario,imageLogo);}else {globalVariable.imageEstadio(meutime,imageLogo);}

                imageLogo = findViewById(R.id.LogoSimulacaoRival);
                timeFoto = adversario;
            }
            globalVariable.imageLogo(timeFoto, imageLogo);
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////
        //RADIOBUTTON
        RadioGroup radioGroup;
        final RadioButton radiobtn1,radiobtn2,radiobtn3;

        radioGroup=findViewById(R.id.RadioGroup);
        radiobtn1=findViewById(R.id.radioButton);
        radiobtn2=findViewById(R.id.radioButton2);
        radiobtn3=findViewById(R.id.radioButton3);
        radiobtn2.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton:
                        Toast.makeText(getApplicationContext(),"Time Defendendo",Toast.LENGTH_SHORT).show();
                        posturaDoTime=1;
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(getApplicationContext(),"Time Normal",Toast.LENGTH_SHORT).show();
                        posturaDoTime=2;
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(getApplicationContext(),"Time Atacando",Toast.LENGTH_SHORT).show();
                        posturaDoTime=3;
                        break;
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////
        //SEEKBAR
        pausa=200-(2*globalVariable.SaberPausa());
        if(pausa==0){pausa=1;}
        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(globalVariable.SaberPausa());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pausa = 100-(1*progress);
                if(pausa==0){pausa=1;}
                globalVariable.DefinirPausa(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CRONOMETRO
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Handler h = new Handler();
        textoCronometro=findViewById(R.id.textoCronometro);
        textoPlacar = findViewById(R.id.textoPlacar);
        PtsEquipeAuxiliar = PtsEquipeAdversario;//sem isso da confusão na variave PtsEquipe dentro do Thread


        final Handler handler = new Handler();
        MeuGolMarcado=0;MeuGolSofrido=0;
        mili = 0;
        final Runnable runnable = new Runnable() {
            public void run() {
                if (mili++ < 90) {
                    if (qualcampeonato >= 1) {
                        textoCronometro.setTextColor(Color.WHITE);
                    }
                    if(mili>3){
                    GolPorMinuto(PtsEquipe.get((max * (campeonato - 1)) + posicao), PtsEquipeAuxiliar);}
                    textoPlacar.setText(MeuGolMarcado + "X" + MeuGolSofrido);
                    textoCronometro.setText(String.valueOf(mili) + "'");
                    handler.postDelayed(this, pausa);
                }//90 min

                //no final do jogo
                if(mili==90){
                    ///////////////////////////////////////////////////////////////////////////////////////////////
                    ///////////          MEU JOGO EM SI   LIBERTADORES E CHAMPIONS                             //
                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    //MEU CAMPEONATO NACIONAL E FASE DE GRUPOS
                    if(rodada<rodadaOitavas ){
                        pontosA=0;pontosB=0;
                        if (MeuGolMarcado>MeuGolSofrido){pontosA=3;Venceu=1;}
                        if (MeuGolMarcado==MeuGolSofrido){pontosA=1;pontosB=1;Venceu=0;}
                        if (MeuGolMarcado<MeuGolSofrido){pontosB=3;Venceu=-1;}
                        if(qualcampeonato==0){
                            globalVariable.DefinirGols(MeuGolMarcado,MeuGolSofrido,pontosA, (max * (campeonato - 1))+chave.get(timea));
                            globalVariable.DefinirGols(MeuGolSofrido,MeuGolMarcado,pontosB, (max * (campeonato - 1))+chave.get(timeb));
                        }
                        if(qualcampeonato==1 && rodada<rodadaOitavas){
                            globalVariable.DefinirGolsChampions(MeuGolMarcado,MeuGolSofrido,pontosA, (4 * (globalVariable.SaberMeuGrupoChampions() - 1))+ chave.get(timea));
                            globalVariable.DefinirGolsChampions(MeuGolSofrido,MeuGolMarcado,pontosB, (4 * (globalVariable.SaberMeuGrupoChampions() - 1))+ chave.get(timeb));
                        }
                        if(qualcampeonato==2 && rodada<rodadaOitavas){
                            globalVariable.DefinirGolsLibertadores(MeuGolMarcado,MeuGolSofrido,pontosA, (4 * (globalVariable.SaberMeuGrupoLibertadores() - 1))+ chave.get(timea));
                            globalVariable.DefinirGolsLibertadores(MeuGolSofrido,MeuGolMarcado,pontosB, (4 * (globalVariable.SaberMeuGrupoLibertadores() - 1))+ chave.get(timeb));
                        }
                    }
                    //Se estiver no matamata Champions/Liberatodres e o jogo empatar: PENALTIS!!!
                    if(qualcampeonato>=1 && MeuGolMarcado==MeuGolSofrido && rodada>=rodadaOitavas){
                        Toast.makeText(getApplicationContext(),"PENALTIS",Toast.LENGTH_SHORT).show();
                        Venceu = new Random().nextInt(100)+1;
                        if(Venceu>=50){MeuGolMarcado++;}
                        if(Venceu<50){MeuGolSofrido++;}
                    }

                    //MATA MATA
                    if(globalVariable.SaberQualCampeonato()==1 && rodada>=rodadaOitavas){
                        //NO MATA MATA NÃO TEM EMPATE CHAMPIONS
                        if(rodada==rodadaOitavas ) {
                            timesChampionsQuartas=globalVariable.SaberTimesChampionsQuartas();
                            PtsEquipeChampionsQuartas=globalVariable.SaberPtsEquipeChampionsQuartas();
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataChampions(MeuGolMarcado, globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataChampions(MeuGolSofrido, indexAdversarioMataMata); //define os gols marcados por b
                            if (Venceu==1){
                                int PtsMinhaEquipe = PtsEquipeChampionsOitavas.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2)globalVariable.DefinirMinhaPosicaoMataMata(1);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4)globalVariable.DefinirMinhaPosicaoMataMata(2);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6)globalVariable.DefinirMinhaPosicaoMataMata(3);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8)globalVariable.DefinirMinhaPosicaoMataMata(4);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==9 || globalVariable.SaberMinhaPosicaoMataMata() ==10)globalVariable.DefinirMinhaPosicaoMataMata(5);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==11 || globalVariable.SaberMinhaPosicaoMataMata() ==12)globalVariable.DefinirMinhaPosicaoMataMata(6);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==13 || globalVariable.SaberMinhaPosicaoMataMata() ==14)globalVariable.DefinirMinhaPosicaoMataMata(7);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==15 || globalVariable.SaberMinhaPosicaoMataMata() ==16)globalVariable.DefinirMinhaPosicaoMataMata(8);
                                timesChampionsQuartas.set(globalVariable.SaberMinhaPosicaoMataMata(),globalVariable.Sabermeutime());
                                PtsEquipeChampionsQuartas.set(globalVariable.SaberMinhaPosicaoMataMata(),PtsMinhaEquipe);
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuChampions(16);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2){timesChampionsQuartas.set(1,adversario);PtsEquipeChampionsQuartas.set(1,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4){timesChampionsQuartas.set(2,adversario);PtsEquipeChampionsQuartas.set(2,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6){timesChampionsQuartas.set(3,adversario);PtsEquipeChampionsQuartas.set(3,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8){timesChampionsQuartas.set(4,adversario);PtsEquipeChampionsQuartas.set(4,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==9 || globalVariable.SaberMinhaPosicaoMataMata() ==10){timesChampionsQuartas.set(5,adversario);PtsEquipeChampionsQuartas.set(5,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==11 || globalVariable.SaberMinhaPosicaoMataMata() ==12){timesChampionsQuartas.set(6,adversario);PtsEquipeChampionsQuartas.set(6,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==13 || globalVariable.SaberMinhaPosicaoMataMata() ==14){timesChampionsQuartas.set(7,adversario);PtsEquipeChampionsQuartas.set(7,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==15 || globalVariable.SaberMinhaPosicaoMataMata() ==16){timesChampionsQuartas.set(8,adversario);PtsEquipeChampionsQuartas.set(8,PtsEquipeAdversario);}
                                globalVariable.DefinirMinhaPosicaoMataMata(-1); //MUDAR
                            }
                            globalVariable.DefinirTimesChampionsQuartas(timesChampionsQuartas);
                            globalVariable.DefinirPtsEquipeChampionsQuartas(PtsEquipeChampionsQuartas);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);}
                        //NO MATA MATA NÃO TEM EMPATE CHAMPIONS
                        if(rodada==rodadaQuartas ) {
                            timesChampionsSemifinal=globalVariable.SaberTimesChampionsSemifinal();
                            PtsEquipeChampionsSemifinal=globalVariable.SaberPtsEquipeChampionsSemifinal();
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataChampions(MeuGolMarcado, 16+globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataChampions(MeuGolSofrido, 16+indexAdversarioMataMata); //define os gols marcados por b
                            if (Venceu==1){
                                int PtsMinhaEquipe = PtsEquipeChampionsQuartas.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2)globalVariable.DefinirMinhaPosicaoMataMata(1);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4)globalVariable.DefinirMinhaPosicaoMataMata(2);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6)globalVariable.DefinirMinhaPosicaoMataMata(3);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8)globalVariable.DefinirMinhaPosicaoMataMata(4);
                                timesChampionsSemifinal.set(globalVariable.SaberMinhaPosicaoMataMata(),meutime);PtsEquipeChampionsSemifinal.set(globalVariable.SaberMinhaPosicaoMataMata(),PtsMinhaEquipe);
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuChampions(8);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2){timesChampionsSemifinal.set(1,adversario);PtsEquipeChampionsSemifinal.set(1,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4){timesChampionsSemifinal.set(2,adversario);PtsEquipeChampionsSemifinal.set(2,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6){timesChampionsSemifinal.set(3,adversario);PtsEquipeChampionsSemifinal.set(3,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8){timesChampionsSemifinal.set(4,adversario);PtsEquipeChampionsSemifinal.set(4,PtsEquipeAdversario);}
                                globalVariable.DefinirMinhaPosicaoMataMata(-1);
                            }
                            globalVariable.DefinirTimesChampionsSemi(timesChampionsSemifinal);
                            globalVariable.DefinirPtsEquipeChampionsSemifinal(PtsEquipeChampionsSemifinal);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);}
                        //NO MATA MATA NÃO TEM EMPATE CHAMPIONS
                        if(rodada==rodadaSemi ) {
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataChampions(MeuGolMarcado, 24+globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataChampions(MeuGolSofrido, 24+indexAdversarioMataMata); //define os gols marcados por b
                            if (Venceu==1){
                                int PtsMinhaEquipe = PtsEquipeChampionsSemifinal.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2)globalVariable.DefinirMinhaPosicaoMataMata(1);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4)globalVariable.DefinirMinhaPosicaoMataMata(2);
                                timesChampionsFinal.set(globalVariable.SaberMinhaPosicaoMataMata(),meutime);PtsEquipeChampionsSemifinal.set(globalVariable.SaberMinhaPosicaoMataMata(),PtsMinhaEquipe);
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuChampions(4);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2){timesChampionsFinal.set(1,adversario);PtsEquipeChampionsFinal.set(1,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4){timesChampionsFinal.set(2,adversario);PtsEquipeChampionsFinal.set(2,PtsEquipeAdversario);}
                                globalVariable.DefinirMinhaPosicaoMataMata(-1);
                            }
                            globalVariable.DefinirTimesChampionsFinal(timesChampionsFinal);
                            globalVariable.DefinirPtsEquipeChampionsFinal(PtsEquipeChampionsFinal);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);}
                        //NO MATA MATA NÃO TEM EMPATE CHAMPIONS
                        if(rodada==rodadaFinal ) {
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataChampions(MeuGolMarcado, 28+globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataChampions(MeuGolSofrido, 28+indexAdversarioMataMata); //define os gols marcados por b
                            String stringAuxiliar;
                            if (Venceu==1) {
                                mp=MediaPlayer.create(getApplication(),R.raw.championsleagueaudio);
                                mp.start();
                                Toast.makeText(getApplicationContext(),"CAMPEÃO DA CHAMPIONS LEAGUE",Toast.LENGTH_SHORT).show();

                                globalVariable.DefinirHistoricoMeuChampions(1);
                                //int PtsMinhaEquipe = PtsEquipeChampionsFinal.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata() ==2){stringAuxiliar=timesChampionsFinal.get(1);timesChampionsFinal.set(1,timesChampionsFinal.get(2));timesChampionsFinal.set(2,stringAuxiliar);           }
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuChampions(2);
                                if(globalVariable.SaberMinhaPosicaoMataMata() ==1){stringAuxiliar=timesChampionsFinal.get(1);timesChampionsFinal.set(1,timesChampionsFinal.get(2));timesChampionsFinal.set(2,stringAuxiliar);           }
                            }
                            //globalVariable.DefinirTimesChampionsFinal(timesChampionsFinal);
                            //globalVariable.DefinirPtsEquipeChampionsFinal(PtsEquipeChampionsFinal);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);

                            globalVariable.DefinirMinhaPosicaoMataMata(-1); //MUDAR
                        }
                    }
                    if(globalVariable.SaberQualCampeonato()==2 && rodada>=rodadaOitavas){
                        //NO MATA MATA NÃO TEM EMPATE LIBERTADORES
                        if(rodada==rodadaOitavas ) {
                            timesLibertadoresQuartas=globalVariable.SaberTimesLibertadoresQuartas();
                            PtsEquipeLibertadoresQuartas=globalVariable.SaberPtsEquipeLibertadoresQuartas();
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolMarcado, globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolSofrido, indexAdversarioMataMata); //define os gols marcados por b
                            if (Venceu==1){
                                int PtsMinhaEquipe = PtsEquipeLibertadoresOitavas.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2)globalVariable.DefinirMinhaPosicaoMataMata(1);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4)globalVariable.DefinirMinhaPosicaoMataMata(2);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6)globalVariable.DefinirMinhaPosicaoMataMata(3);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8)globalVariable.DefinirMinhaPosicaoMataMata(4);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==9 || globalVariable.SaberMinhaPosicaoMataMata() ==10)globalVariable.DefinirMinhaPosicaoMataMata(5);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==11 || globalVariable.SaberMinhaPosicaoMataMata() ==12)globalVariable.DefinirMinhaPosicaoMataMata(6);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==13 || globalVariable.SaberMinhaPosicaoMataMata() ==14)globalVariable.DefinirMinhaPosicaoMataMata(7);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==15 || globalVariable.SaberMinhaPosicaoMataMata() ==16)globalVariable.DefinirMinhaPosicaoMataMata(8);
                                timesLibertadoresQuartas.set(globalVariable.SaberMinhaPosicaoMataMata(),globalVariable.Sabermeutime());
                                PtsEquipeLibertadoresQuartas.set(globalVariable.SaberMinhaPosicaoMataMata(),PtsMinhaEquipe);
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuLibertadores(16);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2){timesLibertadoresQuartas.set(1,adversario);PtsEquipeLibertadoresQuartas.set(1,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4){timesLibertadoresQuartas.set(2,adversario);PtsEquipeLibertadoresQuartas.set(2,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6){timesLibertadoresQuartas.set(3,adversario);PtsEquipeLibertadoresQuartas.set(3,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8){timesLibertadoresQuartas.set(4,adversario);PtsEquipeLibertadoresQuartas.set(4,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==9 || globalVariable.SaberMinhaPosicaoMataMata() ==10){timesLibertadoresQuartas.set(5,adversario);PtsEquipeLibertadoresQuartas.set(5,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==11 || globalVariable.SaberMinhaPosicaoMataMata() ==12){timesLibertadoresQuartas.set(6,adversario);PtsEquipeLibertadoresQuartas.set(6,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==13 || globalVariable.SaberMinhaPosicaoMataMata() ==14){timesLibertadoresQuartas.set(7,adversario);PtsEquipeLibertadoresQuartas.set(7,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==15 || globalVariable.SaberMinhaPosicaoMataMata() ==16){timesLibertadoresQuartas.set(8,adversario);PtsEquipeLibertadoresQuartas.set(8,PtsEquipeAdversario);}
                                globalVariable.DefinirMinhaPosicaoMataMata(-1); //MUDAR
                            }
                            globalVariable.DefinirTimesLibertadoresQuartas(timesLibertadoresQuartas);
                            globalVariable.DefinirPtsEquipeLibertadoresQuartas(PtsEquipeLibertadoresQuartas);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);}
                        //NO MATA MATA NÃO TEM EMPATE LIBERTADORES
                        if(rodada==rodadaQuartas ) {
                            timesLibertadoresSemifinal=globalVariable.SaberTimesLibertadoresSemifinal();
                            PtsEquipeLibertadoresSemifinal=globalVariable.SaberPtsEquipeLibertadoresSemifinal();
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolMarcado, 16+globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolSofrido, 16+indexAdversarioMataMata); //define os gols marcados por b
                            if (Venceu==1){
                                int PtsMinhaEquipe = PtsEquipeLibertadoresQuartas.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2)globalVariable.DefinirMinhaPosicaoMataMata(1);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4)globalVariable.DefinirMinhaPosicaoMataMata(2);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6)globalVariable.DefinirMinhaPosicaoMataMata(3);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8)globalVariable.DefinirMinhaPosicaoMataMata(4);
                                timesLibertadoresSemifinal.set(globalVariable.SaberMinhaPosicaoMataMata(),meutime);PtsEquipeLibertadoresSemifinal.set(globalVariable.SaberMinhaPosicaoMataMata(),PtsMinhaEquipe);
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuLibertadores(8);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2){timesLibertadoresSemifinal.set(1,adversario);PtsEquipeLibertadoresSemifinal.set(1,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4){timesLibertadoresSemifinal.set(2,adversario);PtsEquipeLibertadoresSemifinal.set(2,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==5 || globalVariable.SaberMinhaPosicaoMataMata() ==6){timesLibertadoresSemifinal.set(3,adversario);PtsEquipeLibertadoresSemifinal.set(3,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==7 || globalVariable.SaberMinhaPosicaoMataMata() ==8){timesLibertadoresSemifinal.set(4,adversario);PtsEquipeLibertadoresSemifinal.set(4,PtsEquipeAdversario);}
                                globalVariable.DefinirMinhaPosicaoMataMata(-1);
                            }
                            globalVariable.DefinirTimesLibertadoresSemi(timesLibertadoresSemifinal);
                            globalVariable.DefinirPtsEquipeLibertadoresSemifinal(PtsEquipeLibertadoresSemifinal);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);}
                        //NO MATA MATA NÃO TEM EMPATE LIBERTADORES
                        if(rodada==rodadaSemi ) {
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolMarcado, 24+globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolSofrido, 24+indexAdversarioMataMata); //define os gols marcados por b
                            if (Venceu==1){
                                int PtsMinhaEquipe = PtsEquipeLibertadoresSemifinal.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2)globalVariable.DefinirMinhaPosicaoMataMata(1);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4)globalVariable.DefinirMinhaPosicaoMataMata(2);
                                timesLibertadoresFinal.set(globalVariable.SaberMinhaPosicaoMataMata(),meutime);PtsEquipeLibertadoresSemifinal.set(globalVariable.SaberMinhaPosicaoMataMata(),PtsMinhaEquipe);
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuLibertadores(4);
                                if(globalVariable.SaberMinhaPosicaoMataMata()==1 || globalVariable.SaberMinhaPosicaoMataMata() ==2){timesLibertadoresFinal.set(1,adversario);PtsEquipeLibertadoresFinal.set(1,PtsEquipeAdversario);}
                                if(globalVariable.SaberMinhaPosicaoMataMata()==3 || globalVariable.SaberMinhaPosicaoMataMata() ==4){timesLibertadoresFinal.set(2,adversario);PtsEquipeLibertadoresFinal.set(2,PtsEquipeAdversario);}
                                globalVariable.DefinirMinhaPosicaoMataMata(-1);
                            }
                            globalVariable.DefinirTimesLibertadoresFinal(timesLibertadoresFinal);
                            globalVariable.DefinirPtsEquipeLibertadoresFinal(PtsEquipeLibertadoresFinal);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);}
                        //NO MATA MATA NÃO TEM EMPATE LIBERTADORES
                        if(rodada==rodadaFinal ) {
                            if (MeuGolMarcado>MeuGolSofrido){Venceu=1;}
                            if (MeuGolMarcado==MeuGolSofrido){Venceu=0;}
                            if (MeuGolMarcado<MeuGolSofrido){Venceu=-1;}
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolMarcado, 28+globalVariable.SaberMinhaPosicaoMataMata()); //define os gols marcados por a
                            globalVariable.DefinirGolsMataMataLibertadores(MeuGolSofrido, 28+indexAdversarioMataMata); //define os gols marcados por b
                            String stringAuxiliar;
                            if (Venceu==1) {
                                mp=MediaPlayer.create(getApplication(),R.raw.championsleagueaudio);
                                mp.start();
                                Toast.makeText(getApplicationContext(),"CAMPEÃO DA CHAMPIONS LEAGUE",Toast.LENGTH_SHORT).show();

                                globalVariable.DefinirHistoricoMeuLibertadores(1);
                                //int PtsMinhaEquipe = PtsEquipeLibertadoresFinal.get(globalVariable.SaberMinhaPosicaoMataMata());
                                if(globalVariable.SaberMinhaPosicaoMataMata() ==2){stringAuxiliar=timesLibertadoresFinal.get(1);timesLibertadoresFinal.set(1,timesLibertadoresFinal.get(2));timesLibertadoresFinal.set(2,stringAuxiliar);           }
                            }
                            if (Venceu==-1){
                                globalVariable.DefinirHistoricoMeuLibertadores(2);
                                if(globalVariable.SaberMinhaPosicaoMataMata() ==1){stringAuxiliar=timesLibertadoresFinal.get(1);timesLibertadoresFinal.set(1,timesLibertadoresFinal.get(2));timesLibertadoresFinal.set(2,stringAuxiliar);           }
                            }
                            //globalVariable.DefinirTimesLibertadoresFinal(timesLibertadoresFinal);
                            //globalVariable.DefinirPtsEquipeLibertadoresFinal(PtsEquipeLibertadoresFinal);
                            textoPlacar = findViewById(R.id.textoPlacar);
                            textoPlacar.setText(MeuGolMarcado+"X"+MeuGolSofrido);

                            globalVariable.DefinirMinhaPosicaoMataMata(-1); //MUDAR
                        }
                    }

                    //////////////////////////////////////////////////////////////////////////////////////////////////////
                    //Dinheiro
                    if(dinheiro==dinheiro){
                        double premio=0;
                        if(qualcampeonato==0){
                            if(campeonato==1){premio=1.5;}
                            if(campeonato==2){premio=2.5;}
                            if(campeonato>=3 && campeonato<=5){premio=2.0;}
                            if(campeonato==6){premio=1.8;}//frances
                            if(campeonato==7){premio=1.6;}//ocidente
                            if(campeonato==8){premio=1.3;}//leste
                            if(campeonato==9){premio=1.2;}//championship
                            if(campeonato==10){premio=0.6;}//serie b
                            if(campeonato==11){premio=1.2;}//argentina
                            if(campeonato==12){premio=1.0;}//sulamerica
                            if(campeonato==13){premio=1.0;}
                            if(campeonato==14){premio=1.0;}//mls
                            if(Venceu==0){premio=premio/3;}
                            if(Venceu==-1){premio=premio/5;}}
                        if(qualcampeonato==1){
                            premio=5;
                            if(Venceu==0){premio=premio/3;}
                            if(Venceu==-1){premio=premio/5;}
                        }
                        if(qualcampeonato==2){
                            premio=3;
                            if(Venceu==0){premio=premio/3;}
                            if(Venceu==-1){premio=premio/5;}
                        }
                        dinheiro = dinheiro+(float)premio;
                        globalVariable.DefinirParametros(campeonato,dinheiro);}


                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    //SIMULAÇÃO DOS OUTROS JOGOS para não me incluir precisa ser depois
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if(qualcampeonato==qualcampeonato){
                        //SIMULAÇÃO DO CAMPEONATO NACIONAL
                        if(qualcampeonato==0){//se for campeonato nacional
                            for (int i=1;i<=max*max2;i++){
                                int campeonatoSIMULAÇAO = 1+(i/max); //-> i=15 res:0+1  *i=16 res:2
                                int posicaoSIMULACAO= (i%(max));     //-> i=15 res:15   *i=16 res=0
                                if(i%16==0){posicaoSIMULACAO=16;campeonatoSIMULAÇAO=(i/max);}
                                //se nao tiver meu time e nao for o mesmo campeonato
                                int SIMULAR=0,soma=0;
                                for(int z=1; z<=max;z=z+2){
                                    if(chave.get(z)==posicaoSIMULACAO ) {timea=z;timeb=z+1;SIMULAR=1;
                                        if(SIMULAR==1){
                                            if((chave.get(z)==posicao || chave.get(z+1)==posicao) && campeonatoSIMULAÇAO==campeonato){SIMULAR=0;soma++;
                                                break;}
                                            adversario=times.get((max * (campeonatoSIMULAÇAO - 1)) + chave.get(timeb));
                                            PtsEquipeAdversario=PtsEquipe.get((max * (campeonatoSIMULAÇAO - 1)) + chave.get(timeb));

                                            //PontuaçãoA x Pontuação adversarioB
                                            Venceu = SimulaResultado(PtsEquipe.get(i),PtsEquipeAdversario);
                                            pontosA=0;pontosB=0;
                                            if (Venceu==1){pontosA=pontosA+3;}
                                            if (Venceu==0){pontosA++;pontosB++;}
                                            if (Venceu==-1){pontosB=pontosB+3;}
                                            SimulaGols(Venceu);
                                            globalVariable.DefinirGols(golsMarcados,golsSofridos,pontosA, i);
                                            globalVariable.DefinirGols(golsSofridos,golsMarcados,pontosB, (max * (campeonatoSIMULAÇAO - 1))+chave.get(timeb));
                                        }}}
                            }
                        }
                        //SIMULAÇÃO CHAMPIONS LEAGUE
                        // FASE DE GRUPOS Champions League
                        if(qualcampeonato>=1  && rodada<rodadaOitavas){// FASE DE GRUPOS Champions League
                            for (int i=1;i<=32;i++){
                                int grupoSIMULACAO = 1+(i/4); //-> i=7 res:0+1  *i=8 res:2
                                int posicaoSIMULACAO= (i%(4));     //-> i=7 res:7   *i=8 res=0
                                if(i%4==0){posicaoSIMULACAO=4;grupoSIMULACAO=(i/4);}
                                //se nao tiver meu time e nao for o mesmo campeonato
                                int SIMULAR=0,soma=0;
                                for(int z=1; z<=4;z=z+2){//z+2 pega cada confronto chave1, chave3
                                    chave=ObterChave(rodada);
                                    if(chave.get(z)==posicaoSIMULACAO ) {timea=z;timeb=z+1;SIMULAR=1;    //timea entre 1 e 4

                                        if(SIMULAR==1){
                                            if(qualcampeonato==1 &&(chave.get(z)==minhaposicaoChampions || chave.get(z+1)==minhaposicaoChampions) &&  grupoSIMULACAO == meuGrupoChampions){
                                                SIMULAR=0;soma++;
                                                break;}
                                            adversario=timesChampions.get((4 * (grupoSIMULACAO - 1)) + chave.get(timeb));
                                            PtsEquipeAdversario=PtsEquipeChampions.get((4 * (grupoSIMULACAO - 1)) + chave.get(timeb));

                                            //PontuaçãoA x Pontuação adversarioB
                                            Venceu = SimulaResultado(PtsEquipeChampions.get(i),PtsEquipeAdversario);
                                            pontosA=0;pontosB=0;
                                            if (Venceu==1){pontosA=pontosA+3;}
                                            if (Venceu==0){pontosA++;pontosB++;}
                                            if (Venceu==-1){pontosB=pontosB+3;}
                                            SimulaGols(Venceu);
                                            globalVariable.DefinirGolsChampions(golsMarcados,golsSofridos,pontosA, i);
                                            globalVariable.DefinirGolsChampions(golsSofridos,golsMarcados,pontosB, (4 * (grupoSIMULACAO - 1))+chave.get(timeb));
                                        }}}
                            }
                        }
                        // FASE DE GRUPOS Libertadores
                        if(qualcampeonato>=1  && rodada<rodadaOitavas){// FASE DE GRUPOS Champions League
                            for (int i=1;i<=32;i++){
                                int grupoSIMULACAO = 1+(i/4); //-> i=7 res:0+1  *i=8 res:2
                                int posicaoSIMULACAO= (i%(4));     //-> i=7 res:7   *i=8 res=0
                                if(i%4==0){posicaoSIMULACAO=4;grupoSIMULACAO=(i/4);}
                                //se nao tiver meu time e nao for o mesmo campeonato
                                int SIMULAR=0,soma=0;
                                for(int z=1; z<=4;z=z+2){//z+2 pega cada confronto chave1, chave3
                                    chave=ObterChave(rodada);
                                    if(chave.get(z)==posicaoSIMULACAO ) {timea=z;timeb=z+1;SIMULAR=1;    //timea entre 1 e 4

                                        if(SIMULAR==1){
                                            if(qualcampeonato==2 && (chave.get(z)==minhaposicaoLibertadores || chave.get(z+1)==minhaposicaoLibertadores) &&  grupoSIMULACAO == meuGrupoLibertadores){
                                                SIMULAR=0;soma++;
                                                break;}
                                            adversario=timesLibertadores.get((4 * (grupoSIMULACAO - 1)) + chave.get(timeb));
                                            PtsEquipeAdversario=PtsEquipeLibertadores.get((4 * (grupoSIMULACAO - 1)) + chave.get(timeb));

                                            //PontuaçãoA x Pontuação adversarioB
                                            Venceu = SimulaResultado(PtsEquipeLibertadores.get(i),PtsEquipeAdversario);
                                            pontosA=0;pontosB=0;
                                            if (Venceu==1){pontosA=pontosA+3;}
                                            if (Venceu==0){pontosA++;pontosB++;}
                                            if (Venceu==-1){pontosB=pontosB+3;}
                                            SimulaGols(Venceu);
                                            globalVariable.DefinirGolsLibertadores(golsMarcados,golsSofridos,pontosA, i);
                                            globalVariable.DefinirGolsLibertadores(golsSofridos,golsMarcados,pontosB, (4 * (grupoSIMULACAO - 1))+chave.get(timeb));
                                        }}}
                            }
                        }
                    }


                    ///////////////////////////////////////////////////////////////////////////////////////////////////////
                    //FINAL DO LOOP
                    //////////////////////////////////////////////////////////////////////////////////////////////////////
                    rodada++;
                    if(qualcampeonato>=1)globalVariable.DefinirOrdemLibertadores();
                    if(qualcampeonato>=1)globalVariable.DefinirOrdemChampions();
                    if(qualcampeonato==0)globalVariable.DefinirOrdem();
                    //HISTORICO
                    if (rodada == max) {
                        timesOrdem = globalVariable.SabertimesOrdem();
                        globalVariable.DefinirHistoricoMeuCampeonato(campeonato);
                        int minhaposicao = timesOrdem.indexOf(meutime) % max;
                        if (minhaposicao == 0) {
                            minhaposicao = max;
                        }
                        globalVariable.DefinirHistoricoMinhaPosicao(minhaposicao);
                    }
                    //Envia Variveis
                    globalVariable.DefinirRodada(rodada);

                    mili=100;//para não dar pau na hora de apertar o botão e garantir que o ciclo acabou
                }//depois de 90min

            }//run
        };

// trigger first time
        runnable.run();




    }


    public void abrirActivity_Simulacao(View view){

        if(mili>=100){
        if(mp.isPlaying()){
        mp.stop();}
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        rodada=globalVariable.SaberRodada();
        if (rodada!=max && rodada!=rodadaOitavas || (rodada>=rodadaOitavas &&globalVariable.SaberMinhaPosicaoMataMata()>0)) {
            Intent intent = new Intent(this, Activity_Simulacao.class);
            startActivity(intent);
        }
        if(rodada==max){
            Intent intent = new Intent(this, ActivityTabela.class);
            startActivity(intent);
        }
        if(rodada==rodadaOitavas || rodada==26 || (rodada>=rodadaOitavas && globalVariable.SaberMinhaPosicaoMataMata()<0)){
            Intent intent = new Intent(this, Activity4.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        }
    }
    public void abrirActivity_Menu(View view){
        if(mili>=100) {
        if(mp.isPlaying()){
            mp.stop();}
            final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
            rodada=globalVariable.SaberRodada();
            if (rodada != max) {
                Intent intent = new Intent(getApplicationContext(), Activity4.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
            if (rodada == max) {
                Intent intent = new Intent(this, ActivityTabela.class);
                startActivity(intent);
            }
        }
    }


    public Integer SimulaResultado(Integer PtsEquipe, Integer PtsEquipeAdversario){
        //SIMULAÇÃO RESULTADO
        if(PtsEquipe-PtsEquipeAdversario>=6)                                    {vitoria=80;empate=15;}
        if(PtsEquipe-PtsEquipeAdversario<6 && PtsEquipe-PtsEquipeAdversario>=4){vitoria=60;empate=25;}
        if(PtsEquipe-PtsEquipeAdversario<4 && PtsEquipe-PtsEquipeAdversario>=2){vitoria=45;empate=30;}
        if(PtsEquipe-PtsEquipeAdversario<=1 && PtsEquipe-PtsEquipeAdversario>=-1) {vitoria=33;empate=33;}
        if(PtsEquipe-PtsEquipeAdversario<=-2 && PtsEquipe-PtsEquipeAdversario>-4){vitoria=25;empate=30;}
        if(PtsEquipe-PtsEquipeAdversario<=-4 && PtsEquipe-PtsEquipeAdversario>-6){vitoria=15;empate=25;}
        if(PtsEquipe-PtsEquipeAdversario<=-6)                                     {vitoria=5;empate=15;}

        resultado = new Random().nextInt(100)+1;
        if(resultado<vitoria){Venceu=1;}
        if(resultado>vitoria && resultado<(vitoria+empate)){Venceu=0;}
        if(resultado>=(vitoria+empate)){Venceu=-1;}
        return Venceu;
    }
        public Integer SimulaResultadoMataMata(Integer PtsEquipe, Integer PtsEquipeAdversario){
            //SIMULAÇÃO RESULTADO
            if(PtsEquipe-PtsEquipeAdversario>=6)                                    {vitoria=95;}
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
        if(Venceu==0){golsMarcados=golsSofridos;}
        if(Venceu==-1){while(golsMarcados>=golsSofridos){golsSofridos = new Random().nextInt(4)+1; golsMarcados = new Random().nextInt(3);}}
    }

    public void GolPorMinuto(Integer PtsEquipe, Integer PtsEquipeAdversario){
        int gol=900;
        int probGM=0,probGS=0;
        //TIME NA DEFESA
        if(posturaDoTime==1){
            if(PtsEquipe-PtsEquipeAdversario>=6)                                    {probGM=16;probGS=4;} //marca 4 e toma 0,3 gols por jogo
            if(PtsEquipe-PtsEquipeAdversario<6 && PtsEquipe-PtsEquipeAdversario>=4){probGM=15;probGS=6;}
            if(PtsEquipe-PtsEquipeAdversario<4 && PtsEquipe-PtsEquipeAdversario>=2){probGM=13;probGS=8;}
            if(PtsEquipe-PtsEquipeAdversario==1)                                     {probGM=11;probGS=9;}
            if(PtsEquipe-PtsEquipeAdversario==0)                                     {probGM=11;probGS=11;}
            if(PtsEquipe-PtsEquipeAdversario==-1 )                                   {probGM=10;probGS=11;}
            if(PtsEquipe-PtsEquipeAdversario<=-2 && PtsEquipe-PtsEquipeAdversario>-4){probGM=7;probGS=13;}
            if(PtsEquipe-PtsEquipeAdversario<=-4 && PtsEquipe-PtsEquipeAdversario>-6){probGM=5;probGS=15;}
            if(PtsEquipe-PtsEquipeAdversario<=-6)                                     {probGM=3;probGS=16;}}
        //TIME NORMAL
        if(posturaDoTime==2){
        if(PtsEquipe-PtsEquipeAdversario>=6)                                    {probGM=20;probGS=6;} //marca 4 e toma 0,3 gols por jogo
        if(PtsEquipe-PtsEquipeAdversario<6 && PtsEquipe-PtsEquipeAdversario>=4){probGM=17;probGS=8;}
        if(PtsEquipe-PtsEquipeAdversario<4 && PtsEquipe-PtsEquipeAdversario>=2){probGM=16;probGS=10;}
        if(PtsEquipe-PtsEquipeAdversario==1)                                     {probGM=14;probGS=12;}
        if(PtsEquipe-PtsEquipeAdversario==0)                                     {probGM=13;probGS=13;}
        if(PtsEquipe-PtsEquipeAdversario==-1 )                                   {probGM=12;probGS=14;}
        if(PtsEquipe-PtsEquipeAdversario<=-2 && PtsEquipe-PtsEquipeAdversario>-4){probGM=10;probGS=16;}
        if(PtsEquipe-PtsEquipeAdversario<=-4 && PtsEquipe-PtsEquipeAdversario>-6){probGM=8;probGS=17;}
        if(PtsEquipe-PtsEquipeAdversario<=-6)                                     {probGM=6;probGS=20;}}
        //TIME NO ATAQUE
        if(posturaDoTime==3){
            if(PtsEquipe-PtsEquipeAdversario>=6)                                    {probGM=25;probGS=8;} //marca 4 e toma 0,3 gols por jogo
            if(PtsEquipe-PtsEquipeAdversario<6 && PtsEquipe-PtsEquipeAdversario>=4){probGM=20;probGS=10;}
            if(PtsEquipe-PtsEquipeAdversario<4 && PtsEquipe-PtsEquipeAdversario>=2){probGM=18;probGS=12;}
            if(PtsEquipe-PtsEquipeAdversario==1)                                     {probGM=16;probGS=13;}
            if(PtsEquipe-PtsEquipeAdversario==0)                                     {probGM=15;probGS=15;}
            if(PtsEquipe-PtsEquipeAdversario==-1 )                                   {probGM=14;probGS=18;}
            if(PtsEquipe-PtsEquipeAdversario<=-2 && PtsEquipe-PtsEquipeAdversario>-4){probGM=12;probGS=20;}
            if(PtsEquipe-PtsEquipeAdversario<=-4 && PtsEquipe-PtsEquipeAdversario>-6){probGM=10;probGS=25;}
            if(PtsEquipe-PtsEquipeAdversario<=-6)                                     {probGM=8;probGS=30;}}
            gol=new Random().nextInt(900);
            if(gol<=probGM && MeuGolMarcado<5){MeuGolMarcado++;}
            else {//Os dois times não podem fazer gol no mesmo minuto
                gol = new Random().nextInt(900);
                if (gol <= probGS && MeuGolSofrido < 5) {
                    MeuGolSofrido++;
                }
            }
    }
    public ArrayList<Integer> ObterChave(Integer rodada){
        ArrayList<Integer> chave = new ArrayList<>();
        int chave1=0,chave2=0,chave3=0,chave4=0,chave5=0,chave6=0,chave7=0,chave8=0,chave9=0,chave10=0,chave11=0,chave12=0,chave13=0,chave14=0,chave15=0,chave16=0;
        if(rodada==1){//verifica o numero do meu time e ve qual a posição dele
            chave1= 1;chave2=2;               chave3= 3;chave4=4;             chave5= 5;chave6=6;            chave7= 7;chave8=8;
            chave9= 9;chave10=10;             chave11= 11;chave12=12;         chave13= 13;chave14=14;        chave15= 15;chave16=16;        }
        if(rodada==2){
            chave1= 1;chave2=6;               chave3= 3;chave4=14;             chave5= 5;chave6=4;            chave7= 7;chave8=12;
            chave9= 11;chave10=8;             chave11= 13;chave12=10;         chave13= 15;chave14=2;        chave15= 9;chave16=16;           }
        if(rodada==3){
            chave1= 1;chave2=10;               chave3= 2;chave4=3;             chave5= 4;chave6=11;            chave7= 5;chave8=16;
            chave9= 6;chave10=7;             chave11= 8;chave12=12;         chave13= 9;chave14=14;        chave15= 13;chave16=15;            }
        if(rodada==4){
            chave1= 1;chave2=11;               chave3= 2;chave4=8;             chave5= 3;chave6=15;            chave7= 4;chave8=6;
            chave9= 5;chave10=14;             chave11= 7;chave12=16;         chave13= 9;chave14=13;        chave15= 10;chave16=12;            }
        if(rodada==5){
            chave1= 1;chave2=13;               chave3= 2;chave4=16;             chave5= 3;chave6=5;            chave7= 4;chave8=9;
            chave9= 6;chave10=8;             chave11= 7;chave12=11;         chave13= 15;chave14=12;        chave15= 10;chave16=14;            }
        if(rodada==6){
            chave1= 1;chave2=14;               chave3= 2;chave4=13;             chave5= 3;chave6=7;            chave7= 4;chave8=16;
            chave9= 6;chave10=12;             chave11= 5;chave12=11;         chave13= 9;chave14=8;        chave15= 10;chave16=15;            }
        if(rodada==7){
            chave1= 1;chave2=15;               chave3= 2;chave4=7;             chave5= 3;chave6=8;            chave7= 4;chave8=12;
            chave9= 6;chave10=13;             chave11= 5;chave12=9;         chave13= 16;chave14=14;        chave15= 10;chave16=11;            }
        if(rodada==8){
            chave1= 1;chave2=9;               chave3= 2;chave4=5;             chave5= 3;chave6=12;            chave7= 4;chave8=8;
            chave9= 6;chave10=10;             chave11= 7;chave12=13;         chave13= 15;chave14=14;        chave15= 16;chave16=11;            }
        if(rodada==9){
            chave1= 1;chave2=5;               chave3= 2;chave4=14;             chave5= 3;chave6=6;            chave7= 4;chave8=7;
            chave9= 8;chave10=10;             chave11= 11;chave12=13;         chave13= 15;chave14=9;        chave15= 16;chave16=12;            }
        if(rodada==10){
            chave1= 1;chave2=7;               chave3= 2;chave4=6;             chave5= 3;chave6=13;            chave7= 4;chave8=10;
            chave9= 8;chave10=16;             chave11= 11;chave12=9;         chave13= 5;chave14=15;        chave15= 14;chave16=12;            }
        if(rodada==11){
            chave1= 1;chave2=4;               chave3= 2;chave4=12;             chave5= 3;chave6=9;            chave7= 5;chave8=13;
            chave9= 8;chave10=15;             chave11= 11;chave12=14;         chave13= 6;chave14=16;        chave15= 7;chave16=10;            }
        if(rodada==12){
            chave1= 1;chave2=12;               chave3= 2;chave4=4;             chave5= 3;chave6=16;            chave7= 5;chave8=10;
            chave9= 8;chave10=13;             chave11= 11;chave12=15;         chave13= 6;chave14=14;        chave15= 7;chave16=9;             }
        if(rodada==13){
            chave1= 1;chave2=8;               chave3= 2;chave4=11;             chave5= 3;chave6=10;            chave7= 4;chave8=14;
            chave9= 16;chave10=13;             chave11= 9;chave12=12;         chave13= 6;chave14=15;        chave15= 7;chave16=5;            }
        if(rodada==14){
            chave1= 1;chave2=3;               chave3= 2;chave4=9;             chave5= 5;chave6=12;            chave7= 4;chave8=13;
            chave9= 16;chave10=10;             chave11= 8;chave12=14;         chave13= 6;chave14=11;        chave15= 7;chave16=15;            }
        if(rodada==15){
            chave1= 1;chave2=16;               chave3= 2;chave4=10;             chave5= 5;chave6=8;            chave7= 4;chave8=15;
            chave9= 6;chave10=9;             chave11= 12;chave12=13;         chave13= 3;chave14=11;        chave15= 7;chave16=14;            }

        if(rodada==16){chave1= 1;chave2=2;               chave3= 3;chave4=4;         }
        if(rodada==17){chave1= 1;chave2=3;               chave3= 4;chave4=2;         }
        if(rodada==18){chave1= 1;chave2=4;               chave3= 3;chave4=2;         }
        if(rodada==19){chave1= 1;chave2=2;               chave3= 3;chave4=4;         }
        if(rodada==20){chave1= 1;chave2=3;               chave3= 4;chave4=2;         }
        if(rodada==21){chave1= 1;chave2=4;               chave3= 3;chave4=2;         }

        chave.add(0);
        chave.add(chave1);chave.add(chave2);chave.add(chave3);chave.add(chave4);
        if(rodada<max){
            chave.add(chave5);chave.add(chave6);chave.add(chave7);chave.add(chave8);
            chave.add(chave9);chave.add(chave10);chave.add(chave11);chave.add(chave12);
            chave.add(chave13);chave.add(chave14);chave.add(chave15);chave.add(chave16);}

        return chave; //lista dos adversario
    }

}
