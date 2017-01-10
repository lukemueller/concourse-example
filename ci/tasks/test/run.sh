#!/usr/bin/env bash

set -ex

pushd helloworld-src-git
  service mysql start
  ./gradlew clean test
popd
