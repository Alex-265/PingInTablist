package at.alex.pingintablist.client.utils;

import at.alex.pingintablist.client.config.ModConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;

public class RenderStringUtils {
    public static void renderScaledText(GuiGraphics guiGraphics,String text, int x, int y, int color, float scale) {
        Font font = Minecraft.getInstance().font;
        ModConfig config = ModConfig.getInstance();
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();

        // Scale the text
        poseStack.scale(scale * config.fontSize / 12.0f, scale * config.fontSize / 12.0f, 1.0f);

        // Draw the string
        guiGraphics.drawString(font, text, (int) (x/scale), (int) (y/scale),color);

        // Restore the previous state of the matrix stack
        poseStack.popPose();
    }
}
