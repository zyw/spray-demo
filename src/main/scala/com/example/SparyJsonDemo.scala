package com.example

import spray.json._
import DefaultJsonProtocol._

/**
 * Created by ZYW on 2014/9/29.
 */
object SparyJsonDemo extends App{
  //转换JSON
  val jsonLis = List(1,2,3).toJson
  println(jsonLis)
  val jsonMap = Map("a"->"","b"->"1","c"->"2","d"->"3").toJson
  println(jsonMap)

  //解析JSON
  val m = jsonMap.convertTo[Map[String,String]]
  println(m)
}
