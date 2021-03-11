public class Node {
    public double x, y,t0;
    int BC;
    Global temp = new Global();
    public Node(double x, double y ){
        this.x = x;
        this.y = y;
        this.t0 = temp.t0;
        if(this.x == 0 || this.y == 0 || this.x == temp.W || this.y == temp.H )
        {
            this.BC = 1;
        }
        else{
            this.BC =0;
        }

    }
}
