(ns jdk.nio.file.StandardOpenOption
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file StandardOpenOption]))

(def READ
  "Enum Constant.

  Open for read access.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/READ)

(def WRITE
  "Enum Constant.

  Open for write access.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/WRITE)

(def APPEND
  "Enum Constant.

  If the file is opened for WRITE access then bytes will be written
   to the end of the file rather than the beginning.

    If the file is opened for write access by other programs, then it
   is file system specific if writing to the end of the file is atomic.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/APPEND)

(def TRUNCATE_EXISTING
  "Enum Constant.

  If the file already exists and it is opened for WRITE
   access, then its length is truncated to 0. This option is ignored
   if the file is opened only for READ access.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/TRUNCATE_EXISTING)

(def CREATE
  "Enum Constant.

  Create a new file if it does not exist.
   This option is ignored if the CREATE_NEW option is also set.
   The check for the existence of the file and the creation of the file
   if it does not exist is atomic with respect to other file system
   operations.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/CREATE)

(def CREATE_NEW
  "Enum Constant.

  Create a new file, failing if the file already exists.
   The check for the existence of the file and the creation of the file
   if it does not exist is atomic with respect to other file system
   operations.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/CREATE_NEW)

(def DELETE_ON_CLOSE
  "Enum Constant.

  Delete on close. When this option is present then the implementation
   makes a best effort attempt to delete the file when closed
   by the appropriate close method. If the close method is
   not invoked then a best effort attempt is made to delete the
   file when the Java virtual machine terminates (either normally, as
   defined by the Java Language Specification, or where possible, abnormally).
   This option is primarily intended for use with work files that
   are used solely by a single instance of the Java virtual machine. This
   option is not recommended for use when opening files that are open
   concurrently by other entities. Many of the details as to when and how
   the file is deleted are implementation specific and therefore not
   specified. In particular, an implementation may be unable to guarantee
   that it deletes the expected file when replaced by an attacker while the
   file is open. Consequently, security sensitive applications should take
   care when using this option.

    For security reasons, this option may imply the LinkOption.NOFOLLOW_LINKS option. In other words, if the option is present
   when opening an existing file that is a symbolic link then it may fail
   (by throwing IOException).

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/DELETE_ON_CLOSE)

(def SPARSE
  "Enum Constant.

  Sparse file. When used with the CREATE_NEW option then this
   option provides a hint that the new file will be sparse. The
   option is ignored when the file system does not support the creation of
   sparse files.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/SPARSE)

(def SYNC
  "Enum Constant.

  Requires that every update to the file's content or metadata be written
   synchronously to the underlying storage device.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/SYNC)

(def DSYNC
  "Enum Constant.

  Requires that every update to the file's content be written
   synchronously to the underlying storage device.

  type: java.nio.file.StandardOpenOption"
  StandardOpenOption/DSYNC)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (StandardOpenOption c : StandardOpenOption.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.nio.file.StandardOpenOption[]`"
  ([]
    (StandardOpenOption/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.nio.file.StandardOpenOption`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (StandardOpenOption/valueOf name)))

