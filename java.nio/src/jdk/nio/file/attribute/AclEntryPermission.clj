(ns jdk.nio.file.attribute.AclEntryPermission
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute AclEntryPermission]))

(def READ_DATA
  "Enum Constant.

  Permission to read the data of the file.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/READ_DATA)

(def WRITE_DATA
  "Enum Constant.

  Permission to modify the file's data.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/WRITE_DATA)

(def APPEND_DATA
  "Enum Constant.

  Permission to append data to a file.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/APPEND_DATA)

(def READ_NAMED_ATTRS
  "Enum Constant.

  Permission to read the named attributes of a file.

    RFC 3530: Network
   File System (NFS) version 4 Protocol defines named attributes
   as opaque files associated with a file in the file system.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/READ_NAMED_ATTRS)

(def WRITE_NAMED_ATTRS
  "Enum Constant.

  Permission to write the named attributes of a file.

    RFC 3530: Network
   File System (NFS) version 4 Protocol defines named attributes
   as opaque files associated with a file in the file system.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/WRITE_NAMED_ATTRS)

(def EXECUTE
  "Enum Constant.

  Permission to execute a file.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/EXECUTE)

(def DELETE_CHILD
  "Enum Constant.

  Permission to delete a file or directory within a directory.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/DELETE_CHILD)

(def READ_ATTRIBUTES
  "Enum Constant.

  The ability to read (non-acl) file attributes.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/READ_ATTRIBUTES)

(def WRITE_ATTRIBUTES
  "Enum Constant.

  The ability to write (non-acl) file attributes.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/WRITE_ATTRIBUTES)

(def DELETE
  "Enum Constant.

  Permission to delete the file.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/DELETE)

(def READ_ACL
  "Enum Constant.

  Permission to read the ACL attribute.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/READ_ACL)

(def WRITE_ACL
  "Enum Constant.

  Permission to write the ACL attribute.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/WRITE_ACL)

(def WRITE_OWNER
  "Enum Constant.

  Permission to change the owner.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/WRITE_OWNER)

(def SYNCHRONIZE
  "Enum Constant.

  Permission to access file locally at the server with synchronous reads
   and writes.

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/SYNCHRONIZE)

(def *-list-directory
  "Static Constant.

  Permission to list the entries of a directory (equal to READ_DATA)

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/LIST_DIRECTORY)

(def *-add-file
  "Static Constant.

  Permission to add a new file to a directory (equal to WRITE_DATA)

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/ADD_FILE)

(def *-add-subdirectory
  "Static Constant.

  Permission to create a subdirectory to a directory (equal to APPEND_DATA)

  type: java.nio.file.attribute.AclEntryPermission"
  AclEntryPermission/ADD_SUBDIRECTORY)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (AclEntryPermission c : AclEntryPermission.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.attribute.AclEntryPermission[]`"
  ([]
    (AclEntryPermission/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.attribute.AclEntryPermission`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (AclEntryPermission/valueOf name)))

