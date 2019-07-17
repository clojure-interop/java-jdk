(ns javax.tools.StandardJavaFileManager
  "File manager based on java.io.java.io.File.  A common way
  to obtain an instance of this class is using getStandardFileManager, for example:



    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
     DiagnosticCollector<JavaFileObject> diagnostics =
        new  DiagnosticCollector<JavaFileObject>();
    StandardJavaFileManager fm = compiler.getStandardFileManager(diagnostics, null, null);

  This file manager creates file objects representing regular
  java.io.files,
  java.util.zip.zip file entries, or entries in
  similar file system based containers.  Any file object returned
  from a file manager implementing this interface must observe the
  following behavior:



      File names need not be canonical.


      For file objects representing regular files


          the method FileObject.delete()
          is equivalent to File.delete(),


          the method FileObject.getLastModified()
          is equivalent to File.lastModified(),


          the methods FileObject.getCharContent(boolean),
          FileObject.openInputStream(), and
          FileObject.openReader(boolean)
          must succeed if the following would succeed (ignoring
          encoding issues):



 new FileInputStream(new File(javax.tools.fileObject.toUri()))



          and the methods
          FileObject.openOutputStream(), and
          FileObject.openWriter() must
          succeed if the following would succeed (ignoring encoding
          issues):



 new FileOutputStream(new File(javax.tools.fileObject.toUri()))





      The java.net.URI returned from
      FileObject.toUri()


          must be absolute (have a schema), and


          must have a normalized
          path component which
          can be resolved without any process-specific context such
          as the current directory (file names must be absolute).





  According to these rules, the following URIs, for example, are
  allowed:


      file:///C:/Documents%20and%20Settings/UncleBob/BobsApp/Test.java


      jar:///C:/Documents%20and%20Settings/UncleBob/lib/vendorA.jar!com/vendora/LibraryClass.class


  Whereas these are not (reason in parentheses):


      file:BobsApp/Test.java (the file name is relative
      and depend on the current directory)


      jar:lib/vendorA.jar!com/vendora/LibraryClass.class
      (the first half of the path depends on the current directory,
      whereas the component after ! is legal)


      Test.java (this URI depends on the current
      directory and does not have a schema)


      jar:///C:/Documents%20and%20Settings/UncleBob/BobsApp/../lib/vendorA.jar!com/vendora/LibraryClass.class
      (the path is not normalized)"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools StandardJavaFileManager]))

(defn same-file?
  "Compares two file objects and return true if they represent the
   same canonical file, zip file entry, or entry in any file
   system based container.

  a - a file object - `javax.tools.FileObject`
  b - a file object - `javax.tools.FileObject`

  returns: true if the given file objects represent the same
   canonical file or zip file entry; false otherwise - `boolean`

  throws: java.lang.IllegalArgumentException - if either of the arguments were created with another file manager implementation"
  ([^. this ^javax.tools.FileObject a ^javax.tools.FileObject b]
    (-> this (.isSameFile a b))))

(defn get-java-file-objects-from-files
  "Gets file objects representing the given files.

  files - a list of files - `java.io.File>`

  returns: a list of file objects - `java.lang.Iterable<? extends javax.tools.JavaFileObject>`

  throws: java.lang.IllegalArgumentException - if the list of files includes a directory"
  ([^. this ^java.io.File> files]
    (-> this (.getJavaFileObjectsFromFiles files))))

(defn get-java-file-objects
  "Gets file objects representing the given files.
   Convenience method equivalent to:



       getJavaFileObjectsFromFiles(Arrays.asList(files))

  files - an array of files - `java.io.File`

  returns: a list of file objects - `java.lang.Iterable<? extends javax.tools.JavaFileObject>`

  throws: java.lang.IllegalArgumentException - if the array of files includes a directory"
  ([^. this ^java.io.File files]
    (-> this (.getJavaFileObjects files))))

(defn get-java-file-objects-from-strings
  "Gets file objects representing the given file names.

  names - a list of file names - `java.lang.Iterable<java.lang.String>`

  returns: a list of file objects - `java.lang.Iterable<? extends javax.tools.JavaFileObject>`

  throws: java.lang.IllegalArgumentException - if the list of file names includes a directory"
  ([^. this ^java.lang.Iterable names]
    (-> this (.getJavaFileObjectsFromStrings names))))

(defn set-location
  "Associates the given path with the given location.  Any
   previous value will be discarded.

  location - a location - `javax.tools.JavaFileManager.Location`
  path - a list of files, if null use the default path for this location - `java.io.File>`

  throws: java.lang.IllegalArgumentException - if location is an output location and path does not contain exactly one element"
  ([^. this ^javax.tools.JavaFileManager.Location location ^java.io.File> path]
    (-> this (.setLocation location path))))

(defn get-location
  "Gets the path associated with the given location.

  location - a location - `javax.tools.JavaFileManager.Location`

  returns: a list of files or null if this location has no
   associated path - `java.lang.Iterable<? extends java.io.File>`"
  ([^. this ^javax.tools.JavaFileManager.Location location]
    (-> this (.getLocation location))))

