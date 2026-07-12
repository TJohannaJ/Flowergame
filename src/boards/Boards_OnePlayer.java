package boards;

import menu.*;
import java.awt.*;

import static java.lang.Integer.valueOf;

public class Boards_OnePlayer extends Boards{
    private long timespent;
    public static String[][] tileTable = new String[20][15];

    public Boards_OnePlayer(){
        //random egyszemelyes palya kivalasztasa es beolvasasa egy fajlbol
        super();
        filename = "Board" + boardNumber + "_OnePlayer";
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
        g.fillRect(0, 0, 20*getCellSize(), 15*getCellSize());
        drawLines(g);
        drawPlayer(g);
        drawImages(g);
        endOfGameCheck();
    }
    public String getTileTable(int x, int y){
        return tileTable[x][y];
    }

    public void setTileTable(int x, int y, String s){
        tileTable[x][y]= s;
    }

    public void basicBoardLookGenerator(){
        for(int i =0; i< 20; i++){
            for(int j = 0; j< 15; j++){
                tileTable[i][j] ="n";
            }
        }
        for(int i = 0; i < 20; i++){
            tileTable[i][0] = "w";
            tileTable[i][14] = "w";
        }
        for(int i = 0; i < 15; i++){
            tileTable[0][i] = "w";
            tileTable[19][i] = "w";
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

    public void drawLines(Graphics g){
        g.setColor(new Color(181,229,80));
        for(int i = 0; i <= 20; i++){
            g.drawLine(i*getCellSize(),0,i*getCellSize(),getCellSize()*15);
        }
        for(int i = 0; i <= 15; i++){
            g.drawLine(0,i*getCellSize(),getCellSize()*20,i*getCellSize());
        }
        setLocation(25, 50);
    }

    public void drawPlayer(Graphics g){
        DrawPlayers player1 = new DrawPlayers(Menus.player1, Menus.player1.getX(), Menus.player1.getY());
        player1.drawPlayer(Menus.player1, g);
    }

    public void drawImages(Graphics g){
        for(int i = 0; i < 20;i++){
            for(int j = 0; j < 15; j++){
                switch (tileTable[i][j]){
                    case "w":
                        g.drawImage(wall.getImage(), i*getCellSize(), j*getCellSize(), this );
                        break;
                    case "f":
                        g.drawImage(flower1.getImage(), i*getCellSize(), j*getCellSize(), this );
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void endOfGameCheck(){
        if(Menus.player1.getFlowers() == 0){
            getParent().getParent().getParent().getParent().setVisible(false);
            timespent = (System.currentTimeMillis() - time);
            check();
            Menu5_OnePlayer menu5 = new Menu5_OnePlayer();
            menu5.setVisible(true);
        }
    }

    public void check() {
        int p1_ok = 0;
        for(String coordinate: answers){
            String[] nums = (coordinate.split(" "));
            if (tileTable[valueOf(nums[1])][valueOf(nums[0])] == "f"){
                Menus.player1.setScore(Menus.player1.getScore() + 100);
                p1_ok++;
            }
        }
        Menus.player1.setScore(Menus.player1.getScore() - ((10-Menus.player1.getFlowers())-p1_ok)*50);
        if(Menus.player1.getScore() < 0){
            Menus.player1.setScore(0);
        }
        Menus.player1.setScore((20000*Menus.player1.getScore())/timespent);
    }
}