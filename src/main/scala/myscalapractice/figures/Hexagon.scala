package main.scala.com.myscalapractice.figures

// Output of task # 4
class Hexagon(sideLengths: Seq[Double]) {
  def isRegular: Boolean = {
    sideLengths.tail.forall(side => Math.abs(side - sideLengths.head) < 0.00001)
  }
}

object Hexagon {
  def apply(sideLengths: Double*): Hexagon = new Hexagon(sideLengths)
  def createRegularHexagon(sideLength: Double): Hexagon = Hexagon(Seq.fill(6)(sideLength): _*)
  def isRegular(hexagon: Hexagon): Boolean = hexagon.isRegular

  def main(args: Array[String]): Unit = {
    val regular = Hexagon.createRegularHexagon(10)
    val irregular = Hexagon(10, 10, 10, 10, 10, 11)

    println(s"Hexagon is ${if (Hexagon.isRegular(regular)) "Regular" else "Irregular"}")
    println(s"Hexagon is ${if (Hexagon.isRegular(irregular)) "Regular" else "Irregular"}")
  }
}