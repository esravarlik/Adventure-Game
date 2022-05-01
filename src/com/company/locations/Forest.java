package com.company.locations;

import com.company.Player;
import com.company.monsters.Bear;
import com.company.monsters.Monster;
import com.company.monsters.Vampire;

public class Forest extends BattleLocation{

    public Forest(Player player) {
        super(player,4,"Forest", new Vampire(),"Firewood",2);
    }
}
