(ns jdk.awt.image.ColorConvertOp
  "This class performs a pixel-by-pixel color conversion of the data in
  the source image.  The resulting color values are scaled to the precision
  of the destination image.  Color conversion can be specified
  via an array of ColorSpace objects or an array of ICC_Profile objects.

  If the source is a BufferedImage with premultiplied alpha, the
  color components are divided by the alpha component before color conversion.
  If the destination is a BufferedImage with premultiplied alpha, the
  color components are multiplied by the alpha component after conversion.
  Rasters are treated as having no alpha channel, i.e. all bands are
  color bands.

  If a RenderingHints object is specified in the constructor, the
  color rendering hint and the dithering hint may be used to control
  color conversion.

  Note that Source and Destination may be the same object."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ColorConvertOp]))

(defn ->color-convert-op
  "Constructor.

  Constructs a new ColorConvertOp from two ColorSpace objects.
   The RenderingHints argument may be null.
   This Op is primarily useful for calling the filter method on
   Rasters, in which case the two ColorSpaces define the operation
   to be performed on the Rasters.  In that case, the number of bands
   in the source Raster must match the number of components in
   srcCspace, and the number of bands in the destination Raster
   must match the number of components in dstCspace.  For BufferedImages,
   the two ColorSpaces define intermediate spaces through which the
   source is converted before being converted to the destination space.

  src-cspace - the source ColorSpace - `java.awt.color.ColorSpace`
  dst-cspace - the destination ColorSpace - `java.awt.color.ColorSpace`
  hints - the RenderingHints object used to control the color conversion, or null - `java.awt.RenderingHints`

  throws: java.lang.NullPointerException - if either srcCspace or dstCspace is null"
  ([src-cspace dst-cspace hints]
    (new ColorConvertOp src-cspace dst-cspace hints))
  ([cspace hints]
    (new ColorConvertOp cspace hints))
  ([hints]
    (new ColorConvertOp hints)))

(defn get-icc-profiles
  "Returns the array of ICC_Profiles used to construct this ColorConvertOp.
   Returns null if the ColorConvertOp was not constructed from such an
   array.

  returns: the array of ICC_Profile objects of this
           ColorConvertOp, or null if this
           ColorConvertOp was not constructed with an
           array of ICC_Profile objects. - `java.awt.color.ICC_Profile[]`"
  ([this]
    (-> this (.getICC_Profiles))))

(defn filter
  "ColorConverts the source BufferedImage.
   If the destination image is null,
   a BufferedImage will be created with an appropriate ColorModel.

  src - the source BufferedImage to be converted - `java.awt.image.BufferedImage`
  dest - the destination BufferedImage, or null - `java.awt.image.BufferedImage`

  returns: dest color converted from src
           or a new, converted BufferedImage
           if dest is null - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if dest is null and this op was constructed using the constructor which takes only a RenderingHints argument, since the operation is ill defined."
  ([this src dest]
    (-> this (.filter src dest))))

(defn get-bounds-2-d
  "Returns the bounding box of the destination, given this source.
   Note that this will be the same as the the bounding box of the
   source.

  src - the source BufferedImage - `java.awt.image.BufferedImage`

  returns: a Rectangle2D that is the bounding box
           of the destination, given the specified src - `java.awt.geom.Rectangle2D`"
  ([this src]
    (-> this (.getBounds2D src))))

(defn create-compatible-dest-image
  "Creates a zeroed destination image with the correct size and number of
   bands, given this source.

  src - Source image for the filter operation. - `java.awt.image.BufferedImage`
  dest-cm - ColorModel of the destination. If null, an appropriate ColorModel will be used. - `java.awt.image.ColorModel`

  returns: a BufferedImage with the correct size and
   number of bands from the specified src. - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if destCM is null and this ColorConvertOp was created without any ICC_Profile or ColorSpace defined for the destination"
  ([this src dest-cm]
    (-> this (.createCompatibleDestImage src dest-cm))))

(defn create-compatible-dest-raster
  "Creates a zeroed destination Raster with the correct size and number of
   bands, given this source.

  src - the specified Raster - `java.awt.image.Raster`

  returns: a WritableRaster with the correct size and number
           of bands from the specified src - `java.awt.image.WritableRaster`

  throws: java.lang.IllegalArgumentException - if this ColorConvertOp was created without sufficient information to define the dst and src color spaces"
  ([this src]
    (-> this (.createCompatibleDestRaster src))))

(defn get-point-2-d
  "Returns the location of the destination point given a
   point in the source.  If dstPt is non-null,
   it will be used to hold the return value.  Note that
   for this class, the destination point will be the same
   as the source point.

  src-pt - the specified source Point2D - `java.awt.geom.Point2D`
  dst-pt - the destination Point2D - `java.awt.geom.Point2D`

  returns: dstPt after setting its location to be
           the same as srcPt - `java.awt.geom.Point2D`"
  ([this src-pt dst-pt]
    (-> this (.getPoint2D src-pt dst-pt))))

(defn get-rendering-hints
  "Returns the rendering hints used by this op.

  returns: the RenderingHints object of this
           ColorConvertOp - `java.awt.RenderingHints`"
  ([this]
    (-> this (.getRenderingHints))))

