(ns javax.print.MultiDocPrintService
  "Interface MultiPrintService is the factory for a MultiDocPrintJob.
  A MultiPrintService
  describes the capabilities of a Printer and can be queried regarding
  a printer's supported attributes."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print MultiDocPrintService]))

(defn create-multi-doc-print-job
  "Create a job which can print a multiDoc.

  returns: a MultiDocPrintJob - `javax.print.MultiDocPrintJob`"
  ([this]
    (-> this (.createMultiDocPrintJob))))

