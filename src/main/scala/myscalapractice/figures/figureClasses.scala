package main.scala.com.myscalapractice.figures

import math.Pi
import java.time.LocalDateTime

abstract class Shape {
  def getPerimeter: Double
  def getArea: Double
}

class Triangle(side1: Double, side2: Double, side3: Double) extends Shape {
  def getPerimeter: Double = side1 + side2 + side3

  def getArea: Double = {
    val s = (side1 + side2 + side3) / 2
    math.sqrt(s * (s - side1) * (s - side2) * (s - side3))
  }
}

class Rectangle(length: Double, width: Double) extends Shape {
  def getPerimeter: Double = 2 * (length + width)

  def getArea: Double = length * width
}

class Rhomb(side: Double, height: Double) extends Shape {
  def getPerimeter: Double = 4 * side

  def getArea: Double = side * height
}

class Square(side: Double) extends Rectangle(side, side)

class Circle(radius: Double) extends Shape {
  def getPerimeter: Double = 2 * Pi * radius

  def getArea: Double = Pi * radius * radius
}

class Pentagon(side: Double) extends Shape {
  def getPerimeter: Double = 5 * side

  def getArea: Double = (5 / 4) * side * side / math.tan(Pi / 5)
}


case class ProgrammingLanguagesOne(name: String, version: String, versionReleaseDate: LocalDateTime)

trait LanguageAttributes {
  def languageType: String
}

case class ProgrammingLanguagesTwo(name: String, version: String, versionReleaseDate: LocalDateTime) {
  def isCompiled: Boolean = name match {
    case "Scala" | "Java" => true
    case "Python" => false
    case _ => false
  }
}

sealed trait Language

case class ProgrammingLanguage(name: String, version: String, versionReleaseDate: LocalDateTime) extends Language

case class HumanCommunicationLanguage(languageName: String, countryOfOrigin: String, activeUsersCount: Int) extends Language

