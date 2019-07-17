(ns javax.xml.stream.events.Characters
  "This describes the interface to Characters events.
  All text events get reported as Characters events.
  Content, CData and whitespace are all reported as
  Characters events.  IgnorableWhitespace, in most cases,
  will be set to false unless an element declaration of element
  content is present for the current element."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.xml.stream.events Characters]))

(defn get-data
  "Get the character data of this event

  returns: `java.lang.String`"
  (^java.lang.String [^javax.xml.stream.events.Characters this]
    (-> this (.getData))))

(defn white-space?
  "Returns true if this set of Characters
   is all whitespace.  Whitespace inside a document
   is reported as CHARACTERS.  This method allows
   checking of CHARACTERS events to see if they
   are composed of only whitespace characters

  returns: `boolean`"
  (^Boolean [^javax.xml.stream.events.Characters this]
    (-> this (.isWhiteSpace))))

(defn c-data?
  "Returns true if this is a CData section.  If this
   event is CData its event type will be CDATA

   If javax.xml.stream.isCoalescing is set to true CDATA Sections
   that are surrounded by non CDATA characters will be reported
   as a single Characters event. This method will return false
   in this case.

  returns: `boolean`"
  (^Boolean [^javax.xml.stream.events.Characters this]
    (-> this (.isCData))))

(defn ignorable-white-space?
  "Return true if this is ignorableWhiteSpace.  If
   this event is ignorableWhiteSpace its event type will
   be SPACE.

  returns: `boolean`"
  (^Boolean [^javax.xml.stream.events.Characters this]
    (-> this (.isIgnorableWhiteSpace))))

