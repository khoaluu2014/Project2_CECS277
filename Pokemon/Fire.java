/*
@Joshua Peng
*/

/**
 * Fire class is a type of base pokemon with special functionalities and abilities.It inherits
 * variables and methods from Pokemon class.
 * @author Joshua Peng
 */

public class Fire extends Pokemon{

	/**
	 * Creates a Fire type base object and passes in name of pokemon, hp and max hp as parameters.
	 * Calls in superclass Pokemon's constructor.
	 * @param n, name of pokemon.
	 * @param h, hp for pokemon.
	 * @param m, maximum Hp for pokemon.
	 */
	public Fire(String n, int h, int m)
	{
		super(n, h, m);
	}

	/**
	 * Gets the menu for the fire special attacks by returning the string with the menu choices.
	 * return@ string menu of special attacks for fire base pokemon.
	 */
	@Override
	public String getAttackMenu(int atkType)
	{
		String attackMenu = "";
		if (atkType == 2) {
			attackMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";
		}
		return attackMenu;
	}

	/**
	 * Gets the number of trainer's choices for the fire special attacks
	 * @return the number of choices for fire special attacks.
	 */
	@Override
	public int getNumAttackMenuItems(int atkType)
	{
		int menuItems = 0;
		if (atkType == 2) {
			menuItems = 3;
		}
		return menuItems;
	}

	/**
	 * Get the string for the different attacks based on the Fire type.
	 * @param atkType, trainer chooses between basic attack or special attack.
	 * @param move, the move that trainer chooses.
	 * @return the string description of the move.
	 */
	@Override
	public String getAttackString(int atkType, int move)
	{
		String atkStr = "";
		if(atkType == 2)
		{
			if (move == 1)
			{
				atkStr = "uses AMBER on ";
			}
			if (move == 2)
			{
				atkStr = "uses FIRE BLAST on ";
			}
			if (move == 3)
			{
				atkStr = "uses FIRE PUNCH on ";
			}
		}
		return atkStr;
	}

	/**
	 * Gets a random damage from a range which is based on the type of move.
	 * @param atkType, trainer chooses between basic attack (1)  or special attack (2).
	 * @param move, the move that the Trainer chooses.
	 * @return the damage amount for the move
	 */
	@Override
	public int getAttackDamage(int atkType, int move)
	{
		int damage = 0;
		if(atkType == 2)
		{
			if (move == 1)
			{
				damage = Rand.randIntRange(0, 5);
			}
			else if (move == 2)
			{
				damage = Rand.randIntRange(2, 3);
			}
			else if (move == 3)
			{
				damage = Rand.randIntRange(1, 4);
			}
		}
		return damage;
	}

	/**
	 * Gets the damage multiplier from Pokemon's class battleTable array for each combination of attack.
	 * @param p, wild pokemon that the trainer is fighting with.
	 * @param atkType, trainer chooses between basic attack (1) or special attack (2).
	 * @return damage multiplier or else returns 1 for basic attack which deals no multiplier.
	 */
	public double getAttackMultiplier(Pokemon p, int atkType) {
		double damageMultiplier;
		if (atkType == 2) {
			damageMultiplier = battleTable[this.getType()][p.getType()];
			return damageMultiplier;
		}
		else {
			super.getAttackMultiplier(p, atkType);
		}
		return 1;
	}
}