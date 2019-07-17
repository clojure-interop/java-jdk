(ns javax.naming.directory.SearchControls
  "This class encapsulates
  factors that determine scope of search and what gets returned
  as a result of the search.

  A SearchControls instance is not synchronized against concurrent
  multithreaded access. Multiple threads trying to access and modify
  a single SearchControls instance should lock the object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.directory SearchControls]))

(defn ->search-controls
  "Constructor.

  Constructs a search constraints using arguments.

  scope - The search scope. One of: OBJECT_SCOPE, ONELEVEL_SCOPE, SUBTREE_SCOPE. - `int`
  countlim - The maximum number of entries to return. If 0, return all entries that satisfy filter. - `long`
  timelim - The number of milliseconds to wait before returning. If 0, wait indefinitely. - `int`
  attrs - The identifiers of the attributes to return along with the entry. If null, return all attributes. If empty return no attributes. - `java.lang.String[]`
  retobj - If true, return the object bound to the name of the entry; if false, do not return object. - `boolean`
  deref - If true, dereference links during search. - `boolean`"
  ([scope countlim timelim attrs retobj deref]
    (new SearchControls scope countlim timelim attrs retobj deref))
  ([]
    (new SearchControls )))

(def *-object-scope
  "Static Constant.

  Search the named object.

   The NamingEnumeration that results from search()
   using OBJECT_SCOPE will contain one or zero element.
   The enumeration contains one element if the named object satisfies
   the search filter specified in search().
   The element will have as its name the empty string because the names
   of elements in the NamingEnumeration are relative to the
   target context--in this case, the target context is the named object.
   It contains zero element if the named object does not satisfy
   the search filter specified in search().

   The value of this constant is 0.

  type: int"
  SearchControls/OBJECT_SCOPE)

(def *-onelevel-scope
  "Static Constant.

  Search one level of the named context.

   The NamingEnumeration that results from search()
   using ONELEVEL_SCOPE contains elements with
   objects in the named context that satisfy
   the search filter specified in search().
   The names of elements in the NamingEnumeration are atomic names
   relative to the named context.

   The value of this constant is 1.

  type: int"
  SearchControls/ONELEVEL_SCOPE)

(def *-subtree-scope
  "Static Constant.

  Search the entire subtree rooted at the named object.

   If the named object is not a DirContext, search only the object.
   If the named object is a DirContext, search the subtree
   rooted at the named object, including the named object itself.

   The search will not cross naming system boundaries.

   The NamingEnumeration that results from search()
   using SUBTREE_SCOPE contains elements of objects
   from the subtree (including the named context)
   that satisfy the search filter specified in search().
   The names of elements in the NamingEnumeration are either
   relative to the named context or is a URL string.
   If the named context satisfies the search filter, it is
   included in the enumeration with the empty string as
   its name.

   The value of this constant is 2.

  type: int"
  SearchControls/SUBTREE_SCOPE)

(defn set-count-limit
  "Sets the maximum number of entries to be returned
   as a result of the search.

   0 indicates no limit:  all entries will be returned.

  limit - The maximum number of entries that will be returned. - `long`"
  ([this limit]
    (-> this (.setCountLimit limit))))

(defn set-deref-link-flag
  "Enables/disables link dereferencing during the search.

  on - if true links will be dereferenced; if false, not followed. - `boolean`"
  ([this on]
    (-> this (.setDerefLinkFlag on))))

(defn set-time-limit
  "Sets the time limit of these SearchControls in milliseconds.

   If the value is 0, this means to wait indefinitely.

  ms - The time limit of these SearchControls in milliseconds. - `int`"
  ([this ms]
    (-> this (.setTimeLimit ms))))

(defn set-search-scope
  "Sets the search scope to one of:
   OBJECT_SCOPE, ONELEVEL_SCOPE, SUBTREE_SCOPE.

  scope - The search scope of this SearchControls. - `int`"
  ([this scope]
    (-> this (.setSearchScope scope))))

(defn set-returning-obj-flag
  "Enables/disables returning objects returned as part of the result.

   If disabled, only the name and class of the object is returned.
   If enabled, the object will be returned.

  on - if true, objects will be returned; if false, objects will not be returned. - `boolean`"
  ([this on]
    (-> this (.setReturningObjFlag on))))

(defn get-time-limit
  "Retrieves the time limit of these SearchControls in milliseconds.

   If the value is 0, this means to wait indefinitely.

  returns: The time limit of these SearchControls in milliseconds. - `int`"
  ([this]
    (-> this (.getTimeLimit))))

(defn set-returning-attributes
  "Specifies the attributes that will be returned as part of the search.

   null indicates that all attributes will be returned.
   An empty array indicates no attributes are returned.

  attrs - An array of attribute ids identifying the attributes that will be returned. Can be null. - `java.lang.String[]`"
  ([this attrs]
    (-> this (.setReturningAttributes attrs))))

(defn get-deref-link-flag?
  "Determines whether links will be dereferenced during the search.

  returns: true if links will be dereferenced; false otherwise. - `boolean`"
  ([this]
    (-> this (.getDerefLinkFlag))))

(defn get-returning-attributes
  "Retrieves the attributes that will be returned as part of the search.

   A value of null indicates that all attributes will be returned.
   An empty array indicates that no attributes are to be returned.

  returns: An array of attribute ids identifying the attributes that
   will be returned. Can be null. - `java.lang.String[]`"
  ([this]
    (-> this (.getReturningAttributes))))

(defn get-count-limit
  "Retrieves the maximum number of entries that will be returned
   as a result of the search.

   0 indicates that all entries will be returned.

  returns: The maximum number of entries that will be returned. - `long`"
  ([this]
    (-> this (.getCountLimit))))

(defn get-returning-obj-flag?
  "Determines whether objects will be returned as part of the result.

  returns: true if objects will be returned; false otherwise. - `boolean`"
  ([this]
    (-> this (.getReturningObjFlag))))

(defn get-search-scope
  "Retrieves the search scope of these SearchControls.

   One of OBJECT_SCOPE, ONELEVEL_SCOPE, SUBTREE_SCOPE.

  returns: The search scope of this SearchControls. - `int`"
  ([this]
    (-> this (.getSearchScope))))

