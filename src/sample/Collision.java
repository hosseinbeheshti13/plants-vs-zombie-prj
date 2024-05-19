package sample;



public class Collision {

    public int collision() {
        if (Fire.fire_x+80 >= Zombie.zombie_x){
        if (  Zombie.zombie_y==162  && 0 < Fire.fire_y && Fire.fire_y < 290) {
            return 1;
            } else if ( Zombie.zombie_y==324 && 290 < Fire.fire_y && Fire.fire_y < 439) {
                return 2;
            } else if (Zombie.zombie_y==486 && 439 < Fire.fire_y && Fire.fire_y < 608) {
                return 3;
            } else if ( Zombie.zombie_y==648 && 608 < Fire.fire_y && Fire.fire_y < 730) {
                return 4;
            }
    }
        return 0;

    }
    public int stop_zombie(){
        if (Game.plant_x+80 >= Zombie.zombie_x){
            if (  Zombie.zombie_y==162 &&  Game.plant_y< 40) {
                return 1;
            } else if ( Zombie.zombie_y==324 && 40 < Game.plant_y && Game.plant_y < 207) {
                return 2;
            } else if ( Zombie.zombie_y==486 && 207 < Game.plant_y && Game.plant_y < 368) {
                return 3;
            } else if ( Zombie.zombie_y==648 && 368 < Game.plant_y && Game.plant_y < 680) {
                return 4;
            }
        }
        return 0;
    }
    public int bomb_collision(){
        if (Game.bomb_x+80 >= Zombie.zombie_x){
            if (  Zombie.zombie_y==162 &&  Game.bomb_y< 40) {
                return 1;
            } else if ( Zombie.zombie_y==324 && 40 < Game.bomb_y && Game.bomb_y < 207) {
                return 2;
            } else if ( Zombie.zombie_y==486 && 207 < Game.bomb_y && Game.bomb_y < 368) {
                return 3;
            } else if ( Zombie.zombie_y==648 && 368 < Game.bomb_y && Game.bomb_y< 680) {
                return 4;
            }
        }
        return 0;
    }

}