(ns jdk.awt.Cursor
  "A class to encapsulate the bitmap representation of the mouse cursor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Cursor]))

(defn ->cursor
  "Constructor.

  Creates a new cursor object with the specified type.

  type - the type of cursor - `int`

  throws: java.lang.IllegalArgumentException - if the specified cursor type is invalid"
  (^Cursor [^Integer type]
    (new Cursor type)))

(def *-default-cursor
  "Static Constant.

  The default cursor type (gets set if no cursor is defined).

  type: int"
  Cursor/DEFAULT_CURSOR)

(def *-crosshair-cursor
  "Static Constant.

  The crosshair cursor type.

  type: int"
  Cursor/CROSSHAIR_CURSOR)

(def *-text-cursor
  "Static Constant.

  The text cursor type.

  type: int"
  Cursor/TEXT_CURSOR)

(def *-wait-cursor
  "Static Constant.

  The wait cursor type.

  type: int"
  Cursor/WAIT_CURSOR)

(def *-sw-resize-cursor
  "Static Constant.

  The south-west-resize cursor type.

  type: int"
  Cursor/SW_RESIZE_CURSOR)

(def *-se-resize-cursor
  "Static Constant.

  The south-east-resize cursor type.

  type: int"
  Cursor/SE_RESIZE_CURSOR)

(def *-nw-resize-cursor
  "Static Constant.

  The north-west-resize cursor type.

  type: int"
  Cursor/NW_RESIZE_CURSOR)

(def *-ne-resize-cursor
  "Static Constant.

  The north-east-resize cursor type.

  type: int"
  Cursor/NE_RESIZE_CURSOR)

(def *-n-resize-cursor
  "Static Constant.

  The north-resize cursor type.

  type: int"
  Cursor/N_RESIZE_CURSOR)

(def *-s-resize-cursor
  "Static Constant.

  The south-resize cursor type.

  type: int"
  Cursor/S_RESIZE_CURSOR)

(def *-w-resize-cursor
  "Static Constant.

  The west-resize cursor type.

  type: int"
  Cursor/W_RESIZE_CURSOR)

(def *-e-resize-cursor
  "Static Constant.

  The east-resize cursor type.

  type: int"
  Cursor/E_RESIZE_CURSOR)

(def *-hand-cursor
  "Static Constant.

  The hand cursor type.

  type: int"
  Cursor/HAND_CURSOR)

(def *-move-cursor
  "Static Constant.

  The move cursor type.

  type: int"
  Cursor/MOVE_CURSOR)

(def *-custom-cursor
  "Static Constant.

  The type associated with all custom cursors.

  type: int"
  Cursor/CUSTOM_CURSOR)

(defn *get-predefined-cursor
  "Returns a cursor object with the specified predefined type.

  type - the type of predefined cursor - `int`

  returns: the specified predefined cursor - `java.awt.Cursor`

  throws: java.lang.IllegalArgumentException - if the specified cursor type is invalid"
  (^java.awt.Cursor [^Integer type]
    (Cursor/getPredefinedCursor type)))

(defn *get-system-custom-cursor
  "Returns a system-specific custom cursor object matching the
   specified name.  Cursor names are, for example: \"Invalid.16x16\"

  name - a string describing the desired system-specific custom cursor - `java.lang.String`

  returns: the system specific custom cursor named - `java.awt.Cursor`

  throws: java.awt.HeadlessException - if GraphicsEnvironment.isHeadless returns true"
  (^java.awt.Cursor [^java.lang.String name]
    (Cursor/getSystemCustomCursor name)))

(defn *get-default-cursor
  "Return the system default cursor.

  returns: `java.awt.Cursor`"
  (^java.awt.Cursor []
    (Cursor/getDefaultCursor )))

(defn get-type
  "Returns the type for this cursor.

  returns: `int`"
  (^Integer [^Cursor this]
    (-> this (.getType))))

(defn get-name
  "Returns the name of this cursor.

  returns: a localized description of this cursor. - `java.lang.String`"
  (^java.lang.String [^Cursor this]
    (-> this (.getName))))

(defn to-string
  "Returns a string representation of this cursor.

  returns: a string representation of this cursor. - `java.lang.String`"
  (^java.lang.String [^Cursor this]
    (-> this (.toString))))

