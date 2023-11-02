import java.time.LocalDateTime
import main.scala.ProgrammingLanguagesOne
import main.scala.LanguageAttributes
import main.scala.ProgrammingLanguagesTwo

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
    // todo match / case
    if (compilationType == "java" || compilationType == "c" || compilationType == "c++" ||
      compilationType == "rust" || compilationType == "scala") {
      println(s"${language.languageType} is a Compiled language.")
    } else if (compilationType == "python" || compilationType == "javascript" ||
      compilationType == "ruby" || compilationType == "php") {
      println(s"${language.languageType} is an Interpreted language.")
    } else {
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


