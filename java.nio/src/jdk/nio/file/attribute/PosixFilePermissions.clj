(ns jdk.nio.file.attribute.PosixFilePermissions
  "This class consists exclusively of static methods that operate on sets of
  PosixFilePermission objects."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute PosixFilePermissions]))

(defn *to-string
  "Returns the String representation of a set of permissions. It
   is guaranteed that the returned String can be parsed by the
   fromString(java.lang.String) method.

    If the set contains null or elements that are not of type
   PosixFilePermission then these elements are ignored.

  perms - the set of permissions - `java.util.Set<java.nio.file.attribute.PosixFilePermission>`

  returns: the string representation of the permission set - `java.lang.String`"
  (^java.lang.String [^java.util.Set perms]
    (PosixFilePermissions/toString perms)))

(defn *from-string
  "Returns the set of permissions corresponding to a given String
   representation.

    The perms parameter is a String representing the
   permissions. It has 9 characters that are interpreted as three sets of
   three. The first set refers to the owner's permissions; the next to the
   group permissions and the last to others. Within each set, the first
   character is 'r' to indicate permission to read, the second
   character is 'w' to indicate permission to write, and the third
   character is 'x' for execute permission. Where a permission is
   not set then the corresponding character is set to '-'.

    Usage Example:
   Suppose we require the set of permissions that indicate the owner has read,
   write, and execute permissions, the group has read and execute permissions
   and others have none.


     Set<PosixFilePermission> perms = PosixFilePermissions.fromString(`rwxr-x---`);

  perms - string representing a set of permissions - `java.lang.String`

  returns: the resulting set of permissions - `java.util.Set<java.nio.file.attribute.PosixFilePermission>`

  throws: java.lang.IllegalArgumentException - if the string cannot be converted to a set of permissions"
  (^java.util.Set [^java.lang.String perms]
    (PosixFilePermissions/fromString perms)))

(defn *as-file-attribute
  "Creates a FileAttribute, encapsulating a copy of the given file
   permissions, suitable for passing to the createFile or createDirectory
   methods.

  perms - the set of permissions - `java.util.Set<java.nio.file.attribute.PosixFilePermission>`

  returns: an attribute encapsulating the given file permissions with
            name `posix:permissions` - `java.nio.file.attribute.FileAttribute<java.util.Set<java.nio.file.attribute.PosixFilePermission>>`

  throws: java.lang.ClassCastException - if the set contains elements that are not of type PosixFilePermission"
  (^java.nio.file.attribute.FileAttribute> [^java.util.Set perms]
    (PosixFilePermissions/asFileAttribute perms)))

