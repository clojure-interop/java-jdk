(ns javax.swing.text.html.FormSubmitEvent
  "FormSubmitEvent is used to notify interested
  parties that a form was submitted."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text.html FormSubmitEvent]))

(defn get-method
  "Gets the form method type.

  returns: the form method type, either
   Method.GET or Method.POST. - `javax.swing.text.html.FormSubmitEvent.MethodType`"
  ([this]
    (-> this (.getMethod))))

(defn get-data
  "Gets the form submission data.

  returns: the string representing the form submission data. - `java.lang.String`"
  ([this]
    (-> this (.getData))))

