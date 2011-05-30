package tictactoe;

import gameboard2d.GameBoard2D;
import java.awt.*;
import java.io.*;

/*
 * This class demonstrates how to use the GameBoard2D library version 0.2.
 *
 * This is not a finished game. This code doesn't teach you how to
 * implement a tic tac toe game. The following code only teach you
 * how to implements the graphic part of a 2D game using the
 * GameBoard2D library.
 */
public class Main extends javax.swing.JFrame {

    private static final boolean CROSS = false;
    private static final boolean CIRCLE = true;

    private GameBoard2D gb2d;
    private boolean turn;

    public Main() {
        initComponents();

        try {
            // First we need to create a GameBoard2D object.
            // The first argument is the image of the board.
            // The second argument is the image with cached areas, look at the
            // file "images/ttt-board-cache.png" to see what I mean. In this image,
            // every cached area are filled with a uniq color. A cached area is
            // nothing more than a box of the board.
            // The final argument is the dimension of the board.
            // The two images (board and cache) must be of the same size.
            gb2d = new GameBoard2D(new File("images/ttt-board.png"),
                    new File("images/ttt-board-cache.png"),
                    new Dimension(300, 300));

            // Set up all the boxes of the board.
            // For every box you give :
            //   - an ID, that is an integer
            //   - the color of the cached area for this box
            //   - the reference point of the box from which the library
            //     will draw a piece (this point will be the top left corner
            //     of the drawed piece).
            //   - the dimension of the box (expected this to be removed in the next revision).
            gb2d.addBox(0, new Color(0,0,0), new Point(0,0), new Dimension(100,100));
            gb2d.addBox(1, new Color(20,20,20), new Point(100,0), new Dimension(100,100));
            gb2d.addBox(2, new Color(40,40,40), new Point(200,0), new Dimension(100,100));
            gb2d.addBox(3, new Color(60,60,60), new Point(0,100), new Dimension(100,100));
            gb2d.addBox(4, new Color(80,80,80), new Point(100,100), new Dimension(100,100));
            gb2d.addBox(5, new Color(100,100,100), new Point(200,100), new Dimension(100,100));
            gb2d.addBox(6, new Color(120,120,120), new Point(0,200), new Dimension(100,100));
            gb2d.addBox(7, new Color(140,140,140), new Point(100,200), new Dimension(100,100));
            gb2d.addBox(8, new Color(160,160,160), new Point(200,200), new Dimension(100,100));

            // Add the pieces of the game.
            // For every piece you give:
            //   - an ID, that is the name of the piece
            //   - the image of the piece
            gb2d.addPiece("cross", new File("images/cross.png"));
            gb2d.addPiece("circle", new File("images/circle.png"));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }

        // To finish the initialization, you add the GameBoard2D object in a panel
        // of your GUI.
        // This panel should be of the same size than the board image.
        panel.add(gb2d);

        newGameActionPerformed(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        newGame = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(205, 234, 224));
        panel.setPreferredSize(new java.awt.Dimension(300, 300));
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        newGame.setText("New game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        label.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label)
                    .addComponent(newGame))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label)
                .addGap(18, 18, 18)
                .addComponent(newGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        turn = CROSS;
        label.setText("Cross turn");

        // That method simply draw the board on the screen.
        gb2d.drawBoard();
    }//GEN-LAST:event_newGameActionPerformed

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        // I have added a mouse listener to the panel which contain
        // the GameBoard2D object.
        // When this panel is clicked, we ask the library for the box ID.
        int cell = gb2d.getBoxId(evt.getPoint());

        // To draw a piece, tell the library the name of the piece and
        // the box id.
        if(turn == CROSS) {
            gb2d.drawPiece("cross", cell);
        } else {
            gb2d.drawPiece("circle", cell);
        }

        nextTurn();

    }//GEN-LAST:event_panelMouseClicked

    private void nextTurn() {
        turn = !turn;
        if(turn == CROSS) {
            label.setText("Cross turn");
        } else {
            label.setText("Circle turn");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label;
    private javax.swing.JButton newGame;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

}
