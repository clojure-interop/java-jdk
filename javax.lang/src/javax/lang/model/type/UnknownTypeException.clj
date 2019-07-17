(ns javax.lang.model.type.UnknownTypeException
  "Indicates that an unknown kind of type was encountered.  This can
  occur if the language evolves and new kinds of types are added to
  the TypeMirror hierarchy.  May be thrown by a javax.lang.model.type.type visitor to indicate that the visitor was created
  for a prior version of the language."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type UnknownTypeException]))

(defn ->unknown-type-exception
  "Constructor.

  Creates a new UnknownTypeException.The p
   parameter may be used to pass in an additional argument with
   information about the context in which the unknown type was
   encountered; for example, the visit methods of TypeVisitor may pass in their additional parameter.

  t - the unknown type, may be null - `javax.lang.model.type.TypeMirror`
  p - an additional parameter, may be null - `java.lang.Object`"
  ([^javax.lang.model.type.TypeMirror t ^java.lang.Object p]
    (new UnknownTypeException t p)))

(defn get-unknown-type
  "Returns the unknown type.
   The value may be unavailable if this exception has been
   serialized and then read back in.

  returns: the unknown type, or null if unavailable - `javax.lang.model.type.TypeMirror`"
  ([^javax.lang.model.type.UnknownTypeException this]
    (-> this (.getUnknownType))))

(defn get-argument
  "Returns the additional argument.

  returns: the additional argument - `java.lang.Object`"
  ([^javax.lang.model.type.UnknownTypeException this]
    (-> this (.getArgument))))

