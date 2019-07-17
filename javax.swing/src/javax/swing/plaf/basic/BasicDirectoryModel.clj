(ns javax.swing.plaf.basic.BasicDirectoryModel
  "Basic implementation of a file list."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.plaf.basic BasicDirectoryModel]))

(defn ->basic-directory-model
  "Constructor.

  filechooser - `javax.swing.JFileChooser`"
  ([filechooser]
    (new BasicDirectoryModel filechooser)))

(defn get-files
  "returns: `java.util.Vector<java.io.File>`"
  ([this]
    (-> this (.getFiles))))

(defn rename-file
  "Renames a file in the underlying file system.

  old-file - a File object representing the existing file - `java.io.File`
  new-file - a File object representing the desired new file name - `java.io.File`

  returns: true if rename succeeded,
          otherwise false - `boolean`"
  ([this old-file new-file]
    (-> this (.renameFile old-file new-file))))

(defn validate-file-cache
  ""
  ([this]
    (-> this (.validateFileCache))))

(defn contains
  "o - `java.lang.Object`

  returns: `boolean`"
  ([this o]
    (-> this (.contains o))))

(defn invalidate-file-cache
  "This method is used to interrupt file loading thread."
  ([this]
    (-> this (.invalidateFileCache))))

(defn property-change
  "Description copied from interface: PropertyChangeListener

  e - A PropertyChangeEvent object describing the event source and the property that has changed. - `java.beans.PropertyChangeEvent`"
  ([this e]
    (-> this (.propertyChange e))))

(defn get-element-at
  "Description copied from interface: ListModel

  index - the requested index - `int`

  returns: the value at index - `java.lang.Object`"
  ([this index]
    (-> this (.getElementAt index))))

(defn remove-property-change-listener
  "Removes a PropertyChangeListener from the listener list.

   If listener is null, no exception is thrown and no action is performed.

  listener - the PropertyChangeListener to be removed - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.removePropertyChangeListener listener))))

(defn fire-contents-changed
  ""
  ([this]
    (-> this (.fireContentsChanged))))

(defn get-property-change-listeners
  "Returns an array of all the property change listeners
   registered on this component.

  returns: all of this component's PropertyChangeListeners
           or an empty array if no property change
           listeners are currently registered - `java.beans.PropertyChangeListener[]`"
  ([this]
    (-> this (.getPropertyChangeListeners))))

(defn interval-added
  "Obsolete - not used.

  e - `javax.swing.event.ListDataEvent`"
  ([this e]
    (-> this (.intervalAdded e))))

(defn get-directories
  "returns: `java.util.Vector<java.io.File>`"
  ([this]
    (-> this (.getDirectories))))

(defn interval-removed
  "Obsolete - not used.

  e - `javax.swing.event.ListDataEvent`"
  ([this e]
    (-> this (.intervalRemoved e))))

(defn index-of
  "o - `java.lang.Object`

  returns: `int`"
  ([this o]
    (-> this (.indexOf o))))

(defn add-property-change-listener
  "Adds a PropertyChangeListener to the listener list. The listener is
   registered for all bound properties of this class.

   If listener is null,
   no exception is thrown and no action is performed.

  listener - the property change listener to be added - `java.beans.PropertyChangeListener`"
  ([this listener]
    (-> this (.addPropertyChangeListener listener))))

(defn get-size
  "Description copied from interface: ListModel

  returns: the length of the list - `int`"
  ([this]
    (-> this (.getSize))))

