package com.shiendstunn;

import com.mojang.brigadier.Command;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

import static net.minecraft.server.command.CommandManager.literal;

public class ShiendstunnMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("fgt")
                .executes(context -> {
                    final ServerPlayerEntity player;

                    try {
                        player = context.getSource().getPlayerOrThrow();
                    } catch (Exception exception) {
                        context.getSource().sendError(
                            Text.literal("Dieser Befehl kann nur von einem Spieler verwendet werden.")
                        );
                        return 0;
                    }

                    GameMode currentMode = player.interactionManager.getGameMode();
                    GameMode nextMode;

                    if (currentMode == GameMode.SURVIVAL) {
                        nextMode = GameMode.CREATIVE;
                    } else if (currentMode == GameMode.CREATIVE) {
                        nextMode = GameMode.SURVIVAL;
                    } else {
                        // Adventure oder Spectator wird beim ersten Aufruf auf Survival gesetzt.
                        nextMode = GameMode.SURVIVAL;
                    }

                    boolean changed = player.changeGameMode(nextMode);
                    if (changed) {
                        String modeName = nextMode == GameMode.CREATIVE ? "Kreativ" : "Überleben";
                        player.sendMessage(
                            Text.literal("§aShiendstunn §8» §fSpielmodus: §e" + modeName),
                            false
                        );
                        return Command.SINGLE_SUCCESS;
                    }

                    player.sendMessage(
                        Text.literal("§cDer Spielmodus konnte nicht geändert werden."),
                        false
                    );
                    return 0;
                })
            )
        );
    }
}
