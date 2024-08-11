package com.github.abyssxd.smeltingdisabler;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EnumSet;
import java.util.Set;

public final class SmeltingDisabler extends JavaPlugin implements Listener {

    private final Set<Material> terracottaMaterials = EnumSet.of(
            Material.TERRACOTTA,
            Material.WHITE_TERRACOTTA,
            Material.ORANGE_TERRACOTTA,
            Material.MAGENTA_TERRACOTTA,
            Material.LIGHT_BLUE_TERRACOTTA,
            Material.YELLOW_TERRACOTTA,
            Material.LIME_TERRACOTTA,
            Material.PINK_TERRACOTTA,
            Material.GRAY_TERRACOTTA,
            Material.LIGHT_GRAY_TERRACOTTA,
            Material.CYAN_TERRACOTTA,
            Material.PURPLE_TERRACOTTA,
            Material.BLUE_TERRACOTTA,
            Material.BROWN_TERRACOTTA,
            Material.GREEN_TERRACOTTA,
            Material.RED_TERRACOTTA,
            Material.BLACK_TERRACOTTA
    );

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SmeltingDisabler has been enabled! Made by AbisGamer");
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getType() == InventoryType.FURNACE) {
            if (terracottaMaterials.contains(event.getCursor().getType())) {
                Player player = (Player) event.getWhoClicked();
                player.sendMessage(ChatColor.RED + "Smelting Terracotta is disabled!");
                event.setCancelled(true);
            }

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem != null && terracottaMaterials.contains(clickedItem.getType())) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        if (terracottaMaterials.contains(event.getSource().getType())) {
            event.setCancelled(true);
        }
    }

}
