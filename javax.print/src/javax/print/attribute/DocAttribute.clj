(ns javax.print.attribute.DocAttribute
  "Interface DocAttribute is a tagging interface which a printing attribute
  class implements to indicate the attribute denotes a setting for a doc.
  (\"Doc\" is a short, easy-to-pronounce term that means \"a piece of print
  data.\") The client may include a DocAttribute in a Doc's
  attribute set to specify a characteristic of
  that doc. If an attribute implements PrintRequestAttribute as well as DocAttribute, the client may include the
  attribute in a attribute set which specifies a print job
  to specify a characteristic for all the docs in that job."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute DocAttribute]))

