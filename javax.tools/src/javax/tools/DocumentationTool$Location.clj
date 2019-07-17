(ns javax.tools.DocumentationTool$Location
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools DocumentationTool$Location]))

(def DOCUMENTATION_OUTPUT
  "Enum Constant.

  Location of new documentation files.

  type: javax.tools.DocumentationTool.Location"
  DocumentationTool$Location/DOCUMENTATION_OUTPUT)

(def DOCLET_PATH
  "Enum Constant.

  Location to search for doclets.

  type: javax.tools.DocumentationTool.Location"
  DocumentationTool$Location/DOCLET_PATH)

(def TAGLET_PATH
  "Enum Constant.

  Location to search for taglets.

  type: javax.tools.DocumentationTool.Location"
  DocumentationTool$Location/TAGLET_PATH)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (DocumentationTool.Location c : DocumentationTool.Location.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.tools.DocumentationTool.Location[]`"
  ([]
    (DocumentationTool$Location/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.tools.DocumentationTool.Location`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (DocumentationTool$Location/valueOf name)))

(defn get-name
  "Description copied from interface: JavaFileManager.Location

  returns: a name - `java.lang.String`"
  ([^javax.tools.DocumentationTool$Location this]
    (-> this (.getName))))

(defn output-location?
  "Description copied from interface: JavaFileManager.Location

  returns: true if this is an output location, false otherwise - `boolean`"
  ([^javax.tools.DocumentationTool$Location this]
    (-> this (.isOutputLocation))))

