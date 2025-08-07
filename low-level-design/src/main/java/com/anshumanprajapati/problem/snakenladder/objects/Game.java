package com.anshumanprajapati.problem.snakenladder.objects;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class Game {

    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner;

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many dice you wan to play");
        int dice = sc.nextInt();

        System.out.println("How many player");
        int playerSize = sc.nextInt();

        System.out.println("Enter Player id, name");

    }

}
