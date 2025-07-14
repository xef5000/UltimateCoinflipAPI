package com.github.xef5000.ultimateCoinflip.api.models;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Enum representing available colors for coinflip selection
 */
public enum CoinflipColor {
    RED("red", "Red", Material.RED_WOOL, Material.RED_STAINED_GLASS_PANE, "&c"),
    BLUE("blue", "Blue", Material.BLUE_WOOL, Material.BLUE_STAINED_GLASS_PANE, "&9"),
    GREEN("green", "Green", Material.GREEN_WOOL, Material.GREEN_STAINED_GLASS_PANE, "&a"),
    YELLOW("yellow", "Yellow", Material.YELLOW_WOOL, Material.YELLOW_STAINED_GLASS_PANE, "&e"),
    ORANGE("orange", "Orange", Material.ORANGE_WOOL, Material.ORANGE_STAINED_GLASS_PANE, "&6"),
    PURPLE("purple", "Purple", Material.PURPLE_WOOL, Material.PURPLE_STAINED_GLASS_PANE, "&5"),
    PINK("pink", "Pink", Material.PINK_WOOL, Material.PINK_STAINED_GLASS_PANE, "&d"),
    WHITE("white", "White", Material.WHITE_WOOL, Material.WHITE_STAINED_GLASS_PANE, "&f"),
    BLACK("black", "Black", Material.BLACK_WOOL, Material.BLACK_STAINED_GLASS_PANE, "&8");

    private final String configKey;
    private final String displayName;
    private final Material woolMaterial;
    private final Material glassPaneMaterial;
    private final String colorCode;

    CoinflipColor(String configKey, String displayName, Material woolMaterial, Material glassPaneMaterial, String colorCode) {
        this.configKey = configKey;
        this.displayName = displayName;
        this.woolMaterial = woolMaterial;
        this.glassPaneMaterial = glassPaneMaterial;
        this.colorCode = colorCode;
    }

    /**
     * Get the configuration key for this color
     * @return The config key
     */
    public String getConfigKey() {
        return configKey;
    }

    /**
     * Get the display name for this color
     * @return The display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Get the wool material for this color
     * @return The wool material
     */
    public Material getWoolMaterial() {
        return woolMaterial;
    }

    /**
     * Get the glass pane material for this color
     * @return The glass pane material
     */
    public Material getGlassPaneMaterial() {
        return glassPaneMaterial;
    }

    /**
     * Get the color code for this color
     * @return The color code (e.g., "&c" for red)
     */
    public String getColorCode() {
        return colorCode;
    }

    /**
     * Get the formatted display name with color code
     * @return The colored display name
     */
    public String getColoredDisplayName() {
        return colorCode + displayName;
    }

    /**
     * Get a CoinflipColor by its configuration key
     * @param configKey The configuration key
     * @return The CoinflipColor, or null if not found
     */
    public static CoinflipColor fromConfigKey(String configKey) {
        for (CoinflipColor color : values()) {
            if (color.getConfigKey().equalsIgnoreCase(configKey)) {
                return color;
            }
        }
        return null;
    }

    /**
     * Get a CoinflipColor by its wool material
     * @param material The wool material
     * @return The CoinflipColor, or null if not found
     */
    public static CoinflipColor fromWoolMaterial(Material material) {
        for (CoinflipColor color : values()) {
            if (color.getWoolMaterial() == material) {
                return color;
            }
        }
        return null;
    }

    /**
     * Get a CoinflipColor by its slot in the GUI
     * @param slot The slot number in the GUI
     * @param config The color GUI configuration
     * @return The CoinflipColor, or null if not found
     */
    public static CoinflipColor fromSlot(int slot, FileConfiguration config) {
        if (config == null) return null;

        ConfigurationSection colorsSection = config.getConfigurationSection("colors");
        if (colorsSection == null) return null;

        for (String colorKey : colorsSection.getKeys(false)) {
            ConfigurationSection colorSection = colorsSection.getConfigurationSection(colorKey);
            if (colorSection == null) continue;

            int colorSlot = colorSection.getInt("slot", -1);
            if (colorSlot == slot) {
                return fromConfigKey(colorKey);
            }
        }
        return null;
    }
}
