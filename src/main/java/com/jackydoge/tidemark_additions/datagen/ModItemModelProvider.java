package com.jackydoge.tidemark_additions.datagen;

import com.jackydoge.tidemark_additions.Tidemark_additions;
import com.jackydoge.tidemark_additions.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Tidemark_additions.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        basicItem(ModItems.TIDESCALE.get());
        basicItem(ModItems.DRIFTSTEEL.get());
        basicItem(ModItems.DRIFTSTEEL_FRAGMENT.get());
    }
}
