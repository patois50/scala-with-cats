package com.patrickmcgeever.scalawithcats.ex1_3typeclasses

object Printable {
  def format[A](a: A)(implicit printable: Printable[A]): String =
    printable.format(a)

  def print[A](a: A)(implicit printable: Printable[A]): Unit =
    println(printable.format(a))
}

trait Printable[A] {
  def format(a: A): String
}

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    override def format(a: String): String = s"String - $a"
  }

  implicit val intPrintable = new Printable[Int] {
    override def format(a: Int): String = s"Int - ${a.toString}"
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](a: A) {
    def format(implicit p: Printable[A]): String = p.format(a)
    def print(implicit p: Printable[A]): Unit = println(p.format(a))
  }
}