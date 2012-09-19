import com.juanjo.openDmx.OpenDmx

/**
 * Created with IntelliJ IDEA.
 * User: Josh
 * Date: 9/18/12
 * Time: 7:05 PM
 * To change this template use File | Settings | File Templates.
 */

case class Routine(events: List[Event], channelOffset: Int = 0, timeGranularity: Int = 100)

object RoutinePlayer {

  def play(routine: Routine) = {

    new Thread(new Runnable {
      def run() {
        val maxTime = routine.events.map(e => e.time._2).max
        for (i <- 1 to (maxTime / routine.timeGranularity).toInt) {
          val time = i * routine.timeGranularity
          routine.events.filter(e =>
            Event.isActive(e, time)
          ).map(e => {
            OpenDmx.setValue(e.channel + routine.channelOffset, Event.getValue(e, time))
            //println("Setting channel: " + e.channel + routine.channelOffset + " to " + Event.getValue(e, time))
          })

          //println("Sleeping thread: " + Thread.currentThread().getName)
          Thread.sleep(routine.timeGranularity)

        }
      }
    }).start()


  }


}
