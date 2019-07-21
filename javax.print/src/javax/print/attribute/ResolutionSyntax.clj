(ns javax.print.attribute.ResolutionSyntax
  "Class ResolutionSyntax is an abstract base class providing the common
  implementation of all attributes denoting a printer resolution.

  A resolution attribute's value consists of two items, the cross feed
  direction resolution and the feed direction resolution. A resolution
  attribute may be constructed by supplying the two values and indicating the
  units in which the values are measured. Methods are provided to return a
  resolution attribute's values, indicating the units in which the values are
  to be returned. The two most common resolution units are dots per inch (dpi)
  and dots per centimeter (dpcm), and exported constants DPI and DPCM are provided for
  indicating those units.

  Once constructed, a resolution attribute's value is immutable.

  Design

  A resolution attribute's cross feed direction resolution and feed direction
  resolution values are stored internally using units of dots per 100 inches
  (dphi). Storing the values in dphi rather than, say, metric units allows
  precise integer arithmetic conversions between dpi and dphi and between dpcm
  and dphi: 1 dpi = 100 dphi, 1 dpcm = 254 dphi. Thus, the values can be stored
  into and retrieved back from a resolution attribute in either units with no
  loss of precision. This would not be guaranteed if a floating point
  representation were used. However, roundoff error will in general occur if a
  resolution attribute's values are created in one units and retrieved in
  different units; for example, 600 dpi will be rounded to 236 dpcm, whereas
  the true value (to five figures) is 236.22 dpcm.

  Storing the values internally in common units of dphi lets two resolution
  attributes be compared without regard to the units in which they were
  created; for example, 300 dpcm will compare equal to 762 dpi, as they both
  are stored as 76200 dphi. In particular, a lookup service can
  match resolution attributes based on equality of their serialized
  representations regardless of the units in which they were created. Again,
  using integers for internal storage allows precise equality comparisons to be
  done, which would not be guaranteed if a floating point representation were
  used.

  The exported constant DPI is actually the
  conversion factor by which to multiply a value in dpi to get the value in
  dphi. Likewise, the exported constant DPCM is the
  conversion factor by which to multiply a value in dpcm to get the value in
  dphi. A client can specify a resolution value in units other than dpi or dpcm
  by supplying its own conversion factor. However, since the internal units of
  dphi was chosen with supporting only the external units of dpi and dpcm in
  mind, there is no guarantee that the conversion factor for the client's units
  will be an exact integer. If the conversion factor isn't an exact integer,
  resolution values in the client's units won't be stored precisely."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute ResolutionSyntax]))

(defn ->resolution-syntax
  "Constructor.

  Construct a new resolution attribute from the given items.

  cross-feed-resolution - Cross feed direction resolution. - `int`
  feed-resolution - Feed direction resolution. - `int`
  units - Unit conversion factor, e.g. DPI or DPCM. - `int`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if crossFeedResolution < 1 or feedResolution < 1 or units < 1."
  (^ResolutionSyntax [^Integer cross-feed-resolution ^Integer feed-resolution ^Integer units]
    (new ResolutionSyntax cross-feed-resolution feed-resolution units)))

(def *-dpi
  "Static Constant.

  Value to indicate units of dots per inch (dpi). It is actually the
   conversion factor by which to multiply dpi to yield dphi (100).

  type: int"
  ResolutionSyntax/DPI)

(def *-dpcm
  "Static Constant.

  Value to indicate units of dots per centimeter (dpcm). It is actually
   the conversion factor by which to multiply dpcm to yield dphi (254).

  type: int"
  ResolutionSyntax/DPCM)

(defn get-resolution
  "Get this resolution attribute's resolution values in the given units.
   The values are rounded to the nearest integer.

  units - Unit conversion factor, e.g. DPI or DPCM. - `int`

  returns: A two-element array with the cross feed direction resolution
            at index 0 and the feed direction resolution at index 1. - `int[]`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  ([^ResolutionSyntax this ^Integer units]
    (-> this (.getResolution units))))

(defn get-cross-feed-resolution
  "Returns this resolution attribute's cross feed direction resolution in
   the given units. The value is rounded to the nearest integer.

  units - Unit conversion factor, e.g. DPI or DPCM. - `int`

  returns: Cross feed direction resolution. - `int`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^Integer [^ResolutionSyntax this ^Integer units]
    (-> this (.getCrossFeedResolution units))))

(defn get-feed-resolution
  "Returns this resolution attribute's feed direction resolution in the
   given units. The value is rounded to the nearest integer.

  units - Unit conversion factor, e.g. DPI or DPCM. - `int`

  returns: Feed direction resolution. - `int`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^Integer [^ResolutionSyntax this ^Integer units]
    (-> this (.getFeedResolution units))))

(defn to-string
  "Returns a string version of this resolution attribute in the given units.
   The string takes the form \"CxF U\",
   where C is the cross feed direction resolution, F is the
   feed direction resolution, and U is the units name. The values are
   rounded to the nearest integer.

  units - Unit conversion factor, e.g. CODE>DPI or DPCM. - `int`
  units-name - Units name string, e.g. \"dpi\" or \"dpcm\". If null, no units name is appended to the result. - `java.lang.String`

  returns: String version of this resolution attribute. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^java.lang.String [^ResolutionSyntax this ^Integer units ^java.lang.String units-name]
    (-> this (.toString units units-name)))
  (^java.lang.String [^ResolutionSyntax this]
    (-> this (.toString))))

(defn less-than-or-equals
  "Determine whether this resolution attribute's value is less than or
   equal to the given resolution attribute's value. This is true if all
   of the following conditions are true:


   This attribute's cross feed direction resolution is less than or equal to
   the other attribute's cross feed direction resolution.

   This attribute's feed direction resolution is less than or equal to the
   other attribute's feed direction resolution.

  other - Resolution attribute to compare with. - `javax.print.attribute.ResolutionSyntax`

  returns: True if this resolution attribute is less than or equal to the
            other resolution attribute, false otherwise. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if other is null."
  (^Boolean [^ResolutionSyntax this ^javax.print.attribute.ResolutionSyntax other]
    (-> this (.lessThanOrEquals other))))

(defn equals
  "Returns whether this resolution attribute is equivalent to the passed in
   object. To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class ResolutionSyntax.

   This attribute's cross feed direction resolution is equal to
   object's cross feed direction resolution.

   This attribute's feed direction resolution is equal to
   object's feed direction resolution.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this resolution
            attribute, false otherwise. - `boolean`"
  (^Boolean [^ResolutionSyntax this ^java.lang.Object object]
    (-> this (.equals object))))

(defn hash-code
  "Returns a hash code value for this resolution attribute.

  returns: a hash code value for this object. - `int`"
  (^Integer [^ResolutionSyntax this]
    (-> this (.hashCode))))

