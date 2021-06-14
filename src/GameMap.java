/**
 * @author agung 1972050
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameMap {
    private boolean endGame;
    private GameCharacter hero;
    private GameCharacter monster;
    private Monster [] monsterGraveyard;

    public GameMap() {
        hero=new Hero();
        if (monsterGraveyard==null) {
            monsterGraveyard = new Monster[0];
        }
    }
    public void runGame(){
        if (endGame==false){
            double x=Math.random();
            if (x <= 0.3) {
                battle((Hero)hero, (Monster)monster);
            } else {
                System.out.println("Day passed, no monster to find");
            }
            runGame();
        }
        else if (hero.getCurentHealth()<=0){

        }
        else{
            System.out.println("Permainan selesai, selamat kamu berhasil");
        }

    }
    private void battle(Hero hero,Monster monster){
        if (hero.getCurentHealth()>=0 && monster.getCurentHealth()>0){
            int pil=0;
            Scanner sc= new Scanner(System.in);
            System.out.println("Engaging battle. Prepare .....");
            System.out.println("1. Attack Enemy");
            System.out.println("2. Swap Weapon");
            System.out.println("3. Show Inventory");
            System.out.println("4. Show Status");
            System.out.print("Choice: ");
            pil=sc.nextInt();
            if (pil==1){
                hero.attackEnemy(monster);
            }
            else if (pil==2){
                System.out.println("Choose item name: ");
                String x=sc.next();
                Item y=hero.getItemFromInventory(x);
                if (y==null){
                    System.out.println("salah nama item silahkan coba lagi");
                }
                else{
                    hero.equip((Weapon) y);
                    System.out.println("Senjata diubah menjadi "+y.getName());
                }
            }
            else if (pil==3){
                hero.showAllInventory();
            }

            else if (pil==4){
                System.out.println(hero.getStatus());
                System.out.println(monster.getStatus());
            }
            else{
                System.out.println("Pilihan salah");
            }
            battle(hero,monster);
        }
        else if (monster.getCurentHealth()<=0 && hero.getCurentHealth()>=0){
            if (monsterGraveyard.length>=9){
                endGame=true;
            }
            else {
                System.out.println("Stage " + (monsterGraveyard.length+1)+" Telah Berhasil Dilewati Lanjut ke Stage selanjutnya");
                monsterGraveyard = Arrays.copyOf(monsterGraveyard, monsterGraveyard.length + 1);
                monsterGraveyard[monsterGraveyard.length - 1] = monster;
                generateMonster();
            }

        }
        else if (hero.getCurentHealth()<=0){
            System.out.println("Hero mati silahkan masukan lagi coin untuk mencoba kembali");
            endGame=true;
        }

    }
    public void generateMonster(){
        monster=new Monster();
        Random random=new Random();
        int rm=random.nextInt(3);
        if (rm>=1){
            ((Monster) monster).setFlyingUnit(false);
        }
        else{
            ((Monster) monster).setFlyingUnit(true);
        }
        int health;
        int r=random.nextInt(3);
        int str=(r* monsterGraveyard.length)+5;
        if (((Monster) monster).isFlyingUnit()&&r==0){
            health=200;
        }
        else if (((Monster) monster).isFlyingUnit()&&r==1){
            health=135;
        }
        else if (((Monster) monster).isFlyingUnit()&&r==2){
            health=100;
        }
        else if (!((Monster) monster).isFlyingUnit() &&r==0){
            health=450;
        }
        else if (!((Monster) monster).isFlyingUnit() &&r==1){
            health=300;
        }
        else if (!((Monster) monster).isFlyingUnit() &&r==2){
            health=275;
        }
        else{
            health=225;
        }
        ((Monster)monster).setBaseStregth(str);
        ((Monster)monster).setMaxHealth(health);
        ((Monster)monster).setCurentHealth(health);
        ((Monster)monster).setCurentStrength(str);
    }

    public static void main(String[] args) {
        GameMap gm=new GameMap();
        gm.generateMonster();
        gm.runGame();
    }
}
