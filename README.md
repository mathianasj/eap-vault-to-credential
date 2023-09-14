# Vault to Credential Example

## Install EAP
1. Download EAP 7.4.0 and put the file jboss-eap-7.4.0.zip in the root folder
1. `make setup-eap`

## Configure Vault and EAP
1. `make `

## Run sample app with vault
1. `make run-eap`
1. Navigate to http://localhost:8080/eap-secrets-reader/index.jsp and view the secret contents

## Convert vault to credentials store
1. 