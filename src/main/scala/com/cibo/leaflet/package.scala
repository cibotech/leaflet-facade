package com.cibo


package object leaflet {
  /**
    * The main entry point into Leaflet. alias to L, to match Leaflet idiom.
    */
  val L = Leaflet
  type OptMap = scala.collection.Map[String, Any]
  val noOpts = Map.empty[String, Any]
}
