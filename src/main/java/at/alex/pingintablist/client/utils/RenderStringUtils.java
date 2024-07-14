package at.alex.pingintablist.client.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;

public class RenderStringUtils {
    public static void renderScaledText(GuiGraphics guiGraphics,String text, int x, int y, int color, float scale) {
        Font font = Minecraft.getInstance().font;
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();

        // Scale the text
        poseStack.scale(scale, scale, scale);

        // Draw the string
        guiGraphics.drawString(font, text, (int) (x/scale), (int) (y/scale),color);

        // Restore the previous state of the matrix stack
        poseStack.popPose();
    }
}
