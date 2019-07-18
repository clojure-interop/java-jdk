(ns javax.print.attribute.standard.Sides
  "Class Sides is a printing attribute class, an enumeration, that specifies
  how print-stream pages are to be imposed upon the sides of an instance of a
  selected medium, i.e., an impression.

  The effect of a Sides attribute on a multidoc print job (a job with multiple
  documents) depends on whether all the docs have the same sides values
  specified or whether different docs have different sides values specified,
  and on the (perhaps defaulted) value of the MultipleDocumentHandling attribute.


  If all the docs have the same sides value n specified, then any value
  of MultipleDocumentHandling makes sense,
  and the printer's processing depends on the MultipleDocumentHandling value:


  SINGLE_DOCUMENT -- All the input docs will be combined together into one
  output document. Each media sheet will consist of n impressions from
  the output document.


  SINGLE_DOCUMENT_NEW_SHEET -- All the input docs will be combined together
  into one output document. Each media sheet will consist of n
  impressions from the output document. However, the first impression of each
  input doc will always start on a new media sheet; this means the last media
  sheet of an input doc may have only one impression on it.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- The input docs will remain separate.
  Each media sheet will consist of n impressions from the input doc.
  Since the input docs are separate, the first impression of each input doc
  will always start on a new media sheet; this means the last media sheet of
  an input doc may have only one impression on it.


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- The input docs will remain separate.
  Each media sheet will consist of n impressions from the input doc.
  Since the input docs are separate, the first impression of each input doc
  will always start on a new media sheet; this means the last media sheet of
  an input doc may have only one impression on it.




  SINGLE_DOCUMENT -- All the input docs will be combined together into one
  output document. Each media sheet will consist of ni
  impressions from the output document, where i is the number of the
  input doc corresponding to that point in the output document. When the next
  input doc has a different sides value from the previous input doc, the first
  print-stream page of the next input doc goes at the start of the next media
  sheet, possibly leaving only one impression on the previous media sheet.


  SINGLE_DOCUMENT_NEW_SHEET -- All the input docs will be combined together
  into one output document. Each media sheet will consist of n
  impressions from the output document. However, the first impression of each
  input doc will always start on a new media sheet; this means the last
  impression of an input doc may have only one impression on it.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES -- The input docs will remain separate.
  For input doc i, each media sheet will consist of ni
  impressions from the input doc. Since the input docs are separate, the first
  impression of each input doc will always start on a new media sheet; this
  means the last media sheet of an input doc may have only one impression on
  it.


  SEPARATE_DOCUMENTS_COLLATED_COPIES -- The input docs will remain separate.
  For input doc i, each media sheet will consist of ni
  impressions from the input doc. Since the input docs are separate, the first
  impression of each input doc will always start on a new media sheet; this
  means the last media sheet of an input doc may have only one impression on
  it.



  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard Sides]))

(def *-one-sided
  "Static Constant.

  Imposes each consecutive print-stream page upon the same side of
   consecutive media sheets.

  type: javax.print.attribute.standard.Sides"
  Sides/ONE_SIDED)

(def *-two-sided-long-edge
  "Static Constant.

  Imposes each consecutive pair of print-stream pages upon front and back
   sides of consecutive media sheets, such that the orientation of each
   pair of print-stream pages on the medium would be correct for the
   reader as if for binding on the long edge. This imposition is also
   known as `duplex` (see DUPLEX).

  type: javax.print.attribute.standard.Sides"
  Sides/TWO_SIDED_LONG_EDGE)

(def *-two-sided-short-edge
  "Static Constant.

  Imposes each consecutive pair of print-stream pages upon front and back
   sides of consecutive media sheets, such that the orientation of each
   pair of print-stream pages on the medium would be correct for the
   reader as if for binding on the short edge. This imposition is also
   known as `tumble` (see TUMBLE).

  type: javax.print.attribute.standard.Sides"
  Sides/TWO_SIDED_SHORT_EDGE)

(def *-duplex
  "Static Constant.

  An alias for `two sided long edge` (see TWO_SIDED_LONG_EDGE).

  type: javax.print.attribute.standard.Sides"
  Sides/DUPLEX)

(def *-tumble
  "Static Constant.

  An alias for `two sided short edge` (see TWO_SIDED_SHORT_EDGE).

  type: javax.print.attribute.standard.Sides"
  Sides/TUMBLE)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class Sides, the category is class Sides itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^Sides this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class Sides, the category name is `sides`.

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^Sides this]
    (-> this (.getName))))

