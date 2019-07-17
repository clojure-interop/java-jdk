(ns javax.naming.ldap.SortControl
  "Requests that the results of a search operation be sorted by the LDAP server
  before being returned.
  The sort criteria are specified using an ordered list of one or more sort
  keys, with associated sort parameters.
  Search results are sorted at the LDAP server according to the parameters
  supplied in the sort control and then returned to the requestor. If sorting
  is not supported at the server (and the sort control is marked as critical)
  then the search operation is not performed and an error is returned.

  The following code sample shows how the class may be used:


      // Open an LDAP association
      LdapContext ctx = new InitialLdapContext();

      // Activate sorting
      String sortKey = `cn`;
      ctx.setRequestControls(new Control[]{
          new SortControl(sortKey, Control.CRITICAL) });

      // Perform a search
      NamingEnumeration results =
          ctx.search(``, `(objectclass=*)`, new SearchControls());

      // Iterate over search results
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
      // Examine the sort control response
      Control[] controls = ctx.getResponseControls();
      if (controls != null) {
          for (int i = 0; i < controls.length; i++) {
              if (controls[i] instanceof SortResponseControl) {
                  SortResponseControl src = (SortResponseControl)controls[i];
                  if (! src.isSorted()) {
                      throw src.getException();
                  }
              } else {
                  // Handle other response controls (if any)
              }
          }
      }

      // Close the LDAP association
      ctx.close();
      ...

  This class implements the LDAPv3 Request Control for server-side sorting
  as defined in
  RFC 2891.

  The control's value has the following ASN.1 definition:


      SortKeyList ::= SEQUENCE OF SEQUENCE {
          attributeType     AttributeDescription,
          orderingRule  [0] MatchingRuleId OPTIONAL,
          reverseOrder  [1] BOOLEAN DEFAULT FALSE }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.ldap SortControl]))

(defn ->sort-control
  "Constructor.

  Constructs a control to sort on a single attribute in ascending order.
   Sorting will be performed using the ordering matching rule defined
   for use with the specified attribute.

  sort-by - An attribute ID to sort by. - `java.lang.String`
  criticality - If true then the server must honor the control and return the search results sorted as requested or refuse to perform the search. If false, then the server need not honor the control. - `boolean`

  throws: java.io.IOException - If an error was encountered while encoding the supplied arguments into a control."
  ([sort-by criticality]
    (new SortControl sort-by criticality)))

(def *-oid
  "Static Constant.

  The server-side sort control's assigned object identifier
   is 1.2.840.113556.1.4.473.

  type: java.lang.String"
  SortControl/OID)

