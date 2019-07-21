(ns javax.print.attribute.standard.MediaTray
  "Class MediaTray is a subclass of Media.
  Class MediaTray is a printing attribute class, an enumeration, that
  specifies the media tray or bin for the job.
  This attribute can be used instead of specifying MediaSize or MediaName.

  Class MediaTray declares keywords for standard media kind values.
  Implementation- or site-defined names for a media kind attribute may also
  be created by defining a subclass of class MediaTray.

  IPP Compatibility: MediaTray is a representation class for
  values of the IPP \"media\" attribute which name paper trays."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.print.attribute.standard MediaTray]))

(def *-top
  "Static Constant.

  The top input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/TOP)

(def *-middle
  "Static Constant.

  The middle input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/MIDDLE)

(def *-bottom
  "Static Constant.

  The bottom input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/BOTTOM)

(def *-envelope
  "Static Constant.

  The envelope input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/ENVELOPE)

(def *-manual
  "Static Constant.

  The manual feed input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/MANUAL)

(def *-large-capacity
  "Static Constant.

  The large capacity input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/LARGE_CAPACITY)

(def *-main
  "Static Constant.

  The main input tray in the printer.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/MAIN)

(def *-side
  "Static Constant.

  The side input tray.

  type: javax.print.attribute.standard.MediaTray"
  MediaTray/SIDE)

