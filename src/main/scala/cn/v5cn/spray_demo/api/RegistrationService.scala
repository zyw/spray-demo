package cn.v5cn.spray_demo.api

import akka.actor.ActorRef
import org.json4s.DefaultJsonFormats
import spray.routing.Directives
import scala.concurrent.ExecutionContext

/**
 * Created by ZYW on 2014/9/30.
 */
class RegistrationService(registration:ActorRef)(implicit executionContext:ExecutionContext)
  extends Directives with DefaultJsonFormats{

}
