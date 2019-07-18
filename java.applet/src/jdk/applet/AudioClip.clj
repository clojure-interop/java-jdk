(ns jdk.applet.AudioClip
  "The AudioClip interface is a simple abstraction for
  playing a sound clip. Multiple AudioClip items can be
  playing at the same time, and the resulting sound is mixed
  together to produce a composite."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.applet AudioClip]))

(defn play
  "Starts playing this audio clip. Each time this method is called,
   the clip is restarted from the beginning."
  ([^AudioClip this]
    (-> this (.play))))

(defn loop
  "Starts playing this audio clip in a loop."
  ([^AudioClip this]
    (-> this (.loop))))

(defn stop
  "Stops playing this audio clip."
  ([^AudioClip this]
    (-> this (.stop))))

