package tela;

import java.util.ArrayList;

public class Curvas {
    public ArrayList <Ponto> listapontos = new ArrayList<>();


    public ArrayList<Ponto> getPontos() {
        return listapontos;
    }

    Curvas(Ponto pInicial, Ponto controle1, Ponto controle2, Ponto pFinal){
        bezier(pInicial, controle1, controle2, pFinal);
    }

    private void bezier(Ponto pInicial, Ponto controle1, Ponto controle2, Ponto pFinal) {
        double i = 0.01;

        for (double t = 0; t <= 1; t += i) {
            double x = coordenadas(t, pInicial.x, controle1.x, controle2.x, pFinal.x);
            double y = coordenadas(t, pInicial.y, controle1.y, controle2.y, pFinal.y);

            listapontos.add(new Ponto((int) x, (int) y));
        }
    }

    private double coordenadas(double t, int pInicial, int c1, int c2, int pFinal) {
        double b = 1 - t;
        double qt = t * t;
        double qb = b * b;
        double cb = qb * b;
        double ct = qt * t;

        double coordenada = cb * pInicial + 3 * qb * t * c1 + 3 * b * qt * c2 + ct * pFinal;
        return coordenada;
    }
}
