package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFile {

    private File directory;
    private BufferedImage image;

    public File getDirectory() {
        return this.directory;
    }

    public void setDirectory(File directory) {
        this.directory = directory;
        try {
            ImageIO.write(image, "png", directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        try {
            ImageIO.write(image, "png", directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageFile(File f){
        this.directory = f;
        try {
            this.image = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageFile(BufferedImage image, String filename){
        this.image = image;
        this.directory = (new FileOperator()).createFile(filename);
        try {
            ImageIO.write(image, "png", directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
