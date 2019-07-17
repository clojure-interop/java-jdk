(ns jdk.awt.print.Paper
  "The Paper class describes the physical characteristics of
  a piece of paper.

  When creating a Paper object, it is the application's
  responsibility to ensure that the paper size and the imageable area
  are compatible.  For example, if the paper size is changed from
  11 x 17 to 8.5 x 11, the application might need to reduce the
  imageable area so that whatever is printed fits on the page."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print Paper]))

(defn ->paper
  "Constructor.

  Creates a letter sized piece of paper
   with one inch margins."
  ([]
    (new Paper )))

(defn set-imageable-area
  "Sets the imageable area of this Paper.  The
   imageable area is the area on the page in which printing
   occurs.

  x - the X coordinate to which to set the upper-left corner of the imageable area of this Paper - `double`
  y - the Y coordinate to which to set the upper-left corner of the imageable area of this Paper - `double`
  width - the value to which to set the width of the imageable area of this Paper - `double`
  height - the value to which to set the height of the imageable area of this Paper - `double`"
  ([^java.awt.print.Paper this ^Double x ^Double y ^Double width ^Double height]
    (-> this (.setImageableArea x y width height))))

(defn get-width
  "Returns the width of the page in 1/72nds
   of an inch.

  returns: the width of the page described by this
   Paper. - `double`"
  (^Double [^java.awt.print.Paper this]
    (-> this (.getWidth))))

(defn get-imageable-width
  "Returns the width of this Paper object's imageable
   area.

  returns: the width of the imageable area. - `double`"
  (^Double [^java.awt.print.Paper this]
    (-> this (.getImageableWidth))))

(defn get-imageable-height
  "Returns the height of this Paper object's imageable
   area.

  returns: the height of the imageable area. - `double`"
  (^Double [^java.awt.print.Paper this]
    (-> this (.getImageableHeight))))

(defn get-height
  "Returns the height of the page in 1/72nds of an inch.

  returns: the height of the page described by this
            Paper. - `double`"
  (^Double [^java.awt.print.Paper this]
    (-> this (.getHeight))))

(defn set-size
  "Sets the width and height of this Paper
   object, which represents the properties of the page onto
   which printing occurs.
   The dimensions are supplied in 1/72nds of
   an inch.

  width - the value to which to set this Paper object's width - `double`
  height - the value to which to set this Paper object's height - `double`"
  ([^java.awt.print.Paper this ^Double width ^Double height]
    (-> this (.setSize width height))))

(defn get-imageable-x
  "Returns the x coordinate of the upper-left corner of this
   Paper object's imageable area.

  returns: the x coordinate of the imageable area. - `double`"
  (^Double [^java.awt.print.Paper this]
    (-> this (.getImageableX))))

(defn clone
  "Creates a copy of this Paper with the same contents
   as this Paper.

  returns: a copy of this Paper. - `java.lang.Object`"
  (^java.lang.Object [^java.awt.print.Paper this]
    (-> this (.clone))))

(defn get-imageable-y
  "Returns the y coordinate of the upper-left corner of this
   Paper object's imageable area.

  returns: the y coordinate of the imageable area. - `double`"
  (^Double [^java.awt.print.Paper this]
    (-> this (.getImageableY))))

