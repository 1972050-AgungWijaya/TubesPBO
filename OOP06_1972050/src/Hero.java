/**
 * @author agung 1972050
 */
import java.util.Arrays;
import java.util.List;

public class Hero extends GameCharacter{
    private String name;
    private Weapon mainWeapon;
    private Item [] inventories;

    public Hero() {
        inventories=new Item[2];
        inventories[0]=new Sword();
        inventories[1]=new Bow();
        mainWeapon= (Weapon) inventories[0];
        setMaxHealth(200);
        setBaseStregth(20);
        setCurentHealth(200);
        setCurentStrength(20);
    }
    public void equip(Weapon weapon){
        mainWeapon=weapon;
        setCurentStrength(getBaseStregth()+mainWeapon.getDamage());
    }
    public void showAllInventory(){
        List<Item> invent= Arrays.asList(inventories);
        invent.forEach(Item ->{
            if (Item instanceof Weapon){
                System.out.println(((Weapon)Item).toString());
            }
        });
    }
    public Item getItemFromInventory(String itemName){
        Item itm=null;
        for (int i=0;i<2;i++){
            if (inventories[i].getName().equals(itemName)){
                itm=inventories[i];
            }
        }
        return itm;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void attackEnemy(GameCharacter enemy) {
        mainWeapon.attack(Hero.this,enemy);
    }

}
