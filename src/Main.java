import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Board head = new Board(6);

        ArrayList<Board> expanded = ExpandBoard.expand(head);

        for(int i = 0; i < expanded.size(); i++)
            TerminalGame.printBoard(expanded.get(i).getBoard());

        //TestPlay t = new TestPlay();
        //t.loop();
    }
}
