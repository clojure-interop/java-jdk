(ns javax.tools.ForwardingJavaFileObject
  "Forwards calls to a given file object.  Subclasses of this class
  might override some of these methods and might also provide
  additional fields and methods."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools ForwardingJavaFileObject]))

(defn get-kind
  "Description copied from interface: JavaFileObject

  returns: the kind - `javax.tools.JavaFileObject.Kind`"
  ([this]
    (-> this (.getKind))))

(defn name-compatible?
  "Description copied from interface: JavaFileObject

  simple-name - a simple name of a class - `java.lang.String`
  kind - a kind - `javax.tools.JavaFileObject.Kind`

  returns: true if this file object is compatible; false
   otherwise - `boolean`"
  ([this simple-name kind]
    (-> this (.isNameCompatible simple-name kind))))

(defn get-nesting-kind
  "Description copied from interface: JavaFileObject

  returns: the nesting kind, or null if the nesting kind
   is not known - `javax.lang.model.element.NestingKind`"
  ([this]
    (-> this (.getNestingKind))))

(defn get-access-level
  "Description copied from interface: JavaFileObject

  returns: the access level - `javax.lang.model.element.Modifier`"
  ([this]
    (-> this (.getAccessLevel))))

