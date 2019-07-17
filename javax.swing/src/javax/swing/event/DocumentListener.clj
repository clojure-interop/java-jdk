(ns javax.swing.event.DocumentListener
  "Interface for an observer to register to receive notifications
  of changes to a text document.

  The default implementation of
  the Document interface (AbstractDocument) supports asynchronous
  mutations.  If this feature is used (i.e. mutations are made
  from a thread other than the Swing event thread), the listeners
  will be notified via the mutating thread.  This means that
  if asynchronous updates are made, the implementation of this
  interface must be threadsafe!

  The DocumentEvent notification is based upon the JavaBeans
  event model.  There is no guarantee about the order of delivery
  to listeners, and all listeners must be notified prior to making
  further mutations to the Document.  This means implementations
  of the DocumentListener may not mutate the source of the event
  (i.e. the associated Document)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event DocumentListener]))

(defn insert-update
  "Gives notification that there was an insert into the document.  The
   range given by the DocumentEvent bounds the freshly inserted region.

  e - the document event - `javax.swing.event.DocumentEvent`"
  ([this e]
    (-> this (.insertUpdate e))))

(defn remove-update
  "Gives notification that a portion of the document has been
   removed.  The range is given in terms of what the view last
   saw (that is, before updating sticky positions).

  e - the document event - `javax.swing.event.DocumentEvent`"
  ([this e]
    (-> this (.removeUpdate e))))

(defn changed-update
  "Gives notification that an attribute or set of attributes changed.

  e - the document event - `javax.swing.event.DocumentEvent`"
  ([this e]
    (-> this (.changedUpdate e))))

