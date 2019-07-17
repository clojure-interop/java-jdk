(ns javax.swing.LayoutFocusTraversalPolicy
  "A SortingFocusTraversalPolicy which sorts Components based on their size,
  position, and orientation. Based on their size and position, Components are
  roughly categorized into rows and columns. For a Container with horizontal
  orientation, columns run left-to-right or right-to-left, and rows run top-
  to-bottom. For a Container with vertical orientation, columns run top-to-
  bottom and rows run left-to-right or right-to-left. See
  ComponentOrientation for more information. All columns in a
  row are fully traversed before proceeding to the next row."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing LayoutFocusTraversalPolicy]))

(defn ->layout-focus-traversal-policy
  "Constructor.

  Constructs a LayoutFocusTraversalPolicy."
  ([]
    (new LayoutFocusTraversalPolicy )))

(defn get-component-after
  "Returns the Component that should receive the focus after aComponent.
   aContainer must be a focus cycle root of aComponent.

   By default, LayoutFocusTraversalPolicy implicitly transfers focus down-
   cycle. That is, during normal focus traversal, the Component
   traversed after a focus cycle root will be the focus-cycle-root's
   default Component to focus. This behavior can be disabled using the
   setImplicitDownCycleTraversal method.

   If aContainer is focus
   traversal policy provider, the focus is always transferred down-cycle.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider - `java.awt.Container`
  a-component - a (possibly indirect) child of aContainer, or aContainer itself - `java.awt.Component`

  returns: the Component that should receive the focus after aComponent, or
           null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is not a focus cycle root of aComponent or a focus traversal policy provider, or if either aContainer or aComponent is null"
  (^java.awt.Component [^javax.swing.LayoutFocusTraversalPolicy this ^java.awt.Container a-container ^java.awt.Component a-component]
    (-> this (.getComponentAfter a-container a-component))))

(defn get-component-before
  "Returns the Component that should receive the focus before aComponent.
   aContainer must be a focus cycle root of aComponent.

   By default, LayoutFocusTraversalPolicy implicitly transfers focus down-
   cycle. That is, during normal focus traversal, the Component
   traversed after a focus cycle root will be the focus-cycle-root's
   default Component to focus. This behavior can be disabled using the
   setImplicitDownCycleTraversal method.

   If aContainer is focus
   traversal policy provider, the focus is always transferred down-cycle.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider - `java.awt.Container`
  a-component - a (possibly indirect) child of aContainer, or aContainer itself - `java.awt.Component`

  returns: the Component that should receive the focus before aComponent,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is not a focus cycle root of aComponent or a focus traversal policy provider, or if either aContainer or aComponent is null"
  (^java.awt.Component [^javax.swing.LayoutFocusTraversalPolicy this ^java.awt.Container a-container ^java.awt.Component a-component]
    (-> this (.getComponentBefore a-container a-component))))

(defn get-first-component
  "Returns the first Component in the traversal cycle. This method is used
   to determine the next Component to focus when traversal wraps in the
   forward direction.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider whose first Component is to be returned - `java.awt.Container`

  returns: the first Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^javax.swing.LayoutFocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getFirstComponent a-container))))

(defn get-last-component
  "Returns the last Component in the traversal cycle. This method is used
   to determine the next Component to focus when traversal wraps in the
   reverse direction.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider whose last Component is to be returned - `java.awt.Container`

  returns: the last Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^javax.swing.LayoutFocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getLastComponent a-container))))

