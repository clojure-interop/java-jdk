(ns jdk.nio.charset.spi.CharsetProvider
  "Charset service-provider class.

   A charset provider is a concrete subclass of this class that has a
  zero-argument constructor and some number of associated charset
  implementation classes.  Charset providers may be installed in an instance
  of the Java platform as extensions, that is, jar files placed into any of
  the usual extension directories.  Providers may also be made available by
  adding them to the applet or application class path or by some other
  platform-specific means.  Charset providers are looked up via the current
  thread's context class
  loader.

   A charset provider identifies itself with a provider-configuration file
  named java.nio.charset.spi.CharsetProvider in the resource
  directory META-INF/services.  The file should contain a list of
  fully-qualified concrete charset-provider class names, one per line.  A line
  is terminated by any one of a line feed ('\n'), a carriage return
  ('\r'), or a carriage return followed immediately by a line feed.
  Space and tab characters surrounding each name, as well as blank lines, are
  ignored.  The comment character is '#' ('\u0023'); on
  each line all characters following the first comment character are ignored.
  The file must be encoded in UTF-8.

   If a particular concrete charset provider class is named in more than
  one configuration file, or is named in the same configuration file more than
  once, then the duplicates will be ignored.  The configuration file naming a
  particular provider need not be in the same jar file or other distribution
  unit as the provider itself.  The provider must be accessible from the same
  class loader that was initially queried to locate the configuration file;
  this is not necessarily the class loader that loaded the file."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.nio.charset.spi CharsetProvider]))

(defn charsets
  "Creates an iterator that iterates over the charsets supported by this
   provider.  This method is used in the implementation of the Charset.availableCharsets
   method.

  returns: The new iterator - `java.util.Iterator<java.nio.charset.Charset>`"
  ([this]
    (-> this (.charsets))))

(defn charset-for-name
  "Retrieves a charset for the given charset name.

  charset-name - The name of the requested charset; may be either a canonical name or an alias - `java.lang.String`

  returns: A charset object for the named charset,
            or null if the named charset
            is not supported by this provider - `java.nio.charset.Charset`"
  ([this charset-name]
    (-> this (.charsetForName charset-name))))

