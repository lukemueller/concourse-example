#!/usr/bin/env bash

set -ex

pushd helloworld-src-git
  ./gradlew assemble
  cf push
popd
