(ns jdk.awt.geom.Arc2D$Double
  "This class defines an arc specified in double precision."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.geom Arc2D$Double]))

(defn ->double
  "Constructor.

  Constructs a new arc, initialized to the specified location,
   size, angular extents, and closure type.

  x - The X coordinate of the upper-left corner of the arc's framing rectangle. - `double`
  y - The Y coordinate of the upper-left corner of the arc's framing rectangle. - `double`
  w - The overall width of the full ellipse of which this arc is a partial section. - `double`
  h - The overall height of the full ellipse of which this arc is a partial section. - `double`
  start - The starting angle of the arc in degrees. - `double`
  extent - The angular extent of the arc in degrees. - `double`
  type - The closure type for the arc: Arc2D.OPEN, Arc2D.CHORD, or Arc2D.PIE. - `int`"
  ([^Double x ^Double y ^Double w ^Double h ^Double start ^Double extent ^Integer type]
    (new Arc2D$Double x y w h start extent type))
  ([^java.awt.geom.Rectangle2D ellipse-bounds ^Double start ^Double extent ^Integer type]
    (new Arc2D$Double ellipse-bounds start extent type))
  ([^Integer type]
    (new Arc2D$Double type))
  ([]
    (new Arc2D$Double )))

(defn -x
  "Instance Field.

  The X coordinate of the upper-left corner of the framing
   rectangle of the arc.

  type: double"
  [this]
  (-> this .-x))

(defn -y
  "Instance Field.

  The Y coordinate of the upper-left corner of the framing
   rectangle of the arc.

  type: double"
  [this]
  (-> this .-y))

(defn -width
  "Instance Field.

  The overall width of the full ellipse of which this arc is
   a partial section (not considering the angular extents).

  type: double"
  [this]
  (-> this .-width))

(defn -height
  "Instance Field.

  The overall height of the full ellipse of which this arc is
   a partial section (not considering the angular extents).

  type: double"
  [this]
  (-> this .-height))

(defn -start
  "Instance Field.

  The starting angle of the arc in degrees.

  type: double"
  [this]
  (-> this .-start))

(defn -extent
  "Instance Field.

  The angular extent of the arc in degrees.

  type: double"
  [this]
  (-> this .-extent))

(defn get-angle-start
  "Returns the starting angle of the arc.

  returns: A double value that represents the starting angle
   of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.getAngleStart))))

(defn get-width
  "Returns the width of the framing rectangle in
   double precision.
   Note that the arc
   partially inscribes
   the framing rectangle of this RectangularShape.

  returns: the width of the framing rectangle. - `double`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.getWidth))))

(defn set-arc
  "Sets the location, size, angular extents, and closure type of
   this arc to the specified double values.

  x - The X coordinate of the upper-left corner of the arc. - `double`
  y - The Y coordinate of the upper-left corner of the arc. - `double`
  w - The overall width of the full ellipse of which this arc is a partial section. - `double`
  h - The overall height of the full ellipse of which this arc is a partial section. - `double`
  ang-st - The starting angle of the arc in degrees. - `double`
  ang-ext - The angular extent of the arc in degrees. - `double`
  closure - The closure type for the arc: Arc2D.OPEN, Arc2D.CHORD, or Arc2D.PIE. - `int`"
  ([^java.awt.geom.Arc2D$Double this ^Double x ^Double y ^Double w ^Double h ^Double ang-st ^Double ang-ext ^Integer closure]
    (-> this (.setArc x y w h ang-st ang-ext closure))))

(defn set-angle-extent
  "Sets the angular extent of this arc to the specified double
   value.

  ang-ext - The angular extent of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D$Double this ^Double ang-ext]
    (-> this (.setAngleExtent ang-ext))))

(defn set-angle-start
  "Sets the starting angle of this arc to the specified double
   value.

  ang-st - The starting angle of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D$Double this ^Double ang-st]
    (-> this (.setAngleStart ang-st))))

(defn get-y
  "Returns the Y coordinate of the upper-left corner of
   the framing rectangle in double precision.
   Note that the arc
   partially inscribes
   the framing rectangle of this RectangularShape.

  returns: the Y coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.getY))))

(defn get-x
  "Returns the X coordinate of the upper-left corner of
   the framing rectangle in double precision.
   Note that the arc
   partially inscribes
   the framing rectangle of this RectangularShape.

  returns: the X coordinate of the upper-left corner of
   the framing rectangle. - `double`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.getX))))

(defn get-height
  "Returns the height of the framing rectangle
   in double precision.
   Note that the arc
   partially inscribes
   the framing rectangle of this RectangularShape.

  returns: the height of the framing rectangle. - `double`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.getHeight))))

(defn empty?
  "Determines whether the RectangularShape is empty.
   When the RectangularShape is empty, it encloses no
   area.

  returns: true if the RectangularShape is empty;
            false otherwise. - `boolean`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.isEmpty))))

(defn get-angle-extent
  "Returns the angular extent of the arc.

  returns: A double value that represents the angular extent
   of the arc in degrees. - `double`"
  ([^java.awt.geom.Arc2D$Double this]
    (-> this (.getAngleExtent))))

