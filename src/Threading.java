import java.util.ArrayList;
import java.util.List;

public class Threading extends Thread {
    private String threadName;
    private ArrayList<Board> boardList;
    private int i;
    private Player player;

    public Threading(String name, ArrayList<Board> list, int i, Player player) {
        this.threadName = name;
        this.boardList = list;
        this.i = i;
        this.player = player;
    }

    public void run(){
        try{
            int s = this.boardList.size();
            int b = (s / 4) * (this.i - 1);
            int e = (s / 4) * (this.i);
            int l = e - b;
            for (int j = 0; j < l; j++){
                this.boardList.get(b + j).setHeuristic(MiniMax.miniMax(boardList.get(b + j), 0, false, this.player.getName(), -10000, 10000, this.player));
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Thread " + threadName + " interrupted");
        }
        System.out.println("Thread " + threadName + " exiting");
    }

}
