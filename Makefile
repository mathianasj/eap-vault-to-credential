build-app:
	cd eap-secrets-reader && mvn clean package

deploy-app: build-app
	cp eap-secrets-reader/target/eap-secrets-reader.war jboss-eap-7.4/standalone/deployments

run-eap: deploy-app
	./scripts/run-eap.sh

setup-eap:
	./scripts/setup-eap.sh

create-vault:
	mkdir -p jboss-eap-7.4/vault
	$$JAVA_HOME/bin/keytool -genseckey -alias vault -storetype jceks -keyalg AES -keysize 128 -storepass vault22 -keypass vault22 -validity 730 -keystore ./jboss-eap-7.4/vault/vault.keystore

configure-vault:
	EAP_HOME=$$(pwd)/jboss-eap-7.4 && echo $$EAP_HOME && $$EAP_HOME/bin/vault.sh --keystore $$EAP_HOME/vault/vault.keystore --keystore-password vault22 --alias vault --vault-block vb --attribute password --sec-attr 0penS3sam3 --enc-dir $$EAP_HOME/vault/ --iteration 120 --salt 1234abcd