package com.jackydoge.tidemark_additions.entity.client;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.Tidefin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TidefinRenderer extends GeoEntityRenderer<Tidefin> {

    public TidefinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TidefinModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Tidefin animatable) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "textures/entity/tidefin/tidefin.png");
    }
}
