(ns javax.print.attribute.standard.MediaPrintableArea
  "Class MediaPrintableArea is a printing attribute used to distinguish
  the printable and non-printable areas of media.

  The printable area is specified to be a rectangle, within the overall
  dimensions of a media.

  Most printers cannot print on the entire surface of the media, due
  to printer hardware limitations. This class can be used to query
  the acceptable values for a supposed print job, and to request an area
  within the constraints of the printable area to be used in a print job.

  To query for the printable area, a client must supply a suitable context.
  Without specifying at the very least the size of the media being used
  no meaningful value for printable area can be obtained.

  The attribute is not described in terms of the distance from the edge
  of the paper, in part to emphasise that this attribute is not independent
  of a particular media, but must be described within the context of a
  choice of other attributes. Additionally it is usually more convenient
  for a client to use the printable area.

  The hardware's minimum margins is not just a property of the printer,
  but may be a function of the media size, orientation, media type, and
  any specified finishings.
  PrintService provides the method to query the supported
  values of an attribute in a suitable context :
  See  PrintService.getSupportedAttributeValues()

  The rectangular printable area is defined thus:
  The (x,y) origin is positioned at the top-left of the paper in portrait
  mode regardless of the orientation specified in the requesting context.
  For example a printable area for A4 paper in portrait or landscape
  orientation will have height > width.

  A printable area attribute's values are stored
  internally as integers in units of micrometers (µm), where 1 micrometer
  = 10-6 meter = 1/1000 millimeter = 1/25400 inch. This permits
  dimensions to be represented exactly to a precision of 1/1000 mm (= 1
  µm) or 1/100 inch (= 254 µm). If fractional inches are expressed in

  negative powers of two, this permits dimensions to be represented exactly to
  a precision of 1/8 inch (= 3175 µm) but not 1/16 inch (because 1/16 inch

  does not equal an integral number of µm).

  IPP Compatibility: MediaPrintableArea is not an IPP attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard MediaPrintableArea]))

(defn ->media-printable-area
  "Constructor.

  Constructs a MediaPrintableArea object from floating point values.

  x - printable x - `float`
  y - printable y - `float`
  w - printable width - `float`
  h - printable height - `float`
  units - in which the values are expressed. - `int`

  throws: java.lang.IllegalArgumentException - Thrown if x < 0 or y < 0 or w <= 0 or h <= 0 or units < 1."
  (^MediaPrintableArea [^Float x ^Float y ^Float w ^Float h ^Integer units]
    (new MediaPrintableArea x y w h units)))

(def *-inch
  "Static Constant.

  Value to indicate units of inches (in). It is actually the conversion
   factor by which to multiply inches to yield µm (25400).

  type: int"
  MediaPrintableArea/INCH)

(def *-mm
  "Static Constant.

  Value to indicate units of millimeters (mm). It is actually the
   conversion factor by which to multiply mm to yield µm (1000).

  type: int"
  MediaPrintableArea/MM)

(defn get-width
  "Get the width of the printable area in the specified units.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: width of the printable area in the specified units. - `float`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^Float [^MediaPrintableArea this ^Integer units]
    (-> this (.getWidth units))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class MediaPrintableArea, the category is
   class MediaPrintableArea itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^MediaPrintableArea this]
    (-> this (.getCategory))))

(defn to-string
  "Returns a string version of this rectangular size attribute in the
   given units.

  units - Unit conversion factor, e.g. INCH or MM. - `int`
  units-name - Units name string, e.g. `in` or `mm`. If null, no units name is appended to the result. - `java.lang.String`

  returns: String version of this two-dimensional size attribute. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^java.lang.String [^MediaPrintableArea this ^Integer units ^java.lang.String units-name]
    (-> this (.toString units units-name)))
  (^java.lang.String [^MediaPrintableArea this]
    (-> this (.toString))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class MediaPrintableArea,
   the category name is `media-printable-area`.
   This is not an IPP V1.1 attribute.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^MediaPrintableArea this]
    (-> this (.getName))))

(defn get-y
  "Get the y location of the origin of the printable area in the
   specified units.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: y location of the origin of the printable area in the
   specified units. - `float`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^Float [^MediaPrintableArea this ^Integer units]
    (-> this (.getY units))))

(defn get-printable-area
  "Get the printable area as an array of 4 values in the order
   x, y, w, h. The values returned are in the given units.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: printable area as array of x, y, w, h in the specified units. - `float[]`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  ([^MediaPrintableArea this ^Integer units]
    (-> this (.getPrintableArea units))))

(defn get-x
  "Get the x location of the origin of the printable area in the
   specified units.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: x location of the origin of the printable area in the
   specified units. - `float`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^Float [^MediaPrintableArea this ^Integer units]
    (-> this (.getX units))))

(defn get-height
  "Get the height of the printable area in the specified units.

  units - Unit conversion factor, e.g. INCH or MM. - `int`

  returns: height of the printable area in the specified units. - `float`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if units < 1."
  (^Float [^MediaPrintableArea this ^Integer units]
    (-> this (.getHeight units))))

(defn hash-code
  "Returns a hash code value for this attribute.

  returns: a hash code value for this object. - `int`"
  (^Integer [^MediaPrintableArea this]
    (-> this (.hashCode))))

(defn equals
  "Returns whether this media margins attribute is equivalent to the passed
   in object.
   To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class MediaPrintableArea.

   The origin and dimensions are the same.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this media margins
            attribute, false otherwise. - `boolean`"
  (^Boolean [^MediaPrintableArea this ^java.lang.Object object]
    (-> this (.equals object))))

