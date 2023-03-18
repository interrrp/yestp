package me.interrrp.yestp.teleport;

import net.minecraft.util.math.BlockPos;

/**
 * Class for teleport step calculations.
 * 
 * Throughout this class, the term "coordinate" is used to refer to the x, y, or
 * z coordinate of a position.
 * 
 * A "valid" position/coordinate refers to one that confines to the Minecraft
 * protocol's limitations.
 */
public class TeleportStep {
    /**
     * The maximum number of blocks to teleport in a single step.
     */
    private static final int MAX_TELEPORT_BLOCKS = 3;

    /**
     * Calculate the next valid position to teleport to.
     * 
     * @param current The current position.
     * @param target  The target position.
     * @return The next position to teleport to.
     */
    public static BlockPos calculateNextPosition(BlockPos current, BlockPos target) {
        int x = calculateNextCoordinate(current.getX(), target.getX());
        int y = calculateNextCoordinate(current.getY(), target.getY());
        int z = calculateNextCoordinate(current.getZ(), target.getZ());

        return new BlockPos(x, y, z);
    }

    /**
     * Calculate the next valid coordinate to teleport to.
     * 
     * This steps the coordinate towards the target coordinate by a maximum of
     * {@link #MAX_TELEPORT_BLOCKS} blocks.
     * 
     * @param current The current coordinate.
     * @param target  The target coordinate.
     * @return The next coordinate to teleport to.
     */
    private static int calculateNextCoordinate(int current, int target) {
        int diff = target - current;

        if (diff > MAX_TELEPORT_BLOCKS) {
            return current + MAX_TELEPORT_BLOCKS;
        } else if (diff < -MAX_TELEPORT_BLOCKS) {
            return current - MAX_TELEPORT_BLOCKS;
        } else {
            return target;
        }
    }
}
