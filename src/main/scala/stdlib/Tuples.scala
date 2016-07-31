package stdlib

import java.util.Date

import org.scalatest._

/** @param name tuples
  *
  */
object Tuples extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** Scala tuple combines a fixed number of items together so that they can be passed around as a whole. They are one indexed. Unlike an array or list, a tuple can hold objects with different types but they are also immutable. Here is an example of a tuple holding an integer, a string, and the console:
    *
    * {{{
    * val t = (1, "hello", Console)
    * }}}
    *
    * Which is syntactic sugar (short cut) for the following:
    *
    * {{{
    * val t = new Tuple3(1, "hello", Console)
    * }}}
    * As you can see, tuples can be created easily:
    */
  def oneIndexedTuples(res0: String, res1: String) {
    val tuple = ("apple", "dog")
    val fruit = tuple._1
    val animal = tuple._2

    fruit should be("apple")
    animal should be("dog")
  }

  /** Tuples may be of mixed type:
    */
  def mixedTypeTuples(res0: Int, res1: String) {
    val tuple5 = ("a", 1, 2.2, new Date(), "five")

    tuple5._2 should be(1)
    tuple5._5 should be("five")
  }

  /** You can assign multiple variables at once using tuples:
    */
  def assignVariablesTuples(res0: String, res1: Int, res2: Double) {
    val student = ("Sean Rogers", 21, 3.5)
    val (name, age, gpa) = student

    name should be("Sean Rogers")
    age should be(21)
    gpa should be(3.5)
  }

  /** Tuples items can be swapped on a Tuple 2
    */
  def swappedTuples(res0: Int, res1: String) {
    val tuple = ("apple", 3).swap
    tuple._1 should be(3)
    tuple._2 should be("apple")
  }

}
