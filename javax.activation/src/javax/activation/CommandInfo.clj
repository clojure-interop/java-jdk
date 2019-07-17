(ns javax.activation.CommandInfo
  "The CommandInfo class is used by CommandMap implementations to
  describe the results of command requests. It provides the requestor
  with both the verb requested, as well as an instance of the
  bean. There is also a method that will return the name of the
  class that implements the command but it is not guaranteed to
  return a valid value. The reason for this is to allow CommandMap
  implmentations that subclass CommandInfo to provide special
  behavior. For example a CommandMap could dynamically generate
  JavaBeans. In this case, it might not be possible to create an
  object with all the correct state information solely from the class
  name."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation CommandInfo]))

(defn ->command-info
  "Constructor.

  The Constructor for CommandInfo.

  verb - The command verb this CommandInfo decribes. - `java.lang.String`
  class-name - The command's fully qualified class name. - `java.lang.String`"
  ([^java.lang.String verb ^java.lang.String class-name]
    (new CommandInfo verb class-name)))

(defn get-command-name
  "Return the command verb.

  returns: the command verb. - `java.lang.String`"
  (^java.lang.String [^javax.activation.CommandInfo this]
    (-> this (.getCommandName))))

(defn get-command-class
  "Return the command's class name. This method MAY return null in
   cases where a CommandMap subclassed CommandInfo for its
   own purposes. In other words, it might not be possible to
   create the correct state in the command by merely knowing
   its class name. DO NOT DEPEND ON THIS METHOD RETURNING
   A VALID VALUE!

  returns: The class name of the command, or null - `java.lang.String`"
  (^java.lang.String [^javax.activation.CommandInfo this]
    (-> this (.getCommandClass))))

(defn get-command-object
  "Return the instantiated JavaBean component.

   Begin by instantiating the component with
   Beans.instantiate().

   If the bean implements the javax.activation.CommandObject
   interface, call its setCommandContext method.

   If the DataHandler parameter is null, then the bean is
   instantiated with no data. NOTE: this may be useful
   if for some reason the DataHandler that is passed in
   throws IOExceptions when this method attempts to
   access its InputStream. It will allow the caller to
   retrieve a reference to the bean if it can be
   instantiated.

   If the bean does NOT implement the CommandObject interface,
   this method will check if it implements the
   java.io.Externalizable interface. If it does, the bean's
   readExternal method will be called if an InputStream
   can be acquired from the DataHandler.

  dh - The DataHandler that describes the data to be passed to the command. - `javax.activation.DataHandler`
  loader - The ClassLoader to be used to instantiate the bean. - `java.lang.ClassLoader`

  returns: The bean - `java.lang.Object`

  throws: java.io.IOException"
  (^java.lang.Object [^javax.activation.CommandInfo this ^javax.activation.DataHandler dh ^java.lang.ClassLoader loader]
    (-> this (.getCommandObject dh loader))))

