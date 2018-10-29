package com.cibo.leaflet.pm

import scala.scalajs.js
import js.annotation._
import com.cibo.leaflet._

object PM {

  // Monkey patching
  @js.native
  trait Mapify extends LeafletMap {
    def pm: Map = js.native
  }

  // Monkey patching with implicit conversion
  implicit def leafmap2Mapify(jq: LeafletMap): Mapify = jq.asInstanceOf[Mapify]
}

@JSGlobal
@js.native
class Map extends js.Object {
  def addControls(options: js.UndefOr[ToolbarOptions]): Unit = js.native

  def enableDraw(shape: String, options: js.UndefOr[DrawOptions]): Unit = js.native

  def disableDraw(shape: String): Unit = js.native

  def setPathOptions(options: PathOptions): Unit = js.native

  def toggleRemoval(enabled: Boolean): Unit = js.native

  def globalEditEnabled(): Boolean = js.native

  def toggleGlobalEditMode(options: js.UndefOr[EditOptions]): Unit = js.native

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

@JSGlobal
@js.native
class DrawOptions extends js.Object

object DrawOptions extends DrawOptionsBuilder(noOpts)

class DrawOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[DrawOptions, DrawOptionsBuilder](
    new DrawOptionsBuilder(_)) {
  def templineStyle(v: PathOptions): DrawOptionsBuilder = jsOpt("templineStyle", v)

  def hintlineStyle(v: PathOptions): DrawOptionsBuilder = jsOpt("hintlineStyle", v)

  def pathOptions(v: PathOptions): DrawOptionsBuilder = jsOpt("pathOptions", v)
}

@JSGlobal
@js.native
class EditOptions extends js.Object

object EditOptions extends EditOptionsBuilder(noOpts)

class EditOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[EditOptions, EditOptionsBuilder](
    new EditOptionsBuilder(_)) {
  def draggable(v: PathOptions): EditOptionsBuilder = jsOpt("draggable", v)

  def snappable(v: PathOptions): EditOptionsBuilder = jsOpt("snappable", v)

  def snapDistance(v: PathOptions): EditOptionsBuilder = jsOpt("snapDistance", v)
}

package Edit {

  @JSGlobal
  @js.native
  class Line extends js.Object{
    def enabled: Boolean = js.native
  }

  object Line extends LineBuilder(noOpts)

  class LineBuilder(val dict: OptMap)
    extends JSOptionBuilder[Line, LineBuilder](
      new LineBuilder(_)) {
    def enable(v: js.UndefOr[EditOptions]): LineBuilder = jsOpt("enable", v)

    def disable(v: js.UndefOr[Layer]): LineBuilder = jsOpt("disable", v)

    def toggleEdit(v: js.UndefOr[EditOptions]): LineBuilder = jsOpt("toggleEdit", v)
  }

  @JSGlobal
  @js.native
  class Marker extends js.Object{
    def enabled: Boolean = js.native
  }

  object Marker extends MarkerBuilder(noOpts)

  class MarkerBuilder(val dict: OptMap)
    extends JSOptionBuilder[Marker, MarkerBuilder](
      new MarkerBuilder(_)) {

    def enable(v: js.UndefOr[EditOptions]): MarkerBuilder = jsOpt("enable", v)

    def disable(): MarkerBuilder = jsOpt("disable", js.undefined)

    def toggleEdit(v: js.UndefOr[EditOptions]): MarkerBuilder = jsOpt("toggleEdit", v)
  }

  @JSGlobal
  @js.native
  class LayerGroup extends js.Object {

    def findLayers(): js.Array[Layer] = js.native

    def dragging(): Boolean = js.native

    def getOptions(): EditOptions = js.native
  }

  object LayerGroup extends LayerGroupBuilder(noOpts)

  class LayerGroupBuilder(val dict: OptMap)
    extends JSOptionBuilder[LayerGroup, LayerGroupBuilder](
      new LayerGroupBuilder(_)) {

    def enable(v: js.UndefOr[EditOptions]): LayerGroupBuilder = jsOpt("enable", v)

    def disable(): LayerGroupBuilder = jsOpt("disable", js.undefined)

    def toggleEdit(v: js.UndefOr[EditOptions]): LayerGroupBuilder = jsOpt("toggleEdit", v)

    def enabled(v: Boolean): LayerGroupBuilder = jsOpt("enabled", v)
  }

}