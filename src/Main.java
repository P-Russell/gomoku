import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Board head = new Board(19);
        head.placeValidatedPiece(5, 5);
        head.placeValidatedPiece(0, 1);
        head.placeValidatedPiece(7, 6);
        head.placeValidatedPiece(7, 6);
        head.placeValidatedPiece(7, 7);
        head.placeValidatedPiece(6, 13);
        head.placeValidatedPiece(6, 13);
        head.placeValidatedPiece(6, 14);
        head.placeValidatedPiece(6, 3);
        head.placeValidatedPiece(18, 8);
        head.placeValidatedPiece(18, 9);
        head.placeValidatedPiece(18, 9);
        head.placeValidatedPiece(18, 10);
        head.placeValidatedPiece(18, 10);
        head.placeValidatedPiece(18, 11);
        head.placeValidatedPiece(13, 15);
        head.placeValidatedPiece(13, 16);
        head.placeValidatedPiece(13, 16);
        head.placeValidatedPiece(13, 17);
        head.placeValidatedPiece(13, 17);
        head.placeValidatedPiece(13, 18);
        head.placeValidatedPiece(13, 18);


        ArrayList<Board> expanded = ExpandBoard.expand(head);

        System.out.println("found " + expanded.size() + " nodes");
        for(int i = 0; i < expanded.size(); i++)
            TerminalGame.printBoard(expanded.get(i).getBoard());

        //TestPlay t = new TestPlay();
        //t.loop();
    }
}
