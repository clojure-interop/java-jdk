(ns jdk.awt.MultipleGradientPaint$CycleMethod
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt MultipleGradientPaint$CycleMethod]))

(def NO_CYCLE
  "Enum Constant.

  Use the terminal colors to fill the remaining area.

  type: java.awt.MultipleGradientPaint$CycleMethod"
  MultipleGradientPaint$CycleMethod/NO_CYCLE)

(def REFLECT
  "Enum Constant.

  Cycle the gradient colors start-to-end, end-to-start
   to fill the remaining area.

  type: java.awt.MultipleGradientPaint$CycleMethod"
  MultipleGradientPaint$CycleMethod/REFLECT)

(def REPEAT
  "Enum Constant.

  Cycle the gradient colors start-to-end, start-to-end
   to fill the remaining area.

  type: java.awt.MultipleGradientPaint$CycleMethod"
  MultipleGradientPaint$CycleMethod/REPEAT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (MultipleGradientPaint.CycleMethod c : MultipleGradientPaint.CycleMethod.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.MultipleGradientPaint$CycleMethod[]`"
  ([]
    (MultipleGradientPaint$CycleMethod/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.MultipleGradientPaint$CycleMethod`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.awt.MultipleGradientPaint$CycleMethod [^java.lang.String name]
    (MultipleGradientPaint$CycleMethod/valueOf name)))

