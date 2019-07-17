(ns jdk.security.spec.ECGenParameterSpec
  "This immutable class specifies the set of parameters used for
  generating elliptic curve (EC) domain parameters."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.security.spec ECGenParameterSpec]))

(defn ->ec-gen-parameter-spec
  "Constructor.

  Creates a parameter specification for EC parameter
   generation using a standard (or predefined) name
   stdName in order to generate the corresponding
   (precomputed) elliptic curve domain parameters. For the
   list of supported names, please consult the documentation
   of provider whose implementation will be used.

  std-name - the standard name of the to-be-generated EC domain parameters. - `java.lang.String`

  throws: java.lang.NullPointerException - if stdName is null."
  ([std-name]
    (new ECGenParameterSpec std-name)))

(defn get-name
  "Returns the standard or predefined name of the
   to-be-generated EC domain parameters.

  returns: the standard or predefined name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

