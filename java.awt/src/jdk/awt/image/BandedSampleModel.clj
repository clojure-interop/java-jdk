(ns jdk.awt.image.BandedSampleModel
  "This class represents image data which is stored in a band interleaved
   fashion and for
   which each sample of a pixel occupies one data element of the DataBuffer.
   It subclasses ComponentSampleModel but provides a more efficient
   implementation for accessing band interleaved image data than is provided
   by ComponentSampleModel.  This class should typically be used when working
   with images which store sample data for each band in a different bank of the
   DataBuffer. Accessor methods are provided so that image data can be
   manipulated directly. Pixel stride is the number of
   data array elements between two samples for the same band on the same
   scanline. The pixel stride for a BandedSampleModel is one.
   Scanline stride is the number of data array elements between
   a given sample and the corresponding sample in the same column of the next
   scanline.  Band offsets denote the number
   of data array elements from the first data array element of the bank
   of the DataBuffer holding each band to the first sample of the band.
   The bands are numbered from 0 to N-1.
   Bank indices denote the correspondence between a bank of the data buffer
   and a band of image data.  This class supports
   TYPE_BYTE,
   TYPE_USHORT,
   TYPE_SHORT,
   TYPE_INT,
   TYPE_FLOAT, and
   TYPE_DOUBLE datatypes"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image BandedSampleModel]))

(defn ->banded-sample-model
  "Constructor.

  Constructs a BandedSampleModel with the specified parameters.
   The number of bands will be inferred from the lengths of the
   bandOffsets bankIndices arrays, which must be equal.  The pixel
   stride will be one data element.

  data-type - The data type for storing samples. - `int`
  w - The width (in pixels) of the region of image data described. - `int`
  h - The height (in pixels) of the region of image data described. - `int`
  scanline-stride - The line stride of the of the image data. - `int`
  bank-indices - The bank index for each band. - `int[]`
  band-offsets - The band offset for each band. - `int[]`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the supported data types"
  (^BandedSampleModel [^Integer data-type ^Integer w ^Integer h ^Integer scanline-stride bank-indices band-offsets]
    (new BandedSampleModel data-type w h scanline-stride bank-indices band-offsets))
  (^BandedSampleModel [^Integer data-type ^Integer w ^Integer h ^Integer num-bands]
    (new BandedSampleModel data-type w h num-bands)))

(defn get-sample-float
  "Returns the sample in a specified band
   for the pixel located at (x,y) as a float.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: a float value that represents the sample in the specified
   band for the specified pixel. - `float`"
  (^Float [^BandedSampleModel this ^Integer x ^Integer y ^Integer b ^java.awt.image.DataBuffer data]
    (-> this (.getSampleFloat x y b data))))

(defn create-data-buffer
  "Creates a DataBuffer that corresponds to this BandedSampleModel,
   The DataBuffer's data type, number of banks, and size
   will be consistent with this BandedSampleModel.

  returns: a DataBuffer whose data type, number of banks
           and size are consistent with this
           ComponentSampleModel. - `java.awt.image.DataBuffer`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the supported types."
  (^java.awt.image.DataBuffer [^BandedSampleModel this]
    (-> this (.createDataBuffer))))

(defn get-data-elements
  "Returns data for a single pixel in a primitive array of type
   TransferType.  For a BandedSampleModel, this will be the same
   as the data type, and samples will be returned one per array
   element.  Generally, obj
   should be passed in as null, so that the Object will be created
   automatically and will be of the right primitive data type.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is described by
   BandedSampleModel bsm1, to DataBuffer db2,
   whose storage layout is described by
   BandedSampleModel bsm2.
   The transfer will generally be more efficient than using
   getPixel/setPixel.


         BandedSampleModel bsm1, bsm2;
         DataBufferInt db1, db2;
         bsm2.setDataElements(x, y, bsm1.getDataElements(x, y, null, db1),
                              db2);
   Using getDataElements/setDataElements to transfer between two
   DataBuffer/SampleModel pairs is legitimate if the SampleModels have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   If obj is non-null, it should be a primitive array of type TransferType.
   Otherwise, a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if obj is non-null and is not large enough to hold
   the pixel data.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  obj - If non-null, a primitive array in which to return the pixel data. - `java.lang.Object`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the data for the specified pixel. - `java.lang.Object`"
  (^java.lang.Object [^BandedSampleModel this ^Integer x ^Integer y ^java.lang.Object obj ^java.awt.image.DataBuffer data]
    (-> this (.getDataElements x y obj data))))

(defn create-subset-sample-model
  "Creates a new BandedSampleModel with a subset of the bands of this
   BandedSampleModel.  The new BandedSampleModel can be
   used with any DataBuffer that the existing BandedSampleModel
   can be used with.  The new BandedSampleModel/DataBuffer
   combination will represent an image with a subset of the bands
   of the original BandedSampleModel/DataBuffer combination.

  bands - a subset of bands from this ComponentSampleModel - `int[]`

  returns: a ComponentSampleModel created with a subset
            of bands from this ComponentSampleModel. - `java.awt.image.SampleModel`

  throws: java.awt.image.RasterFormatException - if the number of bands is greater than the number of banks in this sample model."
  (^java.awt.image.SampleModel [^BandedSampleModel this bands]
    (-> this (.createSubsetSampleModel bands))))

(defn get-pixels
  "Returns all samples for the specified rectangle of pixels in
   an int array, one sample per data array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples for the pixels within the specified region. - `int[]`"
  ([^BandedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h i-array ^java.awt.image.DataBuffer data]
    (-> this (.getPixels x y w h i-array data))))

(defn get-sample-double
  "Returns the sample in a specified band
   for a pixel located at (x,y) as a double.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: a double value that represents the sample in the specified
   band for the specified pixel. - `double`"
  (^Double [^BandedSampleModel this ^Integer x ^Integer y ^Integer b ^java.awt.image.DataBuffer data]
    (-> this (.getSampleDouble x y b data))))

(defn set-pixels
  "Sets all samples for a rectangle of pixels from an int array containing
   one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  i-array - The input samples in an int array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^BandedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h i-array ^java.awt.image.DataBuffer data]
    (-> this (.setPixels x y w h i-array data))))

(defn get-sample
  "Returns as int the sample in a specified band for the pixel
   located at (x,y).
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the sample in the specified band for the specified pixel. - `int`"
  (^Integer [^BandedSampleModel this ^Integer x ^Integer y ^Integer b ^java.awt.image.DataBuffer data]
    (-> this (.getSample x y b data))))

(defn set-sample
  "Sets a sample in the specified band for the pixel located at (x,y)
   in the DataBuffer using an int for input.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to set - `int`
  s - The input sample as an int - `int`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^BandedSampleModel this ^Integer x ^Integer y ^Integer b ^Integer s ^java.awt.image.DataBuffer data]
    (-> this (.setSample x y b s data))))

(defn set-pixel
  "Sets a pixel in the DataBuffer using an int array of samples for input.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  i-array - The input samples in an int array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^BandedSampleModel this ^Integer x ^Integer y i-array ^java.awt.image.DataBuffer data]
    (-> this (.setPixel x y i-array data))))

(defn get-pixel
  "Returns all samples for the specified pixel in an int array.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples for the specified pixel. - `int[]`"
  ([^BandedSampleModel this ^Integer x ^Integer y i-array ^java.awt.image.DataBuffer data]
    (-> this (.getPixel x y i-array data))))

(defn create-compatible-sample-model
  "Creates a new BandedSampleModel with the specified
   width and height.  The new BandedSampleModel will have the same
   number of bands, storage data type, and bank indices
   as this BandedSampleModel.  The band offsets will be compressed
   such that the offset between bands will be w*pixelStride and
   the minimum of all of the band offsets is zero.

  w - the width of the resulting BandedSampleModel - `int`
  h - the height of the resulting BandedSampleModel - `int`

  returns: a new BandedSampleModel with the specified
           width and height. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the supported data types"
  (^java.awt.image.SampleModel [^BandedSampleModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^BandedSampleModel this]
    (-> this (.hashCode))))

(defn set-data-elements
  "Sets the data for a single pixel in the specified DataBuffer from a
   primitive array of type TransferType.  For a BandedSampleModel,
   this will be the same as the data type, and samples are transferred
   one per array element.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is described by
   BandedSampleModel bsm1, to DataBuffer db2,
   whose storage layout is described by
   BandedSampleModel bsm2.
   The transfer will generally be more efficient than using
   getPixel/setPixel.


         BandedSampleModel bsm1, bsm2;
         DataBufferInt db1, db2;
         bsm2.setDataElements(x, y, bsm1.getDataElements(x, y, null, db1),
                              db2);
   Using getDataElements/setDataElements to transfer between two
   DataBuffer/SampleModel pairs is legitimate if the SampleModels have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   obj must be a primitive array of type TransferType.  Otherwise,
   a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if obj is not large enough to hold the pixel data.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  obj - If non-null, returns the primitive array in this object - `java.lang.Object`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^BandedSampleModel this ^Integer x ^Integer y ^java.lang.Object obj ^java.awt.image.DataBuffer data]
    (-> this (.setDataElements x y obj data))))

(defn set-samples
  "Sets the samples in the specified band for the specified rectangle
   of pixels from an int array containing one sample per data array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  b - The band to set - `int`
  i-array - The input sample array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^BandedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h ^Integer b i-array ^java.awt.image.DataBuffer data]
    (-> this (.setSamples x y w h b i-array data))))

(defn get-samples
  "Returns the samples in a specified band for the specified rectangle
   of pixels in an int array, one sample per data array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  b - The band to return - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples in the specified band for the pixels within
   the specified region. - `int[]`"
  ([^BandedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h ^Integer b i-array ^java.awt.image.DataBuffer data]
    (-> this (.getSamples x y w h b i-array data))))

