import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Global {
    public double W;
    public double H;
    int nW;
    int nH;
    int NE;
    int NN;
    int punkty;
    double Cp;
    double ro;
    double alfa;
    double totoczenia;
    int tau;
    double t0;
    int k;
    int czassymulacji;
    public Global()
    {
        try{
            File plik = new File("mes.txt");
            Scanner Reader = new Scanner(plik);
            this.W = Reader.nextDouble();
            this.H = Reader.nextDouble();
            this.nW = Reader.nextInt();
            this.nH = Reader.nextInt();
            this.punkty = Reader.nextInt();
            this.Cp = Reader.nextDouble();
            this.ro = Reader.nextDouble();
            this.alfa = Reader.nextDouble();
            this.totoczenia = Reader.nextDouble();
            this.tau = Reader.nextInt();
            this.t0 = Reader.nextDouble();
            this.k = Reader.nextInt();
            this.czassymulacji = Reader.nextInt();


            this.NE = (nW-1)*(nH-1);
            this.NN = nW*nH;
            Reader.close();
            //System.out.println(" W: "+W +" H: "+H +" nW: "+nW +" nH: "+nH + " NE: "+NE +" NN: "+ NN);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
