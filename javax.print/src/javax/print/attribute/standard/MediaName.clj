(ns javax.print.attribute.standard.MediaName
  "Class MediaName is a subclass of Media, a printing attribute class (an
  enumeration) that specifies the media for a print job as a name.

  This attribute can be used instead of specifying MediaSize or MediaTray.

  Class MediaName currently declares a few standard media names.
  Implementation- or site-defined names for a media name attribute may also
  be created by defining a subclass of class MediaName.

  IPP Compatibility: MediaName is a representation class for
  values of the IPP `media` attribute which names media."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard MediaName]))

(def *-na-letter-white
  "Static Constant.

  white letter paper.

  type: javax.print.attribute.standard.MediaName"
  MediaName/NA_LETTER_WHITE)

(def *-na-letter-transparent
  "Static Constant.

  letter transparency.

  type: javax.print.attribute.standard.MediaName"
  MediaName/NA_LETTER_TRANSPARENT)

(def *-iso-a-4-white
  "Static Constant.

  white A4 paper.

  type: javax.print.attribute.standard.MediaName"
  MediaName/ISO_A4_WHITE)

(def *-iso-a-4-transparent
  "Static Constant.

  A4 transparency.

  type: javax.print.attribute.standard.MediaName"
  MediaName/ISO_A4_TRANSPARENT)

