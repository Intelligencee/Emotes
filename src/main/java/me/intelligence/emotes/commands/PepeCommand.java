package me.intelligence.emotes.commands;

import me.intelligence.emotes.utils.Cooldown;
import me.intelligence.emotes.utils.Perm;
import me.intelligence.intelapi.command.CommandInfo;
import me.intelligence.intelapi.command.IntelCommand;
import me.intelligence.intelapi.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "pepe")
public class PepeCommand extends IntelCommand {

    protected void onCommand(final Player player, final String[] args) {
        if (Perm.tryPerm(player, "emotes.pepe", "&c&l[!] &cYou have not unlocked this emote!") && Cooldown.getInstance().tryGo(player, 30, "pepe")) {
            Bukkit.broadcastMessage(CC.translate("&c&l[!] &7" + player.getName() + " goes &c&lREEEE \u30fd\u0f3c \u0ca0\u76ca\u0ca0 \u0f3d\uff89"));
        }
    }
}
