(ns jdk.awt.color.ICC_ProfileGray
  "A subclass of the ICC_Profile class which represents profiles
  which meet the following criteria: the color space type of the
  profile is TYPE_GRAY and the profile includes the grayTRCTag and
  mediaWhitePointTag tags.  Examples of this kind of profile are
  monochrome input profiles, monochrome display profiles, and
  monochrome output profiles.  The getInstance methods in the
  ICC_Profile class will
  return an ICC_ProfileGray object when the above conditions are
  met.  The advantage of this class is that it provides a lookup
  table that Java or native methods may be able to use directly to
  optimize color conversion in some cases.

  To transform from a GRAY device profile color space to the CIEXYZ Profile
  Connection Space, the device gray component is transformed by
  a lookup through the tone reproduction curve (TRC).  The result is
  treated as the achromatic component of the PCS.


                 PCSY = grayTRC[deviceGray]
  The inverse transform is done by converting the PCS Y components to
  device Gray via the inverse of the grayTRC."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.color ICC_ProfileGray]))

(defn get-media-white-point
  "Returns a float array of length 3 containing the X, Y, and Z
   components of the mediaWhitePointTag in the ICC profile.

  returns: an array containing the components of the
   mediaWhitePointTag in the ICC profile. - `float[]`"
  ([^ICC_ProfileGray this]
    (-> this (.getMediaWhitePoint))))

(defn get-gamma
  "Returns a gamma value representing the tone reproduction
   curve (TRC).  If the profile represents the TRC as a table rather
   than a single gamma value, then an exception is thrown.  In this
   case the actual table can be obtained via getTRC().  When
   using a gamma value, the PCS Y component is computed as follows:


                            gamma
           PCSY = deviceGray

  returns: the gamma value as a float. - `float`

  throws: java.awt.color.ProfileDataException - if the profile does not specify the TRC as a single gamma value."
  (^Float [^ICC_ProfileGray this]
    (-> this (.getGamma))))

(defn get-trc
  "Returns the TRC as an array of shorts.  If the profile has
   specified the TRC as linear (gamma = 1.0) or as a simple gamma
   value, this method throws an exception, and the getGamma() method
   should be used to get the gamma value.  Otherwise the short array
   returned here represents a lookup table where the input Gray value
   is conceptually in the range [0.0, 1.0].  Value 0.0 maps
   to array index 0 and value 1.0 maps to array index length-1.
   Interpolation may be used to generate output values for
   input values which do not map exactly to an index in the
   array.  Output values also map linearly to the range [0.0, 1.0].
   Value 0.0 is represented by an array value of 0x0000 and
   value 1.0 by 0xFFFF, i.e. the values are really unsigned
   short values, although they are returned in a short array.

  returns: a short array representing the TRC. - `short[]`

  throws: java.awt.color.ProfileDataException - if the profile does not specify the TRC as a table."
  ([^ICC_ProfileGray this]
    (-> this (.getTRC))))

