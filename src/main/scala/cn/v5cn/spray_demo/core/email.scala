package cn.v5cn.spray_demo.core

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
 * Created by ZYW on 2014/9/30.
 */
object EmailActor{
  case class SendEmail(to:String,message:String)
}
class EmailActor extends Actor{
  import EmailActor._
  override def receive: Receive = {
    case SendEmail(to,body)=>
  }
}
