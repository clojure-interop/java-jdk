(ns javax.lang.model.element.TypeParameterElement
  "Represents a formal type parameter of a generic class, interface, method,
  or constructor element.
  A type parameter declares a TypeVariable."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element TypeParameterElement]))

(defn get-generic-element
  "Returns the generic class, interface, method, or constructor that is
   parameterized by this type parameter.

  returns: the generic class, interface, method, or constructor that is
   parameterized by this type parameter - `javax.lang.model.element.Element`"
  (^javax.lang.model.element.Element [^TypeParameterElement this]
    (-> this (.getGenericElement))))

(defn get-bounds
  "Returns the bounds of this type parameter.
   These are the types given by the extends clause
   used to declare this type parameter.
   If no explicit extends clause was used,
   then java.lang.Object is considered to be the sole bound.

  returns: the bounds of this type parameter, or an empty list if
   there are none - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([^TypeParameterElement this]
    (-> this (.getBounds))))

(defn get-enclosing-element
  "Returns the generic element of this type parameter.

  returns: the generic element of this type parameter - `javax.lang.model.element.Element`"
  (^javax.lang.model.element.Element [^TypeParameterElement this]
    (-> this (.getEnclosingElement))))

