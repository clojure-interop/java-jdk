(ns jdk.util.PropertyResourceBundle
  "PropertyResourceBundle is a concrete subclass of
  ResourceBundle that manages resources for a locale
  using a set of static strings from a property file. See
  ResourceBundle for more information about resource
  bundles.


  Unlike other types of resource bundle, you don't subclass
  PropertyResourceBundle.  Instead, you supply properties
  files containing the resource data.  ResourceBundle.getBundle
  will automatically look for the appropriate properties file and create a
  PropertyResourceBundle that refers to it. See
  ResourceBundle.getBundle
  for a complete description of the search and instantiation strategy.


  The following example shows a member of a resource
  bundle family with the base name `MyResources`.
  The text defines the bundle `MyResources_de`,
  the German member of the bundle family.
  This member is based on PropertyResourceBundle, and the text
  therefore is the content of the file `MyResources_de.properties`
  (a related example shows
  how you can add bundles to this family that are implemented as subclasses
  of ListResourceBundle).
  The keys in this example are of the form `s1` etc. The actual
  keys are entirely up to your choice, so long as they are the same as
  the keys you use in your program to retrieve the objects from the bundle.
  Keys are case-sensitive.



  # MessageFormat pattern
  s1=Die Platte \`{1}\` enthält {0}.

  # location of {0} in pattern
  s2=1

  # sample disk name
  s3=Meine Platte

  # first ChoiceFormat choice
  s4=keine Dateien

  # second ChoiceFormat choice
  s5=eine Datei

  # third ChoiceFormat choice
  s6={0,number} Dateien

  # sample date
  s7=3. März 1996



  The implementation of a PropertyResourceBundle subclass must be
  thread-safe if it's simultaneously used by multiple threads. The default
  implementations of the non-abstract methods in this class are thread-safe.


  Note: PropertyResourceBundle can be constructed either
  from an InputStream or a Reader, which represents a property file.
  Constructing a PropertyResourceBundle instance from an InputStream requires
  that the input stream be encoded in ISO-8859-1.  In that case, characters
  that cannot be represented in ISO-8859-1 encoding must be represented by Unicode Escapes
  as defined in section 3.3 of
  The Java™ Language Specification
  whereas the other constructor which takes a Reader does not have that limitation."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.util PropertyResourceBundle]))

(defn ->property-resource-bundle
  "Constructor.

  Creates a property resource bundle from an InputStream.  The property file read with this constructor
   must be encoded in ISO-8859-1.

  stream - an InputStream that represents a property file to read from. - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error occurs"
  ([^java.io.InputStream stream]
    (new PropertyResourceBundle stream)))

(defn handle-get-object
  "Description copied from class: ResourceBundle

  key - the key for the desired object - `java.lang.String`

  returns: the object for the given key, or null - `java.lang.Object`"
  (^java.lang.Object [^java.util.PropertyResourceBundle this ^java.lang.String key]
    (-> this (.handleGetObject key))))

(defn get-keys
  "Returns an Enumeration of the keys contained in
   this ResourceBundle and its parent bundles.

  returns: an Enumeration of the keys contained in
           this ResourceBundle and its parent bundles. - `java.util.Enumeration<java.lang.String>`"
  (^java.util.Enumeration [^java.util.PropertyResourceBundle this]
    (-> this (.getKeys))))

