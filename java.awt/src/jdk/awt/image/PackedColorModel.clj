(ns jdk.awt.image.PackedColorModel
  "The PackedColorModel class is an abstract
  ColorModel class that works with pixel values which represent
  color and alpha information as separate samples and which pack all
  samples for a single pixel into a single int, short, or byte quantity.
  This class can be used with an arbitrary ColorSpace.  The number of
  color samples in the pixel values must be the same as the number of color
  components in the ColorSpace.  There can be a single alpha
  sample.  The array length is always 1 for those methods that use a
  primitive array pixel representation of type transferType.
  The transfer types supported are DataBuffer.TYPE_BYTE,
  DataBuffer.TYPE_USHORT, and DataBuffer.TYPE_INT.
  Color and alpha samples are stored in the single element of the array
  in bits indicated by bit masks.  Each bit mask must be contiguous and
  masks must not overlap.  The same masks apply to the single int
  pixel representation used by other methods.  The correspondence of
  masks and color/alpha samples is as follows:

   Masks are identified by indices running from 0 through
  getNumComponents - 1.
   The first
  getNumColorComponents
  indices refer to color samples.
   If an alpha sample is present, it corresponds the last index.
   The order of the color indices is specified
  by the ColorSpace.  Typically, this reflects the name of
  the color space type (for example, TYPE_RGB), index 0
  corresponds to red, index 1 to green, and index 2 to blue.


  The translation from pixel values to color/alpha components for
  display or processing purposes is a one-to-one correspondence of
  samples to components.
  A PackedColorModel is typically used with image data
  that uses masks to define packed samples.  For example, a
  PackedColorModel can be used in conjunction with a
  SinglePixelPackedSampleModel to construct a
  BufferedImage.  Normally the masks used by the
  SampleModel and the ColorModel would be the same.
  However, if they are different, the color interpretation of pixel data is
  done according to the masks of the ColorModel.

  A single int pixel representation is valid for all objects
  of this class since it is always possible to represent pixel values
  used with this class in a single int.  Therefore, methods
  that use this representation do not throw an
  IllegalArgumentException due to an invalid pixel value.

  A subclass of PackedColorModel is DirectColorModel,
  which is similar to an X11 TrueColor visual."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image PackedColorModel]))

(defn ->packed-color-model
  "Constructor.

  Constructs a PackedColorModel from the specified
   masks which indicate which bits in an int pixel
   representation contain the alpha, red, green and blue color samples.
   Color components are in the specified ColorSpace, which
   must be of type ColorSpace.TYPE_RGB.  All of the bits in each
   mask must be contiguous and fit in the specified number of
   least significant bits of an int pixel representation.  If
   amask is 0, there is no alpha.  If there is alpha,
   the boolean isAlphaPremultiplied
   specifies how to interpret color and alpha samples
   in pixel values.  If the boolean is true,
   color samples are assumed to have been multiplied by the alpha sample.
   The transparency, trans, specifies what alpha values
   can be represented by this color model.
   The transfer type is the type of primitive array used to represent
   pixel values.

  space - the specified ColorSpace - `java.awt.color.ColorSpace`
  bits - the number of bits in the pixel values - `int`
  rmask - specifies the mask representing the bits of the pixel values that represent the red color component - `int`
  gmask - specifies the mask representing the bits of the pixel values that represent the green color component - `int`
  bmask - specifies the mask representing the bits of the pixel values that represent the blue color component - `int`
  amask - specifies the mask representing the bits of the pixel values that represent the alpha component - `int`
  is-alpha-premultiplied - true if color samples are premultiplied by the alpha sample; false otherwise - `boolean`
  trans - specifies the alpha value that can be represented by this color model - `int`
  transfer-type - the type of array used to represent pixel values - `int`

  throws: java.lang.IllegalArgumentException - if space is not a TYPE_RGB space"
  ([space bits rmask gmask bmask amask is-alpha-premultiplied trans transfer-type]
    (new PackedColorModel space bits rmask gmask bmask amask is-alpha-premultiplied trans transfer-type))
  ([space bits color-mask-array alpha-mask is-alpha-premultiplied trans transfer-type]
    (new PackedColorModel space bits color-mask-array alpha-mask is-alpha-premultiplied trans transfer-type)))

(defn get-mask
  "Returns the mask indicating which bits in a pixel
   contain the specified color/alpha sample.  For color
   samples, index corresponds to the placement of color
   sample names in the color space.  Thus, an index
   equal to 0 for a CMYK ColorSpace would correspond to
   Cyan and an index equal to 1 would correspond to
   Magenta.  If there is alpha, the alpha index would be:


        alphaIndex = numComponents() - 1;

  index - the specified color or alpha sample - `int`

  returns: the mask, which indicates which bits of the int
           pixel representation contain the color or alpha sample specified
           by index. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if index is greater than the number of components minus 1 in this PackedColorModel or if index is less than zero"
  ([this index]
    (-> this (.getMask index))))

(defn get-masks
  "Returns a mask array indicating which bits in a pixel
   contain the color and alpha samples.

  returns: the mask array , which indicates which bits of the
           int pixel
           representation contain the color or alpha samples. - `int[]`"
  ([this]
    (-> this (.getMasks))))

(defn create-compatible-sample-model
  "Creates a SampleModel with the specified width and
   height that has a data layout compatible with this
   ColorModel.

  w - the width (in pixels) of the region of the image data described - `int`
  h - the height (in pixels) of the region of the image data described - `int`

  returns: the newly created SampleModel. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if w or h is not greater than 0"
  ([this w h]
    (-> this (.createCompatibleSampleModel w h))))

(defn compatible-sample-model?
  "Checks if the specified SampleModel is compatible
   with this ColorModel.  If sm is
   null, this method returns false.

  sm - the specified SampleModel, or null - `java.awt.image.SampleModel`

  returns: true if the specified SampleModel
           is compatible with this ColorModel;
           false otherwise. - `boolean`"
  ([this sm]
    (-> this (.isCompatibleSampleModel sm))))

(defn get-alpha-raster
  "Returns a WritableRaster representing the alpha channel of
   an image, extracted from the input WritableRaster.
   This method assumes that WritableRaster objects
   associated with this ColorModel store the alpha band,
   if present, as the last band of image data.  Returns null
   if there is no separate spatial alpha channel associated with this
   ColorModel.  This method creates a new
   WritableRaster, but shares the data array.

  raster - a WritableRaster containing an image - `java.awt.image.WritableRaster`

  returns: a WritableRaster that represents the alpha
           channel of the image contained in raster. - `java.awt.image.WritableRaster`"
  ([this raster]
    (-> this (.getAlphaRaster raster))))

(defn equals
  "Tests if the specified Object is an instance
   of PackedColorModel and equals this
   PackedColorModel.

  obj - the Object to test for equality - `java.lang.Object`

  returns: true if the specified Object
   is an instance of PackedColorModel and equals this
   PackedColorModel; false otherwise. - `boolean`"
  ([this obj]
    (-> this (.equals obj))))

