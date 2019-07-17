(ns jdk.nio.file.attribute.BasicFileAttributeView
  "A file attribute view that provides a view of a basic set of file
  attributes common to many file systems. The basic set of file attributes
  consist of mandatory and optional file attributes as
  defined by the BasicFileAttributes interface.

   The file attributes are retrieved from the file system as a bulk
  operation by invoking the readAttributes method.
  This class also defines the setTimes method to update the
  file's time attributes.

   Where dynamic access to file attributes is required, the attributes
  supported by this attribute view have the following names and types:



       Name
       Type


       `lastModifiedTime`
       FileTime


       `lastAccessTime`
       FileTime


       `creationTime`
       FileTime


       `size`
       Long


       `isRegularFile`
       Boolean


       `isDirectory`
       Boolean


       `isSymbolicLink`
       Boolean


       `isOther`
       Boolean


       `fileKey`
       Object




   The getAttribute method may be
  used to read any of these attributes as if by invoking the readAttributes() method.

   The setAttribute method may be
  used to update the file's last modified time, last access time or create time
  attributes as if by invoking the setTimes method."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file.attribute BasicFileAttributeView]))

(defn name
  "Returns the name of the attribute view. Attribute views of this type
   have the name `basic`.

  returns: the name of the attribute view - `java.lang.String`"
  ([^. this]
    (-> this (.name))))

(defn read-attributes
  "Reads the basic file attributes as a bulk operation.

    It is implementation specific if all file attributes are read as an
   atomic operation with respect to other file system operations.

  returns: the file attributes - `java.nio.file.attribute.BasicFileAttributes`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this]
    (-> this (.readAttributes))))

(defn set-times
  "Updates any or all of the file's last modified time, last access time,
   and create time attributes.

    This method updates the file's timestamp attributes. The values are
   converted to the epoch and precision supported by the file system.
   Converting from finer to coarser granularities result in precision loss.
   The behavior of this method when attempting to set a timestamp that is
   not supported or to a value that is outside the range supported by the
   underlying file store is not defined. It may or not fail by throwing an
   IOException.

    If any of the lastModifiedTime, lastAccessTime,
   or createTime parameters has the value null then the
   corresponding timestamp is not changed. An implementation may require to
   read the existing values of the file attributes when only some, but not
   all, of the timestamp attributes are updated. Consequently, this method
   may not be an atomic operation with respect to other file system
   operations. Reading and re-writing existing values may also result in
   precision loss. If all of the lastModifiedTime, lastAccessTime and createTime parameters are null then
   this method has no effect.

    Usage Example:
   Suppose we want to change a file's last access time.


      Path path = ...
      FileTime time = ...
      Files.getFileAttributeView(path, BasicFileAttributeView.class).setTimes(null, time, null);

  last-modified-time - the new last modified time, or null to not change the value - `java.nio.file.attribute.FileTime`
  last-access-time - the last access time, or null to not change the value - `java.nio.file.attribute.FileTime`
  create-time - the file's create time, or null to not change the value - `java.nio.file.attribute.FileTime`

  throws: java.io.IOException - if an I/O error occurs"
  ([^. this ^java.nio.file.attribute.FileTime last-modified-time ^java.nio.file.attribute.FileTime last-access-time ^java.nio.file.attribute.FileTime create-time]
    (-> this (.setTimes last-modified-time last-access-time create-time))))

