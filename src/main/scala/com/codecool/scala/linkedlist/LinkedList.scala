package com.codecool.scala.linkedlist

import scala.annotation.tailrec

class LinkedList (var size: Int = 0, var head: Node = null) extends List {

  @Override
  def add(data: Int) {
    val newNode = createNode(data)
    try {
      val node: Node = getEndOfList(this.head)
      node.nextNode = newNode
    } catch {
      case ex: NullPointerException => this.head = newNode
    }
    this.size += 1
  }

  @Override
  def insert(index: Int, data: Int) { //TODO
    var node: Node = this.head
    val newNode: Node = createNode(data)
    var previousNode: Node = null
    for (i <- 0 until index){
        previousNode = node
        node = node.nextNode
        if (node == null){
          previousNode.nextNode = newNode
          return
      }
    }
    if (previousNode != null) previousNode.nextNode = newNode
    newNode.nextNode = node
    if (index == 0) this.head = newNode
  }

  @Override
  def remove(element: Int) {
    var node: Node = this.head
    var previousNode: Node = null
    removeNode()

    def removeNode(): Unit ={
      if (node == null) throw new NoSuchElementException
      else if (node.data == element)
        if (this.head == node) this.head = node.nextNode
        else previousNode.nextNode = node.nextNode
      else {
        previousNode = node
        node = node.nextNode
        removeNode()
      }
    }
  }

  @Override
  def get(index: Int): Int = {
    var node: Node = this.head
    for (i <- 0 until index){
      try {
        node = node.nextNode
      } catch {
        case ex: NullPointerException => throw new IndexOutOfBoundsException
      }
    }
    node.data
  }

  @Override
  def getIndex(element: Int): Int = {
    var node: Node = this.head
    var index: Int = 0
    while (node.nextNode != null){
      if (node.data == element) return index
      else {
        index += 1
        node = node.nextNode
      }
    }
    throw new NoSuchElementException
  }

  private def createNode(data: Int): Node ={
    new Node(data)
  }

  @tailrec
  private def getEndOfList(node: Node): Node = {
    if (node.nextNode == null) node
    else getEndOfList(node.nextNode)
  }


  override def toString = {
    var node: Node = this.head
    var string: String = node.data.toString
    while (node.nextNode != null) {
      node = node.nextNode
      string = string ++ " <= " ++ node.data.toString
    }
    string
  }
}
