import java.util.Scanner;
import javax.swing.*;

import tela.Bresenham;
import tela.Ponto;
import tela.Tela;
public class App {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //Ponto pt1 = new Ponto(-1,-2);
       // Ponto pt2 = new Ponto(-3,-4);
        System.out.println("Hello world!");

        //Bresenham b = new Bresenham(pt1,pt2);

        SwingUtilities.invokeLater(()->{
            Tela tela = new Tela();
            tela.setVisible(true);
        });
    }
}