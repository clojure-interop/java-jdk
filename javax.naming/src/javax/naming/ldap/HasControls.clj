(ns javax.naming.ldap.HasControls
  "This interface is for returning controls with objects returned
  in NamingEnumerations.
  For example, suppose a server sends back controls with the results
  of a search operation, the service provider would return a NamingEnumeration of
  objects that are both SearchResult and implement HasControls.


    NamingEnumeration elts = ectx.search((Name)name, filter, sctls);
    while (elts.hasMore()) {
      Object entry = elts.next();

      // Get search result
      SearchResult res = (SearchResult)entry;
      // do something with it

      // Get entry controls
      if (entry instanceof HasControls) {
          Control[] entryCtls = ((HasControls)entry).getControls();
          // do something with controls
      }
    }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap HasControls]))

(defn get-controls
  "Retrieves an array of Controls from the object that
   implements this interface. It is null if there are no controls.

  returns: A possibly null array of Control objects. - `javax.naming.ldap.Control[]`

  throws: javax.naming.NamingException - If cannot return controls due to an error."
  ([^javax.naming.ldap.HasControls this]
    (-> this (.getControls))))

