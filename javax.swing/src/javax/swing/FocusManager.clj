(ns javax.swing.FocusManager
  "This class has been obsoleted by the 1.4 focus APIs. While client code may
  still use this class, developers are strongly encouraged to use
  java.awt.KeyboardFocusManager and
  java.awt.DefaultKeyboardFocusManager instead.

  Please see

  How to Use the Focus Subsystem,
  a section in The Java Tutorial, and the
  Focus Specification
  for more information."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing FocusManager]))

(defn ->focus-manager
  "Constructor."
  ([]
    (new FocusManager )))

(def *-focus-manager-class-property
  "Static Constant.

  This field is obsolete, and its use is discouraged since its
   specification is incompatible with the 1.4 focus APIs.
   The current FocusManager is no longer a property of the UI.
   Client code must query for the current FocusManager using
   KeyboardFocusManager.getCurrentKeyboardFocusManager().
   See the Focus Specification for more information.

  type: java.lang.String"
  FocusManager/FOCUS_MANAGER_CLASS_PROPERTY)

(defn *get-current-manager
  "Returns the current KeyboardFocusManager instance
   for the calling thread's context.

  returns: this thread's context's KeyboardFocusManager - `javax.swing.FocusManager`"
  ([]
    (FocusManager/getCurrentManager )))

(defn *set-current-manager
  "Sets the current KeyboardFocusManager instance
   for the calling thread's context. If null is
   specified, then the current KeyboardFocusManager
   is replaced with a new instance of
   DefaultKeyboardFocusManager.

   If a SecurityManager is installed,
   the calling thread must be granted the AWTPermission
   `replaceKeyboardFocusManager` in order to replace the
   the current KeyboardFocusManager.
   If this permission is not granted,
   this method will throw a SecurityException,
   and the current KeyboardFocusManager will be unchanged.

  a-focus-manager - the new KeyboardFocusManager for this thread's context - `javax.swing.FocusManager`

  throws: java.lang.SecurityException - if the calling thread does not have permission to replace the current KeyboardFocusManager"
  ([^javax.swing.FocusManager a-focus-manager]
    (FocusManager/setCurrentManager a-focus-manager)))

(defn *disable-swing-focus-manager
  "Deprecated. as of 1.4, replaced by
   KeyboardFocusManager.setDefaultFocusTraversalPolicy(FocusTraversalPolicy)

  returns: `java.lang.   void`"
  ([]
    (FocusManager/disableSwingFocusManager )))

(defn *is-focus-manager-enabled
  "Deprecated. As of 1.4, replaced by
     KeyboardFocusManager.getDefaultFocusTraversalPolicy()

  returns: `java.lang.   boolean`"
  ([]
    (FocusManager/isFocusManagerEnabled )))

