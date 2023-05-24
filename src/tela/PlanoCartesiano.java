package tela;
import javax.swing.*;
import java.awt.*;

public class PlanoCartesiano extends JPanel {

    private int numPontos;
    private int tamQuadrado;
    private int centroX; //centro de X
    private int centroY; //centro de Y
    private Color[][] grid;

    public PlanoCartesiano(int numPontos, int tamQuadrado) {
        this.numPontos = numPontos;
        this.tamQuadrado = tamQuadrado;
        this.centroX = numPontos * tamQuadrado / 2;
        this.centroY = numPontos * tamQuadrado / 2;
        this.grid = new Color[numPontos][numPontos];
        setPreferredSize(new Dimension(numPontos * tamQuadrado, numPontos * tamQuadrado));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // pintando grade
        for (int i = 0; i < numPontos; i++) {
            for (int j = 0; j < numPontos; j++) {
                int x = i * tamQuadrado;
                int y = j * tamQuadrado;
                g.setColor(grid[i][j] == null ? Color.WHITE : grid[i][j]);
                g.fillRect(x, y, tamQuadrado, tamQuadrado);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, tamQuadrado, tamQuadrado);
            }
        }
        
        g.setColor(Color.RED);
        g.drawLine(0, centroY,400, centroY);
        g.drawLine(centroX, 0, centroX, 400);
        
    }

    public void paintSquare(int x, int y, Color color) {
        int i = x + numPontos / 2;
        int j = -y + numPontos / 2 - 1;
        if (i >= 0 && i < numPontos && j >= 0 && j < numPontos) {
            grid[i][j] = color;
            repaint();
        }
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