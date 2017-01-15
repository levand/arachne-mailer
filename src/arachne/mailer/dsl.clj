(ns arachne.mailer.dsl 
  (:require [arachne.core.config :as cfg]
            [arachne.core.config.init :as script :refer [defdsl]]
            [arachne.error :as e :refer [error deferror]]
            [clojure.spec :as s]))

(defdsl testmailer
  "Creates a test mailer"
  []
  (let [txdata [{:arachne.component/constructor :arachne.mailer/construct-testmailer}]]
       (script/transact txdata)))

(defdsl ses-mailer
 "Create a mailer for Amazon SES"
 [provider access-key secret-key region]
  (let [txdata [{:arachne.mailer.sesmailer/provider provider
                 :arachne.mailer.sesmailer/access-key access-key
                 :arachne.mailer.sesmailer/secret-key secret-key
                 :arachne.mailer.sesmailer/region region
                 :arachne.component/constructor :arachne.mailer/construct-sesmailer}]]
    (script/transact txdata)))

(defdsl apache-mailer
 "Create a mailer for Apache Commons Mailer"
 [hostname smtp-port authenticator tls]
  (let [txdata [{:arachne.mailer.apachemailer/hostname hostname
                 :arachne.mailer.apachemailer/smtp-port smtp-port
                 :arachne.mailer.apachemailer/authenticator authenticator
                 :arachne.mailer.apachemailer/tls tls
                 :arachne.component/constructor :arachne.mailer/construct-apachemailer}]]
    (script/transact txdata)))
