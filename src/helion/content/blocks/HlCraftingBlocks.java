package helion.content.blocks;

import mindustry.content.*;
import mindustry.gen.Sounds;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import helion.content.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class HlCraftingBlocks {
    public static Block siliconForge;

    public static void load(){
        siliconForge = new GenericCrafter("silicon-forge"){{
            requirements(Category.crafting, with(Items.beryllium, 50, Items.sand, 4, Items.graphite, 25));
            craftTime = 60f;
            outputItem = new ItemStack(Items.silicon, 1);
            hasPower = true;
            size = 2;
            health = 60;
            hasLiquids = true;
            hasItems = true;
            consumePower(0.6f);
            consumeItems(with(new ItemStack(Items.sand, 4), new ItemStack(Items.graphite, 1)));
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.03f;
        }};
    }
}
