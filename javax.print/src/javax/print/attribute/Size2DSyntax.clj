(ns javax.print.attribute.Size2DSyntax
  "Class Size2DSyntax is an abstract base class providing the common
  implementation of all attributes denoting a size in two dimensions.

  A two-dimensional size attribute's value consists of two items, the X
  dimension and the Y dimension. A two-dimensional size attribute may be
  constructed by supplying the two values and indicating the units in which the
  values are measured. Methods are provided to return a two-dimensional size
  attribute's values, indicating the units in which the values are to be
  returned. The two most common size units are inches (in) and millimeters
  (mm), and exported constants INCH and MM are provided for indicating those units.

  Once constructed, a two-dimensional size attribute's value is immutable.

  Design

  A two-dimensional size attribute's X and Y dimension values are stored
  internally as integers in units of micrometers (µm), where 1 micrometer
  = 10-6 meter = 1/1000 millimeter = 1/25400 inch. This permits
  dimensions to be represented exactly to a precision of 1/1000 mm (= 1
  µm) or 1/100 inch (= 254 µm). If fractional inches are expressed in
  negative powers of two, this permits dimensions to be represented exactly to
  a precision of 1/8 inch (= 3175 µm) but not 1/16 inch (because 1/16 inch
  does not equal an integral number of µm).

  Storing the dimensions internally in common units of µm lets two size
  attributes be compared without regard to the units in which they were
  created; for example, 8.5 in will compare equal to 215.9 mm, as they both are
  stored as 215900 µm. For example, a lookup service can
  match resolution attributes based on equality of their serialized
  representations regardless of the units in which they were created. Using
  integers for internal storage allows precise equality comparisons to be done,
  which would not be guaranteed if an internal floating point representation
  were used. Note that if you're looking for U.S. letter sized media in metric
  units, you have to search for a media size of 215.9 x 279.4 mm; rounding off
  to an integral 216 x 279 mm will not match.

  The exported constant INCH is actually the
  conversion factor by which to multiply a value in inches to get the value in
  µm. Likewise, the exported constant MM is the
  conversion factor by which to multiply a value in mm to get the value in
  µm. A client can specify a resolution value in units other than inches
  or mm by supplying its own conversion factor. However, since the internal
  units of µm was chosen with supporting only the external units of inch
  and mm in mind, there is no guarantee that the conversion factor for the
  client's units will be an exact integer. If the conversion factor isn't an
  exact integer, resolution values in the client's units won't be stored
  precisely."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute Size2DSyntax]))

(def *-inch
  "Static Constant.

  Value to indicate units of inches (in). It is actually the conversion
   factor by which to multiply inches to yield µm (25400).

  type: int"
  Size2DSyntax/INCH)

(def *-mm
  "Static Constant.

  Value to indicate units of millimeters (mm). It is actually the
   conversion factor by which to multiply mm to yield µm (1000).

  type: int"
  Size2DSyntax/MM)

(defn get-size
  "Get this two-dimensional size attribute's dimensions in the given units
   as floating-point values.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: A two-element array with the X dimension at index 0 and the Y
            dimension at index 1. - `float[]`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  ([^javax.print.attribute.Size2DSyntax this ^Integer units]
    (-> this (.getSize units))))

(defn get-x
  "Returns this two-dimensional size attribute's X dimension in the given
   units as a floating-point value.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: X dimension. - `float`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  ([^javax.print.attribute.Size2DSyntax this ^Integer units]
    (-> this (.getX units))))

(defn get-y
  "Returns this two-dimensional size attribute's Y dimension in the given
   units as a floating-point value.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: Y dimension. - `float`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  ([^javax.print.attribute.Size2DSyntax this ^Integer units]
    (-> this (.getY units))))

(defn to-string
  "Returns a string version of this two-dimensional size attribute in the
   given units. The string takes the form `XxY
   U`, where X is the X dimension, Y is the Y
   dimension, and U is the units name. The values are displayed in
   floating point.

  units - Unit conversion factor, e.g. INCH or MM. - `int`
  units-name - Units name string, e.g. in or mm. If null, no units name is appended to the result. - `java.lang.String`

  returns: String version of this two-dimensional size attribute. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  ([^javax.print.attribute.Size2DSyntax this ^Integer units ^java.lang.String units-name]
    (-> this (.toString units units-name)))
  ([^javax.print.attribute.Size2DSyntax this]
    (-> this (.toString))))

(defn equals
  "Returns whether this two-dimensional size attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions must
   be true:


   object is not null.

   object is an instance of class Size2DSyntax.

   This attribute's X dimension is equal to object's X
   dimension.

   This attribute's Y dimension is equal to object's Y
   dimension.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this
            two-dimensional size attribute, false otherwise. - `boolean`"
  ([^javax.print.attribute.Size2DSyntax this ^java.lang.Object object]
    (-> this (.equals object))))

(defn hash-code
  "Returns a hash code value for this two-dimensional size attribute.

  returns: a hash code value for this object. - `int`"
  ([^javax.print.attribute.Size2DSyntax this]
    (-> this (.hashCode))))

