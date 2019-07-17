(ns jdk.awt.image.PixelInterleavedSampleModel
  "This class represents image data which is stored in a pixel interleaved
   fashion and for
   which each sample of a pixel occupies one data element of the DataBuffer.
   It subclasses ComponentSampleModel but provides a more efficient
   implementation for accessing pixel interleaved image data than is provided
   by ComponentSampleModel.  This class
   stores sample data for all bands in a single bank of the
   DataBuffer. Accessor methods are provided so that image data can be
   manipulated directly. Pixel stride is the number of
   data array elements between two samples for the same band on the same
   scanline. Scanline stride is the number of data array elements between
   a given sample and the corresponding sample in the same column of the next
   scanline.  Band offsets denote the number
   of data array elements from the first data array element of the bank
   of the DataBuffer holding each band to the first sample of the band.
   The bands are numbered from 0 to N-1.
   Bank indices denote the correspondence between a bank of the data buffer
   and a band of image data.
   This class supports
   TYPE_BYTE,
   TYPE_USHORT,
   TYPE_SHORT,
   TYPE_INT,
   TYPE_FLOAT and
   TYPE_DOUBLE datatypes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image PixelInterleavedSampleModel]))

(defn ->pixel-interleaved-sample-model
  "Constructor.

  Constructs a PixelInterleavedSampleModel with the specified parameters.
   The number of bands will be given by the length of the bandOffsets
   array.

  data-type - The data type for storing samples. - `int`
  w - The width (in pixels) of the region of image data described. - `int`
  h - The height (in pixels) of the region of image data described. - `int`
  pixel-stride - The pixel stride of the image data. - `int`
  scanline-stride - The line stride of the image data. - `int`
  band-offsets - The offsets of all bands. - `int[]`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the supported data types"
  ([^Integer data-type ^Integer w ^Integer h ^Integer pixel-stride ^Integer scanline-stride band-offsets]
    (new PixelInterleavedSampleModel data-type w h pixel-stride scanline-stride band-offsets)))

(defn create-compatible-sample-model
  "Creates a new PixelInterleavedSampleModel with the specified
   width and height.  The new PixelInterleavedSampleModel will have the
   same number of bands, storage data type, and pixel stride
   as this PixelInterleavedSampleModel.  The band offsets may be
   compressed such that the minimum of all of the band offsets is zero.

  w - the width of the resulting SampleModel - `int`
  h - the height of the resulting SampleModel - `int`

  returns: a new SampleModel with the specified width
           and height. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if w or h is not greater than 0"
  ([^java.awt.image.PixelInterleavedSampleModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn create-subset-sample-model
  "Creates a new PixelInterleavedSampleModel with a subset of the
   bands of this PixelInterleavedSampleModel.  The new
   PixelInterleavedSampleModel can be used with any DataBuffer that the
   existing PixelInterleavedSampleModel can be used with.  The new
   PixelInterleavedSampleModel/DataBuffer combination will represent
   an image with a subset of the bands of the original
   PixelInterleavedSampleModel/DataBuffer combination.

  bands - a subset of bands from this ComponentSampleModel - `int[]`

  returns: a ComponentSampleModel created with a subset
            of bands from this ComponentSampleModel. - `java.awt.image.SampleModel`"
  ([^java.awt.image.PixelInterleavedSampleModel this bands]
    (-> this (.createSubsetSampleModel bands))))

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  ([^java.awt.image.PixelInterleavedSampleModel this]
    (-> this (.hashCode))))

