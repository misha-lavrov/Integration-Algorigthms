public class GaussiansMethod {
    private Function f;
    private double a;
    private double b;
    private double[] t;
    private double[] A;
    private int n;

    public GaussiansMethod(Function f, double a, double b, double[] t, double[] A){
        this.f = f;
        this.a = a;
        this.b = b;
        this.n = 3;
        this.t = t;
        this.n = t.length;
        this.A = A;
    }

    public double solve(){
        double S = 0, x;
        print();
        for(int i = 1; i <= n; i++){
            x = (b + a) / 2 + ((b - a) / 2 * t[i - 1]);
            S += A[i - 1] * f.apply(x);
            print(i, x, t[i - 1], A[i - 1], f.apply(x), S);
        }
        S = (b - a) / 2 * S;
        print(S);
        return S;
    }


    public void print(){
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|                  Gaussian's method (n = 3)               |");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|  i  ||    x    |    t    |    A    |   f(x)   ||    S    |");
        System.out.println("|----------------------------------------------------------|");
    }

    public void print(int i, double x, double t, double A, double f, double S){
        System.out.println(String.format("|%5d||%9.4f|%9.4f|%9.4f|%10.4f||%9.4f|", i, x, t, A, f, S));
    }

    public void print(double result){
        System.out.println("|----------------------------------------------------------|");
        System.out.println(String.format("Result: (b - a) / 2 * S = %.10f", result));
        System.out.println();
    }
}
