(ns javax.swing.SortingFocusTraversalPolicy
  "A FocusTraversalPolicy that determines traversal order by sorting the
  Components of a focus traversal cycle based on a given Comparator. Portions
  of the Component hierarchy that are not visible and displayable will not be
  included.

  By default, SortingFocusTraversalPolicy implicitly transfers focus down-
  cycle. That is, during normal focus traversal, the Component
  traversed after a focus cycle root will be the focus-cycle-root's default
  Component to focus. This behavior can be disabled using the
  setImplicitDownCycleTraversal method.

  By default, methods of this class with return a Component only if it is
  visible, displayable, enabled, and focusable. Subclasses can modify this
  behavior by overriding the accept method.

  This policy takes into account focus traversal
  policy providers.  When searching for first/last/next/previous Component,
  if a focus traversal policy provider is encountered, its focus traversal
  policy is used to perform the search operation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing SortingFocusTraversalPolicy]))

(defn ->sorting-focus-traversal-policy
  "Constructor.

  Constructs a SortingFocusTraversalPolicy with the specified Comparator.

  comparator - `java.awt.Component>`"
  ([^java.awt.Component> comparator]
    (new SortingFocusTraversalPolicy comparator)))

(defn get-component-after
  "Returns the Component that should receive the focus after aComponent.
   aContainer must be a focus cycle root of aComponent or a focus traversal policy provider.

   By default, SortingFocusTraversalPolicy implicitly transfers focus down-
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
  (^java.awt.Component [^javax.swing.SortingFocusTraversalPolicy this ^java.awt.Container a-container ^java.awt.Component a-component]
    (-> this (.getComponentAfter a-container a-component))))

(defn get-component-before
  "Returns the Component that should receive the focus before aComponent.
   aContainer must be a focus cycle root of aComponent or a focus traversal policy provider.

   By default, SortingFocusTraversalPolicy implicitly transfers focus down-
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
  (^java.awt.Component [^javax.swing.SortingFocusTraversalPolicy this ^java.awt.Container a-container ^java.awt.Component a-component]
    (-> this (.getComponentBefore a-container a-component))))

(defn get-first-component
  "Returns the first Component in the traversal cycle. This method is used
   to determine the next Component to focus when traversal wraps in the
   forward direction.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider whose first Component is to be returned - `java.awt.Container`

  returns: the first Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^javax.swing.SortingFocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getFirstComponent a-container))))

(defn get-last-component
  "Returns the last Component in the traversal cycle. This method is used
   to determine the next Component to focus when traversal wraps in the
   reverse direction.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider whose last Component is to be returned - `java.awt.Container`

  returns: the last Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^javax.swing.SortingFocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getLastComponent a-container))))

(defn get-default-component
  "Returns the default Component to focus. This Component will be the first
   to receive focus when traversing down into a new focus traversal cycle
   rooted at aContainer. The default implementation of this method
   returns the same Component as getFirstComponent.

  a-container - a focus cycle root of aComponent or a focus traversal policy provider whose default Component is to be returned - `java.awt.Container`

  returns: the default Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^javax.swing.SortingFocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getDefaultComponent a-container))))

(defn set-implicit-down-cycle-traversal
  "Sets whether this SortingFocusTraversalPolicy transfers focus down-cycle
   implicitly. If true, during normal focus traversal,
   the Component traversed after a focus cycle root will be the focus-
   cycle-root's default Component to focus. If false, the
   next Component in the focus traversal cycle rooted at the specified
   focus cycle root will be traversed instead. The default value for this
   property is true.

  implicit-down-cycle-traversal - whether this SortingFocusTraversalPolicy transfers focus down-cycle implicitly - `boolean`"
  ([^javax.swing.SortingFocusTraversalPolicy this ^Boolean implicit-down-cycle-traversal]
    (-> this (.setImplicitDownCycleTraversal implicit-down-cycle-traversal))))

(defn get-implicit-down-cycle-traversal?
  "Returns whether this SortingFocusTraversalPolicy transfers focus down-
   cycle implicitly. If true, during normal focus
   traversal, the Component traversed after a focus cycle root will be the
   focus-cycle-root's default Component to focus. If false,
   the next Component in the focus traversal cycle rooted at the specified
   focus cycle root will be traversed instead.

  returns: whether this SortingFocusTraversalPolicy transfers focus down-
           cycle implicitly - `boolean`"
  (^Boolean [^javax.swing.SortingFocusTraversalPolicy this]
    (-> this (.getImplicitDownCycleTraversal))))

