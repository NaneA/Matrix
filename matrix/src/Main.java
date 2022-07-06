public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5,5); //with first constructor

        matrix.setMatrixCell(1,2, true);
        matrix.setMatrixCell(1,3, true);
        matrix.setMatrixCell(1,4, true);

        matrix.setMatrixCell(2,2, true);
        matrix.setMatrixCell(2,3, true);
        matrix.setMatrixCell(2,4, true);

        matrix.setMatrixCell(3,3, true);
        matrix.setMatrixCell(3,4, true);

        matrix.setMatrixCell(4,2, true);
        matrix.setMatrixCell(4,4, true);

//      System.out.println("First Matrix");
//      matrix.viewMatrix();

        boolean[][] arr = { {true, false, false, false, false},
                            {true, true, true, true, false},
                            {true, true, true, false, false},
                            {true, false, false, false, false},
                            {true, true, true, true, true}
                          };

        Matrix matrix2 = new Matrix(arr); ////with second constructor

//      System.out.println("Second Matrix");
//      matrix2.viewMatrix();

        Coordinate a = new Coordinate(2,2);
        Coordinate b =  new Coordinate(4,4);

        long startTime = System.currentTimeMillis();

        System.out.println("Solution for matrix1: " + matrix.shortestPath(a,b));
        System.out.println("Solution for matrix2: " + matrix2.shortestPath(a,b));

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");

    }
}
