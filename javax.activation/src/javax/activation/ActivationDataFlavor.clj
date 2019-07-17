(ns javax.activation.ActivationDataFlavor
  "The ActivationDataFlavor class is a special subclass of
  java.awt.datatransfer.DataFlavor. It allows the JAF to
  set all three values stored by the DataFlavor class via a new
  constructor. It also contains improved MIME parsing in the equals
   method. Except for the improved parsing, its semantics are
  identical to that of the JDK's DataFlavor class."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.activation ActivationDataFlavor]))

(defn ->activation-data-flavor
  "Constructor.

  Construct a DataFlavor that represents an arbitrary
   Java object. This constructor is an extension of the
   JDK's DataFlavor in that it allows the explicit setting
   of all three DataFlavor attributes.

   The returned DataFlavor will have the following characteristics:

   representationClass = representationClass
   mimeType            = mimeType
   humanName           = humanName

  representation-class - the class used in this DataFlavor - `java.lang.Class`
  mime-type - the MIME type of the data represented by this class - `java.lang.String`
  human-presentable-name - the human presentable name of the flavor - `java.lang.String`"
  ([^java.lang.Class representation-class ^java.lang.String mime-type ^java.lang.String human-presentable-name]
    (new ActivationDataFlavor representation-class mime-type human-presentable-name))
  ([^java.lang.Class representation-class ^java.lang.String human-presentable-name]
    (new ActivationDataFlavor representation-class human-presentable-name)))

(defn get-mime-type
  "Return the MIME type for this DataFlavor.

  returns: the MIME type - `java.lang.String`"
  ([^javax.activation.ActivationDataFlavor this]
    (-> this (.getMimeType))))

(defn get-representation-class
  "Return the representation class.

  returns: the representation class - `java.lang.Class`"
  ([^javax.activation.ActivationDataFlavor this]
    (-> this (.getRepresentationClass))))

(defn get-human-presentable-name
  "Return the Human Presentable name.

  returns: the human presentable name - `java.lang.String`"
  ([^javax.activation.ActivationDataFlavor this]
    (-> this (.getHumanPresentableName))))

(defn set-human-presentable-name
  "Set the human presentable name.

  human-presentable-name - the name to set - `java.lang.String`"
  ([^javax.activation.ActivationDataFlavor this ^java.lang.String human-presentable-name]
    (-> this (.setHumanPresentableName human-presentable-name))))

(defn equals
  "Compares the DataFlavor passed in with this DataFlavor; calls
   the isMimeTypeEqual method.

  data-flavor - the DataFlavor to compare with - `java.awt.datatransfer.DataFlavor`

  returns: true if the MIME type and representation class
                            are the same - `boolean`"
  ([^javax.activation.ActivationDataFlavor this ^java.awt.datatransfer.DataFlavor data-flavor]
    (-> this (.equals data-flavor))))

(defn mime-type-equal?
  "Is the string representation of the MIME type passed in equivalent
   to the MIME type of this DataFlavor.

   ActivationDataFlavor delegates the comparison of MIME types to
   the MimeType class included as part of the JavaBeans Activation
   Framework. This provides a more robust comparison than is normally
   available in the DataFlavor class.

  mime-type - the MIME type - `java.lang.String`

  returns: true if the same MIME type - `boolean`"
  ([^javax.activation.ActivationDataFlavor this ^java.lang.String mime-type]
    (-> this (.isMimeTypeEqual mime-type))))

