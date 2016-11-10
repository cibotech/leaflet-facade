#Scalajs Leaflet Facade  
A type safe Scala.js facade for Leaflet

Works with [Leaflet](http://leafletjs.com/reference-1.0.0.html)
+ version 1.0.0

##Getting Started
+ Add the following to your sbt build  
```
libraryDependencies += "com.cibo.leaflet-facade" %%% "leaflet-facade" % "1.0.0-RC1"
```
  
+ Note - this library currently does not include the leaflet css files.  In order for styling to work, first add the leaflet.css to your html
```
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.0.0-rc.2/leaflet.css">
```


###Example Usage
+ Now you can enjoy leaflet with the type safety of Scala!    
  
```
val leafletMap = Leaflet.map("demo-map").setView(LatLng(51.505, -0.09), 13)

Leaflet
  .tileLayer("http://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}")
  .addTo(leafletMap)

val coords = Seq(
  LatLng(51.509, -0.08),
  LatLng(51.503, -0.06),
  LatLng(51.51, -0.047)
).toJSArray

Leaflet
    .polygon(js.Array(coords))
    .addTo(leafletMap)
```


###Demo
[Demo Page](http://cibotech.github.io/leaflet-facade)  

+ This Full Example can be found under the `/example directory`
