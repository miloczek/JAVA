public class Zmienna extends Wyrazenie {
    private String var;

    public Zmienna(String var){
        this.var = var;
    }

    @Override
    public String toString() {
        return var;
    }

    public String zwrocZmienna() {
        return var;
    }
}
