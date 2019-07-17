(ns jdk.lang.reflect.Member
  "Member is an interface that reflects identifying information about
  a single member (a field or a method) or a constructor."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang.reflect Member]))

(defn get-declaring-class
  "Returns the Class object representing the class or interface
   that declares the member or constructor represented by this Member.

  returns: an object representing the declaring class of the
   underlying member - `java.lang.Class<?>`"
  ([this]
    (-> this (.getDeclaringClass))))

(defn get-name
  "Returns the simple name of the underlying member or constructor
   represented by this Member.

  returns: the simple name of the underlying member - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn get-modifiers
  "Returns the Java language modifiers for the member or
   constructor represented by this Member, as an integer.  The
   Modifier class should be used to decode the modifiers in
   the integer.

  returns: the Java language modifiers for the underlying member - `int`"
  ([this]
    (-> this (.getModifiers))))

(defn synthetic?
  "Returns true if this member was introduced by
   the compiler; returns false otherwise.

  returns: true if and only if this member was introduced by
   the compiler. - `boolean`"
  ([this]
    (-> this (.isSynthetic))))

