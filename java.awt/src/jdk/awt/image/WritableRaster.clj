(ns jdk.awt.image.WritableRaster
  "This class extends Raster to provide pixel writing capabilities.
  Refer to the class comment for Raster for descriptions of how
  a Raster stores pixels.

   The constructors of this class are protected.  To instantiate
  a WritableRaster, use one of the createWritableRaster factory methods
  in the Raster class."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image WritableRaster]))

(defn set-rect
  "Copies pixels from Raster srcRaster to this WritableRaster.
   For each (x, y) address in srcRaster, the corresponding pixel
   is copied to address (x+dx, y+dy) in this WritableRaster,
   unless (x+dx, y+dy) falls outside the bounds of this raster.
   srcRaster must have the same number of bands as this WritableRaster.
   The copy is a simple copy of source samples to the corresponding
   destination samples.  For details, see
   setRect(Raster).

  dx - The X translation factor from src space to dst space of the copy. - `int`
  dy - The Y translation factor from src space to dst space of the copy. - `int`
  src-raster - The Raster from which to copy pixels. - `java.awt.image.Raster`

  throws: java.lang.NullPointerException - if srcRaster is null."
  ([this dx dy src-raster]
    (-> this (.setRect dx dy src-raster)))
  ([this src-raster]
    (-> this (.setRect src-raster))))

(defn get-writable-parent
  "Returns the parent WritableRaster (if any) of this WritableRaster,
    or else null.

  returns: the parent of this WritableRaster, or
            null. - `java.awt.image.WritableRaster`"
  ([this]
    (-> this (.getWritableParent))))

(defn set-pixels
  "Sets all samples for a rectangle of pixels from an int array containing
   one sample per array element.
   An ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.
   However, explicit bounds checking is not guaranteed.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - Width of the pixel rectangle. - `int`
  h - Height of the pixel rectangle. - `int`
  i-array - The input int pixel array. - `int[]`

  throws: java.lang.NullPointerException - if iArray is null."
  ([this x y w h i-array]
    (-> this (.setPixels x y w h i-array))))

(defn set-sample
  "Sets a sample in the specified band for the pixel located at (x,y)
   in the DataBuffer using an int for input.
   An ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.
   However, explicit bounds checking is not guaranteed.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  b - The band to set. - `int`
  s - The input sample. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates or the band index are not in bounds."
  ([this x y b s]
    (-> this (.setSample x y b s))))

(defn set-pixel
  "Sets a pixel in the DataBuffer using an int array of samples for input.
   An ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.
   However, explicit bounds checking is not guaranteed.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  i-array - The input samples in a int array. - `int[]`

  throws: java.lang.NullPointerException - if iArray is null."
  ([this x y i-array]
    (-> this (.setPixel x y i-array))))

(defn set-data-elements
  "Sets the data for a rectangle of pixels from a
   primitive array of type TransferType.  For image data supported by
   the Java 2D API, this will be one of DataBuffer.TYPE_BYTE,
   DataBuffer.TYPE_USHORT, DataBuffer.TYPE_INT, DataBuffer.TYPE_SHORT,
   DataBuffer.TYPE_FLOAT, or DataBuffer.TYPE_DOUBLE.  Data in the array
   may be in a packed format, thus increasing efficiency for data
   transfers.
   An ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if inData is not large enough to hold the pixel data.
   However, explicit bounds checking is not guaranteed.
   A ClassCastException will be thrown if the input object is not null
   and references anything other than an array of TransferType.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - Width of the pixel rectangle. - `int`
  h - Height of the pixel rectangle. - `int`
  in-data - An object reference to an array of type defined by getTransferType() and length w*h*getNumDataElements() containing the pixel data to place between x,y and x+w-1, y+h-1. - `java.lang.Object`

  throws: java.lang.NullPointerException - if inData is null."
  ([this x y w h in-data]
    (-> this (.setDataElements x y w h in-data)))
  ([this x y in-data]
    (-> this (.setDataElements x y in-data))))

(defn set-samples
  "Sets the samples in the specified band for the specified rectangle
   of pixels from an int array containing one sample per array element.
   An ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.
   However, explicit bounds checking is not guaranteed.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - Width of the pixel rectangle. - `int`
  h - Height of the pixel rectangle. - `int`
  b - The band to set. - `int`
  i-array - The input int sample array. - `int[]`

  throws: java.lang.NullPointerException - if iArray is null."
  ([this x y w h b i-array]
    (-> this (.setSamples x y w h b i-array))))

(defn create-writable-translated-child
  "Create a WritableRaster with the same size, SampleModel and DataBuffer
   as this one, but with a different location.  The new WritableRaster
   will possess a reference to the current WritableRaster, accessible
   through its getParent() and getWritableParent() methods.

  child-min-x - X coord of the upper left corner of the new Raster. - `int`
  child-min-y - Y coord of the upper left corner of the new Raster. - `int`

  returns: a WritableRaster the same as this one except
           for the specified location. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if computing either childMinX this.getWidth() or childMinY this.getHeight() results in integer overflow"
  ([this child-min-x child-min-y]
    (-> this (.createWritableTranslatedChild child-min-x child-min-y))))

(defn create-writable-child
  "Returns a new WritableRaster which shares all or part of this
   WritableRaster's DataBuffer.  The new WritableRaster will
   possess a reference to the current WritableRaster, accessible
   through its getParent() and getWritableParent() methods.

    The parentX, parentY, width and height parameters form a
   Rectangle in this WritableRaster's coordinate space, indicating
   the area of pixels to be shared.  An error will be thrown if
   this Rectangle is not contained with the bounds of the current
   WritableRaster.

    The new WritableRaster may additionally be translated to a
   different coordinate system for the plane than that used by the current
   WritableRaster.  The childMinX and childMinY parameters give
   the new (x, y) coordinate of the upper-left pixel of the
   returned WritableRaster; the coordinate (childMinX, childMinY)
   in the new WritableRaster will map to the same pixel as the
   coordinate (parentX, parentY) in the current WritableRaster.

    The new WritableRaster may be defined to contain only a
   subset of the bands of the current WritableRaster, possibly
   reordered, by means of the bandList parameter.  If bandList is
   null, it is taken to include all of the bands of the current
   WritableRaster in their current order.

    To create a new WritableRaster that contains a subregion of
   the current WritableRaster, but shares its coordinate system
   and bands, this method should be called with childMinX equal to
   parentX, childMinY equal to parentY, and bandList equal to
   null.

  parent-x - X coordinate of the upper left corner in this WritableRaster's coordinates. - `int`
  parent-y - Y coordinate of the upper left corner in this WritableRaster's coordinates. - `int`
  w - Width of the region starting at (parentX, parentY). - `int`
  h - Height of the region starting at (parentX, parentY). - `int`
  child-min-x - X coordinate of the upper left corner of the returned WritableRaster. - `int`
  child-min-y - Y coordinate of the upper left corner of the returned WritableRaster. - `int`
  band-list - Array of band indices, or null to use all bands. - `int[]`

  returns: a WritableRaster sharing all or part of the
           DataBuffer of this WritableRaster. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if w or h is less than or equal to zero, or computing any of parentX w, parentY h, childMinX w, or childMinY h results in integer overflow"
  ([this parent-x parent-y w h child-min-x child-min-y band-list]
    (-> this (.createWritableChild parent-x parent-y w h child-min-x child-min-y band-list))))

