#!/usr/bin/env bash

set -ex

pushd helloworld-src-git
  $ wget -q -O - https://packages.cloudfoundry.org/debian/cli.cloudfoundry.org.key | sudo apt-key add -
  $ echo "deb http://packages.cloudfoundry.org/debian stable main" | sudo tee /etc/apt/sources.list.d/cloudfoundry-cli.list
  $ sudo apt-get update
  $ sudo apt-get install cf-cli
  export TERM=${TERM:-dumb}
  ./gradlew assemble
  cf push
popd
