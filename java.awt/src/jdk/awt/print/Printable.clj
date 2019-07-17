(ns jdk.awt.print.Printable
  "The Printable interface is implemented
  by the print methods of the current
  page painter, which is called by the printing
  system to render a page.  When building a
  Pageable, pairs of PageFormat
  instances and instances that implement
  this interface are used to describe each page. The
  instance implementing Printable is called to
  print the page's graphics.

  A Printable(..) may be set on a PrinterJob.
  When the client subsequently initiates printing by calling
  PrinterJob.print(..) control

  is handed to the printing system until all pages have been printed.
  It does this by calling Printable.print(..) until
  all pages in the document have been printed.
  In using the Printable interface the printing
  commits to image the contents of a page whenever
  requested by the printing system.

  The parameters to Printable.print(..) include a
  PageFormat which describes the printable area of
  the page, needed for calculating the contents that will fit the
  page, and the page index, which specifies the zero-based print
  stream index of the requested page.

  For correct printing behaviour, the following points should be
  observed:

   The printing system may request a page index more than once.
  On each occasion equal PageFormat parameters will be supplied.

  The printing system will call Printable.print(..)
  with page indexes which increase monotonically, although as noted above,
  the Printable should expect multiple calls for a page index
  and that page indexes may be skipped, when page ranges are specified
  by the client, or by a user through a print dialog.

  If multiple collated copies of a document are requested, and the
  printer cannot natively support this, then the document may be imaged
  multiple times. Printing will start each copy from the lowest print
  stream page index page.

  With the exception of re-imaging an entire document for multiple
  collated copies, the increasing page index order means that when
  page N is requested if a client needs to calculate page break position,
  it may safely discard any state related to pages < N, and make current
  that for page N. `State` usually is just the calculated position in the
  document that corresponds to the start of the page.

  When called by the printing system the Printable must
  inspect and honour the supplied PageFormat parameter as well as the
  page index.  The format of the page to be drawn is specified by the
  supplied PageFormat. The size, orientation and imageable area of the page
  is therefore already determined and rendering must be within this
  imageable area.
  This is key to correct printing behaviour, and it has the
  implication that the client has the responsibility of tracking
  what content belongs on the specified page.

  When the Printable is obtained from a client-supplied
  Pageable then the client may provide different PageFormats
  for each page index. Calculations of page breaks must account for this."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print Printable]))

(defn print
  "Prints the page at the specified index into the specified
   Graphics context in the specified
   format.  A PrinterJob calls the
   Printable interface to request that a page be
   rendered into the context specified by
   graphics.  The format of the page to be drawn is
   specified by pageFormat.  The zero based index
   of the requested page is specified by pageIndex.
   If the requested page does not exist then this method returns
   NO_SUCH_PAGE; otherwise PAGE_EXISTS is returned.
   The Graphics class or subclass implements the
   PrinterGraphics interface to provide additional
   information.  If the Printable object
   aborts the print job then it throws a PrinterException.

  graphics - the context into which the page is drawn - `java.awt.Graphics`
  page-format - the size and orientation of the page being drawn - `java.awt.print.PageFormat`
  page-index - the zero based index of the page to be drawn - `int`

  returns: PAGE_EXISTS if the page is rendered successfully
           or NO_SUCH_PAGE if pageIndex specifies a
           non-existent page. - `int`

  throws: java.awt.print.PrinterException - thrown when the print job is terminated."
  (^Integer [^java.awt.print.Printable this ^java.awt.Graphics graphics ^java.awt.print.PageFormat page-format ^Integer page-index]
    (-> this (.print graphics page-format page-index))))

