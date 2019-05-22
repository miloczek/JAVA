import java.util.Hashtable;

public class Main
{
    public static void main(String[] args)
    {
        Hashtable<String, Integer> Tree = new Hashtable<String, Integer>();
        Tree.put("x",14);
        System.out.println("x = " + Tree.get("x"));
        Tree.put("y",5);
        System.out.println("y = " + Tree.get("y"));
        Tree.put("z",7);
        System.out.println("z = " + Tree.get("z"));

        Wyrazenie test = new Pomnoz(new Zmienna("z", Tree), new Zmienna("x", Tree));
        test = new Pomnoz(new Stala(20), test);
        test = new Dodaj(test, new Zmienna("y", Tree));
        test = new Odejmij(test, new Stala(3));
        System.out.println(test.toString() + "=" + test.Oblicz());

        Wyrazenie test2 = new Dodaj(new Stala(7), new Stala(10));
        test2 = new Odejmij(new Zmienna("z", Tree),new Stala(15));
        test2 = new Pomnoz(new Zmienna("x",Tree), test2);
        System.out.println(test2.toString() + "=" + test2.Oblicz());
    }
}