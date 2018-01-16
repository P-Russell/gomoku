public class TestPlay {

        public static void loop() {
            Player player1 = new Player(1, true);
            Player player2 = new Player(2, true);
            Board workingBoard = new Board(19);
            boolean flag = true;
            Move move;

            while (flag) {
                if (workingBoard.getLastPlayed() != player1.getName()) {
                    if (!player1.isAI())
                        TerminalGame.printBoard(workingBoard.getBoard());
                    move = player1.getBestMove(workingBoard);
                    workingBoard.placeValidatedPiece(move.y, move.x);
                }
                else {
                    if (!player2.isAI())
                        TerminalGame.printBoard(workingBoard.getBoard());
                    move = player2.getBestMove(workingBoard);
                    workingBoard.placeValidatedPiece(move.y, move.x);
                }
                TerminalGame.printBoard(workingBoard.getBoard());
                //flag = TerminalGame.exitGame();
            }
        }
}
