package com.Dou888311;

import java.util.Scanner;

public class Player {
    Field currentField;
    PlayerAI rival;

    public Player(Field field, PlayerAI ai) {
        currentField = field;
        rival = ai;
    }

    public Player(Field field) {
        currentField = field;
    }

    void gameHumanHuman() {
        currentField.fieldPrint();
        while (!currentField.winCheck()) {
            turn();
            currentField.fieldPrint();
        }
    }

    void gameAIHuman() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(rival.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            turn();
            currentField.fieldPrint();
            button = currentField.winCheck();

        }
    }

    void gameHumanAI() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            turn();
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {return;}
            currentField.gridChange(rival.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }

    boolean turn() {
        int row;
        int column;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the coordinates: ");
        String[] input = sc.nextLine().split(" ");
        try {
            row = Integer.parseInt(input[0]) - 1;
            column = Integer.parseInt(input[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        if (row > 2 || column > 2 || row < 0 || column < 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        if (currentField.field[row][column] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        currentField.gridChange(row, column);
        return true;
    }
}
