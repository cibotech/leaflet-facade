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

@js.native
trait LMapOptions extends js.Object

object LMapOptions extends LMapOptionsBuilder(noOpts)

class LMapOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[LMapOptions, LMapOptionsBuilder](new LMapOptionsBuilder(_)) {

  def preferCanvas(v: Boolean): LMapOptionsBuilder = jsOpt("preferCanvas", v)

  def attributionControl(v: Boolean): LMapOptionsBuilder = jsOpt("attributionControl", v)

  def zoomControl(v: Boolean): LMapOptionsBuilder = jsOpt("zoomControl", v)

  def closePopupOnClick(v: Boolean): LMapOptionsBuilder = jsOpt("closePopupOnClick", v)

  def zoomSnap(v: Int): LMapOptionsBuilder = jsOpt("zoomSnap", v)

  def zoomDelta(v: Int): LMapOptionsBuilder = jsOpt("zoomDelta", v)

  def trackResize(v: Boolean): LMapOptionsBuilder = jsOpt("trackResize", v)

  def boxZoom(v: Boolean): LMapOptionsBuilder = jsOpt("boxZoom", v)

  def doubleClickZoom(v: Boolean | String): LMapOptionsBuilder = jsOpt("doubleClickZoom", v)

  def dragging(v: Boolean): LMapOptionsBuilder = jsOpt("dragging", v)

  def zoom(v: Number): LMapOptionsBuilder = jsOpt("zoom", v)

  def minZoom(v: Number): LMapOptionsBuilder = jsOpt("minZoom", v)

  def maxZoom(v: Number): LMapOptionsBuilder = jsOpt("maxZoom", v)

  def fadeAnimation(v: Boolean): LMapOptionsBuilder = jsOpt("fadeAnimation", v)

  def markerZoomAnimation(v: Boolean): LMapOptionsBuilder = jsOpt("markerZoomAnimation", v)

  def transform3DLimit(v: Int): LMapOptionsBuilder = jsOpt("transform3DLimit", v)

  def zoomAnimation(v: Boolean): LMapOptionsBuilder = jsOpt("zoomAnimation", v)

  def zoomAnimationThreshold(v: Int): LMapOptionsBuilder = jsOpt("zoomAnimationThreshold", v)

  def touchZoom(v: Boolean): LMapOptionsBuilder = jsOpt("touchZoom", v)

  def tap(v: Boolean): LMapOptionsBuilder = jsOpt("tap", v)

  def scrollWheelZoom(v: Boolean): LMapOptionsBuilder = jsOpt("scrollWheelZoom", v)
}
