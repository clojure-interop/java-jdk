(ns javax.tools.DiagnosticCollector
  "Provides an easy way to collect diagnostics in a list."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools DiagnosticCollector]))

(defn ->diagnostic-collector
  "Constructor."
  (^DiagnosticCollector []
    (new DiagnosticCollector )))

(defn report
  "Description copied from interface: DiagnosticListener

  diagnostic - a diagnostic representing the problem that was found - `javax.tools.Diagnostic`"
  ([^DiagnosticCollector this ^javax.tools.Diagnostic diagnostic]
    (-> this (.report diagnostic))))

(defn get-diagnostics
  "Gets a list view of diagnostics collected by this object.

  returns: a list view of diagnostics - `java.util.List<javax.tools.Diagnostic<? extends S>>`"
  ([^DiagnosticCollector this]
    (-> this (.getDiagnostics))))

