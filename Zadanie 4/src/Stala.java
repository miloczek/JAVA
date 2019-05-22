public class Stala extends Wyrazenie{
    double value;

    public Stala(double value){   //double aby pomieścić więcej liczb po przecinku
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public double zwrocWartosc() {
        return value;
    }
}
