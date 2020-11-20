package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileOperator {
    public File chooseFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".png") | f.isDirectory();
            }

            @Override
            public String getDescription() {
                return null;
            }
        });
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.showDialog(null, "OK");
        return chooser.getSelectedFile();
    }

    public File createFile(String filename) {
        File file = null;
        try {
            file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return file;
    }
}
