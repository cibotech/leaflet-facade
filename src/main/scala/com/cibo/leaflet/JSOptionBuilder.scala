package com.cibo.leaflet

import scala.scalajs.js
import js.JSConverters._

abstract class JSOptionBuilder[T <: js.Object, B <: JSOptionBuilder[T, _]](copy: OptMap => B) {
  def dict: OptMap

  def jsOpt(name:String, opt:Any):B = copy(dict + (name -> opt))

  def build = dict.toJSDictionary.asInstanceOf[T]

  override def toString = s"""{\n${dict.keys.map{ key => s"  $key = ${dict(key).toString}"}.mkString("\n")}\n}"""
}
