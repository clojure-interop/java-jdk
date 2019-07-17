(ns javax.lang.model.type.MirroredTypesException
  "Thrown when an application attempts to access a sequence of Class objects each corresponding to a TypeMirror."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type MirroredTypesException]))

(defn ->mirrored-types-exception
  "Constructor.

  Constructs a new MirroredTypesException for the specified types.

  types - the types being accessed - `javax.lang.model.type.TypeMirror>`"
  ([types]
    (new MirroredTypesException types)))

(defn get-type-mirrors
  "Returns the type mirrors corresponding to the types being accessed.
   The type mirrors may be unavailable if this exception has been
   serialized and then read back in.

  returns: the type mirrors in construction order, or null if unavailable - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([this]
    (-> this (.getTypeMirrors))))

