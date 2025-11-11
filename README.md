http://localhost:8080/login

📝 README.md (サンプル)
markdown
# Spring Boot Login Sample

Spring Boot + Spring Security + Thymeleaf を使ったシンプルなログイン／ログアウト／ユーザー登録アプリです。  
ユーザーは新規登録してログインし、ホーム画面にアクセスできます。

---

## 🚀 機能
- ユーザー登録 (`/register`)
- ログイン (`/login`)
- ホーム画面 (`/home`)
- ログアウト（ホームに戻る）

---

## 🛠️ 技術スタック
- Java 17+
- Spring Boot 3.x
- Spring Security
- Thymeleaf
- H2 Database (組み込みDB)

---

## 📂 プロジェクト構成
src/main/java/com/example/login2 ├── Login2Application.java # メインクラス ├── config │ └── SecurityConfig.java # セキュリティ設定 ├── controller │ └── AuthController.java # ログイン/登録/ホーム ├── entity │ └── AppUser.java # ユーザーエンティティ ├── repository │ └── UserRepository.java # ユーザーリポジトリ └── service └── UserService.java # ユーザー登録処理

コード

---

## 📄 テンプレート
- `src/main/resources/templates/login.html`  
- `src/main/resources/templates/register.html`  
- `src/main/resources/templates/home.html`  

---

## ⚙️ セットアップ & 実行

### 1. クローン
```bash
git clone https://github.com/yourname/spring-boot-login-sample.git
cd spring-boot-login-sample
2. ビルド & 実行
Maven の場合:

bash
./mvnw spring-boot:run
Gradle の場合:

bash
./gradlew bootRun
3. アクセス
ログインページ: http://localhost:8080/login

登録ページ: http://localhost:8080/register

ホームページ: http://localhost:8080/home

🔐 注意点
現状パスワードは平文で保存されています。実運用では BCryptPasswordEncoder を使って暗号化してください。

H2 Database を使用しているため、アプリを再起動するとデータはリセットされます。

📌 今後の拡張アイデア
パスワード暗号化（BCrypt）

ユーザー名の重複チェック

管理者専用ページ (ROLE_ADMIN)

Bootstrap を使った UI 改善

コード

---

これを `README.md` としてプロジェクトのルートに置けば、GitHub などで見やすくなります。  

👉 この README に「パスワード暗号化の手順」まで書き足しておき
