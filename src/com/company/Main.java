package com.company;


import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int x = sc.nextInt();
        int sx = sc.nextInt();
        DemCreator demCreator = new DemCreator(s1, s2, x, sx);
        demCreator.createDem();
    }
}
