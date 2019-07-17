(ns javax.xml.ws.handler.MessageContext
  "The interface MessageContext abstracts the message
  context that is processed by a handler in the handle
  method.

  The MessageContext interface provides methods to
  manage a property set. MessageContext properties
  enable handlers in a handler chain to share processing related
  state."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler MessageContext]))

(defn set-scope
  "Sets the scope of a property.

  name - Name of the property associated with the MessageContext - `java.lang.String`
  scope - Desired scope of the property - `javax.xml.ws.handler.MessageContext.Scope`

  throws: java.lang.IllegalArgumentException - if an illegal property name is specified"
  ([^. this ^java.lang.String name ^javax.xml.ws.handler.MessageContext.Scope scope]
    (-> this (.setScope name scope))))

(defn get-scope
  "Gets the scope of a property.

  name - Name of the property - `java.lang.String`

  returns: Scope of the property - `javax.xml.ws.handler.MessageContext.Scope`

  throws: java.lang.IllegalArgumentException - if a non-existant property name is specified"
  ([^. this ^java.lang.String name]
    (-> this (.getScope name))))

