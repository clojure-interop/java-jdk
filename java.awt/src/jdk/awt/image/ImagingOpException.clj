(ns jdk.awt.image.ImagingOpException
  "The ImagingOpException is thrown if one of the
  BufferedImageOp or RasterOp filter methods cannot
  process the image."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.image ImagingOpException]))

(defn ->imaging-op-exception
  "Constructor.

  Constructs an ImagingOpException object with the
   specified message.

  s - the message to generate when a ImagingOpException is thrown - `java.lang.String`"
  ([^java.lang.String s]
    (new ImagingOpException s)))

