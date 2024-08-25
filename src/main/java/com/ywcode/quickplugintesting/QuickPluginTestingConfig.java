package com.ywcode.quickplugintesting;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@ConfigGroup("qptesting")
public interface QuickPluginTestingConfig extends Config
{
	@ConfigItem(
		keyName = "greeting",
		name = "Welcome Greeting",
		description = "The message to show to the user when they login"
	)
	default String greeting()
	{
		return "Hello";
	}

	@ConfigItem(
			keyName = "hotkey1Key",
			name = "Size 1 hotkey",
			description = "The hotkey you'd like to press to activate size 1 (above).<br>"+
					"Can be a combination of keys (e.g. ctrl+L). Reset the key (to 'Not set') to disable this setting.",
			position = 1
	)
	default Keybind hotkey1Key() {
		return Keybind.NOT_SET;
	}
}
