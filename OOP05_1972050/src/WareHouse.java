/**
 * @author agung 1972050
 */
import java.util.ArrayList;

public class WareHouse {
    private ArrayList<Item> items;
    public WareHouse() {
        items=new ArrayList<>();
    }
    public void addItemToList(Item item){
        items.add(item);
    }
    public void showAllItemData(){
        if (items.isEmpty()){
            System.out.println("No data");
        }
        else {
            items.forEach(Item -> {
                if (Item instanceof Shirt) {
                    System.out.println(((Shirt) Item).toString());
                }
            });
            items.forEach(Item -> {
                if (Item instanceof Shoe) {
                    System.out.println(((Shoe) Item).toString());
                }
            });
        }
    }



}
