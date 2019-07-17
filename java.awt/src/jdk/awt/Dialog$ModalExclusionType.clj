(ns jdk.awt.Dialog$ModalExclusionType
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt Dialog$ModalExclusionType]))

(def NO_EXCLUDE
  "Enum Constant.

  No modal exclusion.

  type: java.awt.Dialog.ModalExclusionType"
  Dialog$ModalExclusionType/NO_EXCLUDE)

(def APPLICATION_EXCLUDE
  "Enum Constant.

  APPLICATION_EXCLUDE indicates that a top-level window
   won't be blocked by any application-modal dialogs. Also, it isn't
   blocked by document-modal dialogs from outside of its child hierarchy.

  type: java.awt.Dialog.ModalExclusionType"
  Dialog$ModalExclusionType/APPLICATION_EXCLUDE)

(def TOOLKIT_EXCLUDE
  "Enum Constant.

  TOOLKIT_EXCLUDE indicates that a top-level window
   won't be blocked by  application-modal or toolkit-modal dialogs. Also,
   it isn't blocked by document-modal dialogs from outside of its
   child hierarchy.
   The `toolkitModality` AWTPermission must be granted
   for this exclusion. If an exclusion property is being changed to
   TOOLKIT_EXCLUDE and this permission is not granted, a
   SecurityEcxeption will be thrown, and the exclusion
   property will be left unchanged.

  type: java.awt.Dialog.ModalExclusionType"
  Dialog$ModalExclusionType/TOOLKIT_EXCLUDE)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (Dialog.ModalExclusionType c : Dialog.ModalExclusionType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `java.awt.Dialog.ModalExclusionType[]`"
  ([]
    (Dialog$ModalExclusionType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `java.awt.Dialog.ModalExclusionType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  ([^java.lang.String name]
    (Dialog$ModalExclusionType/valueOf name)))

