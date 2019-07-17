(ns javax.xml.bind.annotation.XmlNsForm
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation XmlNsForm]))

(def UNQUALIFIED
  "Enum Constant.

  type: javax.xml.bind.annotation.XmlNsForm"
  XmlNsForm/UNQUALIFIED)

(def QUALIFIED
  "Enum Constant.

  type: javax.xml.bind.annotation.XmlNsForm"
  XmlNsForm/QUALIFIED)

(def UNSET
  "Enum Constant.

  type: javax.xml.bind.annotation.XmlNsForm"
  XmlNsForm/UNSET)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (XmlNsForm c : XmlNsForm.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.xml.bind.annotation.XmlNsForm[]`"
  ([]
    (XmlNsForm/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.xml.bind.annotation.XmlNsForm`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.xml.bind.annotation.XmlNsForm [^java.lang.String name]
    (XmlNsForm/valueOf name)))

