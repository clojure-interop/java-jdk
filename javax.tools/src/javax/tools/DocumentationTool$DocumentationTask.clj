(ns javax.tools.DocumentationTool$DocumentationTask
  "Interface representing a future for a documentation task.  The
  task has not yet started.  To start the task, call
  the call method.

  Before calling the call method, additional aspects of the
  task can be configured, for example, by calling the
  setLocale method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools DocumentationTool$DocumentationTask]))

(defn set-locale
  "Set the locale to be applied when formatting diagnostics and
   other localized data.

  locale - the locale to apply; null means apply no locale - `java.util.Locale`

  throws: java.lang.IllegalStateException - if the task has started"
  ([^javax.tools.DocumentationTool$DocumentationTask this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn call
  "Performs this documentation task.  The task may only
   be performed once.  Subsequent calls to this method throw
   IllegalStateException.

  returns: true if and only all the files were processed without errors;
   false otherwise - `java.lang.Boolean`

  throws: java.lang.RuntimeException - if an unrecoverable error occurred in a user-supplied component. The cause will be the error in user code."
  ([^javax.tools.DocumentationTool$DocumentationTask this]
    (-> this (.call))))

