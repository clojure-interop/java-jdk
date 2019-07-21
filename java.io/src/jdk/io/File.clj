(ns jdk.io.File
  "An abstract representation of file and directory pathnames.

   User interfaces and operating systems use system-dependent pathname
  strings to name files and directories.  This class presents an
  abstract, system-independent view of hierarchical pathnames.  An
  abstract pathname has two components:


   An optional system-dependent prefix string,
       such as a disk-drive specifier, \"/\" for the UNIX root
       directory, or \"\\\\\\\\\" for a Microsoft Windows UNC pathname, and
   A sequence of zero or more string names.


  The first name in an abstract pathname may be a directory name or, in the
  case of Microsoft Windows UNC pathnames, a hostname.  Each subsequent name
  in an abstract pathname denotes a directory; the last name may denote
  either a directory or a file.  The empty abstract pathname has no
  prefix and an empty name sequence.

   The conversion of a pathname string to or from an abstract pathname is
  inherently system-dependent.  When an abstract pathname is converted into a
  pathname string, each name is separated from the next by a single copy of
  the default separator character.  The default name-separator
  character is defined by the system property file.separator, and
  is made available in the public static fields separator and separatorChar of this class.
  When a pathname string is converted into an abstract pathname, the names
  within it may be separated by the default name-separator character or by any
  other name-separator character that is supported by the underlying system.

   A pathname, whether abstract or in string form, may be either
  absolute or relative.  An absolute pathname is complete in
  that no other information is required in order to locate the file that it
  denotes.  A relative pathname, in contrast, must be interpreted in terms of
  information taken from some other pathname.  By default the classes in the
  java.io package always resolve relative pathnames against the
  current user directory.  This directory is named by the system property
  user.dir, and is typically the directory in which the Java
  virtual machine was invoked.

   The parent of an abstract pathname may be obtained by invoking
  the getParent() method of this class and consists of the pathname's
  prefix and each name in the pathname's name sequence except for the last.
  Each directory's absolute pathname is an ancestor of any File
  object with an absolute abstract pathname which begins with the directory's
  absolute pathname.  For example, the directory denoted by the abstract
  pathname \"/usr\" is an ancestor of the directory denoted by the
  pathname \"/usr/local/bin\".

   The prefix concept is used to handle root directories on UNIX platforms,
  and drive specifiers, root directories and UNC pathnames on Microsoft Windows platforms,
  as follows:



   For UNIX platforms, the prefix of an absolute pathname is always
  \"/\".  Relative pathnames have no prefix.  The abstract pathname
  denoting the root directory has the prefix \"/\" and an empty
  name sequence.

   For Microsoft Windows platforms, the prefix of a pathname that contains a drive
  specifier consists of the drive letter followed by \":\" and
  possibly followed by \"\\\\\" if the pathname is absolute.  The
  prefix of a UNC pathname is \"\\\\\\\\\"; the hostname and the share
  name are the first two names in the name sequence.  A relative pathname that
  does not specify a drive has no prefix.



   Instances of this class may or may not denote an actual file-system
  object such as a file or a directory.  If it does denote such an object
  then that object resides in a partition.  A partition is an
  operating system-specific portion of storage for a file system.  A single
  storage device (e.g. a physical disk-drive, flash memory, CD-ROM) may
  contain multiple partitions.  The object, if any, will reside on the
  partition named by some ancestor of the absolute
  form of this pathname.

   A file system may implement restrictions to certain operations on the
  actual file-system object, such as reading, writing, and executing.  These
  restrictions are collectively known as access permissions.  The file
  system may have multiple sets of access permissions on a single object.
  For example, one set may apply to the object's owner, and another
  may apply to all other users.  The access permissions on an object may
  cause some methods in this class to fail.

   Instances of the File class are immutable; that is, once
  created, the abstract pathname represented by a File object
  will never change.

  Interoperability with java.nio.file package

   The java.nio.file
  package defines interfaces and classes for the Java virtual machine to access
  files, file attributes, and file systems. This API may be used to overcome
  many of the limitations of the java.io.File class.
  The toPath method may be used to obtain a Path that uses the abstract path represented by a File object to
  locate a file. The resulting Path may be used with the Files class to provide more efficient and extensive access to
  additional file operations, file attributes, and I/O exceptions to help
  diagnose errors when an operation on a file fails."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.io File]))

(defn ->file
  "Constructor.

  Creates a new File instance from a parent pathname string
   and a child pathname string.

    If parent is null then the new
   File instance is created as if by invoking the
   single-argument File constructor on the given
   child pathname string.

    Otherwise the parent pathname string is taken to denote
   a directory, and the child pathname string is taken to
   denote either a directory or a file.  If the child pathname
   string is absolute then it is converted into a relative pathname in a
   system-dependent way.  If parent is the empty string then
   the new File instance is created by converting
   child into an abstract pathname and resolving the result
   against a system-dependent default directory.  Otherwise each pathname
   string is converted into an abstract pathname and the child abstract
   pathname is resolved against the parent.

  parent - The parent pathname string - `java.lang.String`
  child - The child pathname string - `java.lang.String`

  throws: java.lang.NullPointerException - If child is null"
  (^File [^java.lang.String parent ^java.lang.String child]
    (new File parent child))
  (^File [^java.lang.String pathname]
    (new File pathname)))

(def *-separator-char
  "Static Constant.

  The system-dependent default name-separator character.  This field is
   initialized to contain the first character of the value of the system
   property file.separator.  On UNIX systems the value of this
   field is '/'; on Microsoft Windows systems it is '\\\\'.

  type: char"
  File/separatorChar)

(def *-separator
  "Static Constant.

  The system-dependent default name-separator character, represented as a
   string for convenience.  This string contains a single character, namely
   separatorChar.

  type: java.lang.String"
  File/separator)

(def *-path-separator-char
  "Static Constant.

  The system-dependent path-separator character.  This field is
   initialized to contain the first character of the value of the system
   property path.separator.  This character is used to
   separate filenames in a sequence of files given as a path list.
   On UNIX systems, this character is ':'; on Microsoft Windows systems it
   is ';'.

  type: char"
  File/pathSeparatorChar)

(def *-path-separator
  "Static Constant.

  The system-dependent path-separator character, represented as a string
   for convenience.  This string contains a single character, namely
   pathSeparatorChar.

  type: java.lang.String"
  File/pathSeparator)

(defn *list-roots
  "List the available filesystem roots.

    A particular Java platform may support zero or more
   hierarchically-organized file systems.  Each file system has a
   root directory from which all other files in that file system
   can be reached.  Windows platforms, for example, have a root directory
   for each active drive; UNIX platforms have a single root directory,
   namely \"/\".  The set of available filesystem roots is affected
   by various system-level operations such as the insertion or ejection of
   removable media and the disconnecting or unmounting of physical or
   virtual disk drives.

    This method returns an array of File objects that denote the
   root directories of the available filesystem roots.  It is guaranteed
   that the canonical pathname of any file physically present on the local
   machine will begin with one of the roots returned by this method.

    The canonical pathname of a file that resides on some other machine
   and is accessed via a remote-filesystem protocol such as SMB or NFS may
   or may not begin with one of the roots returned by this method.  If the
   pathname of a remote file is syntactically indistinguishable from the
   pathname of a local file then it will begin with one of the roots
   returned by this method.  Thus, for example, File objects
   denoting the root directories of the mapped network drives of a Windows
   platform will be returned by this method, while File objects
   containing UNC pathnames will not be returned by this method.

    Unlike most methods in this class, this method does not throw
   security exceptions.  If a security manager exists and its SecurityManager.checkRead(String) method denies read access to a
   particular root directory, then that directory will not appear in the
   result.

  returns: An array of File objects denoting the available
            filesystem roots, or null if the set of roots could not
            be determined.  The array will be empty if there are no
            filesystem roots. - `java.io.File[]`"
  ([]
    (File/listRoots )))

(defn *create-temp-file
  "Creates a new empty file in the specified directory, using the
   given prefix and suffix strings to generate its name.  If this method
   returns successfully then it is guaranteed that:


    The file denoted by the returned abstract pathname did not exist
        before this method was invoked, and
    Neither this method nor any of its variants will return the same
        abstract pathname again in the current invocation of the virtual
        machine.


   This method provides only part of a temporary-file facility.  To arrange
   for a file created by this method to be deleted automatically, use the
   deleteOnExit() method.

    The prefix argument must be at least three characters
   long.  It is recommended that the prefix be a short, meaningful string
   such as \"hjb\" or \"mail\".  The
   suffix argument may be null, in which case the
   suffix \".tmp\" will be used.

    To create the new file, the prefix and the suffix may first be
   adjusted to fit the limitations of the underlying platform.  If the
   prefix is too long then it will be truncated, but its first three
   characters will always be preserved.  If the suffix is too long then it
   too will be truncated, but if it begins with a period character
   ('.') then the period and the first three characters
   following it will always be preserved.  Once these adjustments have been
   made the name of the new file will be generated by concatenating the
   prefix, five or more internally-generated characters, and the suffix.

    If the directory argument is null then the
   system-dependent default temporary-file directory will be used.  The
   default temporary-file directory is specified by the system property
   java.io.tmpdir.  On UNIX systems the default value of this
   property is typically \"/tmp\" or \"/var/tmp\"; on
   Microsoft Windows systems it is typically \"C:\\\\WINNT\\\\TEMP\".  A different
   value may be given to this system property when the Java virtual machine
   is invoked, but programmatic changes to this property are not guaranteed
   to have any effect upon the temporary directory used by this method.

  prefix - The prefix string to be used in generating the file's name; must be at least three characters long - `java.lang.String`
  suffix - The suffix string to be used in generating the file's name; may be null, in which case the suffix \".tmp\" will be used - `java.lang.String`
  directory - The directory in which the file is to be created, or null if the default temporary-file directory is to be used - `java.io.File`

  returns: An abstract pathname denoting a newly-created empty file - `java.io.File`

  throws: java.lang.IllegalArgumentException - If the prefix argument contains fewer than three characters"
  (^java.io.File [^java.lang.String prefix ^java.lang.String suffix ^java.io.File directory]
    (File/createTempFile prefix suffix directory))
  (^java.io.File [^java.lang.String prefix ^java.lang.String suffix]
    (File/createTempFile prefix suffix)))

(defn last-modified
  "Returns the time that the file denoted by this abstract pathname was
   last modified.

    Where it is required to distinguish an I/O exception from the case
   where 0L is returned, or where several attributes of the
   same file are required at the same time, or where the time of last
   access or the creation time are required, then the Files.readAttributes method may be used.

  returns: A long value representing the time the file was
            last modified, measured in milliseconds since the epoch
            (00:00:00 GMT, January 1, 1970), or 0L if the
            file does not exist or if an I/O error occurs - `long`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file"
  (^Long [^File this]
    (-> this (.lastModified))))

(defn file?
  "Tests whether the file denoted by this abstract pathname is a normal
   file.  A file is normal if it is not a directory and, in
   addition, satisfies other system-dependent criteria.  Any non-directory
   file created by a Java application is guaranteed to be a normal file.

    Where it is required to distinguish an I/O exception from the case
   that the file is not a normal file, or where several attributes of the
   same file are required at the same time, then the Files.readAttributes method may be used.

  returns: true if and only if the file denoted by this
            abstract pathname exists and is a normal file;
            false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file"
  (^Boolean [^File this]
    (-> this (.isFile))))

(defn set-read-only
  "Marks the file or directory named by this abstract pathname so that
   only read operations are allowed. After invoking this method the file
   or directory will not change until it is either deleted or marked
   to allow write access. On some platforms it may be possible to start the
   Java virtual machine with special privileges that allow it to modify
   files that are marked read-only. Whether or not a read-only file or
   directory may be deleted depends upon the underlying system.

  returns: true if and only if the operation succeeded;
            false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method denies write access to the named file"
  (^Boolean [^File this]
    (-> this (.setReadOnly))))

(defn list
  "Returns an array of strings naming the files and directories in the
   directory denoted by this abstract pathname that satisfy the specified
   filter.  The behavior of this method is the same as that of the
   list() method, except that the strings in the returned array
   must satisfy the filter.  If the given filter is null
   then all names are accepted.  Otherwise, a name satisfies the filter if
   and only if the value true results when the FilenameFilter.accept(File, String) method
   of the filter is invoked on this abstract pathname and the name of a
   file or directory in the directory that it denotes.

  filter - A filename filter - `java.io.FilenameFilter`

  returns: An array of strings naming the files and directories in the
            directory denoted by this abstract pathname that were accepted
            by the given filter.  The array will be empty if the
            directory is empty or if no names were accepted by the filter.
            Returns null if this abstract pathname does not denote
            a directory, or if an I/O error occurs. - `java.lang.String[]`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(String) method denies read access to the directory"
  ([^File this ^java.io.FilenameFilter filter]
    (-> this (.list filter)))
  ([^File this]
    (-> this (.list))))

(defn delete
  "Deletes the file or directory denoted by this abstract pathname.  If
   this pathname denotes a directory, then the directory must be empty in
   order to be deleted.

    Note that the Files class defines the delete method to throw an IOException
   when a file cannot be deleted. This is useful for error reporting and to
   diagnose why a file cannot be deleted.

  returns: true if and only if the file or directory is
            successfully deleted; false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkDelete(java.lang.String) method denies delete access to the file"
  (^Boolean [^File this]
    (-> this (.delete))))

(defn delete-on-exit
  "Requests that the file or directory denoted by this abstract
   pathname be deleted when the virtual machine terminates.
   Files (or directories) are deleted in the reverse order that
   they are registered. Invoking this method to delete a file or
   directory that is already registered for deletion has no effect.
   Deletion will be attempted only for normal termination of the
   virtual machine, as defined by the Java Language Specification.

    Once deletion has been requested, it is not possible to cancel the
   request.  This method should therefore be used with care.


   Note: this method should not be used for file-locking, as
   the resulting protocol cannot be made to work reliably. The
   FileLock
   facility should be used instead.

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkDelete(java.lang.String) method denies delete access to the file"
  ([^File this]
    (-> this (.deleteOnExit))))

(defn to-uri
  "Constructs a file: URI that represents this abstract pathname.

    The exact form of the URI is system-dependent.  If it can be
   determined that the file denoted by this abstract pathname is a
   directory, then the resulting URI will end with a slash.

    For a given abstract pathname f, it is guaranteed that


   new File( f.toURI()).equals( f.getAbsoluteFile())


   so long as the original abstract pathname, the URI, and the new abstract
   pathname are all created in (possibly different invocations of) the same
   Java virtual machine.  Due to the system-dependent nature of abstract
   pathnames, however, this relationship typically does not hold when a
   file: URI that is created in a virtual machine on one operating
   system is converted into an abstract pathname in a virtual machine on a
   different operating system.

    Note that when this abstract pathname represents a UNC pathname then
   all components of the UNC (including the server name component) are encoded
   in the URI path. The authority component is undefined, meaning
   that it is represented as null. The Path class defines the
   toUri method to encode the server name in the authority
   component of the resulting URI. The toPath method
   may be used to obtain a Path representing this abstract pathname.

  returns: An absolute, hierarchical URI with a scheme equal to
            \"file\", a path representing this abstract pathname,
            and undefined authority, query, and fragment components - `java.net.URI`

  throws: java.lang.SecurityException - If a required system property value cannot be accessed."
  (^java.net.URI [^File this]
    (-> this (.toURI))))

(defn mkdirs
  "Creates the directory named by this abstract pathname, including any
   necessary but nonexistent parent directories.  Note that if this
   operation fails it may have succeeded in creating some of the necessary
   parent directories.

  returns: true if and only if the directory was created,
            along with all necessary parent directories; false
            otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method does not permit verification of the existence of the named directory and all necessary parent directories; or if the SecurityManager.checkWrite(java.lang.String) method does not permit the named directory and all necessary parent directories to be created"
  (^Boolean [^File this]
    (-> this (.mkdirs))))

(defn get-canonical-path
  "Returns the canonical pathname string of this abstract pathname.

    A canonical pathname is both absolute and unique.  The precise
   definition of canonical form is system-dependent.  This method first
   converts this pathname to absolute form if necessary, as if by invoking the
   getAbsolutePath() method, and then maps it to its unique form in a
   system-dependent way.  This typically involves removing redundant names
   such as \".\" and \"..\" from the pathname, resolving
   symbolic links (on UNIX platforms), and converting drive letters to a
   standard case (on Microsoft Windows platforms).

    Every pathname that denotes an existing file or directory has a
   unique canonical form.  Every pathname that denotes a nonexistent file
   or directory also has a unique canonical form.  The canonical form of
   the pathname of a nonexistent file or directory may be different from
   the canonical form of the same pathname after the file or directory is
   created.  Similarly, the canonical form of the pathname of an existing
   file or directory may be different from the canonical form of the same
   pathname after the file or directory is deleted.

  returns: The canonical pathname string denoting the same file or
            directory as this abstract pathname - `java.lang.String`

  throws: java.io.IOException - If an I/O error occurs, which is possible because the construction of the canonical pathname may require filesystem queries"
  (^java.lang.String [^File this]
    (-> this (.getCanonicalPath))))

(defn to-string
  "Returns the pathname string of this abstract pathname.  This is just the
   string returned by the getPath() method.

  returns: The string form of this abstract pathname - `java.lang.String`"
  (^java.lang.String [^File this]
    (-> this (.toString))))

(defn get-path
  "Converts this abstract pathname into a pathname string.  The resulting
   string uses the default name-separator character to
   separate the names in the name sequence.

  returns: The string form of this abstract pathname - `java.lang.String`"
  (^java.lang.String [^File this]
    (-> this (.getPath))))

(defn get-free-space
  "Returns the number of unallocated bytes in the partition named by this abstract path name.

    The returned number of unallocated bytes is a hint, but not
   a guarantee, that it is possible to use most or any of these
   bytes.  The number of unallocated bytes is most likely to be
   accurate immediately after this call.  It is likely to be made
   inaccurate by any external I/O operations including those made
   on the system outside of this virtual machine.  This method
   makes no guarantee that write operations to this file system
   will succeed.

  returns: The number of unallocated bytes on the partition or 0L
            if the abstract pathname does not name a partition.  This
            value will be less than or equal to the total file system size
            returned by getTotalSpace(). - `long`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies RuntimePermission(\"getFileSystemAttributes\") or its SecurityManager.checkRead(String) method denies read access to the file named by this abstract pathname"
  (^Long [^File this]
    (-> this (.getFreeSpace))))

(defn get-total-space
  "Returns the size of the partition named by this
   abstract pathname.

  returns: The size, in bytes, of the partition or 0L if this
            abstract pathname does not name a partition - `long`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies RuntimePermission(\"getFileSystemAttributes\") or its SecurityManager.checkRead(String) method denies read access to the file named by this abstract pathname"
  (^Long [^File this]
    (-> this (.getTotalSpace))))

(defn get-name
  "Returns the name of the file or directory denoted by this abstract
   pathname.  This is just the last name in the pathname's name
   sequence.  If the pathname's name sequence is empty, then the empty
   string is returned.

  returns: The name of the file or directory denoted by this abstract
            pathname, or the empty string if this pathname's name sequence
            is empty - `java.lang.String`"
  (^java.lang.String [^File this]
    (-> this (.getName))))

(defn rename-to
  "Renames the file denoted by this abstract pathname.

    Many aspects of the behavior of this method are inherently
   platform-dependent: The rename operation might not be able to move a
   file from one filesystem to another, it might not be atomic, and it
   might not succeed if a file with the destination abstract pathname
   already exists.  The return value should always be checked to make sure
   that the rename operation was successful.

    Note that the Files class defines the move method to move or rename a file in a
   platform independent manner.

  dest - The new abstract pathname for the named file - `java.io.File`

  returns: true if and only if the renaming succeeded;
            false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method denies write access to either the old or new pathnames"
  (^Boolean [^File this ^java.io.File dest]
    (-> this (.renameTo dest))))

(defn can-read?
  "Tests whether the application can read the file denoted by this
   abstract pathname. On some platforms it may be possible to start the
   Java virtual machine with special privileges that allow it to read
   files that are marked as unreadable. Consequently this method may return
   true even though the file does not have read permissions.

  returns: true if and only if the file specified by this
            abstract pathname exists and can be read by the
            application; false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file"
  (^Boolean [^File this]
    (-> this (.canRead))))

(defn directory?
  "Tests whether the file denoted by this abstract pathname is a
   directory.

    Where it is required to distinguish an I/O exception from the case
   that the file is not a directory, or where several attributes of the
   same file are required at the same time, then the Files.readAttributes method may be used.

  returns: true if and only if the file denoted by this
            abstract pathname exists and is a directory;
            false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file"
  (^Boolean [^File this]
    (-> this (.isDirectory))))

(defn get-parent
  "Returns the pathname string of this abstract pathname's parent, or
   null if this pathname does not name a parent directory.

    The parent of an abstract pathname consists of the
   pathname's prefix, if any, and each name in the pathname's name
   sequence except for the last.  If the name sequence is empty then
   the pathname does not name a parent directory.

  returns: The pathname string of the parent directory named by this
            abstract pathname, or null if this pathname
            does not name a parent - `java.lang.String`"
  (^java.lang.String [^File this]
    (-> this (.getParent))))

(defn hidden?
  "Tests whether the file named by this abstract pathname is a hidden
   file.  The exact definition of hidden is system-dependent.  On
   UNIX systems, a file is considered to be hidden if its name begins with
   a period character ('.').  On Microsoft Windows systems, a file is
   considered to be hidden if it has been marked as such in the filesystem.

  returns: true if and only if the file denoted by this
            abstract pathname is hidden according to the conventions of the
            underlying platform - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file"
  (^Boolean [^File this]
    (-> this (.isHidden))))

(defn set-last-modified
  "Sets the last-modified time of the file or directory named by this
   abstract pathname.

    All platforms support file-modification times to the nearest second,
   but some provide more precision.  The argument will be truncated to fit
   the supported precision.  If the operation succeeds and no intervening
   operations on the file take place, then the next invocation of the
   lastModified() method will return the (possibly
   truncated) time argument that was passed to this method.

  time - The new last-modified time, measured in milliseconds since the epoch (00:00:00 GMT, January 1, 1970) - `long`

  returns: true if and only if the operation succeeded;
            false otherwise - `boolean`

  throws: java.lang.IllegalArgumentException - If the argument is negative"
  (^Boolean [^File this ^Long time]
    (-> this (.setLastModified time))))

(defn get-usable-space
  "Returns the number of bytes available to this virtual machine on the
   partition named by this abstract pathname.  When
   possible, this method checks for write permissions and other operating
   system restrictions and will therefore usually provide a more accurate
   estimate of how much new data can actually be written than getFreeSpace().

    The returned number of available bytes is a hint, but not a
   guarantee, that it is possible to use most or any of these bytes.  The
   number of unallocated bytes is most likely to be accurate immediately
   after this call.  It is likely to be made inaccurate by any external
   I/O operations including those made on the system outside of this
   virtual machine.  This method makes no guarantee that write operations
   to this file system will succeed.

  returns: The number of available bytes on the partition or 0L
            if the abstract pathname does not name a partition.  On
            systems where this information is not available, this method
            will be equivalent to a call to getFreeSpace(). - `long`

  throws: java.lang.SecurityException - If a security manager has been installed and it denies RuntimePermission(\"getFileSystemAttributes\") or its SecurityManager.checkRead(String) method denies read access to the file named by this abstract pathname"
  (^Long [^File this]
    (-> this (.getUsableSpace))))

(defn length
  "Returns the length of the file denoted by this abstract pathname.
   The return value is unspecified if this pathname denotes a directory.

    Where it is required to distinguish an I/O exception from the case
   that 0L is returned, or where several attributes of the same file
   are required at the same time, then the Files.readAttributes method may be used.

  returns: The length, in bytes, of the file denoted by this abstract
            pathname, or 0L if the file does not exist.  Some
            operating systems may return 0L for pathnames
            denoting system-dependent entities such as devices or pipes. - `long`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file"
  (^Long [^File this]
    (-> this (.length))))

(defn set-readable
  "Sets the owner's or everybody's read permission for this abstract
   pathname. On some platforms it may be possible to start the Java virtual
   machine with special privileges that allow it to read files that are
   marked as unreadable.

    The Files class defines methods that operate on
   file attributes including file permissions. This may be used when finer
   manipulation of file permissions is required.

  readable - If true, sets the access permission to allow read operations; if false to disallow read operations - `boolean`
  owner-only - If true, the read permission applies only to the owner's read permission; otherwise, it applies to everybody. If the underlying file system can not distinguish the owner's read permission from that of others, then the permission will apply to everybody, regardless of this value. - `boolean`

  returns: true if and only if the operation succeeded.  The
            operation will fail if the user does not have permission to
            change the access permissions of this abstract pathname.  If
            readable is false and the underlying
            file system does not implement a read permission, then the
            operation will fail. - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method denies write access to the file"
  (^Boolean [^File this ^Boolean readable ^Boolean owner-only]
    (-> this (.setReadable readable owner-only)))
  (^Boolean [^File this ^Boolean readable]
    (-> this (.setReadable readable))))

(defn list-files
  "Returns an array of abstract pathnames denoting the files and
   directories in the directory denoted by this abstract pathname that
   satisfy the specified filter.  The behavior of this method is the same
   as that of the listFiles() method, except that the pathnames in
   the returned array must satisfy the filter.  If the given filter
   is null then all pathnames are accepted.  Otherwise, a pathname
   satisfies the filter if and only if the value true results when
   the FilenameFilter.accept(File, String) method of the filter is
   invoked on this abstract pathname and the name of a file or directory in
   the directory that it denotes.

  filter - A filename filter - `java.io.FilenameFilter`

  returns: An array of abstract pathnames denoting the files and
            directories in the directory denoted by this abstract pathname.
            The array will be empty if the directory is empty.  Returns
            null if this abstract pathname does not denote a
            directory, or if an I/O error occurs. - `java.io.File[]`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(String) method denies read access to the directory"
  ([^File this ^java.io.FilenameFilter filter]
    (-> this (.listFiles filter)))
  ([^File this]
    (-> this (.listFiles))))

(defn to-path
  "Returns a java.nio.file.Path object constructed from the
   this abstract path. The resulting Path is associated with the
   default-filesystem.

    The first invocation of this method works as if invoking it were
   equivalent to evaluating the expression:


   FileSystems.getDefault().getPath(this.getPath());
   Subsequent invocations of this method return the same Path.

    If this abstract pathname is the empty abstract pathname then this
   method returns a Path that may be used to access the current
   user directory.

  returns: a Path constructed from this abstract path - `java.nio.file.Path`

  throws: java.nio.file.InvalidPathException - if a Path object cannot be constructed from the abstract path (see FileSystem.getPath)"
  (^java.nio.file.Path [^File this]
    (-> this (.toPath))))

(defn set-writable
  "Sets the owner's or everybody's write permission for this abstract
   pathname. On some platforms it may be possible to start the Java virtual
   machine with special privileges that allow it to modify files that
   disallow write operations.

    The Files class defines methods that operate on
   file attributes including file permissions. This may be used when finer
   manipulation of file permissions is required.

  writable - If true, sets the access permission to allow write operations; if false to disallow write operations - `boolean`
  owner-only - If true, the write permission applies only to the owner's write permission; otherwise, it applies to everybody. If the underlying file system can not distinguish the owner's write permission from that of others, then the permission will apply to everybody, regardless of this value. - `boolean`

  returns: true if and only if the operation succeeded. The
            operation will fail if the user does not have permission to change
            the access permissions of this abstract pathname. - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method denies write access to the named file"
  (^Boolean [^File this ^Boolean writable ^Boolean owner-only]
    (-> this (.setWritable writable owner-only)))
  (^Boolean [^File this ^Boolean writable]
    (-> this (.setWritable writable))))

(defn can-execute?
  "Tests whether the application can execute the file denoted by this
   abstract pathname. On some platforms it may be possible to start the
   Java virtual machine with special privileges that allow it to execute
   files that are not marked executable. Consequently this method may return
   true even though the file does not have execute permissions.

  returns: true if and only if the abstract pathname exists
            and the application is allowed to execute the file - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkExec(java.lang.String) method denies execute access to the file"
  (^Boolean [^File this]
    (-> this (.canExecute))))

(defn create-new-file
  "Atomically creates a new, empty file named by this abstract pathname if
   and only if a file with this name does not yet exist.  The check for the
   existence of the file and the creation of the file if it does not exist
   are a single operation that is atomic with respect to all other
   filesystem activities that might affect the file.

   Note: this method should not be used for file-locking, as
   the resulting protocol cannot be made to work reliably. The
   FileLock
   facility should be used instead.

  returns: true if the named file does not exist and was
            successfully created; false if the named file
            already exists - `boolean`

  throws: java.io.IOException - If an I/O error occurred"
  (^Boolean [^File this]
    (-> this (.createNewFile))))

(defn hash-code
  "Computes a hash code for this abstract pathname.  Because equality of
   abstract pathnames is inherently system-dependent, so is the computation
   of their hash codes.  On UNIX systems, the hash code of an abstract
   pathname is equal to the exclusive or of the hash code
   of its pathname string and the decimal value
   1234321.  On Microsoft Windows systems, the hash
   code is equal to the exclusive or of the hash code of
   its pathname string converted to lower case and the decimal
   value 1234321.  Locale is not taken into account on
   lowercasing the pathname string.

  returns: A hash code for this abstract pathname - `int`"
  (^Integer [^File this]
    (-> this (.hashCode))))

(defn can-write?
  "Tests whether the application can modify the file denoted by this
   abstract pathname. On some platforms it may be possible to start the
   Java virtual machine with special privileges that allow it to modify
   files that are marked read-only. Consequently this method may return
   true even though the file is marked read-only.

  returns: true if and only if the file system actually
            contains a file denoted by this abstract pathname and
            the application is allowed to write to the file;
            false otherwise. - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method denies write access to the file"
  (^Boolean [^File this]
    (-> this (.canWrite))))

(defn exists?
  "Tests whether the file or directory denoted by this abstract pathname
   exists.

  returns: true if and only if the file or directory denoted
            by this abstract pathname exists; false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkRead(java.lang.String) method denies read access to the file or directory"
  (^Boolean [^File this]
    (-> this (.exists))))

(defn get-parent-file
  "Returns the abstract pathname of this abstract pathname's parent,
   or null if this pathname does not name a parent
   directory.

    The parent of an abstract pathname consists of the
   pathname's prefix, if any, and each name in the pathname's name
   sequence except for the last.  If the name sequence is empty then
   the pathname does not name a parent directory.

  returns: The abstract pathname of the parent directory named by this
            abstract pathname, or null if this pathname
            does not name a parent - `java.io.File`"
  (^java.io.File [^File this]
    (-> this (.getParentFile))))

(defn compare-to
  "Compares two abstract pathnames lexicographically.  The ordering
   defined by this method depends upon the underlying system.  On UNIX
   systems, alphabetic case is significant in comparing pathnames; on Microsoft Windows
   systems it is not.

  pathname - The abstract pathname to be compared to this abstract pathname - `java.io.File`

  returns: Zero if the argument is equal to this abstract pathname, a
            value less than zero if this abstract pathname is
            lexicographically less than the argument, or a value greater
            than zero if this abstract pathname is lexicographically
            greater than the argument - `int`"
  (^Integer [^File this ^java.io.File pathname]
    (-> this (.compareTo pathname))))

(defn set-executable
  "Sets the owner's or everybody's execute permission for this abstract
   pathname. On some platforms it may be possible to start the Java virtual
   machine with special privileges that allow it to execute files that are
   not marked executable.

    The Files class defines methods that operate on
   file attributes including file permissions. This may be used when finer
   manipulation of file permissions is required.

  executable - If true, sets the access permission to allow execute operations; if false to disallow execute operations - `boolean`
  owner-only - If true, the execute permission applies only to the owner's execute permission; otherwise, it applies to everybody. If the underlying file system can not distinguish the owner's execute permission from that of others, then the permission will apply to everybody, regardless of this value. - `boolean`

  returns: true if and only if the operation succeeded.  The
            operation will fail if the user does not have permission to
            change the access permissions of this abstract pathname.  If
            executable is false and the underlying
            file system does not implement an execute permission, then the
            operation will fail. - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method denies write access to the file"
  (^Boolean [^File this ^Boolean executable ^Boolean owner-only]
    (-> this (.setExecutable executable owner-only)))
  (^Boolean [^File this ^Boolean executable]
    (-> this (.setExecutable executable))))

(defn get-absolute-path
  "Returns the absolute pathname string of this abstract pathname.

    If this abstract pathname is already absolute, then the pathname
   string is simply returned as if by the getPath()
   method.  If this abstract pathname is the empty abstract pathname then
   the pathname string of the current user directory, which is named by the
   system property user.dir, is returned.  Otherwise this
   pathname is resolved in a system-dependent way.  On UNIX systems, a
   relative pathname is made absolute by resolving it against the current
   user directory.  On Microsoft Windows systems, a relative pathname is made absolute
   by resolving it against the current directory of the drive named by the
   pathname, if any; if not, it is resolved against the current user
   directory.

  returns: The absolute pathname string denoting the same file or
            directory as this abstract pathname - `java.lang.String`

  throws: java.lang.SecurityException - If a required system property value cannot be accessed."
  (^java.lang.String [^File this]
    (-> this (.getAbsolutePath))))

(defn get-absolute-file
  "Returns the absolute form of this abstract pathname.  Equivalent to
   new File(this.getAbsolutePath()).

  returns: The absolute abstract pathname denoting the same file or
            directory as this abstract pathname - `java.io.File`

  throws: java.lang.SecurityException - If a required system property value cannot be accessed."
  (^java.io.File [^File this]
    (-> this (.getAbsoluteFile))))

(defn equals
  "Tests this abstract pathname for equality with the given object.
   Returns true if and only if the argument is not
   null and is an abstract pathname that denotes the same file
   or directory as this abstract pathname.  Whether or not two abstract
   pathnames are equal depends upon the underlying system.  On UNIX
   systems, alphabetic case is significant in comparing pathnames; on Microsoft Windows
   systems it is not.

  obj - The object to be compared with this abstract pathname - `java.lang.Object`

  returns: true if and only if the objects are the same;
            false otherwise - `boolean`"
  (^Boolean [^File this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn to-url
  "Deprecated. This method does not automatically escape characters that
   are illegal in URLs.  It is recommended that new code convert an
   abstract pathname into a URL by first converting it into a URI, via the
   toURI method, and then converting the URI into a URL
   via the URI.toURL method.

  returns: A URL object representing the equivalent file URL - `java.net.URL`

  throws: java.net.MalformedURLException - If the path cannot be parsed as a URL"
  (^java.net.URL [^File this]
    (-> this (.toURL))))

(defn absolute?
  "Tests whether this abstract pathname is absolute.  The definition of
   absolute pathname is system dependent.  On UNIX systems, a pathname is
   absolute if its prefix is \"/\".  On Microsoft Windows systems, a
   pathname is absolute if its prefix is a drive specifier followed by
   \"\\\\\", or if its prefix is \"\\\\\\\\\".

  returns: true if this abstract pathname is absolute,
            false otherwise - `boolean`"
  (^Boolean [^File this]
    (-> this (.isAbsolute))))

(defn mkdir
  "Creates the directory named by this abstract pathname.

  returns: true if and only if the directory was
            created; false otherwise - `boolean`

  throws: java.lang.SecurityException - If a security manager exists and its SecurityManager.checkWrite(java.lang.String) method does not permit the named directory to be created"
  (^Boolean [^File this]
    (-> this (.mkdir))))

(defn get-canonical-file
  "Returns the canonical form of this abstract pathname.  Equivalent to
   new File(this.getCanonicalPath()).

  returns: The canonical pathname string denoting the same file or
            directory as this abstract pathname - `java.io.File`

  throws: java.io.IOException - If an I/O error occurs, which is possible because the construction of the canonical pathname may require filesystem queries"
  (^java.io.File [^File this]
    (-> this (.getCanonicalFile))))

