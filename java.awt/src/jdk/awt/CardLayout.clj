(ns jdk.awt.CardLayout
  "A CardLayout object is a layout manager for a
  container. It treats each component in the container as a card.
  Only one card is visible at a time, and the container acts as
  a stack of cards. The first component added to a
  CardLayout object is the visible component when the
  container is first displayed.

  The ordering of cards is determined by the container's own internal
  ordering of its component objects. CardLayout
  defines a set of methods that allow an application to flip
  through these cards sequentially, or to show a specified card.
  The addLayoutComponent(java.awt.Component, java.lang.Object)
  method can be used to associate a string identifier with a given card
  for fast random access."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt CardLayout]))

(defn ->card-layout
  "Constructor.

  Creates a new card layout with the specified horizontal and
   vertical gaps. The horizontal gaps are placed at the left and
   right edges. The vertical gaps are placed at the top and bottom
   edges.

  hgap - the horizontal gap. - `int`
  vgap - the vertical gap. - `int`"
  ([^Integer hgap ^Integer vgap]
    (new CardLayout hgap vgap))
  ([]
    (new CardLayout )))

(defn get-vgap
  "Gets the vertical gap between components.

  returns: the vertical gap between components. - `int`"
  ([^java.awt.CardLayout this]
    (-> this (.getVgap))))

(defn invalidate-layout
  "Invalidates the layout, indicating that if the layout manager
   has cached information it should be discarded.

  target - `java.awt.Container`"
  ([^java.awt.CardLayout this ^java.awt.Container target]
    (-> this (.invalidateLayout target))))

(defn next
  "Flips to the next card of the specified container. If the
   currently visible card is the last one, this method flips to the
   first card in the layout.

  parent - the parent container in which to do the layout - `java.awt.Container`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.next parent))))

(defn get-layout-alignment-y
  "Returns the alignment along the y axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - `java.awt.Container`

  returns: `float`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.getLayoutAlignmentY parent))))

(defn set-hgap
  "Sets the horizontal gap between components.

  hgap - the horizontal gap between components. - `int`"
  ([^java.awt.CardLayout this ^Integer hgap]
    (-> this (.setHgap hgap))))

(defn set-vgap
  "Sets the vertical gap between components.

  vgap - the vertical gap between components. - `int`"
  ([^java.awt.CardLayout this ^Integer vgap]
    (-> this (.setVgap vgap))))

(defn preferred-layout-size
  "Determines the preferred size of the container argument using
   this card layout.

  parent - the parent container in which to do the layout - `java.awt.Container`

  returns: the preferred dimensions to lay out the subcomponents
                  of the specified container - `java.awt.Dimension`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.preferredLayoutSize parent))))

(defn to-string
  "Returns a string representation of the state of this card layout.

  returns: a string representation of this card layout. - `java.lang.String`"
  ([^java.awt.CardLayout this]
    (-> this (.toString))))

(defn get-hgap
  "Gets the horizontal gap between components.

  returns: the horizontal gap between components. - `int`"
  ([^java.awt.CardLayout this]
    (-> this (.getHgap))))

(defn show
  "Flips to the component that was added to this layout with the
   specified name, using addLayoutComponent.
   If no such component exists, then nothing happens.

  parent - the parent container in which to do the layout - `java.awt.Container`
  name - the component name - `java.lang.String`"
  ([^java.awt.CardLayout this ^java.awt.Container parent ^java.lang.String name]
    (-> this (.show parent name))))

(defn get-layout-alignment-x
  "Returns the alignment along the x axis.  This specifies how
   the component would like to be aligned relative to other
   components.  The value should be a number between 0 and 1
   where 0 represents alignment along the origin, 1 is aligned
   the furthest away from the origin, 0.5 is centered, etc.

  parent - `java.awt.Container`

  returns: `float`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.getLayoutAlignmentX parent))))

(defn previous
  "Flips to the previous card of the specified container. If the
   currently visible card is the first one, this method flips to the
   last card in the layout.

  parent - the parent container in which to do the layout - `java.awt.Container`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.previous parent))))

(defn minimum-layout-size
  "Calculates the minimum size for the specified panel.

  parent - the parent container in which to do the layout - `java.awt.Container`

  returns: the minimum dimensions required to lay out the
                  subcomponents of the specified container - `java.awt.Dimension`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.minimumLayoutSize parent))))

(defn last
  "Flips to the last card of the container.

  parent - the parent container in which to do the layout - `java.awt.Container`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.last parent))))

(defn maximum-layout-size
  "Returns the maximum dimensions for this layout given the components
   in the specified target container.

  target - the component which needs to be laid out - `java.awt.Container`

  returns: `java.awt.Dimension`"
  ([^java.awt.CardLayout this ^java.awt.Container target]
    (-> this (.maximumLayoutSize target))))

(defn add-layout-component
  "Adds the specified component to this card layout's internal
   table of names. The object specified by constraints
   must be a string. The card layout stores this string as a key-value
   pair that can be used for random access to a particular card.
   By calling the show method, an application can
   display the component with the specified name.

  comp - the component to be added. - `java.awt.Component`
  constraints - a tag that identifies a particular card in the layout. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the constraint is not a string."
  ([^java.awt.CardLayout this ^java.awt.Component comp ^java.lang.Object constraints]
    (-> this (.addLayoutComponent comp constraints))))

(defn remove-layout-component
  "Removes the specified component from the layout.
   If the card was visible on top, the next card underneath it is shown.

  comp - the component to be removed. - `java.awt.Component`"
  ([^java.awt.CardLayout this ^java.awt.Component comp]
    (-> this (.removeLayoutComponent comp))))

(defn layout-container
  "Lays out the specified container using this card layout.

   Each component in the parent container is reshaped
   to be the size of the container, minus space for surrounding
   insets, horizontal gaps, and vertical gaps.

  parent - the parent container in which to do the layout - `java.awt.Container`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.layoutContainer parent))))

(defn first
  "Flips to the first card of the container.

  parent - the parent container in which to do the layout - `java.awt.Container`"
  ([^java.awt.CardLayout this ^java.awt.Container parent]
    (-> this (.first parent))))

