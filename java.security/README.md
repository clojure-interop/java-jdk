# Bindings for java.security

These bindings are created to simplify interaction with java classes from clojure.
For each java class was created a separate namespace.
Each method/field has its own function/field binding.
Their names are changed for a more native look in the clojure code. Each function has docstring - information about the parameters, return value and possible exceptions.

## Note

All namespaces starting with **java.** are renamed to **jdk.** (java compiler limitation). 

**java.io.File** renamed to **jdk.io.File** for example. 




## Clojars

```
[clojure-interop/java.security "1.0.0"]
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

- class **java.security.AccessControlContext**
- class **java.security.AccessControlException**
- class **java.security.AccessController**
- interface **java.security.AlgorithmConstraints**
- class **java.security.AlgorithmParameterGenerator**
- class **java.security.AlgorithmParameterGeneratorSpi**
- class **java.security.AlgorithmParameters**
- class **java.security.AlgorithmParametersSpi**
- class **java.security.AllPermission**
- class **java.security.AuthProvider**
- class **java.security.BasicPermission**
- interface **java.security.Certificate**
- class **java.security.CodeSigner**
- class **java.security.CodeSource**
- enum **java.security.CryptoPrimitive**
- class **java.security.DigestException**
- class **java.security.DigestInputStream**
- class **java.security.DigestOutputStream**
- interface **java.security.DomainCombiner**
- class **java.security.DomainLoadStoreParameter**
- class **java.security.GeneralSecurityException**
- interface **java.security.Guard**
- class **java.security.GuardedObject**
- class **java.security.Identity**
- class **java.security.IdentityScope**
- class **java.security.InvalidAlgorithmParameterException**
- class **java.security.InvalidKeyException**
- class **java.security.InvalidParameterException**
- interface **java.security.Key**
- class **java.security.KeyException**
- class **java.security.KeyFactory**
- class **java.security.KeyFactorySpi**
- class **java.security.KeyManagementException**
- class **java.security.KeyPair**
- class **java.security.KeyPairGenerator**
- class **java.security.KeyPairGeneratorSpi**
- enum **java.security.KeyRep$Type**
- class **java.security.KeyRep**
- class **java.security.KeyStore$Builder**
- class **java.security.KeyStore$CallbackHandlerProtection**
- interface **java.security.KeyStore$Entry$Attribute**
- interface **java.security.KeyStore$Entry**
- interface **java.security.KeyStore$LoadStoreParameter**
- class **java.security.KeyStore$PasswordProtection**
- class **java.security.KeyStore$PrivateKeyEntry**
- interface **java.security.KeyStore$ProtectionParameter**
- class **java.security.KeyStore$SecretKeyEntry**
- class **java.security.KeyStore$TrustedCertificateEntry**
- class **java.security.KeyStore**
- class **java.security.KeyStoreException**
- class **java.security.KeyStoreSpi**
- class **java.security.MessageDigest**
- class **java.security.MessageDigestSpi**
- class **java.security.NoSuchAlgorithmException**
- class **java.security.NoSuchProviderException**
- class **java.security.PKCS12Attribute**
- class **java.security.Permission**
- class **java.security.PermissionCollection**
- class **java.security.Permissions**
- interface **java.security.Policy$Parameters**
- class **java.security.Policy**
- class **java.security.PolicySpi**
- interface **java.security.Principal**
- interface **java.security.PrivateKey**
- interface **java.security.PrivilegedAction**
- class **java.security.PrivilegedActionException**
- interface **java.security.PrivilegedExceptionAction**
- class **java.security.ProtectionDomain**
- class **java.security.Provider$Service**
- class **java.security.Provider**
- class **java.security.ProviderException**
- interface **java.security.PublicKey**
- class **java.security.SecureClassLoader**
- class **java.security.SecureRandom**
- class **java.security.SecureRandomSpi**
- class **java.security.Security**
- class **java.security.SecurityPermission**
- class **java.security.Signature**
- class **java.security.SignatureException**
- class **java.security.SignatureSpi**
- class **java.security.SignedObject**
- class **java.security.Signer**
- class **java.security.Timestamp**
- class **java.security.URIParameter**
- class **java.security.UnrecoverableEntryException**
- class **java.security.UnrecoverableKeyException**
- class **java.security.UnresolvedPermission**
- interface **java.security.acl.Acl**
- interface **java.security.acl.AclEntry**
- class **java.security.acl.AclNotFoundException**
- interface **java.security.acl.Group**
- class **java.security.acl.LastOwnerException**
- class **java.security.acl.NotOwnerException**
- interface **java.security.acl.Owner**
- interface **java.security.acl.Permission**
- class **java.security.cert.CRL**
- class **java.security.cert.CRLException**
- enum **java.security.cert.CRLReason**
- interface **java.security.cert.CRLSelector**
- class **java.security.cert.CertPath$CertPathRep**
- class **java.security.cert.CertPath**
- class **java.security.cert.CertPathBuilder**
- class **java.security.cert.CertPathBuilderException**
- interface **java.security.cert.CertPathBuilderResult**
- class **java.security.cert.CertPathBuilderSpi**
- interface **java.security.cert.CertPathChecker**
- interface **java.security.cert.CertPathParameters**
- class **java.security.cert.CertPathValidator**
- enum **java.security.cert.CertPathValidatorException$BasicReason**
- interface **java.security.cert.CertPathValidatorException$Reason**
- class **java.security.cert.CertPathValidatorException**
- interface **java.security.cert.CertPathValidatorResult**
- class **java.security.cert.CertPathValidatorSpi**
- interface **java.security.cert.CertSelector**
- class **java.security.cert.CertStore**
- class **java.security.cert.CertStoreException**
- interface **java.security.cert.CertStoreParameters**
- class **java.security.cert.CertStoreSpi**
- class **java.security.cert.Certificate$CertificateRep**
- class **java.security.cert.Certificate**
- class **java.security.cert.CertificateEncodingException**
- class **java.security.cert.CertificateException**
- class **java.security.cert.CertificateExpiredException**
- class **java.security.cert.CertificateFactory**
- class **java.security.cert.CertificateFactorySpi**
- class **java.security.cert.CertificateNotYetValidException**
- class **java.security.cert.CertificateParsingException**
- class **java.security.cert.CertificateRevokedException**
- class **java.security.cert.CollectionCertStoreParameters**
- interface **java.security.cert.Extension**
- class **java.security.cert.LDAPCertStoreParameters**
- class **java.security.cert.PKIXBuilderParameters**
- class **java.security.cert.PKIXCertPathBuilderResult**
- class **java.security.cert.PKIXCertPathChecker**
- class **java.security.cert.PKIXCertPathValidatorResult**
- class **java.security.cert.PKIXParameters**
- enum **java.security.cert.PKIXReason**
- enum **java.security.cert.PKIXRevocationChecker$Option**
- class **java.security.cert.PKIXRevocationChecker**
- interface **java.security.cert.PolicyNode**
- class **java.security.cert.PolicyQualifierInfo**
- class **java.security.cert.TrustAnchor**
- class **java.security.cert.X509CRL**
- class **java.security.cert.X509CRLEntry**
- class **java.security.cert.X509CRLSelector**
- class **java.security.cert.X509CertSelector**
- class **java.security.cert.X509Certificate**
- interface **java.security.cert.X509Extension**
- interface **java.security.interfaces.DSAKey**
- interface **java.security.interfaces.DSAKeyPairGenerator**
- interface **java.security.interfaces.DSAParams**
- interface **java.security.interfaces.DSAPrivateKey**
- interface **java.security.interfaces.DSAPublicKey**
- interface **java.security.interfaces.ECKey**
- interface **java.security.interfaces.ECPrivateKey**
- interface **java.security.interfaces.ECPublicKey**
- interface **java.security.interfaces.RSAKey**
- interface **java.security.interfaces.RSAMultiPrimePrivateCrtKey**
- interface **java.security.interfaces.RSAPrivateCrtKey**
- interface **java.security.interfaces.RSAPrivateKey**
- interface **java.security.interfaces.RSAPublicKey**
- interface **java.security.spec.AlgorithmParameterSpec**
- class **java.security.spec.DSAGenParameterSpec**
- class **java.security.spec.DSAParameterSpec**
- class **java.security.spec.DSAPrivateKeySpec**
- class **java.security.spec.DSAPublicKeySpec**
- interface **java.security.spec.ECField**
- class **java.security.spec.ECFieldF2m**
- class **java.security.spec.ECFieldFp**
- class **java.security.spec.ECGenParameterSpec**
- class **java.security.spec.ECParameterSpec**
- class **java.security.spec.ECPoint**
- class **java.security.spec.ECPrivateKeySpec**
- class **java.security.spec.ECPublicKeySpec**
- class **java.security.spec.EllipticCurve**
- class **java.security.spec.EncodedKeySpec**
- class **java.security.spec.InvalidKeySpecException**
- class **java.security.spec.InvalidParameterSpecException**
- interface **java.security.spec.KeySpec**
- class **java.security.spec.MGF1ParameterSpec**
- class **java.security.spec.PKCS8EncodedKeySpec**
- class **java.security.spec.PSSParameterSpec**
- class **java.security.spec.RSAKeyGenParameterSpec**
- class **java.security.spec.RSAMultiPrimePrivateCrtKeySpec**
- class **java.security.spec.RSAOtherPrimeInfo**
- class **java.security.spec.RSAPrivateCrtKeySpec**
- class **java.security.spec.RSAPrivateKeySpec**
- class **java.security.spec.RSAPublicKeySpec**
- class **java.security.spec.X509EncodedKeySpec**

## Contributors

[Eugene Potapenko](https://github.com/potapenko/)

## License

Distributed under the Eclipse Public License, the same as Clojure.
