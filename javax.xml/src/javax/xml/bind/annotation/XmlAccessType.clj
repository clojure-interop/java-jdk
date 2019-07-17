(ns javax.xml.bind.annotation.XmlAccessType
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind.annotation XmlAccessType]))

(def PROPERTY
  "Enum Constant.

  Every getter/setter pair in a JAXB-bound class will be automatically
   bound to XML, unless annotated by XmlTransient.

   Fields are bound to XML only when they are explicitly annotated
   by some of the JAXB annotations.

  type: javax.xml.bind.annotation.XmlAccessType"
  XmlAccessType/PROPERTY)

(def FIELD
  "Enum Constant.

  Every non static, non transient field in a JAXB-bound class will be automatically
   bound to XML, unless annotated by XmlTransient.

   Getter/setter pairs are bound to XML only when they are explicitly annotated
   by some of the JAXB annotations.

  type: javax.xml.bind.annotation.XmlAccessType"
  XmlAccessType/FIELD)

(def PUBLIC_MEMBER
  "Enum Constant.

  Every public getter/setter pair and every public field will be
   automatically bound to XML, unless annotated by XmlTransient.

   Fields or getter/setter pairs that are private, protected, or
   defaulted to package-only access are bound to XML only when they are
   explicitly annotated by the appropriate JAXB annotations.

  type: javax.xml.bind.annotation.XmlAccessType"
  XmlAccessType/PUBLIC_MEMBER)

(def NONE
  "Enum Constant.

  None of the fields or properties is bound to XML unless they
   are specifically  annotated with some of the JAXB annotations.

  type: javax.xml.bind.annotation.XmlAccessType"
  XmlAccessType/NONE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (XmlAccessType c : XmlAccessType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.xml.bind.annotation.XmlAccessType[]`"
  ([]
    (XmlAccessType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.xml.bind.annotation.XmlAccessType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (XmlAccessType/valueOf name)))

