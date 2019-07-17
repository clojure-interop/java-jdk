(ns jdk.awt.image.Raster
  "A class representing a rectangular array of pixels.  A Raster
  encapsulates a DataBuffer that stores the sample values and a
  SampleModel that describes how to locate a given sample value in a
  DataBuffer.

  A Raster defines values for pixels occupying a particular
  rectangular area of the plane, not necessarily including (0, 0).
  The rectangle, known as the Raster's bounding rectangle and
  available by means of the getBounds method, is defined by minX,
  minY, width, and height values.  The minX and minY values define
  the coordinate of the upper left corner of the Raster.  References
  to pixels outside of the bounding rectangle may result in an
  exception being thrown, or may result in references to unintended
  elements of the Raster's associated DataBuffer.  It is the user's
  responsibility to avoid accessing such pixels.

  A SampleModel describes how samples of a Raster
  are stored in the primitive array elements of a DataBuffer.
  Samples may be stored one per data element, as in a
  PixelInterleavedSampleModel or BandedSampleModel, or packed several to
  an element, as in a SinglePixelPackedSampleModel or
  MultiPixelPackedSampleModel.  The SampleModel is also
  controls whether samples are sign extended, allowing unsigned
  data to be stored in signed Java data types such as byte, short, and
  int.

  Although a Raster may live anywhere in the plane, a SampleModel
  makes use of a simple coordinate system that starts at (0, 0).  A
  Raster therefore contains a translation factor that allows pixel
  locations to be mapped between the Raster's coordinate system and
  that of the SampleModel.  The translation from the SampleModel
  coordinate system to that of the Raster may be obtained by the
  getSampleModelTranslateX and getSampleModelTranslateY methods.

  A Raster may share a DataBuffer with another Raster either by
  explicit construction or by the use of the createChild and
  createTranslatedChild methods.  Rasters created by these methods
  can return a reference to the Raster they were created from by
  means of the getParent method.  For a Raster that was not
  constructed by means of a call to createTranslatedChild or
  createChild, getParent will return null.

  The createTranslatedChild method returns a new Raster that
  shares all of the data of the current Raster, but occupies a
  bounding rectangle of the same width and height but with a
  different starting point.  For example, if the parent Raster
  occupied the region (10, 10) to (100, 100), and the translated
  Raster was defined to start at (50, 50), then pixel (20, 20) of the
  parent and pixel (60, 60) of the child occupy the same location in
  the DataBuffer shared by the two Rasters.  In the first case, (-10,
  -10) should be added to a pixel coordinate to obtain the
  corresponding SampleModel coordinate, and in the second case (-50,
  -50) should be added.

  The translation between a parent and child Raster may be
  determined by subtracting the child's sampleModelTranslateX and
  sampleModelTranslateY values from those of the parent.

  The createChild method may be used to create a new Raster
  occupying only a subset of its parent's bounding rectangle
  (with the same or a translated coordinate system) or
  with a subset of the bands of its parent.

  All constructors are protected.  The correct way to create a
  Raster is to use one of the static create methods defined in this
  class.  These methods create instances of Raster that use the
  standard Interleaved, Banded, and Packed SampleModels and that may
  be processed more efficiently than a Raster created by combining
  an externally generated SampleModel and DataBuffer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image Raster]))

(defn *create-interleaved-raster
  "Creates a Raster based on a PixelInterleavedSampleModel with the
   specified data type, width, height, scanline stride, pixel
   stride, and band offsets.  The number of bands is inferred from
   bandOffsets.length.

    The upper left corner of the Raster is given by the
   location argument.  If location is null, (0, 0) will be used.
   The dataType parameter should be one of the enumerated values
   defined in the DataBuffer class.

    Note that interleaved DataBuffer.TYPE_INT
   Rasters are not supported.  To create a 1-band Raster of type
   DataBuffer.TYPE_INT, use
   Raster.createPackedRaster().
    The only dataTypes supported currently are TYPE_BYTE
   and TYPE_USHORT.

  data-type - the data type for storing samples - `int`
  w - the width in pixels of the image data - `int`
  h - the height in pixels of the image data - `int`
  scanline-stride - the line stride of the image data - `int`
  pixel-stride - the pixel stride of the image data - `int`
  band-offsets - the offsets of all bands - `int[]`
  location - the upper-left corner of the Raster - `java.awt.Point`

  returns: a WritableRaster object with the specified data type,
           width, height, scanline stride, pixel stride and band
           offsets. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if w or h is less than or equal to zero, or computing either location.x w or location.y h results in integer overflow"
  (^java.awt.image.WritableRaster [^Integer data-type ^Integer w ^Integer h ^Integer scanline-stride ^Integer pixel-stride band-offsets ^java.awt.Point location]
    (Raster/createInterleavedRaster data-type w h scanline-stride pixel-stride band-offsets location))
  (^java.awt.image.WritableRaster [^Integer data-type ^Integer w ^Integer h ^Integer bands ^java.awt.Point location]
    (Raster/createInterleavedRaster data-type w h bands location)))

(defn *create-banded-raster
  "Creates a Raster based on a BandedSampleModel with the
   specified data type, width, height, scanline stride, bank
   indices and band offsets.  The number of bands is inferred from
   bankIndices.length and bandOffsets.length, which must be the
   same.

    The upper left corner of the Raster is given by the
   location argument.  The dataType parameter should be one of the
   enumerated values defined in the DataBuffer class.

    The only dataTypes supported currently are TYPE_BYTE, TYPE_USHORT,
   and TYPE_INT.

  data-type - the data type for storing samples - `int`
  w - the width in pixels of the image data - `int`
  h - the height in pixels of the image data - `int`
  scanline-stride - the line stride of the image data - `int`
  bank-indices - the bank indices for each band - `int[]`
  band-offsets - the offsets of all bands - `int[]`
  location - the upper-left corner of the Raster - `java.awt.Point`

  returns: a WritableRaster object with the specified data type,
           width, height, scanline stride, bank indices and band
           offsets. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if w or h is less than or equal to zero, or computing either location.x w or location.y h results in integer overflow"
  (^java.awt.image.WritableRaster [^Integer data-type ^Integer w ^Integer h ^Integer scanline-stride bank-indices band-offsets ^java.awt.Point location]
    (Raster/createBandedRaster data-type w h scanline-stride bank-indices band-offsets location))
  (^java.awt.image.WritableRaster [^Integer data-type ^Integer w ^Integer h ^Integer bands ^java.awt.Point location]
    (Raster/createBandedRaster data-type w h bands location)))

(defn *create-packed-raster
  "Creates a Raster based on a packed SampleModel with the
   specified data type, width, height, number of bands, and bits
   per band.  If the number of bands is one, the SampleModel will
   be a MultiPixelPackedSampleModel.

    If the number of bands is more than one, the SampleModel
   will be a SinglePixelPackedSampleModel, with each band having
   bitsPerBand bits.  In either case, the requirements on dataType
   and bitsPerBand imposed by the corresponding SampleModel must
   be met.

    The upper left corner of the Raster is given by the
   location argument.  If location is null, (0, 0) will be used.
   The dataType parameter should be one of the enumerated values
   defined in the DataBuffer class.

    The only dataTypes supported currently are TYPE_BYTE, TYPE_USHORT,
   and TYPE_INT.

  data-type - the data type for storing samples - `int`
  w - the width in pixels of the image data - `int`
  h - the height in pixels of the image data - `int`
  bands - the number of bands - `int`
  bits-per-band - the number of bits per band - `int`
  location - the upper-left corner of the Raster - `java.awt.Point`

  returns: a WritableRaster object with the specified data type,
           width, height, number of bands, and bits per band. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if w or h is less than or equal to zero, or computing either location.x w or location.y h results in integer overflow"
  (^java.awt.image.WritableRaster [^Integer data-type ^Integer w ^Integer h ^Integer bands ^Integer bits-per-band ^java.awt.Point location]
    (Raster/createPackedRaster data-type w h bands bits-per-band location))
  (^java.awt.image.WritableRaster [^Integer data-type ^Integer w ^Integer h band-masks ^java.awt.Point location]
    (Raster/createPackedRaster data-type w h band-masks location)))

(defn *create-raster
  "Creates a Raster with the specified SampleModel and DataBuffer.
    The upper left corner of the Raster is given by the location argument.
    If location is null, (0, 0) will be used.

  sm - the specified SampleModel - `java.awt.image.SampleModel`
  db - the specified DataBuffer - `java.awt.image.DataBuffer`
  location - the upper-left corner of the Raster - `java.awt.Point`

  returns: a Raster with the specified
            SampleModel, DataBuffer, and
            location. - `java.awt.image.Raster`

  throws: java.awt.image.RasterFormatException - if db has more than one bank and sm is a PixelInterleavedSampleModel, SinglePixelPackedSampleModel, or MultiPixelPackedSampleModel."
  (^java.awt.image.Raster [^java.awt.image.SampleModel sm ^java.awt.image.DataBuffer db ^java.awt.Point location]
    (Raster/createRaster sm db location)))

(defn *create-writable-raster
  "Creates a WritableRaster with the specified SampleModel and DataBuffer.
    The upper left corner of the Raster is given by the location argument.
    If location is null, (0, 0) will be used.

  sm - the specified SampleModel - `java.awt.image.SampleModel`
  db - the specified DataBuffer - `java.awt.image.DataBuffer`
  location - the upper-left corner of the WritableRaster - `java.awt.Point`

  returns: a WritableRaster with the specified
            SampleModel, DataBuffer, and
            location. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if db has more than one bank and sm is a PixelInterleavedSampleModel, SinglePixelPackedSampleModel, or MultiPixelPackedSampleModel."
  (^java.awt.image.WritableRaster [^java.awt.image.SampleModel sm ^java.awt.image.DataBuffer db ^java.awt.Point location]
    (Raster/createWritableRaster sm db location))
  (^java.awt.image.WritableRaster [^java.awt.image.SampleModel sm ^java.awt.Point location]
    (Raster/createWritableRaster sm location)))

(defn get-width
  "Returns the width in pixels of the Raster.

  returns: the width of this Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getWidth))))

(defn get-sample-float
  "Returns the sample in a specified band
   for the pixel located at (x,y) as a float.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`

  returns: the sample in the specified band for the pixel at the
           specified coordinate. - `float`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates or the band index are not in bounds."
  (^Float [^java.awt.image.Raster this ^Integer x ^Integer y ^Integer b]
    (-> this (.getSampleFloat x y b))))

(defn get-sample-model-translate-x
  "Returns the X translation from the coordinate system of the
   SampleModel to that of the Raster.  To convert a pixel's X
   coordinate from the Raster coordinate system to the SampleModel
   coordinate system, this value must be subtracted.

  returns: the X translation from the coordinate space of the
           Raster's SampleModel to that of the Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getSampleModelTranslateX))))

(defn get-transfer-type
  "Returns the TransferType used to transfer pixels via the
    getDataElements and setDataElements methods.  When pixels
    are transferred via these methods, they may be transferred in a
    packed or unpacked format, depending on the implementation of the
    underlying SampleModel.  Using these methods, pixels are transferred
    as an array of getNumDataElements() elements of a primitive type given
    by getTransferType().  The TransferType may or may not be the same
    as the storage data type of the DataBuffer.  The TransferType will
    be one of the types defined in DataBuffer.

  returns: this transfer type. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getTransferType))))

(defn get-data-elements
  "Returns the pixel data for the specified rectangle of pixels in a
   primitive array of type TransferType.
   For image data supported by the Java 2D API, this
   will be one of DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
   DataBuffer.TYPE_INT, DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT,
   or DataBuffer.TYPE_DOUBLE.  Data may be returned in a packed format,
   thus increasing efficiency for data transfers.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.
   A ClassCastException will be thrown if the input object is non null
   and references anything other than an array of TransferType.

  x - The X coordinate of the upper-left pixel location - `int`
  y - The Y coordinate of the upper-left pixel location - `int`
  w - Width of the pixel rectangle - `int`
  h - Height of the pixel rectangle - `int`
  out-data - An object reference to an array of type defined by getTransferType() and length w*h*getNumDataElements(). If null, an array of appropriate type and size will be allocated. - `java.lang.Object`

  returns: An object reference to an array of type defined by
                   getTransferType() with the requested pixel data. - `java.lang.Object`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates are not in bounds, or if outData is too small to hold the output."
  (^java.lang.Object [^java.awt.image.Raster this ^Integer x ^Integer y ^Integer w ^Integer h ^java.lang.Object out-data]
    (-> this (.getDataElements x y w h out-data)))
  (^java.lang.Object [^java.awt.image.Raster this ^Integer x ^Integer y ^java.lang.Object out-data]
    (-> this (.getDataElements x y out-data))))

(defn create-child
  "Returns a new Raster which shares all or part of this Raster's
   DataBuffer.  The new Raster will possess a reference to the
   current Raster, accessible through its getParent() method.

    The parentX, parentY, width and height parameters
   form a Rectangle in this Raster's coordinate space,
   indicating the area of pixels to be shared.  An error will
   be thrown if this Rectangle is not contained with the bounds
   of the current Raster.

    The new Raster may additionally be translated to a
   different coordinate system for the plane than that used by the current
   Raster.  The childMinX and childMinY parameters give the new
   (x, y) coordinate of the upper-left pixel of the returned
   Raster; the coordinate (childMinX, childMinY) in the new Raster
   will map to the same pixel as the coordinate (parentX, parentY)
   in the current Raster.

    The new Raster may be defined to contain only a subset of
   the bands of the current Raster, possibly reordered, by means
   of the bandList parameter.  If bandList is null, it is taken to
   include all of the bands of the current Raster in their current
   order.

    To create a new Raster that contains a subregion of the current
   Raster, but shares its coordinate system and bands,
   this method should be called with childMinX equal to parentX,
   childMinY equal to parentY, and bandList equal to null.

  parent-x - The X coordinate of the upper-left corner in this Raster's coordinates - `int`
  parent-y - The Y coordinate of the upper-left corner in this Raster's coordinates - `int`
  width - Width of the region starting at (parentX, parentY) - `int`
  height - Height of the region starting at (parentX, parentY). - `int`
  child-min-x - The X coordinate of the upper-left corner of the returned Raster - `int`
  child-min-y - The Y coordinate of the upper-left corner of the returned Raster - `int`
  band-list - Array of band indices, or null to use all bands - `int[]`

  returns: a new Raster. - `java.awt.image.Raster`

  throws: java.awt.image.RasterFormatException - if width or height is less than or equal to zero, or computing any of parentX width, parentY height, childMinX width, or childMinY height results in integer overflow"
  (^java.awt.image.Raster [^java.awt.image.Raster this ^Integer parent-x ^Integer parent-y ^Integer width ^Integer height ^Integer child-min-x ^Integer child-min-y band-list]
    (-> this (.createChild parent-x parent-y width height child-min-x child-min-y band-list))))

(defn get-num-bands
  "Returns the number of bands (samples per pixel) in this Raster.

  returns: the number of bands of this Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getNumBands))))

(defn get-pixels
  "Returns an int array containing all samples for a rectangle of pixels,
   one sample per array element.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.

  x - The X coordinate of the upper-left pixel location - `int`
  y - The Y coordinate of the upper-left pixel location - `int`
  w - Width of the pixel rectangle - `int`
  h - Height of the pixel rectangle - `int`
  i-array - An optionally pre-allocated int array - `int[]`

  returns: the samples for the specified rectangle of pixels. - `int[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates are not in bounds, or if iArray is too small to hold the output."
  ([^java.awt.image.Raster this ^Integer x ^Integer y ^Integer w ^Integer h i-array]
    (-> this (.getPixels x y w h i-array))))

(defn get-min-y
  "Returns the minimum valid Y coordinate of the Raster.

  returns: the minimum y coordinate of this Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getMinY))))

(defn get-sample-double
  "Returns the sample in a specified band
   for a pixel located at (x,y) as a double.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`

  returns: the sample in the specified band for the pixel at the
           specified coordinate. - `double`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates or the band index are not in bounds."
  (^Double [^java.awt.image.Raster this ^Integer x ^Integer y ^Integer b]
    (-> this (.getSampleDouble x y b))))

(defn get-num-data-elements
  "Returns the number of data elements needed to transfer one pixel
    via the getDataElements and setDataElements methods.  When pixels
    are transferred via these methods, they may be transferred in a
    packed or unpacked format, depending on the implementation of the
    underlying SampleModel.  Using these methods, pixels are transferred
    as an array of getNumDataElements() elements of a primitive type given
    by getTransferType().  The TransferType may or may not be the same
    as the storage data type of the DataBuffer.

  returns: the number of data elements. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getNumDataElements))))

(defn get-data-buffer
  "Returns the DataBuffer associated with this Raster.

  returns: the DataBuffer of this Raster. - `java.awt.image.DataBuffer`"
  (^java.awt.image.DataBuffer [^java.awt.image.Raster this]
    (-> this (.getDataBuffer))))

(defn create-translated-child
  "Create a Raster with the same size, SampleModel and DataBuffer
   as this one, but with a different location.  The new Raster
   will possess a reference to the current Raster, accessible
   through its getParent() method.

  child-min-x - the X coordinate of the upper-left corner of the new Raster - `int`
  child-min-y - the Y coordinate of the upper-left corner of the new Raster - `int`

  returns: a new Raster with the same size, SampleModel,
           and DataBuffer as this Raster, but with the
           specified location. - `java.awt.image.Raster`

  throws: java.awt.image.RasterFormatException - if computing either childMinX this.getWidth() or childMinY this.getHeight() results in integer overflow"
  (^java.awt.image.Raster [^java.awt.image.Raster this ^Integer child-min-x ^Integer child-min-y]
    (-> this (.createTranslatedChild child-min-x child-min-y))))

(defn get-parent
  "Returns the parent Raster (if any) of this Raster or null.

  returns: the parent Raster or null. - `java.awt.image.Raster`"
  (^java.awt.image.Raster [^java.awt.image.Raster this]
    (-> this (.getParent))))

(defn get-sample
  "Returns the sample in a specified band for the pixel located
   at (x,y) as an int.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`

  returns: the sample in the specified band for the pixel at the
           specified coordinate. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates or the band index are not in bounds."
  (^Integer [^java.awt.image.Raster this ^Integer x ^Integer y ^Integer b]
    (-> this (.getSample x y b))))

(defn get-sample-model
  "Returns the SampleModel that describes the layout of the image data.

  returns: the SampleModel of this Raster. - `java.awt.image.SampleModel`"
  (^java.awt.image.SampleModel [^java.awt.image.Raster this]
    (-> this (.getSampleModel))))

(defn get-sample-model-translate-y
  "Returns the Y translation from the coordinate system of the
   SampleModel to that of the Raster.  To convert a pixel's Y
   coordinate from the Raster coordinate system to the SampleModel
   coordinate system, this value must be subtracted.

  returns: the Y translation from the coordinate space of the
           Raster's SampleModel to that of the Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getSampleModelTranslateY))))

(defn get-height
  "Returns the height in pixels of the Raster.

  returns: the height of this Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getHeight))))

(defn get-pixel
  "Returns the samples in an array of int for the specified pixel.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  i-array - An optionally preallocated int array - `int[]`

  returns: the samples for the specified pixel. - `int[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates are not in bounds, or if iArray is too small to hold the output."
  ([^java.awt.image.Raster this ^Integer x ^Integer y i-array]
    (-> this (.getPixel x y i-array))))

(defn create-compatible-writable-raster
  "Create a compatible WritableRaster with the specified
   location (minX, minY) and size (width, height), a
   new SampleModel, and a new initialized DataBuffer.

  x - the X coordinate of the upper-left corner of the WritableRaster - `int`
  y - the Y coordinate of the upper-left corner of the WritableRaster - `int`
  w - the specified width of the WritableRaster - `int`
  h - the specified height of the WritableRaster - `int`

  returns: a compatible WritableRaster with the specified
           size and location and a new sample model and data buffer. - `java.awt.image.WritableRaster`

  throws: java.awt.image.RasterFormatException - if w or h is less than or equal to zero, or computing either x w or y h results in integer overflow"
  (^java.awt.image.WritableRaster [^java.awt.image.Raster this ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.createCompatibleWritableRaster x y w h)))
  (^java.awt.image.WritableRaster [^java.awt.image.Raster this ^Integer w ^Integer h]
    (-> this (.createCompatibleWritableRaster w h)))
  (^java.awt.image.WritableRaster [^java.awt.image.Raster this ^java.awt.Rectangle rect]
    (-> this (.createCompatibleWritableRaster rect)))
  (^java.awt.image.WritableRaster [^java.awt.image.Raster this]
    (-> this (.createCompatibleWritableRaster))))

(defn get-bounds
  "Returns the bounding Rectangle of this Raster. This function returns
   the same information as getMinX/MinY/Width/Height.

  returns: the bounding box of this Raster. - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^java.awt.image.Raster this]
    (-> this (.getBounds))))

(defn get-min-x
  "Returns the minimum valid X coordinate of the Raster.

  returns: the minimum x coordinate of this Raster. - `int`"
  (^Integer [^java.awt.image.Raster this]
    (-> this (.getMinX))))

(defn get-samples
  "Returns the samples for a specified band for the specified rectangle
   of pixels in an int array, one sample per array element.
   An ArrayIndexOutOfBoundsException may be thrown
   if the coordinates are not in bounds.  However, explicit bounds
   checking is not guaranteed.

  x - The X coordinate of the upper-left pixel location - `int`
  y - The Y coordinate of the upper-left pixel location - `int`
  w - Width of the pixel rectangle - `int`
  h - Height of the pixel rectangle - `int`
  b - The band to return - `int`
  i-array - An optionally pre-allocated int array - `int[]`

  returns: the samples for the specified band for the specified
           rectangle of pixels. - `int[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates or the band index are not in bounds, or if iArray is too small to hold the output."
  ([^java.awt.image.Raster this ^Integer x ^Integer y ^Integer w ^Integer h ^Integer b i-array]
    (-> this (.getSamples x y w h b i-array))))

