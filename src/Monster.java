/**
 * @author agung 1972050
 */
 class Monster extends GameCharacter{
    private boolean flyingUnit=false;

    public Monster() {
    }

    @Override
    public void attackEnemy(GameCharacter gameCharacter) {
        double x=Math.random();
        int y= (int) Math.round(x*getCurentHealth()*getCurentStrength()/50);
        gameCharacter.setCurentHealth(gameCharacter.getCurentHealth()-y);
        System.out.println("Monster do "+y+" damage to hero");
    }

    public boolean isFlyingUnit(){
        return flyingUnit;
    }
    public void setFlyingUnit(boolean flyingunit){
        flyingUnit=flyingunit;
    }
}
