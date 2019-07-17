(ns javax.swing.event.DocumentEvent
  "Interface for document change notifications.  This provides
  detailed information to Document observers about how the
  Document changed.  It provides high level information such
  as type of change and where it occurred, as well as the more
  detailed structural changes (What Elements were inserted and
  removed)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event DocumentEvent]))

(defn get-offset
  "Returns the offset within the document of the start
   of the change.

  returns: the offset >= 0 - `int`"
  ([^javax.swing.event.DocumentEvent this]
    (-> this (.getOffset))))

(defn get-length
  "Returns the length of the change.

  returns: the length >= 0 - `int`"
  ([^javax.swing.event.DocumentEvent this]
    (-> this (.getLength))))

(defn get-document
  "Gets the document that sourced the change event.

  returns: the document - `javax.swing.text.Document`"
  ([^javax.swing.event.DocumentEvent this]
    (-> this (.getDocument))))

(defn get-type
  "Gets the type of event.

  returns: the type - `javax.swing.event.DocumentEvent.EventType`"
  ([^javax.swing.event.DocumentEvent this]
    (-> this (.getType))))

(defn get-change
  "Gets the change information for the given element.
   The change information describes what elements were
   added and removed and the location.  If there were
   no changes, null is returned.

   This method is for observers to discover the structural
   changes that were made.  This means that only elements
   that existed prior to the mutation (and still exist after
   the mutation) need to have ElementChange records.
   The changes made available need not be recursive.

   For example, if the an element is removed from it's
   parent, this method should report that the parent
   changed and provide an ElementChange implementation
   that describes the change to the parent.  If the
   child element removed had children, these elements
   do not need to be reported as removed.

   If an child element is insert into a parent element,
   the parent element should report a change.  If the
   child element also had elements inserted into it
   (grandchildren to the parent) these elements need
   not report change.

  elem - the element - `javax.swing.text.Element`

  returns: the change information, or null if the
     element was not modified - `javax.swing.event.DocumentEvent.ElementChange`"
  ([^javax.swing.event.DocumentEvent this ^javax.swing.text.Element elem]
    (-> this (.getChange elem))))

