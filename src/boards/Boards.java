package boards;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public abstract class Boards extends JPanel {
    protected long time;
    protected Tile wall = new Tile("wall.png");
    protected Tile flower1 = new Tile("flower1.png");
    public static int cellSize = 32;
    protected int boardNumber;
    protected String board = null;
    protected String filename;
    protected ArrayList<String> answers;

    public Boards(){
        answers = new ArrayList<String>();
        boardNumber = randomGenerator();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public int getCellSize() {
        return cellSize;
    }

    public void set_time(){
        time = System.currentTimeMillis();
    }

    public int randomGenerator(){
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        int boardNumber = r.nextInt(2) + 1;
        return boardNumber;
    }

    public void readOneLineFromText(){
        try {
            FileInputStream fis = new FileInputStream((filename + ".txt"));
            Scanner sc = new Scanner(fis);
            while(sc.hasNextLine()){
                board = sc.nextLine();
            }
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void answerSheetReading(){
        try {
            FileInputStream fis = new FileInputStream((filename + "M.txt"));
            Scanner sc = new Scanner(fis);
            int szamlalo = 0;
            while(sc.hasNextLine()){
                answers.add(szamlalo, sc.nextLine());
                szamlalo++;
            }
            sc.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
