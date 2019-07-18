(ns jdk.awt.Color
  "The Color class is used to encapsulate colors in the default
  sRGB color space or colors in arbitrary color spaces identified by a
  ColorSpace.  Every color has an implicit alpha value of 1.0 or
  an explicit one provided in the constructor.  The alpha value
  defines the transparency of a color and can be represented by
  a float value in the range 0.0 - 1.0 or 0 - 255.
  An alpha value of 1.0 or 255 means that the color is completely
  opaque and an alpha value of 0 or 0.0 means that the color is
  completely transparent.
  When constructing a Color with an explicit alpha or
  getting the color/alpha components of a Color, the color
  components are never premultiplied by the alpha component.

  The default color space for the Java 2D(tm) API is sRGB, a proposed
  standard RGB color space.  For further information on sRGB,
  see
  http://www.w3.org/pub/WWW/Graphics/Color/sRGB.html
  ."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Color]))

(defn ->color
  "Constructor.

  Creates an sRGB color with the specified red, green, blue, and alpha
   values in the range (0 - 255).

  r - the red component - `int`
  g - the green component - `int`
  b - the blue component - `int`
  a - the alpha component - `int`

  throws: java.lang.IllegalArgumentException - if r, g, b or a are outside of the range 0 to 255, inclusive"
  (^Color [^Integer r ^Integer g ^Integer b ^Integer a]
    (new Color r g b a))
  (^Color [^Integer r ^Integer g ^Integer b]
    (new Color r g b))
  (^Color [^Integer rgba ^Boolean hasalpha]
    (new Color rgba hasalpha))
  (^Color [^Integer rgb]
    (new Color rgb)))

(def *-white
  "Static Constant.

  The color white.  In the default sRGB space.

  type: java.awt.Color"
  Color/white)

(def *-white
  "Static Constant.

  The color white.  In the default sRGB space.

  type: java.awt.Color"
  Color/WHITE)

(def *-light-gray
  "Static Constant.

  The color light gray.  In the default sRGB space.

  type: java.awt.Color"
  Color/lightGray)

(def *-light-gray
  "Static Constant.

  The color light gray.  In the default sRGB space.

  type: java.awt.Color"
  Color/LIGHT_GRAY)

(def *-gray
  "Static Constant.

  The color gray.  In the default sRGB space.

  type: java.awt.Color"
  Color/gray)

(def *-gray
  "Static Constant.

  The color gray.  In the default sRGB space.

  type: java.awt.Color"
  Color/GRAY)

(def *-dark-gray
  "Static Constant.

  The color dark gray.  In the default sRGB space.

  type: java.awt.Color"
  Color/darkGray)

(def *-dark-gray
  "Static Constant.

  The color dark gray.  In the default sRGB space.

  type: java.awt.Color"
  Color/DARK_GRAY)

(def *-black
  "Static Constant.

  The color black.  In the default sRGB space.

  type: java.awt.Color"
  Color/black)

(def *-black
  "Static Constant.

  The color black.  In the default sRGB space.

  type: java.awt.Color"
  Color/BLACK)

(def *-red
  "Static Constant.

  The color red.  In the default sRGB space.

  type: java.awt.Color"
  Color/red)

(def *-red
  "Static Constant.

  The color red.  In the default sRGB space.

  type: java.awt.Color"
  Color/RED)

(def *-pink
  "Static Constant.

  The color pink.  In the default sRGB space.

  type: java.awt.Color"
  Color/pink)

(def *-pink
  "Static Constant.

  The color pink.  In the default sRGB space.

  type: java.awt.Color"
  Color/PINK)

(def *-orange
  "Static Constant.

  The color orange.  In the default sRGB space.

  type: java.awt.Color"
  Color/orange)

(def *-orange
  "Static Constant.

  The color orange.  In the default sRGB space.

  type: java.awt.Color"
  Color/ORANGE)

(def *-yellow
  "Static Constant.

  The color yellow.  In the default sRGB space.

  type: java.awt.Color"
  Color/yellow)

(def *-yellow
  "Static Constant.

  The color yellow.  In the default sRGB space.

  type: java.awt.Color"
  Color/YELLOW)

(def *-green
  "Static Constant.

  The color green.  In the default sRGB space.

  type: java.awt.Color"
  Color/green)

(def *-green
  "Static Constant.

  The color green.  In the default sRGB space.

  type: java.awt.Color"
  Color/GREEN)

(def *-magenta
  "Static Constant.

  The color magenta.  In the default sRGB space.

  type: java.awt.Color"
  Color/magenta)

(def *-magenta
  "Static Constant.

  The color magenta.  In the default sRGB space.

  type: java.awt.Color"
  Color/MAGENTA)

(def *-cyan
  "Static Constant.

  The color cyan.  In the default sRGB space.

  type: java.awt.Color"
  Color/cyan)

(def *-cyan
  "Static Constant.

  The color cyan.  In the default sRGB space.

  type: java.awt.Color"
  Color/CYAN)

(def *-blue
  "Static Constant.

  The color blue.  In the default sRGB space.

  type: java.awt.Color"
  Color/blue)

(def *-blue
  "Static Constant.

  The color blue.  In the default sRGB space.

  type: java.awt.Color"
  Color/BLUE)

(defn *decode
  "Converts a String to an integer and returns the
   specified opaque Color. This method handles string
   formats that are used to represent octal and hexadecimal numbers.

  nm - a String that represents an opaque color as a 24-bit integer - `java.lang.String`

  returns: the new Color object. - `java.awt.Color`

  throws: java.lang.NumberFormatException - if the specified string cannot be interpreted as a decimal, octal, or hexadecimal integer."
  (^java.awt.Color [^java.lang.String nm]
    (Color/decode nm)))

(defn *get-color
  "Finds a color in the system properties.

   The first argument is treated as the name of a system property to
   be obtained. The string value of this property is then interpreted
   as an integer which is then converted to a Color
   object.

   If the specified property is not found or cannot be parsed as
   an integer then the Color specified by the second
   argument is returned instead.

  nm - the name of the color property - `java.lang.String`
  v - the default Color - `java.awt.Color`

  returns: the Color converted from the system
            property, or the specified Color. - `java.awt.Color`"
  (^java.awt.Color [^java.lang.String nm ^java.awt.Color v]
    (Color/getColor nm v))
  (^java.awt.Color [^java.lang.String nm]
    (Color/getColor nm)))

(defn *hs-bto-rgb
  "Converts the components of a color, as specified by the HSB
   model, to an equivalent set of values for the default RGB model.

   The saturation and brightness components
   should be floating-point values between zero and one
   (numbers in the range 0.0-1.0).  The hue component
   can be any floating-point number.  The floor of this number is
   subtracted from it to create a fraction between 0 and 1.  This
   fractional number is then multiplied by 360 to produce the hue
   angle in the HSB color model.

   The integer that is returned by HSBtoRGB encodes the
   value of a color in bits 0-23 of an integer value that is the same
   format used by the method getRGB.
   This integer can be supplied as an argument to the
   Color constructor that takes a single integer argument.

  hue - the hue component of the color - `float`
  saturation - the saturation of the color - `float`
  brightness - the brightness of the color - `float`

  returns: the RGB value of the color with the indicated hue,
                              saturation, and brightness. - `int`"
  (^Integer [^Float hue ^Float saturation ^Float brightness]
    (Color/HSBtoRGB hue saturation brightness)))

(defn *rg-bto-hsb
  "Converts the components of a color, as specified by the default RGB
   model, to an equivalent set of values for hue, saturation, and
   brightness that are the three components of the HSB model.

   If the hsbvals argument is null, then a
   new array is allocated to return the result. Otherwise, the method
   returns the array hsbvals, with the values put into
   that array.

  r - the red component of the color - `int`
  g - the green component of the color - `int`
  b - the blue component of the color - `int`
  hsbvals - the array used to return the three HSB values, or null - `float[]`

  returns: an array of three elements containing the hue, saturation,
                       and brightness (in that order), of the color with
                       the indicated red, green, and blue components. - `float[]`"
  ([^Integer r ^Integer g ^Integer b hsbvals]
    (Color/RGBtoHSB r g b hsbvals)))

(defn *get-hsb-color
  "Creates a Color object based on the specified values
   for the HSB color model.

   The s and b components should be
   floating-point values between zero and one
   (numbers in the range 0.0-1.0).  The h component
   can be any floating-point number.  The floor of this number is
   subtracted from it to create a fraction between 0 and 1.  This
   fractional number is then multiplied by 360 to produce the hue
   angle in the HSB color model.

  h - the hue component - `float`
  s - the saturation of the color - `float`
  b - the brightness of the color - `float`

  returns: a Color object with the specified hue,
                                   saturation, and brightness. - `java.awt.Color`"
  (^java.awt.Color [^Float h ^Float s ^Float b]
    (Color/getHSBColor h s b)))

(defn get-transparency
  "Returns the transparency mode for this Color.  This is
   required to implement the Paint interface.

  returns: this Color object's transparency mode. - `int`"
  (^Integer [^Color this]
    (-> this (.getTransparency))))

(defn get-rgb
  "Returns the RGB value representing the color in the default sRGB
   ColorModel.
   (Bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7 are
   blue).

  returns: the RGB value of the color in the default sRGB
           ColorModel. - `int`"
  (^Integer [^Color this]
    (-> this (.getRGB))))

(defn to-string
  "Returns a string representation of this Color. This
   method is intended to be used only for debugging purposes.  The
   content and format of the returned string might vary between
   implementations. The returned string might be empty but cannot
   be null.

  returns: a string representation of this Color. - `java.lang.String`"
  (^java.lang.String [^Color this]
    (-> this (.toString))))

(defn get-alpha
  "Returns the alpha component in the range 0-255.

  returns: the alpha component. - `int`"
  (^Integer [^Color this]
    (-> this (.getAlpha))))

(defn get-red
  "Returns the red component in the range 0-255 in the default sRGB
   space.

  returns: the red component. - `int`"
  (^Integer [^Color this]
    (-> this (.getRed))))

(defn get-green
  "Returns the green component in the range 0-255 in the default sRGB
   space.

  returns: the green component. - `int`"
  (^Integer [^Color this]
    (-> this (.getGreen))))

(defn get-color-space
  "Returns the ColorSpace of this Color.

  returns: this Color object's ColorSpace. - `java.awt.color.ColorSpace`"
  (^java.awt.color.ColorSpace [^Color this]
    (-> this (.getColorSpace))))

(defn get-components
  "Returns a float array containing the color and alpha
   components of the Color, in the
   ColorSpace specified by the cspace
   parameter.  If compArray is null, an
   array with length equal to the number of components in
   cspace plus one is created for the return value.
   Otherwise, compArray must have at least this
   length, and it is filled in with the components and returned.

  cspace - a specified ColorSpace - `java.awt.color.ColorSpace`
  comp-array - an array that this method fills with the color and alpha components of this Color in the specified ColorSpace and returns - `float[]`

  returns: the color and alpha components in a float
            array. - `float[]`"
  ([^Color this ^java.awt.color.ColorSpace cspace comp-array]
    (-> this (.getComponents cspace comp-array)))
  ([^Color this comp-array]
    (-> this (.getComponents comp-array))))

(defn create-context
  "Creates and returns a PaintContext used to
   generate a solid color field pattern.
   See the specification of the
   method in the Paint interface for information
   on null parameter handling.

  cm - the preferred ColorModel which represents the most convenient format for the caller to receive the pixel data, or null if there is no preference. - `java.awt.image.ColorModel`
  r - the device space bounding box of the graphics primitive being rendered. - `java.awt.Rectangle`
  r-2d - the user space bounding box of the graphics primitive being rendered. - `java.awt.geom.Rectangle2D`
  xform - the AffineTransform from user space into device space. - `java.awt.geom.AffineTransform`
  hints - the set of hints that the context object can use to choose between rendering alternatives. - `java.awt.RenderingHints`

  returns: the PaintContext for
           generating color patterns. - `java.awt.PaintContext`"
  (^java.awt.PaintContext [^Color this ^java.awt.image.ColorModel cm ^java.awt.Rectangle r ^java.awt.geom.Rectangle2D r-2d ^java.awt.geom.AffineTransform xform ^java.awt.RenderingHints hints]
    (-> this (.createContext cm r r-2d xform hints))))

(defn darker
  "Creates a new Color that is a darker version of this
   Color.

   This method applies an arbitrary scale factor to each of the three RGB
   components of this Color to create a darker version of
   this Color.
   The alpha value is preserved.
   Although brighter and
   darker are inverse operations, the results of a series
   of invocations of these two methods might be inconsistent because
   of rounding errors.

  returns: a new Color object that is
                      a darker version of this Color
                      with the same alpha value. - `java.awt.Color`"
  (^java.awt.Color [^Color this]
    (-> this (.darker))))

(defn get-color-components
  "Returns a float array containing only the color
   components of the Color in the
   ColorSpace specified by the cspace
   parameter. If compArray is null, an array
   with length equal to the number of components in
   cspace is created for the return value.  Otherwise,
   compArray must have at least this length, and it is
   filled in with the components and returned.

  cspace - a specified ColorSpace - `java.awt.color.ColorSpace`
  comp-array - an array that this method fills with the color components of this Color in the specified ColorSpace - `float[]`

  returns: the color components in a float array. - `float[]`"
  ([^Color this ^java.awt.color.ColorSpace cspace comp-array]
    (-> this (.getColorComponents cspace comp-array)))
  ([^Color this comp-array]
    (-> this (.getColorComponents comp-array))))

(defn hash-code
  "Computes the hash code for this Color.

  returns: a hash code value for this object. - `int`"
  (^Integer [^Color this]
    (-> this (.hashCode))))

(defn get-blue
  "Returns the blue component in the range 0-255 in the default sRGB
   space.

  returns: the blue component. - `int`"
  (^Integer [^Color this]
    (-> this (.getBlue))))

(defn get-rgb-color-components
  "Returns a float array containing only the color
   components of the Color, in the default sRGB color
   space.  If compArray is null, an array of
   length 3 is created for the return value.  Otherwise,
   compArray must have length 3 or greater, and it is
   filled in with the components and returned.

  comp-array - an array that this method fills with color components and returns - `float[]`

  returns: the RGB components in a float array. - `float[]`"
  ([^Color this comp-array]
    (-> this (.getRGBColorComponents comp-array))))

(defn get-rgb-components
  "Returns a float array containing the color and alpha
   components of the Color, as represented in the default
   sRGB color space.
   If compArray is null, an array of length
   4 is created for the return value.  Otherwise,
   compArray must have length 4 or greater,
   and it is filled in with the components and returned.

  comp-array - an array that this method fills with color and alpha components and returns - `float[]`

  returns: the RGBA components in a float array. - `float[]`"
  ([^Color this comp-array]
    (-> this (.getRGBComponents comp-array))))

(defn equals
  "Determines whether another object is equal to this
   Color.

   The result is true if and only if the argument is not
   null and is a Color object that has the same
   red, green, blue, and alpha values as this object.

  obj - the object to test for equality with this Color - `java.lang.Object`

  returns: true if the objects are the same;
                               false otherwise. - `boolean`"
  (^Boolean [^Color this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn brighter
  "Creates a new Color that is a brighter version of this
   Color.

   This method applies an arbitrary scale factor to each of the three RGB
   components of this Color to create a brighter version
   of this Color.
   The alpha value is preserved.
   Although brighter and
   darker are inverse operations, the results of a
   series of invocations of these two methods might be inconsistent
   because of rounding errors.

  returns: a new Color object that is
                   a brighter version of this Color
                   with the same alpha value. - `java.awt.Color`"
  (^java.awt.Color [^Color this]
    (-> this (.brighter))))

