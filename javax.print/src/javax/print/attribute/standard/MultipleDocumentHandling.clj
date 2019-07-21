(ns javax.print.attribute.standard.MultipleDocumentHandling
  "Class MultipleDocumentHandling is a printing attribute class, an enumeration,
  that controls finishing operations and the placement of one or more
  print-stream pages into impressions and onto media sheets. When the value of
  the Copies attribute exceeds 1, MultipleDocumentHandling also
  controls the order in which the copies that result from processing the
  documents are produced. This attribute is relevant only for a multidoc print
  job consisting of two or more individual docs.

  Briefly, MultipleDocumentHandling determines the relationship between the
  multiple input (electronic) documents fed into a multidoc print job and the
  output (physical) document or documents produced by the multidoc print job.
  There are two possibilities:


  The multiple input documents are combined into a single output document.
  Finishing operations (Finishings),
  are performed on this single output
  document. The Copies attribute tells how many copies of this
  single output document to produce. The MultipleDocumentHandling values
  SINGLE_DOCUMENT and SINGLE_DOCUMENT_NEW_SHEET specify two variations of
  this  possibility.


  The multiple input documents remain separate output documents. Finishing
  operations (Finishings),
  are performed on each output document
  separately. The Copies attribute tells how many copies of each
  separate output document to produce. The MultipleDocumentHandling values
  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES and SEPARATE_DOCUMENTS_COLLATED_COPIES
  specify two variations of this possibility.


  In the detailed explanations below, if \"a\" represents an
  instance of document data, then the result of processing the data in
  document \"a\" is a sequence of media sheets represented by
  \"a(*)\".

  The standard MultipleDocumentHandling values are:


  SINGLE_DOCUMENT. If a print job has multiple
  documents -- say, the document data is called a and
  b -- then the result of processing all the document data
  (a and then b) must be treated as a single sequence
  of media sheets for finishing operations; that is, finishing would be
  performed on the concatenation of the sequences a(*),b(*). The
  printer must not force the data in each document instance to be formatted
  onto a new print-stream page, nor to start a new impression on a new media
  sheet. If more than one copy is made, the ordering of the sets of media
  sheets resulting from processing the document data must be
  a(*),b(*),a(*),b(*),..., and the printer object must force
  each copy (a(*),b(*)) to start on a new media sheet.


  SEPARATE_DOCUMENTS_UNCOLLATED_COPIES. If a print job
  has multiple documents -- say, the document data is called a and
  b -- then the result of processing the data in each document
  instance must be treated as a single sequence of media sheets for finishing
  operations; that is, the sets a(*) and b(*) would
  each be finished separately. The printer must force each copy of the result
  of processing the data in a single document to start on a new media sheet.
  If more than one copy is made, the ordering of the sets of media sheets
  resulting from processing the document data must be
  a(*),a(*),...,b(*),b(*)....


  SEPARATE_DOCUMENTS_COLLATED_COPIES. If a print job
  has multiple documents -- say, the document data is called a and
  b -- then the result of processing the data in each document
  instance must be treated as a single sequence of media sheets for finishing
  operations; that is, the sets a(*) and b(*) would
  each be finished separately. The printer must force each copy of the result
  of processing the data in a single document to start on a new media sheet.
  If more than one copy is made, the ordering of the sets of media sheets
  resulting from processing the document data must be
  a(*),b(*),a(*),b(*),....


  SINGLE_DOCUMENT_NEW_SHEET. Same as SINGLE_DOCUMENT,
  except that the printer must ensure that the first impression of each
  document instance in the job is placed on a new media sheet. This value
  allows multiple documents to be stapled together with a single staple where
  each document starts on a new sheet.


  SINGLE_DOCUMENT is the same as SEPARATE_DOCUMENTS_COLLATED_COPIES with
  respect to ordering of print-stream pages, but not media sheet generation,
  since SINGLE_DOCUMENT will put the first page of the next document on the
  back side of a sheet if an odd number of pages have been produced so far
  for the job, while SEPARATE_DOCUMENTS_COLLATED_COPIES always forces the
  next document or document copy on to a new sheet.

  In addition, if a Finishings attribute of
  STAPLE is specified, then:


  With SINGLE_DOCUMENT, documents a and b are
  stapled together as a single document with no regard to new sheets.


  With SINGLE_DOCUMENT_NEW_SHEET, documents a and b
  are stapled together as a single document, but document b
  starts on a new sheet.


  With SEPARATE_DOCUMENTS_UNCOLLATED_COPIES and
  SEPARATE_DOCUMENTS_COLLATED_COPIES, documents a and
  b are stapled separately.


  Note: None of these values provide means to produce uncollated
  sheets within a document, i.e., where multiple copies of sheet n
  are produced before sheet n+1 of the same document.
  To specify that, see the SheetCollate attribute.

  IPP Compatibility: The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard MultipleDocumentHandling]))

(def *-single-document
  "Static Constant.

  Single document -- see above for further
   information.

  type: javax.print.attribute.standard.MultipleDocumentHandling"
  MultipleDocumentHandling/SINGLE_DOCUMENT)

(def *-separate-documents-uncollated-copies
  "Static Constant.

  Separate documents uncollated copies -- see above for
   further information.

  type: javax.print.attribute.standard.MultipleDocumentHandling"
  MultipleDocumentHandling/SEPARATE_DOCUMENTS_UNCOLLATED_COPIES)

(def *-separate-documents-collated-copies
  "Static Constant.

  Separate documents collated copies -- see above for
   further information.

  type: javax.print.attribute.standard.MultipleDocumentHandling"
  MultipleDocumentHandling/SEPARATE_DOCUMENTS_COLLATED_COPIES)

(def *-single-document-new-sheet
  "Static Constant.

  Single document new sheet -- see above for
   further information.

  type: javax.print.attribute.standard.MultipleDocumentHandling"
  MultipleDocumentHandling/SINGLE_DOCUMENT_NEW_SHEET)

(defn get-category
  "Get the printing attribute class which is to be used as the \"category\"
   for this printing attribute value.

   For class MultipleDocumentHandling and any vendor-defined subclasses,
   the category is class MultipleDocumentHandling itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([^MultipleDocumentHandling this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class MultipleDocumentHandling and any vendor-defined subclasses,
   the category name is \"multiple-document-handling\".

  returns: Attribute category name. - `java.lang.String`"
  (^java.lang.String [^MultipleDocumentHandling this]
    (-> this (.getName))))

