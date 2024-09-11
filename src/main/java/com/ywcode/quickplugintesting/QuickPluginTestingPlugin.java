package com.ywcode.quickplugintesting;


import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ScriptEvent;
import net.runelite.api.events.AccountHashChanged;
import net.runelite.api.events.ActorDeath;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.AreaSoundEffectPlayed;
import net.runelite.api.events.BeforeMenuRender;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.CanvasSizeChanged;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ClanChannelChanged;
import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.CommandExecuted;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.DraggingWidgetChanged;
import net.runelite.api.events.FakeXpDrop;
import net.runelite.api.events.FocusChanged;
import net.runelite.api.events.FriendsChatChanged;
import net.runelite.api.events.FriendsChatMemberJoined;
import net.runelite.api.events.FriendsChatMemberLeft;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.api.events.GrandExchangeSearched;
import net.runelite.api.events.GraphicChanged;
import net.runelite.api.events.GraphicsObjectCreated;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemQuantityChanged;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOpened;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.MenuShouldLeftClick;
import net.runelite.api.events.NameableNameChanged;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.PlayerChanged;
import net.runelite.api.events.PlayerDespawned;
import net.runelite.api.events.PlayerMenuOptionsChanged;
import net.runelite.api.events.PlayerSpawned;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.events.PostHealthBarConfig;
import net.runelite.api.events.PostItemComposition;
import net.runelite.api.events.PostMenuSort;
import net.runelite.api.events.PostObjectComposition;
import net.runelite.api.events.PostStructComposition;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.RemovedFriend;
import net.runelite.api.events.ResizeableChanged;
import net.runelite.api.events.ScriptCallbackEvent;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.events.ScriptPreFired;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.UsernameChanged;
import net.runelite.api.events.VarClientIntChanged;
import net.runelite.api.events.VarClientStrChanged;
import net.runelite.api.events.VarbitChanged;
import net.runelite.api.events.VolumeChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import net.runelite.api.events.WidgetClosed;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.events.WorldChanged;
import net.runelite.api.events.WorldListLoad;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetUtil;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ChatboxInput;
import net.runelite.client.events.ClientShutdown;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.ConfigSync;
import net.runelite.client.events.ExternalPluginsChanged;
import net.runelite.client.events.InfoBoxMenuClicked;
import net.runelite.client.events.NotificationFired;
import net.runelite.client.events.NpcLootReceived;
import net.runelite.client.events.OverlayMenuClicked;
import net.runelite.client.events.PartyChanged;
import net.runelite.client.events.PartyMemberAvatar;
import net.runelite.client.events.PlayerLootReceived;
import net.runelite.client.events.PluginChanged;
import net.runelite.client.events.PrivateMessageInput;
import net.runelite.client.events.ProfileChanged;
import net.runelite.client.events.RuneScapeProfileChanged;
import net.runelite.client.events.ScreenshotTaken;
import net.runelite.client.events.SessionClose;
import net.runelite.client.events.SessionOpen;
import net.runelite.client.events.WorldsFetch;
import net.runelite.client.party.PartyService;
import net.runelite.client.party.events.UserJoin;
import net.runelite.client.party.events.UserPart;
import net.runelite.client.party.messages.PartyChatMessage;
import net.runelite.client.party.messages.UserSync;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.dpscounter.DpsUpdate;
import net.runelite.client.plugins.party.messages.LocationUpdate;
import net.runelite.client.plugins.party.messages.StatusUpdate;
import net.runelite.client.plugins.party.messages.TilePing;
import net.runelite.client.plugins.specialcounter.SpecialCounterUpdate;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@PluginDescriptor(
		name = "Quick Plugin Testing",
		description = "Quick plugin testing",
		tags = {"quick,test"}
)

public class QuickPluginTestingPlugin extends Plugin {

	private static final Map<Integer, Integer> scriptMap = new HashMap<>();
	private static final Map<Integer, String> widgetNames = new HashMap<>();
	private static final String CONFIG_GROUP = "qptesting";

	@Inject
	private Client client;

	@Inject
	private QuickPluginTestingConfig config;

	@Inject
	private ConfigManager configManager;

	@Inject
	private ClientThread clientThread;

	@Inject
	private PartyService partyService;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private OverlayManager overlayManager;

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
	public void onChatboxInput(ChatboxInput chatboxInput) {
	}

	@Subscribe
	public void onChatMessage(ChatMessage chatMessage) {
		//if (chatMessage.getType() == ChatMessageType.PUBLICCHAT && chatMessage.getName() == client.getLocalPlayer().getName()) {
		//}
	}

	//@Subscribe
	//public void onChatInput(ChatInput chatInput) {
	//}

	@Subscribe
	public void onClientShutdown(ClientShutdown clientShutdown) {
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
		if (commandExecuted.getCommand().equalsIgnoreCase("test")) {
			//code here
			//outputCommandArguments(commandExecuted);
			//findVarp(15);
			//findVarc("hello world", true);
			//findVarc("5", false);
			//findVarbit(7);
		}
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged configChanged) {
		if (configChanged.getGroup().equals(CONFIG_GROUP)) {

		}
	}

	@Subscribe
	public void onConfigSync(ConfigSync configSync) {
	}

	@Subscribe
	public void onDecorativeObjectDespawned(DecorativeObjectDespawned decorativeObjectDespawned) {
	}

	@Subscribe
	public void onDecorativeObjectSpawned(DecorativeObjectSpawned decorativeObjectSpawned) {
	}

	@Subscribe
	public void onDpsUpdate(DpsUpdate dpsUpdate) {
	}

	@Subscribe
	public void onDraggingWidgetChanged(DraggingWidgetChanged draggingWidgetChanged) {
	}

	@Subscribe
	public void onExternalPluginsChanged(ExternalPluginsChanged externalPluginsChanged) {
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
	public void onInfoBoxMenuClicked(InfoBoxMenuClicked infoBoxMenuClicked) {
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
	public void onLocationUpdate(LocationUpdate locationUpdate) {
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
	public void onNotificationFired(NotificationFired notificationFired) {
	}

	@Subscribe
	public void onNpcChanged(NpcChanged npcChanged) {
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned npcDespawned) {
	}

	@Subscribe
	public void	onNpcLootReceived(NpcLootReceived npcLootReceived) {
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned npcSpawned) {
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged overheadTextChanged) {
	}

	@Subscribe
	public void onOverlayMenuClicked(OverlayMenuClicked overlayMenuClicked) {
	}

	@Subscribe
	public void onPartyChanged(PartyChanged partyChanged) {
	}

	@Subscribe
	public void onPartyChatMessage(PartyChatMessage partyChatMessage) {
	}

	@Subscribe
	public void onPartyMemberAvatar(PartyMemberAvatar partyMemberAvatar) {
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
	public void onPlayerLootReceived(PlayerLootReceived	playerLootReceived) {
	}

	@Subscribe
	public void onPlayerSpawned(PlayerSpawned playerSpawned) {
	}

	@Subscribe
	public void onPluginChanged(PluginChanged pluginChanged) {
	}

	@Subscribe
	public void onPostClientTick(PostClientTick postClientTick) {
	}

	@Subscribe
	public void onPostHealthBarConfig(PostHealthBarConfig postHealthBarConfig) {
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
	public void onPrivateMessageInput(PrivateMessageInput privateMessageInput) {
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
	public void onRuneScapeProfileChanged(RuneScapeProfileChanged runeScapeProfileChanged) {
	}

	@Subscribe
	public void onScreenshotTaken(ScreenshotTaken screenshotTaken) {
	}

	@Subscribe
	public void onScriptCallbackEvent(ScriptCallbackEvent scriptCallbackEvent) {
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired scriptPostFired) {
	}

	@Subscribe
	public void onScriptPreFired(ScriptPreFired scriptPreFired) {
		//getScriptStack(scriptPreFired, 57);
		//getScriptArguments(scriptPreFired, 57, true);
		//getScriptStack(scriptPreFired, 2153);
		//getScriptArguments(scriptPreFired, 2153, true);
		
		//outputScriptIds(scriptPreFired, 35);
	}

	@Subscribe
	public void onSessionClose(SessionClose sessionClose) {
	}

	@Subscribe
	public void onSessionOpen(SessionOpen sessionOpen) {
	}

	@Subscribe
	public void onSoundEffectPlayed(SoundEffectPlayed soundEffectPlayed) {
	}

	@Subscribe
	public void onSpecialCounterUpdate(SpecialCounterUpdate specialCounterUpdate) {
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged) {
	}

	@Subscribe
	public void onStatusUpdate(StatusUpdate statusUpdate) {
	}

	@Subscribe
	public void onUserJoin(UserJoin userJoin) {
	}

	@Subscribe
	public void onUserSync(UserSync userSync) {
	}

	@Subscribe
	public void onTilePing(TilePing tilePing) {
	}

	@Subscribe
	public void onUsernameChanged(UsernameChanged usernameChanged) {
	}

	@Subscribe
	public void onUserPart(UserPart userPart) {
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
	public void onWorldsFetch(WorldsFetch worldsFetch) {
	}

	@Subscribe
	public void onWorldListLoad(WorldListLoad worldListLoad) {
	}

	@SuppressWarnings("SameParameterValue")
	private void getScriptStack(ScriptPreFired scriptPreFired, int scriptIdToMatch) {
		//Gets the script stack and its content when it fires. Should be used in onScriptPreFired
		final int scriptId = scriptPreFired.getScriptId();
		if (scriptId != scriptIdToMatch) {
			//We don't want to look at this script, return
			return;
		}

		final int intStackSize = client.getIntStackSize();
		final int[] intStack = client.getIntStack();
		System.out.println(scriptId + " intStackSize = " + intStackSize + " at tick " + client.getTickCount());
		for (int i = 0; i < intStackSize; i++) {
			System.out.println(scriptId + " intStack[" + i + "] = " + intStack[i]);
		}
		final int stringStackSize = client.getStringStackSize();
		final String[] stringStack = client.getStringStack();
		System.out.println(scriptId + " stringStackSize = " + stringStackSize);
		for (int i = 0; i < stringStackSize; i++) {
			System.out.println(scriptId + " stringStack[" + i + "] = " + stringStack[i]);
		}
	}

	@SuppressWarnings("SameParameterValue")
	private void getScriptArguments(ScriptPreFired scriptPreFired, int scriptIdToMatch, boolean printExtraStuff) {
		//Gets i.a. the script arguments. Should be used in onScriptPreFired. boolean printExtraStuff in case you also want to print Op stuff and typedKeyChar/Code
		//If you want to get the scripts that are fired because of this script, check RuneLite's script inspector!
		final int scriptId = scriptPreFired.getScriptId();
		if (scriptId != scriptIdToMatch) {
			//Not the script we want to look at
			return;
		}

		final ScriptEvent scriptEvent = scriptPreFired.getScriptEvent();
		final int currentTickCount = client.getTickCount();
		if (scriptEvent != null) {
			final Widget scriptSource = scriptEvent.getSource();
			if (scriptSource != null) {
				final int scriptSourceId = scriptSource.getId();
				System.out.println(scriptId + " source = " + scriptSource + " at tick " + currentTickCount);
				System.out.println(scriptId + " WidgetUtil.componentToInterface(scriptSourceId) = " + WidgetUtil.componentToInterface(scriptSourceId));
				System.out.println(scriptId + " WidgetUtil.componentToId(scriptSourceId) = " + WidgetUtil.componentToId(scriptSourceId));
				System.out.println(scriptId + " scriptSource.getIndex() = " + scriptSource.getIndex());
				var name = getWidgetName(scriptSourceId);
				if (name != null) {
					System.out.println("WidgetName = " + name);
				}
			} else {
				System.out.println(scriptId + " scriptSource = null at tick " + currentTickCount);
			}

			final Object[] scriptArguments = scriptEvent.getArguments();
			System.out.println(scriptId + " Arg length = " + scriptArguments.length);
			for (Object scriptArgument : scriptArguments) {
				System.out.println(scriptArgument);
			}
			System.out.println("Done printing script arguments.");

			if (printExtraStuff) {
				System.out.println(scriptId + " scriptEvent.getOp() = " + scriptEvent.getOp());
				System.out.println(scriptId + " scriptEvent.getOpbase() = " + scriptEvent.getOpbase());
				System.out.println(scriptId + " scriptEvent.getTypedKeyChar() = " + scriptEvent.getTypedKeyChar());
				System.out.println(scriptId + " scriptEvent.getTypedKeyCode() = " + scriptEvent.getTypedKeyCode());
			}

		} else {
			System.out.println(scriptId + " scriptEvent = null at tick " + currentTickCount);
		}
	}

	@SuppressWarnings("SameParameterValue")
	private void outputScriptIds(ScriptPreFired scriptPreFired, int gameCycles) {
		//Useful for finding scriptIds without being spammed by scripts that run every client tick. Should be used in onScriptPreFired
		//gameCycles should be the amount of client ticks between how often the event fires.
		final int id = scriptPreFired.getScriptId();
		final int currentGameCycle = client.getGameCycle();
		if (scriptMap.containsKey(id)) {
			final int cyclesPassed = currentGameCycle - scriptMap.get(id);
			if (cyclesPassed >= gameCycles) {
				System.out.println("Cycles (client ticks) passed: " + cyclesPassed + " scriptId: " + id);
			}
		}
		scriptMap.put(id, currentGameCycle); //Put it in there if it's not in the HashMap or update the value
	}

	@SuppressWarnings("SameParameterValue")
	private void ifVarChanged(VarbitChanged varbitChanged, int varIdToMatch, boolean varbit) {
		//If the Varbit (true) or Varp (false) with this Id changes, it gets outputted. Useful to use in onVarbitChanged
		if (varbit && varbitChanged.getVarbitId() == varIdToMatch) {
			System.out.println(client.getTickCount() + " Varbit " + varbitChanged.getVarbitId() + " changed to " + varbitChanged.getValue());
		}
		if (!varbit && varbitChanged.getVarpId() == varIdToMatch) {
			System.out.println(client.getTickCount() + " Varp " + varbitChanged.getVarpId() + " changed to " + varbitChanged.getValue());
		}
	}

	@SuppressWarnings("SameParameterValue")
	private void ifVarClientIntChanged(VarClientIntChanged varClientIntChanged, int varclientIndexToMatch) {
		//If the VarClientInt with this Index/Id changes, it gets outputted. Useful to use in onVarclientIntChanged
		final int varcIndex = varClientIntChanged.getIndex();
        if (varcIndex != varclientIndexToMatch) {
			//Not the varcInt we want to look at
            return;
        }

        System.out.println(client.getTickCount() + " VarClientInt " + varcIndex + " changed to " + client.getVarcIntValue(varcIndex));
    }

	@SuppressWarnings("SameParameterValue")
	private void ifVarClientStrChanged(VarClientStrChanged varClientStrChanged, int varclientIndexToMatch) {
		//If the VarClientStr with this Index/Id changes, it gets outputted. Useful to use in onVarclientStrChanged
		final int varcStrIndex = varClientStrChanged.getIndex();
        if (varcStrIndex != varclientIndexToMatch) {
            return;
        }

        System.out.println(client.getTickCount() + " VarClientStr " + varcStrIndex + " changed to " + client.getVarcStrValue(varcStrIndex));
    }

	@SuppressWarnings("SameParameterValue")
	private void findVarbit(int desiredValue) {
		//Iterate through Varbits to find matching varbits based on value. Outputs the VarbitId and VarbitValue
		try {
			//This is such a hacky solution find the max varbit size... There must be a better way, but I can't find it right now in the API...
			for (int i = 0; i < 1000000; i++) {
				if (client.getVarbitValue(i) == desiredValue) {
					System.out.println("Varbit " + i + " matches value: " + client.getVarbitValue(i));
				}
			}
			System.out.println("findVarbit has succesfully completed looping client.getVarbitValue(i) for 0<=i<1000000. This should not happen.");
		} catch (IndexOutOfBoundsException indexOutOfBoundsException) {
			final int lastAvailableVarbit = Integer.parseInt(indexOutOfBoundsException.getMessage().replace("Varbit ", "").replace(" does not exist", "")) - 1;
			System.out.println("Last available varbitId = " + lastAvailableVarbit);
		}
		System.out.println("findVarbit completed looking for " + desiredValue);
	}

	@SuppressWarnings("SameParameterValue")
	private void findVarp(int desiredValue) {
		//Iterate through Varps to find matching Varps based on value. Outputs the VarpId and VarpValue
		final int[] varps = client.getVarps();
		for (int i = 0; i < varps.length; i++) {
			if (varps[i] == desiredValue) {
				System.out.println("Varp " + i + " matches value: " + varps[i] + System.lineSeparator() +"client.getVarpValue = " + client.getVarpValue(i));
			}
		}
		System.out.println("findVarp completed looking for " + desiredValue);
	}

	@SuppressWarnings("SameParameterValue")
	private void findVarc(String desiredValue, boolean contains) {
		//Iterate through Varc map looking for a Varc value. Displays both the VarcId (key) and the value.
		//Set contains to true to check if the Varc contains the value, not equals.
		final Map<Integer,Object> varcMap = client.getVarcMap();
		for (Map.Entry<Integer, Object> entry : varcMap.entrySet()) {
			final String entryValue = Text.standardize(entry.getValue().toString());
			final String desiredValueStandardized = Text.standardize(desiredValue);
			if (contains) {
				if (entryValue.contains(desiredValueStandardized)) {
					final int key = entry.getKey();
					System.out.println("Varc " + key + " CONTAINS desired value: " + key + System.lineSeparator() + "client.getVarcIntValue = " + client.getVarcIntValue(key) + " client.getVarcStrValue = " + client.getVarcStrValue(key));
				}
			} else { //if (!contains)
				if (entryValue.equals(desiredValueStandardized)) { // no equalsIgnoreCase required because Text.standardize does .toLowerCase
					final int key = entry.getKey();
					System.out.println("Varc " + key + " EQUALS desired value: " + entry.getValue() + System.lineSeparator() + "client.getVarcIntValue = " + client.getVarcIntValue(key) + " client.getVarcStrValue = " + client.getVarcStrValue(key));
				}
			}
		}
		System.out.println("findVarc completed looking for " + desiredValue);
	}

	@SuppressWarnings("SameParameterValue")
	private void onVarcValueChangedTo(VarClientStrChanged varClientStrChanged, String desiredValue, boolean contains) {
		//Use this in onVarClientStrChanged to only output VarCStrs with this specific value
		final int index = varClientStrChanged.getIndex();
		final String stringValue = Text.standardize(client.getVarcStrValue(index));
		desiredValue = Text.standardize(desiredValue);
		if (contains && stringValue.contains(desiredValue)) {
			System.out.println("VarcStr " + index + " CONTAINS desired value: " + stringValue);
		}
		if (!contains && stringValue.equals(desiredValue)) { // no equalsIgnoreCase required because Text.standardize does .toLowerCase
			System.out.println("VarcStr " + index + " MATCHES desired value: " + stringValue);
		}
	}

	@SuppressWarnings("SameParameterValue")
	private void outputCommandArguments(CommandExecuted commandExecuted) {
		//Iterates over all the command arguments (e.g. ::test 5 6 7) and printlns them
		//I've completely forgotten the use case for this though. Maybe an example of how to use the arguments?
		final String[] Arguments = commandExecuted.getArguments();
		final int VarArgsSize = Arguments.length;
		for (int i = 0; i < VarArgsSize; i++) { //Can be replaced with enhanced for.
			System.out.println("Argument " + Arguments[i] + " at position " + i);
		}
	}

	private boolean isCommandName(CommandExecuted commandExecuted, String commandNameToMatch) { //meh, doesn't really save any time
		return commandExecuted.getCommand().equalsIgnoreCase(commandNameToMatch);
	}

	private static String getWidgetName(int componentId) {
		//Yoinked from the widgetinspector, gets used in the scriptinspector
		if (widgetNames.isEmpty()) {
			//Initialize map here, so it doesn't create the index
			//until it's actually needed.
			try {
				for (Field f : ComponentID.class.getDeclaredFields()) {
					widgetNames.put(f.getInt(null), f.getName());
				}
			} catch (IllegalAccessException ex) {
				System.out.println("error setting up widget names: " + ex);
			}
		}
		return widgetNames.get(componentId);
	}

	@Provides
	QuickPluginTestingConfig provideConfig(ConfigManager configManager)	{
		return configManager.getConfig(QuickPluginTestingConfig.class);
	}
}
