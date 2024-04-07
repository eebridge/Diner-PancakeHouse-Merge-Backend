package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.List;

public class PancakeHouseMenuIterator implements Iterator {
    List<MenuItem> items;
    int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position < items.size()-1 || items.get(position) != null) {
            return true;
        }
        return false;
    }

    public MenuItem next() {
        this.position++;
        return this.items.get(position);
    }
}