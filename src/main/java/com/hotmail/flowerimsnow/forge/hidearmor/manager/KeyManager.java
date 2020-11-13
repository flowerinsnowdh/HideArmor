package com.hotmail.flowerimsnow.forge.hidearmor.manager;

import com.hotmail.flowerimsnow.forge.hidearmor.HideArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class KeyManager {
    public static final KeyBinding SWITCH_ARMORS = new KeyBinding("key.switch.armor", Keyboard.KEY_B,"HideArmor");
    public KeyManager() {
        ClientRegistry.registerKeyBinding(SWITCH_ARMORS);
    }
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent e) {
        Minecraft mc = Minecraft.getMinecraft();
        if (SWITCH_ARMORS.isPressed()) {
            if (HideArmor.hide) mc.thePlayer.addChatComponentMessage(new ChatComponentText("hidearmor.show"));
            else mc.thePlayer.addChatComponentMessage(new ChatComponentText("hidearmor.hide"));
            HideArmor.hide = !HideArmor.hide;
        }
    }
}
