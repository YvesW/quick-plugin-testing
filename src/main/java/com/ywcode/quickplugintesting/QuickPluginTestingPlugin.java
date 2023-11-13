package com.ywcode.quickplugintesting;

import java.applet.*;
import java.awt.Component.*;

import net.runelite.api.Point;
import net.runelite.api.clan.*;
import net.runelite.client.ui.overlay.OverlayManager;


import com.google.inject.Provides;
import javax.inject.Inject;
import javax.swing.*;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.*;
import net.runelite.api.widgets.*;
import net.runelite.client.*;
import net.runelite.client.config.*;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.*;
import net.runelite.client.input.*;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.*;
import net.runelite.client.ui.overlay.*;
import net.runelite.client.util.*;

import java.awt.*;
import java.util.*;

@Slf4j
@PluginDescriptor(
		name = "Quick Plugin Testing",
		description = "Quick plugin testing",
		tags = {"quick,test"}
)

public class QuickPluginTestingPlugin extends Plugin {

	@Inject
	private Client client;

	@Inject
	private QuickPluginTestingConfig config;

	@Inject
	private ConfigManager configManager;

	@Override
	public void startUp() throws Exception {
	}

	@Override
	public void shutDown() throws Exception	{
	}

	@Subscribe
	public void onAccountHashChanged(AccountHashChanged accountHashChanged) {
	}

	@Subscribe
	public void onActorDeath(ActorDeath actorDeath) {
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged animationChanged) {
	}

	@Subscribe
	public void onAreaSoundEffectPlayed(AreaSoundEffectPlayed areaSoundEffectPlayed) {
	}

	@Subscribe
	public void onBeforeMenuRender(BeforeMenuRender beforeMenuRender) {
	}

	@Subscribe
	public void onBeforeRender(BeforeRender beforeRender) {
	}

	@Subscribe
	public void onCanvasSizeChanged(CanvasSizeChanged canvasSizeChanged) {
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		//if (chatMessage.getType() == ChatMessageType.PUBLICCHAT && chatMessage.getName() == client.getLocalPlayer().getName()) {
		//}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged) {
		if (configChanged.getGroup().equals("qptesting")) {

		}
	}

	@Subscribe
	public void onClanChannelChanged(ClanChannelChanged clanChannelChanged) {
	}

	@Subscribe
	public void onClanMemberJoined(ClanMemberJoined clanMemberJoined) {
	}

	@Subscribe
	public void onClanMemberLeft(ClanMemberLeft clanMemberLeft) {
	}

	@Subscribe
	public void onClientTick(ClientTick clientTick) {
	}

	@Subscribe
	public void onCommandExecuted(CommandExecuted commandExecuted) {
		if (commandExecuted.getCommand().equals("test")) {
			//code here
			//outputCommandArguments(commandExecuted);
			//findVarp(15);
			//findVarc("hello world", true);
			//findVarc("5", false);
			//findVarbit(7);
		}
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned decorativeObjectDespawned) {
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned decorativeObjectSpawned) {
	}

	@Subscribe
	public void onDraggingWidgetChanged(DraggingWidgetChanged draggingWidgetChanged) {
	}

	@Subscribe
	public void onFakeXpDrop(FakeXpDrop fakeXpDrop) {
	}

	@Subscribe
	public void onFocusChanged(FocusChanged focusChanged) {
	}

	@Subscribe
	public void onFriendsChatChanged(FriendsChatChanged friendsChatChanged) {
	}

	@Subscribe
	public void onFriendsChatMemberJoined(FriendsChatMemberJoined friendsChatMemberJoined) {
	}

	@Subscribe
	public void onFriendsChatMemberLeft(FriendsChatMemberLeft friendsChatMemberLeft) {
	}

	@Subscribe
	public void onGameObjectDespawned(GameObjectDespawned gameObjectDespawned) {
	}

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned gameObjectSpawned) {
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged) {
	}

	@Subscribe
	public void onGameTick(GameTick gameTick) {
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged grandExchangeOfferChanged) {
	}

	@Subscribe
	public void onGrandExchangeSearched(GrandExchangeSearched grandExchangeSearched) {
	}

	@Subscribe
	public void onGraphicChanged(GraphicChanged graphicChanged) {
	}

	@Subscribe
	public void onGraphicsObjectCreated(GraphicsObjectCreated graphicsObjectCreated) {
	}

	@Subscribe
	public void onGroundObjectDespawned(GroundObjectDespawned groundObjectDespawned) {
	}

	@Subscribe
	public void onGroundObjectSpawned(GroundObjectSpawned groundObjectSpawned) {
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied hitsplatApplied) {
	}

	@Subscribe
	public void onInteractingChanged(InteractingChanged interactingChanged) {
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged itemContainerChanged) {
	}

	@Subscribe
	public void onItemDespawned(ItemDespawned itemDespawned) {
	}

	@Subscribe
	public void onItemQuantityChanged(ItemQuantityChanged itemQuantityChanged) {
	}

	@Subscribe
	public void onItemSpawned(ItemSpawned itemSpawned) {
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded menuEntryAdded) {
	}

	@Subscribe
	public void onMenuOpened(MenuOpened menuOpened) {
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked menuOptionClicked) {
	}

	@Subscribe
	public void onMenuShouldLeftClick(MenuShouldLeftClick menuShouldLeftClick) {
	}

	@Subscribe
	public void onNameableNameChanged(NameableNameChanged nameableNameChanged) {
	}

	@Subscribe
	public void onNpcChanged(NpcChanged npcChanged) {
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned) {
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned) {
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged overheadTextChanged) {
	}

	@Subscribe
	public void onPlayerChanged(PlayerChanged playerChanged) {
	}

	@Subscribe
	public void onPlayerDespawned(PlayerDespawned playerDespawned) {
	}

	@Subscribe
	public void onPlayerMenuOptionsChanged(PlayerMenuOptionsChanged playerMenuOptionsChanged) {
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned playerSpawned) {
	}

	@Subscribe
	public void onPostClientTick(PostClientTick postClientTick) {
	}

	@Subscribe
	public void onPostHealthBar(PostHealthBar postHealthBar) {
	}

	@Subscribe
	public void onPostItemComposition(PostItemComposition postItemComposition) {
	}

	@Subscribe
	public void onPostMenuSort(PostMenuSort postMenuSort) {
	}

	@Subscribe
	public void onPostObjectComposition(PostObjectComposition postObjectComposition) {
	}

	@Subscribe
	public void onPostStructComposition(PostStructComposition postStructComposition) {
	}

	@Subscribe
	public void onProfileChanged(ProfileChanged profileChanged){
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved projectileMoved) {
	}

	@Subscribe
	public void onRemovedFriend(RemovedFriend removedFriend) {
	}

	@Subscribe
	public void onResizeableChanged(ResizeableChanged resizeableChanged) {
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent) {
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired) {
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired) {
		//getScriptArguments(scriptPreFired, 178);
		//getScriptArguments(scriptPreFired, ScriptID.CHAT_PROMPT_INIT);
	}

	@Subscribe
	public void onSoundEffectPlayed(SoundEffectPlayed soundEffectPlayed) {
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged) {
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged usernameChanged) {
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged varbitChanged) {
		//ifVarChanged(varbitChanged, 928, true);
		//ifVarChanged(varbitChanged, 929, true);
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged) {
		//ifVarClientIntChanged(varClientIntChanged, 1111);
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged varClientStrChanged) {
		//onVarcValueChangedTo(varClientStrChanged,"hello world", true);
		//ifVarClientStrChanged(varClientStrChanged, 330);
	}

	@Subscribe
	public void onVolumeChanged(VolumeChanged volumeChanged) {
	}

	@Subscribe
	public void onWallObjectDespawned(WallObjectDespawned wallObjectDespawned) {
	}

	@Subscribe
	public void onWallObjectSpawned(WallObjectSpawned wallObjectSpawned) {
	}

	@Subscribe
	public void onWidgetClosed(WidgetClosed widgetClosed) {
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded widgetLoaded) {
	}

	@Subscribe
	public void onWorldChanged(WorldChanged worldChanged) {
	}

	@Subscribe
	public void onWorldListLoad(WorldListLoad worldListLoad) {
	}

	private void getScriptArguments(ScriptPreFired scriptPreFired, int scriptIdToMatch) {
		//Gets the arguments of a script when it fires. Should be used in onScriptPreFired
		int scriptId = scriptPreFired.getScriptId();
		if (scriptId == scriptIdToMatch) {
			int intStackSize = client.getIntStackSize();
			int[] intStack = client.getIntStack();
			System.out.println(scriptId+" intStackSize = "+intStackSize);
			for (int i = 0; i < intStackSize; i++) {
				System.out.println(scriptId+" intStack["+i+"] = "+intStack[i]);
			}
			int stringStackSize = client.getStringStackSize();
			String[] stringStack = client.getStringStack();
			System.out.println(scriptId+" stringStackSize = "+stringStackSize);
			for (int i = 0; i < stringStackSize; i++) {
				System.out.println(scriptId+" stringStack["+i+"] = "+stringStack[i]);
			}
		}
	}

	private void ifVarChanged(VarbitChanged varbitChanged, int varIdToMatch, boolean varbit) {
		//If the Varbit (true) or Varp (false) with this Id changes, it gets outputted. Useful to use in onVarbitChanged
		if (varbit && varbitChanged.getVarbitId() == varIdToMatch) {
			System.out.println(System.currentTimeMillis() + " Varbit " + varbitChanged.getVarbitId() + "changed to " + varbitChanged.getValue());
		}
		if (!varbit && varbitChanged.getVarpId() == varIdToMatch) {
			System.out.println(System.currentTimeMillis() + " Varp " + varbitChanged.getVarpId() + "changed to " + varbitChanged.getValue());
		}
	}

	private void ifVarClientIntChanged(VarClientIntChanged varClientIntChanged, int varclientIndexToMatch) {
		//If the VarClientInt with this Index/Id changes, it gets outputted. Useful to use in onVarclientIntChanged
		if (varClientIntChanged.getIndex() == varclientIndexToMatch) {
			System.out.println(System.currentTimeMillis() + " VarClientInt " + varClientIntChanged.getIndex() + " changed to " + client.getVarcIntValue(varClientIntChanged.getIndex()));
		}
	}

	private void ifVarClientStrChanged(VarClientStrChanged varClientStrChanged, int varclientIndexToMatch) {
		//If the VarClientStr with this Index/Id changes, it gets outputted. Useful to use in onVarclientStrChanged
		if (varClientStrChanged.getIndex() == varclientIndexToMatch) {
			System.out.println(System.currentTimeMillis() + " VarClientStr " + varClientStrChanged.getIndex() + " changed to " + client.getVarcStrValue(varClientStrChanged.getIndex()));
		}
	}

	private void findVarbit(int desiredValue) {
		//Iterate through Varbits to find matching varbits based on value. Outputs the VarbitId and VarbitValue
		try {
			//This is such a hacky solution find the max varbit size... There must be a better way, but I can't find it right now in the API...
			for (int i = 0; i < 1000000; i++) {
				client.getVarbitValue(i);
			}
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			int lastAvailableVarbit = Integer.parseInt(indexOutOfBoundsException.getMessage().replace("Varbit ", "").replace(" does not exist", "")) - 1;
			System.out.println("Last available varbitId = " + lastAvailableVarbit);
			for (int i = 0; i <= lastAvailableVarbit; i++) {
				if (client.getVarbitValue(i) == desiredValue) {
					System.out.println("Varbit " + i + " matches value: " + client.getVarbitValue(i));
				}
			}
		}
		System.out.println("findVarbit completed looking for " + desiredValue);
	}

	private void findVarp(int desiredValue) {
		//Iterate through Varps to find matching Varps based on value. Outputs the VarpId and VarpValue
		int[] varps = client.getVarps();
		for (int i = 0; i < varps.length; i++) {
			if (varps[i] == desiredValue) {
				System.out.println("Varp " + i + " matches value: " + varps[i] + System.lineSeparator() +"client.getVarpValue = " + client.getVarpValue(i));
			}
		}
		System.out.println("findVarp completed looking for " + desiredValue);
	}

	private void findVarc(String desiredValue, boolean contains) {
		//Iterate through Varc map looking for a Varc value. Displays both the VarcId (key) and the value.
		//Set contains to true to check if the Varc contains the value, not equals.
		Map<Integer,Object> varcMap = client.getVarcMap();
		for (Map.Entry<Integer, Object> entry : varcMap.entrySet()) {
			String entryValue = Text.standardize(entry.getValue().toString());
			String desiredValueStandardized = Text.standardize(desiredValue);
			if (contains) {
				if (entryValue.contains(desiredValueStandardized)) {
					System.out.println("Varc " + entry.getKey() + " CONTAINS desired value: " + entry.getValue() + System.lineSeparator() + "client.getVarcIntValue = " + client.getVarcIntValue(entry.getKey()) + " client.getVarcStrValue = " + client.getVarcStrValue(entry.getKey()));
				}
			}
			if (!contains) {
				if (entryValue.equals(desiredValueStandardized)) {
					System.out.println("Varc " + entry.getKey() + " MATCHES value: " + entry.getValue() + System.lineSeparator() + "client.getVarcIntValue = " + client.getVarcIntValue(entry.getKey()) + " client.getVarcStrValue = " + client.getVarcStrValue(entry.getKey()));
				}
			}
		}
		System.out.println("findVarc completed looking for " + desiredValue);
	}

	private void onVarcValueChangedTo(VarClientStrChanged varClientStrChanged, String desiredValue, boolean contains) {
		//Use this in onVarClientStrChanged to only output VarCStrs with this specific value
		int index = varClientStrChanged.getIndex();
		String stringValue = Text.standardize(client.getVarcStrValue(index));
		desiredValue = Text.standardize(desiredValue);
		if (contains && stringValue.contains(desiredValue)) {
			System.out.println("VarcStr " + index + " CONTAINS desired value: " + stringValue);
		}
		if (!contains && stringValue.equals(desiredValue)) {
			System.out.println("VarcStr " + index + " MATCHES desired value: " + stringValue);
		}
	}

	private void outputCommandArguments(CommandExecuted commandExecuted) {
		//Iterates over all the command arguments (e.g. ::test 5 6 7) and printlns them
		//I've completely forgotten the use case for this though. Maybe an example of how to use the arguments?
		String[] Arguments = commandExecuted.getArguments();
		int VarArgsSize = Arguments.length;
		for (int i = 0; i < VarArgsSize; i++) { //Can be replaced with enhanced for.
			System.out.println(Arguments[i]);
		}
	}

	private boolean isCommandName(CommandExecuted commandExecuted, String commandNameToMatch) { //meh, doesn't really save any time
		return commandExecuted.getCommand().equals(commandNameToMatch);
	}

	@Provides
	QuickPluginTestingConfig provideConfig(ConfigManager configManager)	{
		return configManager.getConfig(QuickPluginTestingConfig.class);
	}
}
