package tela;
import java.util.ArrayList;

public class Polilinhas {
    public ArrayList<Ponto> listapontos = new ArrayList<>();
    public ArrayList<Ponto> getPontos() {
        return listapontos;
    }

    Polilinhas(ArrayList<Ponto> pontos){
        linhas(pontos);
    }

    private void linhas(ArrayList<Ponto> pontos){
        Ponto anterior = null;
        Bresenham b = new Bresenham();
        for (Ponto p : pontos) {
            if(anterior != null){
                b.pontos(anterior,p);
            }
            anterior = p;
        }
        listapontos = b.listapontos;
    }
}
