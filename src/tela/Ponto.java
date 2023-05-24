package tela;
public class Ponto {
    public int x;
    public int y;
    Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    //métodos paa invrter sinal
    public void iSinalX() {
        this.x = -this.x;
    }
    
    public void iSinalY() {
        this.y = -this.y;
    }
    
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
