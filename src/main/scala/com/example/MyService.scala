package com.example

import akka.actor.Actor
import org.json4s.DefaultFormats
import spray.httpx.encoding.Gzip
import spray.httpx.marshalling._
import spray.routing._
import spray.http._
import MediaTypes._
import MyJsonProtocol._
import spray.httpx.SprayJsonSupport._


// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class MyServiceActor extends Actor with MyService{

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)

//  override implicit def json4sFormats = DefaultFormats
}


// this trait defines our service behavior independently from the service actor
trait MyService extends HttpService/* with Json4sSupport*/{

  val myRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) { // XML is marshalled to `text/xml` by default, so we simply override here
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }~path("sjson"){
      get{
        complete(marshal(User("zhangsan","000000","zhangsan@163.com")))
      }
    }~path("twirl"){
      get{
        respondWithMediaType(`text/html`){
          encodeResponse(Gzip){
            complete(html.index("大家好").toString())
          }
        }
      }
    }
}