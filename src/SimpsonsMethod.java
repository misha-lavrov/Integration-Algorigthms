public class SimpsonsMethod {
    private Function f;
    private double a;
    private double b;
    private double h;

    public SimpsonsMethod(Function f, double a, double b, double h){
        this.f = f;
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public double solve(){
        double x, S = 0, S1 = 0, S2 = 0;
        int n = (int)((b - a) / h);
        print();
        print(0, a, f.apply(a), S1, S2);
        for(int i = 1; i < n; i++){
            x = a + i * h;
            if(i % 2 == 0){
                S2 += f.apply(x);
            }else{
                S1 += f.apply(x);
            }
            print(i, x, f.apply(x), S1, S2);
        }
        print(n, b, f.apply(b), S1, S2);
        S = h / 3 * (f.apply(a) + f.apply(b) + 4 * S1 + 2 * S2);
        print(S);
        return S;
    }

    public void print(){
        System.out.println("|--------------------------------------------------|");
        System.out.println(String.format("|            Simpson's method (h = %.1f)            |", h));
        System.out.println("|--------------------------------------------------|");
        System.out.println("|  i  ||    x    |   f(x)   ||    S1    |    S2    |");
        System.out.println("|--------------------------------------------------|");
    }

    public void print(int i, double x, double f, double S1, double S2){
        System.out.println(String.format("|%5d||%9.4f|%10.4f||%10.4f|%10.4f|", i, x, f, S1, S2));
    }

    public void print(double result){
        System.out.println("|--------------------------------------------------|");
        System.out.println(String.format("Result: h / 3 * (f(a) + f(b) + 4 * S1 + 2 * S2) = %.10f", result));
        System.out.println();
    }

}
