(ns javax.swing.JTree$DropLocation
  "A subclass of TransferHandler.DropLocation representing
  a drop location for a JTree."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing JTree$DropLocation]))

(defn get-child-index
  "Returns the index where the dropped data should be inserted
   with respect to the path returned by getPath().

   For drop modes DropMode.USE_SELECTION and
   DropMode.ON, this index is unimportant (and it will
   always be -1) as the only interesting data is the
   path over which the drop operation occurred.

   For drop mode DropMode.INSERT, this index
   indicates the index at which the data should be inserted into
   the parent path represented by getPath().
   -1 indicates that the drop occurred over the
   parent itself, and in most cases should be treated as inserting
   into either the beginning or the end of the parent's list of
   children.

   For DropMode.ON_OR_INSERT, this value will be
   an insert index, as described above, or -1 if
   the drop occurred over the path itself.

  returns: the child index - `int`"
  (^Integer [^javax.swing.JTree$DropLocation this]
    (-> this (.getChildIndex))))

(defn get-path
  "Returns the path where dropped data should be placed in the
   tree.

   Interpretation of this value depends on the drop mode set on the
   component. If the drop mode is DropMode.USE_SELECTION
   or DropMode.ON, the return value is the path in the
   tree over which the data has been (or will be) dropped.
   null indicates that the drop is over empty space,
   not associated with a particular path.

   If the drop mode is DropMode.INSERT, the return value
   refers to the path that should become the parent of the new data,
   in which case getChildIndex() indicates where the
   new item should be inserted into this parent path. A
   null path indicates that no parent path has been
   determined, which can happen for multiple reasons:

      The tree has no model
      There is no root in the tree
      The root is collapsed
      The root is a leaf node

   It is up to the developer to decide if and how they wish to handle
   the null case.

   If the drop mode is DropMode.ON_OR_INSERT,
   getChildIndex can be used to determine whether the
   drop is on top of the path itself (-1) or the index
   at which it should be inserted into the path (values other than
   -1).

  returns: the drop path - `javax.swing.tree.TreePath`"
  (^javax.swing.tree.TreePath [^javax.swing.JTree$DropLocation this]
    (-> this (.getPath))))

(defn to-string
  "Returns a string representation of this drop location.
   This method is intended to be used for debugging purposes,
   and the content and format of the returned string may vary
   between implementations.

  returns: a string representation of this drop location - `java.lang.String`"
  (^java.lang.String [^javax.swing.JTree$DropLocation this]
    (-> this (.toString))))

