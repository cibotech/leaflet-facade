/* Copyright (c) 2016 CiBO Technologies - All Rights Reserved
 * You may use, distribute, and modify this code under the
 * terms of the BSD 3-Clause license.
 *
 * A copy of the license can be found on the root of this repository,
 * at https://github.com/cibotech/leaflet-facade/LICENSE.md,
 * or at https://opensource.org/licenses/BSD-3-Clause
 */

package com.cibo.leaflet

import com.cibo.leaflet.Leaflet.MultipolygonCoords
import org.scalajs.dom.Element
import org.scalajs.dom.raw.HTMLElement

import scala.scalajs.js
import scala.scalajs.js.UndefOr
import scala.scalajs.js.annotation.{JSGlobal, JSName}

@JSGlobal("L")
@js.native
object Leaflet extends js.Object {

  type PolygonCoords = js.Array[js.Array[LatLng]]

  type MultipolygonCoords = js.Array[PolygonCoords]

  @JSName("map")
  def mapFromNode[A <: Element](domNode: A, options: UndefOr[LMapOptions] = js.undefined): LeafletMap = js.native

  def map(id: String, options: UndefOr[LMapOptions] = js.undefined): LeafletMap = js.native

  def tileLayer(urlTemplate: String, options: UndefOr[TileLayerOptions] = js.undefined): TileLayer = js.native

  def gridLayer(gridLayerOpts: UndefOr[GridLayerOptions] = js.undefined): GridLayer = js.native

  def imageOverlay(
    imageUrl: String,
    latLngBounds: LatLngBounds,
    imageOverlayOpts: UndefOr[ImageOverlayOptions] = js.undefined
  ): ImageOverlay = js.native

  def point(x: Double, y: Double, round: UndefOr[Boolean] = js.undefined): Point = js.native

  def polygon(latlngs: PolygonCoords): Polygon = js.native

  def polyline(coords: js.Array[LatLng], opts: UndefOr[PolyLineOptions] = js.undefined): Polyline = js.native

  def popup(
    options: UndefOr[PopupOptions] = js.undefined,
    source: UndefOr[Layer] = js.undefined
  ): Popup = js.native

  @JSName("polygon")
  def multiPolygon(
    multiPolygon: MultipolygonCoords,
    opts: UndefOr[PolyLineOptions] = js.undefined
  ): MultiPolygon = js.native

  def layerGroup[T <: Layer](layers: js.Array[T]): LayerGroup = js.native

  def featureGroup[T <: Layer](layers: js.Array[T]): FeatureGroup = js.native

  def on(name: String, fn: js.Function1[Evented, Evented]): this.type = js.native

  def circle(latLng: LatLng, radius: Double, pathOptions: PathOptions): Circle = js.native

  def marker(latlngs: LatLng, options: UndefOr[MarkerOptions] = js.undefined): Marker = js.native

  def icon(options: UndefOr[IconOptions] = js.undefined): Icon = js.native

  def geoJSON(data: js.Object): GeoJSON = js.native
}

@JSGlobal("L.Icon")
@js.native
class Icon extends js.Object {

}

@JSGlobal("L.Evented")
@js.native
class Evented extends js.Object {
  val `type`: String = js.native
  val target: js.Object = js.native

  def on(name: String, fn: js.Function1[Evented, Evented]): Evented = js.native
}

@JSGlobal("L.GeoJSON")
@js.native
class GeoJSON(data: js.Object, options: js.UndefOr[PathOptions] = js.undefined) extends FeatureGroup

@JSGlobal
@js.native
class GridLayerOptions extends js.Object

object GridLayerOptions extends GridLayerOptionsBuilder(noOpts)

class GridLayerOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[GridLayerOptions, GridLayerOptionsBuilder](new GridLayerOptionsBuilder(_)) {

  def tileSize(v: Number): GridLayerOptionsBuilder = jsOpt("tileSize", v)

  def tileSize(v: Point): GridLayerOptionsBuilder = jsOpt("tileSize", v)

  def bounds(v: LatLngBounds): GridLayerOptionsBuilder = jsOpt("bounds", v)

  def minZoom(v: Number = 0): GridLayerOptionsBuilder = jsOpt("minZoom", v)

  def maxZoom(v: Number): GridLayerOptionsBuilder = jsOpt("maxZoom", v)

  def noWrap(v: Boolean = false): GridLayerOptionsBuilder = jsOpt("noWrap", v)
}

@JSGlobal("L.Marker")
@js.native
class Marker extends Layer {

  def setLatLng(latLng: LatLng): Unit = js.native

  def on(name: String, fn: js.Function1[Evented, Evented]): this.type = js.native

}

@JSGlobal("L.MouseEvent")
@js.native
class MouseEvent extends js.Object {
  val latlng: LatLng = js.native
  val layerPoint: Point = js.native
  val containerPoint: Point = js.native
}

@JSGlobal("L.Circle")
@js.native
class Circle extends Path {
  def on(name: String, fn: js.Function1[MouseEvent, Unit]): Circle = js.native
}

@JSGlobal("L.FeatureGroup")
@js.native
abstract class FeatureGroup extends LayerGroup {
  def setStyle(pathOptions: PathOptions): FeatureGroup = js.native

  def bringToFront(): FeatureGroup = js.native

  def bringToBack(): FeatureGroup = js.native

  def getBounds(): LatLngBounds = js.native
}

@JSGlobal("L.TileLayer")
@js.native
class TileLayer(val urlTemplate: String, val tileLayerOptions: UndefOr[TileLayerOptions]) extends GridLayer

case class TileLayerOptions(maxZoom: Double)

@JSGlobal("L.Layer")
@js.native
class Layer extends js.Object {

  def addTo(map: LeafletMap): Layer = js.native


  def addTo(map: LayerGroup): Layer = js.native

  def remove(): Layer = js.native

  def removeFrom(map: LeafletMap): Layer = js.native

  def getPane(name: UndefOr[String] = ""): HTMLElement = js.native

  def bindPopup(content: HTMLElement, options: UndefOr[PopupOptions] = js.undefined): Unit = {
    js.native
  }

  def bindPopup(content: Popup): Unit = js.native
}

@JSGlobal("L.ImageOverlay")
@js.native
class ImageOverlay extends Layer {
  def setUrl(url: String): ImageOverlay = js.native

  def bringToFront(): ImageOverlay = js.native

  def setOpacity(v: Double): ImageOverlay = js.native
}

@JSGlobal
@js.native
class ImageOverlayOptions extends js.Object

@JSGlobal("L.Map")
@js.native
class LeafletMap(id: String, options: UndefOr[LMapOptions] = js.undefined) extends Evented {
  def setView(center: LatLng, zoom: Double, options: UndefOr[LZoomPanOptions] = js.undefined): LeafletMap = js.native

  def setZoom(level: Int): LeafletMap = js.native

  def addControl(control: Control): LeafletMap = js.native

  def removeControl(control: Control): LeafletMap = js.native

  def addLayer(layer: Layer): LeafletMap = js.native

  def removeLayer(layer: Layer): LeafletMap = js.native

  def fitBounds(bounds: LatLngBounds): LeafletMap = js.native

  def getBounds(): LatLngBounds = js.native

  def getZoom(): Int = js.native

  def hasLayer(layer: Layer): Boolean = js.native

  def eachLayer(fn: js.Function1[Layer, Unit]): LeafletMap = js.native

  def getCenter(): LatLng = js.native

  def panTo(latLng: LatLng): LeafletMap = js.native

  def remove(): LeafletMap = js.native

  def zoomIn(): LeafletMap = js.native

  def zoomOut(): LeafletMap = js.native
}

@JSGlobal("L.GridLayer")
@js.native
class GridLayer extends Layer {
  def this(gridLayerOpts: UndefOr[GridLayerOptions]) = this()

  def createTile(coords: js.Any): HTMLElement = js.native

  def bringToBack(): GridLayer = js.native

  def getAttribution(): GridLayer = js.native

  def getContainer(): GridLayer = js.native

  def setOpacity(opacity: Number): GridLayer = js.native

  def setZIndex(zIndex: Number): GridLayer = js.native

  def isLoading(): GridLayer = js.native

  def redraw(): GridLayer = js.native

  def getTileSize(): GridLayer = js.native
}

@JSGlobal("L.LatLngBounds")
@js.native
class LatLngBounds(southWest: LatLng, northEast: LatLng) extends js.Object {
  def isValid(): Boolean = js.native

  def getSouthEast(): LatLng = js.native

  def getSouthWest(): LatLng = js.native

  def getNorthEast(): LatLng = js.native

  def getNorthWest(): LatLng = js.native

  def getWest(): Double = js.native

  def getSouth(): Double = js.native

  def getEast(): Double = js.native

  def getNorth(): Double = js.native

  def getCenter(): LatLng = js.native

  def intersects(latLngBounds: LatLngBounds): Boolean = js.native

  @JSName("equals")
  def equalsLatLngBounds(latLngBounds: LatLngBounds): Boolean = js.native

  def toBBoxString(): String = js.native
}

object LatLngBounds {
  def apply(northEast: LatLng, southWest: LatLng): LatLngBounds = new LatLngBounds(southWest, northEast)

  def apply(latlngs: js.Array[LatLng]): LatLngBounds = new LatLngBounds(latlngs(0), latlngs(1))
}

@JSGlobal("L.LatLng")
@js.native
class LatLng(val lat: Double, val lng: Double, val alt: UndefOr[Double] = js.undefined) extends js.Object {
  def this(lat: Double, lng: Double) = this(lat, lng, js.undefined)

  def distanceTo(other: LatLng): Double = js.native

  @JSName("equals")
  def equalsLatLng(other: LatLng): Boolean = js.native

  def wrap(left: Double, right: Double): LatLng = js.native

  def toBounds(sizeInMeters: Double): LatLngBounds = js.native
}

object LatLng {
  def apply(latitude: Double, longitude: Double): LatLng = new LatLng(latitude, longitude)

  def apply(latLng: js.Array[Double]): LatLng = new LatLng(latLng(0), latLng(1))
}

@JSGlobal("L.Point")
@js.native
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

@JSGlobal("L.Control")
@js.native
class Control(position: UndefOr[String] = "topright") extends js.Object {
  def getPosition(): String = js.native

  def setPosition(position: String): Control = js.native

  def getContainer(): HTMLElement = js.native

  def addTo(map: LeafletMap): Control = js.native

  def remove(): Control = js.native
}

@JSGlobal("L.Popup")
@js.native
class Popup(options: UndefOr[PopupOptions] = js.undefined, source: UndefOr[Layer] = js.undefined) extends Layer {
  def getLatLng(): LatLng = js.native

  def setLatLng(latlng: LatLng): Popup = js.native

  def getContent(): HTMLElement = js.native

  def setContent(content: HTMLElement): Popup = js.native

  def getElement(): HTMLElement = js.native

  def update(): Unit = js.native

  def isOpen(): Boolean = js.native

  def bringToFront(): Popup = js.native

  def bringToBack(): Popup = js.native

  def openOn(map: LeafletMap): Popup = js.native
}

@JSGlobal("L.Control.Scale")
@js.native
class ControlScale(scaleOptions: UndefOr[ScaleOptions] = js.undefined) extends Control

object ControlScale {
  def apply(scaleOptions: UndefOr[ScaleOptions] = js.undefined): ControlScale = new ControlScale(scaleOptions)
}

@JSGlobal
@js.native
class ScaleOptions extends js.Object

object ScaleOptions extends ScaleOptionsBuilder(noOpts)

class ScaleOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[ScaleOptions, ScaleOptionsBuilder](new ScaleOptionsBuilder(_)) {

  def maxWidth(v: Int): ScaleOptionsBuilder = jsOpt("maxWidth", v)

  def metric(v: Boolean): ScaleOptionsBuilder = jsOpt("metric", v)

  def imperial(v: Boolean): ScaleOptionsBuilder = jsOpt("imperial", v)

  def updateWhenIdle(v: Boolean): ScaleOptionsBuilder = jsOpt("updateWhenIdle", v)
}

@JSGlobal("L.Control.Zoom")
@js.native
class ControlZoom(zoomOptions: UndefOr[ZoomOptions] = js.undefined) extends Control

object ControlZoom {
  def apply(zoomOptions: UndefOr[ZoomOptions] = js.undefined): ControlZoom = new ControlZoom(zoomOptions)
}

@JSGlobal
@js.native
class ZoomOptions extends js.Object

object ZoomOptions extends ScaleOptionsBuilder(noOpts)

class ZoomOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[ZoomOptions, ZoomOptionsBuilder](new ZoomOptionsBuilder(_)) {

  def zoomInText(v: String): ZoomOptionsBuilder = jsOpt("zoomInText", v)

  def zoomInTitle(v: String): ZoomOptionsBuilder = jsOpt("zoomInTitle", v)

  def zoomOutText(v: String): ZoomOptionsBuilder = jsOpt("zoomOutText", v)

  def zoomOutTitle(v: String): ZoomOptionsBuilder = jsOpt("zoomOutTitle", v)
}

@JSGlobal("L.Path")
@js.native
abstract class Path extends Layer {
  def setStyle(pathOptions: PathOptions): Path = js.native

  def redraw(): Path = js.native

  def bringToFront(): Path = js.native
}

@JSGlobal("L.Polyline")
@js.native
class Polyline extends Path {
  def getBounds(): LatLngBounds = js.native

  def setLatLngs(value: js.Array[LatLng]): Polyline = js.native
}

@JSGlobal
@js.native
class PolyLineOptions extends js.Object

object PolyLineOptions extends PolyLineOptionsBuilder(noOpts)

class PolyLineOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[PolyLineOptions, PolyLineOptionsBuilder](new PolyLineOptionsBuilder(_)) {

  def color(v: String): PolyLineOptionsBuilder = jsOpt("color", v)

  def fillOpacity(v: Double): PolyLineOptionsBuilder = jsOpt("fillOpacity", v)
}

@JSGlobal
@js.native
class PopupOptions extends js.Object

object PopupOptions extends PopupOptionsBuilder(noOpts)

class PopupOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[PopupOptions, PopupOptionsBuilder](new PopupOptionsBuilder(_)) {
  def maxWidth(v: Double): PopupOptionsBuilder = jsOpt("maxWidth", v)

  def minWidth(v: Double): PopupOptionsBuilder = jsOpt("minWidth", v)

  def maxHeight(v: Double): PopupOptionsBuilder = jsOpt("maxHeight", v)

  def autoPan(v: Boolean): PopupOptionsBuilder = jsOpt("autoPan", v)

  def autoPanPaddingTopLeft(v: Point): PopupOptionsBuilder =
    jsOpt("autoPanPaddingTopLeft", v)

  def autoPanPadding(v: Point): PopupOptionsBuilder = jsOpt("autoPanPadding", v)

  def keepInView(v: Boolean): PopupOptionsBuilder = jsOpt("keepInView", v)

  def closeButton(v: Boolean): PopupOptionsBuilder = jsOpt("closeButton", v)

  def autoClose(v: Boolean): PopupOptionsBuilder = jsOpt("autoClose", v)

  def closeOnEscapeKey(v: Boolean): PopupOptionsBuilder = jsOpt("closeOnEscapeKey", v)

  def closeOnClick(v: Boolean): PopupOptionsBuilder = jsOpt("closeOnClick", v)

  def className(v: String): PopupOptionsBuilder = jsOpt("className", v)
}

@JSGlobal
@js.native
class IconOptions extends js.Object

object IconOptions extends IconOptionsBuilder(noOpts)

class IconOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[IconOptions, IconOptionsBuilder](new IconOptionsBuilder(_)) {

  def url(v: String) = jsOpt("iconUrl", v)

  def retinaUrl(v: String) = jsOpt("iconRetinaUrl", v)

  def size(v: Point) = jsOpt("iconSize", v)

  def anchor(v: Point) = jsOpt("iconAnchor", v)

  def popupAnchor(v: Point) = jsOpt("popupAnchor", v)

  def tooltipAnchor(v: Point) = jsOpt("tooltipAnchor", v)

  def shadowUrl(v: String) = jsOpt("shadowUrl", v)

  def shadowRetinaUrl(v: String) = jsOpt("shadowRetinaUrl", v)

  def shadowSize(v: Point) = jsOpt("shadowSize", v)

  def shadowAnchor(v: Point) = jsOpt("shadowAnchor", v)

  def className(v: String) = jsOpt("className", v)
}


@JSGlobal
@js.native
class MarkerOptions extends js.Object

object MarkerOptions extends MarkerOptionsBuilder(noOpts)

class MarkerOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[MarkerOptions, MarkerOptionsBuilder](new MarkerOptionsBuilder(_)) {

  def icon(v: Icon) = jsOpt("icon", v)

  def draggable(v: Boolean) = jsOpt("draggable", v)

  def autoPan(v: Boolean) = jsOpt("autoPan", v)

  def autoPanPadding(v: Point) = jsOpt("autoPanPadding", v)

  def autoPanSpeed(v: Int) = jsOpt("autoPanSpeed", v)

  def keyboard(v: Boolean) = jsOpt("keyboard", v)

  def title(v: String) = jsOpt("title", v)

  def alt(v: String) = jsOpt("alt", v)

  def zIndexOffset(v: Int) = jsOpt("zIndexOffset", v)

  def opacity(v: Int) = jsOpt("opacity", v)

  def riseOnHover(v: Boolean) = jsOpt("riseOnHover", v)

  def riseOffset(v: Int) = jsOpt("riseOffset", v)

  def pane(v: String) = jsOpt("pane", v)

  def bubblingMouseEvents(v: Boolean) = jsOpt("bubblingMouseEvents", v)
}

@JSGlobal
@js.native
class PathOptions extends js.Object

object PathOptions extends PathOptionsBuilder(noOpts)

class PathOptionsBuilder(val dict: OptMap)
  extends JSOptionBuilder[PathOptions, PathOptionsBuilder](new PathOptionsBuilder(_)) {

  def color(v: String): PathOptionsBuilder = jsOpt("color", v)

  def opacity(v: Double): PathOptionsBuilder = jsOpt("opacity", v)

  def fillOpacity(v: Double): PathOptionsBuilder = jsOpt("fillOpacity", v)

  def className(v: String): PathOptionsBuilder = jsOpt("className", v)

  def weight(v: Int): PathOptionsBuilder = jsOpt("weight", v)
}

@JSGlobal("L.Polygon")
@js.native
class Polygon(val latlngs: js.Array[LatLng]) extends Polyline {
  def toGeoJSON(): js.Object = js.native
}

@JSGlobal("L.Polygon")
@js.native
class MultiPolygon(multiPolygon: MultipolygonCoords, opts: UndefOr[PolyLineOptions] = js.undefined) extends Polyline {
  def toGeoJSON(): js.Object = js.native
}

@JSGlobal("L.LayerGroup")
@js.native
class LayerGroup extends Layer {
  def addLayer(layer: Layer): LayerGroup = js.native

  def removeLayer(layer: Layer): LayerGroup = js.native

  def removeLayer(id: Double): LayerGroup = js.native

  def clearLayers(): LayerGroup = js.native

  def getLayers(): js.Array[Layer] = js.native

  def getLayer(id: Int): Layer = js.native

  def hasLayer(layer: Layer): Boolean = js.native

  def eachLayer(fn: js.Function1[Layer, Unit]): LayerGroup = js.native
}

@JSGlobal("L.Bounds")
@js.native
class Bounds extends js.Object {
  val min: Point = js.native

  val max: Point = js.native

  def getBottomLeft(): Point = js.native

  def getTopRight(): Point = js.native
}

@JSGlobal("L.PolyUtil")
@js.native
object PolyUtil extends js.Object {
  def clipPolygon(points: js.Array[Point], bounds: Bounds): js.Array[Point] = js.native
}

@JSGlobal("L.Util")
@js.native
object LeafletUtil extends js.Object {
  def stamp(obj: js.Object): Double = js.native
}

case class LZoomPanOptions(paddingTopLeft: Point, paddingBottomRight: Point, padding: Point, maxZoom: Double)
