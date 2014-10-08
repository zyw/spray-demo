package cn.v5cn.spray_demo.core

import akka.actor.Actor

/**
 * Created by ZYW on 2014/9/30.
 */
object SMSActor{
  case class SendSMS(to:String,message:String);
}

class SMSActor extends Actor {
  import SMSActor._
  def receive = {
    case SendSMS(number,body) =>
  }
}
