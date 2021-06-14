/**
 * @author agung 1972050
 */
public class WareHouseManager extends WareHouse{
    private WareHouse wareHouse;
    public WareHouseManager(WareHouse wareHouse) {
        this.wareHouse=wareHouse;
    }
    public void addItemToWareHouse(Item item){
        wareHouse.addItemToList(item);
    }
    public void viewItemInWareHouse(){
        wareHouse.showAllItemData();
    }
}
