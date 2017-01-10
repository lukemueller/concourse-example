#!/usr/bin/env bash

set -ex

pushd helloworld-src-git
  export TERM=${TERM:-dumb}
  ./gradlew assemble
  cf push
popd
