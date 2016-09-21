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
import scala.scalajs.js.|

trait LMapOptions extends js.Object

object LMapOptions extends LMapOptionsBuilder(noOpts)

class LMapOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[LMapOptions, LMapOptionsBuilder](new LMapOptionsBuilder(_)) {
  def preferCanvas(v: Boolean)             = jsOpt("preferCanvas",           v)
  def attributionControl(v: Boolean)       = jsOpt("attributionControl",     v)
  def zoomControl(v: Boolean)              = jsOpt("zoomControl",            v)
  def closePopupOnClick(v: Boolean)        = jsOpt("closePopupOnClick",      v)
  def zoomSnap(v: Int)                     = jsOpt("zoomSnap",               v)
  def zoomDelta(v: Int)                    = jsOpt("zoomDelta",              v)
  def trackResize(v: Boolean)              = jsOpt("trackResize",            v)
  def boxZoom(v: Boolean)                  = jsOpt("boxZoom",                v)
  def doubleClickZoom(v: Boolean | String) = jsOpt("doubleClickZoom",        v)
  def dragging(v: Boolean)                 = jsOpt("dragging",               v)
  def zoom(v: Number)                      = jsOpt("zoom",                   v)
  def minZoom(v: Number)                   = jsOpt("minZoom",                v)
  def maxZoom(v: Number)                   = jsOpt("maxZoom",                v)
  def fadeAnimation(v: Boolean)            = jsOpt("fadeAnimation",          v)
  def markerZoomAnimation(v: Boolean)      = jsOpt("markerZoomAnimation",    v)
  def transform3DLimit(v: Int)             = jsOpt("transform3DLimit",       v)
  def zoomAnimation(v: Boolean)            = jsOpt("zoomAnimation",          v)
  def zoomAnimationThreshold(v: Int)       = jsOpt("zoomAnimationThreshold", v)
}
