package core.utils.thread;

/**
 * Implementation of MatrixBlocks for threading.
 *
 * @author Ivan Tarasov
 * @since 1.0.0
 */
public class BlockThread implements Runnable {
  String name = "Block thread: ";
  Thread t;
  Block block;

  public BlockThread(int name, Block block) {
    this.name += String.valueOf(name);
    this.block = block;
    t = new Thread(this,this.name);
    t.start();
  }

  public Thread getT() {
    return t;
  }

  public Block getBlock() {
    return block;
  }

  @Override
  public void run() {
    block.findMult();
  }
}
