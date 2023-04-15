import java.util.Scanner;

public class App {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Ponto pt1 = new Ponto(0,0);
        Ponto pt2 = new Ponto(5,3);
        System.out.println("Hello world!");

        Bresenham b = new Bresenham(pt1,pt2);
        b.pontos(pt1, pt2);
    }
}