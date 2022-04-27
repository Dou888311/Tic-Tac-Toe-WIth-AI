package com.Dou888311;

import java.util.Random;

public class PlayerAI {
    Field currentField;
    PlayerAIMedium medium;
    PlayerAIHard hard;

    public PlayerAI(Field field) {
        currentField = field;
    }
    public PlayerAI(Field field, PlayerAIMedium medium) {
        this.medium = medium;
        currentField = field;
    }
    public PlayerAI(Field field, PlayerAIHard hard) {
        this.hard = hard;
        currentField = field;
    }

    int[] AIturn() {
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int row = 0;
        int column = 0;
        do {
            row = random.nextInt(3);
            column = random.nextInt(3);
        } while (currentField.field[row][column] != ' ');
        return new int[] {row, column};
    }

    void gameEasyEasy() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }

    void gameEasyMedium() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            currentField.gridChange(medium.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }

    void gameEasyHard() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            currentField.gridChange(hard.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }
}
