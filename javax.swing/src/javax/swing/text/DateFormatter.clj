(ns javax.swing.text.DateFormatter
  "DateFormatter is an InternationalFormatter that does its
  formatting by way of an instance of java.text.DateFormat.

  Warning:
  Serialized objects of this class will not be compatible with
  future Swing releases. The current serialization support is
  appropriate for short term storage or RMI between applications running
  the same version of Swing.  As of 1.4, support for long term storage
  of all JavaBeans™
  has been added to the java.beans package.
  Please see XMLEncoder."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.swing.text DateFormatter]))

(defn ->date-formatter
  "Constructor.

  Returns a DateFormatter configured with the specified
   Format instance.

  format - Format used to dictate legal values - `java.text.DateFormat`"
  ([^java.text.DateFormat format]
    (new DateFormatter format))
  ([]
    (new DateFormatter )))

(defn set-format
  "Sets the format that dictates the legal values that can be edited
   and displayed.

   If you have used the nullary constructor the value of this property
   will be determined for the current locale by way of the
   Dateformat.getDateInstance() method.

  format - DateFormat instance used for converting from/to Strings - `java.text.DateFormat`"
  ([^javax.swing.text.DateFormatter this ^java.text.DateFormat format]
    (-> this (.setFormat format))))

