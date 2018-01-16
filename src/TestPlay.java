import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TestPlay extends Canvas{

    public static final int WIDTH = 1080, HEIGHT = 720;

        public void loop() {
            new Window(WIDTH, HEIGHT, "Gomoku", this);
            Player player1 = new Player(1, true);
            Player player2 = new Player(2, true);
            Board workingBoard = new Board(19);
            boolean flag = true;
            Move move;
            //this.addMouseListener(new MouseGame(pos, AI));
            //this.addKeyListener(new KeyGame(board, this));

            while (flag) {
                if (workingBoard.getLastPlayed() != player1.getName()) {
                    move = player1.getBestMove(workingBoard);
                    workingBoard.placeValidatedPiece(move.y, move.x);
                }
                else {
                    move = player2.getBestMove(workingBoard);
                    workingBoard.placeValidatedPiece(move.y, move.x);
                }
                TerminalGame.printBoard(workingBoard.getBoard());
                flag = !workingBoard.isTerminal();
                //flag = TerminalGame.exitGame();
                render(workingBoard, 1000);
            }
        }

    private BufferedImage image;
    private long time;

    public void render(Board board, long t){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return ;
        }

        Graphics g = bs.getDrawGraphics();

        try{
            image = ImageIO.read(getClass().getResourceAsStream("board_2.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }

        image.getScaledInstance(720, 720, Image.SCALE_DEFAULT);

        g.setColor(Color.darkGray);
        g.fillRect(700, 0, WIDTH, HEIGHT);
        g.drawImage(image, 0, 0, 700, 700, null);
        g.setColor(Color.lightGray);
        if (t != 0)
            time = t;
        g.drawString("Seconds taken: " + time, 800, 100);
        renderTiles(g, board.getBoard());

        g.dispose();
        bs.show();
    }

    private void renderTiles(Graphics g, int[][] board){
        int x = 0;
        while (x < 19)
        {
            int y = 0;
            while (y < 19)
            {
                if (board[y][x] > 0) {
                    if (board[y][x] == 1) g.setColor(Color.white);
                    else if (board[y][x] == 2) g.setColor(Color.black);
                    else //board[y][x] == 3 i.e. suggestion move
                        g.setColor(Color.red);
                    g.fillOval(((x * 35) + 40), ((y * 35) + 38), 20, 20);
                }
                y++;
            }
            x++;
        }
    }
}
