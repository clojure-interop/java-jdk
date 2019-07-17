(ns javax.accessibility.AccessibleHyperlink
  "Encapsulation of a link, or set of links (e.g. client side imagemap)
  in a Hypertext document"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleHyperlink]))

(defn ->accessible-hyperlink
  "Constructor."
  ([]
    (new AccessibleHyperlink )))

(defn valid?
  "Since the document a link is associated with may have
   changed, this method returns whether or not this Link is still valid
   (with respect to the document it references).

  returns: a flag indicating whether this link is still valid with
           respect to the AccessibleHypertext it belongs to - `boolean`"
  (^Boolean [^javax.accessibility.AccessibleHyperlink this]
    (-> this (.isValid))))

(defn get-accessible-action-count
  "Returns the number of accessible actions available in this Link
   If there are more than one, the first one is NOT considered the
   `default` action of this LINK object (e.g. in an HTML imagemap).
   In general, links will have only one AccessibleAction in them.

  returns: the zero-based number of Actions in this object - `int`"
  (^Integer [^javax.accessibility.AccessibleHyperlink this]
    (-> this (.getAccessibleActionCount))))

(defn do-accessible-action
  "Performs the specified Action on the object

  i - zero-based index of actions - `int`

  returns: true if the action was performed; otherwise false. - `boolean`"
  (^Boolean [^javax.accessibility.AccessibleHyperlink this ^Integer i]
    (-> this (.doAccessibleAction i))))

(defn get-accessible-action-description
  "Returns a String description of this particular
   link action.  This should be a text string
   associated with anchoring text, this should be the
   anchor text.  E.g. from HTML:
     <a HREF=`http://www.sun.com/access`>Accessibility</a>
   this method would return `Accessibility`.

   Similarly, from this HTML:
     <a HREF=`#top`><img src=`top-hat.gif` alt=`top hat`></a>
   this method would return `top hat`

  i - zero-based index of the actions - `int`

  returns: a String description of the action - `java.lang.String`"
  (^java.lang.String [^javax.accessibility.AccessibleHyperlink this ^Integer i]
    (-> this (.getAccessibleActionDescription i))))

(defn get-accessible-action-object
  "Returns an object that represents the link action,
   as appropriate for that link.  E.g. from HTML:
     <a HREF=`http://www.sun.com/access`>Accessibility</a>
   this method would return a
   java.net.URL(`http://www.sun.com/access.html`);

  i - zero-based index of the actions - `int`

  returns: an Object representing the hypertext link itself - `java.lang.Object`"
  (^java.lang.Object [^javax.accessibility.AccessibleHyperlink this ^Integer i]
    (-> this (.getAccessibleActionObject i))))

(defn get-accessible-action-anchor
  "Returns an object that represents the link anchor,
   as appropriate for that link.  E.g. from HTML:
     <a href=`http://www.sun.com/access`>Accessibility</a>
   this method would return a String containing the text:
   `Accessibility`.

   Similarly, from this HTML:
     <a HREF=`#top`><img src=`top-hat.gif` alt=`top hat`></a>
   this might return the object ImageIcon(`top-hat.gif`, `top hat`);

  i - zero-based index of the actions - `int`

  returns: an Object representing the hypertext anchor - `java.lang.Object`"
  (^java.lang.Object [^javax.accessibility.AccessibleHyperlink this ^Integer i]
    (-> this (.getAccessibleActionAnchor i))))

(defn get-start-index
  "Gets the index with the hypertext document at which this
   link begins

  returns: index of start of link - `int`"
  (^Integer [^javax.accessibility.AccessibleHyperlink this]
    (-> this (.getStartIndex))))

(defn get-end-index
  "Gets the index with the hypertext document at which this
   link ends

  returns: index of end of link - `int`"
  (^Integer [^javax.accessibility.AccessibleHyperlink this]
    (-> this (.getEndIndex))))

