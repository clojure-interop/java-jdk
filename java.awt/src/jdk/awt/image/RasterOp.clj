(ns jdk.awt.image.RasterOp
  "This interface describes single-input/single-output
  operations performed on Raster objects.  It is implemented by such
  classes as AffineTransformOp, ConvolveOp, and LookupOp.  The Source
  and Destination objects must contain the appropriate number
  of bands for the particular classes implementing this interface.
  Otherwise, an exception is thrown.  This interface cannot be used to
  describe more sophisticated Ops such as ones that take multiple sources.
  Each class implementing this interface will specify whether or not it
  will allow an in-place filtering operation (i.e. source object equal
  to the destination object).  Note that the restriction to single-input
  operations means that the values of destination pixels prior to the
  operation are not used as input to the filter operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image RasterOp]))

(defn filter
  "Performs a single-input/single-output operation from a source Raster
   to a destination Raster.  If the destination Raster is null, a
   new Raster will be created.  The IllegalArgumentException may be thrown
   if the source and/or destination Raster is incompatible with the types
   of Rasters allowed by the class implementing this filter.

  src - the source Raster - `java.awt.image.Raster`
  dest - the destination WritableRaster - `java.awt.image.WritableRaster`

  returns: a WritableRaster that represents the result of
           the filtering operation. - `java.awt.image.WritableRaster`"
  ([^. this ^java.awt.image.Raster src ^java.awt.image.WritableRaster dest]
    (-> this (.filter src dest))))

(defn get-bounds-2-d
  "Returns the bounding box of the filtered destination Raster.
   The IllegalArgumentException may be thrown if the source Raster
   is incompatible with the types of Rasters allowed
   by the class implementing this filter.

  src - the source Raster - `java.awt.image.Raster`

  returns: a Rectangle2D that is the bounding box of
           the Raster resulting from the filtering
           operation. - `java.awt.geom.Rectangle2D`"
  ([^. this ^java.awt.image.Raster src]
    (-> this (.getBounds2D src))))

(defn create-compatible-dest-raster
  "Creates a zeroed destination Raster with the correct size and number of
   bands.
   The IllegalArgumentException may be thrown if the source Raster
   is incompatible with the types of Rasters allowed
   by the class implementing this filter.

  src - the source Raster - `java.awt.image.Raster`

  returns: a WritableRaster that is compatible with
           src - `java.awt.image.WritableRaster`"
  ([^. this ^java.awt.image.Raster src]
    (-> this (.createCompatibleDestRaster src))))

(defn get-point-2-d
  "Returns the location of the destination point given a
   point in the source Raster.  If dstPt is non-null, it
   will be used to hold the return value.

  src-pt - the source Point2D - `java.awt.geom.Point2D`
  dst-pt - the destination Point2D - `java.awt.geom.Point2D`

  returns: the location of the destination point. - `java.awt.geom.Point2D`"
  ([^. this ^java.awt.geom.Point2D src-pt ^java.awt.geom.Point2D dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints for this RasterOp.  Returns
   null if no hints have been set.

  returns: the RenderingHints object of this
           RasterOp. - `java.awt.RenderingHints`"
  ([^. this]
    (-> this (.getRenderingHints))))

