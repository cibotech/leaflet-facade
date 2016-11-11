#Scalajs Leaflet Facade  
A type safe Scala.js facade for Leaflet

Works with [Leaflet](http://leafletjs.com/reference-1.0.0.html) version 1.0.0

##Getting Started
+ Add the following to your sbt build  
```
resolvers += Resolver.bintrayRepo("cibotech", "public")

libraryDependencies += "com.cibo" %%% "leaflet-facade" % "1.0.0"
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

+ A full example can be found under the `/example directory`


###License

BSD 3-Clause License


Copyright (c) 2016, CiBO Technologies
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are
met:

1. Redistributions of source code must retain the above copyright
notice, this list of conditions and the following disclaimer. 

2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in
the documentation and/or other materials provided with the
distribution.  

3. The name of the author may not be used to
endorse or promote products derived from this software without
specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR "AS IS" AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
