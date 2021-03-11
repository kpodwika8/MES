public class Soe {
    Global global = new Global();
    public double [][] HG = new double[global.NN][global.NN];
    public double [][] CG = new double[global.NN][global.NN];
    public double [] PG = new double[global.NN];

    public double epsilon = 1e-10;
    public double[] EliminacjaGaussa(double[][] HKONCOWA, double[] PKONCOWA) {
        int d = PKONCOWA.length;
        for(int i = 0; i < d; i++)
        {
            int maximum = i;
            for(int j = i + 1; j < d; j++) {
                if(Math.abs(HKONCOWA[j][i]) > Math.abs(HKONCOWA[maximum][i])) {
                    maximum = j;
                }

            }

            double [] pomoc = HKONCOWA[i];
            HKONCOWA[i] = HKONCOWA[maximum];
            HKONCOWA[maximum] = pomoc;
            double pomoc2 = PKONCOWA[i];
            PKONCOWA[i] = PKONCOWA[maximum];
            PKONCOWA[maximum] = pomoc2;

            if (Math.abs(HKONCOWA[i][i]) <= epsilon)
            {
                throw  new ArithmeticException("BLAD");
            }

            for(int j = i+1; j<d; j++)
            {
                double alfa = HKONCOWA[j][i] / HKONCOWA[i][i];
                PKONCOWA[j] -= alfa * PKONCOWA[i];
                for(int k = i; k<d; k++)
                {
                    HKONCOWA[j][k] -=alfa * HKONCOWA[i][k];
                }
            }
        }

        double [] wynik = new double[d];
        for(int i= d - 1; i>=0; i--)
        {
            double sum = 0.0;
            for (int j = i + 1; j < d; j++) {
                sum += HKONCOWA[i][j] * wynik[j];
            }
            wynik[i] = (PKONCOWA[i] - sum) / HKONCOWA[i][i];
        }

        return wynik;
    }
}
