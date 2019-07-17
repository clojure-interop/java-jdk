(ns javax.security.auth.callback.ConfirmationCallback
  " Underlying security services instantiate and pass a
  ConfirmationCallback to the handle
  method of a CallbackHandler to ask for YES/NO,
  OK/CANCEL, YES/NO/CANCEL or other similar confirmations."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback ConfirmationCallback]))

(defn ->confirmation-callback
  "Constructor.

  Construct a ConfirmationCallback with a prompt,
   message type, an option type and a default option.

    Underlying security services use this constructor if
   they require either a YES/NO, YES/NO/CANCEL or OK/CANCEL
   confirmation.

  prompt - the prompt used to describe the list of options. - `java.lang.String`
  message-type - the message type (INFORMATION, WARNING or ERROR). - `int`
  option-type - the option type (YES_NO_OPTION, YES_NO_CANCEL_OPTION or OK_CANCEL_OPTION). - `int`
  default-option - the default option from the provided optionType (YES, NO, CANCEL or OK). - `int`

  throws: java.lang.IllegalArgumentException - if prompt is null, if prompt has a length of 0, if messageType is not either INFORMATION, WARNING, or ERROR, if optionType is not either YES_NO_OPTION, YES_NO_CANCEL_OPTION, or OK_CANCEL_OPTION, or if defaultOption does not correspond to one of the options in optionType."
  ([prompt message-type option-type default-option]
    (new ConfirmationCallback prompt message-type option-type default-option))
  ([message-type option-type default-option]
    (new ConfirmationCallback message-type option-type default-option)))

(def *-unspecified-option
  "Static Constant.

  Unspecified option type.

    The getOptionType method returns this
   value if this ConfirmationCallback was instantiated
   with options instead of an optionType.

  type: int"
  ConfirmationCallback/UNSPECIFIED_OPTION)

(def *-yes-no-option
  "Static Constant.

  YES/NO confirmation option.

    An underlying security service specifies this as the
   optionType to a ConfirmationCallback
   constructor if it requires a confirmation which can be answered
   with either YES or NO.

  type: int"
  ConfirmationCallback/YES_NO_OPTION)

(def *-yes-no-cancel-option
  "Static Constant.

  YES/NO/CANCEL confirmation confirmation option.

    An underlying security service specifies this as the
   optionType to a ConfirmationCallback
   constructor if it requires a confirmation which can be answered
   with either YES, NO or CANCEL.

  type: int"
  ConfirmationCallback/YES_NO_CANCEL_OPTION)

(def *-ok-cancel-option
  "Static Constant.

  OK/CANCEL confirmation confirmation option.

    An underlying security service specifies this as the
   optionType to a ConfirmationCallback
   constructor if it requires a confirmation which can be answered
   with either OK or CANCEL.

  type: int"
  ConfirmationCallback/OK_CANCEL_OPTION)

(def *-yes
  "Static Constant.

  YES option.

    If an optionType was specified to this
   ConfirmationCallback, this option may be specified as a
   defaultOption or returned as the selected index.

  type: int"
  ConfirmationCallback/YES)

(def *-no
  "Static Constant.

  NO option.

    If an optionType was specified to this
   ConfirmationCallback, this option may be specified as a
   defaultOption or returned as the selected index.

  type: int"
  ConfirmationCallback/NO)

(def *-cancel
  "Static Constant.

  CANCEL option.

    If an optionType was specified to this
   ConfirmationCallback, this option may be specified as a
   defaultOption or returned as the selected index.

  type: int"
  ConfirmationCallback/CANCEL)

(def *-ok
  "Static Constant.

  OK option.

    If an optionType was specified to this
   ConfirmationCallback, this option may be specified as a
   defaultOption or returned as the selected index.

  type: int"
  ConfirmationCallback/OK)

(def *-information
  "Static Constant.

  INFORMATION message type.

  type: int"
  ConfirmationCallback/INFORMATION)

(def *-warning
  "Static Constant.

  WARNING message type.

  type: int"
  ConfirmationCallback/WARNING)

(def *-error
  "Static Constant.

  ERROR message type.

  type: int"
  ConfirmationCallback/ERROR)

(defn get-prompt
  "Get the prompt.

  returns: the prompt, or null if this ConfirmationCallback
            was instantiated without a prompt. - `java.lang.String`"
  ([this]
    (-> this (.getPrompt))))

(defn get-message-type
  "Get the message type.

  returns: the message type (INFORMATION,
            WARNING or ERROR). - `int`"
  ([this]
    (-> this (.getMessageType))))

(defn get-option-type
  "Get the option type.

    If this method returns UNSPECIFIED_OPTION, then this
   ConfirmationCallback was instantiated with
   options instead of an optionType.
   In this case, invoke the getOptions method
   to determine which confirmation options to display.

  returns: the option type (YES_NO_OPTION,
            YES_NO_CANCEL_OPTION or
            OK_CANCEL_OPTION), or
            UNSPECIFIED_OPTION if this
            ConfirmationCallback was instantiated with
            options instead of an optionType. - `int`"
  ([this]
    (-> this (.getOptionType))))

(defn get-options
  "Get the confirmation options.

  returns: the list of confirmation options, or null if this
            ConfirmationCallback was instantiated with
            an optionType instead of options. - `java.lang.String[]`"
  ([this]
    (-> this (.getOptions))))

(defn get-default-option
  "Get the default option.

  returns: the default option, represented as
            YES, NO, OK or
            CANCEL if an optionType
            was specified to the constructor of this
            ConfirmationCallback.
            Otherwise, this method returns the default option as
            an index into the
            options array specified to the constructor
            of this ConfirmationCallback. - `int`"
  ([this]
    (-> this (.getDefaultOption))))

(defn set-selected-index
  "Set the selected confirmation option.

  selection - the selection represented as YES, NO, OK or CANCEL if an optionType was specified to the constructor of this ConfirmationCallback. Otherwise, the selection represents the index into the options array specified to the constructor of this ConfirmationCallback. - `int`"
  ([this selection]
    (-> this (.setSelectedIndex selection))))

(defn get-selected-index
  "Get the selected confirmation option.

  returns: the selected confirmation option represented as
            YES, NO, OK or
            CANCEL if an optionType
            was specified to the constructor of this
            ConfirmationCallback.
            Otherwise, this method returns the selected confirmation
            option as an index into the
            options array specified to the constructor
            of this ConfirmationCallback. - `int`"
  ([this]
    (-> this (.getSelectedIndex))))

