package net.killerchief.kcweaponmod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemWeaponProperties {
	// All the properties that can be set for custom weapons / projectiles.
	// Note that some should NOT be edited and have been labeled "NOT TO BE SET IN CONFIG!".
	// However there is one exception to this for code sided implementation (not XML) where ProjLivingActArgs & ProjImpactActArgs & ProjPrematureEndLifeActArgs can be edited at any time for things such as different impact damage to entites etc. (Look at Halocraft's Mobs (Elite & Grunt) for example)
	
	/** NOT TO BE SET IN CONFIG! This is handled by the mod. */
	public int ID = -1;
	/** Whether an item of this property set will appear ingame (false for vehicles). */
	public boolean RegisterItem = true;
	/** The unlocalized name of the weapon. */
	public String Name;
	/** The Texture used for the weapons item. */
	public String Texture = KCWeaponMod.MODID + ":Default/DefaultItem";
	/** The Creative Inventory Tab the Weapon will appear under. */
	public CreativeTabs InventoryTab = KCWeaponMod.InventoryTab;
	/** If the weapon requires a shorter shooting delay or it has a secondary shoot projectile type. */
	public boolean IsAutomaticOrHasSecondaryShoot = false;
	/** If the weapon has a zooming scope. */
	public boolean IsZoomable = false;
	/** How much the screen zooms in and the number of zoom positions available. (Only active if IsZoomable is true) */
	public int[] ZoomMultiplier = {1};
	/** The zooming texture overlay file location and name. (Only active if IsZoomable is true) */
	public String ZoomTexture = KCWeaponMod.MODID + ":textures/items/Default/DefaultZoom.png";
	/** How long the delay is between being able to shoot again. */
	public int GunShootDelay = 0;
	/** How much recoil the player experiences per shot. (the final amount of experienced recoil is multiplied by this and ShootBurstCount) */
	public float Recoil = 0F;
	/** Whether the weapons shoot sound should only be played once when ShootBurstCount is more than 1. */
	public boolean PerformOnly1ShootSound = true;
	/** The shoot sound file location and name. */
	public String ShootSound = KCWeaponMod.MODID + ":Default.DefaultShoot";
	/** If set to anything greater than 0, this weapon will have a secondary shoot projectile type. (if set, IsAutomaticOrHasSecondaryShoot must be true) */
	public int SecondaryShootHeldDelay = 0;
	public int SecondaryGunShootDelay = 0;
	public String HeldShootEntity = "";//TODO Code this, can have tracking here too!
	
	/** How many ticks it takes for the weapon to reload */
	public int ReloadTime = 0;
	/** The reload sound file location and name. */
	public String ReloadSound = KCWeaponMod.MODID + ":Default.DefaultReload";
	/** How much ammo can be loaded into the weapon at any one time when reloading. (Coded to activate a reload loop and slow increase of weapon ammo if set to anything greater than 0) */
	public int ReloadMaxAmmoFlow = 0;
	/** How many ticks it should take for the looping loading to occur. (Should be set to a value greater than 0 if ReloadMaxAmmoFlow is set to anything greater than 0) */
	public int ReloadTimeLoop = 0;
	/** The looping reload sound file location and name. */
	public String ReloadSoundLoop = KCWeaponMod.MODID + ":Default.DefaultReloadLoop";
	/** The exiting reload sound file location and name. */
	public String ReloadSoundExit = KCWeaponMod.MODID + ":Default.DefaultReloadExit";
	/** If true, it only supports RequiredUsesPerShot of 1 however that variable isn't required to be set. */
	public boolean AmmoFeedsFromInventory = false;
	/** The ammo this weapon uses. (Only active if ItemStackDecreaseOnUse if false) */
	public ItemStack AmmoType = null;
	/** The size of the weapons magazine. (Only active if AmmoFeedsFromInventory is false) */
	public int MagazineSize = 0;
	/** Whether the ItemStack will decrease when the weapon is used. (Overrides AmmoFeedsFromInventory, MagazineSize and AmmoType) */
	public boolean ItemStackDecreaseOnUse = false;
	/** How large the ItemStack's stack size can grow to. (Only active if ItemStackDecreaseOnUse is true) */
	public int ItemStackMaxStackSize = 16;
	/** How much of the item-stack/ammo the weapon uses up. */
	public int RequiredUsesPerShot = 1;
	/** How many times a projectile is shot per shooting action. */
	public int ShootBurstCount = 1;
	/** How much the accuracy of the projectile's heading is decreased per burst stage. */
	public float BurstAccuracyDecrease = 0.6F;
	/** How many projectiles are launched on shooting action. */
	public int SingleShotProjectileCount = 1;
	
	/** The projectile entity's render properties. 0#ArrowRenderTexture, 1#2DRenderTexture, 2#ModelTexture#ModelClass, 3#LargeArrowRenderTexture */
	public String ProjectileRenderProperties = "0#"+KCWeaponMod.MODID+":textures/entities/Default/DefaultProjectileRender.png";
	/** NOT TO BE SET IN CONFIG! This is handled, configured and processed by the mod for efficiency. */
	public ProjRenderProp ProjRenderProp = new ProjRenderProp();
	
	/** The Speed at which the projectile is launched at. */
	public float ProjectileSpeed = 0F;
	/** The Accuracy of the projectile when fired. */
	public float Accuracy = 0F;
	/** How much the projectile will be pulled down per tick. */
	public float Gravity = 0.004F;
	/** How many ticks the projectile will live until it becomes less effective (less Damage and entity removal after 1.5 times this). */
	public int MaxEffectiveTicksAlive = 0;
	/** The properties the projectile has when it exists/ticks normally, the instructions on what to do and in what order. */
	public String ProjectileLivingProperties = "";
	/** NOT TO BE SET IN CONFIG! This is handled by the mod. */
	public Object[] ProjLivingActArgs = new Object[]{};
	/** What properties the projectile has when it collides with an entity of some kind, the instructions on what to do and in what order. */
	public String ProjectileImpactProperties = "Die";
	/** NOT TO BE SET IN CONFIG! This is handled by the mod. */
	public Object[] ProjImpactActArgs = new Object[]{"Die"};
	/** What to do when the projectile is called upon for its final action (It will die afterwards). */
	public String ProjectilePrematureEndOfLifeProperties = "";
	/** NOT TO BE SET IN CONFIG! This is handled by the mod. */
	public Object[] ProjPrematureEndLifeActArgs = new Object[]{};
	/** How much the projectile slows down when flying through the air. */
	public float ProjectileDragInAir = 0.99F;
	/** How much the projectile slows down when traveling through water. */
	public float ProjectileDragInWater = 0.5F;
	/** If the projectile texture glows (is bright). */
	public boolean ProjectileGlows = false;
	/** How well the projectile tracks target entities. */
	public float TrackSensitivity = 0F; //TODO
	
	
	public ItemWeaponProperties() {}
}
