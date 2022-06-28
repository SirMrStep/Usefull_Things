package me.steep.usefullthings.objects;

import org.bukkit.inventory.ItemStack;

public class ArmorItem {

    private int slot;
    private int rawSlot;

    public ArmorItem(ItemStack item) {

        if(item.getType().toString().equals("ELYTRA")) {
            setSlots(38, 6);
            return;
        }

        String endsWith = item.getType().toString().split("_")[1];

        switch (endsWith) {

            case "HELMET", "HEAD", "SKULL" -> setSlots(39, 5);
            case "CHESTPLATE" -> setSlots(38, 6);
            case "LEGGINGS" -> setSlots(37, 7);
            case "BOOTS" -> setSlots(36, 8);

        }

    }

    /**
     * @return The slot number of the EquipmentSlot this item should go into
     */
    public int getSlot() {
        return this.slot;
    }

    /**
     * @return The raw slot number of the EquipmentSlot this item should go into
     */
    public int getRawSlot() {
        return this.rawSlot;
    }

    private void setSlots(int slot, int rawSlot) {
        this.slot = slot;
        this.rawSlot = rawSlot;
    }

}
