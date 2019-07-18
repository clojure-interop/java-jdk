(ns javax.xml.transform.Templates
  "An object that implements this interface is the runtime representation of processed
  transformation instructions.

  Templates must be threadsafe for a given instance
  over multiple threads running concurrently, and may
  be used multiple times in a given session."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform Templates]))

(defn new-transformer
  "Create a new transformation context for this Templates object.

  returns: A valid non-null instance of a Transformer. - `javax.xml.transform.Transformer`

  throws: javax.xml.transform.TransformerConfigurationException - if a Transformer can not be created."
  (^javax.xml.transform.Transformer [^Templates this]
    (-> this (.newTransformer))))

(defn get-output-properties
  "Get the properties corresponding to the effective xsl:output element.
   The object returned will
   be a clone of the internal values. Accordingly, it can be mutated
   without mutating the Templates object, and then handed in to
   Transformer.setOutputProperties(java.util.Properties).

   The properties returned should contain properties set by the stylesheet,
   and these properties are `defaulted` by default properties specified by
   section 16 of the
   XSL Transformations (XSLT) W3C Recommendation.  The properties that
   were specifically set by the stylesheet should be in the base
   Properties list, while the XSLT default properties that were not
   specifically set should be in the `default` Properties list.  Thus,
   getOutputProperties().getProperty(String key) will obtain any
   property in that was set by the stylesheet, or the default
   properties, while
   getOutputProperties().get(String key) will only retrieve properties
   that were explicitly set in the stylesheet.

   For XSLT,
   Attribute
   Value Templates attribute values will
   be returned unexpanded (since there is no context at this point).  The
   namespace prefixes inside Attribute Value Templates will be unexpanded,
   so that they remain valid XPath values.

  returns: A Properties object, never null. - `java.util.Properties`"
  (^java.util.Properties [^Templates this]
    (-> this (.getOutputProperties))))

