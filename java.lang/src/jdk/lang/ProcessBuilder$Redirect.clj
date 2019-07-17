(ns jdk.lang.ProcessBuilder$Redirect
  "Represents a source of subprocess input or a destination of
  subprocess output.

  Each Redirect instance is one of the following:


  the special value Redirect.PIPE
  the special value Redirect.INHERIT
  a redirection to read from a file, created by an invocation of
      Redirect.from(File)
  a redirection to write to a file,  created by an invocation of
      Redirect.to(File)
  a redirection to append to a file, created by an invocation of
      Redirect.appendTo(File)


  Each of the above categories has an associated unique
  Type."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.lang ProcessBuilder$Redirect]))

(def *-pipe
  "Static Constant.

  Indicates that subprocess I/O will be connected to the
   current Java process over a pipe.

   This is the default handling of subprocess standard I/O.

   It will always be true that


   Redirect.PIPE.file() == null &&
   Redirect.PIPE.type() == Redirect.Type.PIPE

  type: java.lang.ProcessBuilder.Redirect"
  ProcessBuilder$Redirect/PIPE)

(def *-inherit
  "Static Constant.

  Indicates that subprocess I/O source or destination will be the
   same as those of the current process.  This is the normal
   behavior of most operating system command interpreters (shells).

   It will always be true that


   Redirect.INHERIT.file() == null &&
   Redirect.INHERIT.type() == Redirect.Type.INHERIT

  type: java.lang.ProcessBuilder.Redirect"
  ProcessBuilder$Redirect/INHERIT)

(defn *from
  "Returns a redirect to read from the specified file.

   It will always be true that


   Redirect.from(file).file() == file &&
   Redirect.from(file).type() == Redirect.Type.READ

  file - The File for the Redirect. - `java.io.File`

  returns: a redirect to read from the specified file - `java.lang.ProcessBuilder.Redirect`

  throws: java.lang.NullPointerException - if the specified file is null"
  ([^java.io.File file]
    (ProcessBuilder$Redirect/from file)))

(defn *to
  "Returns a redirect to write to the specified file.
   If the specified file exists when the subprocess is started,
   its previous contents will be discarded.

   It will always be true that


   Redirect.to(file).file() == file &&
   Redirect.to(file).type() == Redirect.Type.WRITE

  file - The File for the Redirect. - `java.io.File`

  returns: a redirect to write to the specified file - `java.lang.ProcessBuilder.Redirect`

  throws: java.lang.NullPointerException - if the specified file is null"
  ([^java.io.File file]
    (ProcessBuilder$Redirect/to file)))

(defn *append-to
  "Returns a redirect to append to the specified file.
   Each write operation first advances the position to the
   end of the file and then writes the requested data.
   Whether the advancement of the position and the writing
   of the data are done in a single atomic operation is
   system-dependent and therefore unspecified.

   It will always be true that


   Redirect.appendTo(file).file() == file &&
   Redirect.appendTo(file).type() == Redirect.Type.APPEND

  file - The File for the Redirect. - `java.io.File`

  returns: a redirect to append to the specified file - `java.lang.ProcessBuilder.Redirect`

  throws: java.lang.NullPointerException - if the specified file is null"
  ([^java.io.File file]
    (ProcessBuilder$Redirect/appendTo file)))

(defn type
  "Returns the type of this Redirect.

  returns: the type of this Redirect - `java.lang.ProcessBuilder.Redirect.Type`"
  ([^java.lang.ProcessBuilder$Redirect this]
    (-> this (.type))))

(defn file
  "Returns the File source or destination associated
   with this redirect, or null if there is no such file.

  returns: the file associated with this redirect,
           or null if there is no such file - `java.io.File`"
  ([^java.lang.ProcessBuilder$Redirect this]
    (-> this (.file))))

(defn equals
  "Compares the specified object with this Redirect for
   equality.  Returns true if and only if the two
   objects are identical or both objects are Redirect
   instances of the same type associated with non-null equal
   File instances.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this object is the same as the obj
            argument; false otherwise. - `boolean`"
  ([^java.lang.ProcessBuilder$Redirect this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn hash-code
  "Returns a hash code value for this Redirect.

  returns: a hash code value for this Redirect - `int`"
  ([^java.lang.ProcessBuilder$Redirect this]
    (-> this (.hashCode))))

