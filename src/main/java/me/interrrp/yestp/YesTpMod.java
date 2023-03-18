package me.interrrp.yestp;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * YesTP's mod entrypoint.
 */
public class YesTpMod implements ModInitializer {
	/**
	 * The logger to use for keeping track of events and such.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger("yestp");

	/**
	 * Called when the mod is initialized.
	 */
	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		registerClientCommandRegistrationCallback();
	}

	/**
	 * Register the client command registration callback, where commands will
	 * get registered.
	 */
	private void registerClientCommandRegistrationCallback() {
		ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
			YesTpCommand.register(dispatcher);
		});
	}
}
