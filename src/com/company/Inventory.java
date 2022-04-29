package com.company;

public class Inventory {
    private Gun gun;

    public Inventory() {
        this.setGun(new Gun("Punch", 0,0,0));
    }

    public Gun getGun() {
        return gun;
    }

    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
