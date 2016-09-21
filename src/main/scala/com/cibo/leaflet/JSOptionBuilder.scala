/* Copyright (c) 2016 CiBO Technologies - All Rights Reserved
 * You may use, distribute, and modify this code under the
 * terms of the BSD 3-Clause license.
 *
 * A copy of the license can be found on the root of this repository,
 * at https://github.com/cibotech/leaflet-facade/LICENSE.md,
 * or at https://opensource.org/licenses/BSD-3-Clause
 */

package com.cibo.leaflet

import scala.scalajs.js
import js.JSConverters._

abstract class JSOptionBuilder[T <: js.Object, B <: JSOptionBuilder[T, _]](copy: OptMap => B) {
  def dict: OptMap

  def jsOpt(name:String, opt:Any):B = copy(dict + (name -> opt))

  def build = dict.toJSDictionary.asInstanceOf[T]

  override def toString = s"""{\n${dict.keys.map{ key => s"  $key = ${dict(key).toString}"}.mkString("\n")}\n}"""
}
