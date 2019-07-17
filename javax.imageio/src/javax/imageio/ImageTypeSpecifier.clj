(ns javax.imageio.ImageTypeSpecifier
  "A class that allows the format of an image (in particular, its
  SampleModel and ColorModel) to be
  specified in a convenient manner."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio ImageTypeSpecifier]))

(defn ->image-type-specifier
  "Constructor.

  Constructs an ImageTypeSpecifier directly
   from a ColorModel and a SampleModel.
   It is the caller's responsibility to supply compatible
   parameters.

  color-model - a ColorModel. - `java.awt.image.ColorModel`
  sample-model - a SampleModel. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if sampleModel is not compatible with colorModel."
  ([^java.awt.image.ColorModel color-model ^java.awt.image.SampleModel sample-model]
    (new ImageTypeSpecifier color-model sample-model))
  ([^java.awt.image.RenderedImage image]
    (new ImageTypeSpecifier image)))

(defn *create-packed
  "Returns a specifier for a packed image format that will use a
   DirectColorModel and a packed
   SampleModel to store each pixel packed into in a
   single byte, short, or int.

  color-space - the desired ColorSpace. - `java.awt.color.ColorSpace`
  red-mask - a contiguous mask indicated the position of the red channel. - `int`
  green-mask - a contiguous mask indicated the position of the green channel. - `int`
  blue-mask - a contiguous mask indicated the position of the blue channel. - `int`
  alpha-mask - a contiguous mask indicated the position of the alpha channel. - `int`
  transfer-type - the desired SampleModel transfer type. - `int`
  is-alpha-premultiplied - true if the color channels will be premultipled by the alpha channel. - `boolean`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if transferType if not one of DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, or DataBuffer.TYPE_INT."
  ([^java.awt.color.ColorSpace color-space ^Integer red-mask ^Integer green-mask ^Integer blue-mask ^Integer alpha-mask ^Integer transfer-type ^Boolean is-alpha-premultiplied]
    (ImageTypeSpecifier/createPacked color-space red-mask green-mask blue-mask alpha-mask transfer-type is-alpha-premultiplied)))

(defn *create-interleaved
  "Returns a specifier for an interleaved image format that will
   use a ComponentColorModel and a
   PixelInterleavedSampleModel to store each pixel
   component in a separate byte, short, or int.

  color-space - the desired ColorSpace. - `java.awt.color.ColorSpace`
  band-offsets - an array of ints indicating the offsets for each band. - `int[]`
  data-type - the desired data type, as one of the enumerations from the DataBuffer class. - `int`
  has-alpha - true if an alpha channel is desired. - `boolean`
  is-alpha-premultiplied - true if the color channels will be premultipled by the alpha channel. - `boolean`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if bandOffsets.length does not equal the number of color space components, plus 1 if hasAlpha is true."
  ([^java.awt.color.ColorSpace color-space band-offsets ^Integer data-type ^Boolean has-alpha ^Boolean is-alpha-premultiplied]
    (ImageTypeSpecifier/createInterleaved color-space band-offsets data-type has-alpha is-alpha-premultiplied)))

(defn *create-banded
  "Returns a specifier for a banded image format that will use a
   ComponentColorModel and a
   BandedSampleModel to store each channel in a
   separate array.

  color-space - the desired ColorSpace. - `java.awt.color.ColorSpace`
  bank-indices - an array of ints indicating the bank in which each band will be stored. - `int[]`
  band-offsets - an array of ints indicating the starting offset of each band within its bank. - `int[]`
  data-type - the desired data type, as one of the enumerations from the DataBuffer class. - `int`
  has-alpha - true if an alpha channel is desired. - `boolean`
  is-alpha-premultiplied - true if the color channels will be premultipled by the alpha channel. - `boolean`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if dataType is not one of the legal DataBuffer.TYPE_* constants."
  ([^java.awt.color.ColorSpace color-space bank-indices band-offsets ^Integer data-type ^Boolean has-alpha ^Boolean is-alpha-premultiplied]
    (ImageTypeSpecifier/createBanded color-space bank-indices band-offsets data-type has-alpha is-alpha-premultiplied)))

(defn *create-grayscale
  "Returns a specifier for a grayscale plus alpha image format
   that will pack pixels of the given bit depth into array
   elements of the specified data type.

  bits - the number of bits per gray value (1, 2, 4, 8, or 16). - `int`
  data-type - the desired data type, as one of the enumerations from the DataBuffer class. - `int`
  is-signed - true if negative values are to be represented. - `boolean`
  is-alpha-premultiplied - true if the luminance channel will be premultipled by the alpha channel. - `boolean`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if bits is larger than the bit size of the given dataType."
  ([^Integer bits ^Integer data-type ^Boolean is-signed ^Boolean is-alpha-premultiplied]
    (ImageTypeSpecifier/createGrayscale bits data-type is-signed is-alpha-premultiplied))
  ([^Integer bits ^Integer data-type ^Boolean is-signed]
    (ImageTypeSpecifier/createGrayscale bits data-type is-signed)))

(defn *create-indexed
  "Returns a specifier for an indexed-color image format that will pack
   index values of the given bit depth into array elements of
   the specified data type.

  red-lut - an array of bytes containing the red values for each index. - `byte[]`
  green-lut - an array of bytes containing * the green values for each index. - `byte[]`
  blue-lut - an array of bytes containing the blue values for each index. - `byte[]`
  alpha-lut - an array of bytes containing the alpha values for each index, or null to create a fully opaque LUT. - `byte[]`
  bits - the number of bits in each index. - `int`
  data-type - the desired output type, as one of the enumerations from the DataBuffer class. - `int`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if bits is larger than the bit size of the given dataType."
  ([red-lut green-lut blue-lut alpha-lut ^Integer bits ^Integer data-type]
    (ImageTypeSpecifier/createIndexed red-lut green-lut blue-lut alpha-lut bits data-type)))

(defn *create-from-buffered-image-type
  "Returns an ImageTypeSpecifier that encodes
   one of the standard BufferedImage types
   (other than TYPE_CUSTOM).

  buffered-image-type - an int representing one of the standard BufferedImage types. - `int`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if bufferedImageType is not one of the standard types, or is equal to TYPE_CUSTOM."
  ([^Integer buffered-image-type]
    (ImageTypeSpecifier/createFromBufferedImageType buffered-image-type)))

(defn *create-from-rendered-image
  "Returns an ImageTypeSpecifier that encodes the
   layout of a RenderedImage (which may be a
   BufferedImage).

  image - a RenderedImage. - `java.awt.image.RenderedImage`

  returns: an ImageTypeSpecifier with the desired
   characteristics. - `javax.imageio.ImageTypeSpecifier`

  throws: java.lang.IllegalArgumentException - if image is null."
  ([^java.awt.image.RenderedImage image]
    (ImageTypeSpecifier/createFromRenderedImage image)))

(defn get-num-bands
  "Return the number of bands
   specified by this object.  This is the same value as returned by
   SampleModel.getNumBands

  returns: the number of bands in the image. - `int`"
  ([^javax.imageio.ImageTypeSpecifier this]
    (-> this (.getNumBands))))

(defn get-sample-model
  "Returns a SampleModel based on the settings
   encapsulated within this object.  The width and height of the
   SampleModel will be set to the supplied values.

  width - the desired width of the returned SampleModel. - `int`
  height - the desired height of the returned SampleModel. - `int`

  returns: a SampleModel with the given dimensions. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if the product of width and height is greater than Integer.MAX_VALUE"
  ([^javax.imageio.ImageTypeSpecifier this ^Integer width ^Integer height]
    (-> this (.getSampleModel width height)))
  ([^javax.imageio.ImageTypeSpecifier this]
    (-> this (.getSampleModel))))

(defn create-buffered-image
  "Creates a BufferedImage with a given width and
   height according to the specification embodied in this object.

  width - the desired width of the returned BufferedImage. - `int`
  height - the desired height of the returned BufferedImage. - `int`

  returns: a new BufferedImage - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if the product of width and height is greater than Integer.MAX_VALUE, or if the number of array elements needed to store the image is greater than Integer.MAX_VALUE."
  ([^javax.imageio.ImageTypeSpecifier this ^Integer width ^Integer height]
    (-> this (.createBufferedImage width height))))

(defn get-num-components
  "Return the number of color components
   specified by this object.  This is the same value as returned by
   ColorModel.getNumComponents

  returns: the number of components in the image. - `int`"
  ([^javax.imageio.ImageTypeSpecifier this]
    (-> this (.getNumComponents))))

(defn hash-code
  "Returns the hash code for this ImageTypeSpecifier.

  returns: a hash code for this ImageTypeSpecifier - `int`"
  ([^javax.imageio.ImageTypeSpecifier this]
    (-> this (.hashCode))))

(defn get-bits-per-band
  "Return the number of bits used to represent samples of the given band.

  band - the index of the band to be queried, as an int. - `int`

  returns: an int specifying a number of bits. - `int`

  throws: java.lang.IllegalArgumentException - if band is negative or greater than the largest band index."
  ([^javax.imageio.ImageTypeSpecifier this ^Integer band]
    (-> this (.getBitsPerBand band))))

(defn get-color-model
  "Returns the ColorModel specified by this object.

  returns: a ColorModel. - `java.awt.image.ColorModel`"
  ([^javax.imageio.ImageTypeSpecifier this]
    (-> this (.getColorModel))))

(defn equals
  "Returns true if the given Object is
   an ImageTypeSpecifier and has a
   SampleModel and ColorModel that are
   equal to those of this object.

  o - the Object to be compared for equality. - `java.lang.Object`

  returns: true if the given object is an equivalent
   ImageTypeSpecifier. - `boolean`"
  ([^javax.imageio.ImageTypeSpecifier this ^java.lang.Object o]
    (-> this (.equals o))))

(defn get-buffered-image-type
  "Returns an int containing one of the enumerated constant values
   describing image formats from BufferedImage.

  returns: an int representing a
   BufferedImage type. - `int`"
  ([^javax.imageio.ImageTypeSpecifier this]
    (-> this (.getBufferedImageType))))

