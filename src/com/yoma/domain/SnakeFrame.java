package com.yoma.domain;

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeFrame extends JFrame {
    public SnakeFrame(){
        super("My Frame");
        snakePanel = new SnakePanel();
        JButton button = new JButton();
        snakePanel.add(button);
        button.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

                int keyCode = keyEvent.getKeyCode();
                switch( keyCode ) {
                    case KeyEvent.VK_UP:
                        // handle up
                        snakePanel.moveUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        // handle down
                        snakePanel.moveDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        // handle left
                        snakePanel.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT :
                        // handle right
                        snakePanel.moveRight();
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        setContentPane(snakePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocation(400,400);
        setVisible(true);

        Timer timer = new Timer(500,(event)->{
            snakePanel.moveSnake();
            snakePanel.repaint();
        });
        timer.start();
    }
    private SnakePanel snakePanel ;

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public void setSnakePanel(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }
}
