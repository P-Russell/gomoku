import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

public class TestPlay extends Canvas{

    public static final int WIDTH = 1080, HEIGHT = 720;

    public void loop() {
        new Window(WIDTH, HEIGHT, "Gomoku", this);
        Player player1 = new Player(1, false);
        Player player2 = new Player(2, true);
        Board workingBoard = new Board(19);
        CheckMove validator = new CheckMove();
        boolean flag = true;
        Move clickMove = new Move(0, 0, 0);
        Move move;
        this.addMouseListener(new MouseGame(clickMove, player1, player2, workingBoard));
        this.addKeyListener(new KeyGame(workingBoard, this, player1, player2));
        Date d1 = new Date();
        Date d2 = new Date();
        while (flag) {
            if (workingBoard.getLastPlayed() != player1.getName()) {
                if (player1.isAI()){
                    d1 = new Date();
                    move = player1.getBestMove(workingBoard);
                    d2 = new Date();
                    workingBoard.placeValidatedPiece(move.y, move.x);
                }
            }
            else if (player2.isAI()) {
                d1 = new Date();
                move = player2.getBestMove(workingBoard);
                d2 = new Date();
                workingBoard.placeValidatedPiece(move.y, move.x);
            }
            if (clickMove.piece != 0){
                if (validator.validateAndCapturePieces(workingBoard, clickMove.y, clickMove.x)) {
                    workingBoard.placeValidatedPiece(clickMove.y, clickMove.x);
                    Date b = new Date();
                    Date e = new Date();
                    while (e.getTime() - b.getTime() < 250) {
                        render(workingBoard, d2.getTime() - d1.getTime());
                        e = new Date();
                    }
                }
                else {
                    System.out.println("Invalid Move");
                    flash(workingBoard, clickMove.y, clickMove.x, 4, 1000);
                }
                clickMove.piece = 0;
            }
            render(workingBoard, d2.getTime() - d1.getTime());
            //TerminalGame.printBoard(workingBoard.getBoard());
            flag = !workingBoard.isTerminal();
            //flag = TerminalGame.exitGame();
        }
        System.out.println("Player " + workingBoard.getLastPlayed() + " has won the game");
        render(workingBoard, 1000);
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
        int p = (board.getLastPlayed() % 2) + 1;
        g.drawString("Player Turn: " + p, 800, 50);
        g.drawString("Miliseconds taken: " + time, 800, 100);
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
                    else if (board[y][x] == 3) g.setColor(Color.green);
                    else g.setColor(Color.red);
                    g.fillOval(((x * 35) + 40), ((y * 35) + 38), 20, 20);
                }
                y++;
            }
            x++;
        }
    }

    public void flash(Board board, int r, int c, int val, int time){
        int[][] temp = board.getBoard();
        int t = temp[r][c];
        board.placeSuggestedPiece(r, c, val);
        Date d = new Date();
        long b = d.getTime();
        long end = d.getTime();
        while (end - b < time) {
            render(board, 1000);
            d = new Date();
            end = d.getTime();
        }
        board.placeSuggestedPiece(r, c, t);
    }
}
