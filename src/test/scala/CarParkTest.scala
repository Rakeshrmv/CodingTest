import CarPark.getSmallestReg
import org.scalatest.FunSuite

class CarParkTest extends FunSuite {

  test("Should return the smallest registration number of parked cars") {
    val actions = List(("PARK", 1001), ("PARK", 1002), "DEPART", "DEPART", ("PARK", 1003), ("PARK", 1004), "SMALLEST")
    val smallestReg = getSmallestReg(actions, 5)
    assert(smallestReg === 1003)
  }

  test("Allow only to park the cars until its capacity") {
    val actions = List(("PARK", 1004), ("PARK", 1002),("PARK", 1005), ("PARK", 1006),("PARK", 1003), ("PARK", 1001), "SMALLEST")
    val smallestReg = getSmallestReg(actions, 5)
    assert(smallestReg === 1002)
  }

  test("Allow new cars to park if the parked cars leave(Though car park reached to full capacity but it should allow new cars to park as soon as " +
    "soon as parked cars leave") {
    val actions = List(("PARK", 2004), ("PARK", 2002),("PARK", 2005), ("PARK", 2006),("PARK", 2003), ("PARK", 2001),
      "DEPART", "DEPART","DEPART", "DEPART","DEPART",("PARK", 1001),"SMALLEST")
    val smallestReg = getSmallestReg(actions, 5)
    assert(smallestReg === 1001)
  }

  test("Should return the registration number even with car parked"){
    val actions = List(("PARK", 1000), "SMALLEST")
    val smallestReg = getSmallestReg(actions, 5)
    assert(smallestReg === 1000)
  }

}
