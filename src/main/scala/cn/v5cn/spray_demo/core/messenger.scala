package cn.v5cn.spray_demo.core

import java.util.UUID

import akka.actor.{Props, Actor}
import cn.v5cn.spray_demo.core.SMSActor.SendSMS

/**
 * Created by ZYW on 2014/9/30.
 */

object MessengerActor{
  case class SendMessage(to:UUID,message:String)
}

class MessengerActor extends Actor {
  import MessengerActor._
  import EmailActor._

  val email = context.actorOf(Props[EmailActor])
  val sms = context.actorOf(Props[SMSActor])

  implicit def receive ={
    case SendMessage(to,message) if to.getLeastSignificantBits % 2 == 0 =>
      email ! SendEmail("foo@bar.com",message)
    case SendMessage(to,message) if to.getLeastSignificantBits % 2 != 0 =>
      sms ! SendSMS("+447771234567",message)
  }
}
