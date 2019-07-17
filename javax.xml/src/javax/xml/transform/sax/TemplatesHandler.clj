(ns javax.xml.transform.sax.TemplatesHandler
  "A SAX ContentHandler that may be used to process SAX
  parse events (parsing transformation instructions) into a Templates object.

  Note that TemplatesHandler does not need to implement LexicalHandler."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.sax TemplatesHandler]))

(defn get-templates
  "When a TemplatesHandler object is used as a ContentHandler
   for the parsing of transformation instructions, it creates a Templates object,
   which the caller can get once the SAX events have been completed.

  returns: The Templates object that was created during
   the SAX event process, or null if no Templates object has
   been created. - `javax.xml.transform.Templates`"
  (^javax.xml.transform.Templates [^javax.xml.transform.sax.TemplatesHandler this]
    (-> this (.getTemplates))))

(defn set-system-id
  "Set the base ID (URI or system ID) for the Templates object
   created by this builder.  This must be set in order to
   resolve relative URIs in the stylesheet.  This must be
   called before the startDocument event.

  system-id - Base URI for this stylesheet. - `java.lang.String`"
  ([^javax.xml.transform.sax.TemplatesHandler this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the base ID (URI or system ID) from where relative
   URLs will be resolved.

  returns: The systemID that was set with setSystemId(java.lang.String). - `java.lang.String`"
  (^java.lang.String [^javax.xml.transform.sax.TemplatesHandler this]
    (-> this (.getSystemId))))

