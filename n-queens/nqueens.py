from sys import argv

# Utility function for solving the N-Queens
# problem using backtracking.
def nQueenUtil(j, n, board, result, 
              rows, diag1, diag2):
    if j > n:
      
        # A solution is found
        result.append(board.copy())
        return
    for i in range(1, n +1):
        if not rows[i] and not diag1[i + j] and \
           not diag2[i - j + n]:
          
            # Place queen
            rows[i] = diag1[i + j] = \
                      diag2[i - j + n] = True
            board.append(i)
            
            # Recurse to next column
            nQueenUtil(j +1, n, board, 
                      result, rows, diag1, diag2)
            
            # Remove queen (backtrack)
            board.pop()
            rows[i] = diag1[i + j] = \
                      diag2[i - j + n] = False

# Solves the N-Queens problem and returns
# all valid configurations.
def nQueen(n):
    result = []
    board = []
    rows = [False] * (n +1)
    diag1 = [False] * (2 * n +1)
    diag2 = [False] * (2 * n +1)
    
    # Start solving from first column
    nQueenUtil(1, n, board, result, 
              rows, diag1, diag2)
    return result

def main():
    n=int(argv[1])
    result = nQueen(n)
#   for res in result:
#       print("[", end="")
#       for i in range(len(res)):
#           print(res[i], end="")
#           if i != len(res)-1:
#               print(", ", end="")
#       print("]")
        
main()
