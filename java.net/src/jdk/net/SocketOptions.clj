(ns jdk.net.SocketOptions
  "Interface of methods to get/set socket options.  This interface is
  implemented by: SocketImpl and  DatagramSocketImpl.
  Subclasses of these should override the methods
  of this interface in order to support their own options.

  The methods and constants which specify options in this interface are
  for implementation only.  If you're not subclassing SocketImpl or
  DatagramSocketImpl, you won't use these directly. There are
  type-safe methods to get/set each of these options in Socket, ServerSocket,
  DatagramSocket and MulticastSocket."
  (:refer-clojure :only [require comment defn ->])
  (:import [java.net SocketOptions]))

(defn set-option
  "Enable/disable the option specified by optID.  If the option
   is to be enabled, and it takes an option-specific `value`,  this is
   passed in value.  The actual type of value is option-specific,
   and it is an error to pass something that isn't of the expected type:


   SocketImpl s;
   ...
   s.setOption(SO_LINGER, new Integer(10));
      // OK - set SO_LINGER w/ timeout of 10 sec.
   s.setOption(SO_LINGER, new Double(10));
      // ERROR - expects java.lang.Integer
   If the requested option is binary, it can be set using this method by
   a java.lang.Boolean:


   s.setOption(TCP_NODELAY, new Boolean(true));
      // OK - enables TCP_NODELAY, a binary option

   Any option can be disabled using this method with a Boolean(false):


   s.setOption(TCP_NODELAY, new Boolean(false));
      // OK - disables TCP_NODELAY
   s.setOption(SO_LINGER, new Boolean(false));
      // OK - disables SO_LINGER

   For an option that has a notion of on and off, and requires
   a non-boolean parameter, setting its value to anything other than
   Boolean(false) implicitly enables it.

   Throws SocketException if the option is unrecognized,
   the socket is closed, or some low-level error occurred

  opt-id - identifies the option - `int`
  value - the parameter of the socket option - `java.lang.Object`

  throws: java.net.SocketException - if the option is unrecognized, the socket is closed, or some low-level error occurred"
  ([^java.net.SocketOptions this ^Integer opt-id ^java.lang.Object value]
    (-> this (.setOption opt-id value))))

(defn get-option
  "Fetch the value of an option.
   Binary options will return java.lang.Boolean(true)
   if enabled, java.lang.Boolean(false) if disabled, e.g.:


   SocketImpl s;
   ...
   Boolean noDelay = (Boolean)(s.getOption(TCP_NODELAY));
   if (noDelay.booleanValue()) {
       // true if TCP_NODELAY is enabled...
   ...
   }

   For options that take a particular type as a parameter,
   getOption(int) will return the parameter's value, else
   it will return java.lang.Boolean(false):


   Object o = s.getOption(SO_LINGER);
   if (o instanceof Integer) {
       System.out.print(`Linger time is `  ((Integer)o).intValue());
   } else {
     // the true type of o is java.lang.Boolean(false);
   }

  opt-id - an int identifying the option to fetch - `int`

  returns: the value of the option - `java.lang.Object`

  throws: java.net.SocketException - if optID is unknown along the protocol stack (including the SocketImpl)"
  ([^java.net.SocketOptions this ^Integer opt-id]
    (-> this (.getOption opt-id))))

