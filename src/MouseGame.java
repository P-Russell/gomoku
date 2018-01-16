import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseGame extends MouseAdapter {

    private int[] pos;
    private boolean AI;

    public MouseGame(int[] pos, boolean AI){
        this.pos = pos;
        this.AI = AI;
    }

    public void mouseClicked(MouseEvent e){
        if (!AI && e.getY() >= 35 && e.getY() <= 697 && e.getX() >= 35 && e.getX() <= 697)
        {
            pos[0] = 1;
            pos[1] = ((e.getY() - 35) / 35);
            pos[2] = ((e.getX() - 35) / 35);
        }
        else {
            pos[0] = 0;
            pos[1] = 0;
            pos[2] = 0;
        }
    }

}
