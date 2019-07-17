(ns jdk.awt.image.MultiPixelPackedSampleModel
  "The MultiPixelPackedSampleModel class represents
  one-banded images and can pack multiple one-sample
  pixels into one data element.  Pixels are not allowed to span data elements.
  The data type can be DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
  or DataBuffer.TYPE_INT.  Each pixel must be a power of 2 number of bits
  and a power of 2 number of pixels must fit exactly in one data element.
  Pixel bit stride is equal to the number of bits per pixel.  Scanline
  stride is in data elements and the last several data elements might be
  padded with unused pixels.  Data bit offset is the offset in bits from
  the beginning of the DataBuffer to the first pixel and must be
  a multiple of pixel bit stride.

  The following code illustrates extracting the bits for pixel
  x, y from DataBuffer data
  and storing the pixel data in data elements of type
  dataType:


       int dataElementSize = DataBuffer.getDataTypeSize(dataType);
       int bitnum = dataBitOffset  x*pixelBitStride;
       int element = data.getElem(y*scanlineStride  bitnum/dataElementSize);
       int shift = dataElementSize - (bitnum & (dataElementSize-1))
                   - pixelBitStride;
       int pixel = (element >> shift) & ((1 << pixelBitStride) - 1);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image MultiPixelPackedSampleModel]))

(defn ->multi-pixel-packed-sample-model
  "Constructor.

  Constructs a MultiPixelPackedSampleModel with
   specified data type, width, height, number of bits per pixel,
   scanline stride and data bit offset.

  data-type - the data type for storing samples - `int`
  w - the width, in pixels, of the region of image data described - `int`
  h - the height, in pixels, of the region of image data described - `int`
  number-of-bits - the number of bits per pixel - `int`
  scanline-stride - the line stride of the image data - `int`
  data-bit-offset - the data bit offset for the region of image data described - `int`

  throws: java.awt.image.RasterFormatException - if the number of bits per pixel is not a power of 2 or if a power of 2 number of pixels do not fit in one data element."
  ([^Integer data-type ^Integer w ^Integer h ^Integer number-of-bits ^Integer scanline-stride ^Integer data-bit-offset]
    (new MultiPixelPackedSampleModel data-type w h number-of-bits scanline-stride data-bit-offset))
  ([^Integer data-type ^Integer w ^Integer h ^Integer number-of-bits]
    (new MultiPixelPackedSampleModel data-type w h number-of-bits)))

(defn get-pixel-bit-stride
  "Returns the pixel bit stride in bits.  This value is the same as
   the number of bits per pixel.

  returns: the pixelBitStride of this
   MultiPixelPackedSampleModel. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.getPixelBitStride))))

(defn get-bit-offset
  "Returns the offset, in bits, into the data element in which it is
    stored for the xth pixel of a scanline.
    This offset is the same for all scanlines.

  x - the specified pixel - `int`

  returns: the bit offset of the specified pixel. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this ^Integer x]
    (-> this (.getBitOffset x))))

(defn get-transfer-type
  "Returns the TransferType used to transfer pixels by way of the
    getDataElements and setDataElements
    methods. The TransferType might or might not be the same as the
    storage DataType.  The TransferType is one of
    DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
    or DataBuffer.TYPE_INT.

  returns: the transfertype. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.getTransferType))))

(defn create-data-buffer
  "Creates a DataBuffer that corresponds to this
   MultiPixelPackedSampleModel.  The
   DataBuffer object's data type and size
   is consistent with this MultiPixelPackedSampleModel.
   The DataBuffer has a single bank.

  returns: a DataBuffer with the same data type and
   size as this MultiPixelPackedSampleModel. - `java.awt.image.DataBuffer`"
  (^java.awt.image.DataBuffer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.createDataBuffer))))

(defn get-data-elements
  "Returns data for a single pixel in a primitive array of type
   TransferType.  For a MultiPixelPackedSampleModel,
   the array has one element, and the type is the smallest of
   DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, or DataBuffer.TYPE_INT
   that can hold a single pixel.  Generally, obj
   should be passed in as null, so that the
   Object is created automatically and is the
   correct primitive data type.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is
   described by MultiPixelPackedSampleModel
   mppsm1, to DataBuffer db2,
   whose storage layout is described by
   MultiPixelPackedSampleModel mppsm2.
   The transfer is generally more efficient than using
   getPixel or setPixel.


         MultiPixelPackedSampleModel mppsm1, mppsm2;
         DataBufferInt db1, db2;
         mppsm2.setDataElements(x, y, mppsm1.getDataElements(x, y, null,
                                db1), db2);
   Using getDataElements or setDataElements
   to transfer between two DataBuffer/SampleModel pairs
   is legitimate if the SampleModels have the same number
   of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   If obj is not null, it should be a
   primitive array of type TransferType.  Otherwise, a
   ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException is thrown if the
   coordinates are not in bounds, or if obj is not
   null and is not large enough to hold the pixel data.

  x - the X coordinate of the specified pixel - `int`
  y - the Y coordinate of the specified pixel - `int`
  obj - a primitive array in which to return the pixel data or null. - `java.lang.Object`
  data - the DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: an Object containing data for the specified
    pixel. - `java.lang.Object`

  throws: java.lang.ClassCastException - if obj is not a primitive array of type TransferType or is not null"
  (^java.lang.Object [^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y ^java.lang.Object obj ^java.awt.image.DataBuffer data]
    (-> this (.getDataElements x y obj data))))

(defn create-subset-sample-model
  "Creates a new MultiPixelPackedSampleModel with a
   subset of the bands of this
   MultiPixelPackedSampleModel.  Since a
   MultiPixelPackedSampleModel only has one band, the
   bands argument must have a length of one and indicate the zeroth
   band.

  bands - the specified bands - `int[]`

  returns: a new SampleModel with a subset of bands of
   this MultiPixelPackedSampleModel. - `java.awt.image.SampleModel`

  throws: java.awt.image.RasterFormatException - if the number of bands requested is not one."
  (^java.awt.image.SampleModel [^java.awt.image.MultiPixelPackedSampleModel this bands]
    (-> this (.createSubsetSampleModel bands))))

(defn get-num-data-elements
  "Returns the number of data elements needed to transfer one pixel
   via the getDataElements(int, int, java.lang.Object, java.awt.image.DataBuffer) and setDataElements(int, int, java.lang.Object, java.awt.image.DataBuffer)
   methods.  For a MultiPixelPackedSampleModel, this is
   one.

  returns: the number of data elements. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.getNumDataElements))))

(defn get-offset
  "Returns the offset of pixel (x, y) in data array elements.

  x - the X coordinate of the specified pixel - `int`
  y - the Y coordinate of the specified pixel - `int`

  returns: the offset of the specified pixel. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y]
    (-> this (.getOffset x y))))

(defn get-scanline-stride
  "Returns the scanline stride.

  returns: the scanline stride of this
   MultiPixelPackedSampleModel. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.getScanlineStride))))

(defn get-sample
  "Returns as int the sample in a specified band for the
   pixel located at (x, y).  An
   ArrayIndexOutOfBoundsException is thrown if the
   coordinates are not in bounds.

  x - the X coordinate of the specified pixel - `int`
  y - the Y coordinate of the specified pixel - `int`
  b - the band to return, which is assumed to be 0 - `int`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the specified band containing the sample of the specified
   pixel. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the specified coordinates are not in bounds."
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y ^Integer b ^java.awt.image.DataBuffer data]
    (-> this (.getSample x y b data))))

(defn set-sample
  "Sets a sample in the specified band for the pixel located at
   (x, y) in the DataBuffer using an
   int for input.
   An ArrayIndexOutOfBoundsException is thrown if the
   coordinates are not in bounds.

  x - the X coordinate of the specified pixel - `int`
  y - the Y coordinate of the specified pixel - `int`
  b - the band to return, which is assumed to be 0 - `int`
  s - the input sample as an int - `int`
  data - the DataBuffer where image data is stored - `java.awt.image.DataBuffer`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates are not in bounds."
  ([^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y ^Integer b ^Integer s ^java.awt.image.DataBuffer data]
    (-> this (.setSample x y b s data))))

(defn set-pixel
  "Sets a pixel in the DataBuffer using an
   int array for input.
   ArrayIndexOutOfBoundsException is thrown if
   the coordinates are not in bounds.

  x - the X coordinate of the pixel location - `int`
  y - the Y coordinate of the pixel location - `int`
  i-array - the input pixel in an int array - `int[]`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y i-array ^java.awt.image.DataBuffer data]
    (-> this (.setPixel x y i-array data))))

(defn get-data-bit-offset
  "Returns the data bit offset in bits.

  returns: the dataBitOffset of this
   MultiPixelPackedSampleModel. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.getDataBitOffset))))

(defn get-pixel
  "Returns the specified single band pixel in the first element
   of an int array.
   ArrayIndexOutOfBoundsException is thrown if the
   coordinates are not in bounds.

  x - the X coordinate of the specified pixel - `int`
  y - the Y coordinate of the specified pixel - `int`
  i-array - the array containing the pixel to be returned or null - `int[]`
  data - the DataBuffer where image data is stored - `java.awt.image.DataBuffer`

  returns: an array containing the specified pixel. - `int[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the coordinates are not in bounds"
  ([^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y i-array ^java.awt.image.DataBuffer data]
    (-> this (.getPixel x y i-array data))))

(defn get-sample-size
  "Returns the number of bits per sample for the specified band.

  band - the specified band - `int`

  returns: the number of bits per sample for the specified band. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this ^Integer band]
    (-> this (.getSampleSize band)))
  ([^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.getSampleSize))))

(defn create-compatible-sample-model
  "Creates a new MultiPixelPackedSampleModel with the
   specified width and height.  The new
   MultiPixelPackedSampleModel has the
   same storage data type and number of bits per pixel as this
   MultiPixelPackedSampleModel.

  w - the specified width - `int`
  h - the specified height - `int`

  returns: a SampleModel with the specified width and height
   and with the same storage data type and number of bits per pixel
   as this MultiPixelPackedSampleModel. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if w or h is not greater than 0"
  (^java.awt.image.SampleModel [^java.awt.image.MultiPixelPackedSampleModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.awt.image.MultiPixelPackedSampleModel this]
    (-> this (.hashCode))))

(defn set-data-elements
  "Sets the data for a single pixel in the specified
   DataBuffer from a primitive array of type
   TransferType.  For a MultiPixelPackedSampleModel,
   only the first element of the array holds valid data,
   and the type must be the smallest of
   DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, or DataBuffer.TYPE_INT
   that can hold a single pixel.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is
   described by MultiPixelPackedSampleModel
   mppsm1, to DataBuffer db2,
   whose storage layout is described by
   MultiPixelPackedSampleModel mppsm2.
   The transfer is generally more efficient than using
   getPixel or setPixel.


         MultiPixelPackedSampleModel mppsm1, mppsm2;
         DataBufferInt db1, db2;
         mppsm2.setDataElements(x, y, mppsm1.getDataElements(x, y, null,
                                db1), db2);
   Using getDataElements or setDataElements to
   transfer between two DataBuffer/SampleModel pairs is
   legitimate if the SampleModel objects have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   obj must be a primitive array of type TransferType.
   Otherwise, a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException is thrown if the
   coordinates are not in bounds, or if obj is not large
   enough to hold the pixel data.

  x - the X coordinate of the pixel location - `int`
  y - the Y coordinate of the pixel location - `int`
  obj - a primitive array containing pixel data - `java.lang.Object`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([^java.awt.image.MultiPixelPackedSampleModel this ^Integer x ^Integer y ^java.lang.Object obj ^java.awt.image.DataBuffer data]
    (-> this (.setDataElements x y obj data))))

(defn equals
  "Description copied from class: Object

  o - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^java.awt.image.MultiPixelPackedSampleModel this ^java.lang.Object o]
    (-> this (.equals o))))

