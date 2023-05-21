package tela;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Tela extends JFrame{
    protected JButton desenhar = new JButton("Desenhar");
    protected JPanel pValues;
    protected JPanel painelInicial;
    protected JPanel painelFinal;
    protected JLabel pInicial = new JLabel("Ponto Inicial(x,y): ");
    protected JLabel pFinal = new JLabel("Ponto Final(x,y): ");
    protected JLabel name = new JLabel("by Scarlet Hanna");
    protected JTextField initX = new JTextField(4);
    protected JTextField initY = new JTextField(4);
    protected JTextField finalX = new JTextField(4);
    protected JTextField finalY = new JTextField(4);
    
    public Tela() {
        this.init();
    }
    public JPanel getpainelInicial() {
        if(painelInicial == null){
            painelInicial = new JPanel(new FlowLayout(FlowLayout.CENTER));
            painelInicial.add(pInicial);
            painelInicial.add(initX);
            painelInicial.add(initY);
            painelInicial.setBorder(BorderFactory.createEmptyBorder(300,0,0,0));
        }
        return painelInicial;
    }
    public JPanel getpainelFinal() {
        if(painelFinal == null){
            painelFinal = new JPanel(new FlowLayout(FlowLayout.CENTER));
            painelFinal.add(pFinal);
            painelFinal.add(finalX);
            painelFinal.add(finalY);
            painelFinal.setBorder(BorderFactory.createEmptyBorder(0,8,0,0));

        }
        return painelFinal;
    }
    public JPanel getpValues() {
        if(pValues == null){
            pValues = new JPanel();
            pValues.setLayout(new BoxLayout(pValues, BoxLayout.PAGE_AXIS));
            pValues.add(getpainelInicial());
            pValues.add(getpainelFinal());
            desenhar.setMargin(new Insets(5, 5, 5, 5));
            pValues.add(desenhar);
            pValues.add(name);
            

            
        }
        return pValues;
    }
    private void init() {
        this.setTitle("Computação Gráfica: Trabalho 1");
        this.setSize(840,680);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(getpValues(), BorderLayout.EAST);
    }
}
