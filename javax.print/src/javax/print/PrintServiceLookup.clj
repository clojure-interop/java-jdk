(ns javax.print.PrintServiceLookup
  "Implementations of this class provide lookup services for
  print services (typically equivalent to printers) of a particular type.

  Multiple implementations may be installed concurrently.
  All implementations must be able to describe the located printers
  as instances of a PrintService.
  Typically implementations of this service class are located
  automatically in JAR files (see the SPI JAR file specification).
  These classes must be instantiable using a default constructor.
  Alternatively applications may explicitly register instances
  at runtime.

  Applications use only the static methods of this abstract class.
  The instance methods are implemented by a service provider in a subclass
  and the unification of the results from all installed lookup classes
  are reported by the static methods of this class when called by
  the application.

  A PrintServiceLookup implementor is recommended to check for the
  SecurityManager.checkPrintJobAccess() to deny access to untrusted code.
  Following this recommended policy means that untrusted code may not
  be able to locate any print services. Downloaded applets are the most
  common example of untrusted code.

  This check is made on a per lookup service basis to allow flexibility in
  the policy to reflect the needs of different lookup services.

  Services which are registered by registerService(PrintService)
  will not be included in lookup results if a security manager is
  installed and its checkPrintJobAccess() method denies access."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print PrintServiceLookup]))

(defn ->print-service-lookup
  "Constructor."
  ([]
    (new PrintServiceLookup )))

(defn *lookup-print-services
  "Locates print services capable of printing the specified
   DocFlavor.

  flavor - the flavor to print. If null, this constraint is not used. - `javax.print.DocFlavor`
  attributes - attributes that the print service must support. If null this constraint is not used. - `javax.print.attribute.AttributeSet`

  returns: array of matching PrintService objects
   representing print services that support the specified flavor
   attributes.  If no services match, the array is zero-length. - `javax.print.PrintService[]`"
  ([^javax.print.DocFlavor flavor ^javax.print.attribute.AttributeSet attributes]
    (PrintServiceLookup/lookupPrintServices flavor attributes)))

(defn *lookup-multi-doc-print-services
  "Locates MultiDoc print Services capable of printing MultiDocs
   containing all the specified doc flavors.
    This method is useful to help locate a service that can print
   a MultiDoc in which the elements may be different
   flavors. An application could perform this itself by multiple lookups
   on each DocFlavor in turn and collating the results,
   but the lookup service may be able to do this more efficiently.

  flavors - the flavors to print. If null or empty this constraint is not used. Otherwise return only multidoc print services that can print all specified doc flavors. - `javax.print.DocFlavor[]`
  attributes - attributes that the print service must support. If null this constraint is not used. - `javax.print.attribute.AttributeSet`

  returns: array of matching MultiDocPrintService objects.
   If no services match, the array is zero-length. - `javax.print.MultiDocPrintService[]`"
  ([^javax.print.DocFlavor[] flavors ^javax.print.attribute.AttributeSet attributes]
    (PrintServiceLookup/lookupMultiDocPrintServices flavors attributes)))

(defn *lookup-default-print-service
  "Locates the default print service for this environment.
   This may return null.
   If multiple lookup services each specify a default, the
   chosen service is not precisely defined, but a
   platform native service, rather than an installed service,
   is usually returned as the default.  If there is no clearly
   identifiable
   platform native default print service, the default is the first
   to be located in an implementation-dependent manner.

   This may include making use of any preferences API that is available
   as part of the Java or native platform.
   This algorithm may be overridden by a user setting the property
   javax.print.defaultPrinter.
   A service specified must be discovered to be valid and currently
   available to be returned as the default.

  returns: the default PrintService. - `javax.print.PrintService`"
  ([]
    (PrintServiceLookup/lookupDefaultPrintService )))

(defn *register-service-provider
  "Allows an application to explicitly register a class that
   implements lookup services. The registration will not persist
   across VM invocations.
   This is useful if an application needs to make a new service
   available that is not part of the installation.
   If the lookup service is already registered, or cannot be registered,
   the method returns false.

  sp - an implementation of a lookup service. - `javax.print.PrintServiceLookup`

  returns: true if the new lookup service is newly
           registered; false otherwise. - `boolean`"
  ([^javax.print.PrintServiceLookup sp]
    (PrintServiceLookup/registerServiceProvider sp)))

(defn *register-service
  "Allows an application to directly register an instance of a
   class which implements a print service.
   The lookup operations for this service will be
   performed by the PrintServiceLookup class using the attribute
   values and classes reported by the service.
   This may be less efficient than a lookup
   service tuned for that service.
   Therefore registering a PrintServiceLookup instance
   instead is recommended.
   The method returns true if this service is not previously
   registered and is now successfully registered.
   This method should not be called with StreamPrintService instances.
   They will always fail to register and the method will return false.

  service - an implementation of a print service. - `javax.print.PrintService`

  returns: true if the service is newly
           registered; false otherwise. - `boolean`"
  ([^javax.print.PrintService service]
    (PrintServiceLookup/registerService service)))

(defn get-print-services
  "Locates services that can be positively confirmed to support
   the combination of attributes and DocFlavors specified.
   This method is not called directly by applications.

   Implemented by a service provider, used by the static methods
   of this class.

   The results should be the same as obtaining all the PrintServices
   and querying each one individually on its support for the
   specified attributes and flavors, but the process can be more
   efficient by taking advantage of the capabilities of lookup services
   for the print services.

  flavor - of document required. If null it is ignored. - `javax.print.DocFlavor`
  attributes - required to be supported. If null this constraint is not used. - `javax.print.attribute.AttributeSet`

  returns: array of matching PrintServices. If no services match, the
   array is zero-length. - `javax.print.PrintService[]`"
  ([^javax.print.PrintServiceLookup this ^javax.print.DocFlavor flavor ^javax.print.attribute.AttributeSet attributes]
    (-> this (.getPrintServices flavor attributes)))
  ([^javax.print.PrintServiceLookup this]
    (-> this (.getPrintServices))))

(defn get-multi-doc-print-services
  "Not called directly by applications.

   Implemented by a service provider, used by the static methods
   of this class.

   Locates MultiDoc print services which can be positively confirmed
   to support the combination of attributes and DocFlavors specified.

  flavors - of documents required. If null or empty it is ignored. - `javax.print.DocFlavor[]`
  attributes - required to be supported. If null this constraint is not used. - `javax.print.attribute.AttributeSet`

  returns: array of matching PrintServices. If no services match, the
   array is zero-length. - `javax.print.MultiDocPrintService[]`"
  ([^javax.print.PrintServiceLookup this ^javax.print.DocFlavor[] flavors ^javax.print.attribute.AttributeSet attributes]
    (-> this (.getMultiDocPrintServices flavors attributes))))

(defn get-default-print-service
  "Not called directly by applications.
   Implemented by a service provider, and called by the print lookup
   service

  returns: the default PrintService for this lookup service.
   If there is no default, returns null. - `javax.print.PrintService`"
  ([^javax.print.PrintServiceLookup this]
    (-> this (.getDefaultPrintService))))

