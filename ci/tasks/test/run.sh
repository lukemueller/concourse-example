#!/usr/bin/env bash

set -ex

pushd helloworld-src-git
  ./gradlew clean test
popd
