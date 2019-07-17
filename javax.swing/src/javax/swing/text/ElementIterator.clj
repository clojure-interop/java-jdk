(ns javax.swing.text.ElementIterator
  " ElementIterator, as the name suggests, iterates over the Element
  tree.  The constructor can be invoked with either Document or an Element
  as an argument.  If the constructor is invoked with a Document as an
  argument then the root of the iteration is the return value of
  document.getDefaultRootElement().

  The iteration happens in a depth-first manner.  In terms of how
  boundary conditions are handled:
  a) if next() is called before first() or current(), the
     root will be returned.
  b) next() returns null to indicate the end of the list.
  c) previous() returns null when the current element is the root
     or next() has returned null.

  The ElementIterator does no locking of the Element tree. This means
  that it does not track any changes.  It is the responsibility of the
  user of this class, to ensure that no changes happen during element
  iteration.

  Simple usage example:

     public void iterate() {
         ElementIterator it = new ElementIterator(root);
         Element elem;
         while (true) {
            if ((elem = next()) != null) {
                // process element
                System.out.println(`elem: `  elem.getName());
            } else {
                break;
            }
         }
     }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text ElementIterator]))

(defn ->element-iterator
  "Constructor.

  Creates a new ElementIterator. The
   root element is taken to get the
   default root element of the document.

  document - a Document. - `javax.swing.text.Document`"
  ([document]
    (new ElementIterator document)))

(defn clone
  "Clones the ElementIterator.

  returns: a cloned ElementIterator Object. - `java.lang.Object`"
  ([this]
    (-> this (.clone))))

(defn first
  "Fetches the first element.

  returns: an Element. - `javax.swing.text.Element`"
  ([this]
    (-> this (.first))))

(defn depth
  "Fetches the current depth of element tree.

  returns: the depth. - `int`"
  ([this]
    (-> this (.depth))))

(defn current
  "Fetches the current Element.

  returns: element on top of the stack or
            null if the root element is null - `javax.swing.text.Element`"
  ([this]
    (-> this (.current))))

(defn next
  "Fetches the next Element. The strategy
   used to locate the next element is
   a depth-first search.

  returns: the next element or null
            at the end of the list. - `javax.swing.text.Element`"
  ([this]
    (-> this (.next))))

(defn previous
  "Fetches the previous Element. If however the current
   element is the last element, or the current element
   is null, then null is returned.

  returns: previous Element if available - `javax.swing.text.Element`"
  ([this]
    (-> this (.previous))))

