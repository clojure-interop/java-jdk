(ns jdk.awt.FocusTraversalPolicy
  "A FocusTraversalPolicy defines the order in which Components with a
  particular focus cycle root are traversed. Instances can apply the policy to
  arbitrary focus cycle roots, allowing themselves to be shared across
  Containers. They do not need to be reinitialized when the focus cycle roots
  of a Component hierarchy change.

  The core responsibility of a FocusTraversalPolicy is to provide algorithms
  determining the next and previous Components to focus when traversing
  forward or backward in a UI. Each FocusTraversalPolicy must also provide
  algorithms for determining the first, last, and default Components in a
  traversal cycle. First and last Components are used when normal forward and
  backward traversal, respectively, wraps. The default Component is the first
  to receive focus when traversing down into a new focus traversal cycle.
  A FocusTraversalPolicy can optionally provide an algorithm for determining
  a Window's initial Component. The initial Component is the first to receive
  focus when a Window is first made visible.

  FocusTraversalPolicy takes into account focus traversal
  policy providers.  When searching for first/last/next/previous Component,
  if a focus traversal policy provider is encountered, its focus traversal
  policy is used to perform the search operation.

  Please see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt FocusTraversalPolicy]))

(defn ->focus-traversal-policy
  "Constructor."
  ([]
    (new FocusTraversalPolicy )))

(defn get-component-after
  "Returns the Component that should receive the focus after aComponent.
   aContainer must be a focus cycle root of aComponent or a focus traversal
   policy provider.

  a-container - a focus cycle root of aComponent or focus traversal policy provider - `java.awt.Container`
  a-component - a (possibly indirect) child of aContainer, or aContainer itself - `java.awt.Component`

  returns: the Component that should receive the focus after aComponent, or
           null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is not a focus cycle root of aComponent or a focus traversal policy provider, or if either aContainer or aComponent is null"
  (^java.awt.Component [^java.awt.FocusTraversalPolicy this ^java.awt.Container a-container ^java.awt.Component a-component]
    (-> this (.getComponentAfter a-container a-component))))

(defn get-component-before
  "Returns the Component that should receive the focus before aComponent.
   aContainer must be a focus cycle root of aComponent or a focus traversal
   policy provider.

  a-container - a focus cycle root of aComponent or focus traversal policy provider - `java.awt.Container`
  a-component - a (possibly indirect) child of aContainer, or aContainer itself - `java.awt.Component`

  returns: the Component that should receive the focus before aComponent,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is not a focus cycle root of aComponent or a focus traversal policy provider, or if either aContainer or aComponent is null"
  (^java.awt.Component [^java.awt.FocusTraversalPolicy this ^java.awt.Container a-container ^java.awt.Component a-component]
    (-> this (.getComponentBefore a-container a-component))))

(defn get-first-component
  "Returns the first Component in the traversal cycle. This method is used
   to determine the next Component to focus when traversal wraps in the
   forward direction.

  a-container - the focus cycle root or focus traversal policy provider whose first Component is to be returned - `java.awt.Container`

  returns: the first Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^java.awt.FocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getFirstComponent a-container))))

(defn get-last-component
  "Returns the last Component in the traversal cycle. This method is used
   to determine the next Component to focus when traversal wraps in the
   reverse direction.

  a-container - the focus cycle root or focus traversal policy provider whose last Component is to be returned - `java.awt.Container`

  returns: the last Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^java.awt.FocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getLastComponent a-container))))

(defn get-default-component
  "Returns the default Component to focus. This Component will be the first
   to receive focus when traversing down into a new focus traversal cycle
   rooted at aContainer.

  a-container - the focus cycle root or focus traversal policy provider whose default Component is to be returned - `java.awt.Container`

  returns: the default Component in the traversal cycle of aContainer,
           or null if no suitable Component can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if aContainer is null"
  (^java.awt.Component [^java.awt.FocusTraversalPolicy this ^java.awt.Container a-container]
    (-> this (.getDefaultComponent a-container))))

(defn get-initial-component
  "Returns the Component that should receive the focus when a Window is
   made visible for the first time. Once the Window has been made visible
   by a call to show() or setVisible(true), the
   initial Component will not be used again. Instead, if the Window loses
   and subsequently regains focus, or is made invisible or undisplayable
   and subsequently made visible and displayable, the Window's most
   recently focused Component will become the focus owner. The default
   implementation of this method returns the default Component.

  window - the Window whose initial Component is to be returned - `java.awt.Window`

  returns: the Component that should receive the focus when window is made
           visible for the first time, or null if no suitable Component can
           be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if window is null"
  (^java.awt.Component [^java.awt.FocusTraversalPolicy this ^java.awt.Window window]
    (-> this (.getInitialComponent window))))

