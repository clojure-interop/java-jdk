(ns javax.swing.event.TreeModelEvent
  "Encapsulates information describing changes to a tree model, and
  used to notify tree model listeners of the change.
  For more information and examples see
  How to Write a Tree Model Listener,
  a section in The Java Tutorial.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.event TreeModelEvent]))

(defn ->tree-model-event
  "Constructor.

  Used to create an event when nodes have been changed, inserted, or
   removed, identifying the path to the parent of the modified items as
   an array of Objects. All of the modified objects are siblings which are
   direct descendents (not grandchildren) of the specified parent.
   The positions at which the inserts, deletes, or changes occurred are
   specified by an array of int. The indexes in that array
   must be in order, from lowest to highest.

   For changes, the indexes in the model correspond exactly to the indexes
   of items currently displayed in the UI. As a result, it is not really
   critical if the indexes are not in their exact order. But after multiple
   inserts or deletes, the items currently in the UI no longer correspond
   to the items in the model. It is therefore critical to specify the
   indexes properly for inserts and deletes.

   For inserts, the indexes represent the final state of the tree,
   after the inserts have occurred. Since the indexes must be specified in
   order, the most natural processing methodology is to do the inserts
   starting at the lowest index and working towards the highest. Accumulate
   a Vector of Integer objects that specify the
   insert-locations as you go, then convert the Vector to an
   array of int to create the event. When the postition-index
   equals zero, the node is inserted at the beginning of the list. When the
   position index equals the size of the list, the node is `inserted` at
   (appended to) the end of the list.

   For deletes, the indexes represent the initial state of the tree,
   before the deletes have occurred. Since the indexes must be specified in
   order, the most natural processing methodology is to use a delete-counter.
   Start by initializing the counter to zero and start work through the
   list from lowest to highest. Every time you do a delete, add the current
   value of the delete-counter to the index-position where the delete occurred,
   and append the result to a Vector of delete-locations, using
   addElement(). Then increment the delete-counter. The index
   positions stored in the Vector therefore reflect the effects of all previous
   deletes, so they represent each object's position in the initial tree.
   (You could also start at the highest index and working back towards the
   lowest, accumulating a Vector of delete-locations as you go using the
   insertElementAt(Integer, 0).) However you produce the Vector
   of initial-positions, you then need to convert the Vector of Integer
   objects to an array of int to create the event.

   Notes:
   Like the insertNodeInto method in the
      DefaultTreeModel class, insertElementAt
      appends to the Vector when the index matches the size
      of the vector. So you can use insertElementAt(Integer, 0)
      even when the vector is empty.
   To create a node changed event for the root node, specify the parent
       and the child indices as null.

  source - the Object responsible for generating the event (typically the creator of the event object passes this for its value) - `java.lang.Object`
  path - an array of Object identifying the path to the parent of the modified item(s), where the first element of the array is the Object stored at the root node and the last element is the Object stored at the parent node - `java.lang.Object[]`
  child-indices - an array of int that specifies the index values of the removed items. The indices must be in sorted order, from lowest to highest - `int[]`
  children - an array of Object containing the inserted, removed, or changed objects - `java.lang.Object[]`"
  ([source path child-indices children]
    (new TreeModelEvent source path child-indices children))
  ([source path]
    (new TreeModelEvent source path)))

(defn get-tree-path
  "For all events, except treeStructureChanged,
   returns the parent of the changed nodes.
   For treeStructureChanged events, returns the ancestor of the
   structure that has changed. This and
   getChildIndices are used to get a list of the effected
   nodes.

   The one exception to this is a treeNodesChanged event that is to
   identify the root, in which case this will return the root
   and getChildIndices will return null.

  returns: the TreePath used in identifying the changed nodes. - `javax.swing.tree.TreePath`"
  ([this]
    (-> this (.getTreePath))))

(defn get-path
  "Convenience method to get the array of objects from the TreePath
   instance that this event wraps.

  returns: an array of Objects, where the first Object is the one
           stored at the root and the last object is the one
           stored at the node identified by the path - `java.lang.Object[]`"
  ([this]
    (-> this (.getPath))))

(defn get-children
  "Returns the objects that are children of the node identified by
   getPath at the locations specified by
   getChildIndices. If this is a removal event the
   returned objects are no longer children of the parent node.

  returns: an array of Object containing the children specified by
           the event - `java.lang.Object[]`"
  ([this]
    (-> this (.getChildren))))

(defn get-child-indices
  "Returns the values of the child indexes. If this is a removal event
   the indexes point to locations in the initial list where items
   were removed. If it is an insert, the indices point to locations
   in the final list where the items were added. For node changes,
   the indices point to the locations of the modified nodes.

  returns: an array of int containing index locations for
           the children specified by the event - `int[]`"
  ([this]
    (-> this (.getChildIndices))))

(defn to-string
  "Returns a string that displays and identifies this object's
   properties.

  returns: a String representation of this object - `java.lang.String`"
  ([this]
    (-> this (.toString))))

