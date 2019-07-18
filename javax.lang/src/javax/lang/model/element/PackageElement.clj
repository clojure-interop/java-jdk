(ns javax.lang.model.element.PackageElement
  "Represents a package program element.  Provides access to information
  about the package and its members."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element PackageElement]))

(defn get-qualified-name
  "Returns the fully qualified name of this package.
   This is also known as the package's canonical name.

  returns: the fully qualified name of this package, or an
   empty name if this is an unnamed package - `javax.lang.model.element.Name`"
  (^javax.lang.model.element.Name [^PackageElement this]
    (-> this (.getQualifiedName))))

(defn get-simple-name
  "Returns the simple name of this package.  For an unnamed
   package, an empty name is returned.

  returns: the simple name of this package or an empty name if
   this is an unnamed package - `javax.lang.model.element.Name`"
  (^javax.lang.model.element.Name [^PackageElement this]
    (-> this (.getSimpleName))))

(defn get-enclosed-elements
  "Returns the top-level
   classes and interfaces within this package.  Note that
   subpackages are not considered to be enclosed by a
   package.

  returns: the top-level classes and interfaces within this
   package - `java.util.List<? extends javax.lang.model.element.Element>`"
  ([^PackageElement this]
    (-> this (.getEnclosedElements))))

(defn unnamed?
  "Returns true is this is an unnamed package and false otherwise.

  returns: true is this is an unnamed package and false otherwise - `boolean`"
  (^Boolean [^PackageElement this]
    (-> this (.isUnnamed))))

(defn get-enclosing-element
  "Returns null since a package is not enclosed by another
   element.

  returns: null - `javax.lang.model.element.Element`"
  (^javax.lang.model.element.Element [^PackageElement this]
    (-> this (.getEnclosingElement))))

