package main.scala.com.myscalapractice.languages
import java.time.LocalDateTime

case class ProgrammingLanguagesOne(name: String, version: String, versionReleaseDate: LocalDateTime)
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

