(ns jdk.beans.PropertyEditorManager
  "The PropertyEditorManager can be used to locate a property editor for
  any given type name.  This property editor must support the
  java.beans.PropertyEditor interface for editing a given object.

  The PropertyEditorManager uses three techniques for locating an editor
  for a given type.  First, it provides a registerEditor method to allow
  an editor to be specifically registered for a given type.  Second it
  tries to locate a suitable class by adding `Editor` to the full
  qualified classname of the given type (e.g. `foo.bah.FozEditor`).
  Finally it takes the simple classname (without the package name) adds
  `Editor` to it and looks in a search-path of packages for a matching
  class.

  So for an input class foo.bah.Fred, the PropertyEditorManager would
  first look in its tables to see if an editor had been registered for
  foo.bah.Fred and if so use that.  Then it will look for a
  foo.bah.FredEditor class.  Then it will look for (say)
  standardEditorsPackage.FredEditor class.

  Default PropertyEditors will be provided for the Java primitive types
  `boolean`, `byte`, `short`, `int`, `long`, `float`, and `double`; and
  for the classes java.lang.String. java.awt.Color, and java.awt.Font."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.beans PropertyEditorManager]))

(defn ->property-editor-manager
  "Constructor."
  (^PropertyEditorManager []
    (new PropertyEditorManager )))

(defn *register-editor
  "Registers an editor class to edit values of the given target class.
   If the editor class is null,
   then any existing definition will be removed.
   Thus this method can be used to cancel the registration.
   The registration is canceled automatically
   if either the target or editor class is unloaded.

   If there is a security manager, its checkPropertiesAccess
   method is called. This could result in a java.lang.SecurityException.

  target-type - the class object of the type to be edited - `java.lang.Class`
  editor-class - the class object of the editor class - `java.lang.Class`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow setting of system properties"
  ([^java.lang.Class target-type ^java.lang.Class editor-class]
    (PropertyEditorManager/registerEditor target-type editor-class)))

(defn *find-editor
  "Locate a value editor for a given target type.

  target-type - The Class object for the type to be edited - `java.lang.Class`

  returns: An editor object for the given target class.
   The result is null if no suitable editor can be found. - `java.beans.PropertyEditor`"
  (^java.beans.PropertyEditor [^java.lang.Class target-type]
    (PropertyEditorManager/findEditor target-type)))

(defn *get-editor-search-path
  "Gets the package names that will be searched for property editors.

  returns: The array of package names that will be searched in
            order to find property editors.
        The default value for this array is implementation-dependent,
           e.g. Sun implementation initially sets to  {`sun.beans.editors`}. - `java.lang.String[]`"
  ([]
    (PropertyEditorManager/getEditorSearchPath )))

(defn *set-editor-search-path
  "Change the list of package names that will be used for
            finding property editors.

   First, if there is a security manager, its checkPropertiesAccess
   method is called. This could result in a SecurityException.

  path - Array of package names. - `java.lang.String[]`

  throws: java.lang.SecurityException - if a security manager exists and its checkPropertiesAccess method doesn't allow setting of system properties."
  ([path]
    (PropertyEditorManager/setEditorSearchPath path)))

