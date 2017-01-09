(ns arachne.mail)

(defprotocol MailConfig
  (defaults [this from subject body]))

(defrecord ApacheCommons [hostname smtp-port authenticator tls]
  MailConfig
  (defaults [this from subject body]
    {:hostname hostname
     :smtp-port smtp-port
     :authenticator authenticator
     :tls tls
     :from from
     :subject subject
     :body body}))

(defrecord SesMailer [provider access-key secret-key region]
  MailConfig
  (defaults [this from subject body]
    {:provider provider
     :access-key access-key
     :secret-key secret-key
     :region region
     :from from 
     :subject subject
     :body body}))
