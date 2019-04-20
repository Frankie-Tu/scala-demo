package com.frankie.app

import com.frankie.app.basics.HumanTrait

// abstract class
abstract class AbstractHuman {
  val humanName: String
  val humanHeight : Double
  val humanWeight : Double
  def tellMeAboutYourself(): Unit
}

// concrete class inherits abstract class AbstractHuman and implements trait HumanTrait
class Human (name: String, height: Double, weight: Double) extends AbstractHuman with HumanTrait[Human] {
  val humanName: String = name
  val humanHeight : Double = height
  val humanWeight : Double = weight
  def getHeight: Double = {
    humanHeight
  }

  def getWeight: Double = {
    humanWeight
  }

  def getName: String = {
    humanName
  }
  // implement
  def tellMeAboutYourself(): Unit = {
    println(s"I'm a Human, I'm $humanHeight cm tall and I weigh $humanWeight kilograms")
  }
  // implement
  def compareHeight(x: Human): String = {
    if (this.humanHeight > x.getHeight) {
      s"${this.getName} measures ${this.getHeight} cm and is taller than ${x.getName} at ${x.getHeight} cm"
    } else if (this.humanHeight < x.getHeight) {
      s"${this.getName} measures ${this.getHeight} cm and is shorter than ${x.getName} at ${x.getHeight} cm"
    } else {
      s"${this.getName} has the same height as ${x.getName} at ${this.getHeight}"
    }
  }
}

// inherit concrete class Human
class Girl (val name: String, val height: Double, val weight: Double) extends Human (name, height, weight) {
  // method override
  override def tellMeAboutYourself(): Unit = {
    println(s"I'm a Girl, my name is $humanName. I'm $humanHeight cm tall and I weigh $humanWeight kilograms")
  }
}

class Boy (val name: String, val height: Double, val weight: Double) extends Human (name, height, weight) {
  override def tellMeAboutYourself(): Unit = {
    println(s"I'm a Boy, my name is $humanName. I'm $humanHeight cm tall and I weigh $humanWeight kilograms")
  }
}

class MethodOverloadingExample {
  def printOut (x: String): String = {
    s"printOut Method with one argument $x"
  }
  // method overloading 1
  def printOut(x: Int): String ={
    s"printOut Method with one Integer argument $x"
  }
  // method overloading 2
  def printOut (x: String, y: String): String ={
    s"printOut Method with two arguments $x & $y"
  }
}

object ClassAndObjects {
  def main(args: Array[String]): Unit = {
    new Human("Human",168, 60).tellMeAboutYourself()
    val theGirl = new Girl("Helen", 162, 50)
    theGirl.tellMeAboutYourself()
    val theBoy = new Boy("Frankie", 172, 70)
    theBoy.tellMeAboutYourself()
    val theOtherBoy = new Boy("John", 172, 60)

    println(theBoy.compareHeight(theGirl))
    println(theGirl.compareHeight(theBoy))
    println(theOtherBoy.compareHeight(theBoy))

    val myMethodOverloading = new MethodOverloadingExample()
    println(myMethodOverloading.printOut("arg1"))
    println(myMethodOverloading.printOut(1))
    println(myMethodOverloading.printOut("arg1", "arg2"))
  }
}