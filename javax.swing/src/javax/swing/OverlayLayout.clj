(ns javax.swing.OverlayLayout
  "A layout manager to arrange components over the top
  of each other.  The requested size of the container
  will be the largest requested size of the children,
  taking alignment needs into consideration.

  The alignment is based upon what is needed to properly
  fit the children in the allocation area.  The children
  will be placed such that their alignment points are all
  on top of each other.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing OverlayLayout]))

(defn ->overlay-layout
  "Constructor.

  Constructs a layout manager that performs overlay
   arrangement of the children.  The layout manager
   created is dedicated to the given container.

  target - the container to do layout against - `java.awt.Container`"
  ([target]
    (new OverlayLayout target)))

(defn invalidate-layout
  "Indicates a child has changed its layout related information,
   which causes any cached calculations to be flushed.

  target - the container - `java.awt.Container`"
  ([this target]
    (-> this (.invalidateLayout target))))

(defn get-layout-alignment-y
  "Returns the alignment along the y axis for the container.

  target - the container - `java.awt.Container`

  returns: the alignment >= 0.0f && <= 1.0f - `float`"
  ([this target]
    (-> this (.getLayoutAlignmentY target))))

(defn preferred-layout-size
  "Returns the preferred dimensions for this layout given the components
   in the specified target container.  Recomputes the layout if it
   has been invalidated.  Factors in the current inset setting returned
   by getInsets().

  target - the component which needs to be laid out - `java.awt.Container`

  returns: a Dimension object containing the preferred dimensions - `java.awt.Dimension`"
  ([this target]
    (-> this (.preferredLayoutSize target))))

(defn get-layout-alignment-x
  "Returns the alignment along the x axis for the container.

  target - the container - `java.awt.Container`

  returns: the alignment >= 0.0f && <= 1.0f - `float`"
  ([this target]
    (-> this (.getLayoutAlignmentX target))))

(defn minimum-layout-size
  "Returns the minimum dimensions needed to lay out the components
   contained in the specified target container.  Recomputes the layout
   if it has been invalidated, and factors in the current inset setting.

  target - the component which needs to be laid out - `java.awt.Container`

  returns: a Dimension object containing the minimum dimensions - `java.awt.Dimension`"
  ([this target]
    (-> this (.minimumLayoutSize target))))

(defn get-target
  "Returns the container that uses this layout manager.

  returns: the container that uses this layout manager - `java.awt.Container`"
  ([this]
    (-> this (.getTarget))))

(defn maximum-layout-size
  "Returns the maximum dimensions needed to lay out the components
   contained in the specified target container.  Recomputes the
   layout if it has been invalidated, and factors in the inset setting
   returned by getInset.

  target - the component that needs to be laid out - `java.awt.Container`

  returns: a Dimension object containing the maximum
           dimensions - `java.awt.Dimension`"
  ([this target]
    (-> this (.maximumLayoutSize target))))

(defn add-layout-component
  "Adds the specified component to the layout. Used by
   this class to know when to invalidate layout.

  name - the name of the component - `java.lang.String`
  comp - the the component to be added - `java.awt.Component`"
  ([this name comp]
    (-> this (.addLayoutComponent name comp))))

(defn remove-layout-component
  "Removes the specified component from the layout. Used by
   this class to know when to invalidate layout.

  comp - the component to remove - `java.awt.Component`"
  ([this comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Called by the AWT when the specified container needs to be laid out.

  target - the container to lay out - `java.awt.Container`

  throws: java.awt.AWTError - if the target isn't the container specified to the constructor"
  ([this target]
    (-> this (.layoutContainer target))))

