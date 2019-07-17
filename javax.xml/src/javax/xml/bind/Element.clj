(ns javax.xml.bind.Element
  "This is an element marker interface.

  Under certain circumstances, it is necessary for the binding compiler to
  generate derived java content classes that implement this interface.  In
  those cases, client applications must supply element instances rather than
  types of elements.  For more detail, see section 5.7 `Element Declaration`
  and 5.7.1 `Bind to Java Element Interface` of the specification."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.bind Element]))

