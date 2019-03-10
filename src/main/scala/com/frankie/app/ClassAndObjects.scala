package com.frankie.app

class Human (height: Double, weight: Double) {
  val humanHeight : Double= height
  val humanWeight : Double = weight
  def getHeight: Double = {
    humanHeight
  }

  def getWeight: Double = {
    humanWeight
  }

  def speak: String = {
    s"I'm a Human, I'm ${humanHeight}cm tall and I weigh $humanWeight kilograms"
  }
}

// inheritance
class Girl (val height: Double, val weight: Double) extends Human (height, weight) {
  // method override
  override def speak: String = {
    s"I'm a Girl, I'm ${humanHeight}cm tall and I weigh $humanWeight kilograms"
  }
}

class Boy (val height: Double, val weight: Double) extends Human (height, weight) {
  override def speak: String = {
    s"I'm a Boy, I'm ${humanHeight}cm tall and I weigh $humanWeight kilograms"
  }
}

class MethodOverloadingExample {
  def printOut (x: String): String = {
    s"printOut Method with one argument $x"
  }
  // overloading 1
  def printOut(x: Int): String ={
    s"printOut Method with one Integer argument $x"
  }
  // overloading 2
  def printOut (x: String, y: String): String ={
    s"printOut Method with two arguments $x & $y"
  }
}

object ClassAndObjects {
  def main(args: Array[String]): Unit = {
    println(new Human(168, 60).speak)
    println(new Girl(162, 50).speak)
    println(new Boy(172, 70). speak)
    val myMethodOverloading = new MethodOverloadingExample()
    println(myMethodOverloading.printOut("arg1"))
    println(myMethodOverloading.printOut(1))
    println(myMethodOverloading.printOut("arg1", "arg2"))
  }
}