(ns javax.tools.DiagnosticListener
  "Interface for receiving diagnostics from tools."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools DiagnosticListener]))

(defn report
  "Invoked when a problem is found.

  diagnostic - a diagnostic representing the problem that was found - `DiagnosticListener.S>`

  throws: java.lang.NullPointerException - if the diagnostic argument is null and the implementation cannot handle null arguments"
  ([^javax.tools.DiagnosticListener this ^DiagnosticListener.S> diagnostic]
    (-> this (.report diagnostic))))

