package view;

// TODO: Auto-generated Javadoc
/**
 * The Class Inicio.
 */
public class Inicio extends javax.swing.JFrame {
    
    /** The tela jogo. */
    TelaJogo telaJogo = new TelaJogo();
    
    /** The selecao tema. */
    SelecaoTema selecaoTema = new SelecaoTema();
    
    /**
     * Instantiates a new inicio.
     */
    public Inicio() {
        initComponents();
    }
    
    
    /**
     * Inits the components.
     */
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        bg_Inicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Forca");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNome.setFont(new java.awt.Font("Arial", 0, 18)); 
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 300, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnJogar.png"))); 
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btnJogar2.png"))); 
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 250, 60));

        bg_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg_Inicio.png"))); 
        getContentPane().add(bg_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * J button 1 action performed.
     *
     * @param evt the evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       String nomeDoJogador = txtNome.getText();
       telaJogo.definirNomeJogador(nomeDoJogador);
       selecaoTema.pegarTelaJogo(telaJogo);
       selecaoTema.setVisible(true);
       this.dispose();
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    
    /** The bg inicio. */
    private javax.swing.JLabel bg_Inicio;
    
    /** The j button 1. */
    private javax.swing.JButton jButton1;
    
    /** The txt nome. */
    private javax.swing.JTextField txtNome;
    
}

