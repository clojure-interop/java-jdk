(ns jdk.awt.image.AffineTransformOp
  "This class uses an affine transform to perform a linear mapping from
  2D coordinates in the source image or Raster to 2D coordinates
  in the destination image or Raster.
  The type of interpolation that is used is specified through a constructor,
  either by a RenderingHints object or by one of the integer
  interpolation types defined in this class.

  If a RenderingHints object is specified in the constructor, the
  interpolation hint and the rendering quality hint are used to set
  the interpolation type for this operation.  The color rendering hint
  and the dithering hint can be used when color conversion is required.

  Note that the following constraints have to be met:

  The source and destination must be different.
  For Raster objects, the number of bands in the source must
  be equal to the number of bands in the destination."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image AffineTransformOp]))

(defn ->affine-transform-op
  "Constructor.

  Constructs an AffineTransformOp given an affine transform.
   The interpolation type is determined from the
   RenderingHints object.  If the interpolation hint is
   defined, it will be used. Otherwise, if the rendering quality hint is
   defined, the interpolation type is determined from its value.  If no
   hints are specified (hints is null),
   the interpolation type is TYPE_NEAREST_NEIGHBOR.

  xform - The AffineTransform to use for the operation. - `java.awt.geom.AffineTransform`
  hints - The RenderingHints object used to specify the interpolation type for the operation. - `java.awt.RenderingHints`

  throws: java.awt.image.ImagingOpException - if the transform is non-invertible."
  ([xform hints]
    (new AffineTransformOp xform hints)))

(def *-type-nearest-neighbor
  "Static Constant.

  Nearest-neighbor interpolation type.

  type: java.lang.annotation.    int"
  AffineTransformOp/TYPE_NEAREST_NEIGHBOR)

(def *-type-bilinear
  "Static Constant.

  Bilinear interpolation type.

  type: java.lang.annotation.    int"
  AffineTransformOp/TYPE_BILINEAR)

(def *-type-bicubic
  "Static Constant.

  Bicubic interpolation type.

  type: java.lang.annotation.    int"
  AffineTransformOp/TYPE_BICUBIC)

(defn get-interpolation-type
  "Returns the interpolation type used by this op.

  returns: the interpolation type. - `int`"
  ([this]
    (-> this (.getInterpolationType))))

(defn filter
  "Transforms the source BufferedImage and stores the results
   in the destination BufferedImage.
   If the color models for the two images do not match, a color
   conversion into the destination color model is performed.
   If the destination image is null,
   a BufferedImage is created with the source
   ColorModel.

   The coordinates of the rectangle returned by
   getBounds2D(BufferedImage)
   are not necessarily the same as the coordinates of the
   BufferedImage returned by this method.  If the
   upper-left corner coordinates of the rectangle are
   negative then this part of the rectangle is not drawn.  If the
   upper-left corner coordinates of the  rectangle are positive
   then the filtered image is drawn at that position in the
   destination BufferedImage.

   An IllegalArgumentException is thrown if the source is
   the same as the destination.

  src - The BufferedImage to transform. - `java.awt.image.BufferedImage`
  dst - The BufferedImage in which to store the results of the transformation. - `java.awt.image.BufferedImage`

  returns: The filtered BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if src and dst are the same"
  ([this src dst]
    (-> this (.filter src dst))))

(defn get-bounds-2-d
  "Returns the bounding box of the transformed destination.  The
   rectangle returned is the actual bounding box of the
   transformed points.  The coordinates of the upper-left corner
   of the returned rectangle might not be (0, 0).

  src - The BufferedImage to be transformed. - `java.awt.image.BufferedImage`

  returns: The Rectangle2D representing the destination's
   bounding box. - `java.awt.geom.Rectangle2D`"
  ([this src]
    (-> this (.getBounds2D src))))

(defn create-compatible-dest-image
  "Creates a zeroed destination image with the correct size and number of
   bands.  A RasterFormatException may be thrown if the
   transformed width or height is equal to 0.

   If destCM is null,
   an appropriate ColorModel is used; this
   ColorModel may have
   an alpha channel even if the source ColorModel is opaque.

  src - The BufferedImage to be transformed. - `java.awt.image.BufferedImage`
  dest-cm - ColorModel of the destination. If null, an appropriate ColorModel is used. - `java.awt.image.ColorModel`

  returns: The zeroed destination image. - `java.awt.image.BufferedImage`"
  ([this src dest-cm]
    (-> this (.createCompatibleDestImage src dest-cm))))

(defn create-compatible-dest-raster
  "Creates a zeroed destination Raster with the correct size
   and number of bands.  A RasterFormatException may be thrown
   if the transformed width or height is equal to 0.

  src - The Raster to be transformed. - `java.awt.image.Raster`

  returns: The zeroed destination Raster. - `java.awt.image.WritableRaster`"
  ([this src]
    (-> this (.createCompatibleDestRaster src))))

(defn get-point-2-d
  "Returns the location of the corresponding destination point given a
   point in the source.  If dstPt is specified, it
   is used to hold the return value.

  src-pt - The Point2D that represents the source point. - `java.awt.geom.Point2D`
  dst-pt - The Point2D in which to store the result. - `java.awt.geom.Point2D`

  returns: The Point2D in the destination that corresponds to
   the specified point in the source. - `java.awt.geom.Point2D`"
  ([this src-pt dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-transform
  "Returns the affine transform used by this transform operation.

  returns: The AffineTransform associated with this op. - `java.awt.geom.AffineTransform`"
  ([this]
    (-> this (.getTransform))))

(defn get-rendering-hints
  "Returns the rendering hints used by this transform operation.

  returns: The RenderingHints object associated with this op. - `java.awt.RenderingHints`"
  ([this]
    (-> this (.getRenderingHints))))

