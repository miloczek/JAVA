class Odejmij implements Wyrazenie
{
    Wyrazenie a;
    Wyrazenie b;

    public Odejmij (Wyrazenie a, Wyrazenie b) {
        this.a = a; this.b = b;
    }
    public int Oblicz() {                   //Właściwe odejmowanie
        return a.Oblicz() - b.Oblicz();
    }
    public String toString() {
        return "(" + a + "-" + b + ")";
    }
}
