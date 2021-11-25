package com.knoldus.edu
import com.knoldus.edu.SearchAllDirectiories.allDirectiories
import java.io.File
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.language.postfixOps


object SearchAllDirectiories {

  def allDirectiories(path: String): Future[List[String]] = Future {

    def allDirectiories(dir: File, acc: Boolean = true): List[File] = {
      val files = dir.listFiles
      files ++ files.filter(_.isDirectory).filter(_ => acc).flatMap(allDirectiories(_, acc))
    }.toList

    val list: Seq[File] = allDirectiories(new File(path))
    list.asInstanceOf[List[String]]
  }
}
//object SearhallTheDirectory extends App {
//
//  val allDirectory = allDirectiories("./src")
//  Await.result(allDirectory, Duration.Inf)
//  allDirectory map (paths => paths map println)
//  println(allDirectory)
//
//}