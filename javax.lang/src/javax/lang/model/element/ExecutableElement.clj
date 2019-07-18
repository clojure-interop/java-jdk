(ns javax.lang.model.element.ExecutableElement
  "Represents a method, constructor, or initializer (static or
  instance) of a class or interface, including annotation type
  elements."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.element ExecutableElement]))

(defn get-thrown-types
  "Returns the exceptions and other throwables listed in this
   method or constructor's throws clause in declaration
   order.

  returns: the exceptions and other throwables listed in the
   throws clause, or an empty list if there are none - `java.util.List<? extends javax.lang.model.type.TypeMirror>`"
  ([^ExecutableElement this]
    (-> this (.getThrownTypes))))

(defn var-args?
  "Returns true if this method or constructor accepts a variable
   number of arguments and returns false otherwise.

  returns: true if this method or constructor accepts a variable
   number of arguments and false otherwise - `boolean`"
  (^Boolean [^ExecutableElement this]
    (-> this (.isVarArgs))))

(defn get-parameters
  "Returns the formal parameters of this executable.
   They are returned in declaration order.

  returns: the formal parameters,
   or an empty list if there are none - `java.util.List<? extends javax.lang.model.element.VariableElement>`"
  ([^ExecutableElement this]
    (-> this (.getParameters))))

(defn get-default-value
  "Returns the default value if this executable is an annotation
   type element.  Returns null if this method is not an
   annotation type element, or if it is an annotation type element
   with no default value.

  returns: the default value, or null if none - `javax.lang.model.element.AnnotationValue`"
  (^javax.lang.model.element.AnnotationValue [^ExecutableElement this]
    (-> this (.getDefaultValue))))

(defn get-type-parameters
  "Returns the formal type parameters of this executable
   in declaration order.

  returns: the formal type parameters, or an empty list
   if there are none - `java.util.List<? extends javax.lang.model.element.TypeParameterElement>`"
  ([^ExecutableElement this]
    (-> this (.getTypeParameters))))

(defn get-return-type
  "Returns the return type of this executable.
   Returns a NoType with kind VOID
   if this executable is not a method, or is a method that does not
   return a value.

  returns: the return type of this executable - `javax.lang.model.type.TypeMirror`"
  (^javax.lang.model.type.TypeMirror [^ExecutableElement this]
    (-> this (.getReturnType))))

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
  (^javax.lang.model.type.TypeMirror [^ExecutableElement this]
    (-> this (.getReceiverType))))

(defn get-simple-name
  "Returns the simple name of a constructor, method, or
   initializer.  For a constructor, the name `<init>` is
   returned, for a static initializer, the name `<clinit>`
   is returned, and for an anonymous class or instance
   initializer, an empty name is returned.

  returns: the simple name of a constructor, method, or
   initializer - `javax.lang.model.element.Name`"
  (^javax.lang.model.element.Name [^ExecutableElement this]
    (-> this (.getSimpleName))))

(defn default?
  "Returns true if this method is a default method and
   returns false otherwise.

  returns: true if this method is a default method and
   false otherwise - `boolean`"
  (^Boolean [^ExecutableElement this]
    (-> this (.isDefault))))

