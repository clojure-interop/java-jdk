(ns javax.script.Compilable
  "The optional interface implemented by ScriptEngines whose methods compile scripts
  to a form that can be executed repeatedly without recompilation."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script Compilable]))

(defn compile
  "Compiles the script (source represented as a String) for
   later execution.

  script - The source of the script, represented as a String. - `java.lang.String`

  returns: An instance of a subclass of CompiledScript to be executed later using one
   of the eval methods of CompiledScript. - `javax.script.CompiledScript`

  throws: javax.script.ScriptException - if compilation fails."
  ([this script]
    (-> this (.compile script))))

