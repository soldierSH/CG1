public class Bresenham {
    private boolean mudaX;
    private boolean mudaY;
    private boolean mudaXY;


    Bresenham(Ponto p1, Ponto p2){
        
    }

    void pontos(Ponto p1, Ponto p2){
        octante();
    }
    void octante(Ponto p1, Ponto p2){
        int deltaX=p1.getX() - p1.getX();
        int deltaY=p2.getY() - p1.getY();
        float m=deltaY/deltaX;

        //troca x e y
        if(m > 1 || m < -1){
        //troca de x e y
        p1.x -= p1.y;p1.y += p1.x;p1.x = p1.y - p1.x;
        p2.x -= p2.y;p2.y += p2.x;p2.x = p2.y - p2.x;
        mudaXY = true;
        }//troca o sinal de x
        if(p1.x > p2.x){
        p1.x *= -1;p2.x *= -1;
        mudaX = true;
        }//troca o sinal de y
        if(p1.y > p2.y){
        p1.y *= -1;p2.y *= -1;
        mudaY = true;
        }
        
    }
}
