package org.scala.actors.sample

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object Sender extends App {

	val config = ConfigFactory.load("sender.conf")
	val system = ActorSystem("senders", config)

	val senderActor = system.actorOf( Props[SenderActor], "sender")
	println(senderActor)

	senderActor ! "start"

}

class SenderActor extends Actor{
	val path = "akka.tcp://receiver@localhost:8080"
	override def receive: Receive = {
		case message: String =>
			println( s"sender receive: $message" )
			context.actorSelection(path) ! "done"
	}
}
