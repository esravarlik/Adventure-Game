package com.company;

public class Inventory {
    private Gun gun;
    private Armor armor;
    private boolean water;
    private boolean food;
    private boolean firewood;

    public Inventory() {
        this.setGun(new Gun("Punch", -1,0,0));
        this.setArmor(new Armor(-1,"None", 0,0));
        this.water = false;
        this.food = false;
        this.firewood = false;
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

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}
