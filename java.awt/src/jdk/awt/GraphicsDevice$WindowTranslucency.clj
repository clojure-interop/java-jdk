(ns jdk.awt.GraphicsDevice$WindowTranslucency
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt GraphicsDevice$WindowTranslucency]))

(def PERPIXEL_TRANSPARENT
  "Enum Constant.

  Represents support in the underlying system for windows each pixel
   of which is guaranteed to be either completely opaque, with
   an alpha value of 1.0, or completely transparent, with an alpha
   value of 0.0.

  type: java.awt.GraphicsDevice.WindowTranslucency"
  GraphicsDevice$WindowTranslucency/PERPIXEL_TRANSPARENT)

(def TRANSLUCENT
  "Enum Constant.

  Represents support in the underlying system for windows all of
   the pixels of which have the same alpha value between or including
   0.0 and 1.0.

  type: java.awt.GraphicsDevice.WindowTranslucency"
  GraphicsDevice$WindowTranslucency/TRANSLUCENT)

(def PERPIXEL_TRANSLUCENT
  "Enum Constant.

  Represents support in the underlying system for windows that
   contain or might contain pixels with arbitrary alpha values
   between and including 0.0 and 1.0.

  type: java.awt.GraphicsDevice.WindowTranslucency"
  GraphicsDevice$WindowTranslucency/PERPIXEL_TRANSLUCENT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (GraphicsDevice.WindowTranslucency c : GraphicsDevice.WindowTranslucency.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.GraphicsDevice.WindowTranslucency[]`"
  ([]
    (GraphicsDevice$WindowTranslucency/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.GraphicsDevice.WindowTranslucency`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (GraphicsDevice$WindowTranslucency/valueOf name)))

