class Pomnoz implements Wyrazenie
{
    Wyrazenie a;
    Wyrazenie b;

    public Pomnoz (Wyrazenie a, Wyrazenie b) {
        this.a = a; this.b = b;
    }
    public int Oblicz() {              //Właściwe mnożenie
        return a.Oblicz() * b.Oblicz();
    }
    public String toString() {
        return "(" + a + "*" + b + ")";
    }
}