# restful-booker-platform

ベッド＆ブレックファストの予約システムを構成する一連のウェブサービスプラットフォームです。このプラットフォームの主な目的は、他者がウェブサービスプラットフォームの探索とテスト、およびテスト戦略における自動化の計画と実装をトレーニングすることです。

## 必要要件

RBPは現在、以下の要件で動作することが確認されています：

- JDK 18.0.2以上（JDK 18でテスト済み）
- Maven 3.6.3
- Node 20.9.0
- NPM 10.1.0

## ローカルでのビルド

上記の要件を満たしていると仮定して、以下の手順で開始できます。ターミナルまたはコマンドラインウィンドウを開き、以下の指示に従ってください：

1. リポジトリをクローンまたはダウンロードします。
2. `restful-booker-platform`のルートフォルダに移動します。
3. LinuxまたはMacの場合は`build_locally.sh`、Windowsの場合は`build_locally.cmd`を実行して、RBPをビルドして起動します（初回実行時は依存関係をダウンロードするため時間がかかる場合があります）。
4. ブラウザで`http://localhost:8080`にアクセスしてサイトを表示します。

## ローカルでの実行

アプリケーションを少なくとも一度正常にビルドしたと仮定して、全体を再ビルドせずにアプリを実行できます。

### Mac / Linux

1. エンドツーエンドのチェックなしで実行するには：`run_locally.sh`を実行します。
2. エンドツーエンドのチェック付きで実行するには：`run_locally.sh -e true`を実行します。

### Windows

1. エンドツーエンドのチェックなしで実行するには：`run_locally.cmd`を実行します。
2. エンドツーエンドのチェック付きで実行するには：`run_locally.cmd true`を実行します。

### ログイン情報

ユーザーのログイン情報は以下の通りです：

- ユーザー名：`admin`
- パスワード：`password`

## 開発

### APIの詳細

チェックの実行、APIのビルド、開発用の追加ドキュメントの詳細については、各APIフォルダ内のREADMEをご参照ください。

### このプロジェクトの独自のCI/CDの設定

このプロジェクトのビルドプロセスは[CircleCI](https://circleci.com/)によって管理されており、`.circleci`フォルダ内の`config.yml`ファイルで制御されています。設定するには以下の手順が必要です：

### CIテストの実行

以下の手順に従って、テストを実行するCI環境を設定します。

1. このリポジトリをフォークして、自分のコピーを作成します。
2. まだの場合は、GitHubの詳細を使用してCircleCIのログインを作成します。これにより、CircleCIがGitHubプロファイルに接続されます。
3. CircleCIのプロジェクトページに移動し、RBPリポジトリを見つけて「Set Up Project」をクリックします。
4. プロジェクトの設定手順を進め、プロジェクトからの`config.yml`を読み込むようにします（「Use Existing Config」をクリック）。

完全なデプロイメントを実行するようにCircleCIを設定したい場合は、リポジトリにIssueを投稿してください。