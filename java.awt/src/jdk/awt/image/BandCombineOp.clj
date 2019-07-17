(ns jdk.awt.image.BandCombineOp
  "This class performs an arbitrary linear combination of the bands
  in a Raster, using a specified matrix.

  The width of the matrix must be equal to the number of bands in the
  source Raster, optionally plus one.  If there is one more
  column in the matrix than the number of bands, there is an implied 1 at the
  end of the vector of band samples representing a pixel.  The height
  of the matrix must be equal to the number of bands in the destination.

  For example, a 3-banded Raster might have the following
  transformation applied to each pixel in order to invert the second band of
  the Raster.


    [ 1.0   0.0   0.0    0.0  ]     [ b1 ]
    [ 0.0  -1.0   0.0  255.0  ]  x  [ b2 ]
    [ 0.0   0.0   1.0    0.0  ]     [ b3 ]
                                    [ 1 ]


  Note that the source and destination can be the same object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image BandCombineOp]))

(defn ->band-combine-op
  "Constructor.

  Constructs a BandCombineOp with the specified matrix.
   The width of the matrix must be equal to the number of bands in
   the source Raster, optionally plus one.  If there is one
   more column in the matrix than the number of bands, there is an implied
   1 at the end of the vector of band samples representing a pixel.  The
   height of the matrix must be equal to the number of bands in the
   destination.

   The first subscript is the row index and the second
   is the column index.  This operation uses none of the currently
   defined rendering hints; the RenderingHints argument can be
   null.

  matrix - The matrix to use for the band combine operation. - `float[][]`
  hints - The RenderingHints object for this operation. Not currently used so it can be null. - `java.awt.RenderingHints`"
  ([matrix ^java.awt.RenderingHints hints]
    (new BandCombineOp matrix hints)))

(defn get-matrix
  "Returns a copy of the linear combination matrix.

  returns: The matrix associated with this band combine operation. - `float[][]`"
  ([^java.awt.image.BandCombineOp this]
    (-> this (.getMatrix))))

(defn filter
  "Transforms the Raster using the matrix specified in the
   constructor. An IllegalArgumentException may be thrown if
   the number of bands in the source or destination is incompatible with
   the matrix.  See the class comments for more details.

   If the destination is null, it will be created with a number of bands
   equalling the number of rows in the matrix. No exception is thrown
   if the operation causes a data overflow.

  src - The Raster to be filtered. - `java.awt.image.Raster`
  dst - The Raster in which to store the results of the filter operation. - `java.awt.image.WritableRaster`

  returns: The filtered Raster. - `java.awt.image.WritableRaster`

  throws: java.lang.IllegalArgumentException - If the number of bands in the source or destination is incompatible with the matrix."
  ([^java.awt.image.BandCombineOp this ^java.awt.image.Raster src ^java.awt.image.WritableRaster dst]
    (-> this (.filter src dst))))

(defn get-bounds-2-d
  "Returns the bounding box of the transformed destination.  Since
   this is not a geometric operation, the bounding box is the same for
   the source and destination.
   An IllegalArgumentException may be thrown if the number of
   bands in the source is incompatible with the matrix.  See
   the class comments for more details.

  src - The Raster to be filtered. - `java.awt.image.Raster`

  returns: The Rectangle2D representing the destination
   image's bounding box. - `java.awt.geom.Rectangle2D`

  throws: java.lang.IllegalArgumentException - If the number of bands in the source is incompatible with the matrix."
  ([^java.awt.image.BandCombineOp this ^java.awt.image.Raster src]
    (-> this (.getBounds2D src))))

(defn create-compatible-dest-raster
  "Creates a zeroed destination Raster with the correct size
   and number of bands.
   An IllegalArgumentException may be thrown if the number of
   bands in the source is incompatible with the matrix.  See
   the class comments for more details.

  src - The Raster to be filtered. - `java.awt.image.Raster`

  returns: The zeroed destination Raster. - `java.awt.image.WritableRaster`"
  ([^java.awt.image.BandCombineOp this ^java.awt.image.Raster src]
    (-> this (.createCompatibleDestRaster src))))

(defn get-point-2-d
  "Returns the location of the corresponding destination point given a
   point in the source Raster.  If dstPt is
   specified, it is used to hold the return value.
   Since this is not a geometric operation, the point returned
   is the same as the specified srcPt.

  src-pt - The Point2D that represents the point in the source Raster - `java.awt.geom.Point2D`
  dst-pt - The Point2D in which to store the result. - `java.awt.geom.Point2D`

  returns: The Point2D in the destination image that
   corresponds to the specified point in the source image. - `java.awt.geom.Point2D`"
  ([^java.awt.image.BandCombineOp this ^java.awt.geom.Point2D src-pt ^java.awt.geom.Point2D dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints for this operation.

  returns: The RenderingHints object associated with this
   operation.  Returns null if no hints have been set. - `java.awt.RenderingHints`"
  ([^java.awt.image.BandCombineOp this]
    (-> this (.getRenderingHints))))

