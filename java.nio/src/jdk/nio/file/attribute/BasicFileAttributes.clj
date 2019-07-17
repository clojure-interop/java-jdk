(ns jdk.nio.file.attribute.BasicFileAttributes
  "Basic attributes associated with a file in a file system.

   Basic file attributes are attributes that are common to many file systems
  and consist of mandatory and optional file attributes as defined by this
  interface.

   Usage Example:


     Path file = ...
     BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute BasicFileAttributes]))

(defn file-key
  "Returns an object that uniquely identifies the given file, or null if a file key is not available. On some platforms or file systems
   it is possible to use an identifier, or a combination of identifiers to
   uniquely identify a file. Such identifiers are important for operations
   such as file tree traversal in file systems that support symbolic links or file systems
   that allow a file to be an entry in more than one directory. On UNIX file
   systems, for example, the device ID and inode are
   commonly used for such purposes.

    The file key returned by this method can only be guaranteed to be
   unique if the file system and files remain static. Whether a file system
   re-uses identifiers after a file is deleted is implementation dependent and
   therefore unspecified.

    File keys returned by this method can be compared for equality and are
   suitable for use in collections. If the file system and files remain static,
   and two files are the same with
   non-null file keys, then their file keys are equal.

  returns: an object that uniquely identifies the given file, or null - `java.lang.Object`"
  ([^. this]
    (-> this (.fileKey))))

(defn last-modified-time
  "Returns the time of last modification.

    If the file system implementation does not support a time stamp
   to indicate the time of last modification then this method returns an
   implementation specific default value, typically a FileTime
   representing the epoch (1970-01-01T00:00:00Z).

  returns: a FileTime representing the time the file was last
            modified - `java.nio.file.attribute.FileTime`"
  ([^. this]
    (-> this (.lastModifiedTime))))

(defn symbolic-link?
  "Tells whether the file is a symbolic link.

  returns: true if the file is a symbolic link - `boolean`"
  ([^. this]
    (-> this (.isSymbolicLink))))

(defn regular-file?
  "Tells whether the file is a regular file with opaque content.

  returns: true if the file is a regular file with opaque content - `boolean`"
  ([^. this]
    (-> this (.isRegularFile))))

(defn last-access-time
  "Returns the time of last access.

    If the file system implementation does not support a time stamp
   to indicate the time of last access then this method returns
   an implementation specific default value, typically the last-modified-time or a FileTime
   representing the epoch (1970-01-01T00:00:00Z).

  returns: a FileTime representing the time of last access - `java.nio.file.attribute.FileTime`"
  ([^. this]
    (-> this (.lastAccessTime))))

(defn directory?
  "Tells whether the file is a directory.

  returns: true if the file is a directory - `boolean`"
  ([^. this]
    (-> this (.isDirectory))))

(defn other?
  "Tells whether the file is something other than a regular file, directory,
   or symbolic link.

  returns: true if the file something other than a regular file,
           directory or symbolic link - `boolean`"
  ([^. this]
    (-> this (.isOther))))

(defn creation-time
  "Returns the creation time. The creation time is the time that the file
   was created.

    If the file system implementation does not support a time stamp
   to indicate the time when the file was created then this method returns
   an implementation specific default value, typically the last-modified-time or a FileTime
   representing the epoch (1970-01-01T00:00:00Z).

  returns: a FileTime representing the time the file was created - `java.nio.file.attribute.FileTime`"
  ([^. this]
    (-> this (.creationTime))))

(defn size
  "Returns the size of the file (in bytes). The size may differ from the
   actual size on the file system due to compression, support for sparse
   files, or other reasons. The size of files that are not regular files is implementation specific and
   therefore unspecified.

  returns: the file size, in bytes - `long`"
  ([^. this]
    (-> this (.size))))

