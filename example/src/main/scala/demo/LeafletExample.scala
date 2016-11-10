package demo


import com.cibo.leaflet.{LatLng, Leaflet}

import scala.scalajs.js


object LeafletExample extends js.JSApp {

  import js.JSConverters._

  def main(): Unit = {

    val leafletMap = Leaflet.map("demo-map").setView(LatLng(51.505, -0.09), 13)

    Leaflet
      .tileLayer("http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}")
      .addTo(leafletMap)

    val coords = Seq(
      LatLng(51.509, -0.08),
      LatLng(51.503, -0.06),
      LatLng(51.51, -0.047)
    ).toJSArray

    Leaflet.polygon(js.Array(coords)).addTo(leafletMap)
  }
}