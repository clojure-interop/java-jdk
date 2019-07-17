(ns javax.print.attribute.PrintRequestAttribute
  "Interface PrintRequestAttribute is a tagging interface which a printing
  attribute class implements to indicate the attribute denotes a
  requested setting for a print job.

  Attributes which are tagged with PrintRequestAttribute and are also tagged
  as PrintJobAttribute, represent the subset of job attributes which
  can be part of the specification of a job request.

  If an attribute implements DocAttribute
  as well as PrintRequestAttribute, the client may include the
  attribute in a Doc}'s attribute set to specify
  a job setting which pertains just to that doc."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute PrintRequestAttribute]))

