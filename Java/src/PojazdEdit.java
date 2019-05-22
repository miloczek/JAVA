import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class PojazdEdit extends JFrame implements ActionListener, Serializable {

    public JButton ButtonZapisz, ButtonWczytaj;
    public JTextField TextPodajMarkę, TextPodajKolor, TextPodajRocznik;
    public Pojazd P;
    private File file;

    public PojazdEdit(String x){

        initUI(); P = new Pojazd();

        if(x != ""){

            File file = new File(x);
            WczytajZPliku(file);
        }
    }

    public void Wczytaj(){

        TextPodajMarkę.setText(P.Marka);
        TextPodajKolor.setText(P.Kolor);
        TextPodajRocznik.setText(Integer.toString(P.Rocznik));

    }

    public void Wpisz(){

        P = new Pojazd(TextPodajMarkę.getText(), TextPodajKolor.getText(), Integer.parseInt(TextPodajRocznik.getText()));
    }

    public final void initUI() {

        ButtonZapisz = new JButton("Zapisz");
        ButtonWczytaj = new JButton("Wczytaj");

        ButtonZapisz.setBounds(0, 10, 150, 100); //jedno pod drugim
        ButtonWczytaj.setBounds(0, 110, 150, 100);

        this.setLayout(null);

        getContentPane().add(ButtonZapisz);
        getContentPane().add(ButtonWczytaj);
        ButtonZapisz.addActionListener(this);
        ButtonWczytaj.addActionListener(this);

        TextPodajMarkę = new JTextField("Podaj markę");
        TextPodajMarkę.setBounds(200, 10, 200, 60);
        getContentPane().add(TextPodajMarkę);

        TextPodajKolor = new JTextField("Podaj kolor");
        TextPodajKolor.setBounds(200, 70, 200, 60);
        getContentPane().add(TextPodajKolor);

        TextPodajRocznik = new JTextField("Podaj rocznik");
        TextPodajRocznik.setBounds(200, 130, 200, 60);
        getContentPane().add(TextPodajRocznik);

        setSize(700, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void WpiszDoPliku(File file) {
        try {
            Wpisz();
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(this.file));
            outputStream.writeObject(this.P);
        } catch (Exception e){
            // nic
        }
    }

    public void WczytajZPliku(File file){
        try{
            Wczytaj();
            ObjectInputStream inputStream = new ObjectInputStream (new FileInputStream(this.file));
            P = (Pojazd) inputStream.readObject();
            Wczytaj();


        }
        catch (Exception e) {
            // nic
        }
    }

    public void actionPerformed(ActionEvent e){

        Object source = e.getSource();

        if( source == ButtonZapisz){
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(ButtonZapisz) == JFileChooser.APPROVE_OPTION){

                File file = fileChooser.getSelectedFile();
                WpiszDoPliku(file);

            }
        }

        if ( source == ButtonWczytaj){

            JFileChooser fileChooser = new JFileChooser();

            if (fileChooser.showOpenDialog(ButtonWczytaj) == JFileChooser.APPROVE_OPTION){

                File file = fileChooser.getSelectedFile();
                WczytajZPliku(file);
            }
        }
    }





}




