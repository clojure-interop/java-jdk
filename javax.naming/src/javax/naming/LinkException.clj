(ns javax.naming.LinkException
  "This exception is used to describe problems encounter while resolving links.
  Addition information is added to the base NamingException for pinpointing
  the problem with the link.

  Analogous to how NamingException captures name resolution information,
  LinkException captures `link`-name resolution information pinpointing
  the problem encountered while resolving a link. All these fields may
  be null.

   Link Resolved Name. Portion of link name that has been resolved.
   Link Resolved Object. Object to which resolution of link name proceeded.
   Link Remaining Name. Portion of link name that has not been resolved.
   Link Explanation. Detail explaining why link resolution failed.



  A LinkException instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single LinkException instance should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming LinkException]))

(defn ->link-exception
  "Constructor.

  Constructs a new instance of LinkException with an explanation
   All the other fields are initialized to null.

  explanation - A possibly null string containing additional detail about this exception. - `java.lang.String`"
  ([^java.lang.String explanation]
    (new LinkException explanation))
  ([]
    (new LinkException )))

(defn get-link-remaining-name
  "Retrieves the remaining unresolved portion of the link name.

  returns: The part of the link name that has not been resolved.
            It is a composite name. It can be null, which means
            the link remaining name field has not been set. - `javax.naming.Name`"
  ([^javax.naming.LinkException this]
    (-> this (.getLinkRemainingName))))

(defn get-link-resolved-name
  "Retrieves the leading portion of the link name that was resolved
   successfully.

  returns: The part of the link name that was resolved successfully.
            It is a composite name. It can be null, which means
            the link resolved name field has not been set. - `javax.naming.Name`"
  ([^javax.naming.LinkException this]
    (-> this (.getLinkResolvedName))))

(defn set-link-explanation
  "Sets the explanation associated with the problem encounter
   when resolving a link.

  msg - The possibly null detail string explaining more about the problem with resolving a link. If null, it means no detail will be recorded. - `java.lang.String`"
  ([^javax.naming.LinkException this ^java.lang.String msg]
    (-> this (.setLinkExplanation msg))))

(defn set-link-resolved-name
  "Sets the resolved link name field of this exception.

   name is a composite name. If the intent is to set
   this field using a compound name or string, you must
   `stringify` the compound name, and create a composite
   name with a single component using the string. You can then
   invoke this method using the resulting composite name.

   A copy of name is made and stored.
   Subsequent changes to name does not
   affect the copy in this NamingException and vice versa.

  name - The name to set resolved link name to. This can be null. If null, it sets the link resolved name field to null. - `javax.naming.Name`"
  ([^javax.naming.LinkException this ^javax.naming.Name name]
    (-> this (.setLinkResolvedName name))))

(defn to-string
  "Generates the string representation of this exception.
   This string consists of the NamingException information plus
   the additional information of resolving the link.
   If 'detail' is true, the string also contains information on
   the link resolved object. If false, this method is the same
   as the form of toString() that accepts no parameters.
   This string is used for debugging and not meant to be interpreted
   programmatically.

  detail - If true, add information about the link resolved object. - `boolean`

  returns: The non-null string representation of this link exception. - `java.lang.String`"
  ([^javax.naming.LinkException this ^Boolean detail]
    (-> this (.toString detail)))
  ([^javax.naming.LinkException this]
    (-> this (.toString))))

(defn get-link-explanation
  "Retrieves the explanation associated with the problem encounter
   when resolving a link.

  returns: The possibly null detail string explaining more about the problem
   with resolving a link.
           If null, it means there is no
           link detail message for this exception. - `java.lang.String`"
  ([^javax.naming.LinkException this]
    (-> this (.getLinkExplanation))))

(defn set-link-remaining-name
  "Sets the remaining link name field of this exception.

   name is a composite name. If the intent is to set
   this field using a compound name or string, you must
   `stringify` the compound name, and create a composite
   name with a single component using the string. You can then
   invoke this method using the resulting composite name.

   A copy of name is made and stored.
   Subsequent changes to name does not
   affect the copy in this NamingException and vice versa.

  name - The name to set remaining link name to. This can be null. If null, it sets the remaining name field to null. - `javax.naming.Name`"
  ([^javax.naming.LinkException this ^javax.naming.Name name]
    (-> this (.setLinkRemainingName name))))

(defn set-link-resolved-obj
  "Sets the link resolved object field of this exception.
   This indicates the last successfully resolved object of link name.

  obj - The object to set link resolved object to. This can be null. If null, the link resolved object field is set to null. - `java.lang.Object`"
  ([^javax.naming.LinkException this ^java.lang.Object obj]
    (-> this (.setLinkResolvedObj obj))))

(defn get-link-resolved-obj
  "Retrieves the object to which resolution was successful.
   This is the object to which the resolved link name is bound.

  returns: The possibly null object that was resolved so far.
   If null, it means the link resolved object field has not been set. - `java.lang.Object`"
  ([^javax.naming.LinkException this]
    (-> this (.getLinkResolvedObj))))

