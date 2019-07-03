package me.intelligence.emotes.utils;

import me.intelligence.intelapi.util.CC;
import org.bukkit.entity.Player;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;

public class Cooldown {

    private static Cooldown instance;
    private HashMap<String, Instant> cools;

    public Cooldown() {
        this.cools = new HashMap<String, Instant>();
    }

    public boolean tryGo(final Player player, final int secs, final String name) {
        final Instant inst = this.cools.get(player.getUniqueId() + name);
        if (!player.hasPermission("emotes.bypass") && inst != null && inst.isAfter(Instant.now())) {
            int sec = (int)((inst.toEpochMilli() - Instant.now().toEpochMilli()) / 1000.0);
            final int min = sec / 60;
            player.sendMessage(CC.translate("&c&l[!] &7You have to wait another&c" + this.s(min, "minute") + this.s(sec, "second") + "&7before using this again!"));
            return false;
        }
        this.cools.put(player.getUniqueId() + name, Instant.now().plus((long)secs, (TemporalUnit) ChronoUnit.SECONDS));
        return true;
    }

    private String s(final int i, final String s) {
        if (i <= 0) {
            return "";
        }
        return " " + i + " " + s + ((i == 1) ? "" : "s");
    }

    public static Cooldown getInstance() {
        return Cooldown.instance;
    }

    static {
        Cooldown.instance = new Cooldown();
    }
}
