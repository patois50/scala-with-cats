package com.patrickmcgeever.scalawithcats.ex1_3typeclasses

object Runner extends App {

  import PrintableInstances._
  import PrintableSyntax._

  final case class Cat(name: String, age: Int, colour: String)

  private implicit val catPrintable = new Printable[Cat] {
    override def format(a: Cat): String = s"${a.name} is a ${a.age.toString} year-old ${a.colour} cat."
  }

  Printable.print("Dog")
  Printable.print(98)
  Printable.print(Cat("Garfield", 4, "ginger"))

  Cat("Moggy", 2, "black").print
}
