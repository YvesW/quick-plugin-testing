package com.ywcode.quickplugintesting;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class QuickPluginTestingTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(QuickPluginTestingPlugin.class);
		RuneLite.main(args);
	}
}