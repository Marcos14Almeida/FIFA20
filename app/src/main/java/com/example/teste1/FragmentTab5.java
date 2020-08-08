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

public class FragmentTab5 extends Fragment {
    Button botaoMenu;
    ImageView fundochampions;
    TextView textoTitulo;
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

    int minhaposicaoLibertadores,meuGrupoLibertadores,qualcampeonato, grupoSIMULACAO;
    int rodadaOitavas=22,rodadaQuartas=23,rodadaSemi=24,rodadaFinal=25;
    ArrayList<String> timesLibertadores = new ArrayList<>();
    ArrayList<Integer> PtsEquipeLibertadores = new ArrayList<>();
    ArrayList<Integer> pontosTotalLibertadores = new ArrayList<>();
    ArrayList<Integer> golsMarcadosTotalLibertadores = new ArrayList<>();
    ArrayList<Integer> golsSofridosTotalLibertadores = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = (View) inflater.inflate(R.layout.activity_resultados_champions, container, false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        meutime  = globalVariable.Sabermeutime();
        dinheiro  = globalVariable.SaberDinheiro();
        rodada= globalVariable.SaberRodada();
        campeonato = globalVariable.SaberCampeonato();
        PtsEquipe =globalVariable.SaberPtsEquipe();
        ano = globalVariable.SaberAno();
        max= globalVariable.SaberMax();
        max2=globalVariable.SaberMax2();

        minhaposicaoLibertadores=globalVariable.SaberPosicaoLibertadores();
        meuGrupoLibertadores = globalVariable.SaberMeuGrupoLibertadores();
        timesLibertadores=globalVariable.SaberTimesLibertadores();
        PtsEquipeLibertadores=globalVariable.SaberPtsEquipeLibertadores();
        pontosTotalLibertadores=globalVariable.SaberPontosTotalLibertadores();
        golsMarcadosTotalLibertadores=globalVariable.SaberGolsMarcadosTotalLibertadores();
        golsSofridosTotalLibertadores=globalVariable.SaberGolsSofridosTotalLibertadores();
        qualcampeonato=globalVariable.SaberQualCampeonato();

        times = globalVariable.SaberTimes();
        chave = ObterChave(rodada);
        TextView textoRodada = rootView.findViewById(R.id.textoRodada);
        if(rodada<rodadaOitavas){
            textoRodada.setText("Rodada "+String.valueOf(rodada-15));}
        if(rodada<max){
            textoRodada.setText("Rodada 0");}
        if(rodada>=rodadaOitavas){
            textoRodada.setText("Rodada ");}

        //SIMULAÇÃO CHAMPIONS LEAGUE
        if(rodada>=16 && rodada<=21){//Libertadores League
            for (int i=1;i<=32;i++){
                grupoSIMULACAO = 1+(i/4); //-> i=7 res:0+1  *i=8 res:2
                int posicaoSIMULACAO= (i%(4));     //-> i=7 res:7   *i=8 res=0
                if(i%4==0){posicaoSIMULACAO=4;grupoSIMULACAO=(i/4);}
                //se nao tiver meu time e nao for o mesmo campeonato
                int SIMULAR=0,soma=0;
                for(int z=1; z<=4;z=z+2){//z+2 pega cada confronto chave1, chave3
                    if(chave.get(z)==posicaoSIMULACAO ) {timea=z;timeb=z+1;SIMULAR=1;    //timea entre 1 e 4
                        if(SIMULAR==1){
                            //if((chave.get(z)==minhaposicaoLibertadores || chave.get(z)==minhaposicaoLibertadores) &&  grupoSIMULACAO == meuGrupoLibertadores){SIMULAR=0;soma++;
                            //    break;}
                            adversario=timesLibertadores.get((4 * (grupoSIMULACAO - 1)) + chave.get(timeb));
                            PtsEquipeAdversario=PtsEquipeLibertadores.get((4 * (grupoSIMULACAO - 1)) + chave.get(timeb));

                            //PontuaçãoA x Pontuação adversarioB
                            Venceu = SimulaResultado(PtsEquipeLibertadores.get(i),PtsEquipeAdversario);
                            pontosA=0;pontosB=0;
                            if (Venceu==1){pontosA=pontosA+3;}
                            if (Venceu==0){pontosA++;pontosB++;}
                            if (Venceu==-1){pontosB=pontosB+3;}
                            SimulaGols(Venceu);
                            //globalVariable.DefinirGolsLibertadores(golsMarcados,golsSofridos,pontosA, i);
                            //globalVariable.DefinirGolsLibertadores(golsSofridos,golsMarcados,pontosB, (4 * (grupoSIMULACAO - 1))+chave.get(timeb));
                            tabela((4 * (grupoSIMULACAO - 1))+timea,1,rootView);
                            tabela((4 * (grupoSIMULACAO - 1))+timeb,2,rootView);
                        }}}
            }
        }

        //FINAL
        botaoMenu = rootView.findViewById(R.id.botaoMenu);
        botaoMenu.setVisibility(View.GONE);
        fundochampions = rootView.findViewById(R.id.fundoChampions);
        fundochampions.setImageResource(R.drawable.fundolibertadores);
        textoTitulo=rootView.findViewById(R.id.textoTitulo);
        textoTitulo.setText("Libertadores");

        return rootView;
    }

    public void PrintarTime(Integer id,Integer GMouGS){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        if(GMouGS==1){
            globalVariable.imageLogo(timesLibertadores.get((4 * (grupoSIMULACAO - 1))+chave.get(timea)),imagemTime);
            textoNomeTime.setText(timesLibertadores.get((4 * (grupoSIMULACAO - 1))+chave.get(timea)));
            textoGolsMarcados.setText("");}
        if(GMouGS==2){
            globalVariable.imageLogo(timesLibertadores.get((4 * (grupoSIMULACAO - 1))+chave.get(timeb)),imagemTime);
            textoNomeTime.setText(timesLibertadores.get((4 * (grupoSIMULACAO - 1))+chave.get(timeb)));
            textoGolsMarcados.setText("");}
    }

    public void tabela(Integer id,Integer GMouGS, View rootView){
         /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // TABELA //
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //GRUPO A
        if(id==1){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1A);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1A);
            imagemTime = rootView.findViewById(R.id.logo1A);
        }
        if(id==2){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2A);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2A);
            imagemTime = rootView.findViewById(R.id.logo2A);
        }
        if(id==3){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3A);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3A);
            imagemTime = rootView.findViewById(R.id.logo3A);
        }
        if(id==4){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4A);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4A);
            imagemTime = rootView.findViewById(R.id.logo4A);
        }
        //GRUPO B
        if(id==5){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1B);
            imagemTime = rootView.findViewById(R.id.logo1B);
        }
        if(id==6){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2B);
            imagemTime = rootView.findViewById(R.id.logo2B);
        }
        if(id==7){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3B);
            imagemTime = rootView.findViewById(R.id.logo3B);
        }
        if(id==8){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4B);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4B);
            imagemTime = rootView.findViewById(R.id.logo4B);
        }
        //GRUPO C
        if(id==9){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1C);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1C);
            imagemTime = rootView.findViewById(R.id.logo1C);
        }
        if(id==10){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2C);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2C);
            imagemTime = rootView.findViewById(R.id.logo2C);
        }
        if(id==11){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3C);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3C);
            imagemTime = rootView.findViewById(R.id.logo3C);
        }
        if(id==12){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4C);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4C);
            imagemTime = rootView.findViewById(R.id.logo4C);
        }
        //GRUPO D
        if(id==13){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1D);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1D);
            imagemTime = rootView.findViewById(R.id.logo1D);
        }
        if(id==14){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2D);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2D);
            imagemTime = rootView.findViewById(R.id.logo2D);}

        if(id==15){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3D);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3D);
            imagemTime = rootView.findViewById(R.id.logo3D);
        }
        if(id==16){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4D);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4D);
            imagemTime = rootView.findViewById(R.id.logo4D);
        }
        //GRUPO E
        if(id==17){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1E);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1E);
            imagemTime = rootView.findViewById(R.id.logo1E);
        }
        if(id==18){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2E);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2E);
            imagemTime = rootView.findViewById(R.id.logo2E);
        }
        if(id==19){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3E);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3E);
            imagemTime = rootView.findViewById(R.id.logo3E);
        }
        if(id==20){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4E);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4E);
            imagemTime = rootView.findViewById(R.id.logo4E);
        }
        //GRUPO F
        if(id==21){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1F);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1F);
            imagemTime = rootView.findViewById(R.id.logo1F);
        }
        if(id==22){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2F);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2F);
            imagemTime = rootView.findViewById(R.id.logo2F);
        }
        if(id==23){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3F);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3F);
            imagemTime = rootView.findViewById(R.id.logo3F);
        }
        if(id==24){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4F);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4F);
            imagemTime = rootView.findViewById(R.id.logo4F);
        }
        //GRUPO G
        if(id==25){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1G);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1G);
            imagemTime = rootView.findViewById(R.id.logo1G);
        }
        if(id==26){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2G);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2G);
            imagemTime = rootView.findViewById(R.id.logo2G);
        }
        if(id==27){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3G);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3G);
            imagemTime = rootView.findViewById(R.id.logo3G);
        }
        if(id==28){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4G);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4G);
            imagemTime = rootView.findViewById(R.id.logo4G);
        }
        //GRUPO H
        if(id==29){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime1H);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols1H);
            imagemTime = rootView.findViewById(R.id.logo1H);
        }
        if(id==30){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime2H);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols2H);
            imagemTime = rootView.findViewById(R.id.logo2H);}

        if(id==31){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime3H);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols3H);
            imagemTime = rootView.findViewById(R.id.logo3H);
        }
        if(id==32){
            textoNomeTime =  rootView.findViewById(R.id.nomeTime4H);
            textoGolsMarcados = rootView.findViewById(R.id.textoGols4H);
            imagemTime = rootView.findViewById(R.id.logo4H);
        }
        if(id<=32){
            PrintarTime(id,GMouGS);}

        /*////////////////////////////////////////////////////////////////////////////////////////////////////////////
                //TABELA
         *//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public Integer SimulaResultado(Integer PtsEquipe, Integer PtsEquipeAdversario){
        //SIMULAÇÃO RESULTADO
        if(PtsEquipe-PtsEquipeAdversario>=6)                                    {vitoria=80;empate=15;}
        if(PtsEquipe-PtsEquipeAdversario<6 && PtsEquipe-PtsEquipeAdversario>=4){vitoria=60;empate=25;}
        if(PtsEquipe-PtsEquipeAdversario<4 && PtsEquipe-PtsEquipeAdversario>=2){vitoria=45;empate=30;}
        if(PtsEquipe-PtsEquipeAdversario<=1 && PtsEquipe-PtsEquipeAdversario>=-1) {vitoria=30;empate=35;}
        if(PtsEquipe-PtsEquipeAdversario<=-2 && PtsEquipe-PtsEquipeAdversario>-4){vitoria=25;empate=30;}
        if(PtsEquipe-PtsEquipeAdversario<=-4 && PtsEquipe-PtsEquipeAdversario>-6){vitoria=15;empate=25;}
        if(PtsEquipe-PtsEquipeAdversario<=-6)                                     {vitoria=5;empate=15;}

        resultado = new Random().nextInt(100)+1;
        if(resultado<vitoria){Venceu=1;}
        if(resultado>vitoria && resultado<(vitoria+empate)){Venceu=0;}
        if(resultado>=(vitoria+empate)){Venceu=-1;}
        return Venceu;
    }
    public void SimulaGols(Integer Venceu){
        golsMarcados = new Random().nextInt(3);
        golsSofridos = new Random().nextInt(3);
        if(Venceu==1){while(golsMarcados<=golsSofridos){golsMarcados = new Random().nextInt(5);}}
        if(Venceu==0){golsMarcados=golsSofridos;}
        if(Venceu==-1){while(golsMarcados>=golsSofridos){golsSofridos = new Random().nextInt(4)+1; golsMarcados = new Random().nextInt(3);}}
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