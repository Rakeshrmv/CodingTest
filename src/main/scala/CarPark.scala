import util.control.Breaks._

object CarPark {

 /**
    * Return the smallest registration number of the parked cars when a list of actions and
    * capacity of the Car Park is given
    */
  def getSmallestReg(actionList:List[Any],parkingCapacity:Int):Int =
  {
    //Declare parked cars array with the size of the
    val parkingSpaces = new Array[Int](parkingCapacity)
    var index:Int=0
    var smallestReg:Int=0

        //Loop through the list of actions and perform based on the instruction of the corresponding action
        for(action <- actionList){

            action match {
                  case ("PARK", regNo:Int)  => {
                              try {
                                 //add the registration numbers of the parked car to the array and increment the index
                                  parkingSpaces(index) = regNo
                                  index = index+1
                              } catch {
                                case a: java.lang.ArrayIndexOutOfBoundsException => {
                                  println("OOPS, as the car park is full currently, so Car:"+regNo+" cannot be parked.")
                                  }
                                case e: java.lang.Exception => {
                                  println("Exception")
                                  break
                                  }
                                }
                              }
                  case "DEPART" => {
                                //remove the last parked car from the parkingSpaces array
                                parkingSpaces(index - 1) = Int.MinValue
                                index = index - 1
                          }
                  case "SMALLEST" => {
                              //store first registration number from parkingSpaces array to smallestReg initially
                              smallestReg = parkingSpaces(0)

                              // get the smallest registration number from the parkingSpaces array
                              var i = 1
                              while ({ i < index }) {
                                if (parkingSpaces(i) < smallestReg)
                                {
                                  smallestReg = parkingSpaces(i)
                                }
                                i += 1
                              }
                  }
                  case _ => println(action + " is an Invalid Action")

          }

        }

    smallestReg
  }

}
