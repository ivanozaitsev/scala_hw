package main.scala.com.myscalapractice.figures
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


