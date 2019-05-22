public class Pochodna extends Wyrazenie{
    public Pochodna(Wyrazenie wyrazenie) throws Exception{
        this.wyrazenie = zrobPochodna(wyrazenie);
    }

    public Wyrazenie zrobPochodna(Wyrazenie wyrazenie) throws Exception{
        if (wyrazenie instanceof Stala)                // jeśli stała to zero, bo pochodna ze stałej to zero
            return new Stala(0);
        if (wyrazenie instanceof Zmienna)           // jeśli jest zmienną to "dobieramy się" do wartości
            return wyrazenie;
        if (wyrazenie instanceof Korzen){
            switch (((Korzen) wyrazenie).zwrocOperator()){
                case '+':
                    return new Korzen('+',
                            zrobPochodna(((Korzen) wyrazenie).zwrocLewy()),
                            zrobPochodna(((Korzen) wyrazenie).zwrocPrawy()));
                case '-':
                    return new Korzen('-',
                            zrobPochodna(((Korzen) wyrazenie).zwrocLewy()),
                            zrobPochodna(((Korzen) wyrazenie).zwrocPrawy()));
                case '*':
                    return new Korzen('*',
                            ((Korzen) wyrazenie).zwrocLewy(),
                            zrobPochodna(((Korzen) wyrazenie).zwrocPrawy()));
                case '^':
                    return new Korzen('*',
                            new Stala(((Stala)((Korzen) wyrazenie).zwrocPrawy()).zwrocWartosc()),                   // przerzucamy wartość z potęgi do iloczynu
                            new Korzen('^',
                                    ((Korzen) wyrazenie).zwrocLewy(),
                                    (new Stala(((Stala)((Korzen) wyrazenie).zwrocPrawy()).zwrocWartosc() - 1))));    // zmniejszamy potęgę
            }
        }
        if (wyrazenie instanceof Wyrazenie)
            return zrobPochodna(wyrazenie.getExpression());
        throw new Exception("Zła funkcja");
    }
}
