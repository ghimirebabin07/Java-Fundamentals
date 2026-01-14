import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeAI extends JFrame implements ActionListener {

    private JButton[][] buttons = new JButton[3][3];
    private boolean playerTurn = true;
    private JLabel status = new JLabel("Your Turn (X)", JLabel.CENTER);

    public TicTacToeAI() {
        setTitle("Tic Tac Toe - Unbeatable AI");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        status.setFont(new Font("Arial", Font.BOLD, 18));
        add(status, BorderLayout.NORTH);

        JPanel board = new JPanel(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 48);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                board.add(buttons[i][j]);
            }
        }

        add(board, BorderLayout.CENTER);

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> resetGame());
        add(reset, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!playerTurn) return;

        JButton btn = (JButton) e.getSource();
        if (!btn.getText().equals("")) return;

        btn.setText("X");
        btn.setForeground(Color.BLUE);

        if (checkWin("X")) {
            showResult("You Win!");
            return;
        }

        if (isDraw()) {
            showResult("Draw!");
            return;
        }

        playerTurn = false;
        status.setText("Computer Thinking...");

        Timer t = new Timer(300, ev -> {
            aiMove();
            playerTurn = true;
            status.setText("Your Turn (X)");
        });
        t.setRepeats(false);
        t.start();
    }

    /* ================= AI LOGIC ================= */

    private void aiMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1, bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setText("O");
                    int score = minimax(false);
                    buttons[i][j].setText("");

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }

        buttons[bestRow][bestCol].setText("O");
        buttons[bestRow][bestCol].setForeground(Color.RED);

        if (checkWin("O")) showResult("Computer Wins!");
        else if (isDraw()) showResult("Draw!");
    }

    private int minimax(boolean isMaximizing) {
        if (checkWin("O")) return 10;
        if (checkWin("X")) return -10;
        if (isDraw()) return 0;

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    buttons[i][j].setText(isMaximizing ? "O" : "X");
                    int score = minimax(!isMaximizing);
                    buttons[i][j].setText("");

                    bestScore = isMaximizing
                            ? Math.max(score, bestScore)
                            : Math.min(score, bestScore);
                }
            }
        }
        return bestScore;
    }

    /* ================= GAME LOGIC ================= */

    private boolean checkWin(String p) {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(p) &&
                buttons[i][1].getText().equals(p) &&
                buttons[i][2].getText().equals(p)) return true;

            if (buttons[0][i].getText().equals(p) &&
                buttons[1][i].getText().equals(p) &&
                buttons[2][i].getText().equals(p)) return true;
        }

        return (buttons[0][0].getText().equals(p) &&
                buttons[1][1].getText().equals(p) &&
                buttons[2][2].getText().equals(p)) ||

               (buttons[0][2].getText().equals(p) &&
                buttons[1][1].getText().equals(p) &&
                buttons[2][0].getText().equals(p));
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (buttons[i][j].getText().equals("")) return false;
        return true;
    }

    private void showResult(String msg) {
        JOptionPane.showMessageDialog(this, msg);
        resetGame();
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setText("");
        playerTurn = true;
        status.setText("Your Turn (X)");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToeAI::new);
    }
}
