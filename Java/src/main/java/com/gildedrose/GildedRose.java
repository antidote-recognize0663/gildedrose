package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
            }

            switch (item.name) {
                case "Aged Brie":
                    updateAgedBrieQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePassesQuality(item);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    updateNormalItemQuality(item);
                    break;
            }
        }
    }

    private void updateAgedBrieQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        item.quality = Math.min(item.quality, 50);
    }

    private void updateBackstagePassesQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality += 3;
        } else if (item.sellIn <= 10) {
            item.quality += 2;
        } else {
            item.quality += 1;
        }
        item.quality = Math.min(item.quality, 50);
    }

    private void updateNormalItemQuality(Item item) {
        int qualityChange = item.sellIn <= 0 ? -2 : -1;
        item.quality += qualityChange;
        item.quality = Math.max(item.quality, 0);
    }
}
