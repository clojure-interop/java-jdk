(ns javax.naming.directory.DirContext
  "The directory service interface, containing
  methods for examining and updating attributes
  associated with objects, and for searching the directory.

  Names
  Each name passed as an argument to a DirContext method is relative
  to that context.  The empty name is used to name the context itself.
  The name parameter may never be null.

  Most of the methods have overloaded versions with one taking a
  Name parameter and one taking a String.
  These overloaded versions are equivalent in that if
  the Name and String parameters are just
  different representations of the same name, then the overloaded
  versions of the same methods behave the same.
  In the method descriptions below, only one version is documented.
  The second version instead has a link to the first:  the same
  documentation applies to both.

  See Context for a discussion on the interpretation of the
  name argument to the Context methods. These same rules
  apply to the name argument to the DirContext methods.

  Attribute Models
  There are two basic models of what attributes should be
  associated with.  First, attributes may be directly associated with a
  DirContext object.
  In this model, an attribute operation on the named object is
  roughly equivalent
  to a lookup on the name (which returns the DirContext object),
  followed by the attribute operation invoked on the DirContext object
  in which the caller supplies an empty name. The attributes can be viewed
  as being stored along with the object (note that this does not imply that
  the implementation must do so).

  The second model is that attributes are associated with a
  name (typically an atomic name) in a DirContext.
  In this model, an attribute operation on the named object is
  roughly equivalent to a lookup on the name of the parent DirContext of the
  named object, followed by the attribute operation invoked on the parent
  in which the caller supplies the terminal atomic name.
  The attributes can be viewed as being stored in the parent DirContext
  (again, this does not imply that the implementation must do so).
  Objects that are not DirContexts can have attributes, as long as
  their parents are DirContexts.

  JNDI support both of these models.
  It is up to the individual service providers to decide where to
  \"store\" attributes.
  JNDI clients are safest when they do not make assumptions about
  whether an object's attributes are stored as part of the object, or stored
  within the parent object and associated with the object's name.

  Attribute Type Names
  In the getAttributes() and search() methods,
  you can supply the attributes to return by supplying a list of
  attribute names (strings).
  The attributes that you get back might not have the same names as the
  attribute names you have specified. This is because some directories
  support features that cause them to return other attributes.  Such
  features include attribute subclassing, attribute name synonyms, and
  attribute language codes.

  In attribute subclassing, attributes are defined in a class hierarchy.
  In some directories, for example, the \"name\" attribute might be the
  superclass of all name-related attributes, including \"commonName\" and
  \"surName\".  Asking for the \"name\" attribute might return both the
  \"commonName\" and \"surName\" attributes.

  With attribute type synonyms, a directory can assign multiple names to
  the same attribute. For example, \"cn\" and \"commonName\" might both
  refer to the same attribute. Asking for \"cn\" might return the
  \"commonName\" attribute.

  Some directories support the language codes for attributes.
  Asking such a directory for the \"description\" attribute, for example,
  might return all of the following attributes:

  description
  description;lang-en
  description;lang-de
  description;lang-fr



 Operational Attributes

  Some directories have the notion of \"operational attributes\" which are
  attributes associated with a directory object for administrative
  purposes. An example of operational attributes is the access control
  list for an object.

  In the getAttributes() and search() methods,
  you can specify that all attributes associated with the requested objects
  be returned by supply null as the list of attributes to return.
  The attributes returned do not include operational attributes.
  In order to retrieve operational attributes, you must name them explicitly.


  Named Context

  There are certain methods in which the name must resolve to a context
  (for example, when searching a single level context). The documentation
  of such methods
  use the term named context to describe their name parameter.
  For these methods, if the named object is not a DirContext,
  NotContextException is thrown.
  Aside from these methods, there is no requirement that the
  named object be a DirContext.

 Parameters

  An Attributes, SearchControls, or array object
  passed as a parameter to any method will not be modified by the
  service provider.  The service provider may keep a reference to it
  for the duration of the operation, including any enumeration of the
  method's results and the processing of any referrals generated.
  The caller should not modify the object during this time.
  An Attributes object returned by any method is owned by
  the caller.  The caller may subsequently modify it; the service
  provider will not.

 Exceptions

  All the methods in this interface can throw a NamingException or
  any of its subclasses. See NamingException and their subclasses
  for details on each exception."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory DirContext]))

(defn get-attributes
  "Retrieves selected attributes associated with a named object.
   See the class description regarding attribute models, attribute
   type names, and operational attributes.

    If the object does not have an attribute
   specified, the directory will ignore the nonexistent attribute
   and return those requested attributes that the object does have.

    A directory might return more attributes than was requested
   (see Attribute Type Names in the class description),
   but is not allowed to return arbitrary, unrelated attributes.

    See also Operational Attributes in the class
   description.

  name - the name of the object from which to retrieve attributes - `javax.naming.Name`
  attr-ids - the identifiers of the attributes to retrieve. null indicates that all attributes should be retrieved; an empty array indicates that none should be retrieved. - `java.lang.String[]`

  returns: the requested attributes; never null - `javax.naming.directory.Attributes`

  throws: javax.naming.NamingException - if a naming exception is encountered"
  (^javax.naming.directory.Attributes [^DirContext this ^javax.naming.Name name attr-ids]
    (-> this (.getAttributes name attr-ids)))
  (^javax.naming.directory.Attributes [^DirContext this ^javax.naming.Name name]
    (-> this (.getAttributes name))))

(defn modify-attributes
  "Modifies the attributes associated with a named object.
   The order of the modifications is not specified.  Where
   possible, the modifications are performed atomically.

  name - the name of the object whose attributes will be updated - `javax.naming.Name`
  mod-op - the modification operation, one of: ADD_ATTRIBUTE, REPLACE_ATTRIBUTE, REMOVE_ATTRIBUTE. - `int`
  attrs - the attributes to be used for the modification; may not be null - `javax.naming.directory.Attributes`

  throws: javax.naming.directory.AttributeModificationException - if the modification cannot be completed successfully"
  ([^DirContext this ^javax.naming.Name name ^Integer mod-op ^javax.naming.directory.Attributes attrs]
    (-> this (.modifyAttributes name mod-op attrs)))
  ([^DirContext this ^javax.naming.Name name mods]
    (-> this (.modifyAttributes name mods))))

(defn bind
  "Binds a name to an object, along with associated attributes.
   If attrs is null, the resulting binding will have
   the attributes associated with obj if obj is a
   DirContext, and no attributes otherwise.
   If attrs is non-null, the resulting binding will have
   attrs as its attributes; any attributes associated with
   obj are ignored.

  name - the name to bind; may not be empty - `javax.naming.Name`
  obj - the object to bind; possibly null - `java.lang.Object`
  attrs - the attributes to associate with the binding - `javax.naming.directory.Attributes`

  throws: javax.naming.NameAlreadyBoundException - if name is already bound"
  ([^DirContext this ^javax.naming.Name name ^java.lang.Object obj ^javax.naming.directory.Attributes attrs]
    (-> this (.bind name obj attrs))))

(defn rebind
  "Binds a name to an object, along with associated attributes,
   overwriting any existing binding.
   If attrs is null and obj is a DirContext,
   the attributes from obj are used.
   If attrs is null and obj is not a DirContext,
   any existing attributes associated with the object already bound
   in the directory remain unchanged.
   If attrs is non-null, any existing attributes associated with
   the object already bound in the directory are removed and attrs
   is associated with the named object.  If obj is a
   DirContext and attrs is non-null, the attributes
   of obj are ignored.

  name - the name to bind; may not be empty - `javax.naming.Name`
  obj - the object to bind; possibly null - `java.lang.Object`
  attrs - the attributes to associate with the binding - `javax.naming.directory.Attributes`

  throws: javax.naming.directory.InvalidAttributesException - if some \"mandatory\" attributes of the binding are not supplied"
  ([^DirContext this ^javax.naming.Name name ^java.lang.Object obj ^javax.naming.directory.Attributes attrs]
    (-> this (.rebind name obj attrs))))

(defn create-subcontext
  "Creates and binds a new context, along with associated attributes.
   This method creates a new subcontext with the given name, binds it in
   the target context (that named by all but terminal atomic
   component of the name), and associates the supplied attributes
   with the newly created object.
   All intermediate and target contexts must already exist.
   If attrs is null, this method is equivalent to
   Context.createSubcontext().

  name - the name of the context to create; may not be empty - `javax.naming.Name`
  attrs - the attributes to associate with the newly created context - `javax.naming.directory.Attributes`

  returns: the newly created context - `javax.naming.directory.DirContext`

  throws: javax.naming.NameAlreadyBoundException - if the name is already bound"
  (^javax.naming.directory.DirContext [^DirContext this ^javax.naming.Name name ^javax.naming.directory.Attributes attrs]
    (-> this (.createSubcontext name attrs))))

(defn get-schema
  "Retrieves the schema associated with the named object.
   The schema describes rules regarding the structure of the namespace
   and the attributes stored within it.  The schema
   specifies what types of objects can be added to the directory and where
   they can be added; what mandatory and optional attributes an object
   can have. The range of support for schemas is directory-specific.

    This method returns the root of the schema information tree
   that is applicable to the named object. Several named objects
   (or even an entire directory) might share the same schema.

    Issues such as structure and contents of the schema tree,
   permission to modify to the contents of the schema
   tree, and the effect of such modifications on the directory
   are dependent on the underlying directory.

  name - the name of the object whose schema is to be retrieved - `javax.naming.Name`

  returns: the schema associated with the context; never null - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - if schema not supported"
  (^javax.naming.directory.DirContext [^DirContext this ^javax.naming.Name name]
    (-> this (.getSchema name))))

(defn get-schema-class-definition
  "Retrieves a context containing the schema objects of the
   named object's class definitions.

   One category of information found in directory schemas is
   class definitions.  An \"object class\" definition
   specifies the object's type and what attributes (mandatory
   and optional) the object must/can have. Note that the term
   \"object class\" being referred to here is in the directory sense
   rather than in the Java sense.
   For example, if the named object is a directory object of
   \"Person\" class, getSchemaClassDefinition() would return a
   DirContext representing the (directory's) object class
   definition of \"Person\".

   The information that can be retrieved from an object class definition
   is directory-dependent.

   Prior to JNDI 1.2, this method
   returned a single schema object representing the class definition of
   the named object.
   Since JNDI 1.2, this method returns a DirContext containing
   all of the named object's class definitions.

  name - the name of the object whose object class definition is to be retrieved - `javax.naming.Name`

  returns: the DirContext containing the named
            object's class definitions; never null - `javax.naming.directory.DirContext`

  throws: javax.naming.OperationNotSupportedException - if schema not supported"
  (^javax.naming.directory.DirContext [^DirContext this ^javax.naming.Name name]
    (-> this (.getSchemaClassDefinition name))))

(defn search
  "Searches in the named context or object for entries that satisfy the
   given search filter.  Performs the search as specified by
   the search controls.

   The interpretation of filterExpr is based on RFC
   2254.  It may additionally contain variables of the form
   {i} -- where i is an integer -- that
   refer to objects in the filterArgs array.  The
   interpretation of filterExpr is otherwise
   identical to that of the filter parameter of the
   method search(Name, String, SearchControls).

   When a variable {i} appears in a search filter, it
   indicates that the filter argument filterArgs[i]
   is to be used in that place.  Such variables may be used
   wherever an attr, value, or
   matchingrule production appears in the filter grammar
   of RFC 2254, section 4.  When a string-valued filter argument
   is substituted for a variable, the filter is interpreted as if
   the string were given in place of the variable, with any
   characters having special significance within filters (such as
   '*') having been escaped according to the rules of
   RFC 2254.

   For directories that do not use a string representation for
   some or all of their attributes, the filter argument
   corresponding to an attribute value may be of a type other than
   String.  Directories that support unstructured binary-valued
   attributes, for example, should accept byte arrays as filter
   arguments.  The interpretation (if any) of filter arguments of
   any other type is determined by the service provider for that
   directory, which maps the filter operations onto operations with
   corresponding semantics in the underlying directory.

   This method returns an enumeration of the results.
   Each element in the enumeration contains the name of the object
   and other information about the object (see SearchResult).
   The name is either relative to the target context of the search
   (which is named by the name parameter), or
   it is a URL string. If the target context is included in
   the enumeration (as is possible when
   cons specifies a search scope of
   SearchControls.OBJECT_SCOPE or
   SearchControls.SUBSTREE_SCOPE),
   its name is the empty string.

   The SearchResult may also contain attributes of the matching
   object if the cons argument specifies that attributes be
   returned.

   If the object does not have a requested attribute, that
   nonexistent attribute will be ignored.  Those requested
   attributes that the object does have will be returned.

   A directory might return more attributes than were requested
   (see Attribute Type Names in the class description)
   but is not allowed to return arbitrary, unrelated attributes.

   If a search filter with invalid variable substitutions is provided
   to this method, the result is undefined.
   When changes are made to this DirContext,
   the effect on enumerations returned by prior calls to this method
   is undefined.

   See also Operational Attributes in the class
   description.

  name - the name of the context or object to search - `javax.naming.Name`
  filter-expr - the filter expression to use for the search. The expression may contain variables of the form \"{i}\" where i is a nonnegative integer. May not be null. - `java.lang.String`
  filter-args - the array of arguments to substitute for the variables in filterExpr. The value of filterArgs[i] will replace each occurrence of \"{i}\". If null, equivalent to an empty array. - `java.lang.Object[]`
  cons - the search controls that control the search. If null, the default search controls are used (equivalent to (new SearchControls())). - `javax.naming.directory.SearchControls`

  returns: an enumeration of SearchResults of the objects
            that satisfy the filter; never null - `javax.naming.NamingEnumeration<javax.naming.directory.SearchResult>`

  throws: java.lang.ArrayIndexOutOfBoundsException - if filterExpr contains {i} expressions where i is outside the bounds of the array filterArgs"
  (^javax.naming.NamingEnumeration [^DirContext this ^javax.naming.Name name ^java.lang.String filter-expr filter-args ^javax.naming.directory.SearchControls cons]
    (-> this (.search name filter-expr filter-args cons)))
  (^javax.naming.NamingEnumeration [^DirContext this ^javax.naming.Name name ^javax.naming.directory.Attributes matching-attributes attributes-to-return]
    (-> this (.search name matching-attributes attributes-to-return)))
  (^javax.naming.NamingEnumeration [^DirContext this ^javax.naming.Name name ^javax.naming.directory.Attributes matching-attributes]
    (-> this (.search name matching-attributes))))

