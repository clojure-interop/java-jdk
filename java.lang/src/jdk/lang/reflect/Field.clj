(ns jdk.lang.reflect.Field
  "A Field provides information about, and dynamic access to, a
  single field of a class or an interface.  The reflected field may
  be a class (static) field or an instance field.

  A Field permits widening conversions to occur during a get or
  set access operation, but throws an IllegalArgumentException if a
  narrowing conversion would occur."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Field]))

(defn enum-constant?
  "Returns true if this field represents an element of
   an enumerated type; returns false otherwise.

  returns: true if and only if this field represents an element of
   an enumerated type. - `boolean`"
  (^Boolean [^Field this]
    (-> this (.isEnumConstant))))

(defn get-byte
  "Gets the value of a static or instance byte field.

  obj - the object to extract the byte value from - `java.lang.Object`

  returns: the value of the byte field - `byte`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Byte [^Field this ^java.lang.Object obj]
    (-> this (.getByte obj))))

(defn set-boolean
  "Sets the value of a field as a boolean on the specified object.
   This method is equivalent to
   set(obj, zObj),
   where zObj is a Boolean object and
   zObj.booleanValue() == z.

  obj - the object whose field should be modified - `java.lang.Object`
  z - the new value for the field of obj being modified - `boolean`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Boolean z]
    (-> this (.setBoolean obj z))))

(defn get-type
  "Returns a Class object that identifies the
   declared type for the field represented by this
   Field object.

  returns: a Class object identifying the declared
   type of the field represented by this object - `java.lang.Class<?>`"
  (^java.lang.Class [^Field this]
    (-> this (.getType))))

(defn to-generic-string
  "Returns a string describing this Field, including
   its generic type.  The format is the access modifiers for the
   field, if any, followed by the generic field type, followed by
   a space, followed by the fully-qualified name of the class
   declaring the field, followed by a period, followed by the name
   of the field.

   The modifiers are placed in canonical order as specified by
   \"The Java Language Specification\".  This is public,
   protected or private first, and then other
   modifiers in the following order: static, final,
   transient, volatile.

  returns: a string describing this Field, including
   its generic type - `java.lang.String`"
  (^java.lang.String [^Field this]
    (-> this (.toGenericString))))

(defn get-modifiers
  "Returns the Java language modifiers for the field represented
   by this Field object, as an integer. The Modifier class should
   be used to decode the modifiers.

  returns: the Java language modifiers for the underlying member - `int`"
  (^Integer [^Field this]
    (-> this (.getModifiers))))

(defn get-short
  "Gets the value of a static or instance field of type
   short or of another primitive type convertible to
   type short via a widening conversion.

  obj - the object to extract the short value from - `java.lang.Object`

  returns: the value of the field converted to type short - `short`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Short [^Field this ^java.lang.Object obj]
    (-> this (.getShort obj))))

(defn synthetic?
  "Returns true if this field is a synthetic
   field; returns false otherwise.

  returns: true if and only if this field is a synthetic
   field as defined by the Java Language Specification. - `boolean`"
  (^Boolean [^Field this]
    (-> this (.isSynthetic))))

(defn to-string
  "Returns a string describing this Field.  The format is
   the access modifiers for the field, if any, followed
   by the field type, followed by a space, followed by
   the fully-qualified name of the class declaring the field,
   followed by a period, followed by the name of the field.
   For example:


      public static final int java.lang.Thread.MIN_PRIORITY
      private int java.io.FileDescriptor.fd

   The modifiers are placed in canonical order as specified by
   \"The Java Language Specification\".  This is public,
   protected or private first, and then other
   modifiers in the following order: static, final,
   transient, volatile.

  returns: a string describing this Field - `java.lang.String`"
  (^java.lang.String [^Field this]
    (-> this (.toString))))

(defn get-annotation
  "Description copied from interface: AnnotatedElement

  annotation-class - the Class object corresponding to the annotation type - `java.lang.Class`

  returns: this element's annotation for the specified annotation type if
       present on this element, else null - `<T extends java.lang.annotation.Annotation> T`

  throws: java.lang.NullPointerException - if the given annotation class is null"
  ([^Field this ^java.lang.Class annotation-class]
    (-> this (.getAnnotation annotation-class))))

(defn get-declared-annotations
  "Returns annotations that are directly present on this element.
   This method ignores inherited annotations.

   If there are no annotations directly present on this element,
   the return value is an array of length 0.

   The caller of this method is free to modify the returned array; it will
   have no effect on the arrays returned to other callers.

  returns: annotations directly present on this element - `java.lang.annotation.Annotation[]`"
  ([^Field this]
    (-> this (.getDeclaredAnnotations))))

(defn get-name
  "Returns the name of the field represented by this Field object.

  returns: the simple name of the underlying member - `java.lang.String`"
  (^java.lang.String [^Field this]
    (-> this (.getName))))

(defn get-long
  "Gets the value of a static or instance field of type
   long or of another primitive type convertible to
   type long via a widening conversion.

  obj - the object to extract the long value from - `java.lang.Object`

  returns: the value of the field converted to type long - `long`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Long [^Field this ^java.lang.Object obj]
    (-> this (.getLong obj))))

(defn set-double
  "Sets the value of a field as a double on the specified object.
   This method is equivalent to
   set(obj, dObj),
   where dObj is a Double object and
   dObj.doubleValue() == d.

  obj - the object whose field should be modified - `java.lang.Object`
  d - the new value for the field of obj being modified - `double`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Double d]
    (-> this (.setDouble obj d))))

(defn get-int
  "Gets the value of a static or instance field of type
   int or of another primitive type convertible to
   type int via a widening conversion.

  obj - the object to extract the int value from - `java.lang.Object`

  returns: the value of the field converted to type int - `int`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Integer [^Field this ^java.lang.Object obj]
    (-> this (.getInt obj))))

(defn get-annotated-type
  "Returns an AnnotatedType object that represents the use of a type to specify
   the declared type of the field represented by this Field.

  returns: an object representing the declared type of the field
   represented by this Field - `java.lang.reflect.AnnotatedType`"
  (^java.lang.reflect.AnnotatedType [^Field this]
    (-> this (.getAnnotatedType))))

(defn set-long
  "Sets the value of a field as a long on the specified object.
   This method is equivalent to
   set(obj, lObj),
   where lObj is a Long object and
   lObj.longValue() == l.

  obj - the object whose field should be modified - `java.lang.Object`
  l - the new value for the field of obj being modified - `long`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Long l]
    (-> this (.setLong obj l))))

(defn get-char
  "Gets the value of a static or instance field of type
   char or of another primitive type convertible to
   type char via a widening conversion.

  obj - the object to extract the char value from - `java.lang.Object`

  returns: the value of the field converted to type char - `char`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Character [^Field this ^java.lang.Object obj]
    (-> this (.getChar obj))))

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
  ([^Field this ^java.lang.Class annotation-class]
    (-> this (.getAnnotationsByType annotation-class))))

(defn set-byte
  "Sets the value of a field as a byte on the specified object.
   This method is equivalent to
   set(obj, bObj),
   where bObj is a Byte object and
   bObj.byteValue() == b.

  obj - the object whose field should be modified - `java.lang.Object`
  b - the new value for the field of obj being modified - `byte`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Byte b]
    (-> this (.setByte obj b))))

(defn get-declaring-class
  "Returns the Class object representing the class or interface
   that declares the field represented by this Field object.

  returns: an object representing the declaring class of the
   underlying member - `java.lang.Class<?>`"
  (^java.lang.Class [^Field this]
    (-> this (.getDeclaringClass))))

(defn set-short
  "Sets the value of a field as a short on the specified object.
   This method is equivalent to
   set(obj, sObj),
   where sObj is a Short object and
   sObj.shortValue() == s.

  obj - the object whose field should be modified - `java.lang.Object`
  s - the new value for the field of obj being modified - `short`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Short s]
    (-> this (.setShort obj s))))

(defn set-int
  "Sets the value of a field as an int on the specified object.
   This method is equivalent to
   set(obj, iObj),
   where iObj is a Integer object and
   iObj.intValue() == i.

  obj - the object whose field should be modified - `java.lang.Object`
  i - the new value for the field of obj being modified - `int`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Integer i]
    (-> this (.setInt obj i))))

(defn get-generic-type
  "Returns a Type object that represents the declared type for
   the field represented by this Field object.

   If the Type is a parameterized type, the
   Type object returned must accurately reflect the
   actual type parameters used in the source code.

   If the type of the underlying field is a type variable or a
   parameterized type, it is created. Otherwise, it is resolved.

  returns: a Type object that represents the declared type for
       the field represented by this Field object - `java.lang.reflect.Type`

  throws: java.lang.reflect.GenericSignatureFormatError - if the generic field signature does not conform to the format specified in The Java™ Virtual Machine Specification"
  (^java.lang.reflect.Type [^Field this]
    (-> this (.getGenericType))))

(defn hash-code
  "Returns a hashcode for this Field.  This is computed as the
   exclusive-or of the hashcodes for the underlying field's
   declaring class name and its name.

  returns: a hash code value for this object. - `int`"
  (^Integer [^Field this]
    (-> this (.hashCode))))

(defn set
  "Sets the field represented by this Field object on the
   specified object argument to the specified new value. The new
   value is automatically unwrapped if the underlying field has a
   primitive type.

   The operation proceeds as follows:

   If the underlying field is static, the obj argument is
   ignored; it may be null.

   Otherwise the underlying field is an instance field.  If the
   specified object argument is null, the method throws a
   NullPointerException.  If the specified object argument is not
   an instance of the class or interface declaring the underlying
   field, the method throws an IllegalArgumentException.

   If this Field object is enforcing Java language access control, and
   the underlying field is inaccessible, the method throws an
   IllegalAccessException.

   If the underlying field is final, the method throws an
   IllegalAccessException unless setAccessible(true)
   has succeeded for this Field object
   and the field is non-static. Setting a final field in this way
   is meaningful only during deserialization or reconstruction of
   instances of classes with blank final fields, before they are
   made available for access by other parts of a program. Use in
   any other context may have unpredictable effects, including cases
   in which other parts of a program continue to use the original
   value of this field.

   If the underlying field is of a primitive type, an unwrapping
   conversion is attempted to convert the new value to a value of
   a primitive type.  If this attempt fails, the method throws an
   IllegalArgumentException.

   If, after possible unwrapping, the new value cannot be
   converted to the type of the underlying field by an identity or
   widening conversion, the method throws an
   IllegalArgumentException.

   If the underlying field is static, the class that declared the
   field is initialized if it has not already been initialized.

   The field is set to the possibly unwrapped and widened new value.

   If the field is hidden in the type of obj,
   the field's value is set according to the preceding rules.

  obj - the object whose field should be modified - `java.lang.Object`
  value - the new value for the field of obj being modified - `java.lang.Object`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^java.lang.Object value]
    (-> this (.set obj value))))

(defn get-boolean?
  "Gets the value of a static or instance boolean field.

  obj - the object to extract the boolean value from - `java.lang.Object`

  returns: the value of the boolean field - `boolean`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Boolean [^Field this ^java.lang.Object obj]
    (-> this (.getBoolean obj))))

(defn get-float
  "Gets the value of a static or instance field of type
   float or of another primitive type convertible to
   type float via a widening conversion.

  obj - the object to extract the float value from - `java.lang.Object`

  returns: the value of the field converted to type float - `float`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Float [^Field this ^java.lang.Object obj]
    (-> this (.getFloat obj))))

(defn get-double
  "Gets the value of a static or instance field of type
   double or of another primitive type convertible to
   type double via a widening conversion.

  obj - the object to extract the double value from - `java.lang.Object`

  returns: the value of the field converted to type double - `double`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^Double [^Field this ^java.lang.Object obj]
    (-> this (.getDouble obj))))

(defn get
  "Returns the value of the field represented by this Field, on
   the specified object. The value is automatically wrapped in an
   object if it has a primitive type.

   The underlying field's value is obtained as follows:

   If the underlying field is a static field, the obj argument
   is ignored; it may be null.

   Otherwise, the underlying field is an instance field.  If the
   specified obj argument is null, the method throws a
   NullPointerException. If the specified object is not an
   instance of the class or interface declaring the underlying
   field, the method throws an IllegalArgumentException.

   If this Field object is enforcing Java language access control, and
   the underlying field is inaccessible, the method throws an
   IllegalAccessException.
   If the underlying field is static, the class that declared the
   field is initialized if it has not already been initialized.

   Otherwise, the value is retrieved from the underlying instance
   or static field.  If the field has a primitive type, the value
   is wrapped in an object before being returned, otherwise it is
   returned as is.

   If the field is hidden in the type of obj,
   the field's value is obtained according to the preceding rules.

  obj - object from which the represented field's value is to be extracted - `java.lang.Object`

  returns: the value of the represented field in object
   obj; primitive values are wrapped in an appropriate
   object before being returned - `java.lang.Object`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is inaccessible."
  (^java.lang.Object [^Field this ^java.lang.Object obj]
    (-> this (.get obj))))

(defn equals
  "Compares this Field against the specified object.  Returns
   true if the objects are the same.  Two Field objects are the same if
   they were declared by the same class and have the same name
   and type.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  (^Boolean [^Field this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn set-float
  "Sets the value of a field as a float on the specified object.
   This method is equivalent to
   set(obj, fObj),
   where fObj is a Float object and
   fObj.floatValue() == f.

  obj - the object whose field should be modified - `java.lang.Object`
  f - the new value for the field of obj being modified - `float`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Float f]
    (-> this (.setFloat obj f))))

(defn set-char
  "Sets the value of a field as a char on the specified object.
   This method is equivalent to
   set(obj, cObj),
   where cObj is a Character object and
   cObj.charValue() == c.

  obj - the object whose field should be modified - `java.lang.Object`
  c - the new value for the field of obj being modified - `char`

  throws: java.lang.IllegalAccessException - if this Field object is enforcing Java language access control and the underlying field is either inaccessible or final."
  ([^Field this ^java.lang.Object obj ^Character c]
    (-> this (.setChar obj c))))

