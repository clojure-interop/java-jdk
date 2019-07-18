(ns javax.tools.JavaFileManager$Location
  "Interface for locations of file objects.  Used by file managers
  to determine where to place or search for file objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools JavaFileManager$Location]))

(defn get-name
  "Gets the name of this location.

  returns: a name - `java.lang.String`"
  (^java.lang.String [^JavaFileManager$Location this]
    (-> this (.getName))))

(defn output-location?
  "Determines if this is an output location.  An output
   location is a location that is conventionally used for
   output.

  returns: true if this is an output location, false otherwise - `boolean`"
  (^Boolean [^JavaFileManager$Location this]
    (-> this (.isOutputLocation))))

