(ns javax.lang.model.type.TypeMirror
  "Represents a type in the Java programming language.
  Types include primitive types, declared types (class and interface types),
  array types, type variables, and the null type.
  Also represented are wildcard type arguments,
  the signature and return types of executables,
  and pseudo-types corresponding to packages and to the keyword void.

   Types should be compared using the utility methods in Types.  There is no guarantee that any particular type will always
  be represented by the same object.

   To implement operations based on the class of an TypeMirror object, either use a javax.lang.model.type.visitor
  or use the result of the getKind() method.  Using instanceof is not necessarily a reliable idiom for
  determining the effective class of an object in this modeling
  hierarchy since an implementation may choose to have a single
  object implement multiple TypeMirror subinterfaces."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.lang.model.type TypeMirror]))

(defn get-kind
  "Returns the kind of this type.

  returns: the kind of this type - `javax.lang.model.type.TypeKind`"
  (^javax.lang.model.type.TypeKind [^TypeMirror this]
    (-> this (.getKind))))

(defn equals
  "Obeys the general contract of Object.equals.
   This method does not, however, indicate whether two types represent
   the same type.
   Semantic comparisons of type equality should instead use
   Types.isSameType(TypeMirror, TypeMirror).
   The results of t1.equals(t2) and
   Types.isSameType(t1, t2) may differ.

  obj - the object to be compared with this type - `java.lang.Object`

  returns: true if the specified object is equal to this one - `boolean`"
  (^Boolean [^TypeMirror this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Obeys the general contract of Object.hashCode.

  returns: a hash code value for this object. - `int`"
  (^Integer [^TypeMirror this]
    (-> this (.hashCode))))

(defn to-string
  "Returns an informative string representation of this type.  If
   possible, the string should be of a form suitable for
   representing this type in source code.  Any names embedded in
   the result are qualified if possible.

  returns: a string representation of this type - `java.lang.String`"
  (^java.lang.String [^TypeMirror this]
    (-> this (.toString))))

(defn accept
  "Applies a visitor to this type.

  v - the visitor operating on this type - `javax.lang.model.type.TypeVisitor`
  p - additional parameter to the visitor - `P`

  returns: a visitor-specified result - `<R,P> R`"
  ([^TypeMirror this ^javax.lang.model.type.TypeVisitor v p]
    (-> this (.accept v p))))

