import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception{
        // Tablica haszująca z obliczaniem zmiennych
        HashMap<String, Double> eval = new HashMap<>();
        eval.put("x", 7.0);
        eval.put("y", 2.0);
        eval.put("z", 4.0);

        // 5.0 + (6.0 - 7.0)
        System.out.println("Test bez zmiennych:");
        Wyrazenie wyrazenie = new Wyrazenie(
                new Korzen('+',
                        new Stala(5),
                        new Korzen('-', new Stala(6), new Stala(7))));
        System.out.print(wyrazenie);
        System.out.println(" = " + wyrazenie.Evaluate(eval));

        // 8.0 * x
        System.out.println("Test z jedną zmienną:");
        Wyrazenie wyrazenie1 = new Wyrazenie(
                new Korzen('*',
                        new Stala(8), new Zmienna("x")));
        System.out.print(wyrazenie1);
        System.out.println(" = " + wyrazenie1.Evaluate(eval));

        // (x ^ y) + (x * z)
        System.out.println("Trzy zmienne:");
        Wyrazenie wyrazenie2 = new Wyrazenie(
                new Korzen('+',
                        new Korzen('^', new Zmienna("x"), new Zmienna("y")),
                        new Korzen('*', new Zmienna("x"), new Zmienna("z"))));
        System.out.print(wyrazenie2);
        System.out.println(" = " + wyrazenie2.Evaluate(eval));

        // 5 + (x ^ y) + (x * z)
        System.out.println("Trzy zmienne i jedna stała:");
        Wyrazenie wyrazenie3 = new Wyrazenie(new Korzen('+', new Stala(5.0), wyrazenie2));
        System.out.print(wyrazenie3);
        System.out.println(" = " + wyrazenie3.Evaluate(eval));

        // expression3 + expression3
        System.out.println("Trochę bardziej skomplikowane:");
        Wyrazenie wyrazenie4 = new Wyrazenie(new Korzen ('+', wyrazenie3, wyrazenie3));
        System.out.print(wyrazenie4);
        System.out.println(" = " + wyrazenie4.Evaluate(eval));

        // 2*x^3
        System.out.println("Obliczamy pochodną");
        Wyrazenie wyrazenie5 = new Wyrazenie(new Korzen('*', new Stala(2),
                new Korzen('^', new Zmienna("x"), new Stala(3))));
        System.out.println(wyrazenie5);

        System.out.print("I tu wynik: ");
        Wyrazenie wyrazenie6 = new Pochodna(new Korzen('+', wyrazenie5, wyrazenie5));
        System.out.println(wyrazenie6);

        System.out.print("Kolejna pochodna: ");
        Wyrazenie wyrazenie7 = new Pochodna(new Pochodna (wyrazenie5));
        System.out.println(wyrazenie7);

        System.out.println("Pochodna i stała:");
        Wyrazenie wyrazenie8 = new Korzen('+', new Stala(5), wyrazenie5);
        System.out.println(wyrazenie8);
        System.out.println(new Pochodna(wyrazenie8));

    }
}

