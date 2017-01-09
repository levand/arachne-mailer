(ns arachne-mail.core
  )

(defn hello []
  "hello world")

(defprotocol MailConfig
  (defaults [this from subject body]))

(defrecord ApacheCommons [hostname smtp-port authenticator tls]
  MailConfig
  (defaults [this from subject body]
    (str "testing sending mail from: " from " with subject: " subject)))

(defrecord SesMailer [provider access-key secret-key region]
  MailConfig
  (defaults [this from subject body]
    (str "testing sending mail from: " from " with subject: " subject)))
