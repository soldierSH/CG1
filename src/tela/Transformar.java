package tela;

import java.util.ArrayList;

public class Transformar {
    //public ArrayList<Ponto> lista = new ArrayList<>();
    public ArrayList<Ponto> listapontos = new ArrayList<>();
    public ArrayList<Ponto> getPontos() {
        return listapontos;
    }

    public ArrayList<Ponto> Rotacionar(ArrayList<Ponto> pontos, String[] pivoS, String anguloS){
        Ponto pivo = new Ponto(Integer.parseInt(pivoS[0]),Integer.parseInt(pivoS[1]));
        double angulo = Double.parseDouble(anguloS);
        double radiano = Math.toRadians(angulo); //converte o numero pra radiano
        double seno = Math.sin(radiano);
        double cosseno = Math.cos(radiano);
        Ponto anterior = null;
        listapontos.clear();


        for (Ponto p : pontos) {
            
            double dX = p.getX() -pivo.getX();
            double dY = p.getY() -pivo.getY();
            double x = dX * cosseno - dY * seno + pivo.getX();
            double y = dX * seno + dY * cosseno + pivo.getY();

            Ponto ponto = new Ponto((int)x, (int)y);

            if(anterior  != null){
                Bresenham b = new Bresenham(anterior, ponto);
                listapontos.addAll(b.listapontos);
            }
           anterior = ponto;

        }
        return listapontos;
    }
    
    public ArrayList<Ponto> Transladar(ArrayList<Ponto> pontos, String[] direcaoS){
        int x = Integer.parseInt(direcaoS[0]);
        int y = Integer.parseInt(direcaoS[1]);
        listapontos.clear();

        for (Ponto p : pontos) {
            int nX = p.x + x;
            int nY = p.y + y;

            Ponto ponto = new Ponto(nX, nY);
            listapontos.add(ponto);
        }

        return listapontos;
    }

    public ArrayList<Ponto> Escalar(ArrayList<Ponto> pontos, String[] fatorS, String[] pontoS){
        double fatX = Double.parseDouble(fatorS[0]);
        double fatY = Double.parseDouble(fatorS[1]);
        Ponto anterior = null;
        Ponto fixo = new Ponto(Integer.parseInt(pontoS[0]), Integer.parseInt(pontoS[1]));
        listapontos.clear();

        for (Ponto p : pontos) {
            double dX = p.getX() -fixo.getX();
            double dY = p.getY() -fixo.getY();
            int x = (int) (dX * fatX) + fixo.getX();
            int y = (int) (dY * fatY) + fixo.getY();

            Ponto ponto = new Ponto(x, y);
            if(anterior  != null){
                Bresenham b = new Bresenham(anterior, ponto);
                listapontos.addAll(b.listapontos);
            }
            anterior = ponto;
        }
        return listapontos;
    }
}
