(ns jdk.sql.RowIdLifetime
  (:refer-clojure :only [require comment defn ->])
  (:import [java.sql RowIdLifetime]))

(def ROWID_UNSUPPORTED
  "Enum Constant.

  Indicates that this data source does not support the ROWID type.

  type: java.sql.RowIdLifetime"
  RowIdLifetime/ROWID_UNSUPPORTED)

(def ROWID_VALID_OTHER
  "Enum Constant.

  Indicates that the lifetime of a RowId from this data source is indeterminate;
   but not one of ROWID_VALID_TRANSACTION, ROWID_VALID_SESSION, or,
   ROWID_VALID_FOREVER.

  type: java.sql.RowIdLifetime"
  RowIdLifetime/ROWID_VALID_OTHER)

(def ROWID_VALID_SESSION
  "Enum Constant.

  Indicates that the lifetime of a RowId from this data source is at least the
   containing session.

  type: java.sql.RowIdLifetime"
  RowIdLifetime/ROWID_VALID_SESSION)

(def ROWID_VALID_TRANSACTION
  "Enum Constant.

  Indicates that the lifetime of a RowId from this data source is at least the
   containing transaction.

  type: java.sql.RowIdLifetime"
  RowIdLifetime/ROWID_VALID_TRANSACTION)

(def ROWID_VALID_FOREVER
  "Enum Constant.

  Indicates that the lifetime of a RowId from this data source is, effectively,
   unlimited.

  type: java.sql.RowIdLifetime"
  RowIdLifetime/ROWID_VALID_FOREVER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (RowIdLifetime c : RowIdLifetime.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.sql.RowIdLifetime[]`"
  ([]
    (RowIdLifetime/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.sql.RowIdLifetime`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.sql.RowIdLifetime [^java.lang.String name]
    (RowIdLifetime/valueOf name)))

