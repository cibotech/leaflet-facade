package com.cibo.leaflet.pm

import scala.scalajs.js
import js.annotation._
import com.cibo.leaflet._

object PM {

  // Monkey patching JQuery
  @js.native
  trait Mapify extends LeafletMap {
    def pm: Map = js.native
  }

  // Monkey patching JQuery with implicit conversion
  implicit def jq2semantic(jq: LeafletMap): Mapify = jq.asInstanceOf[Mapify]
}

@JSGlobal
@js.native
class Map extends js.Object {
  def addControls(options: ToolbarOptions = ???): Unit = js.native

  def enableDraw(shape: String, options: DrawOptions = ???): Unit = js.native

  def disableDraw(shape: String): Unit = js.native

  def setPathOptions(options: PathOptions): Unit = js.native

  def toggleRemoval(enabled: Boolean): Unit = js.native

  def globalEditEnabled(): Boolean = js.native

  def toggleGlobalEditMode(options: EditOptions = ???): Unit = js.native

  // var Draw: Draw = js.native
}

@JSGlobal
@js.native
class ToolbarOptions extends js.Object

object ToolbarOptions extends ToolBarOptionsBuilder(noOpts)

class ToolBarOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[ToolbarOptions, ToolBarOptionsBuilder](
    new ToolBarOptionsBuilder(_)) {

  def position(v: String): ToolBarOptionsBuilder = jsOpt("position", v)

  def drawMarker(v: Boolean): ToolBarOptionsBuilder = jsOpt("drawMarker", v)

  def drawPolygon(v: Boolean): ToolBarOptionsBuilder = jsOpt("drawPolygon", v)

  def drawPolyline(v: Boolean): ToolBarOptionsBuilder = jsOpt("drawPolyline", v)

  def editPolygon(v: Boolean): ToolBarOptionsBuilder = jsOpt("editPolygon", v)

  def deleteLayer(v: Boolean): ToolBarOptionsBuilder = jsOpt("deleteLayer", v)
}

@js.native
trait DrawOptions extends js.Object {
  var templineStyle: PathOptions = js.native
  var hintlineStyle: PathOptions = js.native
  var pathOptions: PathOptions = js.native
}

@js.native
trait EditOptions extends js.Object {
  var draggable: Boolean = js.native
  var snappable: Boolean = js.native
  var snapDistance: Double = js.native
}

package Edit {

  @js.native
  trait Line extends js.Object {
    def enable(options: EditOptions = ???): Unit = js.native

    def disable(poly: Layer = ???): Unit = js.native

    def toggleEdit(options: EditOptions = ???): Unit = js.native

    def enabled(): Boolean = js.native
  }

  @js.native
  trait Marker extends js.Object {
    def enable(options: EditOptions = ???): Unit = js.native

    def disable(): Unit = js.native

    def toggleEdit(options: EditOptions = ???): Unit = js.native

    def enabled(): Boolean = js.native
  }

  @js.native
  trait LayerGroup extends js.Object {
    def enable(options: EditOptions = ???): Unit = js.native

    def disable(): Unit = js.native

    def toggleEdit(options: EditOptions = ???): Unit = js.native

    def enabled(): Boolean = js.native

    def findLayers(): js.Array[Layer] = js.native

    def dragging(): Boolean = js.native

    def getOptions(): EditOptions = js.native
  }

}