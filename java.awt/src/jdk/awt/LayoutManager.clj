(ns jdk.awt.LayoutManager
  "Defines the interface for classes that know how to lay out
  Containers.

  Swing's painting architecture assumes the children of a
  JComponent do not overlap.  If a
  JComponent's LayoutManager allows
  children to overlap, the JComponent must override
  isOptimizedDrawingEnabled to return false."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt LayoutManager]))

(defn add-layout-component
  "If the layout manager uses a per-component string,
   adds the component comp to the layout,
   associating it
   with the string specified by name.

  name - the string to be associated with the component - `java.lang.String`
  comp - the component to be added - `java.awt.Component`"
  ([^java.awt.LayoutManager this ^java.lang.String name ^java.awt.Component comp]
    (-> this (.addLayoutComponent name comp))))

(defn remove-layout-component
  "Removes the specified component from the layout.

  comp - the component to be removed - `java.awt.Component`"
  ([^java.awt.LayoutManager this ^java.awt.Component comp]
    (-> this (.removeLayoutComponent comp))))

(defn preferred-layout-size
  "Calculates the preferred size dimensions for the specified
   container, given the components it contains.

  parent - the container to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  ([^java.awt.LayoutManager this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn minimum-layout-size
  "Calculates the minimum size dimensions for the specified
   container, given the components it contains.

  parent - the component to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  ([^java.awt.LayoutManager this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn layout-container
  "Lays out the specified container.

  parent - the container to be laid out - `java.awt.Container`"
  ([^java.awt.LayoutManager this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

