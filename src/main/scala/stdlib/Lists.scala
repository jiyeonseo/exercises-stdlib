package stdlib

import org.scalatest._

/** @param name lists
  *
  */
object Lists extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** Scala Lists are quite similar to arrays which means, all the elements of a list have the same type but there are two important differences. First, lists are immutable, which means elements of a list cannot be changed by assignment. Second, lists represent a linked list whereas arrays are flat. The type of a list that has elements of type `T` is written as `List[T]`.
    *
    * `eq` tests identity (same object)
    */
  def similarToArraysLists(res0: Boolean) {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a eq b) should be(false)
  }

  /** `==` tests equality (same content)
    */
  def sameContentLists(res0: Boolean) {
    val a = List(1, 2, 3)
    val b = List(1, 2, 3)
    (a == b) should be(true)
  }

  /** Nil lists are identical, even of different types
    */
  def nilListsLists(res0: Boolean, res1: Boolean, res2: Boolean, res3: Boolean, res4: Boolean, res5: Boolean) {
    val a: List[String] = Nil
    val b: List[Int] = Nil

    (a == Nil) should be(true)
    (a eq Nil) should be(true)

    (b == Nil) should be(true)
    (b eq Nil) should be(true)

    (a == b) should be(true)
    (a eq b) should be(true)
  }

  /** Lists are easily created
    */
  def easilyCreatedLists(res0: Int, res1: Int, res2: Int) {
    val a = List(1, 2, 3)
    a should equal(List(3))
  }

  /** Lists can be accessed via head, headOption and tail.
    * Accessing List via `head` is unsafe and may result in a IndexOutOfBoundsException
    */
  def headAndTailLists(res0: Int, res1: Int, res2: Int) {
    val a = List(1, 2, 3)
    a.headOption should equal(Option(1))
    a.tail should equal(List(2, 3))
  }

  /** Lists can be accessed by position
    */
  def byPositionLists(res0: Int, res1: Int, res2: Int) {
    val a = List(1, 3, 5, 7, 9)
    a(0) should equal(1)
    a(2) should equal(5)
    a(4) should equal(9)

    intercept[IndexOutOfBoundsException] {
      println(a(5))
    }
  }

  /** Lists are immutable
    */
  def areImmutableLists(res0: Int, res1: Int, res2: Int, res3: Int) {
    val a = List(1, 3, 5, 7, 9)
    val b = a.filterNot(v ⇒ v == 5) // remove where value is 5

    a should equal(List(1, 3, 5, 7, 9))
    b should equal(List(1, 3, 7, 9))
  }

  /** Lists have many useful methods
    */
  def usefulMethodsLists(res0: Int, res1: List[Int], res2: List[Int], res3: List[Int]) {
    val a = List(1, 3, 5, 7, 9)

    // get the length of the list
    a.length should equal(5)

    // reverse the list
    a.reverse should equal(List(9,7,5,3,1))

    // map a function to double the numbers over the list
    a.map { v ⇒ v * 2 } should equal(List(2,6,10,14,18))

    // filter any values divisible by 3 in the list
    a.filter { v ⇒ v % 3 == 0 } should equal(List(3,9))
  }

  /** Functions over lists can use _ as shorthand
    */
  def wildcardAsShorthandLists(res0: Int, res1: Int, res2: Int, res3: Int) {
    val a = List(1, 2, 3)

    a.map {
      _ * 2
    } should equal(List(2, 4, 6))

    a.filter {
      _ % 2 == 0
    } should equal(List(2))
  }

  /** Functions over lists can use `()` instead of `{}`
    */
  def functionsOverListsLists(res0: Int, res1: Int, res2: Int, res3: Int, res4: Int) {
    val a = List(1, 2, 3)
    a.map(_ * 2) should equal(List(2, 4, 6))
    a.filter(_ % 2 != 0) should equal(List(1, 3))
  }

  /** Lists can be *reduced* with a mathematical operation
    */
  def reducingListsLists(res0: Int, res1: Int) {
    val a = List(1, 3, 5, 7)
    a.reduceLeft(_ + _) should equal(16)
    a.reduceLeft(_ * _) should equal(105)
  }

  /** Foldleft is like reduce, but with an explicit starting value
    */
  def foldLeftLists(res0: Int, res1: Int, res2: Int, res3: Int) {
    val a = List(1, 3, 5, 7)
    // NOTE: foldLeft uses a form called currying that we will explore later
    a.foldLeft(0)(_ + _) should equal(16)
    a.foldLeft(10)(_ + _) should equal(26)
    a.foldLeft(1)(_ * _) should equal(105)
    a.foldLeft(0)(_ * _) should equal(0)
  }

  /** You can create a list from a range
    */
  def fromRangeLists(res0: List[Int]) {
    val a = (1 to 5).toList
    a should be(List(1,2,3,4,5))
  }

  /** Lists reuse their tails
    */
  def reuseTailsLists(res0: Int, res1: Int, res2: Int, res3: List[Int], res4: List[Int], res5: List[Int]) {
    val d = Nil
    val c = 3 :: d
    val b = 2 :: c
    val a = 1 :: b

    a should be(List(1, 2, 3))
    a.tail should be(List(2, 3))
    b.tail should be(List(3))
    c.tail should be(Nil)
  }

}
