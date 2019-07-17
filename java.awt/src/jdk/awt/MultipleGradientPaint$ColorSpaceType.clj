(ns jdk.awt.MultipleGradientPaint$ColorSpaceType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MultipleGradientPaint$ColorSpaceType]))

(def SRGB
  "Enum Constant.

  Indicates that the color interpolation should occur in sRGB space.

  type: java.awt.MultipleGradientPaint.ColorSpaceType"
  MultipleGradientPaint$ColorSpaceType/SRGB)

(def LINEAR_RGB
  "Enum Constant.

  Indicates that the color interpolation should occur in linearized
   RGB space.

  type: java.awt.MultipleGradientPaint.ColorSpaceType"
  MultipleGradientPaint$ColorSpaceType/LINEAR_RGB)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (MultipleGradientPaint.ColorSpaceType c : MultipleGradientPaint.ColorSpaceType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.MultipleGradientPaint.ColorSpaceType[]`"
  ([]
    (MultipleGradientPaint$ColorSpaceType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.MultipleGradientPaint.ColorSpaceType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.awt.MultipleGradientPaint.ColorSpaceType [^java.lang.String name]
    (MultipleGradientPaint$ColorSpaceType/valueOf name)))

