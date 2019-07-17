(ns javax.activation.DataHandler
  "The DataHandler class provides a consistent interface to data
  available in many different sources and formats.
  It manages simple stream to string conversions and related operations
  using DataContentHandlers.
  It provides access to commands that can operate on the data.
  The commands are found using a CommandMap.

  DataHandler and the Transferable Interface
  DataHandler implements the Transferable interface so that data can
  be used in AWT data transfer operations, such as cut and paste and
  drag and drop. The implementation of the Transferable interface
  relies on the availability of an installed DataContentHandler
  object corresponding to the MIME type of the data represented in
  the specific instance of the DataHandler.

  DataHandler and CommandMaps
  The DataHandler keeps track of the current CommandMap that it uses to
  service requests for commands (getCommand,
  getAllCommands, getPreferredCommands).
  Each instance of a DataHandler may have a CommandMap associated with
  it using the setCommandMap method.  If a CommandMap was
  not set, DataHandler calls the getDefaultCommandMap
  method in CommandMap and uses the value it returns. See
  CommandMap for more information.

  DataHandler and URLs
  The current DataHandler implementation creates a private
  instance of URLDataSource when it is constructed with a URL."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation DataHandler]))

(defn ->data-handler
  "Constructor.

  Create a DataHandler instance representing an object
   of this MIME type.  This constructor is
   used when the application already has an in-memory representation
   of the data in the form of a Java Object.

  obj - the Java Object - `java.lang.Object`
  mime-type - the MIME type of the object - `java.lang.String`"
  ([obj mime-type]
    (new DataHandler obj mime-type))
  ([ds]
    (new DataHandler ds)))

(defn *set-data-content-handler-factory
  "Sets the DataContentHandlerFactory.  The DataContentHandlerFactory
   is called first to find DataContentHandlers.
   The DataContentHandlerFactory can only be set once.

   If the DataContentHandlerFactory has already been set,
   this method throws an Error.

  new-factory - the DataContentHandlerFactory - `javax.activation.DataContentHandlerFactory`

  throws: java.lang.Error - if the factory has already been defined."
  ([new-factory]
    (DataHandler/setDataContentHandlerFactory new-factory)))

(defn get-preferred-commands
  "Return the preferred commands for this type of data.
   This method calls the getPreferredCommands method
   in the CommandMap associated with this instance of DataHandler.
   This method returns an array that represents a subset of
   available commands. In cases where multiple commands for the
   MIME type represented by this DataHandler are present, the
   installed CommandMap chooses the appropriate commands.

  returns: the CommandInfo objects representing the preferred commands - `javax.activation.CommandInfo[]`"
  ([this]
    (-> this (.getPreferredCommands))))

(defn get-all-commands
  "Return all the commands for this type of data.
   This method returns an array containing all commands
   for the type of data represented by this DataHandler. The
   MIME type for the underlying data represented by this DataHandler
   is used to call through to the getAllCommands method
   of the CommandMap associated with this DataHandler.

  returns: the CommandInfo objects representing all the commands - `javax.activation.CommandInfo[]`"
  ([this]
    (-> this (.getAllCommands))))

(defn get-command
  "Get the command cmdName. Use the search semantics as
   defined by the CommandMap installed in this DataHandler. The
   MIME type for the underlying data represented by this DataHandler
   is used to call through to the getCommand method
   of the CommandMap associated with this DataHandler.

  cmd-name - the command name - `java.lang.String`

  returns: the CommandInfo corresponding to the command - `javax.activation.CommandInfo`"
  ([this cmd-name]
    (-> this (.getCommand cmd-name))))

(defn get-content-type
  "Return the MIME type of this object as retrieved from
   the source object. Note that this is the full
   type with parameters.

  returns: the MIME type - `java.lang.String`"
  ([this]
    (-> this (.getContentType))))

(defn get-name
  "Return the name of the data object. If this DataHandler
   was created with a DataSource, this method calls through
   to the DataSource.getName method, otherwise it
   returns null.

  returns: the name of the object - `java.lang.String`"
  ([this]
    (-> this (.getName))))

(defn write-to
  "Write the data to an OutputStream.

   If the DataHandler was created with a DataSource, writeTo
   retrieves the InputStream and copies the bytes from the
   InputStream to the OutputStream passed in.

   If the DataHandler was created with an object, writeTo
   retrieves the DataContentHandler for the object's type.
   If the DataContentHandler was found, it calls the
   writeTo method on the DataContentHandler.

  os - the OutputStream to write to - `java.io.OutputStream`

  throws: java.io.IOException - if an I/O error occurs"
  ([this os]
    (-> this (.writeTo os))))

(defn get-transfer-data
  "Returns an object that represents the data to be
   transferred. The class of the object returned is defined by the
   representation class of the data flavor.

   For DataHandler's created with DataSources or URLs:

   The DataHandler attempts to locate a DataContentHandler
   for this MIME type. If one is found, the passed in DataFlavor
   and the type of the data are passed to its getTransferData
   method. If the DataHandler fails to locate a DataContentHandler
   and the flavor specifies this object's MIME type and the
   java.io.InputStream class, this object's InputStream
   is returned.
   Otherwise it throws an UnsupportedFlavorException.

   For DataHandler's created with Objects:

   The DataHandler attempts to locate a DataContentHandler
   for this MIME type. If one is found, the passed in DataFlavor
   and the type of the data are passed to its getTransferData
   method. If the DataHandler fails to locate a DataContentHandler
   and the flavor specifies this object's MIME type and its class,
   this DataHandler's referenced object is returned.
   Otherwise it throws an UnsupportedFlavorException.

  flavor - the requested flavor for the data - `java.awt.datatransfer.DataFlavor`

  returns: the object - `java.lang.Object`

  throws: java.awt.datatransfer.UnsupportedFlavorException - if the data could not be converted to the requested flavor"
  ([this flavor]
    (-> this (.getTransferData flavor))))

(defn get-output-stream
  "Get an OutputStream for this DataHandler to allow overwriting
   the underlying data.
   If the DataHandler was created with a DataSource, the
   DataSource's getOutputStream method is called.
   Otherwise, null is returned.

  returns: the OutputStream - `java.io.OutputStream`

  throws: java.io.IOException"
  ([this]
    (-> this (.getOutputStream))))

(defn get-transfer-data-flavors
  "Return the DataFlavors in which this data is available.

   Returns an array of DataFlavor objects indicating the flavors
   the data can be provided in. The array is usually ordered
   according to preference for providing the data, from most
   richly descriptive to least richly descriptive.

   The DataHandler attempts to find a DataContentHandler that
   corresponds to the MIME type of the data. If one is located,
   the DataHandler calls the DataContentHandler's
   getTransferDataFlavors method.

   If a DataContentHandler can not be located, and if the
   DataHandler was created with a DataSource (or URL), one
   DataFlavor is returned that represents this object's MIME type
   and the java.io.InputStream class.  If the
   DataHandler was created with an object and a MIME type,
   getTransferDataFlavors returns one DataFlavor that represents
   this object's MIME type and the object's class.

  returns: an array of data flavors in which this data can be transferred - `java.awt.datatransfer.DataFlavor[]`"
  ([this]
    (-> this (.getTransferDataFlavors))))

(defn get-input-stream
  "Get the InputStream for this object.

   For DataHandlers instantiated with a DataSource, the DataHandler
   calls the DataSource.getInputStream method and
   returns the result to the caller.

   For DataHandlers instantiated with an Object, the DataHandler
   first attempts to find a DataContentHandler for the Object. If
   the DataHandler can not find a DataContentHandler for this MIME
   type, it throws an UnsupportedDataTypeException.  If it is
   successful, it creates a pipe and a thread.  The thread uses the
   DataContentHandler's writeTo method to write the
   stream data into one end of the pipe.  The other end of the pipe
   is returned to the caller.  Because a thread is created to copy
   the data, IOExceptions that may occur during the copy can not be
   propagated back to the caller. The result is an empty stream.

  returns: the InputStream representing this data - `java.io.InputStream`

  throws: java.io.IOException - if an I/O error occurs"
  ([this]
    (-> this (.getInputStream))))

(defn set-command-map
  "Set the CommandMap for use by this DataHandler.
   Setting it to null causes the CommandMap to revert
   to the CommandMap returned by the
   CommandMap.getDefaultCommandMap method.
   Changing the CommandMap, or setting it to null,
   clears out any data cached from the previous CommandMap.

  command-map - the CommandMap to use in this DataHandler - `javax.activation.CommandMap`"
  ([this command-map]
    (-> this (.setCommandMap command-map))))

(defn get-data-source
  "Return the DataSource associated with this instance
   of DataHandler.

   For DataHandlers that have been instantiated with a DataSource,
   this method returns the DataSource that was used to create the
   DataHandler object. In other cases the DataHandler
   constructs a DataSource from the data used to construct
   the DataHandler. DataSources created for DataHandlers not
   instantiated with a DataSource are cached for performance
   reasons.

  returns: a valid DataSource object for this DataHandler - `javax.activation.DataSource`"
  ([this]
    (-> this (.getDataSource))))

(defn get-bean
  "A convenience method that takes a CommandInfo object
   and instantiates the corresponding command, usually
   a JavaBean component.

   This method calls the CommandInfo's getCommandObject
   method with the ClassLoader used to load
   the javax.activation.DataHandler class itself.

  cmdinfo - the CommandInfo corresponding to a command - `javax.activation.CommandInfo`

  returns: the instantiated command object - `java.lang.Object`"
  ([this cmdinfo]
    (-> this (.getBean cmdinfo))))

(defn get-content
  "Return the data in its preferred Object form.

   If the DataHandler was instantiated with an object, return
   the object.

   If the DataHandler was instantiated with a DataSource,
   this method uses a DataContentHandler to return the content
   object for the data represented by this DataHandler. If no
   DataContentHandler can be found for the
   the type of this data, the DataHandler returns an
   InputStream for the data.

  returns: the content. - `java.lang.Object`

  throws: java.io.IOException - if an IOException occurs during this operation."
  ([this]
    (-> this (.getContent))))

(defn data-flavor-supported?
  "Returns whether the specified data flavor is supported
   for this object.

   This method iterates through the DataFlavors returned from
   getTransferDataFlavors, comparing each with
   the specified flavor.

  flavor - the requested flavor for the data - `java.awt.datatransfer.DataFlavor`

  returns: true if the data flavor is supported - `boolean`"
  ([this flavor]
    (-> this (.isDataFlavorSupported flavor))))

