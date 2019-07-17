(ns javax.script.ScriptEngineManager
  "The ScriptEngineManager implements a discovery and instantiation
  mechanism for ScriptEngine classes and also maintains a
  collection of key/value pairs storing state shared by all engines created
  by the Manager. This class uses the service provider mechanism to enumerate all the
  implementations of ScriptEngineFactory.
  The ScriptEngineManager provides a method to return a list of all these factories
  as well as utility methods which look up factories on the basis of language name, file extension
  and mime type.

  The Bindings of key/value pairs, referred to as the `Global Scope`  maintained
  by the manager is available to all instances of ScriptEngine created
  by the ScriptEngineManager.  The values in the Bindings are
  generally exposed in all scripts."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.script ScriptEngineManager]))

(defn ->script-engine-manager
  "Constructor.

  This constructor loads the implementations of
   ScriptEngineFactory visible to the given
   ClassLoader using the service provider mechanism.
   If loader is null, the script engine factories that are
   bundled with the platform and that are in the usual extension
   directories (installed extensions) are loaded.

  loader - ClassLoader used to discover script engine factories. - `java.lang.ClassLoader`"
  ([loader]
    (new ScriptEngineManager loader))
  ([]
    (new ScriptEngineManager )))

(defn put
  "Sets the specified key/value pair in the Global Scope.

  key - Key to set - `java.lang.String`
  value - Value to set. - `java.lang.Object`

  throws: java.lang.NullPointerException - if key is null."
  ([this key value]
    (-> this (.put key value))))

(defn register-engine-extension
  "Registers a ScriptEngineFactory to handle an extension.
   Overrides any such association found using the Discovery mechanism.

  extension - The extension type to be associated with the ScriptEngineFactory. - `java.lang.String`
  factory - The class to associate with the given extension. - `javax.script.ScriptEngineFactory`

  throws: java.lang.NullPointerException - if any of the parameters is null."
  ([this extension factory]
    (-> this (.registerEngineExtension extension factory))))

(defn get-engine-by-extension
  "Look up and create a ScriptEngine for a given extension.  The algorithm
   used by getEngineByName is used except that the search starts
   by looking for a ScriptEngineFactory registered to handle the
   given extension using registerEngineExtension.

  extension - The given extension - `java.lang.String`

  returns: The engine to handle scripts with this extension.  Returns null
   if not found. - `javax.script.ScriptEngine`

  throws: java.lang.NullPointerException - if extension is null."
  ([this extension]
    (-> this (.getEngineByExtension extension))))

(defn register-engine-name
  "Registers a ScriptEngineFactory to handle a language
   name.  Overrides any such association found using the Discovery mechanism.

  name - The name to be associated with the ScriptEngineFactory. - `java.lang.String`
  factory - The class to associate with the given name. - `javax.script.ScriptEngineFactory`

  throws: java.lang.NullPointerException - if any of the parameters is null."
  ([this name factory]
    (-> this (.registerEngineName name factory))))

(defn register-engine-mime-type
  "Registers a ScriptEngineFactory to handle a mime type.
   Overrides any such association found using the Discovery mechanism.

  type - The mime type to be associated with the ScriptEngineFactory. - `java.lang.String`
  factory - The class to associate with the given mime type. - `javax.script.ScriptEngineFactory`

  throws: java.lang.NullPointerException - if any of the parameters is null."
  ([this type factory]
    (-> this (.registerEngineMimeType type factory))))

(defn get-engine-factories
  "Returns a list whose elements are instances of all the ScriptEngineFactory classes
   found by the discovery mechanism.

  returns: List of all discovered ScriptEngineFactorys. - `java.util.List<javax.script.ScriptEngineFactory>`"
  ([this]
    (-> this (.getEngineFactories))))

(defn get-engine-by-mime-type
  "Look up and create a ScriptEngine for a given mime type.  The algorithm
   used by getEngineByName is used except that the search starts
   by looking for a ScriptEngineFactory registered to handle the
   given mime type using registerEngineMimeType.

  mime-type - The given mime type - `java.lang.String`

  returns: The engine to handle scripts with this mime type.  Returns null
   if not found. - `javax.script.ScriptEngine`

  throws: java.lang.NullPointerException - if mimeType is null."
  ([this mime-type]
    (-> this (.getEngineByMimeType mime-type))))

(defn get-engine-by-name
  "Looks up and creates a ScriptEngine for a given  name.
   The algorithm first searches for a ScriptEngineFactory that has been
   registered as a handler for the specified name using the registerEngineName
   method.
    If one is not found, it searches the set of ScriptEngineFactory instances
   stored by the constructor for one with the specified name.  If a ScriptEngineFactory
   is found by either method, it is used to create instance of ScriptEngine.

  short-name - The short name of the ScriptEngine implementation. returned by the getNames method of its ScriptEngineFactory. - `java.lang.String`

  returns: A ScriptEngine created by the factory located in the search.  Returns null
   if no such factory was found.  The ScriptEngineManager sets its own globalScope
   Bindings as the GLOBAL_SCOPE Bindings of the newly
   created ScriptEngine. - `javax.script.ScriptEngine`

  throws: java.lang.NullPointerException - if shortName is null."
  ([this short-name]
    (-> this (.getEngineByName short-name))))

(defn get-bindings
  "getBindings returns the value of the globalScope field.
   ScriptEngineManager sets this Bindings as global bindings for
   ScriptEngine objects created by it.

  returns: The globalScope field. - `javax.script.Bindings`"
  ([this]
    (-> this (.getBindings))))

(defn get
  "Gets the value for the specified key in the Global Scope

  key - The key whose value is to be returned. - `java.lang.String`

  returns: The value for the specified key. - `java.lang.Object`"
  ([this key]
    (-> this (.get key))))

(defn set-bindings
  "setBindings stores the specified Bindings
   in the globalScope field. ScriptEngineManager sets this
   Bindings as global bindings for ScriptEngine
   objects created by it.

  bindings - The specified Bindings - `javax.script.Bindings`

  throws: java.lang.IllegalArgumentException - if bindings is null."
  ([this bindings]
    (-> this (.setBindings bindings))))

