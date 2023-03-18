package me.interrrp.yestp;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;

import me.interrrp.yestp.teleport.Teleport;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

import static dev.xpple.clientarguments.arguments.CBlockPosArgumentType.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;

/**
 * A command to manage teleportation.
 */
public class YesTpCommand {
    /**
     * Register the command.
     * 
     * @param dispatcher The command dispatcher.
     */
    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher
                .register(literal("yestp").then(argument("target", blockPos()).executes(YesTpCommand::handleTeleport)));
    }

    /**
     * Handle a teleport command.
     * 
     * This command requires only one argument, which are the target coordinates.
     * 
     * @param ctx The command context.
     * @return Whether the command finished successfully.
     */
    public static int handleTeleport(CommandContext<FabricClientCommandSource> ctx) {
        Teleport.teleportTo(getCBlockPos(ctx, "target"));
        return 1;
    }
}
