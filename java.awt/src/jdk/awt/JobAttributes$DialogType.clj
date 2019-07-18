(ns jdk.awt.JobAttributes$DialogType
  "A type-safe enumeration of possible dialogs to display to the user."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt JobAttributes$DialogType]))

(def *-common
  "Static Constant.

  The DialogType instance to use for
   specifying the cross-platform, pure Java print dialog.

  type: java.awt.JobAttributes$DialogType"
  JobAttributes$DialogType/COMMON)

(def *-native
  "Static Constant.

  The DialogType instance to use for
   specifying the platform's native print dialog.

  type: java.awt.JobAttributes$DialogType"
  JobAttributes$DialogType/NATIVE)

(def *-none
  "Static Constant.

  The DialogType instance to use for
   specifying no print dialog.

  type: java.awt.JobAttributes$DialogType"
  JobAttributes$DialogType/NONE)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^JobAttributes$DialogType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^JobAttributes$DialogType this]
    (-> this (.toString))))

