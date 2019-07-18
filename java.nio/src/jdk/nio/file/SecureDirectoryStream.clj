(ns jdk.nio.file.SecureDirectoryStream
  "A DirectoryStream that defines operations on files that are located
  relative to an open directory. A SecureDirectoryStream is intended
  for use by sophisticated or security sensitive applications requiring to
  traverse file trees or otherwise operate on directories in a race-free manner.
  Race conditions can arise when a sequence of file operations cannot be
  carried out in isolation. Each of the file operations defined by this
  interface specify a relative path. All access to the file is relative
  to the open directory irrespective of if the directory is moved or replaced
  by an attacker while the directory is open. A SecureDirectoryStream
  may also be used as a virtual working directory.

   A SecureDirectoryStream requires corresponding support from the
  underlying operating system. Where an implementation supports this features
  then the DirectoryStream returned by the newDirectoryStream method will be a SecureDirectoryStream and must
  be cast to that type in order to invoke the methods defined by this interface.

   In the case of the default provider, and a security manager is set, then the permission checks are
  performed using the path obtained by resolving the given relative path
  against the original path of the directory (irrespective of if the
  directory is moved since it was opened)."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file SecureDirectoryStream]))

(defn new-directory-stream
  "Opens the directory identified by the given path, returning a SecureDirectoryStream to iterate over the entries in the directory.

    This method works in exactly the manner specified by the newDirectoryStream method for the case that
   the path parameter is an absolute path.
   When the parameter is a relative path then the directory to open is
   relative to this open directory. The NOFOLLOW_LINKS option may be used to
   ensure that this method fails if the file is a symbolic link.

    The new directory stream, once created, is not dependent upon the
   directory stream used to create it. Closing this directory stream has no
   effect upon newly created directory stream.

  path - the path to the directory to open - `T`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: a new and open SecureDirectoryStream object - `java.nio.file.SecureDirectoryStream<T>`

  throws: java.nio.file.ClosedDirectoryStreamException - if the directory stream is closed"
  (^java.nio.file.SecureDirectoryStream [^SecureDirectoryStream this path ^java.nio.file.LinkOption options]
    (-> this (.newDirectoryStream path options))))

(defn new-byte-channel
  "Opens or creates a file in this directory, returning a seekable byte
   channel to access the file.

    This method works in exactly the manner specified by the Files.newByteChannel method for the
   case that the path parameter is an absolute
   path. When the parameter is a relative path then the file to open or
   create is relative to this open directory. In addition to the options
   defined by the Files.newByteChannel method, the NOFOLLOW_LINKS option may be used to
   ensure that this method fails if the file is a symbolic link.

    The channel, once created, is not dependent upon the directory stream
   used to create it. Closing this directory stream has no effect upon the
   channel.

  path - the path of the file to open open or create - `T`
  options - options specifying how the file is opened - `java.util.Set`
  attrs - an optional list of attributes to set atomically when creating the file - `java.nio.file.attribute.FileAttribute`

  returns: the seekable byte channel - `java.nio.channels.SeekableByteChannel`

  throws: java.nio.file.ClosedDirectoryStreamException - if the directory stream is closed"
  (^java.nio.channels.SeekableByteChannel [^SecureDirectoryStream this path ^java.util.Set options ^java.nio.file.attribute.FileAttribute attrs]
    (-> this (.newByteChannel path options attrs))))

(defn delete-file
  "Deletes a file.

    Unlike the delete() method, this method does
   not first examine the file to determine if the file is a directory.
   Whether a directory is deleted by this method is system dependent and
   therefore not specified. If the file is a symbolic link, then the link
   itself, not the final target of the link, is deleted. When the
   parameter is a relative path then the file to delete is relative to
   this open directory.

  path - the path of the file to delete - `T`

  throws: java.nio.file.ClosedDirectoryStreamException - if the directory stream is closed"
  ([^SecureDirectoryStream this path]
    (-> this (.deleteFile path))))

(defn delete-directory
  "Deletes a directory.

    Unlike the delete() method, this method
   does not first examine the file to determine if the file is a directory.
   Whether non-directories are deleted by this method is system dependent and
   therefore not specified. When the parameter is a relative path then the
   directory to delete is relative to this open directory.

  path - the path of the directory to delete - `T`

  throws: java.nio.file.ClosedDirectoryStreamException - if the directory stream is closed"
  ([^SecureDirectoryStream this path]
    (-> this (.deleteDirectory path))))

(defn move
  "Move a file from this directory to another directory.

    This method works in a similar manner to move
   method when the ATOMIC_MOVE option
   is specified. That is, this method moves a file as an atomic file system
   operation. If the srcpath parameter is an absolute path then it locates the source file. If the parameter is a
   relative path then it is located relative to this open directory. If
   the targetpath parameter is absolute then it locates the target
   file (the targetdir parameter is ignored). If the parameter is
   a relative path it is located relative to the open directory identified
   by the targetdir parameter. In all cases, if the target file
   exists then it is implementation specific if it is replaced or this
   method fails.

  srcpath - the name of the file to move - `T`
  targetdir - the destination directory - `java.nio.file.SecureDirectoryStream`
  targetpath - the name to give the file in the destination directory - `T`

  throws: java.nio.file.ClosedDirectoryStreamException - if this or the target directory stream is closed"
  ([^SecureDirectoryStream this srcpath ^java.nio.file.SecureDirectoryStream targetdir targetpath]
    (-> this (.move srcpath targetdir targetpath))))

(defn get-file-attribute-view
  "Returns a new file attribute view to access the file attributes of a file
   in this directory.

    The resulting file attribute view can be used to read or update the
   attributes of file in this directory. The type parameter specifies
   the type of the attribute view and the method returns an instance of that
   type if supported. Invoking this method to obtain a BasicFileAttributeView always returns an instance of that class that is
   bound to the file in the directory.

    The state of resulting file attribute view is intimately connected
   to this directory stream. Once the directory stream closed,
   then all methods to read or update attributes will throw ClosedDirectoryStreamException. The
   file is not required to exist at the time that the file attribute view
   is created but methods to read or update attributes of the file will
   fail when invoked and the file does not exist.

  path - the path of the file - `T`
  type - the Class object corresponding to the file attribute view - `java.lang.Class`
  options - options indicating how symbolic links are handled - `java.nio.file.LinkOption`

  returns: a new file attribute view of the specified type bound to a
            this directory stream, or null if the attribute view
            type is not available - `<V extends java.nio.file.attribute.FileAttributeView> V`"
  ([^SecureDirectoryStream this path ^java.lang.Class type ^java.nio.file.LinkOption options]
    (-> this (.getFileAttributeView path type options)))
  ([^SecureDirectoryStream this ^java.lang.Class type]
    (-> this (.getFileAttributeView type))))

