(ns jdk.text.Normalizer$Form
  (:refer-clojure :only [require comment defn ->])
  (:import [java.text Normalizer$Form]))

(def NFD
  "Enum Constant.

  Canonical decomposition.

  type: java.text.Normalizer$Form"
  Normalizer$Form/NFD)

(def NFC
  "Enum Constant.

  Canonical decomposition, followed by canonical composition.

  type: java.text.Normalizer$Form"
  Normalizer$Form/NFC)

(def NFKD
  "Enum Constant.

  Compatibility decomposition.

  type: java.text.Normalizer$Form"
  Normalizer$Form/NFKD)

(def NFKC
  "Enum Constant.

  Compatibility decomposition, followed by canonical composition.

  type: java.text.Normalizer$Form"
  Normalizer$Form/NFKC)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Normalizer.Form c : Normalizer.Form.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.text.Normalizer$Form[]`"
  ([]
    (Normalizer$Form/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.text.Normalizer$Form`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.text.Normalizer$Form [^java.lang.String name]
    (Normalizer$Form/valueOf name)))

