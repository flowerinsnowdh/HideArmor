package com.hotmail.flowerimsnow.forge.hidearmor;

import com.hotmail.flowerimsnow.forge.hidearmor.listener.RendererListener;
import com.hotmail.flowerimsnow.forge.hidearmor.manager.KeyManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HideArmor.MODID, version = HideArmor.VERSION)
public class HideArmor {
    public static HideArmor instance;
    public static final String MODID = "hidearmor";
    public static final String VERSION = "1.0";
    public static boolean hide = true;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        regListeners(new KeyManager(),new RendererListener());
    }

    private void regListeners(Object... objects) {
        for (Object object : objects) {
            MinecraftForge.EVENT_BUS.register(object);
        }
    }
}
