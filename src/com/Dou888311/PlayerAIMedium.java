package com.Dou888311;

import java.util.Random;

public class PlayerAIMedium extends PlayerAI{
    PlayerAI AIEasy;
    PlayerAIHard AIHard;
    public PlayerAIMedium(Field currentField) {
        super(currentField);
    }
    public PlayerAIMedium(Field currentField, PlayerAI AIEasy) {
        super(currentField);
        this.AIEasy = AIEasy;
    }
    public PlayerAIMedium(Field currentField, PlayerAIHard AIHard) {
        super(currentField);
        this.AIHard = AIHard;
    }

    char myChar() {
        char myChar = 'X';
        int Xcount = 0;
        int Ocount = 0;
        for (int i = 0; i < currentField.field.length; i++) {
            for (int j = 0; j < currentField.field[i].length; j++) {
                if (currentField.field[i][j] == 'X') {Xcount++;}
                if (currentField.field[i][j] == 'O') {Ocount++;}
            }
        }
        if (Xcount > Ocount) {
            myChar = 'O';
        }
        return myChar;
    }

    int[] AIturn() {
        char myChar = myChar();
        char enemyChar = 'X';
        if (myChar == 'X') {
            enemyChar = 'O';
        }
        int[] turn;
        System.out.println("Making move level \"medium\"");
        turn = rowCheck(myChar);
        if (turn[0] > -1) {return turn;}
        turn = rowCheck(enemyChar);
        if (turn[0] > -1) {return turn;}
        turn = columnCheck(myChar);
        if (turn[0] > -1) {return turn;}
        turn = columnCheck(enemyChar);
        if (turn[0] > -1) {return turn;}
        turn = diagonalCheck(myChar);
        if (turn[0] > -1) {return turn;}
        turn = diagonalCheck(enemyChar);
        if (turn[0] > -1) {return turn;}

        Random random = new Random();
        int row;
        int column;
        do {
            row = random.nextInt(3);
            column = random.nextInt(3);
        } while (currentField.field[row][column] != ' ');
        return new int[] {row, column};
    }

    void gameMediumHard() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            currentField.gridChange(AIHard.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }

    void gameMediumEasy() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            currentField.gridChange(AIEasy.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }

    void gameMediumMedium() {
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

    int[] diagonalCheck(char myChar) {
        // diagonal up-left to down-right
        if (currentField.field[0][0] + currentField.field[1][1] == myChar + myChar & currentField.field[2][2] == ' ') {
            return new int[]{2,2};
        }
        if (currentField.field[0][0] + currentField.field[2][2] == myChar + myChar & currentField.field[1][1] == ' ') {
            return new int[]{1,1};
        }
        if (currentField.field[1][1] + currentField.field[2][2] == myChar + myChar & currentField.field[0][0] == ' ') {
            return new int[] {0,0};
        }
        // diagonal up-right to down-left
        if (currentField.field[0][2] + currentField.field[1][1] == myChar + myChar & currentField.field[2][0] == ' ') {
            return new int[]{2,0};
        }
        if (currentField.field[0][2] + currentField.field[2][0] == myChar + myChar & currentField.field[1][1] == ' ') {
            return new int[]{1,1};
        }
        if (currentField.field[1][1] + currentField.field[2][0] == myChar + myChar & currentField.field[0][2] == ' ') {
            return new int[] {0,2};
        }
        return new int[] {-1, -1};
    }

    int[] rowCheck(char myChar) {
        for (int i = 0; i < currentField.field.length; i++) {
            if (currentField.field[i][0] + currentField.field[i][1] == myChar + myChar & currentField.field[i][2] == ' ') {
                return new int[]{i, 2};
            }
            if (currentField.field[i][0] + currentField.field[i][2] == myChar + myChar & currentField.field[i][1] == ' ') {
                return new int[]{i, 1};
            }
            if (currentField.field[i][1] + currentField.field[i][2] == myChar + myChar & currentField.field[i][0] == ' ') {
                return new int[]{i,0};
            }
        }
        return new int[]{-1, -1};
    }

    int[] columnCheck(char myChar) {
        // first column
        if (currentField.field[0][0] + currentField.field[1][0] == myChar + myChar & currentField.field[2][0] == ' ') {
            return new int[]{2, 0};
        }
        if (currentField.field[0][0] + currentField.field[2][0] == myChar + myChar & currentField.field[1][0] == ' ') {
            return new int[]{1, 0};
        }
        if (currentField.field[1][0] + currentField.field[2][0] == myChar + myChar & currentField.field[0][0] == ' ') {
            return new int[]{0, 0};
        }
        // second column
        if (currentField.field[0][1] + currentField.field[1][1] == myChar + myChar & currentField.field[2][1] == ' ') {
            return new int[]{2, 1};
        }
        if (currentField.field[0][1] + currentField.field[2][1] == myChar + myChar & currentField.field[1][1] == ' ') {
            return new int[]{1, 1};
        }
        if (currentField.field[1][1] + currentField.field[2][1] == myChar + myChar & currentField.field[0][1] == ' ') {
            return new int[]{0, 1};
        }
        // third column
        if (currentField.field[0][2] + currentField.field[1][2] == myChar + myChar & currentField.field[2][2] == ' ') {
            return new int[]{2, 2};
        }
        if (currentField.field[0][2] + currentField.field[2][2] == myChar + myChar & currentField.field[1][2] == ' ') {
            return new int[]{1, 2};
        }
        if (currentField.field[1][2] + currentField.field[2][2] == myChar + myChar & currentField.field[0][2] == ' ') {
            return new int[]{0, 2};
        }
        return new int[]{-1, -1};
    }
}
