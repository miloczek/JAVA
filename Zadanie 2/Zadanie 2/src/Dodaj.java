class Dodaj implements Wyrazenie
{
    Wyrazenie a;
    Wyrazenie b;

    public Dodaj (Wyrazenie a, Wyrazenie b) {  //Tu mówimy czym są wyrażenia
        this.a = a; this.b = b;
    }
    public int Oblicz() {                  //Tutaj ma miejsce właściwe dodawanie
        return a.Oblicz() + b.Oblicz();
    }
    public String toString() {                 //łączymy je znakiem dodawania i wyrzucamy jako string
        return "(" + a + "+" + b + ")";
    }
}
