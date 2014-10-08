package com.example

import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import spray.routing.SimpleRoutingApp
import scala.concurrent.duration._

/**
 * Created by ZYW on 2014/9/30.
 */
object Boot2 extends App with SimpleRoutingApp {
  // we need an ActorSystem to host our application in
  implicit val system = ActorSystem("boot2-spray")

  // create and start our service actor
  lazy val service = system.actorOf(Props[MyServiceActor], "my2-service")

  lazy val jsonService = system.actorOf(Props[JsonServiceActor],"json2-service")

  implicit val timeout = Timeout(5.seconds)
  // start a new HTTP server on port 8080 with our service actor as the handler
    startServer("localhost",8080){
      pathPrefix("test"){ctx => service ! ctx}~
      pathPrefix("json"){ctx => jsonService ! ctx}
    }
}
