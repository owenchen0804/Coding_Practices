package DIYStructure;

public class LC348_DesignTicTacToc {
    //  win的条件是只要有一行or一列or正对角线or反对角线的sum的绝对值为size那么就结束了
    //  且哪一个玩家的move()完成后达到了win的条件就返回那个player；
    //  这里的小技巧是玩家1的move()就+1，而玩家2的move()是-1
    //  但是总的来说要赢都需要n个+1，或者n个-1来满足

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public LC348_DesignTicTacToc(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */

    public int move(int row, int col, int player) {

        int n = rows.length;
        int toAdd = player == 1 ? 1 : -1;
        //  rows[i]就是指那一行有要么1要么-1，那么只要某一行达到n的话就赢了
        rows[row] += toAdd;
        //  同理，对于第col列的话cols[col]++，完成了之后再看这一行是否达到n
        cols[col] += toAdd;
        //  正对角线
        if (row == col) {
            diagonal += toAdd;
        }
        //  反对角线
        if (row + col == n - 1) {
            antiDiagonal += toAdd;
        }

        //  After move之后来判断一下是否有winner出现
        //  注意要取绝对值！
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n  ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        return 0;
    }
}
