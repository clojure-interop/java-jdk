(ns jdk.awt.image.SinglePixelPackedSampleModel
  "This class represents pixel data packed such that the N samples which make
   up a single pixel are stored in a single data array element, and each data
   data array element holds samples for only one pixel.
   This class supports
   TYPE_BYTE,
   TYPE_USHORT,
   TYPE_INT data types.
   All data array elements reside
   in the first bank of a DataBuffer.  Accessor methods are provided so
   that the image data can be manipulated directly. Scanline stride is the
   number of data array elements between a given sample and the corresponding
   sample in the same column of the next scanline. Bit masks are the masks
   required to extract the samples representing the bands of the pixel.
   Bit offsets are the offsets in bits into the data array
   element of the samples representing the bands of the pixel.

  The following code illustrates extracting the bits of the sample
  representing band b for pixel x,y
  from DataBuffer data:


       int sample = data.getElem(y * scanlineStride  x);
       sample = (sample & bitMasks[b]) >>> bitOffsets[b];"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image SinglePixelPackedSampleModel]))

(defn ->single-pixel-packed-sample-model
  "Constructor.

  Constructs a SinglePixelPackedSampleModel with bitMasks.length bands
   and a scanline stride equal to scanlineStride data array elements.
   Each sample is stored in a data array element in the position of
   its corresponding bit mask.  Each bit mask must be contiguous and
   masks must not overlap. Bit masks exceeding data type capacity are
   truncated.

  data-type - The data type for storing samples. - `int`
  w - The width (in pixels) of the region of image data described. - `int`
  h - The height (in pixels) of the region of image data described. - `int`
  scanline-stride - The line stride of the image data. - `int`
  bit-masks - The bit masks for all bands. - `int[]`

  throws: java.lang.IllegalArgumentException - if dataType is not either DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, or DataBuffer.TYPE_INT"
  ([^Integer data-type ^Integer w ^Integer h ^Integer scanline-stride bit-masks]
    (new SinglePixelPackedSampleModel data-type w h scanline-stride bit-masks))
  ([^Integer data-type ^Integer w ^Integer h bit-masks]
    (new SinglePixelPackedSampleModel data-type w h bit-masks)))

(defn create-data-buffer
  "Creates a DataBuffer that corresponds to this
   SinglePixelPackedSampleModel.  The DataBuffer's data type and size
   will be consistent with this SinglePixelPackedSampleModel.  The
   DataBuffer will have a single bank.

  returns: a DataBuffer corresponding to this
           SampleModel. - `java.awt.image.DataBuffer`"
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.createDataBuffer))))

(defn get-data-elements
  "Returns data for a single pixel in a primitive array of type
   TransferType.  For a SinglePixelPackedSampleModel, the array will
   have one element, and the type will be the same as the storage
   data type.  Generally, obj
   should be passed in as null, so that the Object will be created
   automatically and will be of the right primitive data type.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is described by
   SinglePixelPackedSampleModel sppsm1, to
   DataBuffer db2, whose storage layout is described by
   SinglePixelPackedSampleModel sppsm2.
   The transfer will generally be more efficient than using
   getPixel/setPixel.


         SinglePixelPackedSampleModel sppsm1, sppsm2;
         DataBufferInt db1, db2;
         sppsm2.setDataElements(x, y, sppsm1.getDataElements(x, y, null,
                                db1), db2);
   Using getDataElements/setDataElements to transfer between two
   DataBuffer/SampleModel pairs is legitimate if the SampleModels have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   If obj is non-null, it should be a primitive array of type TransferType.
   Otherwise, a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if obj is non-null and is not large enough to hold
   the pixel data.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  obj - If non-null, a primitive array in which to return the pixel data. - `java.lang.Object`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the data for the specified pixel. - `java.lang.Object`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^java.lang.Object obj ^java.awt.image.DataBuffer data]
    (-> this (.getDataElements x y obj data))))

(defn create-subset-sample-model
  "This creates a new SinglePixelPackedSampleModel with a subset of the
   bands of this SinglePixelPackedSampleModel.  The new
   SinglePixelPackedSampleModel can be used with any DataBuffer that the
   existing SinglePixelPackedSampleModel can be used with.  The new
   SinglePixelPackedSampleModel/DataBuffer combination will represent
   an image with a subset of the bands of the original
   SinglePixelPackedSampleModel/DataBuffer combination.

  bands - the subset of bands of this SampleModel - `int[]`

  returns: a SampleModel with a subset of bands of this
           SampleModel. - `java.awt.image.SampleModel`

  throws: java.awt.image.RasterFormatException - if the length of the bands argument is greater than the number of bands in the sample model."
  ([^java.awt.image.SinglePixelPackedSampleModel this bands]
    (-> this (.createSubsetSampleModel bands))))

(defn get-pixels
  "Returns all samples for the specified rectangle of pixels in
   an int array, one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  i-array - If non-null, returns the samples in this array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: all samples for the specified region of pixels. - `int[]`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h i-array ^java.awt.image.DataBuffer data]
    (-> this (.getPixels x y w h i-array data))))

(defn set-pixels
  "Sets all samples for a rectangle of pixels from an int array containing
   one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  i-array - The input samples in an int array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h i-array ^java.awt.image.DataBuffer data]
    (-> this (.setPixels x y w h i-array data))))

(defn get-num-data-elements
  "Returns the number of data elements needed to transfer one pixel
   via the getDataElements and setDataElements methods.
   For a SinglePixelPackedSampleModel, this is one.

  returns: the number of data elements. - `int`"
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.getNumDataElements))))

(defn get-offset
  "Returns the offset (in data array elements) of pixel (x,y).
    The data element containing pixel x,y
    can be retrieved from a DataBuffer data with a
    SinglePixelPackedSampleModel sppsm as:


          data.getElem(sppsm.getOffset(x, y));

  x - the X coordinate of the specified pixel - `int`
  y - the Y coordinate of the specified pixel - `int`

  returns: the offset of the specified pixel. - `int`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y]
    (-> this (.getOffset x y))))

(defn get-scanline-stride
  "Returns the scanline stride of this SinglePixelPackedSampleModel.

  returns: the scanline stride of this
            SinglePixelPackedSampleModel. - `int`"
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.getScanlineStride))))

(defn get-sample
  "Returns as int the sample in a specified band for the pixel
   located at (x,y).
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  b - The band to return. - `int`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the sample in a specified band for the specified
           pixel. - `int`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^Integer b ^java.awt.image.DataBuffer data]
    (-> this (.getSample x y b data))))

(defn set-sample
  "Sets a sample in the specified band for the pixel located at (x,y)
   in the DataBuffer using an int for input.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  b - The band to set. - `int`
  s - The input sample as an int. - `int`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^Integer b ^Integer s ^java.awt.image.DataBuffer data]
    (-> this (.setSample x y b s data))))

(defn set-pixel
  "Sets a pixel in the DataBuffer using an int array of samples for input.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  i-array - The input samples in an int array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y i-array ^java.awt.image.DataBuffer data]
    (-> this (.setPixel x y i-array data))))

(defn get-pixel
  "Returns all samples in for the specified pixel in an int array.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: all samples for the specified pixel. - `int[]`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y i-array ^java.awt.image.DataBuffer data]
    (-> this (.getPixel x y i-array data))))

(defn get-sample-size
  "Returns the number of bits per sample for the specified band.

  band - the specified band - `int`

  returns: the size of the samples of the specified band. - `int`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer band]
    (-> this (.getSampleSize band)))
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.getSampleSize))))

(defn get-bit-masks
  "Returns the bit masks for all bands.

  returns: the bit masks for all bands. - `int[]`"
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.getBitMasks))))

(defn create-compatible-sample-model
  "Creates a new SinglePixelPackedSampleModel with the specified
   width and height.  The new SinglePixelPackedSampleModel will have the
   same storage data type and bit masks as this
   SinglePixelPackedSampleModel.

  w - the width of the resulting SampleModel - `int`
  h - the height of the resulting SampleModel - `int`

  returns: a SinglePixelPackedSampleModel with the
           specified width and height. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if w or h is not greater than 0"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.hashCode))))

(defn set-data-elements
  "Sets the data for a single pixel in the specified DataBuffer from a
   primitive array of type TransferType.  For a
   SinglePixelPackedSampleModel, only the first element of the array
   will hold valid data, and the type of the array must be the same as
   the storage data type of the SinglePixelPackedSampleModel.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is described by
   SinglePixelPackedSampleModel sppsm1,
   to DataBuffer db2, whose storage layout is described by
   SinglePixelPackedSampleModel sppsm2.
   The transfer will generally be more efficient than using
   getPixel/setPixel.


         SinglePixelPackedSampleModel sppsm1, sppsm2;
         DataBufferInt db1, db2;
         sppsm2.setDataElements(x, y, sppsm1.getDataElements(x, y, null,
                                db1), db2);
   Using getDataElements/setDataElements to transfer between two
   DataBuffer/SampleModel pairs is legitimate if the SampleModels have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   obj must be a primitive array of type TransferType.  Otherwise,
   a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if obj is not large enough to hold the pixel data.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  obj - A primitive array containing pixel data. - `java.lang.Object`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^java.lang.Object obj ^java.awt.image.DataBuffer data]
    (-> this (.setDataElements x y obj data))))

(defn set-samples
  "Sets the samples in the specified band for the specified rectangle
   of pixels from an int array containing one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  b - The band to set. - `int`
  i-array - The input samples in an int array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h ^Integer b i-array ^java.awt.image.DataBuffer data]
    (-> this (.setSamples x y w h b i-array data))))

(defn get-bit-offsets
  "Returns the bit offsets into the data array element representing
    a pixel for all bands.

  returns: the bit offsets representing a pixel for all bands. - `int[]`"
  ([^java.awt.image.SinglePixelPackedSampleModel this]
    (-> this (.getBitOffsets))))

(defn equals
  "Description copied from class: Object

  o - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^java.lang.Object o]
    (-> this (.equals o))))

(defn get-samples
  "Returns the samples for a specified band for the specified rectangle
   of pixels in an int array, one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  b - The band to return. - `int`
  i-array - If non-null, returns the samples in this array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the samples for the specified band for the specified
           region of pixels. - `int[]`"
  ([^java.awt.image.SinglePixelPackedSampleModel this ^Integer x ^Integer y ^Integer w ^Integer h ^Integer b i-array ^java.awt.image.DataBuffer data]
    (-> this (.getSamples x y w h b i-array data))))

