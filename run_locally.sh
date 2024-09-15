#!/bin/sh

# オプション '-e' を解析し、DO_E2E変数に値を設定
while getopts e: option
  do
    case "${option}"
  in
    e) DO_E2E=${OPTARG};;
  esac
done

# アプリケーション起動の開始メッセージを表示
printf "\n####### RESTFUL-BOOKER-PLATFORM #######
####                               ####
####    アプリケーションを起動しています...    ####
####                               ####
#######################################\n\n"

# スクリプト終了時にすべての子プロセスを終了するトラップを設定
trap "kill 0" EXIT

# 各サービスをバックグラウンドで起動し、ログファイルに出力
java -jar -Dspring.profiles.active=dev auth/target/restful-booker-platform-auth-*.jar > auth.log &
java -jar -Dspring.profiles.active=dev booking/target/restful-booker-platform-booking-*.jar > booking.log &
java -jar -Dspring.profiles.active=dev room/target/restful-booker-platform-room-*.jar > room.log &
java -jar -Dspring.profiles.active=dev report/target/restful-booker-platform-report-*.jar > report.log &
java -jar -Dspring.profiles.active=dev branding/target/restful-booker-platform-branding-*.jar > branding.log &
java -jar -Dspring.profiles.active=dev message/target/restful-booker-platform-message-*.jar > message.log &
java -jar -Dspring.profiles.active=dev assets/api/target/restful-booker-platform-assets-*.jar > ui.log &
java -jar proxy/target/restful-booker-platform-local-proxy-*.jar > proxy.log &

# モニタースクリプトを実行
node .utilities/monitor/local_monitor.js

# E2Eチェックの開始メッセージを表示
printf "\n\n####### RESTFUL-BOOKER-PLATFORM #######
####                               ####
####    E2Eテストを実行しています         ####
####                               ####
#######################################\n"

# E2Eテストを実行するかどうかを判定
if [ "$DO_E2E" = "true" ]; then
  cd end-to-end-tests

  mvn clean test
else
  printf "\n          E2Eテストをスキップします
     E2Eテストを実行するには -e true 引数を追加してください\n"
fi

# アプリケーション準備完了のメッセージを表示
printf "\n####### RESTFUL-BOOKER-PLATFORM #######
####                               ####
####      アプリケーションが準備完了しました        ####
####                               ####
####         利用可能なURL:         ####
####     http://localhost:8080     ####
####                               ####
#######################################"

# 全てのバックグラウンドプロセスの終了を待機
wait
