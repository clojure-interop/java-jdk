(ns jdk.nio.file.attribute.DosFileAttributeView
  "A file attribute view that provides a view of the legacy `DOS` file attributes.
  These attributes are supported by file systems such as the File Allocation
  Table (FAT) format commonly used in consumer devices.

   A DosFileAttributeView is a BasicFileAttributeView that
  additionally supports access to the set of DOS attribute flags that are used
  to indicate if the file is read-only, hidden, a system file, or archived.

   Where dynamic access to file attributes is required, the attributes
  supported by this attribute view are as defined by BasicFileAttributeView, and in addition, the following attributes are
  supported:



       Name
       Type


       readonly
       Boolean


       hidden
       Boolean


       system
       Boolean


       archive
       Boolean




   The getAttribute method may
  be used to read any of these attributes, or any of the attributes defined by
  BasicFileAttributeView as if by invoking the readAttributes() method.

   The setAttribute method may
  be used to update the file's last modified time, last access time or create
  time attributes as defined by BasicFileAttributeView. It may also be
  used to update the DOS attributes as if by invoking the setReadOnly, setHidden, setSystem, and
  setArchive methods respectively."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute DosFileAttributeView]))

(defn name
  "Returns the name of the attribute view. Attribute views of this type
   have the name `dos`.

  returns: the name of the attribute view - `java.lang.String`"
  ([^. this]
    (-> this (.name))))

(defn read-attributes
  "Description copied from interface: BasicFileAttributeView

  returns: the file attributes - `java.nio.file.attribute.DosFileAttributes`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this]
    (-> this (.readAttributes))))

(defn set-read-only
  "Updates the value of the read-only attribute.

    It is implementation specific if the attribute can be updated as an
   atomic operation with respect to other file system operations. An
   implementation may, for example, require to read the existing value of
   the DOS attribute in order to update this attribute.

  value - the new value of the attribute - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this ^Boolean value]
    (-> this (.setReadOnly value))))

(defn set-hidden
  "Updates the value of the hidden attribute.

    It is implementation specific if the attribute can be updated as an
   atomic operation with respect to other file system operations. An
   implementation may, for example, require to read the existing value of
   the DOS attribute in order to update this attribute.

  value - the new value of the attribute - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this ^Boolean value]
    (-> this (.setHidden value))))

(defn set-system
  "Updates the value of the system attribute.

    It is implementation specific if the attribute can be updated as an
   atomic operation with respect to other file system operations. An
   implementation may, for example, require to read the existing value of
   the DOS attribute in order to update this attribute.

  value - the new value of the attribute - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this ^Boolean value]
    (-> this (.setSystem value))))

(defn set-archive
  "Updates the value of the archive attribute.

    It is implementation specific if the attribute can be updated as an
   atomic operation with respect to other file system operations. An
   implementation may, for example, require to read the existing value of
   the DOS attribute in order to update this attribute.

  value - the new value of the attribute - `boolean`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this ^Boolean value]
    (-> this (.setArchive value))))

