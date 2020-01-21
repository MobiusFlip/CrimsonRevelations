package com.mobiusflip.crimsonrevelations.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchCategories;

public class CrimsonRecipes {
	public static void initRecipes() {
		initInfusion();
		initCrucible();
		initArcaneCrafting();
	}

	private static void initInfusion() {
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimsonblade"),
				new InfusionRecipe("CRIMSON_BLADE", new ItemStack(ItemsTC.crimsonBlade), 3,
					new AspectList().add(Aspect.AVERSION, 75).add(Aspect.DEATH, 75).add(Aspect.TRAP, 25).add(Aspect.DESIRE, 25),
					new ItemStack(ItemsTC.voidSword), new Object[] {
							ThaumcraftApiHelper.makeCrystal(Aspect.AVERSION), ThaumcraftApiHelper.makeCrystal(Aspect.DEATH), new ItemStack(ItemsTC.plate, 1, 3), BlocksTC.bannerCrimsonCult
					}
			));
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("crimsonrevelations", "praetor_helm"),
			new InfusionRecipe("PRAETOR_ARMOR", new ItemStack(ItemsTC.crimsonPraetorHelm), 2,
					new AspectList().add(Aspect.METAL, 25).add(Aspect.ELDRITCH, 10).add(Aspect.PROTECT, 20),
					new ItemStack(ItemsTC.crimsonPlateHelm), new Object[] {
							new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 0), new ItemStack(ItemsTC.plate, 1, 0), BlocksTC.bannerCrimsonCult
					}
			));
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("crimsonrevelations", "praetor_chestplate"),
				new InfusionRecipe("PRAETOR_ARMOR", new ItemStack(ItemsTC.crimsonPraetorChest), 2,
						new AspectList().add(Aspect.METAL, 25).add(Aspect.ELDRITCH, 10).add(Aspect.PROTECT, 30),
						new ItemStack(ItemsTC.crimsonPlateChest), new Object[] {
								new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 0), BlocksTC.bannerCrimsonCult
						}
				));
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("crimsonrevelations", "praetor_greaves"),
				new InfusionRecipe("PRAETOR_ARMOR", new ItemStack(ItemsTC.crimsonPraetorLegs), 2,
						new AspectList().add(Aspect.METAL, 25).add(Aspect.ELDRITCH, 10).add(Aspect.PROTECT, 25),
						new ItemStack(ItemsTC.crimsonPlateLegs), new Object[] {
								new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 1), new ItemStack(ItemsTC.plate, 1, 0), BlocksTC.bannerCrimsonCult
						}
				));
		ItemStack crabStack = new ItemStack(Items.SPAWN_EGG);
		ItemMonsterPlacer.applyEntityIdToItemStack(crabStack, new ResourceLocation("thaumcraft", "eldritchcrab"));
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation("crimsonrevelations", "eldritchcrab"),
				new InfusionRecipe("PRAETOR_ARMOR", crabStack, 5,
						new AspectList().add(Aspect.UNDEAD, 50).add(Aspect.ELDRITCH, 75).add(Aspect.PROTECT, 50),
						new ItemStack(Items.EGG), new Object[] {
								new ItemStack(Items.ENDER_EYE), new ItemStack(Items.FERMENTED_SPIDER_EYE), new ItemStack(ItemsTC.plate, 1, 3), new ItemStack(BlocksTC.stoneAncient), ItemsTC.crimsonPlateHelm, new ItemStack(BlocksTC.stoneAncient), new ItemStack(ItemsTC.plate, 1, 3), new ItemStack(Items.FERMENTED_SPIDER_EYE)
						}
				));
	}
	
	private static void initCrucible() {
		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation("crimsonrevelations", "ancientstone"),
                new CrucibleRecipe("ANCIENT_STONE", new ItemStack(BlocksTC.stoneAncient), new ItemStack(BlocksTC.stoneArcane), new AspectList().add(Aspect.ELDRITCH, 5).add(Aspect.EARTH, 5)));
		
	}

	private static void initArcaneCrafting() {
		ResourceLocation defaultGroup = new ResourceLocation("");
		
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimsonbanner"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_REVELATIONS", 10, 
                new AspectList(), 
                new ItemStack(BlocksTC.bannerCrimsonCult), new Object[] {
                        "DND",
                        "NBN",
                        "D D",
                        'D', new ItemStack(Items.DYE, 1, 1), 'N', Items.GOLD_NUGGET, 'B', new ItemStack(Blocks.WOOL, 1, 1)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "ancientstonetile"), new ShapedArcaneRecipe(
                defaultGroup, "ANCIENT_STONE", 5, 
                new AspectList(), 
                new ItemStack(BlocksTC.stoneAncientTile), new Object[] {
                        "SS ",
                        "SS ",
                        "   ",
                        'S', BlocksTC.stoneAncient
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "glyphstone"), new ShapedArcaneRecipe(
                defaultGroup, "ANCIENT_STONE", 15, 
                new AspectList().add(Aspect.ORDER, 1).add(Aspect.EARTH, 1), 
                new ItemStack(BlocksTC.stoneAncientGlyphed, 6, 0), new Object[] {
                        "SBS",
                        "SBS",
                        "SBS",
                        'S', BlocksTC.stoneAncient, 'B', Blocks.BOOKSHELF
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_helm"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 25, 
                new AspectList().add(Aspect.FIRE, 1), 
                new ItemStack(ItemsTC.crimsonPlateHelm), new Object[] {
                        "IBI",
                        "I I",
                        "   ",
                        'I', new ItemStack(ItemsTC.plate, 1, 1), 'B', new ItemStack(ItemsTC.plate, 1, 0)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_chestplate"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 25, 
                new AspectList().add(Aspect.FIRE, 1), 
                new ItemStack(ItemsTC.crimsonPlateChest), new Object[] {
                        "I I",
                        "WBW",
                        "III",
                        'I', new ItemStack(ItemsTC.plate, 1, 1), 'B', new ItemStack(BlocksTC.bannerCrimsonCult), 'W', new ItemStack(Blocks.WOOL, 1, 1)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_greaves"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 25, 
                new AspectList().add(Aspect.FIRE, 1), 
                new ItemStack(ItemsTC.crimsonPlateLegs), new Object[] {
                        "WBW",
                        "I I",
                        "I I",
                        'I', new ItemStack(ItemsTC.plate, 1, 1), 'B', new ItemStack(BlocksTC.bannerCrimsonCult), 'W', new ItemStack(Blocks.WOOL, 1, 1)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_hood"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 50, 
                new AspectList().add(Aspect.FIRE, 1).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1), 
                new ItemStack(ItemsTC.crimsonRobeHelm), new Object[] {
                        "FBF",
                        "F F",
                        "   ",
                        'F', ItemsTC.fabric, 'B', new ItemStack(BlocksTC.bannerCrimsonCult)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_robes"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 50, 
                new AspectList().add(Aspect.FIRE, 1).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1), 
                new ItemStack(ItemsTC.crimsonRobeChest), new Object[] {
                        "F F",
                        "IBI",
                        "FWF",
                        'F', ItemsTC.fabric, 'B', new ItemStack(BlocksTC.bannerCrimsonCult), 'I', new ItemStack(ItemsTC.plate, 1, 1), 'W', new ItemStack(Blocks.WOOL, 1, 1)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_leggings"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 50, 
                new AspectList().add(Aspect.FIRE, 1).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1), 
                new ItemStack(ItemsTC.crimsonRobeLegs), new Object[] {
                        "WBW",
                        "F F",
                        "F F",
                        'F', ItemsTC.fabric, 'B', new ItemStack(BlocksTC.bannerCrimsonCult), 'W', new ItemStack(Blocks.WOOL, 1, 1)
                }
        ));
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation("crimsonrevelations", "crimson_boots"), new ShapedArcaneRecipe(
                defaultGroup, "CRIMSON_ARMOR", 50, 
                new AspectList().add(Aspect.FIRE, 1).add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1), 
                new ItemStack(ItemsTC.crimsonBoots), new Object[] {
                        "   ",
                        "I I",
                        "W W",
                        'I', new ItemStack(ItemsTC.plate, 1, 1), 'W', new ItemStack(Blocks.WOOL, 1, 1)
                }
        ));
	}
		



}
