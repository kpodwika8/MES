import java.util.List;

public class Elem4 {
    //public double [] tabE;//= {-0.577, 0.577, 0.577, -0.577};
    //public double [] tabN;  //={-0.577, -0.577, 0.577, 0.577};

    public double[][] pkt_calkE;
    public double[][] pkt_calkN;
    public double[][] NNNNNNN;

    public double wagapozioma[];
    public double wagapionowa[];
    public double tabmac[];
    public double tabmac2[];
    public double tabmac3[];
    public double tabmac4[];

    public double Nbok1[][];
    public double Nbok2[][];
    public double Nbok3[][];
    public double Nbok4[][];

    double waga_boki[];

    //konstruktor
    Elem4(int p) {
        if (p == 2) {
            //double[] tabE = {-0.577, 0.577, 0.577, -0.577};
            double[] tabE = {-(1/Math.sqrt(3)), (1/Math.sqrt(3)),(1/Math.sqrt(3)), -(1/Math.sqrt(3))};
            //double[] tabN = {-0.577, -0.577, 0.577, 0.577};
            double[] tabN = {-(1/Math.sqrt(3)), -(1/Math.sqrt(3)), (1/Math.sqrt(3)), (1/Math.sqrt(3))};

            double E_bok1[] = {-(1/Math.sqrt(3)), 1/Math.sqrt(3) };
            double N_bok1[] = {-1, -1 };
            double E_bok2[] = {1, 1};
            double N_bok2[] = {-(1/Math.sqrt(3)), 1/Math.sqrt(3) };
            double E_bok3[] = {-(1/Math.sqrt(3)), (1/Math.sqrt(3)) };
            double N_bok3[] = {1,1};
            double E_bok4[] = {-1, -1};
            double N_bok4[] = {(1/Math.sqrt(3)), -(1/Math.sqrt(3)) };

            waga_boki = new double[]{1,1};

            pkt_calkE = new double[][]
                    {
                            {-0.25 * (1 - tabN[0]), 0.25 * (1 - tabN[0]), 0.25 * (1 + tabN[0]), -0.25 * (1 + tabN[0])},
                            {-0.25 * (1 - tabN[1]), 0.25 * (1 - tabN[1]), 0.25 * (1 + tabN[1]), -0.25 * (1 + tabN[1])},
                            {-0.25 * (1 - tabN[2]), 0.25 * (1 - tabN[2]), 0.25 * (1 + tabN[2]), -0.25 * (1 + tabN[2])},
                            {-0.25 * (1 - tabN[3]), 0.25 * (1 - tabN[3]), 0.25 * (1 + tabN[3]), -0.25 * (1 + tabN[3])}
                    };

            pkt_calkN = new double[][]
                    {
                            {-0.25 * (1 - tabE[0]), -0.25 * (1 + tabE[0]), 0.25 * (1 + tabE[0]), 0.25 * (1 - tabE[0])},
                            {-0.25 * (1 - tabE[1]), -0.25 * (1 + tabE[1]), 0.25 * (1 + tabE[1]), 0.25 * (1 - tabE[1])},
                            {-0.25 * (1 - tabE[2]), -0.25 * (1 + tabE[2]), 0.25 * (1 + tabE[2]), 0.25 * (1 - tabE[2])},
                            {-0.25 * (1 - tabE[3]), -0.25 * (1 + tabE[3]), 0.25 * (1 + tabE[3]), 0.25 * (1 - tabE[3])}
                    };
            NNNNNNN = new double[][]
                    {
                            {0.25 * (1 - tabN[0]) * (1 - tabE[0]), 0.25 * (1 - tabN[0]) * (1 + tabE[0]), 0.25 * (1 + tabN[0]) * (1 + tabE[0]), 0.25 * (1 + tabN[0]) * (1 - tabE[0])},
                            {0.25 * (1 - tabN[1]) * (1 - tabE[1]), 0.25 * (1 - tabN[1]) * (1 + tabE[1]), 0.25 * (1 + tabN[1]) * (1 + tabE[1]), 0.25 * (1 + tabN[1]) * (1 - tabE[1])},
                            {0.25 * (1 - tabN[2]) * (1 - tabE[2]), 0.25 * (1 - tabN[2]) * (1 + tabE[2]), 0.25 * (1 + tabN[2]) * (1 + tabE[2]), 0.25 * (1 + tabN[2]) * (1 - tabE[2])},
                            {0.25 * (1 - tabN[3]) * (1 - tabE[3]), 0.25 * (1 - tabN[3]) * (1 + tabE[3]), 0.25 * (1 + tabN[3]) * (1 + tabE[3]), 0.25 * (1 + tabN[3]) * (1 - tabE[3])}
                    };

            Nbok1 = new double[2][4];
            Nbok2 = new double[2][4];
            Nbok3 = new double[2][4];
            Nbok4 = new double[2][4];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok1[i][j] = 0.5 * (1-E_bok1[i]);
                    if (j == 1) Nbok1[i][j] = 0.5 * (1+E_bok1[i]);
                    if (j == 2) Nbok1[i][j] = 0;
                    if (j == 3) Nbok1[i][j] = 0;
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok2[i][j] = 0;
                    if (j == 1) Nbok2[i][j] = 0.5 * (1-N_bok2[i]);
                    if (j == 2) Nbok2[i][j] = 0.5 * (1+N_bok2[i]);
                    if (j == 3) Nbok2[i][j] = 0;
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok3[i][j] = 0;
                    if (j == 1) Nbok3[i][j] = 0;
                    if (j == 2) Nbok3[i][j] = 0.5 * (1-E_bok3[i]);
                    if (j == 3) Nbok3[i][j] = 0.5 * (1+E_bok3[i]);
                }
            }

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok4[i][j] = 0.5 * (1 - N_bok4[i]);
                    if (j == 1) Nbok4[i][j] = 0;
                    if (j == 2) Nbok4[i][j] = 0;
                    if (j == 3) Nbok4[i][j] = 0.5 * (1 + N_bok4[i]);
                }
            }
            wagapozioma = new double[]{1, 1, 1, 1};
            wagapionowa = new double[]{1, 1, 1, 1};

            tabmac = new double[]{0, 0, 0, 0};
            tabmac2 = new double[]{0, 0, 0, 0};
            tabmac3 = new double[]{0, 0, 0, 0};
            tabmac4 = new double[]{0, 0, 0, 0};

            //tabdoCp= new double[]{0,0,0,0};

        } else if (p == 3) {
            double tabE[] = {-1*Math.sqrt(3.0/5.0), 0, Math.sqrt(3.0/5.0), -1*Math.sqrt(3.0/5.0), 0, Math.sqrt(3.0/5.0), -1*Math.sqrt(3.0/5.0), 0, Math.sqrt(3.0/5.0)};
            double tabN[] = {-1*Math.sqrt(3.0/5.0), -1*Math.sqrt(3.0/5.0), -1*Math.sqrt(3.0/5.0), 0,0,0, Math.sqrt(3.0/5.0), Math.sqrt(3.0/5.0), Math.sqrt(3.0/5.0)};

            double E_bok1[] = {-Math.sqrt(3.0/5.0), 0,  Math.sqrt(3.0/5.0) };
            double N_bok1[] = {-1, -1, -1 };
            double E_bok2[] = {1, 1, 1};
            double N_bok2[] = {-Math.sqrt(3.0/5.0), 0,Math.sqrt(3.0/5.0) };
            double E_bok3[] = {Math.sqrt(3.0/5.0), 0 , -Math.sqrt(3.0/5.0) };
            double N_bok3[] = {1,1, 1};
            double E_bok4[] = {-1, -1, -1};
            double N_bok4[] = {Math.sqrt(3.0/5.0),0, -Math.sqrt(3.0/5.0) };

            waga_boki = new double[]{5.0/9.0, 8.0/9.0, 5.0/9.0};

            pkt_calkE = new double[][]
                    {
                            {-0.25 * (1 - tabN[0]), 0.25 * (1 - tabN[0]), 0.25 * (1 + tabN[0]), -0.25 * (1 + tabN[0])},
                            {-0.25 * (1 - tabN[1]), 0.25 * (1 - tabN[1]), 0.25 * (1 + tabN[1]), -0.25 * (1 + tabN[1])},
                            {-0.25 * (1 - tabN[2]), 0.25 * (1 - tabN[2]), 0.25 * (1 + tabN[2]), -0.25 * (1 + tabN[2])},
                            {-0.25 * (1 - tabN[3]), 0.25 * (1 - tabN[3]), 0.25 * (1 + tabN[3]), -0.25 * (1 + tabN[3])},
                            {-0.25 * (1 - tabN[4]), 0.25 * (1 - tabN[4]), 0.25 * (1 + tabN[4]), -0.25 * (1 + tabN[4])},
                            {-0.25 * (1 - tabN[5]), 0.25 * (1 - tabN[5]), 0.25 * (1 + tabN[5]), -0.25 * (1 + tabN[5])},
                            {-0.25 * (1 - tabN[6]), 0.25 * (1 - tabN[6]), 0.25 * (1 + tabN[6]), -0.25 * (1 + tabN[6])},
                            {-0.25 * (1 - tabN[7]), 0.25 * (1 - tabN[7]), 0.25 * (1 + tabN[7]), -0.25 * (1 + tabN[7])},
                            {-0.25 * (1 - tabN[8]), 0.25 * (1 - tabN[8]), 0.25 * (1 + tabN[8]), -0.25 * (1 + tabN[8])}
                    };

            pkt_calkN = new double[][]
                    {
                            {-0.25 * (1 - tabE[0]), -0.25 * (1 + tabE[0]), 0.25 * (1 + tabE[0]), 0.25 * (1 - tabE[0])},
                            {-0.25 * (1 - tabE[1]), -0.25 * (1 + tabE[1]), 0.25 * (1 + tabE[1]), 0.25 * (1 - tabE[1])},
                            {-0.25 * (1 - tabE[2]), -0.25 * (1 + tabE[2]), 0.25 * (1 + tabE[2]), 0.25 * (1 - tabE[2])},
                            {-0.25 * (1 - tabE[3]), -0.25 * (1 + tabE[3]), 0.25 * (1 + tabE[3]), 0.25 * (1 - tabE[3])},
                            {-0.25 * (1 - tabE[4]), -0.25 * (1 + tabE[4]), 0.25 * (1 + tabE[4]), 0.25 * (1 - tabE[4])},
                            {-0.25 * (1 - tabE[5]), -0.25 * (1 + tabE[5]), 0.25 * (1 + tabE[5]), 0.25 * (1 - tabE[5])},
                            {-0.25 * (1 - tabE[6]), -0.25 * (1 + tabE[6]), 0.25 * (1 + tabE[6]), 0.25 * (1 - tabE[6])},
                            {-0.25 * (1 - tabE[7]), -0.25 * (1 + tabE[7]), 0.25 * (1 + tabE[7]), 0.25 * (1 - tabE[7])},
                            {-0.25 * (1 - tabE[8]), -0.25 * (1 + tabE[8]), 0.25 * (1 + tabE[8]), 0.25 * (1 - tabE[8])}
                    };
            NNNNNNN = new double[][]
                    {
                            {0.25 * (1 - tabN[0]) * (1 - tabE[0]), 0.25 * (1 - tabN[0]) * (1 + tabE[0]), 0.25 * (1 + tabN[0]) * (1 + tabE[0]), 0.25 * (1 + tabN[0]) * (1 - tabE[0])},
                            {0.25 * (1 - tabN[1]) * (1 - tabE[1]), 0.25 * (1 - tabN[1]) * (1 + tabE[1]), 0.25 * (1 + tabN[1]) * (1 + tabE[1]), 0.25 * (1 + tabN[1]) * (1 - tabE[1])},
                            {0.25 * (1 - tabN[2]) * (1 - tabE[2]), 0.25 * (1 - tabN[2]) * (1 + tabE[2]), 0.25 * (1 + tabN[2]) * (1 + tabE[2]), 0.25 * (1 + tabN[2]) * (1 - tabE[2])},
                            {0.25 * (1 - tabN[3]) * (1 - tabE[3]), 0.25 * (1 - tabN[3]) * (1 + tabE[3]), 0.25 * (1 + tabN[3]) * (1 + tabE[3]), 0.25 * (1 + tabN[3]) * (1 - tabE[3])},
                            {0.25 * (1 - tabN[4]) * (1 - tabE[4]), 0.25 * (1 - tabN[4]) * (1 + tabE[4]), 0.25 * (1 + tabN[4]) * (1 + tabE[4]), 0.25 * (1 + tabN[4]) * (1 - tabE[4])},
                            {0.25 * (1 - tabN[5]) * (1 - tabE[5]), 0.25 * (1 - tabN[5]) * (1 + tabE[5]), 0.25 * (1 + tabN[5]) * (1 + tabE[5]), 0.25 * (1 + tabN[5]) * (1 - tabE[5])},
                            {0.25 * (1 - tabN[6]) * (1 - tabE[6]), 0.25 * (1 - tabN[6]) * (1 + tabE[6]), 0.25 * (1 + tabN[6]) * (1 + tabE[6]), 0.25 * (1 + tabN[6]) * (1 - tabE[6])},
                            {0.25 * (1 - tabN[7]) * (1 - tabE[7]), 0.25 * (1 - tabN[7]) * (1 + tabE[7]), 0.25 * (1 + tabN[7]) * (1 + tabE[7]), 0.25 * (1 + tabN[7]) * (1 - tabE[7])},
                            {0.25 * (1 - tabN[8]) * (1 - tabE[8]), 0.25 * (1 - tabN[8]) * (1 + tabE[8]), 0.25 * (1 + tabN[8]) * (1 + tabE[8]), 0.25 * (1 + tabN[8]) * (1 - tabE[8])}
                    };

            Nbok1 = new double[3][4];
            Nbok2 = new double[3][4];
            Nbok3 = new double[3][4];
            Nbok4 = new double[3][4];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok1[i][j] = 0.5 * (1-E_bok1[i]);
                    if (j == 1) Nbok1[i][j] = 0.5 * (1+E_bok1[i]);
                    if (j == 2) Nbok1[i][j] = 0;
                    if (j == 3) Nbok1[i][j] = 0;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok2[i][j] = 0;
                    if (j == 1) Nbok2[i][j] = 0.5 * (1-N_bok2[i]);
                    if (j == 2) Nbok2[i][j] = 0.5 * (1+N_bok2[i]);
                    if (j == 3) Nbok2[i][j] = 0;
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok3[i][j] = 0;
                    if (j == 1) Nbok3[i][j] = 0;
                    if (j == 2) Nbok3[i][j] = 0.5 * (1-E_bok3[i]);
                    if (j == 3) Nbok3[i][j] = 0.5 * (1+E_bok3[i]);
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok4[i][j] = 0.5 * (1 - N_bok4[i]);
                    if (j == 1) Nbok4[i][j] = 0;
                    if (j == 2) Nbok4[i][j] = 0;
                    if (j == 3) Nbok4[i][j] = 0.5 * (1 + N_bok4[i]);
                }
            }

            wagapozioma = new double[]{5.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0, 5.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0, 5.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0};
            wagapionowa = new double[]{5.0 / 9.0, 5.0 / 9.0, 5.0 / 9.0, 8.0 / 9.0, 8.0 / 9.0, 8.0 / 9.0, 5.0 / 9.0, 5.0 / 9.0, 5.0 / 9.0};


            tabmac = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            tabmac2 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            tabmac3 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
            tabmac4 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        }
        else if (p == 4)
        {
            double [] tabE = {
                    -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),
                    -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),
                    -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),
                    -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)))
            };

            double [] tabN = {
                    -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),-1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),-1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),-1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),
                    -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),-1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),-1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),-1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),
                    Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))),
                    Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))),Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)))
            };

            double E_bok1[] = {-1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)))};
            double E_bok2[] = {1, 1, 1, 1};
            double E_bok3[] = {Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))) };
            double E_bok4[] = {-1, -1, -1, -1};
            double N_bok1[] = {-1, -1, -1, -1 };
            double N_bok2[] = {-1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0)))};
            double N_bok3[] = {1,1, 1, 1};
            double N_bok4[] = {Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))), Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)-((2.0/7.0)*Math.sqrt(6.0/5.0))), -1*Math.sqrt((3.0/7.0)+((2.0/7.0)*Math.sqrt(6.0/5.0))) };

            waga_boki = new double[]{(18-Math.sqrt(30))/36,(18+ Math.sqrt(30))/36 , (18+ Math.sqrt(30))/36, (18-Math.sqrt(30))/36};

            pkt_calkE = new double[][]
                    {
                            {-0.25 * (1 - tabN[0]), 0.25 * (1 - tabN[0]), 0.25 * (1 + tabN[0]), -0.25 * (1 + tabN[0])},
                            {-0.25 * (1 - tabN[1]), 0.25 * (1 - tabN[1]), 0.25 * (1 + tabN[1]), -0.25 * (1 + tabN[1])},
                            {-0.25 * (1 - tabN[2]), 0.25 * (1 - tabN[2]), 0.25 * (1 + tabN[2]), -0.25 * (1 + tabN[2])},
                            {-0.25 * (1 - tabN[3]), 0.25 * (1 - tabN[3]), 0.25 * (1 + tabN[3]), -0.25 * (1 + tabN[3])},
                            {-0.25 * (1 - tabN[4]), 0.25 * (1 - tabN[4]), 0.25 * (1 + tabN[4]), -0.25 * (1 + tabN[4])},
                            {-0.25 * (1 - tabN[5]), 0.25 * (1 - tabN[5]), 0.25 * (1 + tabN[5]), -0.25 * (1 + tabN[5])},
                            {-0.25 * (1 - tabN[6]), 0.25 * (1 - tabN[6]), 0.25 * (1 + tabN[6]), -0.25 * (1 + tabN[6])},
                            {-0.25 * (1 - tabN[7]), 0.25 * (1 - tabN[7]), 0.25 * (1 + tabN[7]), -0.25 * (1 + tabN[7])},
                            {-0.25 * (1 - tabN[8]), 0.25 * (1 - tabN[8]), 0.25 * (1 + tabN[8]), -0.25 * (1 + tabN[8])},
                            {-0.25 * (1 - tabN[9]), 0.25 * (1 - tabN[9]), 0.25 * (1 + tabN[9]), -0.25 * (1 + tabN[9])},
                            {-0.25 * (1 - tabN[10]), 0.25 * (1 - tabN[10]), 0.25 * (1 + tabN[10]), -0.25 * (1 + tabN[10])},
                            {-0.25 * (1 - tabN[11]), 0.25 * (1 - tabN[11]), 0.25 * (1 + tabN[11]), -0.25 * (1 + tabN[11])},
                            {-0.25 * (1 - tabN[12]), 0.25 * (1 - tabN[12]), 0.25 * (1 + tabN[12]), -0.25 * (1 + tabN[12])},
                            {-0.25 * (1 - tabN[13]), 0.25 * (1 - tabN[13]), 0.25 * (1 + tabN[13]), -0.25 * (1 + tabN[13])},
                            {-0.25 * (1 - tabN[14]), 0.25 * (1 - tabN[14]), 0.25 * (1 + tabN[14]), -0.25 * (1 + tabN[14])},
                            {-0.25 * (1 - tabN[15]), 0.25 * (1 - tabN[15]), 0.25 * (1 + tabN[15]), -0.25 * (1 + tabN[15])}
                    };

            pkt_calkN = new double[][]
                    {
                            {-0.25 * (1 - tabE[0]), -0.25 * (1 + tabE[0]), 0.25 * (1 + tabE[0]), 0.25 * (1 - tabE[0])},
                            {-0.25 * (1 - tabE[1]), -0.25 * (1 + tabE[1]), 0.25 * (1 + tabE[1]), 0.25 * (1 - tabE[1])},
                            {-0.25 * (1 - tabE[2]), -0.25 * (1 + tabE[2]), 0.25 * (1 + tabE[2]), 0.25 * (1 - tabE[2])},
                            {-0.25 * (1 - tabE[3]), -0.25 * (1 + tabE[3]), 0.25 * (1 + tabE[3]), 0.25 * (1 - tabE[3])},
                            {-0.25 * (1 - tabE[4]), -0.25 * (1 + tabE[4]), 0.25 * (1 + tabE[4]), 0.25 * (1 - tabE[4])},
                            {-0.25 * (1 - tabE[5]), -0.25 * (1 + tabE[5]), 0.25 * (1 + tabE[5]), 0.25 * (1 - tabE[5])},
                            {-0.25 * (1 - tabE[6]), -0.25 * (1 + tabE[6]), 0.25 * (1 + tabE[6]), 0.25 * (1 - tabE[6])},
                            {-0.25 * (1 - tabE[7]), -0.25 * (1 + tabE[7]), 0.25 * (1 + tabE[7]), 0.25 * (1 - tabE[7])},
                            {-0.25 * (1 - tabE[8]), -0.25 * (1 + tabE[8]), 0.25 * (1 + tabE[8]), 0.25 * (1 - tabE[8])},
                            {-0.25 * (1 - tabE[9]), -0.25 * (1 + tabE[9]), 0.25 * (1 + tabE[9]), 0.25 * (1 - tabE[9])},
                            {-0.25 * (1 - tabE[10]), -0.25 * (1 + tabE[10]), 0.25 * (1 + tabE[10]), 0.25 * (1 - tabE[10])},
                            {-0.25 * (1 - tabE[11]), -0.25 * (1 + tabE[11]), 0.25 * (1 + tabE[11]), 0.25 * (1 - tabE[11])},
                            {-0.25 * (1 - tabE[12]), -0.25 * (1 + tabE[12]), 0.25 * (1 + tabE[12]), 0.25 * (1 - tabE[12])},
                            {-0.25 * (1 - tabE[13]), -0.25 * (1 + tabE[13]), 0.25 * (1 + tabE[13]), 0.25 * (1 - tabE[13])},
                            {-0.25 * (1 - tabE[14]), -0.25 * (1 + tabE[14]), 0.25 * (1 + tabE[14]), 0.25 * (1 - tabE[14])},
                            {-0.25 * (1 - tabE[15]), -0.25 * (1 + tabE[15]), 0.25 * (1 + tabE[15]), 0.25 * (1 - tabE[15])}
                    };
            NNNNNNN = new double[][]
                    {
                            {0.25 * (1 - tabN[0]) * (1 - tabE[0]), 0.25 * (1 - tabN[0]) * (1 + tabE[0]), 0.25 * (1 + tabN[0]) * (1 + tabE[0]), 0.25 * (1 + tabN[0]) * (1 - tabE[0])},
                            {0.25 * (1 - tabN[1]) * (1 - tabE[1]), 0.25 * (1 - tabN[1]) * (1 + tabE[1]), 0.25 * (1 + tabN[1]) * (1 + tabE[1]), 0.25 * (1 + tabN[1]) * (1 - tabE[1])},
                            {0.25 * (1 - tabN[2]) * (1 - tabE[2]), 0.25 * (1 - tabN[2]) * (1 + tabE[2]), 0.25 * (1 + tabN[2]) * (1 + tabE[2]), 0.25 * (1 + tabN[2]) * (1 - tabE[2])},
                            {0.25 * (1 - tabN[3]) * (1 - tabE[3]), 0.25 * (1 - tabN[3]) * (1 + tabE[3]), 0.25 * (1 + tabN[3]) * (1 + tabE[3]), 0.25 * (1 + tabN[3]) * (1 - tabE[3])},
                            {0.25 * (1 - tabN[4]) * (1 - tabE[4]), 0.25 * (1 - tabN[4]) * (1 + tabE[4]), 0.25 * (1 + tabN[4]) * (1 + tabE[4]), 0.25 * (1 + tabN[4]) * (1 - tabE[4])},
                            {0.25 * (1 - tabN[5]) * (1 - tabE[5]), 0.25 * (1 - tabN[5]) * (1 + tabE[5]), 0.25 * (1 + tabN[5]) * (1 + tabE[5]), 0.25 * (1 + tabN[5]) * (1 - tabE[5])},
                            {0.25 * (1 - tabN[6]) * (1 - tabE[6]), 0.25 * (1 - tabN[6]) * (1 + tabE[6]), 0.25 * (1 + tabN[6]) * (1 + tabE[6]), 0.25 * (1 + tabN[6]) * (1 - tabE[6])},
                            {0.25 * (1 - tabN[7]) * (1 - tabE[7]), 0.25 * (1 - tabN[7]) * (1 + tabE[7]), 0.25 * (1 + tabN[7]) * (1 + tabE[7]), 0.25 * (1 + tabN[7]) * (1 - tabE[7])},
                            {0.25 * (1 - tabN[8]) * (1 - tabE[8]), 0.25 * (1 - tabN[8]) * (1 + tabE[8]), 0.25 * (1 + tabN[8]) * (1 + tabE[8]), 0.25 * (1 + tabN[8]) * (1 - tabE[8])},
                            {0.25 * (1 - tabN[9]) * (1 - tabE[9]), 0.25 * (1 - tabN[9]) * (1 + tabE[9]), 0.25 * (1 + tabN[9]) * (1 + tabE[9]), 0.25 * (1 + tabN[9]) * (1 - tabE[9])},
                            {0.25 * (1 - tabN[10]) * (1 - tabE[10]), 0.25 * (1 - tabN[10]) * (1 + tabE[10]), 0.25 * (1 + tabN[10]) * (1 + tabE[10]), 0.25 * (1 + tabN[10]) * (1 - tabE[10])},
                            {0.25 * (1 - tabN[11]) * (1 - tabE[11]), 0.25 * (1 - tabN[11]) * (1 + tabE[11]), 0.25 * (1 + tabN[11]) * (1 + tabE[11]), 0.25 * (1 + tabN[11]) * (1 - tabE[11])},
                            {0.25 * (1 - tabN[12]) * (1 - tabE[12]), 0.25 * (1 - tabN[12]) * (1 + tabE[12]), 0.25 * (1 + tabN[12]) * (1 + tabE[12]), 0.25 * (1 + tabN[12]) * (1 - tabE[12])},
                            {0.25 * (1 - tabN[13]) * (1 - tabE[13]), 0.25 * (1 - tabN[13]) * (1 + tabE[13]), 0.25 * (1 + tabN[13]) * (1 + tabE[13]), 0.25 * (1 + tabN[13]) * (1 - tabE[13])},
                            {0.25 * (1 - tabN[14]) * (1 - tabE[14]), 0.25 * (1 - tabN[14]) * (1 + tabE[14]), 0.25 * (1 + tabN[14]) * (1 + tabE[14]), 0.25 * (1 + tabN[14]) * (1 - tabE[14])},
                            {0.25 * (1 - tabN[15]) * (1 - tabE[15]), 0.25 * (1 - tabN[15]) * (1 + tabE[15]), 0.25 * (1 + tabN[15]) * (1 + tabE[15]), 0.25 * (1 + tabN[15]) * (1 - tabE[15])}
                    };

            Nbok1 = new double[4][4];
            Nbok2 = new double[4][4];
            Nbok3 = new double[4][4];
            Nbok4 = new double[4][4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok1[i][j] = 0.5 * (1-E_bok1[i]);
                    if (j == 1) Nbok1[i][j] = 0.5 * (1+E_bok1[i]);
                    if (j == 2) Nbok1[i][j] = 0;
                    if (j == 3) Nbok1[i][j] = 0;
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok2[i][j] = 0;
                    if (j == 1) Nbok2[i][j] = 0.5 * (1-N_bok2[i]);
                    if (j == 2) Nbok2[i][j] = 0.5 * (1+N_bok2[i]);
                    if (j == 3) Nbok2[i][j] = 0;
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok3[i][j] = 0;
                    if (j == 1) Nbok3[i][j] = 0;
                    if (j == 2) Nbok3[i][j] = 0.5 * (1-E_bok3[i]);
                    if (j == 3) Nbok3[i][j] = 0.5 * (1+E_bok3[i]);
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0) Nbok4[i][j] = 0.5 * (1 - N_bok4[i]);
                    if (j == 1) Nbok4[i][j] = 0;
                    if (j == 2) Nbok4[i][j] = 0;
                    if (j == 3) Nbok4[i][j] = 0.5 * (1 + N_bok4[i]);
                }
            }


            wagapozioma = new double[]{(18.0-Math.sqrt(30.0))/36.0,(18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0,  (18.0-Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0,(18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0,(18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0};
            wagapionowa = new double[]{(18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0+Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0, (18.0-Math.sqrt(30.0))/36.0};


            tabmac = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            tabmac2 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            tabmac3 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            tabmac4 = new double[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        }

    }


    public double[][] funkcja5(int q, int e, List<Node> wezly, List<Element> elementy, int p) {
        Elem4 l = new Elem4(p);
        //double x[] = {0, 0, 0, 0};
        //double y[] = {0, 0, 0, 0};

        //jacobi
        //double tabmac [] ={0,0,0,0}; //dxksi
        //double tabmac2 []={0,0,0,0}; //dyksi
        //double tabmac3 []={0,0,0,0}; //dxeta
        //double tabmac4 []={0,0,0,0}; //dyeta
        l.tabmac[e] = wezly.get(elementy.get(q).ID[0] - 1).x * l.pkt_calkE[0][0] + wezly.get(elementy.get(q).ID[1] - 1).x * l.pkt_calkE[0][1] + wezly.get(elementy.get(q).ID[2] - 1).x * l.pkt_calkE[0][2] + wezly.get(elementy.get(q).ID[3] - 1).x * l.pkt_calkE[0][3];
        l.tabmac2[e] = wezly.get(elementy.get(q).ID[0] - 1).y * l.pkt_calkE[1][0] + wezly.get(elementy.get(q).ID[1] - 1).y * l.pkt_calkE[1][1] + wezly.get(elementy.get(q).ID[2] - 1).y * l.pkt_calkE[1][2] + wezly.get(elementy.get(q).ID[3] - 1).y * l.pkt_calkE[1][3];
        l.tabmac3[e] = wezly.get(elementy.get(q).ID[0] - 1).x * l.pkt_calkN[2][0] + wezly.get(elementy.get(q).ID[1] - 1).x * l.pkt_calkN[2][1] + wezly.get(elementy.get(q).ID[2] - 1).x * l.pkt_calkN[2][2] + wezly.get(elementy.get(q).ID[3] - 1).x * l.pkt_calkN[2][3];
        l.tabmac4[e] = wezly.get(elementy.get(q).ID[0] - 1).y * l.pkt_calkN[3][0] + wezly.get(elementy.get(q).ID[1] - 1).y * l.pkt_calkN[3][1] + wezly.get(elementy.get(q).ID[2] - 1).y * l.pkt_calkN[3][2] + wezly.get(elementy.get(q).ID[3] - 1).y * l.pkt_calkN[3][3];


        double Jacobi[][] = new double[2][2];
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                if (j == 0 && k == 0)
                    Jacobi[j][k] = l.tabmac[e];
                if (j == 0 && k == 1)
                    Jacobi[j][k] = l.tabmac2[e];
                if (j == 1 && k == 0)
                    Jacobi[j][k] = l.tabmac3[e];
                if (j == 1 && k == 1)
                    Jacobi[j][k] = l.tabmac4[e];
            }
        }


        //wyznacznik jacobi
        double wyznacznik = Jacobi[0][0] * Jacobi[1][1] - Jacobi[0][1] * Jacobi[1][0];

        //jacobi odwrotny
        double odwrotnyJacobi[][] = new double[2][2];
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                if (j == 0 && k == 0) odwrotnyJacobi[j][k] = (1 / wyznacznik) * (Jacobi[1][1]);
                if (j == 0 && k == 1) odwrotnyJacobi[j][k] = (1 / wyznacznik) * (-Jacobi[j][k]);
                if (j == 1 && k == 0) odwrotnyJacobi[j][k] = (1 / wyznacznik) * (-Jacobi[j][k]);
                if (j == 1 && k == 1) odwrotnyJacobi[j][k] = (1 / wyznacznik) * (Jacobi[0][0]);
            }
        }

        double tabNX[] = new double[4];
        double tabNY[] = new double[4];

        //System.out.println(i + " Punkt calkowania");
        for (int j = 0; j < 4; j++) {
            tabNX[j] = odwrotnyJacobi[0][0] * l.pkt_calkE[e][j] + odwrotnyJacobi[0][1] * l.pkt_calkN[e][j];
            //System.out.print(tabNX[i][j]+" ");
            tabNY[j] = odwrotnyJacobi[1][0] * l.pkt_calkE[e][j] + odwrotnyJacobi[1][1] * l.pkt_calkN[e][j];
            //System.out.print(tabNY[i][j]+" ");
        }
        //System.out.println();


        //System.out.println("dN/dX");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //System.out.print(tabNX[i][j] + " ");
            }
            //System.out.println();
        }
        //System.out.println();
        //System.out.println("dN/dY");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //System.out.print(tabNY[i][j] + " ");
            }
            //System.out.println();
        }
        //System.out.println();

        //
        double[][] tabXX = new double[4][4];
        double[][] tabYY = new double[4][4];

        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                tabXX[k][j] = tabNX[k] * tabNX[j];
                //System.out.print(tab11X[k][j] + " ");
            }
            //System.out.println();
        }
        //System.out.println("----------------------");
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                tabYY[k][j] = tabNY[k] * tabNY[j];
                //System.out.print(tab11Y[k][j] + " ");
            }
            //System.out.println();
        }
        //System.out.println("----------------------");
        //double wynikH[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        double wynikH[][] = new double[4][4];
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                wynikH[k][j] = (tabXX[j][k] + tabYY[j][k]) * 25 * wyznacznik * l.wagapionowa[e] * l.wagapozioma[e];
                //System.out.print(wynikH[k][j] + " ");
            }
            //System.out.println();
        }


        return wynikH;

    }

    public double[][] funkcja6(int q, int e, List<Node> wezly, List<Element> elementy, int p, double Cp, double ro) {
        Elem4 l = new Elem4(p);
        //double x[] = {0, 0, 0, 0};
        //double y[] = {0, 0, 0, 0};

        //jacobi
        //double tabmac [] ={0,0,0,0}; //dxksi
        //double tabmac2 []={0,0,0,0}; //dyksi
        //double tabmac3 []={0,0,0,0}; //dxeta
        //double tabmac4 []={0,0,0,0}; //dyeta
        l.tabmac[e] = wezly.get(elementy.get(q).ID[0] - 1).x * l.pkt_calkE[0][0] + wezly.get(elementy.get(q).ID[1] - 1).x * l.pkt_calkE[0][1] + wezly.get(elementy.get(q).ID[2] - 1).x * l.pkt_calkE[0][2] + wezly.get(elementy.get(q).ID[3] - 1).x * l.pkt_calkE[0][3];
        l.tabmac2[e] = wezly.get(elementy.get(q).ID[0] - 1).y * l.pkt_calkE[1][0] + wezly.get(elementy.get(q).ID[1] - 1).y * l.pkt_calkE[1][1] + wezly.get(elementy.get(q).ID[2] - 1).y * l.pkt_calkE[1][2] + wezly.get(elementy.get(q).ID[3] - 1).y * l.pkt_calkE[1][3];
        l.tabmac3[e] = wezly.get(elementy.get(q).ID[0] - 1).x * l.pkt_calkN[2][0] + wezly.get(elementy.get(q).ID[1] - 1).x * l.pkt_calkN[2][1] + wezly.get(elementy.get(q).ID[2] - 1).x * l.pkt_calkN[2][2] + wezly.get(elementy.get(q).ID[3] - 1).x * l.pkt_calkN[2][3];
        l.tabmac4[e] = wezly.get(elementy.get(q).ID[0] - 1).y * l.pkt_calkN[3][0] + wezly.get(elementy.get(q).ID[1] - 1).y * l.pkt_calkN[3][1] + wezly.get(elementy.get(q).ID[2] - 1).y * l.pkt_calkN[3][2] + wezly.get(elementy.get(q).ID[3] - 1).y * l.pkt_calkN[3][3];


        double Jacobi[][] = new double[2][2];
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 2; k++) {
                if (j == 0 && k == 0)
                    Jacobi[j][k] = l.tabmac[e];
                if (j == 0 && k == 1)
                    Jacobi[j][k] = l.tabmac2[e];
                if (j == 1 && k == 0)
                    Jacobi[j][k] = l.tabmac3[e];
                if (j == 1 && k == 1)
                    Jacobi[j][k] = l.tabmac4[e];
            }
        }


        //wyznacznik jacobi
        double wyznacznik = Jacobi[0][0] * Jacobi[1][1] - Jacobi[0][1] * Jacobi[1][0];

        //
        double[][] tabNXN = new double[4][4];

        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                tabNXN[k][j] = l.NNNNNNN[e][k] * l.NNNNNNN[e][j];
                //System.out.print(tab11X[k][j] + " ");
            }
            //System.out.println();
        }
        //System.out.println("----------------------");
        //double wynikH[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        double wynikC[][] = new double[4][4];
        for (int k = 0; k < 4; k++) {
            for (int j = 0; j < 4; j++) {
                wynikC[k][j] = (tabNXN[k][j]) * Cp*ro * wyznacznik * l.wagapionowa[e] * l.wagapozioma[e];
                //System.out.print(wynikH[k][j] + " ");
            }
            //System.out.println();
        }


        return wynikC;
    }

    public double [][] obliczanieHBC(int q, int e,List<Node> wezly, List<Element> elementy,double alfa, int pc ) {
        Elem4 l = new Elem4(pc);

        Node boki[][] = new Node[4][2];

        for (int j = 0; j < 4; j++) {
            if (wezly.get(elementy.get(e).ID[j] - 1).BC == 1 && wezly.get(elementy.get(e).ID[(j + 1) % 4] - 1).BC == 1) {
                boki[j][0] = wezly.get(elementy.get(e).ID[j] - 1);
                boki[j][1] = wezly.get(elementy.get(e).ID[(j + 1) % 4] - 1);
            }
        }

        double HBC[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};


        double boczek1[][] = new double[4][4];

        //1 bok
        if (boki[0][0] != null && boki[0][1] != null) {
            double temp1[][] = new double[4][4];
            temp1[0][0] += l.Nbok1[q][0] * l.Nbok1[q][0] * alfa * l.waga_boki[q];
            temp1[0][1] += l.Nbok1[q][0] * l.Nbok1[q][1] * alfa * l.waga_boki[q];
            temp1[1][0] += l.Nbok1[q][1] * l.Nbok1[q][0] * alfa * l.waga_boki[q];
            temp1[1][1] += l.Nbok1[q][1] * l.Nbok1[q][1] * alfa * l.waga_boki[q];

            double detJ = Math.sqrt(Math.pow(boki[0][1].x - boki[0][0].x, 2) + Math.pow(boki[0][1].y - boki[0][0].y, 2)) / 2;

            for (int k = 0; k < 4; k++) {
                for (int g = 0; g < 4; g++) {
                    boczek1[k][g] = temp1[k][g] * detJ;
                }
            }
        }

        double boczek2[][] = new double[4][4];

        //2 bok
        if (boki[1][0] != null && boki[1][1] != null) {
            double temp2[][] = new double[4][4];
            temp2[1][1] += l.Nbok2[q][1] * l.Nbok2[q][1] * alfa * l.waga_boki[q];
            temp2[1][2] += l.Nbok2[q][1] * l.Nbok2[q][2] * alfa * l.waga_boki[q];
            temp2[2][1] += l.Nbok2[q][2] * l.Nbok2[q][1] * alfa * l.waga_boki[q];
            temp2[2][2] += l.Nbok2[q][2] * l.Nbok2[q][2] * alfa * l.waga_boki[q];

            double detJ = Math.sqrt(Math.pow(boki[1][1].x - boki[1][0].x, 2) + Math.pow(boki[1][1].y - boki[1][0].y, 2)) / 2;


            for (int k = 0; k < 4; k++) {
                for (int g = 0; g < 4; g++) {
                    boczek2[k][g] = temp2[k][g] * detJ;
                }
            }

        }
        double boczek3[][] = new double[4][4];

        //3 bok
        if (boki[2][0] != null && boki[2][1] != null) {
            double temp3[][] = new double[4][4];
            temp3[2][2] += l.Nbok3[q][2] * l.Nbok3[q][2] * alfa * l.waga_boki[q];
            temp3[2][3] += l.Nbok3[q][2] * l.Nbok3[q][3] * alfa * l.waga_boki[q];
            temp3[3][2] += l.Nbok3[q][3] * l.Nbok3[q][2] * alfa * l.waga_boki[q];
            temp3[3][3] += l.Nbok3[q][3] * l.Nbok3[q][3] * alfa * l.waga_boki[q];

            double detJ = Math.sqrt(Math.pow(boki[2][1].x - boki[2][0].x, 2) + Math.pow(boki[2][1].y - boki[2][0].y, 2)) / 2;


            for (int k = 0; k < 4; k++) {
                for (int g = 0; g < 4; g++) {
                    boczek3[k][g] = temp3[k][g] * detJ;
                }
            }

        }
        //4 bok
        double boczek4[][] = new double[4][4];
        if (boki[3][0] != null && boki[3][1] != null) {
            double temp4[][] = new double[4][4];
            temp4[0][0] += l.Nbok4[q][0] * l.Nbok4[q][0] * alfa * l.waga_boki[q];
            temp4[0][3] += l.Nbok4[q][0] * l.Nbok4[q][3] * alfa * l.waga_boki[q];
            temp4[3][0] += l.Nbok4[q][3] * l.Nbok4[q][0] * alfa * l.waga_boki[q];
            temp4[3][3] += l.Nbok4[q][3] * l.Nbok4[q][3] * alfa * l.waga_boki[q];

            double detJ = Math.sqrt(Math.pow(boki[3][1].x - boki[3][0].x, 2) + Math.pow(boki[3][1].y - boki[3][0].y, 2)) / 2;


            for (int k = 0; k < 4; k++) {
                for (int g = 0; g < 4; g++) {
                    boczek4[k][g] = temp4[k][g] * detJ;
                }
            }

        }

        
        for (int k = 0; k < 4; k++) {
            for (int g = 0; g < 4; g++) {
                HBC[k][g] = boczek1[k][g] + boczek2[k][g] + boczek3[k][g] + boczek4[k][g];
            }
        }
        return HBC;

    }

    public double [] obliczanieP(int q, int e,List<Node> wezly, List<Element> elementy,double alfa,double otoczenie, int pc ) {
        Elem4 l = new Elem4(pc);

        Node boki[][] = new Node[4][2];

        for (int j = 0; j < 4; j++) {
            if (wezly.get(elementy.get(e).ID[j] - 1).BC == 1 && wezly.get(elementy.get(e).ID[(j + 1) % 4] - 1).BC == 1) {
                boki[j][0] = wezly.get(elementy.get(e).ID[j] - 1);
                boki[j][1] = wezly.get(elementy.get(e).ID[(j + 1) % 4] - 1);
            }
        }

        double P[]={0,0,0,0};

        double P1[] = new double[4];

        //1 bok
        if (boki[0][0] != null && boki[0][1] != null) {
            double temp1[] = new double[4];
            temp1[0] += (l.Nbok1[q][0] * l.waga_boki[q])* (-alfa);
            temp1[1] += (l.Nbok1[q][1] * l.waga_boki[q])* (-alfa);

            double detJ = Math.sqrt(Math.pow(boki[0][1].x - boki[0][0].x, 2) + Math.pow(boki[0][1].y - boki[0][0].y, 2)) / 2;

            for (int k = 0; k < 4; k++) {
                {
                    P1[k] = temp1[k] * detJ* otoczenie;
                }
            }
        }
        double P2[] = new double[4];

        //2 bok
        if (boki[1][0] != null && boki[1][1] != null) {
            double temp2[] = new double[4];
            temp2[1] += (l.Nbok2[q][1] * l.waga_boki[q])* (-alfa);
            temp2[2] += (l.Nbok2[q][2] * l.waga_boki[q])* (-alfa);

            double detJ = Math.sqrt(Math.pow(boki[1][1].x - boki[1][0].x, 2) + Math.pow(boki[1][1].y - boki[1][0].y, 2)) / 2;

            for (int k = 0; k < 4; k++) {
                {
                    P2[k] = temp2[k] * detJ* otoczenie;
                }
            }
        }

        double P3[] = new double[4];
        //3 bok
        if (boki[2][0] != null && boki[2][1] != null) {
            double temp3[] = new double[4];
            temp3[2] += (l.Nbok3[q][2] * l.waga_boki[q])* (-alfa);
            temp3[3] += (l.Nbok3[q][3] * l.waga_boki[q])* (-alfa);

            double detJ = Math.sqrt(Math.pow(boki[2][1].x - boki[2][0].x, 2) + Math.pow(boki[2][1].y - boki[2][0].y, 2)) / 2;

            for (int k = 0; k < 4; k++) {
                {
                    P3[k] = temp3[k] * detJ* otoczenie;
                }
            }
        }

        double P4[] = new double[4];
        //3 bok
        if (boki[3][0] != null && boki[3][1] != null) {
            double temp4[] = new double[4];
            temp4[3] += (l.Nbok3[q][3] * l.waga_boki[q]+ l.Nbok3[q][0] * l.waga_boki[q])* (-alfa);
            temp4[0] += (l.Nbok3[q][0] * l.waga_boki[q]+ l.Nbok3[q][3] * l.waga_boki[q])* (-alfa);

            double detJ = Math.sqrt(Math.pow(boki[3][1].x - boki[3][0].x, 2) + Math.pow(boki[3][1].y - boki[3][0].y, 2)) / 2;

            for (int k = 0; k < 4; k++) {
                {
                    P4[k] = temp4[k] * detJ* otoczenie;
                }
            }
        }

        for (int k = 0; k < 4; k++) {

            P[k] = P1[k] + P2[k] + P3[k] + P4[k];

        }
        return P;

    }

}
