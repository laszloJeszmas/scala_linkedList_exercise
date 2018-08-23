package com.codecool.scala.linkedlist

object Main {

  def main(args: Array[String]): Unit = {
    val linkedList: LinkedList = new LinkedList()
    linkedList.add(5)
    linkedList.add(11)
    linkedList.add(23)
    linkedList.insert(0, 100000)
    linkedList.remove(23)
    println(linkedList)
  }
}
