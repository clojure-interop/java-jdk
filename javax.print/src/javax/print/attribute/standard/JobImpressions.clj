(ns javax.print.attribute.standard.JobImpressions
  "Class JobImpressions is an integer valued printing attribute class that
  specifies the total size in number of impressions of the document(s) being
  submitted. An `impression` is the image (possibly many print-stream pages in
  different configurations) imposed onto a single media page.

  The JobImpressions attribute describes the size of the job. This attribute is
  not intended to be a counter; it is intended to be useful routing and
  scheduling information if known. The printer may try to compute the
  JobImpressions attribute's value if it is not supplied in the Print Request.
  Even if the client does supply a value for the JobImpressions attribute in
  the Print Request, the printer may choose to change the value if the printer
  is able to compute a value which is more accurate than the client supplied
  value. The printer may be able to determine the correct value for the
  JobImpressions attribute either right at job submission time or at any later
  point in time.

  As with JobKOctets, the JobImpressions value must not
  include the multiplicative factors contributed by the number of copies
  specified by the Copies attribute, independent of whether the
  device can process multiple copies without making multiple passes over the
  job or document data and independent of whether the output is collated or
  not. Thus the value is independent of the implementation and reflects the
  size of the document(s) measured in impressions independent of the number of
  copies.

  As with JobKOctets, the JobImpressions value must also not
  include the multiplicative factor due to a copies instruction embedded in the
  document data. If the document data actually includes replications of the
  document data, this value will include such replication. In other words, this
  value is always the number of impressions in the source document data, rather
  than a measure of the number of impressions to be produced by the job.

  IPP Compatibility: The integer value gives the IPP integer value. The
  category name returned by getName() gives the IPP attribute
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobImpressions]))

(defn ->job-impressions
  "Constructor.

  Construct a new job impressions attribute with the given integer value.

  value - Integer value. - `int`

  throws: java.lang.IllegalArgumentException - (Unchecked exception) Thrown if value is less than 0."
  ([^Integer value]
    (new JobImpressions value)))

(defn equals
  "Returns whether this job impressions attribute is equivalent to the
   passed in object. To be equivalent, all of the following conditions must
   be true:


   object is not null.

   object is an instance of class JobImpressions.

   This job impressions attribute's value and object's value
   are equal.

  object - Object to compare to. - `java.lang.Object`

  returns: True if object is equivalent to this job
            impressions attribute, false otherwise. - `boolean`"
  (^Boolean [^javax.print.attribute.standard.JobImpressions this ^java.lang.Object object]
    (-> this (.equals object))))

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobImpressions, the category is class JobImpressions itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobImpressions this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobImpressions, the category name is
   `job-impressions`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.JobImpressions this]
    (-> this (.getName))))

