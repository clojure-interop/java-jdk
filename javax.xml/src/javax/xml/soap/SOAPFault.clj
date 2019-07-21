(ns javax.xml.soap.SOAPFault
  "An element in the SOAPBody object that contains
  error and/or status information. This information may relate to
  errors in the SOAPMessage object or to problems
  that are not related to the content in the message itself. Problems
  not related to the message itself are generally errors in
  processing, such as the inability to communicate with an upstream
  server.

  Depending on the protocol specified while creating the
  MessageFactory instance,  a SOAPFault has
  sub-elements as defined in the SOAP 1.1/SOAP 1.2 specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap SOAPFault]))

(defn add-fault-reason-text
  "Appends or replaces a Reason Text item containing the specified
   text message and an xml:lang derived from
   locale. If a Reason Text item with this
   xml:lang already exists its text value will be replaced
   with text.
   The locale parameter should not be null

   Code sample:



   SOAPFault fault = ...;
   fault.addFaultReasonText(\"Version Mismatch\", Locale.ENGLISH);

  text - -- reason message string - `java.lang.String`
  locale - -- Locale object representing the locale of the message - `java.util.Locale`

  throws: javax.xml.soap.SOAPException - if there was an error in adding the Reason text or the locale passed was null."
  ([^SOAPFault this ^java.lang.String text ^java.util.Locale locale]
    (-> this (.addFaultReasonText text locale))))

(defn set-fault-string
  "Sets the fault string for this SOAPFault object
   to the given string and localized to the given locale.

   If this
   SOAPFault is part of a message that supports SOAP 1.2 then
   this call is equivalent to:


        addFaultReasonText(faultString, locale);

  fault-string - a String giving an explanation of the fault - `java.lang.String`
  locale - a Locale object indicating the native language of the faultString - `java.util.Locale`

  throws: javax.xml.soap.SOAPException - if there was an error in adding the faultString to the underlying XML tree."
  ([^SOAPFault this ^java.lang.String fault-string ^java.util.Locale locale]
    (-> this (.setFaultString fault-string locale)))
  ([^SOAPFault this ^java.lang.String fault-string]
    (-> this (.setFaultString fault-string))))

(defn get-fault-reason-text
  "Returns the Reason Text associated with the given Locale.
   If more than one such Reason Text exists the first matching Text is
   returned

  locale - -- the Locale for which a localized Reason Text is desired - `java.util.Locale`

  returns: the Reason Text associated with locale - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if there was an error in retrieving the fault Reason text for the specified locale ."
  (^java.lang.String [^SOAPFault this ^java.util.Locale locale]
    (-> this (.getFaultReasonText locale))))

(defn set-fault-actor
  "Sets this SOAPFault object with the given fault actor.

   The fault actor is the recipient in the message path who caused the
   fault to happen.

   If this SOAPFault supports SOAP 1.2 then this call is
   equivalent to setFaultRole(String)

  fault-actor - a String identifying the actor that caused this SOAPFault object - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if there was an error in adding the faultActor to the underlying XML tree."
  ([^SOAPFault this ^java.lang.String fault-actor]
    (-> this (.setFaultActor fault-actor))))

(defn get-fault-actor
  "Gets the fault actor for this SOAPFault object.

   If this SOAPFault supports SOAP 1.2 then this call is
   equivalent to getFaultRole()

  returns: a String giving the actor in the message path
           that caused this SOAPFault object - `java.lang.String`"
  (^java.lang.String [^SOAPFault this]
    (-> this (.getFaultActor))))

(defn get-fault-subcodes
  "Gets the Subcodes for this SOAPFault as an iterator over
   QNames.

  returns: an Iterator that accesses a sequence of
        QNames. This Iterator should not support
        the optional remove method. The order in which the
        Subcodes are returned reflects the hierarchy of Subcodes present
        in the fault from top to bottom. - `java.util.Iterator`

  throws: java.lang.UnsupportedOperationException - if this message does not support the SOAP 1.2 concept of Subcode."
  (^java.util.Iterator [^SOAPFault this]
    (-> this (.getFaultSubcodes))))

(defn get-fault-reason-locales
  "Returns an Iterator over a distinct sequence of
   Locales for which there are associated Reason Text items.
   Any of these Locales can be used in a call to
   getFaultReasonText in order to obtain a localized version
   of the Reason Text string.

  returns: an Iterator over a sequence of Locale
        objects for which there are associated Reason Text items. - `java.util.Iterator`

  throws: javax.xml.soap.SOAPException - if there was an error in retrieving the fault Reason locales."
  (^java.util.Iterator [^SOAPFault this]
    (-> this (.getFaultReasonLocales))))

(defn remove-all-fault-subcodes
  "Removes any Subcodes that may be contained by this
   SOAPFault. Subsequent calls to
   getFaultSubcodes will return an empty iterator until a call
   to appendFaultSubcode is made.

  throws: java.lang.UnsupportedOperationException - if this message does not support the SOAP 1.2 concept of Subcode."
  ([^SOAPFault this]
    (-> this (.removeAllFaultSubcodes))))

(defn get-fault-code-as-name
  "Gets the mandatory SOAP 1.1 fault code for this
   SOAPFault object as a SAAJ Name object.
   The SOAP 1.1 specification requires the value of the \"faultcode\"
   element to be of type QName. This method returns the content of the
   element as a QName in the form of a SAAJ Name object. This method
   should be used instead of the getFaultCode method since
   it allows applications to easily access the namespace name without
   additional parsing.

  returns: a Name representing the faultcode - `javax.xml.soap.Name`"
  (^javax.xml.soap.Name [^SOAPFault this]
    (-> this (.getFaultCodeAsName))))

(defn set-fault-node
  "Creates or replaces any existing Node element value for
   this SOAPFault object. The Node element
   is optional in SOAP 1.2.

  uri - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if there was an error in setting the Node for this SOAPFault object."
  ([^SOAPFault this ^java.lang.String uri]
    (-> this (.setFaultNode uri))))

(defn get-fault-node
  "Returns the optional Node element value for this
   SOAPFault object. The Node element is
   optional in SOAP 1.2.

  returns: Content of the env:Fault/env:Node element as a String
   or null if none - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this message does not support the SOAP 1.2 concept of Fault Node."
  (^java.lang.String [^SOAPFault this]
    (-> this (.getFaultNode))))

(defn set-fault-role
  "Creates or replaces any existing Role element value for
   this SOAPFault object. The Role element
   is optional in SOAP 1.2.

  uri - - the URI of the Role - `java.lang.String`

  throws: javax.xml.soap.SOAPException - if there was an error in setting the Role for this SOAPFault object."
  ([^SOAPFault this ^java.lang.String uri]
    (-> this (.setFaultRole uri))))

(defn append-fault-subcode
  "Adds a Subcode to the end of the sequence of Subcodes contained by this
   SOAPFault. Subcodes, which were introduced in SOAP 1.2, are
   represented by a recursive sequence of subelements rooted in the
   mandatory Code subelement of a SOAP Fault.

  subcode - a QName containing the Value of the Subcode. - `javax.xml.namespace.QName`

  throws: javax.xml.soap.SOAPException - if there was an error in setting the Subcode"
  ([^SOAPFault this ^javax.xml.namespace.QName subcode]
    (-> this (.appendFaultSubcode subcode))))

(defn get-fault-code
  "Gets the fault code for this SOAPFault object.

  returns: a String with the fault code - `java.lang.String`"
  (^java.lang.String [^SOAPFault this]
    (-> this (.getFaultCode))))

(defn get-fault-role
  "Returns the optional Role element value for this
   SOAPFault object. The Role element is
   optional in SOAP 1.2.

  returns: Content of the env:Fault/env:Role element as a String
   or null if none - `java.lang.String`

  throws: java.lang.UnsupportedOperationException - if this message does not support the SOAP 1.2 concept of Fault Role."
  (^java.lang.String [^SOAPFault this]
    (-> this (.getFaultRole))))

(defn get-fault-code-as-q-name
  "Gets the fault code for this
   SOAPFault object as a QName object.

  returns: a QName representing the faultcode - `javax.xml.namespace.QName`"
  (^javax.xml.namespace.QName [^SOAPFault this]
    (-> this (.getFaultCodeAsQName))))

(defn has-detail?
  "Returns true if this SOAPFault has a Detail
   subelement and false otherwise. Equivalent to
   (getDetail()!=null).

  returns: true if this SOAPFault has a Detail
   subelement and false otherwise. - `boolean`"
  (^Boolean [^SOAPFault this]
    (-> this (.hasDetail))))

(defn get-fault-string
  "Gets the fault string for this SOAPFault object.

   If this
   SOAPFault is part of a message that supports SOAP 1.2 then
   this call is equivalent to:


      String reason = null;
      try {
          reason = (String) getFaultReasonTexts().next();
      } catch (SOAPException e) {}
      return reason;

  returns: a String giving an explanation of
          the fault - `java.lang.String`"
  (^java.lang.String [^SOAPFault this]
    (-> this (.getFaultString))))

(defn get-fault-reason-texts
  "Returns an Iterator over a sequence of
   String objects containing all of the Reason Text items for
   this SOAPFault.

  returns: an Iterator over env:Fault/env:Reason/env:Text items. - `java.util.Iterator`

  throws: javax.xml.soap.SOAPException - if there was an error in retrieving the fault Reason texts."
  (^java.util.Iterator [^SOAPFault this]
    (-> this (.getFaultReasonTexts))))

(defn add-detail
  "Creates an optional Detail object and sets it as the
   Detail object for this SOAPFault
   object.

   It is illegal to add a detail when the fault already
   contains a detail. Therefore, this method should be called
   only after the existing detail has been removed.

  returns: the new Detail object - `javax.xml.soap.Detail`

  throws: javax.xml.soap.SOAPException - if this SOAPFault object already contains a valid Detail object"
  (^javax.xml.soap.Detail [^SOAPFault this]
    (-> this (.addDetail))))

(defn get-detail
  "Returns the optional detail element for this SOAPFault
   object.

   A Detail object carries application-specific error
   information, the scope of the error information is restricted to
   faults in the SOAPBodyElement objects if this is a
   SOAP 1.1 Fault.

  returns: a Detail object with application-specific
           error information if present, null otherwise - `javax.xml.soap.Detail`"
  (^javax.xml.soap.Detail [^SOAPFault this]
    (-> this (.getDetail))))

(defn set-fault-code
  "Sets this SOAPFault object with the given fault code.

    Fault codes, which give information about the fault, are defined
   in the SOAP 1.1 specification. A fault code is mandatory and must
   be of type Name. This method provides a convenient
   way to set a fault code. For example,



   SOAPEnvelope se = ...;
   // Create a qualified name in the SOAP namespace with a localName
   // of \"Client\". Note that prefix parameter is optional and is null
   // here which causes the implementation to use an appropriate prefix.
   Name qname = se.createName(\"Client\", null,
                              SOAPConstants.URI_NS_SOAP_ENVELOPE);
   SOAPFault fault = ...;
   fault.setFaultCode(qname);
   It is preferable to use this method over setFaultCode(String).

  fault-code-q-name - a Name object giving the fault code to be set. It must be namespace qualified. - `javax.xml.soap.Name`

  throws: javax.xml.soap.SOAPException - if there was an error in adding the faultcode element to the underlying XML tree."
  ([^SOAPFault this ^javax.xml.soap.Name fault-code-q-name]
    (-> this (.setFaultCode fault-code-q-name))))

(defn get-fault-string-locale
  "Gets the locale of the fault string for this SOAPFault
   object.

   If this
   SOAPFault is part of a message that supports SOAP 1.2 then
   this call is equivalent to:


      Locale locale = null;
      try {
          locale = (Locale) getFaultReasonLocales().next();
      } catch (SOAPException e) {}
      return locale;

  returns: a Locale object indicating the native language of
            the fault string or null if no locale was specified - `java.util.Locale`"
  (^java.util.Locale [^SOAPFault this]
    (-> this (.getFaultStringLocale))))

