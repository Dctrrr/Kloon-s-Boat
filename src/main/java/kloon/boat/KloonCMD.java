package kloon.boat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class KloonCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 1) {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length >= 1) {
                String playerName = args[0];
                player = Bukkit.getPlayer(playerName);
            }

            assert player != null;
            if (player.hasPermission("minikloon.reward")) {
                ItemStack itemStack = new ItemStack(Material.BOAT);

                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setDisplayName(ChatColor.RED + "Kloonboat");

                itemMeta.setLore(Arrays.asList(
                        ChatColor.GRAY + "" + ChatColor.ITALIC + "Drop this item to decrease your FPS",
                        ChatColor.GRAY + "" + ChatColor.ITALIC + "Immune to drops.",
                        " ",
                        ChatColor.DARK_GRAY + "To: " + player.getDisplayName(),
                        ChatColor.DARK_GRAY + "From: " + ChatColor.RED + "[ADMIN] " + ((Player)sender).getDisplayName(),
                        " ",
                        ChatColor.DARK_GRAY + "Edition: Year 2022",
                        " ",
                        ChatColor.RED + "" + ChatColor.BOLD + "SPECIAL"
                ));

                itemStack.setItemMeta(itemMeta);
                player.getInventory().setHelmet(new ItemStack(itemStack));
                player.sendMessage("§fYou have been given a§f §4§lKloon's boat!§4§l §f§l(2022)§f§l");
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have access to this command!"));
            }
        }
        return true;
    }
}
