import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyGame extends KeyAdapter {

    private Board board;
    private TestPlay play;
    private Player p1;
    private Player p2;

    public KeyGame(Board board, TestPlay play, Player p1, Player p2){
        this.board = board;
        this.play = play;
        this.p1 = p1;
        this.p2 = p2;
    }

    public void keyTyped(KeyEvent e){
        Player temp;
        Move move;
        if (e.getKeyChar() == 's'){
            if (this.board.getLastPlayed() != p1.getName())
                temp = new Player(p1.getName(), true);
            else
                temp = new Player(p2.getName(), true);
            move = temp.getBestMove(this.board);
            this.play.flash(this.board, move.y, move.x, 3);
        }
    }

}
