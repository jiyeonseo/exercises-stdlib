package puruni

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by jiyeon on 2016. 8. 10..
  */
class ListSpec extends FunSuite with Matchers {
  test("list") {
    val list = List(1,2,3,4)

    val nil = Nil
    val nil2 = List()

    // cons
//    val list2 = List(list::Nil)
    val list3 = 1 :: 2 :: 3 :: 4 :: Nil // Nil부터 시작하니 꼭 있어야해
    val list4 = Nil.::(4).::(3).::(2).::(1) // list3 == list4
//    list shouldBe list2
    list shouldBe list3


    // val list5 = list.::(5)
    // list.add(5)
    val list5 =  list ::: 5 :: Nil


    println(list5 :: list)
    println(list5 ::: list)
    println(list ::: list5)

    // ** pattern matching - fp
    val list6 = List(1,2,3)
    list6 match {
      case a :: b :: c :: d :: Nil => println(a,b,c,d)
      case xs => println(s"그냥 받기($xs)")
      case a :: xs => println(s"한개 이상 있나 $a, ($xs)")
      case a :: b :: c :: Nil => println(a,b,c)
      case a :: b :: Nil => println(a,b)
      case a :: Nil => println("하나 잇나? $a")
      case Nil => println("암것도 없음")
    }





  }

}
