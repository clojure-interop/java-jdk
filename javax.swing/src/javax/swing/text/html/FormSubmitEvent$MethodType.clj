(ns javax.swing.text.html.FormSubmitEvent$MethodType
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html FormSubmitEvent$MethodType]))

(def GET
  "Enum Constant.

  type: javax.swing.text.html.FormSubmitEvent.MethodType"
  FormSubmitEvent$MethodType/GET)

(def POST
  "Enum Constant.

  type: javax.swing.text.html.FormSubmitEvent.MethodType"
  FormSubmitEvent$MethodType/POST)

(defn *values
  "Returns an array containing the constants of this enum type, in
  the order they are declared.  This method may be used to iterate
  over the constants as follows:


  for (FormSubmitEvent.MethodType c : FormSubmitEvent.MethodType.values())
      System.out.println(c);

  returns: an array containing the constants of this enum type, in the order they are declared - `javax.swing.text.html.FormSubmitEvent.MethodType[]`"
  ([]
    (FormSubmitEvent$MethodType/values )))

(defn *value-of
  "Returns the enum constant of this type with the specified name.
  The string must match exactly an identifier used to declare an
  enum constant in this type.  (Extraneous whitespace characters are
  not permitted.)

  name - the name of the enum constant to be returned. - `java.lang.String`

  returns: the enum constant with the specified name - `javax.swing.text.html.FormSubmitEvent.MethodType`

  throws: java.lang.IllegalArgumentException - if this enum type has no constant with the specified name"
  (^javax.swing.text.html.FormSubmitEvent.MethodType [^java.lang.String name]
    (FormSubmitEvent$MethodType/valueOf name)))

