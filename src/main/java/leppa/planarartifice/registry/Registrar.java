package leppa.planarartifice.registry;

import leppa.planarartifice.main.PlanarArtifice;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = PlanarArtifice.MODID)
public class Registrar {

	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		PABlocks.registerBlocks(event);
	}

	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		PABlocks.registerItemBlocks(event);
		PAItems.registerItems(event);
	}

	@SubscribeEvent
	public static void registerRecipes(Register<IRecipe> event) {
		PARecipes.registerRecipes(event);

		PAAspects.registerItemAspects();
		PAResearch.registerResearch();
		PAMultiblocks.registerMultiblocks();

	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		PABlocks.registerModels();
		PAItems.registerModels();
	}

}
