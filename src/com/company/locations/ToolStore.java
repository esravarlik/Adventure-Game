package com.company.locations;

import com.company.Armor;
import com.company.Gun;
import com.company.Player;

import java.util.Scanner;

public class ToolStore extends NormalLocation{
    public Scanner input = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player," Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Store");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 Guns");
            System.out.println("2 Armors");
            System.out.println("3 Exit");
            System.out.println("Your choice of id: ");
            int selectCase = input.nextInt();
            while(selectCase < 1 || selectCase > 3){
                System.out.println("Invalid value. Your choice of id: ");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printGun();
                    buyGun();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you again.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printGun() {
        System.out.println("Guns: ");
        for (Gun g : Gun.guns()) {
            System.out.println(g.getId() + g.getGunName() + " <Money: " +
                    g.getPrice() + " Damage: " + g.getDamage() + ">");
        }
        System.out.println("0 Exit");
    }

    public void buyGun(){

        System.out.println("Choose a gun: ");
        int selectGunId = input.nextInt();
        while (selectGunId < 0 || selectGunId > Gun.guns().length) {
            System.out.println("Invalid value. Your choice of id: ");
            selectGunId = input.nextInt();
        }
        if(selectGunId != 0){

            Gun selectedGun = Gun.getGunObjById(selectGunId);

            if (selectedGun != null) {
                if (selectedGun.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money.");
                } else {
                    System.out.println(selectedGun.getGunName() + " you bought the gun.");
                    int balance = this.getPlayer().getMoney() - selectedGun.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setGun(selectedGun);
                    System.out.println("New gun: " + this.getPlayer().getInventory().getGun().getGunName());

                }
            }
        }
    }

    public void printArmor(){
        System.out.println("2 Armors");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + a.getName() + " <Money: " +
                    a.getPrice() + " Block: " + a.getBlock() + ">");
        }
        System.out.println("0 Exit");
    }

    public void buyArmor(){
        System.out.println("Choose a armor: ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Invalid value. Your choice of id: ");
            selectArmorId = input.nextInt();
        }

        if(selectArmorId != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money.");
                } else {
                    System.out.println(selectedArmor.getName() + " you bought the gun.");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your money: " + this.getPlayer().getMoney());

                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("New gun: " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }

    }
}
