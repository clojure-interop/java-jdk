(ns javax.script.SimpleScriptContext
  "Simple implementation of ScriptContext."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script SimpleScriptContext]))

(defn ->simple-script-context
  "Constructor.

  Create a SimpleScriptContext."
  ([]
    (new SimpleScriptContext )))

(defn get-scopes
  "Returns immutable List of all the valid values for
   scope in the ScriptContext.

  returns: list of scope values - `java.util.List<java.lang.Integer>`"
  (^java.util.List [^javax.script.SimpleScriptContext this]
    (-> this (.getScopes))))

(defn set-reader
  "Sets the Reader for scripts to read input
   .

  reader - The new Reader. - `java.io.Reader`"
  ([^javax.script.SimpleScriptContext this ^java.io.Reader reader]
    (-> this (.setReader reader))))

(defn get-writer
  "Returns the Writer for scripts to use when displaying output.

  returns: The Writer. - `java.io.Writer`"
  (^java.io.Writer [^javax.script.SimpleScriptContext this]
    (-> this (.getWriter))))

(defn get-error-writer
  "Returns the Writer used to display error output.

  returns: The Writer - `java.io.Writer`"
  (^java.io.Writer [^javax.script.SimpleScriptContext this]
    (-> this (.getErrorWriter))))

(defn get-attribute
  "Gets the value of an attribute in a given scope.

  name - The name of the attribute to retrieve. - `java.lang.String`
  scope - The scope in which to retrieve the attribute. - `int`

  returns: The value of the attribute. Returns null is the name
   does not exist in the given scope. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the name is empty or if the value of scope is invalid."
  (^java.lang.Object [^javax.script.SimpleScriptContext this ^java.lang.String name ^Integer scope]
    (-> this (.getAttribute name scope)))
  (^java.lang.Object [^javax.script.SimpleScriptContext this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn get-reader
  "Returns a Reader to be used by the script to read
   input.

  returns: The Reader. - `java.io.Reader`"
  (^java.io.Reader [^javax.script.SimpleScriptContext this]
    (-> this (.getReader))))

(defn remove-attribute
  "Remove an attribute in a given scope.

  name - The name of the attribute to remove - `java.lang.String`
  scope - The scope in which to remove the attribute - `int`

  returns: The removed value. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the name is empty or if the scope is invalid."
  (^java.lang.Object [^javax.script.SimpleScriptContext this ^java.lang.String name ^Integer scope]
    (-> this (.removeAttribute name scope))))

(defn set-attribute
  "Sets the value of an attribute in a given scope.

  name - The name of the attribute to set - `java.lang.String`
  value - The value of the attribute - `java.lang.Object`
  scope - The scope in which to set the attribute - `int`

  throws: java.lang.IllegalArgumentException - if the name is empty or if the scope is invalid."
  ([^javax.script.SimpleScriptContext this ^java.lang.String name ^java.lang.Object value ^Integer scope]
    (-> this (.setAttribute name value scope))))

(defn set-writer
  "Sets the Writer for scripts to use when displaying output.

  writer - The new Writer. - `java.io.Writer`"
  ([^javax.script.SimpleScriptContext this ^java.io.Writer writer]
    (-> this (.setWriter writer))))

(defn set-error-writer
  "Sets the Writer used to display error output.

  writer - The Writer. - `java.io.Writer`"
  ([^javax.script.SimpleScriptContext this ^java.io.Writer writer]
    (-> this (.setErrorWriter writer))))

(defn get-bindings
  "Returns the value of the engineScope field if specified scope is
   ENGINE_SCOPE.  Returns the value of the globalScope field if the specified scope is
   GLOBAL_SCOPE.

  scope - The specified scope - `int`

  returns: The value of either the  engineScope or globalScope field. - `javax.script.Bindings`

  throws: java.lang.IllegalArgumentException - if the value of scope is invalid."
  (^javax.script.Bindings [^javax.script.SimpleScriptContext this ^Integer scope]
    (-> this (.getBindings scope))))

(defn get-attributes-scope
  "Get the lowest scope in which an attribute is defined.

  name - Name of the attribute . - `java.lang.String`

  returns: The lowest scope.  Returns -1 if no attribute with the given
   name is defined in any scope. - `int`

  throws: java.lang.NullPointerException - if name is null."
  (^Integer [^javax.script.SimpleScriptContext this ^java.lang.String name]
    (-> this (.getAttributesScope name))))

(defn set-bindings
  "Sets a Bindings of attributes for the given scope.  If the value
   of scope is ENGINE_SCOPE the given Bindings replaces the
   engineScope field.  If the value
   of scope is GLOBAL_SCOPE the given Bindings replaces the
   globalScope field.

  bindings - The Bindings of attributes to set. - `javax.script.Bindings`
  scope - The value of the scope in which the attributes are set. - `int`

  throws: java.lang.IllegalArgumentException - if scope is invalid."
  ([^javax.script.SimpleScriptContext this ^javax.script.Bindings bindings ^Integer scope]
    (-> this (.setBindings bindings scope))))

