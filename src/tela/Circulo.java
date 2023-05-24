package tela;

import java.util.ArrayList;

public class Circulo {
    private ArrayList<Ponto> listapontos = new ArrayList<>();

    Circulo(int raio, Ponto centro){
        pontosCirculo(raio,centro);
    }

    public ArrayList<Ponto> getPontos() {
        return listapontos;
    }
    
    private void pontosCirculo(int raio, Ponto centro){
        int x = 0;
        int y = raio;
        int d = 1-raio;

        addPonto(x, y, centro);
        while (y > x) {
            if (d < 0) {
                d += 2 * x + 3;
            } else {
                d += 2 * (x - y) + 5;
                y--;
            }
            x++;
            addPonto(x, y, centro);
        }
    }

    private void addPonto(int x, int y, Ponto centro) {
        listapontos.add(new Ponto(centro.getX() + x, centro.getY() + y));
        listapontos.add(new Ponto(centro.getX() - x, centro.getY() + y));
        listapontos.add(new Ponto(centro.getX() + x, centro.getY() - y));
        listapontos.add(new Ponto(centro.getX() - x, centro.getY() - y));
        listapontos.add(new Ponto(centro.getX() + y, centro.getY() + x));
        listapontos.add(new Ponto(centro.getX() - y, centro.getY() + x));
        listapontos.add(new Ponto(centro.getX() + y, centro.getY() - x));
        listapontos.add(new Ponto(centro.getX() - y, centro.getY() - x));
    }
}
