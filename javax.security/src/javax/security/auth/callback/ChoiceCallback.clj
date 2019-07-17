(ns javax.security.auth.callback.ChoiceCallback
  " Underlying security services instantiate and pass a
  ChoiceCallback to the handle
  method of a CallbackHandler to display a list of choices
  and to retrieve the selected choice(s)."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback ChoiceCallback]))

(defn ->choice-callback
  "Constructor.

  Construct a ChoiceCallback with a prompt,
   a list of choices, a default choice, and a boolean specifying
   whether or not multiple selections from the list of choices are allowed.

  prompt - the prompt used to describe the list of choices. - `java.lang.String`
  choices - the list of choices. - `java.lang.String[]`
  default-choice - the choice to be used as the default choice when the list of choices are displayed. This value is represented as an index into the choices array. - `int`
  multiple-selections-allowed - boolean specifying whether or not multiple selections can be made from the list of choices. - `boolean`

  throws: java.lang.IllegalArgumentException - if prompt is null, if prompt has a length of 0, if choices is null, if choices has a length of 0, if any element from choices is null, if any element from choices has a length of 0 or if defaultChoice does not fall within the array boundaries of choices."
  ([^java.lang.String prompt ^java.lang.String[] choices ^Integer default-choice ^Boolean multiple-selections-allowed]
    (new ChoiceCallback prompt choices default-choice multiple-selections-allowed)))

(defn get-prompt
  "Get the prompt.

  returns: the prompt. - `java.lang.String`"
  ([^javax.security.auth.callback.ChoiceCallback this]
    (-> this (.getPrompt))))

(defn get-choices
  "Get the list of choices.

  returns: the list of choices. - `java.lang.String[]`"
  ([^javax.security.auth.callback.ChoiceCallback this]
    (-> this (.getChoices))))

(defn get-default-choice
  "Get the defaultChoice.

  returns: the defaultChoice, represented as an index into
            the choices list. - `int`"
  ([^javax.security.auth.callback.ChoiceCallback this]
    (-> this (.getDefaultChoice))))

(defn allow-multiple-selections
  "Get the boolean determining whether multiple selections from
   the choices list are allowed.

  returns: whether multiple selections are allowed. - `boolean`"
  ([^javax.security.auth.callback.ChoiceCallback this]
    (-> this (.allowMultipleSelections))))

(defn set-selected-index
  "Set the selected choice.

  selection - the selection represented as an index into the choices list. - `int`"
  ([^javax.security.auth.callback.ChoiceCallback this ^Integer selection]
    (-> this (.setSelectedIndex selection))))

(defn set-selected-indexes
  "Set the selected choices.

  selections - the selections represented as indexes into the choices list. - `int[]`

  throws: java.lang.UnsupportedOperationException - if multiple selections are not allowed, as determined by allowMultipleSelections."
  ([^javax.security.auth.callback.ChoiceCallback this selections]
    (-> this (.setSelectedIndexes selections))))

(defn get-selected-indexes
  "Get the selected choices.

  returns: the selected choices, represented as indexes into the
            choices list. - `int[]`"
  ([^javax.security.auth.callback.ChoiceCallback this]
    (-> this (.getSelectedIndexes))))

