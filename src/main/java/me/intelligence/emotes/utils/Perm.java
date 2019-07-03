package me.intelligence.emotes.utils;

import me.intelligence.intelapi.util.CC;
import org.bukkit.entity.Player;

public class Perm {

    public static boolean tryPerm(final Player p, final String perm, final String msg) {
        if (p.hasPermission(perm)) {
            return true;
        }
        p.sendMessage(CC.translate(msg));
        return false;
    }
}
