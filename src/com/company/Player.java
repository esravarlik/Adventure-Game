package com.company;

import com.company.characters.ArcherCharacter;
import com.company.characters.GameCharacter;
import com.company.characters.KnightCharacter;
import com.company.characters.SamuraiCharacter;
import com.company.locations.Location;
import com.company.locations.SafeHouse;
import com.company.locations.ToolStore;

import java.util.Scanner;

public class Player {
    private String name;
    private String characterName;
    private int damage;
    private int health;
    private int money;
    private Inventory inventory;

    public Scanner input = new Scanner(System.in);

    public Player(String name){
        this.name = name;
        this.setInventory(new Inventory());
    }

    public void selectCharacter(){
        GameCharacter[] characterList = {
                new SamuraiCharacter(),
                new ArcherCharacter(),
                new KnightCharacter(),
        };

        System.out.println("----------------------------------------------------------");
        for(GameCharacter gameCharacter: characterList){
            System.out.println("Character: "+ gameCharacter.getCharacterName() +
                    "\tId: " + gameCharacter.getId() +
                    "\tDamage: " + gameCharacter.getDamage() +
                    "\tHealth " + gameCharacter.getHealth() +
                    "\tMoney: " + gameCharacter.getMoney()
            );
        }
        System.out.println("----------------------------------------------------------");

        System.out.println("Please enter a character id: ");
        int selectCharacter = input.nextInt();
        switch (selectCharacter){
            case 1:
                initPlayer(new SamuraiCharacter());
                break;
            case 2:
                initPlayer(new ArcherCharacter());
                break;
            case 3:
                initPlayer(new KnightCharacter());
                break;
            default:
                System.out.println("Enter a valid id.");
                break;
        }
        System.out.println("Character: " + this.getCharacterName() +
                "\tDamage: " + this.getDamage() +
                "\tHealth: " + this.getHealth() +
                "\tMoney: " + this.getMoney() + "Good Choice!");
    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setCharacterName(gameCharacter.getCharacterName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }

    public void selectLocation(){
        Location location = null;
        while(true){
            System.out.println("----------------------------------------------------------");
            System.out.println("Zones: ");
            System.out.println("1 Safe House" +
                    "\n2 Tool Store" +
                    "\n0 Exit");
            System.out.println("Please select the zone id you want to go to.");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolStore(this);
                    break;
                default:
                    location = new SafeHouse(this);
            }
            if(location == null){
                System.out.println("See you again.");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }
    }

    public void printInfo(){
        System.out.println("Gun: " + this.getInventory().getGun().getGunName() +
                ", Armor: " + this.getInventory().getArmor().getName() +
                ", Block: " + this.getInventory().getArmor().getBlock() +
                ", Damage: " + this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney()
                );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getDamage() {
        return damage + this.getInventory().getGun().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }


    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
