(ns javax.swing.text.html.ListView
  "A view implementation to display an html list"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html ListView]))

(defn ->list-view
  "Constructor.

  Creates a new view that represents a list element.

  elem - the element to create a view for - `javax.swing.text.Element`"
  ([elem]
    (new ListView elem)))

(defn get-alignment
  "Calculates the desired shape of the list.

  axis - may be either X_AXIS or Y_AXIS - `int`

  returns: the desired span - `float`"
  ([this axis]
    (-> this (.getAlignment axis))))

(defn paint
  "Renders using the given rendering surface and area on that
   surface.

  g - the rendering surface to use - `java.awt.Graphics`
  allocation - the allocated region to render into - `java.awt.Shape`"
  ([this g allocation]
    (-> this (.paint g allocation))))

