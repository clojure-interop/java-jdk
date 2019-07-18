(ns javax.accessibility.AccessibleHypertext
  "The AccessibleHypertext class is the base class for all
  classes that present hypertext information on the display.  This class
  provides the standard mechanism for an assistive technology to access
  that text via its content, attributes, and spatial location.
  It also provides standard mechanisms for manipulating hyperlinks.
  Applications can determine if an object supports the AccessibleHypertext
  interface by first obtaining its AccessibleContext (see Accessible)
  and then calling the AccessibleContext.getAccessibleText()
  method of AccessibleContext.  If the return value is a class which extends
  AccessibleHypertext, then that object supports AccessibleHypertext."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.accessibility AccessibleHypertext]))

(defn get-link-count
  "Returns the number of links within this hypertext document.

  returns: number of links in this hypertext doc. - `int`"
  (^Integer [^AccessibleHypertext this]
    (-> this (.getLinkCount))))

(defn get-link
  "Returns the nth Link of this Hypertext document.

  link-index - within the links of this Hypertext - `int`

  returns: Link object encapsulating the nth link(s) - `javax.accessibility.AccessibleHyperlink`"
  (^javax.accessibility.AccessibleHyperlink [^AccessibleHypertext this ^Integer link-index]
    (-> this (.getLink link-index))))

(defn get-link-index
  "Returns the index into an array of hyperlinks that
   is associated with this character index, or -1 if there
   is no hyperlink associated with this index.

  char-index - index within the text - `int`

  returns: index into the set of hyperlinks for this hypertext doc. - `int`"
  (^Integer [^AccessibleHypertext this ^Integer char-index]
    (-> this (.getLinkIndex char-index))))

