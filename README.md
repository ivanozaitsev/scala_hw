# Scala Tasks

## 1st Scala home task: 

1) Create an abstract class Shape. Add methods get_perimeter, get_area for Shape. 
2) Create classes Triangle, Rectangle, Rhomb, Square, Circle, Pentagon, Hexagon inherited from Shape with methods overridden. Sides length (radius for) should be added as attributes. 
3) In a different module create an Object FigureProcessing with Triangle, Rectangle, Rhomb, Square, Circle instances. Add a method to initialize Triangle, Rectangle, Rhomb, Square, Circle with random sides length (in range between 1 and 20). Add a method to return the sum of their shapes. Add a method to return the sum of their perimeters. 
4) Create a companion object for Hexagon. It should have method to check if the Hexagon is regular (all sides equal). 
5) Create a case class ProgrammingLanguagesOne with the following parameters: name (String), version (String), versionReleaseDate (DateTime). 
6) Create a trait LanguageAttributes. It should have an implementation to output / print "Compiled" if the language is compiled or "Interpreted" if the language is interpreted (use some small set of languages and simple if/else logic to check names). 
7) Create another case class ProgrammingLanguagesTwo with the following parameters: name (String), version (String), versionReleaseDate (DateTime). It should tell if the language is compiled or not.