(ns javax.script.ScriptContext
  "The interface whose implementing classes are used to connect Script Engines
  with objects, such as scoped Bindings, in hosting applications.  Each scope is a set
  of named attributes whose values can be set and retrieved using the
  ScriptContext methods. ScriptContexts also expose Readers and Writers
  that can be used by the ScriptEngines for input and output."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script ScriptContext]))

(defn get-scopes
  "Returns immutable List of all the valid values for
   scope in the ScriptContext.

  returns: list of scope values - `java.util.List<java.lang.Integer>`"
  ([^. this]
    (-> this (.getScopes))))

(defn set-reader
  "Sets the Reader for scripts to read input
   .

  reader - The new Reader. - `java.io.Reader`"
  ([^. this ^java.io.Reader reader]
    (-> this (.setReader reader))))

(defn get-writer
  "Returns the Writer for scripts to use when displaying output.

  returns: The Writer. - `java.io.Writer`"
  ([^. this]
    (-> this (.getWriter))))

(defn get-error-writer
  "Returns the Writer used to display error output.

  returns: The Writer - `java.io.Writer`"
  ([^. this]
    (-> this (.getErrorWriter))))

(defn get-attribute
  "Gets the value of an attribute in a given scope.

  name - The name of the attribute to retrieve. - `java.lang.String`
  scope - The scope in which to retrieve the attribute. - `int`

  returns: The value of the attribute. Returns null is the name
   does not exist in the given scope. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the name is empty or if the value of scope is invalid."
  ([^. this ^java.lang.String name ^Integer scope]
    (-> this (.getAttribute name scope)))
  ([^. this ^java.lang.String name]
    (-> this (.getAttribute name))))

(defn get-reader
  "Returns a Reader to be used by the script to read
   input.

  returns: The Reader. - `java.io.Reader`"
  ([^. this]
    (-> this (.getReader))))

(defn remove-attribute
  "Remove an attribute in a given scope.

  name - The name of the attribute to remove - `java.lang.String`
  scope - The scope in which to remove the attribute - `int`

  returns: The removed value. - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the name is empty or if the scope is invalid."
  ([^. this ^java.lang.String name ^Integer scope]
    (-> this (.removeAttribute name scope))))

(defn set-attribute
  "Sets the value of an attribute in a given scope.

  name - The name of the attribute to set - `java.lang.String`
  value - The value of the attribute - `java.lang.Object`
  scope - The scope in which to set the attribute - `int`

  throws: java.lang.IllegalArgumentException - if the name is empty or if the scope is invalid."
  ([^. this ^java.lang.String name ^java.lang.Object value ^Integer scope]
    (-> this (.setAttribute name value scope))))

(defn set-writer
  "Sets the Writer for scripts to use when displaying output.

  writer - The new Writer. - `java.io.Writer`"
  ([^. this ^java.io.Writer writer]
    (-> this (.setWriter writer))))

(defn set-error-writer
  "Sets the Writer used to display error output.

  writer - The Writer. - `java.io.Writer`"
  ([^. this ^java.io.Writer writer]
    (-> this (.setErrorWriter writer))))

(defn get-bindings
  "Gets the Bindings  associated with the given scope in this
   ScriptContext.

  scope - The scope - `int`

  returns: The associated Bindings.  Returns null if it has not
   been set. - `javax.script.Bindings`

  throws: java.lang.IllegalArgumentException - If no Bindings is defined for the specified scope value in ScriptContext of this type."
  ([^. this ^Integer scope]
    (-> this (.getBindings scope))))

(defn get-attributes-scope
  "Get the lowest scope in which an attribute is defined.

  name - Name of the attribute . - `java.lang.String`

  returns: The lowest scope.  Returns -1 if no attribute with the given
   name is defined in any scope. - `int`

  throws: java.lang.NullPointerException - if name is null."
  ([^. this ^java.lang.String name]
    (-> this (.getAttributesScope name))))

(defn set-bindings
  "Associates a Bindings instance with a particular scope in this
   ScriptContext.  Calls to the getAttribute and
   setAttribute methods must map to the get and
   put methods of the Bindings for the specified scope.

  bindings - The Bindings to associate with the given scope - `javax.script.Bindings`
  scope - The scope - `int`

  throws: java.lang.IllegalArgumentException - If no Bindings is defined for the specified scope value in ScriptContexts of this type."
  ([^. this ^javax.script.Bindings bindings ^Integer scope]
    (-> this (.setBindings bindings scope))))

