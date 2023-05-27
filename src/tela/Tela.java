package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela extends JFrame {
    protected JButton desenhar = new JButton("Desenhar");
    protected JPanel pDireita;
    protected JPanel pEsquerda;
    protected PlanoCartesiano plano;
    protected JPanel painelInicial;
    protected JPanel painelFinal;
    protected JLabel labelCartesiano = new JLabel("Plano Cartesiano [40x40]");
    protected JLabel labelx = new JLabel("Eixo X");
    protected JLabel labely = new JLabel("Eixo Y");
    protected Color corPonto = Color.RED; //default cor, vermelho
    protected String[] cores = {"Vermelho", "Verde", "Azul", "Laranja"};
    protected JComboBox<String> boxCor = new JComboBox<>(cores);
    //-----------------------------
    protected JLabel name = new JLabel("by Scarlet Hanna");
    protected JComboBox<String> boxMenu = new JComboBox<String>();
    protected Font font = labelCartesiano.getFont(); // Obtém a fonte atual
    protected Font novaFonte = font.deriveFont(14f); //fonte com tamanho 20
    protected String[] opcoes = {"Bresenham", "Círculos","Curvas","Polilinha"};
    protected DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(opcoes);
    //-----------------------------
    protected JLabel labelInicial = new JLabel("Ponto Inicial(x,y):");
    protected JTextField textInicial = new JTextField(4);
    protected JLabel labelFinal = new JLabel("Ponto Final(x,y):");
    protected JTextField textFinal = new JTextField(4);
    //-----------------------------
    protected JLabel labelCentro = new JLabel("Centro(x,y):");
    protected JTextField textCentro = new JTextField(4);
    protected JLabel labelRaio = new JLabel("Raio:");
    protected JTextField textRaio = new JTextField(4);
    //-----------------------------
    protected JLabel labelP1 = new JLabel("Ponto de controle 1(x,y):");
    protected JTextField textP1 = new JTextField(4);
    protected JLabel labelP2 = new JLabel("Ponto de controle 2(x,y):");
    protected JTextField textP2 = new JTextField(4);
    //-----------------------------
    protected JLabel labelLinha = new JLabel("Ponto 1:");
    protected JTextField textLinha = new JTextField(4);
    protected JButton adicionar = new JButton("+");
    protected ArrayList<Ponto> pontos = new ArrayList<>();
    //-----------------------------
    protected JLabel cse = new JLabel("Canto Superior Esquerdo:");
    protected JTextField cseText = new JTextField(4);
    protected JLabel cid = new JLabel("Canto Inferior Direito:");
    protected JTextField cidText = new JTextField(4);
    protected JButton recortar = new JButton("Recorte");


    public Tela() {
        this.init();
    }

    public JPanel getPlano() {
        if (plano == null) {
            plano = new PlanoCartesiano(40, 10);
            plano.setPreferredSize(new Dimension(getWidth() / 2, getHeight()-108));
            plano.setBounds(30, 0, plano.getPreferredSize().width, plano.getPreferredSize().height);
        }
        return plano;
    }

    public JPanel getpainelInicial() {
        if (painelInicial == null) {
            painelInicial = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));
            painelInicial.setPreferredSize(new Dimension(0, 200));
            painelInicial.add(pInicial);
            painelInicial.add(initX);
            painelInicial.add(initY);
            
        return painelInicial;
    }

    public JPanel getpainelFinal() {
        if (painelFinal == null) {
            painelFinal = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 40));
            painelFinal.add(pFinal);
            painelFinal.add(finalX);
            painelFinal.add(finalY);
            painelFinal.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        }
        return painelFinal;
    }

    public JPanel getpEsquerda() {
        if (pEsquerda == null) {
            pEsquerda = new JPanel();
            pEsquerda.setLayout(null);


           
            addComboBox();
            labelx.setBounds(346, 218, labelx.getPreferredSize().width, labelx.getPreferredSize().height);
            pEsquerda.add(labelx);
            
            desenhar.setBounds(30, 300, desenhar.getPreferredSize().width, desenhar.getPreferredSize().height);
            pEsquerda.add(desenhar);
            
            // Adicione o nome
            name.setBounds(2, 460, name.getPreferredSize().width, name.getPreferredSize().height);
            addComboBoxCor();
            pEsquerda.add(name);

                    
            pEsquerda.setPreferredSize(new Dimension(200, 100));

            desenhar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    desenhar();
                }
            });
            
        }
        return pEsquerda;
    }


    public JPanel getpDireita() {
        if (pDireita == null) {
            pDireita = new JPanel();
            pDireita.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 26));
            pDireita.add(getPlano());
        }
        return pDireita;
    }

    private void addComboBoxCor() {
        
    
        boxCor.setBounds(114, 450, boxCor.getPreferredSize().width, boxCor.getPreferredSize().height);
        pEsquerda.add(boxCor);
    
        boxCor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarCor();
            }
        });
    }

    private void mudarCor(){
        Component[] components = pEsquerda.getComponents();
        for (Component component : components) {
            if (component != boxCor) {
                pEsquerda.remove(component);
            }
        }
        String selectedOption = (String) boxCor.getSelectedItem();

        if (selectedOption.equals("Vermelho")){
            corPonto = Color.RED;
        } else if (selectedOption.equals("Verde")){
            corPonto = Color.GREEN;
            plano.Recorte(new Ponto(-10,10), new Ponto(13,0),Color.GRAY);
            plano.recorte = true;
        } else if (selectedOption.equals("Azul")){
            corPonto = Color.BLUE;
        } else if (selectedOption.equals("Laranja")){
            corPonto = Color.ORANGE;
        }

        addComboBox();
        pEsquerda.add(labelx);
        pEsquerda.add(desenhar);
        pEsquerda.add(name);
        //addComboBoxCor();
        pEsquerda.revalidate();
        pEsquerda.repaint();
    }
    

    private void addComboBox() {
        boxMenu.setModel(boxModel);
        boxMenu.setBounds(10, 40, boxMenu.getPreferredSize().width, boxMenu.getPreferredSize().height);
        pEsquerda.add(boxMenu);

        // Adicione um ouvinte de alteração de seleção ao JComboBox
        boxMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarLabels();
            }
        });

        // Chame o método mudarLabels() para configurar os componentes iniciais
        mudarLabels();
    }

    private void mudarLabels() {
        // Remova todos os componentes do painel esquerdo, exceto o JComboBox
        Component[] components = pEsquerda.getComponents();
        for (Component component : components) {
            if (component != boxMenu) {
                pEsquerda.remove(component);
            }
        }

        // Obtenha a opção selecionada do JComboBox
        String selectedOption = (String) boxMenu.getSelectedItem();

        // Adicionar labels e text fields com base na opção selecionada
        if (selectedOption.equals("Bresenham")) {
            // Configurar a posição dos labels e text fields
            labelInicial.setBounds(10, 110, labelInicial.getPreferredSize().width, labelInicial.getPreferredSize().height);
            textInicial.setBounds(120, 110, textInicial.getPreferredSize().width, textInicial.getPreferredSize().height);
            labelFinal.setBounds(10, 134, labelFinal.getPreferredSize().width, labelFinal.getPreferredSize().height);
            textFinal.setBounds(120, 134, textFinal.getPreferredSize().width, textFinal.getPreferredSize().height);


            pEsquerda.add(labelInicial);
            pEsquerda.add(textInicial);
            pEsquerda.add(labelFinal);
            pEsquerda.add(textFinal);
        } else if (selectedOption.equals("Círculos")) {
            
            
            // centro e raio
            labelCentro.setBounds(10, 110, labelCentro.getPreferredSize().width, labelCentro.getPreferredSize().height);
            textCentro.setBounds(80, 110, textCentro.getPreferredSize().width, textCentro.getPreferredSize().height);
            labelRaio.setBounds(10, 134, labelRaio.getPreferredSize().width, labelRaio.getPreferredSize().height);
            textRaio.setBounds(80, 134, textRaio.getPreferredSize().width, textRaio.getPreferredSize().height);

            
            pEsquerda.add(labelCentro);
            pEsquerda.add(textCentro);
            pEsquerda.add(labelRaio);
            pEsquerda.add(textRaio);
        } else if (selectedOption.equals("Curvas")) {
            textInicial.setText("");
            textFinal.setText("");

            // ponto inicial, final, e pontos de controle
            labelInicial.setBounds(10, 110, labelInicial.getPreferredSize().width, labelInicial.getPreferredSize().height);
            textInicial.setBounds(120, 110, textInicial.getPreferredSize().width, textInicial.getPreferredSize().height);
            labelFinal.setBounds(10, 134, labelFinal.getPreferredSize().width, labelFinal.getPreferredSize().height);
            textFinal.setBounds(120, 134, textFinal.getPreferredSize().width, textFinal.getPreferredSize().height);

            labelP1.setBounds(10, 160, labelP1.getPreferredSize().width, labelP1.getPreferredSize().height);
            textP1.setBounds(158, 160, textP1.getPreferredSize().width, textP1.getPreferredSize().height);
            labelP2.setBounds(10, 184, labelP2.getPreferredSize().width, labelP2.getPreferredSize().height);
            textP2.setBounds(158, 184, textP2.getPreferredSize().width, textP2.getPreferredSize().height);


            
            pEsquerda.add(labelInicial);pEsquerda.add(textInicial);
            pEsquerda.add(labelFinal);pEsquerda.add(textFinal);
            pEsquerda.add(labelP1);pEsquerda.add(textP1);
            pEsquerda.add(labelP2);pEsquerda.add(textP2);
        } else if (selectedOption.equals("Polilinha")) {
            labelLinha.setText("Ponto 1:");
            pontos.clear();
            
            // pontos
            labelLinha.setBounds(10, 110, labelLinha.getPreferredSize().width, labelLinha.getPreferredSize().height);
            textLinha.setBounds(72, 110, textLinha.getPreferredSize().width, textLinha.getPreferredSize().height);
            adicionar.setBounds(132, 106, adicionar.getPreferredSize().width, adicionar.getPreferredSize().height);
            
            pEsquerda.add(labelLinha);pEsquerda.add(textLinha);
            pEsquerda.add(adicionar);

            adicionar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String pontoLinha = textLinha.getText();
                    String[] pontoA = pontoLinha.split(",");
                    if(!pontoLinha.isEmpty() && pontos.size() < 8){
                        int xInicial = Integer.parseInt(pontoA[0]);
                        int xFinal = Integer.parseInt(pontoA[1]);
                        pontos.add(new Ponto(xInicial,xFinal));
                        String contar = String.valueOf(pontos.size()+1);
                        if(pontos.size() < 9){
                            labelLinha.setText("Ponto "+contar+":");
                        }
                        
                        textLinha.setText("");
                    }
                }
            });
        }

        // Atualiza o layout do painel esquerdo
        pEsquerda.add(desenhar);
        pEsquerda.add(labelx);
        pEsquerda.add(name);
        addComboBoxCor();
        pEsquerda.revalidate();
        pEsquerda.repaint();
    }

    private void desenhar() {
        String selectedOption = (String) boxMenu.getSelectedItem();
        plano.limparPontos();
    
        if (selectedOption.equals("Bresenham")) {
            
            String inicialS = textInicial.getText();
            String finalS = textFinal.getText();
            String[] valorInicial = inicialS.split(",");
            String[] valorFinal = finalS.split(",");
           

            if (valorInicial.length >= 2 && valorFinal.length >= 2) {
                int xInicial = Integer.parseInt(valorInicial[0]);
                int xFinal = Integer.parseInt(valorInicial[1]);
                int yInicial = Integer.parseInt(valorFinal[0]);
                int yFinal = Integer.parseInt(valorFinal[1]);
                Ponto p1 = new Ponto(xInicial,xFinal);
                Ponto p2 = new Ponto(yInicial,yFinal);
                Bresenham bresenham = new Bresenham(p1, p2);
                plano.pintarPontos(bresenham.listapontos, corPonto);
            
            }
        } else if (selectedOption.equals("Círculos")) {
            String centro = textCentro.getText();
            String raio = textRaio.getText();
            String[] centroS = centro.split(",");
            
            if (centroS.length >= 2 && raio != null) {
                int centroX = Integer.parseInt(centroS[0]);
                int centroY = Integer.parseInt(centroS[1]);
                int raioInt = Integer.parseInt(raio);
                Ponto pCentro = new Ponto(centroX, centroY);
                Circulo circulo = new Circulo(raioInt, pCentro);

                plano.pintarPonto(centroX,centroY,Color.BLACK);
                plano.pintarPontos(circulo.listapontos, corPonto);
            
            }
            
        } else if (selectedOption.equals("Curvas")) {
            String inicialS = textInicial.getText();
            String finalS = textFinal.getText();
            String[] valorInicial = inicialS.split(",");
            String[] valorFinal = finalS.split(",");

            String p1S = textP1.getText();
            String p2S = textP2.getText();
            String[] p1 = p1S.split(",");
            String[] p2 = p2S.split(",");
            
            if (valorInicial.length >= 2 && valorFinal.length >= 2 && p1.length >= 2 && p2.length >= 2) {
                int xInicial = Integer.parseInt(valorInicial[0]);
                int xFinal = Integer.parseInt(valorInicial[1]);
                int yInicial = Integer.parseInt(valorFinal[0]);
                int yFinal = Integer.parseInt(valorFinal[1]);

                int p1X = Integer.parseInt(p1[0]);
                int p1Y = Integer.parseInt(p1[1]);
                int p2X = Integer.parseInt(p2[0]);
                int p2Y = Integer.parseInt(p2[1]);
                Ponto pInicial = new Ponto(xInicial, xFinal);
                Ponto pFinal = new Ponto(yInicial, yFinal);
                Ponto ponto1 = new Ponto(p1X, p1Y);
                Ponto ponto2 = new Ponto(p2X, p2Y);
                Curvas curvas = new Curvas(pInicial, ponto1, ponto2, pFinal);
                
                plano.pintarPontos(curvas.listapontos, corPonto);
                plano.pintarPonto(p1X,p1Y,Color.BLACK);
                plano.pintarPonto(p2X,p2Y,Color.BLACK);
            
            }
            
            
        }
        else if (selectedOption.equals("Polilinha")) {
            
            if (!pontos.isEmpty() && pontos.size() >= 3) {
                Polilinhas poli = new Polilinhas(pontos);
                
                plano.pintarPontos(poli.listapontos, corPonto);
                plano.pintarPontos(pontos, Color.BLACK);
            } 
        }
    }
    private void init() {
        this.setTitle("Computação Gráfica: Trabalho 1");
        this.setSize(820, 510);
        this.getContentPane().setLayout(new BorderLayout());
    
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.setResizable(false);
        labelCartesiano.setFont(novaFonte);
        labelCartesiano.setBounds(392,4,labelCartesiano.getPreferredSize().width,labelCartesiano.getPreferredSize().height);
        labely.setBounds(576, 434, labely.getPreferredSize().width, labely.getPreferredSize().height);
        panel.add(labelCartesiano);
        panel.add(labely);
        panel.add(getpDireita(), BorderLayout.EAST);
        panel.add(getpEsquerda());
        
    
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
}