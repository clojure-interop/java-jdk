(ns javax.xml.transform.sax.TransformerHandler
  "A TransformerHandler
  listens for SAX ContentHandler parse events and transforms
  them to a Result."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.sax TransformerHandler]))

(defn set-result
  "Set  the Result associated with this
   TransformerHandler to be used for the transformation.

  result - A Result instance, should not be null. - `javax.xml.transform.Result`

  throws: java.lang.IllegalArgumentException - if result is invalid for some reason."
  ([^javax.xml.transform.sax.TransformerHandler this ^javax.xml.transform.Result result]
    (-> this (.setResult result))))

(defn set-system-id
  "Set the base ID (URI or system ID) from where relative
   URLs will be resolved.

  system-id - Base URI for the source tree. - `java.lang.String`"
  ([^javax.xml.transform.sax.TransformerHandler this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the base ID (URI or system ID) from where relative
   URLs will be resolved.

  returns: The systemID that was set with setSystemId(java.lang.String). - `java.lang.String`"
  ([^javax.xml.transform.sax.TransformerHandler this]
    (-> this (.getSystemId))))

(defn get-transformer
  "Get the Transformer associated with this handler, which
   is needed in order to set parameters and output properties.

  returns: Transformer associated with this
     TransformerHandler. - `javax.xml.transform.Transformer`"
  ([^javax.xml.transform.sax.TransformerHandler this]
    (-> this (.getTransformer))))

