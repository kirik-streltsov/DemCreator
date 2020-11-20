package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DemCreator {
    private String bigText, smallText;
    private static final int width = 540;
    private static final int height = 540;
    private static final int MAXCHARS = 40;
    private int x, sx;
    private  final ImageOperator imageOperator = new ImageOperator();
    private final FileOperator operator = new FileOperator();
    private ImageFile mainImage, pasteImage;

    public DemCreator(String bigText, String smallText, int x, int sx){
        this.bigText = bigText;
        this.smallText = smallText;
        this.x = x;
        this.sx = sx;
        try {

            File pasteImDir = operator.chooseFile();
            mainImage = new ImageFile(new File("C:\\dem.png"));
            imageOperator.resizeImage(width, height, mainImage);
            pasteImage = new ImageFile(ImageIO.read(pasteImDir), pasteImDir.getPath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if(bigText.length() > MAXCHARS | smallText.length() > MAXCHARS) System.exit(1);
    }

    public void createDem(){
        imageOperator.resizeImage(mainImage.getImage().getWidth() - 300, mainImage.getImage().getHeight() - 100, pasteImage);
        BufferedImage template = new BufferedImage(540, 540, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = template.createGraphics();
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(0,0, width, height);
        graphics2D.setColor(Color.WHITE);
        imageOperator.resizeImage(400, 390, pasteImage);
        graphics2D.drawImage(pasteImage.getImage(), 65, 35, null);
        graphics2D.drawRect(60,30, pasteImage.getImage().getWidth() + 9, pasteImage.getImage().getHeight() + 9);
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        graphics2D.drawString(bigText, x, 455);
        graphics2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        graphics2D.drawString(smallText, sx, 475);
        graphics2D.dispose();
        mainImage.setImage(template);
    }

}
