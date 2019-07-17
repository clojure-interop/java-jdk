(ns jdk.awt.DefaultKeyboardFocusManager
  "The default KeyboardFocusManager for AWT applications. Focus traversal is
  done in response to a Component's focus traversal keys, and using a
  Container's FocusTraversalPolicy.

  Please see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt DefaultKeyboardFocusManager]))

(defn ->default-keyboard-focus-manager
  "Constructor."
  ([]
    (new DefaultKeyboardFocusManager )))

(defn dispatch-event
  "This method is called by the AWT event dispatcher requesting that the
   current KeyboardFocusManager dispatch the specified event on its behalf.
   DefaultKeyboardFocusManagers dispatch all FocusEvents, all WindowEvents
   related to focus, and all KeyEvents. These events are dispatched based
   on the KeyboardFocusManager's notion of the focus owner and the focused
   and active Windows, sometimes overriding the source of the specified
   AWTEvent. If this method returns false, then the AWT event
   dispatcher will attempt to dispatch the event itself.

  e - the AWTEvent to be dispatched - `java.awt.AWTEvent`

  returns: true if this method dispatched the event;
           false otherwise - `boolean`"
  ([this e]
    (-> this (.dispatchEvent e))))

(defn dispatch-key-event
  "Called by dispatchEvent if no other
   KeyEventDispatcher in the dispatcher chain dispatched the KeyEvent, or
   if no other KeyEventDispatchers are registered. If the event has not
   been consumed, its target is enabled, and the focus owner is not null,
   this method dispatches the event to its target. This method will also
   subsequently dispatch the event to all registered
   KeyEventPostProcessors. After all this operations are finished,
   the event is passed to peers for processing.

   In all cases, this method returns true, since
   DefaultKeyboardFocusManager is designed so that neither
   dispatchEvent, nor the AWT event dispatcher, should take
   further action on the event in any situation.

  e - the KeyEvent to be dispatched - `java.awt.event.KeyEvent`

  returns: true - `boolean`"
  ([this e]
    (-> this (.dispatchKeyEvent e))))

(defn post-process-key-event
  "This method will be called by dispatchKeyEvent. It will
   handle any unconsumed KeyEvents that map to an AWT
   MenuShortcut by consuming the event and activating the
   shortcut.

  e - the KeyEvent to post-process - `java.awt.event.KeyEvent`

  returns: true - `boolean`"
  ([this e]
    (-> this (.postProcessKeyEvent e))))

(defn process-key-event
  "This method initiates a focus traversal operation if and only if the
   KeyEvent represents a focus traversal key for the specified
   focusedComponent. It is expected that focusedComponent is the current
   focus owner, although this need not be the case. If it is not,
   focus traversal will nevertheless proceed as if focusedComponent
   were the focus owner.

  focused-component - the Component that is the basis for a focus traversal operation if the specified event represents a focus traversal key for the Component - `java.awt.Component`
  e - the event that may represent a focus traversal key - `java.awt.event.KeyEvent`"
  ([this focused-component e]
    (-> this (.processKeyEvent focused-component e))))

(defn focus-previous-component
  "Focuses the Component before aComponent, typically based on a
   FocusTraversalPolicy.

  a-component - the Component that is the basis for the focus traversal operation - `java.awt.Component`"
  ([this a-component]
    (-> this (.focusPreviousComponent a-component))))

(defn focus-next-component
  "Focuses the Component after aComponent, typically based on a
   FocusTraversalPolicy.

  a-component - the Component that is the basis for the focus traversal operation - `java.awt.Component`"
  ([this a-component]
    (-> this (.focusNextComponent a-component))))

(defn up-focus-cycle
  "Moves the focus up one focus traversal cycle. Typically, the focus owner
   is set to aComponent's focus cycle root, and the current focus cycle
   root is set to the new focus owner's focus cycle root. If, however,
   aComponent's focus cycle root is a Window, then the focus owner is set
   to the focus cycle root's default Component to focus, and the current
   focus cycle root is unchanged.

  a-component - the Component that is the basis for the focus traversal operation - `java.awt.Component`"
  ([this a-component]
    (-> this (.upFocusCycle a-component))))

(defn down-focus-cycle
  "Moves the focus down one focus traversal cycle. If aContainer is a focus
   cycle root, then the focus owner is set to aContainer's default
   Component to focus, and the current focus cycle root is set to
   aContainer. If aContainer is not a focus cycle root, then no focus
   traversal operation occurs.

  a-container - the Container that is the basis for the focus traversal operation - `java.awt.Container`"
  ([this a-container]
    (-> this (.downFocusCycle a-container))))

