package com.Dou888311;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Field currentField;
    Player player1;
    PlayerAI ai1;
    PlayerAIMedium AIMedium;
    PlayerAIHard AIHard;
    String[] input;
    boolean gameOver = false;


    void action() {
        switch (input[0]) {
            case "exit" :
                return;
            case "start" :
                switch (input[1]) {
                    case "easy":
                        ai1 = new PlayerAI(currentField);
                        switch (input[2]) {
                            case "easy":
                                ai1.gameEasyEasy();
                                break;
                            case "user" :
                                player1 = new Player(currentField, ai1);
                                player1.gameAIHuman();
                                break;
                            case "medium" :
                                ai1 = new PlayerAI(currentField, new PlayerAIMedium(currentField));
                                ai1.gameEasyMedium();
                                break;
                            case "hard" :
                                ai1 = new PlayerAI(currentField, new PlayerAIHard(currentField));
                                ai1.gameEasyHard();
                                break;
                        }
                    break;
                    case "user" :
                        player1 = new Player(currentField);
                        switch (input[2]) {
                            case "easy" :
                                player1 = new Player(currentField, new PlayerAI(currentField));
                                player1.gameHumanAI();
                                break;
                            case "user" :
                                player1.gameHumanHuman();
                                break;
                            case "medium" :
                                player1 = new Player(currentField, new PlayerAIMedium(currentField));
                                player1.gameHumanAI();
                                break;
                            case "hard" :
                                player1 = new Player(currentField, new PlayerAIHard(currentField));
                                player1.gameHumanAI();
                                break;
                        }
                    break;
                    case "medium" :
                        AIMedium = new PlayerAIMedium(currentField);
                        switch (input[2]) {
                            case "easy" :
                                AIMedium = new PlayerAIMedium(currentField, new PlayerAI(currentField));
                                AIMedium.gameMediumEasy();
                                break;
                            case "user" :
                                player1 = new Player(currentField, AIMedium);
                                player1.gameAIHuman();
                                break;
                            case "medium" :
                                AIMedium.gameMediumMedium();
                                break;
                            case "hard" :
                                AIMedium = new PlayerAIMedium(currentField, new PlayerAIHard(currentField));
                                AIMedium.gameMediumHard();
                                break;
                        }
                    break;
                    case "hard" :
                        AIHard = new PlayerAIHard(currentField);
                        switch (input[2]) {
                            case "easy" :
                                AIHard = new PlayerAIHard(currentField, new PlayerAI(currentField));
                                AIHard.gameHardEasy();
                                break;
                            case "user" :
                                player1 = new Player(currentField, AIHard);
                                player1.gameAIHuman();
                                break;
                            case "medium" :
                                AIHard = new PlayerAIHard(currentField, new PlayerAIMedium(currentField));
                                AIHard.gameHardMedium();
                                break;
                            case "hard" :
                                AIHard.gameHardHard();
                                break;
                        }
                    break;
                }
            break;
        }
    }

    void start() {
        ArrayList<String> valid = new ArrayList<>(List.of("exit", "start", "user", "easy", "medium", "hard"));
        while (!gameOver) {
            currentField = new Field();
            System.out.println("Input command: ");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine().split(" ");
            if (input[0].equals("exit")) {
                gameOver = true;
                break;
            }
            if (!valid.containsAll(Arrays.asList(input)) || input.length != 3) {
                System.out.println("Bad parameters!");
            }
            if (valid.containsAll(Arrays.asList(input)) & input.length == 3) {
                action();
            }
        }
    }
}