(ns javax.print.PrintService
  "Interface PrintService is the factory for a DocPrintJob. A PrintService
  describes the capabilities of a Printer and can be queried regarding
  a printer's supported attributes.

  Example:


    DocFlavor flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
    aset.add(MediaSizeName.ISO_A4);
    PrintService[] pservices =
                  PrintServiceLookup.lookupPrintServices(flavor, aset);
    if (pservices.length > 0) {
        DocPrintJob pj = pservices[0].createPrintJob();
        try {
            FileInputStream fis = new FileInputStream(`test.ps`);
            Doc doc = new SimpleDoc(fis, flavor, null);
            pj.print(doc, aset);
         } catch (FileNotFoundException fe) {
         } catch (PrintException e) {
         }
    }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print PrintService]))

(defn get-default-attribute-value
  "Determines this print service's default printing attribute value in
   the given category. A printing attribute value is an instance of
   a class that implements interface
   Attribute. If a client sets
   up a print job and does not specify any attribute value in the
   given category, this Print Service will use the
   default attribute value instead.

   Some attributes may not be supported in a particular context (ie
   for a particular DocFlavor).
   Use one of the methods that include a DocFlavor to
   validate the request before submitting it, such as
   getSupportedAttributeValues(..).

   Not all attributes have a default value. For example the
   service will not have a defaultvalue for RequestingUser
   i.e. a null return for a supported category means there is no
   service default value for that category. Use the
   isAttributeCategorySupported(Class) method to
   distinguish these cases.

  category - Printing attribute category for which the default attribute value is requested. It must be a Class that implements interface Attribute. - `javax.print.attribute.Attribute>`

  returns: Default attribute value for category, or null
         if this Print Service does not support specifying a doc-level or
            job-level attribute in category in a Print
            Request, or the service does not have a default value
            for this attribute. - `java.lang.Object`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if category is null."
  ([^javax.print.PrintService this ^javax.print.attribute.Attribute> category]
    (-> this (.getDefaultAttributeValue category))))

(defn doc-flavor-supported?
  "Determines if this print service supports a specific
   DocFlavor.  This is a convenience method to determine
   if the DocFlavor would be a member of the result of
   getSupportedDocFlavors().

   Note that some doc flavors may not be supported in combination
   with all attributes. Use getUnsupportedAttributes(..)
   to validate specific combinations.

  flavor - the DocFlavorto query for support. - `javax.print.DocFlavor`

  returns: true if this print service supports the
   specified DocFlavor; false otherwise. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if flavor is null."
  ([^javax.print.PrintService this ^javax.print.DocFlavor flavor]
    (-> this (.isDocFlavorSupported flavor))))

(defn attribute-value-supported?
  "Determines whether a client can specify the given printing
   attribute
   value when setting up a job for this Print Service. A printing
   attribute value is an instance of a class that implements interface
    Attribute.

   If flavor is null and attributes is null or
   is an empty set, this method tells whether this Print Service supports
   the given printing attribute value for some possible combination of doc
   flavor and set of attributes. If flavor is not null or
   attributes is not an empty set, this method tells whether
   this Print Service supports the given printing attribute value in
   combination with the given doc flavor and/or set of attributes.

   Also if DocFlavor is not null it must be a flavor supported by this
   PrintService, else IllegalArgumentException will be thrown.

   DocAttributes which are to be specified on the
   Doc must be included in this set to accurately
   represent the context.

   This is a convenience method to determine if the value
   would be a member of the result of
   getSupportedAttributeValues(...).

  attrval - Printing attribute value to test. - `javax.print.attribute.Attribute`
  flavor - Doc flavor for a supposed job, or null. - `javax.print.DocFlavor`
  attributes - Set of printing attributes for a supposed job (both job-level attributes and document-level attributes), or null. - `javax.print.attribute.AttributeSet`

  returns: True if this Print Service supports specifying
          attrval as a doc-level or job-level attribute in a
            Print Request, false if it doesn't. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) if attrval is null."
  ([^javax.print.PrintService this ^javax.print.attribute.Attribute attrval ^javax.print.DocFlavor flavor ^javax.print.attribute.AttributeSet attributes]
    (-> this (.isAttributeValueSupported attrval flavor attributes))))

(defn get-unsupported-attributes
  "Identifies the attributes that are unsupported for a print request
   in the context of a particular DocFlavor.
   This method is useful for validating a potential print job and
   identifying the specific attributes which cannot be supported.
   It is important to supply only a supported DocFlavor or an
   IllegalArgumentException will be thrown. If the
   return value from this method is null, all attributes are supported.

   DocAttributes which are to be specified on the
   Doc must be included in this set to accurately
   represent the context.

   If the return value is non-null, all attributes in the returned
   set are unsupported with this DocFlavor. The returned set does not
   distinguish attribute categories that are unsupported from
   unsupported attribute values.

   A supported print request can then be created by removing
   all unsupported attributes from the original attribute set,
   except in the case that the DocFlavor is unsupported.

   If any attributes are unsupported only because they are in conflict
   with other attributes then it is at the discretion of the service
   to select the attribute(s) to be identified as the cause of the
   conflict.

   Use isDocFlavorSupported() to verify that a DocFlavor
   is supported before calling this method.

  flavor - Doc flavor to test, or null - `javax.print.DocFlavor`
  attributes - Set of printing attributes for a supposed job (both job-level attributes and document-level attributes), or null. - `javax.print.attribute.AttributeSet`

  returns: null if this Print Service supports the print request
   specification, else the unsupported attributes. - `javax.print.attribute.AttributeSet`

  throws: java.lang.IllegalArgumentException - ifflavor is not supported by this PrintService."
  ([^javax.print.PrintService this ^javax.print.DocFlavor flavor ^javax.print.attribute.AttributeSet attributes]
    (-> this (.getUnsupportedAttributes flavor attributes))))

(defn get-supported-attribute-categories
  "Determines the printing attribute categories a client can specify
   when setting up a job for this print service.
   A printing attribute category is
   designated by a Class that implements interface
   Attribute. This method returns
   just the attribute categories that are supported; it does not
   return the particular attribute values that are supported.

   This method returns all the printing attribute
   categories this print service supports for any possible job.
   Some categories may not be supported in a particular context (ie
   for a particular DocFlavor).
   Use one of the methods that include a DocFlavor to
   validate the request before submitting it, such as
   getSupportedAttributeValues(..).

  returns: Array of printing attribute categories that the client can
            specify as a doc-level or job-level attribute in a Print
            Request. Each element in the array is a Class that implements interface Attribute.
            The array is empty if no categories are supported. - `java.lang.Class<?>[]`"
  ([^javax.print.PrintService this]
    (-> this (.getSupportedAttributeCategories))))

(defn get-attribute
  "Gets the value of the single specified service attribute.
   This may be useful to clients which only need the value of one
   attribute and want to minimize overhead.

  category - the category of a PrintServiceAttribute supported by this service - may not be null. - `java.lang.Class<T>`

  returns: the value of the supported attribute or null if the
   attribute is not supported by this service. - `<T extends javax.print.attribute.PrintServiceAttribute> T`

  throws: java.lang.NullPointerException - if the category is null."
  ([^javax.print.PrintService this ^java.lang.Class category]
    (-> this (.getAttribute category))))

(defn get-name
  "Returns a String name for this print service which may be used
   by applications to request a particular print service.
   In a suitable context, such as a name service, this name must be
   unique.
   In some environments this unique name may be the same as the user
   friendly printer name defined as the
   PrinterName
   attribute.

  returns: name of the service. - `java.lang.String`"
  ([^javax.print.PrintService this]
    (-> this (.getName))))

(defn get-supported-attribute-values
  "Determines the printing attribute values a client can specify in
   the given category when setting up a job for this print service. A
   printing
   attribute value is an instance of a class that implements interface
   Attribute.

   If flavor is null and attributes is null
   or is an empty set, this method returns all the printing attribute
   values this Print Service supports for any possible job. If
   flavor is not null or attributes is not
   an empty set, this method returns just the printing attribute values
   that are compatible with the given doc flavor and/or set of attributes.
   That is, a null return value may indicate that specifying this attribute
   is incompatible with the specified DocFlavor.
   Also if DocFlavor is not null it must be a flavor supported by this
   PrintService, else IllegalArgumentException will be thrown.

   If the attributes parameter contains an Attribute whose
   category is the same as the category parameter, the service
   must ignore this attribute in the AttributeSet.

   DocAttributes which are to be specified on the
   Doc must be included in this set to accurately
   represent the context.

   This method returns an Object because different printing attribute
   categories indicate the supported attribute values in different ways.
   The documentation for each printing attribute in package javax.print.attribute.standard
   describes how each attribute indicates its supported values. Possible
   ways of indicating support include:


   Return a single instance of the attribute category to indicate that any
   value is legal -- used, for example, by an attribute whose value is an
   arbitrary text string. (The value of the returned attribute object is
   irrelevant.)

   Return an array of one or more instances of the attribute category,
   containing the legal values -- used, for example, by an attribute with
   a list of enumerated values. The type of the array is an array of the
   specified attribute category type as returned by its
   getCategory(Class).

   Return a single object (of some class other than the attribute category)
   that indicates bounds on the legal values -- used, for example, by an
   integer-valued attribute that must lie within a certain range.

  category - Printing attribute category to test. It must be a Class that implements interface Attribute. - `javax.print.attribute.Attribute>`
  flavor - Doc flavor for a supposed job, or null. - `javax.print.DocFlavor`
  attributes - Set of printing attributes for a supposed job (both job-level attributes and document-level attributes), or null. - `javax.print.attribute.AttributeSet`

  returns: Object indicating supported values for category,
            or null if this Print Service does not support specifying a
            doc-level or job-level attribute in category in
            a Print Request. - `java.lang.Object`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if category is null."
  ([^javax.print.PrintService this ^javax.print.attribute.Attribute> category ^javax.print.DocFlavor flavor ^javax.print.attribute.AttributeSet attributes]
    (-> this (.getSupportedAttributeValues category flavor attributes))))

(defn get-service-ui-factory
  "Returns a factory for UI components which allow users to interact
   with the service in various roles.
   Services which do not provide any UI should return null.
   Print Services which do provide UI but want to be supported in
   an environment with no UI support should ensure that the factory
   is not initialised unless the application calls this method to
   obtain the factory.
   See ServiceUIFactory for more information.

  returns: null or a factory for UI components. - `javax.print.ServiceUIFactory`"
  ([^javax.print.PrintService this]
    (-> this (.getServiceUIFactory))))

(defn attribute-category-supported?
  "Determines whether a client can specify the given printing
   attribute category when setting up a job for this print service. A
   printing attribute category is designated by a Class
   that implements interface Attribute. This method tells whether the attribute category is
   supported; it does not tell whether a particular attribute value
   is supported.

   Some categories may not be supported in a particular context (ie
   for a particular DocFlavor).
   Use one of the methods which include a DocFlavor to
   validate the request before submitting it, such as
   getSupportedAttributeValues(..).

   This is a convenience method to determine if the category
   would be a member of the result of
   getSupportedAttributeCategories().

  category - Printing attribute category to test. It must be a Class that implements interface Attribute. - `javax.print.attribute.Attribute>`

  returns: true if this print service supports
            specifying a doc-level or
            job-level attribute in category in a Print
            Request; false if it doesn't. - `boolean`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if category is null."
  ([^javax.print.PrintService this ^javax.print.attribute.Attribute> category]
    (-> this (.isAttributeCategorySupported category))))

(defn remove-print-service-attribute-listener
  "Removes the print-service listener from this print service.
   This means the listener is no longer interested in
   PrintService events.

  listener - a PrintServiceAttributeListener object - `javax.print.event.PrintServiceAttributeListener`"
  ([^javax.print.PrintService this ^javax.print.event.PrintServiceAttributeListener listener]
    (-> this (.removePrintServiceAttributeListener listener))))

(defn get-supported-doc-flavors
  "Determines the print data formats a client can specify when setting
   up a job for this PrintService. A print data format is
   designated by a `doc
   flavor` (class DocFlavor)
   consisting of a MIME type plus a print data representation class.

   Note that some doc flavors may not be supported in combination
   with all attributes. Use getUnsupportedAttributes(..)
   to validate specific combinations.

  returns: Array of supported doc flavors, should have at least
            one element. - `javax.print.DocFlavor[]`"
  ([^javax.print.PrintService this]
    (-> this (.getSupportedDocFlavors))))

(defn hash-code
  "This method should be implemented consistently with
   equals(Object).

  returns: hash code of this object. - `int`"
  ([^javax.print.PrintService this]
    (-> this (.hashCode))))

(defn add-print-service-attribute-listener
  "Registers a listener for events on this PrintService.

  listener - a PrintServiceAttributeListener, which monitors the status of a print service - `javax.print.event.PrintServiceAttributeListener`"
  ([^javax.print.PrintService this ^javax.print.event.PrintServiceAttributeListener listener]
    (-> this (.addPrintServiceAttributeListener listener))))

(defn equals
  "Determines if two services are referring to the same underlying
   service.  Objects encapsulating a print service may not exhibit
   equality of reference even though they refer to the same underlying
   service.

   Clients should call this method to determine if two services are
   referring to the same underlying service.

   Services must implement this method and return true only if the
   service objects being compared may be used interchangeably by the
   client.
   Services are free to return the same object reference to an underlying
   service if that, but clients must not depend on equality of reference.

  obj - the reference object with which to compare. - `java.lang.Object`

  returns: true if this service is the same as the obj argument,
   false otherwise. - `boolean`"
  ([^javax.print.PrintService this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-attributes
  "Obtains this print service's set of printer description attributes
   giving this Print Service's status. The returned attribute set object
   is unmodifiable. The returned attribute set object is a `snapshot` of
   this Print Service's attribute set at the time of the
   getAttributes() method call: that is, the returned
   attribute set's contents will not be updated if this print
   service's attribute set's contents change in the future. To detect
   changes in attribute values, call getAttributes() again
   and compare the new attribute set to the previous attribute set;
   alternatively, register a listener for print service events.

  returns: Unmodifiable snapshot of this Print Service's attribute set.
            May be empty, but not null. - `javax.print.attribute.PrintServiceAttributeSet`"
  ([^javax.print.PrintService this]
    (-> this (.getAttributes))))

(defn create-print-job
  "Creates and returns a PrintJob capable of handling data from
   any of the supported document flavors.

  returns: a DocPrintJob object - `javax.print.DocPrintJob`"
  ([^javax.print.PrintService this]
    (-> this (.createPrintJob))))

