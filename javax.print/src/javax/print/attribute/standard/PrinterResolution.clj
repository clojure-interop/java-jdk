(ns javax.print.attribute.standard.PrinterResolution
  "Class PrinterResolution is a printing attribute class that specifies an
  exact resolution supported by a printer or to be used for a print job.
  This attribute assumes that printers have a small set of device resolutions
  at which they can operate rather than a continuum.

  PrinterResolution is used in multiple ways:


  When a client searches looking for a printer that supports the client's
  desired resolution exactly (no more, no less), the client specifies
  an instance of class PrinterResolution indicating the exact resolution the
  client wants. Only printers supporting that exact resolution will match the
  search.


  When a client needs to print a job using the client's desired resolution
  exactly (no more, no less), the client specifies an instance of class
  PrinterResolution as an attribute of the Print Job. This will fail if the
  Print Job doesn't support that exact resolution, and Fidelity is set to
  true.

  If a client wants to locate a printer supporting a resolution
  greater than some required minimum, then it may be necessary to exclude
  this attribute from a lookup request and to directly query the set of
  supported resolutions, and specify the one that most closely meets
  the client's requirements.
  In some cases this may be more simply achieved by specifying a
  PrintQuality attribute which often controls resolution.


  IPP Compatibility: The information needed to construct an IPP
  \"printer-resolution\" attribute can be obtained by calling
  methods on the PrinterResolution object. The category name returned by
  getName() gives the IPP attribute name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PrinterResolution]))

(defn ->printer-resolution
  "Constructor.

  Construct a new printer resolution attribute from the given items.

  cross-feed-resolution - Cross feed direction resolution. - `int`
  feed-resolution - Feed direction resolution. - `int`
  units - Unit conversion factor, e.g. ResolutionSyntax.DPI or ResolutionSyntax.DPCM. - `int`

  throws: java.lang.IllegalArgumentException - (unchecked exception) Thrown if crossFeedResolution < 1 or feedResolution < 1 or units < 1."
  (^PrinterResolution [^Integer cross-feed-resolution ^Integer feed-resolution ^Integer units]
    (new PrinterResolution cross-feed-resolution feed-resolution units)))

(defn equals
  "Returns whether this printer resolution attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions
   must be true:


   object is not null.

   object is an instance of class PrinterResolution.

   This attribute's cross feed direction resolution is equal to
   object's cross feed direction resolution.

   This attribute's feed direction resolution is equal to
   object's feed direction resolution.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this printer
            resolution attribute, false otherwise. - `boolean`"
  (^Boolean [^PrinterResolution this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class PrinterResolution, the category is class PrinterResolution itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^PrinterResolution this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PrinterResolution, the
   category name is \"printer-resolution\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^PrinterResolution this]
    (-> this (.getName))))

