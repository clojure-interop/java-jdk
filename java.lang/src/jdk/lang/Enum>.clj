(ns jdk.lang.Enum>
  "This is the common base class of all Java language enumeration types.

  More information about enums, including descriptions of the
  implicitly declared methods synthesized by the compiler, can be
  found in section 8.9 of
  The Java™ Language Specification.

   Note that when using an enumeration type as the type of a set
  or as the type of the keys in a map, specialized and efficient
  java.util.set and java.util.map implementations are available."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang Enum>]))

(defn *value-of
  "Returns the enum constant of the specified enum type with the
   specified name.  The name must match exactly an identifier used
   to declare an enum constant in this type.  (Extraneous whitespace
   characters are not permitted.)

   Note that for a particular enum type T, the
   implicitly declared public static T valueOf(String)
   method on that enum may be used instead of this method to map
   from a name to the corresponding enum constant.  All the
   constants of an enum type can be obtained by calling the
   implicit public static T[] values() method of that
   type.

  enum-type - the Class object of the enum type from which to return a constant - `java.lang.Class<T>`
  name - the name of the constant to return - `java.lang.String`

  returns: the enum constant of the specified enum type with the
        specified name - `<T extends java.lang.Enum<T>> T`

  throws: java.lang.IllegalArgumentException - if the specified enum type has no constant with the specified name, or the specified class object does not represent an enum type"
  ([^java.lang.Class enum-type ^java.lang.String name]
    (Enum>/valueOf enum-type name)))

(defn name
  "Returns the name of this enum constant, exactly as declared in its
   enum declaration.

   Most programmers should use the toString() method in
   preference to this one, as the toString method may return
   a more user-friendly name.  This method is designed primarily for
   use in specialized situations where correctness depends on getting the
   exact name, which will not vary from release to release.

  returns: the name of this enum constant - `java.lang.String`"
  ([^java.lang.Enum> this]
    (-> this (.name))))

(defn ordinal
  "Returns the ordinal of this enumeration constant (its position
   in its enum declaration, where the initial constant is assigned
   an ordinal of zero).

   Most programmers will have no use for this method.  It is
   designed for use by sophisticated enum-based data structures, such
   as EnumSet and EnumMap.

  returns: the ordinal of this enumeration constant - `int`"
  ([^java.lang.Enum> this]
    (-> this (.ordinal))))

(defn to-string
  "Returns the name of this enum constant, as contained in the
   declaration.  This method may be overridden, though it typically
   isn't necessary or desirable.  An enum type should override this
   method when a more `programmer-friendly` string form exists.

  returns: the name of this enum constant - `java.lang.String`"
  ([^java.lang.Enum> this]
    (-> this (.toString))))

(defn equals
  "Returns true if the specified object is equal to this
   enum constant.

  other - the object to be compared for equality with this object. - `java.lang.Object`

  returns: true if the specified object is equal to this
            enum constant. - `boolean`"
  ([^java.lang.Enum> this ^java.lang.Object other]
    (-> this (.equals other))))

(defn hash-code
  "Returns a hash code for this enum constant.

  returns: a hash code for this enum constant. - `int`"
  ([^java.lang.Enum> this]
    (-> this (.hashCode))))

(defn compare-to
  "Compares this enum with the specified object for order.  Returns a
   negative integer, zero, or a positive integer as this object is less
   than, equal to, or greater than the specified object.

   Enum constants are only comparable to other enum constants of the
   same enum type.  The natural order implemented by this
   method is the order in which the constants are declared.

  o - the object to be compared. - `Enum.E`

  returns: a negative integer, zero, or a positive integer as this object
            is less than, equal to, or greater than the specified object. - `int`"
  ([^java.lang.Enum> this ^Enum.E o]
    (-> this (.compareTo o))))

(defn get-declaring-class
  "Returns the Class object corresponding to this enum constant's
   enum type.  Two enum constants e1 and  e2 are of the
   same enum type if and only if
     e1.getDeclaringClass() == e2.getDeclaringClass().
   (The value returned by this method may differ from the one returned
   by the Object.getClass() method for enum constants with
   constant-specific class bodies.)

  returns: the Class object corresponding to this enum constant's
       enum type - `java.lang.Class<Enum.E>`"
  ([^java.lang.Enum> this]
    (-> this (.getDeclaringClass))))

