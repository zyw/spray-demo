package cn.v5cn.spray_demo.core

import akka.actor.Props

/**
 * Created by ZYW on 2014/9/30.
 */
trait CoreActors {
  this:Core =>


  val registration = system.actorOf(Props[RegistrationActor])
  val messager = system.actorOf(Props[MessengerActor])
}
