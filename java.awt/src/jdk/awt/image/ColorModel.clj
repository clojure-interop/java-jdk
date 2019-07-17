(ns jdk.awt.image.ColorModel
  "The ColorModel abstract class encapsulates the
  methods for translating a pixel value to color components
  (for example, red, green, and blue) and an alpha component.
  In order to render an image to the screen, a printer, or another
  image, pixel values must be converted to color and alpha components.
  As arguments to or return values from methods of this class,
  pixels are represented as 32-bit ints or as arrays of primitive types.
  The number, order, and interpretation of color components for a
  ColorModel is specified by its ColorSpace.
  A ColorModel used with pixel data that does not include
  alpha information treats all pixels as opaque, which is an alpha
  value of 1.0.

  This ColorModel class supports two representations of
  pixel values.  A pixel value can be a single 32-bit int or an
  array of primitive types.  The Java(tm) Platform 1.0 and 1.1 APIs
  represented pixels as single byte or single
  int values.  For purposes of the ColorModel
  class, pixel value arguments were passed as ints.  The Java(tm) 2
  Platform API introduced additional classes for representing images.
  With BufferedImage or RenderedImage
  objects, based on Raster and SampleModel classes, pixel
  values might not be conveniently representable as a single int.
  Consequently, ColorModel now has methods that accept
  pixel values represented as arrays of primitive types.  The primitive
  type used by a particular ColorModel object is called its
  transfer type.

  ColorModel objects used with images for which pixel values
  are not conveniently representable as a single int throw an
  IllegalArgumentException when methods taking a single int pixel
  argument are called.  Subclasses of ColorModel must
  specify the conditions under which this occurs.  This does not
  occur with DirectColorModel or IndexColorModel objects.

  Currently, the transfer types supported by the Java 2D(tm) API are
  DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, DataBuffer.TYPE_INT,
  DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT, and DataBuffer.TYPE_DOUBLE.
  Most rendering operations will perform much faster when using ColorModels
  and images based on the first three of these types.  In addition, some
  image filtering operations are not supported for ColorModels and
  images based on the latter three types.
  The transfer type for a particular ColorModel object is
  specified when the object is created, either explicitly or by default.
  All subclasses of ColorModel must specify what the
  possible transfer types are and how the number of elements in the
  primitive arrays representing pixels is determined.

  For BufferedImages, the transfer type of its
  Raster and of the Raster object's
  SampleModel (available from the
  getTransferType methods of these classes) must match that
  of the ColorModel.  The number of elements in an array
  representing a pixel for the Raster and
  SampleModel (available from the
  getNumDataElements methods of these classes) must match
  that of the ColorModel.

  The algorithm used to convert from pixel values to color and alpha
  components varies by subclass.  For example, there is not necessarily
  a one-to-one correspondence between samples obtained from the
  SampleModel of a BufferedImage object's
  Raster and color/alpha components.  Even when
  there is such a correspondence, the number of bits in a sample is not
  necessarily the same as the number of bits in the corresponding color/alpha
  component.  Each subclass must specify how the translation from
  pixel values to color/alpha components is done.

  Methods in the ColorModel class use two different
  representations of color and alpha components - a normalized form
  and an unnormalized form.  In the normalized form, each component is a
  float value between some minimum and maximum values.  For
  the alpha component, the minimum is 0.0 and the maximum is 1.0.  For
  color components the minimum and maximum values for each component can
  be obtained from the ColorSpace object.  These values
  will often be 0.0 and 1.0 (e.g. normalized component values for the
  default sRGB color space range from 0.0 to 1.0), but some color spaces
  have component values with different upper and lower limits.  These
  limits can be obtained using the getMinValue and
  getMaxValue methods of the ColorSpace
  class.  Normalized color component values are not premultiplied.
  All ColorModels must support the normalized form.

  In the unnormalized
  form, each component is an unsigned integral value between 0 and
  2n - 1, where n is the number of significant bits for a
  particular component.  If pixel values for a particular
  ColorModel represent color samples premultiplied by
  the alpha sample, unnormalized color component values are
  also premultiplied.  The unnormalized form is used only with instances
  of ColorModel whose ColorSpace has minimum
  component values of 0.0 for all components and maximum values of
  1.0 for all components.
  The unnormalized form for color and alpha components can be a convenient
  representation for ColorModels whose normalized component
  values all lie
  between 0.0 and 1.0.  In such cases the integral value 0 maps to 0.0 and
  the value 2n - 1 maps to 1.0.  In other cases, such as
  when the normalized component values can be either negative or positive,
  the unnormalized form is not convenient.  Such ColorModel
  objects throw an IllegalArgumentException when methods involving
  an unnormalized argument are called.  Subclasses of ColorModel
  must specify the conditions under which this occurs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ColorModel]))

(defn ->color-model
  "Constructor.

  Constructs a ColorModel that translates pixels of the
   specified number of bits to color/alpha components.  The color
   space is the default RGB ColorSpace, which is sRGB.
   Pixel values are assumed to include alpha information.  If color
   and alpha information are represented in the pixel value as
   separate spatial bands, the color bands are assumed not to be
   premultiplied with the alpha value. The transparency type is
   java.awt.Transparency.TRANSLUCENT.  The transfer type will be the
   smallest of DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
   or DataBuffer.TYPE_INT that can hold a single pixel
   (or DataBuffer.TYPE_UNDEFINED if bits is greater
   than 32).  Since this constructor has no information about the
   number of bits per color and alpha component, any subclass calling
   this constructor should override any method that requires this
   information.

  bits - the number of bits of a pixel - `int`

  throws: java.lang.IllegalArgumentException - if the number of bits in bits is less than 1"
  ([^Integer bits]
    (new ColorModel bits)))

(defn *get-rg-bdefault
  "Returns a DirectColorModel that describes the default
   format for integer RGB values used in many of the methods in the
   AWT image interfaces for the convenience of the programmer.
   The color space is the default ColorSpace, sRGB.
   The format for the RGB values is an integer with 8 bits
   each of alpha, red, green, and blue color components ordered
   correspondingly from the most significant byte to the least
   significant byte, as in:  0xAARRGGBB.  Color components are
   not premultiplied by the alpha component.  This format does not
   necessarily represent the native or the most efficient
   ColorModel for a particular device or for all images.
   It is merely used as a common color model format.

  returns: a DirectColorModelobject describing default
            RGB values. - `java.awt.image.ColorModel`"
  ([]
    (ColorModel/getRGBdefault )))

(defn get-transparency
  "Returns the transparency.  Returns either OPAQUE, BITMASK,
   or TRANSLUCENT.

  returns: the transparency of this ColorModel. - `int`"
  ([^java.awt.image.ColorModel this]
    (-> this (.getTransparency))))

(defn get-normalized-components
  "Returns an array of all of the color/alpha components in normalized
   form, given an unnormalized component array.  Unnormalized components
   are unsigned integral values between 0 and 2n - 1, where
   n is the number of bits for a particular component.  Normalized
   components are float values between a per component minimum and
   maximum specified by the ColorSpace object for this
   ColorModel.  An IllegalArgumentException
   will be thrown if color component values for this
   ColorModel are not conveniently representable in the
   unnormalized form.  If the
   normComponents array is null, a new array
   will be allocated.  The normComponents array
   will be returned.  Color/alpha components are stored in the
   normComponents array starting at
   normOffset (even if the array is allocated by this
   method).  An ArrayIndexOutOfBoundsException is thrown
   if the normComponents array is not null
   and is not large enough to hold all the color and alpha components
   (starting at normOffset).  An
   IllegalArgumentException is thrown if the
   components array is not large enough to hold all the
   color and alpha components starting at offset.

   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  The default implementation
   of this method in this abstract class assumes that component values
   for this class are conveniently representable in the unnormalized
   form.  Therefore, subclasses which may
   have instances which do not support the unnormalized form must
   override this method.

  components - an array containing unnormalized components - `int[]`
  offset - the offset into the components array at which to start retrieving unnormalized components - `int`
  norm-components - an array that receives the normalized components - `float[]`
  norm-offset - the index into normComponents at which to begin storing normalized components - `int`

  returns: an array containing normalized color and alpha
   components. - `float[]`

  throws: java.lang.IllegalArgumentException - If the component values for this ColorModel are not conveniently representable in the unnormalized form."
  ([^java.awt.image.ColorModel this components ^Integer offset norm-components ^Integer norm-offset]
    (-> this (.getNormalizedComponents components offset norm-components norm-offset)))
  ([^java.awt.image.ColorModel this ^java.lang.Object pixel norm-components ^Integer norm-offset]
    (-> this (.getNormalizedComponents pixel norm-components norm-offset))))

(defn compatible-sample-model?
  "Checks if the SampleModel is compatible with this
   ColorModel.
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  sm - the specified SampleModel - `java.awt.image.SampleModel`

  returns: true if the specified SampleModel
   is compatible with this ColorModel; false
   otherwise. - `boolean`

  throws: java.lang.UnsupportedOperationException - if this method is not supported by this ColorModel"
  ([^java.awt.image.ColorModel this ^java.awt.image.SampleModel sm]
    (-> this (.isCompatibleSampleModel sm))))

(defn get-alpha-raster
  "Returns a Raster representing the alpha channel of an
   image, extracted from the input Raster, provided that
   pixel values of this ColorModel represent color and
   alpha information as separate spatial bands (e.g.
   ComponentColorModel and DirectColorModel).
   This method assumes that Raster objects associated
   with such a ColorModel store the alpha band, if
   present, as the last band of image data.  Returns null
   if there is no separate spatial alpha channel associated with this
   ColorModel.  If this is an
   IndexColorModel which has alpha in the lookup table,
   this method will return null since
   there is no spatially discrete alpha channel.
   This method will create a new Raster (but will share
   the data array).
   Since ColorModel is an abstract class, any instance
   is an instance of a subclass.  Subclasses must override this
   method to get any behavior other than returning null
   because the implementation in this abstract class returns
   null.

  raster - the specified Raster - `java.awt.image.WritableRaster`

  returns: a Raster representing the alpha channel of
   an image, obtained from the specified Raster. - `java.awt.image.WritableRaster`"
  ([^java.awt.image.ColorModel this ^java.awt.image.WritableRaster raster]
    (-> this (.getAlphaRaster raster))))

(defn get-data-element
  "Returns a pixel value represented as an int in this
   ColorModel, given an array of unnormalized color/alpha
   components.  This method will throw an
   IllegalArgumentException if component values for this
   ColorModel are not conveniently representable as a
   single int or if color component values for this
   ColorModel are not conveniently representable in the
   unnormalized form.  An
   ArrayIndexOutOfBoundsException is thrown if  the
   components array is not large enough to hold all the
   color and alpha components (starting at offset).
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  components - an array of unnormalized color and alpha components - `int[]`
  offset - the index into components at which to begin retrieving the color and alpha components - `int`

  returns: an int pixel value in this
   ColorModel corresponding to the specified components. - `int`

  throws: java.lang.IllegalArgumentException - if component values for this ColorModel are not conveniently representable in the unnormalized form"
  ([^java.awt.image.ColorModel this components ^Integer offset]
    (-> this (.getDataElement components offset))))

(defn get-rgb
  "Returns the color/alpha components of the pixel in the default
   RGB color model format.  A color conversion is done if necessary.
   The pixel value is specified as an int.
   An IllegalArgumentException thrown if pixel values
   for this ColorModel are not conveniently representable
   as a single int.  The returned value is in a non
   pre-multiplied format. For example, if the alpha is premultiplied,
   this method divides it out of the color components.  If the alpha
   value is 0, the color values are 0.

  pixel - the specified pixel - `int`

  returns: the RGB value of the color/alpha components of the
            specified pixel. - `int`"
  ([^java.awt.image.ColorModel this ^Integer pixel]
    (-> this (.getRGB pixel))))

(defn get-transfer-type
  "Returns the transfer type of this ColorModel.
   The transfer type is the type of primitive array used to represent
   pixel values as arrays.

  returns: the transfer type. - `int`"
  ([^java.awt.image.ColorModel this]
    (-> this (.getTransferType))))

(defn get-data-elements
  "Returns a data element array representation of a pixel in this
   ColorModel, given an array of unnormalized color/alpha
   components.  This array can then be passed to the
   setDataElements method of a WritableRaster
   object.  This method will throw an IllegalArgumentException
   if color component values for this ColorModel are not
   conveniently representable in the unnormalized form.
   An ArrayIndexOutOfBoundsException is thrown
   if the components array is not large enough to hold
   all the color and alpha components (starting at
   offset).  If the obj variable is
   null, a new array will be allocated.  If
   obj is not null, it must be a primitive
   array of type transferType; otherwise, a
   ClassCastException is thrown.  An
   ArrayIndexOutOfBoundsException is thrown if
   obj is not large enough to hold a pixel value for this
   ColorModel.
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  components - an array of unnormalized color and alpha components - `int[]`
  offset - the index into components at which to begin retrieving color and alpha components - `int`
  obj - the Object representing an array of color and alpha components - `java.lang.Object`

  returns: an Object representing an array of color and
   alpha components. - `java.lang.Object`

  throws: java.lang.ClassCastException - if obj is not a primitive array of type transferType"
  ([^java.awt.image.ColorModel this components ^Integer offset ^java.lang.Object obj]
    (-> this (.getDataElements components offset obj)))
  ([^java.awt.image.ColorModel this ^Integer rgb ^java.lang.Object pixel]
    (-> this (.getDataElements rgb pixel))))

(defn get-unnormalized-components
  "Returns an array of all of the color/alpha components in unnormalized
   form, given a normalized component array.  Unnormalized components
   are unsigned integral values between 0 and 2n - 1, where
   n is the number of bits for a particular component.  Normalized
   components are float values between a per component minimum and
   maximum specified by the ColorSpace object for this
   ColorModel.  An IllegalArgumentException
   will be thrown if color component values for this
   ColorModel are not conveniently representable in the
   unnormalized form.  If the
   components array is null, a new array
   will be allocated.  The components array will
   be returned.  Color/alpha components are stored in the
   components array starting at offset (even
   if the array is allocated by this method). An
   ArrayIndexOutOfBoundsException is thrown if the
   components array is not null and is not
   large enough to hold all the color and alpha
   components (starting at offset).  An
   IllegalArgumentException is thrown if the
   normComponents array is not large enough to hold
   all the color and alpha components starting at
   normOffset.

  norm-components - an array containing normalized components - `float[]`
  norm-offset - the offset into the normComponents array at which to start retrieving normalized components - `int`
  components - an array that receives the components from normComponents - `int[]`
  offset - the index into components at which to begin storing normalized components from normComponents - `int`

  returns: an array containing unnormalized color and alpha
   components. - `int[]`

  throws: java.lang.IllegalArgumentException - if the length of normComponents minus normOffset is less than numComponents"
  ([^java.awt.image.ColorModel this norm-components ^Integer norm-offset components ^Integer offset]
    (-> this (.getUnnormalizedComponents norm-components norm-offset components offset))))

(defn to-string
  "Returns the String representation of the contents of
   this ColorModelobject.

  returns: a String representing the contents of this
   ColorModel object. - `java.lang.String`"
  ([^java.awt.image.ColorModel this]
    (-> this (.toString))))

(defn get-alpha
  "Returns the alpha component for the specified pixel, scaled
   from 0 to 255.  The pixel value is specified as an int.
   An IllegalArgumentException is thrown if pixel
   values for this ColorModel are not conveniently
   representable as a single int.

  pixel - the specified pixel - `int`

  returns: the value of alpha component of the specified pixel. - `int`"
  ([^java.awt.image.ColorModel this ^Integer pixel]
    (-> this (.getAlpha pixel))))

(defn get-red
  "Returns the red color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A color conversion
   is done if necessary.  The pixel value is specified as an int.
   An IllegalArgumentException is thrown if pixel
   values for this ColorModel are not conveniently
   representable as a single int.  The returned value is not a
   pre-multiplied value.  For example, if the
   alpha is premultiplied, this method divides it out before returning
   the value.  If the alpha value is 0, the red value is 0.

  pixel - a specified pixel - `int`

  returns: the value of the red component of the specified pixel. - `int`"
  ([^java.awt.image.ColorModel this ^Integer pixel]
    (-> this (.getRed pixel))))

(defn get-pixel-size
  "Returns the number of bits per pixel described by this
   ColorModel.

  returns: the number of bits per pixel. - `int`"
  ([^java.awt.image.ColorModel this]
    (-> this (.getPixelSize))))

(defn get-green
  "Returns the green color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A color conversion
   is done if necessary.  The pixel value is specified as an int.
   An IllegalArgumentException is thrown if pixel
   values for this ColorModel are not conveniently
   representable as a single int.  The returned value is a non
   pre-multiplied value.  For example, if the alpha is premultiplied,
   this method divides it out before returning
   the value.  If the alpha value is 0, the green value is 0.

  pixel - the specified pixel - `int`

  returns: the value of the green component of the specified pixel. - `int`"
  ([^java.awt.image.ColorModel this ^Integer pixel]
    (-> this (.getGreen pixel))))

(defn has-alpha?
  "Returns whether or not alpha is supported in this
   ColorModel.

  returns: true if alpha is supported in this
   ColorModel; false otherwise. - `boolean`"
  ([^java.awt.image.ColorModel this]
    (-> this (.hasAlpha))))

(defn get-color-space
  "Returns the ColorSpace associated with this
   ColorModel.

  returns: the ColorSpace of this
   ColorModel. - `java.awt.color.ColorSpace`"
  ([^java.awt.image.ColorModel this]
    (-> this (.getColorSpace))))

(defn get-components
  "Returns an array of unnormalized color/alpha components given a pixel
   in this ColorModel.  The pixel value is specified as
   an int.  An IllegalArgumentException
   will be thrown if pixel values for this ColorModel are
   not conveniently representable as a single int or if
   color component values for this ColorModel are not
   conveniently representable in the unnormalized form.
   For example, this method can be used to retrieve the
   components for a specific pixel value in a
   DirectColorModel.  If the components array is
   null, a new array will be allocated.  The
   components array will be returned.  Color/alpha components are
   stored in the components array starting at offset
   (even if the array is allocated by this method).  An
   ArrayIndexOutOfBoundsException is thrown if  the
   components array is not null and is not large
   enough to hold all the color and alpha components (starting at offset).
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  pixel - the specified pixel - `int`
  components - the array to receive the color and alpha components of the specified pixel - `int[]`
  offset - the offset into the components array at which to start storing the color and alpha components - `int`

  returns: an array containing the color and alpha components of the
   specified pixel starting at the specified offset. - `int[]`

  throws: java.lang.UnsupportedOperationException - if this method is not supported by this ColorModel"
  ([^java.awt.image.ColorModel this ^Integer pixel components ^Integer offset]
    (-> this (.getComponents pixel components offset))))

(defn compatible-raster?
  "Returns true if raster is compatible
   with this ColorModel and false if it is
   not.
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  raster - the Raster object to test for compatibility - `java.awt.image.Raster`

  returns: true if raster is compatible
   with this ColorModel. - `boolean`

  throws: java.lang.UnsupportedOperationException - if this method has not been implemented for this ColorModel"
  ([^java.awt.image.ColorModel this ^java.awt.image.Raster raster]
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
   UnsupportedOperationException if it is not supported
   by this ColorModel.
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  raster - the WritableRaster data - `java.awt.image.WritableRaster`
  is-alpha-premultiplied - true if the alpha is premultiplied; false otherwise - `boolean`

  returns: a ColorModel object that represents the
   coerced data. - `java.awt.image.ColorModel`"
  ([^java.awt.image.ColorModel this ^java.awt.image.WritableRaster raster ^Boolean is-alpha-premultiplied]
    (-> this (.coerceData raster is-alpha-premultiplied))))

(defn get-num-components
  "Returns the number of components, including alpha, in this
   ColorModel.  This is equal to the number of color
   components, optionally plus one, if there is an alpha component.

  returns: the number of components in this ColorModel - `int`"
  ([^java.awt.image.ColorModel this]
    (-> this (.getNumComponents))))

(defn create-compatible-writable-raster
  "Creates a WritableRaster with the specified width and
   height that has a data layout (SampleModel) compatible
   with this ColorModel.
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  w - the width to apply to the new WritableRaster - `int`
  h - the height to apply to the new WritableRaster - `int`

  returns: a WritableRaster object with the specified
   width and height. - `java.awt.image.WritableRaster`

  throws: java.lang.UnsupportedOperationException - if this method is not supported by this ColorModel"
  ([^java.awt.image.ColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleWritableRaster w h))))

(defn get-component-size
  "Returns the number of bits for the specified color/alpha component.
   Color components are indexed in the order specified by the
   ColorSpace.  Typically, this order reflects the name
   of the color space type. For example, for TYPE_RGB, index 0
   corresponds to red, index 1 to green, and index 2
   to blue.  If this ColorModel supports alpha, the alpha
   component corresponds to the index following the last color
   component.

  component-idx - the index of the color/alpha component - `int`

  returns: the number of bits for the color/alpha component at the
            specified index. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if componentIdx is greater than the number of components or less than zero"
  ([^java.awt.image.ColorModel this ^Integer component-idx]
    (-> this (.getComponentSize component-idx)))
  ([^java.awt.image.ColorModel this]
    (-> this (.getComponentSize))))

(defn create-compatible-sample-model
  "Creates a SampleModel with the specified width and
   height that has a data layout compatible with this
   ColorModel.
   Since ColorModel is an abstract class,
   any instance is an instance of a subclass.  Subclasses must
   override this method since the implementation in this abstract
   class throws an UnsupportedOperationException.

  w - the width to apply to the new SampleModel - `int`
  h - the height to apply to the new SampleModel - `int`

  returns: a SampleModel object with the specified
   width and height. - `java.awt.image.SampleModel`

  throws: java.lang.UnsupportedOperationException - if this method is not supported by this ColorModel"
  ([^java.awt.image.ColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn hash-code
  "Returns the hash code for this ColorModel.

  returns: a hash code for this ColorModel. - `int`"
  ([^java.awt.image.ColorModel this]
    (-> this (.hashCode))))

(defn get-blue
  "Returns the blue color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A color conversion
   is done if necessary.  The pixel value is specified as an int.
   An IllegalArgumentException is thrown if pixel values
   for this ColorModel are not conveniently representable
   as a single int.  The returned value is a non pre-multiplied
   value, for example, if the alpha is premultiplied, this method
   divides it out before returning the value.  If the alpha value is
   0, the blue value is 0.

  pixel - the specified pixel - `int`

  returns: the value of the blue component of the specified pixel. - `int`"
  ([^java.awt.image.ColorModel this ^Integer pixel]
    (-> this (.getBlue pixel))))

(defn alpha-premultiplied?
  "Returns whether or not the alpha has been premultiplied in the
   pixel values to be translated by this ColorModel.
   If the boolean is true, this ColorModel
   is to be used to interpret pixel values in which color and alpha
   information are represented as separate spatial bands, and color
   samples are assumed to have been multiplied by the
   alpha sample.

  returns: true if the alpha values are premultiplied
            in the pixel values to be translated by this
            ColorModel; false otherwise. - `boolean`"
  ([^java.awt.image.ColorModel this]
    (-> this (.isAlphaPremultiplied))))

(defn equals
  "Tests if the specified Object is an instance of
   ColorModel and if it equals this
   ColorModel.

  obj - the Object to test for equality - `java.lang.Object`

  returns: true if the specified Object
   is an instance of ColorModel and equals this
   ColorModel; false otherwise. - `boolean`"
  ([^java.awt.image.ColorModel this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-num-color-components
  "Returns the number of color components in this
   ColorModel.
   This is the number of components returned by
   ColorSpace.getNumComponents().

  returns: the number of color components in this
   ColorModel. - `int`"
  ([^java.awt.image.ColorModel this]
    (-> this (.getNumColorComponents))))

(defn finalize
  "Disposes of system resources associated with this
   ColorModel once this ColorModel is no
   longer referenced."
  ([^java.awt.image.ColorModel this]
    (-> this (.finalize))))

