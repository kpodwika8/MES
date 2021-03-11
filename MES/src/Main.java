import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Global g = new Global();
        double DeltaX = (g.W) / (g.nW - 1);
        double DeltaY = (g.H) / (g.nH - 1);

        List<Node> wez = new ArrayList<>();
        List<Element> elem = new ArrayList<>();


        //uzupełnienie wezlow
        for (int i = 0; i < g.nW; i++) {
            for (int j = 0; j < g.nH; j++) {
                double x = i * DeltaX;
                double y = j * DeltaY;
                wez.add(new Node(x, y));
//                if (x==0 || y == 0 || x== g.nW || y == g.nH)
//                {
//                    //wez.get(wez.size()).BC=1;
//                }
            }
        }

        //uzupelnienie elementow
        for (int i = 1; i < g.NE + (g.nW - 1); i++) {
            if (i % g.nH == 0) {
                continue;
            }
            Element temp = new Element();
            temp.ID[0] = i;
            temp.ID[1] = temp.ID[0] + g.nH;
            temp.ID[2] = temp.ID[1] + 1;
            temp.ID[3] = temp.ID[0] + 1;
            elem.add(temp);
        }

        //wypisanie elementow
//        for (int i = 0; i < g.NE; i++) {
//            System.out.println((i + 1) + " element: ");
//            System.out.println("wezly:");
//            for (int j = 0; j < 4; j++) {
//                System.out.print(elem.get(i).ID[j] + ": ");
//                System.out.println("x= " + wez.get(elem.get(i).ID[j] - 1).x + "\t y= " + wez.get(elem.get(i).ID[j] - 1).y + "\tBC =" + wez.get(elem.get(i).ID[j] - 1).BC);
//            }
//        }

        double[][] temp;
        double[][] temp2;
        double[][] temp3;
        double[] temp4;
        double[] PKONCOWA = new double[g.NN];
        double[][] HKONCOWA = new double[g.NN][g.NN];
        double[][] CKONCOWA = new double[g.NN][g.NN];
        Soe soe = new Soe();
        Elem4 l = new Elem4(g.punkty);


        int ilosc_krokow = g.czassymulacji / g.tau;

        int e;

        for (int d = 0; d < ilosc_krokow; d++) {

            //zerowanie tablic

            for (int i = 0; i < g.NN; i++) {
                for (int j = 0; j < g.NN; j++) {
                    soe.PG[i] = 0;
                    soe.HG[i][j] = 0;
                    soe.CG[i][j] = 0;
                    PKONCOWA[i] = 0;
                    CKONCOWA[i][j] = 0;
                    HKONCOWA[i][j] = 0;
                }
            }

            for (e = 0; e < g.NE; e++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        elem.get(e).Hlok[i][j] = 0;
                        elem.get(e).HBC[i][j] = 0;
                        elem.get(e).Clok[i][j] = 0;
                        elem.get(e).P[i] = 0;
                    }
                }
            }

            //HLokalna
            for (e = 0; e < g.NE; e++) {
//                System.out.println();
//                System.out.println((e + 1) + " element ");
                for (int i = 0; i < (g.punkty * g.punkty); i++) {
                    temp = l.funkcja5(e, i, wez, elem, g.punkty);
                    for (int k = 0; k < 4; k++) {
                        for (int j = 0; j < 4; j++) {
                            elem.get(e).Hlok[k][j] += temp[k][j];
                        }
                    }

                }
            }

            //HBC
            for (e = 0; e < g.NE; e++) {
                //System.out.println("element: " + (e + 1));
                for (int i = 0; i < g.punkty; i++) {
                    temp3 = l.obliczanieHBC(i, e, wez, elem, g.alfa, g.punkty);

                    for (int k = 0; k < 4; k++) {
                        for (int j = 0; j < 4; j++) {
                            elem.get(e).HBC[k][j] += temp3[k][j];
                        }
                    }
                }

            }

            for (e = 0; e < g.NE; e++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        elem.get(e).Hlok[i][j] += elem.get(e).HBC[i][j];
                    }
                }
            }

            //C
            for (e = 0; e < g.NE; e++) {
//              System.out.println();
//              System.out.println((e + 1) + " element ");
                for (int i = 0; i < (g.punkty * g.punkty); i++) {
                    temp2 = l.funkcja6(e, i, wez, elem, g.punkty, g.ro, g.Cp);
                    for (int k = 0; k < 4; k++) {
                        for (int j = 0; j < 4; j++) {
                            elem.get(e).Clok[k][j] += temp2[k][j];
                        }
                    }
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        CKONCOWA[elem.get(e).ID[i] - 1][elem.get(e).ID[j] - 1] += elem.get(e).Clok[i][j];
                    }
                }
            }

            //P
            for (e = 0; e < g.NE; e++) {
                for (int i = 0; i < (g.punkty ); i++) {
                    temp4 = l.obliczanieP(i, e, wez, elem, g.alfa, g.totoczenia, g.punkty);

                    for (int j = 0; j < 4; j++) {
                        elem.get(e).P[j] += temp4[j];
                    }
                }
                for (int i = 0; i < 4; i++) {
                    PKONCOWA[elem.get(e).ID[i] - 1] += elem.get(e).P[i];
                    //System.out.println(PKONCOWA[]);
                }
            }

            //System.out.println("-------------------");

            //System.out.println("PG: ");
//                for (int i = 0; i < g.NN; i++) {
//                    //System.out.print(PKONCOWA[i] + " ");
//
//                }
            //System.out.println();
            //System.out.println("-------------------");
            for (e = 0; e < g.NE; e++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        HKONCOWA[elem.get(e).ID[i] - 1][elem.get(e).ID[j] - 1] += elem.get(e).Hlok[i][j];
                    }
                }


            }

            //System.out.println("HG: ");
//            for (int i = 0; i < g.NN; i++) {
//                for (int j = 0; j < g.NN; j++) {
//                    //System.out.print(HKONCOWA[i][j] + " ");
//                }
//                //System.out.println();
//            }


            //System.out.println("---------------------");

            //System.out.println("-------------------");
//                //System.out.println("CG: ");
//                for (int i = 0; i < g.NN; i++) {
//                    for (int j = 0; j < g.NN; j++) {
//                        //System.out.print(CKONCOWA[i][j] + " ");
//                    }
//                    //System.out.println();
//                }

            //DODAWANIE PIERWSZY NAWIAS
            //HNOWA[][]

            for (int i = 0; i < g.NN; i++) {
                for (int j = 0; j < g.NN; j++) {
                    HKONCOWA[i][j] += (CKONCOWA[i][j]) / (g.tau);
                }
            }

            //System.out.println("PIERWSZY NAWIAS: ");
//            for (int i = 0; i < g.NN; i++) {
//                for (int j = 0; j < g.NN; j++) {
//                    //System.out.print(HKONCOWA[i][j] + " ");
//                }
//                //System.out.println();
//            }


            //DRUGI NAWIAS
            //System.out.println();
//            for (int i = 0; i < g.NN; i++) {
//                for (int j = 0; j < g.NN; j++) {
//                    //CKONCOWA[i][j] = -(CKONCOWA[i][j]) / (50) ;
//                }
//            }

            for (int i = 0; i < g.NN; i++) {
                for (int j = 0; j < g.NN; j++) {
                    PKONCOWA[i] = PKONCOWA[i] - (CKONCOWA[i][j]) / (g.tau) * wez.get(j).t0;
                }
            }

            for (int i = 0; i < g.NN; i++) {
                PKONCOWA[i] = -1 *PKONCOWA[i];
            }

            //System.out.println("DRUGI NAWIAS: ");
            for (int i = 0; i < g.NN; i++) {
            //System.out.print(PKONCOWA[i] + " ");

            }
//                System.out.println();
//                System.out.println();
//                System.out.println();

             //przepisanie do soe

            for (int i = 0; i < g.NN; i++) {
                for (int j = 0; j < g.NN; j++) {
                    soe.HG[i][j] = HKONCOWA[i][j];
                    //System.out.print(soe.HG[i][j] + " ");
                }
                //System.out.println();
            }

//                System.out.println();
//                System.out.println();

            for (int i = 0; i < g.NN; i++) {
                for (int j = 0; j < g.NN; j++) {
                    soe.CG[i][j] = CKONCOWA[i][j];
                    //System.out.print(soe.CG[i][j] + " ");
                }
//                    System.out.println();
            }

//                System.out.println();
//                System.out.println();
//                System.out.println();

            for (int i = 0; i < g.NN; i++) {
                soe.PG[i] = PKONCOWA[i];
                //System.out.print(PKONCOWA[i] + " ");
            }
                //System.out.println();
                //System.out.println();

            //eliminacja gaussa

            double[] TEMPERATURA = soe.EliminacjaGaussa(soe.HG, soe.PG);

            for (int i = 0; i < g.NN; i++) {
                wez.get(i).t0 = TEMPERATURA[i];
            }
            double min = TEMPERATURA[0], max = TEMPERATURA[0];
            for (int i = 0; i < g.NN; i++) {
                if (min > TEMPERATURA[i]) {
                    min = TEMPERATURA[i];
                }
            }
            for (int i = 0; i < g.NN; i++) {
                if (max < TEMPERATURA[i]) {
                    max = TEMPERATURA[i];
                }
            }
            System.out.println("Min temperatura: " + min + "\t"+ " Max temperatura: " + max);
            //System.out.println(min + "\t" + max);
        }
    }
}



