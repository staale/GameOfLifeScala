package jpr11

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class AliveCellSpec extends FlatSpec with ShouldMatchers {

  "A live cell with two live neighbors" should "stay alive" in {
    AliveCell.createNextGeneration(liveNeighborCount = 2) should be(AliveCell)
  }

  "A live cell with three live neighbors" should "stay alive" in {
    AliveCell.createNextGeneration(liveNeighborCount = 3) should be(AliveCell)
  }

  "A live cell with one live neighbor" should "die" in {
    AliveCell.createNextGeneration(liveNeighborCount = 1) should be(DeadCell)
  }

  "A live cell with four live neighbors" should "die" in {
    AliveCell.createNextGeneration(liveNeighborCount = 4) should be(DeadCell)
  }

  "A live cell with zero live neighbors" should "die" in {
    AliveCell.createNextGeneration(liveNeighborCount = 0) should be(DeadCell)
  }

  "A live cell with minimum possible live neighbors" should "die" in {
    AliveCell.createNextGeneration(liveNeighborCount = 0) should be(DeadCell)
  }

  "A live cell with maximum possible live neighbors" should "die" in {
    AliveCell.createNextGeneration(liveNeighborCount = 8) should be(DeadCell)
  }

  "A live cell with an illegal number of live neighbors" should "throw an exception" in {
    evaluating { AliveCell.createNextGeneration(liveNeighborCount = 9) } should produce[IllegalArgumentException]
    evaluating { AliveCell.createNextGeneration(liveNeighborCount = -1) } should produce[IllegalArgumentException]
  }
}


// vim: set ts=4 sw=4 et:
