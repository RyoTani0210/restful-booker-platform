# Restful-booker-report

**Report**は、異なる部屋の予約に関する情報を収集する役割を担っています。

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

APIを実行するには、まずビルドを行い、次に以下のコマンドを実行してください：

```bash
java -jar target/restful-booker-platform-report-1.0-SNAPSHOT.jar
```

これによりAPIが起動し、エンドポイントにアクセスできるようになります。

## ドキュメント

このAPIのエンドポイントドキュメントにアクセスするには、以下のURLに移動してください：

```
http://localhost:3005/report/swagger-ui/index.html
```

また、アプリケーションのヘルス状態を確認するには、以下のURLにアクセスします：

```
http://localhost:3005/report/actuator/health
```

最後に、APIのログファイルにアクセスするには、以下のURLに移動してください：

```
http://localhost:3005/report/actuator/logfile
```
```