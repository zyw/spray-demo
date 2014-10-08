package cn.v5cn.spray_demo.api

import cn.v5cn.spray_demo.core.{Core, CoreActors}
import spray.routing.RouteConcatenation

/**
 * Created by ZYW on 2014/9/30.
 */
trait Api extends RouteConcatenation {
  this:CoreActors with Core =>

  private implicit val _ = system.dispatcher

  val routes = new RegistrationSer
}
