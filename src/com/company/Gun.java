package com.company;

public class Gun {
    private String gunName;
    private int id;
    private int damage;
    private int price;

    public Gun(String gunName ,int id, int damage, int price) {
        this.gunName = gunName;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Gun[] guns(){
        Gun[] gunList = new Gun[3];
        gunList[0] = new Gun("Pistol",1,2,20 );
        gunList[1] = new Gun("Sword",2,3,30 );
        gunList[2] = new Gun("Rifle",3,7,40 );
        return gunList;
    }

    public static Gun getGunObjById(int id){
        for(Gun g: Gun.guns()){
            if(g.getId() == id){
                return g;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }
}
