class Podziel implements Wyrazenie
{
    Wyrazenie a;
    Wyrazenie b;

    public Podziel (Wyrazenie a, Wyrazenie b) {
        this.a = a; this.b = b;
    }
    public int Oblicz() {                  //Właściwe dzielenie
        return a.Oblicz() / b.Oblicz();
    }
    public String toString() {
        return "(" + a + "/" + b + ")";
    }
}
