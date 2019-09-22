package core.utils.matrix;

import static core.utils.constraints.Constraints.M;
import static core.utils.constraints.Constraints.N;

import core.utils.constraints.Constraints;
import java.util.Random;

/**
 * Matrix of elements.
 *
 * @author Ivan Tarasov
 * @since 1.0.0
 */
public class Matrix implements MatrixOperation {

  private MatrixBlock[] blocks;
  private int[][] arr;

  public Matrix() {
    blocks = new MatrixBlock[Constraints.N_THREAD];
    // init matrix's elements
    fillMatrix();
  }

  private void fillMatrix() {
    initMatrix();

    Random random = new Random();
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        arr[i][j] = random.nextInt(Constraints.RANDOM_BOUND) + 10;
  }

  private void initMatrix() {
    arr = new int[N][];
    for (int i = 0; i < N; i++)
      arr[i] = new int[M];
  }

  public MatrixBlock[] getMatrixBlocks() {

    int colmsMiddle;
    colmsMiddle = M / 2 + 1;

    int rowsMiddle;
    rowsMiddle = N / 2 + 1;

    for (int i = 0; i < blocks.length; i++) {
      // choosing a right block of matrix
      switch (i) {
        case 0:
          blocks[i] = new MatrixBlock(arr, 0, colmsMiddle, 0, rowsMiddle);
          break;
        case 1:
          blocks[i] = new MatrixBlock(arr, colmsMiddle, M, 0, rowsMiddle);
          break;
        case 2:
          blocks[i] = new MatrixBlock(arr, 0, colmsMiddle, rowsMiddle, N);
          break;
        case 3:
          blocks[i] = new MatrixBlock(arr, colmsMiddle, M, rowsMiddle, N);
          break;
      }
    }
    return blocks;
  }

  public void print() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.printf("%d", arr[i][j]);
        System.out.print("\t\t");
      }

      System.out.println();
    }
  }

  public void cleanUp() {
    arr = null;
  }

  @Override
  public int countMult() {
    int amount = 0;
    for (int i = 0; i < Constraints.N; i++)
      for (int j = 0; j < Constraints.M; j++)
        if (arr[i][j] % Constraints.X == 0)
          amount++;

    return amount;
  }
}