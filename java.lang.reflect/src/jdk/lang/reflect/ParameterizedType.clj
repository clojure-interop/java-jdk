(ns jdk.lang.reflect.ParameterizedType
  "ParameterizedType represents a parameterized type such as
  Collection<String>.

  A parameterized type is created the first time it is needed by a
  reflective method, as specified in this package. When a
  parameterized type p is created, the generic type declaration that
  p instantiates is resolved, and all type arguments of p are created
  recursively. See TypeVariable for details on the creation process for type
  variables. Repeated creation of a parameterized type has no effect.

  Instances of classes that implement this interface must implement
  an equals() method that equates any two instances that share the
  same generic type declaration and have equal type parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect ParameterizedType]))

(defn get-actual-type-arguments
  "Returns an array of Type objects representing the actual type
   arguments to this type.

   Note that in some cases, the returned array be empty. This can occur
   if this type represents a non-parameterized type nested within
   a parameterized type.

  returns: an array of Type objects representing the actual type
       arguments to this type - `java.lang.reflect.Type[]`

  throws: java.lang.TypeNotPresentException - if any of the actual type arguments refers to a non-existent type declaration"
  ([^java.lang.reflect.ParameterizedType this]
    (-> this (.getActualTypeArguments))))

(defn get-raw-type
  "Returns the Type object representing the class or interface
   that declared this type.

  returns: the Type object representing the class or interface
       that declared this type - `java.lang.reflect.Type`"
  (^java.lang.reflect.Type [^java.lang.reflect.ParameterizedType this]
    (-> this (.getRawType))))

(defn get-owner-type
  "Returns a Type object representing the type that this type
   is a member of.  For example, if this type is O<T>.I<S>,
   return a representation of O<T>.

   If this type is a top-level type, null is returned.

  returns: a Type object representing the type that
       this type is a member of. If this type is a top-level type,
       null is returned - `java.lang.reflect.Type`

  throws: java.lang.TypeNotPresentException - if the owner type refers to a non-existent type declaration"
  (^java.lang.reflect.Type [^java.lang.reflect.ParameterizedType this]
    (-> this (.getOwnerType))))

