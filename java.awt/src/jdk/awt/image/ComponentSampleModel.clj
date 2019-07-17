(ns jdk.awt.image.ComponentSampleModel
  "This class represents image data which is stored such that each sample
   of a pixel occupies one data element of the DataBuffer.  It stores the
   N samples which make up a pixel in N separate data array elements.
   Different bands may be in different banks of the DataBuffer.
   Accessor methods are provided so that image data can be manipulated
   directly. This class can support different kinds of interleaving, e.g.
   band interleaving, scanline interleaving, and pixel interleaving.
   Pixel stride is the number of data array elements between two samples
   for the same band on the same scanline. Scanline stride is the number
   of data array elements between a given sample and the corresponding sample
   in the same column of the next scanline.  Band offsets denote the number
   of data array elements from the first data array element of the bank
   of the DataBuffer holding each band to the first sample of the band.
   The bands are numbered from 0 to N-1.  This class can represent image
   data for which each sample is an unsigned integral number which can be
   stored in 8, 16, or 32 bits (using DataBuffer.TYPE_BYTE,
   DataBuffer.TYPE_USHORT, or DataBuffer.TYPE_INT,
   respectively), data for which each sample is a signed integral number
   which can be stored in 16 bits (using DataBuffer.TYPE_SHORT),
   or data for which each sample is a signed float or double quantity
   (using DataBuffer.TYPE_FLOAT or
   DataBuffer.TYPE_DOUBLE, respectively).
   All samples of a given ComponentSampleModel
   are stored with the same precision.  All strides and offsets must be
   non-negative.  This class supports
   TYPE_BYTE,
   TYPE_USHORT,
   TYPE_SHORT,
   TYPE_INT,
   TYPE_FLOAT,
   TYPE_DOUBLE,"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ComponentSampleModel]))

(defn ->component-sample-model
  "Constructor.

  Constructs a ComponentSampleModel with the specified parameters.
   The number of bands will be given by the length of the bandOffsets array.
   Different bands may be stored in different banks of the DataBuffer.

  data-type - the data type for storing samples - `int`
  w - the width (in pixels) of the region of image data described - `int`
  h - the height (in pixels) of the region of image data described - `int`
  pixel-stride - the pixel stride of the region of image data described - `int`
  scanline-stride - The line stride of the region of image data described - `int`
  bank-indices - the bank indices of all bands - `int[]`
  band-offsets - the band offsets of all bands - `int[]`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the supported data types"
  ([data-type w h pixel-stride scanline-stride bank-indices band-offsets]
    (new ComponentSampleModel data-type w h pixel-stride scanline-stride bank-indices band-offsets))
  ([data-type w h pixel-stride scanline-stride band-offsets]
    (new ComponentSampleModel data-type w h pixel-stride scanline-stride band-offsets)))

(defn get-bank-indices
  "Returns the bank indices for all bands.

  returns: the bank indices for all bands. - `int[]`"
  ([this]
    (-> this (.getBankIndices))))

(defn get-band-offsets
  "Returns the band offset for all bands.

  returns: the band offsets for all bands. - `int[]`"
  ([this]
    (-> this (.getBandOffsets))))

(defn get-sample-float
  "Returns the sample in a specified band
   for the pixel located at (x,y) as a float.
   An ArrayIndexOutOfBoundsException might be
   thrown if the coordinates are not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: a float value representing the sample in the specified
   band for the specified pixel. - `float`"
  ([this x y b data]
    (-> this (.getSampleFloat x y b data))))

(defn create-data-buffer
  "Creates a DataBuffer that corresponds to this
   ComponentSampleModel.
   The DataBuffer object's data type, number of banks,
   and size are be consistent with this ComponentSampleModel.

  returns: a DataBuffer whose data type, number of banks
           and size are consistent with this
           ComponentSampleModel. - `java.awt.image.DataBuffer`"
  ([this]
    (-> this (.createDataBuffer))))

(defn get-data-elements
  "Returns data for a single pixel in a primitive array of type
   TransferType.  For a ComponentSampleModel,
   this is the same as the data type, and samples are returned
   one per array element.  Generally, obj should
   be passed in as null, so that the Object
   is created automatically and is the right primitive data type.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is
   described by ComponentSampleModel csm1,
   to DataBuffer db2, whose storage layout
   is described by ComponentSampleModel csm2.
   The transfer is usually more efficient than using
   getPixel and setPixel.


         ComponentSampleModel csm1, csm2;
         DataBufferInt db1, db2;
         csm2.setDataElements(x, y,
                              csm1.getDataElements(x, y, null, db1), db2);

   Using getDataElements and setDataElements
   to transfer between two DataBuffer/SampleModel
   pairs is legitimate if the SampleModel objects have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   If obj is not null, it should be a
   primitive array of type TransferType.
   Otherwise, a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException might be thrown if the
   coordinates are not in bounds, or if obj is not
   null and is not large enough to hold
   the pixel data.

  x - the X coordinate of the pixel location - `int`
  y - the Y coordinate of the pixel location - `int`
  obj - if non-null, a primitive array in which to return the pixel data - `java.lang.Object`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the data of the specified pixel - `java.lang.Object`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y obj data]
    (-> this (.getDataElements x y obj data))))

(defn create-subset-sample-model
  "Creates a new ComponentSampleModel with a subset of the bands
   of this ComponentSampleModel.  The new ComponentSampleModel can be
   used with any DataBuffer that the existing ComponentSampleModel
   can be used with.  The new ComponentSampleModel/DataBuffer
   combination will represent an image with a subset of the bands
   of the original ComponentSampleModel/DataBuffer combination.

  bands - a subset of bands from this ComponentSampleModel - `int[]`

  returns: a ComponentSampleModel created with a subset
            of bands from this ComponentSampleModel. - `java.awt.image.SampleModel`"
  ([this bands]
    (-> this (.createSubsetSampleModel bands))))

(defn get-pixels
  "Returns all samples for the specified rectangle of pixels in
   an int array, one sample per array element.
   An ArrayIndexOutOfBoundsException might be thrown if
   the coordinates are not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples of the pixels within the specified region. - `int[]`"
  ([this x y w h i-array data]
    (-> this (.getPixels x y w h i-array data))))

(defn get-sample-double
  "Returns the sample in a specified band
   for a pixel located at (x,y) as a double.
   An ArrayIndexOutOfBoundsException might be
   thrown if the coordinates are not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - The band to return - `int`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: a double value representing the sample in the specified
   band for the specified pixel. - `double`"
  ([this x y b data]
    (-> this (.getSampleDouble x y b data))))

(defn set-pixels
  "Sets all samples for a rectangle of pixels from an int array containing
   one sample per array element.
   An ArrayIndexOutOfBoundsException might be thrown if the
   coordinates are not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  i-array - The input samples in an int array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([this x y w h i-array data]
    (-> this (.setPixels x y w h i-array data))))

(defn get-num-data-elements
  "Returns the number of data elements needed to transfer a pixel
   with the
   getDataElements(int, int, Object, DataBuffer) and
   setDataElements(int, int, Object, DataBuffer)
   methods.
   For a ComponentSampleModel, this is identical to the
   number of bands.

  returns: the number of data elements needed to transfer a pixel with
           the getDataElements and
           setDataElements methods. - `int`"
  ([this]
    (-> this (.getNumDataElements))))

(defn get-offset
  "Gets the offset for band b of pixel (x,y).
    A sample of band b can be retrieved from a
    DataBuffer data
    with a ComponentSampleModel csm as


         data.getElem(csm.getOffset(x, y, b));

  x - the X location of the specified pixel - `int`
  y - the Y location of the specified pixel - `int`
  b - the specified band - `int`

  returns: the offset for the specified band of the specified pixel. - `int`"
  ([this x y b]
    (-> this (.getOffset x y b)))
  ([this x y]
    (-> this (.getOffset x y))))

(defn get-pixel-stride
  "Returns the pixel stride of this ComponentSampleModel.

  returns: the pixel stride of this ComponentSampleModel. - `int`"
  ([this]
    (-> this (.getPixelStride))))

(defn get-scanline-stride
  "Returns the scanline stride of this ComponentSampleModel.

  returns: the scanline stride of this ComponentSampleModel. - `int`"
  ([this]
    (-> this (.getScanlineStride))))

(defn get-sample
  "Returns as int the sample in a specified band for the pixel
   located at (x,y).
   An ArrayIndexOutOfBoundsException might be thrown if
   the coordinates are not in bounds.

  x - the X coordinate of the pixel location - `int`
  y - the Y coordinate of the pixel location - `int`
  b - the band to return - `int`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the sample in a specified band for the specified pixel - `int`"
  ([this x y b data]
    (-> this (.getSample x y b data))))

(defn set-sample
  "Sets a sample in the specified band for the pixel located at (x,y)
   in the DataBuffer using an int for input.
   An ArrayIndexOutOfBoundsException might be thrown if the
   coordinates are not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  b - the band to set - `int`
  s - the input sample as an int - `int`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([this x y b s data]
    (-> this (.setSample x y b s data))))

(defn set-pixel
  "Sets a pixel in the DataBuffer using an int array of
   samples for input.  An ArrayIndexOutOfBoundsException
   might be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  i-array - The input samples in an int array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([this x y i-array data]
    (-> this (.setPixel x y i-array data))))

(defn get-pixel
  "Returns all samples for the specified pixel in an int array,
   one sample per array element.
   An ArrayIndexOutOfBoundsException might be thrown if
   the coordinates are not in bounds.

  x - the X coordinate of the pixel location - `int`
  y - the Y coordinate of the pixel location - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples of the specified pixel. - `int[]`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y i-array data]
    (-> this (.getPixel x y i-array data))))

(defn get-sample-size
  "Returns the number of bits per sample for the specified band.

  band - the specified band - `int`

  returns: the number of bits per sample for the specified band. - `int`"
  ([this band]
    (-> this (.getSampleSize band)))
  ([this]
    (-> this (.getSampleSize))))

(defn create-compatible-sample-model
  "Creates a new ComponentSampleModel with the specified
   width and height.  The new SampleModel will have the same
   number of bands, storage data type, interleaving scheme, and
   pixel stride as this SampleModel.

  w - the width of the resulting SampleModel - `int`
  h - the height of the resulting SampleModel - `int`

  returns: a new ComponentSampleModel with the specified size - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if w or h is not greater than 0"
  ([this w h]
    (-> this (.createCompatibleSampleModel w h))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([this]
    (-> this (.hashCode))))

(defn set-data-elements
  "Sets the data for a single pixel in the specified
   DataBuffer from a primitive array of type
   TransferType.  For a ComponentSampleModel,
   this is the same as the data type, and samples are transferred
   one per array element.

   The following code illustrates transferring data for one pixel from
   DataBuffer db1, whose storage layout is
   described by ComponentSampleModel csm1,
   to DataBuffer db2, whose storage layout
   is described by ComponentSampleModel csm2.
   The transfer is usually more efficient than using
   getPixel and setPixel.


         ComponentSampleModel csm1, csm2;
         DataBufferInt db1, db2;
         csm2.setDataElements(x, y, csm1.getDataElements(x, y, null, db1),
                              db2);
   Using getDataElements and setDataElements
   to transfer between two DataBuffer/SampleModel pairs
   is legitimate if the SampleModel objects have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   A ClassCastException is thrown if obj is not
   a primitive array of type TransferType.
   An ArrayIndexOutOfBoundsException might be thrown if
   the coordinates are not in bounds, or if obj is not large
   enough to hold the pixel data.

  x - the X coordinate of the pixel location - `int`
  y - the Y coordinate of the pixel location - `int`
  obj - a primitive array containing pixel data - `java.lang.Object`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([this x y obj data]
    (-> this (.setDataElements x y obj data))))

(defn set-samples
  "Sets the samples in the specified band for the specified rectangle
   of pixels from an int array containing one sample per data array element.
   An ArrayIndexOutOfBoundsException might be thrown if the
   coordinates are not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - The width of the pixel rectangle - `int`
  h - The height of the pixel rectangle - `int`
  b - The band to set - `int`
  i-array - The input samples in an int array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`"
  ([this x y w h b i-array data]
    (-> this (.setSamples x y w h b i-array data))))

(defn equals
  "Description copied from class: Object

  o - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([this o]
    (-> this (.equals o))))

(defn get-samples
  "Returns the samples in a specified band for the specified rectangle
   of pixels in an int array, one sample per data array element.
   An ArrayIndexOutOfBoundsException might be thrown if
   the coordinates are not in bounds.

  x - The X coordinate of the upper left pixel location - `int`
  y - The Y coordinate of the upper left pixel location - `int`
  w - the width of the pixel rectangle - `int`
  h - the height of the pixel rectangle - `int`
  b - the band to return - `int`
  i-array - if non-null, returns the samples in this array - `int[]`
  data - the DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples in the specified band of the specified pixel - `int[]`"
  ([this x y w h b i-array data]
    (-> this (.getSamples x y w h b i-array data))))

