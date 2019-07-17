(ns jdk.nio.file.attribute.AclEntryFlag
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute AclEntryFlag]))

(def FILE_INHERIT
  "Enum Constant.

  Can be placed on a directory and indicates that the ACL entry should be
   added to each new non-directory file created.

  type: java.nio.file.attribute.AclEntryFlag"
  AclEntryFlag/FILE_INHERIT)

(def DIRECTORY_INHERIT
  "Enum Constant.

  Can be placed on a directory and indicates that the ACL entry should be
   added to each new directory created.

  type: java.nio.file.attribute.AclEntryFlag"
  AclEntryFlag/DIRECTORY_INHERIT)

(def NO_PROPAGATE_INHERIT
  "Enum Constant.

  Can be placed on a directory to indicate that the ACL entry should not
   be placed on the newly created directory which is inheritable by
   subdirectories of the created directory.

  type: java.nio.file.attribute.AclEntryFlag"
  AclEntryFlag/NO_PROPAGATE_INHERIT)

(def INHERIT_ONLY
  "Enum Constant.

  Can be placed on a directory but does not apply to the directory,
   only to newly created files/directories as specified by the
   FILE_INHERIT and DIRECTORY_INHERIT flags.

  type: java.nio.file.attribute.AclEntryFlag"
  AclEntryFlag/INHERIT_ONLY)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (AclEntryFlag c : AclEntryFlag.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.attribute.AclEntryFlag[]`"
  ([]
    (AclEntryFlag/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.attribute.AclEntryFlag`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (AclEntryFlag/valueOf name)))

