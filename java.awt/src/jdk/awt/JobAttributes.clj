(ns jdk.awt.JobAttributes
  "A set of attributes which control a print job.

  Instances of this class control the number of copies, default selection,
  destination, print dialog, file and printer names, page ranges, multiple
  document handling (including collation), and multi-page imposition (such
  as duplex) of every print job which uses the instance. Attribute names are
  compliant with the Internet Printing Protocol (IPP) 1.1 where possible.
  Attribute values are partially compliant where possible.

  To use a method which takes an inner class type, pass a reference to
  one of the constant fields of the inner class. Client code cannot create
  new instances of the inner class types because none of those classes
  has a public constructor. For example, to set the print dialog type to
  the cross-platform, pure Java print dialog, use the following code:


  import java.awt.JobAttributes;

  public class PureJavaPrintDialogExample {
      public void setPureJavaPrintDialog(JobAttributes jobAttributes) {
          jobAttributes.setDialog(JobAttributes.DialogType.COMMON);
      }
  }

  Every IPP attribute which supports an attributeName-default value
  has a corresponding setattributeNameToDefault method.
  Default value fields are not provided."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt JobAttributes]))

(defn ->job-attributes
  "Constructor.

  Constructs a JobAttributes instance with the
   specified values for every attribute.

  copies - an integer greater than 0 - `int`
  default-selection - DefaultSelectionType.ALL, DefaultSelectionType.RANGE, or DefaultSelectionType.SELECTION - `java.awt.JobAttributes.DefaultSelectionType`
  destination - DesintationType.FILE or DesintationType.PRINTER - `java.awt.JobAttributes.DestinationType`
  dialog - DialogType.COMMON, DialogType.NATIVE, or DialogType.NONE - `java.awt.JobAttributes.DialogType`
  file-name - the possibly null file name - `java.lang.String`
  max-page - an integer greater than zero and greater than or equal to minPage - `int`
  min-page - an integer greater than zero and less than or equal to maxPage - `int`
  multiple-document-handling - MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_COLLATED_COPIES or MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_UNCOLLATED_COPIES - `java.awt.JobAttributes.MultipleDocumentHandlingType`
  page-ranges - an array of integer arrays of two elements; an array is interpreted as a range spanning all pages including and between the specified pages; ranges must be in ascending order and must not overlap; specified page numbers cannot be less than minPage nor greater than maxPage; for example: (new int[][] { new int[] { 1, 3 }, new int[] { 5, 5 }, new int[] { 15, 19 } }), specifies pages 1, 2, 3, 5, 15, 16, 17, 18, and 19. Note that (new int[][] { new int[] { 1, 1 }, new int[] { 1, 2 } }), is an invalid set of page ranges because the two ranges overlap - `int[][]`
  printer - the possibly null printer name - `java.lang.String`
  sides - SidesType.ONE_SIDED, SidesType.TWO_SIDED_LONG_EDGE, or SidesType.TWO_SIDED_SHORT_EDGE - `java.awt.JobAttributes.SidesType`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated"
  ([^Integer copies ^java.awt.JobAttributes.DefaultSelectionType default-selection ^java.awt.JobAttributes.DestinationType destination ^java.awt.JobAttributes.DialogType dialog ^java.lang.String file-name ^Integer max-page ^Integer min-page ^java.awt.JobAttributes.MultipleDocumentHandlingType multiple-document-handling page-ranges ^java.lang.String printer ^java.awt.JobAttributes.SidesType sides]
    (new JobAttributes copies default-selection destination dialog file-name max-page min-page multiple-document-handling page-ranges printer sides))
  ([^java.awt.JobAttributes obj]
    (new JobAttributes obj))
  ([]
    (new JobAttributes )))

(defn get-file-name
  "Specifies the file name for the output file for jobs using these
   attributes. This attribute is updated to the value chosen by the user.

  returns: the possibly null file name - `java.lang.String`"
  (^java.lang.String [^java.awt.JobAttributes this]
    (-> this (.getFileName))))

(defn set-destination
  "Specifies whether output will be to a printer or a file for jobs using
   these attributes. Not specifying this attribute is equivalent to
   specifying DesintationType.PRINTER.

  destination - DesintationType.FILE or DesintationType.PRINTER. - `java.awt.JobAttributes.DestinationType`

  throws: java.lang.IllegalArgumentException - if destination is null."
  ([^java.awt.JobAttributes this ^java.awt.JobAttributes.DestinationType destination]
    (-> this (.setDestination destination))))

(defn set-sides-to-default
  "Sets how consecutive pages should be imposed upon the sides of the
   print medium for jobs using these attributes to the default. The
   default imposition is SidesType.ONE_SIDED."
  ([^java.awt.JobAttributes this]
    (-> this (.setSidesToDefault))))

(defn set-copies
  "Specifies the number of copies the application should render for jobs
   using these attributes. Not specifying this attribute is equivalent to
   specifying 1.

  copies - an integer greater than 0 - `int`

  throws: java.lang.IllegalArgumentException - if copies is less than or equal to 0"
  ([^java.awt.JobAttributes this ^Integer copies]
    (-> this (.setCopies copies))))

(defn set-file-name
  "Specifies the file name for the output file for jobs using these
   attributes. Default is platform-dependent and implementation-defined.

  file-name - the possibly null file name. - `java.lang.String`"
  ([^java.awt.JobAttributes this ^java.lang.String file-name]
    (-> this (.setFileName file-name))))

(defn set-page-ranges
  "Specifies, for jobs using these attributes, the ranges of pages to be
   printed, if a range of pages is to be printed. All range numbers are
   inclusive. If this attribute is not specified, then the values from the
   fromPage and toPages attributes are used. If pageRanges and either or
   both of fromPage and toPage are specified, pageRanges takes precedence.
   Specifying none of pageRanges, fromPage, or toPage is equivalent to
   calling setPageRanges(new int[][] { new int[] { minPage,
                                                   minPage } });

  page-ranges - an array of integer arrays of 2 elements. An array is interpreted as a range spanning all pages including and between the specified pages. Ranges must be in ascending order and must not overlap. Specified page numbers cannot be less than minPage nor greater than maxPage. For example: (new int[][] { new int[] { 1, 3 }, new int[] { 5, 5 }, new int[] { 15, 19 } }), specifies pages 1, 2, 3, 5, 15, 16, 17, 18, and 19. Note that (new int[][] { new int[] { 1, 1 }, new int[] { 1, 2 } }), is an invalid set of page ranges because the two ranges overlap. - `int[][]`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated."
  ([^java.awt.JobAttributes this page-ranges]
    (-> this (.setPageRanges page-ranges))))

(defn set-min-page
  "Specifies the minimum value the user can specify as the first page to
   be printed for jobs using these attributes. Not specifying this
   attribute is equivalent to specifying 1.

  min-page - an integer greater than zero and less than or equal to maxPage. - `int`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated."
  ([^java.awt.JobAttributes this ^Integer min-page]
    (-> this (.setMinPage min-page))))

(defn get-to-page
  "Returns, for jobs using these attributes, the last page (inclusive)
   to be printed, if a range of pages is to be printed. This attribute is
   updated to the value chosen by the user. An application should ignore
   this attribute on output, unless the return value of the
   getDefaultSelection method is DefaultSelectionType.RANGE. An
   application should honor the return value of getPageRanges
   over the return value of this method, if possible.

  returns: an integer greater than zero and greater than or equal
            to toPage and greater than or equal to minPage
            and less than or equal to maxPage. - `int`"
  (^Integer [^java.awt.JobAttributes this]
    (-> this (.getToPage))))

(defn get-printer
  "Returns the destination printer for jobs using these attributes. This
   attribute is updated to the value chosen by the user.

  returns: the possibly null printer name. - `java.lang.String`"
  (^java.lang.String [^java.awt.JobAttributes this]
    (-> this (.getPrinter))))

(defn get-destination
  "Specifies whether output will be to a printer or a file for jobs using
   these attributes. This attribute is updated to the value chosen by the
   user.

  returns: DesintationType.FILE or DesintationType.PRINTER - `java.awt.JobAttributes.DestinationType`"
  (^java.awt.JobAttributes.DestinationType [^java.awt.JobAttributes this]
    (-> this (.getDestination))))

(defn set-copies-to-default
  "Sets the number of copies the application should render for jobs using
   these attributes to the default. The default number of copies is 1."
  ([^java.awt.JobAttributes this]
    (-> this (.setCopiesToDefault))))

(defn get-default-selection
  "Specifies whether, for jobs using these attributes, the application
   should print all pages, the range specified by the return value of
   getPageRanges, or the current selection. This attribute
   is updated to the value chosen by the user.

  returns: DefaultSelectionType.ALL, DefaultSelectionType.RANGE, or
            DefaultSelectionType.SELECTION - `java.awt.JobAttributes.DefaultSelectionType`"
  (^java.awt.JobAttributes.DefaultSelectionType [^java.awt.JobAttributes this]
    (-> this (.getDefaultSelection))))

(defn to-string
  "Returns a string representation of this JobAttributes.

  returns: the string representation. - `java.lang.String`"
  (^java.lang.String [^java.awt.JobAttributes this]
    (-> this (.toString))))

(defn set-to-page
  "Specifies, for jobs using these attributes, the last page (inclusive)
   to be printed, if a range of pages is to be printed.
   If this attribute is not specified, then the values from the pageRanges
   attribute are used. If pageRanges and either or both of fromPage and
   toPage are specified, pageRanges takes precedence. Specifying none of
   pageRanges, fromPage, or toPage is equivalent to calling
   setPageRanges(new int[][] { new int[] { minPage } });

  to-page - an integer greater than zero and greater than or equal to fromPage and greater than or equal to minPage and less than or equal to maxPage. - `int`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated."
  ([^java.awt.JobAttributes this ^Integer to-page]
    (-> this (.setToPage to-page))))

(defn set-from-page
  "Specifies, for jobs using these attributes, the first page to be
   printed, if a range of pages is to be printed. If this attribute is not
   specified, then the values from the pageRanges attribute are used. If
   pageRanges and either or both of fromPage and toPage are specified,
   pageRanges takes precedence. Specifying none of pageRanges, fromPage,
   or toPage is equivalent to calling
   setPageRanges(new int[][] { new int[] { minPage } });

  from-page - an integer greater than zero and less than or equal to toPage and greater than or equal to minPage and less than or equal to maxPage. - `int`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated."
  ([^java.awt.JobAttributes this ^Integer from-page]
    (-> this (.setFromPage from-page))))

(defn get-copies
  "Returns the number of copies the application should render for jobs
   using these attributes. This attribute is updated to the value chosen
   by the user.

  returns: an integer greater than 0. - `int`"
  (^Integer [^java.awt.JobAttributes this]
    (-> this (.getCopies))))

(defn set-sides
  "Specifies how consecutive pages should be imposed upon the sides of the
   print medium for jobs using these attributes. SidesType.ONE_SIDED
   imposes each consecutive page upon the same side of consecutive media
   sheets. This imposition is sometimes called simplex.
   SidesType.TWO_SIDED_LONG_EDGE imposes each consecutive pair of pages
   upon front and back sides of consecutive media sheets, such that the
   orientation of each pair of pages on the medium would be correct for
   the reader as if for binding on the long edge. This imposition is
   sometimes called duplex. SidesType.TWO_SIDED_SHORT_EDGE imposes
   each consecutive pair of pages upon front and back sides of consecutive
   media sheets, such that the orientation of each pair of pages on the
   medium would be correct for the reader as if for binding on the short
   edge. This imposition is sometimes called tumble. Not specifying
   this attribute is equivalent to specifying SidesType.ONE_SIDED.

  sides - SidesType.ONE_SIDED, SidesType.TWO_SIDED_LONG_EDGE, or SidesType.TWO_SIDED_SHORT_EDGE. - `java.awt.JobAttributes.SidesType`

  throws: java.lang.IllegalArgumentException - if sides is null."
  ([^java.awt.JobAttributes this ^java.awt.JobAttributes.SidesType sides]
    (-> this (.setSides sides))))

(defn set-printer
  "Specifies the destination printer for jobs using these attributes.
   Default is platform-dependent and implementation-defined.

  printer - the possibly null printer name. - `java.lang.String`"
  ([^java.awt.JobAttributes this ^java.lang.String printer]
    (-> this (.setPrinter printer))))

(defn set-multiple-document-handling-to-default
  "Sets the handling of multiple copies, including collation, for jobs
   using these attributes to the default. The default handling is
   MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_UNCOLLATED_COPIES."
  ([^java.awt.JobAttributes this]
    (-> this (.setMultipleDocumentHandlingToDefault))))

(defn get-max-page
  "Specifies the maximum value the user can specify as the last page to
   be printed for jobs using these attributes. This attribute cannot be
   modified by, and is not subject to any limitations of, the
   implementation or the target printer.

  returns: an integer greater than zero and greater than or equal
            to minPage. - `int`"
  (^Integer [^java.awt.JobAttributes this]
    (-> this (.getMaxPage))))

(defn clone
  "Creates and returns a copy of this JobAttributes.

  returns: the newly created copy; it is safe to cast this Object into
            a JobAttributes - `java.lang.Object`"
  (^java.lang.Object [^java.awt.JobAttributes this]
    (-> this (.clone))))

(defn hash-code
  "Returns a hash code value for this JobAttributes.

  returns: the hash code. - `int`"
  (^Integer [^java.awt.JobAttributes this]
    (-> this (.hashCode))))

(defn set
  "Sets all of the attributes of this JobAttributes to
   the same values as the attributes of obj.

  obj - the JobAttributes to copy - `java.awt.JobAttributes`"
  ([^java.awt.JobAttributes this ^java.awt.JobAttributes obj]
    (-> this (.set obj))))

(defn get-min-page
  "Specifies the minimum value the user can specify as the first page to
   be printed for jobs using these attributes. This attribute cannot be
   modified by, and is not subject to any limitations of, the
   implementation or the target printer.

  returns: an integer greater than zero and less than or equal
            to maxPage. - `int`"
  (^Integer [^java.awt.JobAttributes this]
    (-> this (.getMinPage))))

(defn get-sides
  "Returns how consecutive pages should be imposed upon the sides of the
   print medium for jobs using these attributes. SidesType.ONE_SIDED
   imposes each consecutive page upon the same side of consecutive media
   sheets. This imposition is sometimes called simplex.
   SidesType.TWO_SIDED_LONG_EDGE imposes each consecutive pair of pages
   upon front and back sides of consecutive media sheets, such that the
   orientation of each pair of pages on the medium would be correct for
   the reader as if for binding on the long edge. This imposition is
   sometimes called duplex. SidesType.TWO_SIDED_SHORT_EDGE imposes
   each consecutive pair of pages upon front and back sides of consecutive
   media sheets, such that the orientation of each pair of pages on the
   medium would be correct for the reader as if for binding on the short
   edge. This imposition is sometimes called tumble. This attribute
   is updated to the value chosen by the user.

  returns: SidesType.ONE_SIDED, SidesType.TWO_SIDED_LONG_EDGE, or
            SidesType.TWO_SIDED_SHORT_EDGE. - `java.awt.JobAttributes.SidesType`"
  (^java.awt.JobAttributes.SidesType [^java.awt.JobAttributes this]
    (-> this (.getSides))))

(defn set-dialog
  "Specifies whether, for jobs using these attributes, the user should see
   a print dialog in which to modify the print settings, and which type of
   print dialog should be displayed. DialogType.COMMON denotes a cross-
   platform, pure Java print dialog. DialogType.NATIVE denotes the
   platform's native print dialog. If a platform does not support a native
   print dialog, the pure Java print dialog is displayed instead.
   DialogType.NONE specifies no print dialog (i.e., background printing).
   Not specifying this attribute is equivalent to specifying
   DialogType.NATIVE.

  dialog - DialogType.COMMON, DialogType.NATIVE, or DialogType.NONE. - `java.awt.JobAttributes.DialogType`

  throws: java.lang.IllegalArgumentException - if dialog is null."
  ([^java.awt.JobAttributes this ^java.awt.JobAttributes.DialogType dialog]
    (-> this (.setDialog dialog))))

(defn get-page-ranges
  "Specifies, for jobs using these attributes, the ranges of pages to be
   printed, if a range of pages is to be printed. All range numbers are
   inclusive. This attribute is updated to the value chosen by the user.
   An application should ignore this attribute on output, unless the
   return value of the getDefaultSelection method is
   DefaultSelectionType.RANGE.

  returns: an array of integer arrays of 2 elements. An array
            is interpreted as a range spanning all pages including and
            between the specified pages. Ranges must be in ascending
            order and must not overlap. Specified page numbers cannot be
            less than minPage nor greater than maxPage.
            For example:
            (new int[][] { new int[] { 1, 3 }, new int[] { 5, 5 },
                           new int[] { 15, 19 } }),
            specifies pages 1, 2, 3, 5, 15, 16, 17, 18, and 19. - `int[][]`"
  ([^java.awt.JobAttributes this]
    (-> this (.getPageRanges))))

(defn get-multiple-document-handling
  "Specifies the handling of multiple copies, including collation, for
   jobs using these attributes. This attribute is updated to the value
   chosen by the user.

  returns: MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_COLLATED_COPIES or
       MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_UNCOLLATED_COPIES. - `java.awt.JobAttributes.MultipleDocumentHandlingType`"
  (^java.awt.JobAttributes.MultipleDocumentHandlingType [^java.awt.JobAttributes this]
    (-> this (.getMultipleDocumentHandling))))

(defn set-max-page
  "Specifies the maximum value the user can specify as the last page to
   be printed for jobs using these attributes. Not specifying this
   attribute is equivalent to specifying Integer.MAX_VALUE.

  max-page - an integer greater than zero and greater than or equal to minPage - `int`

  throws: java.lang.IllegalArgumentException - if one or more of the above conditions is violated"
  ([^java.awt.JobAttributes this ^Integer max-page]
    (-> this (.setMaxPage max-page))))

(defn set-multiple-document-handling
  "Specifies the handling of multiple copies, including collation, for
   jobs using these attributes. Not specifying this attribute is equivalent
   to specifying
   MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_UNCOLLATED_COPIES.

  multiple-document-handling - MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_COLLATED_COPIES or MultipleDocumentHandlingType.SEPARATE_DOCUMENTS_UNCOLLATED_COPIES. - `java.awt.JobAttributes.MultipleDocumentHandlingType`

  throws: java.lang.IllegalArgumentException - if multipleDocumentHandling is null."
  ([^java.awt.JobAttributes this ^java.awt.JobAttributes.MultipleDocumentHandlingType multiple-document-handling]
    (-> this (.setMultipleDocumentHandling multiple-document-handling))))

(defn set-default-selection
  "Specifies whether, for jobs using these attributes, the application
   should print all pages, the range specified by the return value of
   getPageRanges, or the current selection. Not specifying
   this attribute is equivalent to specifying DefaultSelectionType.ALL.

  default-selection - DefaultSelectionType.ALL, DefaultSelectionType.RANGE, or DefaultSelectionType.SELECTION. - `java.awt.JobAttributes.DefaultSelectionType`

  throws: java.lang.IllegalArgumentException - if defaultSelection is null"
  ([^java.awt.JobAttributes this ^java.awt.JobAttributes.DefaultSelectionType default-selection]
    (-> this (.setDefaultSelection default-selection))))

(defn equals
  "Determines whether two JobAttributes are equal to each other.

   Two JobAttributes are equal if and only if each of their attributes are
   equal. Attributes of enumeration type are equal if and only if the
   fields refer to the same unique enumeration object. A set of page
   ranges is equal if and only if the sets are of equal length, each range
   enumerates the same pages, and the ranges are in the same order.

  obj - the object whose equality will be checked. - `java.lang.Object`

  returns: whether obj is equal to this JobAttribute according to the
            above criteria. - `boolean`"
  (^Boolean [^java.awt.JobAttributes this ^java.lang.Object obj]
    (-> this (.equals obj))))

(defn get-dialog
  "Returns whether, for jobs using these attributes, the user should see
   a print dialog in which to modify the print settings, and which type of
   print dialog should be displayed. DialogType.COMMON denotes a cross-
   platform, pure Java print dialog. DialogType.NATIVE denotes the
   platform's native print dialog. If a platform does not support a native
   print dialog, the pure Java print dialog is displayed instead.
   DialogType.NONE specifies no print dialog (i.e., background printing).
   This attribute cannot be modified by, and is not subject to any
   limitations of, the implementation or the target printer.

  returns: DialogType.COMMON, DialogType.NATIVE, or
            DialogType.NONE - `java.awt.JobAttributes.DialogType`"
  (^java.awt.JobAttributes.DialogType [^java.awt.JobAttributes this]
    (-> this (.getDialog))))

(defn get-from-page
  "Returns, for jobs using these attributes, the first page to be
   printed, if a range of pages is to be printed. This attribute is
   updated to the value chosen by the user. An application should ignore
   this attribute on output, unless the return value of the
   getDefaultSelection method is DefaultSelectionType.RANGE. An
   application should honor the return value of getPageRanges
   over the return value of this method, if possible.

  returns: an integer greater than zero and less than or equal to
            toPage and greater than or equal to minPage and
            less than or equal to maxPage. - `int`"
  (^Integer [^java.awt.JobAttributes this]
    (-> this (.getFromPage))))

