(ns javax.print.attribute.standard.Fidelity
  "Class Fidelity is a printing attribute class, an enumeration,
  that indicates whether total fidelity to client supplied print request
  attributes is required.
  If FIDELITY_TRUE is specified and a service cannot print the job exactly
  as specified it must reject the job.
  If FIDELITY_FALSE is specified a reasonable attempt to print the job is
  acceptable. If not supplied the default is FIDELITY_FALSE.


  IPP Compatibility: The IPP boolean value is `true` for FIDELITY_TRUE
  and `false` for FIDELITY_FALSE. The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value.
  See RFC 2911 Section 15.1 for
  a fuller description of the IPP fidelity attribute."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Fidelity]))

(def *-fidelity-true
  "Static Constant.

  The job must be printed exactly as specified. or else rejected.

  type: javax.print.attribute.standard.Fidelity"
  Fidelity/FIDELITY_TRUE)

(def *-fidelity-false
  "Static Constant.

  The printer should make reasonable attempts to print the job,
   even if it cannot print it exactly as specified.

  type: javax.print.attribute.standard.Fidelity"
  Fidelity/FIDELITY_FALSE)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Fidelity the category is class Fidelity itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^javax.print.attribute.standard.Fidelity this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Fidelity the category name is
   `ipp-attribute-fidelity`.

  returns: Attribute category name. - `java.lang.String`"
  ([^javax.print.attribute.standard.Fidelity this]
    (-> this (.getName))))

