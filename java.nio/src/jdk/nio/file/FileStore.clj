(ns jdk.nio.file.FileStore
  "Storage for files. A FileStore represents a storage pool, device,
  partition, volume, concrete file system or other implementation specific means
  of file storage. The FileStore for where a file is stored is obtained
  by invoking the getFileStore method, or all file
  stores can be enumerated by invoking the getFileStores method.

   In addition to the methods defined by this class, a file store may support
  one or more FileStoreAttributeView classes
  that provide a read-only or updatable view of a set of file store attributes."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file FileStore]))

(defn get-attribute
  "Reads the value of a file store attribute.

    The attribute parameter identifies the attribute to be read
   and takes the form:

   view-name:attribute-name

   where the character ':' stands for itself.

    view-name is the name of
   a AttributeView that identifies a set of file attributes.
   attribute-name is the name of the attribute.

    Usage Example:
   Suppose we want to know if ZFS compression is enabled (assuming the `zfs`
   view is supported):


      boolean compression = (Boolean)fs.getAttribute(`zfs:compression`);

  attribute - the attribute to read - `java.lang.String`

  returns: the attribute value; null may be a valid valid for some
            attributes - `java.lang.Object`

  throws: java.lang.UnsupportedOperationException - if the attribute view is not available or it does not support reading the attribute"
  ([^java.nio.file.FileStore this ^java.lang.String attribute]
    (-> this (.getAttribute attribute))))

(defn get-total-space
  "Returns the size, in bytes, of the file store.

  returns: the size of the file store, in bytes - `long`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.nio.file.FileStore this]
    (-> this (.getTotalSpace))))

(defn name
  "Returns the name of this file store. The format of the name is highly
   implementation specific. It will typically be the name of the storage
   pool or volume.

    The string returned by this method may differ from the string
   returned by the toString method.

  returns: the name of this file store - `java.lang.String`"
  ([^java.nio.file.FileStore this]
    (-> this (.name))))

(defn supports-file-attribute-view
  "Tells whether or not this file store supports the file attributes
   identified by the given file attribute view.

    Invoking this method to test if the file store supports BasicFileAttributeView will always return true. In the case of
   the default provider, this method cannot guarantee to give the correct
   result when the file store is not a local storage device. The reasons for
   this are implementation specific and therefore unspecified.

  type - the file attribute view type - `java.nio.file.attribute.FileAttributeView>`

  returns: true if, and only if, the file attribute view is
            supported - `boolean`"
  ([^java.nio.file.FileStore this ^java.nio.file.attribute.FileAttributeView> type]
    (-> this (.supportsFileAttributeView type))))

(defn get-usable-space
  "Returns the number of bytes available to this Java virtual machine on the
   file store.

    The returned number of available bytes is a hint, but not a
   guarantee, that it is possible to use most or any of these bytes.  The
   number of usable bytes is most likely to be accurate immediately
   after the space attributes are obtained. It is likely to be made inaccurate
   by any external I/O operations including those made on the system outside
   of this Java virtual machine.

  returns: the number of bytes available - `long`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.nio.file.FileStore this]
    (-> this (.getUsableSpace))))

(defn get-file-store-attribute-view
  "Returns a FileStoreAttributeView of the given type.

    This method is intended to be used where the file store attribute
   view defines type-safe methods to read or update the file store attributes.
   The type parameter is the type of the attribute view required and
   the method returns an instance of that type if supported.

  type - the Class object corresponding to the attribute view - `java.lang.Class<V>`

  returns: a file store attribute view of the specified type or
            null if the attribute view is not available - `<V extends java.nio.file.attribute.FileStoreAttributeView> V`"
  ([^java.nio.file.FileStore this ^java.lang.Class type]
    (-> this (.getFileStoreAttributeView type))))

(defn type
  "Returns the type of this file store. The format of the string
   returned by this method is highly implementation specific. It may
   indicate, for example, the format used or if the file store is local
   or remote.

  returns: a string representing the type of this file store - `java.lang.String`"
  ([^java.nio.file.FileStore this]
    (-> this (.type))))

(defn get-unallocated-space
  "Returns the number of unallocated bytes in the file store.

    The returned number of unallocated bytes is a hint, but not a
   guarantee, that it is possible to use most or any of these bytes.  The
   number of unallocated bytes is most likely to be accurate immediately
   after the space attributes are obtained. It is likely to be
   made inaccurate by any external I/O operations including those made on
   the system outside of this virtual machine.

  returns: the number of unallocated bytes - `long`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.nio.file.FileStore this]
    (-> this (.getUnallocatedSpace))))

(defn read-only?
  "Tells whether this file store is read-only. A file store is read-only if
   it does not support write operations or other changes to files. Any
   attempt to create a file, open an existing file for writing etc. causes
   an IOException to be thrown.

  returns: true if, and only if, this file store is read-only - `boolean`"
  ([^java.nio.file.FileStore this]
    (-> this (.isReadOnly))))

