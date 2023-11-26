object RecursiveSum {
  def recursiveSum(someList: List[Int]): Int = someList match {
    case Nil => 0
    case head :: tail => head + recursiveSum(tail)
  }

  def main(args: Array[String]): Unit = {
    val myList = List(1, 2, 3)
    val result = recursiveSum(myList)
    println(s"Sum of elements in the list $myList is: $result")
  }
}

object RecursiveSumTail {
  def recursiveSumTail(list: List[Int], currentSum: Int = 0): Int = list match {
    case Nil => currentSum
    case head :: tail => recursiveSumTail(tail, currentSum + head)
  }

  def main(args: Array[String]): Unit = {
    val myList = List(1,2,3)
    val result = recursiveSumTail(myList)
    println(s"Sum of elements in the list $myList is: $result")
  }
}
