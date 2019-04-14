package com.frankie.app

import collection.immutable.List
import collection.mutable.HashMap
import scala.util.control.Breaks._

class MiniBank {
  // database private vars
  private val userName: List[String] = List("Frankie",
                                    "John",
                                    "Mike")
  private var password: HashMap[String,String] = HashMap("Frankie" -> "FrankiePW",
                                                 "John" -> "JohnPW",
                                                  "Mike" -> "Mike123")
  private var balance: HashMap[String, Double] = HashMap("Frankie" -> 0,
                                                  "John" -> 0,
                                                  "Mike" -> 0)
  private var sleepTimer = 2000

  val formatter = java.text.NumberFormat.getInstance

  def login(): Unit = {
    // initializing session
    var attempts = 3
    var user = requestUser()
    var pw = requestPw()

    breakable {
      while (attempts > 1) {
        // if username correct
        if (userName.contains(user)) {
          // if username correct but password wrong
          if (password(user) != pw) {
            while (attempts > 1) {
              attempts -= 1
              println(s"Invalid password, please try again, remaining attempt: $attempts")
              pw = requestPw()
              // check if password correct after update
              if (password(user) == pw) {
                bankInteration(user)
                break()
              }
            }
            println("You have exceeded max number of attempts, account is temporarily locked")
            break()
          } else {
            bankInteration(user)
            break()
          }
          // if username wrong
        } else {
          println("Invalid username and password combination!! Please try again")
          user = requestUser()
          pw = requestPw()
          attempts -= 1
        }
      }
      println("Please check your username and password, and try again later. Your access is temporarily blocked")
    }
  }

  private def requestUser(): String ={
    print("UserName: ")
    scala.io.StdIn.readLine()
  }

  private def requestPw(): String ={
    print("Password: ")
    scala.io.StdIn.readLine()
  }

  private def bankInteration(user: String): Unit = {
    breakable(while (true) {
      println()
      println("#################################################\n" +
        s"# Welcome home, $user\n" +
        "# Please selection one of the following options:\n" +
        "# 1. Check balance\n" +
        "# 2. Withdraw funds\n" +
        "# 3. Making deposit\n" +
        "# 4. Exit\n" +
        "#################################################")
      val userOption = scala.io.StdIn.readLine()
      if (userOption == "1") {
        checkBalance(user)
      } else if (userOption == "2") {
        makingWithdraw(user)
      } else if (userOption == "3") {
        makingDeposit(user)
      } else if (userOption == "4") {
        println("Thank you for using automated banking system. Exiting now...")
        break()
      } else {
        println("Invalid option, please try again!")
      }
    })
  }

  private def checkBalance(user: String): Unit ={
    println(s"----------------------Account Balance: $$${formatter.format(balance(user))}------------------------")
    Thread.sleep(sleepTimer)
  }

  private def makingDeposit(user: String): Unit = {
    print("Deposit amount: ")
    val depositAmount = scala.io.StdIn.readDouble()
    balance(user) += depositAmount
    println(s"$$${formatter.format(depositAmount)} has been deposited!")
    Thread.sleep(sleepTimer)
  }

  private def makingWithdraw(user: String): Unit = {
    print("Withdraw amount: ")
    val withdrawAmount = scala.io.StdIn.readDouble()
    if (withdrawAmount > balance(user)) {
      println("Insufficient fund!! Please try again.")
      Thread.sleep(sleepTimer)
    } else {
      balance(user) -= withdrawAmount
      println(s"$withdrawAmount has been withdrawn\n" +
        s"----------------------Account Balance: $$${formatter.format(balance(user))}------------------------")
      Thread.sleep(sleepTimer)
    }
  }
}

object ATM extends App{
  val mybank: MiniBank = new MiniBank()
  //mybank.login
  mybank.login

}