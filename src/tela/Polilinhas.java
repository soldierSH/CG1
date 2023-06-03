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
        Ponto anterior = pontos.get(0);
        int cont = 1;

        do {
            Ponto p = pontos.get(cont);
            Bresenham b = new Bresenham(anterior,p);
            listapontos.addAll(b.listapontos);
            anterior = p;
            cont++;
        } while (cont != pontos.size());
        
    }

}
