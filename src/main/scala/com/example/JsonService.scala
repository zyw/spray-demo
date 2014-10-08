package com.example

import akka.actor.Actor.Receive
import akka.actor.{ActorRefFactory, Actor}
import org.json4s.{DefaultFormats, Formats}
import spray.httpx.Json4sSupport
import spray.routing.HttpService

/**
 * Created by ZYW on 2014/9/30.
 */

class JsonServiceActor extends Actor with JsonService{
  override def receive = runRoute(jsonRout)

  override implicit def json4sFormats = DefaultFormats

  override implicit def actorRefFactory = context
}

trait JsonService extends HttpService with Json4sSupport{
  val jsonRout =
    path("json"){
      get{
        complete(Map("a"->"1","b"->"2","c"->"3"))
      }
    }
}
