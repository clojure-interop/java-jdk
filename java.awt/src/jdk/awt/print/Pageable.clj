(ns jdk.awt.print.Pageable
  "The Pageable implementation represents a set of
  pages to be printed. The Pageable object returns
  the total number of pages in the set as well as the
  PageFormat and Printable for a specified page."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print Pageable]))

(defn get-number-of-pages
  "Returns the number of pages in the set.
   To enable advanced printing features,
   it is recommended that Pageable
   implementations return the true number of pages
   rather than the
   UNKNOWN_NUMBER_OF_PAGES constant.

  returns: the number of pages in this Pageable. - `int`"
  ([^. this]
    (-> this (.getNumberOfPages))))

(defn get-page-format
  "Returns the PageFormat of the page specified by
   pageIndex.

  page-index - the zero based index of the page whose PageFormat is being requested - `int`

  returns: the PageFormat describing the size and
            orientation. - `java.awt.print.PageFormat`

  throws: java.lang.IndexOutOfBoundsException - if the Pageable does not contain the requested page."
  ([^. this ^Integer page-index]
    (-> this (.getPageFormat page-index))))

(defn get-printable
  "Returns the Printable instance responsible for
   rendering the page specified by pageIndex.

  page-index - the zero based index of the page whose Printable is being requested - `int`

  returns: the Printable that renders the page. - `java.awt.print.Printable`

  throws: java.lang.IndexOutOfBoundsException - if the Pageable does not contain the requested page."
  ([^. this ^Integer page-index]
    (-> this (.getPrintable page-index))))

