package com.example.teste1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;

public class Activity4 extends AppCompatActivity {
    private AlertDialog alerta;
    String a4="";
    int scoreJogo;
    int ano,rodada=1,expectativa;
    float dinheiro ;
    int rodadaOitavas=22,rodadaQuartas=23,rodadaSemi=24,rodadaFinal=25;
    float ValorEquipe ;
    int max=16, max2, posicao;
    String meutime,adversario;
    String stringAuxiliar;int auxiliar;
    int campeonato,qualcampeonato;
    int minhaPosicaoMataMata;
    ArrayList<String> historicoCampeonatos = new ArrayList<>();
    ArrayList<String> times = new ArrayList<>();
    ArrayList<Integer> chave = new ArrayList<>();
    ArrayList<Integer> pontos = new ArrayList<>();
    ArrayList<Integer> PtsEquipe = new ArrayList<>();
    ArrayList<Integer> PtsEquipeOrdem = new ArrayList<>();
    ArrayList<String> timesOrdem= new ArrayList<>(times);

    ArrayList<String> timesLibertadores = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadores = new ArrayList<>();
    ArrayList<String> timesChampions = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampions = new ArrayList<>();

    ArrayList<String> timesChampionsOrdem = new ArrayList<>(timesChampions);
    ArrayList<Integer> PtsEquipeChampionsOrdem = new ArrayList<>(PtsEquipeChampions);
    ArrayList<String> timesChampionsOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsOitavas = new ArrayList<>();
    ArrayList<String> timesChampionsQuartas = new ArrayList<>();
    ArrayList<String> timesChampionsSemifinal = new ArrayList<>();
    ArrayList<String> timesChampionsFinal = new ArrayList<>();

    ArrayList<String> timesLibertadoresOrdem = new ArrayList<>(timesLibertadores);
    ArrayList<Integer> PtsEquipeLibertadoresOrdem = new ArrayList<>(PtsEquipeLibertadores);
    ArrayList<String> timesLibertadoresOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresOitavas = new ArrayList<>();
    ArrayList<String> timesLibertadoresQuartas = new ArrayList<>();
    ArrayList<String> timesLibertadoresSemifinal = new ArrayList<>();
    ArrayList<String> timesLibertadoresFinal = new ArrayList<>();

    ArrayList<String> historicoMeuLibertadores = new ArrayList<>();//para fazer o score no final da temporada
    ArrayList<String> historicoMeuChampions = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        times = globalVariable.SaberTimes();
        meutime = globalVariable.Sabermeutime();
        dinheiro = globalVariable.SaberDinheiro();
        rodada = globalVariable.SaberRodada();
        campeonato = globalVariable.SaberCampeonato();
        pontos = globalVariable.SaberPontos();
        posicao = globalVariable.SaberPosicao();
        ano = globalVariable.SaberAno();
        max = globalVariable.SaberMax();
        max2 = globalVariable.SaberMax2();
        PtsEquipe = globalVariable.SaberPtsEquipe();
        PtsEquipeOrdem = globalVariable.SaberPtsEquipeOrdem();
        qualcampeonato = globalVariable.SaberQualCampeonato();
        minhaPosicaoMataMata=globalVariable.SaberMinhaPosicaoMataMata();
        ///////////////////////////////////////////////////////////////////////////////
        //                    COMEÇAR  NOVO ANO                     //
        ///////////////////////////////////////////////////////////////////////////////
        //                    DEFINIR TIMES OITAVAS DE FINAL        //
        ////////////////////////////////////////////////////////////////////////////
        if(rodada==rodadaOitavas){
            //CHAMPIONS
            timesChampionsOrdem = globalVariable.SabertimesChampionsOrdem();
            PtsEquipeChampionsOrdem = globalVariable.SaberPtsEquipeChampionsOrdem();
            timesChampionsOitavas.add("");
            PtsEquipeChampionsOitavas.add(0);
            for(int i=1; i<=32; i=i+8){//1º contra 2º do outro grupo
                timesChampionsOitavas.add(timesChampionsOrdem.get(i));PtsEquipeChampionsOitavas.add(PtsEquipeChampionsOrdem.get(i));
                timesChampionsOitavas.add(timesChampionsOrdem.get(i+5));PtsEquipeChampionsOitavas.add(PtsEquipeChampionsOrdem.get(i+5));
                timesChampionsOitavas.add(timesChampionsOrdem.get(i+1));PtsEquipeChampionsOitavas.add(PtsEquipeChampionsOrdem.get(i+1));
                timesChampionsOitavas.add(timesChampionsOrdem.get(i+4));PtsEquipeChampionsOitavas.add(PtsEquipeChampionsOrdem.get(i+4));}
            globalVariable.DefinirTimesChampionsOitavas(timesChampionsOitavas);
            globalVariable.DefinirPtsEquipeChampionsOitavas(PtsEquipeChampionsOitavas);
            globalVariable.ZerarGolsMataMataChampions();

            if(globalVariable.SaberQualCampeonato()==1){
                globalVariable.DefinirMinhaPosicaoMataMata(-1); //inicializa
                for(int i=1; i<=16; i++){                if(timesChampionsOitavas.get(i).equals(meutime))globalVariable.DefinirMinhaPosicaoMataMata(i);            }
                minhaPosicaoMataMata=globalVariable.SaberMinhaPosicaoMataMata();
            }
            if(globalVariable.SaberMinhaPosicaoMataMata()<0 && globalVariable.SaberPosicaoChampions()>0){
            globalVariable.DefinirHistoricoMeuChampions(32);}
            globalVariable.DefinirPosicaoChampions(-1);


            //LIBERTADORES
            timesLibertadoresOrdem = globalVariable.SabertimesLibertadoresOrdem();
            PtsEquipeLibertadoresOrdem = globalVariable.SaberPtsEquipeLibertadoresOrdem();
            timesLibertadoresOitavas.add("");
            PtsEquipeLibertadoresOitavas.add(0);
            for(int i=1; i<=32; i=i+8){//1º contra 2º do outro grupo
                timesLibertadoresOitavas.add(timesLibertadoresOrdem.get(i));PtsEquipeLibertadoresOitavas.add(PtsEquipeLibertadoresOrdem.get(i));
                timesLibertadoresOitavas.add(timesLibertadoresOrdem.get(i+5));PtsEquipeLibertadoresOitavas.add(PtsEquipeLibertadoresOrdem.get(i+5));
                timesLibertadoresOitavas.add(timesLibertadoresOrdem.get(i+1));PtsEquipeLibertadoresOitavas.add(PtsEquipeLibertadoresOrdem.get(i+1));
                timesLibertadoresOitavas.add(timesLibertadoresOrdem.get(i+4));PtsEquipeLibertadoresOitavas.add(PtsEquipeLibertadoresOrdem.get(i+4));}
            globalVariable.DefinirTimesLibertadoresOitavas(timesLibertadoresOitavas);
            globalVariable.DefinirPtsEquipeLibertadoresOitavas(PtsEquipeLibertadoresOitavas);
            globalVariable.ZerarGolsMataMataLibertadores();

            if(globalVariable.SaberQualCampeonato()==2){
                globalVariable.DefinirMinhaPosicaoMataMata(-1); //inicializa
                for(int i=1; i<=16; i++){                if(timesLibertadoresOitavas.get(i).equals(meutime))globalVariable.DefinirMinhaPosicaoMataMata(i);            }
                minhaPosicaoMataMata=globalVariable.SaberMinhaPosicaoMataMata();
            }
            if(globalVariable.SaberMinhaPosicaoMataMata()<0 && globalVariable.SaberPosicaoLibertadores()>0){
                globalVariable.DefinirHistoricoMeuLibertadores(32);}
            globalVariable.DefinirPosicaoLibertadores(-1);

        }
        ///////////////////////////////////////////////////////////////////////////////
        //            //REBAIXAMENTO + //NOVO ANO no final                      //
        ///////////////////////////////////////////////////////////////////////////////
        if(rodada==26){
            //HISTORICO Champions League
            ArrayList<String> historicoChampionsLeague = globalVariable.SaberTimesChampionsFinal();
            globalVariable.DefinirHistoricoChampionsLeague(historicoChampionsLeague.get(1));
            globalVariable.DefinirHistoricoChampionsLeague(historicoChampionsLeague.get(2));
            //HISTORICO Libertadores
            ArrayList<String> historicoLibertadores = globalVariable.SaberTimesLibertadoresFinal();
            globalVariable.DefinirHistoricoLibertadores(historicoLibertadores.get(1));
            globalVariable.DefinirHistoricoLibertadores(historicoLibertadores.get(2));

            timesOrdem = globalVariable.SabertimesOrdem();

            //VERIFICA A EXPECTATIVA
            expectativa=globalVariable.SaberExpectativa();
            if(timesOrdem.indexOf(meutime)%max > expectativa || timesOrdem.indexOf(meutime)%max==0){
                a4="TEMPORADA PASSADA: \nRUIM: "+timesOrdem.indexOf(meutime)%max+"º/Esperado: "+expectativa+"º";
            }
            else{
                a4="TEMPORADA PASSADA: \nBOM: "+timesOrdem.indexOf(meutime)%max+"º/Esperado: "+expectativa+"º";
            }
            scoreJogo= 10* (timesOrdem.indexOf(meutime)%max - expectativa) * 5 *(timesOrdem.indexOf(meutime)%max - expectativa);
            if(timesOrdem.indexOf(meutime)%max > expectativa){scoreJogo=-scoreJogo;}
            globalVariable.DefinirScoreJogo(scoreJogo);
            historicoMeuChampions=globalVariable.SaberHistoricoMeuChampions();
            historicoMeuLibertadores=globalVariable.SaberHistoricoMeuLibertadores();
            globalVariable.DefinirScoreJogoInternacional(globalVariable.historicoMeuChampions.get(ano-2020));
            globalVariable.DefinirScoreJogoInternacional(globalVariable.historicoMeuLibertadores.get(ano-2020));


            //MUDA TIMES DE DIVISÃO trocando seus nomes
            ArrayList<Integer> x = new ArrayList<>();            x.add(0);            x.add(14);            x.add(15);                      x.add(16);                        x.add(30);                      x.add(31);            x.add(32);
            ArrayList<Integer> y = new ArrayList<>();            y.add(0);            y.add((max * 9) + 1); y.add((max * 9) + 2);            y.add((max * 9) + 3);            y.add((max * 8) + 1);            y.add((max * 8) + 2); y.add((max * 8) + 3);
            if (timesOrdem.indexOf(meutime) == (max * 9) + 1 || timesOrdem.indexOf(meutime) == (max * 9) + 2|| timesOrdem.indexOf(meutime) == (max * 9) + 3) {                campeonato = 1;            }//acesso brasil
            if (timesOrdem.indexOf(meutime) == (max * 8) + 1 || timesOrdem.indexOf(meutime) == (max * 8) + 2|| timesOrdem.indexOf(meutime) == (max * 8) + 3) {                campeonato = 2;            }//acesso inglaterra
            if (timesOrdem.indexOf(meutime) == 30 ||timesOrdem.indexOf(meutime) == 31 || timesOrdem.indexOf(meutime) == 32) {                campeonato = 9;            } // rebaixado inglaterra
            if (timesOrdem.indexOf(meutime) == 14|| timesOrdem.indexOf(meutime) == 15 || timesOrdem.indexOf(meutime) == 16) {                campeonato = 10;            }//rebaixado brasil
            globalVariable.DefinirCampeonato(campeonato);
            for (int k = 1; k < x.size(); k++) {
                for (int todos = 1; todos <= max * 2; todos++) {  //busca todos os times
                    if (times.get(todos).equals(timesOrdem.get(x.get(k)))) {  //ve a posição do time e compara com a posição de rebaixamento
                        for (int todos1 = max * 7; todos1 <= max * 11; todos1++) { //procura outros times
                            if (times.get(todos1).equals(timesOrdem.get(y.get(k)))) {  //ve a posição do  outro time e compara com a posição de acesso
                                if (timesOrdem.get(x.get(k)).equals(meutime)) {                                    posicao = todos1 % 16;                                }
                                if (timesOrdem.get(y.get(k)).equals(meutime)) {                                    posicao = todos % 16;                                }
                                stringAuxiliar = times.get(todos);                                times.set(todos, times.get(todos1));                                times.set(todos1, stringAuxiliar);
                                auxiliar = PtsEquipe.get(todos);                         PtsEquipe.set(todos, PtsEquipe.get(todos1));                                PtsEquipe.set(todos1, auxiliar);
                            }
                        }
                    }
                }
            }

            //Atualiza o OVERALL AS EQUIPES
            for (int i = 0; i <= max * max2; i++) {
                int j = new Random().nextInt(3) - 1;
                if (PtsEquipe.get(i) + j <= 86 && PtsEquipe.get(i) + j >= 68) {    //Se não for muito alto ou muito baixo
                    if(PtsEquipe.get(i) + j <= 82 && (i<=max || i>= max*9) ) //Libertadores no máximo 82
                    globalVariable.DefinirPtsEquipe(PtsEquipe.get(i) + j, i);
                }
            }
            //RANDOMIZA A ORDEM DOS ADVERSARIOS
            for (int i = 1; i <= max ; i++) {
                int j = new Random().nextInt(15) + 1;
                if (posicao != j && posicao!=i) {    //Se não for muito alto ou muito baixo
                    int k=max*(campeonato-1)+i;
                    j=max*(campeonato-1)+j;
                    stringAuxiliar = times.get(k);                                times.set(k, times.get(j));                                times.set(j, stringAuxiliar);
                    auxiliar = PtsEquipe.get(k);                         PtsEquipe.set(k, PtsEquipe.get(j));                                PtsEquipe.set(j, auxiliar);
                }            }
            globalVariable.DefinirPosicao(posicao);
            globalVariable.DefinirTimes(times);

            //SALVA TABELA DO CAMPEONATO
            historicoCampeonatos=globalVariable.SaberHistoricoCampeonatos();
            if(ano==2020){historicoCampeonatos.add("");}
            for(int i=1;i<=max2;i++){
                for(int j=1;j<=max;j++) {
                    historicoCampeonatos.add(timesOrdem.get(max*(i-1)+j));
                }
            }
            globalVariable.DefinirHistoricoCampeonatos(historicoCampeonatos);




            //NOVO ANO
            globalVariable.ZerarPontos();
            globalVariable.ZerarGols();
            globalVariable.DefinirOrdem();
            globalVariable.DefinirQualCampeonato(0);
            ano++;
            globalVariable.DefinirAno(ano);
            rodada=1;
            globalVariable.DefinirRodada(rodada);
            //MEU ADVERSARIO DA RODADA
            chave = ObterChave(1);
            globalVariable.DefinirChave(chave);
            globalVariable.DefinirTransferenciaTecnico(0); //reseta a transferencia de time
        }

        //EXPECTATIVA COMEÇO DO CAMPEONATO
        if(rodada==1) {
            expectativa = globalVariable.DefinirExpectativa();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Expectativa para a temporada");
            String a1,a2,a3="";
            a1=String.valueOf(expectativa) + "º Lugar";
            if(campeonato==1 || campeonato>=10)                a2="LIBERTADORES:";
            else                                               a2="CHAMPIONS LEAGUE:";
            if(expectativa<=8){                a3="Fase de grupos";            }
            if(expectativa<=4){                a3="Oitavas";            }
            if(expectativa<=2){                a3="Quartas";            }
            if(expectativa>8 || campeonato==9 || campeonato==10){                a3="Não temos expectativa";            }
            builder.setMessage(a1+"\n\n"+a2+"\n"+a3+"\n\n\n"+a4);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alerta=builder.create();
            alerta.show();

        }
        expectativa = globalVariable.DefinirExpectativa();
        TextView textoExpectativa = findViewById(R.id.textoExpectativa);
        textoExpectativa.setText("Expectativa: "+expectativa+"º lugar");
        ///////////////////////////////////////////////////////////////////////////////
                    //                      MENU                      //
        ///////////////////////////////////////////////////////////////////////////////
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(meutime);
        //IMAGENS
        ImageView imageLogo = findViewById(R.id.Logo);
        globalVariable.imageLogo(globalVariable.Sabermeutime(), imageLogo);
        imageLogo = findViewById(R.id.Uniforme);
        globalVariable.imageKIT(globalVariable.Sabermeutime(), imageLogo);
        imageLogo = findViewById(R.id.Estadio);
        globalVariable.imageEstadio(globalVariable.Sabermeutime(), imageLogo);

        //https://www.dcode.fr/lagrange-interpolating-polynomial
        float meuOverall = PtsEquipe.get((max * (campeonato - 1)) + posicao);
        ValorEquipe = (meuOverall * meuOverall * 667 / 100) - (meuOverall * 19011 / 20) + 33900;

        TextView textoPontos = findViewById(R.id.textoPontos);
        textoPontos.setText(String.valueOf(pontos.get((max * (campeonato - 1)) + posicao))+"pts");

        //TEXTO DO MENU
        TextView textoDinheiro = findViewById(R.id.textoDinheiro);
        TextView textoPtsEquipeInicial = findViewById(R.id.textoPtsEquipe);
        TextView textoValorEquipe = findViewById(R.id.textoValorEquipe);
        TextView textoAno = findViewById(R.id.textoAno);
        textoAno.setText("Ano: " + ano);
        textoDinheiro.setText("Dinheiro: " + String.format("%.1f", dinheiro) + "milhões");
        textoPtsEquipeInicial.setText("Overall da Equipe: " + PtsEquipe.get((max * (campeonato - 1)) + posicao));
        textoValorEquipe.setText("Valor da Equipe: " + String.format("%.1f", ValorEquipe) + "milhões");
        //Rating BAR
        RatingBar ratingBar = findViewById(R.id.estrelas);
        if (PtsEquipe.get((max * (campeonato - 1)) + posicao) >= 83) {            ratingBar.setRating(5.0f);
        } else if (PtsEquipe.get((max * (campeonato - 1)) + posicao) >= 80) {            ratingBar.setRating(4.0f);
        } else if (PtsEquipe.get((max * (campeonato - 1)) + posicao) >= 76) {            ratingBar.setRating(3.0f);
        } else if (PtsEquipe.get((max * (campeonato - 1)) + posicao) >= 72) {            ratingBar.setRating(2.0f);
        } else if (PtsEquipe.get((max * (campeonato - 1)) + posicao) >= 68) {            ratingBar.setRating(1.0f);
        }

        ///////////////////////////////////////////////////////////////////////////////
        //                    CHAMPIONS LEAGUE  E LIBERTADORES                       //
        //RODADA 16 Champions LEague +  Meu Histórico
        ///////////////////////////////////////////////////////////////////////////////
            if (rodada == max) {
                globalVariable.DefinirOrdem();
                timesOrdem = globalVariable.SabertimesOrdem();
            //DEFINE TIMES CHAMPIONS LEAGUE
                if(1==1){
            timesChampions.clear();
            timesChampions.add("");
            //campeonato Ingles -italiano -espnahol - alemao - frances -europa -leste europeu
            timesChampions.add(timesOrdem.get((max * 1) + 1));            timesChampions.add(timesOrdem.get((max * 6) + 1));            timesChampions.add(timesOrdem.get((max * 1) + 3));            timesChampions.add(timesOrdem.get((max * 1) + 4));
            timesChampions.add(timesOrdem.get((max * 2) + 1));            timesChampions.add(timesOrdem.get((max * 6) + 5));            timesChampions.add(timesOrdem.get((max * 2) + 3));
            timesChampions.add(timesOrdem.get((max * 2) + 4));            timesChampions.add(timesOrdem.get((max * 3) + 1));            timesChampions.add(timesOrdem.get((max * 7) + 3));
            timesChampions.add(timesOrdem.get((max * 3) + 3));            timesChampions.add(timesOrdem.get((max * 3) + 4));            timesChampions.add(timesOrdem.get((max * 4) + 1));
            timesChampions.add(timesOrdem.get((max * 4) + 2));            timesChampions.add(timesOrdem.get((max * 4) + 3));            timesChampions.add(timesOrdem.get((max * 4) + 4));
            timesChampions.add(timesOrdem.get((max * 5) + 1));            timesChampions.add(timesOrdem.get((max * 5) + 2));            timesChampions.add(timesOrdem.get((max * 5) + 3));
            timesChampions.add(timesOrdem.get((max * 5) + 4));            timesChampions.add(timesOrdem.get((max * 1) + 2));            timesChampions.add(timesOrdem.get((max * 6) + 2));
            timesChampions.add(timesOrdem.get((max * 6) + 3));            timesChampions.add(timesOrdem.get((max * 6) + 4));            timesChampions.add(timesOrdem.get((max * 2) + 2));
            timesChampions.add(timesOrdem.get((max * 6) + 6));            timesChampions.add(timesOrdem.get((max * 7) + 1));            timesChampions.add(timesOrdem.get((max * 7) + 2));
            timesChampions.add(timesOrdem.get((max * 3) + 2));            timesChampions.add(timesOrdem.get((max * 7) + 4));            timesChampions.add(timesOrdem.get((max * 7) + 5));
            timesChampions.add(timesOrdem.get((max * 7) + 6));

            //Overall CHAMPIONS LEAGUE
            PtsEquipeChampions.clear();
            PtsEquipeChampions.add(0);
            //campeonato Ingles -italiano -espnahol - alemao - frances -europa -leste europeu
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 1) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 6) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 1) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 1) + 4));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 2) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 6) + 5));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 2) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 2) + 4));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 3) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 7) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 3) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 3) + 4));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 4) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 4) + 2));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 4) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 4) + 4));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 5) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 5) + 2));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 5) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 5) + 4));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 1) + 2));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 6) + 2));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 6) + 3));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 6) + 4));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 2) + 2));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 6) + 6));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 7) + 1));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 7) + 2));
            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 3) + 2));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 7) + 4));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 7) + 5));            PtsEquipeChampions.add(PtsEquipeOrdem.get((max * 7) + 6));

            //SORTEIA OS TIMES
            for (int i = 0; i <= 100; i++) {
                int j = new Random().nextInt(32) + 1;
                int k = new Random().nextInt(32) + 1;
                if (j % 4 != 1 && k % 4 != 1) {  // não muda os cabeças de chave
                    stringAuxiliar = timesChampions.get(j);                    timesChampions.set(j, timesChampions.get(k));                    timesChampions.set(k, stringAuxiliar);
                    auxiliar = PtsEquipeChampions.get(j);                    PtsEquipeChampions.set(j, PtsEquipeChampions.get(k));                    PtsEquipeChampions.set(k, auxiliar);
                }
            }
            //Se meu time estiver na Champions
            globalVariable.DefinirPosicaoChampions(-1);
            for (int i = 1; i <= 32; i++) {
                if (timesChampions.get(i).equals(meutime))
                    globalVariable.DefinirPosicaoChampions(i);
            }
                //Se não estiver salva no histórico que não participei dela
                if(globalVariable.SaberPosicaoChampions()<0){
                    globalVariable.DefinirHistoricoMeuChampions(0);}
}

                //DEFINE TIMES LIBERTADORES
                if(1==1){
                timesLibertadores.clear();
                timesLibertadores.add("");
                //campeonato BR 8 ARG 6 SULAMERICANO 12 COL/MX 6
                timesLibertadores.add(timesOrdem.get((max * 0) + 1));timesLibertadores.add(timesOrdem.get((max * 10) + 6));timesLibertadores.add(timesOrdem.get((max * 11) + 3));timesLibertadores.add(timesOrdem.get((max * 11) + 12));
                timesLibertadores.add(timesOrdem.get((max * 0) + 2));timesLibertadores.add(timesOrdem.get((max * 10) + 5));timesLibertadores.add(timesOrdem.get((max * 12) + 6));timesLibertadores.add(timesOrdem.get((max * 11) + 11));
                timesLibertadores.add(timesOrdem.get((max * 0) + 3));timesLibertadores.add(timesOrdem.get((max * 11) + 2));timesLibertadores.add(timesOrdem.get((max * 12) + 5));timesLibertadores.add(timesOrdem.get((max * 11) + 10));
                timesLibertadores.add(timesOrdem.get((max * 0) + 4));timesLibertadores.add(timesOrdem.get((max * 11) + 1));timesLibertadores.add(timesOrdem.get((max * 12) + 4));timesLibertadores.add(timesOrdem.get((max * 11) + 9));
                timesLibertadores.add(timesOrdem.get((max * 0) + 5));timesLibertadores.add(timesOrdem.get((max * 10) + 4));timesLibertadores.add(timesOrdem.get((max * 12) + 1));timesLibertadores.add(timesOrdem.get((max * 11) + 8));
                timesLibertadores.add(timesOrdem.get((max * 0) + 6));timesLibertadores.add(timesOrdem.get((max * 10) + 3));timesLibertadores.add(timesOrdem.get((max * 12) + 2));timesLibertadores.add(timesOrdem.get((max * 11) + 7));
                timesLibertadores.add(timesOrdem.get((max * 0) + 7));timesLibertadores.add(timesOrdem.get((max * 10) + 2));timesLibertadores.add(timesOrdem.get((max * 12) + 3));timesLibertadores.add(timesOrdem.get((max * 11) + 6));
                timesLibertadores.add(timesOrdem.get((max * 0) + 8));timesLibertadores.add(timesOrdem.get((max * 10) + 1));timesLibertadores.add(timesOrdem.get((max * 11) + 4));timesLibertadores.add(timesOrdem.get((max * 11) + 5));

                //PTS LIBERTADORES
                PtsEquipeLibertadores.clear();
                PtsEquipeLibertadores.add(0);
                //campeonato BR 8 ARG 6 SULAMERICANO 12 COL/MX 6
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 1));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 10) + 6));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 3));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 12));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 2));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 10) + 5));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 12) + 6));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 11));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 3));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 2));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 12) + 5));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 10));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 4));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 1));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 12) + 4));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 9));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 5));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 10) + 4));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 12) + 1));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 8));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 6));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 10) + 3));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 12) + 2));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 7));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 7));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 10) + 2));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 12) + 3));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 6));
                    PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 0) + 8));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 10) + 1));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 4));PtsEquipeLibertadores.add(PtsEquipeOrdem.get((max * 11) + 5));

                    //Se meu time estiver na Libertadores
                globalVariable.DefinirPosicaoLibertadores(-1);
                for (int i = 1; i <= 32; i++) {
                    if (timesLibertadores.get(i).equals(meutime))
                        globalVariable.DefinirPosicaoLibertadores(i);
                }

            //Se não estiver salva no histórico que não participei dela
            if(globalVariable.SaberPosicaoLibertadores()<0){
                    globalVariable.DefinirHistoricoMeuLibertadores(0);}
}

            if(campeonato==2 || campeonato <10)globalVariable.DefinirQualCampeonato(1);//1 =champions 0= nacional 2 =libertadores
            globalVariable.DefinirTimesChampions(timesChampions);
            globalVariable.DefinirPtsEquipeChampions(PtsEquipeChampions);
            globalVariable.ZerarGolsChampions();
            globalVariable.ZerarPontosTotalChampions();

            if(campeonato==1 || campeonato >=10)globalVariable.DefinirQualCampeonato(2);//1 =champions 0= nacional 2 =libertadores
            globalVariable.DefinirTimesLibertadores(timesLibertadores);
            globalVariable.DefinirPtsEquipeLibertadores(PtsEquipeLibertadores);
            globalVariable.ZerarGolsLibertadores();
            globalVariable.ZerarPontosTotalLibertadores();
            globalVariable.DefinirOrdemLibertadores();
                 }
        //ListView listView = findViewById(R.id.lista);
        //ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,globalVariable.SaberHistoricoMeuLibertadores());
        //listView.setAdapter(listAdapter);

    }

    public void onResume() {
        super.onResume();
        //DADOS GLOBAIS
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        times= globalVariable.SaberTimes();
        meutime  = globalVariable.Sabermeutime();
        dinheiro  = globalVariable.SaberDinheiro();
        rodada= globalVariable.SaberRodada();
        campeonato = globalVariable.SaberCampeonato();
        pontos = globalVariable.SaberPontos();
        posicao = globalVariable.SaberPosicao();
        ano = globalVariable.SaberAno();
        globalVariable.DefinirOrdem();
        timesOrdem = globalVariable.SabertimesOrdem();
        PtsEquipe = globalVariable.SaberPtsEquipe();
        PtsEquipeOrdem = globalVariable.SaberPtsEquipeOrdem();
        qualcampeonato=globalVariable.SaberQualCampeonato();
        timesChampions=globalVariable.SaberTimesChampions();
        timesLibertadores=globalVariable.SaberTimesLibertadores();



        //MINHA PONTUAÇÃO E CLASSIFICAÇÃO
        int minhaposicao = timesOrdem.indexOf(meutime)%max;
        if(minhaposicao==0){minhaposicao=max;}

        TextView textoClasificacao = findViewById(R.id.textoClassificacao);
        textoClasificacao.setText(minhaposicao+"º");

        //////////////////////////////////////////////////////////////////////////
        //MEU ADVERSARIO DA RODADA
        ///////////////////////////////////////////////////////////////////////////
        chave=ObterChave(rodada);
        globalVariable.DefinirChave(chave);

        if(globalVariable.SaberQualCampeonato()==0){
        String adversario="";
        for( int i=1; i<=max; i=i+2){
        if(chave.get(i)==posicao) {adversario=times.get((max * (campeonato - 1)) + chave.get(i+1));}}
        for( int i=2; i<=max; i=i+2){
        if(chave.get(i)==posicao) {adversario=times.get((max * (campeonato - 1)) + chave.get(i-1));}}
        TextView textoProximoAdversario = findViewById(R.id.textoProximoAdversario);
        int posicaoAdversario = timesOrdem.indexOf(adversario)%max;
        if(posicaoAdversario==0){posicaoAdversario=max;}
        textoProximoAdversario.setText(adversario+"\n"+posicaoAdversario+"º");
        ImageView imageLogo = findViewById(R.id.logoAdversario);
        globalVariable.imageLogo(adversario,imageLogo);}

        //MEU ADVERSARIO DE GRUPOS CHAMPIONS
        if(globalVariable.SaberQualCampeonato()==1 && globalVariable.SaberPosicaoChampions()>0 && rodada<=21){
            String adversario="";
            chave = ObterChave(rodada);
            if(chave.get(1)==globalVariable.SaberPosicaoChampions()) {adversario=timesChampions.get((4 * (globalVariable.SaberMeuGrupoChampions() - 1)) + chave.get(2));}
            if(chave.get(2)==globalVariable.SaberPosicaoChampions()) {adversario=timesChampions.get((4 * (globalVariable.SaberMeuGrupoChampions() - 1)) + chave.get(1));}
            if(chave.get(3)==globalVariable.SaberPosicaoChampions()) {adversario=timesChampions.get((4 * (globalVariable.SaberMeuGrupoChampions() - 1)) + chave.get(4));}
            if(chave.get(4)==globalVariable.SaberPosicaoChampions()) {adversario=timesChampions.get((4 * (globalVariable.SaberMeuGrupoChampions() - 1)) + chave.get(3));}
            globalVariable.DefinirOrdemChampions();
            TextView textoProximoAdversario = findViewById(R.id.textoProximoAdversario);
            timesChampionsOrdem=globalVariable.SabertimesChampionsOrdem();
            int posicaoAdversario = timesChampionsOrdem.indexOf(adversario)%4;
            if(posicaoAdversario==0){posicaoAdversario=4;}
            textoProximoAdversario.setText(adversario+"\n"+posicaoAdversario+"º");
            ImageView imageLogo = findViewById(R.id.logoAdversario);
            globalVariable.imageLogo(adversario,imageLogo);
        }

        //MEU ADVERSARIO DE MATA-MATA CHAMPIONS
        if(globalVariable.SaberQualCampeonato()==1 && globalVariable.SaberMinhaPosicaoMataMata()>0 && rodada>21){
            //ADVERSARIO OITAVAS
            if(rodada==rodadaOitavas){
            timesChampionsOitavas=globalVariable.SaberTimesChampionsOitavas();
            for(int i=1;i<=16;i=i+2){
                if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                    adversario = timesChampionsOitavas.get(i+1);}}
            for(int i=2;i<=16;i=i+2){
                if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                    adversario = timesChampionsOitavas.get(i-1);}}   }
            //ADVERSARIO QUARTAS
            if(rodada==rodadaQuartas){
                timesChampionsQuartas=globalVariable.SaberTimesChampionsQuartas();
                for(int i=1;i<8;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesChampionsQuartas.get(i+1);}}
                for(int i=2;i<=8;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesChampionsQuartas.get(i-1);}}   }
            //ADVERSARIO SEMIFINAL
            if(rodada==rodadaSemi){
                timesChampionsSemifinal=globalVariable.SaberTimesChampionsSemifinal();
                for(int i=1;i<4;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesChampionsSemifinal.get(i+1);}}
                for(int i=2;i<=4;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesChampionsSemifinal.get(i-1);}}   }
            //ADVERSARIO FINAL
            if(rodada==rodadaFinal){
                timesChampionsFinal=globalVariable.SaberTimesChampionsFinal();
                    if(globalVariable.SaberMinhaPosicaoMataMata()==1){
                        adversario = timesChampionsFinal.get(2);}
                    if(globalVariable.SaberMinhaPosicaoMataMata()==2){
                        adversario = timesChampionsFinal.get(1);}
            }
            TextView textoProximoAdversario = findViewById(R.id.textoProximoAdversario);
            textoProximoAdversario.setText(adversario);
            ImageView imageLogo = findViewById(R.id.logoAdversario);
            globalVariable.imageLogo(adversario,imageLogo);
        }

        //MEU ADVERSARIO DE GRUPOS LIBERTADORES
        if(globalVariable.SaberQualCampeonato()==2 && globalVariable.SaberPosicaoLibertadores()>0 && rodada<=21){
            String adversario="";
            chave = ObterChave(rodada);
            if(chave.get(1)==globalVariable.SaberPosicaoLibertadores()) {adversario=timesLibertadores.get((4 * (globalVariable.SaberMeuGrupoLibertadores() - 1)) + chave.get(2));}
            if(chave.get(2)==globalVariable.SaberPosicaoLibertadores()) {adversario=timesLibertadores.get((4 * (globalVariable.SaberMeuGrupoLibertadores() - 1)) + chave.get(1));}
            if(chave.get(3)==globalVariable.SaberPosicaoLibertadores()) {adversario=timesLibertadores.get((4 * (globalVariable.SaberMeuGrupoLibertadores() - 1)) + chave.get(4));}
            if(chave.get(4)==globalVariable.SaberPosicaoLibertadores()) {adversario=timesLibertadores.get((4 * (globalVariable.SaberMeuGrupoLibertadores() - 1)) + chave.get(3));}
            globalVariable.DefinirOrdemLibertadores();
            TextView textoProximoAdversario = findViewById(R.id.textoProximoAdversario);
            timesLibertadoresOrdem=globalVariable.SabertimesLibertadoresOrdem();
            int posicaoAdversario = timesLibertadoresOrdem.indexOf(adversario)%4;
            if(posicaoAdversario==0){posicaoAdversario=4;}
            textoProximoAdversario.setText(adversario+"\n"+posicaoAdversario+"º");
            ImageView imageLogo = findViewById(R.id.logoAdversario);
            globalVariable.imageLogo(adversario,imageLogo);
        }

        //MEU ADVERSARIO DE MATA-MATA LIBERTADORES
        if(globalVariable.SaberQualCampeonato()==2 && globalVariable.SaberMinhaPosicaoMataMata()>0 && rodada>21){

            //ADVERSARIO OITAVAS
            if(rodada==rodadaOitavas){
                timesLibertadoresOitavas=globalVariable.SaberTimesLibertadoresOitavas();
                for(int i=1;i<=16;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesLibertadoresOitavas.get(i+1);}}
                for(int i=2;i<=16;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesLibertadoresOitavas.get(i-1);}}   }
            //ADVERSARIO QUARTAS
            if(rodada==rodadaQuartas){
                timesLibertadoresQuartas=globalVariable.SaberTimesLibertadoresQuartas();
                for(int i=1;i<8;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesLibertadoresQuartas.get(i+1);}}
                for(int i=2;i<=8;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesLibertadoresQuartas.get(i-1);}}   }
            //ADVERSARIO SEMIFINAL
            if(rodada==rodadaSemi){
                timesLibertadoresSemifinal=globalVariable.SaberTimesLibertadoresSemifinal();
                for(int i=1;i<4;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesLibertadoresSemifinal.get(i+1);}}
                for(int i=2;i<=4;i=i+2){
                    if(i==globalVariable.SaberMinhaPosicaoMataMata()){
                        adversario = timesLibertadoresSemifinal.get(i-1);}}   }
            //ADVERSARIO FINAL
            if(rodada==rodadaFinal){
                timesLibertadoresFinal=globalVariable.SaberTimesLibertadoresFinal();
                if(globalVariable.SaberMinhaPosicaoMataMata()==1){
                    adversario = timesLibertadoresFinal.get(2);}
                if(globalVariable.SaberMinhaPosicaoMataMata()==2){
                    adversario = timesLibertadoresFinal.get(1);}
            }
            TextView textoProximoAdversario = findViewById(R.id.textoProximoAdversario);
            textoProximoAdversario.setText(adversario);
            ImageView imageLogo = findViewById(R.id.logoAdversario);
            globalVariable.imageLogo(adversario,imageLogo);
        }
        //Se eu for Eliminado
        if(globalVariable.SaberQualCampeonato()>=1 && globalVariable.SaberMinhaPosicaoMataMata()<0 && globalVariable.SaberPosicaoLibertadores()<0 && globalVariable.SaberPosicaoChampions()<0 && rodada>=max) {
            TextView textoProximoAdversario = findViewById(R.id.textoProximoAdversario);
            textoProximoAdversario.setText("Fora das Competições");
        }
        //////////////////////////////////////////////////////////////////////////////////////////////
        //TEXTO CAMPEAO
        //compara posicao 1 do campeonato com o nome do seu time
        TextView textoCampeao = findViewById(R.id.textoCampeao);
        if(timesOrdem.get((max*(campeonato-1))+1).equals(times.get((max*(campeonato-1))+posicao))  && rodada>1){
            textoCampeao.setVisibility(View.VISIBLE);
            textoCampeao.setText("LÍDER");
        }
        else{textoCampeao.setVisibility(View.INVISIBLE);}

        //////////////////////////////////////////////////////////////////////////////////////////////
        //SALVA VARIAVEIS
        globalVariable.DefinirTimes(times);
        globalVariable.DefinirRodada(rodada);
        globalVariable.DefinirParametros(campeonato,dinheiro);
    }





    public void abrirActivity_Simulacao(View view){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if(globalVariable.SaberQualCampeonato()==0 || globalVariable.SaberPosicaoLibertadores()>0 ||globalVariable.SaberPosicaoChampions()>0 || globalVariable.SaberMinhaPosicaoMataMata()>0){//Se campeonato nacional, ou se meu time estiver na champions
            Intent intent = new Intent(this, Activity_Simulacao.class);
            startActivity(intent);
        }
        if(globalVariable.SaberQualCampeonato()>=1 && rodada<=21 && globalVariable.SaberPosicaoLibertadores()==-1 && globalVariable.SaberPosicaoChampions()==-1 && globalVariable.SaberMinhaPosicaoMataMata()==-1)  {
            Intent intent = new Intent(this, ActivityResultadosChampions.class);
        startActivity(intent);}
        if(globalVariable.SaberQualCampeonato()>=1 && rodada>21 && globalVariable.SaberPosicaoLibertadores()==-1 && globalVariable.SaberPosicaoChampions()==-1 && globalVariable.SaberMinhaPosicaoMataMata()==-1){
            Intent intent = new Intent(this, ActivityMataMataChampions.class);
            startActivity(intent);}

    }

    public void abrirActivityTabela(View view){
        Intent intent = new Intent(this, ActivityTabela.class);
        startActivity(intent);
    }

    public void abrirActivityJogadores(View view) {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if(rodada<max && globalVariable.SaberTransferenciaTecnico()==0) {
        Intent intent = new Intent(this, ActivityMudarClube.class);
        startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "ESPERE A PRÓXIMA TEMPORADA POR PROPOSTAS", Toast.LENGTH_SHORT).show();
        }
    }
    public void abrirActivityHistorico(View view) {
        Intent intent = new Intent(this, ActivityHistorico.class);
        startActivity(intent);
    }
    public void abrirActivityChampions(View view) {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        if(globalVariable.SaberQualCampeonato()>=1 || ano>2020){
        Intent intent = new Intent(this, ActivityTabInternacional.class);
        startActivity(intent);}
        else{
            if(campeonato==1 || campeonato>=10)
            Toast.makeText(getApplicationContext(), "A LIBERTADORES AINDA NÃO COMEÇOU", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "A CHAMPIONS AINDA NÃO COMEÇOU", Toast.LENGTH_SHORT).show();
        }

    }
    public void abrirActivityCompras(View view) {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        float preco =ValorEquipe/10;
        if(dinheiro<preco) {
            Toast.makeText(getApplicationContext(), "SEM DINHEIRO - PREÇO: "+preco, Toast.LENGTH_SHORT).show();
        }
        if(dinheiro>=preco) {
            dinheiro=dinheiro-preco;
            globalVariable.DefinirPtsEquipe(1+   PtsEquipe.get((max * (campeonato - 1)) + posicao),(max * (campeonato - 1)) + posicao);
            Toast.makeText(getApplicationContext(), "OVERALL DA EQUIPE ATUALIZADO", Toast.LENGTH_SHORT).show();
        }
        TextView textoPtsEquipeInicial = findViewById(R.id.textoPtsEquipe);
        textoPtsEquipeInicial.setText("Overall da Equipe: " + PtsEquipe.get((max * (campeonato - 1)) + posicao));
        TextView textoDinheiro = findViewById(R.id.textoDinheiro);
        textoDinheiro.setText("Dinheiro: " + String.format("%.1f", dinheiro) + "milhões");
        globalVariable.DefinirParametros(campeonato,dinheiro);
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
