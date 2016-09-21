/* Copyright (c) 2016 CiBO Technologies - All Rights Reserved
 * You may use, distribute, and modify this code under the
 * terms of the BSD 3-Clause license.
 *
 * A copy of the license can be found on the root of this repository,
 * at https://github.com/cibotech/leaflet-facade/LICENSE.md,
 * or at https://opensource.org/licenses/BSD-3-Clause
 */

package com.cibo


package object leaflet {
  /**
    * The main entry point into Leaflet. alias to L, to match Leaflet idiom.
    */
  val L = Leaflet
  type OptMap = scala.collection.Map[String, Any]
  val noOpts = Map.empty[String, Any]
}
