package stdlib

import org.scalatest._

/** @param name formatting
  *
  */
object Formatting extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** String can be placed in format:
    */
  def placedInFormatFormatting(res0: String) {
    val s = "Hello World"
    "Application %s".format(s) should be("Application Hello World")
  }

  /** Character Literals can be a single character:
    */
  def characterFormatting(res0: String, res1: String) {
    val a = 'a'
    val b = 'B'

    //format(a) is a string format, meaning the "%c".format(x)
    //will return the string representation of the char.

    "%c".format(a) should be("a")
    "%c".format(b) should be("B")
  }

  /** Character Literals can be an escape sequence, including octal or hexidecimal:
    */
  def escapeSequenceFormatting(res0: String, res1: String, res2: String, res3: String) {
    val c = '\u0061' //unicode for a
    val d = '\141' //octal for a
    val e = '\"'
    val f = '\\'

    "%c".format(c) should be("a")
    "%c".format(d) should be("a")
    "%c".format(e) should be("\"")
    "%c".format(f) should be("\\")
  }

  /** Formatting can also include numbers:
    */
  def includingNumbersFormatting(res0: String) {
    val j = 190
    "%d bottles of beer on the wall" format j - 100 should be("90 bottles of beer on the wall")
  }

  /** Formatting can be used for any number of items, like a string and a number:
    */
  def anyNumberOfItemsFormatting(res0: String) {
    val j = 190
    val k = "vodka"

    "%d bottles of %s on the wall".format(j - 100, k) should be("90 bottles of vodka on the wall")
  }

}
