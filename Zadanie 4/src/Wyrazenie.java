import java.util.HashMap;

public class Wyrazenie {

    public Wyrazenie wyrazenie;  //konstruktor

    public Wyrazenie(){          //określenie typu
        wyrazenie = null;
    }

    public Wyrazenie(Wyrazenie wyrazenie){  // przypisanie argumentu do danych klasy
        this.wyrazenie = wyrazenie;
    }

    @Override
    public String toString() {
        return wyrazenie.toString();
    }

    public double Evaluate(HashMap<String, Double> eval)throws Exception{
        return Oblicz(this.wyrazenie, eval);
    }

    private double Oblicz(Wyrazenie wyrazenie, HashMap<String, Double> eval) throws Exception{ //sprawdzam czy wyrażeniem jest instancją Stałej, Zmiennej czy Korzenia i odpowiednio obliczam
        if (wyrazenie instanceof Stala)
            return ((Stala) wyrazenie).zwrocWartosc();
        else if (wyrazenie instanceof Zmienna)
            return eval.get(((Zmienna) wyrazenie).zwrocZmienna());
        else if (wyrazenie instanceof Korzen) {
            char operator = ((Korzen) wyrazenie).zwrocOperator();
            double lewaWartosc = Oblicz(((Korzen) wyrazenie).zwrocLewy(), eval);
            double prawaWartosc = Oblicz(((Korzen) wyrazenie).zwrocPrawy(), eval);
            switch(operator){
                case '+': return lewaWartosc + prawaWartosc;
                case '-': return lewaWartosc - prawaWartosc;
                case '*': return lewaWartosc * prawaWartosc;
                case '/': return lewaWartosc / prawaWartosc;
                case '^': return Math.pow(lewaWartosc, prawaWartosc);
                default: throw new Exception("Zły operator.");
            }
        }
        else if (wyrazenie instanceof Wyrazenie)
            return wyrazenie.Evaluate(eval);
        else
            throw new Exception("Zły typ wyrażenia.");
    }

    public Wyrazenie getExpression() {
        return wyrazenie;
    }
}
