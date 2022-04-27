package com.Dou888311;

import java.util.Arrays;

public class Field {
    char[][] field = new char[3][3];

    public Field() {
        fieldFilling();
    }


    void fieldFilling() {
        for (char[] row : field) {
            Arrays.fill(row, ' ');
        }
    }

    void fieldPrint() {
        System.out.println("---------");
        for (char[] ch : field) {
            System.out.print("| ");
            for (char ch1 : ch) {
                System.out.print(ch1 + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    void gridChange(int[] AI) {
        int row = AI[0];
        int column = AI[1];
        int Xcount = 0;
        int Ocount = 0;
        char sign = 'X';
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'X') {Xcount++;}
                if (field[i][j] == 'O') {Ocount++;}
            }
        }
        if (Xcount > Ocount) {sign = 'O';}
        field[row][column] = sign;
    }

    void gridChange(int row, int column) {
        int Xcount = 0;
        int Ocount = 0;
        char sign = 'X';
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'X') {Xcount++;}
                if (field[i][j] == 'O') {Ocount++;}
            }
        }
        if (Xcount > Ocount) {sign = 'O';}
        field[row][column] = sign;
    }

    boolean winCheck() {
        boolean Xcheck = false;
        boolean Ocheck = false;
        int emptyCell = 0;
        if (field[0][0] + field[0][1] + field[0][2]==264 ||
                field[1][0] + field[1][1] + field[1][2]==264 ||
                field[2][0] + field[2][1] + field[2][2]==264 ||
                field[0][0] + field[1][0] + field[2][0]==264 ||
                field[0][1] + field[1][1] + field[2][1]==264 ||
                field[0][2] + field[1][2] + field[2][2]==264 ||
                field[0][0] + field[1][1] + field[2][2]==264 ||
                field[0][2] + field[1][1] + field[2][0]==264)
        {
            Xcheck = true;
        }
        if (field[0][0] + field[0][1] + field[0][2]==237 ||
                field[1][0] + field[1][1] + field[1][2]==237 ||
                field[2][0] + field[2][1] + field[2][2]==237 ||
                field[0][0] + field[1][0] + field[2][0]==237 ||
                field[0][1] + field[1][1] + field[2][1]==237 ||
                field[0][2] + field[1][2] + field[2][2]==237 ||
                field[0][0] + field[1][1] + field[2][2]==237 ||
                field[0][2] + field[1][1] + field[2][0]==237)
        {
            Ocheck = true;
        }
        if (Xcheck) {
            System.out.println("X wins!");
            return true;
        }
        if (Ocheck) {
            System.out.println("O wins!");
            return true;
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == ' ') {
                    emptyCell++;
                }
            }
        }
        if (emptyCell == 0) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}
