package me.intelligence.emotes;

import me.intelligence.emotes.commands.*;
import me.intelligence.intelapi.IntelPlugin;

public class Emotes extends IntelPlugin {

    public void onEnable() {
        new DabCommand().register((IntelPlugin)this);
        new LennyCommand().register((IntelPlugin)this);
        new PepeCommand().register((IntelPlugin)this);
        new ShrugCommand().register((IntelPlugin)this);
        new TriggeredCommand().register((IntelPlugin)this);
    }

    public void onDisable() {
        super.onDisable();
    }

    public static String format(final int i) {
        return format(i + "");
    }

    public static String format(final String s) {
        String r = "";
        for (int j = s.length() - 1; j >= 0; --j) {
            r = s.charAt(j) + r;
            if ((s.length() - j) % 3 == 0) {
                r = "," + r;
            }
        }
        if (r.startsWith(",")) {
            return r.substring(1);
        }
        return r;
    }
}
