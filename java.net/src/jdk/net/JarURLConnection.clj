(ns jdk.net.JarURLConnection
  "A URL Connection to a Java ARchive (JAR) file or an entry in a JAR
  file.

  The syntax of a JAR URL is:



  jar:<url>!/{entry}

  for example:

  jar:http://www.foo.com/bar/baz.jar!/COM/foo/Quux.class

  Jar URLs should be used to refer to a JAR file or entries in
  a JAR file. The example above is a JAR URL which refers to a JAR
  entry. If the entry name is omitted, the URL refers to the whole
  JAR file:

  jar:http://www.foo.com/bar/baz.jar!/

  Users should cast the generic URLConnection to a
  JarURLConnection when they know that the URL they created is a JAR
  URL, and they need JAR-specific functionality. For example:



  URL url = new URL(`jar:file:/home/duke/duke.jar!/`);
  JarURLConnection jarConnection = (JarURLConnection)url.openConnection();
  Manifest manifest = jarConnection.getManifest();

  JarURLConnection instances can only be used to read from JAR files.
  It is not possible to get a OutputStream to modify or write
  to the underlying JAR file using this class.
  Examples:



  A Jar entry
  jar:http://www.foo.com/bar/baz.jar!/COM/foo/Quux.class

  A Jar file
  jar:http://www.foo.com/bar/baz.jar!/

  A Jar directory
  jar:http://www.foo.com/bar/baz.jar!/COM/foo/



  !/ is referred to as the separator.

  When constructing a JAR url via new URL(context, spec),
  the following rules apply:



  if there is no context URL and the specification passed to the
  URL constructor doesn't contain a separator, the URL is considered
  to refer to a JarFile.

  if there is a context URL, the context URL is assumed to refer
  to a JAR file or a Jar directory.

  if the specification begins with a '/', the Jar directory is
  ignored, and the spec is considered to be at the root of the Jar
  file.

  Examples:



  context: jar:http://www.foo.com/bar/jar.jar!/,
  spec:baz/entry.txt

  url:jar:http://www.foo.com/bar/jar.jar!/baz/entry.txt

  context: jar:http://www.foo.com/bar/jar.jar!/baz,
  spec:entry.txt

  url:jar:http://www.foo.com/bar/jar.jar!/baz/entry.txt

  context: jar:http://www.foo.com/bar/jar.jar!/baz,
  spec:/entry.txt

  url:jar:http://www.foo.com/bar/jar.jar!/entry.txt"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net JarURLConnection]))

(defn get-jar-file-url
  "Returns the URL for the Jar file for this connection.

  returns: the URL for the Jar file for this connection. - `java.net.URL`"
  (^java.net.URL [^java.net.JarURLConnection this]
    (-> this (.getJarFileURL))))

(defn get-entry-name
  "Return the entry name for this connection. This method
   returns null if the JAR file URL corresponding to this
   connection points to a JAR file and not a JAR file entry.

  returns: the entry name for this connection, if any. - `java.lang.String`"
  (^java.lang.String [^java.net.JarURLConnection this]
    (-> this (.getEntryName))))

(defn get-jar-file
  "Return the JAR file for this connection.

  returns: the JAR file for this connection. If the connection is
   a connection to an entry of a JAR file, the JAR file object is
   returned - `java.util.jar.JarFile`

  throws: java.io.IOException - if an IOException occurs while trying to connect to the JAR file for this connection."
  (^java.util.jar.JarFile [^java.net.JarURLConnection this]
    (-> this (.getJarFile))))

(defn get-manifest
  "Returns the Manifest for this connection, or null if none.

  returns: the manifest object corresponding to the JAR file object
   for this connection. - `java.util.jar.Manifest`

  throws: java.io.IOException - if getting the JAR file for this connection causes an IOException to be thrown."
  (^java.util.jar.Manifest [^java.net.JarURLConnection this]
    (-> this (.getManifest))))

(defn get-jar-entry
  "Return the JAR entry object for this connection, if any. This
   method returns null if the JAR file URL corresponding to this
   connection points to a JAR file and not a JAR file entry.

  returns: the JAR entry object for this connection, or null if
   the JAR URL for this connection points to a JAR file. - `java.util.jar.JarEntry`

  throws: java.io.IOException - if getting the JAR file for this connection causes an IOException to be thrown."
  (^java.util.jar.JarEntry [^java.net.JarURLConnection this]
    (-> this (.getJarEntry))))

(defn get-attributes
  "Return the Attributes object for this connection if the URL
   for it points to a JAR file entry, null otherwise.

  returns: the Attributes object for this connection if the URL
   for it points to a JAR file entry, null otherwise. - `java.util.jar.Attributes`

  throws: java.io.IOException - if getting the JAR entry causes an IOException to be thrown."
  (^java.util.jar.Attributes [^java.net.JarURLConnection this]
    (-> this (.getAttributes))))

(defn get-main-attributes
  "Returns the main Attributes for the JAR file for this
   connection.

  returns: the main Attributes for the JAR file for this
   connection. - `java.util.jar.Attributes`

  throws: java.io.IOException - if getting the manifest causes an IOException to be thrown."
  (^java.util.jar.Attributes [^java.net.JarURLConnection this]
    (-> this (.getMainAttributes))))

(defn get-certificates
  "Return the Certificate object for this connection if the URL
   for it points to a JAR file entry, null otherwise. This method
   can only be called once
   the connection has been completely verified by reading
   from the input stream until the end of the stream has been
   reached. Otherwise, this method will return null

  returns: the Certificate object for this connection if the URL
   for it points to a JAR file entry, null otherwise. - `java.security.cert.Certificate[]`

  throws: java.io.IOException - if getting the JAR entry causes an IOException to be thrown."
  ([^java.net.JarURLConnection this]
    (-> this (.getCertificates))))

