(ns javax.naming.spi.DirStateFactory$Result
  "An object/attributes pair for returning the result of
  DirStateFactory.getStateToBind()."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi DirStateFactory$Result]))

(defn ->result
  "Constructor.

  Constructs an instance of Result.

  obj - The possibly null object to be bound. - `java.lang.Object`
  out-attrs - The possibly null attributes to be bound. - `javax.naming.directory.Attributes`"
  (^DirStateFactory$Result [^java.lang.Object obj ^javax.naming.directory.Attributes out-attrs]
    (new DirStateFactory$Result obj out-attrs)))

(defn get-object
  "Retrieves the object to be bound.

  returns: The possibly null object to be bound. - `java.lang.Object`"
  (^java.lang.Object [^DirStateFactory$Result this]
    (-> this (.getObject))))

(defn get-attributes
  "Retrieves the attributes to be bound.

  returns: The possibly null attributes to be bound. - `javax.naming.directory.Attributes`"
  (^javax.naming.directory.Attributes [^DirStateFactory$Result this]
    (-> this (.getAttributes))))

