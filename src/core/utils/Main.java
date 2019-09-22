package core.utils;

import core.utils.constraints.Constraints;
import core.utils.matrix.Matrix;
import core.utils.matrix.MatrixBlock;
import core.utils.thread.Block;
import core.utils.thread.BlockThread;

public class Main {

  public static void main(String[] args) {

    Matrix matrix = new Matrix();
    matrix.print();

    System.out.println();
    System.out.println("Amount of multiplicity for " + Constraints.X + " : " +  matrix.countMult());

    MatrixBlock[] blocks = matrix.getMatrixBlocks();
    BlockThread[] threads = new BlockThread[Constraints.N_THREAD];

    for (int i = 0; i < Constraints.N_THREAD; i++) {
      threads[i] = new BlockThread(i+1, new Block(blocks[i]));
    }

    try {
      threads[0].getT().join();
      threads[1].getT().join();
      threads[2].getT().join();
      threads[3].getT().join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    int amount = 0;
    for (int i = 0; i < threads.length; i++) {
      amount+=threads[i].getBlock().getBlock().getAmount();
    }

    System.out.println("Amount of multiplicity by threading for " + Constraints.X + " : " +  amount);
  }
}
