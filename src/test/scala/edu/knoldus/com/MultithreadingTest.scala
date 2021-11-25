package edu.knoldus.com
import com.knoldus.edu.SearchAllDirectiories.allDirectiories
import org.scalatest.funsuite.AnyFunSuite
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


class  MultithreadingTest extends AnyFunSuite {

  val res1: Future[List[String]] = allDirectiories("./src")

  val result1:List[String]=List("./src/main", "./src/test", "./src/main/scala", "./src/main/scala/com",
                                "./src/main/scala/com/knoldus", "./src/main/scala/com/knoldus/edu",
                                "./src/main/scala/com/knoldus/edu/Multithreading.scala", "./src/test/scala",
                                "./src/test/scala/edu", "./src/test/scala/edu/knoldus", "./src/test/scala/edu/knoldus/com",
                                "./src/test/scala/edu/knoldus/com/MultithreadingTest.scala"
  )
  //assert(res1==result1.length)

  // case -1 Seaching the Directory and all its subdirectories present in the Directory and files.
  test("Searching to all the Directory and its all subdirectory") {
    println(res1)
    for {
      i<- res1
      j<- res1
    } yield {
      assert(i== result1)
      assert(j.size == result1.size)
    }
  }

  // case -2 Seaching the Directory and all its subdirectories present in the Directory and files.
  val res2: Future[List[String]] = allDirectiories("./src/test/scala")
  val result2:List[String]=List("./src/test/scala/edu",
                                "./src/test/scala/edu/knoldus",
                                "./src/test/scala/edu/knoldus/com",
                                "./src/test/scala/edu/knoldus/com/MultithreadingTest.scala"
  )
  test("Searching the directory  ") {
    println(res2)
    for {
      i<- res2
     j<- res2
    } yield {
      assert(i == result2)
      assert(j.size == result2.size)
    }
  }
//case -3 Searching the empty Directiory
  val res3: Future[List[String]] = allDirectiories("")
  val result3:List[String]=List()
  test("Searching the Empty Directory"){
    println(res3)
    for {
      i<- res3
      j <- res3
    } yield {
      assert(i == result3)
      assert(j.size == result3.size)
    }
  }
}

