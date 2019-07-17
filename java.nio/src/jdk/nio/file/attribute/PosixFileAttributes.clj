(ns jdk.nio.file.attribute.PosixFileAttributes
  "File attributes associated with files on file systems used by operating systems
  that implement the Portable Operating System Interface (POSIX) family of
  standards.

   The POSIX attributes of a file are retrieved using a PosixFileAttributeView by invoking its readAttributes method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute PosixFileAttributes]))

(defn owner
  "Returns the owner of the file.

  returns: the file owner - `java.nio.file.attribute.UserPrincipal`"
  ([^. this]
    (-> this (.owner))))

(defn group
  "Returns the group owner of the file.

  returns: the file group owner - `java.nio.file.attribute.GroupPrincipal`"
  ([^. this]
    (-> this (.group))))

(defn permissions
  "Returns the permissions of the file. The file permissions are returned
   as a set of PosixFilePermission elements. The returned set is a
   copy of the file permissions and is modifiable. This allows the result
   to be modified and passed to the setPermissions method to update the file's permissions.

  returns: the file permissions - `java.util.Set<java.nio.file.attribute.PosixFilePermission>`"
  ([^. this]
    (-> this (.permissions))))

