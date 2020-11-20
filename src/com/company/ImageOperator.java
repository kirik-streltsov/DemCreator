package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageOperator {
    public void resizeImage(int width, int height, ImageFile image){
        Image temp = image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics2D graphics2D = img.createGraphics();
        graphics2D.drawImage(temp, 0, 0, null);
        graphics2D.dispose();
        image.setImage(img);
    }
}
