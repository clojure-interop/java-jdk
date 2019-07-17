(ns javax.management.loading.MLetContent
  "This class represents the contents of the MLET tag.
  It can be consulted by a subclass of MLet that overrides
  the MLet.check method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management.loading MLetContent]))

(defn ->m-let-content
  "Constructor.

  Creates an MLet instance initialized with attributes read
   from an MLET tag in an MLet text file.

  url - The URL of the MLet text file containing the MLET tag. - `java.net.URL`
  attributes - A map of the attributes of the MLET tag. The keys in this map are the attribute names in lowercase, for example codebase. The values are the associated attribute values. - `java.util.Map<java.lang.String,java.lang.String>`
  types - A list of the TYPE attributes that appeared in nested <PARAM> tags. - `java.util.List<java.lang.String>`
  values - A list of the VALUE attributes that appeared in nested <PARAM> tags. - `java.util.List<java.lang.String>`"
  ([^java.net.URL url ^java.util.Map attributes ^java.util.List types ^java.util.List values]
    (new MLetContent url attributes types values)))

(defn get-code-base
  "Gets the code base URL.

  returns: The code base URL. - `java.net.URL`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getCodeBase))))

(defn get-jar-files
  "Gets the list of .jar files specified by the ARCHIVE
   attribute of the MLET tag.

  returns: A comma-separated list of .jar file names. - `java.lang.String`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getJarFiles))))

(defn get-code
  "Gets the value of the CODE
   attribute of the MLET tag.

  returns: The value of the CODE
   attribute of the MLET tag. - `java.lang.String`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getCode))))

(defn get-name
  "Gets the value of the NAME
   attribute of the MLET tag.

  returns: The value of the NAME
   attribute of the MLET tag. - `java.lang.String`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getName))))

(defn get-version
  "Gets the value of the VERSION
   attribute of the MLET tag.

  returns: The value of the VERSION
   attribute of the MLET tag. - `java.lang.String`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getVersion))))

(defn get-parameter-types
  "Gets the list of values of the TYPE attribute in
   each nested <PARAM> tag within the MLET
   tag.

  returns: the list of types. - `java.util.List<java.lang.String>`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getParameterTypes))))

(defn get-document-base
  "Gets the MLet text file's base URL.

  returns: The MLet text file's base URL. - `java.net.URL`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getDocumentBase))))

(defn get-serialized-object
  "Gets the value of the OBJECT
   attribute of the MLET tag.

  returns: The value of the OBJECT
   attribute of the MLET tag. - `java.lang.String`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getSerializedObject))))

(defn get-parameter-values
  "Gets the list of values of the VALUE attribute in
   each nested <PARAM> tag within the MLET
   tag.

  returns: the list of values. - `java.util.List<java.lang.String>`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getParameterValues))))

(defn get-attributes
  "Gets the attributes of the MLET tag.  The keys in
   the returned map are the attribute names in lowercase, for
   example codebase.  The values are the associated
   attribute values.

  returns: A map of the attributes of the MLET tag
   and their values. - `java.util.Map<java.lang.String,java.lang.String>`"
  ([^javax.management.loading.MLetContent this]
    (-> this (.getAttributes))))

