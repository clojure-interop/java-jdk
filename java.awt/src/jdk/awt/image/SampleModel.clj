(ns jdk.awt.image.SampleModel
  "This abstract class defines an interface for extracting samples of pixels
   in an image.  All image data is expressed as a collection of pixels.
   Each pixel consists of a number of samples. A sample is a datum
   for one band of an image and a band consists of all samples of a
   particular type in an image.  For example, a pixel might contain
   three samples representing its red, green and blue components.
   There are three bands in the image containing this pixel.  One band
   consists of all the red samples from all pixels in the
   image.  The second band consists of all the green samples and
   the remaining band consists of all of the blue samples.  The pixel
   can be stored in various formats.  For example, all samples from
   a particular band can be stored contiguously or all samples from a
   single pixel can be stored contiguously.

   Subclasses of SampleModel specify the types of samples they can
   represent (e.g. unsigned 8-bit byte, signed 16-bit short, etc.)
   and may specify how the samples are organized in memory.
   In the Java 2D(tm) API, built-in image processing operators may
   not operate on all possible sample types, but generally will work
   for unsigned integral samples of 16 bits or less.  Some operators
   support a wider variety of sample types.

   A collection of pixels is represented as a Raster, which consists of
   a DataBuffer and a SampleModel.  The SampleModel allows access to
   samples in the DataBuffer and may provide low-level information that
   a programmer can use to directly manipulate samples and pixels in the
   DataBuffer.

   This class is generally a fall back method for dealing with
   images.  More efficient code will cast the SampleModel to the
   appropriate subclass and extract the information needed to directly
   manipulate pixels in the DataBuffer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image SampleModel]))

(defn ->sample-model
  "Constructor.

  Constructs a SampleModel with the specified parameters.

  data-type - The data type of the DataBuffer storing the pixel data. - `int`
  w - The width (in pixels) of the region of image data. - `int`
  h - The height (in pixels) of the region of image data. - `int`
  num-bands - The number of bands of the image data. - `int`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the supported data types"
  ([data-type w h num-bands]
    (new SampleModel data-type w h num-bands)))

(defn get-width
  "Returns the width in pixels.

  returns: the width in pixels of the region of image data
            that this SampleModel describes. - `int`"
  ([this]
    (-> this (.getWidth))))

(defn get-sample-float
  "Returns the sample in a specified band
   for the pixel located at (x,y) as a float.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  b - The band to return. - `int`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the sample in a specified band for the specified pixel. - `float`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y b data]
    (-> this (.getSampleFloat x y b data))))

(defn get-data-type
  "Returns the data type of the DataBuffer storing the pixel data.

  returns: the data type. - `int`"
  ([this]
    (-> this (.getDataType))))

(defn get-transfer-type
  "Returns the TransferType used to transfer pixels via the
    getDataElements and setDataElements methods.  When pixels
    are transferred via these methods, they may be transferred in a
    packed or unpacked format, depending on the implementation of the
    SampleModel.  Using these methods, pixels are transferred as an
    array of getNumDataElements() elements of a primitive type given
    by getTransferType().  The TransferType may or may not be the same
    as the storage DataType.  The TransferType will be one of the types
    defined in DataBuffer.

  returns: the transfer type. - `int`"
  ([this]
    (-> this (.getTransferType))))

(defn create-data-buffer
  "Creates a DataBuffer that corresponds to this SampleModel.
   The DataBuffer's width and height will match this SampleModel's.

  returns: a DataBuffer corresponding to this
           SampleModel. - `java.awt.image.DataBuffer`"
  ([this]
    (-> this (.createDataBuffer))))

(defn get-data-elements
  "Returns the pixel data for the specified rectangle of pixels in a
   primitive array of type TransferType.
   For image data supported by the Java 2D API, this
   will be one of DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
   DataBuffer.TYPE_INT, DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT,
   or DataBuffer.TYPE_DOUBLE.  Data may be returned in a packed format,
   thus increasing efficiency for data transfers. Generally, obj
   should be passed in as null, so that the Object will be created
   automatically and will be of the right primitive data type.

   The following code illustrates transferring data for a rectangular
   region of pixels from
   DataBuffer db1, whose storage layout is described by
   SampleModel sm1, to DataBuffer db2, whose
   storage layout is described by SampleModel sm2.
   The transfer will generally be more efficient than using
   getPixels/setPixels.


         SampleModel sm1, sm2;
         DataBuffer db1, db2;
         sm2.setDataElements(x, y, w, h, sm1.getDataElements(x, y, w,
                             h, null, db1), db2);
   Using getDataElements/setDataElements to transfer between two
   DataBuffer/SampleModel pairs is legitimate if the SampleModels have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   If obj is non-null, it should be a primitive array of type TransferType.
   Otherwise, a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if obj is non-null and is not large enough to hold
   the pixel data.

  x - The minimum X coordinate of the pixel rectangle. - `int`
  y - The minimum Y coordinate of the pixel rectangle. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  obj - If non-null, a primitive array in which to return the pixel data. - `java.lang.Object`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the data elements for the specified region of pixels. - `java.lang.Object`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y w h obj data]
    (-> this (.getDataElements x y w h obj data)))
  ([this x y obj data]
    (-> this (.getDataElements x y obj data))))

(defn create-subset-sample-model
  "Creates a new SampleModel
   with a subset of the bands of this
   SampleModel.

  bands - the subset of bands of this SampleModel - `int[]`

  returns: a SampleModel with a subset of bands of this
           SampleModel. - `java.awt.image.SampleModel`"
  ([this bands]
    (-> this (.createSubsetSampleModel bands))))

(defn get-num-bands
  "Returns the total number of bands of image data.

  returns: the number of bands of image data that this
            SampleModel describes. - `int`"
  ([this]
    (-> this (.getNumBands))))

(defn get-pixels
  "Returns all samples for a rectangle of pixels in an
   int array, one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the upper left pixel location. - `int`
  y - The Y coordinate of the upper left pixel location. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  i-array - If non-null, returns the samples in this array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the samples for the specified region of pixels. - `int[]`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y w h i-array data]
    (-> this (.getPixels x y w h i-array data))))

(defn get-sample-double
  "Returns the sample in a specified band
   for a pixel located at (x,y) as a double.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  b - The band to return. - `int`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the sample in a specified band for the specified pixel. - `double`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y b data]
    (-> this (.getSampleDouble x y b data))))

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
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  throws: java.lang.NullPointerException - if iArray or data is null."
  ([this x y w h i-array data]
    (-> this (.setPixels x y w h i-array data))))

(defn get-num-data-elements
  "Returns the number of data elements needed to transfer a pixel
    via the getDataElements and setDataElements methods.  When pixels
    are transferred via these methods, they may be transferred in a
    packed or unpacked format, depending on the implementation of the
    SampleModel.  Using these methods, pixels are transferred as an
    array of getNumDataElements() elements of a primitive type given
    by getTransferType().  The TransferType may or may not be the same
    as the storage DataType.

  returns: the number of data elements. - `int`"
  ([this]
    (-> this (.getNumDataElements))))

(defn get-sample
  "Returns the sample in a specified band for the pixel located
   at (x,y) as an int.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  b - The band to return. - `int`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  returns: the sample in a specified band for the specified pixel. - `int`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y b data]
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
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y b s data]
    (-> this (.setSample x y b s data))))

(defn get-height
  "Returns the height in pixels.

  returns: the height in pixels of the region of image data
            that this SampleModel describes. - `int`"
  ([this]
    (-> this (.getHeight))))

(defn set-pixel
  "Sets a pixel in  the DataBuffer using an int array of samples for input.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location. - `int`
  y - The Y coordinate of the pixel location. - `int`
  i-array - The input samples in an int array. - `int[]`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  throws: java.lang.NullPointerException - if iArray or data is null."
  ([this x y i-array data]
    (-> this (.setPixel x y i-array data))))

(defn get-pixel
  "Returns the samples for a specified pixel in an int array,
   one sample per array element.
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds.

  x - The X coordinate of the pixel location - `int`
  y - The Y coordinate of the pixel location - `int`
  i-array - If non-null, returns the samples in this array - `int[]`
  data - The DataBuffer containing the image data - `java.awt.image.DataBuffer`

  returns: the samples for the specified pixel. - `int[]`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y i-array data]
    (-> this (.getPixel x y i-array data))))

(defn get-sample-size
  "Returns the size in bits of samples for the specified band.

  band - the specified band - `int`

  returns: the size of the samples of the specified band. - `int`"
  ([this band]
    (-> this (.getSampleSize band)))
  ([this]
    (-> this (.getSampleSize))))

(defn create-compatible-sample-model
  "Creates a SampleModel which describes data in this SampleModel's
    format, but with a different width and height.

  w - the width of the image data - `int`
  h - the height of the image data - `int`

  returns: a SampleModel describing the same image
            data as this SampleModel, but with a
            different size. - `java.awt.image.SampleModel`"
  ([this w h]
    (-> this (.createCompatibleSampleModel w h))))

(defn set-data-elements
  "Sets the data for a rectangle of pixels in the specified DataBuffer
   from a primitive array of type TransferType.  For image data supported
   by the Java 2D API, this will be one of DataBuffer.TYPE_BYTE,
   DataBuffer.TYPE_USHORT, DataBuffer.TYPE_INT, DataBuffer.TYPE_SHORT,
   DataBuffer.TYPE_FLOAT, or DataBuffer.TYPE_DOUBLE.  Data in the array
   may be in a packed format, thus increasing efficiency for data
   transfers.

   The following code illustrates transferring data for a rectangular
   region of pixels from
   DataBuffer db1, whose storage layout is described by
   SampleModel sm1, to DataBuffer db2, whose
   storage layout is described by SampleModel sm2.
   The transfer will generally be more efficient than using
   getPixels/setPixels.


         SampleModel sm1, sm2;
         DataBuffer db1, db2;
         sm2.setDataElements(x, y, w, h, sm1.getDataElements(x, y, w, h,
                             null, db1), db2);
   Using getDataElements/setDataElements to transfer between two
   DataBuffer/SampleModel pairs is legitimate if the SampleModels have
   the same number of bands, corresponding bands have the same number of
   bits per sample, and the TransferTypes are the same.

   obj must be a primitive array of type TransferType.  Otherwise,
   a ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException may be thrown if the coordinates are
   not in bounds, or if obj is not large enough to hold the pixel data.

  x - The minimum X coordinate of the pixel rectangle. - `int`
  y - The minimum Y coordinate of the pixel rectangle. - `int`
  w - The width of the pixel rectangle. - `int`
  h - The height of the pixel rectangle. - `int`
  obj - A primitive array containing pixel data. - `java.lang.Object`
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y w h obj data]
    (-> this (.setDataElements x y w h obj data)))
  ([this x y obj data]
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
  data - The DataBuffer containing the image data. - `java.awt.image.DataBuffer`

  throws: java.lang.NullPointerException - if iArray or data is null."
  ([this x y w h b i-array data]
    (-> this (.setSamples x y w h b i-array data))))

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

  returns: the samples for the specified band for the specified region
           of pixels. - `int[]`

  throws: java.lang.NullPointerException - if data is null."
  ([this x y w h b i-array data]
    (-> this (.getSamples x y w h b i-array data))))

