(ns javax.security.auth.callback.TextOutputCallback
  " Underlying security services instantiate and pass a
  TextOutputCallback to the handle
  method of a CallbackHandler to display information messages,
  warning messages and error messages."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.security.auth.callback TextOutputCallback]))

(defn ->text-output-callback
  "Constructor.

  Construct a TextOutputCallback with a message type and message
   to be displayed.

  message-type - the message type (INFORMATION, WARNING or ERROR). - `int`
  message - the message to be displayed. - `java.lang.String`

  throws: java.lang.IllegalArgumentException - if messageType is not either INFORMATION, WARNING or ERROR, if message is null, or if message has a length of 0."
  ([message-type message]
    (new TextOutputCallback message-type message)))

(def *-information
  "Static Constant.

  Information message.

  type: int"
  TextOutputCallback/INFORMATION)

(def *-warning
  "Static Constant.

  Warning message.

  type: int"
  TextOutputCallback/WARNING)

(def *-error
  "Static Constant.

  Error message.

  type: int"
  TextOutputCallback/ERROR)

(defn get-message-type
  "Get the message type.

  returns: the message type (INFORMATION,
                    WARNING or ERROR). - `int`"
  ([this]
    (-> this (.getMessageType))))

(defn get-message
  "Get the message to be displayed.

  returns: the message to be displayed. - `java.lang.String`"
  ([this]
    (-> this (.getMessage))))

