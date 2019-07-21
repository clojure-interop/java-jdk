(ns jdk.lang.reflect.Parameter
  "Information about method parameters.

  A Parameter provides information about method parameters,
  including its name and modifiers.  It also provides an alternate
  means of obtaining attributes for the parameter."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Parameter]))

(defn get-declared-annotation
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       directly present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Parameter this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotation annotation-class))))

(defn get-declared-annotations-by-type
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       directly or indirectly present on this element, else an array of length zero - `<T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Parameter this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotationsByType annotation-class))))

(defn name-present?
  "Returns true if the parameter has a name according to the class
   file; returns false otherwise. Whether a parameter has a name
   is determined by the MethodParameters attribute of
   the method which declares the parameter.

  returns: true if and only if the parameter has a name according
   to the class file. - `boolean`"
  (^Boolean [^Parameter this]
    (-> this (.isNamePresent))))

(defn get-type
  "Returns a Class object that identifies the
   declared type for the parameter represented by this
   Parameter object.

  returns: a Class object identifying the declared
   type of the parameter represented by this object - `java.lang.Class<?>`"
  (^java.lang.Class [^Parameter this]
    (-> this (.getType))))

(defn var-args?
  "Returns true if this parameter represents a variable
   argument list; returns false otherwise.

  returns: true if an only if this parameter represents a
   variable argument list. - `boolean`"
  (^Boolean [^Parameter this]
    (-> this (.isVarArgs))))

(defn get-modifiers
  "Get the modifier flags for this the parameter represented by
   this Parameter object.

  returns: The modifier flags for this parameter. - `int`"
  (^Integer [^Parameter this]
    (-> this (.getModifiers))))

(defn synthetic?
  "Returns true if this parameter is neither implicitly
   nor explicitly declared in source code; returns false
   otherwise.

  returns: true if and only if this parameter is a synthetic
   construct as defined by
   The Java™ Language Specification. - `boolean`"
  (^Boolean [^Parameter this]
    (-> this (.isSynthetic))))

(defn to-string
  "Returns a string describing this parameter.  The format is the
   modifiers for the parameter, if any, in canonical order as
   recommended by The Java™ Language
   Specification, followed by the fully- qualified type of
   the parameter (excluding the last [] if the parameter is
   variable arity), followed by \"...\" if the parameter is variable
   arity, followed by a space, followed by the name of the
   parameter.

  returns: A string representation of the parameter and associated
   information. - `java.lang.String`"
  (^java.lang.String [^Parameter this]
    (-> this (.toString))))

(defn get-annotation
  "Returns this element's annotation for the specified type if
   such an annotation is present, else null.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Parameter this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-declared-annotations
  "Returns annotations that are directly present on this element.
   This method ignores inherited annotations.

   If there are no annotations directly present on this element,
   the return value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^Parameter this]
    (-> this (.getDeclaredAnnotations))))

(defn get-name
  "Returns the name of the parameter.  If the parameter's name is
   present, then this method returns
   the name provided by the class file. Otherwise, this method
   synthesizes a name of the form argN, where N is the index of
   the parameter in the descriptor of the method which declares
   the parameter.

  returns: The name of the parameter, either provided by the class
           file or synthesized if the class file does not provide
           a name. - `java.lang.String`"
  (^java.lang.String [^Parameter this]
    (-> this (.getName))))

(defn get-annotations
  "Returns annotations that are present on this element.

   If there are no annotations present on this element, the return
   value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations present on this element - `java.lang.annotation.Annotation[]`"
  ([^Parameter this]
    (-> this (.getAnnotations))))

(defn get-parameterized-type
  "Returns a Type object that identifies the parameterized
   type for the parameter represented by this Parameter
   object.

  returns: a Type object identifying the parameterized
   type of the parameter represented by this object - `java.lang.reflect.Type`"
  (^java.lang.reflect.Type [^Parameter this]
    (-> this (.getParameterizedType))))

(defn get-annotated-type
  "Returns an AnnotatedType object that represents the use of a type to
   specify the type of the formal parameter represented by this Parameter.

  returns: an AnnotatedType object representing the use of a type
           to specify the type of the formal parameter represented by this
           Parameter - `java.lang.reflect.AnnotatedType`"
  (^java.lang.reflect.AnnotatedType [^Parameter this]
    (-> this (.getAnnotatedType))))

(defn get-declaring-executable
  "Return the Executable which declares this parameter.

  returns: The Executable declaring this parameter. - `java.lang.reflect.Executable`"
  (^java.lang.reflect.Executable [^Parameter this]
    (-> this (.getDeclaringExecutable))))

(defn implicit?
  "Returns true if this parameter is implicitly declared
   in source code; returns false otherwise.

  returns: true if and only if this parameter is implicitly
   declared as defined by The Java™ Language
   Specification. - `boolean`"
  (^Boolean [^Parameter this]
    (-> this (.isImplicit))))

(defn get-annotations-by-type
  "Returns annotations that are associated with this element.

   If there are no annotations associated with this element, the return
   value is an array of length 0.

   The difference between this method and AnnotatedElement.getAnnotation(Class)
   is that this method detects if its argument is a repeatable
   annotation type (JLS 9.6), and if so, attempts to find one or
   more annotations of that type by \"looking through\" a container
   annotation.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       associated with this element, else an array of length zero - `<T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Parameter this ^java.lang.Class annotation-class]
    (-> this (.getAnnotationsByType annotation-class))))

(defn hash-code
  "Returns a hash code based on the executable's hash code and the
   index.

  returns: A hash code based on the executable's hash code. - `int`"
  (^Integer [^Parameter this]
    (-> this (.hashCode))))

(defn equals
  "Compares based on the executable and the index.

  obj - The object to compare. - `java.lang.Object`

  returns: Whether or not this is equal to the argument. - `boolean`"
  (^Boolean [^Parameter this ^java.lang.Object obj]
    (-> this (.equals obj))))

