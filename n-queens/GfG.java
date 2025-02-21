import java.util.ArrayList;
import java.util.List;

// Utility class for N-Queens
class GfG {

    // Utility function for solving the N-Queens
    // problem using backtracking.
    static void nQueenUtil(int j, int n,
                    List<Integer> board,
                    List<List<Integer> > result,
                    boolean[] rows, boolean[] diag1,
                    boolean[] diag2){
        if (j > n) {
          
            // A solution is found
            result.add(new ArrayList<>(board));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!rows[i] && !diag1[i + j]
                && !diag2[i - j + n]) {
              
                // Place queen
                rows[i] = diag1[i + j] = diag2[i - j + n]
                    = true;
                board.add(i);
              
                // Recurse to next column
                nQueenUtil(j + 1, n, board, result, rows,
                           diag1, diag2);
              
                // Remove queen (backtrack)
                board.remove(board.size() - 1);
                rows[i] = diag1[i + j] = diag2[i - j + n]
                    = false;
            }
        }
    }

    // Solves the N-Queens problem and returns
    // all valid configurations.
    static List<List<Integer> > nQueen(int n){
      
        List<List<Integer> > result = new ArrayList<>();
        List<Integer> board = new ArrayList<>();
        boolean[] rows = new boolean[n + 1];
        boolean[] diag1 = new boolean[2 * n + 1];
        boolean[] diag2 = new boolean[2 * n + 1];
      
        // Start solving from first column
        nQueenUtil(1, n, board, result, rows, diag1, diag2);
        return result;
    }

    public static void main(String[] args){
      
        int n = Integer.parseInt(args[0]);
        List<List<Integer> > result = nQueen(n);
        for (List<Integer> res : result) {
            System.out.print("[");
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
