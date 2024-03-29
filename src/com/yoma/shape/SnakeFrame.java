/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoma.shape;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author aliahmed
 */
public class SnakeFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public SnakeFrame() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newJPanel1 = new SnakePanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        newJPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        newJPanel1.addKeyListener(
                new KeyListener(){
                    @Override
                    public void keyTyped(KeyEvent keyEvent) {
                    }

                    @Override
                    public void keyPressed(KeyEvent keyEvent) {

                        newJPanel1KeyTyped(keyEvent);

                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {
                    }
                }
        );
        newJPanel1.setFocusable(true);
        newJPanel1.requestFocusInWindow();


        javax.swing.GroupLayout newJPanel1Layout = new javax.swing.GroupLayout(newJPanel1);
        newJPanel1.setLayout(newJPanel1Layout);
        newJPanel1Layout.setHorizontalGroup(
                newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 396, Short.MAX_VALUE)
        );
        newJPanel1Layout.setVerticalGroup(
                newJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 396, Short.MAX_VALUE)
        );

        jLabel1.setText("    Score    :");

        jLabel2.setText("0");

        jLabel3.setText("Level :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                               // .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                               // .addContainerGap(127, Short.MAX_VALUE)
                        )
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(newJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        //.addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(newJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );

        pack();
        Timer timer = new Timer(500,(event)->{
            newJPanel1.moveSnake();
            jLabel2.setText(""+this.newJPanel1.getScore());
        });
        timer.start();
    }// </editor-fold>//GEN-END:initComponents

    private void newJPanel1KeyTyped(java.awt.event.KeyEvent keyEvent) {//GEN-FIRST:event_newJPanel1KeyTyped
        // TODO add your handling code here:
        if(newJPanel1.isCrashed()){
            return;
        }
        int keyCode = keyEvent.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                // handle up
                newJPanel1.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                // handle down
                newJPanel1.moveDown();
                break;
            case KeyEvent.VK_LEFT:
                // handle left
                newJPanel1.moveLeft();
                break;
            case KeyEvent.VK_RIGHT :
                // handle right
                newJPanel1.moveRight();
                break;
            case KeyEvent.VK_SPACE :
                newJPanel1.stopOrPlay();
                break;
        }
        System.out.println(newJPanel1.getScore());
        this.jLabel2.setText(""+newJPanel1.getScore());
    }//GEN-LAST:event_newJPanel1KeyTyped

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner1;
    private com.yoma.shape.SnakePanel newJPanel1;
    // End of variables declaration//GEN-END:variables
}
