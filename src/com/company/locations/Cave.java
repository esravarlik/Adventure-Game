package com.company.locations;

import com.company.Player;
import com.company.monsters.Monster;
import com.company.monsters.Zombie;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player,3,"Cave", new Zombie(),"Food",3);
    }
}
