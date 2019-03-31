package com.frankie.app

object HelloWorld{
  // Similar to public static void main in Java
  def main(args:Array[String]): Unit ={
    println("Hello World")
  }
}

// Another way, extends App
object HelloWorld2 extends App {
  println("Hello World 2")
}
