package tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela extends JFrame {
    protected JPanel panel = new JPanel();//painel principal
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
    protected ArrayList<Ponto> pontospintar = new ArrayList<>();
    //-----------------------------
    protected JLabel name = new JLabel("by Scarlet Hanna");
    protected JComboBox<String> boxMenu = new JComboBox<String>();
    protected Font font = labelCartesiano.getFont(); // Obtém a fonte atual
    protected Font novaFonte = font.deriveFont(14f); //fonte com tamanho 20
    protected String[] opcoes = {"Bresenham", "Círculos","Curvas","Polilinha","Transformações"};
    protected DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<>(opcoes);
    //-----------------------------
    protected JLabel labelInicial = new JLabel("Ponto Inicial (x,y)");
    protected JTextField textInicial = new JTextField(4);
    protected JLabel labelFinal = new JLabel("Ponto Final (x,y)");
    protected JTextField textFinal = new JTextField(4);
    //-----------------------------
    protected JLabel labelRaio = new JLabel("Raio");
    protected JTextField textRaio = new JTextField(4);
    //-----------------------------
    protected JLabel labelP1 = new JLabel("Ponto de controle 1 (x,y)");
    protected JTextField textP1 = new JTextField(4);
    protected JLabel labelP2 = new JLabel("Ponto de controle 2 (x,y)");
    protected JTextField textP2 = new JTextField(4);
    //-----------------------------
    protected JLabel labelLinha = new JLabel("Ponto (x,y) 1");
    protected JTextField textLinha = new JTextField(4);
    protected JButton adicionar = new JButton("Adicionar");
    protected JButton limpar = new JButton("Limpar");
    protected ArrayList<Ponto> pontos = new ArrayList<>();
    //-----------------------------
    protected JLabel jRecorte = new JLabel("Janela de Recorte");
    protected JLabel cse = new JLabel("Canto Superior Esquerdo:");
    protected JTextField cseText = new JTextField(4);
    protected JLabel cid = new JLabel("Canto Inferior Direito:");
    protected JTextField cidText = new JTextField(4);
    protected JButton recortar = new JButton("Recortar");
    //-----------------------------
    protected JLabel pontoPreencher = new JLabel("Ponto (x,y)");//usado em preenchimento e tranformações
    protected JTextField textPreencher = new JTextField(4);//usado em preenchimento e tranformações
    protected String[] preencher = {"Varredura", "Recursivo"};
    protected JComboBox<String> boxPreencher = new JComboBox<>(preencher);
    protected JButton buttonPreencher = new JButton("Preencher");
    //-----------------------------
    protected JLabel labelRota = new JLabel("Rotação 1");
    protected JLabel labelTranslacao = new JLabel("Translação 2");
    protected JLabel labelEscala = new JLabel("Escala 3");
    protected JLabel labelAngulo = new JLabel("Ângulo");
    protected JTextField textAngulo = new JTextField(4);
    protected JLabel labelDirecao = new JLabel("Direção (x,y)");
    protected JTextField textDirecao = new JTextField(4);
    protected JLabel labelPivo = new JLabel("Pivô (x,y)");
    protected JTextField textPivo = new JTextField(4);
    //
    protected JLabel labelFator = new JLabel("Escala (x,y)");
    protected JTextField textFator = new JTextField(4);
    protected JLabel labelFixo = new JLabel("Ponto Fixo (x,y)");
    protected JTextField textFixo = new JTextField(4);
    //protected JTextField textOrdem = new JTextField(4);
    protected JButton transformar = new JButton("Transformar");
    protected JLabel label3d = new JLabel("Ponto (x,y,z) 1");




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
            
            desenhar.setBounds(10, 340, desenhar.getPreferredSize().width, desenhar.getPreferredSize().height);
            desenhar.setBackground(Color.BLACK);
            desenhar.setForeground(Color.WHITE);
            pEsquerda.add(desenhar);
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
        boxCor.setBounds(612, 480, boxCor.getPreferredSize().width, boxCor.getPreferredSize().height);
        panel.add(boxCor);
    
        boxCor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarCor();
            }
        });
    }

    private void addComboBoxPreencher() {
        boxPreencher.setBounds(10,218, boxPreencher.getPreferredSize().width, boxPreencher.getPreferredSize().height);
        buttonPreencher.setBounds(104, 218, boxPreencher.getPreferredSize().width, boxPreencher.getPreferredSize().height);
        buttonPreencher.setSize(100,buttonPreencher.getPreferredSize().height);
        buttonPreencher.setBackground(Color.WHITE);
        buttonPreencher.setForeground(Color.BLACK);
        pontoPreencher.setBounds(60, 254, pontoPreencher.getPreferredSize().width, pontoPreencher.getPreferredSize().height);
        textPreencher.setBounds(10, 254, textPreencher.getPreferredSize().width, textPreencher.getPreferredSize().height);


        pEsquerda.add(boxPreencher);
        pEsquerda.add(pontoPreencher);
        pEsquerda.add(textPreencher);
        pEsquerda.add(buttonPreencher);
    
        buttonPreencher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarP();
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
        } else if (selectedOption.equals("Azul")){
            corPonto = Color.BLUE;
        } else if (selectedOption.equals("Laranja")){
            corPonto = Color.ORANGE;
        }

        addComboBox();
        pEsquerda.add(labelx);
        pEsquerda.add(desenhar);
        pEsquerda.revalidate();
        pEsquerda.repaint();
    }

    private void mudarP(){
        Component[] components = pEsquerda.getComponents();
        for (Component component : components) {
            if (component != boxPreencher) {
                pEsquerda.remove(component);
            }
        }
        String selecao = (String) boxPreencher.getSelectedItem();
        String pPreencher = textPreencher.getText();

        if(!pPreencher.isEmpty()){
            String[] apPreencher = pPreencher.split(",");
            Ponto pre = new Ponto(Integer.parseInt(apPreencher[0]), Integer.parseInt(apPreencher[1]));
            if(pontoPoligono(pre)){
                if (selecao.equals("Varredura")){
                    Varredura varrer = new Varredura(pontos);
                    plano.pintarPontos(varrer.listapontos, Color.CYAN);
                    plano.pintarPontos(pontospintar,corPonto);
                } else if (selecao.equals("Recursivo")){
                    
                    Recursivo recursivo = new Recursivo(pre, pontospintar,plano.getNumPontos(), corPonto);
                    plano.pintarPontos(recursivo.listapontos, Color.YELLOW);
                    plano.pintarPontos(pontospintar,corPonto);
                }
            }
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
        boxMenu.setBounds(10, 24, boxMenu.getPreferredSize().width, boxMenu.getPreferredSize().height);
        pEsquerda.add(boxMenu);

        // Adicione um ouvinte de alteração de seleção ao JComboBox
        boxMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mudarLabels();
            }
        });
        mudarLabels();
    }

    private void addTransfer() {
        labelRota.setBounds(10, 142, labelRota.getPreferredSize().width, labelRota.getPreferredSize().height);
        labelRota.setForeground(Color.BLACK);
        labelTranslacao.setBounds(160, 142, labelTranslacao.getPreferredSize().width, labelTranslacao.getPreferredSize().height);
        labelTranslacao.setForeground(Color.BLACK);
        labelEscala.setBounds(10, 226, labelEscala.getPreferredSize().width, labelEscala.getPreferredSize().height);
        labelEscala.setForeground(Color.BLACK);
        textAngulo.setBounds(10, 164, textAngulo.getPreferredSize().width, textAngulo.getPreferredSize().height);
        labelAngulo.setBounds(62, 164, labelAngulo.getPreferredSize().width, labelAngulo.getPreferredSize().height);
        textPivo.setBounds(10, 188, textPivo.getPreferredSize().width, textPivo.getPreferredSize().height);
        labelPivo.setBounds(62, 188, labelPivo.getPreferredSize().width, labelPivo.getPreferredSize().height);
        textDirecao.setBounds(160, 164, textDirecao.getPreferredSize().width, textDirecao.getPreferredSize().height);
        labelDirecao.setBounds(212, 164, labelDirecao.getPreferredSize().width, labelDirecao.getPreferredSize().height);
        textFator.setBounds(10, 248, textFator.getPreferredSize().width, textFator.getPreferredSize().height);
        labelFator.setBounds(62, 248, labelFator.getPreferredSize().width, labelFator.getPreferredSize().height);
        textFixo.setBounds(10, 272, textFixo.getPreferredSize().width, textFixo.getPreferredSize().height);
        labelFixo.setBounds(62, 272, labelFixo.getPreferredSize().width, labelFixo.getPreferredSize().height);
        //textOrdem.setBounds(220, 272, textOrdem.getPreferredSize().width, textOrdem.getPreferredSize().height);
        transformar.setBounds(190, 260, transformar.getPreferredSize().width, transformar.getPreferredSize().height);
        transformar.setBackground(Color.WHITE);
        transformar.setForeground(Color.BLACK);
        

        pEsquerda.add(labelRota);
        pEsquerda.add(labelTranslacao);
        pEsquerda.add(labelEscala);
        pEsquerda.add(textAngulo);
        pEsquerda.add(labelAngulo);
        pEsquerda.add(textDirecao);
        pEsquerda.add(labelDirecao);
        pEsquerda.add(textPivo);
        pEsquerda.add(labelPivo);
        pEsquerda.add(textFator);
        pEsquerda.add(labelFator);
        pEsquerda.add(textFixo);
        pEsquerda.add(labelFixo);
        //pEsquerda.add(textOrdem);
        pEsquerda.add(transformar);

        transformar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Transformar trns = new Transformar();
                String pontoAngulo = textAngulo.getText();
                String pontoDirecao = textDirecao.getText();
                String pontoFator = textFator.getText();
                ArrayList<Ponto> aux = new ArrayList<>();
                plano.limparPontos();
                aux.clear();
                aux.addAll(pontospintar);
                pontospintar.clear();
                
                if(!pontoAngulo.isEmpty()){
                    String pontoPivo = textPivo.getText();
                    String[] pontoAPivo = pontoPivo.split(",");
                    pontospintar = trns.Rotacionar(pontos, pontoAPivo, pontoAngulo);
                    plano.pintarPontos(pontospintar, corPonto);
                } else if(!pontoDirecao.isEmpty()){
                    String[] pontoADirecao = pontoDirecao.split(",");
                    pontospintar = trns.Transladar(aux,pontoADirecao);
                    plano.pintarPontos(pontospintar, corPonto);
                } else if(!pontoFator.isEmpty()){
                    String[] pontoAFator = pontoFator.split("\\s*,\\s*");
                    String pontoFixo = textFixo.getText();
                    String[] pontoAFixo = pontoFixo.split(",");
                    pontospintar = trns.Escalar(pontos,pontoAFator,pontoAFixo);
                    plano.pintarPontos(pontospintar, corPonto);
                }
            }
        });
        
    }

    private void addLinhas() {
        // Configurar a posição dos labels e text fields
        labelInicial.setText("Ponto Inicial (x,y)");
        labelInicial.setBounds(62, 62, labelInicial.getPreferredSize().width, labelInicial.getPreferredSize().height);
        textInicial.setBounds(10, 62, textInicial.getPreferredSize().width, textInicial.getPreferredSize().height);
        labelFinal.setBounds(62, 86, labelFinal.getPreferredSize().width, labelFinal.getPreferredSize().height);
        textFinal.setBounds(10, 86, textFinal.getPreferredSize().width, textFinal.getPreferredSize().height);


        pEsquerda.add(labelInicial);
        pEsquerda.add(textInicial);
        pEsquerda.add(labelFinal);
        pEsquerda.add(textFinal);
    }

    private void addPolis() { // pontos
        labelLinha.setBounds(62, 62, labelLinha.getPreferredSize().width, labelLinha.getPreferredSize().height);
        labelLinha.setSize(90,labelLinha.getPreferredSize().height);
        textLinha.setBounds(10, 62, textLinha.getPreferredSize().width, textLinha.getPreferredSize().height);
        adicionar.setBounds(10, 88, adicionar.getPreferredSize().width, adicionar.getPreferredSize().height);
        adicionar.setBackground(Color.WHITE);
        adicionar.setForeground(Color.BLACK);
        
        pEsquerda.add(labelLinha);pEsquerda.add(textLinha);
        pEsquerda.add(adicionar);

        limpar.setBounds(106, 88, limpar.getPreferredSize().width, limpar.getPreferredSize().height);
        limpar.setBackground(Color.WHITE);
        limpar.setForeground(Color.BLACK);
        pEsquerda.add(limpar);

        adicionar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String pontoLinha = textLinha.getText();
                String[] pontoA = pontoLinha.split(",");
                if(!pontoLinha.isEmpty() && pontos.size() < 10){
                    int xInicial = Integer.parseInt(pontoA[0]);
                    int xFinal = Integer.parseInt(pontoA[1]);
                    pontos.add(new Ponto(xInicial,xFinal));
                    String contar = String.valueOf(pontos.size()+1);
                    if(pontos.size() < 10){
                        labelLinha.setText("Ponto (x,y) "+contar);
                    }
                    textLinha.setText("");
                }
            }
        });
        limpar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pontos.clear();
                labelLinha.setText("Ponto (x,y) 1");
            }
        });
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
        String selecao = (String) boxMenu.getSelectedItem();
        // Adicionar labels e text fields com base na opção selecionada
        if (selecao.equals("Bresenham")) {
           addLinhas();
        } else if (selecao.equals("Círculos")) {
            // centro e raio
            labelInicial.setText("Centro (x,y)");
            labelInicial.setBounds(62, 62, labelInicial.getPreferredSize().width, labelInicial.getPreferredSize().height);
            textInicial.setBounds(10, 62, textInicial.getPreferredSize().width, textInicial.getPreferredSize().height);
            labelRaio.setBounds(62, 86, labelRaio.getPreferredSize().width, labelRaio.getPreferredSize().height);
            textRaio.setBounds(10, 86, textRaio.getPreferredSize().width, textRaio.getPreferredSize().height);

            pEsquerda.add(labelInicial);
            pEsquerda.add(textInicial);
            pEsquerda.add(labelRaio);
            pEsquerda.add(textRaio);
        } else if (selecao.equals("Curvas")) {
            addLinhas();
            labelP1.setBounds(62, 112, labelP1.getPreferredSize().width, labelP1.getPreferredSize().height);
            textP1.setBounds(10, 112, textP1.getPreferredSize().width, textP1.getPreferredSize().height);
            labelP2.setBounds(62, 136, labelP2.getPreferredSize().width, labelP2.getPreferredSize().height);
            textP2.setBounds(10, 136, textP2.getPreferredSize().width, textP2.getPreferredSize().height);

            pEsquerda.add(labelP1); pEsquerda.add(textP1);
            pEsquerda.add(labelP2); pEsquerda.add(textP2);
        } else if (selecao.equals("Polilinha")) {
            addPolis();
            addComboBoxPreencher();
        } else if (selecao.equals("Transformações")) {
            addPolis();
            addTransfer();
        }
        
        pEsquerda.add(labelx);
        //pEsquerda.add(name);
        pEsquerda.add(desenhar);
        recortar();
        //addComboBoxCor();
        pEsquerda.revalidate();
        pEsquerda.repaint();
    }

    private void recortar(){
            jRecorte.setBounds(10, 428, jRecorte.getPreferredSize().width, jRecorte.getPreferredSize().height);
            jRecorte.setForeground(Color.BLACK);
            cse.setBounds(10, 452, cse.getPreferredSize().width, cse.getPreferredSize().height);
            cseText.setBounds(166, 452, cseText.getPreferredSize().width, cseText.getPreferredSize().height);
            cid.setBounds(10, 476, cid.getPreferredSize().width, cid.getPreferredSize().height);
            cidText.setBounds(166, 476, cidText.getPreferredSize().width, cidText.getPreferredSize().height);
            recortar.setBounds(220, 462,recortar.getPreferredSize().width, recortar.getPreferredSize().height); 
            recortar.setBackground(Color.WHITE);
            recortar.setForeground(Color.BLACK);

            pEsquerda.add(jRecorte);
            pEsquerda.add(cse);
            pEsquerda.add(cseText);
            pEsquerda.add(cid);
            pEsquerda.add(cidText);
            pEsquerda.add(recortar);

            recortar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String prString1 = cseText.getText();
                    String prString2 = cidText.getText();
                    String[] p1 = prString1.split(",");
                    String[] p2 = prString2.split(",");
                    if(p1.length == 2 && p2.length == 2){
                        
                        Ponto pr1 = new Ponto(Integer.parseInt(p1[0]), Integer.parseInt(p1[1]));
                        Ponto pr2 = new Ponto(Integer.parseInt(p2[0]), Integer.parseInt(p2[1]));
                        plano.Recorte(pr1,pr2,corPonto);
                        plano.recorte = true;
                    }
                    else{
                        plano.recorte = false;
                        plano.pintar.clear();
                    }
                   
                }
            });
    }

    private void pintar(ArrayList<Ponto> pontos, Color color){
        pontospintar = pontos;
        plano.pintarPontos(pontos,color);
    }
    public boolean pontoPoligono(Ponto ponto) {
        int numIntersecoes = 0;
        int numPontos = pontospintar.size();

        for (int i = 0, j = numPontos - 1; i < numPontos; j = i++) {
            Ponto pontoI = pontospintar.get(i);
            Ponto pontoJ = pontospintar.get(j);

            if ((pontoI.getY() > ponto.getY()) != (pontoJ.getY() > ponto.getY()) && (ponto.getX() < (pontoJ.getX() - pontoI.getX()) * (ponto.getY() - pontoI.getY()) /
                (pontoJ.getY() - pontoI.getY()) + pontoI.getX())) {
                numIntersecoes++;
            }
        }

        return numIntersecoes % 2 == 1;
    }
    private void desenhar() {
        String selecao = (String) boxMenu.getSelectedItem();
        plano.limparPontos();
        
        if (selecao.equals("Bresenham")) {
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
                pintar(bresenham.listapontos, corPonto);
            
            }
        } else if (selecao.equals("Círculos")) {
            String centro = textInicial.getText();
            String raio = textRaio.getText();
            String[] centroS = centro.split(",");
            if (centroS.length >= 2 && raio != null) {
                int centroX = Integer.parseInt(centroS[0]);
                int centroY = Integer.parseInt(centroS[1]);
                int raioInt = Integer.parseInt(raio);
                Ponto pCentro = new Ponto(centroX, centroY);
                Circulo circulo = new Circulo(raioInt, pCentro);
                
                pintar(circulo.listapontos, corPonto);
                plano.pintarPonto(centroX,centroY,Color.BLACK);
            
            }
        } else if (selecao.equals("Curvas")) {
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
                
                pintar(curvas.listapontos, corPonto);
                plano.pintarPonto(p1X,p1Y,Color.BLACK);
                plano.pintarPonto(p2X,p2Y,Color.BLACK);
            
            } 
        } else if (selecao.equals("Polilinha")) {
            if (!pontos.isEmpty() && pontos.size() > 2) {
                Polilinhas poli = new Polilinhas(pontos);
                pintar(poli.listapontos, corPonto);
                
            } 
            
        } else if (selecao.equals("Transformações")) {
            if (!pontos.isEmpty() && pontos.size() > 2) {
                Polilinhas poli = new Polilinhas(pontos);
                pintar(poli.listapontos, corPonto);
                
            } 
            
        }
    }
    private void init() {
        this.setTitle("Computação Gráfica: Trabalho 1");
        this.setSize(820, 540);
        this.getContentPane().setLayout(new BorderLayout());
        panel.setLayout(new BorderLayout());
        this.setResizable(false);
        labelCartesiano.setFont(novaFonte);
        labelCartesiano.setBounds(392,4,labelCartesiano.getPreferredSize().width,labelCartesiano.getPreferredSize().height);
        labely.setBounds(576, 430, labely.getPreferredSize().width, labely.getPreferredSize().height);
        panel.add(labelCartesiano);
        panel.add(labely);
        name.setBounds(708, 490, name.getPreferredSize().width, name.getPreferredSize().height);
        panel.add(name);
        addComboBoxCor();
        panel.add(getpDireita(), BorderLayout.EAST);
        panel.add(getpEsquerda());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
}