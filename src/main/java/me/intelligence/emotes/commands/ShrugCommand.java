package me.intelligence.emotes.commands;

import me.intelligence.emotes.utils.Cooldown;
import me.intelligence.emotes.utils.Perm;
import me.intelligence.intelapi.command.CommandInfo;
import me.intelligence.intelapi.command.IntelCommand;
import me.intelligence.intelapi.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "shrug")
public class ShrugCommand extends IntelCommand {

    protected void onCommand(final Player player, final String[] args) {
        if (Perm.tryPerm(player, "emotes.shrug", "&c&l[!] &cYou have not unlocked this emote!") && Cooldown.getInstance().tryGo(player, 60, "shrug")) {
            Bukkit.broadcastMessage(CC.translate("&a&l[!] &7" + player.getName() + " shrugs &a&l¯\\_(\u30c4)_/¯"));
        }
    }
}
