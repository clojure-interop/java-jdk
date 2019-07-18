(ns jdk.lang.reflect.AnnotatedElement
  "Represents an annotated element of the program currently running in this
  VM.  This interface allows annotations to be read reflectively.  All
  annotations returned by methods in this interface are immutable and
  serializable. The arrays returned by methods of this interface may be modified
  by callers without affecting the arrays returned to other callers.

  The getAnnotationsByType(Class) and getDeclaredAnnotationsByType(Class) methods support multiple
  annotations of the same type on an element. If the argument to
  either method is a repeatable annotation type (JLS 9.6), then the
  method will `look through` a container annotation (JLS 9.7), if
  present, and return any annotations inside the container. Container
  annotations may be generated at compile-time to wrap multiple
  annotations of the argument type.

  The terms directly present, indirectly present,
  present, and associated are used throughout this
  interface to describe precisely which annotations are returned by
  methods:



   An annotation A is directly present on an
  element E if E has a RuntimeVisibleAnnotations or RuntimeVisibleParameterAnnotations or RuntimeVisibleTypeAnnotations attribute, and the attribute
  contains A.

  An annotation A is indirectly present on an
  element E if E has a RuntimeVisibleAnnotations or
  RuntimeVisibleParameterAnnotations or RuntimeVisibleTypeAnnotations
  attribute, and A 's type is repeatable, and the attribute contains
  exactly one annotation whose value element contains A and whose
  type is the containing annotation type of A 's type.

  An annotation A is present on an element E if either:



  A is directly present on E; or

  No annotation of A 's type is directly present on
  E, and E is a class, and A 's type is
  inheritable, and A is present on the superclass of E.



  An annotation A is associated with an element E
  if either:



  A is directly or indirectly present on E; or

  No annotation of A 's type is directly or indirectly
  present on E, and E is a class, and A's type
  is inheritable, and A is associated with the superclass of
  E.





  The table below summarizes which kind of annotation presence
  different methods in this interface examine.


  Overview of kind of presence detected by different AnnotatedElement methods
  Kind of Presence
  MethodDirectly PresentIndirectly PresentPresentAssociated
  TgetAnnotation(Class<T>)
  X

  Annotation[]getAnnotations()
  X

  T[]getAnnotationsByType(Class<T>)
  X

  TgetDeclaredAnnotation(Class<T>)
  X

  Annotation[]getDeclaredAnnotations()
  X

  T[]getDeclaredAnnotationsByType(Class<T>)
  XX



  For an invocation of get[Declared]AnnotationsByType( Class <
  T >), the order of annotations which are directly or indirectly
  present on an element E is computed as if indirectly present
  annotations on E are directly present on E in place
  of their container annotation, in the order in which they appear in
  the value element of the container annotation.

  There are several compatibility concerns to keep in mind if an
  annotation type T is originally not repeatable and
  later modified to be repeatable.

  The containing annotation type for T is TC.



  Modifying T to be repeatable is source and binary
  compatible with existing uses of T and with existing uses
  of TC.

  That is, for source compatibility, source code with annotations of
  type T or of type TC will still compile. For binary
  compatibility, class files with annotations of type T or of
  type TC (or with other kinds of uses of type T or of
  type TC) will link against the modified version of T
  if they linked against the earlier version.

  (An annotation type TC may informally serve as an acting
  containing annotation type before T is modified to be
  formally repeatable. Alternatively, when T is made
  repeatable, TC can be introduced as a new type.)

  If an annotation type TC is present on an element, and
  T is modified to be repeatable with TC as its
  containing annotation type then:



  The change to T is behaviorally compatible with respect
  to the get[Declared]Annotation(Class<T>) (called with an
  argument of T or TC) and get[Declared]Annotations() methods because the results of the
  methods will not change due to TC becoming the containing
  annotation type for T.

  The change to T changes the results of the get[Declared]AnnotationsByType(Class<T>) methods called with an
  argument of T, because those methods will now recognize an
  annotation of type TC as a container annotation for T
  and will `look through` it to expose annotations of type T.



  If an annotation of type T is present on an
  element and T is made repeatable and more annotations of
  type T are added to the element:



   The addition of the annotations of type T is both
  source compatible and binary compatible.

  The addition of the annotations of type T changes the results
  of the get[Declared]Annotation(Class<T>) methods and get[Declared]Annotations() methods, because those methods will now
  only see a container annotation on the element and not see an
  annotation of type T.

  The addition of the annotations of type T changes the
  results of the get[Declared]AnnotationsByType(Class<T>)
  methods, because their results will expose the additional
  annotations of type T whereas previously they exposed only a
  single annotation of type T.





  If an annotation returned by a method in this interface contains
  (directly or indirectly) a Class-valued member referring to
  a class that is not accessible in this VM, attempting to read the class
  by calling the relevant Class-returning method on the returned annotation
  will result in a TypeNotPresentException.

  Similarly, attempting to read an enum-valued member will result in
  a EnumConstantNotPresentException if the enum constant in the
  annotation is no longer present in the enum type.

  If an annotation type T is (meta-)annotated with an
  @Repeatable annotation whose value element indicates a type
  TC, but TC does not declare a value() method
  with a return type of T[], then an exception of type
  AnnotationFormatError is thrown.

  Finally, attempting to read a member whose definition has evolved
  incompatibly will result in a AnnotationTypeMismatchException or an
  IncompleteAnnotationException."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AnnotatedElement]))

(defn is-annotation-present
  "Returns true if an annotation for the specified type
   is present on this element, else false.  This method
   is designed primarily for convenient access to marker annotations.

   The truth value returned by this method is equivalent to:
   getAnnotation(annotationClass) != null

   The body of the default method is specified to be the code
   above.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: true if an annotation for the specified annotation
       type is present on this element, else false - `default boolean`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AnnotatedElement this ^java.lang.Class annotation-class]
    (-> this (.isAnnotationPresent annotation-class))))

(defn get-annotation
  "Returns this element's annotation for the specified type if
   such an annotation is present, else null.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AnnotatedElement this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-annotations
  "Returns annotations that are present on this element.

   If there are no annotations present on this element, the return
   value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations present on this element - `java.lang.annotation.Annotation[]`"
  ([^AnnotatedElement this]
    (-> this (.getAnnotations))))

(defn get-annotations-by-type
  "Returns annotations that are associated with this element.

   If there are no annotations associated with this element, the return
   value is an array of length 0.

   The difference between this method and getAnnotation(Class)
   is that this method detects if its argument is a repeatable
   annotation type (JLS 9.6), and if so, attempts to find one or
   more annotations of that type by `looking through` a container
   annotation.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       associated with this element, else an array of length zero - `default <T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AnnotatedElement this ^java.lang.Class annotation-class]
    (-> this (.getAnnotationsByType annotation-class))))

(defn get-declared-annotation
  "Returns this element's annotation for the specified type if
   such an annotation is directly present, else null.

   This method ignores inherited annotations. (Returns null if no
   annotations are directly present on this element.)

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       directly present on this element, else null - `default <T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AnnotatedElement this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotation annotation-class))))

(defn get-declared-annotations-by-type
  "Returns this element's annotation(s) for the specified type if
   such annotations are either directly present or
   indirectly present. This method ignores inherited
   annotations.

   If there are no specified annotations directly or indirectly
   present on this element, the return value is an array of length
   0.

   The difference between this method and getDeclaredAnnotation(Class) is that this method detects if its
   argument is a repeatable annotation type (JLS 9.6), and if so,
   attempts to find one or more annotations of that type by `looking
   through` a container annotation if one is present.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       directly or indirectly present on this element, else an array of length zero - `default <T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AnnotatedElement this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotationsByType annotation-class))))

(defn get-declared-annotations
  "Returns annotations that are directly present on this element.
   This method ignores inherited annotations.

   If there are no annotations directly present on this element,
   the return value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^AnnotatedElement this]
    (-> this (.getDeclaredAnnotations))))

