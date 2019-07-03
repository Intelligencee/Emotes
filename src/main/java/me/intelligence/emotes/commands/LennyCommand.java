package me.intelligence.emotes.commands;

import me.intelligence.emotes.utils.Cooldown;
import me.intelligence.emotes.utils.Perm;
import me.intelligence.intelapi.command.CommandInfo;
import me.intelligence.intelapi.command.IntelCommand;
import me.intelligence.intelapi.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "lenny")
public class LennyCommand extends IntelCommand {

    protected void onCommand(final Player player, final String[] args) {
        if (Perm.tryPerm(player, "emotes.lenny", "&c&l[!] &cYou have not unlocked this emote!") && Cooldown.getInstance().tryGo(player, 30, "lenny")) {
            Bukkit.broadcastMessage(CC.translate("&e&l[!] &7" + player.getName() + " activates Le Lenny &e( ° \u0296 °)"));
        }
    }
}
