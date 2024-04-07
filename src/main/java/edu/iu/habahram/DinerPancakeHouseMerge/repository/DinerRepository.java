package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public class DinerRepository {

    public MenuItem[] getTheMenu() {
        DinerMenu dinerMenu = new DinerMenu();
        return dinerMenu.getMenuItems();
    }

    public Iterator<MenuItem> getTheMenuIterator() {
        Menu dinerMenu = new DinerMenu();
        return dinerMenu.createIterator();
    }
}