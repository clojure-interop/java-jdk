(ns javax.xml.validation.SchemaFactoryLoader
  "Factory that creates SchemaFactory.

  DO NOT USE THIS CLASS


  This class was introduced as a part of an early proposal during the
  JSR-206 standardization process. The proposal was eventually abandoned
  but this class accidentally remained in the source tree, and made its
  way into the final version.

  This class does not participate in any JAXP 1.3 or JAXP 1.4 processing.
  It must not be used by users or JAXP implementations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.validation SchemaFactoryLoader]))

(defn new-factory
  "Creates a new SchemaFactory object for the specified
   schema language.

  schema-language - See the list of available schema languages. - `java.lang.String`

  returns: null if the callee fails to create one. - `javax.xml.validation.SchemaFactory`

  throws: java.lang.NullPointerException - If the schemaLanguage parameter is null."
  (^javax.xml.validation.SchemaFactory [^SchemaFactoryLoader this ^java.lang.String schema-language]
    (-> this (.newFactory schema-language))))

