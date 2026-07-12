package boards;

import menu.*;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Integer.valueOf;

public class Boards_TwoPlayer extends Boards{

    private long timespent;
    public static String[][] tileTable = new String[25][20];
    private Tile flower2 = new Tile("flower2.png");

    public Boards_TwoPlayer(){
        //random ketszemelyes palya kivalasztasa es beolvasasa egy fajlbol
        super();
        filename = "Board" + boardNumber + "_TwoPlayer";
        readOneLineFromText();
        //Megoldokulcs bevitele
        answerSheetReading();
        //Tabla generalasa
        basicBoardLookGenerator();
        boardLookGenerator();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(145, 167, 101));
        g.fillRect(0, 0, 25*getCellSize(), 20*getCellSize());
        setLocation(18,50);
        drawLines(g);
        drawPlayers(g);
        drawImages(g);
        endOfGameCheck();
    }

    public void basicBoardLookGenerator(){
        for(int i =0; i< 25; i++){
            for(int j = 0; j< 20; j++){
                tileTable[i][j] ="n";
            }
        }
        for(int i = 0; i < 25; i++){
            tileTable[i][0] = "w";
            tileTable[i][19] = "w";
        }
        for(int i = 0; i < 20; i++){
            tileTable[0][i] = "w";
            tileTable[24][i] = "w";
        }
    }

    public void boardLookGenerator(){
        String[] rows = board.split("/");
        int y =1;
        for(String row:rows){
            int x = 1;
            for(char tile : row.toCharArray()){
                if(Character.isDigit(tile)){
                    x+= Character.getNumericValue(tile);
                    continue;
                }

                if(tile == 'w'){
                    setTileTable(x,y,"w");
                }
                x++;
            }
            y++;
        }
    }

    public String getTileTable(int x, int y){
        return tileTable[x][y];
    }

    public void setTileTable(int x, int y, String s){
        tileTable[x][y]= s;
    }

    public void drawImages(Graphics g){
        for(int i = 0; i < 25;i++){
            for(int j = 0; j < 20; j++){
                switch (tileTable[i][j]){
                    case "w":
                        g.drawImage(wall.getImage(), i*getCellSize(), j*getCellSize(), this );
                        break;
                    case "f":
                        g.drawImage(flower1.getImage(), i*getCellSize(), j*getCellSize(), this );
                        break;
                    case "F":
                        g.drawImage(flower2.getImage(), i*getCellSize(), j*getCellSize(), this);
                    default:
                        break;
                }
            }
        }
    }

    public void drawLines(Graphics g){
        g.setColor(new Color(181,229,80));
        for(int i = 0; i <= 25; i++){
            g.drawLine(i*getCellSize(),0,i*getCellSize(),getCellSize()*20);
        }
        for(int i = 0; i <= 20; i++){
            g.drawLine(0,i*getCellSize(),getCellSize()*25,i*getCellSize());
        }
    }

    public void drawPlayers(Graphics g){
        DrawPlayers player1 = new DrawPlayers(Menus.player1, Menus.player1.getX(), Menus.player1.getY());
        player1.drawPlayer(Menus.player1, g);
        DrawPlayers player2 = new DrawPlayers(Menus.player2, Menus.player2.getX(), Menus.player2.getY());
        player2.drawPlayer(Menus.player2, g);
        drawImages(g);
    }

    public void endOfGameCheck(){
        if(Menus.player1.getFlowers() == 0 || Menus.player2.getFlowers() == 0){
            timespent = (System.currentTimeMillis() - time);
            check();
            Menu5_TwoPlayer menu5 = new Menu5_TwoPlayer();
            menu5.setVisible(true);
            getParent().getParent().getParent().getParent().setVisible(false);
        }
    }
    public void check() {
        int p1_ok = 0;
        int p2_ok = 0;
        for(String coordinate: answers){
            String[] nums = (coordinate.split(" "));
            if (tileTable[valueOf(nums[1])][valueOf(nums[0])] == "f"){
                Menus.player1.setScore(Menus.player1.getScore() + 100);
                p1_ok++;
            } else if(tileTable[valueOf(nums[1])][valueOf(nums[0])]== "F"){
                Menus.player2.setScore(Menus.player2.getScore() + 100);
                p2_ok++;
            }
        }
        Menus.player1.setScore(Menus.player1.getScore() - ((10-Menus.player1.getFlowers()) -p1_ok)*50);
        Menus.player2.setScore(Menus.player2.getScore() - ((10-Menus.player2.getFlowers()) -p2_ok)*50);
        if(Menus.player1.getScore() < 0){
            Menus.player1.setScore(0);
        }
        if(Menus.player2.getScore() < 0){
            Menus.player2.setScore(0);
        }
        Menus.player1.setScore((20000*Menus.player1.getScore())/timespent);
        Menus.player2.setScore((20000*Menus.player2.getScore())/timespent);
    }
}