package me.cuft.MorvenCosmetics.Gui;

import me.cuft.MorvenCosmetics.Main;
import me.cuft.MorvenCosmetics.Util.Particle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class adminGui implements Listener
{
    private static Inventory inv;

    Player player;

    private final Main main;

    private int size = 27;
    public adminGui(Player player, Main main) {
        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inv = Bukkit.createInventory(null, size, "Admin Menu");

        this.player = player;
        this.main = main;
        // Put the items into the inventory
        initializeItems();
    }

    // You can call this whenever you want to put the items in
    public void initializeItems() {
        inv.addItem(main.createGuiItem(Material.BOW,  ChatColor.GOLD + "Bow Trails:"));

        for(Particle particle : main.getBowParticleArrayList())
        {
            inv.addItem(main.createGuiItem(particle.getDisplayItem(), particle.getDisplayName(),ChatColor.GREEN + "" + particle.getPrice(), ChatColor.GOLD + "Click To Change Price"));
        }

        int slot = 18;
        inv.setItem(slot, main.createGuiItem(Material.ELYTRA,  ChatColor.GOLD + "Elytra Trails:"));
        for(Particle particle : main.getFireworksParticleArrayList())
        {
            inv.setItem(++slot, main.createGuiItem(particle.getDisplayItem(), particle.getDisplayName(),ChatColor.GREEN +  "" + particle.getPrice(), ChatColor.GOLD + "Click To Change Price"));
        }
    }

    // Nice little method to create a gui item with a custom name, and description

    // You can open the inventory with this
    public void openInventory(final Player player) {
        player.openInventory(inv);
    }

    public Inventory getInventory()
    {
        return inv;
    }
}
