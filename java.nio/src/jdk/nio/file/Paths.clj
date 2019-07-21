(ns jdk.nio.file.Paths
  "This class consists exclusively of static methods that return a Path
  by converting a path string or URI."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.file Paths]))

(defn *get
  "Converts a path string, or a sequence of strings that when joined form
   a path string, to a Path. If more does not specify any
   elements then the value of the first parameter is the path string
   to convert. If more specifies one or more elements then each
   non-empty string, including first, is considered to be a sequence
   of name elements (see Path) and is joined to form a path string.
   The details as to how the Strings are joined is provider specific but
   typically they will be joined using the name-separator as the separator. For example, if the name separator is
   \"/\" and getPath(\"/foo\",\"bar\",\"gus\") is invoked, then the
   path string \"/foo/bar/gus\" is converted to a Path.
   A Path representing an empty path is returned if first
   is the empty string and more does not contain any non-empty
   strings.

    The Path is obtained by invoking the getPath method of the default FileSystem.

    Note that while this method is very convenient, using it will imply
   an assumed reference to the default FileSystem and limit the
   utility of the calling code. Hence it should not be used in library code
   intended for flexible reuse. A more flexible alternative is to use an
   existing Path instance as an anchor, such as:


       Path dir = ...
       Path path = dir.resolve(\"file\");

  first - the path string or initial part of the path string - `java.lang.String`
  more - additional strings to be joined to form the path string - `java.lang.String`

  returns: the resulting Path - `java.nio.file.Path`

  throws: java.nio.file.InvalidPathException - if the path string cannot be converted to a Path"
  (^java.nio.file.Path [^java.lang.String first ^java.lang.String more]
    (Paths/get first more))
  (^java.nio.file.Path [^java.net.URI uri]
    (Paths/get uri)))

