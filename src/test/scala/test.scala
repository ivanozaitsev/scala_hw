package main.scala.com.myscalapractice.figures
import java.time.LocalDateTime
import math.Pi

object testHW extends App {
  testShape()
  testProgrammingLanguages()

  def testShape(): Unit = {
    println("Testing Shape classes:")

    val triangle = new Triangle(3.0, 4.0, 5.0)
    assert(triangle.getPerimeter == 12.0)
    assert(triangle.getArea == 6.0)
    println("Triangle - Perimeter: " + triangle.getPerimeter + ", Area: " + triangle.getArea)

    val rectangle = new Rectangle(4.0, 5.0)
    assert(rectangle.getPerimeter == 18.0)
    assert(rectangle.getArea == 20.0)
    println("Rectangle - Perimeter: " + rectangle.getPerimeter + ", Area: " + rectangle.getArea)

    val rhomb = new Rhomb(6.0, 8.0)
    assert(rhomb.getPerimeter == 24.0)
    assert(rhomb.getArea == 48.0)
    println("Rhomb - Perimeter: " + rhomb.getPerimeter + ", Area: " + rhomb.getArea)

    val square = new Square(5.0)
    assert(square.getPerimeter == 20.0)
    assert(square.getArea == 25.0)
    println("Square - Perimeter: " + square.getPerimeter + ", Area: " + square.getArea)

    val circle = new Circle(4.0)
    assert(circle.getPerimeter == 2 * Pi * 4.0)
    assert(circle.getArea == Pi * 4.0 * 4.0)
    println("Circle - Perimeter: " + circle.getPerimeter + ", Area: " + circle.getArea)

    val pentagon = new Pentagon(4.0)
    assert(pentagon.getPerimeter == 20.0)
    assert(pentagon.getArea == (5 / 4) * 4.0 * 4.0 / math.tan(Pi / 5))
    println("Pentagon - Perimeter: " + pentagon.getPerimeter + ", Area: " + pentagon.getArea)
  }

  def testProgrammingLanguages(): Unit = {
    println("Testing ProgrammingLanguages classes:")

    val releaseDate = LocalDateTime.now()
    val langOne = ProgrammingLanguagesOne("Scala", "2.13.1", releaseDate)
    assert(langOne.name == "Scala")
    assert(langOne.version == "2.13.1")
    assert(langOne.versionReleaseDate == releaseDate)
    println("ProgrammingLanguagesOne - Name: " + langOne.name + ", Version: " + langOne.version)

    val scalaLang = ProgrammingLanguagesTwo("Scala", "2.13.1", LocalDateTime.now())
    val javaLang = ProgrammingLanguagesTwo("Java", "11.0.1", LocalDateTime.now())
    val pythonLang = ProgrammingLanguagesTwo("Python", "3.9.2", LocalDateTime.now())
    val otherLang = ProgrammingLanguagesTwo("Ruby", "2.7.2", LocalDateTime.now())

    assert(scalaLang.isCompiled)
    assert(javaLang.isCompiled)
    assert(!pythonLang.isCompiled)
    assert(!otherLang.isCompiled)
    println("Scala isCompiled: " + scalaLang.isCompiled)
    println("Java isCompiled: " + javaLang.isCompiled)
    println("Python isCompiled: " + pythonLang.isCompiled)
    println("Ruby isCompiled: " + otherLang.isCompiled)
  }
}