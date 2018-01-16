import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyGame extends KeyAdapter {

    private Board board;
    private TestPlay play;

    public KeyGame(Board board, TestPlay play){
        this.board = board;
        this.play = play;
    }
/*
    public void keyTyped(KeyEvent e){
        if (e.getKeyChar() == 's'){
            board.getBestMove();
            board[][] = 3;
            play.render(board);
            try {
                wait(1000);
            }
            catch (Exception ex){
                System.out.println("Delay failed");
            }
            board[][] = 0;
            play.render(board);
        }
    }*/

}
