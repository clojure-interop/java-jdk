(ns javax.xml.transform.sax.SAXResult
  "Acts as an holder for a transformation Result."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.transform.sax SAXResult]))

(defn ->sax-result
  "Constructor.

  Create a SAXResult that targets a SAX2 ContentHandler.

  handler - Must be a non-null ContentHandler reference. - `org.xml.sax.ContentHandler`"
  (^SAXResult [^org.xml.sax.ContentHandler handler]
    (new SAXResult handler))
  (^SAXResult []
    (new SAXResult )))

(def *-feature
  "Static Constant.

  If TransformerFactory.getFeature(java.lang.String)
   returns true when passed this value as an argument,
   the Transformer supports Result output of this type.

  type: java.lang.String"
  SAXResult/FEATURE)

(defn set-handler
  "Set the target to be a SAX2 ContentHandler.

  handler - Must be a non-null ContentHandler reference. - `org.xml.sax.ContentHandler`"
  ([^SAXResult this ^org.xml.sax.ContentHandler handler]
    (-> this (.setHandler handler))))

(defn get-handler
  "Get the ContentHandler that is the Result.

  returns: The ContentHandler that is to be transformation output. - `org.xml.sax.ContentHandler`"
  (^org.xml.sax.ContentHandler [^SAXResult this]
    (-> this (.getHandler))))

(defn set-lexical-handler
  "Set the SAX2 LexicalHandler for the output.

   This is needed to handle XML comments and the like.  If the
   lexical handler is not set, an attempt should be made by the
   transformer to cast the ContentHandler to a
   LexicalHandler.

  handler - A non-null LexicalHandler for handling lexical parse events. - `org.xml.sax.ext.LexicalHandler`"
  ([^SAXResult this ^org.xml.sax.ext.LexicalHandler handler]
    (-> this (.setLexicalHandler handler))))

(defn get-lexical-handler
  "Get a SAX2 LexicalHandler for the output.

  returns: A LexicalHandler, or null. - `org.xml.sax.ext.LexicalHandler`"
  (^org.xml.sax.ext.LexicalHandler [^SAXResult this]
    (-> this (.getLexicalHandler))))

(defn set-system-id
  "Method setSystemId Set the systemID that may be used in association
   with the ContentHandler.

  system-id - The system identifier as a URI string. - `java.lang.String`"
  ([^SAXResult this ^java.lang.String system-id]
    (-> this (.setSystemId system-id))))

(defn get-system-id
  "Get the system identifier that was set with setSystemId.

  returns: The system identifier that was set with setSystemId, or null
   if setSystemId was not called. - `java.lang.String`"
  (^java.lang.String [^SAXResult this]
    (-> this (.getSystemId))))

