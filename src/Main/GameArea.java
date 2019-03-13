package Main;

import GuiOperations.GameUI;
import GuiOperations.IMediator;
import GuiOperations.Mediator;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class GameArea extends JFrame implements IMediator{
    private GameUI game;
    private JButton btnMix;
    public JLabel lblScore;
    public JLabel lblHak;
    private Mediator mediator;
    public static void main(String[] args) {
        
    }
    
    
    // start game yapılduğında resim diskten yükleniyor 
        // parçalanıyor.
        // ekleniyor 
        // karıştırılıyor.
        // listenerleri ekleniyor.
        // fazla söze gerek yok bu class sadece diğer classları çağıran bir class extra bir özelliği yok
    
    public GameArea(GameUI game,Mediator mediator){
        this.game = game;
        this.mediator = mediator;
        mediator.addArea(this);
        try {UIManager.setLookAndFeel(new NimbusLookAndFeel());} catch (Exception e) {e.printStackTrace();}
        
        lblScore = new JLabel("Score : 100");
        lblHak = new JLabel("Heart : 15 " );
        lblHak.setBounds(175,412,100,30);
        lblHak.setVisible(false);
        lblScore.setVisible(false);
        lblScore.setBounds(375, 412, 100, 30);
        setSize(500,510);
        setVisible(true);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);
        
        game.setBounds(35,10,405,405);
        game.setVisible(false);
        btnMix = new JButton("Mix");
        btnMix.setBounds(212,410,75,30);
        
        add(game);
        add(btnMix);
        add(lblScore);
        add(lblHak);
        
        btnMix.addActionListener((ActionEvent e) -> {
            int result = game.mixImages();
            System.out.println("result: "+result);
            if(result != 0){
                game.addImages();
                game.setVisible(true);
                btnMix.setVisible(false);
                lblHak.setVisible(true);
                lblScore.setVisible(true);
                repaint();
            }
            else{
                JOptionPane.showMessageDialog(null, "Yeniden dene");
                game.resetButtons();
            }
        });
    }
    
    
}
