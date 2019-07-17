(ns jdk.awt.image.BufferedImage
  "The BufferedImage subclass describes an Image with an accessible buffer of image data.
  A BufferedImage is comprised of a ColorModel and a
  Raster of image data.
  The number and types of bands in the SampleModel of the
  Raster must match the number and types required by the
  ColorModel to represent its color and alpha components.
  All BufferedImage objects have an upper left corner
  coordinate of (0, 0).  Any Raster used to construct a
  BufferedImage must therefore have minX=0 and minY=0.


  This class relies on the data fetching and setting methods
  of Raster,
  and on the color characterization methods of ColorModel."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image BufferedImage]))

(defn ->buffered-image
  "Constructor.

  Constructs a BufferedImage of one of the predefined
   image types:
   TYPE_BYTE_BINARY or TYPE_BYTE_INDEXED.

    If the image type is TYPE_BYTE_BINARY, the number of
   entries in the color model is used to determine whether the
   image should have 1, 2, or 4 bits per pixel.  If the color model
   has 1 or 2 entries, the image will have 1 bit per pixel.  If it
   has 3 or 4 entries, the image with have 2 bits per pixel.  If
   it has between 5 and 16 entries, the image will have 4 bits per
   pixel.  Otherwise, an IllegalArgumentException will be thrown.

  width - width of the created image - `int`
  height - height of the created image - `int`
  image-type - type of the created image - `int`
  cm - IndexColorModel of the created image - `java.awt.image.IndexColorModel`

  throws: java.lang.IllegalArgumentException - if the imageType is not TYPE_BYTE_BINARY or TYPE_BYTE_INDEXED or if the imageType is TYPE_BYTE_BINARY and the color map has more than 16 entries."
  ([^Integer width ^Integer height ^Integer image-type ^java.awt.image.IndexColorModel cm]
    (new BufferedImage width height image-type cm))
  ([^Integer width ^Integer height ^Integer image-type]
    (new BufferedImage width height image-type)))

(def *-type-custom
  "Static Constant.

  Image type is not recognized so it must be a customized
   image.  This type is only used as a return value for the getType()
   method.

  type: int"
  BufferedImage/TYPE_CUSTOM)

(def *-type-int-rgb
  "Static Constant.

  Represents an image with 8-bit RGB color components packed into
   integer pixels.  The image has a DirectColorModel without
   alpha.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_INT_RGB)

(def *-type-int-argb
  "Static Constant.

  Represents an image with 8-bit RGBA color components packed into
   integer pixels.  The image has a DirectColorModel
   with alpha. The color data in this image is considered not to be
   premultiplied with alpha.  When this type is used as the
   imageType argument to a BufferedImage
   constructor, the created image is consistent with images
   created in the JDK1.1 and earlier releases.

  type: int"
  BufferedImage/TYPE_INT_ARGB)

(def *-type-int-argb-pre
  "Static Constant.

  Represents an image with 8-bit RGBA color components packed into
   integer pixels.  The image has a DirectColorModel
   with alpha.  The color data in this image is considered to be
   premultiplied with alpha.

  type: int"
  BufferedImage/TYPE_INT_ARGB_PRE)

(def *-type-int-bgr
  "Static Constant.

  Represents an image with 8-bit RGB color components, corresponding
   to a Windows- or Solaris- style BGR color model, with the colors
   Blue, Green, and Red packed into integer pixels.  There is no alpha.
   The image has a DirectColorModel.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_INT_BGR)

(def *-type-3-byte-bgr
  "Static Constant.

  Represents an image with 8-bit RGB color components, corresponding
   to a Windows-style BGR color model) with the colors Blue, Green,
   and Red stored in 3 bytes.  There is no alpha.  The image has a
   ComponentColorModel.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_3BYTE_BGR)

(def *-type-4-byte-abgr
  "Static Constant.

  Represents an image with 8-bit RGBA color components with the colors
   Blue, Green, and Red stored in 3 bytes and 1 byte of alpha.  The
   image has a ComponentColorModel with alpha.  The
   color data in this image is considered not to be premultiplied with
   alpha.  The byte data is interleaved in a single
   byte array in the order A, B, G, R
   from lower to higher byte addresses within each pixel.

  type: int"
  BufferedImage/TYPE_4BYTE_ABGR)

(def *-type-4-byte-abgr-pre
  "Static Constant.

  Represents an image with 8-bit RGBA color components with the colors
   Blue, Green, and Red stored in 3 bytes and 1 byte of alpha.  The
   image has a ComponentColorModel with alpha. The color
   data in this image is considered to be premultiplied with alpha.
   The byte data is interleaved in a single byte array in the order
   A, B, G, R from lower to higher byte addresses within each pixel.

  type: int"
  BufferedImage/TYPE_4BYTE_ABGR_PRE)

(def *-type-ushort-565-rgb
  "Static Constant.

  Represents an image with 5-6-5 RGB color components (5-bits red,
   6-bits green, 5-bits blue) with no alpha.  This image has
   a DirectColorModel.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_USHORT_565_RGB)

(def *-type-ushort-555-rgb
  "Static Constant.

  Represents an image with 5-5-5 RGB color components (5-bits red,
   5-bits green, 5-bits blue) with no alpha.  This image has
   a DirectColorModel.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_USHORT_555_RGB)

(def *-type-byte-gray
  "Static Constant.

  Represents a unsigned byte grayscale image, non-indexed.  This
   image has a ComponentColorModel with a CS_GRAY
   ColorSpace.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_BYTE_GRAY)

(def *-type-ushort-gray
  "Static Constant.

  Represents an unsigned short grayscale image, non-indexed).  This
   image has a ComponentColorModel with a CS_GRAY
   ColorSpace.
   When data with non-opaque alpha is stored
   in an image of this type,
   the color data must be adjusted to a non-premultiplied form
   and the alpha discarded,
   as described in the
   AlphaComposite documentation.

  type: int"
  BufferedImage/TYPE_USHORT_GRAY)

(def *-type-byte-binary
  "Static Constant.

  Represents an opaque byte-packed 1, 2, or 4 bit image.  The
   image has an IndexColorModel without alpha.  When this
   type is used as the imageType argument to the
   BufferedImage constructor that takes an
   imageType argument but no ColorModel
   argument, a 1-bit image is created with an
   IndexColorModel with two colors in the default
   sRGB ColorSpace: {0, 0, 0} and
   {255, 255, 255}.

    Images with 2 or 4 bits per pixel may be constructed via
   the BufferedImage constructor that takes a
   ColorModel argument by supplying a
   ColorModel with an appropriate map size.

    Images with 8 bits per pixel should use the image types
   TYPE_BYTE_INDEXED or TYPE_BYTE_GRAY
   depending on their ColorModel.

    When color data is stored in an image of this type,
   the closest color in the colormap is determined
   by the IndexColorModel and the resulting index is stored.
   Approximation and loss of alpha or color components
   can result, depending on the colors in the
   IndexColorModel colormap.

  type: int"
  BufferedImage/TYPE_BYTE_BINARY)

(def *-type-byte-indexed
  "Static Constant.

  Represents an indexed byte image.  When this type is used as the
   imageType argument to the BufferedImage
   constructor that takes an imageType argument
   but no ColorModel argument, an
   IndexColorModel is created with
   a 256-color 6/6/6 color cube palette with the rest of the colors
   from 216-255 populated by grayscale values in the
   default sRGB ColorSpace.

    When color data is stored in an image of this type,
   the closest color in the colormap is determined
   by the IndexColorModel and the resulting index is stored.
   Approximation and loss of alpha or color components
   can result, depending on the colors in the
   IndexColorModel colormap.

  type: int"
  BufferedImage/TYPE_BYTE_INDEXED)

(defn get-min-tile-y
  "Returns the minimum tile index in the y direction.
   This is always zero.

  returns: the minimum tile index in the y direction. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getMinTileY))))

(defn get-transparency
  "Returns the transparency.  Returns either OPAQUE, BITMASK,
   or TRANSLUCENT.

  returns: the transparency of this BufferedImage. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getTransparency))))

(defn get-writable-tile-indices
  "Returns an array of Point objects indicating which tiles
   are checked out for writing.  Returns null if none are
   checked out.

  returns: a Point array that indicates the tiles that
            are checked out for writing, or null if no
            tiles are checked out for writing. - `java.awt.Point[]`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getWritableTileIndices))))

(defn set-data
  "Sets a rectangular region of the image to the contents of the
   specified Raster r, which is
   assumed to be in the same coordinate space as the
   BufferedImage. The operation is clipped to the bounds
   of the BufferedImage.

  r - the specified Raster - `java.awt.image.Raster`"
  ([^java.awt.image.BufferedImage this ^java.awt.image.Raster r]
    (-> this (.setData r))))

(defn get-width
  "Returns the width of the BufferedImage.

  observer - ignored - `java.awt.image.ImageObserver`

  returns: the width of this BufferedImage - `int`"
  ([^java.awt.image.BufferedImage this ^java.awt.image.ImageObserver observer]
    (-> this (.getWidth observer)))
  ([^java.awt.image.BufferedImage this]
    (-> this (.getWidth))))

(defn get-data
  "Computes and returns an arbitrary region of the
   BufferedImage.  The Raster returned is a
   copy of the image data and is not updated if the image is
   changed.

  rect - the region of the BufferedImage to be returned. - `java.awt.Rectangle`

  returns: a Raster that is a copy of the image data of
            the specified region of the BufferedImage - `java.awt.image.Raster`"
  ([^java.awt.image.BufferedImage this ^java.awt.Rectangle rect]
    (-> this (.getData rect)))
  ([^java.awt.image.BufferedImage this]
    (-> this (.getData))))

(defn get-alpha-raster
  "Returns a WritableRaster representing the alpha
   channel for BufferedImage objects
   with ColorModel objects that support a separate
   spatial alpha channel, such as ComponentColorModel and
   DirectColorModel.  Returns null if there
   is no alpha channel associated with the ColorModel in
   this image.  This method assumes that for all
   ColorModel objects other than
   IndexColorModel, if the ColorModel
   supports alpha, there is a separate alpha channel
   which is stored as the last band of image data.
   If the image uses an IndexColorModel that
   has alpha in the lookup table, this method returns
   null since there is no spatially discrete alpha
   channel.  This method creates a new
   WritableRaster, but shares the data array.

  returns: a WritableRaster or null if this
            BufferedImage has no alpha channel associated
            with its ColorModel. - `java.awt.image.WritableRaster`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getAlphaRaster))))

(defn get-type
  "Returns the image type.  If it is not one of the known types,
   TYPE_CUSTOM is returned.

  returns: the image type of this BufferedImage. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getType))))

(defn get-rgb
  "Returns an array of integer pixels in the default RGB color model
   (TYPE_INT_ARGB) and default sRGB color space,
   from a portion of the image data.  Color conversion takes
   place if the default model does not match the image
   ColorModel.  There are only 8-bits of precision for
   each color component in the returned data when
   using this method.  With a specified coordinate (x, y) in the
   image, the ARGB pixel can be accessed in this way:



      pixel   = rgbArray[offset  (y-startY)*scansize  (x-startX)];



   An ArrayOutOfBoundsException may be thrown
   if the region is not in bounds.
   However, explicit bounds checking is not guaranteed.

  start-x - the starting X coordinate - `int`
  start-y - the starting Y coordinate - `int`
  w - width of region - `int`
  h - height of region - `int`
  rgb-array - if not null, the rgb pixels are written here - `int[]`
  offset - offset into the rgbArray - `int`
  scansize - scanline stride for the rgbArray - `int`

  returns: array of RGB pixels. - `int[]`"
  ([^java.awt.image.BufferedImage this ^Integer start-x ^Integer start-y ^Integer w ^Integer h rgb-array ^Integer offset ^Integer scansize]
    (-> this (.getRGB start-x start-y w h rgb-array offset scansize)))
  ([^java.awt.image.BufferedImage this ^Integer x ^Integer y]
    (-> this (.getRGB x y))))

(defn get-tile
  "Returns tile (tileX, tileY).  Note
   that tileX and tileY are indices
   into the tile array, not pixel locations.  The Raster
   that is returned is live, which means that it is updated if the
   image is changed.

  tile-x - the x index of the requested tile in the tile array - `int`
  tile-y - the y index of the requested tile in the tile array - `int`

  returns: a Raster that is the tile defined by the
            arguments tileX and tileY. - `java.awt.image.Raster`

  throws: java.lang.ArrayIndexOutOfBoundsException - if both tileX and tileY are not equal to 0"
  ([^java.awt.image.BufferedImage this ^Integer tile-x ^Integer tile-y]
    (-> this (.getTile tile-x tile-y))))

(defn set-rgb
  "Sets an array of integer pixels in the default RGB color model
   (TYPE_INT_ARGB) and default sRGB color space,
   into a portion of the image data.  Color conversion takes place
   if the default model does not match the image
   ColorModel.  There are only 8-bits of precision for
   each color component in the returned data when
   using this method.  With a specified coordinate (x, y) in the
   this image, the ARGB pixel can be accessed in this way:


      pixel   = rgbArray[offset  (y-startY)*scansize  (x-startX)];
   WARNING: No dithering takes place.



   An ArrayOutOfBoundsException may be thrown
   if the region is not in bounds.
   However, explicit bounds checking is not guaranteed.

  start-x - the starting X coordinate - `int`
  start-y - the starting Y coordinate - `int`
  w - width of the region - `int`
  h - height of the region - `int`
  rgb-array - the rgb pixels - `int[]`
  offset - offset into the rgbArray - `int`
  scansize - scanline stride for the rgbArray - `int`"
  ([^java.awt.image.BufferedImage this ^Integer start-x ^Integer start-y ^Integer w ^Integer h rgb-array ^Integer offset ^Integer scansize]
    (-> this (.setRGB start-x start-y w h rgb-array offset scansize)))
  ([^java.awt.image.BufferedImage this ^Integer x ^Integer y ^Integer rgb]
    (-> this (.setRGB x y rgb))))

(defn get-graphics
  "This method returns a Graphics2D, but is here
   for backwards compatibility.  createGraphics is more
   convenient, since it is declared to return a
   Graphics2D.

  returns: a Graphics2D, which can be used to draw into
            this image. - `java.awt.Graphics`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getGraphics))))

(defn get-tile-grid-x-offset
  "Returns the x offset of the tile grid relative to the origin,
   For example, the x coordinate of the location of tile
   (0, 0).  This is always zero.

  returns: the x offset of the tile grid. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getTileGridXOffset))))

(defn to-string
  "Returns a String representation of this
   BufferedImage object and its values.

  returns: a String representing this
            BufferedImage. - `java.lang.String`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.toString))))

(defn get-min-y
  "Returns the minimum y coordinate of this
   BufferedImage.  This is always zero.

  returns: the minimum y coordinate of this
            BufferedImage. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getMinY))))

(defn add-tile-observer
  "Adds a tile observer.  If the observer is already present,
   it receives multiple notifications.

  to - the specified TileObserver - `java.awt.image.TileObserver`"
  ([^java.awt.image.BufferedImage this ^java.awt.image.TileObserver to]
    (-> this (.addTileObserver to))))

(defn copy-data
  "Computes an arbitrary rectangular region of the
   BufferedImage and copies it into a specified
   WritableRaster.  The region to be computed is
   determined from the bounds of the specified
   WritableRaster.  The specified
   WritableRaster must have a
   SampleModel that is compatible with this image.  If
   outRaster is null,
   an appropriate WritableRaster is created.

  out-raster - a WritableRaster to hold the returned part of the image, or null - `java.awt.image.WritableRaster`

  returns: a reference to the supplied or created
            WritableRaster. - `java.awt.image.WritableRaster`"
  ([^java.awt.image.BufferedImage this ^java.awt.image.WritableRaster out-raster]
    (-> this (.copyData out-raster))))

(defn get-source
  "Returns the object that produces the pixels for the image.

  returns: the ImageProducer that is used to produce the
   pixels for this image. - `java.awt.image.ImageProducer`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getSource))))

(defn has-tile-writers?
  "Returns whether or not any tile is checked out for writing.
   Semantically equivalent to


   (getWritableTileIndices() != null).

  returns: true if any tile is checked out for writing;
            false otherwise. - `boolean`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.hasTileWriters))))

(defn get-property-names
  "Returns an array of names recognized by
   getProperty(String)
   or null, if no property names are recognized.

  returns: a String array containing all of the property
            names that getProperty(String) recognizes;
            or null if no property names are recognized. - `java.lang.String[]`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getPropertyNames))))

(defn get-sample-model
  "Returns the SampleModel associated with this
   BufferedImage.

  returns: the SampleModel of this
            BufferedImage. - `java.awt.image.SampleModel`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getSampleModel))))

(defn get-tile-grid-y-offset
  "Returns the y offset of the tile grid relative to the origin,
   For example, the y coordinate of the location of tile
   (0, 0).  This is always zero.

  returns: the y offset of the tile grid. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getTileGridYOffset))))

(defn tile-writable?
  "Returns whether or not a tile is currently checked out for writing.

  tile-x - the x index of the tile. - `int`
  tile-y - the y index of the tile. - `int`

  returns: true if the tile specified by the specified
            indices is checked out for writing; false
            otherwise. - `boolean`

  throws: java.lang.ArrayIndexOutOfBoundsException - if both tileX and tileY are not equal to 0"
  ([^java.awt.image.BufferedImage this ^Integer tile-x ^Integer tile-y]
    (-> this (.isTileWritable tile-x tile-y))))

(defn get-height
  "Returns the height of the BufferedImage.

  observer - ignored - `java.awt.image.ImageObserver`

  returns: the height of this BufferedImage - `int`"
  ([^java.awt.image.BufferedImage this ^java.awt.image.ImageObserver observer]
    (-> this (.getHeight observer)))
  ([^java.awt.image.BufferedImage this]
    (-> this (.getHeight))))

(defn get-subimage
  "Returns a subimage defined by a specified rectangular region.
   The returned BufferedImage shares the same
   data array as the original image.

  x - the X coordinate of the upper-left corner of the specified rectangular region - `int`
  y - the Y coordinate of the upper-left corner of the specified rectangular region - `int`
  w - the width of the specified rectangular region - `int`
  h - the height of the specified rectangular region - `int`

  returns: a BufferedImage that is the subimage of this
            BufferedImage. - `java.awt.image.BufferedImage`

  throws: java.awt.image.RasterFormatException - if the specified area is not contained within this BufferedImage."
  ([^java.awt.image.BufferedImage this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.getSubimage x y w h))))

(defn get-property
  "Returns a property of the image by name.  Individual property names
   are defined by the various image formats.  If a property is not
   defined for a particular image, this method returns the
   UndefinedProperty field.  If the properties
   for this image are not yet known, then this method returns
   null and the ImageObserver object is
   notified later.  The property name `comment` should be used to
   store an optional comment that can be presented to the user as a
   description of the image, its source, or its author.

  name - the property name - `java.lang.String`
  observer - the ImageObserver that receives notification regarding image information - `java.awt.image.ImageObserver`

  returns: an Object that is the property referred to by the
            specified name or null if the
            properties of this image are not yet known. - `java.lang.Object`

  throws: java.lang.NullPointerException - if the property name is null."
  ([^java.awt.image.BufferedImage this ^java.lang.String name ^java.awt.image.ImageObserver observer]
    (-> this (.getProperty name observer)))
  ([^java.awt.image.BufferedImage this ^java.lang.String name]
    (-> this (.getProperty name))))

(defn remove-tile-observer
  "Removes a tile observer.  If the observer was not registered,
   nothing happens.  If the observer was registered for multiple
   notifications, it is now registered for one fewer notification.

  to - the specified TileObserver. - `java.awt.image.TileObserver`"
  ([^java.awt.image.BufferedImage this ^java.awt.image.TileObserver to]
    (-> this (.removeTileObserver to))))

(defn coerce-data
  "Forces the data to match the state specified in the
   isAlphaPremultiplied variable.  It may multiply or
   divide the color raster data by alpha, or do nothing if the data is
   in the correct state.

  is-alpha-premultiplied - true if the alpha has been premultiplied; false otherwise. - `boolean`"
  ([^java.awt.image.BufferedImage this ^Boolean is-alpha-premultiplied]
    (-> this (.coerceData is-alpha-premultiplied))))

(defn get-raster
  "Returns the WritableRaster.

  returns: the WriteableRaster of this
    BufferedImage. - `java.awt.image.WritableRaster`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getRaster))))

(defn get-tile-height
  "Returns the tile height in pixels.

  returns: the tile height in pixels. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getTileHeight))))

(defn create-graphics
  "Creates a Graphics2D, which can be used to draw into
   this BufferedImage.

  returns: a Graphics2D, used for drawing into this
            image. - `java.awt.Graphics2D`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.createGraphics))))

(defn get-num-x-tiles
  "Returns the number of tiles in the x direction.
   This is always one.

  returns: the number of tiles in the x direction. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getNumXTiles))))

(defn get-writable-tile
  "Checks out a tile for writing.  All registered
   TileObservers are notified when a tile goes from having
   no writers to having one writer.

  tile-x - the x index of the tile - `int`
  tile-y - the y index of the tile - `int`

  returns: a WritableRaster that is the tile, indicated by
              the specified indices, to be checked out for writing. - `java.awt.image.WritableRaster`"
  ([^java.awt.image.BufferedImage this ^Integer tile-x ^Integer tile-y]
    (-> this (.getWritableTile tile-x tile-y))))

(defn get-min-x
  "Returns the minimum x coordinate of this
   BufferedImage.  This is always zero.

  returns: the minimum x coordinate of this
            BufferedImage. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getMinX))))

(defn get-tile-width
  "Returns the tile width in pixels.

  returns: the tile width in pixels. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getTileWidth))))

(defn release-writable-tile
  "Relinquishes permission to write to a tile.  If the caller
   continues to write to the tile, the results are undefined.
   Calls to this method should only appear in matching pairs
   with calls to getWritableTile(int, int).  Any other leads
   to undefined results.  All registered TileObservers
   are notified when a tile goes from having one writer to having no
   writers.

  tile-x - the x index of the tile - `int`
  tile-y - the y index of the tile - `int`"
  ([^java.awt.image.BufferedImage this ^Integer tile-x ^Integer tile-y]
    (-> this (.releaseWritableTile tile-x tile-y))))

(defn get-sources
  "Returns a Vector of RenderedImage objects that are
   the immediate sources, not the sources of these immediate sources,
   of image data for this BufferedImage.  This
   method returns null if the BufferedImage
   has no information about its immediate sources.  It returns an
   empty Vector if the BufferedImage has no
   immediate sources.

  returns: a Vector containing immediate sources of
            this BufferedImage object's image date, or
            null if this BufferedImage has
            no information about its immediate sources, or an empty
            Vector if this BufferedImage
            has no immediate sources. - `java.util.Vector<java.awt.image.RenderedImage>`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getSources))))

(defn get-num-y-tiles
  "Returns the number of tiles in the y direction.
   This is always one.

  returns: the number of tiles in the y direction. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getNumYTiles))))

(defn get-color-model
  "Returns the ColorModel.

  returns: the ColorModel of this
    BufferedImage. - `java.awt.image.ColorModel`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getColorModel))))

(defn alpha-premultiplied?
  "Returns whether or not the alpha has been premultiplied.  It
   returns false if there is no alpha.

  returns: true if the alpha has been premultiplied;
            false otherwise. - `boolean`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.isAlphaPremultiplied))))

(defn get-min-tile-x
  "Returns the minimum tile index in the x direction.
   This is always zero.

  returns: the minimum tile index in the x direction. - `int`"
  ([^java.awt.image.BufferedImage this]
    (-> this (.getMinTileX))))

