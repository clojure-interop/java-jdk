(ns jdk.awt.Canvas
  "A Canvas component represents a blank rectangular
  area of the screen onto which the application can draw or from
  which the application can trap input events from the user.

  An application must subclass the Canvas class in
  order to get useful functionality such as creating a custom
  component. The paint method must be overridden
  in order to perform custom graphics on the canvas."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Canvas]))

(defn ->canvas
  "Constructor.

  Constructs a new Canvas given a GraphicsConfiguration object.

  config - a reference to a GraphicsConfiguration object. - `java.awt.GraphicsConfiguration`"
  ([config]
    (new Canvas config))
  ([]
    (new Canvas )))

(defn add-notify
  "Creates the peer of the canvas.  This peer allows you to change the
   user interface of the canvas without changing its functionality."
  ([this]
    (-> this (.addNotify))))

(defn paint
  "Paints this canvas.

   Most applications that subclass Canvas should
   override this method in order to perform some useful operation
   (typically, custom painting of the canvas).
   The default operation is simply to clear the canvas.
   Applications that override this method need not call
   super.paint(g).

  g - the specified Graphics context - `java.awt.Graphics`"
  ([this g]
    (-> this (.paint g))))

(defn update
  "Updates this canvas.

   This method is called in response to a call to repaint.
   The canvas is first cleared by filling it with the background
   color, and then completely redrawn by calling this canvas's
   paint method.
   Note: applications that override this method should either call
   super.update(g) or incorporate the functionality described
   above into their own code.

  g - the specified Graphics context - `java.awt.Graphics`"
  ([this g]
    (-> this (.update g))))

(defn create-buffer-strategy
  "Creates a new strategy for multi-buffering on this component with the
   required buffer capabilities.  This is useful, for example, if only
   accelerated memory or page flipping is desired (as specified by the
   buffer capabilities).

   Each time this method
   is called, the existing buffer strategy for this component is discarded.

  num-buffers - number of buffers to create - `int`
  caps - the required capabilities for creating the buffer strategy; cannot be null - `java.awt.BufferCapabilities`

  throws: java.awt.AWTException - if the capabilities supplied could not be supported or met; this may happen, for example, if there is not enough accelerated memory currently available, or if page flipping is specified but not possible."
  ([this num-buffers caps]
    (-> this (.createBufferStrategy num-buffers caps)))
  ([this num-buffers]
    (-> this (.createBufferStrategy num-buffers))))

(defn get-buffer-strategy
  "Returns the BufferStrategy used by this component.  This
   method will return null if a BufferStrategy has not yet
   been created or has been disposed.

  returns: the buffer strategy used by this component - `java.awt.image.BufferStrategy`"
  ([this]
    (-> this (.getBufferStrategy))))

(defn get-accessible-context
  "Gets the AccessibleContext associated with this Canvas.
   For canvases, the AccessibleContext takes the form of an
   AccessibleAWTCanvas.
   A new AccessibleAWTCanvas instance is created if necessary.

  returns: an AccessibleAWTCanvas that serves as the
           AccessibleContext of this Canvas - `javax.accessibility.AccessibleContext`"
  ([this]
    (-> this (.getAccessibleContext))))

