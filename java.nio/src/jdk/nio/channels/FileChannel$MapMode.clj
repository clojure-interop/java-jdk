(ns jdk.nio.channels.FileChannel$MapMode
  "A typesafe enumeration for file-mapping modes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.channels FileChannel$MapMode]))

(def *-read-only
  "Static Constant.

  Mode for a read-only mapping.

  type: java.nio.channels.FileChannel$MapMode"
  FileChannel$MapMode/READ_ONLY)

(def *-read-write
  "Static Constant.

  Mode for a read/write mapping.

  type: java.nio.channels.FileChannel$MapMode"
  FileChannel$MapMode/READ_WRITE)

(def *-private
  "Static Constant.

  Mode for a private (copy-on-write) mapping.

  type: java.nio.channels.FileChannel$MapMode"
  FileChannel$MapMode/PRIVATE)

(defn to-string
  "Returns a string describing this file-mapping mode.

  returns: A descriptive string - `java.lang.String`"
  (^java.lang.String [^FileChannel$MapMode this]
    (-> this (.toString))))

