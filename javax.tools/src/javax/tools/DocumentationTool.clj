(ns javax.tools.DocumentationTool
  "Interface to invoke Java™ programming language documentation tools from
  programs."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools DocumentationTool]))

(defn get-task
  "Creates a future for a documentation task with the given
   components and arguments.  The task might not have
   completed as described in the DocumentationTask interface.

   If a file manager is provided, it must be able to handle all
   locations defined in DocumentationTool.Location,
   as well as
   StandardLocation.SOURCE_PATH,
   StandardLocation.CLASS_PATH, and
   StandardLocation.PLATFORM_CLASS_PATH.

  out - a Writer for additional output from the tool; use System.err if null - `java.io.Writer`
  file-manager - a file manager; if null use the tool's standard filemanager - `javax.tools.JavaFileManager`
  diagnostic-listener - a diagnostic listener; if null use the tool's default method for reporting diagnostics - `javax.tools.JavaFileObject>`
  doclet-class - a class providing the necessary methods required of a doclet - `java.lang.Class<?>`
  options - documentation tool options and doclet options, null means no options - `java.lang.Iterable<java.lang.String>`
  compilation-units - the compilation units to compile, null means no compilation units - `javax.tools.JavaFileObject>`

  returns: an object representing the compilation - `javax.tools.DocumentationTool.DocumentationTask`

  throws: java.lang.RuntimeException - if an unrecoverable error occurred in a user supplied component. The cause will be the error in user code."
  ([^. this ^java.io.Writer out ^javax.tools.JavaFileManager file-manager ^javax.tools.JavaFileObject> diagnostic-listener ^java.lang.Class doclet-class ^java.lang.Iterable options ^javax.tools.JavaFileObject> compilation-units]
    (-> this (.getTask out file-manager diagnostic-listener doclet-class options compilation-units))))

(defn get-standard-file-manager
  "Gets a new instance of the standard file manager implementation
   for this tool.  The file manager will use the given diagnostic
   listener for producing any non-fatal diagnostics.  Fatal errors
   will be signaled with the appropriate exceptions.

   The standard file manager will be automatically reopened if
   it is accessed after calls to flush or close.
   The standard file manager must be usable with other tools.

  diagnostic-listener - a diagnostic listener for non-fatal diagnostics; if null use the compiler's default method for reporting diagnostics - `javax.tools.JavaFileObject>`
  locale - the locale to apply when formatting diagnostics; null means the default locale. - `java.util.Locale`
  charset - the character set used for decoding bytes; if null use the platform default - `java.nio.charset.Charset`

  returns: the standard file manager - `javax.tools.StandardJavaFileManager`"
  ([^. this ^javax.tools.JavaFileObject> diagnostic-listener ^java.util.Locale locale ^java.nio.charset.Charset charset]
    (-> this (.getStandardFileManager diagnostic-listener locale charset))))

