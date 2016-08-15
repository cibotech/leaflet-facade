package com.cibo.leaflet

import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.JSName

@JSName("L")
object Leaflet extends js.Object {
  def map(id: String, options: UndefOr[LMapOptions] = js.undefined): Map            = js.native
  def tileLayer(urlTemplate: String, options: UndefOr[TileLayerOptions]): TileLayer = js.native
  def gridLayer(gridLayerOpts: UndefOr[GridLayerOptions] = js.undefined): GridLayer = js.native
}

class GridLayerOptions extends js.Object
object GridLayerOptions extends GridLayerOptionsBuilder(noOpts)

class GridLayerOptionsBuilder(val dict: OptMap) extends JSOptionBuilder[GridLayerOptions, GridLayerOptionsBuilder](new GridLayerOptionsBuilder(_)) {
  def tileSize(v: Number) = jsOpt("tileSize", v)
}

@JSName("L.Layer")
class Layer extends js.Object {
  def addTo(map: Map)     : Layer                      = js.native
  def remove()            : Layer                      = js.native
  def removeFrom(map: Map): Layer                      = js.native
  def getPane(name: UndefOr[String] = ""): HTMLElement = js.native
}

@JSName("L.TileLayer")
class TileLayer extends Layer {
  def this(urlTemplate: String, tileLayerOptions: UndefOr[TileLayerOptions]) = this()
}

case class TileLayerOptions(maxZoom: Double)

@JSName("L.Map")
class Map extends js.Object {
  def setView(center: LatLng, zoom: Double, options: UndefOr[LZoomPanOptions] = js.undefined): Map = js.native
}

@JSName("L.GridLayer")
class GridLayer extends Layer {
  def this(gridLayerOpts: UndefOr[GridLayerOptions]) = this()
  def createTile(coords: js.Any): HTMLElement = js.native
  def bringToFront()             : GridLayer = js.native
  def bringToBack()              : GridLayer = js.native
  def getAttribution()           : GridLayer = js.native
  def getContainer()             : GridLayer = js.native
  def setOpacity(opacity: Number): GridLayer = js.native
  def setZIndex(zIndex: Number)  : GridLayer = js.native
  def isLoading()                : GridLayer = js.native
  def redraw()                   : GridLayer = js.native
  def getTileSize()              : GridLayer = js.native
}

trait IProjection extends js.Object {
  def project(latLng: LatLng): Point  = js.native
  def unproject(point: Point): LatLng = js.native
  val bounds: LatLngBounds            = js.native
}

@JSName("L.Projection")
object Projection extends IProjection {
  val LonLat           : IProjection = js.native
  val Mercator         : IProjection = js.native
  val SphericalMercator: IProjection = js.native
}

@JSName("L.LatLngBounds")
class LatLngBounds(southWest: LatLng, northEast: LatLng) extends js.Object

object LatLngBounds {
  def apply(southWest: LatLng, northEast: LatLng): LatLngBounds = new LatLngBounds(southWest, northEast)
  def apply(latlngs: js.Array[LatLng]           ): LatLngBounds = new LatLngBounds(latlngs(0), latlngs(1))
}

@JSName("L.LatLng")
class LatLng(latitude: Double, longitude: Double, altitude: UndefOr[Double] = js.undefined) extends js.Object {
  def this(lat: Double, lng: Double) = this(lat, lng, js.undefined)

  def distanceTo(other: LatLng): Double            = js.native
  def equals(other: LatLng): Boolean               = js.native
  def wrap(left: Double, right: Double): LatLng    = js.native
  def toBounds(sizeInMeters: Double): LatLngBounds = js.native
}

object LatLng {
  def apply(latitude: Double, longitude: Double) = new LatLng(latitude, longitude)
  def apply(latLng: js.Array[Double])            = new LatLng(latLng(0), latLng(1))
}

case class Point(x: Double, y: Double)
case class LZoomPanOptions(paddingTopLeft: Point, paddingBottomRight: Point, padding: Point, maxZoom: Double)

