package maze;


import java.util.ArrayList;

public class Robot
{

   private int row;
   private int column;
   private int direction;
   private boolean debug;
   private Maze maze;
   private ArrayList<String> visited;
   public static final int NORTH = 0;
   public static final int EAST = 1;
   public static final int SOUTH = 2;
   public static final int WEST = 3;
   private static final int DIRECTIONS = 4;

   public Robot(Maze aMaze, int startingRow, int startingColumn)
   {
      maze = aMaze;
      row = startingRow;
      column = startingColumn;
      visited = new ArrayList<String>();
      visited.add(getPosition());
      maze.updateRobot(startingRow, startingColumn, 1);
   }

   public void escape() {
	    // Base case: If the robot is already at an exit, return
	    if (atExit()) {
	        return;
	    }

	    // Recursive case
	    // If the robot can't move forward, turn left
	    if (!canMove()) {
	        turnLeft();
	    } else {
	        // If the robot can move forward, move
	        move();

	        // Check if the robot has lost the wall
	        if (!maze.isValid(nextRow(row, (direction + 1) % DIRECTIONS), nextColumn(column, (direction + 1) % DIRECTIONS))) {
	            // If the block on the right is not a wall, turn right and move
	            turnRight();
	            move();
	        } else {
	            // If there is a wall to the right, turn back to the original position
	            turnRight();
	            turnRight();
	        }
		    escape();

	    }
	    
	    // Recur to escape from the new position
	}


   public boolean escape2()
   {      
	   return false;
   }

   public void move()
   {
      int newRow = nextRow(row, direction);
      int newColumn = nextColumn(column, direction);
      if (maze.isValid(newRow, newColumn))
      {
         maze.updateRobot(row, column, -1);

         row = newRow;
         column = newColumn;
         maze.updateRobot(row, column, +1);

         visited.add(getPosition());
         if (debug) maze.print();
      }
   }

   public void turnRight()
   {
      direction = (direction + 1) % DIRECTIONS;
   }

   public void turnLeft()
   {
      turnRight();
      turnRight();
      turnRight();
   }

   public boolean canMove()
   {
      int newRow = nextRow(row, direction);
      int newColumn = nextColumn(column, direction);
      return maze.isValid(newRow, newColumn);
   }

   public boolean atExit()
   {
      return maze.isExit(row, column);
   }

   public String getPosition()
   {
      return "(" + row + "," + column + ")";
   }

   public ArrayList<String> getVisited()
   {
      return visited;
   }

   private static int nextRow(int aRow, int aDirection)
   {
      if (aDirection == NORTH)
      {
         return aRow - 1;
      }
      else if (aDirection == SOUTH)
      {
         return aRow + 1;
      }
      else
      {
         return aRow;
      }
   }

   private static int nextColumn(int aColumn, int aDirection)
   {
      if (aDirection == WEST)
      {
         return aColumn - 1;
      }
      else if (aDirection == EAST)
      {
         return aColumn + 1;
      }
      else
      {
         return aColumn;
      }
   }

   public Robot clone()
   {
      Robot result = new Robot(maze, row, column);
      result.debug = debug;
      result.direction = direction;
      // Add the trip of the ancestors
      result.visited = new ArrayList<String>(visited);
      return result;
   }

   public void setDebug(boolean debug)
   {
      this.debug = debug;
   }
}
