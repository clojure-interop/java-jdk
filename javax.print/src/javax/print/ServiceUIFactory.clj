(ns javax.print.ServiceUIFactory
  "Services may optionally provide UIs which allow different styles
  of interaction in different roles.
  One role may be end-user browsing and setting of print options.
  Another role may be administering the print service.

  Although the Print Service API does not presently provide standardised
  support for administering a print service, monitoring of the print
  service is possible and a UI may provide for private update mechanisms.

  The basic design intent is to allow applications to lazily locate and
  initialize services only when needed without any API dependencies
  except in an environment in which they are used.

  Swing UIs are preferred as they provide a more consistent L&F
  and can support accessibility APIs.

  Example usage:


   ServiceUIFactory factory = printService.getServiceUIFactory();
   if (factory != null) {
       JComponent swingui = (JComponent)factory.getUI(
                                          ServiceUIFactory.MAIN_UIROLE,
                                          ServiceUIFactory.JCOMPONENT_UI);
       if (swingui != null) {
           tabbedpane.add(`Custom UI`, swingui);
       }
   }"
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print ServiceUIFactory]))

(defn ->service-ui-factory
  "Constructor."
  ([]
    (new ServiceUIFactory )))

(def *-jcomponent-ui
  "Static Constant.

  Denotes a UI implemented as a Swing component.
   The value of the String is the fully qualified classname :
   `javax.swing.JComponent`.

  type: java.lang.String"
  ServiceUIFactory/JCOMPONENT_UI)

(def *-panel-ui
  "Static Constant.

  Denotes a UI implemented as an AWT panel.
   The value of the String is the fully qualified classname :
   `java.awt.Panel`

  type: java.lang.String"
  ServiceUIFactory/PANEL_UI)

(def *-dialog-ui
  "Static Constant.

  Denotes a UI implemented as an AWT dialog.
   The value of the String is the fully qualified classname :
   `java.awt.Dialog`

  type: java.lang.String"
  ServiceUIFactory/DIALOG_UI)

(def *-jdialog-ui
  "Static Constant.

  Denotes a UI implemented as a Swing dialog.
   The value of the String is the fully qualified classname :
   `javax.swing.JDialog`

  type: java.lang.String"
  ServiceUIFactory/JDIALOG_UI)

(def *-about-uirole
  "Static Constant.

  Denotes a UI which performs an informative `About` role.

  type: int"
  ServiceUIFactory/ABOUT_UIROLE)

(def *-admin-uirole
  "Static Constant.

  Denotes a UI which performs an administrative role.

  type: int"
  ServiceUIFactory/ADMIN_UIROLE)

(def *-main-uirole
  "Static Constant.

  Denotes a UI which performs the normal end user role.

  type: int"
  ServiceUIFactory/MAIN_UIROLE)

(def *-reserved-uirole
  "Static Constant.

  Not a valid role but role id's greater than this may be used
   for private roles supported by a service. Knowledge of the
   function performed by this role is required to make proper use
   of it.

  type: int"
  ServiceUIFactory/RESERVED_UIROLE)

(defn get-ui
  "Get a UI object which may be cast to the requested UI type
   by the application and used in its user interface.

  role - requested. Must be one of the standard roles or a private role supported by this factory. - `int`
  ui - type in which the role is requested. - `java.lang.String`

  returns: the UI role or null if the requested UI role is not available
   from this factory - `java.lang.Object`

  throws: java.lang.IllegalArgumentException - if the role or ui is neither one of the standard ones, nor a private one supported by the factory."
  (^java.lang.Object [^javax.print.ServiceUIFactory this ^Integer role ^java.lang.String ui]
    (-> this (.getUI role ui))))

(defn get-ui-class-names-for-role
  "Given a UI role obtained from this factory obtain the UI
   types available from this factory which implement this role.
   The returned Strings should refer to the static variables defined
   in this class so that applications can use equality of reference
   (`==`).

  role - to be looked up. - `int`

  returns: the UI types supported by this class for the specified role,
   null if no UIs are available for the role. - `java.lang.String[]`

  throws: java.lang.IllegalArgumentException - is the role is a non-standard role not supported by this factory."
  ([^javax.print.ServiceUIFactory this ^Integer role]
    (-> this (.getUIClassNamesForRole role))))

