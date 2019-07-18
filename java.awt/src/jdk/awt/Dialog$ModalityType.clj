(ns jdk.awt.Dialog$ModalityType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Dialog$ModalityType]))

(def MODELESS
  "Enum Constant.

  MODELESS dialog doesn't block any top-level windows.

  type: java.awt.Dialog$ModalityType"
  Dialog$ModalityType/MODELESS)

(def DOCUMENT_MODAL
  "Enum Constant.

  A DOCUMENT_MODAL dialog blocks input to all top-level windows
   from the same document except those from its own child hierarchy.
   A document is a top-level window without an owner. It may contain child
   windows that, together with the top-level window are treated as a single
   solid document. Since every top-level window must belong to some
   document, its root can be found as the top-nearest window without an owner.

  type: java.awt.Dialog$ModalityType"
  Dialog$ModalityType/DOCUMENT_MODAL)

(def APPLICATION_MODAL
  "Enum Constant.

  An APPLICATION_MODAL dialog blocks all top-level windows
   from the same Java application except those from its own child hierarchy.
   If there are several applets launched in a browser, they can be
   treated either as separate applications or a single one. This behavior
   is implementation-dependent.

  type: java.awt.Dialog$ModalityType"
  Dialog$ModalityType/APPLICATION_MODAL)

(def TOOLKIT_MODAL
  "Enum Constant.

  A TOOLKIT_MODAL dialog blocks all top-level windows run
   from the same toolkit except those from its own child hierarchy. If there
   are several applets launched in a browser, all of them run with the same
   toolkit; thus, a toolkit-modal dialog displayed by an applet may affect
   other applets and all windows of the browser instance which embeds the
   Java runtime environment for this toolkit.
   Special AWTPermission `toolkitModality` must be granted to use
   toolkit-modal dialogs. If a TOOLKIT_MODAL dialog is being created
   and this permission is not granted, a SecurityException will be
   thrown, and no dialog will be created. If a modality type is being changed
   to TOOLKIT_MODAL and this permission is not granted, a
   SecurityException will be thrown, and the modality type will
   be left unchanged.

  type: java.awt.Dialog$ModalityType"
  Dialog$ModalityType/TOOLKIT_MODAL)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Dialog.ModalityType c : Dialog.ModalityType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.Dialog$ModalityType[]`"
  ([]
    (Dialog$ModalityType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.Dialog$ModalityType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^java.awt.Dialog$ModalityType [^java.lang.String name]
    (Dialog$ModalityType/valueOf name)))

