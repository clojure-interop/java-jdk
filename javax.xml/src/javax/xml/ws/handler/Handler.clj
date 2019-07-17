(ns javax.xml.ws.handler.Handler
  "The Handler interface
   is the base interface for JAX-WS handlers."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.ws.handler Handler]))

(defn handle-message
  "The handleMessage method is invoked for normal processing
    of inbound and outbound messages. Refer to the description of the handler
    framework in the JAX-WS specification for full details.

  context - the message context. - `Handler.C`

  returns: An indication of whether handler processing should continue for
    the current message

                   Return true to continue
                       processing.
                   Return false to block
                       processing. - `boolean`

  throws: java.lang.RuntimeException - Causes the JAX-WS runtime to cease handler processing and generate a fault."
  (^Boolean [^javax.xml.ws.handler.Handler this ^Handler.C context]
    (-> this (.handleMessage context))))

(defn handle-fault
  "The handleFault method is invoked for fault message
    processing.  Refer to the description of the handler
    framework in the JAX-WS specification for full details.

  context - the message context - `Handler.C`

  returns: An indication of whether handler fault processing should continue
    for the current message

                   Return true to continue
                       processing.
                   Return false to block
                       processing. - `boolean`

  throws: java.lang.RuntimeException - Causes the JAX-WS runtime to cease handler fault processing and dispatch the fault."
  (^Boolean [^javax.xml.ws.handler.Handler this ^Handler.C context]
    (-> this (.handleFault context))))

(defn close
  "Called at the conclusion of a message exchange pattern just prior to
   the JAX-WS runtime dispatching a message, fault or exception.  Refer to
   the description of the handler
   framework in the JAX-WS specification for full details.

  context - the message context - `javax.xml.ws.handler.MessageContext`"
  ([^javax.xml.ws.handler.Handler this ^javax.xml.ws.handler.MessageContext context]
    (-> this (.close context))))

