# Bindings for javax.sound

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/javax.sound "1.0.1"]
```

## Class Members Naming Conventions

| Class Member | Java | Clojure |
|:--|:--|:--|
| constructor | new File() | (->file) |
| instance method | getAnyValue() | (get-any-value) |
| instance field | instanceField | -instance-field |
| static method | staticMethod() | (*static-method) |
| static field | ANY_STATIC_FIELD | *-any-static-field |
| boolean field/method | isExists(), canUse() | (exists?), (can-use?) |

## Classes

- interface **javax.sound.midi.ControllerEventListener**
- class **javax.sound.midi.Instrument**
- class **javax.sound.midi.InvalidMidiDataException**
- interface **javax.sound.midi.MetaEventListener**
- class **javax.sound.midi.MetaMessage**
- interface **javax.sound.midi.MidiChannel**
- class **javax.sound.midi.MidiDevice$Info**
- interface **javax.sound.midi.MidiDevice**
- interface **javax.sound.midi.MidiDeviceReceiver**
- interface **javax.sound.midi.MidiDeviceTransmitter**
- class **javax.sound.midi.MidiEvent**
- class **javax.sound.midi.MidiFileFormat**
- class **javax.sound.midi.MidiMessage**
- class **javax.sound.midi.MidiSystem**
- class **javax.sound.midi.MidiUnavailableException**
- class **javax.sound.midi.Patch**
- interface **javax.sound.midi.Receiver**
- class **javax.sound.midi.Sequence**
- class **javax.sound.midi.Sequencer$SyncMode**
- interface **javax.sound.midi.Sequencer**
- class **javax.sound.midi.ShortMessage**
- interface **javax.sound.midi.Soundbank**
- class **javax.sound.midi.SoundbankResource**
- interface **javax.sound.midi.Synthesizer**
- class **javax.sound.midi.SysexMessage**
- class **javax.sound.midi.Track**
- interface **javax.sound.midi.Transmitter**
- class **javax.sound.midi.VoiceStatus**
- class **javax.sound.midi.spi.MidiDeviceProvider**
- class **javax.sound.midi.spi.MidiFileReader**
- class **javax.sound.midi.spi.MidiFileWriter**
- class **javax.sound.midi.spi.SoundbankReader**
- class **javax.sound.sampled.AudioFileFormat$Type**
- class **javax.sound.sampled.AudioFileFormat**
- class **javax.sound.sampled.AudioFormat$Encoding**
- class **javax.sound.sampled.AudioFormat**
- class **javax.sound.sampled.AudioInputStream**
- class **javax.sound.sampled.AudioPermission**
- class **javax.sound.sampled.AudioSystem**
- class **javax.sound.sampled.BooleanControl$Type**
- class **javax.sound.sampled.BooleanControl**
- interface **javax.sound.sampled.Clip**
- class **javax.sound.sampled.CompoundControl$Type**
- class **javax.sound.sampled.CompoundControl**
- class **javax.sound.sampled.Control$Type**
- class **javax.sound.sampled.Control**
- class **javax.sound.sampled.DataLine$Info**
- interface **javax.sound.sampled.DataLine**
- class **javax.sound.sampled.EnumControl$Type**
- class **javax.sound.sampled.EnumControl**
- class **javax.sound.sampled.FloatControl$Type**
- class **javax.sound.sampled.FloatControl**
- class **javax.sound.sampled.Line$Info**
- interface **javax.sound.sampled.Line**
- class **javax.sound.sampled.LineEvent$Type**
- class **javax.sound.sampled.LineEvent**
- interface **javax.sound.sampled.LineListener**
- class **javax.sound.sampled.LineUnavailableException**
- class **javax.sound.sampled.Mixer$Info**
- interface **javax.sound.sampled.Mixer**
- class **javax.sound.sampled.Port$Info**
- interface **javax.sound.sampled.Port**
- class **javax.sound.sampled.ReverbType**
- interface **javax.sound.sampled.SourceDataLine**
- interface **javax.sound.sampled.TargetDataLine**
- class **javax.sound.sampled.UnsupportedAudioFileException**
- class **javax.sound.sampled.spi.AudioFileReader**
- class **javax.sound.sampled.spi.AudioFileWriter**
- class **javax.sound.sampled.spi.FormatConversionProvider**
- class **javax.sound.sampled.spi.MixerProvider**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
