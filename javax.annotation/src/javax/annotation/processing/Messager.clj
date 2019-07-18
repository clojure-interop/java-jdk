(ns javax.annotation.processing.Messager
  "A Messager provides the way for an annotation processor to
  report error messages, warnings, and other notices.  Elements,
  annotations, and annotation values can be passed to provide a
  location hint for the message.  However, such location hints may be
  unavailable or only approximate.

  Printing a message with an error kind will raise an error.

  Note that the messages `printed` by methods in this
  interface may or may not appear as textual output to a location
  like System.out or System.err.  Implementations may
  choose to present this information in a different fashion, such as
  messages in a window."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.annotation.processing Messager]))

(defn print-message
  "Prints a message of the specified kind at the location of the
   annotation value inside the annotation mirror of the annotated
   element.

  kind - the kind of message - `javax.tools.Diagnostic$Kind`
  msg - the message, or an empty string if none - `java.lang.CharSequence`
  e - the annotated element - `javax.lang.model.element.Element`
  a - the annotation containing the annotation value - `javax.lang.model.element.AnnotationMirror`
  v - the annotation value to use as a position hint - `javax.lang.model.element.AnnotationValue`"
  ([^Messager this ^javax.tools.Diagnostic$Kind kind ^java.lang.CharSequence msg ^javax.lang.model.element.Element e ^javax.lang.model.element.AnnotationMirror a ^javax.lang.model.element.AnnotationValue v]
    (-> this (.printMessage kind msg e a v)))
  ([^Messager this ^javax.tools.Diagnostic$Kind kind ^java.lang.CharSequence msg ^javax.lang.model.element.Element e ^javax.lang.model.element.AnnotationMirror a]
    (-> this (.printMessage kind msg e a)))
  ([^Messager this ^javax.tools.Diagnostic$Kind kind ^java.lang.CharSequence msg ^javax.lang.model.element.Element e]
    (-> this (.printMessage kind msg e)))
  ([^Messager this ^javax.tools.Diagnostic$Kind kind ^java.lang.CharSequence msg]
    (-> this (.printMessage kind msg))))

