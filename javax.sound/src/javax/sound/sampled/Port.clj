(ns javax.sound.sampled.Port
  "Ports are simple lines for input or output of audio to or from audio devices.
  Common examples of ports that act as source lines (mixer inputs) include the microphone,
  line input, and CD-ROM drive.  Ports that act as target lines (mixer outputs) include the
  speaker, headphone, and line output.  You can access port using a Port.Info
  object."
  (:refer-clojure :only [require comment defn ->])
  (:import [javax.sound.sampled Port]))

