import java.io.Serializable;

public class Pojazd implements Serializable {
    public String Kolor;
    public String Marka;
    public int Rocznik;

    public Pojazd(String m, String k, int r){
        Marka = m; Kolor = k; Rocznik = r;
    }
    public Pojazd() {this ( "Marka", "Kolor", 11111);}

    public String toString() {return Marka + "\n" + Kolor + "\n" + Integer.toString(Rocznik);}
}
