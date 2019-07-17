(ns jdk.awt.print.Book
  "The Book class provides a representation of a document in
  which pages may have different page formats and page painters. This
  class uses the Pageable interface to interact with a
  PrinterJob."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print Book]))

(defn ->book
  "Constructor.

  Creates a new, empty Book."
  ([]
    (new Book )))

(defn get-number-of-pages
  "Returns the number of pages in this Book.

  returns: the number of pages this Book contains. - `int`"
  (^Integer [^java.awt.print.Book this]
    (-> this (.getNumberOfPages))))

(defn get-page-format
  "Returns the PageFormat of the page specified by
   pageIndex.

  page-index - the zero based index of the page whose PageFormat is being requested - `int`

  returns: the PageFormat describing the size and
            orientation of the page. - `java.awt.print.PageFormat`

  throws: java.lang.IndexOutOfBoundsException - if the Pageable does not contain the requested page"
  (^java.awt.print.PageFormat [^java.awt.print.Book this ^Integer page-index]
    (-> this (.getPageFormat page-index))))

(defn get-printable
  "Returns the Printable instance responsible for rendering
   the page specified by pageIndex.

  page-index - the zero based index of the page whose Printable is being requested - `int`

  returns: the Printable that renders the page. - `java.awt.print.Printable`

  throws: java.lang.IndexOutOfBoundsException - if the Pageable does not contain the requested page"
  (^java.awt.print.Printable [^java.awt.print.Book this ^Integer page-index]
    (-> this (.getPrintable page-index))))

(defn set-page
  "Sets the PageFormat and the Painter for a
   specified page number.

  page-index - the zero based index of the page whose painter and format is altered - `int`
  painter - the Printable instance that renders the page - `java.awt.print.Printable`
  page - the size and orientation of the page - `java.awt.print.PageFormat`

  throws: java.lang.IndexOutOfBoundsException - if the specified page is not already in this Book"
  ([^java.awt.print.Book this ^Integer page-index ^java.awt.print.Printable painter ^java.awt.print.PageFormat page]
    (-> this (.setPage page-index painter page))))

(defn append
  "Appends numPages pages to the end of this
   Book.  Each of the pages is associated with
   page.

  painter - the Printable instance that renders the page - `java.awt.print.Printable`
  page - the size and orientation of the page - `java.awt.print.PageFormat`
  num-pages - the number of pages to be added to the this Book. - `int`

  throws: java.lang.NullPointerException - If the painter or page argument is null"
  ([^java.awt.print.Book this ^java.awt.print.Printable painter ^java.awt.print.PageFormat page ^Integer num-pages]
    (-> this (.append painter page num-pages)))
  ([^java.awt.print.Book this ^java.awt.print.Printable painter ^java.awt.print.PageFormat page]
    (-> this (.append painter page))))

