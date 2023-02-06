package me.troldepus2005.blockmania.Worldguard;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;

public class WorldGuardFlags {

    // declare your flag as a field accessible to other parts of your code (so you can use this to check it)
    // note: if you want to use a different type of flag, make sure you change StateFlag here and below to that type
    public static StateFlag allowBlockMania;

    public void onLoad() {
        // ... do your own plugin things, etc

        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            // create a flag with the name "my-custom-flag", defaulting to true
            StateFlag flag = new StateFlag("allow-block-mania", false);
            registry.register(flag);
            allowBlockMania = flag; // only set our field if there was no error
        } catch (FlagConflictException e) {
            // some other plugin registered a flag by the same name already.
            // you can use the existing flag, but this may cause conflicts - be sure to check type
            Flag<?> existing = registry.get("my-custom-flag");
            if (existing instanceof StateFlag) {
                allowBlockMania = (StateFlag) existing;
            } else {
                // types don't match - this is bad news! some other plugin conflicts with you
                // hopefully this never actually happens
            }
        }

    }

}
