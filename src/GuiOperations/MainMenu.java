
package GuiOperations;

import Main.Game;
import java.awt.Menu;

/**
 *
 * Netbeans sağolsun pek fazla söze gerek yok sanırım bu class ta herşey otomatik yapılmış zaten :)
 */
public class MainMenu extends javax.swing.JPanel {

    private Game gamer;
    public MainMenu(Game gamer) {
        this.gamer = gamer;
        initComponents();
    }
    public MainMenu(){
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        highScoresButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 83, 242));

        jLabel2.setFont(new java.awt.Font("Vladimir Script", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Puzzle Game");

        startButton.setBackground(new java.awt.Color(153, 0, 153));
        startButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("Start Game");
        startButton.setBorderPainted(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        highScoresButton.setBackground(new java.awt.Color(0, 153, 0));
        highScoresButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        highScoresButton.setForeground(new java.awt.Color(255, 255, 255));
        highScoresButton.setText("High Scores");
        highScoresButton.setBorderPainted(false);
        highScoresButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highScoresButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(102, 255, 102));
        exitButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Exit");
        exitButton.setToolTipText("");
        exitButton.setBorderPainted(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(highScoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel2)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highScoresButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void highScoresButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highScoresButtonActionPerformed
        new HighScores().setVisible(true);
    }//GEN-LAST:event_highScoresButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        gamer.startGame();
        repaint();
    }//GEN-LAST:event_startButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JButton highScoresButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
