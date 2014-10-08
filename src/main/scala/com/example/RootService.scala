package com.example

import akka.actor.{ActorRefFactory, Props, Actor}
import akka.actor.Actor.Receive
import spray.http.HttpRequest
import spray.http._
import HttpMethods._
import spray.routing.HttpService


/**
 * Created by ZYW on 2014/9/30.
 */
class RootService extends Actor with HttpService{
  override def receive = {
    //case pathPrefix("test"){ctx => context.actorOf(Props[MyServiceActor] ! ctx}
    case HttpRequest(GET,Uri.Path("/hello/test"),_,_,_)=>sender ! context.actorOf(Props[MyServiceActor])
  }

  override implicit def actorRefFactory = context
}
