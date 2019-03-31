package com.frankie.app

class DataTypes {
  // -128 to 127, 8 bit
  val myByte: Byte = 127
  // -32768 to 32767, 16bit
  val myShort: Short = 32767
  // -2147483648 to 2147483647, 32 bit
  val myInt: Int = 2147483647
  // -9223372036854775808 to 9223372036854775807, 64 bit
  val myLong : Long = 9223372036854775807l
  // IEEE single=precision float, 31 bit
  val myFloat: Float = 1.23456789f
  // IEEE double-precision float, 64 bit
  val myDouble: Double = 1.23456789
  // Range from U+0000 to U+FFFF, 16 bi
  val myChar: Char = '\u005A'
  // Sequence of Chars
  val myString: String = "Hello World"
  // true / false
  val myBool: Boolean = true
  // null
  val myNull = null
  // Anything
  val myAny: Any = "Anything"
}

object DataTypeDemo extends App {
  val myDataTypes = new DataTypes()
  println(s"my byte is: ${myDataTypes.myByte}")
  println(s"my short is: ${myDataTypes.myShort}")
  println(s"my Integer is: ${myDataTypes.myInt}")
  println(s"my Long is: ${myDataTypes.myLong}")
  println(s"my Float is: ${myDataTypes.myFloat}")
  println(s"my Double is: ${myDataTypes.myDouble}")
  println(s"my Char is: ${myDataTypes.myChar}")
  println(s"my String is: ${myDataTypes.myString}")
  println(s"my Boolean is: ${myDataTypes.myBool}")
  println(s"my null value is: ${myDataTypes.myNull}")
  println(s"my any value is: ${myDataTypes.myAny}")
}