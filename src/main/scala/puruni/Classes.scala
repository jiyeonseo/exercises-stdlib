package puruni

/**
 * Created by jiyeon on 16. 7. 29..
 */
class Classes(cheese:String) {

}

// 함수 모양이랑 비슷비슷 function 같다.
class Point(val x: Int,val y : Int) {
  override def toString: String = s"($x,$y)"

}

object Classes1 extends App { // app은 trait main 메소드가 됨
  val pt= new Point(1,2) // 이렇게 하면 그냥 pt.x 하면 접근이 안됨
  println(pt.x)
  println("sup world")
}

object Classes2 {
  def main(arg: Array[String]) : Unit = {
    println("sup world")
  }
}



