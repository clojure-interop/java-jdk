(ns javax.swing.DesktopManager
  "DesktopManager objects are owned by a JDesktopPane object. They are responsible
  for implementing L&F specific behaviors for the JDesktopPane. JInternalFrame
  implementations should delegate specific behaviors to the DesktopManager. For
  instance, if a JInternalFrame was asked to iconify, it should try:


     getDesktopPane().getDesktopManager().iconifyFrame(frame);
  This delegation allows each L&F to provide custom behaviors for desktop-specific
  actions. (For example, how and where the internal frame's icon would appear.)
  This class provides a policy for the various JInternalFrame methods, it is not
  meant to be called directly rather the various JInternalFrame methods will call
  into the DesktopManager."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing DesktopManager]))

(defn drag-frame
  "The user has moved the frame. Calls to this method will be preceded by calls
   to beginDraggingFrame().
    Normally f will be a JInternalFrame.

  f - `javax.swing.JComponent`
  new-x - `int`
  new-y - `int`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f ^Integer new-x ^Integer new-y]
    (-> this (.dragFrame f new-x new-y))))

(defn begin-dragging-frame
  "This method is normally called when the user has indicated that
   they will begin dragging a component around. This method should be called
   prior to any dragFrame() calls to allow the DesktopManager to prepare any
   necessary state. Normally f will be a JInternalFrame.

  f - `javax.swing.JComponent`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f]
    (-> this (.beginDraggingFrame f))))

(defn resize-frame
  "The user has resized the component. Calls to this method will be preceded by calls
   to beginResizingFrame().
    Normally f will be a JInternalFrame.

  f - `javax.swing.JComponent`
  new-x - `int`
  new-y - `int`
  new-width - `int`
  new-height - `int`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f ^Integer new-x ^Integer new-y ^Integer new-width ^Integer new-height]
    (-> this (.resizeFrame f new-x new-y new-width new-height))))

(defn activate-frame
  "Generally, indicate that this frame has focus. This is usually called after
   the JInternalFrame's IS_SELECTED_PROPERTY has been set to true.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.activateFrame f))))

(defn minimize-frame
  "Generally, this indicates that the frame should be restored to it's
   size and position prior to a maximizeFrame() call.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.minimizeFrame f))))

(defn maximize-frame
  "Generally, the frame should be resized to match it's parents bounds.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.maximizeFrame f))))

(defn close-frame
  "Generally, this call should remove the frame from it's parent.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.closeFrame f))))

(defn end-resizing-frame
  "This method signals the end of the resize session. Any state maintained by
   the DesktopManager can be removed here.  Normally f will be a JInternalFrame.

  f - `javax.swing.JComponent`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f]
    (-> this (.endResizingFrame f))))

(defn open-frame
  "If possible, display this frame in an appropriate location.
   Normally, this is not called, as the creator of the JInternalFrame
   will add the frame to the appropriate parent.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.openFrame f))))

(defn set-bounds-for-frame
  "This is a primitive reshape method.

  f - `javax.swing.JComponent`
  new-x - `int`
  new-y - `int`
  new-width - `int`
  new-height - `int`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f ^Integer new-x ^Integer new-y ^Integer new-width ^Integer new-height]
    (-> this (.setBoundsForFrame f new-x new-y new-width new-height))))

(defn deiconify-frame
  "Generally, remove any iconic representation that is present and restore the
   frame to it's original size and location.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.deiconifyFrame f))))

(defn deactivate-frame
  "Generally, indicate that this frame has lost focus. This is usually called
   after the JInternalFrame's IS_SELECTED_PROPERTY has been set to false.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.deactivateFrame f))))

(defn end-dragging-frame
  "This method signals the end of the dragging session. Any state maintained by
   the DesktopManager can be removed here.  Normally f will be a JInternalFrame.

  f - `javax.swing.JComponent`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f]
    (-> this (.endDraggingFrame f))))

(defn begin-resizing-frame
  "This methods is normally called when the user has indicated that
   they will begin resizing the frame. This method should be called
   prior to any resizeFrame() calls to allow the DesktopManager to prepare any
   necessary state.  Normally f will be a JInternalFrame.

  f - `javax.swing.JComponent`
  direction - `int`"
  ([^javax.swing.DesktopManager this ^javax.swing.JComponent f ^Integer direction]
    (-> this (.beginResizingFrame f direction))))

(defn iconify-frame
  "Generally, remove this frame from it's parent and add an iconic representation.

  f - `javax.swing.JInternalFrame`"
  ([^javax.swing.DesktopManager this ^javax.swing.JInternalFrame f]
    (-> this (.iconifyFrame f))))

