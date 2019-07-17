(ns javax.management.AttributeList
  "Represents a list of values for attributes of an MBean.  See the
  getAttributes and
  setAttributes methods of
  MBeanServer and MBeanServerConnection.

  For compatibility reasons, it is possible, though
  highly discouraged, to add objects to an AttributeList that are
  not instances of Attribute.  However, an AttributeList
  can be made type-safe, which means that an attempt to add
  an object that is not an Attribute will produce an IllegalArgumentException.  An AttributeList becomes type-safe
  when the method asList() is called on it."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.management AttributeList]))

(defn ->attribute-list
  "Constructor.

  Constructs an empty AttributeList with
   the initial capacity specified.

  initial-capacity - the initial capacity of the AttributeList, as specified by ArrayList.ArrayList(int). - `int`"
  ([^Integer initial-capacity]
    (new AttributeList initial-capacity))
  ([]
    (new AttributeList )))

(defn as-list
  "Return a view of this list as a List<Attribute>.
   Changes to the returned value are reflected by changes
   to the original AttributeList and vice versa.

  returns: a List<Attribute> whose contents
   reflect the contents of this AttributeList.

   If this method has ever been called on a given
   AttributeList instance, a subsequent attempt to add
   an object to that instance which is not an Attribute
   will fail with a IllegalArgumentException. For compatibility
   reasons, an AttributeList on which this method has never
   been called does allow objects other than Attributes to
   be added. - `java.util.List<javax.management.Attribute>`

  throws: java.lang.IllegalArgumentException - if this AttributeList contains an element that is not an Attribute."
  ([^javax.management.AttributeList this]
    (-> this (.asList))))

(defn add
  "Inserts the attribute specified as an element at the position specified.
   Elements with an index greater than or equal to the current position are
   shifted up. If the index is out of range (index < 0 || index >
   size()) a RuntimeOperationsException should be raised, wrapping the
   java.lang.IndexOutOfBoundsException thrown.

  index - The position in the list where the new Attribute object is to be inserted. - `int`
  object - The Attribute object to be inserted. - `javax.management.Attribute`"
  ([^javax.management.AttributeList this ^Integer index ^javax.management.Attribute object]
    (-> this (.add index object)))
  ([^javax.management.AttributeList this ^javax.management.Attribute object]
    (-> this (.add object))))

(defn set
  "Sets the element at the position specified to be the attribute specified.
   The previous element at that position is discarded. If the index is
   out of range (index < 0 || index > size()) a RuntimeOperationsException
   should be raised, wrapping the java.lang.IndexOutOfBoundsException thrown.

  index - The position specified. - `int`
  object - The value to which the attribute element should be set. - `javax.management.Attribute`"
  ([^javax.management.AttributeList this ^Integer index ^javax.management.Attribute object]
    (-> this (.set index object))))

(defn add-all
  "Inserts all of the elements in the AttributeList specified
   into this list, starting at the specified position, in the order in which
   they are returned by the Iterator of the AttributeList specified.
   If the index is out of range (index < 0 || index > size()) a
   RuntimeOperationsException should be raised, wrapping the
   java.lang.IndexOutOfBoundsException thrown.

  index - Position at which to insert the first element from the AttributeList specified. - `int`
  list - Elements to be inserted into the list. - `javax.management.AttributeList`

  returns: true if this list changed as a result of the call. - `boolean`"
  ([^javax.management.AttributeList this ^Integer index ^javax.management.AttributeList list]
    (-> this (.addAll index list)))
  ([^javax.management.AttributeList this ^javax.management.AttributeList list]
    (-> this (.addAll list))))

