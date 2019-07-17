(ns javax.print.attribute.standard.JobMediaSheets
  "Class JobMediaSheets is an integer valued printing attribute class that
  specifies the total number of media sheets to be produced for this job.

  The JobMediaSheets attribute describes the size of the job. This attribute is
  not intended to be a counter; it is intended to be useful routing and
  scheduling information if known. The printer may try to compute the
  JobMediaSheets attribute's value if it is not supplied in the Print Request.
  Even if the client does supply a value for the JobMediaSheets attribute in
  the Print Request, the printer may choose to change the value if the printer
  is able to compute a value which is more accurate than the client supplied
  value. The printer may be able to determine the correct value for the
  JobMediaSheets attribute either right at job submission time or at any later
  point in time.

  Unlike the JobKOctets and JobImpressions attributes, the JobMediaSheets value must include the
  multiplicative factors contributed by the number of copies specified by the
  Copies attribute and a `number of copies` instruction embedded
  in the document data, if any. This difference allows the system administrator
  to control the lower and upper bounds of both (1) the size of the document(s)
  with JobKOctetsSupported and JobImpressionsSupported and (2) the size of the job
  with JobMediaSheetsSupported.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobMediaSheets]))

(defn ->job-media-sheets
  "Constructor.

  Construct a new job media sheets attribute with the given integer
   value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  ([^Integer value]
    (new JobMediaSheets value)))

(defn equals
  "Returns whether this job media sheets attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions must
   be true:


   object is not null.

   object is an instance of class JobMediaSheets.

   This job media sheets attribute's value and object's
   value are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job media
            sheets attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.JobMediaSheets this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobMediaSheets and any vendor-defined subclasses, the category
   is class JobMediaSheets itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobMediaSheets this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobMediaSheets and any vendor-defined subclasses, the
   category name is `job-media-sheets`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.JobMediaSheets this]
    (-> this (.getName))))

