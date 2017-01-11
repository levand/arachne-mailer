(ns arachne.mailer.schema
  (:require [arachne.core.config.model :as o]))

(def schema
  (concat
    (o/type :arachne.mailer/Mailer )

  ))
