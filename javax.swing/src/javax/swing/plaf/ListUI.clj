(ns javax.swing.plaf.ListUI
  "The JList pluggable look and feel delegate."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf ListUI]))

(defn ->list-ui
  "Constructor."
  (^ListUI []
    (new ListUI )))

(defn location-to-index
  "Returns the cell index in the specified JList closest to the
   given location in the list's coordinate system. To determine if the
   cell actually contains the specified location, compare the point against
   the cell's bounds, as provided by getCellBounds.
   This method returns -1 if the list's model is empty.

  list - the list - `javax.swing.JList`
  location - the coordinates of the point - `java.awt.Point`

  returns: the cell index closest to the given location, or -1 - `int`

  throws: java.lang.NullPointerException - if location is null"
  (^Integer [^ListUI this ^javax.swing.JList list ^java.awt.Point location]
    (-> this (.locationToIndex list location))))

(defn index-to-location
  "Returns the origin in the given JList, of the specified item,
   in the list's coordinate system.
   Returns null if the index isn't valid.

  list - the list - `javax.swing.JList`
  index - the cell index - `int`

  returns: the origin of the cell, or null - `java.awt.Point`"
  (^java.awt.Point [^ListUI this ^javax.swing.JList list ^Integer index]
    (-> this (.indexToLocation list index))))

(defn get-cell-bounds
  "Returns the bounding rectangle, in the given list's coordinate system,
   for the range of cells specified by the two indices.
   The indices can be supplied in any order.

   If the smaller index is outside the list's range of cells, this method
   returns null. If the smaller index is valid, but the larger
   index is outside the list's range, the bounds of just the first index
   is returned. Otherwise, the bounds of the valid range is returned.

  list - the list - `javax.swing.JList`
  index-1 - the first index in the range - `int`
  index-2 - the second index in the range - `int`

  returns: the bounding rectangle for the range of cells, or null - `java.awt.Rectangle`"
  (^java.awt.Rectangle [^ListUI this ^javax.swing.JList list ^Integer index-1 ^Integer index-2]
    (-> this (.getCellBounds list index-1 index-2))))

