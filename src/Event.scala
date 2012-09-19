/**
 * Created with IntelliJ IDEA.
 * User: Josh
 * Date: 9/18/12
 * Time: 7:06 PM
 * To change this template use File | Settings | File Templates.
 */

case class Event(time: (Long, Long), value: (Int, Int), channel: Int)

object Event {
  def isActive(event: Event, time: Long): Boolean = {
    event.time._1 <= time && event.time._2 >= time
  }

  def getValue(event: Event, time: Long): Int = {
    val length = event.time._2 - event.time._1
    val percentage = (time - event.time._1).toDouble / length
    ((event.value._2 - event.value._1) * percentage + event.value._1).toInt
  }
}
