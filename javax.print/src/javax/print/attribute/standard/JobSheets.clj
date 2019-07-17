(ns javax.print.attribute.standard.JobSheets
  "Class JobSheets is a printing attribute class, an enumeration, that
  determines which job start and end sheets, if any, must be printed with a
  job. Class JobSheets declares keywords for standard job sheets values.
  Implementation- or site-defined names for a job sheets attribute may also be
  created by defining a subclass of class JobSheets.

  The effect of a JobSheets attribute on multidoc print jobs (jobs with
  multiple documents) may be affected by the MultipleDocumentHandling job attribute, depending on the meaning of the
  particular JobSheets value.

  IPP Compatibility:  The category name returned by
  getName() is the IPP attribute name.  The
  enumeration's integer value is the IPP enum value.  The
  toString() method returns the IPP string representation of
  the attribute value. For a subclass, the attribute value must be
  localized to give the IPP name and natural language values."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard JobSheets]))

(def *-none
  "Static Constant.

  No job sheets are printed.

  type: javax.print.attribute.standard.JobSheets"
  JobSheets/NONE)

(def *-standard
  "Static Constant.

  One or more site specific standard job sheets are printed. e.g. a
   single start sheet is printed, or both start and end sheets are
   printed.

  type: javax.print.attribute.standard.JobSheets"
  JobSheets/STANDARD)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class JobSheets and any vendor-defined subclasses, the category is
   class JobSheets itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.JobSheets this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class JobSheets and any vendor-defined subclasses, the category
   name is `job-sheets`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^javax.print.attribute.standard.JobSheets this]
    (-> this (.getName))))

