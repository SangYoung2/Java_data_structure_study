package Chapter4.section2;

public class Term {
    public int coef;
    public int expo;

    public Term(int coef, int expo) {
        this.coef = coef;
        this.expo = expo;
    }

    public int calc(int x) {
        System.out.println("calc");
        return coef * (int)Math.pow(x, expo);
    }

    @Override
    public String toString() {
        return coef + "x^" + + expo;
    }
}
