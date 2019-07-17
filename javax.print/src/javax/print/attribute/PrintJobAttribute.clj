(ns javax.print.attribute.PrintJobAttribute
  "PrintJobAttribute is a tagging interface which a printing attribute
  class implements to indicate the attribute describes the status of a Print
  Job or some other characteristic of a Print Job. A Print Service
  instance adds a number of PrintJobAttributes to a Print Job's attribute set
  to report the Print Job's status. If an attribute implements PrintRequestAttribute as well as PrintJobAttribute,
  the client may include the attribute in a attribute set to
  specify the attribute's value for the Print Job."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute PrintJobAttribute]))

