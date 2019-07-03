package me.intelligence.emotes.commands;

import me.intelligence.emotes.utils.Cooldown;
import me.intelligence.emotes.utils.Perm;
import me.intelligence.intelapi.command.CommandInfo;
import me.intelligence.intelapi.command.IntelCommand;
import me.intelligence.intelapi.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "triggered")
public class TriggeredCommand extends IntelCommand {

    protected void onCommand(final Player player, final String[] args) {
        if (Perm.tryPerm(player, "emotes.triggered", "&c&l[!] &cYou have not unlocked this emote!") && Cooldown.getInstance().tryGo(player, 30, "triggered")) {
            Bukkit.broadcastMessage(CC.translate("&4&l[!] &7" + player.getName() + " is &4&lTRIGGERED&7!"));
        }
    }
}
