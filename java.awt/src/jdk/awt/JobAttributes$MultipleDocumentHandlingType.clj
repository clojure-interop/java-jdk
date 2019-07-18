(ns jdk.awt.JobAttributes$MultipleDocumentHandlingType
  "A type-safe enumeration of possible multiple copy handling states.
  It is used to control how the sheets of multiple copies of a single
  document are collated."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt JobAttributes$MultipleDocumentHandlingType]))

(def *-separate-documents-collated-copies
  "Static Constant.

  The MultipleDocumentHandlingType instance to use for specifying
   that the job should be divided into separate, collated copies.

  type: java.awt.JobAttributes$MultipleDocumentHandlingType"
  JobAttributes$MultipleDocumentHandlingType/SEPARATE_DOCUMENTS_COLLATED_COPIES)

(def *-separate-documents-uncollated-copies
  "Static Constant.

  The MultipleDocumentHandlingType instance to use for specifying
   that the job should be divided into separate, uncollated copies.

  type: java.awt.JobAttributes$MultipleDocumentHandlingType"
  JobAttributes$MultipleDocumentHandlingType/SEPARATE_DOCUMENTS_UNCOLLATED_COPIES)

(defn hash-code
  "Description copied from class: Object

  returns: a hash code value for this object. - `int`"
  (^Integer [^JobAttributes$MultipleDocumentHandlingType this]
    (-> this (.hashCode))))

(defn to-string
  "Description copied from class: Object

  returns: a string representation of the object. - `java.lang.String`"
  (^java.lang.String [^JobAttributes$MultipleDocumentHandlingType this]
    (-> this (.toString))))

