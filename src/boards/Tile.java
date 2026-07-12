package boards;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tile {
    private Image image;
    public Tile(String imagePath){
        Image img;
        try {
            img = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image = img.getScaledInstance(32,32,Image.SCALE_SMOOTH);
    }

    public Image getImage() {
        return image;
    }
}
