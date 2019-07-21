(ns jdk.lang.Package
  "Package objects contain version information
  about the implementation and specification of a Java package.
  This versioning information is retrieved and made available
  by the ClassLoader instance that
  loaded the class(es).  Typically, it is stored in the manifest that is
  distributed with the classes.

  The set of classes that make up the package may implement a
  particular specification and if so the specification title, version number,
  and vendor strings identify that specification.
  An application can ask if the package is
  compatible with a particular version, see the isCompatibleWith
  method for details.

  Specification version numbers use a syntax that consists of nonnegative
  decimal integers separated by periods \".\", for example \"2.0\" or
  \"1.2.3.4.5.6.7\".  This allows an extensible number to be used to represent
  major, minor, micro, etc. versions.  The version specification is described
  by the following formal grammar:


  SpecificationVersion:
  Digits RefinedVersionopt

  RefinedVersion:
  . Digits
  . Digits RefinedVersion

  Digits:
  Digit
  Digits

  Digit:
  any character for which Character.isDigit(char) returns true,
  e.g. 0, 1, 2, ...



  The implementation title, version, and vendor strings identify an
  implementation and are made available conveniently to enable accurate
  reporting of the packages involved when a problem occurs. The contents
  all three implementation strings are vendor specific. The
  implementation version strings have no specified syntax and should
  only be compared for equality with desired version identifiers.

  Within each ClassLoader instance all classes from the same
  java package have the same Package object.  The static methods allow a package
  to be found by name or the set of all packages known to the current class
  loader to be found."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Package]))

(defn *get-package
  "Find a package by name in the callers ClassLoader instance.
   The callers ClassLoader instance is used to find the package
   instance corresponding to the named class. If the callers
   ClassLoader instance is null then the set of packages loaded
   by the system ClassLoader instance is searched to find the
   named package.

   Packages have attributes for versions and specifications only if the class
   loader created the package instance with the appropriate attributes. Typically,
   those attributes are defined in the manifests that accompany the classes.

  name - a package name, for example, java.lang. - `java.lang.String`

  returns: the package of the requested name. It may be null if no package
            information is available from the archive or codebase. - `java.lang.Package`"
  (^java.lang.Package [^java.lang.String name]
    (Package/getPackage name)))

(defn *get-packages
  "Get all the packages currently known for the caller's ClassLoader
   instance.  Those packages correspond to classes loaded via or accessible by
   name to that ClassLoader instance.  If the caller's
   ClassLoader instance is the bootstrap ClassLoader
   instance, which may be represented by null in some implementations,
   only packages corresponding to classes loaded by the bootstrap
   ClassLoader instance will be returned.

  returns: a new array of packages known to the callers ClassLoader
   instance.  An zero length array is returned if none are known. - `java.lang.Package[]`"
  ([]
    (Package/getPackages )))

(defn get-declared-annotation
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       directly present on this element, else null - `<A extends java.lang.annotation.Annotation> A`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Package this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotation annotation-class))))

(defn get-declared-annotations-by-type
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       directly or indirectly present on this element, else an array of length zero - `<A extends java.lang.annotation.Annotation> A[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Package this ^java.lang.Class annotation-class]
    (-> this (.getDeclaredAnnotationsByType annotation-class))))

(defn to-string
  "Returns the string representation of this Package.
   Its value is the string \"package \" and the package name.
   If the package title is defined it is appended.
   If the package version is defined it is appended.

  returns: the string representation of the package. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.toString))))

(defn get-annotation
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<A extends java.lang.annotation.Annotation> A`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Package this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-declared-annotations
  "Description copied from interface: AnnotatedElement

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^Package this]
    (-> this (.getDeclaredAnnotations))))

(defn get-name
  "Return the name of this package.

  returns: The fully-qualified name of this package as defined in section 6.5.3 of
            The Java™ Language Specification,
            for example, java.lang - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getName))))

(defn get-annotations
  "Description copied from interface: AnnotatedElement

  returns: annotations present on this element - `java.lang.annotation.Annotation[]`"
  ([^Package this]
    (-> this (.getAnnotations))))

(defn get-implementation-version
  "Return the version of this implementation. It consists of any string
   assigned by the vendor of this implementation and does
   not have any particular syntax specified or expected by the Java
   runtime. It may be compared for equality with other
   package version strings used for this implementation
   by this vendor for this package.

  returns: the version of the implementation, null is returned if it is not known. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getImplementationVersion))))

(defn get-implementation-title
  "Return the title of this package.

  returns: the title of the implementation, null is returned if it is not known. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getImplementationTitle))))

(defn get-annotations-by-type
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: all this element's annotations for the specified annotation type if
       associated with this element, else an array of length zero - `<A extends java.lang.annotation.Annotation> A[]`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Package this ^java.lang.Class annotation-class]
    (-> this (.getAnnotationsByType annotation-class))))

(defn sealed?
  "Returns true if this package is sealed with respect to the specified
   code source url.

  url - the code source url - `java.net.URL`

  returns: true if this package is sealed with respect to url - `boolean`"
  (^Boolean [^Package this ^java.net.URL url]
    (-> this (.isSealed url)))
  (^Boolean [^Package this]
    (-> this (.isSealed))))

(defn get-implementation-vendor
  "Returns the name of the organization,
   vendor or company that provided this implementation.

  returns: the vendor that implemented this package.. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getImplementationVendor))))

(defn hash-code
  "Return the hash code computed from the package name.

  returns: the hash code computed from the package name. - `int`"
  (^Integer [^Package this]
    (-> this (.hashCode))))

(defn get-specification-vendor
  "Return the name of the organization, vendor,
   or company that owns and maintains the specification
   of the classes that implement this package.

  returns: the specification vendor, null is returned if it is not known. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getSpecificationVendor))))

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
  (^Boolean [^Package this ^java.lang.Class annotation-class]
    (-> this (.isAnnotationPresent annotation-class))))

(defn compatible-with?
  "Compare this package's specification version with a
   desired version. It returns true if
   this packages specification version number is greater than or equal
   to the desired version number.

   Version numbers are compared by sequentially comparing corresponding
   components of the desired and specification strings.
   Each component is converted as a decimal integer and the values
   compared.
   If the specification value is greater than the desired
   value true is returned. If the value is less false is returned.
   If the values are equal the period is skipped and the next pair of
   components is compared.

  desired - the version string of the desired version. - `java.lang.String`

  returns: true if this package's version number is greater
            than or equal to the desired version number - `boolean`

  throws: java.lang.NumberFormatException - if the desired or current version is not of the correct dotted form."
  (^Boolean [^Package this ^java.lang.String desired]
    (-> this (.isCompatibleWith desired))))

(defn get-specification-version
  "Returns the version number of the specification
   that this package implements.
   This version string must be a sequence of nonnegative decimal
   integers separated by \".\"'s and may have leading zeros.
   When version strings are compared the most significant
   numbers are compared.

  returns: the specification version, null is returned if it is not known. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getSpecificationVersion))))

(defn get-specification-title
  "Return the title of the specification that this package implements.

  returns: the specification title, null is returned if it is not known. - `java.lang.String`"
  (^java.lang.String [^Package this]
    (-> this (.getSpecificationTitle))))

