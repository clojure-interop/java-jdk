(ns javax.print.DocFlavor$SERVICE_FORMATTED
  "Class DocFlavor.SERVICE_FORMATTED provides predefined static constant
  DocFlavor objects for example doc flavors for service formatted print
  data."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print DocFlavor$SERVICE_FORMATTED]))

(defn ->service-formatted
  "Constructor.

  Constructs a new doc flavor with a MIME type of
   `application/x-java-jvm-local-objectref` indicating
   service formatted print data and the given print data
   representation class name.

  class-name - Fully-qualified representation class name. - `java.lang.String`

  throws: java.lang.NullPointerException - (unchecked exception) Thrown if className is null."
  (^DocFlavor$SERVICE_FORMATTED [^java.lang.String class-name]
    (new DocFlavor$SERVICE_FORMATTED class-name)))

(def *-renderable-image
  "Static Constant.

  Service formatted print data doc flavor with print data
   representation class name =
   `java.awt.image.renderable.RenderableImage`
   (renderable image object).

  type: javax.print.DocFlavor$SERVICE_FORMATTED"
  DocFlavor$SERVICE_FORMATTED/RENDERABLE_IMAGE)

(def *-printable
  "Static Constant.

  Service formatted print data doc flavor with print data
   representation class name = `java.awt.print.Printable`
   (printable object).

  type: javax.print.DocFlavor$SERVICE_FORMATTED"
  DocFlavor$SERVICE_FORMATTED/PRINTABLE)

(def *-pageable
  "Static Constant.

  Service formatted print data doc flavor with print data
   representation class name = `java.awt.print.Pageable`
   (pageable object).

  type: javax.print.DocFlavor$SERVICE_FORMATTED"
  DocFlavor$SERVICE_FORMATTED/PAGEABLE)

