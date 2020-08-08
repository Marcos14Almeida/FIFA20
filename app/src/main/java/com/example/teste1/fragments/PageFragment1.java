package com.example.teste1.fragments;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.teste1.GlobalClass;
import com.example.teste1.R;

import java.util.ArrayList;

public class PageFragment1 extends Fragment {

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

    ArrayList<Integer> pontosOrdem;
    ArrayList<Integer> PtsEquipeOrdem ;
    ArrayList<String> timesOrdem;
    ArrayList<Integer> golsSofridosTotalOrdem;
    ArrayList<Integer> golsMarcadosTotalOrdem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_tabela,container,false);

        //Recebe dados globais
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        meutime  = globalVariable.Sabermeutime();
        rodada = globalVariable.SaberRodada();
        golsMarcadosTotal = globalVariable.SaberGolsMarcados();
        golsSofridosTotal = globalVariable.SaberGolsSofridos();
        pontos = globalVariable.SaberPontos();
        campeonato = globalVariable.SaberCampeonato();
        posicao = globalVariable.SaberPosicao();
        times = globalVariable.SaberTimes();
        PtsEquipe = globalVariable.SaberPtsEquipe();
        TextView textoRodada = rootView.findViewById(R.id.textoRodada);
        textoRodada.setText("Rodada "+String.valueOf(rodada-1));



        //CHAVES DA TABELA
        chave = globalVariable.SaberChave();
        //PRINT CONFRONTOS
        if(rodada<max) {
            TextView textoConfronto = rootView.findViewById(R.id.textoConfrontos);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(1)) + " x " + times.get((max * (campeonato - 1)) + chave.get(2)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos2);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(3)) + " x " + times.get((max * (campeonato - 1)) + chave.get(4)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos3);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(5)) + " x " + times.get((max * (campeonato - 1)) + chave.get(6)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos4);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(7)) + " x " + times.get((max * (campeonato - 1)) + chave.get(8)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos5);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(9)) + " x " + times.get((max * (campeonato - 1)) + chave.get(10)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos6);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(11)) + " x " + times.get((max * (campeonato - 1)) + chave.get(12)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos7);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(13)) + " x " + times.get((max * (campeonato - 1)) + chave.get(14)));
            textoConfronto = rootView.findViewById(R.id.textoConfrontos8);
            textoConfronto.setText("" + times.get((max * (campeonato - 1)) + chave.get(15)) + " x " + times.get((max * (campeonato - 1)) + chave.get(16)));
        }
        //PRINT TABELA
        timesOrdem=globalVariable.SabertimesOrdem();
        PtsEquipeOrdem=globalVariable.SaberPtsEquipeOrdem();
        pontosOrdem=globalVariable.SaberpontosOrdem();
        golsMarcadosTotalOrdem=globalVariable.SabergolsMarcadosTotalOrdem();
        golsSofridosTotalOrdem=globalVariable.SabergolsSofridosTotalOrdem();
        tabela(rootView);

        //CAMPEÃO
        if(timesOrdem.get((max*(campeonato-1))+1).equals(times.get((max*(campeonato-1))+posicao))  && rodada==max){
        MediaPlayer mp;
        mp = MediaPlayer.create(getActivity(),R.raw.hinogenerico);
            if(meutime.equals("Atlético-MG")){       mp=MediaPlayer.create(getActivity(),R.raw.hinoatleticomg);        }
            else if(meutime.equals("Cruzeiro")){            mp=MediaPlayer.create(getActivity(),R.raw.hinocruzeiro);         }
            else if(meutime.equals("Fortaleza")){            mp=MediaPlayer.create(getActivity(),R.raw.hinofortaleza);         }
            else if(meutime.equals("Flamengo")){          mp=MediaPlayer.create(getActivity(),R.raw.hinoflamengo);        }
            else if(meutime.equals("Fluminense")){        mp=MediaPlayer.create(getActivity(),R.raw.hinofluminense);         }
            else if(meutime.equals("Grêmio")){            mp=MediaPlayer.create(getActivity(),R.raw.hinogremio);         }
            else if(meutime.equals("Internacional")){     mp=MediaPlayer.create(getActivity(),R.raw.hinointernacional);        }
            else if(meutime.equals("Palmeiras")){         mp=MediaPlayer.create(getActivity(),R.raw.hinopalmeiras);    }
            else if(meutime.equals("Santos")){            mp=MediaPlayer.create(getActivity(),R.raw.hinosantos);         }
            else if(meutime.equals("São Paulo")){            mp=MediaPlayer.create(getActivity(),R.raw.hinosaopaulo);         }
            else if(meutime.equals("Sport")){            mp=MediaPlayer.create(getActivity(),R.raw.hinosport);         }
            else if(meutime.equals("Vasco")){            mp=MediaPlayer.create(getActivity(),R.raw.hinovasco);         }
            else if(meutime.equals("Real Madrid")){      mp=MediaPlayer.create(getActivity(),R.raw.hinorealmadrid);         }
            else if(meutime.equals("Barcelona")){        mp=MediaPlayer.create(getActivity(),R.raw.hinobarcelona);         }
            else if(meutime.equals("Chelsea")){          mp=MediaPlayer.create(getActivity(),R.raw.hinochelsea);         }
            else if(meutime.equals("Liverpool")){          mp=MediaPlayer.create(getActivity(),R.raw.hinoliverpool);         }
            else if(meutime.equals("Milan")){          mp=MediaPlayer.create(getActivity(),R.raw.hinomilan);         }
            else if(meutime.equals("Juventus")){          mp=MediaPlayer.create(getActivity(),R.raw.hinojuventus);         }
            else if(meutime.equals("PSG")){              mp=MediaPlayer.create(getActivity(),R.raw.hinopsg);         }
            else if(meutime.equals("Ponte Preta")){          mp=MediaPlayer.create(getActivity(),R.raw.hinoponte);         }
            mp.start();
        }

        return rootView;
    }
    public void PrintarTime(Integer id){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        time_da_linha = timesOrdem.get((max*(campeonato-1))+id);
        globalVariable.imageLogo(time_da_linha,imagemTime);
        textoNomeTime.setText(time_da_linha+" ");
        if(id==1)textoNomeTime.setBackgroundColor(Color.rgb(233,208,44));
        if(campeonato != 9 && campeonato !=10){if(id>=2 && id <=4)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));}
        if(campeonato == 9 || campeonato ==10){if(id>=1 && id <=3)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));}
        //CAMP. BRASILEIRO
        if(campeonato == 1){if(id>=5 && id <=8)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));}
        //CAMP ARGENTINO
        if(campeonato == 11){if(id>=5 && id <=6)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));}
        //CAMP SUL AMERICANO
        if(campeonato == 12){if(id>=5 && id <=12)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));}
        //CAMP COLOMBIA
        if(campeonato == 13){if(id>=5 && id <=6)textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));}
        if(id>=5 && id <=6 && (campeonato==7 || campeonato==8))textoNomeTime.setBackgroundColor(Color.rgb(150,180,255));
        //rebaixamento
        if(id>=14 && id <=16)textoNomeTime.setBackgroundColor(Color.rgb(255,150,150));
        if(time_da_linha.equals(meutime)){textoNomeTime.setBackgroundColor(Color.rgb(150,255,150));}
        textoPontos.setText(" "+String.valueOf(pontosOrdem.get((max*(campeonato-1))+id)));
        textoGolsMarcados.setText(" "+String.valueOf(golsMarcadosTotalOrdem.get((max*(campeonato-1))+id)));
        textoGolsSofridos.setText(" "+String.valueOf(golsSofridosTotalOrdem.get((max*(campeonato-1))+id)));
        SaldoGols=golsMarcadosTotalOrdem.get((max*(campeonato-1))+id)-golsSofridosTotalOrdem.get((max*(campeonato-1))+id);
        textoSaldoGols.setText(" "+String.valueOf(SaldoGols));
        textovalorEquipe.setText(" "+String.valueOf(PtsEquipeOrdem.get((max*(campeonato-1))+id)));
    }

    public void tabela(ViewGroup rootView){
         /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TABELA //
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TextView titulotabela = rootView.findViewById(R.id.titulotabela2);
        titulotabela.setText(" Times                              ");
        titulotabela = rootView.findViewById(R.id.titulotabela3);
        titulotabela.setText(" Pontos ");
        titulotabela = rootView.findViewById(R.id.titulotabela4);
        titulotabela.setText(" GM ");
        titulotabela = rootView.findViewById(R.id.titulotabela5);
        titulotabela.setText(" GS ");
        titulotabela = rootView.findViewById(R.id.titulotabela6);
        titulotabela.setText(" SG ");
        titulotabela = rootView.findViewById(R.id.titulotabela7);
        titulotabela.setText(" OVR ");
        titulotabela = rootView.findViewById(R.id.textoTitulo);
        titulotabela.setText("Tabela de Classificação");
         titulotabela = rootView.findViewById(R.id.posicao1);titulotabela.setText("1-");
         titulotabela = rootView.findViewById(R.id.posicao2);titulotabela.setText("2-");
         titulotabela = rootView.findViewById(R.id.posicao3);titulotabela.setText("3-");
         titulotabela = rootView.findViewById(R.id.posicao4);titulotabela.setText("4-");
         titulotabela = rootView.findViewById(R.id.posicao5);titulotabela.setText("5-");
         titulotabela = rootView.findViewById(R.id.posicao6);titulotabela.setText("6-");
         titulotabela = rootView.findViewById(R.id.posicao7);titulotabela.setText("7-");
         titulotabela = rootView.findViewById(R.id.posicao8);titulotabela.setText("8-");
         titulotabela = rootView.findViewById(R.id.posicao9);titulotabela.setText("9-");
         titulotabela = rootView.findViewById(R.id.posicao10);titulotabela.setText("10-");
         titulotabela = rootView.findViewById(R.id.posicao11);titulotabela.setText("11-");
         titulotabela = rootView.findViewById(R.id.posicao12);titulotabela.setText("12-");
         titulotabela = rootView.findViewById(R.id.posicao13);titulotabela.setText("13-");
         titulotabela = rootView.findViewById(R.id.posicao14);titulotabela.setText("14-");
         titulotabela = rootView.findViewById(R.id.posicao15);titulotabela.setText("15-");
         titulotabela = rootView.findViewById(R.id.posicao16);titulotabela.setText("16-");
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

        //Coluna5
        textoNomeTime =  rootView.findViewById(R.id.nomeTime5);
        textoPontos = rootView.findViewById(R.id.pontosGanhos5);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados5);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos5);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols5);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe5);
        imagemTime = rootView.findViewById(R.id.logo5);
        PrintarTime(5);

        //Coluna6
        textoNomeTime =  rootView.findViewById(R.id.nomeTime6);
        textoPontos = rootView.findViewById(R.id.pontosGanhos6);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados6);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos6);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols6);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe6);
        imagemTime = rootView.findViewById(R.id.logo6);
        PrintarTime(6);

        //Coluna7
        textoNomeTime =  rootView.findViewById(R.id.nomeTime7);
        textoPontos = rootView.findViewById(R.id.pontosGanhos7);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados7);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos7);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols7);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe7);
        imagemTime = rootView.findViewById(R.id.logo7);
        PrintarTime(7);

        //Coluna8
        textoNomeTime =  rootView.findViewById(R.id.nomeTime8);
        textoPontos = rootView.findViewById(R.id.pontosGanhos8);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados8);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos8);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols8);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe8);
        imagemTime = rootView.findViewById(R.id.logo8);
        PrintarTime(8);

        //Coluna9
        textoNomeTime =  rootView.findViewById(R.id.nomeTime9);
        textoPontos = rootView.findViewById(R.id.pontosGanhos9);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados9);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos9);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols9);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe9);
        imagemTime = rootView.findViewById(R.id.logo9);
        PrintarTime(9);

        //Coluna10
        textoNomeTime =  rootView.findViewById(R.id.nomeTime10);
        textoPontos = rootView.findViewById(R.id.pontosGanhos10);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados10);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos10);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols10);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe10);
        imagemTime = rootView.findViewById(R.id.logo10);
        PrintarTime(10);

        //Coluna11
        textoNomeTime =  rootView.findViewById(R.id.nomeTime11);
        textoPontos = rootView.findViewById(R.id.pontosGanhos11);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados11);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos11);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols11);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe11);
        imagemTime = rootView.findViewById(R.id.logo11);
        PrintarTime(11);

        //Coluna12
        textoNomeTime =  rootView.findViewById(R.id.nomeTime12);
        textoPontos = rootView.findViewById(R.id.pontosGanhos12);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados12);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos12);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols12);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe12);
        imagemTime = rootView.findViewById(R.id.logo12);
        PrintarTime(12);

        //Coluna13
        textoNomeTime =  rootView.findViewById(R.id.nomeTime13);
        textoPontos = rootView.findViewById(R.id.pontosGanhos13);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados13);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos13);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols13);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe13);
        imagemTime = rootView.findViewById(R.id.logo13);
        PrintarTime(13);

        //Coluna14
        textoNomeTime =  rootView.findViewById(R.id.nomeTime14);
        textoPontos = rootView.findViewById(R.id.pontosGanhos14);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados14);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos14);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols14);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe14);
        imagemTime = rootView.findViewById(R.id.logo14);
        PrintarTime(14);

        //Coluna15
        textoNomeTime =  rootView.findViewById(R.id.nomeTime15);
        textoPontos = rootView.findViewById(R.id.pontosGanhos15);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados15);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos15);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols15);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe15);
        imagemTime = rootView.findViewById(R.id.logo15);
        PrintarTime(15);

        //Coluna16
        textoNomeTime =  rootView.findViewById(R.id.nomeTime16);
        textoPontos = rootView.findViewById(R.id.pontosGanhos16);
        textoGolsMarcados = rootView.findViewById(R.id.golsMarcados16);
        textoGolsSofridos = rootView.findViewById(R.id.golsSofridos16);
        textoSaldoGols = rootView.findViewById(R.id.saldoGols16);
        textovalorEquipe = rootView.findViewById(R.id.valorEquipe16);
        imagemTime = rootView.findViewById(R.id.logo16);
        PrintarTime(16);
        /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //TABELA
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

}
