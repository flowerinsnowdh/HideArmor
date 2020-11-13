package com.hotmail.flowerimsnow.forge.hidearmor.listener;

import com.hotmail.flowerimsnow.forge.hidearmor.HideArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RendererListener {
    private ItemStack[] armors = new ItemStack[4];
    @SubscribeEvent
    public void onRenderLivingPre(RenderLivingEvent.Pre<EntityLiving> e) {
        Minecraft mc = Minecraft.getMinecraft();
        if (e.entity == mc.thePlayer && HideArmor.hide) {
            for (int i = 36;i < 40;i++) {
                armors[i - 36] = mc.thePlayer.inventory.getStackInSlot(i);
                mc.thePlayer.inventory.setInventorySlotContents(i,null);
            }
        }
    }
    @SubscribeEvent
    public void onRenderLivingPost(RenderLivingEvent.Post<EntityLiving> e) {
        Minecraft mc = Minecraft.getMinecraft();
        if (e.entity == mc.thePlayer && HideArmor.hide) {
            for (int i = 36;i < 40;i++) {
                mc.thePlayer.inventory.setInventorySlotContents(i,armors[i - 36]);
                armors[i - 36] = null;
            }
        }
    }
}
