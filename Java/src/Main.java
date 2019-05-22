import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        String plik = ""; String klasa = "Samochód";

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame ex;

                if(klasa == "Pojazd") ex = new PojazdEdit(plik);
                else if (klasa == "Samochód") ex = new SamochódEdit(plik);
                else ex = new TramwajEdit(plik);

                ex.setVisible(true);

            }
        });
    }
}
