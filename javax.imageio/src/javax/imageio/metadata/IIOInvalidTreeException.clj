(ns javax.imageio.metadata.IIOInvalidTreeException
  "An IIOInvalidTreeException is thrown when an attempt
  by an IIOMetadata object to parse a tree of
  IIOMetadataNodes fails.  The node that led to the
  parsing error may be stored.  As with any parsing error, the actual
  error may occur at a different point that that where it is
  detected.  The node returned by getOffendingNode
  should merely be considered as a clue to the actual nature of the
  problem."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.imageio.metadata IIOInvalidTreeException]))

(defn ->iio-invalid-tree-exception
  "Constructor.

  Constructs an IIOInvalidTreeException with a
   message string, a reference to an exception that caused this
   exception, and a reference to the Node that caused
   the parsing error.

  message - a String containing the reason for the parsing failure. - `java.lang.String`
  cause - the Throwable (Error or Exception) that caused this exception to occur, or null. - `java.lang.Throwable`
  offending-node - the DOM Node that caused the exception, or null. - `org.w3c.dom.Node`"
  ([^java.lang.String message ^java.lang.Throwable cause ^org.w3c.dom.Node offending-node]
    (new IIOInvalidTreeException message cause offending-node))
  ([^java.lang.String message ^org.w3c.dom.Node offending-node]
    (new IIOInvalidTreeException message offending-node)))

(defn get-offending-node
  "Returns the Node that caused the error in parsing.

  returns: the offending Node. - `org.w3c.dom.Node`"
  ([^javax.imageio.metadata.IIOInvalidTreeException this]
    (-> this (.getOffendingNode))))

