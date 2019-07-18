(ns javax.imageio.metadata.IIOMetadata
  "An abstract class to be extended by objects that represent metadata
  (non-image data) associated with images and streams.  Plug-ins
  represent metadata using opaque, plug-in specific objects.  These
  objects, however, provide the ability to access their internal
  information as a tree of IIOMetadataNode objects that
  support the XML DOM interfaces as well as additional interfaces for
  storing non-textual data and retrieving information about legal
  data values.  The format of such trees is plug-in dependent, but
  plug-ins may choose to support a plug-in neutral format described
  below.  A single plug-in may support multiple metadata formats,
  whose names maybe determined by calling
  getMetadataFormatNames.  The plug-in may also support
  a single special format, referred to as the `native` format, which
  is designed to encode its metadata losslessly.  This format will
  typically be designed specifically to work with a specific file
  format, so that images may be loaded and saved in the same format
  with no loss of metadata, but may be less useful for transferring
  metadata between an ImageReader and an
  ImageWriter for different image formats.  To convert
  between two native formats as losslessly as the image file formats
  will allow, an ImageTranscoder object must be used."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.metadata IIOMetadata]))

(defn merge-tree
  "Alters the internal state of this IIOMetadata
   object from a tree of XML DOM Nodes whose syntax
   is defined by the given metadata format.  The previous state is
   altered only as necessary to accommodate the nodes that are
   present in the given tree.  If the tree structure or contents
   are invalid, an IIOInvalidTreeException will be
   thrown.

    As the semantics of how a tree or subtree may be merged with
   another tree are completely format-specific, plug-in authors may
   implement this method in whatever manner is most appropriate for
   the format, including simply replacing all existing state with the
   contents of the given tree.

  format-name - the desired metadata format. - `java.lang.String`
  root - an XML DOM Node object forming the root of a tree. - `org.w3c.dom.Node`

  throws: java.lang.IllegalStateException - if this object is read-only."
  ([^IIOMetadata this ^java.lang.String format-name ^org.w3c.dom.Node root]
    (-> this (.mergeTree format-name root))))

(defn has-controller?
  "Returns true if there is a controller installed
   for this IIOMetadata object.

    The default implementation returns true if the
   getController method returns a
   non-null value.

  returns: true if a controller is installed. - `boolean`"
  (^Boolean [^IIOMetadata this]
    (-> this (.hasController))))

(defn activate-controller
  "Activates the installed IIOMetadataController for
   this IIOMetadata object and returns the resulting
   value.  When this method returns true, all values for this
   IIOMetadata object will be ready for the next write
   operation.  If false is
   returned, no settings in this object will have been disturbed
   (i.e., the user canceled the operation).

    Ordinarily, the controller will be a GUI providing a user
   interface for a subclass of IIOMetadata for a
   particular plug-in.  Controllers need not be GUIs, however.

    The default implementation calls getController
   and the calls activate on the returned object if
   hasController returns true.

  returns: true if the controller completed normally. - `boolean`

  throws: java.lang.IllegalStateException - if there is no controller currently installed."
  (^Boolean [^IIOMetadata this]
    (-> this (.activateController))))

(defn get-metadata-format
  "Returns an IIOMetadataFormat object describing the
   given metadata format, or null if no description
   is available.  The supplied name must be one of those returned
   by getMetadataFormatNames (i.e., either the
   native format name, the standard format name, or one of those
   returned by getExtraMetadataFormatNames).

    The default implementation checks the name against the
   global standard metadata format name, and returns that format
   if it is supported.  Otherwise, it checks against the native
   format names followed by any additional format names.  If a
   match is found, it retrieves the name of the
   IIOMetadataFormat class from
   nativeMetadataFormatClassName or
   extraMetadataFormatClassNames as appropriate, and
   constructs an instance of that class using its
   getInstance method.

  format-name - the desired metadata format. - `java.lang.String`

  returns: an IIOMetadataFormat object. - `javax.imageio.metadata.IIOMetadataFormat`

  throws: java.lang.IllegalArgumentException - if formatName is null or is not one of the names recognized by the plug-in."
  (^javax.imageio.metadata.IIOMetadataFormat [^IIOMetadata this ^java.lang.String format-name]
    (-> this (.getMetadataFormat format-name))))

(defn reset
  "Resets all the data stored in this object to default values,
   usually to the state this object was in immediately after
   construction, though the precise semantics are plug-in specific.
   Note that there are many possible default values, depending on
   how the object was created.

  throws: java.lang.IllegalStateException - if this object is read-only."
  ([^IIOMetadata this]
    (-> this (.reset))))

(defn get-metadata-format-names
  "Returns an array of Strings containing the names
   of all metadata formats, including the native and standard
   formats, recognized by this plug-in's getAsTree,
   setFromTree, and mergeTree methods.
   If there are no such formats, null is returned.

    The default implementation calls
   getNativeMetadataFormatName,
   isStandardMetadataFormatSupported, and
   getExtraMetadataFormatNames and returns the
   combined results.

  returns: an array of Strings. - `java.lang.String[]`"
  ([^IIOMetadata this]
    (-> this (.getMetadataFormatNames))))

(defn set-controller
  "Sets the IIOMetadataController to be used
   to provide settings for this IIOMetadata
   object when the activateController method
   is called, overriding any default controller.  If the
   argument is null, no controller will be
   used, including any default.  To restore the default, use
   setController(getDefaultController()).

    The default implementation sets the controller
   instance variable to the supplied value.

  controller - An appropriate IIOMetadataController, or null. - `javax.imageio.metadata.IIOMetadataController`"
  ([^IIOMetadata this ^javax.imageio.metadata.IIOMetadataController controller]
    (-> this (.setController controller))))

(defn get-as-tree
  "Returns an XML DOM Node object that represents the
   root of a tree of metadata contained within this object
   according to the conventions defined by a given metadata
   format.

    The names of the available metadata formats may be queried
   using the getMetadataFormatNames method.

  format-name - the desired metadata format. - `java.lang.String`

  returns: an XML DOM Node object forming the
   root of a tree. - `org.w3c.dom.Node`

  throws: java.lang.IllegalArgumentException - if formatName is null or is not one of the names returned by getMetadataFormatNames."
  (^org.w3c.dom.Node [^IIOMetadata this ^java.lang.String format-name]
    (-> this (.getAsTree format-name))))

(defn set-from-tree
  "Sets the internal state of this IIOMetadata object
   from a tree of XML DOM Nodes whose syntax is
   defined by the given metadata format.  The previous state is
   discarded.  If the tree's structure or contents are invalid, an
   IIOInvalidTreeException will be thrown.

    The default implementation calls reset
   followed by mergeTree(formatName, root).

  format-name - the desired metadata format. - `java.lang.String`
  root - an XML DOM Node object forming the root of a tree. - `org.w3c.dom.Node`

  throws: java.lang.IllegalStateException - if this object is read-only."
  ([^IIOMetadata this ^java.lang.String format-name ^org.w3c.dom.Node root]
    (-> this (.setFromTree format-name root))))

(defn get-default-controller
  "Returns the default IIOMetadataController, if there
   is one, regardless of the currently installed controller.  If
   there is no default controller, returns null.

    The default implementation returns the value of the
   defaultController instance variable.

  returns: the default IIOMetadataController, or
   null. - `javax.imageio.metadata.IIOMetadataController`"
  (^javax.imageio.metadata.IIOMetadataController [^IIOMetadata this]
    (-> this (.getDefaultController))))

(defn read-only?
  "Returns true if this object does not support the
   mergeTree, setFromTree, and
   reset methods.

  returns: true if this IIOMetadata object cannot be
   modified. - `boolean`"
  (^Boolean [^IIOMetadata this]
    (-> this (.isReadOnly))))

(defn get-controller
  "Returns whatever IIOMetadataController is currently
   installed.  This could be the default if there is one,
   null, or the argument of the most recent call
   to setController.

    The default implementation returns the value of the
   controller instance variable.

  returns: the currently installed
   IIOMetadataController, or null. - `javax.imageio.metadata.IIOMetadataController`"
  (^javax.imageio.metadata.IIOMetadataController [^IIOMetadata this]
    (-> this (.getController))))

(defn get-extra-metadata-format-names
  "Returns an array of Strings containing the names
   of additional metadata formats, other than the native and standard
   formats, recognized by this plug-in's
   getAsTree, setFromTree, and
   mergeTree methods.  If there are no such additional
   formats, null is returned.

    The default implementation returns a clone of the
   extraMetadataFormatNames instance variable.

  returns: an array of Strings with length at least
   1, or null. - `java.lang.String[]`"
  ([^IIOMetadata this]
    (-> this (.getExtraMetadataFormatNames))))

(defn get-native-metadata-format-name
  "Returns the name of the `native` metadata format for this
   plug-in, which typically allows for lossless encoding and
   transmission of the metadata stored in the format handled by
   this plug-in.  If no such format is supported,
   nullwill be returned.

    The structure and contents of the `native` metadata format
   are defined by the plug-in that created this
   IIOMetadata object.  Plug-ins for simple formats
   will usually create a dummy node for the root, and then a
   series of child nodes representing individual tags, chunks, or
   keyword/value pairs.  A plug-in may choose whether or not to
   document its native format.

    The default implementation returns the value of the
   nativeMetadataFormatName instance variable.

  returns: the name of the native format, or null. - `java.lang.String`"
  (^java.lang.String [^IIOMetadata this]
    (-> this (.getNativeMetadataFormatName))))

(defn standard-metadata-format-supported?
  "Returns true if the standard metadata format is
   supported by getMetadataFormat,
   getAsTree, setFromTree, and
   mergeTree.

    The default implementation returns the value of the
   standardFormatSupported instance variable.

  returns: true if the standard metadata format
   is supported. - `boolean`"
  (^Boolean [^IIOMetadata this]
    (-> this (.isStandardMetadataFormatSupported))))

