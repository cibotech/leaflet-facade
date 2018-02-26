package com.cibo.leaflet

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSGlobal

@JSGlobal("L.Control.Draw")
@js.native
class ControlDraw(val drawLayerOptions: UndefOr[DrawOptions]) extends Control
object ControlDraw {

  def apply(drawOptions: UndefOr[DrawOptions] = js.undefined): ControlDraw =
    new ControlDraw(drawOptions)
}

@JSGlobal
@js.native
class DrawOptions extends js.Object
object DrawOptions extends DrawOptionsBuilder(noOpts)

class DrawOptionsBuilder(val dict: OptMap)
    extends JSOptionBuilder[DrawOptions, DrawOptionsBuilder](
      new DrawOptionsBuilder(_)) {

  def edit(v: EditOptions): DrawOptionsBuilder = jsOpt("edit", v)
}

@JSGlobal
@js.native
class EditOptions extends js.Object
object EditOptions extends EditOptionsBuilder(noOpts)

class EditOptionsBuilder(val dict: OptMap)
    extends JSOptionBuilder[EditOptions, EditOptionsBuilder](
      new EditOptionsBuilder(_)) {

  def featureGroup(v: FeatureGroup): EditOptionsBuilder =
    jsOpt("featureGroup", v)
}

@JSGlobal
@js.native
class DrawEvent extends Evented {
  val layer: Layer = js.native
}
