package main.scala
import scala.util.Random

// Task #3
object FigureProcessing {

  def getRandomSideLength: Double = {
    Random.between(1, 20).toDouble
  }

  def initializeFigures: (Triangle, Rectangle, Rhomb, Square, Circle) = {
    val triangle = new Triangle(getRandomSideLength, getRandomSideLength, getRandomSideLength)
    val rectangle = new Rectangle(getRandomSideLength, getRandomSideLength)
    val rhomb = new Rhomb(getRandomSideLength, getRandomSideLength)
    val square = new Square(getRandomSideLength)
    val circle = new Circle(getRandomSideLength)

    (triangle, rectangle, rhomb, square, circle)
  }

  def sumOfAreas(figures: (Triangle, Rectangle, Rhomb, Square, Circle)): Double = {
    figures.productIterator.collect { case s: Shape => s.getArea }.sum
  }

  def sumOfPerimeters(figures: (Triangle, Rectangle, Rhomb, Square, Circle)): Double = {
    figures.productIterator.collect { case s: Shape => s.getPerimeter }.sum
  }

  def main(args: Array[String]): Unit = {
    val figures = initializeFigures
    println(s"Sum of Areas: ${sumOfAreas(figures)}")
    println(s"Sum of Perimeters: ${sumOfPerimeters(figures)}")
  }
}

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


