(ns javax.naming.LinkRef
  "This class represents a Reference whose contents is a name, called the link name,
  that is bound to an atomic name in a context.

  The name is a URL, or a name to be resolved relative to the initial
  context, or if the first character of the name is \".\", the name
  is relative to the context in which the link is bound.

  Normal resolution of names in context operations always follow links.
  Resolution of the link name itself may cause resolution to pass through
  other  links. This gives rise to the possibility of a cycle of links whose
  resolution could not terminate normally. As a simple means to avoid such
  non-terminating resolutions, service providers may define limits on the
  number of links that may be involved in any single operation invoked
  by the caller.

  A LinkRef contains a single StringRefAddr, whose type is \"LinkAddress\",
  and whose contents is the link name. The class name field of the
  Reference is that of this (LinkRef) class.

  LinkRef is bound to a name using the normal Context.bind()/rebind(), and
  DirContext.bind()/rebind(). Context.lookupLink() is used to retrieve the link
  itself if the terminal atomic name is bound to a link.

  Many naming systems support a native notion of link that may be used
  within the naming system itself. JNDI does not specify whether
  there is any relationship between such native links and JNDI links.

  A LinkRef instance is not synchronized against concurrent access by multiple
  threads. Threads that need to access a LinkRef instance concurrently should
  synchronize amongst themselves and provide the necessary locking."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.naming LinkRef]))

(defn ->link-ref
  "Constructor.

  Constructs a LinkRef for a name.

  link-name - The non-null name for which to create this link. - `javax.naming.Name`"
  (^LinkRef [^javax.naming.Name link-name]
    (new LinkRef link-name)))

(defn get-link-name
  "Retrieves the name of this link.

  returns: The non-null name of this link. - `java.lang.String`

  throws: javax.naming.MalformedLinkException - If a link name could not be extracted"
  (^java.lang.String [^LinkRef this]
    (-> this (.getLinkName))))

