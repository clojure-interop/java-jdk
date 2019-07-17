(ns jdk.awt.BufferCapabilities$FlipContents
  "A type-safe enumeration of the possible back buffer contents after
  page-flipping"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt BufferCapabilities$FlipContents]))

(def *-undefined
  "Static Constant.

  When flip contents are UNDEFINED, the
   contents of the back buffer are undefined after flipping.

  type: java.awt.BufferCapabilities.FlipContents"
  BufferCapabilities$FlipContents/UNDEFINED)

(def *-background
  "Static Constant.

  When flip contents are BACKGROUND, the
   contents of the back buffer are cleared with the background color after
   flipping.

  type: java.awt.BufferCapabilities.FlipContents"
  BufferCapabilities$FlipContents/BACKGROUND)

(def *-prior
  "Static Constant.

  When flip contents are PRIOR, the
   contents of the back buffer are the prior contents of the front buffer
   (a true page flip).

  type: java.awt.BufferCapabilities.FlipContents"
  BufferCapabilities$FlipContents/PRIOR)

(def *-copied
  "Static Constant.

  When flip contents are COPIED, the
   contents of the back buffer are copied to the front buffer when
   flipping.

  type: java.awt.BufferCapabilities.FlipContents"
  BufferCapabilities$FlipContents/COPIED)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^java.awt.BufferCapabilities$FlipContents this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^java.awt.BufferCapabilities$FlipContents this]
    (-> this (.toString))))

