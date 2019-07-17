(ns javax.script.CompiledScript
  "Extended by classes that store results of compilations.  State
  might be stored in the form of Java classes, Java class files or scripting
  language opcodes.  The script may be executed repeatedly
  without reparsing.

  Each CompiledScript is associated with a ScriptEngine -- A call to an  eval
  method of the CompiledScript causes the execution of the script by the
  ScriptEngine.  Changes in the state of the ScriptEngine caused by execution
  of the CompiledScript  may visible during subsequent executions of scripts by the engine."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script CompiledScript]))

(defn ->compiled-script
  "Constructor."
  ([]
    (new CompiledScript )))

(defn eval
  "Executes the program stored in this CompiledScript object.

  context - A ScriptContext that is used in the same way as the ScriptContext passed to the eval methods of ScriptEngine. - `javax.script.ScriptContext`

  returns: The value returned by the script execution, if any.  Should return null
   if no value is returned by the script execution. - `java.lang.Object`

  throws: javax.script.ScriptException - if an error occurs."
  (^java.lang.Object [^javax.script.CompiledScript this ^javax.script.ScriptContext context]
    (-> this (.eval context)))
  (^java.lang.Object [^javax.script.CompiledScript this]
    (-> this (.eval))))

(defn get-engine
  "Returns the ScriptEngine whose compile method created this CompiledScript.
   The CompiledScript will execute in this engine.

  returns: The ScriptEngine that created this CompiledScript - `javax.script.ScriptEngine`"
  (^javax.script.ScriptEngine [^javax.script.CompiledScript this]
    (-> this (.getEngine))))

