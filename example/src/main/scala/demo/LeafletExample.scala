package demo


import com.cibo.leaflet.pm._
import com.cibo.leaflet.pm.PM._
import com.cibo.leaflet._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel


object LeafletExample {

  import js.JSConverters._

  @JSExportTopLevel("example")
  def example(): Unit = {

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

    // PM
    leafletMap.pm.addControls(ToolbarOptions.drawPolygon(false).drawMarker(true))
  }
}
