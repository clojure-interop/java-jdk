(ns jdk.awt.im.spi.InputMethodDescriptor
  "Defines methods that provide sufficient information about an input method
  to enable selection and loading of that input method.
  The input method itself is only loaded when it is actually used."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.awt.im.spi InputMethodDescriptor]))

(defn get-available-locales
  "Returns the locales supported by the corresponding input method.
   The locale may describe just the language, or may also include
   country and variant information if needed.
   The information is used to select input methods by locale
   (InputContext.selectInputMethod(Locale)). It may also
   be used to sort input methods by locale in a user-visible
   list of input methods.

   Only the input method's primary locales should be returned.
   For example, if a Japanese input method also has a pass-through
   mode for Roman characters, typically still only Japanese would
   be returned. Thus, the list of locales returned is typically
   a subset of the locales for which the corresponding input method's
   implementation of InputMethod.setLocale(java.util.Locale) returns true.

   If hasDynamicLocaleList() returns true, this method is
   called each time the information is needed. This
   gives input methods that depend on network resources the chance
   to add or remove locales as resources become available or
   unavailable.

  returns: the locales supported by the input method - `java.util.Locale[]`

  throws: java.awt.AWTException - if it can be determined that the input method is inoperable, for example, because of incomplete installation."
  ([this]
    (-> this (.getAvailableLocales))))

(defn has-dynamic-locale-list?
  "Returns whether the list of available locales can change
   at runtime. This may be the case, for example, for adapters
   that access real input methods over the network.

  returns: `boolean`"
  ([this]
    (-> this (.hasDynamicLocaleList))))

(defn get-input-method-display-name
  "Returns the user-visible name of the corresponding
   input method for the given input locale in the language in which
   the name will be displayed.

   The inputLocale parameter specifies the locale for which text
   is input.
   This parameter can only take values obtained from this descriptor's
   getAvailableLocales() method or null. If it is null, an
   input locale independent name for the input method should be
   returned.

   If a name for the desired display language is not available, the
   method may fall back to some other language.

  input-locale - the locale for which text input is supported, or null - `java.util.Locale`
  display-language - the language in which the name will be displayed - `java.util.Locale`

  returns: `java.lang.String`"
  ([this input-locale display-language]
    (-> this (.getInputMethodDisplayName input-locale display-language))))

(defn get-input-method-icon
  "Returns an icon for the corresponding input method.
   The icon may be used by a user interface for selecting input methods.

   The inputLocale parameter specifies the locale for which text
   is input.
   This parameter can only take values obtained from this descriptor's
   getAvailableLocales() method or null. If it is null, an
   input locale independent icon for the input method should be
   returned.

   The icon's size should be 16×16 pixels.

  input-locale - the locale for which text input is supported, or null - `java.util.Locale`

  returns: an icon for the corresponding input method, or null - `java.awt.Image`"
  ([this input-locale]
    (-> this (.getInputMethodIcon input-locale))))

(defn create-input-method
  "Creates a new instance of the corresponding input method.

  returns: a new instance of the corresponding input method - `java.awt.im.spi.InputMethod`

  throws: java.lang.Exception - any exception that may occur while creating the input method instance"
  ([this]
    (-> this (.createInputMethod))))

