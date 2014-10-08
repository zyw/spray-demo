package cn.v5cn.spray_demo.core

import akka.actor.ActorSystem

/**
 * Created by ZYW on 2014/9/30.
 */
trait Core {
  implicit def system:ActorSystem
}
