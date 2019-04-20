package com.frankie.app.basics

// generic trait
trait HumanTrait[A] {
  def compareHeight(x: A): String
}