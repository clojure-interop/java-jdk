(ns jdk.sql.PseudoColumnUsage
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql PseudoColumnUsage]))

(def SELECT_LIST_ONLY
  "Enum Constant.

  The pseudo/hidden column may only be used in a SELECT list.

  type: java.sql.PseudoColumnUsage"
  PseudoColumnUsage/SELECT_LIST_ONLY)

(def WHERE_CLAUSE_ONLY
  "Enum Constant.

  The pseudo/hidden column may only be used in a WHERE clause.

  type: java.sql.PseudoColumnUsage"
  PseudoColumnUsage/WHERE_CLAUSE_ONLY)

(def NO_USAGE_RESTRICTIONS
  "Enum Constant.

  There are no restrictions on the usage of the pseudo/hidden columns.

  type: java.sql.PseudoColumnUsage"
  PseudoColumnUsage/NO_USAGE_RESTRICTIONS)

(def USAGE_UNKNOWN
  "Enum Constant.

  The usage of the pseudo/hidden column cannot be determined.

  type: java.sql.PseudoColumnUsage"
  PseudoColumnUsage/USAGE_UNKNOWN)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (PseudoColumnUsage c : PseudoColumnUsage.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.sql.PseudoColumnUsage[]`"
  ([]
    (PseudoColumnUsage/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.sql.PseudoColumnUsage`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.sql.PseudoColumnUsage [^java.lang.String name]
    (PseudoColumnUsage/valueOf name)))

