package stdlib

import org.scalatest._

/** @param name sets
  *
  */
object Sets extends FlatSpec with Matchers with org.scalaexercises.definitions.Section {

  /** `Set`s are `Iterable`s that contain no duplicate elements. The operations on sets are summarized in the following table for general sets and in the table after that for mutable sets. They fall into the following categories:
    *
    * *   **Tests** `contains`, `apply`, `subsetOf`. The `contains` method asks whether a set contains a given element. The `apply` method for a set is the same as `contains`, so `set(elem)` is the same as `set contains elem`. That means sets can also be used as test functions that return true for the elements they contain.
    * *   **Additions** `+` and `++`, which add one or more elements to a set, yielding a new set.
    * *   **Removals** `-`, `--`, which remove one or more elements from a set, yielding a new set.
    * *   **Set operations** for union, intersection, and set difference. Each of these operations exists in two forms: alphabetic and symbolic. The alphabetic versions are `intersect`, `union`, and `diff`, whereas the symbolic versions are `&`, `|`, and `&~`. In fact, the `++` that Set inherits from `Traversable` can be seen as yet another alias of `union` or `|`, except that `++` takes a `Traversable` argument whereas `union` and `|` take sets.
    *
    * Sets can be created easily:
    */
  def noDuplicatesSets(res0: Int) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    mySet.size should be(4)
  }

  /** Sets contain distinct values:
    */
  def distinctValuesSets(res0: Int) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Michigan")
    mySet.size should be(3)
  }

  /** Sets can be added to easily:
    */
  def easilyAddedSets(res0: Boolean, res1: Boolean) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet + "Illinois"

    aNewSet.contains("Illinois") should be(true)
    mySet.contains("Illinois") should be(false)
  }

  /** Sets may be of mixed type:
    */
  def mixedTypeSets(res0: Boolean, res1: Boolean) {
    val mySet = Set("Michigan", "Ohio", 12)

    mySet.contains(12) should be(true)
    mySet.contains("MI") should be(false)
  }

  /** Sets can be checked for member existence:
    */
  def checkExistenceSets(res0: Boolean, res1: Boolean) {
    val mySet = Set("Michigan", "Ohio", 12)

    mySet(12) should be(true)
    mySet("MI") should be(false)
  }

  /** Set elements can be removed easily:
    */
  def easilyRemovedSets(res0: Boolean, res1: Boolean) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet - "Michigan"

    aNewSet.contains("Michigan") should be(false)
    mySet.contains("Michigan") should be(true)
  }

  /** Set elements can be removed in multiple:
    */
  def multipleRemovingSets(res0: Boolean, res1: Boolean, res2: Int) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet -- List("Michigan", "Ohio")

    aNewSet.contains("Michigan") should be(false)
    aNewSet.contains("Wisconsin") should be(true)
    aNewSet.size should be(2)
  }

  /** Set elements can be removed with a tuple:
    */
  def tupleRemovingSets(res0: Boolean, res1: Boolean, res2: Int) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet - ("Michigan", "Ohio") // Notice: single '-' operator for tuples

    aNewSet.contains("Michigan") should be(false)
    aNewSet.contains("Wisconsin") should be(true)
    aNewSet.size should be(2)
  }

  /** Attempted removal of nonexistent elements from a set is handled gracefully:
    */
  def nonexistentRemovalSets(res0: Boolean) {
    val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val aNewSet = mySet - "Minnesota"

    aNewSet.equals(mySet) should be(true)
  }

  /** Two sets can be intersected easily:
    */
  def easilyIntersectedSets(res0: Boolean) {
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
    val aNewSet = mySet1 intersect mySet2
    // NOTE: Scala 2.7 used **, deprecated for & or intersect in Scala 2.8

    aNewSet.equals(Set("Michigan", "Wisconsin")) should be(true)
  }

  /** Two sets can be joined as their union easily:
    */
  def easilyJoinedSets(res0: Boolean) {
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
    val aNewSet = mySet1 union mySet2 // NOTE: You can also use the "|" operator

    aNewSet.equals(Set("Michigan", "Wisconsin", "Ohio", "Iowa", "Minnesota")) should be(true)
  }

  /** A set is either a subset of another set or it isn't:
    */
  def subsetSets(res0: Boolean, res1: Boolean) {
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Minnesota")
    val mySet3 = Set("Wisconsin", "Michigan")

    mySet2 subsetOf mySet1 should be(false)
    mySet3 subsetOf mySet1 should be(true)
  }

  /** The difference between two sets can be obtained easily:
    */
  def easilyObtainedDifferencesSets(res0: Boolean) {
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan")
    val aNewSet = mySet1 diff mySet2 // Note: you can use the "&~" operator if you *really* want to.

    aNewSet.equals(Set("Ohio", "Iowa")) should be(true)
  }

  /** Set equivalency is independent of order:
    */
  def equivalencySets(res0: Boolean) {
    val mySet1 = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
    val mySet2 = Set("Wisconsin", "Michigan", "Ohio", "Iowa")

    mySet1.equals(mySet2) should be(true)
  }

}
