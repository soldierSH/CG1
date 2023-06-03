package tela;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlanoCartesiano extends JPanel {
    private int numPontos;
    public int getNumPontos() {
        return numPontos;
    }

    private int tamQuadrado;
    private int centroX; //centro de X
    private int centroY; //centro de Y
    public Color[][] grid;
    public boolean recorte = false;
    public ArrayList<Ponto> pintar  = new ArrayList<>();
    private ArrayList<Ponto> pintarRecorte  = new ArrayList<>();

    public PlanoCartesiano(int numPontos, int tamQuadrado) {
        this.numPontos = numPontos;
        this.tamQuadrado = tamQuadrado;
        this.centroX = numPontos * tamQuadrado / 2;
        this.centroY = numPontos * tamQuadrado / 2;
        this.grid = new Color[numPontos][numPontos];
        setPreferredSize(new Dimension(numPontos * tamQuadrado, numPontos * tamQuadrado));
    }

    private void gradePrincipal(Graphics g) {
        for (int i = 0; i < numPontos; i++) {
            for (int j = 0; j < numPontos; j++) {
                int x = i * tamQuadrado;
                int y = j * tamQuadrado;
                g.setColor(grid[i][j] == null ? Color.WHITE : grid[i][j]);
                g.fillRect(x, y, tamQuadrado, tamQuadrado);
                g.setColor(Color.gray);
                g.drawRect(x, y, tamQuadrado, tamQuadrado);
            }
        }
    
        g.setColor(Color.RED);
        g.drawLine(0, centroY, 400, centroY);
        g.drawLine(centroX, 0, centroX, 400);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gradePrincipal(g);
    }
      

    public void pintarPonto(int x, int y, Color color) {
        int i = x + numPontos / 2;
        int j = -y + numPontos / 2 - 1;
        
        if (i >= 0 && i < numPontos && j >= 0 && j < numPontos) {
            grid[i][j] = color;
            
        }
        repaint();

    }
    public void pintarPontos(ArrayList<Ponto> listapontos, Color color) {
        for (Ponto p : listapontos) {
            int i = p.x + numPontos / 2;
            int j = -p.y + numPontos / 2 - 1;

            if (recorte == false) {
                if (i >= 0 && i < numPontos && j >= 0 && j < numPontos) {
                    grid[i][j] = color;
                }
            } else {//Preencher janela de recorte
                if (i >= 0 && i < numPontos && j >= 0 && j < numPontos) {
                    for (Ponto ponto : pintar) {
                        grid[ponto.x][ponto.y] = Color.LIGHT_GRAY;
                        if(ponto.x == i && ponto.y == j){
                            pintarRecorte.add(new Ponto(i, j));
                        }
                    }
                } 
            } 
        }
        for (Ponto ponto : pintarRecorte) {
            grid[ponto.x][ponto.y]= color;
        }
        pintarRecorte.clear();
        repaint();
    }
    
    
    public void Recorte(Ponto p1, Ponto p2, Color color) {
        int i1 = p1.x + numPontos / 2;
        int j1 = -p1.y + numPontos / 2 - 1;
        int i2 = p2.x + numPontos / 2;
        int j2 = -p2.y + numPontos / 2 - 1;
    
        if (i1 >= 0 && i1 < numPontos && j1 >= 0 && j1 < numPontos && i2 >= 0 && i2 < numPontos && j2 >= 0 && j2 < numPontos) {
            for (int i = i1; i <= i2; i++) {
                for (int j = j1; j <= j2; j++) {
                    if(grid[i][j] == null){
                        grid[i][j] = Color.LIGHT_GRAY;
                        pintar.add(new Ponto(i,j));
                    } if(grid[i][j] != Color.WHITE){
                        pintar.add(new Ponto(i,j));
                    }
                    
                }
            }
            repaint();
        }
    }

    public Color[][] getGrid() {
        return grid;
    }

    public void limparPontos() {
        for (int i = 0; i < numPontos; i++) {
            for (int j = 0; j < numPontos; j++) {
                grid[i][j] = null;
            }
        }
        repaint();
    }
    
}