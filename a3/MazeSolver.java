/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */
public class MazeSolver {
    public static String findPath(Maze maze) {
        String result = "";
        StackRefBased < MazeLocation > stack = new StackRefBased < MazeLocation > ();

        MazeLocation first = maze.getEntry();
        MazeLocation last = maze.getExit();

        int rows = maze.getNumRows();
        int cols = maze.getNumCols();

        int i = first.getRow();
        int j = first.getCol();


        boolean[][] array = new boolean[rows][cols];

        stack.push(first);

        MazeLocation current = first;


        while (!stack.isEmpty() && !current.equals(last)) {

            if (!maze.isWall(i + 1, j) && array[i + 1][j] == false) {
                i = i + 1;
                current = new MazeLocation(i, j);
                stack.push(current);
                array[i][j] = true;
            } else if (!maze.isWall(i - 1, j) && array[i - 1][j] == false) {
                i = i - 1;
                current = new MazeLocation(i, j);
                stack.push(current);
                array[i][j] = true;
            } else if (!maze.isWall(i, j + 1) && array[i][j + 1] == false) {
                j = j + 1;
                current = new MazeLocation(i, j);
                stack.push(current);
                array[i][j] = true;
            } else if (!maze.isWall(i, j - 1) && array[i][j - 1] == false) {
                j = j - 1;
                current = new MazeLocation(i, j);
                stack.push(current);
                array[i][j] = true;
            } else {
                try {

                    MazeLocation curr = stack.pop();
                    MazeLocation prev = stack.peek();
                    int row = prev.getRow();
                    int col = prev.getCol();
                    i = row;
                    j = col;
                } catch (StackEmptyException e) {
                    current = last;
                }
            }
        }

        Stack < MazeLocation > stackTemp = new StackRefBased < MazeLocation > ();
        try {
            while (!stack.isEmpty()) {
                stackTemp.push(stack.pop());
            }
        } catch (StackEmptyException e) {
            System.out.println("");
        }

        int a = 0;
        int e = stackTemp.size();

        while (!stackTemp.isEmpty()) {
            try {
                result += stackTemp.pop();
                if (a < e - 1) {
                    result += " ";
                }
            } catch (StackEmptyException se) {

            }
            a++;
        }

        return result;

    }
}
