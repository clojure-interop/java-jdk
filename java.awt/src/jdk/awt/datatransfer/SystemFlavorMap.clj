(ns jdk.awt.datatransfer.SystemFlavorMap
  "The SystemFlavorMap is a configurable map between `natives` (Strings), which
  correspond to platform-specific data formats, and `flavors` (DataFlavors),
  which correspond to platform-independent MIME types. This mapping is used
  by the data transfer subsystem to transfer data between Java and native
  applications, and between Java applications in separate VMs."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.datatransfer SystemFlavorMap]))

(defn *get-default-flavor-map
  "Returns the default FlavorMap for this thread's ClassLoader.

  returns: `java.awt.datatransfer.FlavorMap`"
  ([]
    (SystemFlavorMap/getDefaultFlavorMap )))

(defn *encode-java-mime-type
  "Encodes a MIME type for use as a String native. The format
   of an encoded representation of a MIME type is implementation-dependent.
   The only restrictions are:

   The encoded representation is null if and only if the
   MIME type String is null.
   The encoded representations for two non-null MIME type
   Strings are equal if and only if these Strings
   are equal according to String.equals(Object).


   The reference implementation of this method returns the specified MIME
   type String prefixed with JAVA_DATAFLAVOR:.

  mime-type - the MIME type to encode - `java.lang.String`

  returns: the encoded String, or null if
           mimeType is null - `java.lang.String`"
  ([^java.lang.String mime-type]
    (SystemFlavorMap/encodeJavaMIMEType mime-type)))

(defn *encode-data-flavor
  "Encodes a DataFlavor for use as a String
   native. The format of an encoded DataFlavor is
   implementation-dependent. The only restrictions are:

   The encoded representation is null if and only if the
   specified DataFlavor is null or its MIME type
   String is null.
   The encoded representations for two non-null
   DataFlavors with non-null MIME type
   Strings are equal if and only if the MIME type
   Strings of these DataFlavors are equal
   according to String.equals(Object).


   The reference implementation of this method returns the MIME type
   String of the specified DataFlavor prefixed
   with JAVA_DATAFLAVOR:.

  flav - the DataFlavor to encode - `java.awt.datatransfer.DataFlavor`

  returns: the encoded String, or null if
           flav is null or has a null MIME type - `java.lang.String`"
  ([^java.awt.datatransfer.DataFlavor flav]
    (SystemFlavorMap/encodeDataFlavor flav)))

(defn *java-mime-type?
  "Returns whether the specified String is an encoded Java
   MIME type.

  str - the String to test - `java.lang.String`

  returns: true if the String is encoded;
           false otherwise - `boolean`"
  ([^java.lang.String str]
    (SystemFlavorMap/isJavaMIMEType str)))

(defn *decode-java-mime-type
  "Decodes a String native for use as a Java MIME type.

  nat - the String to decode - `java.lang.String`

  returns: the decoded Java MIME type, or null if nat is not
           an encoded String native - `java.lang.String`"
  ([^java.lang.String nat]
    (SystemFlavorMap/decodeJavaMIMEType nat)))

(defn *decode-data-flavor
  "Decodes a String native for use as a
   DataFlavor.

  nat - the String to decode - `java.lang.String`

  returns: the decoded DataFlavor, or null if
           nat is not an encoded String native - `java.awt.datatransfer.DataFlavor`

  throws: java.lang.ClassNotFoundException"
  ([^java.lang.String nat]
    (SystemFlavorMap/decodeDataFlavor nat)))

(defn get-natives-for-flavor
  "Returns a List of String natives to which the
   specified DataFlavor can be translated by the data transfer
   subsystem. The List will be sorted from best native to
   worst. That is, the first native will best reflect data in the specified
   flavor to the underlying native platform.

   If the specified DataFlavor is previously unknown to the
   data transfer subsystem and the data transfer subsystem is unable to
   translate this DataFlavor to any existing native, then
   invoking this method will establish a
   mapping in both directions between the specified DataFlavor
   and an encoded version of its MIME type as its native.

  flav - the DataFlavor whose corresponding natives should be returned. If null is specified, all natives currently known to the data transfer subsystem are returned in a non-deterministic order. - `java.awt.datatransfer.DataFlavor`

  returns: a java.util.List of java.lang.String
           objects which are platform-specific representations of platform-
           specific data formats - `java.util.List<java.lang.String>`"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.awt.datatransfer.DataFlavor flav]
    (-> this (.getNativesForFlavor flav))))

(defn get-flavors-for-native
  "Returns a List of DataFlavors to which the
   specified String native can be translated by the data
   transfer subsystem. The List will be sorted from best
   DataFlavor to worst. That is, the first
   DataFlavor will best reflect data in the specified
   native to a Java application.

   If the specified native is previously unknown to the data transfer
   subsystem, and that native has been properly encoded, then invoking this
   method will establish a mapping in both directions between the specified
   native and a DataFlavor whose MIME type is a decoded
   version of the native.

   If the specified native is not a properly encoded native and the
   mappings for this native have not been altered with
   setFlavorsForNative, then the contents of the
   List is platform dependent, but null
   cannot be returned.

  nat - the native whose corresponding DataFlavors should be returned. If null is specified, all DataFlavors currently known to the data transfer subsystem are returned in a non-deterministic order. - `java.lang.String`

  returns: a java.util.List of DataFlavor
           objects into which platform-specific data in the specified,
           platform-specific native can be translated - `java.util.List<java.awt.datatransfer.DataFlavor>`"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.lang.String nat]
    (-> this (.getFlavorsForNative nat))))

(defn get-natives-for-flavors
  "Returns a Map of the specified DataFlavors to
   their most preferred String native. Each native value will
   be the same as the first native in the List returned by
   getNativesForFlavor for the specified flavor.

   If a specified DataFlavor is previously unknown to the
   data transfer subsystem, then invoking this method will establish a
   mapping in both directions between the specified DataFlavor
   and an encoded version of its MIME type as its native.

  flavors - an array of DataFlavors which will be the key set of the returned Map. If null is specified, a mapping of all DataFlavors known to the data transfer subsystem to their most preferred String natives will be returned. - `java.awt.datatransfer.DataFlavor[]`

  returns: a java.util.Map of DataFlavors to
           String natives - `java.util.Map<java.awt.datatransfer.DataFlavor,java.lang.String>`"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.awt.datatransfer.DataFlavor[] flavors]
    (-> this (.getNativesForFlavors flavors))))

(defn get-flavors-for-natives
  "Returns a Map of the specified String natives
   to their most preferred DataFlavor. Each
   DataFlavor value will be the same as the first
   DataFlavor in the List returned by
   getFlavorsForNative for the specified native.

   If a specified native is previously unknown to the data transfer
   subsystem, and that native has been properly encoded, then invoking this
   method will establish a mapping in both directions between the specified
   native and a DataFlavor whose MIME type is a decoded
   version of the native.

  natives - an array of Strings which will be the key set of the returned Map. If null is specified, a mapping of all supported String natives to their most preferred DataFlavors will be returned. - `java.lang.String[]`

  returns: a java.util.Map of String natives to
           DataFlavors - `java.util.Map<java.lang.String,java.awt.datatransfer.DataFlavor>`"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.lang.String[] natives]
    (-> this (.getFlavorsForNatives natives))))

(defn add-unencoded-native-for-flavor
  "Adds a mapping from the specified DataFlavor (and all
   DataFlavors equal to the specified DataFlavor)
   to the specified String native.
   Unlike getNativesForFlavor, the mapping will only be
   established in one direction, and the native will not be encoded. To
   establish a two-way mapping, call
   addFlavorForUnencodedNative as well. The new mapping will
   be of lower priority than any existing mapping.
   This method has no effect if a mapping from the specified or equal
   DataFlavor to the specified String native
   already exists.

  flav - the DataFlavor key for the mapping - `java.awt.datatransfer.DataFlavor`
  nat - the String native value for the mapping - `java.lang.String`

  throws: java.lang.NullPointerException - if flav or nat is null"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.awt.datatransfer.DataFlavor flav ^java.lang.String nat]
    (-> this (.addUnencodedNativeForFlavor flav nat))))

(defn set-natives-for-flavor
  "Discards the current mappings for the specified DataFlavor
   and all DataFlavors equal to the specified
   DataFlavor, and creates new mappings to the
   specified String natives.
   Unlike getNativesForFlavor, the mappings will only be
   established in one direction, and the natives will not be encoded. To
   establish two-way mappings, call setFlavorsForNative
   as well. The first native in the array will represent the highest
   priority mapping. Subsequent natives will represent mappings of
   decreasing priority.

   If the array contains several elements that reference equal
   String natives, this method will establish new mappings
   for the first of those elements and ignore the rest of them.

   It is recommended that client code not reset mappings established by the
   data transfer subsystem. This method should only be used for
   application-level mappings.

  flav - the DataFlavor key for the mappings - `java.awt.datatransfer.DataFlavor`
  natives - the String native values for the mappings - `java.lang.String[]`

  throws: java.lang.NullPointerException - if flav or natives is null or if natives contains null elements"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.awt.datatransfer.DataFlavor flav ^java.lang.String[] natives]
    (-> this (.setNativesForFlavor flav natives))))

(defn add-flavor-for-unencoded-native
  "Adds a mapping from a single String native to a single
   DataFlavor. Unlike getFlavorsForNative, the
   mapping will only be established in one direction, and the native will
   not be encoded. To establish a two-way mapping, call
   addUnencodedNativeForFlavor as well. The new mapping will
   be of lower priority than any existing mapping.
   This method has no effect if a mapping from the specified
   String native to the specified or equal
   DataFlavor already exists.

  nat - the String native key for the mapping - `java.lang.String`
  flav - the DataFlavor value for the mapping - `java.awt.datatransfer.DataFlavor`

  throws: java.lang.NullPointerException - if nat or flav is null"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.lang.String nat ^java.awt.datatransfer.DataFlavor flav]
    (-> this (.addFlavorForUnencodedNative nat flav))))

(defn set-flavors-for-native
  "Discards the current mappings for the specified String
   native, and creates new mappings to the specified
   DataFlavors. Unlike getFlavorsForNative, the
   mappings will only be established in one direction, and the natives need
   not be encoded. To establish two-way mappings, call
   setNativesForFlavor as well. The first
   DataFlavor in the array will represent the highest priority
   mapping. Subsequent DataFlavors will represent mappings of
   decreasing priority.

   If the array contains several elements that reference equal
   DataFlavors, this method will establish new mappings
   for the first of those elements and ignore the rest of them.

   It is recommended that client code not reset mappings established by the
   data transfer subsystem. This method should only be used for
   application-level mappings.

  nat - the String native key for the mappings - `java.lang.String`
  flavors - the DataFlavor values for the mappings - `java.awt.datatransfer.DataFlavor[]`

  throws: java.lang.NullPointerException - if nat or flavors is null or if flavors contains null elements"
  ([^java.awt.datatransfer.SystemFlavorMap this ^java.lang.String nat ^java.awt.datatransfer.DataFlavor[] flavors]
    (-> this (.setFlavorsForNative nat flavors))))

