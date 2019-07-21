(ns jdk.lang.reflect.AccessibleObject
  "The AccessibleObject class is the base class for Field, Method and
  Constructor objects.  It provides the ability to flag a reflected
  object as suppressing default Java language access control checks
  when it is used.  The access checks--for public, default (package)
  access, protected, and private members--are performed when Fields,
  Methods or Constructors are used to set or get fields, to invoke
  methods, or to create and initialize new instances of classes,
  respectively.

  Setting the accessible flag in a reflected object
  permits sophisticated applications with sufficient privilege, such
  as Java Object Serialization or other persistence mechanisms, to
  manipulate objects in a manner that would normally be prohibited.

  By default, a reflected object is not accessible."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect AccessibleObject]))

(defn *set-accessible
  "Convenience method to set the accessible flag for an
   array of objects with a single security check (for efficiency).

   First, if there is a security manager, its
   checkPermission method is called with a
   ReflectPermission(\"suppressAccessChecks\") permission.

   A SecurityException is raised if flag is
   true but accessibility of any of the elements of the input
   array may not be changed (for example, if the element
   object is a Constructor object for the class Class).  In the event of such a SecurityException, the
   accessibility of objects is set to flag for array elements
   upto (and excluding) the element for which the exception occurred; the
   accessibility of elements beyond (and including) the element for which
   the exception occurred is unchanged.

  array - the array of AccessibleObjects - `java.lang.reflect.AccessibleObject[]`
  flag - the new value for the accessible flag in each object - `boolean`

  throws: java.lang.SecurityException - if the request is denied."
  ([array ^Boolean flag]
    (AccessibleObject/setAccessible array flag)))

(defn get-declared-annotation
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       directly present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AccessibleObject this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotation annotation-class))))

(defn get-declared-annotations-by-type
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       directly or indirectly present on this element, else an array of length zero - `<T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AccessibleObject this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotationsByType annotation-class))))

(defn get-annotation
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AccessibleObject this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-declared-annotations
  "Description copied from interface: AnnotatedElement

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^AccessibleObject this]
    (-> this (.getDeclaredAnnotations))))

(defn set-accessible
  "Set the accessible flag for this object to
   the indicated boolean value.  A value of true indicates that
   the reflected object should suppress Java language access
   checking when it is used.  A value of false indicates
   that the reflected object should enforce Java language access checks.

   First, if there is a security manager, its
   checkPermission method is called with a
   ReflectPermission(\"suppressAccessChecks\") permission.

   A SecurityException is raised if flag is
   true but accessibility of this object may not be changed
   (for example, if this element object is a Constructor object for
   the class Class).

   A SecurityException is raised if this object is a Constructor object for the class
   java.lang.Class, and flag is true.

  flag - the new value for the accessible flag - `boolean`

  throws: java.lang.SecurityException - if the request is denied."
  ([^AccessibleObject this ^Boolean flag]
    (-> this (.setAccessible flag))))

(defn get-annotations
  "Description copied from interface: AnnotatedElement

  returns: annotations present on this element - `java.lang.annotation.Annotation[]`"
  ([^AccessibleObject this]
    (-> this (.getAnnotations))))

(defn get-annotations-by-type
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       associated with this element, else an array of length zero - `<T extends java.lang.annotation.Annotation> T[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^AccessibleObject this ^java.lang.Class annotation-class]
    (-> this (.getAnnotationsByType annotation-class))))

(defn accessible?
  "Get the value of the accessible flag for this object.

  returns: the value of the object's accessible flag - `boolean`"
  (^Boolean [^AccessibleObject this]
    (-> this (.isAccessible))))

(defn annotation-present?
  "Returns true if an annotation for the specified type
   is present on this element, else false.  This method
   is designed primarily for convenient access to marker annotations.

   The truth value returned by this method is equivalent to:
   getAnnotation(annotationClass) != null

   The body of the default method is specified to be the code
   above.

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: true if an annotation for the specified annotation
       type is present on this element, else false - `boolean`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  (^Boolean [^AccessibleObject this ^java.lang.Class annotation-class]
    (-> this (.isAnnotationPresent annotation-class))))

