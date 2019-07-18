(ns javax.lang.model.type.ExecutableType
  "Represents the type of an executable.  An executable
  is a method, constructor, or initializer.

   The executable is
  represented as when viewed as a method (or constructor or
  initializer) of some reference type.
  If that reference type is parameterized, then its actual
  type arguments are substituted into any types returned by the methods of
  this interface."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type ExecutableType]))

(defn get-type-variables
  "Returns the type variables declared by the formal type parameters
   of this executable.

  returns: the type variables declared by the formal type parameters,
            or an empty list if there are none - `java.util.List<? extends javax.lang.model.type.TypeVariable>`"
  ([^ExecutableType this]
    (-> this (.getTypeVariables))))

(defn get-return-type
  "Returns the return type of this executable.
   Returns a NoType with kind VOID
   if this executable is not a method, or is a method that does not
   return a value.

  returns: the return type of this executable - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^ExecutableType this]
    (-> this (.getReturnType))))

(defn get-parameter-types
  "Returns the types of this executable's formal parameters.

  returns: the types of this executable's formal parameters,
            or an empty list if there are none - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([^ExecutableType this]
    (-> this (.getParameterTypes))))

(defn get-receiver-type
  "Returns the receiver type of this executable,
   or NoType with
   kind NONE
   if the executable has no receiver type.

   An executable which is an instance method, or a constructor of an
   inner class, has a receiver type derived from the declaring type.

   An executable which is a static method, or a constructor of a
   non-inner class, or an initializer (static or instance), has no
   receiver type.

  returns: the receiver type of this executable - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^ExecutableType this]
    (-> this (.getReceiverType))))

(defn get-thrown-types
  "Returns the exceptions and other throwables listed in this
   executable's throws clause.

  returns: the exceptions and other throwables listed in this
            executable's throws clause,
            or an empty list if there are none. - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([^ExecutableType this]
    (-> this (.getThrownTypes))))

