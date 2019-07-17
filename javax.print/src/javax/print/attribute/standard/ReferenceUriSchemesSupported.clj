(ns javax.print.attribute.standard.ReferenceUriSchemesSupported
  "Class ReferenceUriSchemesSupported is a printing attribute class
  an enumeration, that indicates a `URI scheme,` such as `http:` or `ftp:`,
  that a printer can use to retrieve print data stored at a URI location.
  If a printer supports doc flavors with a print data representation class of
  `java.net.URL`, the printer uses instances of class
  ReferenceUriSchemesSupported to advertise the URI schemes it can accept.
  The acceptable URI schemes are included as service attributes in the
  lookup service; this lets clients search the
  for printers that can get print data using a certain URI scheme. The
  acceptable URI schemes can also be queried using the capability methods in
  interface PrintService. However,
  ReferenceUriSchemesSupported attributes are used solely for determining
  acceptable URI schemes, they are never included in a doc's,
  print request's, print job's, or print service's attribute set.

  The Internet Assigned Numbers Authority maintains the
  official
  list of URI schemes.

  Class ReferenceUriSchemesSupported defines enumeration values for widely
  used URI schemes. A printer that supports additional URI schemes
  can define them in a subclass of class ReferenceUriSchemesSupported.

  IPP Compatibility:  The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard ReferenceUriSchemesSupported]))

(def *-ftp
  "Static Constant.

  File Transfer Protocol (FTP).

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/FTP)

(def *-http
  "Static Constant.

  HyperText Transfer Protocol (HTTP).

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/HTTP)

(def *-https
  "Static Constant.

  Secure HyperText Transfer Protocol (HTTPS).

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/HTTPS)

(def *-gopher
  "Static Constant.

  Gopher Protocol.

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/GOPHER)

(def *-news
  "Static Constant.

  USENET news.

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/NEWS)

(def *-nntp
  "Static Constant.

  USENET news using Network News Transfer Protocol (NNTP).

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/NNTP)

(def *-wais
  "Static Constant.

  Wide Area Information Server (WAIS) protocol.

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/WAIS)

(def *-file
  "Static Constant.

  Host-specific file names.

  type: javax.print.attribute.standard.ReferenceUriSchemesSupported"
  ReferenceUriSchemesSupported/FILE)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class ReferenceUriSchemesSupported and any vendor-defined
   subclasses, the category is class ReferenceUriSchemesSupported itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.ReferenceUriSchemesSupported this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class ReferenceUriSchemesSupported and any vendor-defined
   subclasses, the category name is
   `reference-uri-schemes-supported`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.ReferenceUriSchemesSupported this]
    (-> this (.getName))))

