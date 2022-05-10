package kloon.boat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class reward extends JavaPlugin {

        @Override
        public void onEnable() {

            getCommand("kloonboat").setExecutor(new klooncmd());
            getServer().getPluginManager().registerEvents(new kloonlistener(), this);
            getServer().getPluginManager().registerEvents(new kloonantidrop(), this);

            new BukkitRunnable() {
                @Override
                public void run() {
                    for (Player player : Bukkit.getOnlinePlayers()) {

                        ItemStack item = player.getInventory().getHelmet();

                        if(item == null) {return;}
                        if(item.getItemMeta() == null) {return;}
                        if(item.getItemMeta().getDisplayName() == null) {return;}
                        ItemMeta meta = item.getItemMeta();
                        String ItemName = item.getItemMeta().getDisplayName();
                        if (ItemName.equals(ChatColor.RED + "Kloonboat")) {
                            item.setItemMeta(meta);
                        }
                    }
                }
            }.runTaskTimer(this, 20, 20);
        }
    }

