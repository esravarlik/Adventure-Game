
package com.company.locations;

import com.company.Player;
import com.company.monsters.Snake;

import java.util.Random;

public class Mine extends BattleLocation{
    static Random random = new Random();
    public Mine(Player player) {
        super(player, 6, "Mine", new Snake(random.nextInt(3)+4), "Money/Gun/Armor", 5);
    }

}

