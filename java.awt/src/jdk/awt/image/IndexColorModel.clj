(ns jdk.awt.image.IndexColorModel
  "The IndexColorModel class is a ColorModel
  class that works with pixel values consisting of a
  single sample that is an index into a fixed colormap in the default
  sRGB color space.  The colormap specifies red, green, blue, and
  optional alpha components corresponding to each index.  All components
  are represented in the colormap as 8-bit unsigned integral values.
  Some constructors allow the caller to specify `holes` in the colormap
  by indicating which colormap entries are valid and which represent
  unusable colors via the bits set in a BigInteger object.
  This color model is similar to an X11 PseudoColor visual.

  Some constructors provide a means to specify an alpha component
  for each pixel in the colormap, while others either provide no
  such means or, in some cases, a flag to indicate whether the
  colormap data contains alpha values.  If no alpha is supplied to
  the constructor, an opaque alpha component (alpha = 1.0) is
  assumed for each entry.
  An optional transparent pixel value can be supplied that indicates a
  pixel to be made completely transparent, regardless of any alpha
  component supplied or assumed for that pixel value.
  Note that the color components in the colormap of an
  IndexColorModel objects are never pre-multiplied with
  the alpha components.


  The transparency of an IndexColorModel object is
  determined by examining the alpha components of the colors in the
  colormap and choosing the most specific value after considering
  the optional alpha values and any transparent index specified.
  The transparency value is Transparency.OPAQUE
  only if all valid colors in
  the colormap are opaque and there is no valid transparent pixel.
  If all valid colors
  in the colormap are either completely opaque (alpha = 1.0) or
  completely transparent (alpha = 0.0), which typically occurs when
  a valid transparent pixel is specified,
  the value is Transparency.BITMASK.
  Otherwise, the value is Transparency.TRANSLUCENT, indicating
  that some valid color has an alpha component that is
  neither completely transparent nor completely opaque
  (0.0 < alpha < 1.0).



  If an IndexColorModel object has
  a transparency value of Transparency.OPAQUE,
  then the hasAlpha
  and getNumComponents methods
  (both inherited from ColorModel)
  return false and 3, respectively.
  For any other transparency value,
  hasAlpha returns true
  and getNumComponents returns 4.



  The values used to index into the colormap are taken from the least
  significant n bits of pixel representations where
  n is based on the pixel size specified in the constructor.
  For pixel sizes smaller than 8 bits, n is rounded up to a
  power of two (3 becomes 4 and 5,6,7 become 8).
  For pixel sizes between 8 and 16 bits, n is equal to the
  pixel size.
  Pixel sizes larger than 16 bits are not supported by this class.
  Higher order bits beyond n are ignored in pixel representations.
  Index values greater than or equal to the map size, but less than
  2n, are undefined and return 0 for all color and
  alpha components.


  For those methods that use a primitive array pixel representation of
  type transferType, the array length is always one.
  The transfer types supported are DataBuffer.TYPE_BYTE and
  DataBuffer.TYPE_USHORT.  A single int pixel
  representation is valid for all objects of this class, since it is
  always possible to represent pixel values used with this class in a
  single int.  Therefore, methods that use this representation do
  not throw an IllegalArgumentException due to an invalid
  pixel value.

  Many of the methods in this class are final.  The reason for
  this is that the underlying native graphics code makes assumptions
  about the layout and operation of this class and those assumptions
  are reflected in the implementations of the methods here that are
  marked final.  You can subclass this class for other reasons, but
  you cannot override or modify the behaviour of those methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image IndexColorModel]))

(defn ->index-color-model
  "Constructor.

  Constructs an IndexColorModel from an array of
   ints where each int is comprised of red, green, blue, and
   optional alpha components in the default RGB color model format.
   The specified transparent index represents a pixel that is made
   entirely transparent regardless of any alpha value specified
   for it.  The array must have enough values in it to fill all
   of the needed component arrays of the specified size.
   The ColorSpace is the default sRGB space.
   The transparency value may be any of Transparency.OPAQUE,
   Transparency.BITMASK,
   or Transparency.TRANSLUCENT
   depending on the arguments, as specified
   in the class description above.

  bits - the number of bits each pixel occupies - `int`
  size - the size of the color component arrays - `int`
  cmap - the array of color components - `int[]`
  start - the starting offset of the first color component - `int`
  hasalpha - indicates whether alpha values are contained in the cmap array - `boolean`
  trans - the index of the fully transparent pixel - `int`
  transfer-type - the data type of the array used to represent pixel values. The data type must be either DataBuffer.TYPE_BYTE or DataBuffer.TYPE_USHORT. - `int`

  throws: java.lang.IllegalArgumentException - if transferType is not one of DataBuffer.TYPE_BYTE or DataBuffer.TYPE_USHORT"
  (^IndexColorModel [^Integer bits ^Integer size cmap ^Integer start ^Boolean hasalpha ^Integer trans ^Integer transfer-type]
    (new IndexColorModel bits size cmap start hasalpha trans transfer-type))
  (^IndexColorModel [^Integer bits ^Integer size r g b ^Integer trans]
    (new IndexColorModel bits size r g b trans))
  (^IndexColorModel [^Integer bits ^Integer size r g b]
    (new IndexColorModel bits size r g b)))

(defn get-transparency
  "Returns the transparency.  Returns either OPAQUE, BITMASK,
   or TRANSLUCENT

  returns: the transparency of this IndexColorModel - `int`"
  (^Integer [^IndexColorModel this]
    (-> this (.getTransparency))))

(defn compatible-sample-model?
  "Checks if the specified SampleModel is compatible
   with this ColorModel.  If sm is
   null, this method returns false.

  sm - the specified SampleModel, or null - `java.awt.image.SampleModel`

  returns: true if the specified SampleModel
   is compatible with this ColorModel; false
   otherwise. - `boolean`"
  (^Boolean [^IndexColorModel this ^java.awt.image.SampleModel sm]
    (-> this (.isCompatibleSampleModel sm))))

(defn get-data-element
  "Returns a pixel value represented as an int in this
   ColorModel given an array of unnormalized
   color/alpha components.  An
   ArrayIndexOutOfBoundsException
   is thrown if the components array is not large
   enough to hold all of the color and alpha components starting
   at offset.  Since
   ColorModel can be subclassed, subclasses inherit the
   implementation of this method and if they don't override it then
   they throw an exception if they use an unsupported transferType.

  components - an array of unnormalized color and alpha components - `int[]`
  offset - the index into components at which to begin retrieving the color and alpha components - `int`

  returns: an int pixel value in this
   ColorModel corresponding to the specified components. - `int`

  throws: java.lang.ArrayIndexOutOfBoundsException - if the components array is not large enough to hold all of the color and alpha components starting at offset"
  (^Integer [^IndexColorModel this components ^Integer offset]
    (-> this (.getDataElement components offset))))

(defn get-rgb
  "Returns the color/alpha components of the pixel in the default
   RGB color model format.  The pixel value is specified as an int.
   Only the lower n bits of the pixel value, as specified in the
   class description above, are used to
   calculate the returned value.
   The returned value is in a non pre-multiplied format.

  pixel - the specified pixel - `int`

  returns: the color and alpha components of the specified pixel - `int`"
  (^Integer [^IndexColorModel this ^Integer pixel]
    (-> this (.getRGB pixel))))

(defn get-data-elements
  "Returns a data element array representation of a pixel in this
   ColorModel given an array of unnormalized color/alpha
   components.  This array can then be passed to the
   setDataElements method of a WritableRaster
   object.  An ArrayIndexOutOfBoundsException is
   thrown if the
   components array is not large enough to hold all of the
   color and alpha components starting at offset.
   If the pixel variable is null, a new array
   is allocated.  If pixel is not null,
   it must be a primitive array of type transferType;
   otherwise, a ClassCastException is thrown.
   An ArrayIndexOutOfBoundsException is thrown if pixel
   is not large enough to hold a pixel value for this
   ColorModel.

   Since IndexColorModel can be subclassed, subclasses
   inherit the implementation of this method and if they don't
   override it then they throw an exception if they use an
   unsupported transferType

  components - an array of unnormalized color and alpha components - `int[]`
  offset - the index into components at which to begin retrieving color and alpha components - `int`
  pixel - the Object representing an array of color and alpha components - `java.lang.Object`

  returns: an Object representing an array of color and
   alpha components. - `java.lang.Object`

  throws: java.lang.ClassCastException - if pixel is not a primitive array of type transferType"
  (^java.lang.Object [^IndexColorModel this components ^Integer offset ^java.lang.Object pixel]
    (-> this (.getDataElements components offset pixel)))
  (^java.lang.Object [^IndexColorModel this ^Integer rgb ^java.lang.Object pixel]
    (-> this (.getDataElements rgb pixel))))

(defn get-transparent-pixel
  "Returns the index of a transparent pixel in this
   IndexColorModel or -1 if there is no pixel
   with an alpha value of 0.  If a transparent pixel was
   explicitly specified in one of the constructors by its
   index, then that index will be preferred, otherwise,
   the index of any pixel which happens to be fully transparent
   may be returned.

  returns: the index of a transparent pixel in this
           IndexColorModel object, or -1 if there
           is no such pixel - `int`"
  (^Integer [^IndexColorModel this]
    (-> this (.getTransparentPixel))))

(defn get-blues
  "Copies the array of blue color components into the specified array.
   Only the initial entries of the array as specified by
   getMapSize are written.

  b - the specified array into which the elements of the array of blue color components are copied - `byte[]`"
  ([^IndexColorModel this b]
    (-> this (.getBlues b))))

(defn get-rg-bs
  "Converts data for each index from the color and alpha component
   arrays to an int in the default RGB ColorModel format and copies
   the resulting 32-bit ARGB values into the specified array.  Only
   the initial entries of the array as specified by
   getMapSize are
   written.

  rgb - the specified array into which the converted ARGB values from this array of color and alpha components are copied. - `int[]`"
  ([^IndexColorModel this rgb]
    (-> this (.getRGBs rgb))))

(defn to-string
  "Returns the String representation of the contents of
   this ColorModelobject.

  returns: a String representing the contents of this
   ColorModel object. - `java.lang.String`"
  (^java.lang.String [^IndexColorModel this]
    (-> this (.toString))))

(defn get-alpha
  "Returns the alpha component for the specified pixel, scaled
   from 0 to 255.  The pixel value is specified as an int.
   Only the lower n bits of the pixel value, as specified in the
   class description above, are used to
   calculate the returned value.

  pixel - the specified pixel - `int`

  returns: the value of the alpha component for the specified pixel - `int`"
  (^Integer [^IndexColorModel this ^Integer pixel]
    (-> this (.getAlpha pixel))))

(defn get-red
  "Returns the red color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  The pixel value
   is specified as an int.
   Only the lower n bits of the pixel value, as specified in the
   class description above, are used to
   calculate the returned value.
   The returned value is a non pre-multiplied value.

  pixel - the specified pixel - `int`

  returns: the value of the red color component for the specified pixel - `int`"
  (^Integer [^IndexColorModel this ^Integer pixel]
    (-> this (.getRed pixel))))

(defn get-green
  "Returns the green color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  The pixel value
   is specified as an int.
   Only the lower n bits of the pixel value, as specified in the
   class description above, are used to
   calculate the returned value.
   The returned value is a non pre-multiplied value.

  pixel - the specified pixel - `int`

  returns: the value of the green color component for the specified pixel - `int`"
  (^Integer [^IndexColorModel this ^Integer pixel]
    (-> this (.getGreen pixel))))

(defn get-reds
  "Copies the array of red color components into the specified array.
   Only the initial entries of the array as specified by
   getMapSize are written.

  r - the specified array into which the elements of the array of red color components are copied - `byte[]`"
  ([^IndexColorModel this r]
    (-> this (.getReds r))))

(defn get-greens
  "Copies the array of green color components into the specified array.
   Only the initial entries of the array as specified by
   getMapSize are written.

  g - the specified array into which the elements of the array of green color components are copied - `byte[]`"
  ([^IndexColorModel this g]
    (-> this (.getGreens g))))

(defn get-components
  "Returns an array of unnormalized color/alpha components for a
   specified pixel in this ColorModel.  The pixel value
   is specified as an int.  If the components array is null,
   a new array is allocated that contains
   offset  getNumComponents() elements.
   The components array is returned,
   with the alpha component included
   only if hasAlpha returns true.
   Color/alpha components are stored in the components array starting
   at offset even if the array is allocated by this method.
   An ArrayIndexOutOfBoundsException
   is thrown if  the components array is not null and is
   not large enough to hold all the color and alpha components
   starting at offset.

  pixel - the specified pixel - `int`
  components - the array to receive the color and alpha components of the specified pixel - `int[]`
  offset - the offset into the components array at which to start storing the color and alpha components - `int`

  returns: an array containing the color and alpha components of the
   specified pixel starting at the specified offset. - `int[]`"
  ([^IndexColorModel this ^Integer pixel components ^Integer offset]
    (-> this (.getComponents pixel components offset))))

(defn compatible-raster?
  "Returns true if raster is compatible
   with this ColorModel or false if it
   is not compatible with this ColorModel.

  raster - the Raster object to test for compatibility - `java.awt.image.Raster`

  returns: true if raster is compatible
   with this ColorModel; false otherwise. - `boolean`"
  (^Boolean [^IndexColorModel this ^java.awt.image.Raster raster]
    (-> this (.isCompatibleRaster raster))))

(defn get-valid-pixels
  "Returns a BigInteger that indicates the valid/invalid
   pixels in the colormap.  A bit is valid if the
   BigInteger value at that index is set, and is invalid
   if the BigInteger value at that index is not set.
   The only valid ranges to query in the BigInteger are
   between 0 and the map size.

  returns: a BigInteger indicating the valid/invalid pixels. - `java.math.BigInteger`"
  (^java.math.BigInteger [^IndexColorModel this]
    (-> this (.getValidPixels))))

(defn valid?
  "Returns whether or not the pixel is valid.

  pixel - the specified pixel value - `int`

  returns: true if pixel
   is valid; false otherwise. - `boolean`"
  (^Boolean [^IndexColorModel this ^Integer pixel]
    (-> this (.isValid pixel)))
  (^Boolean [^IndexColorModel this]
    (-> this (.isValid))))

(defn create-compatible-writable-raster
  "Creates a WritableRaster with the specified width
   and height that has a data layout (SampleModel)
   compatible with this ColorModel.  This method
   only works for color models with 16 or fewer bits per pixel.

   Since IndexColorModel can be subclassed, any
   subclass that supports greater than 16 bits per pixel must
   override this method.

  w - the width to apply to the new WritableRaster - `int`
  h - the height to apply to the new WritableRaster - `int`

  returns: a WritableRaster object with the specified
   width and height. - `java.awt.image.WritableRaster`

  throws: java.lang.UnsupportedOperationException - if the number of bits in a pixel is greater than 16"
  (^java.awt.image.WritableRaster [^IndexColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleWritableRaster w h))))

(defn get-component-size
  "Returns an array of the number of bits for each color/alpha component.
   The array contains the color components in the order red, green,
   blue, followed by the alpha component, if present.

  returns: an array containing the number of bits of each color
           and alpha component of this IndexColorModel - `int[]`"
  ([^IndexColorModel this]
    (-> this (.getComponentSize))))

(defn create-compatible-sample-model
  "Creates a SampleModel with the specified
   width and height that has a data layout compatible with
   this ColorModel.

  w - the width to apply to the new SampleModel - `int`
  h - the height to apply to the new SampleModel - `int`

  returns: a SampleModel object with the specified
   width and height. - `java.awt.image.SampleModel`

  throws: java.lang.IllegalArgumentException - if w or h is not greater than 0"
  (^java.awt.image.SampleModel [^IndexColorModel this ^Integer w ^Integer h]
    (-> this (.createCompatibleSampleModel w h))))

(defn get-blue
  "Returns the blue color component for the specified pixel, scaled
   from 0 to 255 in the default RGB ColorSpace, sRGB.  The pixel value
   is specified as an int.
   Only the lower n bits of the pixel value, as specified in the
   class description above, are used to
   calculate the returned value.
   The returned value is a non pre-multiplied value.

  pixel - the specified pixel - `int`

  returns: the value of the blue color component for the specified pixel - `int`"
  (^Integer [^IndexColorModel this ^Integer pixel]
    (-> this (.getBlue pixel))))

(defn convert-to-int-discrete
  "Returns a new BufferedImage of TYPE_INT_ARGB or
   TYPE_INT_RGB that has a Raster with pixel data
   computed by expanding the indices in the source Raster
   using the color/alpha component arrays of this ColorModel.
   Only the lower n bits of each index value in the source
   Raster, as specified in the
   class description above, are used to
   compute the color/alpha values in the returned image.
   If forceARGB is true, a TYPE_INT_ARGB image is
   returned regardless of whether or not this ColorModel
   has an alpha component array or a transparent pixel.

  raster - the specified Raster - `java.awt.image.Raster`
  force-argb - if true, the returned BufferedImage is TYPE_INT_ARGB; otherwise it is TYPE_INT_RGB - `boolean`

  returns: a BufferedImage created with the specified
       Raster - `java.awt.image.BufferedImage`

  throws: java.lang.IllegalArgumentException - if the raster argument is not compatible with this IndexColorModel"
  (^java.awt.image.BufferedImage [^IndexColorModel this ^java.awt.image.Raster raster ^Boolean force-argb]
    (-> this (.convertToIntDiscrete raster force-argb))))

(defn get-alphas
  "Copies the array of alpha transparency components into the
   specified array.  Only the initial entries of the array as specified
   by getMapSize are written.

  a - the specified array into which the elements of the array of alpha components are copied - `byte[]`"
  ([^IndexColorModel this a]
    (-> this (.getAlphas a))))

(defn finalize
  "Disposes of system resources associated with this
   ColorModel once this ColorModel is no
   longer referenced."
  ([^IndexColorModel this]
    (-> this (.finalize))))

(defn get-map-size
  "Returns the size of the color/alpha component arrays in this
   IndexColorModel.

  returns: the size of the color and alpha component arrays. - `int`"
  (^Integer [^IndexColorModel this]
    (-> this (.getMapSize))))

