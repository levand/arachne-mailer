(ns arachne.mailer
  (:require [arachne.mailer.schema :as schema]))

(defprotocol Mailer
  (sendmail! [this from subject body]))

(defrecord TestMailer []
  Mailer
  (sendmail! [this from subject body]
    (println "Calling sendmail! from TestMailer")))

(defrecord ApacheMailer [hostname smtp-port authenticator tls]
  Mailer
  (sendmail! [this from subject body]
    (println "Calling sendmail! from ApacheMailer")))

(defrecord SesMailer [provider access-key secret-key region]
  Mailer
  (sendmail! [this from subject body]
    (println "Calling sendmail! from SesMailer")))

(defn construct-testmailer []
  (->TestMailer))

(defn construct-apachemailer [hostname smtp-port authenticator tls]
  (->ApacheMailer hostname smtp-port authenticator tls))

(defn construct-sesmailer [provider access-key secret-key region]
  (->SesMailer provider access-key secret-key region))

(defn schema []
  schema/schema)
