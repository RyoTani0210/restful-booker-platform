#!/bin/sh -e

printf "####### RESTFUL-BOOKER-PLATFORM #######
####                               ####
####       事前チェック             ####
####                               ####
#######################################\n"


if ! type -p java; then
    printf "Javaランタイム環境が見つかりません。インストール方法については以下をご覧ください：
    https://automationintesting.com/setup/settingupjava\n"
    exit
fi

if ! type -p javac; then
    printf "Java開発キットが見つかりません。インストール方法については以下をご覧ください：
    https://automationintesting.com/setup/settingupjava\n"
    exit
fi

if ! type -p mvn; then
    printf "Mavenが見つかりません。インストール方法については以下をご覧ください：
    https://automationintesting.com/setup/settingupmaven\n"
    exit
fi

if [[ -z "${JAVA_HOME}" ]]; then
  printf "JAVA_HOMEが設定されていません。設定方法については以下をご覧ください：
    https://automationintesting.com/setup/settingupmaven\n"
  exit
fi

if ! node -v; then
    printf "Nodeが見つからないか壊れています。インストール方法については以下をご覧ください：
    https://automationintesting.com/setup/settingupnode\n"
    exit
fi

if ! type -p npm; then
    printf "Npmが見つかりません。インストール方法については以下をご覧ください：
    https://automationintesting.com/setup/settingupnode\n"
    exit
fi

printf "\n####### RESTFUL-BOOKER-PLATFORM #######
####                               ####
####       プロジェクトのビルド   ####
####                               ####
#######################################\n"

mvn clean

if [[ -z "${APPLITOOLS_API_KEY}" ]]; then
  printf "Applitools APIキーが設定されていないため、ビジュアルチェックをスキップします。ビジュアルチェックを実行するには、APPLITOOLS_API_KEYにキーを設定してください。"
  mvn install
else
  mvn install -P ci
fi

/bin/bash ./run_locally.sh -e true
