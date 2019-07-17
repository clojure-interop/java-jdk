(ns jdk.awt.color.ICC_ProfileRGB
  "The ICC_ProfileRGB class is a subclass of the ICC_Profile class
  that represents profiles which meet the following criteria:

  The profile's color space type is RGB.
  The profile includes the redColorantTag,
  greenColorantTag, blueColorantTag,
  redTRCTag, greenTRCTag,
  blueTRCTag, and mediaWhitePointTag tags.

  The ICC_Profile getInstance method will
  return an ICC_ProfileRGB object when these conditions are met.
  Three-component, matrix-based input profiles and RGB display profiles are
  examples of this type of profile.

  This profile class provides color transform matrices and lookup tables
  that Java or native methods can use directly to
  optimize color conversion in some cases.

  To transform from a device profile color space to the CIEXYZ Profile
  Connection Space, each device color component is first linearized by
  a lookup through the corresponding tone reproduction curve (TRC).
  The resulting linear RGB components are converted to the CIEXYZ PCS
  using a a 3x3 matrix constructed from the RGB colorants.


                  linearR = redTRC[deviceR]

                  linearG = greenTRC[deviceG]

                  linearB = blueTRC[deviceB]

    _      _       _                                             _   _         _
   [  PCSX  ]     [  redColorantX  greenColorantX  blueColorantX  ] [  linearR  ]
   [        ]     [                                               ] [           ]
   [  PCSY  ]  =  [  redColorantY  greenColorantY  blueColorantY  ] [  linearG  ]
   [        ]     [                                               ] [           ]
   [_ PCSZ _]     [_ redColorantZ  greenColorantZ  blueColorantZ _] [_ linearB _]
  The inverse transform is performed by converting PCS XYZ components to linear
  RGB components through the inverse of the above 3x3 matrix, and then converting
  linear RGB to device RGB through inverses of the TRCs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.color ICC_ProfileRGB]))

(def *-redcomponent
  "Static Constant.

  Used to get a gamma value or TRC for the red component.

  type: int"
  ICC_ProfileRGB/REDCOMPONENT)

(def *-greencomponent
  "Static Constant.

  Used to get a gamma value or TRC for the green component.

  type: int"
  ICC_ProfileRGB/GREENCOMPONENT)

(def *-bluecomponent
  "Static Constant.

  Used to get a gamma value or TRC for the blue component.

  type: int"
  ICC_ProfileRGB/BLUECOMPONENT)

(defn get-media-white-point
  "Returns an array that contains the components of the profile's
   mediaWhitePointTag.

  returns: A 3-element float array containing the x, y,
   and z components of the profile's mediaWhitePointTag. - `float[]`"
  ([this]
    (-> this (.getMediaWhitePoint))))

(defn get-matrix
  "Returns a 3x3 float matrix constructed from the
   X, Y, and Z components of the profile's redColorantTag,
   greenColorantTag, and blueColorantTag.

   This matrix can be used for color transforms in the forward
   direction of the profile--from the profile color space
   to the CIEXYZ PCS.

  returns: A 3x3 float array that contains the x, y, and z
   components of the profile's redColorantTag,
   greenColorantTag, and blueColorantTag. - `float[][]`"
  ([this]
    (-> this (.getMatrix))))

(defn get-gamma
  "Returns a gamma value representing the tone reproduction curve
   (TRC) for a particular component.  The component parameter
   must be one of REDCOMPONENT, GREENCOMPONENT, or BLUECOMPONENT.

   If the profile
   represents the TRC for the corresponding component
   as a table rather than a single gamma value, an
   exception is thrown.  In this case the actual table
   can be obtained through the getTRC(int) method.
   When using a gamma value,
   the linear component (R, G, or B) is computed as follows:


                                             gamma
            linearComponent = deviceComponent

  component - The ICC_ProfileRGB constant that represents the component whose TRC you want to retrieve - `int`

  returns: the gamma value as a float. - `float`

  throws: java.awt.color.ProfileDataException - if the profile does not specify the corresponding TRC as a single gamma value."
  ([this component]
    (-> this (.getGamma component))))

(defn get-trc
  "Returns the TRC for a particular component as an array.
   Component must be REDCOMPONENT,
   GREENCOMPONENT, or BLUECOMPONENT.
   Otherwise the returned array
   represents a lookup table where the input component value
   is conceptually in the range [0.0, 1.0].  Value 0.0 maps
   to array index 0 and value 1.0 maps to array index length-1.
   Interpolation might be used to generate output values for
   input values that do not map exactly to an index in the
   array.  Output values also map linearly to the range [0.0, 1.0].
   Value 0.0 is represented by an array value of 0x0000 and
   value 1.0 by 0xFFFF.  In other words, the values are really unsigned
   short values even though they are returned in a
   short array.

   If the profile has specified the corresponding TRC
   as linear (gamma = 1.0) or as a simple gamma value, this method
   throws an exception.  In this case, the getGamma(int)
   method should be used to get the gamma value.

  component - The ICC_ProfileRGB constant that represents the component whose TRC you want to retrieve: REDCOMPONENT, GREENCOMPONENT, or BLUECOMPONENT. - `int`

  returns: a short array representing the TRC. - `short[]`

  throws: java.awt.color.ProfileDataException - if the profile does not specify the corresponding TRC as a table."
  ([this component]
    (-> this (.getTRC component))))

