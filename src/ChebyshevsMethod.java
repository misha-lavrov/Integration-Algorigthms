public class ChebyshevsMethod {
    private Function f;
    private double a;
    private double b;
    private double[] t;
    private int n;

    public ChebyshevsMethod(Function f, double a, double b, double[] t){
        this.f = f;
        this.a = a;
        this.b = b;
        this.n = t.length;
        this.t = t;
    }

    public double solve(){
        double S = 0, x;
        print();
        for(int i = 1; i <= n; i++){
            x = (b + a) / 2 + ((b - a) / 2 * t[i - 1]);
            S += f.apply(x);
            print(i, x, t[i - 1], f.apply(x), S);
        }
        S = (b - a) / n * S;
        print(S);
        return S;
    }


    public void print(){
        System.out.println("|------------------------------------------------|");
        System.out.println("|            Chebyshev's method (n = 4)          |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|  i  ||    x    |    t    |   f(x)   ||    S    |");
        System.out.println("|------------------------------------------------|");
    }

    public void print(int i, double x, double t, double f, double S){
        System.out.println(String.format("|%5d||%9.4f|%9.4f|%10.4f||%9.4f|", i, x, t, f, S));
    }

    public void print(double result){
        System.out.println("|------------------------------------------------|");
        System.out.println(String.format("Result: (b - a) / n * S = %.10f", result));
        System.out.println();
    }
}
