(ns jdk.awt.image.DirectColorModel
  "The DirectColorModel class is a ColorModel
  class that works with pixel values that represent RGB
  color and alpha information as separate samples and that pack all
  samples for a single pixel into a single int, short, or byte quantity.
  This class can be used only with ColorSpaces of type ColorSpace.TYPE_RGB.
  In addition, for each component of the ColorSpace, the minimum
  normalized component value obtained via the getMinValue()
  method of ColorSpace must be 0.0, and the maximum value obtained via
  the getMaxValue() method must be 1.0 (these min/max
  values are typical for RGB spaces).
  There must be three color samples in the pixel values and there can
  be a single alpha sample.  For those methods that use a primitive array
  pixel representation of type transferType, the array
  length is always one.  The transfer
  types supported are DataBuffer.TYPE_BYTE,
  DataBuffer.TYPE_USHORT, and DataBuffer.TYPE_INT.
  Color and alpha samples are stored in the single
  element of the array in bits indicated by bit masks.  Each bit mask
  must be contiguous and masks must not overlap.  The same masks apply to
  the single int pixel representation used by other methods.  The
  correspondence of masks and color/alpha samples is as follows:

   Masks are identified by indices running from 0 through 2
  if no alpha is present, or 3 if an alpha is present.
   The first three indices refer to color samples;
  index 0 corresponds to red, index 1 to green, and index 2 to blue.
   Index 3 corresponds to the alpha sample, if present.


  The translation from pixel values to color/alpha components for
  display or processing purposes is a one-to-one correspondence of
  samples to components.  A DirectColorModel is
  typically used with image data which uses masks to define packed
  samples.  For example, a DirectColorModel can be used in
  conjunction with a SinglePixelPackedSampleModel to
  construct a BufferedImage.  Normally the masks used by the
  SampleModel and the ColorModel would be the
  same.  However, if they are different, the color interpretation
  of pixel data will be done according to the masks of the
  ColorModel.

  A single int pixel representation is valid for all objects of this
  class, since it is always possible to represent pixel values used with
  this class in a single int.  Therefore, methods which use this
  representation will not throw an IllegalArgumentException
  due to an invalid pixel value.

  This color model is similar to an X11 TrueColor visual.
  The default RGB ColorModel specified by the
  getRGBdefault method is a
  DirectColorModel with the following parameters:


  Number of bits:        32
  Red mask:              0x00ff0000
  Green mask:            0x0000ff00
  Blue mask:             0x000000ff
  Alpha mask:            0xff000000
  Color space:           sRGB
  isAlphaPremultiplied:  False
  Transparency:          Transparency.TRANSLUCENT
  transferType:          DataBuffer.TYPE_INT

  Many of the methods in this class are final. This is because the
  underlying native graphics code makes assumptions about the layout
  and operation of this class and those assumptions are reflected in
  the implementations of the methods here that are marked final.  You
  can subclass this class for other reasons, but you cannot override
  or modify the behavior of those methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image DirectColorModel]))

(defn ->direct-color-model
  "Constructor.

  Constructs a DirectColorModel from the specified
   parameters.  Color components are in the specified
   ColorSpace, which must be of type ColorSpace.TYPE_RGB
   and have minimum normalized component values which are all 0.0
   and maximum values which are all 1.0.
   The masks specify which bits in an int pixel
   representation contain the red, green and blue color samples and
   the alpha sample, if present.  If amask is 0, pixel
   values do not contain alpha information and all pixels are treated
   as opaque, which means that alpha = 1.0.  All of the
   bits in each mask must be contiguous and fit in the specified number
   of least significant bits of an int pixel
   representation.  If there is alpha, the boolean
   isAlphaPremultiplied specifies how to interpret
   color and alpha samples in pixel values.  If the boolean
   is true, color samples are assumed to have been
   multiplied by the alpha sample.  The transparency value is
   Transparency.OPAQUE, if no alpha is present, or
   Transparency.TRANSLUCENT otherwise.  The transfer type
   is the type of primitive array used to represent pixel values and
   must be one of DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, or
   DataBuffer.TYPE_INT.

  space - the specified ColorSpace - `java.awt.color.ColorSpace`
  bits - the number of bits in the pixel values; for example, the sum of the number of bits in the masks. - `int`
  rmask - specifies a mask indicating which bits in an integer pixel contain the red component - `int`
  gmask - specifies a mask indicating which bits in an integer pixel contain the green component - `int`
  bmask - specifies a mask indicating which bits in an integer pixel contain the blue component - `int`
  amask - specifies a mask indicating which bits in an integer pixel contain the alpha component - `int`
  is-alpha-premultiplied - true if color samples are premultiplied by the alpha sample; false otherwise - `boolean`
  transfer-type - the type of array used to represent pixel values - `int`

  throws: java.lang.IllegalArgumentException - if space is not a TYPE_RGB space or if the min/max normalized component values are not 0.0/1.0."
  ([^java.awt.color.ColorSpace space ^Integer bits ^Integer rmask ^Integer gmask ^Integer bmask ^Integer amask ^Boolean is-alpha-premultiplied ^Integer transfer-type]
    (new DirectColorModel space bits rmask gmask bmask amask is-alpha-premultiplied transfer-type))
  ([^Integer bits ^Integer rmask ^Integer gmask ^Integer bmask ^Integer amask]
    (new DirectColorModel bits rmask gmask bmask amask))
  ([^Integer bits ^Integer rmask ^Integer gmask ^Integer bmask]
    (new DirectColorModel bits rmask gmask bmask)))

(defn get-green-mask
  "Returns the mask indicating which bits in an int pixel
   representation contain the green color component.

  returns: the mask, which indicates which bits of the int
           pixel representation contain the green color sample. - `int`"
  ([^java.awt.image.DirectColorModel this]
    (-> this (.getGreenMask))))

(defn get-data-element
  "Returns a pixel value represented as an int in this
   ColorModel, given an array of unnormalized color/alpha
   components.   An ArrayIndexOutOfBoundsException is
   thrown if the components array is
   not large enough to hold all the color and alpha components, starting
   at offset.

  components - an array of unnormalized color and alpha components - `int[]`
  offset - the index into components at which to begin retrieving the color and alpha components - `int`

  returns: an int pixel value in this
   ColorModel corresponding to the specified components. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the components array is not large enough to hold all of the color and alpha components starting at offset"
  ([^java.awt.image.DirectColorModel this components ^Integer offset]
    (-> this (.getDataElement components offset))))

(defn get-rgb
  "Returns the color/alpha components of the pixel in the default
   RGB color model format.  A color conversion is done if necessary.
   The pixel value is specified as an int.
   The returned value is in a non pre-multiplied format.  Thus, if
   the alpha is premultiplied, this method divides it out of the
   color components.  If the alpha value is 0, for example, the color
   values are each 0.

  pixel - the specified pixel - `int`

  returns: the RGB value of the color/alpha components of the specified
           pixel. - `int`"
  ([^java.awt.image.DirectColorModel this ^Integer pixel]
    (-> this (.getRGB pixel))))

(defn get-alpha-mask
  "Returns the mask indicating which bits in an int pixel
   representation contain the alpha component.

  returns: the mask, which indicates which bits of the int
           pixel representation contain the alpha sample. - `int`"
  ([^java.awt.image.DirectColorModel this]
    (-> this (.getAlphaMask))))

(defn get-data-elements
  "Returns a data element array representation of a pixel in this
   ColorModel, given an array of unnormalized color/alpha
   components.
   This array can then be passed to the setDataElements
   method of a WritableRaster object.
   An ArrayIndexOutOfBoundsException is thrown if the
   components array
   is not large enough to hold all the color and alpha components,
   starting at offset.  If the obj variable is
   null, a new array is allocated.  If obj is
   not null, it must be a primitive array
   of type transferType; otherwise, a
   ClassCastException is thrown.
   An ArrayIndexOutOfBoundsException is thrown if
   obj is not large enough to hold a pixel value for this
   ColorModel.
   Since DirectColorModel can be subclassed, subclasses
   inherit the implementation of this method and if they don't
   override it then they throw an exception if they use an unsupported
   transferType.

  components - an array of unnormalized color and alpha components - `int[]`
  offset - the index into components at which to begin retrieving color and alpha components - `int`
  obj - the Object representing an array of color and alpha components - `java.lang.Object`

  returns: an Object representing an array of color and
   alpha components. - `java.lang.Object`

  throws: java.lang.ClassCastException - if obj is not a primitive array of type transferType"
  ([^java.awt.image.DirectColorModel this components ^Integer offset ^java.lang.Object obj]
    (-> this (.getDataElements components offset obj)))
  ([^java.awt.image.DirectColorModel this ^Integer rgb ^java.lang.Object pixel]
    (-> this (.getDataElements rgb pixel))))

(defn to-string
  "Returns a String that represents this
   DirectColorModel.

  returns: a String representing this
   DirectColorModel. - `java.lang.String`"
  ([^java.awt.image.DirectColorModel this]
    (-> this (.toString))))

(defn get-red-mask
  "Returns the mask indicating which bits in an int pixel
   representation contain the red color component.

  returns: the mask, which indicates which bits of the int
           pixel representation contain the red color sample. - `int`"
  ([^java.awt.image.DirectColorModel this]
    (-> this (.getRedMask))))

(defn get-alpha
  "Returns the alpha component for the specified pixel, scaled
   from 0 to 255.  The pixel value is specified as an int.

  pixel - the specified pixel - `int`

  returns: the value of the alpha component of pixel
           from 0 to 255. - `int`"
  ([^java.awt.image.DirectColorModel this ^Integer pixel]
    (-> this (.getAlpha pixel))))

(defn get-red
  "Returns the red color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A
   color conversion is done if necessary.  The pixel value is specified
   as an int.
   The returned value is a non pre-multiplied value.  Thus, if the
   alpha is premultiplied, this method divides it out before returning
   the value.  If the alpha value is 0, for example, the red value
   is 0.

  pixel - the specified pixel - `int`

  returns: the red color component for the specified pixel, from
           0 to 255 in the sRGB ColorSpace. - `int`"
  ([^java.awt.image.DirectColorModel this ^Integer pixel]
    (-> this (.getRed pixel))))

(defn get-green
  "Returns the green color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A
   color conversion is done if necessary.  The pixel value is specified
   as an int.
   The returned value is a non pre-multiplied value.  Thus, if the
   alpha is premultiplied, this method divides it out before returning
   the value.  If the alpha value is 0, for example, the green value
   is 0.

  pixel - the specified pixel - `int`

  returns: the green color component for the specified pixel, from
           0 to 255 in the sRGB ColorSpace. - `int`"
  ([^java.awt.image.DirectColorModel this ^Integer pixel]
    (-> this (.getGreen pixel))))

(defn get-components
  "Returns an array of unnormalized color/alpha components given a pixel
   in this ColorModel.  The pixel value is specified as an
   int.  If the components array is
   null, a new array is allocated.  The
   components array is returned.  Color/alpha components are
   stored in the components array starting at
   offset, even if the array is allocated by this method.
   An ArrayIndexOutOfBoundsException is thrown if the
   components array is not null and is not large
   enough to hold all the color and alpha components, starting at
   offset.

  pixel - the specified pixel - `int`
  components - the array to receive the color and alpha components of the specified pixel - `int[]`
  offset - the offset into the components array at which to start storing the color and alpha components - `int`

  returns: an array containing the color and alpha components of the
   specified pixel starting at the specified offset. - `int[]`"
  ([^java.awt.image.DirectColorModel this ^Integer pixel components ^Integer offset]
    (-> this (.getComponents pixel components offset))))

(defn compatible-raster?
  "Returns true if raster is compatible
   with this ColorModel and false if it is
   not.

  raster - the Raster object to test for compatibility - `java.awt.image.Raster`

  returns: true if raster is compatible
   with this ColorModel; false otherwise. - `boolean`"
  ([^java.awt.image.DirectColorModel this ^java.awt.image.Raster raster]
    (-> this (.isCompatibleRaster raster))))

(defn coerce-data
  "Forces the raster data to match the state specified in the
   isAlphaPremultiplied variable, assuming the data is
   currently correctly described by this ColorModel.  It
   may multiply or divide the color raster data by alpha, or do
   nothing if the data is in the correct state.  If the data needs to
   be coerced, this method will also return an instance of this
   ColorModel with the isAlphaPremultiplied
   flag set appropriately.  This method will throw a
   UnsupportedOperationException if this transferType is
   not supported by this ColorModel.  Since
   ColorModel can be subclassed, subclasses inherit the
   implementation of this method and if they don't override it then
   they throw an exception if they use an unsupported transferType.

  raster - the WritableRaster data - `java.awt.image.WritableRaster`
  is-alpha-premultiplied - true if the alpha is premultiplied; false otherwise - `boolean`

  returns: a ColorModel object that represents the
   coerced data. - `java.awt.image.ColorModel`

  throws: java.lang.UnsupportedOperationException - if this transferType is not supported by this color model"
  ([^java.awt.image.DirectColorModel this ^java.awt.image.WritableRaster raster ^Boolean is-alpha-premultiplied]
    (-> this (.coerceData raster is-alpha-premultiplied))))

(defn create-compatible-writable-raster
  "Creates a WritableRaster with the specified width and
   height that has a data layout (SampleModel) compatible
   with this ColorModel.

  w - the width to apply to the new WritableRaster - `int`
  h - the height to apply to the new WritableRaster - `int`

  returns: a WritableRaster object with the specified
   width and height. - `java.awt.image.WritableRaster`

  throws: java.lang.IllegalArgumentException - if w or h is less than or equal to zero"
  ([^java.awt.image.DirectColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleWritableRaster w h))))

(defn get-blue
  "Returns the blue color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A
   color conversion is done if necessary.  The pixel value is specified
   as an int.
   The returned value is a non pre-multiplied value.  Thus, if the
   alpha is premultiplied, this method divides it out before returning
   the value.  If the alpha value is 0, for example, the blue value
   is 0.

  pixel - the specified pixel - `int`

  returns: the blue color component for the specified pixel, from
           0 to 255 in the sRGB ColorSpace. - `int`"
  ([^java.awt.image.DirectColorModel this ^Integer pixel]
    (-> this (.getBlue pixel))))

(defn get-blue-mask
  "Returns the mask indicating which bits in an int pixel
   representation contain the blue color component.

  returns: the mask, which indicates which bits of the int
           pixel representation contain the blue color sample. - `int`"
  ([^java.awt.image.DirectColorModel this]
    (-> this (.getBlueMask))))

