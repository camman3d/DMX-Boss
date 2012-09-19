import com.juanjo.openDmx.OpenDmx

/**
 * Created with IntelliJ IDEA.
 * User: Josh
 * Date: 9/18/12
 * Time: 8:31 AM
 * To change this template use File | Settings | File Templates.
 */
object Controller {
  def main(args: Array[String]) = {

    if (!OpenDmx.connect(OpenDmx.OPENDMX_TX)) {
      println("Uh oh... cannot connect")
    } else {
      val routine1 = Routine(
        List(
          Event((1000, 2000), (0, 255), 0),
          Event((3000, 4000), (255, 0), 0),
          Event((5000, 6000), (0, 255), 0),
          Event((7000, 8000), (255, 0), 0)
        )
      )
      RoutinePlayer.play(routine1)

      val routine2 = Routine(
        List(
          Event((1000, 2000), (0, 255), 0),
          Event((3000, 4000), (255, 0), 0),
          Event((5000, 6000), (0, 255), 0),
          Event((7000, 8000), (255, 0), 0)
        ),
        1
      )
      RoutinePlayer.play(routine2)
    }



//    OpenDmx.setValue(0, 255)

//    OpenDmx.disconnect()
  }
}
