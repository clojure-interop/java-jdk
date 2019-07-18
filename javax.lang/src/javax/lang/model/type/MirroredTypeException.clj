(ns javax.lang.model.type.MirroredTypeException
  "Thrown when an application attempts to access the Class object
  corresponding to a TypeMirror."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type MirroredTypeException]))

(defn ->mirrored-type-exception
  "Constructor.

  Constructs a new MirroredTypeException for the specified type.

  type - the type being accessed - `javax.lang.model.type.TypeMirror`"
  (^MirroredTypeException [^javax.lang.model.type.TypeMirror type]
    (new MirroredTypeException type)))

(defn get-type-mirror
  "Returns the type mirror corresponding to the type being accessed.
   The type mirror may be unavailable if this exception has been
   serialized and then read back in.

  returns: the type mirror, or null if unavailable - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^MirroredTypeException this]
    (-> this (.getTypeMirror))))

