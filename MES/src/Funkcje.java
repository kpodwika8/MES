public class Funkcje {
    double f(double x, double y)
    {
        return ((x*2.0)*y);
    }

    void dwaWezly()
    {
        double x1 = -0.577;
        double x2 = 0.577;
        double y1 = -0.577;
        double y2 = 0.577;
        double a1 = 1;
        double a2 = -1;

        double wynik = 0;

        wynik = f(x1,y1)*a1*a1 + f(x2,y1)*a1*a2 + f(x1,y2)*a2*a1 + f(x2,y2)*a2*a2;
        System.out.println(wynik);

    }

    void trzyWezly()
    {
        double x1 = -0.77;
        double x2 = 0;
        double x3 = 0.77;
        double y1 = -0.77;
        double y2 = 0;
        double y3 = 0.77;
        double a1 = 0.555555;
        double a2 = 0.888888889;

        double wynik = 0;

        wynik = f(x1,y1)*a1*a1 + f(x2,y1)*a2*a1 + f(x3,y1) * a1*a1 + f(x1,y2)*a1*a2 + f(x2,y2)*a2*a2 +  f(x3,y2) * a1*a2 +  f(x1,y3)*a1*a1 + f(x2,y3)*a1*a2 + f(x3,y3)*a1*a1;

        System.out.println(wynik);

    }
}
