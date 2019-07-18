(ns javax.naming.spi.ResolveResult
  "This class represents the result of resolution of a name.
  It contains the object to which name was resolved, and the portion
  of the name that has not been resolved.

  A ResolveResult instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single ResolveResult instance should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi ResolveResult]))

(defn ->resolve-result
  "Constructor.

  Constructs a new instance of ResolveResult consisting of
   the resolved object and the remaining unresolved component.

  robj - The non-null object resolved to. - `java.lang.Object`
  rcomp - The single remaining name component that has yet to be resolved. Cannot be null (but can be empty). - `java.lang.String`"
  (^ResolveResult [^java.lang.Object robj ^java.lang.String rcomp]
    (new ResolveResult robj rcomp)))

(defn get-remaining-name
  "Retrieves the remaining unresolved portion of the name.

  returns: The remaining unresolved portion of the name.
            Cannot be null but empty OK. - `javax.naming.Name`"
  (^javax.naming.Name [^ResolveResult this]
    (-> this (.getRemainingName))))

(defn get-resolved-obj
  "Retrieves the Object to which resolution was successful.

  returns: The Object to which resolution was successful. Cannot be null. - `java.lang.Object`"
  (^java.lang.Object [^ResolveResult this]
    (-> this (.getResolvedObj))))

(defn set-remaining-name
  "Sets the remaining name field of this result to name.
   A copy of name is made so that modifying the copy within
   this ResolveResult does not affect name and
   vice versa.

  name - The name to set remaining name to. Cannot be null. - `javax.naming.Name`"
  ([^ResolveResult this ^javax.naming.Name name]
    (-> this (.setRemainingName name))))

(defn append-remaining-name
  "Adds components to the end of remaining name.

  name - The components to add. Can be null. - `javax.naming.Name`"
  ([^ResolveResult this ^javax.naming.Name name]
    (-> this (.appendRemainingName name))))

(defn append-remaining-component
  "Adds a single component to the end of remaining name.

  name - The component to add. Can be null. - `java.lang.String`"
  ([^ResolveResult this ^java.lang.String name]
    (-> this (.appendRemainingComponent name))))

(defn set-resolved-obj
  "Sets the resolved Object field of this result to obj.

  obj - The object to use for setting the resolved obj field. Cannot be null. - `java.lang.Object`"
  ([^ResolveResult this ^java.lang.Object obj]
    (-> this (.setResolvedObj obj))))

