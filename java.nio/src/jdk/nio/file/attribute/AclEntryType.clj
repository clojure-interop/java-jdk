(ns jdk.nio.file.attribute.AclEntryType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute AclEntryType]))

(def ALLOW
  "Enum Constant.

  Explicitly grants access to a file or directory.

  type: java.nio.file.attribute.AclEntryType"
  AclEntryType/ALLOW)

(def DENY
  "Enum Constant.

  Explicitly denies access to a file or directory.

  type: java.nio.file.attribute.AclEntryType"
  AclEntryType/DENY)

(def AUDIT
  "Enum Constant.

  Log, in a system dependent way, the access specified in the
   permissions component of the ACL entry.

  type: java.nio.file.attribute.AclEntryType"
  AclEntryType/AUDIT)

(def ALARM
  "Enum Constant.

  Generate an alarm, in a system dependent way, the access specified in the
   permissions component of the ACL entry.

  type: java.nio.file.attribute.AclEntryType"
  AclEntryType/ALARM)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (AclEntryType c : AclEntryType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.attribute.AclEntryType[]`"
  ([]
    (AclEntryType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.attribute.AclEntryType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (AclEntryType/valueOf name)))

