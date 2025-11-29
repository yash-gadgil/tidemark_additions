package com.jackydoge.tidemark_additions.entity.client;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.entity.custom.AbyssalRay;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AbyssalRayRenderer extends GeoEntityRenderer<AbyssalRay> {

    public AbyssalRayRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AbyssalRayModel());
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AbyssalRay animatable) {
        return ResourceLocation.fromNamespaceAndPath(Tidemark_additions.MOD_ID, "textures/entity/abyssal_ray/abyssal_ray.png");
    }
}

