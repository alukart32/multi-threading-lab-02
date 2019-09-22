package core.utils.matrix;

import core.utils.constraints.Constraints;

/**
 * Block of matrix with specified properties.
 *
 * @author Ivan Tarasov.
 * @since 1.0.0
 */
public class MatrixBlock{
  // array of matrix's elements
  private int[][] arr;

  // bounds of block
  private int left;
  private int right;
  private int up;
  private int down;

  // amount of multiplicity elements for X
  private int amount;

  public MatrixBlock(int[][] arr, int left, int right, int up, int down) {
    this.arr = arr;
    this.left = left;
    this.right = right;
    this.up = up;
    this.down = down;
    this.amount = 0;
  }

  public void countMult() {
    // go through a block
    for (int i = this.up; i < this.down;  i++)
      for (int j = this.left; j < this.right; j++)
        if (arr[i][j] % Constraints.X == 0)
          this.amount++;
  }

  public void setUp(int up) {
    this.up = up;
  }

  public int getAmount() {
    return amount;
  }
}
