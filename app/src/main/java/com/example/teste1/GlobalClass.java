package com.example.teste1;

import android.app.Application;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;

public class GlobalClass extends Application {
    String meutime;
    int pausa=50;//velocidade do jogo
    int max=16,max2=13, ano=2020;
    int expectativa=1;
    int scoreJogo=0;
    int campeonato,rodada=1, posicao;
    float dinheiro;
    int transferenciaTecnico=0;
    ArrayList<Integer> chave = new ArrayList<>();
    ArrayList<Integer> historicoMeuCampeonato = new ArrayList<>();
    ArrayList<Integer> historicoMinhaPosicao = new ArrayList<>();
    ArrayList<Integer> historicoMeuChampions = new ArrayList<>();
    ArrayList<Integer> historicoMeuLibertadores = new ArrayList<>();
    ArrayList<String> historicoCampeonatos = new ArrayList<>();
    ArrayList<String> historicoChampionsLeague = new ArrayList<>();
    ArrayList<String> historicoLibertadores = new ArrayList<>();

    int posicaoAbsolutaChampions=-1, minhaposicaoChampions=-1,meuGrupoChampions=-1,qualcampeonato=0,minhaPosicaoMataMata=-1;
    int posicaoAbsolutaLibertadores=-1, minhaposicaoLibertadores=-1,meuGrupoLibertadores=-1;
    ArrayList<String> times = new ArrayList<>();
    ArrayList<Integer> PtsEquipe = new ArrayList<>();
    ArrayList<Integer> pontosTotal = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotal = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotal = new ArrayList<>();

    ArrayList<String> timesOrdem;
    ArrayList<Integer> pontosOrdem;
    ArrayList<Integer> PtsEquipeOrdem ;
    ArrayList<Integer> golsSofridosTotalOrdem;
    ArrayList<Integer> golsMarcadosTotalOrdem;

    ArrayList<String> timesChampions = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampions = new ArrayList<>();
    ArrayList<Integer> pontosTotalChampions = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalChampions = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalChampions = new ArrayList<>();

    ArrayList<String> timesChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalChampionsOrdem = new ArrayList<>();
    ArrayList<Integer> pontosTotalChampionsOrdem = new ArrayList<>();

    ArrayList<String> timesChampionsOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsOitavas = new ArrayList<>();
    ArrayList<String> timesChampionsQuartas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsQuartas = new ArrayList<>();
    ArrayList<String> timesChampionsSemifinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsSemifinal = new ArrayList<>();
    ArrayList<String> timesChampionsFinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeChampionsFinal = new ArrayList<>();
    ArrayList<Integer> golsMarcadosMataMataChampions = new ArrayList<>();

    ArrayList<String> timesLibertadores = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadores = new ArrayList<>();
    ArrayList<Integer> pontosTotalLibertadores = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalLibertadores = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalLibertadores = new ArrayList<>();

    ArrayList<String> timesLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalLibertadoresOrdem = new ArrayList<>();
    ArrayList<Integer> pontosTotalLibertadoresOrdem = new ArrayList<>();

    ArrayList<String> timesLibertadoresOitavas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresOitavas = new ArrayList<>();
    ArrayList<String> timesLibertadoresQuartas = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresQuartas = new ArrayList<>();
    ArrayList<String> timesLibertadoresSemifinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresSemifinal = new ArrayList<>();
    ArrayList<String> timesLibertadoresFinal = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadoresFinal = new ArrayList<>();
    ArrayList<Integer> golsMarcadosMataMataLibertadores = new ArrayList<>();

//LIBERTADORES MATA-MATA
    public void DefinirTimesLibertadoresOitavas(ArrayList a) {timesLibertadoresOitavas=a;    }
    public ArrayList SaberTimesLibertadoresOitavas(){return timesLibertadoresOitavas;}
    public void DefinirPtsEquipeLibertadoresOitavas(ArrayList aPts) {PtsEquipeLibertadoresOitavas=aPts;  }
    public ArrayList SaberPtsEquipeLibertadoresOitavas(){return PtsEquipeLibertadoresOitavas;}

    public void DefinirTimesLibertadoresQuartas(ArrayList a) {timesLibertadoresQuartas=a;    }
    public ArrayList SaberTimesLibertadoresQuartas(){return timesLibertadoresQuartas;}
    public void DefinirPtsEquipeLibertadoresQuartas(ArrayList aPts) {PtsEquipeLibertadoresQuartas=aPts;  }
    public ArrayList SaberPtsEquipeLibertadoresQuartas(){return PtsEquipeLibertadoresQuartas;}

    public void DefinirTimesLibertadoresSemi(ArrayList a) {timesLibertadoresSemifinal=a;    }
    public ArrayList SaberTimesLibertadoresSemifinal(){return timesLibertadoresSemifinal;}
    public void DefinirPtsEquipeLibertadoresSemifinal(ArrayList aPts) {PtsEquipeLibertadoresSemifinal=aPts;  }
    public ArrayList SaberPtsEquipeLibertadoresSemifinal(){return PtsEquipeLibertadoresSemifinal;}

    public void DefinirTimesLibertadoresFinal(ArrayList a) {timesLibertadoresFinal=a;    }
    public ArrayList SaberTimesLibertadoresFinal(){return timesLibertadoresFinal;}
    public void DefinirPtsEquipeLibertadoresFinal(ArrayList aPts) {PtsEquipeLibertadoresFinal=aPts;  }
    public ArrayList SaberPtsEquipeLibertadoresFinal(){return PtsEquipeLibertadoresFinal;}

    public void DefinirGolsMarcadosMataMataLibertadores(ArrayList aPts) {golsMarcadosMataMataLibertadores=aPts;  }
    public ArrayList SaberGolsMarcadosMataMataLibertadores(){return golsMarcadosMataMataLibertadores;}
    public void DefinirGolsMataMataLibertadores(Integer aGM, Integer index){
        golsMarcadosMataMataLibertadores.set(index, golsMarcadosMataMataLibertadores.get(index)+aGM);
    }
    public void ZerarGolsMataMataLibertadores(){
        golsMarcadosMataMataLibertadores.clear();
        for(int i=0;i<=60;i++){
            golsMarcadosMataMataLibertadores.add(0);
        }
    }

    //Libertadores
    public void DefinirTimesLibertadores(ArrayList a) {timesLibertadores=a;    }
    public ArrayList SaberTimesLibertadores(){return timesLibertadores;}
    public void DefinirPtsEquipeLibertadores(ArrayList aPts) {PtsEquipeLibertadores=aPts;  }
    public ArrayList SaberPtsEquipeLibertadores(){return PtsEquipeLibertadores;}
    public void ZerarGolsLibertadores(){
        golsMarcadosTotalLibertadores.clear();
        golsSofridosTotalLibertadores.clear();
        for(int i=0;i<=32;i++){
            golsMarcadosTotalLibertadores.add(0);
            golsSofridosTotalLibertadores.add(0);
        }
    }
    public void ZerarPontosTotalLibertadores(){
        pontosTotalLibertadores.clear();
        for(int i=0;i<=32;i++){
            pontosTotalLibertadores.add(0);
        }
    }
    public ArrayList<Integer> SaberGolsMarcadosTotalLibertadores(){
        return golsMarcadosTotalLibertadores;
    }
    public ArrayList<Integer> SaberGolsSofridosTotalLibertadores(){
        return golsSofridosTotalLibertadores;
    }
    public ArrayList<Integer> SaberPontosTotalLibertadores(){
        return pontosTotalLibertadores;
    }
    public void DefinirGolsLibertadores(Integer aGM, Integer aGS,Integer apontos, Integer index){
        golsMarcadosTotalLibertadores.set(index, golsMarcadosTotalLibertadores.get(index)+aGM);
        golsSofridosTotalLibertadores.set(index, golsSofridosTotalLibertadores.get(index)+aGS);
        pontosTotalLibertadores.set(index, pontosTotalLibertadores.get(index)+apontos);
    }
    public ArrayList SaberPontosLibertadores(){return pontosTotalLibertadores;}

    //ORDEM LIBERTADORES
    public void DefinirOrdemLibertadores(){
        int intAuxiliar;
        String stringAuxiliar;
        pontosTotalLibertadoresOrdem = new ArrayList<>(pontosTotalLibertadores);
        PtsEquipeLibertadoresOrdem = new ArrayList<>(PtsEquipeLibertadores);
        timesLibertadoresOrdem = new ArrayList<>(timesLibertadores);
        golsMarcadosTotalLibertadoresOrdem = new ArrayList<>(golsMarcadosTotalLibertadores);
        golsSofridosTotalLibertadoresOrdem = new ArrayList<>(golsSofridosTotalLibertadores);

        for (int var =0;var<8;var++){ //para cada grupo organiza os pontos
            for (int i =(var*4)+1; i<=4*(var+1); i++){ //grupos com 4 times
                for (int x =(var*4)+1;x<=4*(var+1);x++){
                    if(pontosTotalLibertadoresOrdem.get(x)<pontosTotalLibertadoresOrdem.get(i) || (pontosTotalLibertadoresOrdem.get(x)==pontosTotalLibertadoresOrdem.get(i) && golsMarcadosTotalLibertadoresOrdem.get(x)-golsSofridosTotalLibertadoresOrdem.get(x)<golsMarcadosTotalLibertadoresOrdem.get(i)-golsSofridosTotalLibertadoresOrdem.get(i))){
                        intAuxiliar=pontosTotalLibertadoresOrdem.get(x);pontosTotalLibertadoresOrdem.set(x,pontosTotalLibertadoresOrdem.get(i));pontosTotalLibertadoresOrdem.set(i,intAuxiliar);
                        intAuxiliar=PtsEquipeLibertadoresOrdem.get(x);PtsEquipeLibertadoresOrdem.set(x,PtsEquipeLibertadoresOrdem.get(i));PtsEquipeLibertadoresOrdem.set(i,intAuxiliar);
                        stringAuxiliar=timesLibertadoresOrdem.get(x);timesLibertadoresOrdem.set(x,timesLibertadoresOrdem.get(i));timesLibertadoresOrdem.set(i,stringAuxiliar);
                        intAuxiliar=golsMarcadosTotalLibertadoresOrdem.get(x);golsMarcadosTotalLibertadoresOrdem.set(x,golsMarcadosTotalLibertadoresOrdem.get(i));golsMarcadosTotalLibertadoresOrdem.set(i,intAuxiliar);
                        intAuxiliar=golsSofridosTotalLibertadoresOrdem.get(x);golsSofridosTotalLibertadoresOrdem.set(x,golsSofridosTotalLibertadoresOrdem.get(i));golsSofridosTotalLibertadoresOrdem.set(i,intAuxiliar);

                    }//if
                }
            }
        }
    }
    public ArrayList<Integer> SaberPontosLibertadoresOrdem(){
        return pontosTotalLibertadoresOrdem;
    }
    public ArrayList<String> SabertimesLibertadoresOrdem(){
        return timesLibertadoresOrdem;
    }
    public ArrayList<Integer> SaberPtsEquipeLibertadoresOrdem(){
        return PtsEquipeLibertadoresOrdem;
    }
    public ArrayList<Integer> SaberGolsMarcadosTotalLibertadoresOrdem(){
        return golsMarcadosTotalLibertadoresOrdem;
    }
    public ArrayList<Integer> SaberGolsSofridosTotalLibertadoresOrdem(){
        return golsSofridosTotalLibertadoresOrdem;
    }

//CHAMPIONS LEAGUE MATA-MATA
    public void DefinirTimesChampionsOitavas(ArrayList a) {timesChampionsOitavas=a;    }
    public ArrayList SaberTimesChampionsOitavas(){return timesChampionsOitavas;}
    public void DefinirPtsEquipeChampionsOitavas(ArrayList aPts) {PtsEquipeChampionsOitavas=aPts;  }
    public ArrayList SaberPtsEquipeChampionsOitavas(){return PtsEquipeChampionsOitavas;}

    public void DefinirTimesChampionsQuartas(ArrayList a) {timesChampionsQuartas=a;    }
    public ArrayList SaberTimesChampionsQuartas(){return timesChampionsQuartas;}
    public void DefinirPtsEquipeChampionsQuartas(ArrayList aPts) {PtsEquipeChampionsQuartas=aPts;  }
    public ArrayList SaberPtsEquipeChampionsQuartas(){return PtsEquipeChampionsQuartas;}

    public void DefinirTimesChampionsSemi(ArrayList a) {timesChampionsSemifinal=a;    }
    public ArrayList SaberTimesChampionsSemifinal(){return timesChampionsSemifinal;}
    public void DefinirPtsEquipeChampionsSemifinal(ArrayList aPts) {PtsEquipeChampionsSemifinal=aPts;  }
    public ArrayList SaberPtsEquipeChampionsSemifinal(){return PtsEquipeChampionsSemifinal;}

    public void DefinirTimesChampionsFinal(ArrayList a) {timesChampionsFinal=a;    }
    public ArrayList SaberTimesChampionsFinal(){return timesChampionsFinal;}
    public void DefinirPtsEquipeChampionsFinal(ArrayList aPts) {PtsEquipeChampionsFinal=aPts;  }
    public ArrayList SaberPtsEquipeChampionsFinal(){return PtsEquipeChampionsFinal;}

    public void DefinirGolsMarcadosMataMataChampions(ArrayList aPts) {golsMarcadosMataMataChampions=aPts;  }
    public ArrayList SaberGolsMarcadosMataMataChampions(){return golsMarcadosMataMataChampions;}
    public void DefinirGolsMataMataChampions(Integer aGM, Integer index){
        golsMarcadosMataMataChampions.set(index, golsMarcadosMataMataChampions.get(index)+aGM);
    }
    public void ZerarGolsMataMataChampions(){
        golsMarcadosMataMataChampions.clear();
        for(int i=0;i<=60;i++){
            golsMarcadosMataMataChampions.add(0);
        }
    }

    //SABER QUAL CAMPEONATO -> LIBERTA CHAMPIONS OU NACIONAL
    public void DefinirQualCampeonato(Integer campeonato){
        qualcampeonato=campeonato;
        if(qualcampeonato==1){
    minhaposicaoChampions = posicaoAbsolutaChampions%4;
    meuGrupoChampions = 1+(posicaoAbsolutaChampions/4);
    if(posicaoAbsolutaChampions%4==0){minhaposicaoChampions=4;meuGrupoChampions=(posicaoAbsolutaChampions/4);}
    }
}
    public Integer SaberQualCampeonato(){
        return qualcampeonato;
    }
    //CHAMPIONS LEAGUE
    public void DefinirPosicaoChampions(Integer aposicao){
        posicaoAbsolutaChampions=aposicao;
        minhaposicaoChampions = posicaoAbsolutaChampions%4;
        meuGrupoChampions = 1+(posicaoAbsolutaChampions/4);
        if(posicaoAbsolutaChampions%4==0){minhaposicaoChampions=4;meuGrupoChampions=(posicaoAbsolutaChampions/4);}
}
    public Integer SaberPosicaoChampions(){
        return minhaposicaoChampions;
    }
    public Integer SaberMeuGrupoChampions(){
        return meuGrupoChampions;
    }
    public void DefinirMinhaPosicaoMataMata(Integer aposicao){minhaPosicaoMataMata=aposicao;}
    public Integer SaberMinhaPosicaoMataMata(){
        return minhaPosicaoMataMata;
    }

    public void DefinirPosicaoLibertadores(Integer aposicao){
        posicaoAbsolutaLibertadores=aposicao;
        minhaposicaoLibertadores = posicaoAbsolutaLibertadores%4;
        meuGrupoLibertadores = 1+(posicaoAbsolutaLibertadores/4);
        if(posicaoAbsolutaLibertadores%4==0){minhaposicaoLibertadores=4;meuGrupoLibertadores=(posicaoAbsolutaLibertadores/4);}
    }
    public Integer SaberPosicaoLibertadores(){
        return minhaposicaoLibertadores;
    }
    public Integer SaberMeuGrupoLibertadores(){
        return meuGrupoLibertadores;
    }

    public void DefinirTimesChampions(ArrayList a) {timesChampions=a;    }
    public ArrayList SaberTimesChampions(){return timesChampions;}
    public void DefinirPtsEquipeChampions(ArrayList aPts) {PtsEquipeChampions=aPts;  }
    public ArrayList SaberPtsEquipeChampions(){return PtsEquipeChampions;}
    public void ZerarGolsChampions(){
    golsMarcadosTotalChampions.clear();
    golsSofridosTotalChampions.clear();
    for(int i=0;i<=32;i++){
        golsMarcadosTotalChampions.add(0);
        golsSofridosTotalChampions.add(0);
    }
}
    public void ZerarPontosTotalChampions(){
        pontosTotalChampions.clear();
        for(int i=0;i<=32;i++){
            pontosTotalChampions.add(0);
        }
    }
    public ArrayList<Integer> SaberGolsMarcadosTotalChampions(){
        return golsMarcadosTotalChampions;
    }
    public ArrayList<Integer> SaberGolsSofridosTotalChampions(){
        return golsSofridosTotalChampions;
    }
    public ArrayList<Integer> SaberPontosTotalChampions(){
        return pontosTotalChampions;
    }
    public void DefinirGolsChampions(Integer aGM, Integer aGS,Integer apontos, Integer index){
        golsMarcadosTotalChampions.set(index, golsMarcadosTotalChampions.get(index)+aGM);
        golsSofridosTotalChampions.set(index, golsSofridosTotalChampions.get(index)+aGS);
        pontosTotalChampions.set(index, pontosTotalChampions.get(index)+apontos);
    }
    public ArrayList SaberPontosChampions(){return pontosTotalChampions;}

    //ORDEM CHAMPIONS LEAGUE
    public void DefinirOrdemChampions(){
        int intAuxiliar;
        String stringAuxiliar;
        pontosTotalChampionsOrdem = new ArrayList<>(pontosTotalChampions);
        PtsEquipeChampionsOrdem = new ArrayList<>(PtsEquipeChampions);
        timesChampionsOrdem = new ArrayList<>(timesChampions);
        golsMarcadosTotalChampionsOrdem = new ArrayList<>(golsMarcadosTotalChampions);
        golsSofridosTotalChampionsOrdem = new ArrayList<>(golsSofridosTotalChampions);

        for (int var =0;var<8;var++){ //para cada grupo organiza os pontos
            for (int i =(var*4)+1; i<=4*(var+1); i++){ //grupos com 4 times
                for (int x =(var*4)+1;x<=4*(var+1);x++){
                    if(pontosTotalChampionsOrdem.get(x)<pontosTotalChampionsOrdem.get(i) || (pontosTotalChampionsOrdem.get(x)==pontosTotalChampionsOrdem.get(i) && golsMarcadosTotalChampionsOrdem.get(x)-golsSofridosTotalChampionsOrdem.get(x)<golsMarcadosTotalChampionsOrdem.get(i)-golsSofridosTotalChampionsOrdem.get(i))){
                        intAuxiliar=pontosTotalChampionsOrdem.get(x);pontosTotalChampionsOrdem.set(x,pontosTotalChampionsOrdem.get(i));pontosTotalChampionsOrdem.set(i,intAuxiliar);
                        intAuxiliar=PtsEquipeChampionsOrdem.get(x);PtsEquipeChampionsOrdem.set(x,PtsEquipeChampionsOrdem.get(i));PtsEquipeChampionsOrdem.set(i,intAuxiliar);
                        stringAuxiliar=timesChampionsOrdem.get(x);timesChampionsOrdem.set(x,timesChampionsOrdem.get(i));timesChampionsOrdem.set(i,stringAuxiliar);
                        intAuxiliar=golsMarcadosTotalChampionsOrdem.get(x);golsMarcadosTotalChampionsOrdem.set(x,golsMarcadosTotalChampionsOrdem.get(i));golsMarcadosTotalChampionsOrdem.set(i,intAuxiliar);
                        intAuxiliar=golsSofridosTotalChampionsOrdem.get(x);golsSofridosTotalChampionsOrdem.set(x,golsSofridosTotalChampionsOrdem.get(i));golsSofridosTotalChampionsOrdem.set(i,intAuxiliar);

                    }//if
                }
            }
        }
    }
    public ArrayList<Integer> SaberPontosChampionsOrdem(){
        return pontosTotalChampionsOrdem;
    }
    public ArrayList<String> SabertimesChampionsOrdem(){
        return timesChampionsOrdem;
    }
    public ArrayList<Integer> SaberPtsEquipeChampionsOrdem(){
        return PtsEquipeChampionsOrdem;
    }
    public ArrayList<Integer> SaberGolsMarcadosTotalChampionsOrdem(){
        return golsMarcadosTotalChampionsOrdem;
    }
    public ArrayList<Integer> SaberGolsSofridosTotalChampionsOrdem(){
        return golsSofridosTotalChampionsOrdem;
    }

//HISTÓRICO
    public void DefinirHistoricoMeuCampeonato(Integer acampeonato) {historicoMeuCampeonato.add(acampeonato);  }
    public ArrayList SaberHistoricoMeuCampeonato(){return historicoMeuCampeonato;}
    public void DefinirHistoricoMinhaPosicao(Integer aposicao) {historicoMinhaPosicao.add(aposicao);  }
    public ArrayList SaberHistoricoMinhaPosicao(){return historicoMinhaPosicao;}
    public void DefinirHistoricoMeuChampions(Integer aposicao) {historicoMeuChampions.add(aposicao);  }
    public ArrayList SaberHistoricoMeuChampions(){return historicoMeuChampions;}
    public void DefinirHistoricoMeuLibertadores(Integer aposicao) {historicoMeuLibertadores.add(aposicao);  }
    public ArrayList SaberHistoricoMeuLibertadores(){return historicoMeuLibertadores;}
    public void DefinirHistoricoCampeonatos(ArrayList a) {historicoCampeonatos=a;    }
    public ArrayList<String> SaberHistoricoCampeonatos(){return historicoCampeonatos;}
    public void DefinirHistoricoChampionsLeague(String a) {historicoChampionsLeague.add(a);    }
    public ArrayList<String> SaberHistoricoChampionsLeague(){return historicoChampionsLeague;}
    public void DefinirHistoricoLibertadores(String a) {historicoLibertadores.add(a);    }
    public ArrayList<String> SaberHistoricoLibertadores(){return historicoLibertadores;}

//ORDEM CAMP. NACIONAL
    public void DefinirOrdem(){
        int intAuxiliar;
        String stringAuxiliar;
        pontosOrdem = new ArrayList<>(pontosTotal);
        PtsEquipeOrdem = new ArrayList<>(PtsEquipe);
        timesOrdem = new ArrayList<>(times);
        golsSofridosTotalOrdem = new ArrayList<>(golsSofridosTotal);
        golsMarcadosTotalOrdem = new ArrayList<>(golsMarcadosTotal);

        for (int var =0;var<max2;var++){ //para cada campeonato organiza os pontos
            for (int i =(var*max)+1; i<=max*(var+1); i++){
                for (int x =i+1;x<=max*(var+1);x++){
                    if(pontosOrdem.get(x)>pontosOrdem.get(i) || (pontosOrdem.get(x)==pontosOrdem.get(i) && golsMarcadosTotalOrdem.get(x)-golsSofridosTotalOrdem.get(x)>golsMarcadosTotalOrdem.get(i)-golsSofridosTotalOrdem.get(i))){
                        intAuxiliar=pontosOrdem.get(x);pontosOrdem.set(x,pontosOrdem.get(i));pontosOrdem.set(i,intAuxiliar);
                        intAuxiliar=PtsEquipeOrdem.get(x);PtsEquipeOrdem.set(x,PtsEquipeOrdem.get(i));PtsEquipeOrdem.set(i,intAuxiliar);
                        stringAuxiliar=timesOrdem.get(x);timesOrdem.set(x,timesOrdem.get(i));timesOrdem.set(i,stringAuxiliar);
                        intAuxiliar=golsMarcadosTotalOrdem.get(x);golsMarcadosTotalOrdem.set(x,golsMarcadosTotalOrdem.get(i));golsMarcadosTotalOrdem.set(i,intAuxiliar);
                        intAuxiliar=golsSofridosTotalOrdem.get(x);golsSofridosTotalOrdem.set(x,golsSofridosTotalOrdem.get(i));golsSofridosTotalOrdem.set(i,intAuxiliar);
                    }//if
                }
            }
        }
    }
    public ArrayList<Integer> SaberpontosOrdem(){
        return pontosOrdem;
    }
    public ArrayList<String> SabertimesOrdem(){
        return timesOrdem;
    }
    public ArrayList<Integer> SaberPtsEquipeOrdem(){
        return PtsEquipeOrdem;
    }
    public ArrayList<Integer> SabergolsMarcadosTotalOrdem(){
        return golsMarcadosTotalOrdem;
    }
    public ArrayList<Integer> SabergolsSofridosTotalOrdem(){
        return golsSofridosTotalOrdem;
    }

//SIMULAÇÃO
    public void DefinirGols(Integer aGM, Integer aGS,Integer apontos, Integer index){
        golsMarcadosTotal.set(index, golsMarcadosTotal.get(index)+aGM);
        golsSofridosTotal.set(index, golsSofridosTotal.get(index)+aGS);
        pontosTotal.set(index, pontosTotal.get(index)+apontos);
    }
    public ArrayList<Integer> SaberGolsMarcados(){
        return golsMarcadosTotal;
    }
    public ArrayList<Integer> SaberGolsSofridos(){
        return golsSofridosTotal;
    }
    public ArrayList<Integer> SaberPontos(){
        return pontosTotal;
    }
    public void ZerarGols(){
        golsMarcadosTotal.clear();
        golsSofridosTotal.clear();
        for(int i=0;i<=max2*max;i++){
            golsMarcadosTotal.add(0);
            golsSofridosTotal.add(0);
        }
    }
    public void ZerarPontos(){
        pontosTotal.clear();
        for(int i=0;i<=max2*max;i++){
            pontosTotal.add(0);
        }
    }
    public void DefinirPtsEquipe(Integer aPtsEquipe,Integer index ) {
        PtsEquipe.set(index, aPtsEquipe);
    }
    public ArrayList<Integer> SaberPtsEquipe() {
        return PtsEquipe;
    }
    public void ZerarPtsEquipe(){
        PtsEquipe.clear();
        for(int i=0;i<=max2*max;i++){
            PtsEquipe.add(0);
        }
    }


    //MEU TIME
    public void Definirmeutime(String ameutime){
        meutime = ameutime;
    }
    public String Sabermeutime(){
        return meutime;
    }
    public void DefinirPosicao(Integer aposicao){
        posicao=aposicao;
    }
    public Integer SaberPosicao(){
        return posicao;
    }
    public Integer DefinirExpectativa(){
        int intAuxiliar;
        String stringAuxiliar;
        timesOrdem = new ArrayList<>(times);
        PtsEquipeOrdem = new ArrayList<>(PtsEquipe);
        //Organiza a tabela em ordem
            for (int i =((campeonato-1)*max)+1; i<=max*campeonato; i++){
            for (int x =i+1;x<=max*campeonato;x++){
                if(PtsEquipeOrdem.get(x)>PtsEquipeOrdem.get(i)){
                    intAuxiliar=PtsEquipeOrdem.get(x);PtsEquipeOrdem.set(x,PtsEquipeOrdem.get(i));PtsEquipeOrdem.set(i,intAuxiliar);
                    stringAuxiliar=timesOrdem.get(x);timesOrdem.set(x,timesOrdem.get(i));timesOrdem.set(i,stringAuxiliar);
                }//if
            }
        }
            //organiza a ordem do meu time até 1 pt abaixo
        int i=timesOrdem.indexOf(meutime);
            for (int x =i+1;x<=max*campeonato;x++){
                if(PtsEquipeOrdem.get(x)+1>PtsEquipeOrdem.get(i)){
                    intAuxiliar=PtsEquipeOrdem.get(x);PtsEquipeOrdem.set(x,PtsEquipeOrdem.get(i));PtsEquipeOrdem.set(i,intAuxiliar);
                    stringAuxiliar=timesOrdem.get(x);timesOrdem.set(x,timesOrdem.get(i));timesOrdem.set(i,stringAuxiliar);
                    i++;
                }//if
                else break;
            }

            expectativa=timesOrdem.indexOf(meutime);
            expectativa=expectativa%max;
            if(expectativa%max==0)expectativa=max-1;
            return expectativa;
    }
    public Integer SaberExpectativa(){
        return expectativa;
    }
//PARAMETROS PADRÃO
    public void DefinirParametros(Integer aCampeonato, Float aDinheiro){
        campeonato = aCampeonato;
        dinheiro = aDinheiro;
    }
    public void DefinirCampeonato(Integer acampeonato){campeonato =acampeonato;}
    public Float SaberDinheiro(){
        return dinheiro;
    }
    public void DefinirRodada(Integer arodada) {rodada=arodada;    }
    public Integer SaberRodada(){
        return rodada;
    }
    public Integer SaberCampeonato(){
        return campeonato;
    }

    public void DefinirChave(ArrayList<Integer> achave){
        chave=achave;
    }
    public ArrayList<Integer> SaberChave(){        return chave;    }

    public void DefinirTimes(ArrayList<String> atimes){
        times=atimes;
    }
    public ArrayList<String> SaberTimes(){        return times;    }

    public Integer SaberMax(){return max;}
    public Integer SaberMax2(){return max2;}
    public void DefinirAno(Integer aano) {ano=aano;    }
    public Integer SaberAno(){return ano;}
    public void DefinirTransferenciaTecnico(Integer a) {transferenciaTecnico=a;    }
    public Integer SaberTransferenciaTecnico(){return transferenciaTecnico;}
    public void DefinirPausa(Integer a) {pausa=a;    }
    public Integer SaberPausa(){return pausa;}
    public void DefinirScoreJogo(Integer a) {scoreJogo=a+scoreJogo;    }
    public void DefinirScoreJogoInternacional(Integer a) {
        if(a==32)a=500;
        if(a==16)a=1000;
        if(a==8)a=1300;
        if(a==4)a=1600;
        if(a==2)a=2000;
        if(a==1)a=2500;
        if(a<=0)a=0;
        scoreJogo=a+scoreJogo;    }
    public Integer SaberScoreJogo(){return scoreJogo;}

    //IMAGENS
    public void imageKIT(String timeFoto, ImageView imageLogo){

        if(timeFoto.equals("Atlético-MG")){       imageLogo.setImageResource(R.drawable.atleticomg1);      }
        if(timeFoto.equals("Atlético-PR")){       imageLogo.setImageResource(R.drawable.atleticopr1);        }
        if(timeFoto.equals("Bahia")){             imageLogo.setImageResource(R.drawable.bahia1);        }
        if(timeFoto.equals("Botafogo")){          imageLogo.setImageResource(R.drawable.botafogo1);        }
        if(timeFoto.equals("Corinthians")){       imageLogo.setImageResource(R.drawable.corinthians1);        }
        if(timeFoto.equals("Cruzeiro")){          imageLogo.setImageResource(R.drawable.cruzeiro1);        }
        if(timeFoto.equals("Flamengo")){          imageLogo.setImageResource(R.drawable.flamengo1);        }
        if(timeFoto.equals("Fluminense")){        imageLogo.setImageResource(R.drawable.fluminense1);        }
        if(timeFoto.equals("Grêmio")){            imageLogo.setImageResource(R.drawable.gremio1);        }
        if(timeFoto.equals("Goias")){            imageLogo.setImageResource(R.drawable.goias1);        }
        if(timeFoto.equals("Internacional")){     imageLogo.setImageResource(R.drawable.internacional1);        }
        if(timeFoto.equals("Palmeiras")){            imageLogo.setImageResource(R.drawable.palmeiras1);     }
        if(timeFoto.equals("Santos")){            imageLogo.setImageResource(R.drawable.santos1);        }
        if(timeFoto.equals("São Paulo")){         imageLogo.setImageResource(R.drawable.saopaulo1);        }
        if(timeFoto.equals("Sport")){            imageLogo.setImageResource(R.drawable.sport1);        }
        if(timeFoto.equals("Vasco")){            imageLogo.setImageResource(R.drawable.vasco1);       }

        if(timeFoto.equals("Arsenal")){            imageLogo.setImageResource(R.drawable.arsenal1);        }
        if(timeFoto.equals("Aston Villa")){            imageLogo.setImageResource(R.drawable.astonvilla1);        }
        if(timeFoto.equals("Crystal Palace")){            imageLogo.setImageResource(R.drawable.crystalpalace1);        }
        if(timeFoto.equals("Chelsea")){            imageLogo.setImageResource(R.drawable.chelsea1);        }
        if(timeFoto.equals("Everton")){            imageLogo.setImageResource(R.drawable.everton1);        }
        if(timeFoto.equals("Leicester")){            imageLogo.setImageResource(R.drawable.leicester1);        }
        if(timeFoto.equals("Leeds United")){            imageLogo.setImageResource(R.drawable.leeds1);        }
        if(timeFoto.equals("Liverpool")){            imageLogo.setImageResource(R.drawable.liverpool1);        }
        if(timeFoto.equals("Manchester City")){            imageLogo.setImageResource(R.drawable.manchestercity1);        }
        if(timeFoto.equals("Manchester United")){            imageLogo.setImageResource(R.drawable.manchesterunited1);        }
        if(timeFoto.equals("Newcastle")){            imageLogo.setImageResource(R.drawable.newcastle1);        }
        if(timeFoto.equals("Southampton")){            imageLogo.setImageResource(R.drawable.southampton1);        }
        if(timeFoto.equals("Tottenham")){            imageLogo.setImageResource(R.drawable.tottenham1);        }
        if(timeFoto.equals("West Bromwich")){            imageLogo.setImageResource(R.drawable.westbromwich1);        }
        if(timeFoto.equals("West Ham")){            imageLogo.setImageResource(R.drawable.westham1);        }
        if(timeFoto.equals("Wolves")){            imageLogo.setImageResource(R.drawable.wolves1);        }

        if(timeFoto.equals("Atalanta")){            imageLogo.setImageResource(R.drawable.atalanta1);        }
        if(timeFoto.equals("Bologna")){            imageLogo.setImageResource(R.drawable.bologna1);        }
        if(timeFoto.equals("Cagliari")){            imageLogo.setImageResource(R.drawable.cagliari1);        }
        if(timeFoto.equals("Fiorentina")){            imageLogo.setImageResource(R.drawable.fiorentina1);        }
        if(timeFoto.equals("Genoa")){            imageLogo.setImageResource(R.drawable.genoa1);        }
        if(timeFoto.equals("Inter")){            imageLogo.setImageResource(R.drawable.inter1);        }
        if(timeFoto.equals("Juventus")){            imageLogo.setImageResource(R.drawable.juventus1);        }
        if(timeFoto.equals("Milan")){            imageLogo.setImageResource(R.drawable.milan1);        }
        if(timeFoto.equals("Lazio")){            imageLogo.setImageResource(R.drawable.lazio1);        }
        if(timeFoto.equals("Napoli")){            imageLogo.setImageResource(R.drawable.napoli1);        }
        if(timeFoto.equals("Parma")){            imageLogo.setImageResource(R.drawable.parma1);        }
        if(timeFoto.equals("Roma")){            imageLogo.setImageResource(R.drawable.roma1);        }
        if(timeFoto.equals("Sampdoria")){            imageLogo.setImageResource(R.drawable.sampdoria1);        }
        if(timeFoto.equals("Sassuolo")){            imageLogo.setImageResource(R.drawable.sassuolo1);        }
        if(timeFoto.equals("Torino")){            imageLogo.setImageResource(R.drawable.torino1);        }
        if(timeFoto.equals("Udinese")){            imageLogo.setImageResource(R.drawable.udinese1);        }

        if(timeFoto.equals("Athletic Bilbao")){            imageLogo.setImageResource(R.drawable.athleticbilbao1);        }
        if(timeFoto.equals("Atlético Madrid")){            imageLogo.setImageResource(R.drawable.atleticomadrid1);        }
        if(timeFoto.equals("Barcelona")){            imageLogo.setImageResource(R.drawable.barcelona1);        }
        if(timeFoto.equals("Celta de Vigo")){            imageLogo.setImageResource(R.drawable.celta1);        }
        if(timeFoto.equals("Espanyol")){            imageLogo.setImageResource(R.drawable.espanyol1);        }
        if(timeFoto.equals("Getafe")){            imageLogo.setImageResource(R.drawable.getafe1);        }
        if(timeFoto.equals("Osasuna")){            imageLogo.setImageResource(R.drawable.osasuna1);        }
        if(timeFoto.equals("La Coruna")){            imageLogo.setImageResource(R.drawable.getafe1);        }
        if(timeFoto.equals("Levante")){            imageLogo.setImageResource(R.drawable.levante1);        }
        if(timeFoto.equals("Real Betis")){            imageLogo.setImageResource(R.drawable.realbetis1);        }
        if(timeFoto.equals("Real Madrid")){            imageLogo.setImageResource(R.drawable.realmadrid1);        }
        if(timeFoto.equals("Real Sociedad")){            imageLogo.setImageResource(R.drawable.realsociedad1);        }
        if(timeFoto.equals("Sevilla")){            imageLogo.setImageResource(R.drawable.sevilla1);        }
        if(timeFoto.equals("Valladolid")){            imageLogo.setImageResource(R.drawable.valladolid1);        }
        if(timeFoto.equals("Valencia")){            imageLogo.setImageResource(R.drawable.valencia1);        }
        if(timeFoto.equals("Villareal")){            imageLogo.setImageResource(R.drawable.villareal1);        }

        if(timeFoto.equals("Moenchengladbach")){            imageLogo.setImageResource(R.drawable.borussia1);        }
        if(timeFoto.equals("Borussia Dortmund")){            imageLogo.setImageResource(R.drawable.dortmund1);        }
        if(timeFoto.equals("Bayern Munique")){            imageLogo.setImageResource(R.drawable.bayern1);        }
        if(timeFoto.equals("Bayer Leverkusen")){            imageLogo.setImageResource(R.drawable.leverkusen1);        }
        if(timeFoto.equals("Eintracht Frankfurt")){            imageLogo.setImageResource(R.drawable.frankfurt1);        }
        if(timeFoto.equals("Freiburg")){            imageLogo.setImageResource(R.drawable.freiburg1);        }
        if(timeFoto.equals("Hamburgo")){            imageLogo.setImageResource(R.drawable.hamburgo1);        }
        if(timeFoto.equals("Colonia")){            imageLogo.setImageResource(R.drawable.colonia1);        }
        if(timeFoto.equals("Hannover96")){            imageLogo.setImageResource(R.drawable.hannover961);        }
        if(timeFoto.equals("Hertha Berlim")){            imageLogo.setImageResource(R.drawable.hertha1);        }
        if(timeFoto.equals("Hoffenheim")){            imageLogo.setImageResource(R.drawable.hoffenheim1);        }
        if(timeFoto.equals("RB Leipzig")){            imageLogo.setImageResource(R.drawable.leipzig1);        }
        if(timeFoto.equals("Schalke-04")){            imageLogo.setImageResource(R.drawable.schalke1);        }
        if(timeFoto.equals("Stuttgart")){            imageLogo.setImageResource(R.drawable.stuttgart1);        }
        if(timeFoto.equals("Werder Bremen")){            imageLogo.setImageResource(R.drawable.werderbremen1);        }
        if(timeFoto.equals("Wolfsburg")){            imageLogo.setImageResource(R.drawable.wolfsburg1);        }

        if(timeFoto.equals("Bordeaux")){            imageLogo.setImageResource(R.drawable.bordeaux1);        }
        if(timeFoto.equals("Lille")){            imageLogo.setImageResource(R.drawable.lille1);        }
        if(timeFoto.equals("Lyon")){            imageLogo.setImageResource(R.drawable.lyon1);        }
        if(timeFoto.equals("Monaco")){            imageLogo.setImageResource(R.drawable.monaco1);        }
        if(timeFoto.equals("Montpellier")){            imageLogo.setImageResource(R.drawable.montpellier1);        }
        if(timeFoto.equals("Nantes")){            imageLogo.setImageResource(R.drawable.nantes1);        }
        if(timeFoto.equals("Nice")){            imageLogo.setImageResource(R.drawable.nice1);        }
        if(timeFoto.equals("Olympique Marselha")){            imageLogo.setImageResource(R.drawable.marseille1);        }
        if(timeFoto.equals("PSG")){            imageLogo.setImageResource(R.drawable.psg1);        }
        if(timeFoto.equals("Reims")){            imageLogo.setImageResource(R.drawable.guingamp1);        }
        if(timeFoto.equals("Rennes")){            imageLogo.setImageResource(R.drawable.rennes1);        }
        if(timeFoto.equals("Saint-Etienne")){            imageLogo.setImageResource(R.drawable.stetienne1);        }
        if(timeFoto.equals("Toulouse")){            imageLogo.setImageResource(R.drawable.toulouse1);        }
        if(timeFoto.equals("Anderlecht")){            imageLogo.setImageResource(R.drawable.anderlecht1);        }
        if(timeFoto.equals("Brugge")){            imageLogo.setImageResource(R.drawable.brugge1);        }
        if(timeFoto.equals("Standard Liege")){            imageLogo.setImageResource(R.drawable.liege1);        }

        if(timeFoto.equals("Benfica")){            imageLogo.setImageResource(R.drawable.benfica1);        }
        if(timeFoto.equals("Porto")){            imageLogo.setImageResource(R.drawable.porto1);        }
        if(timeFoto.equals("Sporting")){            imageLogo.setImageResource(R.drawable.sporting1);        }
        if(timeFoto.equals("Braga")){            imageLogo.setImageResource(R.drawable.braga1);        }
        if(timeFoto.equals("Vitória Guimarães")){            imageLogo.setImageResource(R.drawable.guimaraes1);        }
        if(timeFoto.equals("Ajax")){            imageLogo.setImageResource(R.drawable.ajax1);        }
        if(timeFoto.equals("Feyenoord")){            imageLogo.setImageResource(R.drawable.feyenoord1);        }
        if(timeFoto.equals("PSV")){            imageLogo.setImageResource(R.drawable.psv1);        }
        if(timeFoto.equals("Celtic")){            imageLogo.setImageResource(R.drawable.celtic1);        }
        if(timeFoto.equals("Glasgow Rangers")){            imageLogo.setImageResource(R.drawable.rangers1);        }
        if(timeFoto.equals("Rosemborg")){            imageLogo.setImageResource(R.drawable.borussia1);        }
        if(timeFoto.equals("Malmo")){            imageLogo.setImageResource(R.drawable.malmo1);        }
        if(timeFoto.equals("Copenhague")){            imageLogo.setImageResource(R.drawable.copenhague1);        }
        if(timeFoto.equals("RB Salzburg")){            imageLogo.setImageResource(R.drawable.rbsalzburg1);        }
        if(timeFoto.equals("Rapid Viena")){            imageLogo.setImageResource(R.drawable.rapidviena1);        }
        if(timeFoto.equals("Basel")){            imageLogo.setImageResource(R.drawable.basel1);        }

        if(timeFoto.equals("Zenit")){            imageLogo.setImageResource(R.drawable.zenit1);        }
        if(timeFoto.equals("CSKA")){            imageLogo.setImageResource(R.drawable.cska1);        }
        if(timeFoto.equals("Krasnodar")){            imageLogo.setImageResource(R.drawable.krasnodar1);        }
        if(timeFoto.equals("Spartak Moscou")){            imageLogo.setImageResource(R.drawable.spartak1);        }
        if(timeFoto.equals("Galatasaray")){            imageLogo.setImageResource(R.drawable.galatasaray1);        }
        if(timeFoto.equals("Fenerbahce")){            imageLogo.setImageResource(R.drawable.fenerbahce1);        }
        if(timeFoto.equals("Besiktas")){            imageLogo.setImageResource(R.drawable.besiktas1);        }
        if(timeFoto.equals("Olympiakos")){            imageLogo.setImageResource(R.drawable.olympiakos1);        }
        if(timeFoto.equals("Estrela Vermelha")){            imageLogo.setImageResource(R.drawable.estrelavermelha1);        }
        if(timeFoto.equals("Partizan")){            imageLogo.setImageResource(R.drawable.partizan1);        }
        if(timeFoto.equals("Ludogorets")){            imageLogo.setImageResource(R.drawable.ludogorets1);        }
        if(timeFoto.equals("Dinamo Zagreb")){            imageLogo.setImageResource(R.drawable.basel1);        }
        if(timeFoto.equals("Shaktar Donetsk")){            imageLogo.setImageResource(R.drawable.shaktar1);        }
        if(timeFoto.equals("Dinamo Kiev")){            imageLogo.setImageResource(R.drawable.dinamokiev1);        }
        if(timeFoto.equals("Sparta Praga")){            imageLogo.setImageResource(R.drawable.spartapraga1);        }
        if(timeFoto.equals("APOEL")){            imageLogo.setImageResource(R.drawable.partizan1);        }

        if(timeFoto.equals("Birmigham")){            imageLogo.setImageResource(R.drawable.birmingham1);        }
        if(timeFoto.equals("Blackburn")){            imageLogo.setImageResource(R.drawable.blackburn1);        }
        if(timeFoto.equals("Burnley")){            imageLogo.setImageResource(R.drawable.burnley1);        }
        if(timeFoto.equals("Brighton")){            imageLogo.setImageResource(R.drawable.brighton1);        }
        if(timeFoto.equals("Derby Count")){            imageLogo.setImageResource(R.drawable.derby1);        }
        if(timeFoto.equals("Fulham")){            imageLogo.setImageResource(R.drawable.fulham1);        }
        if(timeFoto.equals("Hull City")){            imageLogo.setImageResource(R.drawable.hull1);        }
        if(timeFoto.equals("Middlesbrough")){      imageLogo.setImageResource(R.drawable.middlesbrough1);        }
        if(timeFoto.equals("Norwich")){            imageLogo.setImageResource(R.drawable.norwich1);        }
        if(timeFoto.equals("Nottingham Forest")){    imageLogo.setImageResource(R.drawable.nottingham1);        }
        if(timeFoto.equals("QPR")){                imageLogo.setImageResource(R.drawable.qpr1);        }
        if(timeFoto.equals("Reading")){            imageLogo.setImageResource(R.drawable.reading1);        }
        if(timeFoto.equals("Sheffield United")){    imageLogo.setImageResource(R.drawable.sheffield1);        }
        if(timeFoto.equals("Stoke City")){            imageLogo.setImageResource(R.drawable.stoke1);        }
        if(timeFoto.equals("Swansea")){            imageLogo.setImageResource(R.drawable.swansea1);        }
        if(timeFoto.equals("Watford")){            imageLogo.setImageResource(R.drawable.watford1);        }

        if(timeFoto.equals("Avaí")){                imageLogo.setImageResource(R.drawable.avai1);        }
        if(timeFoto.equals("Botafogo-SP")){            imageLogo.setImageResource(R.drawable.botafogosp1);;     }
        if(timeFoto.equals("Bragantino")){            imageLogo.setImageResource(R.drawable.bragantino1);      }
        if(timeFoto.equals("Ceará")){               imageLogo.setImageResource(R.drawable.ceara1);        }
        if(timeFoto.equals("Coritiba")){            imageLogo.setImageResource(R.drawable.coritiba1);        }
        if(timeFoto.equals("Criciúma")){            imageLogo.setImageResource(R.drawable.criciuma1);        }
        if(timeFoto.equals("Figueirense")){         imageLogo.setImageResource(R.drawable.figueirense1);        }
        if(timeFoto.equals("Fortaleza")){          imageLogo.setImageResource(R.drawable.fortaleza1);         }
        if(timeFoto.equals("Guarani")){            imageLogo.setImageResource(R.drawable.guarani1);         }
        if(timeFoto.equals("Juventude")){         imageLogo.setImageResource(R.drawable.juventude1);          }
        if(timeFoto.equals("Naútico")){            imageLogo.setImageResource(R.drawable.nautico1);         }
        if(timeFoto.equals("Paraná")){            imageLogo.setImageResource(R.drawable.parana1);          }
        if(timeFoto.equals("Paysandu")){          imageLogo.setImageResource(R.drawable.paysandu1);          }
        if(timeFoto.equals("Ponte Preta")){       imageLogo.setImageResource(R.drawable.pontepreta1);          }
        if(timeFoto.equals("Santa Cruz")){        imageLogo.setImageResource(R.drawable.santacruz1);          }
        if(timeFoto.equals("Vitória")){            imageLogo.setImageResource(R.drawable.vitoria1);         }

        if(timeFoto.equals("Argentino Juniors")){       imageLogo.setImageResource(R.drawable.argentinosjr1);        }
        if(timeFoto.equals("Arsenal Sarandí")){            imageLogo.setImageResource(R.drawable.sarandi1);     }
        if(timeFoto.equals("Banfield")){            imageLogo.setImageResource(R.drawable.banfield1);      }
        if(timeFoto.equals("Boca Juniors")){               imageLogo.setImageResource(R.drawable.bocajuniors1);        }
        if(timeFoto.equals("Colón")){                imageLogo.setImageResource(R.drawable.colon1);        }
        if(timeFoto.equals("Estudiantes")){            imageLogo.setImageResource(R.drawable.estudiantes1);        }
        if(timeFoto.equals("Independiente")){         imageLogo.setImageResource(R.drawable.independiente1);        }
        if(timeFoto.equals("Huracán")){             imageLogo.setImageResource(R.drawable.huracan1);         }
        if(timeFoto.equals("Lanús")){               imageLogo.setImageResource(R.drawable.lanus1);         }
        if(timeFoto.equals("Newell's Old Boys")){         imageLogo.setImageResource(R.drawable.newells1);          }
        if(timeFoto.equals("Racing")){               imageLogo.setImageResource(R.drawable.racing1);         }
        if(timeFoto.equals("River Plate")){            imageLogo.setImageResource(R.drawable.riverplate1);          }
        if(timeFoto.equals("Rosario Central")){          imageLogo.setImageResource(R.drawable.rosariocentral);          }
        if(timeFoto.equals("San Lorenzo")){          imageLogo.setImageResource(R.drawable.sanlorenzo);          }
        if(timeFoto.equals("Talleres")){              imageLogo.setImageResource(R.drawable.talleres1);          }
        if(timeFoto.equals("Vélez Sarsfield")){            imageLogo.setImageResource(R.drawable.velez1);         }

        if(timeFoto.equals("Peñarol")){       imageLogo.setImageResource(R.drawable.penarol1);        }
        if(timeFoto.equals("Nacional")){            imageLogo.setImageResource(R.drawable.nacional1);     }
        if(timeFoto.equals("Olimpia")){            imageLogo.setImageResource(R.drawable.olimpia1);      }
        if(timeFoto.equals("Cerro Porteño")){               imageLogo.setImageResource(R.drawable.cerro1);        }
        if(timeFoto.equals("Libertad")){                imageLogo.setImageResource(R.drawable.libertad1);        }
        if(timeFoto.equals("Colo-Colo")){            imageLogo.setImageResource(R.drawable.colocolo1);        }
        if(timeFoto.equals("LaU")){         imageLogo.setImageResource(R.drawable.lau1);        }
        if(timeFoto.equals("Univ. Católica")){             imageLogo.setImageResource(R.drawable.universidadcatolica1);         }
        if(timeFoto.equals("Bolívar")){               imageLogo.setImageResource(R.drawable.bolivar1);         }
        if(timeFoto.equals("Alianza Lima")){         imageLogo.setImageResource(R.drawable.alianzalima1);          }
        if(timeFoto.equals("Sporting Cristal")){               imageLogo.setImageResource(R.drawable.sportingcristal1);         }
        if(timeFoto.equals("Cienciano")){            imageLogo.setImageResource(R.drawable.cienciano1);          }
        if(timeFoto.equals("Barcelona-EQU")){          imageLogo.setImageResource(R.drawable.barcelonaequ1);          }
        if(timeFoto.equals("Emelec")){          imageLogo.setImageResource(R.drawable.emelec1);          }
        if(timeFoto.equals("LDU")){              imageLogo.setImageResource(R.drawable.ldu1);          }
        if(timeFoto.equals("Caracas")){            imageLogo.setImageResource(R.drawable.independiente1);         }

        if(timeFoto.equals("América de Cali")){       imageLogo.setImageResource(R.drawable.americacali1);        }
        if(timeFoto.equals("Atlético Nacional")){            imageLogo.setImageResource(R.drawable.atleticonacional1);     }
        if(timeFoto.equals("Deportivo Cali")){            imageLogo.setImageResource(R.drawable.deportivocali1);      }
        if(timeFoto.equals("Junior")){               imageLogo.setImageResource(R.drawable.junior1);        }
        if(timeFoto.equals("I. Medellín")){                imageLogo.setImageResource(R.drawable.medellin1);        }
        if(timeFoto.equals("Once Caldas")){            imageLogo.setImageResource(R.drawable.oncecaldas1);        }
        if(timeFoto.equals("Millonarios")){         imageLogo.setImageResource(R.drawable.milionarios1);        }
        if(timeFoto.equals("Santa Fé")){             imageLogo.setImageResource(R.drawable.santafe1);         }
        if(timeFoto.equals("América-MEX")){               imageLogo.setImageResource(R.drawable.americamx1);         }
        if(timeFoto.equals("Chivas Guadalajara")){         imageLogo.setImageResource(R.drawable.chivas1);          }
        if(timeFoto.equals("Cruz Azul")){               imageLogo.setImageResource(R.drawable.cruzazul1);         }
        if(timeFoto.equals("Monterrey")){            imageLogo.setImageResource(R.drawable.monterrey1);          }
        if(timeFoto.equals("Pachuca")){          imageLogo.setImageResource(R.drawable.pachuca1);          }
        if(timeFoto.equals("Pumas")){          imageLogo.setImageResource(R.drawable.pumas1);          }
        if(timeFoto.equals("Tigres")){              imageLogo.setImageResource(R.drawable.tigres1);          }
        if(timeFoto.equals("Toluca")){            imageLogo.setImageResource(R.drawable.toluca1);         }

        if(timeFoto.equals("Ghuagzhou Evergrande")){       imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Beijing Guoan")){            imageLogo.setImageResource(R.drawable.toluca);     }
        if(timeFoto.equals("Shandong Luneng")){            imageLogo.setImageResource(R.drawable.toluca);      }
        if(timeFoto.equals("Shanghai SIPG")){               imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Kashima Antlers")){                imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Urawa Red Diamonds")){            imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Vissel Kobe")){             imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("FC Tokyo")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("FC Seoul")){         imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Jeonbuk Hyundai")){            imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Ain-EAU")){         imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Sadd-QAT")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Duhail-QAT")){            imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Ahli")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Hilal")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Persepolis")){              imageLogo.setImageResource(R.drawable.toluca);          }

        if(timeFoto.equals("Sydney FC")){       imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Melbourne Victory")){            imageLogo.setImageResource(R.drawable.toluca);     }
        if(timeFoto.equals("Suwon Samsung")){               imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Ulsan Hyundai")){            imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Jiangsu Suning")){         imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Shanghai Shenhua")){                imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Cerezo Osaka")){         imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Kawasaki Frontale")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Kashiwa Reysol")){            imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Gamba Osaka")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Yokohama F-Marinos")){            imageLogo.setImageResource(R.drawable.toluca);      }
        if(timeFoto.equals("Al Nassr")){             imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Ittihad")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Pakhtakor-UZB")){            imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Sepahan")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Esteghlal")){              imageLogo.setImageResource(R.drawable.toluca);          }

        if(timeFoto.equals("Atlanta United")){       imageLogo.setImageResource(R.drawable.atlanta1);        }
        if(timeFoto.equals("Chicago Fire")){            imageLogo.setImageResource(R.drawable.chicago1);     }
        if(timeFoto.equals("Columbus Crew")){               imageLogo.setImageResource(R.drawable.columbus1);        }
        if(timeFoto.equals("DC United")){            imageLogo.setImageResource(R.drawable.dcunited1);        }
        if(timeFoto.equals("FC Dallas")){         imageLogo.setImageResource(R.drawable.dallas1);        }
        if(timeFoto.equals("Houston Dynamo")){                imageLogo.setImageResource(R.drawable.houston1);        }
        if(timeFoto.equals("LA Galaxy")){            imageLogo.setImageResource(R.drawable.la1);          }
        if(timeFoto.equals("New England Revolution")){               imageLogo.setImageResource(R.drawable.nerevolution1);         }
        if(timeFoto.equals("NY City")){          imageLogo.setImageResource(R.drawable.nycity1);          }
        if(timeFoto.equals("NY Red Bulls")){            imageLogo.setImageResource(R.drawable.nyredbull1);      }
        if(timeFoto.equals("Orlando City")){             imageLogo.setImageResource(R.drawable.orlando1);         }
        if(timeFoto.equals("Portland Timbers")){               imageLogo.setImageResource(R.drawable.portland1);         }
        if(timeFoto.equals("Seattle Sounders")){            imageLogo.setImageResource(R.drawable.seattle1);         }
        if(timeFoto.equals("Sporting Kansas City")){          imageLogo.setImageResource(R.drawable.kansas1);          }
        if(timeFoto.equals("Toronto FC")){              imageLogo.setImageResource(R.drawable.toronto1);          }
        if(timeFoto.equals("Vancouver Whitecaps")){         imageLogo.setImageResource(R.drawable.vancouver1);          }
    }
    public void imageEstadio(String timeFoto, ImageView imageLogo){
        if(timeFoto.equals("Atlético-MG")){       imageLogo.setImageResource(R.drawable.atleticomg0);        }
        if(timeFoto.equals("Atlético-PR")){       imageLogo.setImageResource(R.drawable.atleticopr0);        }
        if(timeFoto.equals("Bahia")){             imageLogo.setImageResource(R.drawable.bahia0);        }
        if(timeFoto.equals("Botafogo")){          imageLogo.setImageResource(R.drawable.botafogo0);        }
        if(timeFoto.equals("Corinthians")){       imageLogo.setImageResource(R.drawable.corinthians0);        }
        if(timeFoto.equals("Cruzeiro")){          imageLogo.setImageResource(R.drawable.cruzeiro0);        }
        if(timeFoto.equals("Flamengo")){          imageLogo.setImageResource(R.drawable.flamengo0);        }
        if(timeFoto.equals("Fluminense")){        imageLogo.setImageResource(R.drawable.fluminense0);        }
        if(timeFoto.equals("Grêmio")){            imageLogo.setImageResource(R.drawable.gremio0);        }
        if(timeFoto.equals("Goias")){            imageLogo.setImageResource(R.drawable.goias0);        }
        if(timeFoto.equals("Internacional")){     imageLogo.setImageResource(R.drawable.internacional0);        }
        if(timeFoto.equals("Palmeiras")){            imageLogo.setImageResource(R.drawable.palmeiras0);        }
        if(timeFoto.equals("Santos")){            imageLogo.setImageResource(R.drawable.santos0);        }
        if(timeFoto.equals("São Paulo")){         imageLogo.setImageResource(R.drawable.saopaulo0);        }
        if(timeFoto.equals("Sport")){            imageLogo.setImageResource(R.drawable.sport0);        }
        if(timeFoto.equals("Vasco")){            imageLogo.setImageResource(R.drawable.vasco0);        }

        if(timeFoto.equals("Arsenal")){            imageLogo.setImageResource(R.drawable.arsenal0);        }
        if(timeFoto.equals("Aston Villa")){            imageLogo.setImageResource(R.drawable.astonvilla0);        }
        if(timeFoto.equals("Crystal Palace")){            imageLogo.setImageResource(R.drawable.crystalpalace0);        }
        if(timeFoto.equals("Chelsea")){            imageLogo.setImageResource(R.drawable.chelsea0);        }
        if(timeFoto.equals("Everton")){            imageLogo.setImageResource(R.drawable.everton0);        }
        if(timeFoto.equals("Leicester")){            imageLogo.setImageResource(R.drawable.leicester0);        }
        if(timeFoto.equals("Leeds United")){            imageLogo.setImageResource(R.drawable.leeds0);        }
        if(timeFoto.equals("Liverpool")){            imageLogo.setImageResource(R.drawable.liverpool0);        }
        if(timeFoto.equals("Manchester City")){            imageLogo.setImageResource(R.drawable.manchestercity0);        }
        if(timeFoto.equals("Manchester United")){            imageLogo.setImageResource(R.drawable.manchesterunited0);        }
        if(timeFoto.equals("Newcastle")){            imageLogo.setImageResource(R.drawable.newcastle0);        }
        if(timeFoto.equals("Southampton")){            imageLogo.setImageResource(R.drawable.southampton0);        }
        if(timeFoto.equals("Tottenham")){            imageLogo.setImageResource(R.drawable.tottenham0);        }
        if(timeFoto.equals("West Bromwich")){            imageLogo.setImageResource(R.drawable.westbromwich0);        }
        if(timeFoto.equals("West Ham")){            imageLogo.setImageResource(R.drawable.westham0);        }
        if(timeFoto.equals("Wolves")){            imageLogo.setImageResource(R.drawable.wolves0);        }

        if(timeFoto.equals("Atalanta")){            imageLogo.setImageResource(R.drawable.atalanta0);        }
        if(timeFoto.equals("Bologna")){            imageLogo.setImageResource(R.drawable.parma0);        }
        if(timeFoto.equals("Cagliari")){            imageLogo.setImageResource(R.drawable.parma0);        }
        if(timeFoto.equals("Fiorentina")){            imageLogo.setImageResource(R.drawable.fiorentina0);        }
        if(timeFoto.equals("Genoa")){            imageLogo.setImageResource(R.drawable.genoa0);        }
        if(timeFoto.equals("Inter")){            imageLogo.setImageResource(R.drawable.milan0);        }
        if(timeFoto.equals("Juventus")){            imageLogo.setImageResource(R.drawable.juventus0);        }
        if(timeFoto.equals("Milan")){            imageLogo.setImageResource(R.drawable.milan0);        }
        if(timeFoto.equals("Lazio")){            imageLogo.setImageResource(R.drawable.roma0);        }
        if(timeFoto.equals("Napoli")){            imageLogo.setImageResource(R.drawable.napoli0);        }
        if(timeFoto.equals("Parma")){            imageLogo.setImageResource(R.drawable.parma0);        }
        if(timeFoto.equals("Roma")){            imageLogo.setImageResource(R.drawable.roma0);        }
        if(timeFoto.equals("Sampdoria")){            imageLogo.setImageResource(R.drawable.genoa0);        }
        if(timeFoto.equals("Sassuolo")){            imageLogo.setImageResource(R.drawable.parma0);        }
        if(timeFoto.equals("Torino")){            imageLogo.setImageResource(R.drawable.torino0);        }
        if(timeFoto.equals("Udinese")){            imageLogo.setImageResource(R.drawable.udinese0);        }

        if(timeFoto.equals("Athletic Bilbao")){            imageLogo.setImageResource(R.drawable.athleticbilbao0);        }
        if(timeFoto.equals("Atlético Madrid")){            imageLogo.setImageResource(R.drawable.atleticomadrid0);        }
        if(timeFoto.equals("Barcelona")){            imageLogo.setImageResource(R.drawable.barcelona0);        }
        if(timeFoto.equals("Celta de Vigo")){            imageLogo.setImageResource(R.drawable.celta0);        }
        if(timeFoto.equals("Espanyol")){            imageLogo.setImageResource(R.drawable.espanyol0);        }
        if(timeFoto.equals("Getafe")){            imageLogo.setImageResource(R.drawable.getafe0);        }
        if(timeFoto.equals("Osasuna")){            imageLogo.setImageResource(R.drawable.getafe0);        }
        if(timeFoto.equals("La Coruna")){            imageLogo.setImageResource(R.drawable.lacoruna0);        }
        if(timeFoto.equals("Levante")){            imageLogo.setImageResource(R.drawable.levante0);        }
        if(timeFoto.equals("Real Betis")){            imageLogo.setImageResource(R.drawable.betis0);        }
        if(timeFoto.equals("Real Madrid")){            imageLogo.setImageResource(R.drawable.realmadrid0);        }
        if(timeFoto.equals("Real Sociedad")){            imageLogo.setImageResource(R.drawable.realsociedad0);        }
        if(timeFoto.equals("Sevilla")){            imageLogo.setImageResource(R.drawable.sevilla0);        }
        if(timeFoto.equals("Valladolid")){            imageLogo.setImageResource(R.drawable.valladolid0);        }
        if(timeFoto.equals("Valencia")){            imageLogo.setImageResource(R.drawable.valencia0);        }
        if(timeFoto.equals("Villareal")){            imageLogo.setImageResource(R.drawable.villareal0);        }

        if(timeFoto.equals("Moenchengladbach")){            imageLogo.setImageResource(R.drawable.borussia0);        }
        if(timeFoto.equals("Borussia Dortmund")){            imageLogo.setImageResource(R.drawable.dortmund0);        }
        if(timeFoto.equals("Bayern Munique")){            imageLogo.setImageResource(R.drawable.bayern0);        }
        if(timeFoto.equals("Bayer Leverkusen")){            imageLogo.setImageResource(R.drawable.leverkusen0);        }
        if(timeFoto.equals("Eintracht Frankfurt")){            imageLogo.setImageResource(R.drawable.frankfurt0);        }
        if(timeFoto.equals("Freiburg")){            imageLogo.setImageResource(R.drawable.freiburg0);        }
        if(timeFoto.equals("Hamburgo")){            imageLogo.setImageResource(R.drawable.hamburgo0);        }
        if(timeFoto.equals("Colonia")){            imageLogo.setImageResource(R.drawable.colonia0);        }
        if(timeFoto.equals("Hannover96")){            imageLogo.setImageResource(R.drawable.hannover960);        }
        if(timeFoto.equals("Hertha Berlim")){            imageLogo.setImageResource(R.drawable.hertha0);        }
        if(timeFoto.equals("Hoffenheim")){            imageLogo.setImageResource(R.drawable.hoffeinheim0);        }
        if(timeFoto.equals("RB Leipzig")){            imageLogo.setImageResource(R.drawable.leipzig0);        }
        if(timeFoto.equals("Schalke-04")){            imageLogo.setImageResource(R.drawable.schalke0);        }
        if(timeFoto.equals("Stuttgart")){            imageLogo.setImageResource(R.drawable.stuttgart0);        }
        if(timeFoto.equals("Werder Bremen")){            imageLogo.setImageResource(R.drawable.werderbremen0);        }
        if(timeFoto.equals("Wolfsburg")){            imageLogo.setImageResource(R.drawable.wolfsburg0);        }

        if(timeFoto.equals("Bordeaux")){            imageLogo.setImageResource(R.drawable.bordeaux0);        }
        if(timeFoto.equals("Lille")){            imageLogo.setImageResource(R.drawable.lille0);        }
        if(timeFoto.equals("Lyon")){            imageLogo.setImageResource(R.drawable.lyon0);        }
        if(timeFoto.equals("Monaco")){            imageLogo.setImageResource(R.drawable.monaco0);        }
        if(timeFoto.equals("Montpellier")){            imageLogo.setImageResource(R.drawable.montpellier0);        }
        if(timeFoto.equals("Nantes")){            imageLogo.setImageResource(R.drawable.nantes0);        }
        if(timeFoto.equals("Nice")){            imageLogo.setImageResource(R.drawable.nice0);        }
        if(timeFoto.equals("Olympique Marselha")){            imageLogo.setImageResource(R.drawable.marseille0);        }
        if(timeFoto.equals("PSG")){            imageLogo.setImageResource(R.drawable.psg0);        }
        if(timeFoto.equals("Reims")){            imageLogo.setImageResource(R.drawable.reims0);        }
        if(timeFoto.equals("Rennes")){            imageLogo.setImageResource(R.drawable.rennes0);        }
        if(timeFoto.equals("Saint-Etienne")){            imageLogo.setImageResource(R.drawable.stetienne0);        }
        if(timeFoto.equals("Toulouse")){            imageLogo.setImageResource(R.drawable.toulouse0);        }
        if(timeFoto.equals("Anderlecht")){            imageLogo.setImageResource(R.drawable.anderlecht0);        }
        if(timeFoto.equals("Brugge")){            imageLogo.setImageResource(R.drawable.brugge0);        }
        if(timeFoto.equals("Standard Liege")){            imageLogo.setImageResource(R.drawable.liege0);        }

        if(timeFoto.equals("Benfica")){            imageLogo.setImageResource(R.drawable.benfica0);        }
        if(timeFoto.equals("Porto")){            imageLogo.setImageResource(R.drawable.porto0);        }
        if(timeFoto.equals("Sporting")){            imageLogo.setImageResource(R.drawable.sporting0);        }
        if(timeFoto.equals("Braga")){            imageLogo.setImageResource(R.drawable.braga0);        }
        if(timeFoto.equals("Vitória Guimarães")){            imageLogo.setImageResource(R.drawable.guimaraes0);        }
        if(timeFoto.equals("Ajax")){            imageLogo.setImageResource(R.drawable.ajax0);        }
        if(timeFoto.equals("Feyenoord")){            imageLogo.setImageResource(R.drawable.feyenoord0);        }
        if(timeFoto.equals("PSV")){            imageLogo.setImageResource(R.drawable.psv0);        }
        if(timeFoto.equals("Celtic")){            imageLogo.setImageResource(R.drawable.celtic0);        }
        if(timeFoto.equals("Glasgow Rangers")){            imageLogo.setImageResource(R.drawable.rangers0);        }
        if(timeFoto.equals("Rosemborg")){            imageLogo.setImageResource(R.drawable.rosemborg0);        }
        if(timeFoto.equals("Malmo")){            imageLogo.setImageResource(R.drawable.malmo0);        }
        if(timeFoto.equals("Copenhague")){            imageLogo.setImageResource(R.drawable.copenhague0);        }
        if(timeFoto.equals("RB Salzburg")){            imageLogo.setImageResource(R.drawable.rbsalzburg0);        }
        if(timeFoto.equals("Rapid Viena")){            imageLogo.setImageResource(R.drawable.rapidviena0);        }
        if(timeFoto.equals("Basel")){            imageLogo.setImageResource(R.drawable.basel0);        }

        if(timeFoto.equals("Zenit")){            imageLogo.setImageResource(R.drawable.zenit0);        }
        if(timeFoto.equals("CSKA")){            imageLogo.setImageResource(R.drawable.cska0);        }
        if(timeFoto.equals("Krasnodar")){            imageLogo.setImageResource(R.drawable.krasnodar0);        }
        if(timeFoto.equals("Spartak Moscou")){            imageLogo.setImageResource(R.drawable.spartak0);        }
        if(timeFoto.equals("Galatasaray")){            imageLogo.setImageResource(R.drawable.galatasaray0);        }
        if(timeFoto.equals("Fenerbahce")){            imageLogo.setImageResource(R.drawable.fenerbahce0);        }
        if(timeFoto.equals("Besiktas")){            imageLogo.setImageResource(R.drawable.besiktas0);        }
        if(timeFoto.equals("Olympiakos")){            imageLogo.setImageResource(R.drawable.olympiakos0);        }
        if(timeFoto.equals("Estrela Vermelha")){            imageLogo.setImageResource(R.drawable.estrelavermelha0);        }
        if(timeFoto.equals("Partizan")){            imageLogo.setImageResource(R.drawable.partizan0);        }
        if(timeFoto.equals("Ludogorets")){            imageLogo.setImageResource(R.drawable.ludogorets0);        }
        if(timeFoto.equals("Dinamo Zagreb")){            imageLogo.setImageResource(R.drawable.dinamozagreb0);        }
        if(timeFoto.equals("Shaktar Donetsk")){            imageLogo.setImageResource(R.drawable.shaktar0);        }
        if(timeFoto.equals("Dinamo Kiev")){            imageLogo.setImageResource(R.drawable.dinamo0);        }
        if(timeFoto.equals("Sparta Praga")){            imageLogo.setImageResource(R.drawable.spartapraga0);        }
        if(timeFoto.equals("APOEL")){            imageLogo.setImageResource(R.drawable.apoel0);        }

        if(timeFoto.equals("Birmigham")){            imageLogo.setImageResource(R.drawable.birmigham0);        }
        if(timeFoto.equals("Blackburn")){            imageLogo.setImageResource(R.drawable.blackburn0);        }
        if(timeFoto.equals("Burnley")){            imageLogo.setImageResource(R.drawable.burnley0);        }
        if(timeFoto.equals("Brighton")){            imageLogo.setImageResource(R.drawable.brighton0);        }
        if(timeFoto.equals("Derby Count")){            imageLogo.setImageResource(R.drawable.derby0);        }
        if(timeFoto.equals("Fulham")){            imageLogo.setImageResource(R.drawable.fulham0);        }
        if(timeFoto.equals("Hull City")){            imageLogo.setImageResource(R.drawable.hullcity0);        }
        if(timeFoto.equals("Middlesbrough")){      imageLogo.setImageResource(R.drawable.middlesbrough0);        }
        if(timeFoto.equals("Norwich")){            imageLogo.setImageResource(R.drawable.norwich0);        }
        if(timeFoto.equals("Nottingham Forest")){    imageLogo.setImageResource(R.drawable.nottinghamforest0);        }
        if(timeFoto.equals("QPR")){                imageLogo.setImageResource(R.drawable.qpr0);        }
        if(timeFoto.equals("Reading")){            imageLogo.setImageResource(R.drawable.bragantino0);        }
        if(timeFoto.equals("Sheffield United")){    imageLogo.setImageResource(R.drawable.sheffield0);        }
        if(timeFoto.equals("Stoke City")){            imageLogo.setImageResource(R.drawable.stoke0);        }
        if(timeFoto.equals("Swansea")){            imageLogo.setImageResource(R.drawable.swansea0);        }
        if(timeFoto.equals("Watford")){            imageLogo.setImageResource(R.drawable.watford0);        }

        if(timeFoto.equals("Avaí")){                imageLogo.setImageResource(R.drawable.avai0);        }
        if(timeFoto.equals("Botafogo-SP")){            imageLogo.setImageResource(R.drawable.botafogosp0);;     }
        if(timeFoto.equals("Bragantino")){            imageLogo.setImageResource(R.drawable.bragantino0);      }
        if(timeFoto.equals("Ceará")){               imageLogo.setImageResource(R.drawable.fortaleza0);        }
        if(timeFoto.equals("Coritiba")){            imageLogo.setImageResource(R.drawable.coritiba0);        }
        if(timeFoto.equals("Criciúma")){            imageLogo.setImageResource(R.drawable.criciuma0);        }
        if(timeFoto.equals("Figueirense")){         imageLogo.setImageResource(R.drawable.figueirense0);        }
        if(timeFoto.equals("Fortaleza")){          imageLogo.setImageResource(R.drawable.fortaleza0);         }
        if(timeFoto.equals("Guarani")){            imageLogo.setImageResource(R.drawable.guarani0);         }
        if(timeFoto.equals("Juventude")){         imageLogo.setImageResource(R.drawable.juventude0);          }
        if(timeFoto.equals("Naútico")){            imageLogo.setImageResource(R.drawable.nautico0);         }
        if(timeFoto.equals("Paraná")){            imageLogo.setImageResource(R.drawable.parana0);          }
        if(timeFoto.equals("Paysandu")){          imageLogo.setImageResource(R.drawable.paysandu0);          }
        if(timeFoto.equals("Ponte Preta")){       imageLogo.setImageResource(R.drawable.pontepreta0);          }
        if(timeFoto.equals("Santa Cruz")){        imageLogo.setImageResource(R.drawable.santacruz0);          }
        if(timeFoto.equals("Vitória")){            imageLogo.setImageResource(R.drawable.vitoria0);         }

        if(timeFoto.equals("Argentino Juniors")){       imageLogo.setImageResource(R.drawable.argentinosjr0);        }
        if(timeFoto.equals("Arsenal Sarandí")){            imageLogo.setImageResource(R.drawable.sarandi0);     }
        if(timeFoto.equals("Banfield")){            imageLogo.setImageResource(R.drawable.banfield0);      }
        if(timeFoto.equals("Boca Juniors")){               imageLogo.setImageResource(R.drawable.boca0);        }
        if(timeFoto.equals("Colón")){                imageLogo.setImageResource(R.drawable.colon0);        }
        if(timeFoto.equals("Estudiantes")){            imageLogo.setImageResource(R.drawable.estudiantes0);        }
        if(timeFoto.equals("Independiente")){         imageLogo.setImageResource(R.drawable.independiente0);        }
        if(timeFoto.equals("Huracán")){             imageLogo.setImageResource(R.drawable.huracan0);         }
        if(timeFoto.equals("Lanús")){               imageLogo.setImageResource(R.drawable.lanus0);         }
        if(timeFoto.equals("Newell's Old Boys")){         imageLogo.setImageResource(R.drawable.newells0);          }
        if(timeFoto.equals("Racing")){               imageLogo.setImageResource(R.drawable.racing0);         }
        if(timeFoto.equals("River Plate")){            imageLogo.setImageResource(R.drawable.river0);          }
        if(timeFoto.equals("Rosario Central")){          imageLogo.setImageResource(R.drawable.rosario0);          }
        if(timeFoto.equals("San Lorenzo")){          imageLogo.setImageResource(R.drawable.sanlorenzo0);          }
        if(timeFoto.equals("Talleres")){              imageLogo.setImageResource(R.drawable.talleres0);          }
        if(timeFoto.equals("Vélez Sarsfield")){            imageLogo.setImageResource(R.drawable.velez0);         }

        if(timeFoto.equals("Peñarol")){       imageLogo.setImageResource(R.drawable.penarol0);        }
        if(timeFoto.equals("Nacional")){            imageLogo.setImageResource(R.drawable.nacional0);     }
        if(timeFoto.equals("Olimpia")){            imageLogo.setImageResource(R.drawable.olimpia0);      }
        if(timeFoto.equals("Cerro Porteño")){               imageLogo.setImageResource(R.drawable.cerro0);        }
        if(timeFoto.equals("Libertad")){                imageLogo.setImageResource(R.drawable.libertad0);        }
        if(timeFoto.equals("Colo-Colo")){            imageLogo.setImageResource(R.drawable.colocolo0);        }
        if(timeFoto.equals("LaU")){         imageLogo.setImageResource(R.drawable.lau0);        }
        if(timeFoto.equals("Univ. Católica")){             imageLogo.setImageResource(R.drawable.universidadcatolica0);         }
        if(timeFoto.equals("Bolívar")){               imageLogo.setImageResource(R.drawable.bolivar0);         }
        if(timeFoto.equals("Alianza Lima")){         imageLogo.setImageResource(R.drawable.alianzalima0);          }
        if(timeFoto.equals("Sporting Cristal")){               imageLogo.setImageResource(R.drawable.sportingcristal0);         }
        if(timeFoto.equals("Cienciano")){            imageLogo.setImageResource(R.drawable.cienciano0);          }
        if(timeFoto.equals("Barcelona-EQU")){          imageLogo.setImageResource(R.drawable.barcelonaequ0);          }
        if(timeFoto.equals("Emelec")){          imageLogo.setImageResource(R.drawable.emelec0);          }
        if(timeFoto.equals("LDU")){              imageLogo.setImageResource(R.drawable.ldu0);          }
        if(timeFoto.equals("Caracas")){            imageLogo.setImageResource(R.drawable.parma0);         }

        if(timeFoto.equals("América de Cali")){       imageLogo.setImageResource(R.drawable.americacali0);        }
        if(timeFoto.equals("Atlético Nacional")){            imageLogo.setImageResource(R.drawable.atleticonacional0);     }
        if(timeFoto.equals("Deportivo Cali")){            imageLogo.setImageResource(R.drawable.deportivocali0);      }
        if(timeFoto.equals("Junior")){               imageLogo.setImageResource(R.drawable.junior0);        }
        if(timeFoto.equals("I. Medellín")){                imageLogo.setImageResource(R.drawable.medellin0);        }
        if(timeFoto.equals("Once Caldas")){            imageLogo.setImageResource(R.drawable.oncecaldas0);        }
        if(timeFoto.equals("Millonarios")){         imageLogo.setImageResource(R.drawable.millonarios0);        }
        if(timeFoto.equals("Santa Fé")){             imageLogo.setImageResource(R.drawable.santafe0);         }
        if(timeFoto.equals("América-MEX")){               imageLogo.setImageResource(R.drawable.americamx0);         }
        if(timeFoto.equals("Chivas Guadalajara")){         imageLogo.setImageResource(R.drawable.chivas0);          }
        if(timeFoto.equals("Cruz Azul")){               imageLogo.setImageResource(R.drawable.cruzazul0);         }
        if(timeFoto.equals("Monterrey")){            imageLogo.setImageResource(R.drawable.monterrey0);          }
        if(timeFoto.equals("Pachuca")){          imageLogo.setImageResource(R.drawable.pachuca0);          }
        if(timeFoto.equals("Pumas")){          imageLogo.setImageResource(R.drawable.pumas0);          }
        if(timeFoto.equals("Tigres")){              imageLogo.setImageResource(R.drawable.tigres0);          }
        if(timeFoto.equals("Toluca")){            imageLogo.setImageResource(R.drawable.toluca0);         }

        if(timeFoto.equals("Ghuagzhou Evergrande")){       imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Beijing Guoan")){            imageLogo.setImageResource(R.drawable.toluca);     }
        if(timeFoto.equals("Shandong Luneng")){            imageLogo.setImageResource(R.drawable.toluca);      }
        if(timeFoto.equals("Shanghai SIPG")){               imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Kashima Antlers")){                imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Urawa Red Diamonds")){            imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Vissel Kobe")){             imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("FC Tokyo")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("FC Seoul")){         imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Jeonbuk Hyundai")){            imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Ain-EAU")){         imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Sadd-QAT")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Duhail-QAT")){            imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Ahli")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Hilal")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Persepolis")){              imageLogo.setImageResource(R.drawable.toluca);          }

        if(timeFoto.equals("Sydney FC")){       imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Melbourne Victory")){            imageLogo.setImageResource(R.drawable.toluca);     }
        if(timeFoto.equals("Suwon Samsung")){               imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Ulsan Hyundai")){            imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Jiangsu Suning")){         imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Shanghai Shenhua")){                imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Cerezo Osaka")){         imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Kawasaki Frontale")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Kashiwa Reysol")){            imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Gamba Osaka")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Yokohama F-Marinos")){            imageLogo.setImageResource(R.drawable.toluca);      }
        if(timeFoto.equals("Al Nassr")){             imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Ittihad")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Pakhtakor-UZB")){            imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Sepahan")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Esteghlal")){              imageLogo.setImageResource(R.drawable.toluca);          }

        if(timeFoto.equals("Atlanta United")){       imageLogo.setImageResource(R.drawable.atlanta0);        }
        if(timeFoto.equals("Chicago Fire")){            imageLogo.setImageResource(R.drawable.chicago0);     }
        if(timeFoto.equals("Columbus Crew")){               imageLogo.setImageResource(R.drawable.la0);        }
        if(timeFoto.equals("DC United")){            imageLogo.setImageResource(R.drawable.dcunited0);        }
        if(timeFoto.equals("FC Dallas")){         imageLogo.setImageResource(R.drawable.dallas0);        }
        if(timeFoto.equals("Houston Dynamo")){                imageLogo.setImageResource(R.drawable.houston0);        }
        if(timeFoto.equals("LA Galaxy")){            imageLogo.setImageResource(R.drawable.la0);          }
        if(timeFoto.equals("New England Revolution")){               imageLogo.setImageResource(R.drawable.nerevolution0);         }
        if(timeFoto.equals("NY City")){          imageLogo.setImageResource(R.drawable.nycity0);          }
        if(timeFoto.equals("NY Red Bulls")){            imageLogo.setImageResource(R.drawable.nyredbull0);      }
        if(timeFoto.equals("Orlando City")){             imageLogo.setImageResource(R.drawable.orlando0);         }
        if(timeFoto.equals("Portland Timbers")){               imageLogo.setImageResource(R.drawable.portland0);         }
        if(timeFoto.equals("Seattle Sounders")){            imageLogo.setImageResource(R.drawable.seattle0);         }
        if(timeFoto.equals("Sporting Kansas City")){          imageLogo.setImageResource(R.drawable.la0);          }
        if(timeFoto.equals("Toronto FC")){              imageLogo.setImageResource(R.drawable.toronto0);          }
        if(timeFoto.equals("Vancouver Whitecaps")){         imageLogo.setImageResource(R.drawable.vancouver0);          }
    }
    public void imageLogo(String timeFoto, ImageView imageLogo){
        if(timeFoto.equals("Atlético-MG")){       imageLogo.setImageResource(R.drawable.atleticomg);        }
        if(timeFoto.equals("Atlético-PR")){       imageLogo.setImageResource(R.drawable.atleticopr);       }
        if(timeFoto.equals("Bahia")){             imageLogo.setImageResource(R.drawable.bahia);        }
        if(timeFoto.equals("Botafogo")){          imageLogo.setImageResource(R.drawable.botafogo);        }
        if(timeFoto.equals("Corinthians")){       imageLogo.setImageResource(R.drawable.corinthians);        }
        if(timeFoto.equals("Cruzeiro")){          imageLogo.setImageResource(R.drawable.cruzeiro);        }
        if(timeFoto.equals("Flamengo")){          imageLogo.setImageResource(R.drawable.flamengo);        }
        if(timeFoto.equals("Fluminense")){        imageLogo.setImageResource(R.drawable.fluminense);        }
        if(timeFoto.equals("Grêmio")){            imageLogo.setImageResource(R.drawable.gremio);        }
        if(timeFoto.equals("Goias")){            imageLogo.setImageResource(R.drawable.goias);        }
        if(timeFoto.equals("Internacional")){     imageLogo.setImageResource(R.drawable.internacional);        }
        if(timeFoto.equals("Palmeiras")){            imageLogo.setImageResource(R.drawable.palmeiras);   }
        if(timeFoto.equals("Santos")){            imageLogo.setImageResource(R.drawable.santos);        }
        if(timeFoto.equals("São Paulo")){         imageLogo.setImageResource(R.drawable.saopaulo);        }
        if(timeFoto.equals("Sport")){            imageLogo.setImageResource(R.drawable.sport);        }
        if(timeFoto.equals("Vasco")){            imageLogo.setImageResource(R.drawable.vasco);        }

        if(timeFoto.equals("Arsenal")){            imageLogo.setImageResource(R.drawable.arsenal);        }
        if(timeFoto.equals("Aston Villa")){            imageLogo.setImageResource(R.drawable.astonvilla);        }
        if(timeFoto.equals("Crystal Palace")){            imageLogo.setImageResource(R.drawable.crystalpalace);        }
        if(timeFoto.equals("Chelsea")){            imageLogo.setImageResource(R.drawable.chelsea);        }
        if(timeFoto.equals("Everton")){            imageLogo.setImageResource(R.drawable.everton);        }
        if(timeFoto.equals("Leicester")){            imageLogo.setImageResource(R.drawable.leicester);        }
        if(timeFoto.equals("Leeds United")){            imageLogo.setImageResource(R.drawable.leeds);        }
        if(timeFoto.equals("Liverpool")){            imageLogo.setImageResource(R.drawable.liverpool);        }
        if(timeFoto.equals("Manchester City")){            imageLogo.setImageResource(R.drawable.manchestercity);        }
        if(timeFoto.equals("Manchester United")){            imageLogo.setImageResource(R.drawable.manchesterunited);        }
        if(timeFoto.equals("Newcastle")){            imageLogo.setImageResource(R.drawable.newcastle);        }
        if(timeFoto.equals("Southampton")){            imageLogo.setImageResource(R.drawable.southampton);        }
        if(timeFoto.equals("Tottenham")){            imageLogo.setImageResource(R.drawable.tottenham);        }
        if(timeFoto.equals("West Bromwich")){            imageLogo.setImageResource(R.drawable.westbromwich);        }
        if(timeFoto.equals("West Ham")){            imageLogo.setImageResource(R.drawable.westham);        }
        if(timeFoto.equals("Wolves")){            imageLogo.setImageResource(R.drawable.wolves);        }

        if(timeFoto.equals("Atalanta")){            imageLogo.setImageResource(R.drawable.atalanta);        }
        if(timeFoto.equals("Bologna")){            imageLogo.setImageResource(R.drawable.bologna);        }
        if(timeFoto.equals("Cagliari")){            imageLogo.setImageResource(R.drawable.cagliari);        }
        if(timeFoto.equals("Fiorentina")){            imageLogo.setImageResource(R.drawable.fiorentina);        }
        if(timeFoto.equals("Genoa")){            imageLogo.setImageResource(R.drawable.genoa);        }
        if(timeFoto.equals("Inter")){            imageLogo.setImageResource(R.drawable.inter);        }
        if(timeFoto.equals("Juventus")){            imageLogo.setImageResource(R.drawable.juventus);        }
        if(timeFoto.equals("Milan")){            imageLogo.setImageResource(R.drawable.milan);        }
        if(timeFoto.equals("Lazio")){            imageLogo.setImageResource(R.drawable.lazio);        }
        if(timeFoto.equals("Napoli")){            imageLogo.setImageResource(R.drawable.napoli);        }
        if(timeFoto.equals("Parma")){            imageLogo.setImageResource(R.drawable.parma);        }
        if(timeFoto.equals("Roma")){            imageLogo.setImageResource(R.drawable.roma);        }
        if(timeFoto.equals("Sampdoria")){            imageLogo.setImageResource(R.drawable.sampdoria);        }
        if(timeFoto.equals("Sassuolo")){            imageLogo.setImageResource(R.drawable.sassuolo);        }
        if(timeFoto.equals("Torino")){            imageLogo.setImageResource(R.drawable.torino);        }
        if(timeFoto.equals("Udinese")){            imageLogo.setImageResource(R.drawable.udinese);        }

        if(timeFoto.equals("Athletic Bilbao")){            imageLogo.setImageResource(R.drawable.athleticbilbao);        }
        if(timeFoto.equals("Atlético Madrid")){            imageLogo.setImageResource(R.drawable.atleticomadrid);        }
        if(timeFoto.equals("Barcelona")){            imageLogo.setImageResource(R.drawable.barcelona);        }
        if(timeFoto.equals("Celta de Vigo")){            imageLogo.setImageResource(R.drawable.celta);        }
        if(timeFoto.equals("Espanyol")){            imageLogo.setImageResource(R.drawable.espanyol);        }
        if(timeFoto.equals("Getafe")){            imageLogo.setImageResource(R.drawable.getafe);        }
        if(timeFoto.equals("Osasuna")){            imageLogo.setImageResource(R.drawable.osasuna);        }
        if(timeFoto.equals("La Coruna")){            imageLogo.setImageResource(R.drawable.lacoruna);        }
        if(timeFoto.equals("Levante")){            imageLogo.setImageResource(R.drawable.levante);        }
        if(timeFoto.equals("Real Betis")){            imageLogo.setImageResource(R.drawable.realbetis);        }
        if(timeFoto.equals("Real Madrid")){            imageLogo.setImageResource(R.drawable.realmadrid);        }
        if(timeFoto.equals("Real Sociedad")){            imageLogo.setImageResource(R.drawable.realsociedad);        }
        if(timeFoto.equals("Sevilla")){            imageLogo.setImageResource(R.drawable.sevilla);        }
        if(timeFoto.equals("Valladolid")){            imageLogo.setImageResource(R.drawable.valladolid);        }
        if(timeFoto.equals("Valencia")){            imageLogo.setImageResource(R.drawable.valencia);        }
        if(timeFoto.equals("Villareal")){            imageLogo.setImageResource(R.drawable.villareal);        }

        if(timeFoto.equals("Moenchengladbach")){            imageLogo.setImageResource(R.drawable.borussia);        }
        if(timeFoto.equals("Borussia Dortmund")){            imageLogo.setImageResource(R.drawable.dortmund);        }
        if(timeFoto.equals("Bayern Munique")){            imageLogo.setImageResource(R.drawable.bayern);        }
        if(timeFoto.equals("Bayer Leverkusen")){            imageLogo.setImageResource(R.drawable.leverkusen);        }
        if(timeFoto.equals("Eintracht Frankfurt")){            imageLogo.setImageResource(R.drawable.frankfurt);        }
        if(timeFoto.equals("Freiburg")){            imageLogo.setImageResource(R.drawable.freiburg);        }
        if(timeFoto.equals("Hamburgo")){            imageLogo.setImageResource(R.drawable.hamburgo);        }
        if(timeFoto.equals("Colonia")){            imageLogo.setImageResource(R.drawable.colonia);        }
        if(timeFoto.equals("Hannover96")){            imageLogo.setImageResource(R.drawable.hannover96);        }
        if(timeFoto.equals("Hertha Berlim")){            imageLogo.setImageResource(R.drawable.hertha);        }
        if(timeFoto.equals("Hoffenheim")){            imageLogo.setImageResource(R.drawable.hoffeinheim);        }
        if(timeFoto.equals("RB Leipzig")){            imageLogo.setImageResource(R.drawable.leipzig);        }
        if(timeFoto.equals("Schalke-04")){            imageLogo.setImageResource(R.drawable.schalke);        }
        if(timeFoto.equals("Stuttgart")){            imageLogo.setImageResource(R.drawable.stuttgart);        }
        if(timeFoto.equals("Werder Bremen")){            imageLogo.setImageResource(R.drawable.werderbremen);        }
        if(timeFoto.equals("Wolfsburg")){            imageLogo.setImageResource(R.drawable.wolfsburg);        }

        if(timeFoto.equals("Bordeaux")){            imageLogo.setImageResource(R.drawable.bordeaux);        }
        if(timeFoto.equals("Lille")){            imageLogo.setImageResource(R.drawable.lille);        }
        if(timeFoto.equals("Lyon")){            imageLogo.setImageResource(R.drawable.lyon);        }
        if(timeFoto.equals("Monaco")){            imageLogo.setImageResource(R.drawable.monaco);        }
        if(timeFoto.equals("Montpellier")){            imageLogo.setImageResource(R.drawable.montpellier);        }
        if(timeFoto.equals("Nantes")){            imageLogo.setImageResource(R.drawable.nantes);        }
        if(timeFoto.equals("Nice")){            imageLogo.setImageResource(R.drawable.nice);        }
        if(timeFoto.equals("Olympique Marselha")){            imageLogo.setImageResource(R.drawable.marseille);        }
        if(timeFoto.equals("PSG")){            imageLogo.setImageResource(R.drawable.psg);        }
        if(timeFoto.equals("Reims")){            imageLogo.setImageResource(R.drawable.reims);        }
        if(timeFoto.equals("Rennes")){            imageLogo.setImageResource(R.drawable.rennes);        }
        if(timeFoto.equals("Saint-Etienne")){            imageLogo.setImageResource(R.drawable.stetienne);        }
        if(timeFoto.equals("Toulouse")){            imageLogo.setImageResource(R.drawable.toulouse);        }
        if(timeFoto.equals("Anderlecht")){            imageLogo.setImageResource(R.drawable.anderlecht);        }
        if(timeFoto.equals("Brugge")){            imageLogo.setImageResource(R.drawable.brugge);        }
        if(timeFoto.equals("Standard Liege")){            imageLogo.setImageResource(R.drawable.liege);        }

        if(timeFoto.equals("Benfica")){            imageLogo.setImageResource(R.drawable.benfica);        }
        if(timeFoto.equals("Porto")){            imageLogo.setImageResource(R.drawable.porto);        }
        if(timeFoto.equals("Sporting")){            imageLogo.setImageResource(R.drawable.sporting);        }
        if(timeFoto.equals("Braga")){            imageLogo.setImageResource(R.drawable.braga);        }
        if(timeFoto.equals("Vitória Guimarães")){            imageLogo.setImageResource(R.drawable.guimaraes);        }
        if(timeFoto.equals("Ajax")){            imageLogo.setImageResource(R.drawable.ajax);        }
        if(timeFoto.equals("Feyenoord")){            imageLogo.setImageResource(R.drawable.feyenoord);        }
        if(timeFoto.equals("PSV")){            imageLogo.setImageResource(R.drawable.psv);        }
        if(timeFoto.equals("Celtic")){            imageLogo.setImageResource(R.drawable.celtic);        }
        if(timeFoto.equals("Glasgow Rangers")){            imageLogo.setImageResource(R.drawable.rangers);        }
        if(timeFoto.equals("Rosemborg")){            imageLogo.setImageResource(R.drawable.rosemborg);        }
        if(timeFoto.equals("Malmo")){            imageLogo.setImageResource(R.drawable.malmo);        }
        if(timeFoto.equals("Copenhague")){            imageLogo.setImageResource(R.drawable.copenhague);        }
        if(timeFoto.equals("RB Salzburg")){            imageLogo.setImageResource(R.drawable.rbsalzburg);        }
        if(timeFoto.equals("Rapid Viena")){            imageLogo.setImageResource(R.drawable.rapidviena);        }
        if(timeFoto.equals("Basel")){            imageLogo.setImageResource(R.drawable.basel);        }

        if(timeFoto.equals("Zenit")){            imageLogo.setImageResource(R.drawable.zenit);        }
        if(timeFoto.equals("CSKA")){            imageLogo.setImageResource(R.drawable.cska);        }
        if(timeFoto.equals("Krasnodar")){            imageLogo.setImageResource(R.drawable.krasnodar);        }
        if(timeFoto.equals("Spartak Moscou")){            imageLogo.setImageResource(R.drawable.spartak);        }
        if(timeFoto.equals("Galatasaray")){            imageLogo.setImageResource(R.drawable.galatasaray);        }
        if(timeFoto.equals("Fenerbahce")){            imageLogo.setImageResource(R.drawable.fenerbahce);        }
        if(timeFoto.equals("Besiktas")){            imageLogo.setImageResource(R.drawable.besiktas);        }
        if(timeFoto.equals("Olympiakos")){            imageLogo.setImageResource(R.drawable.olympiakos);        }
        if(timeFoto.equals("Estrela Vermelha")){            imageLogo.setImageResource(R.drawable.estrelavermelha);        }
        if(timeFoto.equals("Partizan")){            imageLogo.setImageResource(R.drawable.partizan);        }
        if(timeFoto.equals("Ludogorets")){            imageLogo.setImageResource(R.drawable.ludogorets);        }
        if(timeFoto.equals("Dinamo Zagreb")){            imageLogo.setImageResource(R.drawable.dinamozagreb);        }
        if(timeFoto.equals("Shaktar Donetsk")){            imageLogo.setImageResource(R.drawable.shaktar);        }
        if(timeFoto.equals("Dinamo Kiev")){            imageLogo.setImageResource(R.drawable.dinamokiev);        }
        if(timeFoto.equals("Sparta Praga")){            imageLogo.setImageResource(R.drawable.spartapraga);        }
        if(timeFoto.equals("APOEL")){            imageLogo.setImageResource(R.drawable.apoel);        }

        if(timeFoto.equals("Birmigham")){            imageLogo.setImageResource(R.drawable.birmigham);        }
        if(timeFoto.equals("Blackburn")){            imageLogo.setImageResource(R.drawable.blackburn);        }
        if(timeFoto.equals("Burnley")){            imageLogo.setImageResource(R.drawable.burnley);        }
        if(timeFoto.equals("Brighton")){            imageLogo.setImageResource(R.drawable.brighton);        }
        if(timeFoto.equals("Derby Count")){            imageLogo.setImageResource(R.drawable.derby);        }
        if(timeFoto.equals("Fulham")){            imageLogo.setImageResource(R.drawable.fulham);        }
        if(timeFoto.equals("Hull City")){            imageLogo.setImageResource(R.drawable.hullcity);        }
        if(timeFoto.equals("Middlesbrough")){      imageLogo.setImageResource(R.drawable.middlesbrough);        }
        if(timeFoto.equals("Norwich")){            imageLogo.setImageResource(R.drawable.norwich);        }
        if(timeFoto.equals("Nottingham Forest")){    imageLogo.setImageResource(R.drawable.nottingham);        }
        if(timeFoto.equals("QPR")){                imageLogo.setImageResource(R.drawable.qpr);        }
        if(timeFoto.equals("Reading")){            imageLogo.setImageResource(R.drawable.reading);        }
        if(timeFoto.equals("Sheffield United")){    imageLogo.setImageResource(R.drawable.sheffield);        }
        if(timeFoto.equals("Stoke City")){            imageLogo.setImageResource(R.drawable.stoke);        }
        if(timeFoto.equals("Swansea")){            imageLogo.setImageResource(R.drawable.swansea);        }
        if(timeFoto.equals("Watford")){            imageLogo.setImageResource(R.drawable.watford);        }

        if(timeFoto.equals("Avaí")){                imageLogo.setImageResource(R.drawable.avai);        }
        if(timeFoto.equals("Botafogo-SP")){            imageLogo.setImageResource(R.drawable.botafogosp);;     }
        if(timeFoto.equals("Bragantino")){            imageLogo.setImageResource(R.drawable.bragantino);      }
        if(timeFoto.equals("Ceará")){               imageLogo.setImageResource(R.drawable.ceara);        }
        if(timeFoto.equals("Coritiba")){            imageLogo.setImageResource(R.drawable.coritiba);        }
        if(timeFoto.equals("Criciúma")){            imageLogo.setImageResource(R.drawable.criciuma);        }
        if(timeFoto.equals("Figueirense")){         imageLogo.setImageResource(R.drawable.figueirense);        }
        if(timeFoto.equals("Fortaleza")){          imageLogo.setImageResource(R.drawable.fortaleza);         }
        if(timeFoto.equals("Guarani")){            imageLogo.setImageResource(R.drawable.guarani);         }
        if(timeFoto.equals("Juventude")){         imageLogo.setImageResource(R.drawable.juventude);          }
        if(timeFoto.equals("Naútico")){            imageLogo.setImageResource(R.drawable.nautico);         }
        if(timeFoto.equals("Paraná")){            imageLogo.setImageResource(R.drawable.parana);          }
        if(timeFoto.equals("Paysandu")){          imageLogo.setImageResource(R.drawable.paysandu);          }
        if(timeFoto.equals("Ponte Preta")){       imageLogo.setImageResource(R.drawable.pontepreta);          }
        if(timeFoto.equals("Santa Cruz")){        imageLogo.setImageResource(R.drawable.santacruz);          }
        if(timeFoto.equals("Vitória")){            imageLogo.setImageResource(R.drawable.vitoria);         }

        if(timeFoto.equals("Argentino Juniors")){       imageLogo.setImageResource(R.drawable.argentinosjr);        }
        if(timeFoto.equals("Arsenal Sarandí")){            imageLogo.setImageResource(R.drawable.sarandi);     }
        if(timeFoto.equals("Banfield")){            imageLogo.setImageResource(R.drawable.banfield);      }
        if(timeFoto.equals("Boca Juniors")){               imageLogo.setImageResource(R.drawable.bocajuniors);        }
        if(timeFoto.equals("Colón")){                imageLogo.setImageResource(R.drawable.colon);        }
        if(timeFoto.equals("Estudiantes")){            imageLogo.setImageResource(R.drawable.estudiantes);        }
        if(timeFoto.equals("Independiente")){         imageLogo.setImageResource(R.drawable.independiente);        }
        if(timeFoto.equals("Huracán")){             imageLogo.setImageResource(R.drawable.huracan);         }
        if(timeFoto.equals("Lanús")){               imageLogo.setImageResource(R.drawable.lanus);         }
        if(timeFoto.equals("Newell's Old Boys")){         imageLogo.setImageResource(R.drawable.newells);          }
        if(timeFoto.equals("Racing")){               imageLogo.setImageResource(R.drawable.racing);         }
        if(timeFoto.equals("River Plate")){            imageLogo.setImageResource(R.drawable.riverplate);          }
        if(timeFoto.equals("Rosario Central")){          imageLogo.setImageResource(R.drawable.rosariocentral);          }
        if(timeFoto.equals("San Lorenzo")){          imageLogo.setImageResource(R.drawable.sanlorenzo);          }
        if(timeFoto.equals("Talleres")){              imageLogo.setImageResource(R.drawable.talleres);          }
        if(timeFoto.equals("Vélez Sarsfield")){            imageLogo.setImageResource(R.drawable.velez);         }

        if(timeFoto.equals("Peñarol")){       imageLogo.setImageResource(R.drawable.penarol);        }
        if(timeFoto.equals("Nacional")){            imageLogo.setImageResource(R.drawable.nacional);     }
        if(timeFoto.equals("Olimpia")){            imageLogo.setImageResource(R.drawable.olimpia);      }
        if(timeFoto.equals("Cerro Porteño")){               imageLogo.setImageResource(R.drawable.cerro);        }
        if(timeFoto.equals("Libertad")){                imageLogo.setImageResource(R.drawable.libertad);        }
        if(timeFoto.equals("Colo-Colo")){            imageLogo.setImageResource(R.drawable.colocolo);        }
        if(timeFoto.equals("LaU")){         imageLogo.setImageResource(R.drawable.lau);        }
        if(timeFoto.equals("Univ. Católica")){             imageLogo.setImageResource(R.drawable.universidadcatolica);         }
        if(timeFoto.equals("Bolívar")){               imageLogo.setImageResource(R.drawable.bolivar);         }
        if(timeFoto.equals("Alianza Lima")){         imageLogo.setImageResource(R.drawable.alianzalima);          }
        if(timeFoto.equals("Sporting Cristal")){               imageLogo.setImageResource(R.drawable.sportingcristal);         }
        if(timeFoto.equals("Cienciano")){            imageLogo.setImageResource(R.drawable.cienciano);          }
        if(timeFoto.equals("Barcelona-EQU")){          imageLogo.setImageResource(R.drawable.barcelonaequ);          }
        if(timeFoto.equals("Emelec")){          imageLogo.setImageResource(R.drawable.emelec);          }
        if(timeFoto.equals("LDU")){              imageLogo.setImageResource(R.drawable.ldu);          }
        if(timeFoto.equals("Caracas")){            imageLogo.setImageResource(R.drawable.caracas);         }

        if(timeFoto.equals("América de Cali")){       imageLogo.setImageResource(R.drawable.americacali);        }
        if(timeFoto.equals("Atlético Nacional")){            imageLogo.setImageResource(R.drawable.atleticonacional);     }
        if(timeFoto.equals("Deportivo Cali")){            imageLogo.setImageResource(R.drawable.deportivocali);      }
        if(timeFoto.equals("Junior")){               imageLogo.setImageResource(R.drawable.junior);        }
        if(timeFoto.equals("I. Medellín")){                imageLogo.setImageResource(R.drawable.medellin);        }
        if(timeFoto.equals("Once Caldas")){            imageLogo.setImageResource(R.drawable.oncecaldas);        }
        if(timeFoto.equals("Millonarios")){         imageLogo.setImageResource(R.drawable.millonarios);        }
        if(timeFoto.equals("Santa Fé")){             imageLogo.setImageResource(R.drawable.santafe);         }
        if(timeFoto.equals("América-MEX")){               imageLogo.setImageResource(R.drawable.americamx);         }
        if(timeFoto.equals("Chivas Guadalajara")){         imageLogo.setImageResource(R.drawable.chivas);          }
        if(timeFoto.equals("Cruz Azul")){               imageLogo.setImageResource(R.drawable.cruzazul);         }
        if(timeFoto.equals("Monterrey")){            imageLogo.setImageResource(R.drawable.monterrey);          }
        if(timeFoto.equals("Pachuca")){          imageLogo.setImageResource(R.drawable.pachuca);          }
        if(timeFoto.equals("Pumas")){          imageLogo.setImageResource(R.drawable.pumas);          }
        if(timeFoto.equals("Tigres")){              imageLogo.setImageResource(R.drawable.tigres);          }
        if(timeFoto.equals("Toluca")){            imageLogo.setImageResource(R.drawable.toluca);         }

        if(timeFoto.equals("Ghuagzhou Evergrande")){       imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Beijing Guoan")){            imageLogo.setImageResource(R.drawable.toluca);     }
        if(timeFoto.equals("Shandong Luneng")){            imageLogo.setImageResource(R.drawable.toluca);      }
        if(timeFoto.equals("Shanghai SIPG")){               imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Kashima Antlers")){                imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Urawa Red Diamonds")){            imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Vissel Kobe")){             imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("FC Tokyo")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("FC Seoul")){         imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Jeonbuk Hyundai")){            imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Ain-EAU")){         imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Sadd-QAT")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Duhail-QAT")){            imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Ahli")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Al Hilal")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Persepolis")){              imageLogo.setImageResource(R.drawable.toluca);          }

        if(timeFoto.equals("Sydney FC")){       imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Melbourne Victory")){            imageLogo.setImageResource(R.drawable.toluca);     }
        if(timeFoto.equals("Suwon Samsung")){               imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Ulsan Hyundai")){            imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Jiangsu Suning")){         imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Shanghai Shenhua")){                imageLogo.setImageResource(R.drawable.toluca);        }
        if(timeFoto.equals("Cerezo Osaka")){         imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Kawasaki Frontale")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Kashiwa Reysol")){            imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Gamba Osaka")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Yokohama F-Marinos")){            imageLogo.setImageResource(R.drawable.toluca);      }
        if(timeFoto.equals("Al Nassr")){             imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Al Ittihad")){               imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Pakhtakor-UZB")){            imageLogo.setImageResource(R.drawable.toluca);         }
        if(timeFoto.equals("Sepahan")){          imageLogo.setImageResource(R.drawable.toluca);          }
        if(timeFoto.equals("Esteghlal")){              imageLogo.setImageResource(R.drawable.toluca);          }

        if(timeFoto.equals("Atlanta United")){       imageLogo.setImageResource(R.drawable.atlanta);        }
        if(timeFoto.equals("Chicago Fire")){            imageLogo.setImageResource(R.drawable.chicago);     }
        if(timeFoto.equals("Columbus Crew")){               imageLogo.setImageResource(R.drawable.columbus);        }
        if(timeFoto.equals("DC United")){            imageLogo.setImageResource(R.drawable.dcunited);        }
        if(timeFoto.equals("FC Dallas")){         imageLogo.setImageResource(R.drawable.dallas);        }
        if(timeFoto.equals("Houston Dynamo")){                imageLogo.setImageResource(R.drawable.houston);        }
        if(timeFoto.equals("LA Galaxy")){            imageLogo.setImageResource(R.drawable.la);          }
        if(timeFoto.equals("New England Revolution")){               imageLogo.setImageResource(R.drawable.nerevolution);         }
        if(timeFoto.equals("NY City")){          imageLogo.setImageResource(R.drawable.nycity);          }
        if(timeFoto.equals("NY Red Bulls")){            imageLogo.setImageResource(R.drawable.nyredbull);      }
        if(timeFoto.equals("Orlando City")){             imageLogo.setImageResource(R.drawable.orlando);         }
        if(timeFoto.equals("Portland Timbers")){               imageLogo.setImageResource(R.drawable.portland);         }
        if(timeFoto.equals("Seattle Sounders")){            imageLogo.setImageResource(R.drawable.seattle);         }
        if(timeFoto.equals("Sporting Kansas City")){          imageLogo.setImageResource(R.drawable.kansas);          }
        if(timeFoto.equals("Toronto FC")){              imageLogo.setImageResource(R.drawable.toronto);          }
        if(timeFoto.equals("Vancouver Whitecaps")){         imageLogo.setImageResource(R.drawable.vancouver);          }
    }
    //Toast.makeText(getApplicationContext(),""+dinheiro,Toast.LENGTH_SHORT).show();
}
