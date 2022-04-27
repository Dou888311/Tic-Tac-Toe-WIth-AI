package com.Dou888311;

public class PlayerAIHard extends PlayerAI{

    PlayerAI AIEasy;
    PlayerAIMedium AIMedium;

    public PlayerAIHard(Field currentField) {super(currentField);}
    public PlayerAIHard(Field currentField, PlayerAI easy) {
        super(currentField);
        AIEasy = easy;
    }
    public PlayerAIHard(Field currentField, PlayerAIMedium AIMedium) {
        super(currentField);
        this.AIMedium = AIMedium;
    }

    int[] AIturn() {
        System.out.println("Making move level \"hard\"");
        MiniMaxTurn mini = new MiniMaxTurn();
        return mini.go(currentField.field);
    }

    void gameHardEasy() {
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

    void gameHardMedium() {
        currentField.fieldPrint();
        boolean button = false;
        while (!button) {
            currentField.gridChange(AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
            if (button) {
                return;
            }
            currentField.gridChange(AIMedium.AIturn());
            currentField.fieldPrint();
            button = currentField.winCheck();
        }
    }

    void gameHardHard() {
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
}
