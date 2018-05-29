package com.patrickmcgeever.scalawithcats.ex1_3typeclasses

object Runner extends App {

  import PrintableInstances._

  Printable.print("Dog")
  Printable.print(98)

}
