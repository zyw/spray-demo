package com.example

import spray.json.DefaultJsonProtocol

/**
 * Created by ZYW on 2014/9/29.
 */
 case class User(name:String,pwd:String,email:String)

object MyJsonProtocol extends DefaultJsonProtocol{
  implicit val userFormat = jsonFormat3(User)
}
