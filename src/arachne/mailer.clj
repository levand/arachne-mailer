(ns arachne.mailer
  #_[arachne.core.config :as cfg]
  #_[arachne.mail.schema :as schema])

(defprotocol Mailer
  (sendmail! [this from subject body]))

(defrecord ApacheCommons [hostname smtp-port authenticator tls]
  Mailer
  (sendmail! [this from subject body]
    {:hostname hostname
     :smtp-port smtp-port
     :authenticator authenticator
     :tls tls
     :from from
     :subject subject
     :body body}))

(defrecord SesMailer [provider access-key secret-key region]
  Mailer
  (sendmail! [this from subject body]
    {:provider provider
     :access-key access-key
     :secret-key secret-key
     :region region
     :from from 
     :subject subject
     :body body}))

#_(defn mailer-component
  [cfg]
  (let [mailers (cfg/q cfg '[:find [?g ...]
                     :where
                     [?g :arachne-mail.mailer]])]))
