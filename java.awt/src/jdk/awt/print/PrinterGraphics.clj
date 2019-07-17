(ns jdk.awt.print.PrinterGraphics
  "The PrinterGraphics interface is implemented by
  Graphics objects that are passed to
  Printable objects to render a page. It allows an
  application to find the PrinterJob object that is
  controlling the printing."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.print PrinterGraphics]))

(defn get-printer-job
  "Returns the PrinterJob that is controlling the
   current rendering request.

  returns: the PrinterJob controlling the current
   rendering request. - `java.awt.print.PrinterJob`"
  ([this]
    (-> this (.getPrinterJob))))

