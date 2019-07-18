(ns jdk.awt.PointerInfo
  "A class that describes the pointer position.
  It provides the GraphicsDevice where the pointer is and
  the Point that represents the coordinates of the pointer.

  Instances of this class should be obtained via
  MouseInfo.getPointerInfo().
  The PointerInfo instance is not updated dynamically as the mouse
  moves. To get the updated location, you must call
  MouseInfo.getPointerInfo() again."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PointerInfo]))

(defn get-device
  "Returns the GraphicsDevice where the mouse pointer was at the
   moment this PointerInfo was created.

  returns: GraphicsDevice corresponding to the pointer - `java.awt.GraphicsDevice`"
  (^java.awt.GraphicsDevice [^PointerInfo this]
    (-> this (.getDevice))))

(defn get-location
  "Returns the Point that represents the coordinates of the pointer
   on the screen. See MouseInfo.getPointerInfo() for more information
   about coordinate calculation for multiscreen systems.

  returns: coordinates of mouse pointer - `java.awt.Point`"
  (^java.awt.Point [^PointerInfo this]
    (-> this (.getLocation))))

