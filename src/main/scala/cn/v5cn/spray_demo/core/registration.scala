package cn.v5cn.spray_demo.core

import akka.actor.Actor

/**
 * Created by ZYW on 2014/9/30.
 */

object RegistrationActor{
  case class Register(user:User)
  case object Registered
  case object NotRegistered
}

class RegistrationActor extends Actor{
  import RegistrationActor._
  def receive = {
    case Register(user) if user.email.isEmpty => sender ! Left(NotRegistered)
    case Register(user)                       => sender ! Right(Registered)
  }
}
