(ns javax.activation.CommandMap
  "The CommandMap class provides an interface to a registry of
  command objects available in the system.
  Developers are expected to either use the CommandMap
  implementation included with this package (MailcapCommandMap) or
  develop their own. Note that some of the methods in this class are
  abstract."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation CommandMap]))

(defn ->command-map
  "Constructor."
  ([]
    (new CommandMap )))

(defn *get-default-command-map
  "Get the default CommandMap.



    In cases where a CommandMap instance has been previously set
        to some value (via setDefaultCommandMap)
    return the CommandMap.

    In cases where no CommandMap has been set, the CommandMap
         creates an instance of MailcapCommandMap and
         set that to the default, returning its value.

  returns: the CommandMap - `javax.activation.CommandMap`"
  ([]
    (CommandMap/getDefaultCommandMap )))

(defn *set-default-command-map
  "Set the default CommandMap. Reset the CommandMap to the default by
   calling this method with null.

  command-map - The new default CommandMap. - `javax.activation.CommandMap`

  throws: java.lang.SecurityException - if the caller doesn't have permission to change the default"
  ([^javax.activation.CommandMap command-map]
    (CommandMap/setDefaultCommandMap command-map)))

(defn get-preferred-commands
  "Get the preferred command list from a MIME Type. The actual semantics
   are determined by the implementation of the CommandMap.

   The DataSource provides extra information, such as
   the file name, that a CommandMap implementation may use to further
   refine the list of commands that are returned.  The implementation
   in this class simply calls the getPreferredCommands
   method that ignores this argument.

  mime-type - the MIME type - `java.lang.String`
  ds - a DataSource for the data - `javax.activation.DataSource`

  returns: the CommandInfo classes that represent the command Beans. - `javax.activation.CommandInfo[]`"
  ([^javax.activation.CommandMap this ^java.lang.String mime-type ^javax.activation.DataSource ds]
    (-> this (.getPreferredCommands mime-type ds)))
  ([^javax.activation.CommandMap this ^java.lang.String mime-type]
    (-> this (.getPreferredCommands mime-type))))

(defn get-all-commands
  "Get all the available commands for this type. This method
   should return all the possible commands for this MIME type.

   The DataSource provides extra information, such as
   the file name, that a CommandMap implementation may use to further
   refine the list of commands that are returned.  The implementation
   in this class simply calls the getAllCommands
   method that ignores this argument.

  mime-type - the MIME type - `java.lang.String`
  ds - a DataSource for the data - `javax.activation.DataSource`

  returns: the CommandInfo objects representing all the commands. - `javax.activation.CommandInfo[]`"
  ([^javax.activation.CommandMap this ^java.lang.String mime-type ^javax.activation.DataSource ds]
    (-> this (.getAllCommands mime-type ds)))
  ([^javax.activation.CommandMap this ^java.lang.String mime-type]
    (-> this (.getAllCommands mime-type))))

(defn get-command
  "Get the default command corresponding to the MIME type.

   The DataSource provides extra information, such as
   the file name, that a CommandMap implementation may use to further
   refine the command that is chosen.  The implementation
   in this class simply calls the getCommand
   method that ignores this argument.

  mime-type - the MIME type - `java.lang.String`
  cmd-name - the command name - `java.lang.String`
  ds - a DataSource for the data - `javax.activation.DataSource`

  returns: the CommandInfo corresponding to the command. - `javax.activation.CommandInfo`"
  ([^javax.activation.CommandMap this ^java.lang.String mime-type ^java.lang.String cmd-name ^javax.activation.DataSource ds]
    (-> this (.getCommand mime-type cmd-name ds)))
  ([^javax.activation.CommandMap this ^java.lang.String mime-type ^java.lang.String cmd-name]
    (-> this (.getCommand mime-type cmd-name))))

(defn create-data-content-handler
  "Locate a DataContentHandler that corresponds to the MIME type.
   The mechanism and semantics for determining this are determined
   by the implementation of the particular CommandMap.

   The DataSource provides extra information, such as
   the file name, that a CommandMap implementation may use to further
   refine the choice of DataContentHandler.  The implementation
   in this class simply calls the createDataContentHandler
   method that ignores this argument.

  mime-type - the MIME type - `java.lang.String`
  ds - a DataSource for the data - `javax.activation.DataSource`

  returns: the DataContentHandler for the MIME type - `javax.activation.DataContentHandler`"
  ([^javax.activation.CommandMap this ^java.lang.String mime-type ^javax.activation.DataSource ds]
    (-> this (.createDataContentHandler mime-type ds)))
  ([^javax.activation.CommandMap this ^java.lang.String mime-type]
    (-> this (.createDataContentHandler mime-type))))

(defn get-mime-types
  "Get all the MIME types known to this command map.
   If the command map doesn't support this operation,
   null is returned.

  returns: array of MIME types as strings, or null if not supported - `java.lang.String[]`"
  ([^javax.activation.CommandMap this]
    (-> this (.getMimeTypes))))

