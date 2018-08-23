package com.codecool.scala.linkedlist

trait List {
  def add(element: Int)
  def insert(index: Int, element: Int)
  def remove(element: Int)
  def get(index: Int): Int
  def getIndex(element: Int): Int
}
