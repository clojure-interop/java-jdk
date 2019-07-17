(ns javax.xml.bind.annotation.XmlAccessOrder
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation XmlAccessOrder]))

(def UNDEFINED
  "Enum Constant.

  The ordering of fields and properties in a class is undefined.

  type: javax.xml.bind.annotation.XmlAccessOrder"
  XmlAccessOrder/UNDEFINED)

(def ALPHABETICAL
  "Enum Constant.

  The ordering of fields and properties in a class is in
   alphabetical order as determined by the
   method java.lang.String.compareTo(String anotherString).

  type: javax.xml.bind.annotation.XmlAccessOrder"
  XmlAccessOrder/ALPHABETICAL)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (XmlAccessOrder c : XmlAccessOrder.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.xml.bind.annotation.XmlAccessOrder[]`"
  ([]
    (XmlAccessOrder/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.xml.bind.annotation.XmlAccessOrder`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.xml.bind.annotation.XmlAccessOrder [^java.lang.String name]
    (XmlAccessOrder/valueOf name)))

