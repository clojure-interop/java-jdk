(ns jdk.nio.file.attribute.DosFileAttributes
  "File attributes associated with a file in a file system that supports
  legacy `DOS` attributes.

   Usage Example:


     Path file = ...
     DosFileAttributes attrs = Files.readAttributes(file, DosFileAttributes.class);"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute DosFileAttributes]))

(defn read-only?
  "Returns the value of the read-only attribute.

    This attribute is often used as a simple access control mechanism
   to prevent files from being deleted or updated. Whether the file system
   or platform does any enforcement to prevent read-only files
   from being updated is implementation specific.

  returns: the value of the read-only attribute - `boolean`"
  ([^java.nio.file.attribute.DosFileAttributes this]
    (-> this (.isReadOnly))))

(defn hidden?
  "Returns the value of the hidden attribute.

    This attribute is often used to indicate if the file is visible to
   users.

  returns: the value of the hidden attribute - `boolean`"
  ([^java.nio.file.attribute.DosFileAttributes this]
    (-> this (.isHidden))))

(defn archive?
  "Returns the value of the archive attribute.

    This attribute is typically used by backup programs.

  returns: the value of the archive attribute - `boolean`"
  ([^java.nio.file.attribute.DosFileAttributes this]
    (-> this (.isArchive))))

(defn system?
  "Returns the value of the system attribute.

    This attribute is often used to indicate that the file is a component
   of the operating system.

  returns: the value of the system attribute - `boolean`"
  ([^java.nio.file.attribute.DosFileAttributes this]
    (-> this (.isSystem))))

