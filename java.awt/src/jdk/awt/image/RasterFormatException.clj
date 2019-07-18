(ns jdk.awt.image.RasterFormatException
  "The RasterFormatException is thrown if there is
  invalid layout information in the Raster."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image RasterFormatException]))

(defn ->raster-format-exception
  "Constructor.

  Constructs a new RasterFormatException with the
   specified message.

  s - the message to generate when a RasterFormatException is thrown - `java.lang.String`"
  (^RasterFormatException [^java.lang.String s]
    (new RasterFormatException s)))

