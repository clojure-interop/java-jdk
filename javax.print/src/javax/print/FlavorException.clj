(ns javax.print.FlavorException
  "Interface FlavorException is a mixin interface which a subclass of PrintException can implement to report an error condition
  involving a doc flavor or flavors (class DocFlavor). The Print Service API does not define any print exception
  classes that implement interface FlavorException, that being left to the
  Print Service implementor's discretion."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print FlavorException]))

(defn get-unsupported-flavors
  "Returns the unsupported flavors.

  returns: the unsupported doc flavors. - `javax.print.DocFlavor[]`"
  ([this]
    (-> this (.getUnsupportedFlavors))))

