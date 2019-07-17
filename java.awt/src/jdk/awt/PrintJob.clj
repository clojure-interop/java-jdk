(ns jdk.awt.PrintJob
  "An abstract class which initiates and executes a print job.
  It provides access to a print graphics object which renders
  to an appropriate print device."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt PrintJob]))

(defn ->print-job
  "Constructor."
  ([]
    (new PrintJob )))

(defn get-graphics
  "Gets a Graphics object that will draw to the next page.
   The page is sent to the printer when the graphics
   object is disposed.  This graphics object will also implement
   the PrintGraphics interface.

  returns: `java.awt.Graphics`"
  ([this]
    (-> this (.getGraphics))))

(defn get-page-dimension
  "Returns the dimensions of the page in pixels.
   The resolution of the page is chosen so that it
   is similar to the screen resolution.

  returns: `java.awt.Dimension`"
  ([this]
    (-> this (.getPageDimension))))

(defn get-page-resolution
  "Returns the resolution of the page in pixels per inch.
   Note that this doesn't have to correspond to the physical
   resolution of the printer.

  returns: `int`"
  ([this]
    (-> this (.getPageResolution))))

(defn last-page-first
  "Returns true if the last page will be printed first.

  returns: `boolean`"
  ([this]
    (-> this (.lastPageFirst))))

(defn end
  "Ends the print job and does any necessary cleanup."
  ([this]
    (-> this (.end))))

(defn finalize
  "Ends this print job once it is no longer referenced."
  ([this]
    (-> this (.finalize))))

