(ns javax.xml.soap.SOAPPart
  "The container for the SOAP-specific portion of a SOAPMessage
  object. All messages are required to have a SOAP part, so when a
  SOAPMessage object is created, it will automatically
  have a SOAPPart object.

  A SOAPPart object is a MIME part and has the MIME headers
  Content-Id, Content-Location, and Content-Type.  Because the value of
  Content-Type must be \"text/xml\", a SOAPPart object automatically
  has a MIME header of Content-Type with its value set to \"text/xml\".
  The value must be \"text/xml\" because content in the SOAP part of a
  message must be in XML format.  Content that is not of type \"text/xml\"
  must be in an AttachmentPart object rather than in the
  SOAPPart object.

  When a message is sent, its SOAP part must have the MIME header Content-Type
  set to \"text/xml\". Or, from the other perspective, the SOAP part of any
  message that is received must have the MIME header Content-Type with a
  value of \"text/xml\".

  A client can access the SOAPPart object of a
  SOAPMessage object by
  calling the method SOAPMessage.getSOAPPart. The
  following  line of code, in which message is a
  SOAPMessage object, retrieves the SOAP part of a message.


    SOAPPart soapPart = message.getSOAPPart();

  A SOAPPart object contains a SOAPEnvelope object,
  which in turn contains a SOAPBody object and a
  SOAPHeader object.
  The SOAPPart method getEnvelope can be used
  to retrieve the SOAPEnvelope object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPPart]))

(defn ->soap-part
  "Constructor."
  (^SOAPPart []
    (new SOAPPart )))

(defn get-envelope
  "Gets the SOAPEnvelope object associated with this
   SOAPPart object. Once the SOAP envelope is obtained, it
   can be used to get its contents.

  returns: the SOAPEnvelope object for this
             SOAPPart object - `javax.xml.soap.SOAPEnvelope`

  throws: javax.xml.soap.SOAPException - if there is a SOAP error"
  (^javax.xml.soap.SOAPEnvelope [^SOAPPart this]
    (-> this (.getEnvelope))))

(defn add-mime-header
  "Creates a MimeHeader object with the specified
   name and value and adds it to this SOAPPart object.
   If a MimeHeader with the specified name already
   exists, this method adds the specified value to the already
   existing value(s).

   Note that RFC822 headers can contain only US-ASCII characters.

  name - a String giving the header name - `java.lang.String`
  value - a String giving the value to be set or added - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified mime header name or value"
  ([^SOAPPart this ^java.lang.String name ^java.lang.String value]
    (-> this (.addMimeHeader name value))))

(defn set-content-id
  "Sets the value of the MIME header named \"Content-Id\"
   to the given String.

  content-id - a String giving the value of the MIME header \"Content-Id\" - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there is a problem in setting the content id"
  ([^SOAPPart this ^java.lang.String content-id]
    (-> this (.setContentId content-id))))

(defn get-content-location
  "Retrieves the value of the MIME header whose name is \"Content-Location\".

  returns: a String giving the value of the MIME header whose
            name is \"Content-Location\" - `java.lang.String`"
  (^java.lang.String [^SOAPPart this]
    (-> this (.getContentLocation))))

(defn remove-all-mime-headers
  "Removes all the MimeHeader objects for this
   SOAPEnvelope object."
  ([^SOAPPart this]
    (-> this (.removeAllMimeHeaders))))

(defn get-non-matching-mime-headers
  "Retrieves all MimeHeader objects whose name does
   not match a name in the given array.

  names - a String array with the name(s) of the MIME headers not to be returned - `java.lang.String[]`

  returns: all of the MIME headers in this SOAPPart object
            except those that match one of the names in the
             given array.  The nonmatching MIME headers are returned as an
             Iterator object. - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPPart this names]
    (-> this (.getNonMatchingMimeHeaders names))))

(defn remove-mime-header
  "Removes all MIME headers that match the given name.

  header - a String giving the name of the MIME header(s) to be removed - `java.lang.String`"
  ([^SOAPPart this ^java.lang.String header]
    (-> this (.removeMimeHeader header))))

(defn set-content-location
  "Sets the value of the MIME header \"Content-Location\"
   to the given String.

  content-location - a String giving the value of the MIME header \"Content-Location\" - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there is a problem in setting the content location."
  ([^SOAPPart this ^java.lang.String content-location]
    (-> this (.setContentLocation content-location))))

(defn get-mime-header
  "Gets all the values of the MimeHeader object
   in this SOAPPart object that
   is identified by the given String.

  name - the name of the header; example: \"Content-Type\" - `java.lang.String`

  returns: a String array giving all the values for the
           specified header - `java.lang.String[]`"
  ([^SOAPPart this ^java.lang.String name]
    (-> this (.getMimeHeader name))))

(defn get-matching-mime-headers
  "Retrieves all MimeHeader objects that match a name in
   the given array.

  names - a String array with the name(s) of the MIME headers to be returned - `java.lang.String[]`

  returns: all of the MIME headers that match one of the names in the
             given array, returned as an Iterator object - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPPart this names]
    (-> this (.getMatchingMimeHeaders names))))

(defn get-all-mime-headers
  "Retrieves all the headers for this SOAPPart object
   as an iterator over the MimeHeader objects.

  returns: an Iterator object with all of the Mime
            headers for this SOAPPart object - `java.util.Iterator`"
  (^java.util.Iterator [^SOAPPart this]
    (-> this (.getAllMimeHeaders))))

(defn set-content
  "Sets the content of the SOAPEnvelope object with the data
   from the given Source object. This Source
   must contain a valid SOAP document.

  source - the javax.xml.transform.Source object with the data to be set - `javax.xml.transform.Source`

  throws: javax.xml.soap.SOAPException - if there is a problem in setting the source"
  ([^SOAPPart this ^javax.xml.transform.Source source]
    (-> this (.setContent source))))

(defn set-mime-header
  "Changes the first header entry that matches the given header name
   so that its value is the given value, adding a new header with the
   given name and value if no
   existing header is a match. If there is a match, this method clears
   all existing values for the first header that matches and sets the
   given value instead. If more than one header has
   the given name, this method removes all of the matching headers after
   the first one.

   Note that RFC822 headers can contain only US-ASCII characters.

  name - a String giving the header name for which to search - `java.lang.String`
  value - a String giving the value to be set. This value will be substituted for the current value(s) of the first header that is a match if there is one. If there is no match, this value will be the value for a new MimeHeader object. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if there was a problem with the specified mime header name or value"
  ([^SOAPPart this ^java.lang.String name ^java.lang.String value]
    (-> this (.setMimeHeader name value))))

(defn get-content
  "Returns the content of the SOAPEnvelope as a JAXP Source
   object.

  returns: the content as a javax.xml.transform.Source object - `javax.xml.transform.Source`

  throws: javax.xml.soap.SOAPException - if the implementation cannot convert the specified Source object"
  (^javax.xml.transform.Source [^SOAPPart this]
    (-> this (.getContent))))

(defn get-content-id
  "Retrieves the value of the MIME header whose name is \"Content-Id\".

  returns: a String giving the value of the MIME header
           named \"Content-Id\" - `java.lang.String`"
  (^java.lang.String [^SOAPPart this]
    (-> this (.getContentId))))

