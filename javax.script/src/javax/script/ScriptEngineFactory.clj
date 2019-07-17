(ns javax.script.ScriptEngineFactory
  "ScriptEngineFactory is used to describe and instantiate
  ScriptEngines.

  Each class implementing ScriptEngine has a corresponding factory
  that exposes metadata describing the engine class.
  The ScriptEngineManager
  uses the service provider mechanism described in the Jar File Specification to obtain
  instances of all ScriptEngineFactories available in
  the current ClassLoader."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script ScriptEngineFactory]))

(defn get-engine-version
  "Returns the version of the ScriptEngine.

  returns: The ScriptEngine implementation version. - `java.lang.String`"
  ([^. this]
    (-> this (.getEngineVersion))))

(defn get-language-version
  "Returns the version of the scripting language supported by this
   ScriptEngine.

  returns: The version of the supported language. - `java.lang.String`"
  ([^. this]
    (-> this (.getLanguageVersion))))

(defn get-program
  "Returns a valid scripting language executable program with given statements.
   For instance an implementation for a PHP engine might be:



   public String getProgram(String... statements) {
        String retval = `<?\n`;
        int len = statements.length;
        for (int i = 0; i < len; i++) {
            retval = statements[i]  `;\n`;
        }
        return retval = `?>`;
   }

  statements - The statements to be executed. May be return values of calls to the getMethodCallSyntax and getOutputStatement methods. - `java.lang.String`

  returns: The Program - `java.lang.String`"
  ([^. this ^java.lang.String statements]
    (-> this (.getProgram statements))))

(defn get-extensions
  "Returns an immutable list of filename extensions, which generally identify scripts
   written in the language supported by this ScriptEngine.
   The array is used by the ScriptEngineManager to implement its
   getEngineByExtension method.

  returns: The list of extensions. - `java.util.List<java.lang.String>`"
  ([^. this]
    (-> this (.getExtensions))))

(defn get-output-statement
  "Returns a String that can be used as a statement to display the specified String  using
   the syntax of the supported scripting language.  For instance, the implementation for a Perl
   engine might be;



   public String getOutputStatement(String toDisplay) {
        return `print(`  toDisplay  `)`;
   }

  to-display - The String to be displayed by the returned statement. - `java.lang.String`

  returns: The string used to display the String in the syntax of the scripting language. - `java.lang.String`"
  ([^. this ^java.lang.String to-display]
    (-> this (.getOutputStatement to-display))))

(defn get-parameter
  "Returns the value of an attribute whose meaning may be implementation-specific.
   Keys for which the value is defined in all implementations are:

   ScriptEngine.ENGINE
   ScriptEngine.ENGINE_VERSION
   ScriptEngine.LANGUAGE
   ScriptEngine.LANGUAGE_VERSION
   ScriptEngine.NAME


   The values for these keys are the Strings returned by getEngineName,
   getEngineVersion, getLanguageName,
   getLanguageVersion for the first four keys respectively. For NAME, one of the Strings
   returned by getNames is returned.
   A reserved key, THREADING, whose value describes the behavior of the engine
   with respect to concurrent execution of scripts and maintenance of state is also defined.
   These values for the THREADING key are:

   null - The engine implementation is not thread safe, and cannot
   be used to execute scripts concurrently on multiple threads.
   `MULTITHREADED` - The engine implementation is internally
   thread-safe and scripts may execute concurrently although effects of script execution
   on one thread may be visible to scripts on other threads.
   `THREAD-ISOLATED` - The implementation satisfies the requirements
   of `MULTITHREADED`, and also, the engine maintains independent values
   for symbols in scripts executing on different threads.
   `STATELESS` - The implementation satisfies the requirements of
   `THREAD-ISOLATED`.  In addition, script executions do not alter the
   mappings in the Bindings which is the engine scope of the
   ScriptEngine.  In particular, the keys in the Bindings
   and their associated values are the same before and after the execution of the script.


   Implementations may define implementation-specific keys.

  key - The name of the parameter - `java.lang.String`

  returns: The value for the given parameter. Returns null if no
   value is assigned to the key. - `java.lang.Object`"
  ([^. this ^java.lang.String key]
    (-> this (.getParameter key))))

(defn get-mime-types
  "Returns an immutable list of mimetypes, associated with scripts that
   can be executed by the engine.  The list is used by the
   ScriptEngineManager class to implement its
   getEngineByMimetype method.

  returns: The list of mime types. - `java.util.List<java.lang.String>`"
  ([^. this]
    (-> this (.getMimeTypes))))

(defn get-method-call-syntax
  "Returns a String which can be used to invoke a method of a  Java object using the syntax
   of the supported scripting language.  For instance, an implementation for a Javascript
   engine might be;



   public String getMethodCallSyntax(String obj,
                                     String m, String... args) {
        String ret = obj;
        ret = `.`  m  `(`;
        for (int i = 0; i < args.length; i++) {
            ret = args[i];
            if (i < args.length - 1) {
                ret = `,`;
            }
        }
        ret = `)`;
        return ret;
   }

  obj - The name representing the object whose method is to be invoked. The name is the one used to create bindings using the put method of ScriptEngine, the put method of an ENGINE_SCOPE Bindings,or the setAttribute method of ScriptContext. The identifier used in scripts may be a decorated form of the specified one. - `java.lang.String`
  m - The name of the method to invoke. - `java.lang.String`
  args - names of the arguments in the method call. - `java.lang.String`

  returns: The String used to invoke the method in the syntax of the scripting language. - `java.lang.String`"
  ([^. this ^java.lang.String obj ^java.lang.String m ^java.lang.String args]
    (-> this (.getMethodCallSyntax obj m args))))

(defn get-language-name
  "Returns the name of the scripting language supported by this
   ScriptEngine.

  returns: The name of the supported language. - `java.lang.String`"
  ([^. this]
    (-> this (.getLanguageName))))

(defn get-script-engine
  "Returns an instance of the ScriptEngine associated with this
   ScriptEngineFactory. A new ScriptEngine is generally
   returned, but implementations may pool, share or reuse engines.

  returns: A new ScriptEngine instance. - `javax.script.ScriptEngine`"
  ([^. this]
    (-> this (.getScriptEngine))))

(defn get-engine-name
  "Returns the full  name of the ScriptEngine.  For
   instance an implementation based on the Mozilla Rhino Javascript engine
   might return Rhino Mozilla Javascript Engine.

  returns: The name of the engine implementation. - `java.lang.String`"
  ([^. this]
    (-> this (.getEngineName))))

(defn get-names
  "Returns an immutable list of  short names for the ScriptEngine, which may be used to
   identify the ScriptEngine by the ScriptEngineManager.
   For instance, an implementation based on the Mozilla Rhino Javascript engine might
   return list containing {`javascript`, `rhino`}.

  returns: an immutable list of short names - `java.util.List<java.lang.String>`"
  ([^. this]
    (-> this (.getNames))))

