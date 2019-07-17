(ns javax.naming.ldap.PagedResultsControl
  "Requests that the results of a search operation be returned by the LDAP
  server in batches of a specified size.
  The requestor controls the rate at which batches are returned by the rate
  at which it invokes search operations.

  The following code sample shows how the class may be used:


      // Open an LDAP association
      LdapContext ctx = new InitialLdapContext();

      // Activate paged results
      int pageSize = 20; // 20 entries per page
      byte[] cookie = null;
      int total;
      ctx.setRequestControls(new Control[]{
          new PagedResultsControl(pageSize, Control.CRITICAL) });

      do {
          // Perform the search
          NamingEnumeration results =
              ctx.search(``, `(objectclass=*)`, new SearchControls());

          // Iterate over a batch of search results
          while (results != null && results.hasMore()) {
              // Display an entry
              SearchResult entry = (SearchResult)results.next();
              System.out.println(entry.getName());
              System.out.println(entry.getAttributes());

              // Handle the entry's response controls (if any)
              if (entry instanceof HasControls) {
                  // ((HasControls)entry).getControls();
              }
          }
          // Examine the paged results control response
          Control[] controls = ctx.getResponseControls();
          if (controls != null) {
              for (int i = 0; i < controls.length; i++) {
                  if (controls[i] instanceof PagedResultsResponseControl) {
                      PagedResultsResponseControl prrc =
                          (PagedResultsResponseControl)controls[i];
                      total = prrc.getResultSize();
                      cookie = prrc.getCookie();
                  } else {
                      // Handle other response controls (if any)
                  }
              }
          }

          // Re-activate paged results
          ctx.setRequestControls(new Control[]{
              new PagedResultsControl(pageSize, cookie, Control.CRITICAL) });
      } while (cookie != null);

      // Close the LDAP association
      ctx.close();
      ...

  This class implements the LDAPv3 Control for paged-results as defined in
  RFC 2696.

  The control's value has the following ASN.1 definition:


      realSearchControlValue ::= SEQUENCE {
          size      INTEGER (0..maxInt),
                            -- requested page size from client
                            -- result set size estimate from server
          cookie    OCTET STRING
      }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap PagedResultsControl]))

(defn ->paged-results-control
  "Constructor.

  Constructs a control to set the number of entries to be returned per
   page of results. The cookie is provided by the server and may be
   obtained from the paged-results response control.

   A sequence of paged-results can be abandoned by setting the pageSize
   to zero and setting the cookie to the last cookie received from the
   server.

  page-size - The number of entries to return in a page. - `int`
  cookie - A possibly null server-generated cookie. - `byte[]`
  criticality - If true then the server must honor the control and return search results as indicated by pageSize or refuse to perform the search. If false, then the server need not honor the control. - `boolean`

  throws: java.io.IOException - If an error was encountered while encoding the supplied arguments into a control."
  ([page-size cookie criticality]
    (new PagedResultsControl page-size cookie criticality))
  ([page-size criticality]
    (new PagedResultsControl page-size criticality)))

(def *-oid
  "Static Constant.

  The paged-results control's assigned object identifier
   is 1.2.840.113556.1.4.319.

  type: java.lang.String"
  PagedResultsControl/OID)

