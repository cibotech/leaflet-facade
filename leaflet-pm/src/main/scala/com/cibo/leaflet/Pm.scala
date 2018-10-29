package com.cibo
import scala.scalajs.js
import js.annotation._
import js.|

package leaflet {

  @js.native
  trait Map extends js.Object {
    var pm: PM.Map = js.native
  }

  @js.native
  trait Polygon extends js.Object {
    var pm: PM.Edit.Line = js.native
  }

  @js.native
  trait Polyline extends js.Object {
    var pm: PM.Edit.Line = js.native
  }

  @js.native
  trait Marker extends js.Object {
    var pm: PM.Edit.Marker = js.native
  }

  @js.native
  trait LayerGroup extends js.Object {
    var pm: PM.Edit.LayerGroup = js.native
  }

  package PM {

    @js.native
    trait Map extends js.Object {
      def addControls(options: ToolbarOptions = ???): Unit = js.native
      def enableDraw(shape: String, options: DrawOptions = ???): Unit = js.native
      def disableDraw(shape: String): Unit = js.native
      def setPathOptions(options: PathOptions): Unit = js.native
      def toggleRemoval(enabled: Boolean): Unit = js.native
      def globalEditEnabled(): Boolean = js.native
      def toggleGlobalEditMode(options: EditOptions = ???): Unit = js.native
      var Draw: Draw = js.native
    }

    @js.native
    trait Draw extends js.Object {
      def getShapes(): js.Array[String] = js.native
    }

    @js.native
    trait ToolbarOptions extends js.Object {
      var position: String = js.native
      var drawMarker: Boolean = js.native
      var drawPolygon: Boolean = js.native
      var drawPolyline: Boolean = js.native
      var editPolygon: Boolean = js.native
      var deleteLayer: Boolean = js.native
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
  }}