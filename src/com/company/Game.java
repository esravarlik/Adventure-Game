package com.company;


import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to adventure game.");
        System.out.println("Please enter a name: ");

        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome to " + player.getName().toUpperCase()+ "!");

        System.out.println("Please select a character: ");
        player.selectCharacter();

        player.selectLocation();
        player.printInfo();


    }


}
