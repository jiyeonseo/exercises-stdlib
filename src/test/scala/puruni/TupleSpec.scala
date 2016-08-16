package puruni

import org.scalatest.{FunSuite, Matchers}

class TupleSpec extends FunSuite with Matchers{
    test("test") {
      val t = ("cheese", 1, Some(1))
      println(t._1)
    }

}
