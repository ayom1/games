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
        JPanel main = new JPanel();
        JPanel up = new JPanel ();

        //adjust size and set layout
        //setPreferredSize (new Dimension (400, 432));
        GridLayout layout = new GridLayout(2, 1, 0, 0);
        main.setLayout (layout);
        up.setSize(400,100);
        snakePanel.setSize(400,200);
        //add components
        main.add (up);
        main.add (snakePanel);

        setContentPane(main);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 422);
        setLocation(400,400);
        setVisible(true);
        setResizable(false);
        Timer timer = new Timer(500,(event)->{
            snakePanel.moveSnake();
        });
        timer.start();
        System.out.println(snakePanel.getSize());
    }
    private SnakePanel snakePanel ;

    public SnakePanel getSnakePanel() {
        return snakePanel;
    }

    public void setSnakePanel(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }
}
