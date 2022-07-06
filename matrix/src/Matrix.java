import java.util.*;

public class Matrix {
    private final int x;
    private final int y;
    private final boolean[][] matrix;

    //just make an matrix by size and fill by false values
    public Matrix(int x, int y) { // x- size of x axis y-size of y axis
        this.x = x;
        this.y = y;
        this.matrix = new boolean[x][y];
    }

    //receive a matrix
    public Matrix(boolean[][] matrix) {
        this.x = matrix[0].length;
        this.y = matrix.length;
        this.matrix = matrix;
    }

    public void setMatrixCell(int x, int y, boolean val) {
        this.matrix[x][y] = val;
    }

    public boolean getMatrixCell(int x, int y) {
        return matrix[x][y];
    }

    //solution discussed during interview
    //if Coordinate of b is false I assumed that the path is unreachable
    //if no path return -1
    public int shortestPath(Coordinate a, Coordinate b) {
        if (a.getX() >= this.x || b.getX() >= this.x || a.getY() >= this.y || b.getY() >= this.y) {
           throw new IndexOutOfBoundsException();
        }
        if(!this.matrix[b.getX()][b.getY()]){
            return -1;
        }
        Deque<String> deq = new LinkedList();
        deq.offer(a.getX() + " " + a.getY());
        Set<String> set = new HashSet<>();
        int level;
        int counter = 0;
        String temp;
        int x,y;
        while (deq.size() > 0) {
            level = deq.size();
            counter++;
            for (int i = 0; i < level; i++) {
                temp = deq.pop();
                x = temp.charAt(0)-'0';
                y = temp.charAt(2)- '0';
                if (b.getX() == x && b.getY() == y) {
                    return counter-1;
                }
                if (!set.contains(temp)) {
                    set.add(temp);
                    if (x + 1 < this.x && matrix[x + 1][y]) {
                        deq.offer((x + 1) + " " + y);
                    }
                    if (y + 1 < this.y && matrix[x][y + 1]) {
                        deq.offer(x + " " + (y + 1));
                    }
                    if (x - 1 >= 0 && matrix[x - 1][y]) {
                        deq.offer((x - 1) + " " + y);
                    }
                    if (y - 1 >= 0 && matrix[x][y - 1]) {
                        deq.offer(x + " " + (y - 1));
                    }
                }
            }
        }
        return -1;
    }

    public void viewMatrix() {
       for(int i=0; i<y ; i++){
           System.out.println(Arrays.toString(this.matrix[i]));
       }
    }
}
