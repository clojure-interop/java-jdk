(ns jdk.awt.color.ColorSpace
  "This abstract class is used to serve as a color space tag to identify the
  specific color space of a Color object or, via a ColorModel object,
  of an Image, a BufferedImage, or a GraphicsDevice.  It contains
  methods that transform colors in a specific color space to/from sRGB
  and to/from a well-defined CIEXYZ color space.

  For purposes of the methods in this class, colors are represented as
  arrays of color components represented as floats in a normalized range
  defined by each ColorSpace.  For many ColorSpaces (e.g. sRGB), this
  range is 0.0 to 1.0.  However, some ColorSpaces have components whose
  values have a different range.  Methods are provided to inquire per
  component minimum and maximum normalized values.

  Several variables are defined for purposes of referring to color
  space types (e.g. TYPE_RGB, TYPE_XYZ, etc.) and to refer to specific
  color spaces (e.g. CS_sRGB and CS_CIEXYZ).
  sRGB is a proposed standard RGB color space.  For more information,
  see
  http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html
  .

  The purpose of the methods to transform to/from the well-defined
  CIEXYZ color space is to support conversions between any two color
  spaces at a reasonably high degree of accuracy.  It is expected that
  particular implementations of subclasses of ColorSpace (e.g.
  ICC_ColorSpace) will support high performance conversion based on
  underlying platform color management systems.

  The CS_CIEXYZ space used by the toCIEXYZ/fromCIEXYZ methods can be
  described as follows:


       CIEXYZ
       viewing illuminance: 200 lux
       viewing white point: CIE D50
       media white point: \"that of a perfectly reflecting diffuser\" -- D50
       media black point: 0 lux or 0 Reflectance
       flare: 1 percent
       surround: 20percent of the media white point
       media description: reflection print (i.e., RLAB, Hunt viewing media)
       note: For developers creating an ICC profile for this conversion
             space, the following is applicable.  Use a simple Von Kries
             white point adaptation folded into the 3X3 matrix parameters
             and fold the flare and surround effects into the three
             one-dimensional lookup tables (assuming one uses the minimal
             model for monitors)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.color ColorSpace]))

(def *-type-xyz
  "Static Constant.

  Any of the family of XYZ color spaces.

  type: int"
  ColorSpace/TYPE_XYZ)

(def *-type-lab
  "Static Constant.

  Any of the family of Lab color spaces.

  type: int"
  ColorSpace/TYPE_Lab)

(def *-type-luv
  "Static Constant.

  Any of the family of Luv color spaces.

  type: int"
  ColorSpace/TYPE_Luv)

(def *-type-y-cb-cr
  "Static Constant.

  Any of the family of YCbCr color spaces.

  type: int"
  ColorSpace/TYPE_YCbCr)

(def *-type-yxy
  "Static Constant.

  Any of the family of Yxy color spaces.

  type: int"
  ColorSpace/TYPE_Yxy)

(def *-type-rgb
  "Static Constant.

  Any of the family of RGB color spaces.

  type: int"
  ColorSpace/TYPE_RGB)

(def *-type-gray
  "Static Constant.

  Any of the family of GRAY color spaces.

  type: int"
  ColorSpace/TYPE_GRAY)

(def *-type-hsv
  "Static Constant.

  Any of the family of HSV color spaces.

  type: int"
  ColorSpace/TYPE_HSV)

(def *-type-hls
  "Static Constant.

  Any of the family of HLS color spaces.

  type: int"
  ColorSpace/TYPE_HLS)

(def *-type-cmyk
  "Static Constant.

  Any of the family of CMYK color spaces.

  type: int"
  ColorSpace/TYPE_CMYK)

(def *-type-cmy
  "Static Constant.

  Any of the family of CMY color spaces.

  type: int"
  ColorSpace/TYPE_CMY)

(def *-type-2-clr
  "Static Constant.

  Generic 2 component color spaces.

  type: int"
  ColorSpace/TYPE_2CLR)

(def *-type-3-clr
  "Static Constant.

  Generic 3 component color spaces.

  type: int"
  ColorSpace/TYPE_3CLR)

(def *-type-4-clr
  "Static Constant.

  Generic 4 component color spaces.

  type: int"
  ColorSpace/TYPE_4CLR)

(def *-type-5-clr
  "Static Constant.

  Generic 5 component color spaces.

  type: int"
  ColorSpace/TYPE_5CLR)

(def *-type-6-clr
  "Static Constant.

  Generic 6 component color spaces.

  type: int"
  ColorSpace/TYPE_6CLR)

(def *-type-7-clr
  "Static Constant.

  Generic 7 component color spaces.

  type: int"
  ColorSpace/TYPE_7CLR)

(def *-type-8-clr
  "Static Constant.

  Generic 8 component color spaces.

  type: int"
  ColorSpace/TYPE_8CLR)

(def *-type-9-clr
  "Static Constant.

  Generic 9 component color spaces.

  type: int"
  ColorSpace/TYPE_9CLR)

(def *-type-aclr
  "Static Constant.

  Generic 10 component color spaces.

  type: int"
  ColorSpace/TYPE_ACLR)

(def *-type-bclr
  "Static Constant.

  Generic 11 component color spaces.

  type: int"
  ColorSpace/TYPE_BCLR)

(def *-type-cclr
  "Static Constant.

  Generic 12 component color spaces.

  type: int"
  ColorSpace/TYPE_CCLR)

(def *-type-dclr
  "Static Constant.

  Generic 13 component color spaces.

  type: int"
  ColorSpace/TYPE_DCLR)

(def *-type-eclr
  "Static Constant.

  Generic 14 component color spaces.

  type: int"
  ColorSpace/TYPE_ECLR)

(def *-type-fclr
  "Static Constant.

  Generic 15 component color spaces.

  type: int"
  ColorSpace/TYPE_FCLR)

(def *-cs-s-rgb
  "Static Constant.

  The sRGB color space defined at

   http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html
   .

  type: int"
  ColorSpace/CS_sRGB)

(def *-cs-linear-rgb
  "Static Constant.

  A built-in linear RGB color space.  This space is based on the
   same RGB primaries as CS_sRGB, but has a linear tone reproduction curve.

  type: int"
  ColorSpace/CS_LINEAR_RGB)

(def *-cs-ciexyz
  "Static Constant.

  The CIEXYZ conversion color space defined above.

  type: int"
  ColorSpace/CS_CIEXYZ)

(def *-cs-pycc
  "Static Constant.

  The Photo YCC conversion color space.

  type: int"
  ColorSpace/CS_PYCC)

(def *-cs-gray
  "Static Constant.

  The built-in linear gray scale color space.

  type: int"
  ColorSpace/CS_GRAY)

(defn *get-instance
  "Returns a ColorSpace representing one of the specific
   predefined color spaces.

  colorspace - a specific color space identified by one of the predefined class constants (e.g. CS_sRGB, CS_LINEAR_RGB, CS_CIEXYZ, CS_GRAY, or CS_PYCC) - `int`

  returns: the requested ColorSpace object - `java.awt.color.ColorSpace`"
  (^java.awt.color.ColorSpace [^Integer colorspace]
    (ColorSpace/getInstance colorspace)))

(defn get-type
  "Returns the color space type of this ColorSpace (for example
   TYPE_RGB, TYPE_XYZ, ...).  The type defines the
   number of components of the color space and the interpretation,
   e.g. TYPE_RGB identifies a color space with three components - red,
   green, and blue.  It does not define the particular color
   characteristics of the space, e.g. the chromaticities of the
   primaries.

  returns: the type constant that represents the type of this
           ColorSpace - `int`"
  (^Integer [^ColorSpace this]
    (-> this (.getType))))

(defn get-min-value
  "Returns the minimum normalized color component value for the
   specified component.  The default implementation in this abstract
   class returns 0.0 for all components.  Subclasses should override
   this method if necessary.

  component - the component index - `int`

  returns: the minimum normalized component value - `float`

  throws: java.lang.IllegalArgumentException - if component is less than 0 or greater than numComponents - 1"
  (^Float [^ColorSpace this ^Integer component]
    (-> this (.getMinValue component))))

(defn get-max-value
  "Returns the maximum normalized color component value for the
   specified component.  The default implementation in this abstract
   class returns 1.0 for all components.  Subclasses should override
   this method if necessary.

  component - the component index - `int`

  returns: the maximum normalized component value - `float`

  throws: java.lang.IllegalArgumentException - if component is less than 0 or greater than numComponents - 1"
  (^Float [^ColorSpace this ^Integer component]
    (-> this (.getMaxValue component))))

(defn get-name
  "Returns the name of the component given the component index.

  idx - the component index - `int`

  returns: the name of the component at the specified index - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if idx is less than 0 or greater than numComponents - 1"
  (^java.lang.String [^ColorSpace this ^Integer idx]
    (-> this (.getName idx))))

(defn from-rgb
  "Transforms a color value assumed to be in the default CS_sRGB
   color space into this ColorSpace.

   This method transforms color values using algorithms designed
   to produce the best perceptual match between input and output
   colors.  In order to do colorimetric conversion of color values,
   you should use the toCIEXYZ
   method of the CS_sRGB color space to first convert from the input
   color space to the CS_CIEXYZ color space, and then use the
   fromCIEXYZ method of this color space to
   convert from CS_CIEXYZ to the output color space.
   See toCIEXYZ and
   fromCIEXYZ for further information.

  rgbvalue - a float array with length of at least 3 - `float[]`

  returns: a float array with length equal to the number of
           components in this ColorSpace - `float[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if array length is not at least 3"
  ([^ColorSpace this rgbvalue]
    (-> this (.fromRGB rgbvalue))))

(defn cs-s-rgb?
  "Returns true if the ColorSpace is CS_sRGB.

  returns: true if this is a CS_sRGB color
           space, false if it is not - `boolean`"
  (^Boolean [^ColorSpace this]
    (-> this (.isCS_sRGB))))

(defn get-num-components
  "Returns the number of components of this ColorSpace.

  returns: The number of components in this ColorSpace. - `int`"
  (^Integer [^ColorSpace this]
    (-> this (.getNumComponents))))

(defn from-ciexyz
  "Transforms a color value assumed to be in the CS_CIEXYZ conversion
   color space into this ColorSpace.

   This method transforms color values using relative colorimetry,
   as defined by the International Color Consortium standard.  This
   means that the XYZ argument values taken by this method are represented
   relative to the D50 white point of the CS_CIEXYZ color space.
   This representation is useful in a two-step color conversion
   process in which colors are transformed from an input color
   space to CS_CIEXYZ and then to an output color space.  The color
   values returned by this method are not those that would produce
   the XYZ value passed to the method when measured by a colorimeter.
   If you have XYZ values corresponding to measurements made using
   current CIE recommended practices, they must be converted to D50
   relative values before being passed to this method.
   See the fromCIEXYZ method of
   ICC_ColorSpace for further information.

  colorvalue - a float array with length of at least 3 - `float[]`

  returns: a float array with length equal to the number of
           components in this ColorSpace - `float[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if array length is not at least 3"
  ([^ColorSpace this colorvalue]
    (-> this (.fromCIEXYZ colorvalue))))

(defn to-ciexyz
  "Transforms a color value assumed to be in this ColorSpace
   into the CS_CIEXYZ conversion color space.

   This method transforms color values using relative colorimetry,
   as defined by the International Color Consortium standard.  This
   means that the XYZ values returned by this method are represented
   relative to the D50 white point of the CS_CIEXYZ color space.
   This representation is useful in a two-step color conversion
   process in which colors are transformed from an input color
   space to CS_CIEXYZ and then to an output color space.  This
   representation is not the same as the XYZ values that would
   be measured from the given color value by a colorimeter.
   A further transformation is necessary to compute the XYZ values
   that would be measured using current CIE recommended practices.
   See the toCIEXYZ method of
   ICC_ColorSpace for further information.

  colorvalue - a float array with length of at least the number of components in this ColorSpace - `float[]`

  returns: a float array of length 3 - `float[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if array length is not at least the number of components in this ColorSpace."
  ([^ColorSpace this colorvalue]
    (-> this (.toCIEXYZ colorvalue))))

(defn to-rgb
  "Transforms a color value assumed to be in this ColorSpace
   into a value in the default CS_sRGB color space.

   This method transforms color values using algorithms designed
   to produce the best perceptual match between input and output
   colors.  In order to do colorimetric conversion of color values,
   you should use the toCIEXYZ
   method of this color space to first convert from the input
   color space to the CS_CIEXYZ color space, and then use the
   fromCIEXYZ method of the CS_sRGB color space to
   convert from CS_CIEXYZ to the output color space.
   See toCIEXYZ and
   fromCIEXYZ for further information.

  colorvalue - a float array with length of at least the number of components in this ColorSpace - `float[]`

  returns: a float array of length 3 - `float[]`

  throws: java.lang.ArrayIndexOutOfBoundsException - if array length is not at least the number of components in this ColorSpace"
  ([^ColorSpace this colorvalue]
    (-> this (.toRGB colorvalue))))

