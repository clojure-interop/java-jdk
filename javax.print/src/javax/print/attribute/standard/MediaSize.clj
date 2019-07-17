(ns javax.print.attribute.standard.MediaSize
  "Class MediaSize is a two-dimensional size valued printing attribute class
  that indicates the dimensions of the medium in a portrait orientation, with
  the X dimension running along the bottom edge and the Y dimension running
  along the left edge. Thus, the Y dimension must be greater than or equal to
  the X dimension. Class MediaSize declares many standard media size
  values, organized into nested classes for ISO, JIS, North American,
  engineering, and other media.

  MediaSize is not yet used to specify media. Its current role is
  as a mapping for named media (see MediaSizeName).
  Clients can use the mapping method
  MediaSize.getMediaSizeForName(MediaSizeName)
  to find the physical dimensions of the MediaSizeName instances
  enumerated in this API. This is useful for clients which need this
  information to format & paginate printing."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard MediaSize]))

(defn ->media-size
  "Constructor.

  Construct a new media size attribute from the given floating-point
   values.

  x - X dimension. - `float`
  y - Y dimension. - `float`
  units - Unit conversion factor, e.g. Size2DSyntax.INCH or Size2DSyntax.MM. - `int`
  media - a media name to associate with this MediaSize - `javax.print.attribute.standard.MediaSizeName`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if x < 0 or y < 0 or units < 1 or x > y."
  ([^Float x ^Float y ^Integer units ^javax.print.attribute.standard.MediaSizeName media]
    (new MediaSize x y units media))
  ([^Float x ^Float y ^Integer units]
    (new MediaSize x y units)))

(defn *get-media-size-for-name
  "Get the MediaSize for the specified named media.

  media - - the name of the media for which the size is sought - `javax.print.attribute.standard.MediaSizeName`

  returns: size of the media, or null if this media is not associated
   with any size. - `javax.print.attribute.standard.MediaSize`"
  (^javax.print.attribute.standard.MediaSize [^javax.print.attribute.standard.MediaSizeName media]
    (MediaSize/getMediaSizeForName media)))

(defn *find-media
  "The specified dimensions are used to locate a matching MediaSize
   instance from amongst all the standard MediaSize instances.
   If there is no exact match, the closest match is used.

   The MediaSize is in turn used to locate the MediaSizeName object.
   This method may return null if the closest matching MediaSize
   has no corresponding Media instance.

   This method is useful for clients which have only dimensions and
   want to find a Media which corresponds to the dimensions.

  x - - X dimension - `float`
  y - - Y dimension. - `float`
  units - Unit conversion factor, e.g. Size2DSyntax.INCH or Size2DSyntax.MM - `int`

  returns: MediaSizeName matching these dimensions, or null. - `javax.print.attribute.standard.MediaSizeName`

  throws: java.lang.IllegalArgumentException - if x <= 0, y <= 0, or units < 1."
  (^javax.print.attribute.standard.MediaSizeName [^Float x ^Float y ^Integer units]
    (MediaSize/findMedia x y units)))

(defn get-media-size-name
  "Get the media name, if any, for this size.

  returns: the name for this media size, or null if no name was
   associated with this size (an anonymous size). - `javax.print.attribute.standard.MediaSizeName`"
  (^javax.print.attribute.standard.MediaSizeName [^javax.print.attribute.standard.MediaSize this]
    (-> this (.getMediaSizeName))))

(defn equals
  "Returns whether this media size attribute is equivalent to the passed
   in object.
   To be equivalent, all of the following conditions must be true:


   object is not null.

   object is an instance of class MediaSize.

   This media size attribute's X dimension is equal to
   object's X dimension.

   This media size attribute's Y dimension is equal to
   object's Y dimension.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this media size
            attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.MediaSize this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class MediaSize and any vendor-defined subclasses, the category is
   class MediaSize itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.MediaSize this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class MediaSize and any vendor-defined subclasses, the category
   name is `media-size`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.MediaSize this]
    (-> this (.getName))))

