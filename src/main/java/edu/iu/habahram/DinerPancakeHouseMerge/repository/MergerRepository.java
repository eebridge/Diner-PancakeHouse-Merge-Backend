package edu.iu.habahram.DinerPancakeHouseMerge.repository;
import edu.iu.habahram.DinerPancakeHouseMerge.model.CafeMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.DinerMenu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class MergerRepository {
    public ArrayList<Menu> getTheMenus() {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new DinerMenu());
        menus.add(new PancakeHouseMenu());
        menus.add(new CafeMenu());
        return menus;
    }
}