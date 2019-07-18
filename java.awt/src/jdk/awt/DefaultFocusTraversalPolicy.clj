(ns jdk.awt.DefaultFocusTraversalPolicy
  "A FocusTraversalPolicy that determines traversal order based on the order
  of child Components in a Container. From a particular focus cycle root, the
  policy makes a pre-order traversal of the Component hierarchy, and traverses
  a Container's children according to the ordering of the array returned by
  Container.getComponents(). Portions of the hierarchy that are
  not visible and displayable will not be searched.

  If client code has explicitly set the focusability of a Component by either
  overriding Component.isFocusTraversable() or
  Component.isFocusable(), or by calling
  Component.setFocusable(), then a DefaultFocusTraversalPolicy
  behaves exactly like a ContainerOrderFocusTraversalPolicy. If, however, the
  Component is relying on default focusability, then a
  DefaultFocusTraversalPolicy will reject all Components with non-focusable
  peers. This is the default FocusTraversalPolicy for all AWT Containers.

  The focusability of a peer is implementation-dependent. Sun recommends that
  all implementations for a particular native platform construct peers with
  the same focusability. The recommendations for Windows and Unix are that
  Canvases, Labels, Panels, Scrollbars, ScrollPanes, Windows, and lightweight
  Components have non-focusable peers, and all other Components have focusable
  peers. These recommendations are used in the Sun AWT implementations. Note
  that the focusability of a Component's peer is different from, and does not
  impact, the focusability of the Component itself.

  Please see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt DefaultFocusTraversalPolicy]))

(defn ->default-focus-traversal-policy
  "Constructor."
  (^DefaultFocusTraversalPolicy []
    (new DefaultFocusTraversalPolicy )))

