(ns javax.xml.namespace.NamespaceContext
  "Interface for read only XML Namespace context processing.

  An XML Namespace has the properties:

    Namespace URI:
        Namespace name expressed as a URI to which the prefix is bound
    prefix: syntactically, this is the part of the attribute name
        following the XMLConstants.XMLNS_ATTRIBUTE
        (`xmlns`) in the Namespace declaration

  example:
  <element xmlns:prefix=`http://Namespace-name-URI`>

  All get*(*) methods operate in the current scope
  for Namespace URI and prefix resolution.

  Note that a Namespace URI can be bound to
  multiple prefixes in the current scope.  This can
  occur when multiple XMLConstants.XMLNS_ATTRIBUTE
  (`xmlns`) Namespace declarations occur in the same Start-Tag and
  refer to the same Namespace URI. e.g.


  <element xmlns:prefix1=`http://Namespace-name-URI`
           xmlns:prefix2=`http://Namespace-name-URI`>
  This can also occur when the same Namespace URI is used in multiple
  XMLConstants.XMLNS_ATTRIBUTE (`xmlns`) Namespace
  declarations in the logical parent element hierarchy.  e.g.


  <parent xmlns:prefix1=`http://Namespace-name-URI`>
    <child xmlns:prefix2=`http://Namespace-name-URI`>
      ...
    </child>
  </parent>

  A prefix can only be bound to a single
  Namespace URI in the current scope."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.namespace NamespaceContext]))

(defn get-namespace-uri
  "Get Namespace URI bound to a prefix in the current scope.

   When requesting a Namespace URI by prefix, the following
   table describes the returned Namespace URI value for all
   possible prefix values:





           getNamespaceURI(prefix)
           return value for specified prefixes



         prefix parameter
         Namespace URI return value




         DEFAULT_NS_PREFIX (``)
         default Namespace URI in the current scope or
           XMLConstants.NULL_NS_URI(``)

           when there is no default Namespace URI in the current scope


         bound prefix
         Namespace URI bound to prefix in current scope


         unbound prefix

           XMLConstants.NULL_NS_URI(``)




         XMLConstants.XML_NS_PREFIX (`xml`)
         XMLConstants.XML_NS_URI
             (`http://www.w3.org/XML/1998/namespace`)


         XMLConstants.XMLNS_ATTRIBUTE (`xmlns`)
         XMLConstants.XMLNS_ATTRIBUTE_NS_URI
           (`http://www.w3.org/2000/xmlns/`)


         null
         IllegalArgumentException is thrown

  prefix - prefix to look up - `java.lang.String`

  returns: Namespace URI bound to prefix in the current scope - `java.lang.String`

  throws: java.lang.IllegalArgumentException - When prefix is null"
  ([this prefix]
    (-> this (.getNamespaceURI prefix))))

(defn get-prefix
  "Get prefix bound to Namespace URI in the current scope.

   To get all prefixes bound to a Namespace URI in the current
   scope, use getPrefixes(String namespaceURI).

   When requesting a prefix by Namespace URI, the following
   table describes the returned prefix value for all Namespace URI
   values:





           getPrefix(namespaceURI) return value for
           specified Namespace URIs



         Namespace URI parameter
         prefix value returned




         <default Namespace URI>
         XMLConstants.DEFAULT_NS_PREFIX (``)



         bound Namespace URI
         prefix bound to Namespace URI in the current scope,
             if multiple prefixes are bound to the Namespace URI in
             the current scope, a single arbitrary prefix, whose
             choice is implementation dependent, is returned


         unbound Namespace URI
         null


         XMLConstants.XML_NS_URI
             (`http://www.w3.org/XML/1998/namespace`)
         XMLConstants.XML_NS_PREFIX (`xml`)


         XMLConstants.XMLNS_ATTRIBUTE_NS_URI
             (`http://www.w3.org/2000/xmlns/`)
         XMLConstants.XMLNS_ATTRIBUTE (`xmlns`)


         null
         IllegalArgumentException is thrown

  namespace-uri - URI of Namespace to lookup - `java.lang.String`

  returns: prefix bound to Namespace URI in current context - `java.lang.String`

  throws: java.lang.IllegalArgumentException - When namespaceURI is null"
  ([this namespace-uri]
    (-> this (.getPrefix namespace-uri))))

(defn get-prefixes
  "Get all prefixes bound to a Namespace URI in the current
   scope.

   An Iterator over String elements is returned in an arbitrary,
   implementation dependent, order.

   The Iterator is
   not modifiable.  e.g. the
   remove() method will throw
   UnsupportedOperationException.

   When requesting prefixes by Namespace URI, the following
   table describes the returned prefixes value for all Namespace
   URI values:





           getPrefixes(namespaceURI) return value for
           specified Namespace URIs


         Namespace URI parameter
         prefixes value returned




         bound Namespace URI,
           including the <default Namespace URI>

           Iterator over prefixes bound to Namespace URI in
           the current scope in an arbitrary,
           implementation dependent,
           order



         unbound Namespace URI
         empty Iterator


         XMLConstants.XML_NS_URI
             (`http://www.w3.org/XML/1998/namespace`)
         Iterator with one element set to
           XMLConstants.XML_NS_PREFIX (`xml`)


         XMLConstants.XMLNS_ATTRIBUTE_NS_URI
             (`http://www.w3.org/2000/xmlns/`)
         Iterator with one element set to
           XMLConstants.XMLNS_ATTRIBUTE (`xmlns`)


         null
         IllegalArgumentException is thrown

  namespace-uri - URI of Namespace to lookup - `java.lang.String`

  returns: Iterator for all prefixes bound to the
     Namespace URI in the current scope - `java.util.Iterator`

  throws: java.lang.IllegalArgumentException - When namespaceURI is null"
  ([this namespace-uri]
    (-> this (.getPrefixes namespace-uri))))

