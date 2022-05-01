package com.company.locations;

import com.company.Player;
import com.company.monsters.Bear;
import com.company.monsters.Monster;

public class River extends BattleLocation{
    public River(Player player) {
        super(player,5,"River",new Bear(),"Water",3);
    }
}
