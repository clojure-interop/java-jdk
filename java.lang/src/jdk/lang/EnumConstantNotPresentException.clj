(ns jdk.lang.EnumConstantNotPresentException
  "Thrown when an application tries to access an enum constant by name
  and the enum type contains no constant with the specified name.
  This exception can be thrown by the java.lang.reflect.API used to read annotations
  reflectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang EnumConstantNotPresentException]))

(defn ->enum-constant-not-present-exception
  "Constructor.

  Constructs an EnumConstantNotPresentException for the
   specified constant.

  enum-type - the type of the missing enum constant - `java.lang.Enum>`
  constant-name - the name of the missing enum constant - `java.lang.String`"
  ([^java.lang.Enum> enum-type ^java.lang.String constant-name]
    (new EnumConstantNotPresentException enum-type constant-name)))

(defn enum-type
  "Returns the type of the missing enum constant.

  returns: the type of the missing enum constant - `java.lang.Class<? extends java.lang.Enum>`"
  ([^java.lang.EnumConstantNotPresentException this]
    (-> this (.enumType))))

(defn constant-name
  "Returns the name of the missing enum constant.

  returns: the name of the missing enum constant - `java.lang.String`"
  ([^java.lang.EnumConstantNotPresentException this]
    (-> this (.constantName))))

