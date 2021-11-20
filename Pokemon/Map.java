/*
@Vritik Mistry
*/

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Exception;

/**
 * The Map class constructs a map which the trainer uses to explore the different areas
 * of the game and encounters different situations. The map is hidden from player in the
 * beginning and each area/encounter is revealed as trainer passes by the area.
 * @author Vritik Mistry
 */
public class Map {
  private char [][] map;
  private boolean [][] revealed;

  /**
   * Creates a Map object with variables map and revealed, which are 2D array types
   * with 5 rows and 5 columns.
   * **/
  public Map() 
  {
    map = new char[5][5];
    revealed = new boolean[5][5];
  }

  /**
   * Loads the map for the trainer by reading in and storing the contents of 3 area text files,
   * and initialize the revealed array to all false initially.
   * @param mapNum map number which corresponds to the area map text file.
   * * **/
  public void loadMap(int mapNum)
  {
    int row = 5;
    int col = 5;
    File myFile = null;
    if(mapNum == 1)
    {
      myFile = new File("Pokemon/Area1.txt");
    }
    else if(mapNum == 2)
    {
      myFile = new File("Pokemon/Area2.txt");
    }
    else if(mapNum == 3)
    {
      myFile = new File("Pokemon/Area2.txt");
    }
    try(Scanner file = new Scanner(myFile))
    {
      while(file.hasNext())
      {
        for(int i = 0; i < row; i++)
        {
          for(int j = 0; j < col; j++)
          {
            map[i][j] = file.next().charAt(0);
            revealed[i][j] = false;
          }
        }
      }
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e);
    }
  }

  /**
   * Gets the character at the point location of the trainer. When the trainer cannot go further on the map, 
   * the program will let player know that a certain move is not allowed by printing out a message. 
   * Otherwise, it will return character at the trainer's location in the map.
   * @param p point location of trainer. 
   * @return loc character at trainer's location in the map.
   * **/
  public char getCharAtLoc(Point p)
  {
    int pX = (int)p.getX();
    int pY = (int)p.getY();
    char loc;
    if(pX < 0 || pX > 4)
    {
      loc = 'x';
      System.out.println("You cannot go that way.");
    }
    else if(pY < 0 || pY > 4)
    {
      loc = 'x';
      System.out.println("You cannot go that way.");
    }
    else
    {
      loc = map[pX][pY];
    }
    return loc;
  }
  
  /**
   * String representation of the Map object.  Map will show '*' for trainer's current location, the character for the type of encounter 
   * trainer had or 'x' if trainer has not visited the area.
   * @param p point location (x,y) of the trainer.
   * @return map with the updated position of the trainer, the character for the current and past encounters and "x" for the 
   * areas that have not been visited.
   * **/
  public String mapToString(Point p)
  {
    String mapString = "";
    int pX = (int)p.getX();
    int pY = (int)p.getY();
    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 5; j++)
      {
        if(pX == i && pY == j)
        {
          mapString += '*';
        }
        else if(revealed[i][j])
        {
          mapString += map[i][j];
        }
        else
        {
          mapString += 'x';
        }

      }
      mapString += "\n";
    }
    return mapString;
  }

  /**
   * Looks for 's' in the map which is the starting position of the trainer and 
   * sets the location of trainer at that point. Reveals the character 's' indicating
   * where the trainer starts.
   * @return the character 's' for the starting location of the trainer by calling reveal() with
   * the Point start as parameter.
   * **/ 
  public Point findStart()
  {
    Point start = new Point();
    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 5; j++)
      {
        if(map[i][j] == 's')
        {
          start.setLocation(i, j);
        }
      }
    }
    reveal(start);
    return start;
  }

  /**
   * Sets the point revealed to true to reveal the point (x,y) on the map.
   * @param p point (x,y) location of the trainer. 
   * **/ 
  public void reveal(Point p)
  {
    int x = (int)p.getX();
    int y = (int)p.getY();
    revealed[x][y] = true;
  }

  /**
   * Removes character 'i' at a certain point location of the trainer by replacing with 'n'. Occurs when trainer finds
   * an item and is randomly given a potion or pokeball.
   * @param p point location (x,y) of the trainer.
   * @return character 'n' at the point (x,y) location of the trainer.
   * **/
  public void removeCharAtLoc(Point p)
  {
    int x = (int)p.getX();
    int y = (int)p.getY();
    map[x][y] = 'n';
  }
}