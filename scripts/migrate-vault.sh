#!/bin/bash

bin/elytron-tool.sh vault --enc-dir vault --keystore vault/vault.keystore --iteration 120 --salt 1234abcd --alias vault \
    --location vault/newcredstore.cs

# /subsystem=elytron/credential-store=mycredstore:add(path=../../vault/newcredstore.cs, relative-to=jboss.server.config.dir, credential-reference={clear-text=MASK-5dOaAVafCSd;1234abcd;120})