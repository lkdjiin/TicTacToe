package tictactoe;

import gameboard2d.GameBoard2D;
import java.awt.*;
import java.io.*;

/*
 * This single file game shows you how to use the GameBoard2D library version 0.3.
 *
 * This is not a finished game.
 * The following code only teach you how to implements the graphic part of
 * a 2D game using the GameBoard2D library.
 */
public class Main extends javax.swing.JFrame {

    private static final boolean CROSS_TURN = false;
    private static final boolean CIRCLE_TURN = true;
    private static final String CROSS_PIECE = "cross";
    private static final String CIRCLE_PIECE = "circle";

    private GameBoard2D gb2d;
    private boolean turn;
    private String[] board;

    public Main() {
        initComponents();
        board = new String[9];

        try {
            // First you need to create a GameBoard2D object.
            gb2d = new GameBoard2D();

            // Next, set up the board.
            // The first argument is the image of the board.
            // The second argument is the image with cached areas, look at the
            // file "images/ttt-board-cache.png" to see what I mean. In this image,
            // every cached area are filled with a uniq color. A cached area is
            // nothing more than a box of the board.
            // The two images (board and cache) must be of the same size.
            gb2d.setBoard(new File("images/ttt-board.png"), new File("images/ttt-board-cache.png"));

            // Set up all the boxes of the board.
            // For every box you give :
            //   - an ID, that is an integer
            //   - the color of the cached area for this box
            //   - the reference point of the box from which the library
            //     will draw a piece (this point will be the top left corner
            //     of the drawed piece).
            gb2d.addBox(0, new Color(0,0,0), new Point(0,0));
            gb2d.addBox(1, new Color(20,20,20), new Point(100,0));
            gb2d.addBox(2, new Color(40,40,40), new Point(200,0));
            gb2d.addBox(3, new Color(60,60,60), new Point(0,100));
            gb2d.addBox(4, new Color(80,80,80), new Point(100,100));
            gb2d.addBox(5, new Color(100,100,100), new Point(200,100));
            gb2d.addBox(6, new Color(120,120,120), new Point(0,200));
            gb2d.addBox(7, new Color(140,140,140), new Point(100,200));
            gb2d.addBox(8, new Color(160,160,160), new Point(200,200));

            // Add the pieces of the game.
            // For every piece you give:
            //   - an ID, that is the name of the piece
            //   - the image of the piece
            // Note that a "piece" is simply a thing that will
            // be drawed on the board.
            gb2d.addPiece(CROSS_PIECE, new File("images/cross.png"));
            gb2d.addPiece(CIRCLE_PIECE, new File("images/circle.png"));
            gb2d.addPiece("stroke h", new File("images/stroke_h.png"));
            gb2d.addPiece("stroke v", new File("images/stroke_v.png"));
            gb2d.addPiece("stroke d1", new File("images/stroke_d1.png"));
            gb2d.addPiece("stroke d2", new File("images/stroke_d2.png"));

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
        turn = CROSS_TURN;
        label.setText("Cross turn");
        clearBoard();

        // That method draw the board on the screen, without anything else, destroying
        // any previously rendering.
        gb2d.drawBoard();
    }//GEN-LAST:event_newGameActionPerformed

    private void clearBoard() {
        for(int i=0; i < board.length; i++) {
            board[i] = "";
        }
    }

    private void panelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseClicked
        // I have added a mouse listener to the panel which contain
        // the GameBoard2D object.
        // When this panel is clicked, we ask the library for the box ID.
        int id = gb2d.getBoxId(evt.getPoint());

        if(! board[id].isEmpty()) {
            return;
        }
        
        // To draw a piece, tell the library the name of the piece and
        // the box id.
        if(turn == CROSS_TURN) {
            board[id] = CROSS_PIECE;
            gb2d.drawPiece(CROSS_PIECE, id);
        } else {
            board[id] = CIRCLE_PIECE;
            gb2d.drawPiece(CIRCLE_PIECE, id);
        }

        checkWin();

        nextTurn();

    }//GEN-LAST:event_panelMouseClicked

    private void checkWin() {
        // drawPieceOnTop is like drawPiece, but it preserves the background.
        if(!board[0].isEmpty() && board[0].equals(board[1]) && board[0].equals(board[2])) {
            gb2d.drawPieceOnTop("stroke h", 0);
        } else if(!board[3].isEmpty() && board[3].equals(board[4]) && board[3].equals(board[5])) {
             gb2d.drawPieceOnTop("stroke h", 3);
        } else if(!board[6].isEmpty() && board[6].equals(board[7]) && board[6].equals(board[8])) {
             gb2d.drawPieceOnTop("stroke h", 6);
        } else if(!board[0].isEmpty() && board[0].equals(board[3]) && board[0].equals(board[6])) {
             gb2d.drawPieceOnTop("stroke v", 0);
        } else if(!board[1].isEmpty() && board[1].equals(board[4]) && board[1].equals(board[7])) {
             gb2d.drawPieceOnTop("stroke v", 1);
        } else if(!board[2].isEmpty() && board[2].equals(board[5]) && board[2].equals(board[8])) {
             gb2d.drawPieceOnTop("stroke v", 2);
        } else if(!board[0].isEmpty() && board[0].equals(board[4]) && board[0].equals(board[8])) {
             gb2d.drawPieceOnTop("stroke d2", 0);
        } else if(!board[2].isEmpty() && board[2].equals(board[4]) && board[2].equals(board[6])) {
             gb2d.drawPieceOnTop("stroke d1", 0);
        }
    }

    private void nextTurn() {
        turn = !turn;
        if(turn == CROSS_TURN) {
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
