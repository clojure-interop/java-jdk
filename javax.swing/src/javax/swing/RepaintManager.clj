(ns javax.swing.RepaintManager
  "This class manages repaint requests, allowing the number
  of repaints to be minimized, for example by collapsing multiple
  requests into a single repaint for members of a component tree.

  As of 1.6 RepaintManager handles repaint requests
  for Swing's top level components (JApplet,
  JWindow, JFrame and JDialog).
  Any calls to repaint on one of these will call into the
  appropriate addDirtyRegion method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing RepaintManager]))

(defn ->repaint-manager
  "Constructor.

  Create a new RepaintManager instance. You rarely call this constructor.
   directly. To get the default RepaintManager, use
   RepaintManager.currentManager(JComponent) (normally `this`)."
  ([]
    (new RepaintManager )))

(defn *current-manager
  "Return the RepaintManager for the calling thread given a Component.

  c - a Component -- unused in the default implementation, but could be used by an overridden version to return a different RepaintManager depending on the Component - `java.awt.Component`

  returns: the RepaintManager object - `javax.swing.RepaintManager`"
  ([^java.awt.Component c]
    (RepaintManager/currentManager c)))

(defn *set-current-manager
  "Set the RepaintManager that should be used for the calling
   thread. aRepaintManager will become the current RepaintManager
   for the calling thread's thread group.

  a-repaint-manager - the RepaintManager object to use - `javax.swing.RepaintManager`"
  ([^javax.swing.RepaintManager a-repaint-manager]
    (RepaintManager/setCurrentManager a-repaint-manager)))

(defn mark-completely-clean
  "Mark a component completely clean. aComponent will not
   get painted during the next paintDirtyRegions() call.

  a-component - `javax.swing.JComponent`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent a-component]
    (-> this (.markCompletelyClean a-component))))

(defn set-double-buffer-maximum-size
  "Set the maximum double buffer size.

  d - `java.awt.Dimension`"
  ([^javax.swing.RepaintManager this ^java.awt.Dimension d]
    (-> this (.setDoubleBufferMaximumSize d))))

(defn validate-invalid-components
  "Validate all of the components that have been marked invalid."
  ([^javax.swing.RepaintManager this]
    (-> this (.validateInvalidComponents))))

(defn get-dirty-region
  "Return the current dirty region for a component.
    Return an empty rectangle if the component is not
    dirty.

  a-component - `javax.swing.JComponent`

  returns: `java.awt.Rectangle`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent a-component]
    (-> this (.getDirtyRegion a-component))))

(defn get-double-buffer-maximum-size
  "Returns the maximum double buffer size.

  returns: a Dimension object representing the maximum size - `java.awt.Dimension`"
  ([^javax.swing.RepaintManager this]
    (-> this (.getDoubleBufferMaximumSize))))

(defn to-string
  "Returns a string that displays and identifies this
   object's properties.

  returns: a String representation of this object - `java.lang.String`"
  ([^javax.swing.RepaintManager this]
    (-> this (.toString))))

(defn completely-dirty?
  "Convenience method that returns true if aComponent will be completely
   painted during the next paintDirtyRegions(). If computing dirty regions is
   expensive for your component, use this method and avoid computing dirty region
   if it return true.

  a-component - `javax.swing.JComponent`

  returns: `boolean`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent a-component]
    (-> this (.isCompletelyDirty a-component))))

(defn mark-completely-dirty
  "Mark a component completely dirty. aComponent will be
   completely painted during the next paintDirtyRegions() call.

  a-component - `javax.swing.JComponent`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent a-component]
    (-> this (.markCompletelyDirty a-component))))

(defn get-offscreen-buffer
  "Return the offscreen buffer that should be used as a double buffer with
   the component c.
   By default there is a double buffer per RepaintManager.
   The buffer might be smaller than (proposedWidth,proposedHeight)
   This happens when the maximum double buffer size as been set for the receiving
   repaint manager.

  c - `java.awt.Component`
  proposed-width - `int`
  proposed-height - `int`

  returns: `java.awt.Image`"
  ([^javax.swing.RepaintManager this ^java.awt.Component c ^Integer proposed-width ^Integer proposed-height]
    (-> this (.getOffscreenBuffer c proposed-width proposed-height))))

(defn remove-invalid-component
  "Remove a component from the list of invalid components.

  component - `javax.swing.JComponent`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent component]
    (-> this (.removeInvalidComponent component))))

(defn get-volatile-offscreen-buffer
  "Return a volatile offscreen buffer that should be used as a
   double buffer with the specified component c.
   The image returned will be an instance of VolatileImage, or null
   if a VolatileImage object could not be instantiated.
   This buffer might be smaller than (proposedWidth,proposedHeight).
   This happens when the maximum double buffer size has been set for this
   repaint manager.

  c - `java.awt.Component`
  proposed-width - `int`
  proposed-height - `int`

  returns: `java.awt.Image`"
  ([^javax.swing.RepaintManager this ^java.awt.Component c ^Integer proposed-width ^Integer proposed-height]
    (-> this (.getVolatileOffscreenBuffer c proposed-width proposed-height))))

(defn paint-dirty-regions
  "Paint all of the components that have been marked dirty."
  ([^javax.swing.RepaintManager this]
    (-> this (.paintDirtyRegions))))

(defn add-dirty-region
  "Add a component in the list of components that should be refreshed.
   If c already has a dirty region, the rectangle (x,y,w,h)
   will be unioned with the region that should be redrawn.

  c - Component to repaint, null results in nothing happening. - `javax.swing.JComponent`
  x - X coordinate of the region to repaint - `int`
  y - Y coordinate of the region to repaint - `int`
  w - Width of the region to repaint - `int`
  h - Height of the region to repaint - `int`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent c ^Integer x ^Integer y ^Integer w ^Integer h]
    (-> this (.addDirtyRegion c x y w h))))

(defn add-invalid-component
  "Mark the component as in need of layout and queue a runnable
   for the event dispatching thread that will validate the components
   first isValidateRoot() ancestor.

  invalid-component - `javax.swing.JComponent`"
  ([^javax.swing.RepaintManager this ^javax.swing.JComponent invalid-component]
    (-> this (.addInvalidComponent invalid-component))))

(defn set-double-buffering-enabled
  "Enables or disables double buffering in this RepaintManager.
   CAUTION: The default value for this property is set for optimal
   paint performance on the given platform and it is not recommended
   that programs modify this property directly.

  a-flag - true to activate double buffering - `boolean`"
  ([^javax.swing.RepaintManager this ^Boolean a-flag]
    (-> this (.setDoubleBufferingEnabled a-flag))))

(defn double-buffering-enabled?
  "Returns true if this RepaintManager is double buffered.
   The default value for this property may vary from platform
   to platform.  On platforms where native double buffering
   is supported in the AWT, the default value will be false
   to avoid unnecessary buffering in Swing.
   On platforms where native double buffering is not supported,
   the default value will be true.

  returns: true if this object is double buffered - `boolean`"
  ([^javax.swing.RepaintManager this]
    (-> this (.isDoubleBufferingEnabled))))

