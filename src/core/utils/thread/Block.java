package core.utils.thread;

import core.utils.matrix.MatrixBlock;

/**
 * Unit of a data to work with in threads.
 *
 *
 * @author Ivan Tarasov.
 * @since 1.0.0
 */
public class Block {
  private MatrixBlock block;

  public Block(MatrixBlock block) {
    this.block = block;
  }

  public MatrixBlock getBlock() {
    return block;
  }

  public void findMult(){
    block.countMult();
  }
}
