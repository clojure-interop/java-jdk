(ns javax.naming.ldap.SortResponseControl
  "Indicates whether the requested sort of search results was successful or not.
  When the result code indicates success then the results have been sorted as
  requested. Otherwise the sort was unsuccessful and additional details
  regarding the cause of the error may have been provided by the server.

  The code sample in SortControl shows how this class may be used.

  This class implements the LDAPv3 Response Control for server-side sorting
  as defined in
  RFC 2891.

  The control's value has the following ASN.1 definition:


      SortResult ::= SEQUENCE {
         sortResult  ENUMERATED {
             success                   (0), -- results are sorted
             operationsError           (1), -- server internal failure
             timeLimitExceeded         (3), -- timelimit reached before
                                            -- sorting was completed
             strongAuthRequired        (8), -- refused to return sorted
                                            -- results via insecure
                                            -- protocol
             adminLimitExceeded       (11), -- too many matching entries
                                            -- for the server to sort
             noSuchAttribute          (16), -- unrecognized attribute
                                            -- type in sort key
             inappropriateMatching    (18), -- unrecognized or inappro-
                                            -- priate matching rule in
                                            -- sort key
             insufficientAccessRights (50), -- refused to return sorted
                                            -- results to this client
             busy                     (51), -- too busy to process
             unwillingToPerform       (53), -- unable to sort
             other                    (80)
             },
       attributeType [0] AttributeType OPTIONAL }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap SortResponseControl]))

(defn ->sort-response-control
  "Constructor.

  Constructs a control to indicate the outcome of a sort request.

  id - The control's object identifier string. - `java.lang.String`
  criticality - The control's criticality. - `boolean`
  value - The control's ASN.1 BER encoded value. It is not cloned - any changes to value will affect the contents of the control. - `byte[]`

  throws: java.io.IOException - if an error is encountered while decoding the control's value."
  ([id criticality value]
    (new SortResponseControl id criticality value)))

(def *-oid
  "Static Constant.

  The server-side sort response control's assigned object identifier
   is 1.2.840.113556.1.4.474.

  type: java.lang.String"
  SortResponseControl/OID)

(defn sorted?
  "Determines if the search results have been successfully sorted.
   If an error occurred during sorting a NamingException is thrown.

  returns: true if the search results have been sorted. - `boolean`"
  ([this]
    (-> this (.isSorted))))

(defn get-result-code
  "Retrieves the LDAP result code of the sort operation.

  returns: The result code. A zero value indicates success. - `int`"
  ([this]
    (-> this (.getResultCode))))

(defn get-attribute-id
  "Retrieves the ID of the attribute that caused the sort to fail.
   Returns null if no ID was returned by the server.

  returns: The possibly null ID of the bad attribute. - `java.lang.String`"
  ([this]
    (-> this (.getAttributeID))))

(defn get-exception
  "Retrieves the NamingException appropriate for the result code.

  returns: A NamingException or null if the result code indicates
           success. - `javax.naming.NamingException`"
  ([this]
    (-> this (.getException))))

