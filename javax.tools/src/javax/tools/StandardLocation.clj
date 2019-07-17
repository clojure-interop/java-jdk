(ns javax.tools.StandardLocation
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools StandardLocation]))

(def CLASS_OUTPUT
  "Enum Constant.

  Location of new class files.

  type: javax.tools.StandardLocation"
  StandardLocation/CLASS_OUTPUT)

(def SOURCE_OUTPUT
  "Enum Constant.

  Location of new source files.

  type: javax.tools.StandardLocation"
  StandardLocation/SOURCE_OUTPUT)

(def CLASS_PATH
  "Enum Constant.

  Location to search for user class files.

  type: javax.tools.StandardLocation"
  StandardLocation/CLASS_PATH)

(def SOURCE_PATH
  "Enum Constant.

  Location to search for existing source files.

  type: javax.tools.StandardLocation"
  StandardLocation/SOURCE_PATH)

(def ANNOTATION_PROCESSOR_PATH
  "Enum Constant.

  Location to search for annotation processors.

  type: javax.tools.StandardLocation"
  StandardLocation/ANNOTATION_PROCESSOR_PATH)

(def PLATFORM_CLASS_PATH
  "Enum Constant.

  Location to search for platform classes.  Sometimes called
   the boot class path.

  type: javax.tools.StandardLocation"
  StandardLocation/PLATFORM_CLASS_PATH)

(def NATIVE_HEADER_OUTPUT
  "Enum Constant.

  Location of new native header files.

  type: javax.tools.StandardLocation"
  StandardLocation/NATIVE_HEADER_OUTPUT)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (StandardLocation c : StandardLocation.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.tools.StandardLocation[]`"
  ([]
    (StandardLocation/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.tools.StandardLocation`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([name]
    (StandardLocation/valueOf name)))

(defn *location-for
  "Gets a location object with the given name.  The following
   property must hold: locationFor(x) ==
   locationFor(y) if and only if x.equals(y).
   The returned location will be an output location if and only if
   name ends with `_OUTPUT`.

  name - a name - `java.lang.String`

  returns: a location - `javax.tools.JavaFileManager.Location`"
  ([name]
    (StandardLocation/locationFor name)))

(defn get-name
  "Description copied from interface: JavaFileManager.Location

  returns: a name - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn output-location?
  "Description copied from interface: JavaFileManager.Location

  returns: true if this is an output location, false otherwise - `boolean`"
  ([this]
    (-> this (.isOutputLocation))))

