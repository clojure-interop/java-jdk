(ns javax.xml.ws.handler.MessageContext$Scope
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler MessageContext$Scope]))

(def APPLICATION
  "Enum Constant.

  type: javax.xml.ws.handler.MessageContext.Scope"
  MessageContext$Scope/APPLICATION)

(def HANDLER
  "Enum Constant.

  type: javax.xml.ws.handler.MessageContext.Scope"
  MessageContext$Scope/HANDLER)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (MessageContext.Scope c : MessageContext.Scope.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.xml.ws.handler.MessageContext.Scope[]`"
  ([]
    (MessageContext$Scope/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.xml.ws.handler.MessageContext.Scope`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.xml.ws.handler.MessageContext.Scope [^java.lang.String name]
    (MessageContext$Scope/valueOf name)))

