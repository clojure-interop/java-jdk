(ns jdk.awt.TrayIcon$MessageType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt TrayIcon$MessageType]))

(def ERROR
  "Enum Constant.

  An error message

  type: java.awt.TrayIcon.MessageType"
  TrayIcon$MessageType/ERROR)

(def WARNING
  "Enum Constant.

  A warning message

  type: java.awt.TrayIcon.MessageType"
  TrayIcon$MessageType/WARNING)

(def INFO
  "Enum Constant.

  An information message

  type: java.awt.TrayIcon.MessageType"
  TrayIcon$MessageType/INFO)

(def NONE
  "Enum Constant.

  Simple message

  type: java.awt.TrayIcon.MessageType"
  TrayIcon$MessageType/NONE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (TrayIcon.MessageType c : TrayIcon.MessageType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.TrayIcon.MessageType[]`"
  ([]
    (TrayIcon$MessageType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.TrayIcon.MessageType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.awt.TrayIcon.MessageType [^java.lang.String name]
    (TrayIcon$MessageType/valueOf name)))

