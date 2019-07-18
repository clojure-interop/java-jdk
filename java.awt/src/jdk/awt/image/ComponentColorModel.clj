(ns jdk.awt.image.ComponentColorModel
  "A ColorModel class that works with pixel values that
  represent color and alpha information as separate samples and that
  store each sample in a separate data element.  This class can be
  used with an arbitrary ColorSpace.  The number of
  color samples in the pixel values must be same as the number of
  color components in the ColorSpace. There may be a
  single alpha sample.

  For those methods that use
  a primitive array pixel representation of type transferType,
  the array length is the same as the number of color and alpha samples.
  Color samples are stored first in the array followed by the alpha
  sample, if present.  The order of the color samples is specified
  by the ColorSpace.  Typically, this order reflects the
  name of the color space type. For example, for TYPE_RGB,
  index 0 corresponds to red, index 1 to green, and index 2 to blue.

  The translation from pixel sample values to color/alpha components for
  display or processing purposes is based on a one-to-one correspondence of
  samples to components.
  Depending on the transfer type used to create an instance of
  ComponentColorModel, the pixel sample values
  represented by that instance may be signed or unsigned and may
  be of integral type or float or double (see below for details).
  The translation from sample values to normalized color/alpha components
  must follow certain rules.  For float and double samples, the translation
  is an identity, i.e. normalized component values are equal to the
  corresponding sample values.  For integral samples, the translation
  should be only a simple scale and offset, where the scale and offset
  constants may be different for each component.  The result of
  applying the scale and offset constants is a set of color/alpha
  component values, which are guaranteed to fall within a certain
  range.  Typically, the range for a color component will be the range
  defined by the getMinValue and getMaxValue
  methods of the ColorSpace class.  The range for an
  alpha component should be 0.0 to 1.0.

  Instances of ComponentColorModel created with transfer types
  DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
  and DataBuffer.TYPE_INT have pixel sample values which
  are treated as unsigned integral values.
  The number of bits in a color or alpha sample of a pixel value might not
  be the same as the number of bits for the corresponding color or alpha
  sample passed to the
  ComponentColorModel(ColorSpace, int[], boolean, boolean, int, int)
  constructor.  In
  that case, this class assumes that the least significant n bits of a sample
  value hold the component value, where n is the number of significant bits
  for the component passed to the constructor.  It also assumes that
  any higher-order bits in a sample value are zero.  Thus, sample values
  range from 0 to 2n - 1.  This class maps these sample values
  to normalized color component values such that 0 maps to the value
  obtained from the ColorSpace's getMinValue
  method for each component and 2n - 1 maps to the value
  obtained from getMaxValue.  To create a
  ComponentColorModel with a different color sample mapping
  requires subclassing this class and overriding the
  getNormalizedComponents(Object, float[], int) method.
  The mapping for an alpha sample always maps 0 to 0.0 and
  2n - 1 to 1.0.

  For instances with unsigned sample values,
  the unnormalized color/alpha component representation is only
  supported if two conditions hold.  First, sample value value 0 must
  map to normalized component value 0.0 and sample value 2n - 1
  to 1.0.  Second the min/max range of all color components of the
  ColorSpace must be 0.0 to 1.0.  In this case, the
  component representation is the n least
  significant bits of the corresponding sample.  Thus each component is
  an unsigned integral value between 0 and 2n - 1, where
  n is the number of significant bits for a particular component.
  If these conditions are not met, any method taking an unnormalized
  component argument will throw an IllegalArgumentException.

  Instances of ComponentColorModel created with transfer types
  DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT, and
  DataBuffer.TYPE_DOUBLE have pixel sample values which
  are treated as signed short, float, or double values.
  Such instances do not support the unnormalized color/alpha component
  representation, so any methods taking such a representation as an argument
  will throw an IllegalArgumentException when called on one
  of these instances.  The normalized component values of instances
  of this class have a range which depends on the transfer
  type as follows: for float samples, the full range of the float data
  type; for double samples, the full range of the float data type
  (resulting from casting double to float); for short samples,
  from approximately -maxVal to maxVal, where maxVal is the per
  component maximum value for the ColorSpace
  (-32767 maps to -maxVal, 0 maps to 0.0, and 32767 maps
  to maxVal).  A subclass may override the scaling for short sample
  values to normalized component values by overriding the
  getNormalizedComponents(Object, float[], int) method.
  For float and double samples, the normalized component values are
  taken to be equal to the corresponding sample values, and subclasses
  should not attempt to add any non-identity scaling for these transfer
  types.

  Instances of ComponentColorModel created with transfer types
  DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT, and
  DataBuffer.TYPE_DOUBLE
  use all the bits of all sample values.  Thus all color/alpha components
  have 16 bits when using DataBuffer.TYPE_SHORT, 32 bits when
  using DataBuffer.TYPE_FLOAT, and 64 bits when using
  DataBuffer.TYPE_DOUBLE.  When the
  ComponentColorModel(ColorSpace, int[], boolean, boolean, int, int)
  form of constructor is used with one of these transfer types, the
  bits array argument is ignored.

  It is possible to have color/alpha sample values
  which cannot be reasonably interpreted as component values for rendering.
  This can happen when ComponentColorModel is subclassed to
  override the mapping of unsigned sample values to normalized color
  component values or when signed sample values outside a certain range
  are used.  (As an example, specifying an alpha component as a signed
  short value outside the range 0 to 32767, normalized range 0.0 to 1.0, can
  lead to unexpected results.) It is the
  responsibility of applications to appropriately scale pixel data before
  rendering such that color components fall within the normalized range
  of the ColorSpace (obtained using the getMinValue
  and getMaxValue methods of the ColorSpace class)
  and the alpha component is between 0.0 and 1.0.  If color or alpha
  component values fall outside these ranges, rendering results are
  indeterminate.

  Methods that use a single int pixel representation throw
  an IllegalArgumentException, unless the number of components
  for the ComponentColorModel is one and the component
  value is unsigned -- in other words,  a single color component using
  a transfer type of DataBuffer.TYPE_BYTE,
  DataBuffer.TYPE_USHORT, or DataBuffer.TYPE_INT
  and no alpha.

  A ComponentColorModel can be used in conjunction with a
  ComponentSampleModel, a BandedSampleModel,
  or a PixelInterleavedSampleModel to construct a
  BufferedImage."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ComponentColorModel]))

(defn ->component-color-model
  "Constructor.

  Constructs a ComponentColorModel from the specified
   parameters. Color components will be in the specified
   ColorSpace.  The supported transfer types are
   DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT,
   DataBuffer.TYPE_INT,
   DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT,
   and DataBuffer.TYPE_DOUBLE.
   If not null, the bits array specifies the
   number of significant bits per color and alpha component and its
   length should be at least the number of components in the
   ColorSpace if there is no alpha
   information in the pixel values, or one more than this number if
   there is alpha information.  When the transferType is
   DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT,
   or DataBuffer.TYPE_DOUBLE the bits array
   argument is ignored.  hasAlpha indicates whether alpha
   information is present.  If hasAlpha is true, then
   the boolean isAlphaPremultiplied
   specifies how to interpret color and alpha samples in pixel values.
   If the boolean is true, color samples are assumed to have been
   multiplied by the alpha sample. The transparency
   specifies what alpha values can be represented by this color model.
   The acceptable transparency values are
   OPAQUE, BITMASK or TRANSLUCENT.
   The transferType is the type of primitive array used
   to represent pixel values.

  color-space - The ColorSpace associated with this color model. - `java.awt.color.ColorSpace`
  bits - The number of significant bits per component. May be null, in which case all bits of all component samples will be significant. Ignored if transferType is one of DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT, or DataBuffer.TYPE_DOUBLE, in which case all bits of all component samples will be significant. - `int[]`
  has-alpha - If true, this color model supports alpha. - `boolean`
  is-alpha-premultiplied - If true, alpha is premultiplied. - `boolean`
  transparency - Specifies what alpha values can be represented by this color model. - `int`
  transfer-type - Specifies the type of primitive array used to represent pixel values. - `int`

  throws: java.lang.IllegalArgumentException - If transferType is not one of DataBuffer.TYPE_BYTE, DataBuffer.TYPE_USHORT, DataBuffer.TYPE_INT, DataBuffer.TYPE_SHORT, DataBuffer.TYPE_FLOAT, or DataBuffer.TYPE_DOUBLE."
  (^ComponentColorModel [^java.awt.color.ColorSpace color-space bits ^Boolean has-alpha ^Boolean is-alpha-premultiplied ^Integer transparency ^Integer transfer-type]
    (new ComponentColorModel color-space bits has-alpha is-alpha-premultiplied transparency transfer-type))
  (^ComponentColorModel [^java.awt.color.ColorSpace color-space ^Boolean has-alpha ^Boolean is-alpha-premultiplied ^Integer transparency ^Integer transfer-type]
    (new ComponentColorModel color-space has-alpha is-alpha-premultiplied transparency transfer-type)))

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

  components - an array containing unnormalized components - `int[]`
  offset - the offset into the components array at which to start retrieving unnormalized components - `int`
  norm-components - an array that receives the normalized components - `float[]`
  norm-offset - the index into normComponents at which to begin storing normalized components - `int`

  returns: an array containing normalized color and alpha
   components. - `float[]`

  throws: java.lang.IllegalArgumentException - If this ComponentColorModel does not support the unnormalized form"
  ([^ComponentColorModel this components ^Integer offset norm-components ^Integer norm-offset]
    (-> this (.getNormalizedComponents components offset norm-components norm-offset)))
  ([^ComponentColorModel this ^java.lang.Object pixel norm-components ^Integer norm-offset]
    (-> this (.getNormalizedComponents pixel norm-components norm-offset))))

(defn compatible-sample-model?
  "Checks whether or not the specified SampleModel
   is compatible with this ColorModel.

  sm - The SampleModel to test for compatibility. - `java.awt.image.SampleModel`

  returns: true if the SampleModel is
   compatible with this ColorModel, false
   if it is not. - `boolean`"
  (^Boolean [^ComponentColorModel this ^java.awt.image.SampleModel sm]
    (-> this (.isCompatibleSampleModel sm))))

(defn get-alpha-raster
  "Returns a Raster representing the alpha channel of an image,
   extracted from the input Raster.
   This method assumes that Raster objects associated with
   this ColorModel store the alpha band, if present, as
   the last band of image data. Returns null if there is no separate spatial
   alpha channel associated with this ColorModel.
   This method creates a new Raster, but will share the data
   array.

  raster - The WritableRaster from which to extract the alpha channel. - `java.awt.image.WritableRaster`

  returns: A WritableRaster containing the image's alpha channel. - `java.awt.image.WritableRaster`"
  (^java.awt.image.WritableRaster [^ComponentColorModel this ^java.awt.image.WritableRaster raster]
    (-> this (.getAlphaRaster raster))))

(defn get-data-element
  "Returns a pixel value represented as an int in this ColorModel,
   given an array of unnormalized color/alpha components.

  components - An array of unnormalized color/alpha components. - `int[]`
  offset - An offset into the components array. - `int`

  returns: A pixel value represented as an int. - `int`

  throws: java.lang.IllegalArgumentException - If this ComponentColorModel does not support the unnormalized form"
  (^Integer [^ComponentColorModel this components ^Integer offset]
    (-> this (.getDataElement components offset))))

(defn get-rgb
  "Returns the color/alpha components of the pixel in the default
   RGB color model format.  A color conversion is done if necessary.
   The returned value will be in a non pre-multiplied format. If
   the alpha is premultiplied, this method divides it out of the
   color components (if the alpha value is 0, the color values will be 0).

  pixel - The pixel from which you want to get the color/alpha components. - `int`

  returns: The color/alpha components for the specified pixel, as an int. - `int`

  throws: java.lang.IllegalArgumentException - If the component value for this ColorModel is signed"
  (^Integer [^ComponentColorModel this ^Integer pixel]
    (-> this (.getRGB pixel))))

(defn get-data-elements
  "Returns a data element array representation of a pixel in this
   ColorModel, given an array of unnormalized color/alpha
   components. This array can then be passed to the setDataElements
   method of a WritableRaster object.

  components - An array of unnormalized color/alpha components. - `int[]`
  offset - The integer offset into the components array. - `int`
  obj - The object in which to store the data element array representation of the pixel. If obj variable is null, a new array is allocated. If obj is not null, it must be a primitive array of type transferType. An ArrayIndexOutOfBoundsException is thrown if obj is not large enough to hold a pixel value for this ColorModel. Since ComponentColorModel can be subclassed, subclasses inherit the implementation of this method and if they don't override it then they throw an exception if they use an unsupported transferType. - `java.lang.Object`

  returns: The data element array representation of a pixel
   in this ColorModel. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - If this ComponentColorModel does not support the unnormalized form"
  (^java.lang.Object [^ComponentColorModel this components ^Integer offset ^java.lang.Object obj]
    (-> this (.getDataElements components offset obj)))
  (^java.lang.Object [^ComponentColorModel this ^Integer rgb ^java.lang.Object pixel]
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
  ([^ComponentColorModel this norm-components ^Integer norm-offset components ^Integer offset]
    (-> this (.getUnnormalizedComponents norm-components norm-offset components offset))))

(defn get-alpha
  "Returns the alpha component for the specified pixel, scaled
   from 0 to 255.   The pixel value is specified as an int.

  pixel - The pixel from which you want to get the alpha component. - `int`

  returns: The alpha component for the specified pixel, as an int. - `int`

  throws: java.lang.IllegalArgumentException - If the component value for this ColorModel is signed"
  (^Integer [^ComponentColorModel this ^Integer pixel]
    (-> this (.getAlpha pixel))))

(defn get-red
  "Returns the red color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A color conversion
   is done if necessary.  The pixel value is specified as an int.
   The returned value will be a non pre-multiplied value.
   If the alpha is premultiplied, this method divides
   it out before returning the value (if the alpha value is 0,
   the red value will be 0).

  pixel - The pixel from which you want to get the red color component. - `int`

  returns: The red color component for the specified pixel, as an int. - `int`

  throws: java.lang.IllegalArgumentException - If the component value for this ColorModel is signed"
  (^Integer [^ComponentColorModel this ^Integer pixel]
    (-> this (.getRed pixel))))

(defn get-green
  "Returns the green color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A color conversion
   is done if necessary.  The pixel value is specified as an int.
   The returned value will be a non
   pre-multiplied value. If the alpha is premultiplied, this method
   divides it out before returning the value (if the alpha value is 0,
   the green value will be 0).

  pixel - The pixel from which you want to get the green color component. - `int`

  returns: The green color component for the specified pixel, as an int. - `int`

  throws: java.lang.IllegalArgumentException - If the component value for this ColorModel is signed"
  (^Integer [^ComponentColorModel this ^Integer pixel]
    (-> this (.getGreen pixel))))

(defn get-components
  "Returns an array of unnormalized color/alpha components given a pixel
   in this ColorModel.
   An IllegalArgumentException is thrown if the component value for this
   ColorModel is not conveniently representable in the
   unnormalized form.  Color/alpha components are stored
   in the components array starting at offset
   (even if the array is allocated by this method).

  pixel - The pixel value specified as an integer. - `int`
  components - An integer array in which to store the unnormalized color/alpha components. If the components array is null, a new array is allocated. - `int[]`
  offset - An offset into the components array. - `int`

  returns: The components array. - `int[]`

  throws: java.lang.IllegalArgumentException - If this ColorModel does not support the unnormalized form"
  ([^ComponentColorModel this ^Integer pixel components ^Integer offset]
    (-> this (.getComponents pixel components offset))))

(defn compatible-raster?
  "Returns true if raster is compatible with this
   ColorModel; false if it is not.

  raster - The Raster object to test for compatibility. - `java.awt.image.Raster`

  returns: true if raster is compatible with this
   ColorModel, false if it is not. - `boolean`"
  (^Boolean [^ComponentColorModel this ^java.awt.image.Raster raster]
    (-> this (.isCompatibleRaster raster))))

(defn coerce-data
  "Forces the raster data to match the state specified in the
   isAlphaPremultiplied variable, assuming the data
   is currently correctly described by this ColorModel.
   It may multiply or divide the color raster data by alpha, or
   do nothing if the data is in the correct state.  If the data needs
   to be coerced, this method also returns an instance of
   this ColorModel with
   the isAlphaPremultiplied flag set appropriately.
   Since ColorModel can be subclassed, subclasses inherit
   the implementation of this method and if they don't override it
   then they throw an exception if they use an unsupported
   transferType.

  raster - the WritableRaster data - `java.awt.image.WritableRaster`
  is-alpha-premultiplied - true if the alpha is premultiplied; false otherwise - `boolean`

  returns: a ColorModel object that represents the
   coerced data. - `java.awt.image.ColorModel`

  throws: java.lang.NullPointerException - if raster is null and data coercion is required."
  (^java.awt.image.ColorModel [^ComponentColorModel this ^java.awt.image.WritableRaster raster ^Boolean is-alpha-premultiplied]
    (-> this (.coerceData raster is-alpha-premultiplied))))

(defn create-compatible-writable-raster
  "Creates a WritableRaster with the specified width and height,
   that  has a data layout (SampleModel) compatible with
   this ColorModel.

  w - The width of the WritableRaster you want to create. - `int`
  h - The height of the WritableRaster you want to create. - `int`

  returns: A WritableRaster that is compatible with
   this ColorModel. - `java.awt.image.WritableRaster`"
  (^java.awt.image.WritableRaster [^ComponentColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleWritableRaster w h))))

(defn create-compatible-sample-model
  "Creates a SampleModel with the specified width and height,
   that  has a data layout compatible with this ColorModel.

  w - The width of the SampleModel you want to create. - `int`
  h - The height of the SampleModel you want to create. - `int`

  returns: A SampleModel that is compatible with this
   ColorModel. - `java.awt.image.SampleModel`"
  (^java.awt.image.SampleModel [^ComponentColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn get-blue
  "Returns the blue color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  A color conversion
   is done if necessary.  The pixel value is specified as an int.
   The returned value will be a non
   pre-multiplied value. If the alpha is premultiplied, this method
   divides it out before returning the value (if the alpha value is 0,
   the blue value will be 0).

  pixel - The pixel from which you want to get the blue color component. - `int`

  returns: The blue color component for the specified pixel, as an int. - `int`

  throws: java.lang.IllegalArgumentException - If the component value for this ColorModel is signed"
  (^Integer [^ComponentColorModel this ^Integer pixel]
    (-> this (.getBlue pixel))))

(defn equals
  "Compares this color model with another for equality.

  obj - The object to compare with this color model. - `java.lang.Object`

  returns: true if the color model objects are equal,
   false if they are not. - `boolean`"
  (^Boolean [^ComponentColorModel this ^java.lang.Object obj]
    (-> this (.equals obj))))

