# RBP End to Endチェック

このモジュールは、**RBP**が正常に稼働した後に、フルスタックチェックを実行する責任を担っています。

## RBPチェックの実行

**RBP**チェックを実行するには、以下の環境変数を設定する必要があります：

- **TARGET** - `automationintesting.online`に対してE2Eチェックを実行したい場合は、この値を`production`に設定します。そうでない場合は、ローカルホストに対して実行するために空白のままにします。
- **BROWSER** - E2Eチェックを実行するブラウザを設定します。現在のオプションは`chrome`と`remote`です。`remote`はSauce Labsと連携し、正当なSauce Labsのユーザー名とアクセスキーが必要です。
- **SAUCE_USERNAME** - `BROWSER = remote`を使用している場合、`SAUCE_USERNAME`をSauce Labsアカウントに設定されているユーザー名に設定する必要があります。
- **SAUCE_ACCESS_KEY** - `BROWSER = remote`を使用している場合、`SAUCE_ACCESS_KEY`をSauce Labsアカウントに設定されているアクセスキーに設定する必要があります。アクセスキーは以下のURLで確認できます：
  
  [https://app.saucelabs.com/user-settings](https://app.saucelabs.com/user-settings)

環境変数を設定したら、以下のコマンドを実行してチェックを開始します：

```bash
mvn clean test
```

---

**補足情報:**

- **TARGET変数**:
  - `production`に設定すると、外部環境（例: `automationintesting.online`）に対してE2Eチェックが実行されます。
  - 空白または`0`に設定すると、ローカルホスト環境に対してチェックが実行されます。

- **BROWSER変数**:
  - `chrome`を選択すると、ローカルのChromeブラウザでE2Eチェックが実行されます。
  - `remote`を選択すると、Sauce Labsのようなリモートブラウザサービスを使用してチェックが実行されます。この場合、Sauce Labsのアカウント情報（ユーザー名とアクセスキー）が必要です。

- **環境変数の設定方法**:
  - 環境変数は、シェルの設定ファイル（例: `~/.bashrc`、`~/.zshrc`）に追加することで永続的に設定できます。例：
  
    ```bash
    export TARGET=production
    export BROWSER=chrome
    export SAUCE_USERNAME=your_sauce_username
    export SAUCE_ACCESS_KEY=your_sauce_access_key
    ```
  
  - 設定後、以下のコマンドで設定を反映させます：
  
    ```bash
    source ~/.bashrc
    ```

**トラブルシューティング:**

- **E2Eチェックが失敗する場合**:
  - 環境変数が正しく設定されているか確認してください。
  - Sauce Labsを使用している場合、ユーザー名とアクセスキーが正しいか確認してください。
  - ネットワーク接続に問題がないか確認してください。

- **ブラウザの問題**:
  - `chrome`を使用している場合、最新バージョンのChromeブラウザがインストールされていることを確認してください。
  - `remote`を使用している場合、リモートブラウザサービスが正常に稼働していることを確認してください。
