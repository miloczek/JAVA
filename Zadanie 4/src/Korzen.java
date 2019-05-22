public class Korzen extends Wyrazenie{  //implementacja korzenia
    private char operator;
    private Wyrazenie lewy;             // operator w korzeniu oraz lewe i prawe dziecko jako wyrażenia
    private Wyrazenie prawy;

    public Korzen(char operator, Wyrazenie lewy, Wyrazenie prawy ){
        this.operator = operator;
        this.lewy = lewy;
        this.prawy = prawy;
    }

    @Override
    public String toString() {
        return "(" + lewy + " " + operator + " " + prawy + ")";
    }

    public Wyrazenie zwrocLewy() {
        return lewy;
    }

    public Wyrazenie zwrocPrawy() {
        return prawy;
    }

    public char zwrocOperator() {
        return operator;
    }
}
