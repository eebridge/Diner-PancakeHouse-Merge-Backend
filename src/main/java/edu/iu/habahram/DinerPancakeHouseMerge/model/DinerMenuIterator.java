package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position < items.length-1 || items[position] != null) {
            return true;
        }
        return false;
    }

    public MenuItem next() {
        this.position++;
        return this.items[position];
    }
}