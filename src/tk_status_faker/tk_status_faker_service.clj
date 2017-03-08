(ns tk-status-faker.tk-status-faker-service
  (:require [clojure.tools.logging :as log]
            [compojure.core :as compojure]
            [puppetlabs.trapperkeeper.core :as trapperkeeper]
            [puppetlabs.trapperkeeper.services :as tk-services]
            [puppetlabs.trapperkeeper.services.status.status-core :as status-core]
            [schema.core :as schema]))

(schema/defn ^:always-validate
             v1-status-callback :- status-core/StatusCallbackResponse
             [level :- status-core/ServiceStatusDetailLevel]
             {:state :starting
              :status "Status"})

(trapperkeeper/defservice fake-status-service
[[:StatusService register-status]]
(init [this context]
      (register-status "fake-status-service"
                       "1.0"
                       1
                       v1-status-callback)
      context))
