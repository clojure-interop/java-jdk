(ns javax.tools.JavaCompiler$CompilationTask
  "Interface representing a future for a compilation task.  The
  compilation task has not yet started.  To start the task, call
  the call method.

  Before calling the call method, additional aspects of the
  task can be configured, for example, by calling the
  setProcessors method."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools JavaCompiler$CompilationTask]))

(defn set-processors
  "Sets processors (for annotation processing).  This will
   bypass the normal discovery mechanism.

  processors - processors (for annotation processing) - `javax.annotation.processing.Processor>`

  throws: java.lang.IllegalStateException - if the task has started"
  ([^. this ^javax.annotation.processing.Processor> processors]
    (-> this (.setProcessors processors))))

(defn set-locale
  "Set the locale to be applied when formatting diagnostics and
   other localized data.

  locale - the locale to apply; null means apply no locale - `java.util.Locale`

  throws: java.lang.IllegalStateException - if the task has started"
  ([^. this ^java.util.Locale locale]
    (-> this (.setLocale locale))))

(defn call
  "Performs this compilation task.  The compilation may only
   be performed once.  Subsequent calls to this method throw
   IllegalStateException.

  returns: true if and only all the files compiled without errors;
   false otherwise - `java.lang.Boolean`

  throws: java.lang.RuntimeException - if an unrecoverable error occurred in a user-supplied component. The cause will be the error in user code."
  ([^. this]
    (-> this (.call))))

