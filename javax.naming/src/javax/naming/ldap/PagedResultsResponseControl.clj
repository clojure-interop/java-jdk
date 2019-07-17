(ns javax.naming.ldap.PagedResultsResponseControl
  "Indicates the end of a batch of search results.
  Contains an estimate of the total number of entries in the result set
  and an opaque cookie. The cookie must be supplied to the next search
  operation in order to get the next batch of results.

  The code sample in PagedResultsControl shows how this class may
  be used.

  This class implements the LDAPv3 Response Control for
  paged-results as defined in
  RFC 2696.

  The control's value has the following ASN.1 definition:


      realSearchControlValue ::= SEQUENCE {
          size      INTEGER (0..maxInt),
                            -- requested page size from client
                            -- result set size estimate from server
          cookie    OCTET STRING
      }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap PagedResultsResponseControl]))

(defn ->paged-results-response-control
  "Constructor.

  Constructs a paged-results response control.

  id - The control's object identifier string. - `java.lang.String`
  criticality - The control's criticality. - `boolean`
  value - The control's ASN.1 BER encoded value. It is not cloned - any changes to value will affect the contents of the control. - `byte[]`

  throws: java.io.IOException - If an error was encountered while decoding the control's value."
  ([^java.lang.String id ^Boolean criticality value]
    (new PagedResultsResponseControl id criticality value)))

(def *-oid
  "Static Constant.

  The paged-results response control's assigned object identifier
   is 1.2.840.113556.1.4.319.

  type: java.lang.String"
  PagedResultsResponseControl/OID)

(defn get-result-size
  "Retrieves (an estimate of) the number of entries in the search result.

  returns: The number of entries in the search result, or zero if unknown. - `int`"
  ([^javax.naming.ldap.PagedResultsResponseControl this]
    (-> this (.getResultSize))))

(defn get-cookie
  "Retrieves the server-generated cookie. Null is returned when there are
   no more entries for the server to return.

  returns: A possibly null server-generated cookie. It is not cloned - any
           changes to the cookie will update the control's state and thus
           are not recommended. - `byte[]`"
  ([^javax.naming.ldap.PagedResultsResponseControl this]
    (-> this (.getCookie))))

