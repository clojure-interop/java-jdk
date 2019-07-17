(ns jdk.awt.datatransfer.FlavorMap
  "A two-way Map between `natives` (Strings), which correspond to platform-
  specific data formats, and `flavors` (DataFlavors), which correspond to
  platform-independent MIME types. FlavorMaps need not be symmetric, but
  typically are."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer FlavorMap]))

(defn get-natives-for-flavors
  "Returns a Map of the specified DataFlavors to
   their corresponding String native. The returned
   Map is a modifiable copy of this FlavorMap's
   internal data. Client code is free to modify the Map
   without affecting this object.

  flavors - an array of DataFlavors which will be the key set of the returned Map. If null is specified, a mapping of all DataFlavors currently known to this FlavorMap to their corresponding String natives will be returned. - `java.awt.datatransfer.DataFlavor[]`

  returns: a java.util.Map of DataFlavors to
           String natives - `java.util.Map<java.awt.datatransfer.DataFlavor,java.lang.String>`"
  ([^java.awt.datatransfer.FlavorMap this ^java.awt.datatransfer.DataFlavor[] flavors]
    (-> this (.getNativesForFlavors flavors))))

(defn get-flavors-for-natives
  "Returns a Map of the specified String natives
   to their corresponding DataFlavor. The returned
   Map is a modifiable copy of this FlavorMap's
   internal data. Client code is free to modify the Map
   without affecting this object.

  natives - an array of Strings which will be the key set of the returned Map. If null is specified, a mapping of all String natives currently known to this FlavorMap to their corresponding DataFlavors will be returned. - `java.lang.String[]`

  returns: a java.util.Map of String natives to
           DataFlavors - `java.util.Map<java.lang.String,java.awt.datatransfer.DataFlavor>`"
  ([^java.awt.datatransfer.FlavorMap this ^java.lang.String[] natives]
    (-> this (.getFlavorsForNatives natives))))

