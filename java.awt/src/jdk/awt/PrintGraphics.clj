(ns jdk.awt.PrintGraphics
  "An abstract class which provides a print graphics context for a page."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PrintGraphics]))

(defn get-print-job
  "Returns the PrintJob object from which this PrintGraphics
   object originated.

  returns: `java.awt.PrintJob`"
  ([^. this]
    (-> this (.getPrintJob))))

