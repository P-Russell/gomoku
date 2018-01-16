import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseGame extends MouseAdapter {

    private Move pos;
    private Player p1;
    private Player p2;
    private Board board;

    public MouseGame(Move pos, Player p1, Player p2, Board board){
        this.pos = pos;
        this.p1 = p1;
        this.p2 = p2;
        this.board = board;
    }

    public void mouseClicked(MouseEvent e){
        if (board.getLastPlayed() != p1.getName() && !p1.isAI() && e.getY() >= 35 && e.getY() <= 697 && e.getX() >= 35 && e.getX() <= 697)
        {
            pos.piece = p1.getName();
            pos.y = ((e.getY() - 35) / 35);
            pos.x = ((e.getX() - 35) / 35);
        }
        else if (board.getLastPlayed() != p2.getName() && !p2.isAI() && e.getY() >= 35 && e.getY() <= 697 && e.getX() >= 35 && e.getX() <= 697) {
            pos.piece = p2.getName();
            pos.y = ((e.getY() - 35) / 35);
            pos.x = ((e.getX() - 35) / 35);
        }
    }

}
