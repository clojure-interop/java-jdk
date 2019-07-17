(ns javax.swing.DefaultDesktopManager
  "This is an implementation of the DesktopManager.
  It currently implements the basic behaviors for managing
  JInternalFrames in an arbitrary parent.
  JInternalFrames that are not children of a
  JDesktop will use this component
  to handle their desktop-like actions.
  This class provides a policy for the various JInternalFrame methods,
  it is not meant to be called directly rather the various JInternalFrame
  methods will call into the DesktopManager."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DefaultDesktopManager]))

(defn ->default-desktop-manager
  "Constructor."
  ([]
    (new DefaultDesktopManager )))

(defn drag-frame
  "Moves the visible location of the frame being dragged
   to the location specified.  The means by which this occurs can vary depending
   on the dragging algorithm being used.  The actual logical location of the frame
   might not change until endDraggingFrame is called.

  f - `javax.swing.JComponent`
  new-x - `int`
  new-y - `int`"
  ([this f new-x new-y]
    (-> this (.dragFrame f new-x new-y))))

(defn begin-dragging-frame
  "Description copied from interface: DesktopManager

  f - `javax.swing.JComponent`"
  ([this f]
    (-> this (.beginDraggingFrame f))))

(defn resize-frame
  "Calls setBoundsForFrame with the new values.

  f - the component to be resized - `javax.swing.JComponent`
  new-x - the new x-coordinate - `int`
  new-y - the new y-coordinate - `int`
  new-width - the new width - `int`
  new-height - the new height - `int`"
  ([this f new-x new-y new-width new-height]
    (-> this (.resizeFrame f new-x new-y new-width new-height))))

(defn activate-frame
  "This will activate f moving it to the front. It will
   set the current active frame's (if any)
   IS_SELECTED_PROPERTY to false.
   There can be only one active frame across all Layers.

  f - the JInternalFrame to be activated - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.activateFrame f))))

(defn minimize-frame
  "Restores the frame back to its size and position prior
   to a maximizeFrame call.

  f - the JInternalFrame to be restored - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.minimizeFrame f))))

(defn maximize-frame
  "Resizes the frame to fill its parents bounds.

  f - the frame to be resized - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.maximizeFrame f))))

(defn close-frame
  "Removes the frame, and, if necessary, the
   desktopIcon, from its parent.

  f - the JInternalFrame to be removed - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.closeFrame f))))

(defn end-resizing-frame
  "Description copied from interface: DesktopManager

  f - `javax.swing.JComponent`"
  ([this f]
    (-> this (.endResizingFrame f))))

(defn open-frame
  "Normally this method will not be called. If it is, it
   try to determine the appropriate parent from the desktopIcon of the frame.
   Will remove the desktopIcon from its parent if it successfully adds the frame.

  f - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.openFrame f))))

(defn set-bounds-for-frame
  "This moves the JComponent and repaints the damaged areas.

  f - `javax.swing.JComponent`
  new-x - `int`
  new-y - `int`
  new-width - `int`
  new-height - `int`"
  ([this f new-x new-y new-width new-height]
    (-> this (.setBoundsForFrame f new-x new-y new-width new-height))))

(defn deiconify-frame
  "Removes the desktopIcon from its parent and adds its frame
   to the parent.

  f - the JInternalFrame to be de-iconified - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.deiconifyFrame f))))

(defn deactivate-frame
  "Description copied from interface: DesktopManager

  f - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.deactivateFrame f))))

(defn end-dragging-frame
  "Description copied from interface: DesktopManager

  f - `javax.swing.JComponent`"
  ([this f]
    (-> this (.endDraggingFrame f))))

(defn begin-resizing-frame
  "Description copied from interface: DesktopManager

  f - `javax.swing.JComponent`
  direction - `int`"
  ([this f direction]
    (-> this (.beginResizingFrame f direction))))

(defn iconify-frame
  "Removes the frame from its parent and adds its
   desktopIcon to the parent.

  f - the JInternalFrame to be iconified - `javax.swing.JInternalFrame`"
  ([this f]
    (-> this (.iconifyFrame f))))

