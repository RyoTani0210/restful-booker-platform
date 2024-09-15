# Restful-booker-message

**Message**は、データベースからメッセージデータを作成、読み取り、削除し、他のサービスと共有する役割を担っています。

## チェックの実行

チェックのみを実行するには、以下のコマンドを実行してください：

```bash
mvn clean test
```

## APIのビルド

このAPIをビルドするには、以下のコマンドを実行してください。これによりテストが実行され、その後実行可能な`.JAR`ファイルが作成されます：

```bash
mvn clean package
```

## APIの実行

**Message API**は、以下の環境変数を受け取ります：

- `dbRefresh` - 数値（例: 10）を設定すると、APIが10分ごとにデータベースをリセットします。空白のままにするか、0を設定するとデータベースはリセットされません。
- `dbServer` - この変数を`true`に設定すると、データベースが「サーバーモード」で有効になり、SquirrelSQLなどのツールを使用して外部からデータベースに接続できるようになります。

APIを実行するには、まずビルドを行い、次に以下のコマンドを実行してください：

```bash
java -jar target/restful-booker-platform-message-1.0-SNAPSHOT.jar
```

これによりAPIが起動し、エンドポイントにアクセスできるようになります。

## ドキュメント

このAPIのエンドポイントドキュメントにアクセスするには、以下のURLに移動してください：

```
http://localhost:3006/message/swagger-ui/index.html
```

また、アプリケーションのヘルス状態を確認するには、以下のURLにアクセスします：

```
http://localhost:3006/message/actuator/health
```

最後に、APIのログファイルにアクセスするには、以下のURLに移動してください：

```
http://localhost:3006/message/actuator/logfile
```
```