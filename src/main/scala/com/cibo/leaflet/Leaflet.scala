package com.cibo.leaflet

import scala.scalajs.js
import scala.scalajs.js.{UndefOr, |}
import scala.scalajs.js.annotation.{JSName}
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.Element

@JSName("L")
object Leaflet extends js.Object {
  def map(id: String, options: UndefOr[LMapOptions] = js.undefined): Map = js.native

  @JSName("map")
  def mapFromNode[A <: Element](domNode: A, options: UndefOr[LMapOptions] = js.undefined): Map = js.native

  def tileLayer(urlTemplate: String, options: UndefOr[TileLayerOptions] = js.undefined): TileLayer = js.native
  def gridLayer(gridLayerOpts: UndefOr[GridLayerOptions] = js.undefined): GridLayer = js.native
  def imageOverlay(imageUrl: String, latLngBounds: LatLngBounds, imageOverlayOpts: UndefOr[ImageOverlayOptions] = js.undefined): ImageOverlay = js.native
  def point(x: Double, y: Double, round: UndefOr[Boolean] = js.undefined): Point = js.native

  def polygon(latlngs: js.Array[LatLng]): Polygon = js.native

  @JSName("polygon")
  def multiPolygon(multiPolygon: js.Array[js.Array[js.Array[LatLng]]], opts: UndefOr[PolyLineOptions] = js.undefined): MultiPolygon = js.native

  def layerGroup[T <: Layer](layers: js.Array[T]): LayerGroup = js.native

  def on(name: String, fn: js.Function1[Evented, Evented]): this.type = js.native
}

@JSName("L.Evented")
class Evented extends js.Object {
  val `type`: String = js.native
  val target: js.Object = js.native
  def on(name: String, fn: js.Function1[Evented, Evented]): Evented = js.native
}

class GridLayerOptions extends js.Object

object GridLayerOptions extends GridLayerOptionsBuilder(noOpts)

class GridLayerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GridLayerOptions, GridLayerOptionsBuilder](new GridLayerOptionsBuilder(_)) {
  def tileSize(v: Number) = jsOpt("tileSize", v)
  def tileSize(v: Point) = jsOpt("tileSize", v)
  def bounds(v: LatLngBounds) = jsOpt("bounds", v)
  def minZoom(v: Number = 0) = jsOpt("minZoom", v)
  def maxZoom(v: Number) = jsOpt("maxZoom", v)
  def noWrap(v: Boolean = false) = jsOpt("noWrap", v)
}

@JSName("L.TileLayer")
class TileLayer extends Layer {
  def this(urlTemplate: String, tileLayerOptions: UndefOr[TileLayerOptions]) = this()
}

case class TileLayerOptions(maxZoom: Double)

@JSName("L.Layer")
class Layer extends js.Object {
  def addTo(map: Map): Layer = js.native
  def remove(): Layer = js.native
  def removeFrom(map: Map): Layer = js.native
  def getPane(name: UndefOr[String] = ""): HTMLElement = js.native
}

@JSName("L.ImageOverlay")
class ImageOverlay extends Layer {
  def setUrl(url: String): ImageOverlay = js.native
}

class ImageOverlayOptions extends js.Object

@JSName("L.Map")
class Map extends Evented {
  def setView(center: LatLng, zoom: Double, options: UndefOr[LZoomPanOptions] = js.undefined): Map = js.native
  def addControl(control: Control): Map = js.native
  def removeControl(control: Control): Map = js.native
  def addLayer(layer: Layer): Map = js.native
  def removeLayer(layer: Layer): Map = js.native
  def fitBounds(bounds: LatLngBounds): Map = js.native
  def getBounds(): LatLngBounds = js.native
  def getZoom(): Int = js.native
}

@JSName("L.GridLayer")
class GridLayer extends Layer {
  def this(gridLayerOpts: UndefOr[GridLayerOptions]) = this()
  def createTile(coords: js.Any): HTMLElement = js.native
  def bringToFront(): GridLayer = js.native
  def bringToBack(): GridLayer = js.native
  def getAttribution(): GridLayer = js.native
  def getContainer(): GridLayer = js.native
  def setOpacity(opacity: Number): GridLayer = js.native
  def setZIndex(zIndex: Number): GridLayer = js.native
  def isLoading(): GridLayer = js.native
  def redraw(): GridLayer = js.native
  def getTileSize(): GridLayer = js.native
}

trait IProjection extends js.Object {
  def project(latLng: LatLng): Point = js.native
  def unproject(point: Point): LatLng = js.native
  val bounds: LatLngBounds = js.native
}

@JSName("L.Projection")
object Projection extends IProjection {
  val LonLat: IProjection = js.native
  val Mercator: IProjection = js.native
  val SphericalMercator: IProjection = js.native
}

@JSName("L.LatLngBounds")
class LatLngBounds(southWest: LatLng, northEast: LatLng) extends js.Object {
  def getSouthWest(): LatLng = js.native
  def getNorthEast(): LatLng = js.native
  def getNorthWest(): LatLng = js.native
  def getWest(): Double = js.native
  def getSouth(): Double = js.native
  def getEast(): Double = js.native
  def getNorth(): Double = js.native
  def getCenter(): LatLng = js.native
  def equals(latLngBounds: LatLngBounds): Boolean = js.native
}

object LatLngBounds {
  def apply(northEast: LatLng, southWest: LatLng): LatLngBounds = new LatLngBounds(southWest, northEast)
  def apply(latlngs: js.Array[LatLng]): LatLngBounds = new LatLngBounds(latlngs(0), latlngs(1))
}

@JSName("L.LatLng")
class LatLng(val lat: Double, val lng: Double, val alt: UndefOr[Double] = js.undefined) extends js.Object {
  def this(lat: Double, lng: Double) = this(lat, lng, js.undefined)
  def distanceTo(other: LatLng): Double = js.native
  def equals(other: LatLng): Boolean = js.native
  def wrap(left: Double, right: Double): LatLng = js.native
  def toBounds(sizeInMeters: Double): LatLngBounds = js.native
}

object LatLng {
  def apply(latitude: Double, longitude: Double) = new LatLng(latitude, longitude)
  def apply(latLng: js.Array[Double]) = new LatLng(latLng(0), latLng(1))
}

@JSName("L.Point")
class Point(x: Double, y: Double, round: UndefOr[Boolean] = js.undefined) extends js.Object {
  def this(coords: js.Array[Double]) = this(coords(0), coords(1))
  def add(point: Point): Point = js.native
  def subtract(point: Point): Point = js.native
  def divideBy(num: Double): Point = js.native
  def multiplyBy(num: Double): Point = js.native
  def scaleBy(point: Point): Point = js.native
  def unscaleBy(point: Point): Point = js.native
  @JSName("round")
  def roundPoint(): Point = js.native
  def floor(): Point = js.native
  def ceil(): Point = js.native
  def distanceTo(): Double = js.native
  def contains(): Boolean = js.native
}


@JSName("L.Control")
class Control(position: UndefOr[String] = "topright") extends js.Object {
  def getPosition(): String = js.native
  def setPosition(position: String): Control = js.native
  def getContainer(): HTMLElement = js.native
  def addTo(map: Map): Control = js.native
  def remove(): Control = js.native

}

@JSName("L.Control.Scale")
class ControlScale(scaleOptions: UndefOr[ScaleOptions] = js.undefined) extends Control
object ControlScale {
  def apply(scaleOptions: UndefOr[ScaleOptions] = js.undefined) = new ControlScale(scaleOptions)
}

class ScaleOptions extends js.Object
object ScaleOptions extends ScaleOptionsBuilder(noOpts)

class ScaleOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ScaleOptions, ScaleOptionsBuilder](new ScaleOptionsBuilder(_)) {
  def maxWidth(v: Int) = jsOpt("maxWidth", v)
  def metric(v: Boolean) = jsOpt("metric", v)
  def imperial(v: Boolean) = jsOpt("imperial", v)
  def updateWhenIdle(v: Boolean) = jsOpt("updateWhenIdle", v)
}

@JSName("L.Control.Zoom")
class ControlZoom(zoomOptions: UndefOr[ZoomOptions] = js.undefined) extends Control
object ControlZoom {
  def apply(zoomOptions: UndefOr[ZoomOptions] = js.undefined) = new ControlZoom(zoomOptions)
}

class ZoomOptions extends js.Object
object ZoomOptions extends ScaleOptionsBuilder(noOpts)

class ZoomOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[ZoomOptions, ZoomOptionsBuilder](new ZoomOptionsBuilder(_)) {
  def zoomInText(v: String) = jsOpt("zoomInText", v)
  def zoomInTitle(v: String) = jsOpt("zoomInTitle", v)
  def zoomOutText(v: String) = jsOpt("zoomOutText", v)
  def zoomOutTitle(v: String) = jsOpt("zoomOutTitle", v)
}

@JSName("L.Path")
abstract class Path extends Layer {
  def setStyle(pathOptions: PathOptions): Path = js.native
}

@JSName("L.Polyline")
class Polyline extends PolyLineOptions {
  def getBounds(): LatLngBounds = js.native
}

class PolyLineOptions extends Path
object PolyLineOptions extends PolyLineOptionsBuilder(noOpts)

class PolyLineOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PolyLineOptions, PolyLineOptionsBuilder](new PolyLineOptionsBuilder(_)) {
  def color(v: String) = jsOpt("color", v)
}

class PathOptions extends js.Object
object PathOptions extends PathOptionsBuilder(noOpts)

class PathOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[PathOptions, PathOptionsBuilder](new PathOptionsBuilder(_)) {
  def color(v: String) = jsOpt("color", v)
}

@JSName("L.Polygon")
class Polygon extends Polyline


@JSName("L.Polygon")
class MultiPolygon extends Polyline

@JSName("L.LayerGroup")
class LayerGroup extends Layer {
  def addLayer(layer: Layer): LayerGroup = js.native
  def removeLayer(layer: Layer): LayerGroup = js.native
  def removeLayer(id: Int): LayerGroup = js.native
  def clearLayers(): LayerGroup = js.native
  def getLayers(): js.Array[Layer] = js.native
  def getLayer(id: Int): Layer = js.native
}

case class LZoomPanOptions(paddingTopLeft: Point, paddingBottomRight: Point, padding: Point, maxZoom: Double)
