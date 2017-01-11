(ns arachne.mailer.schema
  (:require [arachne.core.config.model :as m]))

(def schema
  (concat
    (m/type :arachne.mailer/Mailer [:arachne/Component] :arachne.mailer.spec/Mailer)

    (m/type :arachne.mailer/ApacheCommonsMailer [:arachne.mailer/Mailer]
      (m/attr :arachne.mailer.apache-commons/hostname :one :string
        "The hostname of the smtp server")
      (m/attr :arachne.mailer.apache-commons/port :one :string
        "The port for this smtp server")
      (m/attr :arachne.mailer.apache-commons/authenticator :one :string
        "The authentication used")
      (m/attr :arachne.mailer.apache-commons/tls :one :string))

    (m/type :arachne.mailer/SesMailer [:arachne.mailer/Mailer]
      (m/attr :arachne.mailer.ses-mailer/provider :one :string
        "The provider used")
      (m/attr :arachne.mailer.ses-mailer/access-key :one :string
        "The access key")
      (m/attr :arachne.mailer.ses-mailer/secret-key :one :string
        "The secret key")
      (m/attr :arachne.mailer.ses-mailer/region :one :keyword
        "The region as as keyword"))))
