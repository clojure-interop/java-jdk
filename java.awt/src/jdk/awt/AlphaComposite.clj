(ns jdk.awt.AlphaComposite
  "The AlphaComposite class implements basic alpha
  compositing rules for combining source and destination colors
  to achieve blending and transparency effects with graphics and
  images.
  The specific rules implemented by this class are the basic set
  of 12 rules described in
  T. Porter and T. Duff, `Compositing Digital Images`, SIGGRAPH 84,
  253-259.
  The rest of this documentation assumes some familiarity with the
  definitions and concepts outlined in that paper.


  This class extends the standard equations defined by Porter and
  Duff to include one additional factor.
  An instance of the AlphaComposite class can contain
  an alpha value that is used to modify the opacity or coverage of
  every source pixel before it is used in the blending equations.


  It is important to note that the equations defined by the Porter
  and Duff paper are all defined to operate on color components
  that are premultiplied by their corresponding alpha components.
  Since the ColorModel and Raster classes
  allow the storage of pixel data in either premultiplied or
  non-premultiplied form, all input data must be normalized into
  premultiplied form before applying the equations and all results
  might need to be adjusted back to the form required by the destination
  before the pixel values are stored.


  Also note that this class defines only the equations
  for combining color and alpha values in a purely mathematical
  sense. The accurate application of its equations depends
  on the way the data is retrieved from its sources and stored
  in its destinations.
  See Implementation Caveats
  for further information.


  The following factors are used in the description of the blending
  equation in the Porter and Duff paper:



  Factor  Definition
  Asthe alpha component of the source pixel
  Csa color component of the source pixel in premultiplied form
  Adthe alpha component of the destination pixel
  Cda color component of the destination pixel in premultiplied form
  Fsthe fraction of the source pixel that contributes to the output
  Fdthe fraction of the destination pixel that contributes
  to the output
  Arthe alpha component of the result
  Cra color component of the result in premultiplied form




  Using these factors, Porter and Duff define 12 ways of choosing
  the blending factors Fs and Fd to
  produce each of 12 desirable visual effects.
  The equations for determining Fs and Fd
  are given in the descriptions of the 12 static fields
  that specify visual effects.
  For example,
  the description for
  SRC_OVER
  specifies that Fs = 1 and Fd = (1-As).
  Once a set of equations for determining the blending factors is
  known they can then be applied to each pixel to produce a result
  using the following set of equations:



       Fs = f(Ad)
       Fd = f(As)
       Ar = As*Fs  Ad*Fd
       Cr = Cs*Fs  Cd*Fd


  The following factors will be used to discuss our extensions to
  the blending equation in the Porter and Duff paper:



  Factor  Definition
  Csr one of the raw color components of the source pixel
  Cdr one of the raw color components of the destination pixel
  Aac  the `extra` alpha component from the AlphaComposite instance
  Asr the raw alpha component of the source pixel
  Adrthe raw alpha component of the destination pixel
  Adf the final alpha component stored in the destination
  Cdf the final raw color component stored in the destination



  Preparing Inputs


  The AlphaComposite class defines an additional alpha
  value that is applied to the source alpha.
  This value is applied as if an implicit SRC_IN rule were first
  applied to the source pixel against a pixel with the indicated
  alpha by multiplying both the raw source alpha and the raw
  source colors by the alpha in the AlphaComposite.
  This leads to the following equation for producing the alpha
  used in the Porter and Duff blending equation:



       As = Asr * Aac

  All of the raw source color components need to be multiplied
  by the alpha in the AlphaComposite instance.
  Additionally, if the source was not in premultiplied form
  then the color components also need to be multiplied by the
  source alpha.
  Thus, the equation for producing the source color components
  for the Porter and Duff equation depends on whether the source
  pixels are premultiplied or not:



       Cs = Csr * Asr * Aac     (if source is not premultiplied)
       Cs = Csr * Aac           (if source is premultiplied)

  No adjustment needs to be made to the destination alpha:



       Ad = Adr


  The destination color components need to be adjusted only if
  they are not in premultiplied form:



       Cd = Cdr * Ad    (if destination is not premultiplied)
       Cd = Cdr         (if destination is premultiplied)

  Applying the Blending Equation


  The adjusted As, Ad,
  Cs, and Cd are used in the standard
  Porter and Duff equations to calculate the blending factors
  Fs and Fd and then the resulting
  premultiplied components Ar and Cr.

  Preparing Results


  The results only need to be adjusted if they are to be stored
  back into a destination buffer that holds data that is not
  premultiplied, using the following equations:



       Adf = Ar
       Cdf = Cr                 (if dest is premultiplied)
       Cdf = Cr / Ar            (if dest is not premultiplied)

  Note that since the division is undefined if the resulting alpha
  is zero, the division in that case is omitted to avoid the `divide
  by zero` and the color components are left as
  all zeros.

  Performance Considerations


  For performance reasons, it is preferable that
  Raster objects passed to the compose
  method of a CompositeContext object created by the
  AlphaComposite class have premultiplied data.
  If either the source Raster
  or the destination Raster
  is not premultiplied, however,
  appropriate conversions are performed before and after the compositing
  operation.

  Implementation Caveats



  Many sources, such as some of the opaque image types listed
  in the BufferedImage class, do not store alpha values
  for their pixels.  Such sources supply an alpha of 1.0 for
  all of their pixels.


  Many destinations also have no place to store the alpha values
  that result from the blending calculations performed by this class.
  Such destinations thus implicitly discard the resulting
  alpha values that this class produces.
  It is recommended that such destinations should treat their stored
  color values as non-premultiplied and divide the resulting color
  values by the resulting alpha value before storing the color
  values and discarding the alpha value.


  The accuracy of the results depends on the manner in which pixels
  are stored in the destination.
  An image format that provides at least 8 bits of storage per color
  and alpha component is at least adequate for use as a destination
  for a sequence of a few to a dozen compositing operations.
  An image format with fewer than 8 bits of storage per component
  is of limited use for just one or two compositing operations
  before the rounding errors dominate the results.
  An image format
  that does not separately store
  color components is not a
  good candidate for any type of translucent blending.
  For example, BufferedImage.TYPE_BYTE_INDEXED
  should not be used as a destination for a blending operation
  because every operation
  can introduce large errors, due to
  the need to choose a pixel from a limited palette to match the
  results of the blending equations.


  Nearly all formats store pixels as discrete integers rather than
  the floating point values used in the reference equations above.
  The implementation can either scale the integer pixel
  values into floating point values in the range 0.0 to 1.0 or
  use slightly modified versions of the equations
  that operate entirely in the integer domain and yet produce
  analogous results to the reference equations.


  Typically the integer values are related to the floating point
  values in such a way that the integer 0 is equated
  to the floating point value 0.0 and the integer
  2^n-1 (where n is the number of bits
  in the representation) is equated to 1.0.
  For 8-bit representations, this means that 0x00
  represents 0.0 and 0xff represents
  1.0.


  The internal implementation can approximate some of the equations
  and it can also eliminate some steps to avoid unnecessary operations.
  For example, consider a discrete integer image with non-premultiplied
  alpha values that uses 8 bits per component for storage.
  The stored values for a
  nearly transparent darkened red might be:



     (A, R, G, B) = (0x01, 0xb0, 0x00, 0x00)


  If integer math were being used and this value were being
  composited in
  SRC
  mode with no extra alpha, then the math would
  indicate that the results were (in integer format):



     (A, R, G, B) = (0x01, 0x01, 0x00, 0x00)


  Note that the intermediate values, which are always in premultiplied
  form, would only allow the integer red component to be either 0x00
  or 0x01.  When we try to store this result back into a destination
  that is not premultiplied, dividing out the alpha will give us
  very few choices for the non-premultiplied red value.
  In this case an implementation that performs the math in integer
  space without shortcuts is likely to end up with the final pixel
  values of:



     (A, R, G, B) = (0x01, 0xff, 0x00, 0x00)


  (Note that 0x01 divided by 0x01 gives you 1.0, which is equivalent
  to the value 0xff in an 8-bit storage format.)


  Alternately, an implementation that uses floating point math
  might produce more accurate results and end up returning to the
  original pixel value with little, if any, roundoff error.
  Or, an implementation using integer math might decide that since
  the equations boil down to a virtual NOP on the color values
  if performed in a floating point space, it can transfer the
  pixel untouched to the destination and avoid all the math entirely.


  These implementations all attempt to honor the
  same equations, but use different tradeoffs of integer and
  floating point math and reduced or full equations.
  To account for such differences, it is probably best to
  expect only that the premultiplied form of the results to
  match between implementations and image formats.  In this
  case both answers, expressed in premultiplied form would
  equate to:



     (A, R, G, B) = (0x01, 0x01, 0x00, 0x00)


  and thus they would all match.


  Because of the technique of simplifying the equations for
  calculation efficiency, some implementations might perform
  differently when encountering result alpha values of 0.0
  on a non-premultiplied destination.
  Note that the simplification of removing the divide by alpha
  in the case of the SRC rule is technically not valid if the
  denominator (alpha) is 0.
  But, since the results should only be expected to be accurate
  when viewed in premultiplied form, a resulting alpha of 0
  essentially renders the resulting color components irrelevant
  and so exact behavior in this case should not be expected."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt AlphaComposite]))

(def *-clear
  "Static Constant.

  Both the color and the alpha of the destination are cleared
   (Porter-Duff Clear rule).
   Neither the source nor the destination is used as input.

   Fs = 0 and Fd = 0, thus:


    Ar = 0
    Cr = 0

  type: java.lang.annotation.    int"
  AlphaComposite/CLEAR)

(def *-src
  "Static Constant.

  The source is copied to the destination
   (Porter-Duff Source rule).
   The destination is not used as input.

   Fs = 1 and Fd = 0, thus:


    Ar = As
    Cr = Cs

  type: java.lang.annotation.    int"
  AlphaComposite/SRC)

(def *-dst
  "Static Constant.

  The destination is left untouched
   (Porter-Duff Destination rule).

   Fs = 0 and Fd = 1, thus:


    Ar = Ad
    Cr = Cd

  type: java.lang.annotation.    int"
  AlphaComposite/DST)

(def *-src-over
  "Static Constant.

  The source is composited over the destination
   (Porter-Duff Source Over Destination rule).

   Fs = 1 and Fd = (1-As), thus:


    Ar = As  Ad*(1-As)
    Cr = Cs  Cd*(1-As)

  type: java.lang.annotation.    int"
  AlphaComposite/SRC_OVER)

(def *-dst-over
  "Static Constant.

  The destination is composited over the source and
   the result replaces the destination
   (Porter-Duff Destination Over Source rule).

   Fs = (1-Ad) and Fd = 1, thus:


    Ar = As*(1-Ad)  Ad
    Cr = Cs*(1-Ad)  Cd

  type: java.lang.annotation.    int"
  AlphaComposite/DST_OVER)

(def *-src-in
  "Static Constant.

  The part of the source lying inside of the destination replaces
   the destination
   (Porter-Duff Source In Destination rule).

   Fs = Ad and Fd = 0, thus:


    Ar = As*Ad
    Cr = Cs*Ad

  type: java.lang.annotation.    int"
  AlphaComposite/SRC_IN)

(def *-dst-in
  "Static Constant.

  The part of the destination lying inside of the source
   replaces the destination
   (Porter-Duff Destination In Source rule).

   Fs = 0 and Fd = As, thus:


    Ar = Ad*As
    Cr = Cd*As

  type: java.lang.annotation.    int"
  AlphaComposite/DST_IN)

(def *-src-out
  "Static Constant.

  The part of the source lying outside of the destination
   replaces the destination
   (Porter-Duff Source Held Out By Destination rule).

   Fs = (1-Ad) and Fd = 0, thus:


    Ar = As*(1-Ad)
    Cr = Cs*(1-Ad)

  type: java.lang.annotation.    int"
  AlphaComposite/SRC_OUT)

(def *-dst-out
  "Static Constant.

  The part of the destination lying outside of the source
   replaces the destination
   (Porter-Duff Destination Held Out By Source rule).

   Fs = 0 and Fd = (1-As), thus:


    Ar = Ad*(1-As)
    Cr = Cd*(1-As)

  type: java.lang.annotation.    int"
  AlphaComposite/DST_OUT)

(def *-src-atop
  "Static Constant.

  The part of the source lying inside of the destination
   is composited onto the destination
   (Porter-Duff Source Atop Destination rule).

   Fs = Ad and Fd = (1-As), thus:


    Ar = As*Ad  Ad*(1-As) = Ad
    Cr = Cs*Ad  Cd*(1-As)

  type: java.lang.annotation.    int"
  AlphaComposite/SRC_ATOP)

(def *-dst-atop
  "Static Constant.

  The part of the destination lying inside of the source
   is composited over the source and replaces the destination
   (Porter-Duff Destination Atop Source rule).

   Fs = (1-Ad) and Fd = As, thus:


    Ar = As*(1-Ad)  Ad*As = As
    Cr = Cs*(1-Ad)  Cd*As

  type: java.lang.annotation.    int"
  AlphaComposite/DST_ATOP)

(def *-xor
  "Static Constant.

  The part of the source that lies outside of the destination
   is combined with the part of the destination that lies outside
   of the source
   (Porter-Duff Source Xor Destination rule).

   Fs = (1-Ad) and Fd = (1-As), thus:


    Ar = As*(1-Ad)  Ad*(1-As)
    Cr = Cs*(1-Ad)  Cd*(1-As)

  type: java.lang.annotation.    int"
  AlphaComposite/XOR)

(def *-clear
  "Static Constant.

  AlphaComposite object that implements the opaque CLEAR rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/Clear)

(def *-src
  "Static Constant.

  AlphaComposite object that implements the opaque SRC rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/Src)

(def *-dst
  "Static Constant.

  AlphaComposite object that implements the opaque DST rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/Dst)

(def *-src-over
  "Static Constant.

  AlphaComposite object that implements the opaque SRC_OVER rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/SrcOver)

(def *-dst-over
  "Static Constant.

  AlphaComposite object that implements the opaque DST_OVER rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/DstOver)

(def *-src-in
  "Static Constant.

  AlphaComposite object that implements the opaque SRC_IN rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/SrcIn)

(def *-dst-in
  "Static Constant.

  AlphaComposite object that implements the opaque DST_IN rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/DstIn)

(def *-src-out
  "Static Constant.

  AlphaComposite object that implements the opaque SRC_OUT rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/SrcOut)

(def *-dst-out
  "Static Constant.

  AlphaComposite object that implements the opaque DST_OUT rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/DstOut)

(def *-src-atop
  "Static Constant.

  AlphaComposite object that implements the opaque SRC_ATOP rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/SrcAtop)

(def *-dst-atop
  "Static Constant.

  AlphaComposite object that implements the opaque DST_ATOP rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/DstAtop)

(def *-xor
  "Static Constant.

  AlphaComposite object that implements the opaque XOR rule
   with an alpha of 1.0f.

  type: java.awt.AlphaComposite"
  AlphaComposite/Xor)

(defn *get-instance
  "Creates an AlphaComposite object with the specified rule and
   the constant alpha to multiply with the alpha of the source.
   The source is multiplied with the specified alpha before being composited
   with the destination.

  rule - the compositing rule - `int`
  alpha - the constant alpha to be multiplied with the alpha of the source. alpha must be a floating point number in the inclusive range [0.0, 1.0]. - `float`

  returns: `java.awt.AlphaComposite`

  throws: java.lang.IllegalArgumentException - if alpha is less than 0.0 or greater than 1.0, or if rule is not one of the following: CLEAR, SRC, DST, SRC_OVER, DST_OVER, SRC_IN, DST_IN, SRC_OUT, DST_OUT, SRC_ATOP, DST_ATOP, or XOR"
  (^java.awt.AlphaComposite [^Integer rule ^Float alpha]
    (AlphaComposite/getInstance rule alpha))
  (^java.awt.AlphaComposite [^Integer rule]
    (AlphaComposite/getInstance rule)))

(defn create-context
  "Creates a context for the compositing operation.
   The context contains state that is used in performing
   the compositing operation.

  src-color-model - the ColorModel of the source - `java.awt.image.ColorModel`
  dst-color-model - the ColorModel of the destination - `java.awt.image.ColorModel`
  hints - the hint that the context object uses to choose between rendering alternatives - `java.awt.RenderingHints`

  returns: the CompositeContext object to be used to perform
   compositing operations. - `java.awt.CompositeContext`"
  (^java.awt.CompositeContext [^java.awt.AlphaComposite this ^java.awt.image.ColorModel src-color-model ^java.awt.image.ColorModel dst-color-model ^java.awt.RenderingHints hints]
    (-> this (.createContext src-color-model dst-color-model hints))))

(defn get-alpha
  "Returns the alpha value of this AlphaComposite.  If this
   AlphaComposite does not have an alpha value, 1.0 is returned.

  returns: the alpha value of this AlphaComposite. - `float`"
  (^Float [^java.awt.AlphaComposite this]
    (-> this (.getAlpha))))

(defn get-rule
  "Returns the compositing rule of this AlphaComposite.

  returns: the compositing rule of this AlphaComposite. - `int`"
  (^Integer [^java.awt.AlphaComposite this]
    (-> this (.getRule))))

(defn derive
  "Returns a similar AlphaComposite object that uses
   the specified compositing rule.
   If this object already uses the specified compositing rule,
   this object is returned.

  rule - the compositing rule - `int`

  returns: an AlphaComposite object derived from
   this object that uses the specified compositing rule. - `java.awt.AlphaComposite`

  throws: java.lang.IllegalArgumentException - if rule is not one of the following: CLEAR, SRC, DST, SRC_OVER, DST_OVER, SRC_IN, DST_IN, SRC_OUT, DST_OUT, SRC_ATOP, DST_ATOP, or XOR"
  (^java.awt.AlphaComposite [^java.awt.AlphaComposite this ^Integer rule]
    (-> this (.derive rule))))

(defn hash-code
  "Returns the hashcode for this composite.

  returns: a hash code for this composite. - `int`"
  (^Integer [^java.awt.AlphaComposite this]
    (-> this (.hashCode))))

(defn equals
  "Determines whether the specified object is equal to this
   AlphaComposite.

   The result is true if and only if
   the argument is not null and is an
   AlphaComposite object that has the same
   compositing rule and alpha value as this object.

  obj - the Object to test for equality - `java.lang.Object`

  returns: true if obj equals this
   AlphaComposite; false otherwise. - `boolean`"
  (^Boolean [^java.awt.AlphaComposite this ^java.lang.Object obj]
    (-> this (.equals obj))))

