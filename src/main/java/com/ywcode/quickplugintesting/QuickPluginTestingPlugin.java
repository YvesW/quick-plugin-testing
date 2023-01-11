package com.ywcode.quickplugintesting;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

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
	}

	@Subscribe
	public void onVarClientIntChanged(VarClientIntChanged varClientIntChanged) {
	}

	@Subscribe
	public void onVarClientStrChanged(VarClientStrChanged varClientStrChanged) {
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

	@Provides
	QuickPluginTestingConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(QuickPluginTestingConfig.class);
	}
}
