package me.interrrp.yestp.teleport;

import me.interrrp.yestp.PlayerUtil;
import me.interrrp.yestp.YesTpMod;
import net.minecraft.util.math.BlockPos;

/**
 * Class to manage teleportation.
 */
public class Teleport {
    /**
     * Teleport the player to a given position.
     * 
     * This method is asynchronous due to the fact that it needs to sleep
     * between teleportation steps, and as a result it is not guaranteed that
     * the player will be teleported to the target position.
     * 
     * @param target  The target position.
     * @param delayMs The delay between teleportation steps in milliseconds.
     */
    public static void teleportTo(BlockPos target, long delayMs) {
        new Thread(() -> {
            BlockPos current = PlayerUtil.getPosition();

            while (!current.equals(target)) {
                current = TeleportStep.calculateNextPosition(current, target);
                PlayerUtil.setPosition(current);

                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    YesTpMod.LOGGER.error("Teleportation thread interrupted.");
                    return;
                }
            }
        }).start();
    }

    /**
     * Teleport the player to a given position.
     * 
     * This calls {@link #teleportTo(BlockPos, long)} with a default delay of
     * 100ms.
     * 
     * @param target The target position.
     */
    public static void teleportTo(BlockPos target) {
        teleportTo(target, 100);
    }
}
