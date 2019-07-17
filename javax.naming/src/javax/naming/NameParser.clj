(ns javax.naming.NameParser
  "This interface is used for parsing names from a hierarchical
  namespace.  The NameParser contains knowledge of the syntactic
  information (like left-to-right orientation, name separator, etc.)
  needed to parse names.

  The equals() method, when used to compare two NameParsers, returns
  true if and only if they serve the same namespace."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming NameParser]))

(defn parse
  "Parses a name into its components.

  name - The non-null string name to parse. - `java.lang.String`

  returns: A non-null parsed form of the name using the naming convention
   of this parser. - `javax.naming.Name`

  throws: javax.naming.InvalidNameException - If name does not conform to syntax defined for the namespace."
  ([this name]
    (-> this (.parse name))))

