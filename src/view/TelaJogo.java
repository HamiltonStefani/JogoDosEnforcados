package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.BancoDePalavras;
import model.Jogador;

// TODO: Auto-generated Javadoc
/**
 * The Class TelaJogo.
 */
public class TelaJogo extends javax.swing.JFrame {

    /** The tela inicio. */
    Inicio telaInicio;
    
    /** The jogador. */
    private Jogador jogador;
    
    /** The banco de palavras. */
    BancoDePalavras bancoDePalavras = new BancoDePalavras();
    
    /** The palavra sorteada. */
    String palavraSorteada;
    
    /** The palavra com tracinhos. */
    char[] palavraComTracinhos;
    
    /** The quantidade erros. */
    int quantidadeErros = 0;
    
    /** The palavra sem espaco. */
    ArrayList<String> palavraSemEspaco;
    
    /** The letras atuais. */
    String letrasAtuais = "";

    /**
     * Instantiates a new tela jogo.
     */
    public TelaJogo() {
        initComponents();
        fazerEnforcadoDesaparecer();
    }

    /**
     * Voltar tela inicial.
     */
    public void voltarTelaInicial() {
        telaInicio = new Inicio();
        telaInicio.setVisible(true);
        dispose();
    }

    /**
     * Definir nome jogador.
     *
     * @param nome the nome
     */
    public void definirNomeJogador(String nome) {
        if (nome.trim().equals("")) {
            nome = "SEM NOME";
        }
        jogador = new Jogador(nome);
        txtNomeJogador.setText(jogador.getNome());
    }

    /**
     * Definir tema.
     *
     * @param temaEscolhido the tema escolhido
     */
    public void definirTema(String temaEscolhido) {
        palavraSorteada = bancoDePalavras.sortearPalavra(temaEscolhido);
        palavraComTracinhos = new char[palavraSorteada.length()];
        palavraSemEspaco = new ArrayList<>();
        preencherPalavraSemEspaco(palavraSorteada);

        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (palavraSorteada.charAt(i) != ' ') {
                palavraComTracinhos[i] = '_';
            } else {
                palavraComTracinhos[i] = ' ';
            }
        }

        txtTema.setText(temaEscolhido);
        lblPalavra.setText(exibirTracinhos(palavraComTracinhos));
    }

    /**
     * Preencher palavra sem espaco.
     *
     * @param palavraSorteada the palavra sorteada
     */
    public void preencherPalavraSemEspaco(String palavraSorteada) {
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (palavraSorteada.charAt(i) != ' ') {
                palavraSemEspaco.add(palavraSorteada.charAt(i) + "");
            }
        }
    }

    /**
     * Exibir tracinhos.
     *
     * @param palavraComTracinhos the palavra com tracinhos
     * @return the string
     */
    public String exibirTracinhos(char[] palavraComTracinhos) {
        String tracinhos = "";
        for (int i = 0; i < palavraComTracinhos.length; i++) {
            tracinhos += palavraComTracinhos[i] + " ";
        }
        return tracinhos;
    }

    /**
     * Atualizar palavra.
     *
     * @param letra the letra
     */
    public void atualizarPalavra(char letra) {
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if (palavraSorteada.charAt(i) == letra) {
                palavraComTracinhos[i] = letra;
            }
        }
    }

    /**
     * Verificar vitoria.
     *
     * @return true, if successful
     */
    public boolean verificarVitoria() {
        int contador = 0;
        for (int i = 0; i < palavraComTracinhos.length; i++) {
            if (palavraComTracinhos[i] != '_' && palavraComTracinhos[i] != ' ') {
                contador++;
            }
        }
        return contador == palavraSemEspaco.size();
    }

    /**
     * Verificar quantidade erros.
     *
     * @param letra the letra
     */
    public void verificarQuantidadeErros(String letra) {
        if (!palavraSorteada.contains(letra)) {
            quantidadeErros++;
            exibirEnforcado(quantidadeErros);
        }
    }

    /**
     * Exibir enforcado.
     *
     * @param quantidadeErros the quantidade erros
     */
    public void exibirEnforcado(int quantidadeErros) {
        switch (quantidadeErros) {
            case 1:
                enforcado1.setVisible(true);
                break;
            case 2:
                enforcado2.setVisible(true);
                break;
            case 3:
                enforcado3.setVisible(true);
                break;
            case 4:
                enforcado4.setVisible(true);
                break;
            case 5:
                enforcado5.setVisible(true);
                break;
            case 6:
                enforcado6.setVisible(true);
                JOptionPane.showMessageDialog(null, "VOCÊ PERDEU!", "PERDEU", JOptionPane.INFORMATION_MESSAGE);
                voltarTelaInicial();
                break;
        }
    }

    /**
     * Jogar.
     *
     * @param letra the letra
     */
    private void jogar(String letra) {
        letrasAtuais += letra;

        lblPalavra.setText(exibirTracinhos(palavraComTracinhos));
        if (verificarVitoria()) {
            JOptionPane.showMessageDialog(null, "PARABÉNS " + jogador.getNome() + ", VOCÊ GANHOU!", "GANHOU!", JOptionPane.INFORMATION_MESSAGE);
            voltarTelaInicial();
        } else {
            verificarQuantidadeErros(letra);
        }
    }

    /**
     * Fazer enforcado desaparecer.
     */
    public void fazerEnforcadoDesaparecer() {
        enforcado1.setVisible(false);
        enforcado2.setVisible(false);
        enforcado3.setVisible(false);
        enforcado4.setVisible(false);
        enforcado5.setVisible(false);
        enforcado6.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTema = new javax.swing.JLabel();
        lblTema = new javax.swing.JLabel();
        btnZ = new javax.swing.JButton();
        btnY = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnW = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        btnU = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnR = new javax.swing.JButton();
        btnQ = new javax.swing.JButton();
        btnP = new javax.swing.JButton();
        btnO = new javax.swing.JButton();
        btnN = new javax.swing.JButton();
        btnM = new javax.swing.JButton();
        btnL = new javax.swing.JButton();
        btnK = new javax.swing.JButton();
        btnJ = new javax.swing.JButton();
        btnI = new javax.swing.JButton();
        btnH = new javax.swing.JButton();
        btnG = new javax.swing.JButton();
        btnF = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        btnD = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        lblPalavra = new javax.swing.JLabel();
        txtNomeJogador = new javax.swing.JLabel();
        lblJogador = new javax.swing.JLabel();
        enforcado6 = new javax.swing.JLabel();
        enforcado5 = new javax.swing.JLabel();
        enforcado4 = new javax.swing.JLabel();
        enforcado3 = new javax.swing.JLabel();
        enforcado2 = new javax.swing.JLabel();
        enforcado1 = new javax.swing.JLabel();
        enforcado0 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Forca");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTema.setFont(new java.awt.Font("Arial", 0, 18)); 
        txtTema.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTema.setToolTipText("");
        getContentPane().add(txtTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 190, 20));

        lblTema.setFont(new java.awt.Font("Arial", 0, 18)); 
        lblTema.setText("TEMA:");
        getContentPane().add(lblTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        btnZ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraZ.png"))); 
        btnZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZActionPerformed(evt);
            }
        });
        getContentPane().add(btnZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 30, 30));

        btnY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraY.png"))); 
        btnY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYActionPerformed(evt);
            }
        });
        getContentPane().add(btnY, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, 30, 30));

        btnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraX.png"))); 
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });
        getContentPane().add(btnX, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 30, 30));

        btnW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraW.png"))); 
        btnW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWActionPerformed(evt);
            }
        });
        getContentPane().add(btnW, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 30, 30));

        btnV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraV.png"))); 
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });
        getContentPane().add(btnV, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 30, 30));

        btnU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraU.png"))); 
        btnU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUActionPerformed(evt);
            }
        });
        getContentPane().add(btnU, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 30, 30));

        btnT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraT.png"))); 
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });
        getContentPane().add(btnT, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 30, 30));

        btnS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraS.png"))); 
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });
        getContentPane().add(btnS, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 30, 30));

        btnR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraR.png"))); 
        btnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRActionPerformed(evt);
            }
        });
        getContentPane().add(btnR, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 30, 30));

        btnQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraQ.png"))); 
        btnQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQActionPerformed(evt);
            }
        });
        getContentPane().add(btnQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 30, 30));

        btnP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraP.png"))); 
        btnP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPActionPerformed(evt);
            }
        });
        getContentPane().add(btnP, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 30, 30));

        btnO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraO.png"))); 
        btnO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOActionPerformed(evt);
            }
        });
        getContentPane().add(btnO, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 30, 30));

        btnN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraN.png"))); 
        btnN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNActionPerformed(evt);
            }
        });
        getContentPane().add(btnN, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 30, 30));

        btnM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraM.png"))); 
        btnM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMActionPerformed(evt);
            }
        });
        getContentPane().add(btnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 30, 30));

        btnL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraL.png"))); 
        btnL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLActionPerformed(evt);
            }
        });
        getContentPane().add(btnL, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 30, 30));

        btnK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraK.png"))); 
        btnK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKActionPerformed(evt);
            }
        });
        getContentPane().add(btnK, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 30, 30));

        btnJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraJ.png"))); 
        btnJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJActionPerformed(evt);
            }
        });
        getContentPane().add(btnJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 30, 30));

        btnI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraI.png"))); 
        btnI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIActionPerformed(evt);
            }
        });
        getContentPane().add(btnI, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 30, 30));

        btnH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraH.png"))); 
        btnH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHActionPerformed(evt);
            }
        });
        getContentPane().add(btnH, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 140, 30, 30));

        btnG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraG.png"))); 
        btnG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGActionPerformed(evt);
            }
        });
        getContentPane().add(btnG, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 30, 30));

        btnF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraF.png"))); 
        btnF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFActionPerformed(evt);
            }
        });
        getContentPane().add(btnF, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 30, 30));

        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraE.png"))); 
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });
        getContentPane().add(btnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 30, 30));

        btnD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraD.png"))); 
        btnD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDActionPerformed(evt);
            }
        });
        getContentPane().add(btnD, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 30, 30));

        btnC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraC.png"))); 
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });
        getContentPane().add(btnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 30, 30));

        btnB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraB.png"))); 
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });
        getContentPane().add(btnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 30, 30));

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letraA.png"))); 
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        getContentPane().add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 30, 30));

        lblPalavra.setFont(new java.awt.Font("Arial", 0, 18)); 
        lblPalavra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblPalavra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 490, 40));

        txtNomeJogador.setFont(new java.awt.Font("Arial", 0, 18)); 
        txtNomeJogador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(txtNomeJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 190, 20));

        lblJogador.setFont(new java.awt.Font("Arial", 0, 18)); 
        lblJogador.setText("JOGADOR:");
        getContentPane().add(lblJogador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 100, 20));

        enforcado6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado6.png"))); 
        getContentPane().add(enforcado6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        enforcado5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado5.png"))); 
        getContentPane().add(enforcado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        enforcado4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado4.png"))); 
        getContentPane().add(enforcado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        enforcado3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado3.png"))); 
        getContentPane().add(enforcado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        enforcado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado2.png"))); 
        getContentPane().add(enforcado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        enforcado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado1.png"))); 
        getContentPane().add(enforcado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        enforcado0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/enforcado0.png"))); 
        getContentPane().add(enforcado0, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_Jogo.png"))); 
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Btn A action performed.
     *
     * @param evt the evt
     */
    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {
        btnA.setVisible(false);
        atualizarPalavra('A');
        jogar("A");
    }

    /**
     * Btn B action performed.
     *
     * @param evt the evt
     */
    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {
        btnB.setVisible(false);
        atualizarPalavra('B');
        jogar("B");
    }

    /**
     * Btn C action performed.
     *
     * @param evt the evt
     */
    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {
        btnC.setVisible(false);
        atualizarPalavra('C');
        jogar("C");
    }

    /**
     * Btn D action performed.
     *
     * @param evt the evt
     */
    private void btnDActionPerformed(java.awt.event.ActionEvent evt) {
        btnD.setVisible(false);
        atualizarPalavra('D');
        jogar("D");
    }

    /**
     * Btn E action performed.
     *
     * @param evt the evt
     */
    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {
        btnE.setVisible(false);
        atualizarPalavra('E');
        jogar("E");
    }

    /**
     * Btn F action performed.
     *
     * @param evt the evt
     */
    private void btnFActionPerformed(java.awt.event.ActionEvent evt) {
        btnF.setVisible(false);
        atualizarPalavra('F');
        jogar("F");
    }

    /**
     * Btn G action performed.
     *
     * @param evt the evt
     */
    private void btnGActionPerformed(java.awt.event.ActionEvent evt) {
        btnG.setVisible(false);
        atualizarPalavra('G');
        jogar("G");
    }

    /**
     * Btn H action performed.
     *
     * @param evt the evt
     */
    private void btnHActionPerformed(java.awt.event.ActionEvent evt) {
        btnH.setVisible(false);
        atualizarPalavra('H');
        jogar("H");
    }

    /**
     * Btn I action performed.
     *
     * @param evt the evt
     */
    private void btnIActionPerformed(java.awt.event.ActionEvent evt) {
        btnI.setVisible(false);
        atualizarPalavra('I');
        jogar("I");
    }

    /**
     * Btn J action performed.
     *
     * @param evt the evt
     */
    private void btnJActionPerformed(java.awt.event.ActionEvent evt) {
        btnJ.setVisible(false);
        atualizarPalavra('J');
        jogar("J");
    }

    /**
     * Btn K action performed.
     *
     * @param evt the evt
     */
    private void btnKActionPerformed(java.awt.event.ActionEvent evt) {
        btnK.setVisible(false);
        atualizarPalavra('K');
        jogar("K");
    }

    /**
     * Btn L action performed.
     *
     * @param evt the evt
     */
    private void btnLActionPerformed(java.awt.event.ActionEvent evt) {
        btnL.setVisible(false);
        atualizarPalavra('L');
        jogar("L");
    }

    /**
     * Btn M action performed.
     *
     * @param evt the evt
     */
    private void btnMActionPerformed(java.awt.event.ActionEvent evt) {
        btnM.setVisible(false);
        atualizarPalavra('M');
        jogar("M");
    }

    /**
     * Btn N action performed.
     *
     * @param evt the evt
     */
    private void btnNActionPerformed(java.awt.event.ActionEvent evt) {
        btnN.setVisible(false);
        atualizarPalavra('N');
        jogar("N");
    }

    /**
     * Btn O action performed.
     *
     * @param evt the evt
     */
    private void btnOActionPerformed(java.awt.event.ActionEvent evt) {
        btnO.setVisible(false);
        atualizarPalavra('O');
        jogar("O");
    }

    /**
     * Btn P action performed.
     *
     * @param evt the evt
     */
    private void btnPActionPerformed(java.awt.event.ActionEvent evt) {
        btnP.setVisible(false);
        atualizarPalavra('P');
        jogar("P");
    }

    /**
     * Btn Q action performed.
     *
     * @param evt the evt
     */
    private void btnQActionPerformed(java.awt.event.ActionEvent evt) {
        btnQ.setVisible(false);
        atualizarPalavra('Q');
        jogar("Q");
    }

    /**
     * Btn R action performed.
     *
     * @param evt the evt
     */
    private void btnRActionPerformed(java.awt.event.ActionEvent evt) {
        btnR.setVisible(false);
        atualizarPalavra('R');
        jogar("R");
    }

    /**
     * Btn S action performed.
     *
     * @param evt the evt
     */
    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {
        btnS.setVisible(false);
        atualizarPalavra('S');
        jogar("S");
    }

    /**
     * Btn T action performed.
     *
     * @param evt the evt
     */
    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {
        btnT.setVisible(false);
        atualizarPalavra('T');
        jogar("T");
    }

    /**
     * Btn U action performed.
     *
     * @param evt the evt
     */
    private void btnUActionPerformed(java.awt.event.ActionEvent evt) {
        btnU.setVisible(false);
        atualizarPalavra('U');
        jogar("U");
    }

    /**
     * Btn V action performed.
     *
     * @param evt the evt
     */
    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {
        btnV.setVisible(false);
        atualizarPalavra('V');
        jogar("V");
    }

    /**
     * Btn W action performed.
     *
     * @param evt the evt
     */
    private void btnWActionPerformed(java.awt.event.ActionEvent evt) {
        btnW.setVisible(false);
        atualizarPalavra('W');
        jogar("W");
    }

    /**
     * Btn X action performed.
     *
     * @param evt the evt
     */
    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {
        btnX.setVisible(false);
        atualizarPalavra('X');
        jogar("X");
    }

    /**
     * Btn Y action performed.
     *
     * @param evt the evt
     */
    private void btnYActionPerformed(java.awt.event.ActionEvent evt) {
        btnY.setVisible(false);
        atualizarPalavra('Y');
        jogar("Y");
    }

    /**
     * Btn Z action performed.
     *
     * @param evt the evt
     */
    private void btnZActionPerformed(java.awt.event.ActionEvent evt) {
        btnZ.setVisible(false);
        atualizarPalavra('Z');
        jogar("Z");
    }

    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaJogo().setVisible(true);
            }
        });
    }

    
    /** The bg. */
    private javax.swing.JLabel bg;
    
    /** The btn A. */
    private javax.swing.JButton btnA;
    
    /** The btn B. */
    private javax.swing.JButton btnB;
    
    /** The btn C. */
    private javax.swing.JButton btnC;
    
    /** The btn D. */
    private javax.swing.JButton btnD;
    
    /** The btn E. */
    private javax.swing.JButton btnE;
    
    /** The btn F. */
    private javax.swing.JButton btnF;
    
    /** The btn G. */
    private javax.swing.JButton btnG;
    
    /** The btn H. */
    private javax.swing.JButton btnH;
    
    /** The btn I. */
    private javax.swing.JButton btnI;
    
    /** The btn J. */
    private javax.swing.JButton btnJ;
    
    /** The btn K. */
    private javax.swing.JButton btnK;
    
    /** The btn L. */
    private javax.swing.JButton btnL;
    
    /** The btn M. */
    private javax.swing.JButton btnM;
    
    /** The btn N. */
    private javax.swing.JButton btnN;
    
    /** The btn O. */
    private javax.swing.JButton btnO;
    
    /** The btn P. */
    private javax.swing.JButton btnP;
    
    /** The btn Q. */
    private javax.swing.JButton btnQ;
    
    /** The btn R. */
    private javax.swing.JButton btnR;
    
    /** The btn S. */
    private javax.swing.JButton btnS;
    
    /** The btn T. */
    private javax.swing.JButton btnT;
    
    /** The btn U. */
    private javax.swing.JButton btnU;
    
    /** The btn V. */
    private javax.swing.JButton btnV;
    
    /** The btn W. */
    private javax.swing.JButton btnW;
    
    /** The btn X. */
    private javax.swing.JButton btnX;
    
    /** The btn Y. */
    private javax.swing.JButton btnY;
    
    /** The btn Z. */
    private javax.swing.JButton btnZ;
    
    /** The enforcado 0. */
    private javax.swing.JLabel enforcado0;
    
    /** The enforcado 1. */
    private javax.swing.JLabel enforcado1;
    
    /** The enforcado 2. */
    private javax.swing.JLabel enforcado2;
    
    /** The enforcado 3. */
    private javax.swing.JLabel enforcado3;
    
    /** The enforcado 4. */
    private javax.swing.JLabel enforcado4;
    
    /** The enforcado 5. */
    private javax.swing.JLabel enforcado5;
    
    /** The enforcado 6. */
    private javax.swing.JLabel enforcado6;
    
    /** The lbl jogador. */
    private javax.swing.JLabel lblJogador;
    
    /** The lbl palavra. */
    private javax.swing.JLabel lblPalavra;
    
    /** The lbl tema. */
    private javax.swing.JLabel lblTema;
    
    /** The txt nome jogador. */
    private javax.swing.JLabel txtNomeJogador;
    
    /** The txt tema. */
    private javax.swing.JLabel txtTema;
    
}
