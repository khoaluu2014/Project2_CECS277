/*
@Vritik Mistry
*/

/**
 * Abstract class Entity is a representation of a generic type of entity. Entities in the game are the trainers 
 * and different types of pokemons. The Entity class is extended by the Trainer class and the Abstract Pokemon class,
 * with both classes inheriting variables and methods from this Entity class.
 * @author Vritik Mistry
 */
public abstract class Entity {
  private String name;
  private int hp;
  private int maxHp;

  /**
   * Creates an Entity object with name n and maximum health points mHp as parameters
   * @param n, name of trainer, trainer's pokemons  or wild pokemons.
   * @param h, current health points for trainer and the pokemons.
   * @param mHp, maximum health points allowed for trainer or pokemons.
   */
  public Entity(String n, int h, int m){
    name = n;
    hp = h;
    maxHp = m;
  }

  /**
   * Gets the trainer's or pokemon's health points.
   * return@ hp which is trainer's or pokemon's current health points.
   */
  public int getHp(){
    return hp;
  }

  /**
   * Gets the trainer's or pokemon's maximum health points allowed.
   * return@ maxHp which is trainer's or pokemon's maximum health points allowed.
   */
  public int getMaxHp(){
    return maxHp;
  }

  /**
   * Calculates the damage that a pokemon or trainer takes by subtracting 
   * damage d from current health points hp, but only if pokemon has enough 
   * hp before battle or if trainer has enough hp before encountering a person.
   * @param d damage that a pokeman or trainer takes.
   */
  public void takeDamage(int d){
    if(hp > 0){
      hp -= d;
    }
    else{
      hp = 0;
    }
    
  }

  /**
   * Heals all the pokemons if trainer chooses to take pokemons to the hospital
   * when entering the city. Sets the health points hp to maximun health points maxHp.
   */
  public void heal(){
    hp = maxHp;
  }

  /**
   * Gets the trainer's or pokemon's name.
   * return@ name of trainer or pokemon.
   */
  public String getName(){
    return name;
  }

  /**
   * String representation of Entity object. 
   * @return string summary of trainer or pokemon's name and hp/maxHP ratio.
   */
  @Override
  public String toString(){
    //add name of pokemon between Name and HP
    String toString = name + " HP: " + hp + "/" + maxHp;

    return toString;
  }

}