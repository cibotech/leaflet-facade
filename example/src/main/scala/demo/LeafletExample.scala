package demo

import scala.scalajs.js
import com.cibo.leaflet{Leaflet}

object LeafletExample extends js.JSApp {
  def main(): Unit = {
    println(Hello.a)
//    val leafletMap = L.map("demo-map").setView(LatLng(51.505, -0.09), 13)
//    val tileLayer = L.tileLayer("http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}")
//
//    tileLayer.addTo(leafletMap)

    //        val leafletMap = LeafletFacade.map("leaflet-map")

    //    val tileLayer = LeafletFacade
    //      .tileLayer("http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}")
    //      .addTo(leafletMap)
    //
    //    tileLayer
    //
    //    val coords = Seq(
    //      LatLng(51.509, -0.08),
    //      LatLng(51.503, -0.06),
    //      LatLng(51.51, -0.047)
    //    ).toJSArray

    //    tileLayer
    //
    //    val coords = Seq(
    //      LatLng(51.509, -0.08),
    //      LatLng(51.503, -0.06),
    //      LatLng(51.51, -0.047)
    //    ).toJSArray
    //
    //    L.polygon(coords).addTo(leafletMap)
    //
    //    jQuery
    //
    //
    //
    //    val canvasLayer = L.gridLayer()
    //    canvasLayer.asInstanceOf[js.Dynamic].createTile = () => {
    //      val canvas = dom.document.createElement("canvas").asInstanceOf[Canvas]
    //      val ctx = canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    //      canvas.width = 50
    //      canvas.height = 50
    //      ctx.fillStyle = "white"
    //      ctx.strokeStyle = "red"
    //      ctx.beginPath()
    //      ctx.moveTo(0, 0)
    //      ctx.lineTo(255, 0)
    //      ctx.lineTo(255, 255)
    //      ctx.lineTo(0, 255)
    //      ctx.closePath()
    //      ctx.stroke()
    //      canvas
    //    }
    //    canvasLayer.addTo(leafletMap)
    //      dom.document.getElementById("content").innerHTML =


    println("a crazy basic example")
  }
}
