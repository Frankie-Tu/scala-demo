package com.frankie.app

class Company {
  class InnerClass {
    // private function accessible within InnerClass
    private def helloWorld {
      println("hello world")
    }

    class InnerMost {
      // Access scope to InnerMost only
      private[this] var confidential = "confidential information"
      // Access scope to any class within class InnerClass
      private[InnerClass] var secret = "secret information"
      // Access scope to any class within class Company
      private[Company] var internal = "Internal information"

      def getConfidential: String = {
        confidential
      }
    }
    // accessing func from within Innerclass
    def callHelloWorld: Unit = {
      helloWorld
    }

    def getInnerMost: InnerMost = {
      new InnerMost()
    }
    // accessing secret from within InnerClass
    def getSecret: String = {
      getInnerMost.secret
    }
  }
  
  def getInnerClass: InnerClass = {
    new InnerClass()
  }

  def getInternal: String = {
    getInnerClass.getInnerMost.internal
  }
}

object ClassModifiers {
  def main(args: Array[String]): Unit = {
    val myclass = new Company

    myclass.getInnerClass.callHelloWorld

    println(myclass.getInternal)
    println(myclass.getInnerClass.getSecret)
    println(myclass.getInnerClass.getInnerMost.getConfidential)
  }
}