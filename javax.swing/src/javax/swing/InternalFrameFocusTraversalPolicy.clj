(ns javax.swing.InternalFrameFocusTraversalPolicy
  "A FocusTraversalPolicy which can optionally provide an algorithm for
  determining a JInternalFrame's initial Component. The initial Component is
  the first to receive focus when the JInternalFrame is first selected. By
  default, this is the same as the JInternalFrame's default Component to
  focus."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing InternalFrameFocusTraversalPolicy]))

(defn ->internal-frame-focus-traversal-policy
  "Constructor."
  (^InternalFrameFocusTraversalPolicy []
    (new InternalFrameFocusTraversalPolicy )))

(defn get-initial-component
  "Returns the Component that should receive the focus when a
   JInternalFrame is selected for the first time. Once the JInternalFrame
   has been selected by a call to setSelected(true), the
   initial Component will not be used again. Instead, if the JInternalFrame
   loses and subsequently regains selection, or is made invisible or
   undisplayable and subsequently made visible and displayable, the
   JInternalFrame's most recently focused Component will become the focus
   owner. The default implementation of this method returns the
   JInternalFrame's default Component to focus.

  frame - the JInternalFrame whose initial Component is to be returned - `javax.swing.JInternalFrame`

  returns: the Component that should receive the focus when frame is
           selected for the first time, or null if no suitable Component
           can be found - `java.awt.Component`

  throws: java.lang.IllegalArgumentException - if window is null"
  (^java.awt.Component [^InternalFrameFocusTraversalPolicy this ^javax.swing.JInternalFrame frame]
    (-> this (.getInitialComponent frame))))

