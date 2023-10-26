package Chapter2.section3;

public class Polynomial3 {
    private char name; // 다항식의 이름
    private int nTerms; // 다항식을 구성하는 항의 갯수
    private Term3[] terms; // 항의 배열

    public Polynomial3() {
        nTerms = 0;
        terms = new Term3[100];
    }

    public Polynomial3(char name) {
        this.name = name;
        nTerms = 0;
        terms = new Term3[100];
    }

    int calcPolynomial(int x) {
        int result = 0;
        for (int i = 0; i < nTerms; i++) {
            result += terms[i].calcTerm(x);
        }
        return result;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    void printPolynomial(){
        for (int i = 0; i < nTerms; i++) {
            terms[i].printTerm ();
            System.out.println("+");
        }
    }

    public void addTerm(int c, int e) {
        int index = findTerm(e);
        if(index != -1) {
            terms[index].setCoef(terms[index].getCoef() + c);
        }
        else {
            int i = nTerms-1;
            while (i >= 0 && terms[i].getCoef() < e) {
                terms[i+1] = terms[i];
                i--;
            }
            terms[i+1] = new Term3(c, e);
            nTerms++;
        }
    }

    private int findTerm(int e) {
        for (int i = 0; i < nTerms && terms[i].getCoef() >= e; i++) {
            if(terms[i].getCoef() == e) {
                return i;
            }
        }
        return -1;
    }

}
