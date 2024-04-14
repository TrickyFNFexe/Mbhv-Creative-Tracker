import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Mbhvcreative extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getType().isCreative() && player.getGameMode().isCreative()) {
            ItemStack item = event.getCurrentItem();
            if (item != null && item.getType() != Material.AIR) {
                addCreativeSpawnedLore(item, player.getName());
            }
        }
    }

    private void addCreativeSpawnedLore(ItemStack item, String playerName) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setLore(java.util.Arrays.asList("Spawned in creative mode, by: " + playerName));
            item.setItemMeta(meta);
        }
    }
}
