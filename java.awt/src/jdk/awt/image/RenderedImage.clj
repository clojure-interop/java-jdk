(ns jdk.awt.image.RenderedImage
  "RenderedImage is a common interface for objects which contain
  or can produce image data in the form of Rasters.  The image
  data may be stored/produced as a single tile or a regular array
  of tiles."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image RenderedImage]))

(defn get-min-tile-y
  "Returns the minimum tile index in the Y direction.

  returns: the minimum tile index in the X direction. - `int`"
  ([this]
    (-> this (.getMinTileY))))

(defn get-width
  "Returns the width of the RenderedImage.

  returns: the width of this RenderedImage. - `int`"
  ([this]
    (-> this (.getWidth))))

(defn get-data
  "Computes and returns an arbitrary region of the RenderedImage.
   The Raster returned is a copy of the image data and will not
   be updated if the image is changed.

  rect - the region of the RenderedImage to be returned. - `java.awt.Rectangle`

  returns: the region of the RenderedImage
   indicated by the specified Rectangle. - `java.awt.image.Raster`"
  ([this rect]
    (-> this (.getData rect)))
  ([this]
    (-> this (.getData))))

(defn get-tile
  "Returns tile (tileX, tileY).  Note that tileX and tileY are indices
   into the tile array, not pixel locations.  The Raster that is returned
   is live and will be updated if the image is changed.

  tile-x - the X index of the requested tile in the tile array - `int`
  tile-y - the Y index of the requested tile in the tile array - `int`

  returns: the tile given the specified indices. - `java.awt.image.Raster`"
  ([this tile-x tile-y]
    (-> this (.getTile tile-x tile-y))))

(defn get-tile-grid-x-offset
  "Returns the X offset of the tile grid relative to the origin,
   i.e., the X coordinate of the upper-left pixel of tile (0, 0).
   (Note that tile (0, 0) may not actually exist.)

  returns: the X offset of the tile grid relative to the origin. - `int`"
  ([this]
    (-> this (.getTileGridXOffset))))

(defn get-min-y
  "Returns the minimum Y coordinate (inclusive) of the RenderedImage.

  returns: the Y coordinate of this RenderedImage. - `int`"
  ([this]
    (-> this (.getMinY))))

(defn copy-data
  "Computes an arbitrary rectangular region of the RenderedImage
   and copies it into a caller-supplied WritableRaster.  The region
   to be computed is determined from the bounds of the supplied
   WritableRaster.  The supplied WritableRaster must have a
   SampleModel that is compatible with this image.  If raster is null,
   an appropriate WritableRaster is created.

  raster - a WritableRaster to hold the returned portion of the image, or null. - `java.awt.image.WritableRaster`

  returns: a reference to the supplied or created WritableRaster. - `java.awt.image.WritableRaster`"
  ([this raster]
    (-> this (.copyData raster))))

(defn get-property-names
  "Returns an array of names recognized by
   getProperty(String)
   or null, if no property names are recognized.

  returns: a String array containing all of the
   property names that getProperty(String) recognizes;
   or null if no property names are recognized. - `java.lang.String[]`"
  ([this]
    (-> this (.getPropertyNames))))

(defn get-sample-model
  "Returns the SampleModel associated with this image.  All Rasters
   returned from this image will have this as their SampleModel.

  returns: the SampleModel of this image. - `java.awt.image.SampleModel`"
  ([this]
    (-> this (.getSampleModel))))

(defn get-tile-grid-y-offset
  "Returns the Y offset of the tile grid relative to the origin,
   i.e., the Y coordinate of the upper-left pixel of tile (0, 0).
   (Note that tile (0, 0) may not actually exist.)

  returns: the Y offset of the tile grid relative to the origin. - `int`"
  ([this]
    (-> this (.getTileGridYOffset))))

(defn get-height
  "Returns the height of the RenderedImage.

  returns: the height of this RenderedImage. - `int`"
  ([this]
    (-> this (.getHeight))))

(defn get-property
  "Gets a property from the property set of this image.  The set of
   properties and whether it is immutable is determined by the
   implementing class.  This method returns
   java.awt.Image.UndefinedProperty if the specified property is
   not defined for this RenderedImage.

  name - the name of the property - `java.lang.String`

  returns: the property indicated by the specified name. - `java.lang.Object`"
  ([this name]
    (-> this (.getProperty name))))

(defn get-tile-height
  "Returns the tile height in pixels.  All tiles must have the same
    height.

  returns: the tile height in pixels. - `int`"
  ([this]
    (-> this (.getTileHeight))))

(defn get-num-x-tiles
  "Returns the number of tiles in the X direction.

  returns: the number of tiles in the X direction. - `int`"
  ([this]
    (-> this (.getNumXTiles))))

(defn get-min-x
  "Returns the minimum X coordinate (inclusive) of the RenderedImage.

  returns: the X coordinate of this RenderedImage. - `int`"
  ([this]
    (-> this (.getMinX))))

(defn get-tile-width
  "Returns the tile width in pixels.  All tiles must have the same
    width.

  returns: the tile width in pixels. - `int`"
  ([this]
    (-> this (.getTileWidth))))

(defn get-sources
  "Returns a vector of RenderedImages that are the immediate sources of
   image data for this RenderedImage.  This method returns null if
   the RenderedImage object has no information about its immediate
   sources.  It returns an empty Vector if the RenderedImage object has
   no immediate sources.

  returns: a Vector of RenderedImage objects. - `java.util.Vector<java.awt.image.RenderedImage>`"
  ([this]
    (-> this (.getSources))))

(defn get-num-y-tiles
  "Returns the number of tiles in the Y direction.

  returns: the number of tiles in the Y direction. - `int`"
  ([this]
    (-> this (.getNumYTiles))))

(defn get-color-model
  "Returns the ColorModel associated with this image.  All Rasters
   returned from this image will have this as their ColorModel.  This
   can return null.

  returns: the ColorModel of this image. - `java.awt.image.ColorModel`"
  ([this]
    (-> this (.getColorModel))))

(defn get-min-tile-x
  "Returns the minimum tile index in the X direction.

  returns: the minimum tile index in the X direction. - `int`"
  ([this]
    (-> this (.getMinTileX))))

