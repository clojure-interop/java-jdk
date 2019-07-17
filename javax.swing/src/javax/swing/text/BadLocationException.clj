(ns javax.swing.text.BadLocationException
  "This exception is to report bad locations within a document model
  (that is, attempts to reference a location that doesn't exist).

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text BadLocationException]))

(defn ->bad-location-exception
  "Constructor.

  Creates a new BadLocationException object.

  s - a string indicating what was wrong with the arguments - `java.lang.String`
  offs - offset within the document that was requested >= 0 - `int`"
  ([s offs]
    (new BadLocationException s offs)))

(defn offset-requested
  "Returns the offset into the document that was not legal.

  returns: the offset >= 0 - `int`"
  ([this]
    (-> this (.offsetRequested))))

