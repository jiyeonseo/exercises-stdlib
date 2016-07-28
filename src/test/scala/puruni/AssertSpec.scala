package puruni

import org.scalatest.{Matchers, FunSuite}

/**
 * Created by jiyeon on 16. 7. 27..
 */
class AssertSpec extends FunSuite with Matchers{

  test("hello world") {
      println("world")
  }

  test("assert") {
    val left = 2
    val right = 1
    assert(left != right)
  }


}
