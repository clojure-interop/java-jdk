(ns jdk.awt.LayoutManager2
  "Defines an interface for classes that know how to layout Containers
  based on a layout constraints object.

  This interface extends the LayoutManager interface to deal with layouts
  explicitly in terms of constraint objects that specify how and where
  components should be added to the layout.

  This minimal extension to LayoutManager is intended for tool
  providers who wish to the creation of constraint-based layouts.
  It does not yet provide full, general support for custom
  constraint-based layout managers."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt LayoutManager2]))

(defn add-layout-component
  "Adds the specified component to the layout, using the specified
   constraint object.

  comp - the component to be added - `java.awt.Component`
  constraints - where/how the component is added to the layout. - `java.lang.Object`"
  ([^. this ^java.awt.Component comp ^java.lang.Object constraints]
    (-> this (.addLayoutComponent comp constraints))))

(defn maximum-layout-size
  "Calculates the maximum size dimensions for the specified container,
   given the components it contains.

  target - `java.awt.Container`

  returns: `java.awt.Dimension`"
  ([^. this ^java.awt.Container target]
    (-> this (.maximumLayoutSize target))))

(defn get-layout-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  target - `java.awt.Container`

  returns: `float`"
  ([^. this ^java.awt.Container target]
    (-> this (.getLayoutAlignmentX target))))

(defn get-layout-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  target - `java.awt.Container`

  returns: `float`"
  ([^. this ^java.awt.Container target]
    (-> this (.getLayoutAlignmentY target))))

(defn invalidate-layout
  "Invalidates the layout, indicating that if the layout manager
   has cached information it should be discarded.

  target - `java.awt.Container`"
  ([^. this ^java.awt.Container target]
    (-> this (.invalidateLayout target))))

