public class Main {
    public static void main(String[] args) {

        SparseMatrixRooutes matrix = new SparseMatrixRooutes();
        matrix.addRoute(1, 2, 5);
        matrix.addRoute(4, 3, 10);
        matrix.addRoute(5, 4, 12);

        matrix.PrintAllRoutes();
        matrix.removeRoute(1,3);
        matrix.PrintAllRoutes();
        System.out.println("Time from 1 to 2: " + matrix.getRoute(1, 2));
        System.out.println("Time from 4 to 3: " + matrix.getRoute(4, 3));
        System.out.println("Time from 5 to 4: " + matrix.getRoute(5, 4));
        System.out.println();
        SparseMatrixRooutes transpose = matrix.transpose();
        System.out.println("Transpose matrix : ");
        transpose.PrintAllRoutes();
        SparseMatrixRooutes matrix2 = new SparseMatrixRooutes();
        matrix2.addRoute(2, 3, 5);
        matrix2.addRoute(3, 4, 4);
        matrix2.addRoute(4, 5, 2);
        matrix2.PrintAllRoutes();
        System.out.println("Multy Matris matris : ");
        SparseMatrixRooutes MultyMatris = matrix.multiply(matrix2);
        MultyMatris.PrintAllRoutes();




}
}