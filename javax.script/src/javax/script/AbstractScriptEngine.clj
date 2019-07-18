(ns javax.script.AbstractScriptEngine
  "Provides a standard implementation for several of the variants of the eval
  method.

  eval(Reader)eval(String)
  eval(String, Bindings)eval(Reader, Bindings)
   are implemented using the abstract methods

  eval(Reader,ScriptContext) or
  eval(String, ScriptContext)

  with a SimpleScriptContext.

  A SimpleScriptContext is used as the default ScriptContext
  of the AbstractScriptEngine.."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script AbstractScriptEngine]))

(defn ->abstract-script-engine
  "Constructor.

  Creates a new instance using the specified Bindings as the
   ENGINE_SCOPE Bindings in the protected context field.

  n - The specified Bindings. - `javax.script.Bindings`

  throws: java.lang.NullPointerException - if n is null."
  (^AbstractScriptEngine [^javax.script.Bindings n]
    (new AbstractScriptEngine n))
  (^AbstractScriptEngine []
    (new AbstractScriptEngine )))

(defn set-context
  "Sets the value of the protected context field to the specified
   ScriptContext.

  ctxt - The specified ScriptContext. - `javax.script.ScriptContext`

  throws: java.lang.NullPointerException - if ctxt is null."
  ([^AbstractScriptEngine this ^javax.script.ScriptContext ctxt]
    (-> this (.setContext ctxt))))

(defn get-context
  "Returns the value of the protected context field.

  returns: The value of the protected context field. - `javax.script.ScriptContext`"
  (^javax.script.ScriptContext [^AbstractScriptEngine this]
    (-> this (.getContext))))

(defn get-bindings
  "Returns the Bindings with the specified scope value in
   the protected context field.

  scope - The specified scope - `int`

  returns: The corresponding Bindings. - `javax.script.Bindings`

  throws: java.lang.IllegalArgumentException - if the value of scope is invalid for the type the protected context field."
  (^javax.script.Bindings [^AbstractScriptEngine this ^Integer scope]
    (-> this (.getBindings scope))))

(defn set-bindings
  "Sets the Bindings with the corresponding scope value in the
   context field.

  bindings - The specified Bindings. - `javax.script.Bindings`
  scope - The specified scope. - `int`

  throws: java.lang.IllegalArgumentException - if the value of scope is invalid for the type the context field."
  ([^AbstractScriptEngine this ^javax.script.Bindings bindings ^Integer scope]
    (-> this (.setBindings bindings scope))))

(defn put
  "Sets the specified value with the specified key in the ENGINE_SCOPE
   Bindings of the protected context field.

  key - The specified key. - `java.lang.String`
  value - The specified value. - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null."
  ([^AbstractScriptEngine this ^java.lang.String key ^java.lang.Object value]
    (-> this (.put key value))))

(defn get
  "Gets the value for the specified key in the ENGINE_SCOPE of the
   protected context field.

  key - The key whose value is to be returned - `java.lang.String`

  returns: The value for the specified key. - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null."
  (^java.lang.Object [^AbstractScriptEngine this ^java.lang.String key]
    (-> this (.get key))))

(defn eval
  "eval(Reader, Bindings) calls the abstract
   eval(Reader, ScriptContext) method, passing it a ScriptContext
   whose Reader, Writers and Bindings for scopes other that ENGINE_SCOPE
   are identical to those members of the protected context field.  The specified
   Bindings is used instead of the ENGINE_SCOPE

   Bindings of the context field.

  reader - A Reader containing the source of the script. - `java.io.Reader`
  bindings - A Bindings to use for the ENGINE_SCOPE while the script executes. - `javax.script.Bindings`

  returns: The return value from eval(Reader, ScriptContext) - `java.lang.Object`

  throws: javax.script.ScriptException - if an error occurs in script."
  (^java.lang.Object [^AbstractScriptEngine this ^java.io.Reader reader ^javax.script.Bindings bindings]
    (-> this (.eval reader bindings)))
  (^java.lang.Object [^AbstractScriptEngine this ^java.io.Reader reader]
    (-> this (.eval reader))))

