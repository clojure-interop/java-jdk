(ns javax.security.sasl.RealmChoiceCallback
  "This callback is used by SaslClient and SaslServer
  to obtain a realm given a list of realm choices."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.sasl RealmChoiceCallback]))

(defn ->realm-choice-callback
  "Constructor.

  Constructs a RealmChoiceCallback with a prompt, a list of
   choices and a default choice.

  prompt - the non-null prompt to use to request the realm. - `java.lang.String`
  choices - the non-null list of realms to choose from. - `java.lang.String[]`
  default-choice - the choice to be used as the default choice when the list of choices is displayed. It is an index into the choices array. - `int`
  multiple - true if multiple choices allowed; false otherwise - `boolean`

  throws: java.lang.IllegalArgumentException - If prompt is null or the empty string, if choices has a length of 0, if any element from choices is null or empty, or if defaultChoice does not fall within the array boundary of choices"
  ([^java.lang.String prompt choices ^Integer default-choice ^Boolean multiple]
    (new RealmChoiceCallback prompt choices default-choice multiple)))

