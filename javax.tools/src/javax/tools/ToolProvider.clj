(ns javax.tools.ToolProvider
  "Provides methods for locating tool providers, for example,
  providers of compilers.  This class complements the
  functionality of ServiceLoader."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.tools ToolProvider]))

(defn *get-system-java-compiler
  "Gets the Java™ programming language compiler provided
   with this platform.

  returns: the compiler provided with this platform or
   null if no compiler is provided - `javax.tools.JavaCompiler`"
  ([]
    (ToolProvider/getSystemJavaCompiler )))

(defn *get-system-documentation-tool
  "Gets the Java™ programming language documentation tool provided
   with this platform.

  returns: the documentation tool provided with this platform or
   null if no documentation tool is provided - `javax.tools.DocumentationTool`"
  ([]
    (ToolProvider/getSystemDocumentationTool )))

(defn *get-system-tool-class-loader
  "Returns the class loader for tools provided with this platform.
   This does not include user-installed tools.  Use the
   java.util.service provider mechanism
   for locating user installed tools.

  returns: the class loader for tools provided with this platform
   or null if no tools are provided - `java.lang.ClassLoader`"
  ([]
    (ToolProvider/getSystemToolClassLoader )))

