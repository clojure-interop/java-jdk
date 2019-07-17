(ns jdk.awt.KeyEventDispatcher
  "A KeyEventDispatcher cooperates with the current KeyboardFocusManager in the
  targeting and dispatching of all KeyEvents. KeyEventDispatchers registered
  with the current KeyboardFocusManager will receive KeyEvents before they are
  dispatched to their targets, allowing each KeyEventDispatcher to retarget
  the event, consume it, dispatch the event itself, or make other changes.

  Note that KeyboardFocusManager itself implements KeyEventDispatcher. By
  default, the current KeyboardFocusManager will be the sink for all KeyEvents
  not dispatched by the registered KeyEventDispatchers. The current
  KeyboardFocusManager cannot be completely deregistered as a
  KeyEventDispatcher. However, if a KeyEventDispatcher reports that it
  dispatched the KeyEvent, regardless of whether it actually did so, the
  KeyboardFocusManager will take no further action with regard to the
  KeyEvent. (While it is possible for client code to register the current
  KeyboardFocusManager as a KeyEventDispatcher one or more times, this is
  usually unnecessary and not recommended.)"
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt KeyEventDispatcher]))

(defn dispatch-key-event
  "This method is called by the current KeyboardFocusManager requesting
   that this KeyEventDispatcher dispatch the specified event on its behalf.
   This KeyEventDispatcher is free to retarget the event, consume it,
   dispatch it itself, or make other changes. This capability is typically
   used to deliver KeyEvents to Components other than the focus owner. This
   can be useful when navigating children of non-focusable Windows in an
   accessible environment, for example. Note that if a KeyEventDispatcher
   dispatches the KeyEvent itself, it must use redispatchEvent
   to prevent the current KeyboardFocusManager from recursively requesting
   that this KeyEventDispatcher dispatch the event again.

   If an implementation of this method returns false, then
   the KeyEvent is passed to the next KeyEventDispatcher in the chain,
   ending with the current KeyboardFocusManager. If an implementation
   returns true, the KeyEvent is assumed to have been
   dispatched (although this need not be the case), and the current
   KeyboardFocusManager will take no further action with regard to the
   KeyEvent. In such a case,
   KeyboardFocusManager.dispatchEvent should return
   true as well. If an implementation consumes the KeyEvent,
   but returns false, the consumed event will still be passed
   to the next KeyEventDispatcher in the chain. It is important for
   developers to check whether the KeyEvent has been consumed before
   dispatching it to a target. By default, the current KeyboardFocusManager
   will not dispatch a consumed KeyEvent.

  e - the KeyEvent to dispatch - `java.awt.event.KeyEvent`

  returns: true if the KeyboardFocusManager should take no
           further action with regard to the KeyEvent; false
           otherwise - `boolean`"
  ([^java.awt.KeyEventDispatcher this ^java.awt.event.KeyEvent e]
    (-> this (.dispatchKeyEvent e))))

