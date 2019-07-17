(ns javax.script.ScriptEngine
  "ScriptEngine is the fundamental interface whose methods must be
  fully functional in every implementation of this specification.

  These methods provide basic scripting functionality.  Applications written to this
  simple interface are expected to work with minimal modifications in every implementation.
  It includes methods that execute scripts, and ones that set and get values.

  The values are key/value pairs of two types.  The first type of pairs consists of
  those whose keys are reserved and defined in this specification or  by individual
  implementations.  The values in the pairs with reserved keys have specified meanings.

  The other type of pairs consists of those that create Java language Bindings, the values are
  usually represented in scripts by the corresponding keys or by decorated forms of them."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script ScriptEngine]))

(defn create-bindings
  "Returns an uninitialized Bindings.

  returns: A Bindings that can be used to replace the state of this ScriptEngine. - `javax.script.Bindings`"
  ([^. this]
    (-> this (.createBindings))))

(defn put
  "Sets a key/value pair in the state of the ScriptEngine that may either create
   a Java Language Binding to be used in the execution of scripts or be used in some
   other way, depending on whether the key is reserved.  Must have the same effect as
   getBindings(ScriptContext.ENGINE_SCOPE).put.

  key - The name of named value to add - `java.lang.String`
  value - The value of named value to add. - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null."
  ([^. this ^java.lang.String key ^java.lang.Object value]
    (-> this (.put key value))))

(defn set-context
  "Sets the default ScriptContext of the ScriptEngine whose Bindings, Reader
   and Writers are used for script executions when no ScriptContext is specified.

  context - A ScriptContext that will replace the default ScriptContext in the ScriptEngine. - `javax.script.ScriptContext`

  throws: java.lang.NullPointerException - if context is null."
  ([^. this ^javax.script.ScriptContext context]
    (-> this (.setContext context))))

(defn eval
  "Causes the immediate execution of the script whose source is the String
   passed as the first argument.  The script may be reparsed or recompiled before
   execution.  State left in the engine from previous executions, including
   variable values and compiled procedures may be visible during this execution.

  script - The script to be executed by the script engine. - `java.lang.String`
  context - A ScriptContext exposing sets of attributes in different scopes. The meanings of the scopes ScriptContext.GLOBAL_SCOPE, and ScriptContext.ENGINE_SCOPE are defined in the specification. The ENGINE_SCOPE Bindings of the ScriptContext contains the bindings of scripting variables to application objects to be used during this script execution. - `javax.script.ScriptContext`

  returns: The value returned from the execution of the script. - `java.lang.Object`

  throws: javax.script.ScriptException - if an error occurs in script. ScriptEngines should create and throw ScriptException wrappers for checked Exceptions thrown by underlying scripting implementations."
  ([^. this ^java.lang.String script ^javax.script.ScriptContext context]
    (-> this (.eval script context)))
  ([^. this ^java.lang.String script]
    (-> this (.eval script))))

(defn get-factory
  "Returns a ScriptEngineFactory for the class to which this ScriptEngine belongs.

  returns: The ScriptEngineFactory - `javax.script.ScriptEngineFactory`"
  ([^. this]
    (-> this (.getFactory))))

(defn get-context
  "Returns the default ScriptContext of the ScriptEngine whose Bindings, Reader
   and Writers are used for script executions when no ScriptContext is specified.

  returns: The default ScriptContext of the ScriptEngine. - `javax.script.ScriptContext`"
  ([^. this]
    (-> this (.getContext))))

(defn get-bindings
  "Returns a scope of named values.  The possible scopes are:


   ScriptContext.GLOBAL_SCOPE - The set of named values representing global
   scope. If this ScriptEngine is created by a ScriptEngineManager,
   then the manager sets global scope bindings. This may be null if no global
   scope is associated with this ScriptEngine
   ScriptContext.ENGINE_SCOPE - The set of named values representing the state of
   this ScriptEngine.  The values are generally visible in scripts using
   the associated keys as variable names.
   Any other value of scope defined in the default ScriptContext of the ScriptEngine.



   The Bindings instances that are returned must be identical to those returned by the
   getBindings method of ScriptContext called with corresponding arguments on
   the default ScriptContext of the ScriptEngine.

  scope - Either ScriptContext.ENGINE_SCOPE or ScriptContext.GLOBAL_SCOPE which specifies the Bindings to return. Implementations of ScriptContext may define additional scopes. If the default ScriptContext of the ScriptEngine defines additional scopes, any of them can be passed to get the corresponding Bindings. - `int`

  returns: The Bindings with the specified scope. - `javax.script.Bindings`

  throws: java.lang.IllegalArgumentException - if specified scope is invalid"
  ([^. this ^Integer scope]
    (-> this (.getBindings scope))))

(defn get
  "Retrieves a value set in the state of this engine.  The value might be one
   which was set using setValue or some other value in the state
   of the ScriptEngine, depending on the implementation.  Must have the same effect
   as getBindings(ScriptContext.ENGINE_SCOPE).get

  key - The key whose value is to be returned - `java.lang.String`

  returns: the value for the given key - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null."
  ([^. this ^java.lang.String key]
    (-> this (.get key))))

(defn set-bindings
  "Sets a scope of named values to be used by scripts.  The possible scopes are:


   ScriptContext.ENGINE_SCOPE - The specified Bindings replaces the
   engine scope of the ScriptEngine.

   ScriptContext.GLOBAL_SCOPE - The specified Bindings must be visible
   as the GLOBAL_SCOPE.

   Any other value of scope defined in the default ScriptContext of the ScriptEngine.



   The method must have the same effect as calling the setBindings method of
   ScriptContext with the corresponding value of scope on the default
   ScriptContext of the ScriptEngine.

  bindings - The Bindings for the specified scope. - `javax.script.Bindings`
  scope - The specified scope. Either ScriptContext.ENGINE_SCOPE, ScriptContext.GLOBAL_SCOPE, or any other valid value of scope. - `int`

  throws: java.lang.IllegalArgumentException - if the scope is invalid"
  ([^. this ^javax.script.Bindings bindings ^Integer scope]
    (-> this (.setBindings bindings scope))))

