package me.flashyreese.mods.reeses_sodium_options.mixin.sodium;

import me.flashyreese.mods.reeses_sodium_options.client.gui.SodiumVideoOptionsScreen;
import me.jellysquid.mods.sodium.client.gui.SodiumOptionsGUI;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SodiumOptionsGUI.class)
public abstract class MixinSodiumOptionsGUI extends Screen {

    @Shadow
    @Final
    private List<OptionPage> pages;

    @Shadow
    @Final
    private Screen prevScreen;

    protected MixinSodiumOptionsGUI(Component title) {
        super(title);
    }

    @Inject(method = "init", at = @At("TAIL"))
    public void postInit(CallbackInfo ci) {
        this.minecraft.setScreen(new SodiumVideoOptionsScreen(this.prevScreen, this.pages));
    }
}
