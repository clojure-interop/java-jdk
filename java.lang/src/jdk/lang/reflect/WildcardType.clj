(ns jdk.lang.reflect.WildcardType
  "WildcardType represents a wildcard type expression, such as
  ?, ? extends Number, or ? super Integer."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect WildcardType]))

(defn get-upper-bounds
  "Returns an array of Type objects representing the  upper
   bound(s) of this type variable.  Note that if no upper bound is
   explicitly declared, the upper bound is Object.

   For each upper bound B :

    if B is a parameterized type or a type variable, it is created,
    (see ParameterizedType
    for the details of the creation process for parameterized types).
    Otherwise, B is resolved.

  returns: an array of Types representing the upper bound(s) of this
       type variable - `java.lang.reflect.Type[]`

  throws: java.lang.TypeNotPresentException - if any of the bounds refers to a non-existent type declaration"
  ([^WildcardType this]
    (-> this (.getUpperBounds))))

(defn get-lower-bounds
  "Returns an array of Type objects representing the
   lower bound(s) of this type variable.  Note that if no lower bound is
   explicitly declared, the lower bound is the type of null.
   In this case, a zero length array is returned.

   For each lower bound B :

     if B is a parameterized type or a type variable, it is created,
    (see ParameterizedType
    for the details of the creation process for parameterized types).
     Otherwise, B is resolved.

  returns: an array of Types representing the lower bound(s) of this
       type variable - `java.lang.reflect.Type[]`

  throws: java.lang.TypeNotPresentException - if any of the bounds refers to a non-existent type declaration"
  ([^WildcardType this]
    (-> this (.getLowerBounds))))

