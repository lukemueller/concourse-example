#!/usr/bin/env bash

set -ex

pushd helloworld-src-git
  export TERM=${TERM:-dumb}
  ./gradlew clean test
popd
