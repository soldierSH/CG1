import java.util.Scanner;
import javax.swing.*;
import tela.Bresenham;
import tela.Ponto;
import tela.Tela;
public class App {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SwingUtilities.invokeLater(()->{
            Tela tela = new Tela();
            tela.setVisible(true);
        });
    }
}