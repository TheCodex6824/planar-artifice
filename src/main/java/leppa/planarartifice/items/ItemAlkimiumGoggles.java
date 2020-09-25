package leppa.planarartifice.items;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.render.IRenderBauble;
import leppa.planarartifice.main.PlanarArtifice;
import leppa.planarartifice.registry.PAItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.items.IGoggles;
import thaumcraft.api.items.IRevealer;
import thaumcraft.api.items.IVisDiscountGear;
import thaumcraft.client.lib.UtilsFX;

public class ItemAlkimiumGoggles extends ItemArmor implements IRevealer, IGoggles, IVisDiscountGear, IBauble, IRenderBauble {

	public static final ResourceLocation BAUBLE_TEXTURE = new ResourceLocation(PlanarArtifice.MODID, "textures/items/alkimium/alkimium_goggles_bauble.png");

	public ItemAlkimiumGoggles(String name, ArmorMaterial mat) {
		super(mat, 3, EntityEquipmentSlot.HEAD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(PlanarArtifice.creativetab);

		PAItems.ITEMS.add(this);

	}

	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	public int getVisDiscount(ItemStack stack, EntityPlayer player) {
		return 10;
	}

	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.HEAD;
	}

	public EnumRarity getRarity(ItemStack stack) {
		return PlanarArtifice.rarityPA;
	}

	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float ticks) {
		if(type == IRenderBauble.RenderType.HEAD) {
			boolean armor = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null;
			Minecraft.getMinecraft().renderEngine.bindTexture(BAUBLE_TEXTURE);
			IRenderBauble.Helper.translateToHeadLevel(player);
			IRenderBauble.Helper.translateToFace();
			IRenderBauble.Helper.defaultTransforms();
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.translate(-0.5D, -0.5D, armor ? 0.11999999731779099D : 0.0D);
			UtilsFX.renderTextureIn3D(0.0F, 0.0F, 1.0F, 1.0F, 16, 26, 0.1F);
		}
	}
	
	public static boolean shouldRenderHud(EntityPlayer player) {
		if(player.inventory.armorItemInSlot(3).getItem() == PAItems.alkimium_goggles)
			return true;
		if(BaublesApi.isBaubleEquipped(player, PAItems.alkimium_goggles) != -1)
			return true;
		return false;
		
	}
}
