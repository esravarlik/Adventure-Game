package com.company;

public class Inventory {
    private Gun gun;
    private Armor armor;

    public Inventory() {
        this.setGun(new Gun("Punch", -1,0,0));
        this.setArmor(new Armor(-1,"None", 0,0));
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
