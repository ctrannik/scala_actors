package org.scala.actors.sample

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Receiver extends App {

	val config = ConfigFactory.load("receiver.conf")
	val system = ActorSystem("senders", config)

	val senderActor = system.actorOf( Props[ReceiverActor], "receiver")
	println(senderActor)

}

class ReceiverActor extends Actor{
	val path = "akka.tcp://sender@localhost:8080"
	override def receive: Receive = {
		case message: String =>
			println( s"receiver receive: $message" )
			context.actorSelection(path) ! "done"
	}
}