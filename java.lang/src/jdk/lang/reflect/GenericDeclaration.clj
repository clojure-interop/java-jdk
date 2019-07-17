(ns jdk.lang.reflect.GenericDeclaration
  "A common interface for all entities that declare type variables."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect GenericDeclaration]))

(defn get-type-parameters
  "Returns an array of TypeVariable objects that
   represent the type variables declared by the generic
   declaration represented by this GenericDeclaration
   object, in declaration order.  Returns an array of length 0 if
   the underlying generic declaration declares no type variables.

  returns: an array of TypeVariable objects that represent
       the type variables declared by this generic declaration - `java.lang.reflect.TypeVariable<?>[]`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic signature of this generic declaration does not conform to the format specified in The Java™ Virtual Machine Specification"
  ([^java.lang.reflect.GenericDeclaration this]
    (-> this (.getTypeParameters))))

