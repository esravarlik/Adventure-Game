package com.company.locations;

import com.company.Player;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the safe house now.");
        return true;
    }
}
