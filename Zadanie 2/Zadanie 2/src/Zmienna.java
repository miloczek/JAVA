import java.util.*;

public class Zmienna implements Wyrazenie
{
    String s; Hashtable<String, Integer> Tree; //wykorzystujemy Hashtable (tablica haszująca)

    public Zmienna(String s, Hashtable<String, Integer> l) //mamy symbol i jego wartość
    {
        this.s = s; this.Tree = l;
    }

    public int Oblicz() {
        return Tree.get(s);
    }
    public String toString() {  //zwracamy w formie stringa
        return s;
    }
}