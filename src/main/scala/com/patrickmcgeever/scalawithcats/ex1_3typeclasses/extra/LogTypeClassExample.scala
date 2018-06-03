package com.patrickmcgeever.scalawithcats.ex1_3typeclasses.extra

object LogTypeClassExample extends App {

  trait Animal {
    val name: String
    val call: String
  }

  trait LogPrinter[E] {
    def toLogLine(e: E): String
  }

  object LogPrinterInstances {
    implicit val animalLogPrinter = new LogPrinter[Animal] {
      override def toLogLine(e: Animal): String = s"name=${e.name} call=${e.call}"
    }
  }

  object LogPrinterSyntax {
    implicit class LogPrinterOps[A](a: A) {
      def toLogLine(implicit logPrinter: LogPrinter[A]): String = logPrinter.toLogLine(a)
    }
  }

  val dog = new Animal {
    override val name: String = "dog"
    override val call: String = "woof"
  }


  import LogPrinterInstances._
  import LogPrinterSyntax._

  println(dog.toLogLine)


}