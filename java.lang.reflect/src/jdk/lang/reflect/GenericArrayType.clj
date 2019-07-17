(ns jdk.lang.reflect.GenericArrayType
  "GenericArrayType represents an array type whose component
  type is either a parameterized type or a type variable."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect GenericArrayType]))

(defn get-generic-component-type
  "Returns a Type object representing the component type
   of this array. This method creates the component type of the
   array.  See the declaration of ParameterizedType for the
   semantics of the creation process for parameterized types and
   see TypeVariable for the
   creation process for type variables.

  returns: a Type object representing the component type
       of this array - `java.lang.reflect.Type`

  throws: java.lang.TypeNotPresentException - if the underlying array type's component type refers to a non-existent type declaration"
  (^java.lang.reflect.Type [^java.lang.reflect.GenericArrayType this]
    (-> this (.getGenericComponentType))))

