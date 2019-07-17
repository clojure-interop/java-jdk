(ns javax.naming.directory.InitialDirContext
  "This class is the starting context for performing
  directory operations. The documentation in the class description
  of InitialContext (including those for synchronization) apply here."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory InitialDirContext]))

(defn ->initial-dir-context
  "Constructor.

  Constructs an initial DirContext using the supplied environment.
   Environment properties are discussed in the
   javax.naming.InitialContext class description.

    This constructor will not modify environment
   or save a reference to it, but may save a clone.
   Caller should not modify mutable keys and values in
   environment after it has been passed to the constructor.

  environment - environment used to create the initial DirContext. Null indicates an empty environment. - `java.util.Hashtable<?,?>`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([environment]
    (new InitialDirContext environment))
  ([]
    (new InitialDirContext )))

(defn get-attributes
  "Description copied from interface: DirContext

  name - The name of the object from which to retrieve attributes - `java.lang.String`
  attr-ids - the identifiers of the attributes to retrieve. null indicates that all attributes should be retrieved; an empty array indicates that none should be retrieved. - `java.lang.String[]`

  returns: the requested attributes; never null - `javax.naming.directory.Attributes`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  ([this name attr-ids]
    (-> this (.getAttributes name attr-ids)))
  ([this name]
    (-> this (.getAttributes name))))

(defn modify-attributes
  "Description copied from interface: DirContext

  name - the name of the object whose attributes will be updated - `java.lang.String`
  mod-op - the modification operation, one of: ADD_ATTRIBUTE, REPLACE_ATTRIBUTE, REMOVE_ATTRIBUTE. - `int`
  attrs - the attributes to be used for the modification; may not be null - `javax.naming.directory.Attributes`

  throws: javax.naming.directory.AttributeModificationException - if the modification cannot be completed successfully"
  ([this name mod-op attrs]
    (-> this (.modifyAttributes name mod-op attrs)))
  ([this name mods]
    (-> this (.modifyAttributes name mods))))

(defn bind
  "Description copied from interface: DirContext

  name - the name to bind; may not be empty - `java.lang.String`
  obj - the object to bind; possibly null - `java.lang.Object`
  attrs - the attributes to associate with the binding - `javax.naming.directory.Attributes`

  throws: javax.naming.NameAlreadyBoundException - if name is already bound"
  ([this name obj attrs]
    (-> this (.bind name obj attrs))))

(defn rebind
  "Description copied from interface: DirContext

  name - the name to bind; may not be empty - `java.lang.String`
  obj - the object to bind; possibly null - `java.lang.Object`
  attrs - the attributes to associate with the binding - `javax.naming.directory.Attributes`

  throws: javax.naming.directory.InvalidAttributesException - if some `mandatory` attributes of the binding are not supplied"
  ([this name obj attrs]
    (-> this (.rebind name obj attrs))))

(defn create-subcontext
  "Description copied from interface: DirContext

  name - the name of the context to create; may not be empty - `java.lang.String`
  attrs - the attributes to associate with the newly created context - `javax.naming.directory.Attributes`

  returns: the newly created context - `javax.naming.directory.DirContext`

  throws: javax.naming.NameAlreadyBoundException - if the name is already bound"
  ([this name attrs]
    (-> this (.createSubcontext name attrs))))

(defn get-schema
  "Description copied from interface: DirContext

  name - the name of the object whose schema is to be retrieved - `java.lang.String`

  returns: the schema associated with the context; never null - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - if schema not supported"
  ([this name]
    (-> this (.getSchema name))))

(defn get-schema-class-definition
  "Description copied from interface: DirContext

  name - the name of the object whose object class definition is to be retrieved - `java.lang.String`

  returns: the DirContext containing the named
            object's class definitions; never null - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - if schema not supported"
  ([this name]
    (-> this (.getSchemaClassDefinition name))))

(defn search
  "Description copied from interface: DirContext

  name - the name of the context or object to search - `java.lang.String`
  filter-expr - the filter expression to use for the search. The expression may contain variables of the form `{i}` where i is a nonnegative integer. May not be null. - `java.lang.String`
  filter-args - the array of arguments to substitute for the variables in filterExpr. The value of filterArgs[i] will replace each occurrence of `{i}`. If null, equivalent to an empty array. - `java.lang.Object[]`
  cons - the search controls that control the search. If null, the default search controls are used (equivalent to (new SearchControls())). - `javax.naming.directory.SearchControls`

  returns: an enumeration of SearchResults of the objects
            that satisfy the filter; never null - `javax.naming.NamingEnumeration<javax.naming.directory.SearchResult>`

  throws: javax.naming.directory.InvalidSearchControlsException - if cons contains invalid settings"
  ([this name filter-expr filter-args cons]
    (-> this (.search name filter-expr filter-args cons)))
  ([this name matching-attributes attributes-to-return]
    (-> this (.search name matching-attributes attributes-to-return)))
  ([this name matching-attributes]
    (-> this (.search name matching-attributes))))

