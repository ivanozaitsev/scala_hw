package main.scala.com.myscalapractice.languages
import main.scala.com.myscalapractice.utils.LanguageAttributes
import scala.util.{Try, Success, Failure}
import java.time.LocalDateTime


// Output of task 5
object ProgrammingLanguagesOneObj {
  def main(args: Array[String]): Unit = {
    val scala = ProgrammingLanguagesOne("Scala", "2.13.6", LocalDateTime.now())

    println(s"Language: ${scala.name}")
    println(s"Version: ${scala.version}")
    println(s"Release Date: ${scala.versionReleaseDate}")
  }
}

// Output of task 6
object LanguageAttributes {
  def printCompilationType(language: LanguageAttributes): Unit = {
    val compilationType = language.languageType.toLowerCase

    compilationType match {
      case "java" | "c" | "c++" | "rust" | "scala" =>
        println(s"${language.languageType} is a Compiled language.")
      case "python" | "javascript" | "ruby" | "php" =>
        println(s"${language.languageType} is an Interpreted language.")
      case _ =>
        println(s"Compilation type for ${language.languageType} is unknown.")
    }
  }
}

// In the LanguageAttributesTest object, I create instances of classes that implement the LanguageAttributes trait for Java and Python,
// and then call the printCompilationType method to determine and print their compilation types.
object LanguageAttributesTest extends App {
  val java = new LanguageAttributes {
    override def languageType: String = "Java"
  }

  val python = new LanguageAttributes {
    override def languageType: String = "Python"
  }

  LanguageAttributes.printCompilationType(java)
  LanguageAttributes.printCompilationType(python)
}

// Output of task 7
object ProgrammingLanguagesTwoObj {
  def main(args: Array[String]): Unit = {
    val scala = ProgrammingLanguagesTwo("Scala", "2.13.6", LocalDateTime.now())
    val python = ProgrammingLanguagesTwo("Python", "3.9", LocalDateTime.now())
    val java = ProgrammingLanguagesTwo("Java", "11", LocalDateTime.now())
    val unknown = ProgrammingLanguagesTwo("UnknownLanguage", "1.0", LocalDateTime.now())

    println(s"${scala.name} is ${if (scala.isCompiled) "Compiled" else "not Compiled"} language")
    println(s"${python.name} is ${if (python.isCompiled) "Compiled" else "not Compiled"} language")
    println(s"${java.name} is ${if (java.isCompiled) "Compiled" else "not Compiled"} language")
    println(s"${unknown.name} is ${if (unknown.isCompiled) "Compiled" else "not Compiled"} language")
  }
}

object LanguageDescription {

  def describe(language: Language): Unit = language match {
    case ProgrammingLanguage(name, version, releaseDate) =>
      println(s"Programming Language: $name, Version: $version, Release Date: $releaseDate")
    case HumanCommunicationLanguage(languageName, countryOfOrigin, usersCount) =>
      println(s"Human Communication Language: $languageName, Country of Origin: $countryOfOrigin, Active Users: $usersCount")
  }

  def isCompiled(language: Language): Try[Boolean] = language match {
    case _: ProgrammingLanguage => Success(true)
    case _: HumanCommunicationLanguage => Failure(new UnsupportedOperationException("HumanCommunicationLanguage is not compiled."))
  }

  def extractProgrammingInfo(languages: Vector[Language]): Vector[Option[String]] = {
    languages.map {
      case ProgrammingLanguage(name, version, _) => Some(s"Programming Language: $name, Version: $version")
      case _ => None
    }
  }

  def main(args: Array[String]): Unit = {
    val english = HumanCommunicationLanguage("Ukrainian", "Kyivan Rus'", 50000000)
    val python = ProgrammingLanguage("Python", "3.9", LocalDateTime.of(2020, 10, 5, 0, 0))
    val scala = ProgrammingLanguage("Scala", "2.13", LocalDateTime.of(2019, 7, 7, 0, 0))

    describe(scala)
    describe(python)
    describe(english)

    val languages = Vector(scala, python, english)

    isCompiled(scala) match {
      case Success(value) => println(s"Is Scala Compiled: $value")
      case Failure(exception) => println(s"Error checking if Scala is compiled: ${exception.getMessage}")
    }

    isCompiled(python) match {
      case Success(value) => println(s"Is Python Compiled: $value")
      case Failure(exception) => println(s"Error checking if Python is compiled: ${exception.getMessage}")
    }

    isCompiled(english) match {
      case Success(value) => println(s"Is English Compiled: $value")
      case Failure(exception) => println(s"Error checking if English is compiled: ${exception.getMessage}")
    }

    val programmingInfo = extractProgrammingInfo(languages)
    programmingInfo.foreach(println)
  }
}



