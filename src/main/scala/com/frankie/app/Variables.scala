package com.frankie.app

class Variables {
  // mutable, re-assignment allowed
  var myVar = 1
  // immutable, re-assignment NOT allowed
  val myVal = 2
  // multiple assignments
  val (myP1, myP2) = Pair("pair1", "pair2")
  // no data type declaration
  val noDeclaration1 = "no declaration"
  val noDeclaration2 = 123
}

object VariableDemo extends App {
  val myVariables = new Variables()
  println(s"my var is: ${myVariables.myVar}")
  myVariables.myVar = 3
  println(s"my reassigned var is: ${myVariables.myVar}")
  println(s"my val is: ${myVariables.myVal}")
  println(s"my pair is: ${myVariables.myP1} & ${myVariables.myP2}")
  println(s"no data type declaration: ${myVariables.noDeclaration1}")
  println(s"no data type declaration: ${myVariables.noDeclaration2}")
}