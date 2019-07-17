(ns javax.print.attribute.standard.PresentationDirection
  "Class PresentationDirection is a printing attribute class, an enumeration,
  that is used in conjunction with the NumberUp attribute to
  indicate the layout of multiple print-stream pages to impose upon a
  single side of an instance of a selected medium.
  This is useful to mirror the text layout conventions of different scripts.
  For example, English is `toright-tobottom`, Hebrew is `toleft-tobottom`
   and Japanese is usually `tobottom-toleft`.

  IPP Compatibility:  This attribute is not an IPP 1.1
  attribute; it is an attribute in the Production Printing Extension
  (PDF)
  of IPP 1.1.  The category name returned by
  getName() is the IPP attribute name.  The enumeration's
  integer value is the IPP enum value.  The toString() method
  returns the IPP string representation of the attribute value."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard PresentationDirection]))

(def *-tobottom-toright
  "Static Constant.

  Pages are laid out in columns starting at the top left,
   proceeding towards the bottom & right.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TOBOTTOM_TORIGHT)

(def *-tobottom-toleft
  "Static Constant.

  Pages are laid out in columns starting at the top right,
   proceeding towards the bottom & left.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TOBOTTOM_TOLEFT)

(def *-totop-toright
  "Static Constant.

  Pages are laid out in columns starting at the bottom left,
   proceeding towards the top & right.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TOTOP_TORIGHT)

(def *-totop-toleft
  "Static Constant.

  Pages are laid out in columns starting at the bottom right,
   proceeding towards the top & left.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TOTOP_TOLEFT)

(def *-toright-tobottom
  "Static Constant.

  Pages are laid out in rows starting at the top left,
   proceeding towards the right & bottom.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TORIGHT_TOBOTTOM)

(def *-toright-totop
  "Static Constant.

  Pages are laid out in rows starting at the bottom left,
   proceeding towards the right & top.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TORIGHT_TOTOP)

(def *-toleft-tobottom
  "Static Constant.

  Pages are laid out in rows starting at the top right,
   proceeding towards the left & bottom.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TOLEFT_TOBOTTOM)

(def *-toleft-totop
  "Static Constant.

  Pages are laid out in rows starting at the bottom right,
   proceeding towards the left & top.

  type: javax.print.attribute.standard.PresentationDirection"
  PresentationDirection/TOLEFT_TOTOP)

(defn get-category
  "Get the printing attribute class which is to be used as the `category`
   for this printing attribute value.

   For class PresentationDirection
   the category is class PresentationDirection itself.

  returns: Printing attribute class (category), an instance of class
            java.lang.Class. - `java.lang.Class<? extends javax.print.attribute.Attribute>`"
  ([this]
    (-> this (.getCategory))))

(defn get-name
  "Get the name of the category of which this attribute value is an
   instance.

   For class PresentationDirection
   the category name is `presentation-direction`.

  returns: Attribute category name. - `java.lang.String`"
  ([this]
    (-> this (.getName))))

