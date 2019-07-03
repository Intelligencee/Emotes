package me.intelligence.emotes.commands;

import me.intelligence.emotes.utils.Cooldown;
import me.intelligence.emotes.utils.Perm;
import me.intelligence.intelapi.command.CommandInfo;
import me.intelligence.intelapi.command.IntelCommand;
import me.intelligence.intelapi.util.CC;
import me.intelligence.intelapi.util.RandomUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "dab")
public class DabCommand extends IntelCommand {

    protected void onCommand(final Player player, final String[] args) {
        if (Perm.tryPerm(player, "emotes.dab", "&c&l[!] &cYou have not unlocked this emote!") && Cooldown.getInstance().tryGo(player, 30, "dab")) {
            Bukkit.broadcastMessage(CC.translate("&b&l[!] &7" + player.getName() + " dabs &b&l" + ((RandomUtil.getRandom().nextInt(2) == 0) ? "<o/" : "\\o>")));
        }
    }
}
