(ns javax.tools.Tool
  "Common interface for tools that can be invoked from a program.
  A tool is traditionally a command line program such as a compiler.
  The set of tools available with a platform is defined by the
  vendor.

  Tools can be located using ServiceLoader.load(Class)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools Tool]))

(defn run
  "Run the tool with the given I/O channels and arguments. By
   convention a tool returns 0 for success and nonzero for errors.
   Any diagnostics generated will be written to either out
   or err in some unspecified format.

  in - \"standard\" input; use System.in if null - `java.io.InputStream`
  out - \"standard\" output; use System.out if null - `java.io.OutputStream`
  err - \"standard\" error; use System.err if null - `java.io.OutputStream`
  arguments - arguments to pass to the tool - `java.lang.String`

  returns: 0 for success; nonzero otherwise - `int`

  throws: java.lang.NullPointerException - if the array of arguments contains any null elements."
  (^Integer [^Tool this ^java.io.InputStream in ^java.io.OutputStream out ^java.io.OutputStream err ^java.lang.String arguments]
    (-> this (.run in out err arguments))))

(defn get-source-versions
  "Gets the source versions of the Java™ programming language
   supported by this tool.

  returns: a set of supported source versions - `java.util.Set<javax.lang.model.SourceVersion>`"
  (^java.util.Set [^Tool this]
    (-> this (.getSourceVersions))))

