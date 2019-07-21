(ns javax.naming.spi.Resolver
  "This interface represents an \"intermediate context\" for name resolution.

  The Resolver interface contains methods that are implemented by contexts
  that do not support subtypes of Context, but which can act as
  intermediate contexts for resolution purposes.

  A Name parameter passed to any method is owned
  by the caller.  The service provider will not modify the object
  or keep a reference to it.
  A ResolveResult object returned by any
  method is owned by the caller.  The caller may subsequently modify it;
  the service provider may not."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming.spi Resolver]))

(defn resolve-to-class
  "Partially resolves a name.  Stops at the first
   context that is an instance of a given subtype of
   Context.

  name - the name to resolve - `javax.naming.Name`
  context-type - the type of object to resolve. This should be a subtype of Context. - `java.lang.Class`

  returns: the object that was found, along with the unresolved
            suffix of name.  Cannot be null. - `javax.naming.spi.ResolveResult`

  throws: javax.naming.NotContextException - if no context of the appropriate type is found"
  (^javax.naming.spi.ResolveResult [^Resolver this ^javax.naming.Name name ^java.lang.Class context-type]
    (-> this (.resolveToClass name context-type))))

