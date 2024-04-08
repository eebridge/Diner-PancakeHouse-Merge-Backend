package edu.iu.habahram.DinerPancakeHouseMerge.repository;
import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

@Repository
public class MergerRepository {
    String DATABASE_NAME = "data/customers.txt";
    private static final String NEW_LINE = System.lineSeparator();
    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast");
        DinerMenu dinerMenu = new DinerMenu("DINER MENU", "Lunch");
        CafeMenu cafeMenu = new CafeMenu("CAFE MENU", "Dinner");

        List<MenuItem> pancakeItems = pancakeHouseMenu.getMenuItems();
        MenuItem[] dinerItems = dinerMenu.getMenuItems();
        MenuItem[] cafeItems = cafeMenu.getItems();


        MenuItem[] menuItems = new MenuItem[pancakeItems.size() + dinerItems.length + cafeItems.length];
        for (int i = 0; i < pancakeItems.size(); i++) {
            menuItems[i] = pancakeItems.get(i);
        }
        for (int i = 0; i < dinerItems.length; i++) {
            menuItems[i + pancakeItems.size()] = dinerItems[i];
        }
        for (int i = 0; i < cafeItems.length; i++) {
            menuItems[i + pancakeItems.size() + dinerItems.length] = cafeItems[i];
        }

        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getTheVegetarianItems() {
        List<MenuItemRecord> vegetarianMenu = new ArrayList<MenuItemRecord>();
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu("pancake", "breakfast");
        DinerMenu dinerMenu = new DinerMenu("diner", "lunch");
        CafeMenu cafeMenu = new CafeMenu("cafe", "dinner");
        List<MenuItemRecord> records = getTheMenuItems();

        for (MenuItemRecord record: records ) {
            if (record.vegetarian()) {
                vegetarianMenu.add(record);
            }
        }
        return vegetarianMenu;
    }

    public List<MenuItemRecord> getBreakfastItems() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast");
        List<MenuItem> pancakeItems = pancakeHouseMenu.getMenuItems();
        MenuItem[] menuItems = pancakeItems.toArray(new MenuItem[0]);
        System.out.println(menuItems.length);
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();

        System.out.println(records.size());
        return records;
    }

    public List<MenuItemRecord> getLunchItems() {
        DinerMenu dinerMenu = new DinerMenu("DINER MENU", "Lunch");
        MenuItem[] menuItems = dinerMenu.getMenuItems();
        System.out.println(menuItems.length);
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();

        System.out.println(records.size());
        return records;
    }

    public List<MenuItemRecord> getSupperItems() {
        CafeMenu cafeMenu = new CafeMenu("CAFE MENU", "Dinner");
        MenuItem[] menuItems = cafeMenu.getItems();
        System.out.println(menuItems.length);
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();

        System.out.println(records.size());
        return records;
    }

    public boolean signup(Customer customer) throws IOException {
        Path path = Paths.get(DATABASE_NAME );
        String data = customer.username() + "," + customer.password() + "," + customer.password();
        appendToFile(path, data+NEW_LINE);
        return true;
    }
}