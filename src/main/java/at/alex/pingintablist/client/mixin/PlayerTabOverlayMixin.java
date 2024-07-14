package at.alex.pingintablist.client.mixin;


import at.alex.pingintablist.client.utils.Colors;
import at.alex.pingintablist.client.utils.RenderStringUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerTabOverlay.class)
public class PlayerTabOverlayMixin {
    @Shadow @Final private Gui gui;

    /**
     * @author PlayerListHud mod (Alex_265)
     * @reason Overrides the renderPingIcon method in the PlayerTabOverlay class, to render the ping in text instead of the Icon.
     */
    @Overwrite
    public void renderPingIcon(GuiGraphics guiGraphics, int i, int j, int k, PlayerInfo playerInfo) {
        String latency = String.valueOf(playerInfo.getLatency());
        int color = Colors.GRAY;
        if (playerInfo.getLatency() <= 0) {
            latency = "???";
        } else if (playerInfo.getLatency() < 150) {
            color = Colors.GREEN;
        } else if (playerInfo.getLatency() < 300) {
            color = Colors.ORANGE;
        } else if (playerInfo.getLatency() < 600) {
            color = Colors.RED;
        } else if (playerInfo.getLatency() < 1000) {
            color = Colors.DARK_RED;
        } else {
            color = Colors.BLACK;
        }
        RenderStringUtils.renderScaledText(guiGraphics, latency + "ms", j + i - 24, k+1, color,0.75f);
    }
}
