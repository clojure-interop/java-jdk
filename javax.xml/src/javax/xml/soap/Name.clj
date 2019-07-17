(ns javax.xml.soap.Name
  "A representation of an XML name.  This interface provides methods for
  getting the local and namespace-qualified names and also for getting the
  prefix associated with the namespace for the name. It is also possible
  to get the URI of the namespace.

  The following is an example of a namespace declaration in an element.


    <wombat:GetLastTradePrice xmlns:wombat=`http://www.wombat.org/trader`>
  (`xmlns` stands for `XML namespace`.)
  The following
  shows what the methods in the Name interface will return.

   getQualifiedName will return `prefix:LocalName` =
       `WOMBAT:GetLastTradePrice`
   getURI will return `http://www.wombat.org/trader`
   getLocalName will return `GetLastTracePrice`
   getPrefix will return `WOMBAT`


  XML namespaces are used to disambiguate SOAP identifiers from
  application-specific identifiers.

  Name objects are created using the method
  SOAPEnvelope.createName, which has two versions.
  One method creates Name objects with
  a local name, a namespace prefix, and a namespace URI.
   and the second creates Name objects with just a local name.
  The following line of
  code, in which se is a SOAPEnvelope object, creates a new
  Name object with all three.


      Name name = se.createName(`GetLastTradePrice`, `WOMBAT`,
                                 `http://www.wombat.org/trader`);
  The following line of code gives an example of how a Name object
  can be used. The variable element is a SOAPElement object.
  This code creates a new SOAPElement object with the given name and
  adds it to element.


      element.addChildElement(name);

  The Name interface may be deprecated in a future release of SAAJ
  in favor of javax.xml.namespace.QName"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.soap Name]))

(defn get-local-name
  "Gets the local name part of the XML name that this Name
   object represents.

  returns: a string giving the local name - `java.lang.String`"
  ([^. this]
    (-> this (.getLocalName))))

(defn get-qualified-name
  "Gets the namespace-qualified name of the XML name that this
   Name object represents.

  returns: the namespace-qualified name as a string - `java.lang.String`"
  ([^. this]
    (-> this (.getQualifiedName))))

(defn get-prefix
  "Returns the prefix that was specified when this Name object
   was initialized. This prefix is associated with the namespace for the XML
   name that this Name object represents.

  returns: the prefix as a string - `java.lang.String`"
  ([^. this]
    (-> this (.getPrefix))))

(defn get-uri
  "Returns the URI of the namespace for the XML
   name that this Name object represents.

  returns: the URI as a string - `java.lang.String`"
  ([^. this]
    (-> this (.getURI))))

