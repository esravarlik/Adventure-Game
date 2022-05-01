package com.company.locations;

import com.company.Player;
import com.company.monsters.Monster;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location{

    private int id;
    private Monster monster;
    private String award;
    private int maxMonster;

    public Scanner input = new Scanner(System.in);
    public BattleLocation(Player player,int id, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.id = id;
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();

        System.out.println("Your location: " + this.getName());
        System.out.println("The beast of this map is " + monsterNumber + " " + this.getMonster().getMonsterName());
        System.out.println("Fight<Y> or Flight<N>");
        String selectCase = input.nextLine().toUpperCase();
        if(selectCase.equals("Y")){
            if(combat(monsterNumber)){
                System.out.println(this.getName() + " you have won on this map.");
                if (this.award.equals("Food") && getPlayer().getInventory().isFood() == false) {
                    this.getPlayer().getInventory().setFood(true);
                    System.out.println(this.award + " inventory added! ");
                } else if (this.award.equals("Water") && getPlayer().getInventory().isWater() == false) {
                    System.out.println(this.award + " inventory added!! ");
                    this.getPlayer().getInventory().setWater(true);
                } else if (this.award.equals("Firewood") && getPlayer().getInventory().isFirewood() == false) {
                    System.out.println(this.award + " inventory added!! ");
                    this.getPlayer().getInventory().setFirewood(true);
                }
                return true;
            }
        }
        if(this.getPlayer().getHealth() <= 0){
            System.out.println("You died.");
            return false;
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println("the health of the monster: " + this.getMonster().getMonsterName());
    }

    public boolean combat(int monsterNumber){
        for(int i=1;i <= monsterNumber;i++) {
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            playerStats();
            monsterStats();
            while(this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("Fight<Y> or Flight<N>");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("Y")){
                    System.out.println();
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                    afterHit();
                    if(this.getMonster().getHealth() > 0){
                        System.out.println("Monster Attack!");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(monsterDamage < 0){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getMonster().getHealth());
                        afterHit();
                    }
                }else{
                    return false;
                }
            }
            if(this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("You won the beast.");
                System.out.println(this.getMonster().getAward() + " you made money.");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Your money: " + this.getPlayer().getMoney());
            }else{
                return false;
            }
        }
        return true;
    }

    public void playerStats() {
        System.out.println("The player's: ");
        System.out.println(" Health: " + this.getPlayer().getHealth() +
                "\t Gun: " + this.getPlayer().getInventory().getGun().getGunName() +
                "\t Armor: " + this.getPlayer().getInventory().getArmor().getName() +
                "\t Damage: " + this.getPlayer().getTotalDamage() +
                "\t Money: " + this.getPlayer().getMoney());
        System.out.println("----------------------------------------------------------");
    }

    public  void monsterStats(){
        System.out.println("The monster's: ");
        System.out.println(" Health: " + this.getMonster().getMonsterName() +
                "\t Armor: " + this.getPlayer().getInventory().getArmor().getName() +
                "\t Damage: " + this.getMonster().getDamage() +
                "\t Award: " + this.getMonster().getAward());
    }

    public int randomMonsterNumber(){
        Random random = new Random();
        return random.nextInt(this.getMaxMonster()) + 1;
    }
    

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
