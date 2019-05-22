import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

import javax.swing.*;

public class SamochódEdit extends JFrame implements ActionListener, Serializable{

    public JButton ButtonZapisz, ButtonWczytaj;
    public JTextField TextPodajMarkę, TextPodajKolor, TextPodajRocznik;
    public Samochód P;

    public SamochódEdit (String x){

        initUI(); P = new Samochód();

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

        P = new Samochód(TextPodajMarkę.getText(), TextPodajKolor.getText(), Integer.parseInt(TextPodajRocznik.getText()));
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

        TextPodajKolor = new JTextField("Podaj model");
        TextPodajKolor.setBounds(200, 70, 200, 60);
        getContentPane().add(TextPodajKolor);

        TextPodajRocznik = new JTextField("Podaj rocznik");
        TextPodajRocznik.setBounds(200, 130, 200, 60);
        getContentPane().add(TextPodajRocznik);

        setSize(700, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void WpiszDoPliku(File file){
        try
        {
            PrintWriter wpis = new PrintWriter(file);
            Wpisz();
            wpis.println(P.toString());
            wpis.close();
        }
        catch (FileNotFoundException e1) {}
    }

    public void WczytajZPliku(File file){
        try
        {
            Scanner in = new Scanner(file);

            String M = in.nextLine();
            String K = in.nextLine();
            String R = in.nextLine();

            P = new Samochód(M, K, Integer.parseInt(R));
            Wczytaj();
            in.close();
        }
        catch (FileNotFoundException e1) {}
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

