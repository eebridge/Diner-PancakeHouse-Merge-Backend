package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position;

    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        Calendar date = Calendar.getInstance();
        int day_of_week = date.get (Calendar.DAY_OF_WEEK);
        position = day_of_week % 2;
    }
    public MenuItem next() {
        MenuItem menuItem = items[position];
        Calendar date = Calendar.getInstance();
        int day_of_week = date.get (Calendar.DAY_OF_WEEK);
        position = day_of_week + 2;
        return menuItem;
    }
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}