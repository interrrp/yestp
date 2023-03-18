package me.interrrp.yestp;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;

/**
 * Utility class to manage the player.
 */
public class PlayerUtil {
    private static ClientPlayerEntity getPlayer() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client.player;
    }

    /**
     * Get the player's current position.
     * 
     * @return The player's current position.
     */
    public static BlockPos getPosition() {
        return getPlayer().getBlockPos();
    }

    /**
     * Set the player's position.
     * 
     * @param newPosition The new position.
     */
    public static void setPosition(BlockPos newPosition) {
        getPlayer().updatePosition(newPosition.getX(), newPosition.getY(), newPosition.getZ());
    }
}
