public class Main {
    public static void main(String[] args) {
        double a = 0;
        double b = 1;
        double c = 1;
        double d = 0.5;
        Function f = (x) -> d * Math.pow(x, 3) / 2 - Math.cos(c * x);

        // для Сімпсона:
        double[] h = {0.1, 0.2, 0.5};

        // для Чебишева 4-го порядку:
        double[] t_Cheb = new double[]{0.794_654, 0.187_592, -0.187_592, -0.794_654};

        // для Гауса 3-го порядку:
        double[] t_Gaus = new double[]{-0.774_596_669, 0, 0.774_596_669};
        double[] A_Gaus = new double[]{0.555_555_556, 0.888_888_889, 0.555_555_556};


        double[] resultSimp = new double[3];
        double resultCheb;
        double resultGaus;

        for(int i = 0; i < h.length; i++){
            SimpsonsMethod simpsonsMethod = new SimpsonsMethod(f, a, b, h[i]);
            resultSimp[i] = simpsonsMethod.solve();
        }

        ChebyshevsMethod chebyshevsMethod = new ChebyshevsMethod(f, a, b, t_Cheb);
        resultCheb = chebyshevsMethod.solve();

        GaussiansMethod gaussiansMethod = new GaussiansMethod(f, a, b, t_Gaus, A_Gaus);
        resultGaus = gaussiansMethod.solve();

        System.out.println();
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|                      Final results:                      |");

        for(int i = 0; i < resultSimp.length; i++){
            System.out.println(String.format("Simpson's (h = %.1f): I = \t%.10f", h[i], resultSimp[i]));
        }
        System.out.println(String.format("Chebyshev's (n = 4): I = \t%.10f", resultCheb));
        System.out.println(String.format("Gaussian's (n = 3): I = \t%.10f", resultGaus));

        double handCalc = -Math.sin(1) + 0.0625;
        System.out.println(String.format("Hand calculation:\nF(1) - F(0) = -sin(1) + 0.0625 = \t%.10f", handCalc));
        System.out.println();
    }
}
