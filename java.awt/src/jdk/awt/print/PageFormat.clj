(ns jdk.awt.print.PageFormat
  "The PageFormat class describes the size and
  orientation of a page to be printed."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print PageFormat]))

(defn ->page-format
  "Constructor.

  Creates a default, portrait-oriented
   PageFormat."
  ([]
    (new PageFormat )))

(def *-landscape
  "Static Constant.

  The origin is at the bottom left of the paper with
    x running bottom to top and y running left to right.
    Note that this is not the Macintosh landscape but
    is the Window's and PostScript landscape.

  type: java.lang.annotation.    int"
  PageFormat/LANDSCAPE)

(def *-portrait
  "Static Constant.

  The origin is at the top left of the paper with
    x running to the right and y running down the
    paper.

  type: java.lang.annotation.    int"
  PageFormat/PORTRAIT)

(def *-reverse-landscape
  "Static Constant.

  The origin is at the top right of the paper with x
    running top to bottom and y running right to left.
    Note that this is the Macintosh landscape.

  type: java.lang.annotation.    int"
  PageFormat/REVERSE_LANDSCAPE)

(defn set-paper
  "Sets the Paper object for this
   PageFormat.

  paper - the Paper object to which to set the Paper object for this PageFormat. - `java.awt.print.Paper`

  throws: java.lang.NullPointerException - a null paper instance was passed as a parameter."
  ([this paper]
    (-> this (.setPaper paper))))

(defn get-orientation
  "Returns the orientation of this PageFormat.

  returns: this PageFormat object's orientation. - `int`"
  ([this]
    (-> this (.getOrientation))))

(defn get-width
  "Returns the width, in 1/72nds of an inch, of the page.
   This method takes into account the orientation of the
   page when determining the width.

  returns: the width of the page. - `double`"
  ([this]
    (-> this (.getWidth))))

(defn get-paper
  "Returns a copy of the Paper object associated
   with this PageFormat.  Changes made to the
   Paper object returned from this method do not
   affect the Paper object of this
   PageFormat.  To update the Paper
   object of this PageFormat, create a new
   Paper object and set it into this
   PageFormat by using the setPaper(Paper)
   method.

  returns: a copy of the Paper object associated
            with this PageFormat. - `java.awt.print.Paper`"
  ([this]
    (-> this (.getPaper))))

(defn get-imageable-width
  "Returns the width, in 1/72nds of an inch, of the imageable
   area of the page. This method takes into account the orientation
   of the page.

  returns: the width of the page. - `double`"
  ([this]
    (-> this (.getImageableWidth))))

(defn get-imageable-height
  "Return the height, in 1/72nds of an inch, of the imageable
   area of the page. This method takes into account the orientation
   of the page.

  returns: the height of the page. - `double`"
  ([this]
    (-> this (.getImageableHeight))))

(defn get-height
  "Returns the height, in 1/72nds of an inch, of the page.
   This method takes into account the orientation of the
   page when determining the height.

  returns: the height of the page. - `double`"
  ([this]
    (-> this (.getHeight))))

(defn set-orientation
  "Sets the page orientation. orientation must be
   one of the constants: PORTRAIT, LANDSCAPE,
   or REVERSE_LANDSCAPE.

  orientation - the new orientation for the page - `int`

  throws: java.lang.IllegalArgumentException - if an unknown orientation was requested"
  ([this orientation]
    (-> this (.setOrientation orientation))))

(defn get-imageable-x
  "Returns the x coordinate of the upper left point of the
   imageable area of the Paper object
   associated with this PageFormat.
   This method takes into account the
   orientation of the page.

  returns: the x coordinate of the upper left point of the
   imageable area of the Paper object
   associated with this PageFormat. - `double`"
  ([this]
    (-> this (.getImageableX))))

(defn clone
  "Makes a copy of this PageFormat with the same
   contents as this PageFormat.

  returns: a copy of this PageFormat. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn get-imageable-y
  "Returns the y coordinate of the upper left point of the
   imageable area of the Paper object
   associated with this PageFormat.
   This method takes into account the
   orientation of the page.

  returns: the y coordinate of the upper left point of the
   imageable area of the Paper object
   associated with this PageFormat. - `double`"
  ([this]
    (-> this (.getImageableY))))

(defn get-matrix
  "Returns a transformation matrix that translates user
   space rendering to the requested orientation
   of the page.  The values are placed into the
   array as
   { m00, m10, m01, m11, m02, m12} in
   the form required by the AffineTransform
   constructor.

  returns: the matrix used to translate user space rendering
   to the orientation of the page. - `double[]`"
  ([this]
    (-> this (.getMatrix))))

