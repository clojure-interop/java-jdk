(ns jdk.awt.MouseInfo
  "MouseInfo  provides methods for getting information about the mouse,
  such as mouse pointer location and the number of mouse buttons."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MouseInfo]))

(defn *get-pointer-info
  "Returns a PointerInfo instance that represents the current
   location of the mouse pointer.
   The GraphicsDevice stored in this PointerInfo
   contains the mouse pointer. The coordinate system used for the mouse position
   depends on whether or not the GraphicsDevice is part of a virtual
   screen device.
   For virtual screen devices, the coordinates are given in the virtual
   coordinate system, otherwise they are returned in the coordinate system
   of the GraphicsDevice. See GraphicsConfiguration
   for more information about the virtual screen devices.
   On systems without a mouse, returns null.

   If there is a security manager, its checkPermission method
   is called with an AWTPermission(`watchMousePointer`)
   permission before creating and returning a PointerInfo
   object. This may result in a SecurityException.

  returns: location of the mouse pointer - `java.awt.PointerInfo`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([]
    (MouseInfo/getPointerInfo )))

(defn *get-number-of-buttons
  "Returns the number of buttons on the mouse.
   On systems without a mouse, returns -1.

  returns: number of buttons on the mouse - `int`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless() returns true"
  ([]
    (MouseInfo/getNumberOfButtons )))

